package com.example.hassannaqvi.wfppishincr.ui.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.hassannaqvi.wfppishincr.R;
import com.example.hassannaqvi.wfppishincr.core.DatabaseHelper;
import com.example.hassannaqvi.wfppishincr.core.MainApp;
import com.example.hassannaqvi.wfppishincr.databinding.ActivitySectionLBinding;
import com.example.hassannaqvi.wfppishincr.validation.ClearClass;
import com.example.hassannaqvi.wfppishincr.validation.validatorClass;

import org.json.JSONException;
import org.json.JSONObject;

public class SectionLActivity extends AppCompatActivity {

    ActivitySectionLBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_l);
        bi.setCallback(this);

        this.setTitle("Section L");


        //============================skip patterns==============================================

        bi.ccl01.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.ccl01b || i == R.id.ccl01c || i == R.id.ccl01d) {
                    bi.fldgrpccl02.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrpccl02, false);
                    bi.fldgrpccl03.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrpccl03, false);
                } else {
                    bi.fldgrpccl02.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccl02, true);
                    bi.fldgrpccl03.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccl03, true);
                }
            }
        });

        bi.ccl04.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.ccl04b) {
                    bi.fldgrpccl05.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrpccl05, false);
                } else {
                    bi.fldgrpccl05.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccl05, true);
                }
            }
        });


    }

    public void BtnContinue() {

        if (formValidate()) {

            try {
                saveData();
                if (updateDb()) {
                    Intent secNext = new Intent(this, SectionMActivity.class);
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

        int updcount = db.updateSL();

        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public void saveData() throws JSONException {

        JSONObject sL = new JSONObject();
        sL.put("ccl01", bi.ccl01a.isChecked() ? "1" : bi.ccl01b.isChecked() ? "2" : bi.ccl01c.isChecked() ? "3"
                : bi.ccl0196.isChecked() ? "96" : "0");
        sL.put("ccl0196x", bi.ccl0196x.getText().toString());
        sL.put("ccl02", bi.ccl02a.isChecked() ? "1" : bi.ccl02b.isChecked() ? "2" : "0");
        sL.put("ccl03a", bi.ccl03a.isChecked() ? "1" : "0");
        sL.put("ccl03b", bi.ccl03b.isChecked() ? "2" : "0");
        sL.put("ccl03c", bi.ccl03c.isChecked() ? "3" : "0");
        sL.put("ccl03d", bi.ccl03d.isChecked() ? "4" : "0");
        sL.put("ccl03e", bi.ccl0397.isChecked() ? "5" : "0");
        sL.put("ccl04", bi.ccl04a.isChecked() ? "1" : bi.ccl04b.isChecked() ? "2" : "0");
        sL.put("ccl05a", bi.ccl05a.isChecked() ? "1" : "0");
        sL.put("ccl05b", bi.ccl05b.isChecked() ? "2" : "0");
        sL.put("ccl05c", bi.ccl05c.isChecked() ? "3" : "0");
        sL.put("ccl05d", bi.ccl05d.isChecked() ? "4" : "0");
        sL.put("ccl05e", bi.ccl0597.isChecked() ? "5" : "0");
        sL.put("ccl06a", bi.ccl06a.isChecked() ? "1" : "0");
        sL.put("ccl06b", bi.ccl06b.isChecked() ? "2" : "0");
        sL.put("ccl06c", bi.ccl06c.isChecked() ? "3" : "0");
        sL.put("ccl06d", bi.ccl06d.isChecked() ? "4" : "0");
        sL.put("ccl06e", bi.ccl06e.isChecked() ? "5" : "0");
        sL.put("ccl06f", bi.ccl06f.isChecked() ? "6" : "0");
        sL.put("ccl06g", bi.ccl06g.isChecked() ? "7" : "0");
        sL.put("ccl06h", bi.ccl06h.isChecked() ? "8" : "0");
        sL.put("ccl06i", bi.ccl06i.isChecked() ? "9" : "0");
        sL.put("ccl0696", bi.ccl0696.isChecked() ? "96" : "0");
        sL.put("ccl0696x", bi.ccl0696x.getText().toString());
        MainApp.fc.setsL(String.valueOf(sL));
        Toast.makeText(this, "Validation Successful", Toast.LENGTH_SHORT).show();

    }


    private boolean formValidate() {

        if (!validatorClass.EmptyRadioButton(this, bi.ccl01, bi.ccl01a, getString(R.string.ccl01))) {
            return false;
        }

        if (bi.ccl01a.isChecked()) {

            if (!validatorClass.EmptyRadioButton(this, bi.ccl02, bi.ccl02a, getString(R.string.ccl02))) {
                return false;
            }
            if (!validatorClass.EmptyCheckBox(this, bi.ccl03, bi.ccl03a, getString(R.string.ccl03))) {
                return false;
            }
        }
        if (bi.ccl0196.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.ccl0196x, getString(R.string.ccl01))) {
                return false;
            }
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ccl04, bi.ccl04a, getString(R.string.ccl04))) {
            return false;
        }

        if (bi.ccl04a.isChecked()) {
            if (!validatorClass.EmptyCheckBox(this, bi.ccl05, bi.ccl05a, getString(R.string.ccl05))) {
                return false;
            }
        }

        if (!validatorClass.EmptyCheckBox(this, bi.ccl06, bi.ccl06a, getString(R.string.ccl06))) {
            return false;
        }

        if (bi.ccl0696.isChecked()) {
            return validatorClass.EmptyTextBox(this, bi.ccl0696x, getString(R.string.ccl06));
        }


        return true;
    }

    public void BtnEnd() {
        MainApp.endActivity(this, this);


    }
}
