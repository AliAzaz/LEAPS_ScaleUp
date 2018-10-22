package com.example.hassannaqvi.leaps_scaleup.ui.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.hassannaqvi.leaps_scaleup.R;
import com.example.hassannaqvi.leaps_scaleup.databinding.ActivityForm02Hhpart2FsBinding;
import com.example.hassannaqvi.leaps_scaleup.validation.ClearClass;
import com.example.hassannaqvi.leaps_scaleup.validation.validatorClass;

import org.json.JSONException;

public class Form02HHPart_2_FS extends AppCompatActivity {

    ActivityForm02Hhpart2FsBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_form02_hhpart_2_fs);
        bi.setCallback(this);

        this.setTitle(R.string.ls02fsheading);

        setupViews();
    }

    private void setupViews() {

        bi.ls02fs01a.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.ls02fs01a02) {

                    bi.fldgrpfs02.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrpfs02, false);
                } else {
                    bi.fldgrpfs02.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrpfs02, true);
                }
            }
        });

        bi.ls02fs02a.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.ls02fs02a02) {
                    bi.fldgrpfs04.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrpfs04, false);
                } else {
                    bi.fldgrpfs04.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrpfs04, true);
                }
            }
        });

        bi.ls02fs03a.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.ls02fs03a02) {
                    bi.fldgrpfs06.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrpfs06, false);
                } else {
                    bi.fldgrpfs06.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrpfs06, true);

                }
            }
        });

        bi.ls02fs04a.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.ls02fs04a02) {
                    bi.fldgrpfs08.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrpfs08, false);
                } else {
                    bi.fldgrpfs08.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrpfs08, true);
                }
            }
        });

        bi.ls02fs05a.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.ls02fs05a02) {
                    bi.fldgrpfs10.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrpfs10, false);
                } else {
                    bi.fldgrpfs10.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrpfs10, true);
                }
            }
        });

        bi.ls02fs06a.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.ls02fs06a02) {
                    bi.fldgrpfs12.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrpfs12, false);
                } else {
                    bi.fldgrpfs12.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrpfs12, true);
                }
            }
        });

        bi.ls02fs07a.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.ls02fs07a02) {
                    bi.fldgrpfs14.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrpfs14, false);
                }else{
                    bi.fldgrpfs14.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrpfs14, true);
                }
            }
        });

        bi.ls02fs08a.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if(i == R.id.ls02fs08a02){
                    bi.fldgrpfs16.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrpfs16, false);
                }else{
                    bi.fldgrpfs16.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrpfs16, true);
                }
            }
        });

        bi.ls02fs09a.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if(i == R.id.ls02fs09a02){
                    bi.fldgrpfs18.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrpfs18, false);
                }else{
                    bi.fldgrpfs18.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrpfs18, true);
                }
            }
        });




    }

    public void BtnContinue() {
        // startActivity(new Intent(getApplicationContext(), Form02HHPart_3.class));

        if (formValidation()) {
            try {
                SaveDraft();
                if (UpdateDB()) {
                    startActivity(new Intent(getApplicationContext(), Form02HHPart_3.class).putExtra("complete", true));
                } else {
                    Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean UpdateDB() {

        return true;
    }

    private void SaveDraft() throws JSONException {
    }

    private boolean formValidation() {

        if(!validatorClass.EmptyRadioButton(this,bi.ls02fs01a,bi.ls02fs01a01,getString(R.string.ls02fs01a))){
            return false;
        }
        if(bi.ls02fs01a01.isChecked()){
            if(!validatorClass.EmptyRadioButton(this,bi.ls02fs01b,bi.ls02fs01b01,getString(R.string.ls02fs01b))){
                return false;
            }
        }

        if(!validatorClass.EmptyRadioButton(this,bi.ls02fs02a,bi.ls02fs02a01,getString(R.string.ls02fs02a))){
            return false;
        }
        if(bi.ls02fs02a01.isChecked()){
            if(!validatorClass.EmptyRadioButton(this,bi.ls02fs02b,bi.ls02fs02b01,getString(R.string.ls02fs02b))){
                return false;
            }
        }

        if(!validatorClass.EmptyRadioButton(this,bi.ls02fs03a,bi.ls02fs03a01,getString(R.string.ls02fs03a))){
            return false;
        }
        if(bi.ls02fs03a01.isChecked()){
            if(!validatorClass.EmptyRadioButton(this,bi.ls02fs03b,bi.ls02fs03b01,getString(R.string.ls02fs03b))){
                return false;
            }
        }

        if(!validatorClass.EmptyRadioButton(this,bi.ls02fs04a,bi.ls02fs04a01,getString(R.string.ls02fs04a))){
            return false;
        }
        if(bi.ls02fs04a01.isChecked()){
            if(!validatorClass.EmptyRadioButton(this,bi.ls02fs04b,bi.ls02fs04b01,getString(R.string.ls02fs04b))){
                return false;
            }
        }

        if(!validatorClass.EmptyRadioButton(this,bi.ls02fs05a,bi.ls02fs05a01,getString(R.string.ls02fs05a))){
            return false;
        }
        if(bi.ls02fs05a01.isChecked()){
            if(!validatorClass.EmptyRadioButton(this,bi.ls02fs05b,bi.ls02fs05b01,getString(R.string.ls02fs05b))){
                return false;
            }
        }

        if(!validatorClass.EmptyRadioButton(this,bi.ls02fs06a,bi.ls02fs06a01,getString(R.string.ls02fs06a))){
            return false;
        }
        if(bi.ls02fs06a01.isChecked()){
            if(!validatorClass.EmptyRadioButton(this,bi.ls02fs06b,bi.ls02fs06b01,getString(R.string.ls02fs06b))){
                return false;
            }
        }

        if(!validatorClass.EmptyRadioButton(this,bi.ls02fs07a,bi.ls02fs07a01,getString(R.string.ls02fs07a))){
            return false;
        }
        if(bi.ls02fs07a01.isChecked()){
            if(!validatorClass.EmptyRadioButton(this,bi.ls02fs07b,bi.ls02fs07b01,getString(R.string.ls02fs07b))){
                return false;
            }
        }

        if(!validatorClass.EmptyRadioButton(this,bi.ls02fs08a,bi.ls02fs08a01,getString(R.string.ls02fs08a))){
            return false;
        }
        if(bi.ls02fs08a01.isChecked()){
            if(!validatorClass.EmptyRadioButton(this,bi.ls02fs08b,bi.ls02fs08b01,getString(R.string.ls02fs08b))){
                return false;
            }
        }

        if(!validatorClass.EmptyRadioButton(this,bi.ls02fs09a,bi.ls02fs09a01,getString(R.string.ls02fs09a))){
            return false;
        }
        if(bi.ls02fs09a01.isChecked()){
            if(!validatorClass.EmptyRadioButton(this,bi.ls02fs09b,bi.ls02fs09b01,getString(R.string.ls02fs09b))){
                return false;
            }
        }

        return true;
    }

    public void BtnEnd() {
        startActivity(new Intent(getApplicationContext(), EndingActivity.class).putExtra("complete", false));
    }
}
