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
import com.example.hassannaqvi.leaps_scaleup.databinding.ActivityForm08EfDBinding;
import com.example.hassannaqvi.leaps_scaleup.validation.validatorClass;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;

import static com.example.hassannaqvi.leaps_scaleup.ui.LoginActivity.db;
import static com.example.hassannaqvi.leaps_scaleup.utils.JsonUtils.mergeJSONObjects;

public class Form08_EF_D extends AppCompatActivity {

    ActivityForm08EfDBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_form08_ef_d);
        bi.setCallback(this);
        this.setTitle(R.string.ls08d);

    }


    public void BtnContinue() {
        if (formValidation()) {
            SaveDraft();
            if (UpdateDB()) {
                startActivity(new Intent(getApplicationContext(), Form08_EF_E.class));
            } else {
                Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
            }
        }

    }

    private boolean formValidation() {
        return validatorClass.EmptyCheckingContainer(this, bi.flgGrpls08d);
        //return true;
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

        JSONObject Json1 = GeneratorClass.getContainerJSON(bi.flgGrpls08d, true);

        JSONObject Json9 = new JSONObject();
        try {
            Json9.put("ls08dt", new SimpleDateFormat("HH:mm").format(new Date().getTime()));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        localJson = mergeJSONObjects(Json1, Json9);
        YouthInfoActivity.fc_4_5.setSa4(String.valueOf(localJson));

        Log.d("F8-EA_D", String.valueOf(localJson));
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }
}