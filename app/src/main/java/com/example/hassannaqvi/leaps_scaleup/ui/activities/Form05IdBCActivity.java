package com.example.hassannaqvi.leaps_scaleup.ui.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.hassannaqvi.leaps_scaleup.R;
import com.example.hassannaqvi.leaps_scaleup.databinding.ActivityForm05IdBCBinding;

public class Form05IdBCActivity extends AppCompatActivity {

    ActivityForm05IdBCBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_form05_id_b_c);
        bi.setCallback(this);

    }

    public void BtnContinue() {
        startActivity(new Intent(this, Form02HHPart_2_HI_SE.class));
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
        startActivity(new Intent(this, EndingActivity.class).putExtra("complete", false));
    }
}
