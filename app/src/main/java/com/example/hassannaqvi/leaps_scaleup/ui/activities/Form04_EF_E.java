package com.example.hassannaqvi.leaps_scaleup.ui.activities;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.hassannaqvi.leaps_scaleup.JSON.GeneratorClass;
import com.example.hassannaqvi.leaps_scaleup.R;
import com.example.hassannaqvi.leaps_scaleup.RMOperations.crudOperations;
import com.example.hassannaqvi.leaps_scaleup.data.DAO.FormsDAO;
import com.example.hassannaqvi.leaps_scaleup.databinding.ActivityForm04EfABinding;
import com.example.hassannaqvi.leaps_scaleup.databinding.ActivityForm04EfEBinding;
import com.example.hassannaqvi.leaps_scaleup.validation.validatorClass;

import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

import static com.example.hassannaqvi.leaps_scaleup.ui.activities.LoginActivity.db;

public class Form04_EF_E extends AppCompatActivity {
ActivityForm04EfEBinding bi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this,R.layout.activity_form04_ef_e);
        bi.setCallback(this);
        validatorClass.setScrollViewFocus(bi.efEScrollview);
    }
    public void BtnEnd() {
        startActivity(new Intent(this, EndingActivity.class).putExtra("complete", false));
    }

    public void BtnContinue() {
        if (formValidation()) {
            SaveDraft();
            if (UpdateDB()) {
                startActivity(new Intent(getApplicationContext(), EndingActivity.class).putExtra("complete", true));
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
        JSONObject Json = GeneratorClass.getContainerJSON(bi.flgGrpls04e, true);
        InfoActivity.fc_4_5.setSa5(String.valueOf(Json));
       /*
        For Testing purpose
        Forms_04_05 fc_4_5 = new Forms_04_05();
        fc_4_5.setSa5(String.valueOf(Json));*/

        Log.d("F4-D", String.valueOf(Json));
    }
    private boolean formValidation() {

        return validatorClass.EmptyCheckingContainer(this, bi.flgGrpls04e);
    }

}
