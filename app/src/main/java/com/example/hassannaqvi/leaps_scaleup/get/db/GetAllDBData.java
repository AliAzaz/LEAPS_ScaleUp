package com.example.hassannaqvi.leaps_scaleup.get.db;

import android.os.AsyncTask;

import com.example.hassannaqvi.leaps_scaleup.data.AppDatabase;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by openm on 19-Jul-18.
 */

public class GetAllDBData extends AsyncTask<String, Void, Collection<?>> {

    AppDatabase db;
    String DAOclsName, DAOAbsClsFnc, DAOFnc;
    int typeData;

    public GetAllDBData(AppDatabase db, String DAOclsName, String DAOAbsClsFnc, String DAOFnc, int typeData) {
        this.db = db;
        this.DAOclsName = DAOclsName;
        this.DAOAbsClsFnc = DAOAbsClsFnc;
        this.DAOFnc = DAOFnc;
        this.typeData = typeData;
    }

    @Override
    protected Collection<?> doInBackground(String... fnNames) {

        Collection<?> curData = new ArrayList<>();

        try {

            Method[] fn = db.getClass().getDeclaredMethods();
            for (Method method : fn) {
                if (method.getName().equals(DAOAbsClsFnc)) {

                    Class<?> fnClass = Class.forName(DAOclsName);

                    for (Method method2 : fnClass.getDeclaredMethods()) {
                        if (method2.getName().equals(DAOFnc)) {

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

                            switch (typeData) {
                                case 1:
                                    curData = (Collection<?>) fnClass.getMethod(method2.getName())
                                            .invoke(db.getClass().getMethod(DAOAbsClsFnc).invoke(db), fnNames[0]);
                                    break;
                                default:
                                    curData = (Collection<?>) fnClass.getMethod(method2.getName())
                                            .invoke(db.getClass().getMethod(DAOAbsClsFnc).invoke(db));
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
