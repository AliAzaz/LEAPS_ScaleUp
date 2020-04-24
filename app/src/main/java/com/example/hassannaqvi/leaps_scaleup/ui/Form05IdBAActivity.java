package com.example.hassannaqvi.leaps_scaleup.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.hassannaqvi.leaps_scaleup.JSON.GeneratorClass;
import com.example.hassannaqvi.leaps_scaleup.R;
import com.example.hassannaqvi.leaps_scaleup.RMOperations.crudOperations;
import com.example.hassannaqvi.leaps_scaleup.core.MainApp;
import com.example.hassannaqvi.leaps_scaleup.data.DAO.FormsDAO;
import com.example.hassannaqvi.leaps_scaleup.databinding.ActivityForm05IdBABinding;
import com.example.hassannaqvi.leaps_scaleup.validation.validatorClass;

import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

import static com.example.hassannaqvi.leaps_scaleup.ui.LoginActivity.db;

public class Form05IdBAActivity extends AppCompatActivity {

    ActivityForm05IdBABinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_form05_id_b_a);
        bi.setCallback(this);

        this.setTitle("IDELA");


        setContent();
    }

    private void setContent() {

    }

    public void BtnContinue() {

        if (formValidation()) {
            SaveDraft();
            if (UpdateDB()) {
                startActivity(new Intent(getApplicationContext(), Form05IdBBActivity.class));
            } else {
                Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public boolean UpdateDB() {
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

        JSONObject Json = GeneratorClass.getContainerJSON(bi.flgGrpf05BA01, true);

        InfoActivity.fc_4_5.setSa1(String.valueOf(Json));

        Log.d("F5-BA", String.valueOf(Json));

    }

    private boolean formValidation() {

        return validatorClass.EmptyCheckingContainer(this, bi.flgGrpf05BA01);
    }

    public void BtnEnd() {
        MainApp.endActivity(this, this, EndingActivity.class, false, InfoActivity.fc_4_5);
    }

    @Override
    public void onBackPressed() {

        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }
}
