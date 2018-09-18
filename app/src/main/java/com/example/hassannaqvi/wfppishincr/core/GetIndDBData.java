package com.example.hassannaqvi.wfppishincr.core;

import android.os.AsyncTask;

import com.example.hassannaqvi.wfppishincr.data.AppDatabase;
import com.example.hassannaqvi.wfppishincr.data.entities.Forms;

/**
 * Created by openm on 19-Jul-18.
 */

public class GetIndDBData extends AsyncTask<Long, Void, Forms> {

    Forms userData, userInfo;
    AppDatabase db;
    int type;

    public GetIndDBData(AppDatabase db, Forms userInfo, int type) {
        this.db = db;
        this.userInfo = userInfo;
        this.type = type;
    }

    @Override
    protected Forms doInBackground(Long... data) {

        Forms curUser = null;

        switch (type) {
            case 1:
                curUser = db.formsDao().getLastForm(data[0].intValue());
                break;
            case 2:
                curUser = db.formsDao().getUnSynced();
                break;
        }

        userData = curUser != null ? new Forms(curUser) : null;

        return userData;
    }
}
