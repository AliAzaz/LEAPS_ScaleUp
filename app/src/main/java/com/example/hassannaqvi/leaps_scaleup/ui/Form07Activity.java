package com.example.hassannaqvi.leaps_scaleup.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.hassannaqvi.leaps_scaleup.R;
import com.example.hassannaqvi.leaps_scaleup.RMOperations.crudOperations;
import com.example.hassannaqvi.leaps_scaleup.core.MainApp;
import com.example.hassannaqvi.leaps_scaleup.data.DAO.FormsDAO;
import com.example.hassannaqvi.leaps_scaleup.data.DAO.GetFncDAO;
import com.example.hassannaqvi.leaps_scaleup.data.entities.Clusters;
import com.example.hassannaqvi.leaps_scaleup.data.entities.Forms;
import com.example.hassannaqvi.leaps_scaleup.databinding.ActivityForm07Binding;
import com.example.hassannaqvi.leaps_scaleup.get.db.GetIndDBData;
import com.example.hassannaqvi.leaps_scaleup.other.CheckingID;
import com.example.hassannaqvi.leaps_scaleup.validation.ClearClass;
import com.example.hassannaqvi.leaps_scaleup.validation.validatorClass;
import com.shashank.sony.fancytoastlib.FancyToast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static com.example.hassannaqvi.leaps_scaleup.ui.LoginActivity.db;

public class Form07Activity extends AppCompatActivity {

    private static final String TAG = Form07Activity.class.getName();
    ActivityForm07Binding bi;

    String getFtype = "", deviceID;

    public static Forms fc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_form07);
        bi.setCallback(this);

        this.setTitle(R.string.ls07Heading);

        bi.ls07id06.setManager(getSupportFragmentManager());
        bi.ls07id13.setManager(getSupportFragmentManager());

        getFtype = getIntent().getStringExtra("fType");

        deviceID = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);

        setupViews();

    }

    private void setupViews() {

        bi.ls07id08.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.ls07id08b) {

                    bi.fldgrpls0710.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrpls0710);
                } else {
                    bi.fldgrpls0710.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrpls0710);
                }
            }
        });

        bi.ls07id10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.ls07id10b) {
                    bi.fldgrpls0712.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrpls0712);
                    bi.fldgrpls0713.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrpls0713);
                    bi.fldgrpls0714.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrpls0714);
                } else {
                    bi.fldgrpls0712.setVisibility(View.VISIBLE);
                    bi.fldgrpls0713.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrpls0712);
                    ClearClass.ClearAllCardFields(bi.fldgrpls0713);
                    bi.fldgrpls0714.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrpls0714);
                }
            }
        });
        bi.ls07id18.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.ls07id18b) {
                    bi.fldgrpls0713.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrpls0713);
                    //bi.fldgrpls0714.setVisibility(View.GONE);
                    // ClearClass.ClearAllCardFields(bi.fldgrpls0714);
                } else {
                    bi.fldgrpls0713.setVisibility(View.VISIBLE);
                    //bi.fldgrpls0714.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrpls0713);
                    //ClearClass.ClearAllCardFields(bi.fldgrpls0714);
                }
            }
        });


        bi.ls07id15.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                bi.fldgrpls07a01.setVisibility(GONE);

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        if (MainApp.round == 1) {
            bi.fldgrpls0717.setVisibility(GONE);
        }


    }

    public void BtnContinue() {

        if (formValidation(true)) {
            try {
                SaveDraft();

                if (UpdateDB()) {
                    MainApp.endActivity(this, this, EndingActivity.class, true, fc);
                } else {
                    FancyToast.makeText(this, "Error in updating db!!", FancyToast.LENGTH_SHORT, FancyToast.ERROR, false).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
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

        return false;

    }

    public void BtnClusterIDValid() {
        if (!validatorClass.EmptyTextBox(this, bi.ls07id15, getString(R.string.ls07id15))) {
            return;
        }

        Object cluster = null;
        try {
            cluster = new GetIndDBData(db, GetFncDAO.class.getName(), "getFncDao", "getClusterRecord").execute(bi.ls07id15.getText().toString()).get();

            if (cluster != null) {
                Toast.makeText(this, "Cluster ID validate..", Toast.LENGTH_SHORT).show();
                String[] cluster_name = ((Clusters) cluster).getCluster_name().split("\\|");
                bi.ls01aDis.setText(cluster_name[0]);
                bi.ls01aTeh.setText(cluster_name[1]);
                bi.ls01aUC.setText(cluster_name[2]);
                bi.ls01aVil.setText(cluster_name[3]);

                bi.fldgrpls07a01.setVisibility(VISIBLE);

            } else {
                Toast.makeText(this, "Cluster not found!!", Toast.LENGTH_SHORT).show();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

    public boolean formValidation(boolean flag) {

        //2
        if (!validatorClass.EmptyTextBox(this, bi.ls07id02, getString(R.string.ls07id02))) {
            return false;
        }
        //3
        if (!validatorClass.EmptyTextBox(this, bi.ls07id03, getString(R.string.ls07id03))) {
            return false;
        }
        if (!CheckingID.getIDValidation(this, bi.ls07id03, "8" + bi.ls07id03.getText().toString(), getFtype)) {
            return false;
        }

        if (flag) {

            //6
            if (!validatorClass.EmptyRadioButton(this, bi.ls07id05, bi.ls07id05a, getString(R.string.ls07id05))) {
                return false;
            }
            //7
            if (!validatorClass.EmptyTextBox(this, bi.ls07id06, getString(R.string.ls07id06))) {
                return false;
            }
            //8
            if (!validatorClass.EmptyTextBox(this, bi.ls07id07, getString(R.string.ls07id07))) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, bi.ls07id07, 18, 24, getString(R.string.ls07id07), "Age")) {
                return false;
            }
            //9
            if (!validatorClass.EmptyRadioButton(this, bi.ls07id08, bi.ls07id08a, getString(R.string.ls07id08))) {
                return false;
            }
            if (bi.ls07id08a.isChecked()) {
                //10
                if (!validatorClass.EmptyRadioButton(this, bi.ls07id09, bi.ls07id09a, getString(R.string.ls07id09))) {
                    return false;
                }
            }
            //11
            if (!validatorClass.EmptyRadioButton(this, bi.ls07id10, bi.ls07id10a, getString(R.string.ls07id10))) {
                return false;
            }
            if (bi.ls07id10a.isChecked()) {
                //12
                if (!validatorClass.EmptyRadioButton(this, bi.ls07id18, bi.ls07id18a, getString(R.string.ls07id18))) {
                    return false;
                }
                if (bi.ls07id18a.isChecked()) {
                    //13
                    if (!validatorClass.EmptyTextBox(this, bi.ls07id11, getString(R.string.ls07id11))) {
                        return false;
                    }
                    //14
//                if (!validatorClass.EmptyRadioButton(this, bi.ls07id17, bi.ls07id17a, getString(R.string.ls07id17))) {
//                    return false;
//                }
                }

            } else {
                //14
                if (!validatorClass.EmptyRadioButton(this, bi.ls07id17, bi.ls07id17a, getString(R.string.ls07id17))) {
                    return false;
                }
            }
            //15
            if (!validatorClass.EmptyRadioButton(this, bi.ls07id12, bi.ls07id12a, getString(R.string.ls07id12))) {
                return false;
            }
            if (bi.ls07id1296.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.ls07id1296x, getString(R.string.ls07id12))) {
                    return false;
                }
            }

            //16
            if (!validatorClass.EmptyTextBox(this, bi.ls07id13, getString(R.string.ls07id13))) {
                return false;
            }
            //17
            if (MainApp.round != 1) {
                return validatorClass.EmptyRadioButton(this, bi.ls07id14, bi.ls07id14a, getString(R.string.ls07id14));
            }
        }

        return true;
    }

    private void SaveDraft() throws JSONException {

        fc = new Forms();

        fc.setDevicetagID(MainApp.getTagName(this));
        fc.setFormType(getIntent().getStringExtra("fType"));
        fc.setAppversion(MainApp.versionName + "." + MainApp.versionCode);
        fc.setUsername(MainApp.userName);
        fc.setFormDate(new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime()));
        fc.setDeviceID(deviceID);
        setGPS(fc); // Set GPS

        fc.setClustercode(bi.ls07id15.getText().toString());
        fc.setYouthID(bi.ls07id03.getText().toString());
        fc.setStudyID(MainApp.round + "" + bi.ls07id15.getText().toString() + bi.ls07id03.getText().toString());

        JSONObject f07 = new JSONObject();

        f07.put("round", MainApp.round);
        f07.put("ls0702", bi.ls07id02.getText().toString()); //name
//        f07.put("ls0703", bi.ls07id03.getText().toString()); //already saving in youthID
        f07.put("ls0706", bi.ls07id05a.isChecked() ? "1"
                : bi.ls07id05b.isChecked() ? "2"
                : bi.ls07id05c.isChecked() ? "3"
                : "0");
        f07.put("ls0707", bi.ls07id06.getText().toString());
        f07.put("ls0708", bi.ls07id07.getText().toString());

        f07.put("ls0709", bi.ls07id08a.isChecked() ? "1"
                : bi.ls07id08b.isChecked() ? "2"
                : "0");

        f07.put("ls0710", bi.ls07id09a.isChecked() ? "1"
                : bi.ls07id09b.isChecked() ? "2"
                : bi.ls07id0998.isChecked() ? "98"
                : "0");

        f07.put("ls0711", bi.ls07id10a.isChecked() ? "1"
                : bi.ls07id10b.isChecked() ? "2"
                : "0");

        f07.put("ls0712", bi.ls07id18a.isChecked() ? "1"
                : bi.ls07id18b.isChecked() ? "2"
                : "0");

        f07.put("ls0713", bi.ls07id11.getText().toString());

        f07.put("ls0714", bi.ls07id12a.isChecked() ? "1"
                : bi.ls07id17a.isChecked() ? "2"
                : bi.ls07id17b.isChecked() ? "3"
                : bi.ls07id17c.isChecked() ? "97"
                : "0");

        f07.put("ls0715", bi.ls07id12a.isChecked() ? "1"
                : bi.ls07id12b.isChecked() ? "2"
                : bi.ls07id12c.isChecked() ? "3"
                : bi.ls07id12d.isChecked() ? "4"
                : bi.ls07id1296.isChecked() ? "96"
                : "0");
        f07.put("ls071596x", bi.ls07id1296x.getText().toString());

        f07.put("ls0716", bi.ls07id13.getText().toString());

        f07.put("ls0717", bi.ls07id14a.isChecked() ? "1"
                : bi.ls07id14b.isChecked() ? "2"
                : bi.ls07id14c.isChecked() ? "3"
                : "0");

        fc.setSa1(String.valueOf(f07));

    }

    public void BtnEnd() {

        if (formValidation(false)) {
            try {
                SaveDraft();

                if (UpdateDB()) {
                    MainApp.endActivity(this, this, EndingActivity.class, false, fc);
                } else {
                    FancyToast.makeText(this, "Error in updating db!!", FancyToast.LENGTH_SHORT, FancyToast.ERROR, false).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

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

}
