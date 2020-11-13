package com.example.hassannaqvi.leaps_scaleup.RMOperations;

import android.os.AsyncTask;

import com.example.hassannaqvi.leaps_scaleup.data.AppDatabase;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by openm on 19-Jul-18.
 */

public class CrudOperations extends AsyncTask<String, Void, Long> {

    private final AppDatabase db;
    private final Object forms;

    public CrudOperations(AppDatabase db, Object forms) {
        this.db = db;
        this.forms = forms;
    }

    @Override
    protected Long doInBackground(String... fnNames) {

        long longID = 0L;

        try {

            Method[] fn = db.getClass().getDeclaredMethods();
            for (Method method : fn) {
                if (method.getName().equals(fnNames[1])) {

                    Class<?> fnClass = Class.forName(fnNames[0]);

                    for (Method method2 : fnClass.getDeclaredMethods()) {
                        if (method2.getName().equals(fnNames[2])) {

                            longID = Long.parseLong(String.valueOf(fnClass.getMethod(method2.getName(), forms.getClass())
                                    .invoke(db.getClass().getMethod(fnNames[1]).invoke(db), forms)));

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