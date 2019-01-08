package com.example.hassannaqvi.leaps_scaleup.scheduling;

import android.app.job.JobParameters;
import android.app.job.JobService;

import com.example.hassannaqvi.leaps_scaleup.core.CONSTANTS;
import com.example.hassannaqvi.leaps_scaleup.core.MainApp;
import com.example.hassannaqvi.leaps_scaleup.data.DAO.GetFncDAO;
import com.example.hassannaqvi.leaps_scaleup.data.entities.Forms_04_05;
import com.example.hassannaqvi.leaps_scaleup.get.db.GetAllDBData;
import com.example.hassannaqvi.leaps_scaleup.sync.SyncAllData;

import java.util.Collection;

import static com.example.hassannaqvi.leaps_scaleup.ui.LoginActivity.db;

public class ScheduleService01b extends JobService {
    @Override
    public boolean onStartJob(final JobParameters jobParameters) {

        /*Upload Form 01b*/
        new GetAllDBData(db, GetFncDAO.class.getName(), "getFncDao", "getUnSyncedForms_04_05") {
            @Override
            protected void onPostExecute(Collection<?> objects) {
                new SyncAllData(
                        ScheduleService01b.this,
                        "Forms01b",
                        "updateSyncedForms_04_05",
                        Forms_04_05.class,
                        MainApp.buildUrl(CONSTANTS.URL_FORMS.replace(".php", MainApp.FORM01B + ".php"))
                        , objects
                ) {
                    @Override
                    protected void onPostExecute(String result) {
                        super.onPostExecute(result);
                        jobFinished(jobParameters, result == null);
                    }
                };
            }
        }.execute(MainApp.FORM01B);

        return true;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
