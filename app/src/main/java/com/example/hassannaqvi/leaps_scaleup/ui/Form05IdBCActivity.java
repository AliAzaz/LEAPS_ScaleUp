package com.example.hassannaqvi.leaps_scaleup.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.hassannaqvi.leaps_scaleup.JSON.GeneratorClass;
import com.example.hassannaqvi.leaps_scaleup.R;
import com.example.hassannaqvi.leaps_scaleup.RMOperations.crudOperations;
import com.example.hassannaqvi.leaps_scaleup.core.MainApp;
import com.example.hassannaqvi.leaps_scaleup.data.DAO.FormsDAO;
import com.example.hassannaqvi.leaps_scaleup.databinding.ActivityForm05IdBCBinding;
import com.example.hassannaqvi.leaps_scaleup.validation.validatorClass;

import org.json.JSONObject;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;

import static com.example.hassannaqvi.leaps_scaleup.ui.LoginActivity.db;

public class Form05IdBCActivity extends AppCompatActivity {

    ActivityForm05IdBCBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_form05_id_b_c);
        bi.setCallback(this);

        this.setTitle("IDELA");
        setContentUI();

    }

    public void setContentUI() {

        String[] numFormat = {"....", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

        bi.ls05b09a.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Arrays.asList(numFormat)));
        bi.ls05b14a.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Arrays.asList(numFormat)));
        bi.ls05b14b.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Arrays.asList(numFormat)));
    }

    public void BtnContinue() {

        if (formValidation()) {
            SaveDraft();
            if (UpdateDB()) {
                startActivity(new Intent(getApplicationContext(), Form05IdBDActivity.class));
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

        JSONObject Json = GeneratorClass.getContainerJSON(bi.flgGrpf05BC01, true);
        InfoActivity.fc_4_5.setSa3(String.valueOf(Json));

        Log.d("F5-BC", String.valueOf(Json));
    }

    private boolean formValidation() {
        return validatorClass.EmptyCheckingContainer(this, bi.flgGrpf05BC01);
    }

    public void BtnEnd() {
        MainApp.endActivity(this, this, EndingActivity.class, false, InfoActivity.fc_4_5);
    }

    @Override
    public void onBackPressed() {

        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }
}
