package com.example.hassannaqvi.leaps_scaleup.data.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.hassannaqvi.leaps_scaleup.data.AppDatabase.Sub_DBConnection;
import com.example.hassannaqvi.leaps_scaleup.data.entities.Clusters;
import com.example.hassannaqvi.leaps_scaleup.data.entities.Forms;
import com.example.hassannaqvi.leaps_scaleup.data.entities.Forms_04_05;
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

    @Query("DELETE from " + Sub_DBConnection.TABLE_USERS)
    int deleteUsers();

    @Query("DELETE from " + Sub_DBConnection.TABLE_CLUSTERS)
    int deleteClusters();

}
