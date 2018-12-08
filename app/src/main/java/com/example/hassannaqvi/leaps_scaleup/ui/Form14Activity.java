package com.example.hassannaqvi.leaps_scaleup.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.hassannaqvi.leaps_scaleup.R;
import com.example.hassannaqvi.leaps_scaleup.RMOperations.crudOperations;
import com.example.hassannaqvi.leaps_scaleup.core.MainApp;
import com.example.hassannaqvi.leaps_scaleup.data.DAO.FormsDAO;
import com.example.hassannaqvi.leaps_scaleup.data.DAO.GetFncDAO;
import com.example.hassannaqvi.leaps_scaleup.data.entities.Forms;
import com.example.hassannaqvi.leaps_scaleup.data.entities.Forms_04_05;
import com.example.hassannaqvi.leaps_scaleup.databinding.ActivityForm14Binding;
import com.example.hassannaqvi.leaps_scaleup.get.db.GetIndDBData;
import com.example.hassannaqvi.leaps_scaleup.validation.validatorClass;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;

import static android.view.View.VISIBLE;
import static com.example.hassannaqvi.leaps_scaleup.ui.LoginActivity.db;

public class Form14Activity extends AppCompatActivity {
    private static final String TAG = Form14Activity.class.getName();

    ActivityForm14Binding bi;

    public static Forms fc;
    String getFtype = "", deviceID;
    Forms_04_05 participantDT;
    Forms _participantDT;
    Boolean isFormType7 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_form14);
        bi.setCallback(this);
        bi.ls1403.setManager(getSupportFragmentManager());
        bi.ls1403.setMaxDate(new SimpleDateFormat("dd/MM/yyyy").format(System.currentTimeMillis()));
        getFtype = MainApp.FORM14;
        fc = new Forms();

        deviceID = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);

        this.setTitle(R.string.ls14Heading);
    }

    public void BtnContinue() {
        //startActivity(new Intent(getApplicationContext(), Form02HHPart_2_HI_SE.class).putExtra("complete", true));
        if (formValidation()) {
            Toast.makeText(this, "validated", Toast.LENGTH_SHORT).show();
            try {
                SaveDraft();
                if (UpdateDB()) {
                    finish();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                } else {
                    Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void checkID() {
        //startActivity(new Intent(getApplicationContext(), Form02HHPart_2_HI_SE.class).putExtra("complete", true));
        if (validatorClass.EmptyRadioButton(this, bi.ls14a, bi.ls14a01, getString(R.string.ls14)) && !TextUtils.isEmpty(bi.ls14b.getText().toString())) {
            /*bi.mainLayout1.setVisibility(View.VISIBLE);
            bi.ls14a01.setError(null);
            bi.ls14b.setError(null);*/
            try {
                Object participantExists = new GetIndDBData(db, GetFncDAO.class.getName(), "getFncDao", "checkParticipantExist").execute(bi.ls14b.getText().toString());

                if (participantExists != null) {
                    try {
                        Object participantData = new GetIndDBData(db, GetFncDAO.class.getName(), "getFncDao", "getParticipantRecord").execute(bi.ls14b.getText().toString()).get();

                        if (participantData != null) {
                            isFormType7 = false;
                            participantDT = (Forms_04_05) participantData;
                            // Enable view
                            bi.mainLayout1.setVisibility(View.VISIBLE);
                            bi.ls14a01.setError(null);
                            bi.ls14b.setError(null);
                        } else {
                            Toast.makeText(this, "You are not allowed to enter deviation form for this participant!!", Toast.LENGTH_SHORT).show();
                            bi.mainLayout1.setVisibility(View.GONE);
                            bi.ls1403.setText("");
                            bi.ls1404.setText("");
                            bi.ls1405.setText("");
                            bi.ls1406.clearCheck();
                            bi.ls1407.clearCheck();
                            bi.ls1408.setText("");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                } else {

                        Object participantExistsinform7 = new GetIndDBData(db, GetFncDAO.class.getName(), "getFncDao", "getParticipantRecordForm7").execute(bi.ls14b.getText().toString());

                        if (participantExistsinform7 != null) {
                            isFormType7 = true;
                            _participantDT = (Forms) participantExistsinform7;
                            // Enable view
                            bi.mainLayout1.setVisibility(View.VISIBLE);
                            bi.ls14a01.setError(null);
                            bi.ls14b.setError(null);


                        } else {
                            Toast.makeText(this, "Participant ID not found!!!", Toast.LENGTH_SHORT).show();
                            bi.mainLayout1.setVisibility(View.GONE);
                            bi.ls1403.setText("");
                            bi.ls1404.setText("");
                            bi.ls1405.setText("");
                            bi.ls1406.clearCheck();
                            bi.ls1407.clearCheck();
                            bi.ls1408.setText("");
                        }


                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(this, "Please enter ID", Toast.LENGTH_SHORT).show();
            bi.ls14a01.setError("Please Enter participant ID");
            bi.ls14b.setError("Please Enter participant ID");
            bi.mainLayout1.setVisibility(View.GONE);
            bi.ls1403.setText("");
            bi.ls1404.setText("");
            bi.ls1405.setText("");
            bi.ls1406.clearCheck();
            bi.ls1407.clearCheck();
            bi.ls1408.setText("");
        }


    }

    private void SaveDraft() throws JSONException {

        fc.setDevicetagID(MainApp.getTagName(this));
        fc.setFormType(MainApp.FORM14);
        fc.setAppversion(MainApp.versionName + "." + MainApp.versionCode);
        fc.setUsername(MainApp.userName);
        fc.setFormDate(new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime()));
        fc.setDeviceID(deviceID);
        setGPS(fc); // Set GPS

        fc.setClustercode(bi.ls1404.getText().toString());
        fc.setYouthID(bi.ls14b.getText().toString());
        fc.setRound("1");
        fc.setStudyID(MainApp.round + "" + bi.ls1404.getText().toString() + bi.ls14b.getText().toString());
        JSONObject sF14 = new JSONObject();
        if (!isFormType7) {
            fc.setYouthName(participantDT.getParticipantName());
            sF14.put("uuid", participantDT.getUid());
        } else {
            fc.setYouthName(_participantDT.getYouthName());
            sF14.put("uuid", _participantDT.getUid());
        }
        sF14.put("ls1403", bi.ls1403.getText().toString());
        sF14.put("ls1404", bi.ls1404.getText().toString());
        sF14.put("ls1405", bi.ls1405.getText().toString());
        sF14.put("ls1406", bi.ls1406a.isChecked() ? "1"
                : bi.ls1406b.isChecked() ? "2"
                : bi.ls1406c.isChecked() ? "3"
                : bi.ls140696.isChecked() ? "96"
                : "0");

        sF14.put("ls140696x", bi.ls140696x.getText().toString());
        sF14.put("ls1407", bi.ls1407a.isChecked() ? "1"
                : bi.ls1407b.isChecked() ? "2"
                : "0");
        sF14.put("ls1408", bi.ls1408.getText().toString());
        fc.setSa1(String.valueOf(sF14));

    }

    public void setGPS(Forms fc) {
        SharedPreferences GPSPref = getSharedPreferences("GPSCoordinates", Context.MODE_PRIVATE);
        try {
            String lat = GPSPref.getString("Latitude", "0");
            String lang = GPSPref.getString("Longitude", "0");
            String acc = GPSPref.getString("Accuracy", "0");
            String elevation = GPSPref.getString("Elevation", "0");

            if (lat == "0" && lang == "0") {
                Toast.makeText(this, "Could not obtained GPS points", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "GPS set", Toast.LENGTH_SHORT).show();
            }

            String date = DateFormat.format("dd-MM-yyyy HH:mm", Long.parseLong(GPSPref.getString("Time", "0"))).toString();

            fc.setGpsLat(lat);
            fc.setGpsLng(lang);
            fc.setGpsAcc(acc);
            fc.setGpsDT(date); // Timestamp is converted to date above
            fc.setGpsElev(elevation);

            Toast.makeText(this, "GPS set", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Log.e(TAG, "setGPS: " + e.getMessage());
        }

    }

    public void BtnEnd() {
        finish();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
//        startActivity(new Intent(getApplicationContext(), EndingActivity.class).putExtra("complete", false));
    }

    private boolean UpdateDB() {

        try {

            Long longID = new crudOperations(db, fc).execute(FormsDAO.class.getName(), "formsDao", "insertForm").get();

            if (longID != 0) {
                fc.setId(longID.intValue());

                fc.setUid(deviceID + fc.getId());

                longID = new crudOperations(db, fc).execute(FormsDAO.class.getName(), "formsDao", "updateForm").get();
                return longID == 1;

            } else {
                return false;
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return true;
    }

    private boolean formValidation() {

        if (!validatorClass.EmptyRadioButton(this, bi.ls14a, bi.ls14a01, getString(R.string.ls14))) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.ls14b, getString(R.string.ls14))) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.ls1403, getString(R.string.ls1403))) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.ls1404, getString(R.string.ls1404))) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.ls1405, getString(R.string.ls1405))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls1406, bi.ls140696, bi.ls140696x, getString(R.string.ls1406))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.ls1407, bi.ls1407a, getString(R.string.ls1407))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.ls1408, getString(R.string.ls1408))) {
            return false;
        }
        return true;
    }

}

