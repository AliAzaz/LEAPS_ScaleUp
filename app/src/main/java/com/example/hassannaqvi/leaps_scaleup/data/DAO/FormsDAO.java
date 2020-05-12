package com.example.hassannaqvi.leaps_scaleup.data.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.hassannaqvi.leaps_scaleup.data.AppDatabase.Sub_DBConnection;
import com.example.hassannaqvi.leaps_scaleup.data.entities.Clusters;
import com.example.hassannaqvi.leaps_scaleup.data.entities.Forms;
import com.example.hassannaqvi.leaps_scaleup.data.entities.Forms_04_05;
import com.example.hassannaqvi.leaps_scaleup.data.entities.Participant;
import com.example.hassannaqvi.leaps_scaleup.data.entities.Users;

@Dao
public interface FormsDAO {

    /*Form*/
    @Insert
    Long insertForm(Forms forms);

    @Insert
    Long insertForm_04_05(Forms_04_05 forms);

    @Delete
    void delete(Forms forms);

    @Update
    int updateForm(Forms forms);

    @Update
    int updateForm_04_05(Forms_04_05 forms);

    /*Others Sync*/
    @Insert
    Long insertUsers(Users users);

    @Insert
    Long insertClusters(Clusters clusters);

    @Insert
    Long insertParticipants(Participant participant);

    @Query("DELETE from " + Sub_DBConnection.TABLE_USERS)
    int deleteUsers();

    @Query("DELETE from " + Sub_DBConnection.TABLE_CLUSTERS)
    int deleteClusters();

    @Query("DELETE from " + Sub_DBConnection.TABLE_PARTICIPANT)
    int deleteParticipants();


    /*Update methods after upload on server*/

    /**
     * Updating only sync and syncDate
     * By order id
     */
    @Query("UPDATE Forms SET synced =  '1' , synced_date= :synced_date WHERE id =:id")
    int updateSyncedForms(String synced_date, int id);

    @Query("UPDATE Forms_04_05 SET synced = '1' , synced_date= :synced_date WHERE id =:id")
    int updateSyncedForms_04_05(String synced_date, int id);


}
