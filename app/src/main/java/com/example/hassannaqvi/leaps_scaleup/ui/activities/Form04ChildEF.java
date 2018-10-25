package com.example.hassannaqvi.leaps_scaleup.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.hassannaqvi.leaps_scaleup.R;

public class Form04ChildEF extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form04_child_ef);
    }

    public void BtnContinue() {
        /*startActivity(new Intent(this, Form05IdBAActivity.class));
        if (formValidation()) {
            SaveDraft();
            if (UpdateDB()) {
                startActivity(new Intent(getApplicationContext(), EndingActivity.class).putExtra("complete", true));
            } else {
                Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
            }
        }*/
    }

    private boolean UpdateDB() {
        return true;
    }

    private void SaveDraft() {
    }

    private boolean formValidation() {


        return true;
    }

    public void BtnEnd() {
//        startActivity(new Intent(this, EndingActivity.class).putExtra("complete", false));
    }
}
