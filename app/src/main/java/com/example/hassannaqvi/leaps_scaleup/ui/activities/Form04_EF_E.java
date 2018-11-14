package com.example.hassannaqvi.leaps_scaleup.ui.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.hassannaqvi.leaps_scaleup.JSON.GeneratorClass;
import com.example.hassannaqvi.leaps_scaleup.R;
import com.example.hassannaqvi.leaps_scaleup.RMOperations.crudOperations;
import com.example.hassannaqvi.leaps_scaleup.core.MainApp;
import com.example.hassannaqvi.leaps_scaleup.data.DAO.FormsDAO;
import com.example.hassannaqvi.leaps_scaleup.databinding.ActivityForm04EfEBinding;
import com.example.hassannaqvi.leaps_scaleup.validation.ClearClass;
import com.example.hassannaqvi.leaps_scaleup.validation.validatorClass;

import org.json.JSONObject;

import java.lang.reflect.Field;
import java.util.concurrent.ExecutionException;

import static com.example.hassannaqvi.leaps_scaleup.ui.activities.LoginActivity.db;

public class Form04_EF_E extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    ActivityForm04EfEBinding bi;
    int ls04e1c01, ls04e1c02, ls04e1c03, ls04e1c04, ls04e1c05, ls04e1c06, ls04e1c07, ls04e1c08, ls04e1c09, ls04e1c10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_form04_ef_e);
        bi.setCallback(this);
        this.setTitle(R.string.ls04e);
        validatorClass.setScrollViewFocus(bi.efEScrollview);
        attachingListners();
    }

    public void BtnEnd() {
        MainApp.endActivity(this, this, EndingActivity.class, false, InfoActivity.fc_4_5);
    }

    public void attachingListners() {
        bi.ls04e1c01.setOnCheckedChangeListener(this);
        bi.ls04e1c02.setOnCheckedChangeListener(this);
        bi.ls04e1c03.setOnCheckedChangeListener(this);
        bi.ls04e1c04.setOnCheckedChangeListener(this);
        bi.ls04e1c05.setOnCheckedChangeListener(this);
        bi.ls04e1c06.setOnCheckedChangeListener(this);
        bi.ls04e1c07.setOnCheckedChangeListener(this);
        bi.ls04e1c08.setOnCheckedChangeListener(this);
        bi.ls04e1c09.setOnCheckedChangeListener(this);
        bi.ls04e1c10.setOnCheckedChangeListener(this);
    }

    public void BtnContinue() {
        if (formValidation()) {
            SaveDraft();
            if (UpdateDB()) {
                MainApp.endActivity(this, this, EndingActivity.class, true, InfoActivity.fc_4_5);
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

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        RadioButton radioButton = findViewById(group.getCheckedRadioButtonId());
        String radiogrpID = getResources().getResourceEntryName(group.getId());
        if (radioButton.getText().toString().equals(getResources().getIdentifier(radiogrpID + "pattern", "id", getPackageName()))) {

            showHideLevel2(radiogrpID, 2);

        } else if (radioButton.getText().toString().equals(getString(R.string.selfcorrect))) {

            showHideLevel2(radiogrpID, 1);

        } else {

            showHideLevel2(radiogrpID, 0);

        }
    }

    public void setVariable(String variableName, int value)
            throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        Field field = this.getClass().getDeclaredField(variableName);
        field.setAccessible(true);
        field.set(this, value);
    }

    public void showHideLevel2(String radiogrpID, int value) {
        try {
            setVariable(radiogrpID, value);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        int total = ls04e1c01 + ls04e1c02 + ls04e1c03 + ls04e1c04 + ls04e1c05 + ls04e1c06 + ls04e1c07 + ls04e1c08 + ls04e1c09 + ls04e1c10;
        if (total >= 5) {
            bi.level2.setVisibility(View.VISIBLE);
        } else {
            bi.level2.setVisibility(View.GONE);
            ClearClass.ClearAllFields(bi.level2, false);
        }
    }

}
