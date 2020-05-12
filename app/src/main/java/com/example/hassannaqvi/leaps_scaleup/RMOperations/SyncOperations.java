package com.example.hassannaqvi.leaps_scaleup.RMOperations;

import android.os.AsyncTask;

import com.example.hassannaqvi.leaps_scaleup.data.AppDatabase;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by openm on 19-Jul-18.
 */

public class SyncOperations extends AsyncTask<String, Void, Long> {

    private AppDatabase db;

    public SyncOperations(AppDatabase db) {
        this.db = db;
    }

    @Override
    protected Long doInBackground(String... fnNames) {

        Long longID = 0L;

        try {

            Method[] fn = db.getClass().getDeclaredMethods();
            for (Method method : fn) {
                if (method.getName().equals(fnNames[1])) {

                    Class<?> fnClass = Class.forName(fnNames[0]);

                    for (Method method2 : fnClass.getDeclaredMethods()) {
                        if (method2.getName().equals(fnNames[2])) {

                            longID = Long.valueOf(String.valueOf(fnClass.getMethod(method2.getName())
                                    .invoke(db.getClass().getMethod(fnNames[1]).invoke(db))));

                            break;
                        }
                    }

                    break;
                }
            }

        } catch (IllegalAccessException | InvocationTargetException | ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        }


        return longID;
    }
}
