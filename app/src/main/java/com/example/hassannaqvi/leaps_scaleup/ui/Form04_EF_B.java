package com.example.hassannaqvi.leaps_scaleup.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hassannaqvi.leaps_scaleup.JSON.GeneratorClass;
import com.example.hassannaqvi.leaps_scaleup.R;
import com.example.hassannaqvi.leaps_scaleup.core.MainApp;
import com.example.hassannaqvi.leaps_scaleup.databinding.ActivityForm04EfBBinding;
import com.example.hassannaqvi.leaps_scaleup.validation.validatorClass;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.util.Iterator;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class Form04_EF_B extends AppCompatActivity {
    ActivityForm04EfBBinding bi;
    int ls04bb01, ls04bb02, ls04bb03, ls04bb04, ls04bb05, ls04bb06;
    int ls04bc01, ls04bc02, ls04bc03, ls04bc04, ls04bc05, ls04bc06;
    int ls04be01, ls04be02, ls04be03, ls04be04, ls04be05, ls04be06;
    int ls04bf01, ls04bf02, ls04bf03, ls04bf04, ls04bf05, ls04bf06;
    int ls04bg01, ls04bg02, ls04bg03, ls04bg04, ls04bg05, ls04bg06, ls04bg07, ls04bg08, ls04bg09, ls04bg10, ls04bg11, ls04bg12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_form04_ef_b);
        bi.setCallback(this);

        this.setTitle(R.string.ls04b);
    }

    public void BtnContinue() {
        if (formValidation()) {
            SaveDraft();
            if (UpdateDB()) {
//            if (true) {
                startActivity(new Intent(getApplicationContext(), Form04_EF_C.class));
            } else {
                Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean UpdateDB() {
      /*  try {
            Long longID = new crudOperations(db, InfoActivity.fc_4_5).execute(FormsDAO.class.getName(), "formsDao", "updateForm_04_05").get();
            return longID == 1;

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return false;*/
       return true;
    }
    public static JSONObject mergeJSONObjects(JSONObject Obj1, JSONObject Obj2) {
        JSONObject merged = new JSONObject();
        JSONObject[] objs = new JSONObject[] { Obj1, Obj2 };
        for (JSONObject obj : objs) {
            Iterator it = obj.keys();
            while (it.hasNext()) {
                String key = (String)it.next();
                try {
                    merged.put(key, obj.get(key));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return merged;
    }
    private void SaveDraft() {
        JSONObject localJson;
        JSONObject Json1 = GeneratorClass.getContainerJSON(this,bi.fldgrpls04b, false,new JSONObject());
        /*JSONObject Json2 = GeneratorClass.getContainerJSON(this,bi.level2, false,new JSONObject());
        localJson = mergeJSONObjects(Json1,Json2);*/

        InfoActivity.fc_4_5.setSa2(String.valueOf(Json1));

        Log.d("F4-EF-B", String.valueOf(Json1));
    }

    private boolean formValidation() {

          return validatorClass.EmptyCheckingContainer(this, bi.fldgrpls04b);
//        return true;
    }

    public void BtnEnd() {
        MainApp.endActivity(this, this, EndingActivity.class, false, InfoActivity.fc_4_5);

    }

    public void processButton(View v) {

        Button b = (Button) v;
        // Get question ID
        String qID = getResources().getResourceEntryName(v.getId());
        qID = qID.substring(0, qID.length() - 2); // this is question id
        EditText tv = findViewById(getResources().getIdentifier(qID, "id", getPackageName()));
        CardView fldgrp = findViewById(getResources().getIdentifier("fldgrp" + qID, "id", getPackageName()));
        String ques = qID.substring(0, qID.length() - 1);
        String nextqID = ques + "b";
        EditText nexttv = findViewById(getResources().getIdentifier(nextqID, "id", getPackageName()));
        // Get Text on button
        Boolean skipnext = getlastCharacter(qID) == 'a';
        String btnPressed = b.getText().toString();
        skipPractice(tv, btnPressed, fldgrp, getStringbyIdName(this, ques + "pattern"), nexttv, skipnext);
    }

    public void levelBasedProcess(View v) {
        Button b = (Button) v;
        // Get question ID
        String qID = getResources().getResourceEntryName(v.getId());
        if (getlastCharacter(qID) == 'a' || getlastCharacter(qID) == 'b') {
            qID = qID.substring(0, qID.length() - 1); // this is question id
        } else {
            qID = qID.substring(0, qID.length() - 2); // this is question id
        }
        EditText tv = findViewById(getResources().getIdentifier(qID, "id", getPackageName()));
        String btnPressed = b.getText().toString();
        try {
            setVariable(qID, settingAnswers(tv, btnPressed, getVariable(qID), getStringbyIdName(this, qID + "pattern")));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        int sumofC = ls04bc01 + ls04bc02 + ls04bc03 + ls04bc04 + ls04bc05 + ls04bc06;
        int sumofF = ls04bf01 + ls04bf02 + ls04bf03 + ls04bf04 + ls04bf05 + ls04bf06;
        if (sumofC >= 5) {
            bi.level2.setVisibility(VISIBLE);
        } else {
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
        if (sumofF >= 5) {
            bi.level3.setVisibility(VISIBLE);
        } else {
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

    int settingAnswers(EditText txtview, String txtValue, int answer, String pattern) {

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

    public void skipPractice(EditText txtview, String response, android.support.v7.widget.CardView fldGrp, String pattern, EditText nextTxtView, Boolean skipNext) {
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

    char getlastCharacter(String value) {
        return value.charAt(value.length() - 1);
    }


    public static String getStringbyIdName(Context context, String name) {
        Resources res = context.getResources();
        return res.getString(res.getIdentifier(name, "string", context.getPackageName()));
    }

    @Override
    public void onBackPressed() {

        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }
}
