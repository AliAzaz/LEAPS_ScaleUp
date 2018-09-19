package com.example.hassannaqvi.leaps_scaleup.core;

import android.os.AsyncTask;

import com.example.hassannaqvi.leaps_scaleup.data.AppDatabase;

import java.util.Collection;

/**
 * Created by openm on 19-Jul-18.
 */

public class GetAllDBData extends AsyncTask<String, Void, Collection<?>> {

    Collection<?> userData;
    AppDatabase db;

    public GetAllDBData(AppDatabase db) {
        this.db = db;
    }

    @Override
    protected Collection<?> doInBackground(String... fnNames) {

        Collection<?> curData = db.formsDao().getUnSyncedForms();


        userData = curData.size() > 0 ? curData : null;

        return userData;
    }
}
