package com.example.hassannaqvi.leaps_scaleup.data.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.example.hassannaqvi.leaps_scaleup.data.AppDatabase;
import com.example.hassannaqvi.leaps_scaleup.data.entities.Clusters;
import com.example.hassannaqvi.leaps_scaleup.data.entities.Forms;
import com.example.hassannaqvi.leaps_scaleup.data.entities.Forms_04_05;
import com.example.hassannaqvi.leaps_scaleup.data.entities.Users;

import java.util.List;

@Dao
public interface GetFncDAO {

    @Query("SELECT * FROM " + AppDatabase.Sub_DBConnection.TABLE_FORMS)
    List<Forms> getAll();

    @Query("SELECT * FROM " + AppDatabase.Sub_DBConnection.TABLE_FORMS + " WHERE id=:id")
    Forms getLastForm(int id);

    @Query("SELECT * FROM " + AppDatabase.Sub_DBConnection.TABLE_FORMS_04_05 + " WHERE synced = ''")
    List<Forms_04_05> getUnSyncedForms_04_05();

    @Query("SELECT * FROM " + AppDatabase.Sub_DBConnection.TABLE_FORMS_04_05 + " WHERE synced = '' AND formType = :formType")
    List<Forms_04_05> getUnSyncedForms_04_05(String formType);

    @Query("SELECT * FROM " + AppDatabase.Sub_DBConnection.TABLE_FORMS + " WHERE formDate LIKE :date")
    List<Forms> getTodaysForms(String date);

    @Query("SELECT * FROM " + AppDatabase.Sub_DBConnection.TABLE_FORMS + " WHERE synced = ''")
    List<Forms> getUnSyncedForms();
/*
    @Query("SELECT * FROM " + AppDatabase.Sub_DBConnection.TABLE_FORMS + " WHERE synced = '' AND  = :formType")
    List<Forms> getUnSyncedForms(String formType);*/

    @Query("SELECT * FROM " + AppDatabase.Sub_DBConnection.TABLE_USERS + " where ROW_USERNAME=:username AND ROW_PASSWORD=:password")
    Users login(String username, String password);

    @Query("SELECT * FROM " + AppDatabase.Sub_DBConnection.TABLE_CLUSTERS + " where cluster_code=:clusterCode")
    Clusters getClusterRecord(String clusterCode);

}
