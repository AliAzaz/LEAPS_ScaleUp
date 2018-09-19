package com.example.hassannaqvi.leaps_scaleup.data.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.hassannaqvi.leaps_scaleup.data.AppDatabase.Sub_DBConnection;
import com.example.hassannaqvi.leaps_scaleup.data.entities.Forms;

import java.util.List;

@Dao
public interface FormsDAO {

    @Query("SELECT * FROM " + Sub_DBConnection.TABLE_FORM)
    List<Forms> getAll();

    @Query("SELECT * FROM " + Sub_DBConnection.TABLE_FORM + " WHERE id=:id")
    Forms getLastForm(int id);

    @Query("SELECT * FROM " + Sub_DBConnection.TABLE_FORM + " WHERE synced = ''")
    List<Forms> getUnSyncedForms();

    @Insert
    Long insertAll(Forms forms);

    @Delete
    void delete(Forms forms);

    @Update
    int updateForm(Forms... forms);

}
