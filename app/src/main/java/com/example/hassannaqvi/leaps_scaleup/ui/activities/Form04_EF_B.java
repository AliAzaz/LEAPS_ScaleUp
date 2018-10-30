package com.example.hassannaqvi.leaps_scaleup.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hassannaqvi.leaps_scaleup.R;
import com.example.hassannaqvi.leaps_scaleup.databinding.ActivityForm04EfBBinding;

import java.lang.reflect.Field;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class Form04_EF_B extends AppCompatActivity {
ActivityForm04EfBBinding bi;
int ls04bb01,ls04bb02,ls04bb03,ls04bb04,ls04bb05,ls04bb06;
int ls04bc01,ls04bc02,ls04bc03,ls04bc04,ls04bc05,ls04bc06;
int ls04be01,ls04be02,ls04be03,ls04be04,ls04be05,ls04be06;
int ls04bf01,ls04bf02,ls04bf03,ls04bf04,ls04bf05,ls04bf06;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this,R.layout.activity_form04_ef_b);
        bi.setCallback(this);
    }

    public void BtnContinue() {
        if (formValidation()) {
            SaveDraft();
//            if (UpdateDB()) {
            if (true) {
//                startActivity(new Intent(getApplicationContext(), Form04_EF_C.class));
                startActivity(new Intent(getApplicationContext(), EndingActivity.class).putExtra("complete",false));
            } else {
                Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void SaveDraft() {
/*
        JSONObject Json = GeneratorClass.getContainerJSON(bi.flgGrpf05BE01, true);
        Form05IdBAActivity.fc_4_5.setSa5(String.valueOf(Json));

        Log.d("F4-EF-A", String.valueOf(Json));*/
    }
    private boolean formValidation() {

        /*  return validatorClass.EmptyCheckingContainer(this, bi.flgGrpf05BE01);*/
        return true;
    }
    public void BtnEnd() {
        startActivity(new Intent(this, EndingActivity.class).putExtra("complete", false));

    }
    public void processButton(View v) {

        Button b = (Button) v;
        // Get question ID
        String qID = getResources().getResourceEntryName(v.getId());
        qID = qID.substring(0, qID.length() - 2); // this is question id
        TextView tv = findViewById(getResources().getIdentifier(qID, "id", getPackageName()));
        CardView fldgrp = findViewById(getResources().getIdentifier("fldgrp" + qID, "id", getPackageName()));
        String ques = qID.substring(0, qID.length() - 1);
        String nextqID = ques + "b";
        TextView nexttv = findViewById(getResources().getIdentifier(nextqID, "id", getPackageName()));
        // Get Text on button
        Boolean skipnext = getlastCharacter(qID) == 'a';
        String btnPressed = b.getText().toString();
        skipPractice(tv,btnPressed, fldgrp, getStringbyIdName(this, ques + "pattern"), nexttv, skipnext);
    }
    public void levelBasedProcess(View v) {
        Button b = (Button) v;
        // Get question ID
        String qID = getResources().getResourceEntryName(v.getId());
        if(getlastCharacter(qID) == 'a' || getlastCharacter(qID) == 'b'){
            qID = qID.substring(0, qID.length() - 1); // this is question id
        }else{
            qID = qID.substring(0, qID.length() - 2); // this is question id
        }
        TextView tv = findViewById(getResources().getIdentifier(qID, "id", getPackageName()));
        String btnPressed = b.getText().toString();
        try {
            setVariable(qID, settingAnswers(tv,btnPressed, getVariable(qID), getStringbyIdName(this, qID + "pattern")));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        int sumofC = ls04bc01+ls04bc02+ls04bc03+ls04bc04+ls04bc05+ls04bc06;
        int sumofF = ls04bf01+ls04bf02+ls04bf03+ls04bf04+ls04bf05+ls04bf06;
        if(sumofC >= 5){
            bi.level2.setVisibility(VISIBLE);
        }else {
            bi.level2.setVisibility(GONE);
            bi.ls04bd01a.setText(null);
            bi.ls04bd01b.setText(null);
            bi.ls04bd02a.setText(null);
            bi.ls04bd02b.setText(null);
            bi.ls04be01.setText(null);
            bi.ls04be02.setText(null);
            bi.ls04be03.setText(null);
            bi.ls04be04.setText(null);
            bi.ls04be05.setText(null);
            bi.ls04bf01.setText(null);
            bi.ls04bf02.setText(null);
            bi.ls04bf03.setText(null);
            bi.ls04bf04.setText(null);
            bi.ls04bf05.setText(null);
            bi.ls04bf06.setText(null);
            bi.ls04bg01.setText(null);
            bi.ls04bg02.setText(null);
            bi.ls04bg03.setText(null);
            bi.ls04bg04.setText(null);
            bi.ls04bg05.setText(null);
            bi.ls04bg06.setText(null);
            bi.ls04bg07.setText(null);
            bi.ls04bg08.setText(null);
            bi.ls04bg09.setText(null);
            bi.ls04bg10.setText(null);
            bi.ls04bg11.setText(null);
            bi.ls04bg12.setText(null);

        }
        if(sumofF >= 5){
            bi.level3.setVisibility(VISIBLE);
        }else {
            bi.level3.setVisibility(GONE);
            bi.ls04bg01.setText(null);
            bi.ls04bg02.setText(null);
            bi.ls04bg03.setText(null);
            bi.ls04bg04.setText(null);
            bi.ls04bg05.setText(null);
            bi.ls04bg06.setText(null);
            bi.ls04bg07.setText(null);
            bi.ls04bg08.setText(null);
            bi.ls04bg09.setText(null);
            bi.ls04bg10.setText(null);
            bi.ls04bg11.setText(null);
            bi.ls04bg12.setText(null);
        }


    }
    int settingAnswers(TextView txtview, String txtValue, int answer, String pattern) {

        txtview.setText(txtValue);
        if (!TextUtils.isEmpty(txtview.getText().toString())) {
            if (txtview.getText().toString().equals(pattern)) {
                answer = 1;
            } else {
                answer = 0;
            }
        } else {
            answer = 0;

        }
        return answer;
    }
    public int getVariable(String c)
            throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        Field field = this.getClass().getDeclaredField(c);
        field.setAccessible(true);
        Object value = field.get(this);
        return (int) value;
    }

    public void setVariable(String variableName, int value)
            throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        Field field = this.getClass().getDeclaredField(variableName);
        field.setAccessible(true);
        field.set(this, value);
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
    char getlastCharacter(String value){
       return value.charAt(value.length()  - 1);
    }


    public static String getStringbyIdName(Context context, String name) {
        Resources res = context.getResources();
        return res.getString(res.getIdentifier(name, "string", context.getPackageName()));
    }

}
