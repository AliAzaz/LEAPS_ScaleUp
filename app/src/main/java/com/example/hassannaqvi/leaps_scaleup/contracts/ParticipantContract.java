package com.example.hassannaqvi.leaps_scaleup.contracts;


import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

public class ParticipantContract {

    private static final String TAG = "Participant_CONTRACT";
    private String study_id;
    private String part_name;
    private String part_type;

    public ParticipantContract() {
        // Default Constructor
    }

    public ParticipantContract Sync(JSONObject jsonObject) throws JSONException {
        this.study_id = jsonObject.getString(SinglePart.COLUMN_STUDY_ID);
        this.part_name = jsonObject.getString(SinglePart.COLUMN_PART_NAME);
        this.part_type = jsonObject.getString(SinglePart.COLUMN_PART_TYPE);
        return this;
    }

    public ParticipantContract HydrateParticipant(Cursor cursor) {
        this.study_id = cursor.getString(cursor.getColumnIndex(SinglePart.COLUMN_STUDY_ID));
        this.part_name = cursor.getString(cursor.getColumnIndex(SinglePart.COLUMN_PART_NAME));
        this.part_type = cursor.getString(cursor.getColumnIndex(SinglePart.COLUMN_PART_TYPE));
        return this;
    }

    public String getStudy_id() {
        return study_id;
    }

    public void setStudy_id(String study_id) {
        this.study_id = study_id;
    }

    public String getPart_name() {
        return part_name;
    }

    public void setPart_name(String part_name) {
        this.part_name = part_name;
    }

    public String getPart_type() {
        return part_type;
    }

    public void setPart_type(String part_type) {
        this.part_type = part_type;
    }

    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();
        json.put(SinglePart.COLUMN_STUDY_ID, this.study_id == null ? JSONObject.NULL : this.study_id);
        json.put(SinglePart.COLUMN_PART_NAME, this.part_name == null ? JSONObject.NULL : this.part_name);
        json.put(SinglePart.COLUMN_PART_TYPE, this.part_type == null ? JSONObject.NULL : this.part_type);
        return json;
    }


    public static abstract class SinglePart implements BaseColumns {

        public static final String TABLE_NAME = "Participant";
        public static final String COLUMN_STUDY_ID = "study_id";
        public static final String COLUMN_PART_NAME = "part_name";
        public static final String COLUMN_PART_TYPE = "part_type";

        public static final String _URI = "participant.php"; //suno
    }
}