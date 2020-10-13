package com.example.hassannaqvi.leaps_scaleup.sync;

import com.example.hassannaqvi.leaps_scaleup.RMOperations.UpdateSyncedStatus;
import com.example.hassannaqvi.leaps_scaleup.data.DAO.FormsDAO;

import java.util.Date;
import java.util.concurrent.ExecutionException;

import static com.example.hassannaqvi.leaps_scaleup.ui.LoginActivity.db;

public abstract class UpdateFncs {

    public static void updateSyncedForms_04_05(int _id) {
        try {
            new UpdateSyncedStatus(db, new Date().toString(), _id).execute(FormsDAO.class.getName(), "formsDao", "updateSyncedForms_04_05").get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void updateSyncedForms(int _id) {
        try {
            new UpdateSyncedStatus(db, new Date().toString(), _id).execute(FormsDAO.class.getName(), "formsDao", "updateSyncedForms").get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void getUnSyncedForms_GPS(int _id) {
        try {
            new UpdateSyncedStatus(db, new Date().toString(), _id).execute(FormsDAO.class.getName(), "formsDao", "updateSyncedForms_GPS").get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
