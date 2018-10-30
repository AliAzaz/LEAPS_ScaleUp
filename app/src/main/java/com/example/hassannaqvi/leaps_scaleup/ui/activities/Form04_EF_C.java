package com.example.hassannaqvi.leaps_scaleup.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hassannaqvi.leaps_scaleup.R;
import com.example.hassannaqvi.leaps_scaleup.databinding.ActivityForm04EfCBinding;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static com.example.hassannaqvi.leaps_scaleup.ui.activities.Form04_EF_A.getStringbyIdName;

public class Form04_EF_C extends AppCompatActivity {


    ActivityForm04EfCBinding bi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_form04__ef__c);
        bi.setCallback(this);

    }

    public void procesButton(View v) {

        Button b = (Button) v;
        // Get question ID
        String qID = getResources().getResourceEntryName(v.getId());
        String _qID = qID.substring(0, qID.length() - 1); // this is question id

        TextView tv = findViewById(getResources().getIdentifier(_qID, "id", getPackageName()));
        CardView fldgrp = findViewById(getResources().getIdentifier("fldgrp" + _qID, "id", getPackageName()));
        //String nextqID = qID + "a";
        TextView nexttv = findViewById(getResources().getIdentifier(qID, "id", getPackageName()));
        // Get Text on button
        Boolean skipnext = qID.charAt(qID.length() - 1) == 'a';
        String btnPressed = b.getText().toString();
        skipPractice(tv, String.format("%s%s", tv.getText().toString(), btnPressed), fldgrp,
                getStringbyIdName(this, _qID + "pattern"), nexttv, skipnext);

    }

    private void skipPractice(TextView tv, String format, CardView fldgrp, String stringbyIdName, TextView nexttv, Boolean skipnext) {

        tv.setText(format);
        if (skipnext) {
            if (tv.getText().toString().equals(stringbyIdName)) {
                fldgrp.setVisibility(View.GONE);
                nexttv.setText(null);
            } else {
                fldgrp.setVisibility(View.VISIBLE);

            }
        } else {
            tv.setText(null);
        }

    }

    public static String getStringbyIdName(Context context, String name) {
        Resources res = context.getResources();
        return res.getString(res.getIdentifier(name, "string", context.getPackageName()));
    }


    public void BtnContinue() {

    }

    public void BtnEnd() {
        startActivity(new Intent(getApplicationContext(), EndingActivity.class).putExtra("complete", false));
    }
}
