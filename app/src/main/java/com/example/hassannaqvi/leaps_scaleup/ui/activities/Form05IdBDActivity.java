package com.example.hassannaqvi.leaps_scaleup.ui.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.hassannaqvi.leaps_scaleup.JSON.GeneratorClass;
import com.example.hassannaqvi.leaps_scaleup.R;
import com.example.hassannaqvi.leaps_scaleup.RMOperations.crudOperations;
import com.example.hassannaqvi.leaps_scaleup.core.MainApp;
import com.example.hassannaqvi.leaps_scaleup.data.DAO.FormsDAO;
import com.example.hassannaqvi.leaps_scaleup.databinding.ActivityForm05IdBDBinding;
import com.example.hassannaqvi.leaps_scaleup.validation.validatorClass;

import org.json.JSONObject;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;

import static com.example.hassannaqvi.leaps_scaleup.ui.activities.LoginActivity.db;

public class Form05IdBDActivity extends AppCompatActivity {

    ActivityForm05IdBDBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_form05_id_b_d);
        bi.setCallback(this);
        this.setTitle("IDELA");

        setListeners();
        setContentUI();

    }

    private void setContentUI() {

        String[] numFormat = {"....", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] numFormat1 = {"....", "0", "1", "2", "3", "4"};

        bi.ls05b16a.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Arrays.asList(numFormat)));
        bi.ls05b16b.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Arrays.asList(numFormat)));
        bi.ls05b16c.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Arrays.asList(numFormat)));
        bi.ls05b16d.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Arrays.asList(numFormat)));

        bi.ls05b18a.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Arrays.asList(numFormat1)));
    }

    private void setListeners() {

        bi.ls05b16a.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i != 0) {
                    bi.llgrpls05b16b.setVisibility(Integer.valueOf(bi.ls05b16a.getSelectedItem().toString()) < 4 ? View.GONE : View.VISIBLE);
                    bi.ls05b16b99.setChecked(false);
                    bi.ls05b16b.setSelection(0);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        bi.ls05b16b99.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.ls05b16b88.setChecked(false);
                    bi.ls05b16b88.setEnabled(false);

                    bi.ls05b16b.setSelection(0);
                    bi.ls05b16b.setEnabled(false);
                } else {
                    bi.ls05b16b88.setEnabled(true);

                    bi.ls05b16b.setEnabled(true);
                }

            }
        });

        bi.ls05b16b88.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.ls05b16b99.setChecked(false);
                    bi.ls05b16b99.setEnabled(false);


                    bi.ls05b16b.setSelection(0);
                    bi.ls05b16b.setEnabled(false);
                } else {
                    bi.ls05b16b99.setEnabled(true);

                    bi.ls05b16b.setEnabled(true);
                }

            }
        });

        bi.ls05b16c.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i != 0) {
                    bi.llgrpls05b16d.setVisibility(Integer.valueOf(bi.ls05b16c.getSelectedItem().toString()) < 4 ? View.GONE : View.VISIBLE);
                    bi.ls05b16d99.setChecked(false);
                    bi.ls05b16d.setSelection(0);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        bi.ls05b16d99.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.ls05b16d88.setChecked(false);
                    bi.ls05b16d88.setEnabled(false);

                    bi.ls05b16d.setSelection(0);
                    bi.ls05b16d.setEnabled(false);
                } else {
                    bi.ls05b16d88.setEnabled(true);

                    bi.ls05b16d.setEnabled(true);
                }

            }
        });

        bi.ls05b16d88.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.ls05b16d99.setChecked(false);
                    bi.ls05b16d99.setEnabled(false);

                    bi.ls05b16d.setSelection(0);
                    bi.ls05b16d.setEnabled(false);
                } else {
                    bi.ls05b16d99.setEnabled(true);

                    bi.ls05b16d.setEnabled(true);
                }

            }
        });

    }

    public void BtnContinue() {

        if (formValidation()) {
            SaveDraft();
            if (UpdateDB()) {
                startActivity(new Intent(getApplicationContext(), Form05IdBEActivity.class));
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

        JSONObject Json = GeneratorClass.getContainerJSON(bi.flgGrpf05BD01, true);
        InfoActivity.fc_4_5.setSa4(String.valueOf(Json));

        Log.d("F5-BD", String.valueOf(Json));
    }

    private boolean formValidation() {

        return validatorClass.EmptyCheckingContainer(this, bi.flgGrpf05BD01);
    }

    public void BtnEnd() {
        MainApp.endActivity(this, this, EndingActivity.class, false, InfoActivity.fc_4_5);
    }

    @Override
    public void onBackPressed() {

        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }
}
