package com.example.hassannaqvi.leaps_scaleup.data.entities;

import android.provider.BaseColumns;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.hassannaqvi.leaps_scaleup.data.AppDatabase;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

@Entity(tableName = AppDatabase.Sub_DBConnection.TABLE_FORMS_GPS)
public class Forms_GPS implements Serializable {

    @Ignore
    private final String _projectName = "Leaps-Sup";

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo
    private String uid = "";
    private String formType = "";
    private String formDate = ""; // Date
    private String username = ""; // Interviewer
    private String istatus = ""; // Interview Status
    private String istatus88x = ""; // Interview Status
    private String sa1 = "";     // Info Section
    private String endtime = "";
    private String clustercode = "";
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
    private String round = "";

    @Ignore
    public Forms_GPS(Forms_GPS forms) {

        this.uid = forms.uid;
        this.formDate = forms.formDate;
        this.formType = forms.formType;
        this.username = forms.username;
        this.istatus = forms.istatus;
        this.istatus88x = forms.istatus88x;
        this.sa1 = forms.sa1;
        this.endtime = forms.endtime;
        this.clustercode = forms.clustercode;
        this.studyID = forms.studyID;
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
        this.round = forms.round;

    }

    public Forms_GPS() {
    }

    @Ignore
    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();

        json.put(SinglePart.COLUMN_PROJECT_NAME, this._projectName);
        json.put(SinglePart._ID, this.id == 0 ? JSONObject.NULL : this.id);
        json.put(SinglePart.COLUMN_FORMTYPE, this.formType == null ? JSONObject.NULL : this.formType);
        json.put(SinglePart.COLUMN_FORMDATE, this.formDate == null ? JSONObject.NULL : this.formDate);
        json.put(SinglePart.COLUMN_UID, this.uid == null ? JSONObject.NULL : this.uid);
        json.put(SinglePart.COLUMN_USER, this.username == null ? JSONObject.NULL : this.username);
        json.put(SinglePart.COLUMN_STUDYID, this.studyID == null ? JSONObject.NULL : this.studyID);
        json.put(SinglePart.COLUMN_CLUSTERCODE, this.clustercode == null ? JSONObject.NULL : this.clustercode);
        json.put(SinglePart.COLUMN_ENDINGDATETIME, this.endtime == null ? JSONObject.NULL : this.endtime);
        json.put(SinglePart.COLUMN_ISTATUS, this.istatus == null ? JSONObject.NULL : this.istatus);
        json.put(SinglePart.COLUMN_ISTATUS88X, this.istatus88x == null ? JSONObject.NULL : this.istatus88x);
        json.put(SinglePart.COLUMN_GPSLAT, this.gpsLat == null ? JSONObject.NULL : this.gpsLat);
        json.put(SinglePart.COLUMN_GPSLNG, this.gpsLng == null ? JSONObject.NULL : this.gpsLng);
        json.put(SinglePart.COLUMN_GPSDATE, this.gpsDT == null ? JSONObject.NULL : this.gpsDT);
        json.put(SinglePart.COLUMN_GPSACC, this.gpsAcc == null ? JSONObject.NULL : this.gpsAcc);
        json.put(SinglePart.COLUMN_DEVICEID, this.deviceID == null ? JSONObject.NULL : this.deviceID);
        json.put(SinglePart.COLUMN_GPSELEV, this.gpsElev == null ? JSONObject.NULL : this.gpsElev);
        json.put(SinglePart.COLUMN_DEVICE_TAGID, this.devicetagID == null ? JSONObject.NULL : this.devicetagID);
        /*json.put("synced", this.synced == null ? JSONObject.NULL : this.synced);
        json.put("synced_date", this.synced_date == null ? JSONObject.NULL : this.synced_date);*/
        json.put(SinglePart.COLUMN_APPVERSION, this.appversion == null ? JSONObject.NULL : this.appversion);
        json.put(SinglePart.COLUMN_ROUND, this.round == null ? JSONObject.NULL : this.round);
        if (!this.sa1.equals("")) {
            json.put(SinglePart.COLUMN_SA1, new JSONObject(this.sa1));
        }


        return json;
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

    public String getFormType() {
        return formType;
    }

    public void setFormType(String formType) {
        this.formType = formType;
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

    public String getStudyID() {
        return studyID;
    }

    public void setStudyID(String studyID) {
        this.studyID = studyID;
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

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }


    public static final class SinglePart implements BaseColumns {
        public static final String COLUMN_PROJECT_NAME = "projectName";
        public static final String COLUMN_UID = "uid";
        public static final String COLUMN_FORMDATE = "formDate";
        public static final String COLUMN_FORMTYPE = "formType";
        public static final String COLUMN_USER = "username";
        public static final String COLUMN_STUDYID = "studyID";
        public static final String COLUMN_CLUSTERCODE = "clustercode";
        public static final String COLUMN_ENDINGDATETIME = "endtime";
        public static final String COLUMN_ISTATUS = "istatus";
        public static final String COLUMN_ISTATUS88X = "istatus88x";
        public static final String COLUMN_GPSLAT = "gpsLat";
        public static final String COLUMN_GPSLNG = "gpsLng";
        public static final String COLUMN_GPSDATE = "gpsDT";
        public static final String COLUMN_GPSACC = "gpsAcc";
        public static final String COLUMN_GPSELEV = "gpsElev";
        public static final String COLUMN_DEVICEID = "deviceID";
        public static final String COLUMN_DEVICE_TAGID = "devicetagID";
        public static final String COLUMN_APPVERSION = "appversion";
        public static final String COLUMN_ROUND = "round";
        public static final String COLUMN_SA1 = "sa1";
    }

}
