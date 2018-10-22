package com.example.hassannaqvi.leaps_scaleup.ui.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.hassannaqvi.leaps_scaleup.R;
import com.example.hassannaqvi.leaps_scaleup.databinding.ActivityForm02Hhpart2HiSeBinding;
import com.example.hassannaqvi.leaps_scaleup.validation.ClearClass;
import com.example.hassannaqvi.leaps_scaleup.validation.validatorClass;

import org.json.JSONException;

public class Form02HHPart_2_HI_SE extends AppCompatActivity {


    ActivityForm02Hhpart2HiSeBinding bi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_form02_hhpart_2_hi_se);
        bi.setCallback(this);

        this.setTitle(R.string.lsseheading);

        setupViews();
    }

    private void setupViews() {

        bi.ls02se02.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i != R.id.ls02se02b) {
                    bi.fldgrpls0207.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrpls0207, false);
                } else {
                    bi.fldgrpls0207.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrpls0207, true);
                }

            }
        });

        bi.ls02se09.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i != R.id.ls02se09a) {
                    bi.fldgrpls0214.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrpls0214, false);
                } else {
                    bi.fldgrpls0214.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrpls0214, true);
                }
            }
        });


    }

    public void BtnContinue() {
        startActivity(new Intent(getApplicationContext(), Form02HHPart_2_FS.class));

        /*if (formValidation()) {
            try {
                SaveDraft();
                if (UpdateDB()) {
                    startActivity(new Intent(getApplicationContext(), EndingActivity.class).putExtra("complete", true));
                } else {
                    Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }*/
    }

    private boolean UpdateDB() {

        return true;
    }

    private void SaveDraft() throws JSONException {
    }

    private boolean formValidation() {

        if (!validatorClass.EmptyRadioButton(this, bi.ls02hi01, bi.ls02hi01a, getString(R.string.ls02hi01))) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.ls02hi02, getString(R.string.ls02hi02))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls02se01a, bi.ls02se01a01, getString(R.string.ls02se01a))) {
            return false;
        }
        if (bi.ls02se01a96.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.ls02se01a96x, getString(R.string.ls02se01a))) {
                return false;
            }
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls02se01b, bi.ls02se01b01, getString(R.string.ls02se01b))) {
            return false;
        }
        if (bi.ls02se01b96.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.ls02se01b96x, getString(R.string.ls02se01b))) {
                return false;
            }
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls02se01c, bi.ls02se01c02, getString(R.string.ls02se01c))) {
            return false;
        }
        if (bi.ls02se01c96.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.ls02se01c96x, getString(R.string.ls02se01c))) {
                return false;
            }
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls02se02, bi.ls02se02a, getString(R.string.ls02se02))) {
            return false;
        }

        if (bi.ls02se0296.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.ls02se0296x, getString(R.string.ls02se02))) {
                return false;
            }
        }
        if (bi.ls02se02b.isChecked()) {
            if (!bi.ls02se0398.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.ls02se03, getString(R.string.ls02se03))) {
                    return false;
                }
            }

        }
        if (!validatorClass.EmptyTextBox(this, bi.ls02se04, getString(R.string.ls02se04))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls02se05, bi.ls02se05a, getString(R.string.ls02se05))) {
            return false;
        }
        if (bi.ls02se0596.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.ls02se0596x, getString(R.string.ls02se05))) {
                return false;
            }
        }
        if (!bi.ls02se0698.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.ls02se06, getString(R.string.ls02se06))) {
                return false;
            }
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls02se07, bi.ls02se07a, getString(R.string.ls02se07))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls02se08, bi.ls02se08a, getString(R.string.ls02se08))) {
            return false;
        }
        if (bi.ls02se0896.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.ls02se0896x, getString(R.string.ls02se08))) {
                return false;
            }
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls02se09, bi.ls02se09a, getString(R.string.ls02se09))) {
            return false;
        }
        if (bi.ls02se0996.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.ls02se0996x, getString(R.string.ls02se09))) {
                return false;
            }
        }



        return true;
    }

    public void BtnEnd() {
        startActivity(new Intent(getApplicationContext(), EndingActivity.class).putExtra("complete", false));
    }
}
