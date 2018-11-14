package com.example.hassannaqvi.leaps_scaleup.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.hassannaqvi.leaps_scaleup.JSON.GeneratorClass;
import com.example.hassannaqvi.leaps_scaleup.R;
import com.example.hassannaqvi.leaps_scaleup.RMOperations.crudOperations;
import com.example.hassannaqvi.leaps_scaleup.core.MainApp;
import com.example.hassannaqvi.leaps_scaleup.data.DAO.FormsDAO;
import com.example.hassannaqvi.leaps_scaleup.databinding.ActivityForm05IdBBBinding;
import com.example.hassannaqvi.leaps_scaleup.validation.validatorClass;

import org.json.JSONObject;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;

import static com.example.hassannaqvi.leaps_scaleup.ui.LoginActivity.db;

public class Form05IdBBActivity extends AppCompatActivity {

    ActivityForm05IdBBBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_form05_id_b_b);
        bi.setCallback(this);
        this.setTitle("IDELA");

        setContentUI();
        setListeners();

    }

    private void setListeners() {

        bi.ls05b05a.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i != 0) {
                    bi.llgrpls05b05b.setVisibility(Integer.valueOf(bi.ls05b05a.getSelectedItem().toString()) < 4 ? View.GONE : View.VISIBLE);
                    bi.ls05b05b99.setChecked(false);
                    bi.ls05b05b.setSelection(0);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        bi.ls05b05b99.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.ls05b05b88.setChecked(false);
                    bi.ls05b05b88.setEnabled(false);

                    bi.ls05b05b.setSelection(0);
                    bi.ls05b05b.setEnabled(false);

                } else {
                    bi.ls05b05b88.setEnabled(true);

                    bi.ls05b05b.setEnabled(true);
                }

            }
        });

        bi.ls05b05b88.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.ls05b05b99.setChecked(false);
                    bi.ls05b05b99.setEnabled(false);

                    bi.ls05b05b.setSelection(0);
                    bi.ls05b05b.setEnabled(false);
                } else {
                    bi.ls05b05b99.setEnabled(true);

                    bi.ls05b05b.setEnabled(true);
                }

            }
        });

        bi.ls05b06a.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == bi.ls05b06a02.getId()) {
                    bi.ls05b06b.clearCheck();
                    bi.ls05b06c.clearCheck();
                }
            }
        });

        bi.ls05b06b.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == bi.ls05b06b02.getId()) {
                    bi.ls05b06c.clearCheck();
                }
            }
        });

    }

    private void setContentUI() {
        String[] numFormat = {"....", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        bi.ls05b05a.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Arrays.asList(numFormat)));
        bi.ls05b05b.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Arrays.asList(numFormat)));
        bi.ls05b08a.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Arrays.asList("....", "0", "1", "2", "3", "4", "5")));
    }

    public void BtnContinue() {

        if (formValidation()) {
            SaveDraft();
            if (UpdateDB()) {
                startActivity(new Intent(getApplicationContext(), Form05IdBCActivity.class));
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

        JSONObject Json = GeneratorClass.getContainerJSON(bi.flgGrpf05BB01, true);
        InfoActivity.fc_4_5.setSa2(String.valueOf(Json));

        Log.d("F5-BB", String.valueOf(Json));
    }

    private boolean formValidation() {

        return validatorClass.EmptyCheckingContainer(this, bi.flgGrpf05BB01);
    }

    public void BtnEnd() {
        MainApp.endActivity(this, this, EndingActivity.class, false, InfoActivity.fc_4_5);
    }

    @Override
    public void onBackPressed() {

        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }
}
