package com.example.hassannaqvi.leaps_scaleup.ui.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.hassannaqvi.leaps_scaleup.JSON.GeneratorClass;
import com.example.hassannaqvi.leaps_scaleup.R;
import com.example.hassannaqvi.leaps_scaleup.RMOperations.crudOperations;
import com.example.hassannaqvi.leaps_scaleup.data.DAO.FormsDAO;
import com.example.hassannaqvi.leaps_scaleup.databinding.ActivityForm05IdBEBinding;
import com.example.hassannaqvi.leaps_scaleup.validation.validatorClass;

import org.json.JSONObject;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;

import static com.example.hassannaqvi.leaps_scaleup.ui.activities.LoginActivity.db;

public class Form05IdBEActivity extends AppCompatActivity {

    ActivityForm05IdBEBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_form05_id_b_e);
        bi.setCallback(this);

        setContentUI();

    }

    public void setContentUI() {

        String[] numFormat = {"....", "0", "1", "2", "3", "4"};

        bi.ls05b22a.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Arrays.asList(numFormat)));
    }

    public void BtnContinue() {

        if (formValidation()) {
            SaveDraft();
//            if (UpdateDB()) {
            if (true) {
                startActivity(new Intent(getApplicationContext(), Form05IdCActivity.class));
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

        JSONObject Json = GeneratorClass.getContainerJSON(bi.flgGrpf05BE01, true);
        InfoActivity.fc_4_5.setSa5(String.valueOf(Json));

        Log.d("F5-B-E", String.valueOf(Json));
    }
    private boolean formValidation() {

        return validatorClass.EmptyCheckingContainer(this, bi.flgGrpf05BE01);
    }

    public void BtnEnd() {
        startActivity(new Intent(this, EndingActivity.class).putExtra("complete", false));
    }
}
