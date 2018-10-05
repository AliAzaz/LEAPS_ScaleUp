package com.example.hassannaqvi.leaps_scaleup.ui.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.hassannaqvi.leaps_scaleup.R;
import com.example.hassannaqvi.leaps_scaleup.databinding.ActivityForm02Hhpart2FsBinding;

public class Form02HHPart_2_FS extends AppCompatActivity {
    ActivityForm02Hhpart2FsBinding bi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_form02_hhpart_2_fs);
        bi.setCallback(this);
    }
    public void BtnContinue() {
        startActivity(new Intent(getApplicationContext(), Form02HHPart_3.class));

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
