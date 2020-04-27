package com.example.hassannaqvi.leaps_scaleup.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.hassannaqvi.leaps_scaleup.R;
import com.example.hassannaqvi.leaps_scaleup.RMOperations.crudOperations;
import com.example.hassannaqvi.leaps_scaleup.core.MainApp;
import com.example.hassannaqvi.leaps_scaleup.data.DAO.FormsDAO;
import com.example.hassannaqvi.leaps_scaleup.data.entities.Forms_04_05;
import com.example.hassannaqvi.leaps_scaleup.databinding.ActivityGpsCoordinateBinding;
import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.ExecutionException;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static com.example.hassannaqvi.leaps_scaleup.ui.LoginActivity.db;

public class GPSCoordinateActivity extends AppCompatActivity {
    private static final String TAG = GPSCoordinateActivity.class.getName();
    public static Forms_04_05 fc_4_5;
    ActivityGpsCoordinateBinding bi;
    String getFtype = "", deviceID;
    String[] cluster_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_gps_coordinate);
        bi.setCallback(this);
        this.setTitle(R.string.ls01aheading);

        getFtype = getIntent().getStringExtra("fType");

        deviceID = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);

        setupView();

    }

    private void setupView() {

        bi.gca02a.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                bi.fldgrpls01a01.setVisibility(VISIBLE);
                //ClearClass.ClearAllFields(bi.fldgrpls01a01);

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        bi.gca05.setOnCheckedChangeListener((new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == bi.gca05b.getId() || i == bi.gca05c.getId()) {
                    Clear.clearAllFields(bi.fldgrpgca06);
                } else if (i == bi.gca05f.getId()) {
                    Clear.clearAllFields(bi.fldgrpgca07);
                    bi.fldgrpgca06.setVisibility(GONE);
                } else {
                    bi.fldgrpgca06.setVisibility(VISIBLE);
                    Clear.clearAllFields(bi.fldgrpgca08);
                }
            }
        }));

        //spinner gca03 districtName
        String[] districtName = {"....", "Naushahero Feroz", "Dadu", "Khairpur", "Sukkur"};

        bi.gca03.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Arrays.asList(districtName)));

    }

    public void BtnClusterIDValid() {
       /* if (!validatorClass.EmptyTextBox(this, bi.gca02a, getString(R.string.ls01a05))) {
            return;
        }

        Object cluster = null;
        try {
            cluster = new GetIndDBData(db, GetFncDAO.class.getName(), "getFncDao", "getClusterRecord").execute(bi.gca02a.getText().toString()).get();

            if (cluster != null) {
                Toast.makeText(this, "Cluster ID validate..", Toast.LENGTH_SHORT).show();
                cluster_name = ((Clusters) cluster).getCluster_name().split("\\|");
                bi.ls01aDis.setText(cluster_name[0]);
                bi.ls01aTeh.setText(cluster_name[1]);
                bi.ls01aUC.setText(cluster_name[2]);
                bi.ls01aVil.setText(cluster_name[3]);

                bi.fldgrpls01a01.setVisibility(VISIBLE);

            } else {
                Toast.makeText(this, "Cluster not found!!", Toast.LENGTH_SHORT).show();
              *//*  bi.fldgrpls01a01.setVisibility(GONE);
                ClearClass.ClearAllFields(bi.fldgrpls01a01,false);*//*

            }

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }*/


    }

    public void BtnContinue() {
        if (formValidation()) {
            try {
                SaveDraft();
                if (UpdateDB()) {
                    startActivity(new Intent(getApplicationContext(), Form02HHPart_1.class));
                } else {
                    Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean UpdateDB() {

        try {

            Long longID = new crudOperations(db, fc_4_5).execute(FormsDAO.class.getName(), "formsDao", "insertForm_04_05").get();

            if (longID != 0) {
                fc_4_5.setId(longID.intValue());
                fc_4_5.setUid(deviceID + fc_4_5.getId());

                longID = new crudOperations(db, fc_4_5).execute(FormsDAO.class.getName(), "formsDao", "updateForm_04_05").get();
                return longID == 1;

            } else {
                return false;
            }

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        return false;

    }

    public void BtnEnd() {

        /*if (!validatorClass.EmptyTextBox(this, bi.ls01a05, getString(R.string.ls01a05))) {
            return;
        }


        try {
            SaveDraft();
            if (UpdateDB()) {
                MainApp.endActivity(this, this, EndingActivity.class, false, fc_4_5);
            } else {
                Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }*/

    }

    private void SaveDraft() throws JSONException {

        fc_4_5 = new Forms_04_05();

        fc_4_5.setDevicetagID(MainApp.getTagName(this));
        fc_4_5.setFormType(getIntent().getStringExtra("fType"));
        fc_4_5.setAppversion(MainApp.versionName + "." + MainApp.versionCode);
        fc_4_5.setUsername(MainApp.userName);
        fc_4_5.setFormDate(new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime()));
        fc_4_5.setDeviceID(deviceID);

        setGPS(fc_4_5); // Set GPS

        fc_4_5.setClustercode(bi.gca02a.getText().toString());
        fc_4_5.setRound(String.valueOf(MainApp.round));

        JSONObject f01 = new JSONObject();
        //f01.put("ls01a02", MainApp.userName);
        //f01.put("ls01a05", cluster_name[3]); //VILLAGE
        //f01.put("ls01a06", cluster_name[0]); //DISTRICT


        f01.put("gca02a", bi.gca02a.getText().toString());
        f01.put("gca02a98", bi.gca02a98.isChecked() ? "1" : "0");

        f01.put("gca02b", bi.gca02b.getText().toString());

        f01.put("gca03", bi.gca03.getSelectedItem().toString());

        f01.put("gca05", bi.gca05a.isChecked() ? "1"
                : bi.gca05b.isChecked() ? "2"
                : bi.gca05c.isChecked() ? "3"
                : bi.gca05d.isChecked() ? "2"
                : bi.gca05e.isChecked() ? "3"
                : bi.gca05f.isChecked() ? "2"
                : bi.gca05g.isChecked() ? "3"
                : "0");

        f01.put("gca06", bi.gca06.getText().toString());
        f01.put("gca07", bi.gca07.getText().toString());
        f01.put("gca08", bi.gca08.getText().toString());

        fc_4_5.setSInfo(String.valueOf(f01));

    }

    public boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.fldGrpGPSCoord01);
    }

    public void setGPS(Forms_04_05 fc) {
        SharedPreferences GPSPref = getSharedPreferences("GPSCoordinates", Context.MODE_PRIVATE);
        try {
            String lat = GPSPref.getString("Latitude", "0");
            String lang = GPSPref.getString("Longitude", "0");
            String acc = GPSPref.getString("Accuracy", "0");
            String elevation = GPSPref.getString("Elevation", "0");

            if (lat.equals("0") && lang.equals("0")) {
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

}
