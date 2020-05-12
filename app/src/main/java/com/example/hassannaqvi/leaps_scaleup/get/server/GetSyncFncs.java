package com.example.hassannaqvi.leaps_scaleup.get.server;

import com.example.hassannaqvi.leaps_scaleup.RMOperations.SyncOperations;
import com.example.hassannaqvi.leaps_scaleup.RMOperations.crudOperations;
import com.example.hassannaqvi.leaps_scaleup.data.DAO.FormsDAO;
import com.example.hassannaqvi.leaps_scaleup.data.entities.Clusters;
import com.example.hassannaqvi.leaps_scaleup.data.entities.Participant;
import com.example.hassannaqvi.leaps_scaleup.data.entities.Users;

import org.json.JSONArray;
import org.json.JSONObject;

import static com.example.hassannaqvi.leaps_scaleup.ui.LoginActivity.db;

public abstract class GetSyncFncs {

    static void syncUsers(JSONArray userlist) {

        new SyncOperations(db).execute(FormsDAO.class.getName(), "formsDao", "deleteUsers");

        try {
            for (int i = 0; i < userlist.length(); i++) {
                JSONObject jsonObjectUser = userlist.getJSONObject(i);
                String userName = jsonObjectUser.getString("username");
                String password = jsonObjectUser.getString("password");

                Users users = new Users(userName, password);
                new crudOperations(db, users).execute(FormsDAO.class.getName(), "formsDao", "insertUsers").get();
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

                new crudOperations(db, clusters).execute(FormsDAO.class.getName(), "formsDao", "insertClusters").get();
            }
            db.close();

        } catch (Exception ignored) {
        }
    }

    static void syncParticipants(JSONArray participantList, Boolean syncClassFlag) {

        if (syncClassFlag)
            new SyncOperations(db).execute(FormsDAO.class.getName(), "formsDao", "deleteParticipants");

        try {
            for (int i = 0; i < participantList.length(); i++) {
                JSONObject jsonObjectUser = participantList.getJSONObject(i);

                Participant participant = new Participant();
                participant.Sync(jsonObjectUser);

                new crudOperations(db, participant).execute(FormsDAO.class.getName(), "formsDao", "insertParticipants");
            }
            db.close();
        } catch (Exception ignored) {
        }
    }

}
