package com.example.hassannaqvi.leaps_scaleup.get.db;

import android.os.AsyncTask;

import com.example.hassannaqvi.leaps_scaleup.data.AppDatabase;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by openm on 19-Jul-18.
 */

public class GetIndDBData extends AsyncTask<String, Void, Class<?>> {

    AppDatabase db;
    String DAOclsName, DAOAbsClsFnc, DAOFnc;
    int typeData;

    public GetIndDBData(AppDatabase db, String DAOclsName, String DAOAbsClsFnc, String DAOFnc, int typeData) {
        this.db = db;
        this.DAOclsName = DAOclsName;
        this.DAOAbsClsFnc = DAOAbsClsFnc;
        this.DAOFnc = DAOFnc;
        this.typeData = typeData;
    }

    @Override
    protected Class<?> doInBackground(String... fnNames) {

        Class<?> curData = null;

        try {

            Method[] fn = db.getClass().getDeclaredMethods();
            for (Method method : fn) {
                if (method.getName().equals(DAOAbsClsFnc)) {

                    Class<?> fnClass = Class.forName(DAOclsName);

                    for (Method method2 : fnClass.getDeclaredMethods()) {
                        if (method2.getName().equals(DAOFnc)) {

                            switch (typeData) {
                                case 1:
                                    curData = (Class<?>) fnClass.getMethod(method2.getName())
                                            .invoke(db.getClass().getMethod(DAOAbsClsFnc).invoke(db), fnNames[0]);
                                    break;
                            }

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
