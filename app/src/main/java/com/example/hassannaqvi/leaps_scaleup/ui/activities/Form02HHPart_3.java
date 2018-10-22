package com.example.hassannaqvi.leaps_scaleup.ui.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.hassannaqvi.leaps_scaleup.R;
import com.example.hassannaqvi.leaps_scaleup.databinding.ActivityForm02Hhpart3Binding;
import com.example.hassannaqvi.leaps_scaleup.validation.ClearClass;
import com.example.hassannaqvi.leaps_scaleup.validation.validatorClass;

import org.json.JSONException;

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

                if (i != R.id.ls02ee01b01) {
                    bi.fldgrpee03.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrpee03,false);
                }else{
                    bi.fldgrpee03.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrpee03,true);
                }
            }
        });

        bi.ls02ee12.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if(i == R.id.ls02ee12b){

                    bi.fldgrpee16.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrpee16,false);

                }else{
                    bi.fldgrpee16.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrpee16,true);
                }
            }
        });
    }

    public void BtnContinue() {
        //startActivity(new Intent(getApplicationContext(), EndingActivity.class).putExtra("complete", true));

        if (formValidation()) {
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
        }
    }

    private boolean UpdateDB() {

        return true;
    }

    private void SaveDraft() throws JSONException {
    }

    private boolean formValidation() {

        if(!validatorClass.EmptyRadioButton(this,bi.ls02ee01a,bi.ls02ee01a01,getString(R.string.ls02ee01a))){
            return false;
        }
        if(!validatorClass.EmptyRadioButton(this,bi.ls02ee01b,bi.ls02ee01b01,getString(R.string.ls02ee01b))){
            return false;
        }
        if(bi.ls02ee01b02.isChecked()){
            if(!validatorClass.EmptyRadioButton(this,bi.ls02ee01c,bi.ls02ee01c01,getString(R.string.ls02ee01c))){
                return false;
            }
        }
        if(bi.ls02ee01c96.isChecked()){
            if(!validatorClass.EmptyTextBox(this,bi.ls02ee01c96x,getString(R.string.ls02ee01c))){
                return false;
            }
        }
        if(!validatorClass.EmptyTextBox(this,bi.ls02ee02,getString(R.string.ls02ee02))){
            return false;
        }
        if(!validatorClass.EmptyRadioButton(this,bi.ls02ee03a,bi.ls02ee03a01,getString(R.string.ls02ee03a))){
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls02ee03b, bi.ls02ee03b01, getString(R.string.ls02ee03b))) {
            return false;
        }
        if(!validatorClass.EmptyTextBox(this,bi.ls02ee04,getString(R.string.ls02ee04))){
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.ls02ee05, bi.ls02ee05a, getString(R.string.ls02ee05))) {
            return false;
        }

        if(bi.ls02ee0596.isChecked()){
            if(!validatorClass.EmptyTextBox(this,bi.ls02ee0596x,getString(R.string.ls02ee05))){
                return false;
            }
        }

        if (!validatorClass.EmptyRadioButton(this, bi.ls02ee06, bi.ls02ee06a, getString(R.string.ls02ee06))) {
            return false;
        }




        return true;
    }

    public void BtnEnd() {
        startActivity(new Intent(getApplicationContext(), EndingActivity.class).putExtra("complete", false));
    }
}
