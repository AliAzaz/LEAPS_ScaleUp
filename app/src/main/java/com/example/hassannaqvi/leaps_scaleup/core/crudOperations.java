package com.example.hassannaqvi.leaps_scaleup.core;

import android.os.AsyncTask;

import com.example.hassannaqvi.leaps_scaleup.data.AppDatabase;
import com.example.hassannaqvi.leaps_scaleup.data.entities.Forms;

/**
 * Created by openm on 19-Jul-18.
 */

public class crudOperations extends AsyncTask<Void, Void, Long> {

    int type;
    AppDatabase db;
    Forms forms;

    public crudOperations(int type, AppDatabase db, Forms forms) {
        this.type = type;
        this.db = db;
        this.forms = forms;
    }

    @Override
    protected Long doInBackground(Void... voids) {

        Long longID = null;

        if (type == 0) {
            longID = db.formsDao().insertAll(forms);
        } else if (type == 1) {
            longID = Long.valueOf(db.formsDao().updateForm(forms));
        }

        return longID;
    }
}
