package com.example.hassannaqvi.wfppishincr.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hassannaqvi.wfppishincr.R;
import com.example.hassannaqvi.wfppishincr.contracts.FamilyMembersContract;
import com.example.hassannaqvi.wfppishincr.contracts.FormsContract;
import com.example.hassannaqvi.wfppishincr.contracts.LHWsContract;
import com.example.hassannaqvi.wfppishincr.contracts.TehsilContract;
import com.example.hassannaqvi.wfppishincr.contracts.UCsContract;
import com.example.hassannaqvi.wfppishincr.contracts.VillagesContract;
import com.example.hassannaqvi.wfppishincr.core.DatabaseHelper;
import com.example.hassannaqvi.wfppishincr.core.MainApp;
import com.example.hassannaqvi.wfppishincr.databinding.ActivitySectionABinding;
import com.example.hassannaqvi.wfppishincr.validation.validatorClass;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SectionAActivity extends AppCompatActivity {


    ActivitySectionABinding bi;
    DatabaseHelper db;

    ArrayList<String> lablesTehsil;
    Collection<TehsilContract> TehsilList;
    Map<String, String> tehsilMap;

    ArrayList<String> lablesUCs;
    Collection<UCsContract> UcsList;
    Map<String, String> ucsMap;

    ArrayList<String> lablesVillages;
    Collection<VillagesContract> VillagesList;
    Map<String, String> VillagesMap;

    ArrayList<String> lablesLHWs;
    Collection<LHWsContract> LHWsList;
    Map<String, String> LHWsMap;
    public static ArrayList<FamilyMembersContract> pwList;

    private static final String TAG = SectionAActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_a);
        bi.setCallback(this);
        this.setTitle("Section A");
        db = new DatabaseHelper(this);
        populateSpinner(this);
        bi.cca08.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.cca08a) {
                    bi.btnContinue.setVisibility(View.VISIBLE);
                    bi.cca08x.setVisibility(View.GONE);
                    bi.cca08x.setText(null);
                    bi.btnEnd.setVisibility(View.GONE);
                } else {
                    bi.btnContinue.setVisibility(View.GONE);
                    bi.cca08x.setVisibility(View.VISIBLE);
                    bi.btnEnd.setVisibility(View.VISIBLE);
                }
            }
        });

//        Initialize PW spinner
        pwList = new ArrayList<>();

    }
    public void populateSpinner(final Context context) {

        final Context mContext = context;

        // Populate Tehsils list
        TehsilList = db.getAllTehsils();

        lablesTehsil = new ArrayList<>();
        tehsilMap = new HashMap<>();

        lablesTehsil.add("Select Tehsil..");

        for (TehsilContract taluka : TehsilList) {
            lablesTehsil.add(taluka.getTehsil_name());

            tehsilMap.put(taluka.getTehsil_name(), taluka.getTehsilcode());
        }

        bi.cca03.setAdapter(new ArrayAdapter<>(mContext, android.R.layout.simple_spinner_dropdown_item, lablesTehsil));

        bi.cca03.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // Populate UCs list

                if (bi.cca03.getSelectedItemPosition() != 0) {
                    MainApp.tehsilCode = Integer.valueOf(tehsilMap.get(bi.cca03.getSelectedItem().toString()));
                }

                lablesUCs = new ArrayList<>();
                ucsMap = new HashMap<>();
                lablesUCs.add("Select UC..");

                if (bi.cca03.getSelectedItemPosition() != 0) {
                    UcsList = db.getAllUCs(String.valueOf(MainApp.tehsilCode));
                    for (UCsContract ucs : UcsList) {
                        lablesUCs.add(ucs.getUcs());
                        ucsMap.put(ucs.getUcs(), ucs.getUccode());
                    }
                }
                bi.cca04.setAdapter(new ArrayAdapter<>(mContext, android.R.layout.simple_spinner_dropdown_item, lablesUCs));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        bi.cca04.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // Populate UCs list

                if (bi.cca04.getSelectedItemPosition() != 0) {
                    MainApp.ucCode = Integer.valueOf(ucsMap.get(bi.cca04.getSelectedItem().toString()));
                }

                lablesVillages = new ArrayList<>();
                VillagesMap = new HashMap<>();
                lablesVillages.add("Select Village..");

                VillagesList = db.getVillages(String.valueOf(MainApp.ucCode));

                if (VillagesList.size() != 0) {
                    for (VillagesContract vil : VillagesList) {
                        lablesVillages.add(vil.getVillagename());
                        VillagesMap.put(vil.getVillagename(), vil.getVillagecode());
                    }
                }

                bi.cca05.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, lablesVillages));

                lablesLHWs = new ArrayList<>();
                LHWsMap = new HashMap<>();
                lablesLHWs.add("Select LHWs..");

                LHWsList = db.getLHWs(String.valueOf(MainApp.ucCode));

                if (LHWsList.size() != 0) {
                    for (LHWsContract vil : LHWsList) {
                        lablesLHWs.add(vil.getLhwname());
                        LHWsMap.put(vil.getLhwname(), vil.getLhwcode());
                    }
                }

                bi.cca06.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, lablesLHWs));

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        bi.cca05.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (bi.cca05.getSelectedItemPosition() != 0) {
                    MainApp.villageCode = Integer.valueOf(VillagesMap.get(bi.cca05.getSelectedItem().toString()));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        bi.cca06.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (bi.cca06.getSelectedItemPosition() != 0) {
                    MainApp.lhwCode = Integer.valueOf(LHWsMap.get(bi.cca06.getSelectedItem().toString()));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
    public void BtnEnd() {

        if (formValidation()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            if (UpdateDB()) {

                MainApp.endActivity(this, this);

            }
        }



    }

    public void BtnContinue() {

        if (formValidation()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            if (UpdateDB()) {

                Intent secNext = new Intent(this, SectionBActivity.class);
                secNext.putExtra("check", false);
                startActivity(secNext);
                finish();

            }
        }


    }

    private void SaveDraft() throws JSONException {
        SharedPreferences sharedPref = getSharedPreferences("tagName", MODE_PRIVATE);
        MainApp.fc = new FormsContract();

        MainApp.fc.setDevicetagID(sharedPref.getString("tagName", null));
        MainApp.fc.setFormDate(new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime()));
        MainApp.fc.setInterviewer01(MainApp.userName);
        MainApp.fc.setInterviewer02(MainApp.userName2);
        MainApp.fc.setDeviceID(Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID));
        MainApp.fc.setAppversion(MainApp.versionName + "." + MainApp.versionCode);

        JSONObject sInfo = new JSONObject();

        sInfo.put("cca03", String.valueOf(MainApp.tehsilCode));
        sInfo.put("cca04", String.valueOf(MainApp.ucCode));
        sInfo.put("cca05", String.valueOf(MainApp.villageCode));
        sInfo.put("cca06", String.valueOf(MainApp.lhwCode));

        // sInfo.put("spbla04", spbla04.getText().toString());
        // MainApp.HHno = spbla04.getText().toString();
        sInfo.put("cca07", bi.cca07a.isChecked() ? "1" : bi.cca07b.isChecked() ? "2" : "0");


        sInfo.put("cca08", bi.cca08a.isChecked() ? "1" : bi.cca08b.isChecked() ? "2" : "0");
        sInfo.put("cca08bx", bi.cca08x.getText().toString());

        MainApp.fc.setsA(String.valueOf(sInfo));

        MainApp.setGPS(this);

    }

    private boolean UpdateDB() {

        DatabaseHelper db = new DatabaseHelper(this);

        long updcount = db.addForm(MainApp.fc);

        MainApp.fc.set_ID(String.valueOf(updcount));

        if (updcount != 0) {
            MainApp.fc.setUID(
                    (MainApp.fc.getDeviceID() + MainApp.fc.get_ID()));
            db.updateFormID();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public boolean formValidation() {

        if (bi.cca03.getSelectedItemPosition() == 0) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.cca03), Toast.LENGTH_SHORT).show();
            ((TextView) bi.cca03.getSelectedView()).setText("This Data is Required");
            ((TextView) bi.cca03.getSelectedView()).setTextColor(Color.RED);
            bi.cca03.requestFocus();
            Log.i(TAG, "cca03: This Data is Required!");
            return false;
        } else {
            ((TextView) bi.cca03.getSelectedView()).setError(null);
        }

        if (bi.cca04.getSelectedItemPosition() == 0) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.cca04), Toast.LENGTH_SHORT).show();
            ((TextView) bi.cca04.getSelectedView()).setText("This Data is Required");
            ((TextView) bi.cca04.getSelectedView()).setTextColor(Color.RED);
            bi.cca04.requestFocus();
            Log.i(TAG, "cca04: This Data is Required!");
            return false;
        } else {
            ((TextView) bi.cca04.getSelectedView()).setError(null);
        }

        if (bi.cca05.getSelectedItemPosition() == 0) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.cca05), Toast.LENGTH_SHORT).show();
            ((TextView) bi.cca05.getSelectedView()).setText("This Data is Required");
            ((TextView) bi.cca05.getSelectedView()).setTextColor(Color.RED);
            bi.cca05.requestFocus();
            Log.i(TAG, "cca05: This Data is Required!");
            return false;
        } else {
            ((TextView) bi.cca05.getSelectedView()).setError(null);
        }

        if (bi.cca06.getSelectedItemPosition() == 0) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.cca06), Toast.LENGTH_SHORT).show();
            ((TextView) bi.cca06.getSelectedView()).setText("This Data is Required");
            ((TextView) bi.cca06.getSelectedView()).setTextColor(Color.RED);
            bi.cca06.requestFocus();
            Log.i(TAG, "cca06: This Data is Required!");
            return false;
        } else {
            ((TextView) bi.cca06.getSelectedView()).setError(null);
        }
        if (!validatorClass.EmptyRadioButton(this,bi.cca07,bi.cca07a,getString(R.string.cca07))){
            return false;
        }

        if (bi.cca08.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.cca08), Toast.LENGTH_SHORT).show();
            bi.cca08a.setError("This data is Required!");
            Log.i(TAG, "cca08: This data is Required!");
            bi.cca08a.setFocusable(true);
            bi.cca08a.setFocusableInTouchMode(true);
            bi.cca08a.requestFocus();
            return false;
        } else {
            bi.cca08a.setError(null);
        }

        if(bi.cca08b.isChecked()){
            if(bi.cca08x.getText().toString().isEmpty()){
                Toast.makeText(this, "ERROR(empty): " + "وضاحت کریں", Toast.LENGTH_SHORT).show();
                bi.cca08x.setError("This data is required");
                bi.cca08x.requestFocus();
                return false;

            }else {
                bi.cca08x.setError(null);
                bi.cca08x.clearFocus();
            }
        }

        return true;
    }


}
