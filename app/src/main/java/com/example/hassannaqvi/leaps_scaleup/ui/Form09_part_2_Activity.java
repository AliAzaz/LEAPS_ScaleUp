package com.example.hassannaqvi.leaps_scaleup.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.hassannaqvi.leaps_scaleup.JSON.GeneratorClass;
import com.example.hassannaqvi.leaps_scaleup.R;
import com.example.hassannaqvi.leaps_scaleup.RMOperations.CrudOperations;
import com.example.hassannaqvi.leaps_scaleup.core.MainApp;
import com.example.hassannaqvi.leaps_scaleup.data.DAO.FormsDAO;
import com.example.hassannaqvi.leaps_scaleup.databinding.ActivityForm09Part2Binding;
import com.example.hassannaqvi.leaps_scaleup.validation.ClearClass;
import com.example.hassannaqvi.leaps_scaleup.validation.validatorClass;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

import static com.example.hassannaqvi.leaps_scaleup.ui.LoginActivity.db;

public class Form09_part_2_Activity extends AppCompatActivity {

    ActivityForm09Part2Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_form09_part_2_);
        bi.setCallback(this);



        bi.ls09efaa05a.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if(i == bi.ls09efaa05a01.getId()){
                    ClearClass.ClearAllCardFields(bi.fldgrplspl05b);
                }else{
                    ClearClass.ClearAllCardFields(bi.fldgrplspl05b);
                }
            }
        });
    }

    public void BtnContinue() {
        //startActivity(new Intent(getApplicationContext(), Form02HHPart_2_HI_SE.class).putExtra("complete", true));
        if (formValidation()) {
            Toast.makeText(this, "validated", Toast.LENGTH_SHORT).show();
            try {
                SaveDraft();
                if (UpdateDB()) {
                    startActivity(new Intent(getApplicationContext(), Form09_part_3_4_5_Activity.class).putExtra("complete", true));
                } else {
                    Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void SaveDraft() throws JSONException {

        JSONObject Json = GeneratorClass.getContainerJSON(bi.fldgrpform04part02, true);

        //InfoActivity.fc_4_5.setSa3(String.valueOf(Json));
        YouthInfoActivity.fc_4_5.setSa2(String.valueOf(Json));

        Log.d("F5-BA", String.valueOf(Json));
    }

    private boolean UpdateDB() {
        try {
            Long longID = new CrudOperations(db, YouthInfoActivity.fc_4_5).execute(FormsDAO.class.getName(), "formsDao", "updateForm_04_05").get();
            return longID == 1;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return false;
    }

    private boolean formValidation() {


        if (!validatorClass.EmptyRadioButton(this, bi.ls09efaa01, bi.ls09efaa01a, getString(R.string.ls09efaa01))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09efaa02, bi.ls09efaa02a, getString(R.string.ls09efaa02))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09efaa03, bi.ls09efaa03a, getString(R.string.ls09efaa03))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09efaa04, bi.ls09efaa04a, getString(R.string.ls09efaa04))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.ls09efaa05a, bi.ls09efaa05a01, getString(R.string.ls09efaa05a))) {
            return false;
        }
        if (bi.ls09efaa05a01.isChecked()) {
            if (!validatorClass.EmptyRadioButton(this, bi.ls09efaa05b, bi.ls09efaa05b01, getString(R.string.ls09efaa05b))) {
                return false;
            }
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09efaa06, bi.ls09efaa06a, getString(R.string.ls09efaa06))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09efaa07, bi.ls09efaa07a, getString(R.string.ls09efaa07))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09efaa08, bi.ls09efaa08a, getString(R.string.ls09efaa08))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09efaa09, bi.ls09efaa09a, getString(R.string.ls09efaa09))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09efaa10a, bi.ls09efaa10a01, getString(R.string.ls09efaa10a))) {
            return false;
        }
        if (bi.ls09efaa10a01.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.ls09efaa10b, getString(R.string.ls09efaa10b))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.ls09efaa11, bi.ls09efaa11a, getString(R.string.ls09efaa11))) {
                return false;
            }
        }

        if (!validatorClass.EmptyRadioButton(this, bi.ls09efaa12, bi.ls09efaa12a, getString(R.string.ls09efaa12))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09efaa13a, bi.ls09efaa13a01, getString(R.string.ls09efaa13a))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09efaa13b, bi.ls09efaa13b01, getString(R.string.ls09efaa13b))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09efaa14, bi.ls09efaa14a, getString(R.string.ls09efaa14))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls09efaa15, bi.ls09efaa15a, getString(R.string.ls09efaa15))) {
            return false;
        }
        return validatorClass.EmptyRadioButton(this, bi.ls09efaa16, bi.ls09efaa16a, getString(R.string.ls09efaa16));
    }

    public void BtnEnd() {
        MainApp.endActivity(this, this, EndingActivity.class, false, YouthInfoActivity.fc_4_5);

    }
}
