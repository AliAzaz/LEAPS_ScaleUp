package com.example.hassannaqvi.leaps_scaleup.data.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import com.example.hassannaqvi.leaps_scaleup.data.AppDatabase;

@Entity(tableName = AppDatabase.Sub_DBConnection.TABLE_FORMS)
public class Forms {

    @Ignore
    private final String _projectName = "National Nutrition Survey 2018";
    @Ignore
    private final String _surveyType = "";

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo
    private String uid = "";
    private String formDate = ""; // Date
    private String username = ""; // Interviewer
    private String istatus = ""; // Interview Status
    private String istatus88x = ""; // Interview Status
    private String sa1 = "";     // Info Section
    private String endtime = "";
    private String clustercode = "";
    private String childID = "";
    private String gpsLat = "";
    private String gpsLng = "";
    private String gpsDT = "";
    private String gpsAcc = "";
    private String gpsElev = "";
    private String deviceID = "";
    private String devicetagID = "";
    private String synced = "";
    private String synced_date = "";
    private String appversion = "";

    @Ignore
    public Forms(Forms forms) {

        this.uid = forms.uid;
        this.formDate = forms.formDate;
        this.username = forms.username;
        this.istatus = forms.istatus;
        this.istatus88x = forms.istatus88x;
        this.sa1 = forms.sa1;
        this.endtime = forms.endtime;
        this.clustercode = forms.clustercode;
        this.childID = forms.childID;
        this.gpsLat = forms.gpsLat;
        this.gpsLng = forms.gpsLng;
        this.gpsDT = forms.gpsDT;
        this.gpsAcc = forms.gpsAcc;
        this.gpsElev = forms.gpsElev;
        this.deviceID = forms.deviceID;
        this.devicetagID = forms.devicetagID;
        this.synced = forms.synced;
        this.synced_date = forms.synced_date;
        this.appversion = forms.appversion;

    }

    public Forms() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getFormDate() {
        return formDate;
    }

    public void setFormDate(String formDate) {
        this.formDate = formDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIstatus() {
        return istatus;
    }

    public void setIstatus(String istatus) {
        this.istatus = istatus;
    }

    public String getIstatus88x() {
        return istatus88x;
    }

    public void setIstatus88x(String istatus88x) {
        this.istatus88x = istatus88x;
    }

    public String getSa1() {
        return sa1;
    }

    public void setSa1(String sa1) {
        this.sa1 = sa1;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getClustercode() {
        return clustercode;
    }

    public void setClustercode(String clustercode) {
        this.clustercode = clustercode;
    }

    public String getchildID() {
        return childID;
    }

    public void setchildID(String childID) {
        this.childID = childID;
    }

    public String getGpsLat() {
        return gpsLat;
    }

    public void setGpsLat(String gpsLat) {
        this.gpsLat = gpsLat;
    }

    public String getGpsLng() {
        return gpsLng;
    }

    public void setGpsLng(String gpsLng) {
        this.gpsLng = gpsLng;
    }

    public String getGpsDT() {
        return gpsDT;
    }

    public void setGpsDT(String gpsDT) {
        this.gpsDT = gpsDT;
    }

    public String getGpsAcc() {
        return gpsAcc;
    }

    public void setGpsAcc(String gpsAcc) {
        this.gpsAcc = gpsAcc;
    }

    public String getGpsElev() {
        return gpsElev;
    }

    public void setGpsElev(String gpsElev) {
        this.gpsElev = gpsElev;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getDevicetagID() {
        return devicetagID;
    }

    public void setDevicetagID(String devicetagID) {
        this.devicetagID = devicetagID;
    }

    public String getSynced() {
        return synced;
    }

    public void setSynced(String synced) {
        this.synced = synced;
    }

    public String getSynced_date() {
        return synced_date;
    }

    public void setSynced_date(String synced_date) {
        this.synced_date = synced_date;
    }

    public String getAppversion() {
        return appversion;
    }

    public void setAppversion(String appversion) {
        this.appversion = appversion;
    }
}
