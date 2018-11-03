package com.example.hassannaqvi.leaps_scaleup.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hassannaqvi.leaps_scaleup.JSON.GeneratorClass;
import com.example.hassannaqvi.leaps_scaleup.R;
import com.example.hassannaqvi.leaps_scaleup.databinding.ActivityForm04EfCBinding;
import com.example.hassannaqvi.leaps_scaleup.validation.ClearClass;
import com.example.hassannaqvi.leaps_scaleup.validation.validatorClass;

import org.json.JSONException;
import org.json.JSONObject;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static com.example.hassannaqvi.leaps_scaleup.ui.activities.Form04_EF_A.getStringbyIdName;

public class Form04_EF_C extends AppCompatActivity {


    ActivityForm04EfCBinding bi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_form04__ef__c);
        bi.setCallback(this);

        this.setTitle(R.string.ls04caHeading);
        setupViews();

    }

    private void setupViews() {

        bi.ls04ca01.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.ls04ca01a) {
                    bi.fldgrpls04ca02.setVisibility(GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrpls04ca02, false);
                } else {
                    bi.fldgrpls04ca02.setVisibility(VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrpls04ca02, true);
                }
            }
        });

        bi.ls04ca03.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.ls04ca03a) {
                    bi.fldgrpls04ca04.setVisibility(GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrpls04ca04, false);
                    bi.fldgrpls04ca05.setVisibility(GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrpls04ca05, false);
                    bi.fldgrpls04ca06.setVisibility(GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrpls04ca06, false);
                    bi.fldgrpls04ca07.setVisibility(GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrpls04ca07, false);
                    bi.fldgrpls04ca08.setVisibility(GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrpls04ca08, false);
                } else {
                    bi.fldgrpls04ca04.setVisibility(VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrpls04ca04, true);
                    bi.fldgrpls04ca05.setVisibility(VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrpls04ca05, true);
                    bi.fldgrpls04ca06.setVisibility(VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrpls04ca06, true);
                    bi.fldgrpls04ca07.setVisibility(VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrpls04ca07, true);
                    bi.fldgrpls04ca08.setVisibility(VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrpls04ca08, true);
                }
            }
        });

        bi.ls04ca05.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.ls04ca05a) {
                    bi.fldgrpls04ca06.setVisibility(GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrpls04ca06, false);
                } else {
                    bi.fldgrpls04ca06.setVisibility(VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrpls04ca06, true);
                }
            }
        });

        bi.ls04ca07.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.ls04ca07a) {
                    bi.fldgrpls04ca08.setVisibility(GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrpls04ca08, false);
                } else {
                    bi.fldgrpls04ca08.setVisibility(VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrpls04ca08, true);
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

        JSONObject Json = GeneratorClass.getContainerJSON(bi.fldgrpf04EFC, true);

        InfoActivity.fc_4_5.setSa1(String.valueOf(Json));

        Log.d("F5-BA", String.valueOf(Json));


    }

    private boolean formValidation() {

        if (!validatorClass.EmptyRadioButton(this, bi.ls04ca01, bi.ls04ca01a, getString(R.string.ls04ca01))) {
            return false;
        }
        if (!bi.ls04ca01a.isChecked()) {

            if (!validatorClass.EmptyRadioButton(this, bi.ls04ca02, bi.ls04ca02a, getString(R.string.ls04ca02))) {
                return false;
            }
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls04ca03, bi.ls04ca03a, getString(R.string.ls04ca03))) {
            return false;
        }
        if (!bi.ls04ca03a.isChecked()) {
            if (!validatorClass.EmptyRadioButton(this, bi.ls04ca04, bi.ls04ca04a, getString(R.string.ls04ca04))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.ls04ca05, bi.ls04ca05a, getString(R.string.ls04ca05))) {
                return false;
            }

            if (!bi.ls04ca05a.isChecked()) {
                if (!validatorClass.EmptyRadioButton(this, bi.ls04ca06, bi.ls04ca06a, getString(R.string.ls04ca06))) {
                    return false;
                }
            }
            if (!validatorClass.EmptyRadioButton(this, bi.ls04ca07, bi.ls04ca07a, getString(R.string.ls04ca07))) {
                return false;
            }
            if (!bi.ls04ca07a.isChecked()) {
                if (!validatorClass.EmptyRadioButton(this, bi.ls04ca08, bi.ls04ca08a, getString(R.string.ls04ca08))) {
                    return false;
                }
            }
        }

        return true;
    }


    public void BtnEnd() {
        startActivity(new Intent(getApplicationContext(), EndingActivity.class).putExtra("complete", false));
    }
}
