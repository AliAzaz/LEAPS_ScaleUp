package com.example.hassannaqvi.leaps_scaleup.ui;

import android.content.Intent;
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
import com.example.hassannaqvi.leaps_scaleup.databinding.ActivityForm08EfBBinding;
import com.example.hassannaqvi.leaps_scaleup.validation.validatorClass;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static com.example.hassannaqvi.leaps_scaleup.ui.LoginActivity.db;
import static com.example.hassannaqvi.leaps_scaleup.utils.JsonUtils.mergeJSONObjects;

public class Form08_EF_B extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    ActivityForm08EfBBinding bi;

    RadioGroup.OnCheckedChangeListener level3 = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if (isConditionSatisfied(bi.ls08bb01a.isChecked(), bi.ls08bb02a.isChecked(), bi.ls08bb03a.isChecked())) {
                bi.level3.setVisibility(VISIBLE);
                bi.level4.setVisibility(VISIBLE);
                bi.level5.setVisibility(VISIBLE);
                bi.level6.setVisibility(VISIBLE);
                bi.level7.setVisibility(VISIBLE);
                bi.level8.setVisibility(VISIBLE);

            } else {
                bi.level3.setVisibility(GONE);
                bi.level4.setVisibility(GONE);
                bi.level5.setVisibility(GONE);
                bi.level6.setVisibility(GONE);
                bi.level7.setVisibility(GONE);
                bi.level8.setVisibility(GONE);
                bi.ls08bb04.clearCheck();
                bi.ls08bb05.clearCheck();
                bi.ls08bb06.clearCheck();
                bi.ls08bb07.clearCheck();
                bi.ls08bb08.clearCheck();
                bi.ls08bb09.clearCheck();
                bi.ls08bb10.clearCheck();
                bi.ls08bb11.clearCheck();
                bi.ls08bb12.clearCheck();
                bi.ls08bb13.clearCheck();
                bi.ls08bb14.clearCheck();
                bi.ls08bb15.clearCheck();
                bi.ls08bb16.clearCheck();
                bi.ls08bb17.clearCheck();
                bi.ls08bb18.clearCheck();
                bi.ls08bb19.clearCheck();
                bi.ls08bb20.clearCheck();
                bi.ls08bb21.clearCheck();
            }
        }
    };
    RadioGroup.OnCheckedChangeListener level4 = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if (isConditionSatisfied(bi.ls08bb04a.isChecked(), bi.ls08bb05a.isChecked(), bi.ls08bb06a.isChecked())) {

                bi.level4.setVisibility(VISIBLE);
                bi.level5.setVisibility(VISIBLE);
                bi.level6.setVisibility(VISIBLE);
                bi.level7.setVisibility(VISIBLE);
                bi.level8.setVisibility(VISIBLE);

            } else {
                bi.level4.setVisibility(GONE);
                bi.level5.setVisibility(GONE);
                bi.level6.setVisibility(GONE);
                bi.level7.setVisibility(GONE);
                bi.level8.setVisibility(GONE);
                bi.ls08bb07.clearCheck();
                bi.ls08bb08.clearCheck();
                bi.ls08bb09.clearCheck();
                bi.ls08bb10.clearCheck();
                bi.ls08bb11.clearCheck();
                bi.ls08bb12.clearCheck();
                bi.ls08bb13.clearCheck();
                bi.ls08bb14.clearCheck();
                bi.ls08bb15.clearCheck();
                bi.ls08bb16.clearCheck();
                bi.ls08bb17.clearCheck();
                bi.ls08bb18.clearCheck();
                bi.ls08bb19.clearCheck();
                bi.ls08bb20.clearCheck();
                bi.ls08bb21.clearCheck();
            }
        }
    };
    RadioGroup.OnCheckedChangeListener level5 = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if (isConditionSatisfied(bi.ls08bb07a.isChecked(), bi.ls08bb08a.isChecked(), bi.ls08bb09a.isChecked())) {

                bi.level5.setVisibility(VISIBLE);
                bi.level6.setVisibility(VISIBLE);
                bi.level7.setVisibility(VISIBLE);
                bi.level8.setVisibility(VISIBLE);

            } else {
                bi.level5.setVisibility(GONE);
                bi.level6.setVisibility(GONE);
                bi.level7.setVisibility(GONE);
                bi.level8.setVisibility(GONE);
                bi.ls08bb10.clearCheck();
                bi.ls08bb11.clearCheck();
                bi.ls08bb12.clearCheck();
                bi.ls08bb13.clearCheck();
                bi.ls08bb14.clearCheck();
                bi.ls08bb15.clearCheck();
                bi.ls08bb16.clearCheck();
                bi.ls08bb17.clearCheck();
                bi.ls08bb18.clearCheck();
                bi.ls08bb19.clearCheck();
                bi.ls08bb20.clearCheck();
                bi.ls08bb21.clearCheck();
            }
        }
    };
    RadioGroup.OnCheckedChangeListener level6 = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if (isConditionSatisfied(bi.ls08bb10a.isChecked(), bi.ls08bb11a.isChecked(), bi.ls08bb12a.isChecked())) {

                bi.level6.setVisibility(VISIBLE);
                bi.level7.setVisibility(VISIBLE);
                bi.level8.setVisibility(VISIBLE);

            } else {
                bi.level6.setVisibility(GONE);
                bi.level7.setVisibility(GONE);
                bi.level8.setVisibility(GONE);
                bi.ls08bb13.clearCheck();
                bi.ls08bb14.clearCheck();
                bi.ls08bb15.clearCheck();
                bi.ls08bb16.clearCheck();
                bi.ls08bb17.clearCheck();
                bi.ls08bb18.clearCheck();
                bi.ls08bb19.clearCheck();
                bi.ls08bb20.clearCheck();
                bi.ls08bb21.clearCheck();
            }
        }
    };
    RadioGroup.OnCheckedChangeListener level7 = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if (isConditionSatisfied(bi.ls08bb13a.isChecked(), bi.ls08bb14a.isChecked(), bi.ls08bb15a.isChecked())) {
                bi.level7.setVisibility(VISIBLE);
                bi.level8.setVisibility(VISIBLE);
            } else {
                bi.level7.setVisibility(GONE);
                bi.level8.setVisibility(GONE);
                bi.ls08bb16.clearCheck();
                bi.ls08bb17.clearCheck();
                bi.ls08bb18.clearCheck();
                bi.ls08bb19.clearCheck();
                bi.ls08bb20.clearCheck();
                bi.ls08bb21.clearCheck();
            }
        }
    };
    RadioGroup.OnCheckedChangeListener level8 = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if (isConditionSatisfied(bi.ls08bb16a.isChecked(), bi.ls08bb17a.isChecked(), bi.ls08bb18a.isChecked())) {
                bi.level8.setVisibility(VISIBLE);
            } else {
                bi.level8.setVisibility(GONE);
                bi.ls08bb19.clearCheck();
                bi.ls08bb20.clearCheck();
                bi.ls08bb21.clearCheck();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_form08_ef_b);
        bi.setCallback(this);
        this.setTitle(R.string.ls08b);
        validatorClass.setScrollViewFocus(bi.ef08BScrollview);

        attachingListeners();

    }

    private void attachingListeners() {
        bi.ls08ba01a.setOnCheckedChangeListener(this);
        bi.ls08ba01b.setOnCheckedChangeListener(this);

        bi.ls08bb01.setOnCheckedChangeListener(level3);
        bi.ls08bb02.setOnCheckedChangeListener(level3);
        bi.ls08bb03.setOnCheckedChangeListener(level3);
        bi.ls08bb04.setOnCheckedChangeListener(level4);
        bi.ls08bb05.setOnCheckedChangeListener(level4);
        bi.ls08bb06.setOnCheckedChangeListener(level4);
        bi.ls08bb07.setOnCheckedChangeListener(level5);
        bi.ls08bb08.setOnCheckedChangeListener(level5);
        bi.ls08bb09.setOnCheckedChangeListener(level5);
        bi.ls08bb10.setOnCheckedChangeListener(level6);
        bi.ls08bb11.setOnCheckedChangeListener(level6);
        bi.ls08bb12.setOnCheckedChangeListener(level6);
        bi.ls08bb13.setOnCheckedChangeListener(level7);
        bi.ls08bb14.setOnCheckedChangeListener(level7);
        bi.ls08bb15.setOnCheckedChangeListener(level7);
        bi.ls08bb16.setOnCheckedChangeListener(level8);
        bi.ls08bb17.setOnCheckedChangeListener(level8);
        bi.ls08bb18.setOnCheckedChangeListener(level8);


    }

    public void BtnContinue() {
        if (formValidation()) {
            SaveDraft();
            if (UpdateDB()) {
//                startActivity(new Intent(getApplicationContext(), Form08_EF_C.class));
                startActivity(new Intent(getApplicationContext(), Form08_EF_C.class));
            } else {
                Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
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
    private boolean formValidation() {
        return validatorClass.EmptyCheckingContainer(this, bi.fldGrpls08b);

    }

    public void BtnEnd() {
        MainApp.endActivity(this, this, EndingActivity.class, false, YouthInfoActivity.fc_4_5);

    }

    private boolean UpdateDB() {
        try {
            Long longID = new crudOperations(db, YouthInfoActivity.fc_4_5).execute(FormsDAO.class.getName(), "formsDao", "updateForm_04_05").get();
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
        JSONObject Json1 = GeneratorClass.getContainerJSON(bi.fldGrpls08b, true);
        JSONObject Json2 = GeneratorClass.getContainerJSON(bi.level2, true);
        localJson = mergeJSONObjects(Json1,Json2);
        JSONObject Json3 = GeneratorClass.getContainerJSON(bi.level3, true);
        localJson = mergeJSONObjects(localJson,Json3);
        JSONObject Json4 = GeneratorClass.getContainerJSON(bi.level4, true);
        localJson = mergeJSONObjects(localJson,Json4);
        JSONObject Json5 = GeneratorClass.getContainerJSON(bi.level5, true);
        localJson = mergeJSONObjects(localJson,Json5);
        JSONObject Json6 = GeneratorClass.getContainerJSON(bi.level6, true);
        localJson = mergeJSONObjects(localJson, Json6);
        JSONObject Json7 = GeneratorClass.getContainerJSON(bi.level7, true);
        localJson = mergeJSONObjects(localJson, Json7);
        JSONObject Json8 = GeneratorClass.getContainerJSON(bi.level8, true);
        localJson = mergeJSONObjects(localJson, Json8);
        JSONObject Json9 = new JSONObject();
        try {
            Json9.put("ls08bt", new SimpleDateFormat("HH:mm").format(new Date().getTime()));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        localJson = mergeJSONObjects(localJson, Json9);

        YouthInfoActivity.fc_4_5.setSa2(String.valueOf(localJson));
        Log.d("F4-EF-B", String.valueOf(localJson));
    }

    @Override
    public void onBackPressed() {

        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }

    char getlastCharacter(String value) {
        return value.charAt(value.length() - 1);
    }

    char getsixthCharacter(String value) {
        return value.charAt(5);
    }

    public void skipPractice(String selectedbtnTxt, android.support.v7.widget.CardView fldGrp, RadioGroup nextRadio) {
        if (selectedbtnTxt.equals(getResources().getString(R.string.yes))) {
            fldGrp.setVisibility(View.GONE);
            nextRadio.clearCheck();
        } else {
            fldGrp.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int i) {
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
}
