package com.example.hassannaqvi.leaps_scaleup.ui.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.hassannaqvi.leaps_scaleup.R;
import com.example.hassannaqvi.leaps_scaleup.databinding.ActivityForm02Hhpart1Binding;

public class Form02HHPart_3 extends AppCompatActivity {

//    ActivityForm02Hhpart3Binding bi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form02_hhpart_3);
//        bi = DataBindingUtil.setContentView(this, R.layout.activity_form02_hhpart_3);
//        bi.setCallback(this);
    }
    public void BtnContinue() {
        startActivity(new Intent(getApplicationContext(), EndingActivity.class).putExtra("complete", true));

      /*  if (formValidation()) {
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
    public void BtnEnd() {
        startActivity(new Intent(getApplicationContext(), EndingActivity.class).putExtra("complete", false));
    }
}
