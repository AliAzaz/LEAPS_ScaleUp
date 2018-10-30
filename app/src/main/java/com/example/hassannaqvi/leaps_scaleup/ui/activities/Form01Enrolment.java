package com.example.hassannaqvi.leaps_scaleup.ui.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.hassannaqvi.leaps_scaleup.R;
import com.example.hassannaqvi.leaps_scaleup.RMOperations.crudOperations;
import com.example.hassannaqvi.leaps_scaleup.data.entities.Forms;
import com.example.hassannaqvi.leaps_scaleup.databinding.ActivityForm01EnrolmentBinding;
import com.example.hassannaqvi.leaps_scaleup.other.CheckingID;
import com.example.hassannaqvi.leaps_scaleup.validation.ClearClass;
import com.example.hassannaqvi.leaps_scaleup.validation.validatorClass;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static com.example.hassannaqvi.leaps_scaleup.ui.activities.LoginActivity.db;

public class Form01Enrolment extends AppCompatActivity {
    ActivityForm01EnrolmentBinding bi;
    public static Forms fc;

    String getFtype = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_form01_enrolment);
        bi.setCallback(this);
        this.setTitle(R.string.ls01aheading);

        setupView();
        bi.ls01f03.setManager(getSupportFragmentManager());
//        bi.ls01f05.setManager(getSupportFragmentManager());
        bi.ls01a10.setManager(getSupportFragmentManager());


        getFtype = getIntent().getStringExtra("fType");

    }

    private void setupView() {
        bi.ls01f04.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.ls01f04a) {
                    bi.fldgrpls01f03.setVisibility(VISIBLE);
                    bi.fldgrpls01f05.setVisibility(GONE);
                } else {
                    bi.fldgrpls01f03.setVisibility(GONE);
                    bi.fldgrpls01f05.setVisibility(VISIBLE);
                    bi.ls01f03.setText(null);
                }
            }
        });
        bi.ls01a07.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.ls01a07a) {
                    bi.fldgrpls01a07.setVisibility(GONE);
                    ClearClass.ClearAllFields(bi.fldgrpls01a07, false);
                } else {
                    bi.fldgrpls01a07.setVisibility(VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpls01a07, true);
                }
            }
        });
        bi.ls01a08.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != R.id.ls01a08a) {
                    bi.grpls01a08.setVisibility(GONE);
                    ClearClass.ClearAllFields(bi.grpls01a08, false);
                } else {
                    bi.grpls01a08.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.grpls01a08, true);
                }
            }
        });
        bi.ls01f07a.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != R.id.ls01f07a02) {
                    bi.grpls01f07a.setVisibility(GONE);
                    ClearClass.ClearAllFields(bi.grpls01f07a, false);

                } else {
                    bi.grpls01f07a.setVisibility(VISIBLE);
                    ClearClass.ClearAllFields(bi.grpls01f07a, true);
                }
            }
        });
        bi.ls01f07b.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.ls01f07b06) {
                    bi.fldgrpls01f07b.setVisibility(VISIBLE);
                } else {
                    bi.fldgrpls01f07b.setVisibility(GONE);
                    bi.ls01f07c.setText(null);
                }
            }
        });
        bi.ls01f10a.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != R.id.ls01f10a02) {
                    bi.grpls01f10a.setVisibility(GONE);
                    ClearClass.ClearAllFields(bi.grpls01f10a, false);
                } else {
                    bi.grpls01f10a.setVisibility(VISIBLE);
                    ClearClass.ClearAllFields(bi.grpls01f10a, true);
                }
            }
        });


        bi.ls01a04.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                bi.fldgrpls01a01.setVisibility(GONE);

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    public void BtnIDValid() {
        if (!validatorClass.EmptyTextBox(this, bi.ls01a04, getString(R.string.ls01a04))) {
            return;
        }

        if (CheckingID.getIDValidation(db, this, bi.ls01a04, getFtype)) {
            bi.fldgrpls01a01.setVisibility(VISIBLE);
        }
    }

    public void BtnContinue() {
        if (formValidation()) {
            try {
                SaveDraft();
//                if (UpdateDB()) {
                startActivity(new Intent(getApplicationContext(), Form02HHPart_1.class));
//                } else {
                Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
//                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean UpdateDB() {
        try {

            Long longID = new crudOperations(db, fc).execute().get();

            if (longID != 0) {
                fc.setId(longID.intValue());
                return true;
            } else {
                return false;
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return false;
    }

    public void BtnEnd() {
        if (!validatorClass.EmptyTextBox(this, bi.ls01a04, getString(R.string.ls01a04))) {
            return;
        }
        if (!validatorClass.EmptyTextBox(this, bi.ls01a02, getString(R.string.ls01a02))) {
            return;
        }
        startActivity(new Intent(getApplicationContext(), EndingActivity.class).putExtra("complete", false));
    }

    private void SaveDraft() throws JSONException {

        fc = new Forms();

        fc.setChildID(bi.ls01a04.getText().toString());

        JSONObject f01 = new JSONObject();
        f01.put("ls01a01", "");
        f01.put("ls01a02", bi.ls01a02.getText().toString());
        f01.put("ls01a03", "");
        f01.put("ls01a04", "");
        f01.put("ls01a05", "");
        f01.put("ls01a06", "");
        f01.put("ls01a07", bi.ls01a07a.isChecked() ? "1"
                : bi.ls01a07b.isChecked() ? "2"
                : bi.ls01a07c.isChecked() ? "3"
                : bi.ls01a07d.isChecked() ? "4"
                : "0");
        f01.put("ls01a08", bi.ls01a08a.isChecked() ? "1"
                : bi.ls01a08b.isChecked() ? "2"
                : bi.ls01a0896.isChecked() ? "96"
                : "0");
        f01.put("ls01a0896x", bi.ls01a0896x.getText().toString());
        f01.put("ls01a09", bi.ls01a09a.isChecked() ? "1"
                : bi.ls01a09b.isChecked() ? "2"
                : bi.ls01a09c.isChecked() ? "3"
                : bi.ls01a09d.isChecked() ? "4"
                : "0");
        f01.put("ls01a10", bi.ls01a10.getText().toString());
        f01.put("ls01a11", bi.ls01a11.getText().toString());

        f01.put("ls01a12", bi.ls01a12a.isChecked() ? "1"
                : bi.ls01a12b.isChecked() ? "2"
                : bi.ls01a12c.isChecked() ? "3"
                : bi.ls01a12d.isChecked() ? "4"
                : bi.ls01a12e.isChecked() ? "5"
                : bi.ls01a12f.isChecked() ? "6"
                : bi.ls01a1296.isChecked() ? "96"
                : "0");
        f01.put("ls01a1296x", bi.ls01a1296x.getText().toString());
        f01.put("ls01c01", bi.ls01c01.getText().toString());
        f01.put("ls01d01", bi.ls01d01.getText().toString());
        f01.put("ls01d02", bi.ls01d02.getText().toString());
        f01.put("ls01e01", bi.ls01e01.getText().toString());
        f01.put("ls01e02", bi.ls01e02.getText().toString());
        f01.put("ls01e03", bi.ls01e03.getText().toString());
        f01.put("ls01e04", bi.ls01e04.getText().toString());
        f01.put("ls01f01", bi.ls01f01.getText().toString());

        f01.put("ls01f02", bi.ls01f02a.isChecked() ? "1"
                : bi.ls01f02a.isChecked() ? "2"
                : "0");
        f01.put("ls01f03", bi.ls01f03.getText().toString());

        f01.put("ls01f04", bi.ls01f04a.isChecked() ? "1"
                : bi.ls01f04a.isChecked() ? "2"
                : "0");
        f01.put("ls01f05", bi.ls01f05.getText().toString());

        f01.put("ls01f06a", bi.ls01f06a01.isChecked() ? "1"
                : bi.ls01f06a02.isChecked() ? "2"
                : "0");
        f01.put("ls01f06b", bi.ls01f06b.getText().toString());

        f01.put("ls01f07a", bi.ls01f07a01.isChecked() ? "1"
                : bi.ls01f07a02.isChecked() ? "2"
                : "0");
        f01.put("ls01f07b", bi.ls01f07b01.isChecked() ? "1"
                : bi.ls01f07b02.isChecked() ? "2"
                : bi.ls01f07b03.isChecked() ? "3"
                : bi.ls01f07b04.isChecked() ? "4"
                : bi.ls01f07b05.isChecked() ? "5"
                : bi.ls01f07b06.isChecked() ? "6"
                : bi.ls01f07b96.isChecked() ? "96"
                : "0");
        f01.put("ls01f07c", bi.ls01f07c.getText().toString());

        f01.put("ls01f07d", bi.ls01f07d01.isChecked() ? "1"
                : bi.ls01f07d02.isChecked() ? "2"
                : bi.ls01f07d03.isChecked() ? "3"
                : bi.ls01f07d04.isChecked() ? "4"
                : bi.ls01f07d05.isChecked() ? "5"
                : bi.ls01f07d96.isChecked() ? "96"
                : "0");
        f01.put("ls01f08a", bi.ls01f08a.isChecked() ? "1" : "0");
        f01.put("ls01f08b", bi.ls01f08b.isChecked() ? "2" : "0");
        f01.put("ls01f08c", bi.ls01f08c.isChecked() ? "3" : "0");
        f01.put("ls01f08d", bi.ls01f08d.isChecked() ? "4" : "0");
        f01.put("ls01f08e", bi.ls01f08e.isChecked() ? "5" : "0");
        f01.put("ls01f08f", bi.ls01f08f.isChecked() ? "6" : "0");
        f01.put("ls01f08g", bi.ls01f08g.isChecked() ? "7" : "0");
        f01.put("ls01f08h", bi.ls01f08h.isChecked() ? "8" : "0");
        f01.put("ls01f0896", bi.ls01f0896.isChecked() ? "96" : "0");

        f01.put("ls01f0896", bi.ls01f0896x.getText().toString());
        f01.put("ls01f09", bi.ls01f09.getText().toString());
        f01.put("ls01f10a", bi.ls01f10a01.isChecked() ? "1"
                : bi.ls01f10a02.isChecked() ? "2"
                : "0");
        f01.put("ls01f10b", bi.ls01f10b01.isChecked() ? "1"
                : bi.ls01f10b02.isChecked() ? "2"
                : bi.ls01f10b96.isChecked() ? "96"
                : "0");
        f01.put("ls01f10b96x", bi.ls01f10b96x.getText().toString());
        f01.put("ls01f10c", bi.ls01f10c01.isChecked() ? "1"
                : bi.ls01f10c02.isChecked() ? "2"
                : bi.ls01f10c03.isChecked() ? "3"
                : bi.ls01f10c04.isChecked() ? "4"
                : bi.ls01f10c05.isChecked() ? "5"
                : bi.ls01f10c06.isChecked() ? "6"
                : bi.ls01f10c96.isChecked() ? "96"
                : "0");
        f01.put("ls01f10c96x", bi.ls01f10c96x.getText().toString());
        fc.setSa1(String.valueOf(f01));
//        MainApp.fc.setF16(String.valueOf(f16));
        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();

    }

    public boolean formValidation() {

        if (!validatorClass.EmptyTextBox(this, bi.ls01a02, getString(R.string.ls01a02))) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.ls01a04, getString(R.string.ls01a04))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls01a07, bi.ls01a07a, getString(R.string.ls01a07))) {
            return false;
        }
        if (!bi.ls01a07a.isChecked()) {
            if (!validatorClass.EmptyRadioButton(this, bi.ls01a08, bi.ls01a0896, bi.ls01a0896x, getString(R.string.ls01a08))) {
                return false;
            }
            if (bi.ls01a08a.isChecked()) {
                if (!validatorClass.EmptyRadioButton(this, bi.ls01a09, bi.ls01a09a, getString(R.string.ls01a09))) {
                    return false;
                }
            }
        }

        if (!validatorClass.EmptyTextBox(this, bi.ls01a10, getString(R.string.ls01a10))) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.ls01a11, getString(R.string.ls01a11))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls01a12, bi.ls01a1296, bi.ls01a1296x, getString(R.string.ls01a12))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.ls01c01, getString(R.string.ls01c01))) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.ls01d01, getString(R.string.ls01d01))) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.ls01d02, getString(R.string.ls01d02))) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.ls01e01, getString(R.string.ls01e01))) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.ls01e02, getString(R.string.ls01e02))) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.ls01e03, getString(R.string.ls01e03))) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.ls01e04, getString(R.string.ls01e04))) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.ls01f01, getString(R.string.ls01f01))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.ls01f02, bi.ls01f02a, getString(R.string.ls01f02))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.ls01f04, bi.ls01f04a, getString(R.string.ls01f04))) {
            return false;
        }
        if (bi.ls01f04a.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.ls01f03, getString(R.string.ls01f03))) {
                return false;
            }
        } else {
            if (!validatorClass.EmptyTextBox(this, bi.ls01f05, getString(R.string.ls01f05))) {
                return false;
            }
        }


        if (!validatorClass.EmptyRadioButton(this, bi.ls01f06a, bi.ls01f06a01, getString(R.string.ls01f06a))) {
            return false;
        }
        if (bi.ls01f06a02.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.ls01f06b, getString(R.string.ls01f06b))) {
                return false;
            }
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls01f07a, bi.ls01f07a01, getString(R.string.ls01f07a))) {
            return false;
        }
        if (!bi.ls01f07a01.isChecked()) {

            if (!validatorClass.EmptyRadioButton(this, bi.ls01f07b, bi.ls01f07b96, bi.ls01f07b96x, getString(R.string.ls01f07b))) {
                return false;
            }
            if (bi.ls01f07b06.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.ls01f07c, getString(R.string.ls01f07c))) {
                    return false;
                }
            }
            if (!validatorClass.EmptyRadioButton(this, bi.ls01f07d, bi.ls01f07d96, bi.ls01f07d96x, getString(R.string.ls01f07d))) {
                return false;
            }
        }

        if (!validatorClass.EmptyCheckBox(this, bi.ls01f08, bi.ls01f0896, bi.ls01f0896x, getString(R.string.ls01f08))) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.ls01f09, getString(R.string.ls01f09))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.ls01f10a, bi.ls01f10a01, getString(R.string.ls01f10a))) {
            return false;
        }
        if (bi.ls01f10a02.isChecked()) {

            if (!validatorClass.EmptyRadioButton(this, bi.ls01f10b, bi.ls01f10b96, bi.ls01f10b96x, getString(R.string.ls01f10b))) {
                return false;
            }
            return validatorClass.EmptyRadioButton(this, bi.ls01f10c, bi.ls01f10c96, bi.ls01f10c96x, getString(R.string.ls01f10c));
        }

        return true;
    }

}
