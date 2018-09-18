package com.example.hassannaqvi.wfppishincr.ui.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.hassannaqvi.wfppishincr.R;
import com.example.hassannaqvi.wfppishincr.core.DatabaseHelper;
import com.example.hassannaqvi.wfppishincr.core.MainApp;
import com.example.hassannaqvi.wfppishincr.databinding.ActivitySectionDEFBinding;
import com.example.hassannaqvi.wfppishincr.validation.validatorClass;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

public class SectionDEFActivity extends AppCompatActivity {


    ActivitySectionDEFBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_d_e_f);
        bi.setCallback(this);
        this.setTitle("Section D,E,F");

        //Setting user's spinners

        bi.ccd0101.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Arrays.asList(MainActivity.usersArray)));
        bi.ccd0102.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Arrays.asList(MainActivity.usersArray)));
        bi.ccd0201.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Arrays.asList(MainActivity.usersArray)));
        bi.ccd0202.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Arrays.asList(MainActivity.usersArray)));
        bi.cce0101.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Arrays.asList(MainActivity.usersArray)));
        bi.cce0102.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Arrays.asList(MainActivity.usersArray)));
        bi.cce0201.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Arrays.asList(MainActivity.usersArray)));
        bi.cce0202.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Arrays.asList(MainActivity.usersArray)));
        bi.ccf0101.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Arrays.asList(MainActivity.usersArray)));
        bi.ccf0102.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Arrays.asList(MainActivity.usersArray)));
        bi.ccf0201.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Arrays.asList(MainActivity.usersArray)));
        bi.ccf0202.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Arrays.asList(MainActivity.usersArray)));


        bi.ccf01.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.fldgrpFatherAnthro.setVisibility(View.GONE);
                    bi.ccf01cm01.setText(null);
                    bi.ccf01cm02.setText(null);
                    bi.ccf02kg01.setText(null);
                    bi.ccf02kg02.setText(null);
                    bi.ccf0101.setSelection(0);
                    bi.ccf0102.setSelection(0);
                    bi.ccf0201.setSelection(0);
                    bi.ccf0202.setSelection(0);

                } else {
                    bi.fldgrpFatherAnthro.setVisibility(View.VISIBLE);
                }
            }
        });
    }


    public void BtnContinue() {

        if (formValidate()) {

            try {
                saveData();
                if (updateDb()) {
                    Intent secNext = new Intent(this, SectionGHActivity.class);
                    secNext.putExtra("check", false);
                    startActivity(secNext);
                    finish();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }


    }

    public boolean updateDb() {
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSDEF();

        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private boolean formValidate() {

        //=================================child================================
        if (!validatorClass.EmptySpinner(this, bi.ccd0101, getString(R.string.ccd01))) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.ccd01cm01, getString(R.string.ccd01))) {
            return false;
        }
        if (!bi.ccd01cm01.getText().toString().matches("^(\\d{1,3}\\.\\d{1,1})$")) {
            bi.ccd01cm01.setError("Wrong Presentation ");
            bi.ccd01cm01.requestFocus();
            return false;
        } else {
            bi.ccd01cm01.setError(null);
            bi.ccd01cm01.clearFocus();
        }

        if (!validatorClass.EmptySpinner(this, bi.ccd0102, getString(R.string.ccd01))) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.ccd01cm02, getString(R.string.ccd01))) {
            return false;
        }
        if (!bi.ccd01cm02.getText().toString().matches("^(\\d{1,3}\\.\\d{1,1})$")) {
            bi.ccd01cm02.setError("Wrong Presentation ");
            bi.ccd01cm02.requestFocus();
            return false;
        } else {
            bi.ccd01cm02.setError(null);
            bi.ccd01cm02.clearFocus();
        }

        ///---------------------------Weight------------------------------------------

        if (!validatorClass.EmptySpinner(this, bi.ccd0201, getString(R.string.ccd02))) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.ccd02kg01, getString(R.string.ccd02))) {
            return false;
        }
        if (!bi.ccd02kg01.getText().toString().matches("^(\\d{1,3}\\.\\d{1,1})$")) {
            bi.ccd02kg01.setError("Wrong Presentation ");
            bi.ccd02kg01.requestFocus();
            return false;
        } else {
            bi.ccd02kg01.setError(null);
            bi.ccd02kg01.clearFocus();
        }

        if (!validatorClass.EmptySpinner(this, bi.ccd0202, getString(R.string.ccd02))) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.ccd02kg02, getString(R.string.ccd02))) {
            return false;
        }
        if (!bi.ccd02kg02.getText().toString().matches("^(\\d{1,3}\\.\\d{1,1})$")) {
            bi.ccd02kg02.setError("Wrong Presentation ");
            bi.ccd02kg02.requestFocus();
            return false;
        } else {
            bi.ccd02kg02.setError(null);
            bi.ccd02kg02.clearFocus();
        }

        //======================Mother=======================================================
        if (!validatorClass.EmptySpinner(this, bi.cce0101, getString(R.string.ccd01))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.cce01cm01, getString(R.string.ccd01))) {
            return false;
        }
        if (!bi.cce01cm01.getText().toString().matches("^(\\d{1,3}\\.\\d{1,1})$")) {
            bi.cce01cm01.setError("Wrong Presentation ");
            bi.cce01cm01.requestFocus();
            return false;
        } else {
            bi.cce01cm01.setError(null);
            bi.cce01cm01.clearFocus();
        }

        if (!validatorClass.EmptySpinner(this, bi.cce0102, getString(R.string.ccd01))) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.cce01cm02, getString(R.string.ccd01))) {
            return false;
        }
        if (!bi.cce01cm02.getText().toString().matches("^(\\d{1,3}\\.\\d{1,1})$")) {
            bi.cce01cm02.setError("Wrong Presentation ");
            bi.cce01cm02.requestFocus();
            return false;
        } else {
            bi.cce01cm02.setError(null);
            bi.cce01cm02.clearFocus();
        }

        ///------------------------Weight------------------------------------------

        if (!validatorClass.EmptySpinner(this, bi.cce0201, getString(R.string.ccd02))) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.cce02kg01, getString(R.string.ccd02))) {
            return false;
        }
        if (!bi.cce02kg01.getText().toString().matches("^(\\d{1,3}\\.\\d{1,1})$")) {
            bi.cce02kg01.setError("Wrong Presentation ");
            bi.cce02kg01.requestFocus();
            return false;
        } else {
            bi.cce02kg01.setError(null);
            bi.cce02kg01.clearFocus();
        }

        if (!validatorClass.EmptySpinner(this, bi.cce0202, getString(R.string.ccd02))) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.cce02kg02, getString(R.string.ccd02))) {
            return false;
        }
        if (!bi.cce02kg02.getText().toString().matches("^(\\d{1,3}\\.\\d{1,1})$")) {
            bi.cce02kg02.setError("Wrong Presentation ");
            bi.cce02kg02.requestFocus();
            return false;
        } else {
            bi.cce02kg02.setError(null);
            bi.cce02kg02.clearFocus();
        }

        //===================================Father================================

        if (!bi.ccf01.isChecked()) {

            if (!validatorClass.EmptySpinner(this, bi.ccf0101, getString(R.string.ccd01))) {
                return false;
            }

            if (!validatorClass.EmptyTextBox(this, bi.ccf01cm01, getString(R.string.ccd01))) {
                return false;
            }
            if (!bi.ccf01cm01.getText().toString().matches("^(\\d{1,3}\\.\\d{1,1})$")) {
                bi.ccf01cm01.setError("Wrong Presentation ");
                bi.ccf01cm01.requestFocus();
                return false;
            } else {
                bi.ccf01cm01.setError(null);
                bi.ccf01cm01.clearFocus();
            }

            if (!validatorClass.EmptySpinner(this, bi.ccf0102, getString(R.string.ccd01))) {
                return false;
            }
            if (!validatorClass.EmptyTextBox(this, bi.ccf01cm02, getString(R.string.ccd01))) {
                return false;
            }
            if (!bi.ccf01cm02.getText().toString().matches("^(\\d{1,3}\\.\\d{1,1})$")) {
                bi.ccf01cm02.setError("Wrong Presentation ");
                bi.ccf01cm02.requestFocus();
                return false;
            } else {
                bi.ccf01cm02.setError(null);
                bi.ccf01cm02.clearFocus();
            }

            ///------------------------Weight------------------------------------------

            if (!validatorClass.EmptySpinner(this, bi.ccf0201, getString(R.string.ccd02))) {
                return false;
            }
            if (!validatorClass.EmptyTextBox(this, bi.ccf02kg01, getString(R.string.ccd02))) {
                return false;
            }
            if (!bi.ccf02kg01.getText().toString().matches("^(\\d{1,3}\\.\\d{1,1})$")) {
                bi.ccf02kg01.setError("Wrong Presentation ");
                bi.ccf02kg01.requestFocus();
                return false;
            } else {
                bi.ccf02kg01.setError(null);
                bi.ccf02kg01.clearFocus();
            }

            if (!validatorClass.EmptySpinner(this, bi.ccf0202, getString(R.string.ccd02))) {
                return false;
            }
            if (!validatorClass.EmptyTextBox(this, bi.ccf02kg02, getString(R.string.ccd02))) {
                return false;
            }
            if (!bi.ccf02kg02.getText().toString().matches("^(\\d{1,3}\\.\\d{1,1})$")) {
                bi.ccf02kg02.setError("Wrong Presentation ");
                bi.ccf02kg02.requestFocus();
                return false;
            } else {
                bi.ccf02kg02.setError(null);
                bi.ccf02kg02.clearFocus();
            }


        }
        return true;
    }

    private void saveData() throws JSONException {
        JSONObject sDEF = new JSONObject();

        sDEF.put("ccd01cm01", bi.ccd01cm01.getText().toString());
        sDEF.put("ccd01a", bi.ccd0101.getSelectedItem().toString());
        sDEF.put("ccd01cm02", bi.ccd01cm02.getText().toString());
        sDEF.put("ccd01b", bi.ccd0102.getSelectedItem().toString());

        sDEF.put("ccd02kg01", bi.ccd02kg01.getText().toString());
        sDEF.put("ccd02a", bi.ccd0201.getSelectedItem().toString());
        sDEF.put("ccd02kg02", bi.ccd02kg02.getText().toString());
        sDEF.put("ccd02b", bi.ccd0202.getSelectedItem().toString());

        sDEF.put("cce01cm01", bi.cce01cm01.getText().toString());
        sDEF.put("cce01a", bi.cce0101.getSelectedItem().toString());
        sDEF.put("cce01cm02", bi.cce01cm02.getText().toString());
        sDEF.put("cce01b", bi.cce0102.getSelectedItem().toString());

        sDEF.put("cce02kg01", bi.cce02kg01.getText().toString());
        sDEF.put("cce02a", bi.cce0201.getSelectedItem().toString());
        sDEF.put("cce02kg02", bi.cce02kg02.getText().toString());
        sDEF.put("cce02b", bi.cce0202.getSelectedItem().toString());

        sDEF.put("ccf01cm01", bi.ccf01cm01.getText().toString());
        sDEF.put("ccf01a", bi.ccf0101.getSelectedItem().toString());
        sDEF.put("ccf01cm02", bi.ccf01cm02.getText().toString());
        sDEF.put("ccf01b", bi.ccf0102.getSelectedItem().toString());

        sDEF.put("ccf02kg01", bi.ccf02kg01.getText().toString());
        sDEF.put("ccf02a", bi.ccf0201.getSelectedItem().toString());
        sDEF.put("ccf02kg02", bi.ccf02kg02.getText().toString());
        sDEF.put("ccf02b", bi.ccf0202.getSelectedItem().toString());
        MainApp.fc.setsDEF(String.valueOf(sDEF));
        Toast.makeText(this, "Validation Succecful", Toast.LENGTH_SHORT).show();
    }

    public void BtnEnd() {

        MainApp.endActivity(this, this);

    }

}
