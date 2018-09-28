package com.example.hassannaqvi.leaps_scaleup.data.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.example.hassannaqvi.leaps_scaleup.data.AppDatabase;

@Entity(tableName = AppDatabase.Sub_DBConnection.TABLE_USERS)
public class Users {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo
    private String ROW_USERNAME = "";
    private String ROW_PASSWORD = "";

    public Users(Users users) {
        this.ROW_USERNAME = users.ROW_USERNAME;
        this.ROW_PASSWORD = users.ROW_PASSWORD;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getROW_USERNAME() {
        return ROW_USERNAME;
    }

    public void setROW_USERNAME(String ROW_USERNAME) {
        this.ROW_USERNAME = ROW_USERNAME;
    }

    public String getROW_PASSWORD() {
        return ROW_PASSWORD;
    }

    public void setROW_PASSWORD(String ROW_PASSWORD) {
        this.ROW_PASSWORD = ROW_PASSWORD;
    }
}
