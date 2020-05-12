package com.example.hassannaqvi.leaps_scaleup.data.entities;

import android.provider.BaseColumns;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.hassannaqvi.leaps_scaleup.data.AppDatabase;

import org.json.JSONException;
import org.json.JSONObject;

@Entity(tableName = AppDatabase.Sub_DBConnection.TABLE_PARTICIPANT)
public class Participant {

    @Ignore
    private static final String TAG = "Participant_CONTRACT";
    @PrimaryKey(autoGenerate = true)
    private int _id;
    @ColumnInfo
    private String studyID;
    private String partName;
    private String partType;

    public Participant Sync(JSONObject jsonObject) throws JSONException {
        this.studyID = jsonObject.getString(SinglePart.COLUMN_STUDY_ID);
        this.partName = jsonObject.getString(SinglePart.COLUMN_PART_NAME);
        this.partType = jsonObject.getString(SinglePart.COLUMN_PART_TYPE);
        return this;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getStudyID() {
        return studyID;
    }

    public void setStudyID(String studyID) {
        this.studyID = studyID;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getPartType() {
        return partType;
    }

    public void setPartType(String partType) {
        this.partType = partType;
    }

    public static final class SinglePart implements BaseColumns {
        public static final String COLUMN_STUDY_ID = "study_id";
        public static final String COLUMN_PART_NAME = "part_name";
        public static final String COLUMN_PART_TYPE = "part_type";
    }
}