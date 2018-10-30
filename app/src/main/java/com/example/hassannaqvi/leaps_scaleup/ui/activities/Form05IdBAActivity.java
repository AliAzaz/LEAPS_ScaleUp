package com.example.hassannaqvi.leaps_scaleup.ui.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.hassannaqvi.leaps_scaleup.JSON.GeneratorClass;
import com.example.hassannaqvi.leaps_scaleup.R;
import com.example.hassannaqvi.leaps_scaleup.RMOperations.crudOperations;
import com.example.hassannaqvi.leaps_scaleup.data.DAO.FormsDAO;
import com.example.hassannaqvi.leaps_scaleup.data.entities.Forms_04_05;
import com.example.hassannaqvi.leaps_scaleup.databinding.ActivityForm05IdBABinding;
import com.example.hassannaqvi.leaps_scaleup.validation.validatorClass;

import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

import static com.example.hassannaqvi.leaps_scaleup.ui.activities.LoginActivity.db;

public class Form05IdBAActivity extends AppCompatActivity {

    ActivityForm05IdBABinding bi;

    public static Forms_04_05 fc_4_5;
    String fTYPE = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_form05_id_b_a);
        bi.setCallback(this);

        setContent();
    }

    private void setContent() {

        fTYPE = getIntent().getStringExtra("fTYPE");

    }

    public void BtnContinue() {

        if (formValidation()) {
            SaveDraft();
//            if (UpdateDB()) {
            if (UpdateDB()) {
                startActivity(new Intent(getApplicationContext(), Form05IdBBActivity.class));
            } else {
                Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public boolean UpdateDB() {
        try {

            Long longID = new crudOperations(db, fc_4_5).execute(FormsDAO.class.getName(), "formsDao", "insertForm_04_05").get();

            if (longID != 0) {
                fc_4_5.setId(longID.intValue());
                return true;
            } else {
                return false;
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return false;
    }

    private void SaveDraft() {

        fc_4_5 = new Forms_04_05();

        fc_4_5.setFormType(fTYPE);

        JSONObject Json = GeneratorClass.getContainerJSON(bi.flgGrpf05BA01, true);

        fc_4_5.setSa1(String.valueOf(Json));

        Log.d("F5-BA", String.valueOf(Json));

    }

    private boolean formValidation() {

        return validatorClass.EmptyCheckingContainer(this, bi.flgGrpf05BA01);
    }

    public void BtnEnd() {
        startActivity(new Intent(this, EndingActivity.class).putExtra("complete", false));
    }
}
