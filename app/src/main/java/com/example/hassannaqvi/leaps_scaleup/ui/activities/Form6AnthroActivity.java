package com.example.hassannaqvi.leaps_scaleup.ui.activities;

import android.content.Intent;
import android.database.DatabaseUtils;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.hassannaqvi.leaps_scaleup.R;
import com.example.hassannaqvi.leaps_scaleup.databinding.ActivityForm6AnthroBinding;
import com.example.hassannaqvi.leaps_scaleup.validation.validatorClass;
import com.shashank.sony.fancytoastlib.FancyToast;

import org.json.JSONException;
import org.json.JSONObject;

public class Form6AnthroActivity extends AppCompatActivity {


    ActivityForm6AnthroBinding bi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_form6_anthro);
        bi.setCallback(this);

        this.setTitle(R.string.ls06Heading);
    }

    public void BtnContinue() {

        if (formValidation()) {
            try {
                SaveDraft();

                if (UpdateDB()) {
                    startActivity(new Intent(getApplicationContext(), EndingActivity.class).putExtra("complete", true));
                } else {
                    FancyToast.makeText(this, "Error in updating db!!", FancyToast.LENGTH_SHORT, FancyToast.ERROR, false).show();
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

        JSONObject sF6 = new JSONObject();

        sF6.put("ls0601", bi.ls0601.getText().toString());
        sF6.put("ls0602", bi.ls0602.getText().toString());
        sF6.put("ls0603", bi.ls0603.getText().toString());
        sF6.put("ls0604", bi.ls0604.getText().toString());


    }

    private boolean formValidation() {

        if (!validatorClass.EmptyTextBox(this, bi.ls0601, getString(R.string.ls0601))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.ls0602, getString(R.string.ls0602))) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.ls0603, getString(R.string.ls0603))) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.ls0604, getString(R.string.ls0604))) {
            return false;
        }

        FancyToast.makeText(this, "Section Validated", FancyToast.LENGTH_SHORT, FancyToast.SUCCESS, false).show();
        return true;
    }

    public void BtnEnd() {
        startActivity(new Intent(getApplicationContext(), EndingActivity.class).putExtra("complete", false));
    }
}
