package com.example.hassannaqvi.leaps_scaleup.ui.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.hassannaqvi.leaps_scaleup.JSON.GeneratorClass;
import com.example.hassannaqvi.leaps_scaleup.R;
import com.example.hassannaqvi.leaps_scaleup.databinding.ActivityForm09Part345Binding;
import com.example.hassannaqvi.leaps_scaleup.validation.validatorClass;

import org.json.JSONException;
import org.json.JSONObject;

public class Form09_part_3_4_5_Activity extends AppCompatActivity {

    ActivityForm09Part345Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_form09_part_3_4_5_);
        bi.setCallback(this);


    }

    public void BtnContinue() {
        //startActivity(new Intent(getApplicationContext(), Form02HHPart_2_HI_SE.class).putExtra("complete", true));
        if (formValidation()) {
            Toast.makeText(this, "validated", Toast.LENGTH_SHORT).show();
         try {
               SaveDraft();
            if (UpdateDB()) {
                startActivity(new Intent(getApplicationContext(), Form02HHPart_2_HI_SE.class).putExtra("complete", true));
            } else {
                Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
            }
          } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void SaveDraft() throws JSONException{

        JSONObject Json = GeneratorClass.getContainerJSON(bi.fldgrpform09part345, true);

        //InfoActivity.fc_4_5.setSa3(String.valueOf(Json));

        Log.d("F5-BA", String.valueOf(Json));
    }

    private boolean UpdateDB() {

        return true;
    }

    private boolean formValidation() {

        //Part 3
        if (!validatorClass.EmptyRadioButton(this, bi.ls09sef01, bi.ls09sef01a, getString(R.string.ls09sef01))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09sef02, bi.ls09sef02a, getString(R.string.ls09sef02))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09sef03, bi.ls09sef03a, getString(R.string.ls09sef03))) {
            return false;
        }
        //Part 4
        if (!validatorClass.EmptyRadioButton(this, bi.ls09se01, bi.ls09se01a, getString(R.string.ls09se01))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09se02, bi.ls09se02a, getString(R.string.ls09se02))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09se03, bi.ls09se03a, getString(R.string.ls09se03))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09se04, bi.ls09se04a, getString(R.string.ls09se04))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09se05, bi.ls09se05a, getString(R.string.ls09se05))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09se06, bi.ls09se06a, getString(R.string.ls09se06))) {
            return false;
        }

        //part 5
        if (!validatorClass.EmptyRadioButton(this, bi.ls09srq01, bi.ls09srq01a, getString(R.string.ls09srq01))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09srq02, bi.ls09srq02a, getString(R.string.ls09srq02))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09srq03, bi.ls09srq03a, getString(R.string.ls09srq03))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09srq04, bi.ls09srq04a, getString(R.string.ls09srq04))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09srq05, bi.ls09srq05a, getString(R.string.ls09srq05))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09srq06, bi.ls09srq06a, getString(R.string.ls09srq06))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09srq07, bi.ls09srq07a, getString(R.string.ls09srq07))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09srq08, bi.ls09srq08a, getString(R.string.ls09srq08))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09srq09, bi.ls09srq09a, getString(R.string.ls09srq09))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09srq10, bi.ls09srq10a, getString(R.string.ls09srq10))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09srq11, bi.ls09srq11a, getString(R.string.ls09srq11))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09srq12, bi.ls09srq12a, getString(R.string.ls09srq12))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09srq13, bi.ls09srq13a, getString(R.string.ls09srq13))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09srq14, bi.ls09srq14a, getString(R.string.ls09srq14))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09srq15, bi.ls09srq15a, getString(R.string.ls09srq15))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09srq16, bi.ls09srq16a, getString(R.string.ls09srq16))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09srq17, bi.ls09srq17a, getString(R.string.ls09srq17))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09srq18, bi.ls09srq18a, getString(R.string.ls09srq18))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09srq19, bi.ls09srq19a, getString(R.string.ls09srq19))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09srq20, bi.ls09srq20a, getString(R.string.ls09srq20))) {
            return false;
        }
        return true;
    }

    public void BtnEnd() {

        startActivity(new Intent(getApplicationContext(), EndingActivity.class).putExtra("complete", false));
    }

}
