package com.example.hassannaqvi.wfppishincr.ui.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.hassannaqvi.wfppishincr.R;
import com.example.hassannaqvi.wfppishincr.core.DatabaseHelper;
import com.example.hassannaqvi.wfppishincr.core.MainApp;
import com.example.hassannaqvi.wfppishincr.databinding.ActivitySectionNopBinding;
import com.example.hassannaqvi.wfppishincr.validation.validatorClass;

import org.json.JSONException;
import org.json.JSONObject;

public class SectionNOPActivity extends AppCompatActivity {

    ActivitySectionNopBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_nop);
        bi.setCallback(this);

        this.setTitle("Section N,O,P");
    }

    public void BtnContinue() {

        if (formValidate()) {

            try {
                saveData();
                if (updateDb()) {
                    Intent secNext = new Intent(this, EndingActivity.class).putExtra("complete",true);
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

        int updcount = db.updateSNOP();

        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public void saveData() throws JSONException {

        JSONObject sNOP = new JSONObject();
        sNOP.put("ccn01", bi.ccn01b.isChecked() ? "1"
                : bi.ccn01c.isChecked() ? "2"
                : bi.ccn01d.isChecked() ? "3"
                : bi.ccn01e.isChecked() ? "4"
                : bi.ccn01f.isChecked() ? "5"
                : bi.ccn01g.isChecked() ? "6"
                : bi.ccn01h.isChecked() ? "7"
                : "0");
        sNOP.put("ccn02", bi.ccn02b.isChecked() ? "1"
                : bi.ccn02c.isChecked() ? "2"
                : bi.ccn02d.isChecked() ? "3"
                : bi.ccn02e.isChecked() ? "4"
                : bi.ccn02f.isChecked() ? "5"
                : bi.ccn02g.isChecked() ? "6"
                : bi.ccn02h.isChecked() ? "7"
                : "0");
        sNOP.put("ccn03", bi.ccn03b.isChecked() ? "1"
                : bi.ccn03c.isChecked() ? "2"
                : bi.ccn03d.isChecked() ? "3"
                : bi.ccn03e.isChecked() ? "4"
                : bi.ccn03f.isChecked() ? "5"
                : bi.ccn03g.isChecked() ? "6"
                : bi.ccn03h.isChecked() ? "7"
                : "0");
        sNOP.put("ccn04", bi.ccn04b.isChecked() ? "1"
                : bi.ccn04c.isChecked() ? "2"
                : bi.ccn04d.isChecked() ? "3"
                : bi.ccn04e.isChecked() ? "4"
                : bi.ccn04f.isChecked() ? "5"
                : bi.ccn04g.isChecked() ? "6"
                : bi.ccn04h.isChecked() ? "7"
                : "0");
        sNOP.put("ccn05", bi.ccn05b.isChecked() ? "1"
                : bi.ccn05c.isChecked() ? "2"
                : bi.ccn05d.isChecked() ? "3"
                : bi.ccn05e.isChecked() ? "4"
                : bi.ccn05f.isChecked() ? "5"
                : bi.ccn05g.isChecked() ? "6"
                : bi.ccn05h.isChecked() ? "7"
                : "0");



        sNOP.put("cco01", bi.cco01b.isChecked() ? "1"
                : bi.cco01c.isChecked() ? "2"
                : bi.cco01d.isChecked() ? "3"
                : "0");
        sNOP.put("cco02", bi.cco02b.isChecked() ? "1"
                : bi.cco02c.isChecked() ? "2"
                : bi.cco02d.isChecked() ? "3"
                : "0");
        sNOP.put("cco03", bi.cco03b.isChecked() ? "1"
                : bi.cco03c.isChecked() ? "2"
                : bi.cco03d.isChecked() ? "3"
                : "0");





//        1
        sNOP.put("ccp01", bi.ccp01yes.isChecked() ? "1"
                : bi.ccp01no.isChecked() ? "2"
                : "0");

        sNOP.put("ccp01b", bi.ccp01b.getText().toString());
        sNOP.put("ccp01ngo", bi.ccp01ngo.getText().toString());

//        2
        sNOP.put("ccp02", bi.ccp02yes.isChecked() ? "1"
                : bi.ccp02no.isChecked() ? "2"
                : "0");

        sNOP.put("ccp02b", bi.ccp02b.getText().toString());
        sNOP.put("ccp02ngo", bi.ccp02ngo.getText().toString());

//        3
        sNOP.put("ccp03", bi.ccp03yes.isChecked() ? "1"
                : bi.ccp03no.isChecked() ? "2"
                : "0");

        sNOP.put("ccp03b", bi.ccp03b.getText().toString());
        sNOP.put("ccp03ngo", bi.ccp03ngo.getText().toString());

//        4
        sNOP.put("ccp04", bi.ccp04yes.isChecked() ? "1"
                : bi.ccp04no.isChecked() ? "2"
                : "0");

        sNOP.put("ccp04b", bi.ccp04b.getText().toString());
        sNOP.put("ccp04ngo", bi.ccp04ngo.getText().toString());

//        5
        sNOP.put("ccp05", bi.ccp05yes.isChecked() ? "1"
                : bi.ccp05no.isChecked() ? "2"
                : "0");

        sNOP.put("ccp05b", bi.ccp05b.getText().toString());
        sNOP.put("ccp05ngo", bi.ccp05ngo.getText().toString());

//        6
        sNOP.put("ccp06", bi.ccp06yes.isChecked() ? "1"
                : bi.ccp06no.isChecked() ? "2"
                : "0");

        sNOP.put("ccp06b", bi.ccp06b.getText().toString());
        sNOP.put("ccp06ngo", bi.ccp06ngo.getText().toString());

//        7
        sNOP.put("ccp07", bi.ccp07yes.isChecked() ? "1"
                : bi.ccp07no.isChecked() ? "2"
                : "0");

        sNOP.put("ccp07b", bi.ccp07b.getText().toString());
        sNOP.put("ccp07ngo", bi.ccp07ngo.getText().toString());

//        8
        sNOP.put("ccp08", bi.ccp08yes.isChecked() ? "1"
                : bi.ccp08no.isChecked() ? "2"
                : "0");

        sNOP.put("ccp08b", bi.ccp08b.getText().toString());
        sNOP.put("ccp08ngo", bi.ccp08ngo.getText().toString());

//        9
        sNOP.put("ccp09", bi.ccp09yes.isChecked() ? "1"
                : bi.ccp09no.isChecked() ? "2"
                : "0");

        sNOP.put("ccp09b", bi.ccp09b.getText().toString());
        sNOP.put("ccp09ngo", bi.ccp09ngo.getText().toString());

//        10
        sNOP.put("ccp10", bi.ccp10yes.isChecked() ? "1"
                : bi.ccp10no.isChecked() ? "2"
                : "0");

        sNOP.put("ccp10b", bi.ccp10b.getText().toString());
        sNOP.put("ccp10ngo", bi.ccp10ngo.getText().toString());

//        11
        sNOP.put("ccp11", bi.ccp11yes.isChecked() ? "1"
                : bi.ccp11no.isChecked() ? "2"
                : "0");

        sNOP.put("ccp11b", bi.ccp11b.getText().toString());
        sNOP.put("ccp11ngo", bi.ccp11ngo.getText().toString());

//        12
        sNOP.put("ccp12", bi.ccp12yes.isChecked() ? "1"
                : bi.ccp12no.isChecked() ? "2"
                : "0");

        sNOP.put("ccp1296x", bi.ccp1296x.getText().toString());
        sNOP.put("ccp12b", bi.ccp12b.getText().toString());
        sNOP.put("ccp12ngo", bi.ccp12ngo.getText().toString());


        MainApp.fc.setsNOP(String.valueOf(sNOP));
        Toast.makeText(this, "Validation Successful", Toast.LENGTH_SHORT).show();
    }

    private boolean formValidate() {

        if (!validatorClass.EmptyRadioButton(this, bi.ccn01, bi.ccn01a, getString(R.string.ccn01))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ccn02, bi.ccn02a, getString(R.string.ccn02))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ccn03, bi.ccn03a, getString(R.string.ccn03))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ccn04, bi.ccn04a, getString(R.string.ccn04))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ccn05, bi.ccn05a, getString(R.string.ccn05))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.cco01, bi.cco01a, getString(R.string.cco01))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.cco02, bi.cco02a, getString(R.string.cco02))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.cco03, bi.cco03a, getString(R.string.cco03))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.ccp01, bi.ccp01no, getString(R.string.ccp01))) {
            return false;
        }
        if (bi.ccp01yes.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.ccp01b, getString(R.string.ccp01b))) {
                return false;
            }
            if (!validatorClass.EmptyTextBox(this, bi.ccp01ngo, getString(R.string.ccp01ngo))) {
                return false;
            }
        }

        if (!validatorClass.EmptyRadioButton(this, bi.ccp02, bi.ccp02yes, getString(R.string.ccp02))) {
            return false;
        }
        if (bi.ccp02yes.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.ccp02b, getString(R.string.ccp01b))) {
                return false;
            }
            if (!validatorClass.EmptyTextBox(this, bi.ccp02ngo, getString(R.string.ccp01ngo))) {
                return false;
            }
        }

        if (!validatorClass.EmptyRadioButton(this, bi.ccp03, bi.ccp03no, getString(R.string.ccp01))) {
            return false;
        }
        if (bi.ccp03yes.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.ccp03b, getString(R.string.ccp01b))) {
                return false;
            }
            if (!validatorClass.EmptyTextBox(this, bi.ccp03ngo, getString(R.string.ccp01ngo))) {
                return false;
            }
        }

        if (!validatorClass.EmptyRadioButton(this, bi.ccp04, bi.ccp04no, getString(R.string.ccp01))) {
            return false;
        }
        if (bi.ccp04yes.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.ccp04b, getString(R.string.ccp01b))) {
                return false;
            }
            if (!validatorClass.EmptyTextBox(this, bi.ccp04ngo, getString(R.string.ccp01ngo))) {
                return false;
            }
        }

        if (!validatorClass.EmptyRadioButton(this, bi.ccp05, bi.ccp05no, getString(R.string.ccp01))) {
            return false;
        }
        if (bi.ccp05yes.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.ccp05b, getString(R.string.ccp01b))) {
                return false;
            }
            if (!validatorClass.EmptyTextBox(this, bi.ccp05ngo, getString(R.string.ccp01ngo))) {
                return false;
            }
        }

        if (!validatorClass.EmptyRadioButton(this, bi.ccp06, bi.ccp06no, getString(R.string.ccp01))) {
            return false;
        }
        if (bi.ccp06yes.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.ccp06b, getString(R.string.ccp01b))) {
                return false;
            }
            if (!validatorClass.EmptyTextBox(this, bi.ccp06ngo, getString(R.string.ccp01ngo))) {
                return false;
            }
        }

        if (!validatorClass.EmptyRadioButton(this, bi.ccp07, bi.ccp07no, getString(R.string.ccp01))) {
            return false;
        }
        if (bi.ccp07yes.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.ccp07b, getString(R.string.ccp01b))) {
                return false;
            }
            if (!validatorClass.EmptyTextBox(this, bi.ccp07ngo, getString(R.string.ccp01ngo))) {
                return false;
            }
        }

        if (!validatorClass.EmptyRadioButton(this, bi.ccp08, bi.ccp08no, getString(R.string.ccp01))) {
            return false;
        }
        if (bi.ccp08yes.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.ccp08b, getString(R.string.ccp01b))) {
                return false;
            }
            if (!validatorClass.EmptyTextBox(this, bi.ccp08ngo, getString(R.string.ccp01ngo))) {
                return false;
            }
        }

        if (!validatorClass.EmptyRadioButton(this, bi.ccp09, bi.ccp09no, getString(R.string.ccp01))) {
            return false;
        }
        if (bi.ccp09yes.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.ccp09b, getString(R.string.ccp01b))) {
                return false;
            }
            if (!validatorClass.EmptyTextBox(this, bi.ccp09ngo, getString(R.string.ccp01ngo))) {
                return false;
            }
        }

        if (!validatorClass.EmptyRadioButton(this, bi.ccp10, bi.ccp10no, getString(R.string.ccp01))) {
            return false;
        }
        if (bi.ccp10yes.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.ccp10b, getString(R.string.ccp01b))) {
                return false;
            }
            if (!validatorClass.EmptyTextBox(this, bi.ccp10ngo, getString(R.string.ccp01ngo))) {
                return false;
            }
        }

        if (!validatorClass.EmptyRadioButton(this, bi.ccp11, bi.ccp11no, getString(R.string.ccp01))) {
            return false;
        }
        if (bi.ccp11yes.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.ccp11b, getString(R.string.ccp01b))) {
                return false;
            }
            if (!validatorClass.EmptyTextBox(this, bi.ccp11ngo, getString(R.string.ccp01ngo))) {
                return false;
            }
        }

        if (!validatorClass.EmptyRadioButton(this, bi.ccp12, bi.ccp12no, getString(R.string.ccp01))) {
            return false;
        }
        if (bi.ccp12yes.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.ccp12b, getString(R.string.ccp01b))) {
                return false;
            }
            return validatorClass.EmptyTextBox(this, bi.ccp12ngo, getString(R.string.ccp01ngo));
        }


        return true;
    }

    public void BtnEnd() {

        MainApp.endActivity(this, this);

    }
}
