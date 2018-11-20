package com.example.hassannaqvi.leaps_scaleup.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.hassannaqvi.leaps_scaleup.JSON.GeneratorClass;
import com.example.hassannaqvi.leaps_scaleup.R;
import com.example.hassannaqvi.leaps_scaleup.RMOperations.crudOperations;
import com.example.hassannaqvi.leaps_scaleup.core.MainApp;
import com.example.hassannaqvi.leaps_scaleup.data.DAO.FormsDAO;
import com.example.hassannaqvi.leaps_scaleup.databinding.ActivityForm08EfABinding;
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

public class Form08_EF_A extends AppCompatActivity {
ActivityForm08EfABinding bi;
    RadioGroup.OnCheckedChangeListener level3 = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if (isConditionSatisfied(bi.ls08ab01a.isChecked(), bi.ls08ab02a.isChecked(), bi.ls08ab03a.isChecked())) {
                bi.level3.setVisibility(VISIBLE);
                bi.level4.setVisibility(VISIBLE);
                bi.level5.setVisibility(VISIBLE);
                bi.level6.setVisibility(VISIBLE);
                bi.level7.setVisibility(VISIBLE);

            } else {
                bi.level3.setVisibility(GONE);
                bi.level4.setVisibility(GONE);
                bi.level5.setVisibility(GONE);
                bi.level6.setVisibility(GONE);
                bi.level7.setVisibility(GONE);
                bi.ls08ab04.clearCheck();
                bi.ls08ab05.clearCheck();
                bi.ls08ab06.clearCheck();
                bi.ls08ab07.clearCheck();
                bi.ls08ab08.clearCheck();
                bi.ls08ab09.clearCheck();
                bi.ls08ab10.clearCheck();
                bi.ls08ab11.clearCheck();
                bi.ls08ab12.clearCheck();
                bi.ls08ab13.clearCheck();
                bi.ls08ab14.clearCheck();
                bi.ls08ab15.clearCheck();
                bi.ls08ab16.clearCheck();
                bi.ls08ab17.clearCheck();
                bi.ls08ab18.clearCheck();
            }
        }
    };
    RadioGroup.OnCheckedChangeListener level4 = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if (isConditionSatisfied(bi.ls08ab04a.isChecked(), bi.ls08ab05a.isChecked(), bi.ls08ab06a.isChecked())) {

                bi.level4.setVisibility(VISIBLE);
                bi.level5.setVisibility(VISIBLE);
                bi.level6.setVisibility(VISIBLE);
                bi.level7.setVisibility(VISIBLE);

            } else {
                bi.level4.setVisibility(GONE);
                bi.level5.setVisibility(GONE);
                bi.level6.setVisibility(GONE);
                bi.level7.setVisibility(GONE);

                bi.ls08ab07.clearCheck();
                bi.ls08ab08.clearCheck();
                bi.ls08ab09.clearCheck();
                bi.ls08ab10.clearCheck();
                bi.ls08ab11.clearCheck();
                bi.ls08ab12.clearCheck();
                bi.ls08ab13.clearCheck();
                bi.ls08ab14.clearCheck();
                bi.ls08ab15.clearCheck();
                bi.ls08ab16.clearCheck();
                bi.ls08ab17.clearCheck();
                bi.ls08ab18.clearCheck();
            }
        }
    };
    RadioGroup.OnCheckedChangeListener level5 = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if (isConditionSatisfied(bi.ls08ab07a.isChecked(), bi.ls08ab08a.isChecked(), bi.ls08ab09a.isChecked())) {

                bi.level5.setVisibility(VISIBLE);
                bi.level6.setVisibility(VISIBLE);
                bi.level7.setVisibility(VISIBLE);

            } else {
                bi.level5.setVisibility(GONE);
                bi.level6.setVisibility(GONE);
                bi.level7.setVisibility(GONE);

                bi.ls08ab10.clearCheck();
                bi.ls08ab11.clearCheck();
                bi.ls08ab12.clearCheck();
                bi.ls08ab13.clearCheck();
                bi.ls08ab14.clearCheck();
                bi.ls08ab15.clearCheck();
                bi.ls08ab16.clearCheck();
                bi.ls08ab17.clearCheck();
                bi.ls08ab18.clearCheck();
            }
        }
    };
    RadioGroup.OnCheckedChangeListener level6 = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if (isConditionSatisfied(bi.ls08ab10a.isChecked(), bi.ls08ab11a.isChecked(), bi.ls08ab12a.isChecked())) {

                bi.level6.setVisibility(VISIBLE);
                bi.level7.setVisibility(VISIBLE);

            } else {
                bi.level6.setVisibility(GONE);
                bi.level7.setVisibility(GONE);


                bi.ls08ab13.clearCheck();
                bi.ls08ab14.clearCheck();
                bi.ls08ab15.clearCheck();
                bi.ls08ab16.clearCheck();
                bi.ls08ab17.clearCheck();
                bi.ls08ab18.clearCheck();
            }
        }
    };
    RadioGroup.OnCheckedChangeListener level7 = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if (isConditionSatisfied(bi.ls08ab13a.isChecked(), bi.ls08ab14a.isChecked(), bi.ls08ab15a.isChecked())) {
                bi.level7.setVisibility(VISIBLE);
            } else {
                bi.level7.setVisibility(GONE);
                bi.ls08ab16.clearCheck();
                bi.ls08ab17.clearCheck();
                bi.ls08ab18.clearCheck();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_form08_ef_a);
        bi.setCallback(this);
        this.setTitle(R.string.ls08a);
        validatorClass.setScrollViewFocus(bi.ef08AScrollview);
        attachingListeners();
    }

    private void attachingListeners() {

        bi.ls08ab01.setOnCheckedChangeListener(level3);
        bi.ls08ab02.setOnCheckedChangeListener(level3);
        bi.ls08ab03.setOnCheckedChangeListener(level3);
        bi.ls08ab04.setOnCheckedChangeListener(level4);
        bi.ls08ab05.setOnCheckedChangeListener(level4);
        bi.ls08ab06.setOnCheckedChangeListener(level4);
        bi.ls08ab07.setOnCheckedChangeListener(level5);
        bi.ls08ab08.setOnCheckedChangeListener(level5);
        bi.ls08ab09.setOnCheckedChangeListener(level5);
        bi.ls08ab10.setOnCheckedChangeListener(level6);
        bi.ls08ab11.setOnCheckedChangeListener(level6);
        bi.ls08ab12.setOnCheckedChangeListener(level6);
        bi.ls08ab13.setOnCheckedChangeListener(level7);
        bi.ls08ab14.setOnCheckedChangeListener(level7);
        bi.ls08ab15.setOnCheckedChangeListener(level7);


    }

    public boolean isConditionSatisfied(Boolean a, Boolean b, Boolean c) {
        if (Objects.equals(a, true) && Objects.equals(b, true)) {
            return true;
        } else if (Objects.equals(b, true) && Objects.equals(c, true)) {
            return true;
        } else return Objects.equals(a, true) && Objects.equals(c, true);
    }

    public void BtnContinue() {
        if (formValidation()) {
            SaveDraft();
            if (UpdateDB()) {
//                startActivity(new Intent(getApplicationContext(), Form08_EF_C.class));
                startActivity(new Intent(getApplicationContext(), Form08_EF_B.class));
            } else {
                Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
            }
        }

    }

    private boolean formValidation() {
        return validatorClass.EmptyCheckingContainer(this, bi.fldGrpls08a);

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
        JSONObject Json1 = GeneratorClass.getContainerJSON(bi.fldGrpls08a, true);
        JSONObject Json2 = GeneratorClass.getContainerJSON(bi.level2, true);
        localJson = mergeJSONObjects(Json1, Json2);
        JSONObject Json3 = GeneratorClass.getContainerJSON(bi.level3, true);
        localJson = mergeJSONObjects(localJson, Json3);
        JSONObject Json4 = GeneratorClass.getContainerJSON(bi.level4, true);
        localJson = mergeJSONObjects(localJson, Json4);
        JSONObject Json5 = GeneratorClass.getContainerJSON(bi.level5, true);
        localJson = mergeJSONObjects(localJson, Json5);
        JSONObject Json6 = GeneratorClass.getContainerJSON(bi.level6, true);
        localJson = mergeJSONObjects(localJson, Json6);
        JSONObject Json7 = GeneratorClass.getContainerJSON(bi.level7, true);
        localJson = mergeJSONObjects(localJson, Json7);

        JSONObject Json8 = new JSONObject();
        try {
            Json8.put("ls08at", new SimpleDateFormat("HH:mm").format(new Date().getTime()));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        localJson = mergeJSONObjects(localJson, Json8);

        YouthInfoActivity.fc_4_5.setSa1(String.valueOf(localJson));
        Log.d("F8-EF-A", String.valueOf(localJson));
    }

    @Override
    public void onBackPressed() {

        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }
}
