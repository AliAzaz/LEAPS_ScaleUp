package com.example.hassannaqvi.leaps_scaleup.get.server;

import com.example.hassannaqvi.leaps_scaleup.RMOperations.CrudOperations;
import com.example.hassannaqvi.leaps_scaleup.RMOperations.SyncOperations;
import com.example.hassannaqvi.leaps_scaleup.data.DAO.FormsDAO;
import com.example.hassannaqvi.leaps_scaleup.data.entities.Clusters;
import com.example.hassannaqvi.leaps_scaleup.data.entities.Participant;
import com.example.hassannaqvi.leaps_scaleup.data.entities.Users;

import org.json.JSONArray;
import org.json.JSONObject;

import static com.example.hassannaqvi.leaps_scaleup.ui.LoginActivity.db;

abstract class GetSyncFncs {

    static void syncUsers(JSONArray userlist) {

        new SyncOperations(db).execute(FormsDAO.class.getName(), "formsDao", "deleteUsers");

        try {
            for (int i = 0; i < userlist.length(); i++) {
                JSONObject jsonObjectUser = userlist.getJSONObject(i);
                String userName = jsonObjectUser.getString("username");
                String password = jsonObjectUser.getString("password");

                Users users = new Users(userName, password);
                new CrudOperations(db, users).execute(FormsDAO.class.getName(), "formsDao", "insertUsers").get();
            }
            db.close();

        } catch (Exception ignored) {
        }
    }

    static void syncClusters(JSONArray clusterList) {

        new SyncOperations(db).execute(FormsDAO.class.getName(), "formsDao", "deleteClusters");

        try {
            for (int i = 0; i < clusterList.length(); i++) {
                JSONObject jsonObjectUser = clusterList.getJSONObject(i);

                Clusters clusters = new Clusters();
                clusters.Sync(jsonObjectUser);

                new CrudOperations(db, clusters).execute(FormsDAO.class.getName(), "formsDao", "insertClusters").get();
            }
            db.close();

        } catch (Exception e) {
        }
    }

}
