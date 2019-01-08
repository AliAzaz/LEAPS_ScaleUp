package com.example.hassannaqvi.leaps_scaleup.scheduling;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;

import com.example.hassannaqvi.leaps_scaleup.core.CONSTANTS;
import com.example.hassannaqvi.leaps_scaleup.core.MainApp;
import com.example.hassannaqvi.leaps_scaleup.data.DAO.GetFncDAO;
import com.example.hassannaqvi.leaps_scaleup.data.entities.Forms_04_05;
import com.example.hassannaqvi.leaps_scaleup.get.db.GetAllDBData;
import com.example.hassannaqvi.leaps_scaleup.sync.SyncAllData;

import java.util.Collection;

import static com.example.hassannaqvi.leaps_scaleup.ui.LoginActivity.db;

public class ScheduleService01a extends JobService {

    private static final String TAG = ScheduleService01a.class.getName();

    @Override
    public boolean onStartJob(final JobParameters jobParameters) {

        Log.d(TAG, "Inner Starting");

        /*Upload Form 01a*/
        new GetAllDBData(db, GetFncDAO.class.getName(), "getFncDao", "getUnSyncedForms_04_05") {
            @Override
            protected void onPostExecute(Collection<?> objects) {

                Log.d(TAG, "Get data:" + objects);

                new SyncAllData(
                        ScheduleService01a.this,
                        "Forms01a",
                        "updateSyncedForms_04_05",
                        Forms_04_05.class,
                        MainApp.buildUrl(CONSTANTS.URL_FORMS.replace(".php", MainApp.FORM01A + ".php"))
                        , objects
                ) {
                    @Override
                    protected void onPostExecute(String result) {

                        Log.d(TAG, "Working on result:" + result);

                        super.onPostExecute(result);
                        jobFinished(jobParameters, result == null);
                    }
                };
            }
        }.execute(MainApp.FORM01A);

        return true;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
