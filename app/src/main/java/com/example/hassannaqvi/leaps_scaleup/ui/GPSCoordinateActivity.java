package com.example.hassannaqvi.leaps_scaleup.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Settings;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.hassannaqvi.leaps_scaleup.R;
import com.example.hassannaqvi.leaps_scaleup.RMOperations.CrudOperations;
import com.example.hassannaqvi.leaps_scaleup.core.MainApp;
import com.example.hassannaqvi.leaps_scaleup.data.DAO.FormsDAO;
import com.example.hassannaqvi.leaps_scaleup.data.DAO.GetFncDAO;
import com.example.hassannaqvi.leaps_scaleup.data.entities.Clusters;
import com.example.hassannaqvi.leaps_scaleup.data.entities.FO;
import com.example.hassannaqvi.leaps_scaleup.data.entities.Forms_GPS;
import com.example.hassannaqvi.leaps_scaleup.data.entities.Participant;
import com.example.hassannaqvi.leaps_scaleup.databinding.ActivityGpsCoordinateBinding;
import com.example.hassannaqvi.leaps_scaleup.databinding.IdentifiedClusterLayoutBinding;
import com.example.hassannaqvi.leaps_scaleup.get.db.GetIndDBData;
import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static com.example.hassannaqvi.leaps_scaleup.ui.LoginActivity.db;

public class GPSCoordinateActivity extends AppCompatActivity {
    private static final String TAG = GPSCoordinateActivity.class.getName();
    public static Forms_GPS fc_gps;
    ActivityGpsCoordinateBinding bi;
    String getFtype = "", deviceID;
    String[] cluster_name;
    boolean gpsFlag = false;
    Object clusterData, partData, foData;

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

        //spinner gca03 districtName
        String[] districtName = {"....", "Naushahero Feroz", "Dadu", "Khairpur", "Sukkur"};

        bi.gca03.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Arrays.asList(districtName)));

        bi.gca05.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radiogroup, int i) {
//                bi.fldgrpls01a01.setVisibility(GONE);
                setBtnVisibility(GONE);
                Clear.clearAllFields(bi.fldGrpllGca06);
                Clear.clearAllFields(bi.fldGrpllGca07);
                Clear.clearAllFields(bi.fldGrpllGca08);
                Clear.clearAllFields(bi.fldGrpllGca09);
                Clear.clearAllFields(bi.fldGrpllGca10);
                Clear.clearAllFields(bi.fldGrpllGca11);
            }
        });

    }

    public void BtnContinue() {
        if (formValidation()) {
            try {
                saveDraft();
                if (!gpsFlag) return;
                if (updateDB()) {
                    finish();
                    startActivity(new Intent(this, EndingActivity.class).putExtra("complete", true).putExtra("fc_data", fc_gps));
                } else {
                    Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean updateDB() {

        try {

            Long longID = new CrudOperations(db, fc_gps).execute(FormsDAO.class.getName(), "formsDao", "insertForm_GPS").get();

            if (longID > 0) {
                fc_gps.setId(longID.intValue());
                fc_gps.setUid(deviceID + fc_gps.getId());

                longID = new CrudOperations(db, fc_gps).execute(FormsDAO.class.getName(), "formsDao", "updateForm_GPS").get();
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

        if (!Validator.emptyCheckingContainer(this, bi.fldgrpls01a02)) return;
        try {
            saveDraft();
            if (updateDB()) {
                Intent end_intent = new Intent(this, EndingActivity.class);
                end_intent.putExtra("complete", false);
                end_intent.putExtra("fc_data", fc_gps);
                startActivity(end_intent);
            } else {
                Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void saveDraft() throws JSONException {

        fc_gps = new Forms_GPS();

        fc_gps.setDevicetagID(MainApp.getTagName(this));
        fc_gps.setFormType(getIntent().getStringExtra("fType"));
        fc_gps.setAppversion(MainApp.versionName + "." + MainApp.versionCode);
        fc_gps.setUsername(MainApp.userName);
        fc_gps.setFormDate(new SimpleDateFormat("dd-MM-yy HH:mm", Locale.getDefault()).format(new Date().getTime()));
        fc_gps.setDeviceID(deviceID);
        setGPS(fc_gps); // Set GPS
        fc_gps.setRound(String.valueOf(MainApp.round));

        JSONObject f01 = new JSONObject();

        f01.put("gca02", bi.gca02.getText().toString());

        f01.put("gca03", bi.gca03.getSelectedItem().toString());

        f01.put("gca05", bi.gca05a.isChecked() ? "1"
                : bi.gca05b.isChecked() ? "2"
                : bi.gca05c.isChecked() ? "3"
                : bi.gca05d.isChecked() ? "4"
                : bi.gca05e.isChecked() ? "5"
                : bi.gca05f.isChecked() ? "6"
                : bi.gca05g.isChecked() ? "7"
                : "0");

//        fc_gps.setStudyID(bi.gca06.getText().toString());

        f01.put("gca06", bi.gca06.getText().toString());
        f01.put("gca06b01", bi.gca06b01.getText().toString());
        f01.put("gca06b02", bi.gca06b02.getText().toString());

        f01.put("gca07", bi.gca07.getText().toString());

        f01.put("gca08", bi.gca08.getText().toString());
        f01.put("gca08b01", bi.gca08b01.getText().toString());
        f01.put("gca08b02", bi.gca08b02.getText().toString());
        f01.put("gca08c", bi.gca08c.getText().toString());

        f01.put("gca09", bi.gca09.getText().toString());
        f01.put("gca09b", bi.gca09b.getText().toString());

        f01.put("gca10", bi.gca10.getText().toString());
        f01.put("gca10b", bi.gca10b.getText().toString());

        f01.put("gca11a01", bi.gca11a01.getText().toString());
        f01.put("gca11a02", bi.gca11a02.getText().toString());
        f01.put("gca11b", bi.gca11b.getText().toString());
        f01.put("gca11c", bi.gca11c.getText().toString());

        if (partData != null) {
            Participant part_item = (Participant) partData;
            fc_gps.setStudyID(part_item.getStudyID());
            f01.put("_luid", part_item.getPartType());
            f01.put("youthName", part_item.getPartName());
        } else if (clusterData != null) {
            Clusters cluster_item = (Clusters) clusterData;
            fc_gps.setClustercode(cluster_item.getCluster_code());
            f01.put("cluster_name", cluster_item.getCluster_name());
        }

        fc_gps.setSa1(String.valueOf(f01));

    }

    public boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.fldGrpGPSCoord01);
    }

    private void setGPS(Forms_GPS fc) {
        SharedPreferences GPSPref = getSharedPreferences("GPSCoordinates", Context.MODE_PRIVATE);
        try {
            String lat = GPSPref.getString("Latitude", "0");
            String lang = GPSPref.getString("Longitude", "0");
            String acc = GPSPref.getString("Accuracy", "0");
            String elevation = GPSPref.getString("Elevation", "0");

            if (lat.equals("0") && lang.equals("0")) {
                Toast.makeText(this, "Could not obtained GPS points", Toast.LENGTH_SHORT).show();
                gpsFlag = false;
            } else {
                Toast.makeText(this, "GPS set", Toast.LENGTH_SHORT).show();
                gpsFlag = true;
            }

            String date = DateFormat.format("dd-MM-yyyy HH:mm", Long.parseLong(GPSPref.getString("Time", "0"))).toString();

            fc.setGpsLat(lat);
            fc.setGpsLng(lang);
            fc.setGpsAcc(acc);
            fc.setGpsDT(date); // Timestamp is converted to date above
            fc.setGpsElev(elevation);

        } catch (Exception e) {
            Log.e(TAG, "setGPS: " + e.getMessage());
        }

    }

    public void BtnClusterIDValid(ViewGroup grp, View txt) {
        EditText edit = (EditText) txt;
        if (!Validator.emptyTextBox(this, edit))
            return;

        try {
            clusterData = new GetIndDBData(db, GetFncDAO.class.getName(), "getFncDao", "getClusterRecord").execute(edit.getText().toString()).get();
            if (clusterData != null) {
                cluster_name = ((Clusters) clusterData).getCluster_name().split("\\|");
                IdentifiedClusterLayoutBinding bi_c = DataBindingUtil.inflate((LayoutInflater) Objects.requireNonNull(this.getSystemService(Context.LAYOUT_INFLATER_SERVICE)), R.layout.identified_cluster_layout, grp, true);
                bi_c.ls01aDis.setText(cluster_name[0]);
                bi_c.ls01aTeh.setText(cluster_name[1]);
                bi_c.ls01aUC.setText(cluster_name[2]);
                bi_c.ls01aVil.setText(cluster_name[3]);
                setBtnVisibility(VISIBLE);
            } else {
                Toast.makeText(this, "Cluster not found", Toast.LENGTH_SHORT).show();
//                bi.fldgrpls01a01.setVisibility(GONE);
                setBtnVisibility(GONE);
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


    }

    public void BtnCYLIDValid(View txt) {
        EditText edit = (EditText) txt;
        if (!Validator.emptyTextBox(this, edit))
            return;
        try {
            partData = new GetIndDBData(db, GetFncDAO.class.getName(), "getFncDao", "getParticipantRecordFromMainDB").execute(edit.getText().toString()).get();
            if (partData != null) {
                Toast.makeText(this, "CYL ID found", Toast.LENGTH_SHORT).show();
                bi.partname.setText(String.format("Youth Name: %s", ((Participant) partData).getPartName().toUpperCase()));
                setBtnVisibility(VISIBLE);
            } else {
                Toast.makeText(this, "CYL ID not found", Toast.LENGTH_SHORT).show();
                bi.partname.setText(null);
                setBtnVisibility(GONE);
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }

    public void BtnFOIDValid(View txt) {
        EditText edit = (EditText) txt;
        if (!Validator.emptyTextBox(this, edit))
            return;
        try {
            foData = new GetIndDBData(db, GetFncDAO.class.getName(), "getFncDao", "getFORecordFromMainDB").execute(edit.getText().toString()).get();
            if (foData != null) {
                Toast.makeText(this, "FO ID found", Toast.LENGTH_SHORT).show();
                bi.foname.setText(String.format("FO Name: %s", ((FO) foData).getFname().toUpperCase()));
                setBtnVisibility(VISIBLE);
            } else {
                Toast.makeText(this, "FO ID not found", Toast.LENGTH_SHORT).show();
                bi.foname.setText(null);
                setBtnVisibility(GONE);
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }

    public void clusterIDWatch(CharSequence charSequence, int i, int i1, int i2) {
        setBtnVisibility(GONE);
        partData = null;
        clusterData = null;
        foData = null;
        bi.fldgrpgca07ll.removeAllViews();
        bi.fldgrpgca08ll.removeAllViews();
        bi.fldgrpgca10ll.removeAllViews();
    }

    private void setBtnVisibility(int view) {
        bi.endButtons.setVisibility(view);
        if (view == GONE) {
            bi.fldgrpgca07ll.removeAllViews();
            bi.fldgrpgca08ll.removeAllViews();
            bi.fldgrpgca10ll.removeAllViews();
        }
    }

}
