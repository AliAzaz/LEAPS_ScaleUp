package com.example.hassannaqvi.leaps_scaleup.data.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.hassannaqvi.leaps_scaleup.data.AppDatabase;
import com.example.hassannaqvi.leaps_scaleup.data.entities.Users;

@Dao
public interface GetFncDAO {

    @Query("SELECT COUNT(*) FROM " + AppDatabase.Sub_DBConnection.TABLE_USERS + " where ROW_USERNAME=:username AND ROW_PASSWORD=:password")
    int login(String username, String password);

    /*
    @Query("SELECT * FROM " + Sub_DBConnection.TABLE_FORMS + " WHERE id=:id")
    Forms getLastForm(int id);

    @Query("SELECT * FROM " + Sub_DBConnection.TABLE_FORMS + " WHERE synced = ''")
    List<Forms> getUnSyncedForms();

    @Query("SELECT * FROM " + Sub_DBConnection.TABLE_FORMS + " WHERE formDate LIKE :date")
    List<Forms> getTodaysForms(String date);*/

    @Insert
    Long insertUsers(Users users);

}
