package com.example.hassannaqvi.wfppishincr.ui.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.hassannaqvi.wfppishincr.R;
import com.example.hassannaqvi.wfppishincr.core.DatabaseHelper;
import com.example.hassannaqvi.wfppishincr.core.MainApp;
import com.example.hassannaqvi.wfppishincr.databinding.ActivitySectionCBinding;
import com.example.hassannaqvi.wfppishincr.validation.ClearClass;

import org.json.JSONException;
import org.json.JSONObject;

public class SectionCActivity extends AppCompatActivity {

    private static final String TAG = "SectionCActivity";

    ActivitySectionCBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setTitle("Section C");

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_c);
        bi.setCallback(this);
        bi.ccc04d.setManager(getSupportFragmentManager());

        bi.ccc08.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.ccc08b || i == R.id.ccc0898) {
                    ClearClass.ClearAllFields(bi.fldgrpccc09, false);

                } else {
                    ClearClass.ClearAllFields(bi.fldgrpccc09, true);

                }
            }
        });
    }

    public void BtnContinue() {

        if (formValidate()) {

            try {
                saveData();
                if (updateDb()) {
                    Intent secNext = new Intent(this, SectionDEFActivity.class);
                    secNext.putExtra("check", false);
                    startActivity(secNext);
                    finish();
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }


    }

    public boolean updateDb() {
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSC();

        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }

    private void saveData() throws JSONException {

        JSONObject sC = new JSONObject();

        sC.put("ccc01", bi.ccc01.getText().toString());
        sC.put("ccc02", bi.ccc02.getText().toString());
        sC.put("ccc03", bi.ccc03a.isChecked() ? "1" : bi.ccc03b.isChecked() ? "2" : "0");
        sC.put("ccc04", bi.ccc04d.getText().toString());
        sC.put("ccc05m", bi.ccc05m.getText().toString());
        sC.put("ccc05d", bi.ccc05d.getText().toString());
        sC.put("ccc06", bi.ccc06a.isChecked() ? "1" : bi.ccc06b.isChecked() ? "2" : "0");
        sC.put("ccc07", bi.ccc07w.getText().toString());
        sC.put("ccc08", bi.ccc08a.isChecked() ? "1" : bi.ccc08b.isChecked() ? "2" : bi.ccc0898.isChecked() ? "98" : "0");
        sC.put("ccc09", bi.ccc0998.isChecked() ? "98" : "0");
        sC.put("ccc09kg", bi.ccc09kg.getText().toString());
        MainApp.fc.setsC(String.valueOf(sC));
        Toast.makeText(this, "Validation Successful", Toast.LENGTH_SHORT).show();

    }

    private boolean formValidate() {
//        Toast.makeText(this, "Validating this section..", Toast.LENGTH_SHORT).show();
//        if (!validatorClass.EmptyTextBox(this, bi.ccc01, getString(R.string.cca01))) {
//            return false;
//        }
//
//        if (!validatorClass.EmptyTextBox(this, bi.ccc02, getString(R.string.cca02))) {
//            return false;
//        }
//
//        if (!validatorClass.EmptyRadioButton(this, bi.ccc03, bi.ccc03a, getString(R.string.cca03))) {
//            return false;
//        }
//        if (!validatorClass.EmptyTextBox(this, bi.ccc04d, getString(R.string.cca04))) {
//            return false;
//        }
//        if (!validatorClass.EmptyTextBox(this, bi.ccc05m, getString(R.string.cca05))) {
//            return false;
//        }
//        if (!validatorClass.EmptyTextBox(this, bi.ccc05d, getString(R.string.cca05))) {
//            return false;
//        }
//        if (!validatorClass.EmptyRadioButton(this, bi.ccc06, bi.ccc06a, getString(R.string.cca06))) {
//            return false;
//        }
//
//        if (!validatorClass.EmptyTextBox(this, bi.ccc07w, getString(R.string.cca07))) {
//            return false;
//        }
//
//        if (!validatorClass.EmptyRadioButton(this, bi.ccc08, bi.ccc08a, getString(R.string.cca08))) {
//            return false;
//        }
//
//        if (bi.ccc08a.isChecked()) {
//            if (!bi.ccc0998.isChecked()) {
//                return validatorClass.EmptyTextBox(this, bi.ccc09kg, getString(R.string.ccc09));
//            }
//        }


        return true;
    }

    public void BtnEnd() {

        MainApp.endActivity(this, this);


    }
}
