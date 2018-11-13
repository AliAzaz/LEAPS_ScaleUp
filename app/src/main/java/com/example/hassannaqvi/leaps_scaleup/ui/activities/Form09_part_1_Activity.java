package com.example.hassannaqvi.leaps_scaleup.ui.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.hassannaqvi.leaps_scaleup.R;
import com.example.hassannaqvi.leaps_scaleup.databinding.ActivityForm09Part1Binding;
import com.example.hassannaqvi.leaps_scaleup.validation.ClearClass;
import com.example.hassannaqvi.leaps_scaleup.validation.validatorClass;

import org.json.JSONException;
import org.json.JSONObject;

public class Form09_part_1_Activity extends AppCompatActivity {

    ActivityForm09Part1Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_form09_part_1_);
        bi.setCallback(this);

        setupViews();
    }

    private void setupViews() {

        bi.ls09pa0598.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    ClearClass.ClearAllFields(bi.fldgrpls09pa05a, false);
                } else {
                    ClearClass.ClearAllFields(bi.fldgrpls09pa05a, true);
                }
            }
        });

        bi.ls09j0299.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    ClearClass.ClearAllFields(bi.fldgrpls09j02a, false);
                } else {
                    ClearClass.ClearAllFields(bi.fldgrpls09j02a, true);
                }
            }
        });
    }

    public void BtnContinue() {
        //startActivity(new Intent(getApplicationContext(), Form02HHPart_2_HI_SE.class).putExtra("complete", true));
        if (formValidation()) {
            Toast.makeText(this, "validated", Toast.LENGTH_SHORT).show();
            try {
                SaveDraft();
                if (UpdateDB()) {
                    startActivity(new Intent(getApplicationContext(), Form09_part_2_Activity.class).putExtra("complete", true));
                } else {
                    Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void SaveDraft() throws JSONException {

        JSONObject f09_1 = new JSONObject();

        f09_1.put("ls09pl01",
                bi.ls09pl01a.isChecked() ? "1"
                        : bi.ls09pl01b.isChecked() ? "2" : "0");

        f09_1.put("ls09pl02", bi.ls09pl02.getText().toString());

        f09_1.put("ls09pl03",
                bi.ls09pl03a.isChecked() ? "1"
                        : bi.ls09pl03b.isChecked() ? "2" : "0");

        f09_1.put("ls09he01",
                bi.ls09he01a.isChecked() ? "1"
                        : bi.ls09he01b.isChecked() ? "2"
                        : bi.ls09he01c.isChecked() ? "3"
                        : bi.ls09he01d.isChecked() ? "4"
                        : bi.ls09he01e.isChecked() ? "5"
                        : bi.ls09he01f.isChecked() ? "6"
                        : bi.ls09he0196.isChecked() ? "96"
                        : bi.ls09he0198.isChecked() ? "98"
                        : bi.ls09he0199.isChecked() ? "99"
                        : "0");
        f09_1.put("ls09he0196x", bi.ls09he0196x.getText().toString());

        f09_1.put("ls09he02",
                bi.ls09he02a.isChecked() ? "1"
                        : bi.ls09he02b.isChecked() ? "2"
                        : bi.ls09he0298.isChecked() ? "98"
                        : bi.ls09he0299.isChecked() ? "99"
                        : "0");

        f09_1.put("ls09he03",
                bi.ls09he03a.isChecked() ? "1"
                        : bi.ls09he03b.isChecked() ? "2"
                        : bi.ls09he0398.isChecked() ? "98"
                        : bi.ls09he0399.isChecked() ? "99"
                        : "0");

        f09_1.put("ls09j01",
                bi.ls09j01a.isChecked() ? "1"
                        : bi.ls09j01b.isChecked() ? "2"
                        : bi.ls09j0198.isChecked() ? "98"
                        : bi.ls09j0199.isChecked() ? "99"
                        : "0");

        f09_1.put("ls09j02a", bi.ls09j02a.isChecked() ? "1" : "0");
        f09_1.put("ls09j02b", bi.ls09j02b.isChecked() ? "2" : "0");
        f09_1.put("ls09j02c", bi.ls09j02c.isChecked() ? "3" : "0");
        f09_1.put("ls09j02d", bi.ls09j02d.isChecked() ? "4" : "0");
        f09_1.put("ls09j0299", bi.ls09j0299.isChecked() ? "99" : "0");

        f09_1.put("ls09j03a",
                bi.ls09j03a01.isChecked() ? "1"
                        : bi.ls09j03a02.isChecked() ? "2"
                        : bi.ls09j03a98.isChecked() ? "98"
                        : bi.ls09j03a99.isChecked() ? "99"
                        : "0");

        f09_1.put("ls09j03b", bi.ls09j03b.getText().toString());

        f09_1.put("ls09j04",
                bi.ls09j04a.isChecked() ? "1"
                        : bi.ls09j04b.isChecked() ? "2"
                        : bi.ls09j0498.isChecked() ? "98"
                        : bi.ls09j0499.isChecked() ? "99"
                        : "0");

        f09_1.put("ls09c01a",
                bi.ls09c01a01.isChecked() ? "1"
                        : bi.ls09c01a02.isChecked() ? "2"
                        : bi.ls09c01a98.isChecked() ? "98"
                        : bi.ls09c01a99.isChecked() ? "99"
                        : "0");

        f09_1.put("ls09c01b", bi.ls09c01b.getText().toString());

        f09_1.put("ls09c02",
                bi.ls09c02a.isChecked() ? "1"
                        : bi.ls09c02b.isChecked() ? "2"
                        : bi.ls09c0298.isChecked() ? "98"
                        : bi.ls09c0299.isChecked() ? "99"
                        : "0");

        f09_1.put("ls09dm01",
                bi.ls09dm01a.isChecked() ? "1"
                        : bi.ls09dm01b.isChecked() ? "2"
                        : bi.ls09dm01c.isChecked() ? "3"
                        : bi.ls09dm0198.isChecked() ? "98"
                        : bi.ls09dm0199.isChecked() ? "99"
                        : "0");

        f09_1.put("ls09dm02",
                bi.ls09dm02a.isChecked() ? "1"
                        : bi.ls09dm02b.isChecked() ? "2"
                        : bi.ls09dm02c.isChecked() ? "3"
                        : bi.ls09dm0298.isChecked() ? "98"
                        : bi.ls09dm0299.isChecked() ? "99"
                        : "0");
        f09_1.put("ls09dm03",
                bi.ls09dm03a.isChecked() ? "1"
                        : bi.ls09dm03b.isChecked() ? "2"
                        : bi.ls09dm03c.isChecked() ? "3"
                        : bi.ls09dm0398.isChecked() ? "98"
                        : bi.ls09dm0399.isChecked() ? "99"
                        : "0");
        f09_1.put("ls09dm04",
                bi.ls09dm04a.isChecked() ? "1"
                        : bi.ls09dm04b.isChecked() ? "2"
                        : bi.ls09dm04c.isChecked() ? "3"
                        : bi.ls09dm0498.isChecked() ? "98"
                        : bi.ls09dm0499.isChecked() ? "99"
                        : "0");
        f09_1.put("ls09dm05",
                bi.ls09dm05a.isChecked() ? "1"
                        : bi.ls09dm05b.isChecked() ? "2"
                        : bi.ls09dm05c.isChecked() ? "3"
                        : bi.ls09dm0598.isChecked() ? "98"
                        : bi.ls09dm0599.isChecked() ? "99"
                        : "0");
        f09_1.put("ls09dm06",
                bi.ls09dm06a.isChecked() ? "1"
                        : bi.ls09dm06b.isChecked() ? "2"
                        : bi.ls09dm06c.isChecked() ? "3"
                        : bi.ls09dm0698.isChecked() ? "98"
                        : bi.ls09dm0699.isChecked() ? "99"
                        : "0");

        f09_1.put("ls09fm01",
                bi.ls09fm01a.isChecked() ? "1"
                        : bi.ls09fm01b.isChecked() ? "2"
                        : bi.ls09fm01c.isChecked() ? "3"
                        : bi.ls09fm0199.isChecked() ? "99"
                        : "0");
        f09_1.put("ls09fm02",
                bi.ls09fm02a.isChecked() ? "1"
                        : bi.ls09fm02b.isChecked() ? "2"
                        : bi.ls09fm02c.isChecked() ? "3"
                        : bi.ls09fm0299.isChecked() ? "99"
                        : "0");
        f09_1.put("ls09fm03",
                bi.ls09fm03a.isChecked() ? "1"
                        : bi.ls09fm03b.isChecked() ? "2"
                        : bi.ls09fm03c.isChecked() ? "3"
                        : bi.ls09fm0399.isChecked() ? "99"
                        : "0");
        f09_1.put("ls09fm04",
                bi.ls09fm04a.isChecked() ? "1"
                        : bi.ls09fm04b.isChecked() ? "2"
                        : bi.ls09fm04c.isChecked() ? "3"
                        : bi.ls09fm0499.isChecked() ? "99"
                        : "0");
        f09_1.put("ls09fm05",
                bi.ls09fm05a.isChecked() ? "1"
                        : bi.ls09fm05b.isChecked() ? "2"
                        : bi.ls09fm05c.isChecked() ? "3"
                        : bi.ls09fm0599.isChecked() ? "99"
                        : "0");

        f09_1.put("ls09fl01",
                bi.ls09fl01a.isChecked() ? "1"
                        : bi.ls09fl01b.isChecked() ? "2"
                        : bi.ls09fl0198.isChecked() ? "98"
                        : bi.ls09fl0199.isChecked() ? "99"
                        : "0");
        f09_1.put("ls09fl02",
                bi.ls09fl02a.isChecked() ? "1"
                        : bi.ls09fl02b.isChecked() ? "2"
                        : bi.ls09fl0298.isChecked() ? "98"
                        : bi.ls09fl0299.isChecked() ? "99"
                        : "0");
        f09_1.put("ls09fl03",
                bi.ls09fl03a.isChecked() ? "1"
                        : bi.ls09fl03b.isChecked() ? "2"
                        : bi.ls09fl0398.isChecked() ? "98"
                        : bi.ls09fl0399.isChecked() ? "99"
                        : "0");
        f09_1.put("ls09fl04",
                bi.ls09fl04a.isChecked() ? "1"
                        : bi.ls09fl04b.isChecked() ? "2"
                        : bi.ls09fl0498.isChecked() ? "98"
                        : bi.ls09fl0499.isChecked() ? "99"
                        : "0");

        f09_1.put("ls09pa01",
                bi.ls09pa01a.isChecked() ? "1"
                        : bi.ls09pa01b.isChecked() ? "2"
                        : bi.ls09pa0198.isChecked() ? "98"
                        : bi.ls09pa0199.isChecked() ? "99"
                        : "0");
        f09_1.put("ls09pa02",
                bi.ls09pa02a.isChecked() ? "1"
                        : bi.ls09pa02b.isChecked() ? "2"
                        : bi.ls09pa0298.isChecked() ? "98"
                        : bi.ls09pa0299.isChecked() ? "99"
                        : "0");
        f09_1.put("ls09pa03",
                bi.ls09pa03a.isChecked() ? "1"
                        : bi.ls09pa03b.isChecked() ? "2"
                        : bi.ls09pa0398.isChecked() ? "98"
                        : bi.ls09pa0399.isChecked() ? "99"
                        : "0");
        f09_1.put("ls09pa04",
                bi.ls09pa04a.isChecked() ? "1"
                        : bi.ls09pa04b.isChecked() ? "2"
                        : bi.ls09pa0498.isChecked() ? "98"
                        : bi.ls09pa0499.isChecked() ? "99"
                        : "0");

        f09_1.put("ls09pa05a", bi.ls09pa05a.isChecked() ? "1" : "0");
        f09_1.put("ls09pa05b", bi.ls09pa05b.isChecked() ? "2" : "0");
        f09_1.put("ls09pa05c", bi.ls09pa05c.isChecked() ? "3" : "0");
        f09_1.put("ls09pa05d", bi.ls09pa05d.isChecked() ? "4" : "0");
        f09_1.put("ls09pa05e", bi.ls09pa05e.isChecked() ? "5" : "0");
        f09_1.put("ls09pa05f", bi.ls09pa05f.isChecked() ? "6" : "0");
        f09_1.put("ls09pa0596", bi.ls09pa0596.isChecked() ? "96" : "0");
        f09_1.put("ls09pa0598", bi.ls09pa0598.isChecked() ? "98" : "0");

        f09_1.put("ls09pa0596x", bi.ls09pa0596x.getText().toString());


    }

    private boolean UpdateDB() {

        return false;
    }

    private boolean formValidation() {

        if (!validatorClass.EmptyRadioButton(this, bi.ls09pl01, bi.ls09pl01a, getString(R.string.ls09pl01))) {
            return false;
        }
        if (bi.ls09pl01a.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.ls09pl02, getString(R.string.ls09pl02))) {
                return false;
            }
        } else {
            if (!validatorClass.EmptyRadioButton(this, bi.ls09pl03, bi.ls09pl03a, getString(R.string.ls09pl03))) {
                return false;
            }
        }

        if (!validatorClass.EmptyRadioButton(this, bi.ls09he01, bi.ls09he01a, getString(R.string.ls09he01))) {
            return false;
        }
        if (bi.ls09he0196.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.ls09he0196x, getString(R.string.ls09he01))) {
                return false;
            }
        }
        if (!bi.ls09pl01a.isChecked()) {

            if (!validatorClass.EmptyRadioButton(this, bi.ls09he02, bi.ls09he02a, getString(R.string.ls09he02))) {
                return false;
            }

        } else {
            if (!validatorClass.EmptyRadioButton(this, bi.ls09he03, bi.ls09he03a, getString(R.string.ls09he03))) {
                return false;
            }
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09j01, bi.ls09j01a, getString(R.string.ls09j01))) {
            return false;
        }
        if (!bi.ls09j0299.isChecked()) {
            if (!validatorClass.EmptyCardCheckBox(this, bi.fldgrplspl08, bi.ls09j02a, getString(R.string.ls09j02))) {
                return false;
            }
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09j03a, bi.ls09j03a01, getString(R.string.ls09j03a))) {
            return false;
        }
        if (bi.ls09j03a01.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.ls09j03b, getString(R.string.ls09j03b))) {
                return false;
            }
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09j04, bi.ls09j04a, getString(R.string.ls09j04))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09c01a, bi.ls09c01a01, getString(R.string.ls09c01a))) {
            return false;
        }
        if (bi.ls09c01a01.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.ls09c01b, getString(R.string.ls09c01b))) {
                return false;
            }
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09c02, bi.ls09c02a, getString(R.string.ls09c02))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09dm01, bi.ls09dm01a, getString(R.string.ls09dm01))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09dm02, bi.ls09dm02a, getString(R.string.ls09dm02))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09dm03, bi.ls09dm03a, getString(R.string.ls09dm03))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09dm04, bi.ls09dm04a, getString(R.string.ls09dm04))) {
            return false;
        }
        if (!bi.ls09pl01a.isChecked()) {

            if (!validatorClass.EmptyRadioButton(this, bi.ls09dm05, bi.ls09dm05a, getString(R.string.ls09dm05))) {
                return false;
            }
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09dm06, bi.ls09dm06a, getString(R.string.ls09dm06))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09fm01, bi.ls09fm01a, getString(R.string.ls09fm01))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09fm02, bi.ls09fm02a, getString(R.string.ls09fm02))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09fm03, bi.ls09fm03a, getString(R.string.ls09fm03))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09fm04, bi.ls09fm04a, getString(R.string.ls09fm04))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09fm05, bi.ls09fm05a, getString(R.string.ls09fm05))) {
            return false;
        }
        if (!bi.ls09pl01a.isChecked()) {

            if (!validatorClass.EmptyRadioButton(this, bi.ls09fl01, bi.ls09fl01a, getString(R.string.ls09fl01))) {
                return false;
            }
        }
        if (bi.ls09pl01a.isChecked()) {
            if (!validatorClass.EmptyRadioButton(this, bi.ls09fl02, bi.ls09fl02a, getString(R.string.ls09fl02))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.ls09fl03, bi.ls09fl03a, getString(R.string.ls09fl03))) {
                return false;
            }
        }
        if (!bi.ls09pl01a.isChecked()) {

            if (!validatorClass.EmptyRadioButton(this, bi.ls09fl04, bi.ls09fl04a, getString(R.string.ls09fl04))) {
                return false;
            }
        }
        if (bi.ls09pl01a.isChecked()) {

            if (!validatorClass.EmptyRadioButton(this, bi.ls09pa01, bi.ls09pa01a, getString(R.string.ls09pa01))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.ls09pa02, bi.ls09pa02a, getString(R.string.ls09pa02))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.ls09pa03, bi.ls09pa03a, getString(R.string.ls09pa03))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.ls09pa04, bi.ls09pa04a, getString(R.string.ls09pa04))) {
                return false;
            }
            if (!bi.ls09pa0598.isChecked()) {
                if (!validatorClass.EmptyCardCheckBox(this, bi.fldgrplspl34, bi.ls09pa05a, getString(R.string.ls09pa05))) {
                    return false;
                }
                if (bi.ls09pa0596.isChecked()) {
                    if (!validatorClass.EmptyTextBox(this, bi.ls09pa0596x, getString(R.string.ls09pa05))) {
                        return false;
                    }
                }
            }

        }


        return false;
    }

    public void BtnEnd() {
        startActivity(new Intent(getApplicationContext(), EndingActivity.class).putExtra("complete", false));
    }
}
