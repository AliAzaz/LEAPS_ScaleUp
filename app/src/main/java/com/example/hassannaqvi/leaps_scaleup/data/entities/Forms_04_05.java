package com.example.hassannaqvi.leaps_scaleup.data.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import com.example.hassannaqvi.leaps_scaleup.data.AppDatabase;

@Entity(tableName = AppDatabase.Sub_DBConnection.TABLE_FORMS_04_05)
public class Forms_04_05 {

    @Ignore
    private final String _projectName = "National Nutrition Survey 2018";

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo
    private String uuid = "";
    private String formType = "";
    private String uid = "";
    private String formDate = ""; // Date
    private String username = ""; // Interviewer
    private String childID = ""; // Child ID
    private String childName = ""; // Child Name
    private String sInfo = "";   // Section Info
    private String sa1 = "";     // Section 1
    private String sa2 = "";     // Section 2
    private String sa3 = "";     // Section 3
    private String sa4 = "";     // Section 4
    private String sa5 = "";     // Section 5
    private String sa6 = "";     // Section 6
    private String endtime = "";
    private String clustercode = "";
    private String districtname = "";
    private String studyID = "";
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
    public Forms_04_05(Forms_04_05 forms) {

        this.uuid = forms.uuid;
        this.formType = forms.formType;
        this.uid = forms.uid;
        this.formDate = forms.formDate;
        this.username = forms.username;
        this.childID = forms.childID;
        this.childName = forms.childName;
        this.studyID = forms.studyID;
        this.sInfo = forms.sInfo;
        this.sa1 = forms.sa1;
        this.sa2 = forms.sa2;
        this.sa3 = forms.sa3;
        this.sa4 = forms.sa4;
        this.sa5 = forms.sa5;
        this.sa6 = forms.sa6;
        this.endtime = forms.endtime;
        this.clustercode = forms.clustercode;
        this.districtname = forms.districtname;
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

    public Forms_04_05() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getFormType() {
        return formType;
    }

    public void setFormType(String formType) {
        this.formType = formType;
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

    public String getChildID() {
        return childID;
    }

    public void setChildID(String childID) {
        this.childID = childID;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public String getStudyID() {
        return studyID;
    }

    public void setStudyID(String studyID) {
        this.studyID = studyID;
    }

    public String getSInfo() {
        return sInfo;
    }

    public void setSInfo(String sInfo) {
        this.sInfo = sInfo;
    }

    public String getSa1() {
        return sa1;
    }

    public void setSa1(String sa1) {
        this.sa1 = sa1;
    }

    public String getSa2() {
        return sa2;
    }

    public void setSa2(String sa2) {
        this.sa2 = sa2;
    }

    public String getSa3() {
        return sa3;
    }

    public void setSa3(String sa3) {
        this.sa3 = sa3;
    }

    public String getSa4() {
        return sa4;
    }

    public void setSa4(String sa4) {
        this.sa4 = sa4;
    }

    public String getSa5() {
        return sa5;
    }

    public void setSa5(String sa5) {
        this.sa5 = sa5;
    }

    public String getSa6() {
        return sa6;
    }

    public void setSa6(String sa6) {
        this.sa6 = sa6;
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

    public String getDistrictname() {
        return districtname;
    }

    public void setDistrictname(String districtname) {
        this.districtname = districtname;
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
