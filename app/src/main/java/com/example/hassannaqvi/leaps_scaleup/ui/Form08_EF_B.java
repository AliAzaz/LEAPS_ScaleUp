package com.example.hassannaqvi.leaps_scaleup.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.hassannaqvi.leaps_scaleup.JSON.GeneratorClass;
import com.example.hassannaqvi.leaps_scaleup.R;
import com.example.hassannaqvi.leaps_scaleup.RMOperations.crudOperations;
import com.example.hassannaqvi.leaps_scaleup.core.MainApp;
import com.example.hassannaqvi.leaps_scaleup.data.DAO.FormsDAO;
import com.example.hassannaqvi.leaps_scaleup.databinding.ActivityForm08EfABinding;
import com.example.hassannaqvi.leaps_scaleup.databinding.ActivityForm08EfBBinding;
import com.example.hassannaqvi.leaps_scaleup.validation.validatorClass;

import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

import static com.example.hassannaqvi.leaps_scaleup.ui.LoginActivity.db;
import static com.example.hassannaqvi.leaps_scaleup.utils.JsonUtils.mergeJSONObjects;

public class Form08_EF_B extends AppCompatActivity {
    ActivityForm08EfBBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_form08_ef_b);
        bi.setCallback(this);

    }

    public void BtnContinue() {
        if (formValidation()) {
            SaveDraft();
            if (UpdateDB()) {
//                startActivity(new Intent(getApplicationContext(), Form08_EF_C.class));
            } else {
                Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
            }
        }

    }

    private boolean formValidation() {
//        return validatorClass.EmptyCheckingContainer(this, bi.flgGrpls08a);
        return true;
    }

    public void BtnEnd() {
        MainApp.endActivity(this, this, EndingActivity.class, false, InfoActivity.fc_4_5);

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
       /* JSONObject localJson;
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
        Log.d("F4-EF-A", String.valueOf(localJson));*/
    }

    @Override
    public void onBackPressed() {

        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }
}
