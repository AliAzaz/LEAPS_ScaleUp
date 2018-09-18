package com.example.hassannaqvi.wfppishincr.core;

import android.os.AsyncTask;

import com.example.hassannaqvi.wfppishincr.data.AppDatabase;

import java.util.Collection;

/**
 * Created by openm on 19-Jul-18.
 */

public class GetAllDBData extends AsyncTask<Long, Void, Collection<?>> {

    Collection<?> userData;
    AppDatabase db;

    public GetAllDBData(AppDatabase db) {
        this.db = db;
    }

    @Override
    protected Collection<?> doInBackground(Long... data) {

        Collection<?> curUser = db.formsDao().getUnSyncedForms();

        userData = curUser.size() > 0 ? curUser : null;

        return userData;
    }
}
