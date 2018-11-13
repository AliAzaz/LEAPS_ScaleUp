package com.example.hassannaqvi.leaps_scaleup.ui.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.hassannaqvi.leaps_scaleup.JSON.GeneratorClass;
import com.example.hassannaqvi.leaps_scaleup.R;
import com.example.hassannaqvi.leaps_scaleup.databinding.ActivityForm09Part2Binding;
import com.example.hassannaqvi.leaps_scaleup.validation.validatorClass;

import org.json.JSONException;
import org.json.JSONObject;

public class Form09_part_2_Activity extends AppCompatActivity {

    ActivityForm09Part2Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_form09_part_2_);
        bi.setCallback(this);
    }

    public void BtnContinue() {
        //startActivity(new Intent(getApplicationContext(), Form02HHPart_2_HI_SE.class).putExtra("complete", true));
        if (formValidation()) {
            Toast.makeText(this, "validated", Toast.LENGTH_SHORT).show();
         try {
                SaveDraft();
            if (UpdateDB()) {
              startActivity(new Intent(getApplicationContext(), Form09_part_3_4_5_Activity.class).putExtra("complete", true));
            } else {
                Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
            }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void SaveDraft() throws JSONException {

        JSONObject Json = GeneratorClass.getContainerJSON(bi.fldgrpform04part02, true);

        //InfoActivity.fc_4_5.setSa3(String.valueOf(Json));

        Log.d("F5-BA", String.valueOf(Json));
    }

    private boolean UpdateDB() {

        return true;
    }

    private boolean formValidation() {


        if (!validatorClass.EmptyRadioButton(this, bi.ls09efaa01, bi.ls09efaa01a, getString(R.string.ls09efaa01))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09efaa02, bi.ls09efaa02a, getString(R.string.ls09efaa02))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09efaa03, bi.ls09efaa03a, getString(R.string.ls09efaa03))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09efaa04, bi.ls09efaa04a, getString(R.string.ls09efaa04))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09efaa05, bi.ls09efaa05a, getString(R.string.ls09efaa05))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09efaa06, bi.ls09efaa06a, getString(R.string.ls09efaa06))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09efaa07, bi.ls09efaa07a, getString(R.string.ls09efaa07))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09efaa08, bi.ls09efaa08a, getString(R.string.ls09efaa08))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09efaa09, bi.ls09efaa09a, getString(R.string.ls09efaa09))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09efaa10a, bi.ls09efaa10a01, getString(R.string.ls09efaa10a))) {
            return false;
        }
        if (bi.ls09efaa10a01.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.ls09efaa10b, getString(R.string.ls09efaa10b))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.ls09efaa11, bi.ls09efaa11a, getString(R.string.ls09efaa11))) {
                return false;
            }
        }

        if (!validatorClass.EmptyRadioButton(this, bi.ls09efaa12, bi.ls09efaa12a, getString(R.string.ls09efaa12))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09efaa13a, bi.ls09efaa13a01, getString(R.string.ls09efaa13a))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09efaa13b, bi.ls09efaa13b01, getString(R.string.ls09efaa13b))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09efaa14, bi.ls09efaa14a, getString(R.string.ls09efaa14))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09efaa15, bi.ls09efaa15a, getString(R.string.ls09efaa15))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09efaa16, bi.ls09efaa16a, getString(R.string.ls09efaa16))) {
            return false;
        }

        return true;
    }

    public void BtnEnd() {

        startActivity(new Intent(getApplicationContext(), EndingActivity.class).putExtra("complete", false));
    }
}
