package com.example.hassannaqvi.leaps_scaleup.ui;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.hassannaqvi.leaps_scaleup.R;
import com.example.hassannaqvi.leaps_scaleup.databinding.ActivityForm08EfABinding;

public class Form08_EF_A extends AppCompatActivity {
ActivityForm08EfABinding bi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this,R.layout.activity_form08__ef_a);
        bi.setCallback(this);
    }
}