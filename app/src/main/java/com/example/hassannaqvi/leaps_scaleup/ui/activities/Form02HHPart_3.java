package com.example.hassannaqvi.leaps_scaleup.ui.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.hassannaqvi.leaps_scaleup.R;
import com.example.hassannaqvi.leaps_scaleup.RMOperations.crudOperations;
import com.example.hassannaqvi.leaps_scaleup.data.DAO.FormsDAO;
import com.example.hassannaqvi.leaps_scaleup.databinding.ActivityForm02Hhpart3Binding;
import com.example.hassannaqvi.leaps_scaleup.validation.ClearClass;
import com.example.hassannaqvi.leaps_scaleup.validation.validatorClass;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

import static com.example.hassannaqvi.leaps_scaleup.ui.activities.LoginActivity.db;

public class Form02HHPart_3 extends AppCompatActivity {

    ActivityForm02Hhpart3Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_form02_hhpart_3);
        bi.setCallback(this);

        this.setTitle(R.string.ls02eeheading);

        setupViews();
    }

    private void setupViews() {


        bi.ls02ee01b.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.ls02ee01b01) {
                    bi.fldgrpee03.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrpee03, false);
                } else {
                    bi.fldgrpee03.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrpee03, true);
                }
            }
        });

        bi.ls02ee12.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.ls02ee12b) {

                    bi.fldgrpee16.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrpee16, false);

                } else {
                    bi.fldgrpee16.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrpee16, true);
                }
            }
        });

        bi.ls02ee06.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.ls02ee06b) {

                    bi.fldgrpee10.setVisibility(View.GONE);
                    bi.fldgrpee11.setVisibility(View.GONE);
                    bi.fldgrpee12.setVisibility(View.GONE);
                    bi.fldgrpee13.setVisibility(View.GONE);
                    bi.fldgrpee14.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrpee10, false);
                    ClearClass.ClearAllCardFields(bi.fldgrpee11, false);
                    ClearClass.ClearAllCardFields(bi.fldgrpee12, false);
                    ClearClass.ClearAllCardFields(bi.fldgrpee13, false);
                    ClearClass.ClearAllCardFields(bi.fldgrpee14, false);
                } else {
                    bi.fldgrpee10.setVisibility(View.VISIBLE);
                    bi.fldgrpee11.setVisibility(View.VISIBLE);
                    bi.fldgrpee12.setVisibility(View.VISIBLE);
                    bi.fldgrpee13.setVisibility(View.VISIBLE);
                    bi.fldgrpee14.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrpee10, true);
                    ClearClass.ClearAllCardFields(bi.fldgrpee11, true);
                    ClearClass.ClearAllCardFields(bi.fldgrpee12, true);
                    ClearClass.ClearAllCardFields(bi.fldgrpee13, true);
                    ClearClass.ClearAllCardFields(bi.fldgrpee14, true);
                }
            }
        });
    }

    public void BtnContinue() {
        if (formValidation()) {
            try {
                SaveDraft();
                if (UpdateDB()) {
                    startActivity(new Intent(getApplicationContext(), EndingActivity.class)
                            .putExtra("complete", true));
                } else {
                    Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean UpdateDB() {
        try {

            Long longID = new crudOperations(db, Form01Enrolment.fc_4_5).execute(FormsDAO.class.getName(), "formsDao", "updateForm_04_05").get();
            return longID == 1;

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return false;
    }

    private void SaveDraft() throws JSONException {

        JSONObject sH3 = new JSONObject();

        sH3.put("lsee01", bi.ls02ee01a01.isChecked() ? "1" : bi.ls02ee01a02.isChecked() ? "2" : "0");
        sH3.put("lsee02", bi.ls02ee01b01.isChecked() ? "1" : bi.ls02ee01b02.isChecked() ? "1" : "0");

        sH3.put("lsee03", bi.ls02ee01c01.isChecked() ? "1"
                : bi.ls02ee01c02.isChecked() ? "2"
                : bi.ls02ee01c03.isChecked() ? "3"
                : bi.ls02ee01c04.isChecked() ? "4"
                : bi.ls02ee01c05.isChecked() ? "5"
                : bi.ls02ee01c96.isChecked() ? "96"
                : "0");
        sH3.put("lsee0396x", bi.ls02ee01c96x.getText().toString());
        sH3.put("lsee04", bi.ls02ee02.getText().toString());

        sH3.put("lsee05", bi.ls02ee03a01.isChecked() ? "1"
                : bi.ls02ee03a02.isChecked() ? "2"
                : "0");

        sH3.put("lsee06", bi.ls02ee03b01.isChecked() ? "1"
                : bi.ls02ee03b02.isChecked() ? "2"
                : "0");

        sH3.put("lsee07", bi.ls02ee04.getText().toString());

        sH3.put("lsee08", bi.ls02ee05a.isChecked() ? "1"
                : bi.ls02ee05b.isChecked() ? "2"
                : bi.ls02ee05c.isChecked() ? "3"
                : bi.ls02ee05d.isChecked() ? "4"
                : bi.ls02ee05e.isChecked() ? "5"
                : bi.ls02ee05f.isChecked() ? "6"
                : bi.ls02ee05g.isChecked() ? "7"
                : bi.ls02ee05h.isChecked() ? "8"
                : bi.ls02ee05i.isChecked() ? "9"
                : bi.ls02ee05j.isChecked() ? "10"
                : bi.ls02ee0596.isChecked() ? "96"
                : bi.ls02ee0599.isChecked() ? "97"
                : "0");

        sH3.put("lsee0896x", bi.ls02ee0596x.getText().toString());
        sH3.put("lsee09", bi.ls02ee06a.isChecked() ? "1" : bi.ls02ee06b.isChecked() ? "2" : "0");
        sH3.put("lsee10", bi.ls02ee07a.isChecked() ? "1" : bi.ls02ee07b.isChecked() ? "2" : "0");

        sH3.put("lsee11", bi.ls02ee08.getText().toString());

        sH3.put("lsee12", bi.ls02ee09a.isChecked() ? "1"
                : bi.ls02ee09b.isChecked() ? "2"
                : bi.ls02ee09c.isChecked() ? "3"
                : bi.ls02ee09d.isChecked() ? "4"
                : bi.ls02ee09e.isChecked() ? "5"
                : bi.ls02ee09f.isChecked() ? "6"
                : bi.ls02ee09g.isChecked() ? "7"
                : bi.ls02ee09h.isChecked() ? "8"
                : bi.ls02ee09i.isChecked() ? "9"
                : bi.ls02ee09j.isChecked() ? "10"
                : bi.ls02ee09j.isChecked() ? "11"
                : bi.ls02ee09k.isChecked() ? "12"
                : bi.ls02ee09l.isChecked() ? "13"
                : bi.ls02ee09m.isChecked() ? "14"
                : bi.ls02ee0996.isChecked() ? "96"
                : bi.ls02ee0997.isChecked() ? "97"
                : "0");
        sH3.put("lsee1296x", bi.ls02ee0996x.getText().toString());

        sH3.put("lsee13", bi.ls02ee10a.isChecked() ? "1" : bi.ls02ee10b.isChecked() ? "2" : "0");

        sH3.put("lsee14", bi.ls02ee11a.isChecked() ? "1" : bi.ls02ee11b.isChecked() ? "2" : "0");
        sH3.put("lsee15", bi.ls02ee12a.isChecked() ? "1" : bi.ls02ee12b.isChecked() ? "2" : "0");
        sH3.put("lsee16", bi.ls02ee13a.isChecked() ? "1"
                : bi.ls02ee13b.isChecked() ? "2"
                : bi.ls02ee13c.isChecked() ? "3"
                : "0");

        sH3.put("lsee17", bi.ls02ee14.getText().toString());
        sH3.put("lsee18", bi.ls02ee15.getText().toString());

        Form01Enrolment.fc_4_5.setSa4(String.valueOf(sH3));
    }

    private boolean formValidation() {

        if (!validatorClass.EmptyRadioButton(this, bi.ls02ee01a, bi.ls02ee01a01, getString(R.string.ls02ee01a))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls02ee01b, bi.ls02ee01b01, getString(R.string.ls02ee01b))) {
            return false;
        }
        if (bi.ls02ee01b02.isChecked()) {
            if (!validatorClass.EmptyRadioButton(this, bi.ls02ee01c, bi.ls02ee01c01, getString(R.string.ls02ee01c))) {
                return false;
            }
            if (bi.ls02ee01c96.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.ls02ee01c96x, getString(R.string.ls02ee01c))) {
                    return false;
                }
            }
        }
        if (!validatorClass.EmptyTextBox(this, bi.ls02ee02, getString(R.string.ls02ee02))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls02ee03a, bi.ls02ee03a01, getString(R.string.ls02ee03a))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls02ee03b, bi.ls02ee03b01, getString(R.string.ls02ee03b))) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.ls02ee04, getString(R.string.ls02ee04))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.ls02ee05, bi.ls02ee05a, getString(R.string.ls02ee05))) {
            return false;
        }

        if (bi.ls02ee0596.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.ls02ee0596x, getString(R.string.ls02ee05))) {
                return false;
            }
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls02ee06, bi.ls02ee06a, getString(R.string.ls02ee06))) {
            return false;
        }
        if (bi.ls02ee06a.isChecked()) {
            if (!validatorClass.EmptyRadioButton(this, bi.ls02ee07, bi.ls02ee07a, getString(R.string.ls02ee07))) {
                return false;
            }
            if (!validatorClass.EmptyTextBox(this, bi.ls02ee08, getString(R.string.ls02ee08))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.ls02ee09, bi.ls02ee09a, getString(R.string.ls02ee09))) {
                return false;
            }
            if (bi.ls02ee0996.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.ls02ee0996x, getString(R.string.ls02ee09))) {
                    return false;
                }
            }
            if (!validatorClass.EmptyRadioButton(this, bi.ls02ee10, bi.ls02ee10a, getString(R.string.ls02ee10))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.ls02ee11, bi.ls02ee11a, getString(R.string.ls02ee11))) {
                return false;
            }
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls02ee12, bi.ls02ee12a, getString(R.string.ls02ee12))) {
            return false;
        }
        if (bi.ls02ee12a.isChecked()) {
            if (!validatorClass.EmptyRadioButton(this, bi.ls02ee13, bi.ls02ee13a, getString(R.string.ls02ee13))) {
                return false;
            }
        }
        if (!validatorClass.EmptyTextBox(this, bi.ls02ee14, getString(R.string.ls02ee14))) {
            return false;
        }
        return validatorClass.EmptyTextBox(this, bi.ls02ee15, getString(R.string.ls02ee15));
    }

    public void BtnEnd() {
        startActivity(new Intent(getApplicationContext(), EndingActivity.class).putExtra("complete", false));
    }

    @Override
    public void onBackPressed() {

        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }
}
