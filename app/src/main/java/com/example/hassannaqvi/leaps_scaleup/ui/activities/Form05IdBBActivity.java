package com.example.hassannaqvi.leaps_scaleup.ui.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.hassannaqvi.leaps_scaleup.R;
import com.example.hassannaqvi.leaps_scaleup.databinding.ActivityForm05IdBBBinding;
import com.example.hassannaqvi.leaps_scaleup.validation.validatorClass;

import java.util.Arrays;

public class Form05IdBBActivity extends AppCompatActivity {

    ActivityForm05IdBBBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_form05_id_b_b);
        bi.setCallback(this);

        setContentUI();

    }

    public void setContentUI() {
        bi.ls05b08a.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Arrays.asList("....", "0", "1", "2", "3", "4", "5")));
    }

    public void BtnContinue() {

        if (formValidation()) {
            SaveDraft();
            if (UpdateDB()) {
                startActivity(new Intent(getApplicationContext(), Form05IdBCActivity.class));
            } else {
                Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
            }
        }

    }

    private boolean UpdateDB() {
        return true;
    }

    private void SaveDraft() {

    }

    private boolean formValidation() {

        if (!validatorClass.EmptyCheckingContainer(this, bi.flgGrpf05BB01)) {
            return false;
        }

        if (!bi.ls05b0899.isChecked()) {
            if (!validatorClass.EmptySpinner(this, bi.ls05b08a, getString(R.string.ls05b08a))) {
                return false;
            }
        }

        return validatorClass.EmptyCheckingContainer(this, bi.flgGrpf05BB02);
    }

    public void BtnEnd() {
        startActivity(new Intent(this, EndingActivity.class).putExtra("complete", false));
    }
}
