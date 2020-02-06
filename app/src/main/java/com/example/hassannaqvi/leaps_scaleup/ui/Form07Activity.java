package com.example.hassannaqvi.leaps_scaleup.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

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
    String[] cluster_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_form07);
        bi.setCallback(this);

        this.setTitle(R.string.ls07Heading);

        bi.ls07y08.setManager(getSupportFragmentManager());
        bi.ls07y17.setManager(getSupportFragmentManager());

        getFtype = getIntent().getStringExtra("fType");

        deviceID = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);

        setupViews();

    }

    private void setupViews() {

        bi.ls07y10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.ls07y10b) {

                    bi.fldgrpls0711.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrpls0711);
                } else {
                    bi.fldgrpls0711.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrpls0711);
                }
            }
        });

        bi.ls07y12.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.ls07y12b) {
                    bi.fldgrpls0715.setVisibility(View.VISIBLE);
                    bi.fldgrpls0713.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrpls0713);
                    bi.fldgrpls0714.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrpls0714);
                } else {
                    bi.fldgrpls0715.setVisibility(View.GONE);
                    bi.fldgrpls0713.setVisibility(View.VISIBLE);
                    bi.fldgrpls0714.setVisibility(View.VISIBLE);

                }
            }
        });
        bi.ls07y13.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.ls07y13a) {
                    bi.fldgrpls0714.setVisibility(View.VISIBLE);
                } else {
                    ClearClass.ClearAllCardFields(bi.fldgrpls0715);
                    bi.fldgrpls0714.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrpls0714);
                }
            }
        });


        bi.ls07y05.addTextChangedListener(new TextWatcher() {
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

//        if (MainApp.round == 1) {
//            bi.fldgrpls0718.setVisibility(GONE);
//        }


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
        if (!validatorClass.EmptyTextBox(this, bi.ls07y05, getString(R.string.ls07y05))) {
            return;
        }

        Object cluster = null;
        try {
            cluster = new GetIndDBData(db, GetFncDAO.class.getName(), "getFncDao", "getClusterRecord").execute(bi.ls07y05.getText().toString()).get();

            if (cluster != null) {
                Toast.makeText(this, "Cluster ID validate..", Toast.LENGTH_SHORT).show();
                cluster_name = ((Clusters) cluster).getCluster_name().split("\\|");
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
        if (!validatorClass.EmptyTextBox(this, bi.ls07y03, getString(R.string.ls07y03))) {
            return false;
        }
        //3
        if (!validatorClass.EmptyTextBox(this, bi.ls07y04, getString(R.string.ls07y04))) {
            return false;
        }
        if (!CheckingID.getIDValidation(this, bi.ls07y04, "8" + bi.ls07y04.getText().toString(), getFtype)) {
            return false;
        }

        if (flag) {

            //6
            if (!validatorClass.EmptyRadioButton(this, bi.ls07y07, bi.ls07y07a, getString(R.string.ls07y07))) {
                return false;
            }
            //7
            if (!validatorClass.EmptyTextBox(this, bi.ls07y08, getString(R.string.ls07y08))) {
                return false;
            }
            //8
            if (!validatorClass.EmptyTextBox(this, bi.ls07y09, getString(R.string.ls07y09))) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, bi.ls07y09, 16, 99, getString(R.string.ls07y09), "Age")) {
                return false;
            }
            if (!validatorClass.EmptyTextBox(this, bi.ls07m09, getString(R.string.ls07y09))) {
                return false;
            }
            if (!validatorClass.RangeTextBox(this, bi.ls07m09, 0, 11, getString(R.string.ls07y09), "Age")) {
                return false;
            }
            //9
            if (!validatorClass.EmptyRadioButton(this, bi.ls07y10, bi.ls07y10a, getString(R.string.ls07y10))) {
                return false;
            }
            if (bi.ls07y10a.isChecked()) {
                //10
                if (!validatorClass.EmptyRadioButton(this, bi.ls07y11, bi.ls07y11a, getString(R.string.ls07y11))) {
                    return false;
                }
            }
            //11
            if (!validatorClass.EmptyRadioButton(this, bi.ls07y12, bi.ls07y12a, getString(R.string.ls07y12))) {
                return false;
            }
            if (bi.ls07y12a.isChecked()) {
                //12
                if (!validatorClass.EmptyRadioButton(this, bi.ls07y13, bi.ls07y13a, getString(R.string.ls07y13))) {
                    return false;
                }
                if (bi.ls07y13a.isChecked()) {
                    //13
                    if (!validatorClass.EmptyTextBox(this, bi.ls07y14, getString(R.string.ls07y14))) {
                        return false;
                    }
                    //14

                }

            } else {
                if (!validatorClass.EmptyRadioButton(this, bi.ls07y15, bi.ls07y15a, getString(R.string.ls07y15))) {
                    return false;
                }

            }
            //15
            if (!validatorClass.EmptyRadioButton(this, bi.ls07y16, bi.ls07y16a, getString(R.string.ls07y16))) {
                return false;
            }
            if (bi.ls07y1696.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.ls07y1696x, getString(R.string.ls07y16))) {
                    return false;
                }
            }

            //16
            if (!validatorClass.EmptyTextBox(this, bi.ls07y17, getString(R.string.ls07y17))) {
                return false;
            }
            //17
            if (MainApp.round != 1) {
                return validatorClass.EmptyRadioButton(this, bi.ls07y18, bi.ls07y18a, getString(R.string.ls07y18));
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

        fc.setClustercode(bi.ls07y05.getText().toString());
        fc.setYouthID(bi.ls07y04.getText().toString());
//        fc.setStudyID(MainApp.round + "" + bi.ls07y05.getText().toString() + bi.ls07y04.getText().toString());
        fc.setStudyID("8" + bi.ls07y05.getText().toString() + bi.ls07y04.getText().toString());
        fc.setYouthName(bi.ls07y03.getText().toString()); //Name

        fc.setRound(String.valueOf(MainApp.round));

        JSONObject f07 = new JSONObject();

//        f07.put("ls07y03", bi.ls07y03.getText().toString());
        f07.put("ls01a06", cluster_name[0]); //District
        f07.put("ls07y07", bi.ls07y07a.isChecked() ? "1"
                : bi.ls07y07b.isChecked() ? "2"
                : bi.ls07y07c.isChecked() ? "3"
                : "0");
        f07.put("ls07y08", bi.ls07y08.getText().toString());
        f07.put("ls07y09", bi.ls07y09.getText().toString());

        f07.put("ls07y10", bi.ls07y10a.isChecked() ? "1"
                : bi.ls07y10b.isChecked() ? "2"
                : "0");

        f07.put("ls07y11", bi.ls07y11a.isChecked() ? "1"
                : bi.ls07y11b.isChecked() ? "2"
                : bi.ls07y1198.isChecked() ? "98"
                : "0");

        f07.put("ls07y12", bi.ls07y12a.isChecked() ? "1"
                : bi.ls07y12b.isChecked() ? "2"
                : "0");

        f07.put("ls07y13", bi.ls07y13a.isChecked() ? "1"
                : bi.ls07y13b.isChecked() ? "2"
                : "0");

        f07.put("ls07y14", bi.ls07y14.getText().toString());

        f07.put("ls07y15", bi.ls07y15a.isChecked() ? "1"
                : bi.ls07y15b.isChecked() ? "2"
                : bi.ls07y15c.isChecked() ? "3"
                : "0");

        f07.put("ls07y16", bi.ls07y16a.isChecked() ? "1"
                : bi.ls07y16b.isChecked() ? "2"
                : bi.ls07y16c.isChecked() ? "3"
                : bi.ls07y16d.isChecked() ? "4"
                : bi.ls07y1696.isChecked() ? "96"
                : "0");
        f07.put("ls07y1696x", bi.ls07y1696x.getText().toString());

        f07.put("ls07y17", bi.ls07y17.getText().toString());

        f07.put("ls07y18", bi.ls07y18a.isChecked() ? "1"
                : bi.ls07y18b.isChecked() ? "2"
                : bi.ls07y18c.isChecked() ? "3"
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
