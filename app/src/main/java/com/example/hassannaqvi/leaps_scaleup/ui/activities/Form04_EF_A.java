package com.example.hassannaqvi.leaps_scaleup.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.hassannaqvi.leaps_scaleup.JSON.GeneratorClass;
import com.example.hassannaqvi.leaps_scaleup.R;
import com.example.hassannaqvi.leaps_scaleup.RMOperations.crudOperations;
import com.example.hassannaqvi.leaps_scaleup.core.MainApp;
import com.example.hassannaqvi.leaps_scaleup.data.DAO.FormsDAO;
import com.example.hassannaqvi.leaps_scaleup.databinding.ActivityForm04EfABinding;
import com.example.hassannaqvi.leaps_scaleup.validation.validatorClass;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;
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

        this.setTitle(R.string.ls04a);


        validatorClass.setScrollViewFocus(bi.efAScrollview);
        attachingListeners();


    }


    RadioGroup.OnCheckedChangeListener level3 = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if (isConditionSatisfied(bi.ls04ab01a.isChecked(), bi.ls04ab02a.isChecked(), bi.ls04ab03a.isChecked())) {
                bi.level3.setVisibility(VISIBLE);
                bi.level4.setVisibility(VISIBLE);
                bi.level5.setVisibility(VISIBLE);

            } else {
                bi.level3.setVisibility(GONE);
                bi.level4.setVisibility(GONE);
                bi.level5.setVisibility(GONE);
                bi.ls04ab04.clearCheck();
                bi.ls04ab05.clearCheck();
                bi.ls04ab06.clearCheck();
                bi.ls04ab07.clearCheck();
                bi.ls04ab08.clearCheck();
                bi.ls04ab09.clearCheck();
                bi.ls04ab10.clearCheck();
                bi.ls04ab11.clearCheck();
                bi.ls04ab12.clearCheck();
            }
        }
    };
    RadioGroup.OnCheckedChangeListener level4 = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if (isConditionSatisfied(bi.ls04ab04a.isChecked(), bi.ls04ab05a.isChecked(), bi.ls04ab06a.isChecked())) {

                bi.level4.setVisibility(VISIBLE);
                bi.level5.setVisibility(VISIBLE);

            } else {
                bi.level4.setVisibility(GONE);
                bi.level5.setVisibility(GONE);
                bi.ls04ab07.clearCheck();
                bi.ls04ab08.clearCheck();
                bi.ls04ab09.clearCheck();
                bi.ls04ab10.clearCheck();
                bi.ls04ab11.clearCheck();
                bi.ls04ab12.clearCheck();
            }
        }
    };
    RadioGroup.OnCheckedChangeListener level5 = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if (isConditionSatisfied(bi.ls04ab07a.isChecked(), bi.ls04ab08a.isChecked(), bi.ls04ab09a.isChecked())) {
                bi.level5.setVisibility(VISIBLE);
            } else {
                bi.level5.setVisibility(GONE);
                bi.ls04ab10.clearCheck();
                bi.ls04ab11.clearCheck();
                bi.ls04ab12.clearCheck();
            }
        }
    };

    private void attachingListeners() {
        bi.ls04aa01a.setOnCheckedChangeListener(this);
        bi.ls04aa01b.setOnCheckedChangeListener(this);
        bi.ls04aa02a.setOnCheckedChangeListener(this);
        bi.ls04aa02b.setOnCheckedChangeListener(this);
        bi.ls04aa03a.setOnCheckedChangeListener(this);
        bi.ls04aa03b.setOnCheckedChangeListener(this);
        bi.ls04aa04a.setOnCheckedChangeListener(this);
        bi.ls04aa04b.setOnCheckedChangeListener(this);

        bi.ls04ab01.setOnCheckedChangeListener(level3);
        bi.ls04ab02.setOnCheckedChangeListener(level3);
        bi.ls04ab03.setOnCheckedChangeListener(level3);
        bi.ls04ab04.setOnCheckedChangeListener(level4);
        bi.ls04ab05.setOnCheckedChangeListener(level4);
        bi.ls04ab06.setOnCheckedChangeListener(level4);
        bi.ls04ab07.setOnCheckedChangeListener(level5);
        bi.ls04ab08.setOnCheckedChangeListener(level5);
        bi.ls04ab09.setOnCheckedChangeListener(level5);

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
    }

    private void SaveDraft() {
        JSONObject localJson;
        JSONObject Json1 = GeneratorClass.getContainerJSON(bi.flgGrpls04a, true);
        JSONObject Json2 = GeneratorClass.getContainerJSON(bi.level2, true);
        localJson = mergeJSONObjects(Json1,Json2);
        JSONObject Json3 = GeneratorClass.getContainerJSON(bi.level3, true);
        localJson = mergeJSONObjects(localJson,Json3);
        JSONObject Json4 = GeneratorClass.getContainerJSON(bi.level4, true);
        localJson = mergeJSONObjects(localJson,Json4);
        JSONObject Json5 = GeneratorClass.getContainerJSON(bi.level5, true);
        localJson = mergeJSONObjects(localJson,Json5);

        InfoActivity.fc_4_5.setSa1(String.valueOf(localJson));
        Log.d("F4-EF-A", String.valueOf(localJson));
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

    private boolean formValidation() {
        return validatorClass.EmptyCheckingContainer(this, bi.flgGrpls04a);

    }

    public void BtnEnd() {
        MainApp.endActivity(this, this, EndingActivity.class, false, InfoActivity.fc_4_5);

    }


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
        }
    }


    public boolean isConditionSatisfied(Boolean a, Boolean b, Boolean c) {
        if (Objects.equals(a, true) && Objects.equals(b, true)) {
            return true;
        } else if (Objects.equals(b, true) && Objects.equals(c, true)) {
            return true;
        } else return Objects.equals(a, true) && Objects.equals(c, true);
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
