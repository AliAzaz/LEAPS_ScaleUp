package com.example.hassannaqvi.leaps_scaleup.ui;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.hassannaqvi.leaps_scaleup.R;
import com.example.hassannaqvi.leaps_scaleup.databinding.ActivityForm08EfABinding;
import com.example.hassannaqvi.leaps_scaleup.databinding.ActivityForm08EfBBinding;

public class Form08_EF_B extends AppCompatActivity {
    ActivityForm08EfBBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_form08_ef_b);
        bi.setCallback(this);
    }
}