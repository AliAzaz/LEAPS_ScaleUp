package com.example.hassannaqvi.leaps_scaleup.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.hassannaqvi.leaps_scaleup.R;
import com.example.hassannaqvi.leaps_scaleup.RMOperations.crudOperations;
import com.example.hassannaqvi.leaps_scaleup.core.MainApp;
import com.example.hassannaqvi.leaps_scaleup.data.DAO.FormsDAO;
import com.example.hassannaqvi.leaps_scaleup.databinding.ActivityForm6AnthroBinding;
import com.example.hassannaqvi.leaps_scaleup.validation.validatorClass;
import com.shashank.sony.fancytoastlib.FancyToast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

import static com.example.hassannaqvi.leaps_scaleup.ui.LoginActivity.db;

public class Form6AnthroActivity extends AppCompatActivity {


    ActivityForm6AnthroBinding bi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_form6_anthro);
        bi.setCallback(this);

        this.setTitle(R.string.ls06Heading);

        this.setTitle(R.string.ls06Heading);
    }

    public void BtnContinue() {

        if (formValidation()) {
            try {
                SaveDraft();

                if (UpdateDB()) {
                    MainApp.endActivity(this, this, EndingActivity.class, true, InfoActivity.fc_4_5);
                } else {
                    FancyToast.makeText(this, "Error in updating db!!", FancyToast.LENGTH_SHORT, FancyToast.ERROR, false).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
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

    private void SaveDraft() throws JSONException {

        JSONObject sF6 = new JSONObject();

        sF6.put("ls0601", bi.ls0601.getText().toString());
        sF6.put("ls0602", bi.ls0602.getText().toString());
        sF6.put("ls0603", bi.ls0603.getText().toString());
        sF6.put("ls0604", bi.ls0604.getText().toString());

        InfoActivity.fc_4_5.setSa1(String.valueOf(sF6));

    }

    private boolean formValidation() {

        if (!validatorClass.EmptyTextBox(this, bi.ls0601, getString(R.string.ls0601))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.ls0602, getString(R.string.ls0602))) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.ls0603, getString(R.string.ls0603))) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.ls0604, getString(R.string.ls0604))) {
            return false;
        }

        FancyToast.makeText(this, "Section Validated", FancyToast.LENGTH_SHORT, FancyToast.SUCCESS, false).show();
        return true;
    }

    public void BtnEnd() {
        MainApp.endActivity(this, this, EndingActivity.class, false, InfoActivity.fc_4_5);
    }

    @Override
    public void onBackPressed() {

        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }
}