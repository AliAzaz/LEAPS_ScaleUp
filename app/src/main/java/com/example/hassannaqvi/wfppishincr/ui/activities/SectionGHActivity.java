package com.example.hassannaqvi.wfppishincr.ui.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.hassannaqvi.wfppishincr.R;
import com.example.hassannaqvi.wfppishincr.core.DatabaseHelper;
import com.example.hassannaqvi.wfppishincr.core.MainApp;
import com.example.hassannaqvi.wfppishincr.databinding.ActivitySectionGHBinding;
import com.example.hassannaqvi.wfppishincr.validation.ClearClass;
import com.example.hassannaqvi.wfppishincr.validation.validatorClass;

import org.json.JSONException;
import org.json.JSONObject;

public class SectionGHActivity extends AppCompatActivity {

    ActivitySectionGHBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_g_h);
        bi.setCallback(this);

        this.setTitle("Section G,H");


        //==============skip patterns==================

        bi.ccg0197.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

                if (isChecked) {
                    bi.fldgrpccg002.setVisibility(View.GONE);
                    bi.ccg0101.clearCheck();
                    bi.ccg0102.clearCheck();
                    bi.ccg0103.clearCheck();
                    bi.ccg0104.clearCheck();
                    bi.ccg0105.clearCheck();
                    bi.ccg0106.clearCheck();
                    bi.ccg0107.clearCheck();
                    bi.ccg0108.clearCheck();
                    bi.ccg0196x.setText(null);
                } else {
                    bi.fldgrpccg002.setVisibility(View.VISIBLE);

                }
            }
        });

        bi.ccg0101.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.ccg0101a || i == R.id.ccg0101b) {
                    bi.ccg0197.setChecked(false);
                    //  bi.fldgrpccg002.setVisibility(View.VISIBLE);
                } else {
                    bi.ccg0197.setChecked(true);
                }
            }
        });

        bi.ccg0102.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.ccg0102a || i == R.id.ccg0102b) {
                    bi.ccg0197.setChecked(false);
                    // bi.fldgrpccg002.setVisibility(View.VISIBLE);
                } else {
                    bi.ccg0197.setChecked(true);
                }
            }
        });
        bi.ccg0103.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.ccg0103a || i == R.id.ccg0103b) {
                    bi.ccg0197.setChecked(false);
                    //  bi.fldgrpccg002.setVisibility(View.VISIBLE);
                } else {
                    bi.ccg0197.setChecked(true);
                }
            }
        });
        bi.ccg0104.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.ccg0104a || i == R.id.ccg0104b) {
                    bi.ccg0197.setChecked(false);
                    // bi.fldgrpccg002.setVisibility(View.VISIBLE);
                } else {
                    bi.ccg0197.setChecked(true);
                }
            }
        });
        bi.ccg0105.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.ccg0105a || i == R.id.ccg0105b) {
                    bi.ccg0197.setChecked(false);
                    // bi.fldgrpccg002.setVisibility(View.VISIBLE);
                } else {
                    bi.ccg0197.setChecked(true);
                }
            }
        });
        bi.ccg0106.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.ccg0106a || i == R.id.ccg0106b) {
                    bi.ccg0197.setChecked(false);
                    // bi.fldgrpccg002.setVisibility(View.VISIBLE);
                } else {
                    bi.ccg0197.setChecked(true);
                }
            }
        });
        bi.ccg0107.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.ccg0107a || i == R.id.ccg0107b) {
                    bi.ccg0197.setChecked(false);
                    //bi.fldgrpccg002.setVisibility(View.VISIBLE);
                } else {
                    bi.ccg0197.setChecked(true);
                }
            }
        });
        bi.ccg0108.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.ccg0108a || i == R.id.ccg0108b) {
                    bi.ccg0197.setChecked(false);
                    //bi.fldgrpccg002.setVisibility(View.VISIBLE);
                } else {
                    bi.ccg0197.setChecked(true);
                }
            }
        });

        bi.ccg02.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.ccg02a) {
                    bi.fldgrpccg03.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccg03, true);

                } else {
                    bi.fldgrpccg03.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrpccg03, false);
                }
            }
        });

        bi.cch01.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.cch01a) {

                    bi.fldgrpcch02.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpcch02, true);
                } else {
                    bi.fldgrpcch02.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrpcch02, false);
                }
            }
        });
    }

    public boolean updateDb() {
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSGH();

        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public void BtnContinue() {

        if (formValidate()) {

            try {
                saveData();
                if (updateDb()) {
                    Intent secNext = new Intent(this, SectionIActivity.class);
                    secNext.putExtra("check", false);
                    startActivity(secNext);
                    finish();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }


    }

    private void saveData() throws JSONException {

        JSONObject sGH = new JSONObject();

        sGH.put("ccg01a", bi.ccg0101a.isChecked() ? "1" : bi.ccg0101b.isChecked() ? "2" : "0");
        sGH.put("ccg01b", bi.ccg0102a.isChecked() ? "1" : bi.ccg0102b.isChecked() ? "2" : "0");
        sGH.put("ccg01c", bi.ccg0103a.isChecked() ? "1" : bi.ccg0103b.isChecked() ? "2" : "0");
        sGH.put("ccg01d", bi.ccg0104a.isChecked() ? "1" : bi.ccg0104b.isChecked() ? "2" : "0");
        sGH.put("ccg01e", bi.ccg0105a.isChecked() ? "1" : bi.ccg0105b.isChecked() ? "2" : "0");
        sGH.put("ccg01f", bi.ccg0106a.isChecked() ? "1" : bi.ccg0106b.isChecked() ? "2" : "0");
        sGH.put("ccg01g", bi.ccg0107a.isChecked() ? "1" : bi.ccg0107b.isChecked() ? "2" : "0");
        sGH.put("ccg01h", bi.ccg0108a.isChecked() ? "1" : bi.ccg0108b.isChecked() ? "2" : "0");
        sGH.put("ccg0196", bi.ccg0196x.getText().toString());
        sGH.put("ccg0197", bi.ccg0197.isChecked() ? "97" : "0");

        sGH.put("ccg02", bi.ccg02a.isChecked() ? "1" : bi.ccg02b.isChecked() ? "2" : "0");
        sGH.put("ccg03", bi.ccg03a.isChecked() ? "1" : bi.ccg03b.isChecked() ? "2" : bi.ccg03c.isChecked() ? "3" : bi.ccg03d.isChecked() ? "4" : bi.ccg03e.isChecked() ? "5" : bi.ccg03f.isChecked() ? "6" : bi.ccg03g.isChecked() ? "7" : bi.ccg03h.isChecked() ? "8" : bi.ccg0396.isChecked() ? "96" : "0");
        sGH.put("ccg0396", bi.ccg0396x.getText().toString());

        sGH.put("cch01", bi.cch01a.isChecked() ? "1" : bi.cch01b.isChecked() ? "2" : "0");
        sGH.put("cchbcg", bi.cch0201a.isChecked() ? "1" : bi.cch0201b.isChecked() ? "2" : bi.cch0201c.isChecked() ? "3" : "0");
        sGH.put("cchopvq", bi.cch0202a.isChecked() ? "1" : bi.cch0202b.isChecked() ? "2" : bi.cch0202c.isChecked() ? "3" : "0");

        sGH.put("cchp1", bi.cch0301a.isChecked() ? "1" : bi.cch0301b.isChecked() ? "2" : bi.cch0301c.isChecked() ? "3" : "0");
        sGH.put("cchpcv1", bi.cch0302a.isChecked() ? "1" : bi.cch0302b.isChecked() ? "2" : bi.cch0302c.isChecked() ? "3" : "0");
        sGH.put("cchopv1", bi.cch0303a.isChecked() ? "1" : bi.cch0303b.isChecked() ? "2" : bi.cch0303c.isChecked() ? "3" : "0");

        sGH.put("cchp2", bi.cch0401a.isChecked() ? "1" : bi.cch0401b.isChecked() ? "2" : bi.cch0401c.isChecked() ? "3" : "0");
        sGH.put("cchpcv2", bi.cch0402a.isChecked() ? "1" : bi.cch0402b.isChecked() ? "2" : bi.cch0402c.isChecked() ? "3" : "0");
        sGH.put("cchopv2", bi.cch0403a.isChecked() ? "1" : bi.cch0403b.isChecked() ? "2" : bi.cch0403c.isChecked() ? "3" : "0");

        sGH.put("cchp3", bi.cch0501a.isChecked() ? "1" : bi.cch0501b.isChecked() ? "2" : bi.cch0501c.isChecked() ? "3" : "0");
        sGH.put("cchpcv3", bi.cch0502a.isChecked() ? "1" : bi.cch0502b.isChecked() ? "2" : bi.cch0502c.isChecked() ? "3" : "0");
        sGH.put("cchopv3", bi.cch0503a.isChecked() ? "1" : bi.cch0503b.isChecked() ? "2" : bi.cch0503c.isChecked() ? "3" : "0");
        sGH.put("cchipv", bi.cch0504a.isChecked() ? "1" : bi.cch0504b.isChecked() ? "2" : bi.cch0504c.isChecked() ? "3" : "0");

        sGH.put("cchva", bi.cch0601a.isChecked() ? "1" : bi.cch0601b.isChecked() ? "2" : bi.cch0601c.isChecked() ? "3" : "0");
        sGH.put("cchm1", bi.cch0701a.isChecked() ? "1" : bi.cch0701b.isChecked() ? "2" : bi.cch0701c.isChecked() ? "3" : "0");
        MainApp.fc.setsGH(String.valueOf(sGH));
        Toast.makeText(this, "Validation Successful", Toast.LENGTH_SHORT).show();
    }

    private boolean formValidate() {

        //Section G

        if (!bi.ccg0197.isChecked()) {
            if (!validatorClass.EmptyRadioButton(this, bi.ccg0101, bi.ccg0101a, getString(R.string.ccg01a))) {
                return false;
            }

            if (!validatorClass.EmptyRadioButton(this, bi.ccg0102, bi.ccg0102a, getString(R.string.ccg01b))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.ccg0103, bi.ccg0103a, getString(R.string.ccg01c))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.ccg0104, bi.ccg0104a, getString(R.string.ccg01d))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.ccg0105, bi.ccg0105a, getString(R.string.ccg01e))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.ccg0106, bi.ccg0106a, getString(R.string.ccg01f))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.ccg0107, bi.ccg0107a, getString(R.string.ccg01g))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.ccg0108, bi.ccg0108a, getString(R.string.ccg01h))) {
                return false;
            }

        }
        if (!bi.ccg0197.isChecked()) {

            if (!validatorClass.EmptyRadioButton(this, bi.ccg02, bi.ccg02a, getString(R.string.ccg02))) {
                return false;
            }

            if (bi.ccg02a.isChecked()) {

                if (!validatorClass.EmptyRadioButton(this, bi.ccg03, bi.ccg03a, getString(R.string.ccg03))) {
                    return false;
                }

                if (bi.ccg0396.isChecked()) {
                    if (!validatorClass.EmptyTextBox(this, bi.ccg0396x, getString(R.string.ccg03))) {
                        return false;
                    }
                }
            }
        }

        //Section H
        if (!validatorClass.EmptyRadioButton(this, bi.cch01, bi.cch01a, getString(R.string.cch01))) {
            return false;
        }
        if (bi.cch01a.isChecked()) {

            if (!validatorClass.EmptyRadioButton(this, bi.cch0201, bi.cch0201a, getString(R.string.cch02))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.cch0202, bi.cch0202a, getString(R.string.cch02))) {
                return false;
            }

            if (!validatorClass.EmptyRadioButton(this, bi.cch0301, bi.cch0301a, getString(R.string.cch03))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.cch0302, bi.cch0302a, getString(R.string.cch03))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.cch0303, bi.cch0303a, getString(R.string.cch03))) {
                return false;
            }

            if (!validatorClass.EmptyRadioButton(this, bi.cch0401, bi.cch0401a, getString(R.string.cch04))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.cch0402, bi.cch0402a, getString(R.string.cch04))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.cch0403, bi.cch0403a, getString(R.string.cch04))) {
                return false;
            }

            if (!validatorClass.EmptyRadioButton(this, bi.cch0501, bi.cch0501a, getString(R.string.cch05))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.cch0502, bi.cch0502a, getString(R.string.cch05))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.cch0503, bi.cch0503a, getString(R.string.cch05))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.cch0504, bi.cch0504a, getString(R.string.cch05))) {
                return false;
            }

            if (!validatorClass.EmptyRadioButton(this, bi.cch0601, bi.cch0601a, getString(R.string.cch06))) {
                return false;
            }
            return validatorClass.EmptyRadioButton(this, bi.cch0701, bi.cch0701a, getString(R.string.cch07));

        }


        return true;
    }

    public void BtnEnd() {


        MainApp.endActivity(this, this);
    }
}
