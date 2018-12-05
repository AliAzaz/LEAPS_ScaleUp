package com.example.hassannaqvi.leaps_scaleup.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.util.Log;
import android.widget.Toast;

import com.example.hassannaqvi.leaps_scaleup.JSON.GeneratorClass;
import com.example.hassannaqvi.leaps_scaleup.R;
import com.example.hassannaqvi.leaps_scaleup.RMOperations.crudOperations;
import com.example.hassannaqvi.leaps_scaleup.core.MainApp;
import com.example.hassannaqvi.leaps_scaleup.data.DAO.FormsDAO;
import com.example.hassannaqvi.leaps_scaleup.data.DAO.GetFncDAO;
import com.example.hassannaqvi.leaps_scaleup.data.entities.Forms_04_05;
import com.example.hassannaqvi.leaps_scaleup.databinding.ActivityYouthInfoBinding;
import com.example.hassannaqvi.leaps_scaleup.get.db.GetIndDBData;
import com.example.hassannaqvi.leaps_scaleup.validation.ClearClass;
import com.example.hassannaqvi.leaps_scaleup.validation.validatorClass;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static com.example.hassannaqvi.leaps_scaleup.ui.LoginActivity.db;

public class YouthInfoActivity extends AppCompatActivity {
    private static final String TAG = InfoActivity.class.getName();
    public static Forms_04_05 fc_4_5;
    ActivityYouthInfoBinding bi;
    String fTYPE = "", fExt = "", deviceID;
    Class<?> routeClass;
    Forms_04_05 youthDT;
    Forms_04_05.Simple_Forms_04_05 sInfo_parse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_youth_info);
        bi.setCallback(this);
        deviceID = Settings.Secure.getString(YouthInfoActivity.this.getContentResolver(), Settings.Secure.ANDROID_ID);
        setContentUI();
    }

    private void setContentUI() {

        /*Getting intent data*/
        fTYPE = getIntent().getStringExtra("fType");

        /*Setting BlackBox date picker*/
        bi.lsyid03.setManager(getSupportFragmentManager());
        bi.lsyid03.setMaxDate(new SimpleDateFormat("dd/MM/yyyy").format(System.currentTimeMillis()));

        /*Setting listeners*/
        bi.lsyid01.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                bi.fldgrplsyid01.setVisibility(GONE);
                ClearClass.ClearAllFields(bi.fldgrplsyid01);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        /*Calling fnc*/
        routeClass = selectedForm(fTYPE);

    }

    private Class<?> selectedForm(String fType) {

        Class retClass = null;

        switch (fType) {

            case "8":
                fExt = "f8_";
                retClass = Form08_EF_A.class;
                break;
            case "9":
                fExt = "f9_";
                retClass = Form09_part_1_Activity.class;
                break;
        }

        return retClass;
    }

    public void BtnContinue() {
        if (formValidation()) {
            SaveDraft();
            if (UpdateDB()) {
                startActivity(new Intent(getApplicationContext(), routeClass));
            } else {
                Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public void BtnIDValid() {
        if (!validatorClass.EmptyTextBox(this, bi.lsyid01, getString(R.string.lsyid01))) {
            return;
        }

        try {
            Object youthData = new GetIndDBData(db, GetFncDAO.class.getName(), "getFncDao", "getChildYouthRecord").execute(bi.lsyid01.getText().toString()).get();

            if (youthData != null) {
                Toast.makeText(this, "Youth ID validate..", Toast.LENGTH_SHORT).show();
                youthDT = (Forms_04_05) youthData;

                // Youth Name
                bi.lsyid02.setText(youthDT.getChildName());
                // Form date of enrollment
                bi.lsyid03.setText(youthDT.getFormDate());

                sInfo_parse = new Gson().fromJson(youthDT.getSInfo(), Forms_04_05.Simple_Forms_04_05.class);

                // Round Setting
                bi.lsyid04.check(
                        sInfo_parse.getLs01a07().equals("1") ? bi.lsyid04a.getId() :
                                sInfo_parse.getLs01a07().equals("2") ? bi.lsyid04b.getId() :
                                        sInfo_parse.getLs01a07().equals("3") ? bi.lsyid04c.getId() :
                                                sInfo_parse.getLs01a07().equals("4") ? bi.lsyid04d.getId() : bi.lsyid04a.getId());

                for (byte i = 0; i < bi.lsyid04.getChildCount(); i++) {
                    bi.lsyid04.getChildAt(i).setEnabled(false);
                }

                // Enable view
                bi.fldgrplsyid01.setVisibility(VISIBLE);

            } else {
                Toast.makeText(this, "Youth ID not found!!", Toast.LENGTH_SHORT).show();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
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

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return false;

    }

    private void SaveDraft() {

        fc_4_5 = new Forms_04_05();
        fc_4_5.setDevicetagID(MainApp.getTagName(this));
        fc_4_5.setFormType(fTYPE);
        fc_4_5.setAppversion(MainApp.versionName + "." + MainApp.versionCode);
        fc_4_5.setUsername(MainApp.userName);
        fc_4_5.setFormDate(new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime()));
        fc_4_5.setDeviceID(deviceID);
        fc_4_5.setChildID(bi.lsyid01.getText().toString());

        setGPS(fc_4_5); // Set GPS

        JSONObject Json = GeneratorClass.getContainerJSON(bi.fldgrplsyid01, true, fExt);
        fc_4_5.setSInfo(String.valueOf(Json));

    }

    public void setGPS(Forms_04_05 fc_4_5) {
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

            fc_4_5.setGpsLat(lat);
            fc_4_5.setGpsLng(lang);
            fc_4_5.setGpsAcc(acc);
            fc_4_5.setGpsDT(date); // Timestamp is converted to date above
            fc_4_5.setGpsElev(elevation);

            Toast.makeText(this, "GPS set", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Log.e(TAG, "setGPS: " + e.getMessage());
        }

    }

    private boolean formValidation() {

        return validatorClass.EmptyCheckingContainer(this, bi.fldgrplsyid01);
    }

    public void BtnEnd() {

        SaveDraft();
        if (UpdateDB()) {
            MainApp.endActivity(this, this, EndingActivity.class, false, fc_4_5);
        } else {
            Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
        }
    }


}
