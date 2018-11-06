package com.example.hassannaqvi.leaps_scaleup.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hassannaqvi.leaps_scaleup.JSON.GeneratorClass;
import com.example.hassannaqvi.leaps_scaleup.R;
import com.example.hassannaqvi.leaps_scaleup.RMOperations.crudOperations;
import com.example.hassannaqvi.leaps_scaleup.core.MainApp;
import com.example.hassannaqvi.leaps_scaleup.data.DAO.FormsDAO;
import com.example.hassannaqvi.leaps_scaleup.databinding.ActivityForm04EfABinding;
import com.example.hassannaqvi.leaps_scaleup.validation.validatorClass;

import org.json.JSONObject;

import java.lang.reflect.Field;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static com.example.hassannaqvi.leaps_scaleup.ui.activities.LoginActivity.db;

public class Form04_EF_A extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    ActivityForm04EfABinding bi;


    int ls04ab01, ls04ab02, ls04ab03, ls04ab04, ls04ab05, ls04ab06, ls04ab07, ls04ab08, ls04ab09, ls04ab10, ls04ab11, ls04ab12;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form04_ef_a);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_form04_ef_a);
        bi.setCallback(this);


        validatorClass.setScrollViewFocus(bi.efAScrollview);
        attachingListeners();


    }

    private void attachingListeners() {
        bi.ls04aa01a.setOnCheckedChangeListener(this);
        bi.ls04aa01b.setOnCheckedChangeListener(this);
        bi.ls04aa02a.setOnCheckedChangeListener(this);
        bi.ls04aa02b.setOnCheckedChangeListener(this);
        bi.ls04aa03a.setOnCheckedChangeListener(this);
        bi.ls04aa03b.setOnCheckedChangeListener(this);
        bi.ls04aa04a.setOnCheckedChangeListener(this);
        bi.ls04aa04b.setOnCheckedChangeListener(this);

        bi.ls04ab01.setOnCheckedChangeListener(this);
        bi.ls04ab02.setOnCheckedChangeListener(this);
        bi.ls04ab03.setOnCheckedChangeListener(this);
        bi.ls04ab04.setOnCheckedChangeListener(this);
        bi.ls04ab05.setOnCheckedChangeListener(this);
        bi.ls04ab06.setOnCheckedChangeListener(this);
        bi.ls04ab07.setOnCheckedChangeListener(this);
        bi.ls04ab08.setOnCheckedChangeListener(this);
        bi.ls04ab09.setOnCheckedChangeListener(this);
        bi.ls04ab10.setOnCheckedChangeListener(this);
        bi.ls04ab11.setOnCheckedChangeListener(this);
        bi.ls04ab12.setOnCheckedChangeListener(this);

    }


    int settingAnswers(TextView txtview, String txtValue, int answer, String pattern) {

        txtview.setText(txtValue);
        if (!TextUtils.isEmpty(txtview.getText().toString())) {
            if (txtview.getText().toString().equals(pattern)) {
                answer = 1;
            } else {
                answer = 2;
            }
        } else {
            answer = 0;

        }
        return answer;
    }


    public void BtnContinue() {
        if (formValidation()) {
            SaveDraft();
            if (UpdateDB()) {
                startActivity(new Intent(getApplicationContext(), Form04_EF_B.class));
            } else {
                Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean UpdateDB() {
        try {
            Long longID = new crudOperations(db, InfoActivity.fc_4_5).execute(FormsDAO.class.getName(), "formsDao", "updateForm_04_05").get();
            return longID == 1;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return false;


       /* try {
            Long longID = new crudOperations(db, InfoActivity.fc_4_5).execute(FormsDAO.class.getName(), "formsDao", "updateForm_04_05").get();
            return longID == 1;

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return false;*/
//       return true;
    }

    private void SaveDraft() {
      /*  JSONObject Json = GeneratorClass.getContainerJSON(bi.fldgrpls04a01, true);
        Json = Json. GeneratorClass.getContainerJSON(this,bi.fldgrpls04a02, false, Json);
        Json = Json + GeneratorClass.getContainerJSON(this,bi.fldgrpls04a03,  false, Json);
        Json = Json + GeneratorClass.getContainerJSON(this,bi.fldgrpls04a04,  false, Json);
        Json = Json + GeneratorClass.getContainerJSON(this,bi.fldgrpls04a05, false, Json);
        InfoActivity.fc_4_5.setSa1(String.valueOf(Json));

        Log.d("F4-EF-A", String.valueOf(Json));*/
    }

    private boolean formValidation() {

        return validatorClass.EmptyCheckingContainer(this, bi.flgGrpls04a);



/*
        if (!validatorClass.tempEmptyCheckingContainer(this, bi.fldgrpls04a01)) {
            return false;
        }
        if (!validatorClass.tempEmptyCheckingContainer(this, bi.fldgrpls04a02)) {
            return false;
        }
        if (!validatorClass.tempEmptyCheckingContainer(this, bi.fldgrpls04a03)) {
            return false;
        }
        if (!validatorClass.tempEmptyCheckingContainer(this, bi.fldgrpls04a04)) {
            return false;
        }
        return validatorClass.tempEmptyCheckingContainer(this, bi.fldgrpls04a05);*/
//      return true;
    }

    public void BtnEnd() {
        startActivity(new Intent(this, EndingActivity.class).putExtra("complete", false));

    }

    /*
        public boolean isConditionSatisfied(int a, int b, int c) {
            if (Objects.equals(a, 1) && Objects.equals(b, 1)) {
                return true;
            } else if (Objects.equals(b, 1) && Objects.equals(c, 1)) {
                return true;
            } else if (Objects.equals(a, 1) && Objects.equals(c, 1)) {
                return true;
            } else {
                return false;
            }
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
            if (bi.ls04aa01a.getText().toString().equals(getResources().getString(R.string.ls04aa01pattern)) && bi.ls04aa02a.getText().toString().equals(getResources().getString(R.string.ls04aa02pattern))) {
                bi.fldgrpll01.setVisibility(GONE);
                bi.ls04aa03a.setText(null);
                bi.ls04aa04a.setText(null);
            } else {
                bi.fldgrpll01.setVisibility(VISIBLE);
            }


        }


        public static String getStringbyIdName(Context context, String name) {
            Resources res = context.getResources();
            return res.getString(res.getIdentifier(name, "string", context.getPackageName()));
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

        public void levelBasedProcess(View v) {


            Button b = (Button) v;
            // Get question ID
            String qID = getResources().getResourceEntryName(v.getId());
            qID = qID.substring(0, qID.length() - 1); // this is question id

            TextView tv = findViewById(getResources().getIdentifier(qID, "id", getPackageName()));
            String btnPressed = b.getText().toString();
            try {
                setVariable(qID, settingAnswers(tv, String.format("%s%s", tv.getText().toString(), btnPressed), getVariable(qID), getStringbyIdName(this, qID + "pattern")));
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            checkLevelSkip(ls04ab01, ls04ab02, ls04ab03, bi.level3);
            checkLevelSkip(ls04ab04, ls04ab05, ls04ab06, bi.level4);
            checkLevelSkip(ls04ab07, ls04ab08, ls04ab09, bi.level5);
        }

        private void checkLevelSkip(int a, int b, int c, LinearLayout levelName) {
            if (isConditionSatisfied(a, b, c)) {
                levelName.setVisibility(VISIBLE);
            } else {
                levelName.setVisibility(GONE);
            }
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
        }*/
    char getlastCharacter(String value) {
        return value.charAt(value.length() - 1);
    }

    char getsixthCharacter(String value) {
        return value.charAt(5);
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        String qID = getResources().getResourceEntryName(group.getId());
        if (getsixthCharacter(qID) == 'a') {
            if (group.getCheckedRadioButtonId() == -1) {
            } else {
                RadioButton selectedbtn = findViewById(group.getCheckedRadioButtonId());
                if (getlastCharacter(qID) == 'a') {
                    CardView fldgrp = findViewById(getResources().getIdentifier("fldgrp" + qID, "id", getPackageName()));
                    String ques = qID.substring(0, qID.length() - 1);
                    String nextqID = ques + "b";
                    RadioGroup nextRadio = findViewById(getResources().getIdentifier(nextqID, "id", getPackageName()));
                    skipPractice(selectedbtn.getText().toString(), fldgrp, nextRadio);
                }
            }
        } else if (getsixthCharacter(qID) == 'b') {
            checkLevelSkip(bi.ls04ab01a.isChecked(), bi.ls04ab02a.isChecked(), bi.ls04ab03a.isChecked(), bi.level3);
            checkLevelSkip(bi.ls04ab04a.isChecked(), bi.ls04ab05a.isChecked(), bi.ls04ab06a.isChecked(), bi.level4);
            checkLevelSkip(bi.ls04ab07a.isChecked(), bi.ls04ab08a.isChecked(), bi.ls04ab09a.isChecked(), bi.level5);
        }
    }

    private void checkLevelSkip(Boolean a, Boolean b, Boolean c, LinearLayout levelName) {
        if (isConditionSatisfied(a, b, c)) {
            levelName.setVisibility(VISIBLE);

        } else {
            levelName.setVisibility(GONE);
           /* if (levelName.getId() == R.id.level3) {
                bi.ls04ab04.clearCheck();
                bi.ls04ab05.clearCheck();
                bi.ls04ab06.clearCheck();
                bi.ls04ab07.clearCheck();
                bi.ls04ab08.clearCheck();
                bi.ls04ab09.clearCheck();
            } else if (levelName.getId() == R.id.level4) {
                bi.ls04ab07.clearCheck();
                bi.ls04ab08.clearCheck();
                bi.ls04ab09.clearCheck();
            }*/
        }
    }

    public boolean isConditionSatisfied(Boolean a, Boolean b, Boolean c) {
/*

        if (a == b ) {
            return true;
        } else if ( b == c) {
            return true;
        } else if (a == c) {
            return true;
        } else {
            return false;
        }
*/

        if (Objects.equals(a, true) && Objects.equals(b, true)) {
            return true;
        } else if (Objects.equals(b, true) && Objects.equals(c, true)) {
            return true;
        } else if (Objects.equals(a, true) && Objects.equals(c, true)) {
            return true;
        } else {
            return false;
        }
    }

    public static String getStringbyIdName(Context context, String name) {
        Resources res = context.getResources();
        return res.getString(res.getIdentifier(name, "string", context.getPackageName()));
    }

    public void skipPractice(String selectedbtnTxt, android.support.v7.widget.CardView fldGrp, RadioGroup nextRadio) {
        if (selectedbtnTxt.equals(getResources().getString(R.string.yes))) {
            fldGrp.setVisibility(View.GONE);
            nextRadio.clearCheck();
        } else {
            fldGrp.setVisibility(View.VISIBLE);
        }
        if (bi.ls04aa01a01.isChecked() && bi.ls04aa02a01.isChecked()) {
            bi.fldgrpadmin.setVisibility(GONE);
            bi.ls04aa03a.clearCheck();
            bi.ls04aa04a.clearCheck();
        } else {
            bi.fldgrpadmin.setVisibility(VISIBLE);
        }
    }


    @Override
    public void onBackPressed() {

        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }
}
