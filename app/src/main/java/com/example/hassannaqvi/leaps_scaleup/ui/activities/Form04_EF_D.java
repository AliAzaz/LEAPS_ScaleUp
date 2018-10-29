package com.example.hassannaqvi.leaps_scaleup.ui.activities;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hassannaqvi.leaps_scaleup.R;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class Form04_EF_D extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form04_ef_d);
    }
    public void processButton(View v) {

        Button b = (Button) v;
        // Get question ID
        String qID = getResources().getResourceEntryName(v.getId());
        qID = qID.substring(0, qID.length() - 1); // this is question id

        TextView tv = findViewById(getResources().getIdentifier(qID, "id", getPackageName()));
        CardView fldgrp = findViewById(getResources().getIdentifier("fldgrp" + qID, "id", getPackageName()));
        String ques = qID.substring(0, qID.length() - 1);
        String nextqID = ques + "b";
        TextView nexttv = findViewById(getResources().getIdentifier(nextqID, "id", getPackageName()));
        // Get Text on button
        Boolean skipnext = qID.charAt(qID.length() - 1) == 'a';
        String btnPressed = b.getText().toString();
        skipPractice(tv, String.format("%s%s", tv.getText().toString(), btnPressed), fldgrp, getStringbyIdName(this, ques + "pattern"), nexttv, skipnext);

    }

    public static String getStringbyIdName(Context context, String name) {
        Resources res = context.getResources();
        return res.getString(res.getIdentifier(name, "string", context.getPackageName()));
    }
    public void skipPractice(TextView txtview, String response, android.support.v7.widget.CardView fldGrp, String pattern, TextView nextTxtView, Boolean skipNext) {
        txtview.setText(response);
        if (skipNext) {
            if (txtview.getText().toString().equals(pattern)) {
                fldGrp.setVisibility(View.GONE);
                nextTxtView.setText(null);
            } else {
                fldGrp.setVisibility(View.VISIBLE);

            }
        }



    }
}
