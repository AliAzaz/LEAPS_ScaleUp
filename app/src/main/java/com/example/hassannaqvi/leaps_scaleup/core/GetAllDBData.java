package com.example.hassannaqvi.leaps_scaleup.core;

import android.os.AsyncTask;

import com.example.hassannaqvi.leaps_scaleup.data.AppDatabase;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by openm on 19-Jul-18.
 */

public class GetAllDBData extends AsyncTask<Object, Void, Collection<?>> {

    AppDatabase db;

    public GetAllDBData(AppDatabase db) {
        this.db = db;
    }

    @Override
    protected Collection<?> doInBackground(Object... fnNames) {

        Collection<?> curData = new ArrayList<>();

        try {

            Method[] fn = db.getClass().getDeclaredMethods();
            for (Method method : fn) {
                if (method.getName().equals(fnNames[1])) {

                    Class<?> fnClass = Class.forName(fnNames[0].toString());

                    for (Method method2 : fnClass.getDeclaredMethods()) {
                        if (method2.getName().equals(fnNames[2].toString())) {

                            /*String arg = "";
                            if (fnNames[3] != null) {

                                for (byte i = 0; i < ((String[]) fnNames[3]).length; i++) {

                                    arg += ((String[]) fnNames[3])[i];

                                    if (i + 1 != ((String[]) fnNames[3]).length) {
                                        arg += ",";
                                    }
                                }

                                curData = (Collection<?>) fnClass.getMethod(method2.getName())
                                        .invoke(db.getClass().getMethod(fnNames[1].toString()).invoke(db),arg.split(","));

                                break;
                            }*/

                            curData = (Collection<?>) fnClass.getMethod(method2.getName())
                                    .invoke(db.getClass().getMethod(fnNames[1].toString()).invoke(db));

                            break;
                        }
                    }

                    break;
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return curData;
    }
}
