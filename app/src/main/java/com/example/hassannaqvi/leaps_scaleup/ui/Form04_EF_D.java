package com.example.hassannaqvi.leaps_scaleup.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;

import com.example.hassannaqvi.leaps_scaleup.JSON.GeneratorClass;
import com.example.hassannaqvi.leaps_scaleup.R;
import com.example.hassannaqvi.leaps_scaleup.RMOperations.crudOperations;
import com.example.hassannaqvi.leaps_scaleup.core.MainApp;
import com.example.hassannaqvi.leaps_scaleup.data.DAO.FormsDAO;
import com.example.hassannaqvi.leaps_scaleup.databinding.ActivityForm04EfDBinding;
import com.example.hassannaqvi.leaps_scaleup.validation.validatorClass;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static com.example.hassannaqvi.leaps_scaleup.ui.LoginActivity.db;
import static com.example.hassannaqvi.leaps_scaleup.utils.JsonUtils.mergeJSONObjects;

public class Form04_EF_D extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    ActivityForm04EfDBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_form04_ef_d);
        bi.setCallback(this);
        this.setTitle(R.string.ls04d);
        validatorClass.setScrollViewFocus(bi.efDScrollview);
//        bi.ls04da01a.setOnClickListener(practiceTrialListener);
        bi.ls04da01a.setOnCheckedChangeListener(this);
        bi.ls04da01b.setOnCheckedChangeListener(this);
        bi.ls04da02a.setOnCheckedChangeListener(this);
        bi.ls04da02b.setOnCheckedChangeListener(this);
        bi.ls04da03a.setOnCheckedChangeListener(this);
        bi.ls04da03b.setOnCheckedChangeListener(this);
        bi.ls04da04a.setOnCheckedChangeListener(this);
        bi.ls04da04b.setOnCheckedChangeListener(this);


    }

    public void BtnEnd() {
        MainApp.endActivity(this, this, EndingActivity.class, false, InfoActivity.fc_4_5);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        String qID = getResources().getResourceEntryName(group.getId());
        if (group.getCheckedRadioButtonId() == -1) {
        } else {
            RadioButton selectedbtn = findViewById(group.getCheckedRadioButtonId());
            if (getlastCharacter(qID) == 'a') {
                CardView fldgrp = findViewById(getResources().getIdentifier("fldgrp" + qID, "id", getPackageName()));
                String ques = qID.substring(0, qID.length() - 1);
                String nextqID = ques + "b";
                RadioGroup nextRadio = findViewById(getResources().getIdentifier(nextqID, "id", getPackageName()));
                skipPractice(selectedbtn.getText().toString(), fldgrp, getStringbyIdName(this, ques + "pattern"), nextRadio);
            }
        }

    }

    public void BtnContinue() {
        if (formValidation()) {
            SaveDraft();
            if (UpdateDB()) {
                startActivity(new Intent(getApplicationContext(), Form04_EF_E.class));
            } else {
                Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
            }
        }

    }

    private boolean UpdateDB() {
        /*for temporary testing purpose*/
//        db = AppDatabase.getDatabase(getApplicationContext());

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

        JSONObject Json = GeneratorClass.getContainerJSON(bi.flgGrpls04d, true);
        JSONObject Json2 = GeneratorClass.getContainerJSON(bi.fldgrpadmin, true);
        localJson = mergeJSONObjects(Json, Json2);

        JSONObject Json3 = new JSONObject();
        try {
            Json3.put("ls04dt", new SimpleDateFormat("HH:mm").format(new Date().getTime()));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        localJson = mergeJSONObjects(localJson, Json3);
        InfoActivity.fc_4_5.setSa4(String.valueOf(localJson));
       /*
        For Testing purpose
        Forms_04_05 fc_4_5 = new Forms_04_05();
        fc_4_5.setSa4(String.valueOf(Json));*/

        Log.d("F4-D", String.valueOf(localJson));
    }

    private boolean formValidation() {

        return validatorClass.EmptyCheckingContainer(this, bi.flgGrpls04d);
    }

    char getlastCharacter(String value) {
        return value.charAt(value.length() - 1);
    }


    /*   public void processButton(View v) {

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
*/
    public static String getStringbyIdName(Context context, String name) {
        Resources res = context.getResources();
        return res.getString(res.getIdentifier(name, "string", context.getPackageName()));
    }

    public void skipPractice(String selectedbtnTxt, CardView fldGrp, String pattern, RadioGroup nextRadio) {
        if (selectedbtnTxt.equals(pattern)) {
            fldGrp.setVisibility(View.GONE);
            nextRadio.clearCheck();
        } else {
            fldGrp.setVisibility(View.VISIBLE);
        }
        if (bi.ls04da01a.getCheckedRadioButtonId() != -1 && bi.ls04da02a.getCheckedRadioButtonId() != -1) {

            RadioButton btn01 = findViewById(bi.ls04da01a.getCheckedRadioButtonId());
            RadioButton btn02 = findViewById(bi.ls04da02a.getCheckedRadioButtonId());

            if (btn01.getText().toString().equals(getResources().getString(R.string.ls04da01pattern)) && btn02.getText().toString().equals(getResources().getString(R.string.ls04da02pattern))) {
                bi.fldgrpadmin.setVisibility(GONE);
                bi.ls04da03a.clearCheck();
                bi.ls04da04a.clearCheck();
            } else {
                bi.fldgrpadmin.setVisibility(VISIBLE);
            }
        }

    }

    @Override
    public void onBackPressed() {

        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }


}
