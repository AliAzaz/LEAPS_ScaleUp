package com.example.hassannaqvi.leaps_scaleup.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.hassannaqvi.leaps_scaleup.R;
import com.example.hassannaqvi.leaps_scaleup.RMOperations.crudOperations;
import com.example.hassannaqvi.leaps_scaleup.core.MainApp;
import com.example.hassannaqvi.leaps_scaleup.data.DAO.FormsDAO;
import com.example.hassannaqvi.leaps_scaleup.databinding.ActivityForm02Hhpart1Binding;
import com.example.hassannaqvi.leaps_scaleup.validation.ClearClass;
import com.example.hassannaqvi.leaps_scaleup.validation.validatorClass;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

import static com.example.hassannaqvi.leaps_scaleup.ui.LoginActivity.db;

public class Form02HHPart_1 extends AppCompatActivity {

    ActivityForm02Hhpart1Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_form02_hhpart_1);
        bi.setCallback(this);

        this.setTitle(R.string.ls02pe01heading);

        setupViews();
    }

    private void setupViews() {


        bi.ls02pe01a.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.ls02pe01a01) {
                    bi.fldgrplspe09.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe09, false);
                    bi.fldgrplspe10.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe10, false);
                    bi.fldgrplspe11.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe11, false);
                    bi.fldgrplspe12.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe12, false);
                    bi.fldgrplspe13.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe13, false);
                    bi.fldgrplspe14.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe14, false);
                    bi.fldgrplspe15.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe15, false);
                    bi.fldgrplspe16.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe16, false);

                    bi.fldgrplspe02.setVisibility(View.VISIBLE);
                    bi.fldgrplspe03.setVisibility(View.VISIBLE);
                    bi.fldgrplspe04.setVisibility(View.VISIBLE);
                    bi.fldgrplspe05.setVisibility(View.VISIBLE);
                    bi.fldgrplspe06.setVisibility(View.VISIBLE);
                    bi.fldgrplspe07.setVisibility(View.VISIBLE);
                    bi.fldgrplspe08.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe02, true);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe03, true);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe04, true);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe05, true);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe06, true);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe07, true);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe08, true);
                } else {
                    bi.fldgrplspe02.setVisibility(View.GONE);
                    bi.fldgrplspe03.setVisibility(View.GONE);
                    bi.fldgrplspe04.setVisibility(View.GONE);
                    bi.fldgrplspe05.setVisibility(View.GONE);
                    bi.fldgrplspe06.setVisibility(View.GONE);
                    bi.fldgrplspe07.setVisibility(View.GONE);
                    bi.fldgrplspe08.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe02, false);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe03, false);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe04, false);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe05, false);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe06, false);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe07, false);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe08, false);

                    bi.fldgrplspe09.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe09, true);
                    bi.fldgrplspe10.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe10, true);
                    bi.fldgrplspe11.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe11, true);
                    bi.fldgrplspe12.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe12, true);
                    bi.fldgrplspe13.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe13, true);
                    bi.fldgrplspe14.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe14, true);
                    bi.fldgrplspe15.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe15, true);
                    bi.fldgrplspe16.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe16, true);
                }
            }
        });

        bi.ls02pe01c.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i != R.id.ls02pe01c05) {
                    bi.fldgrplspe04.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe04, false);
                    bi.fldgrplspe05.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe05, false);
                    bi.fldgrplspe06.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe06, false);

                } else {
                    bi.fldgrplspe04.setVisibility(View.VISIBLE);
                    bi.fldgrplspe05.setVisibility(View.VISIBLE);
                    bi.fldgrplspe06.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe04, true);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe05, true);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe06, true);
                }
            }
        });

        bi.ls02pe02a.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i != R.id.ls02pe02a01) {
                    bi.fldgrplspe10.setVisibility(View.GONE);
                    bi.fldgrplspe11.setVisibility(View.GONE);
                    bi.fldgrplspe12.setVisibility(View.GONE);
                    bi.fldgrplspe13.setVisibility(View.GONE);
                    bi.fldgrplspe14.setVisibility(View.GONE);
                    bi.fldgrplspe15.setVisibility(View.GONE);
                    bi.fldgrplspe16.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe10, false);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe11, false);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe12, false);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe13, false);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe14, false);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe15, false);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe16, false);
                } else {
                    bi.fldgrplspe10.setVisibility(View.VISIBLE);
                    bi.fldgrplspe11.setVisibility(View.VISIBLE);
                    bi.fldgrplspe12.setVisibility(View.VISIBLE);
                    bi.fldgrplspe13.setVisibility(View.VISIBLE);
                    bi.fldgrplspe14.setVisibility(View.VISIBLE);
                    bi.fldgrplspe15.setVisibility(View.VISIBLE);
                    bi.fldgrplspe16.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe10, true);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe11, true);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe12, true);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe13, true);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe14, true);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe15, true);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe16, true);
                }
            }
        });

        bi.ls02pe02c.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i != R.id.ls02pe02c05) {

                    bi.fldgrplspe12.setVisibility(View.GONE);
                    bi.fldgrplspe13.setVisibility(View.GONE);
                    bi.fldgrplspe14.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe12, false);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe13, false);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe14, false);
                } else {
                    bi.fldgrplspe12.setVisibility(View.VISIBLE);
                    bi.fldgrplspe13.setVisibility(View.VISIBLE);
                    bi.fldgrplspe14.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe12, true);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe13, true);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe14, true);
                }
            }
        });


        bi.ls02pe03a.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i != R.id.ls02pe03a01) {
                    bi.fldgrplspe18.setVisibility(View.GONE);
                    bi.fldgrplspe19.setVisibility(View.GONE);
                    bi.fldgrplspe20.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe18, false);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe19, false);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe20, false);

                } else {
                    bi.fldgrplspe18.setVisibility(View.VISIBLE);
                    bi.fldgrplspe19.setVisibility(View.VISIBLE);
                    bi.fldgrplspe20.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe18, true);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe19, true);
                    ClearClass.ClearAllCardFields(bi.fldgrplspe20, true);
                }
            }
        });

    }

    public void BtnContinue() {
        if (formValidation()) {
            try {
                SaveDraft();
                if (UpdateDB()) {
                    startActivity(new Intent(getApplicationContext(), Form02HHPart_2_HI_SE.class));
                } else {
                    Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean UpdateDB() {
        try {

            Long longID = new crudOperations(db, Form01Enrolment.fc_4_5).execute(FormsDAO.class.getName(), "formsDao", "updateForm_04_05").get();
            return longID == 1;

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return false;
    }

    private void SaveDraft() throws JSONException {

        JSONObject sHH01 = new JSONObject();
        sHH01.put("ls02pe01", bi.ls02pe01a01.isChecked() ? "1" : bi.ls02pe01a02.isChecked() ? "2" : "0");
        sHH01.put("ls02pe02", bi.ls02pe01b.getText().toString());
        sHH01.put("ls02pe03", bi.ls02pe01c01.isChecked() ? "1"
                : bi.ls02pe01c02.isChecked() ? "2"
                : bi.ls02pe01c03.isChecked() ? "3"
                : bi.ls02pe01c04.isChecked() ? "4"
                : bi.ls02pe01c05.isChecked() ? "5"
                : bi.ls02pe01c96.isChecked() ? "96"
                : bi.ls02pe01c98.isChecked() ? "98"
                : "0");
        sHH01.put("ls02pe0396x", bi.ls02pe01c96x.getText().toString());
        sHH01.put("ls02pe04", bi.ls02pe01d.getText().toString());
        sHH01.put("ls02pe05", bi.ls02pe01e.getText().toString());
        sHH01.put("ls02pe06", bi.ls02pe01f.getText().toString());
        sHH01.put("ls02pe07", bi.ls02pe01g.getText().toString());
        sHH01.put("ls02pe08", bi.ls02pe01h.getText().toString());

        sHH01.put("ls02pe09", bi.ls02pe02a01.isChecked() ? "1" : bi.ls02pe02a02.isChecked() ? "2" : "0");

        sHH01.put("ls02pe10", bi.ls02pe02b.getText().toString());

        sHH01.put("ls02pe11", bi.ls02pe02c01.isChecked() ? "1"
                : bi.ls02pe02c02.isChecked() ? "2"
                : bi.ls02pe02c03.isChecked() ? "3"
                : bi.ls02pe02c04.isChecked() ? "4"
                : bi.ls02pe02c05.isChecked() ? "5"
                : bi.ls02pe02c96.isChecked() ? "96"
                : bi.ls02pe02c98.isChecked() ? "98"
                : "0");
        sHH01.put("ls02pe1196x", bi.ls02pe02c96x.getText().toString());
        sHH01.put("ls02pe12", bi.ls02pe02d.getText().toString());
        sHH01.put("ls02pe13", bi.ls02pe02e.getText().toString());
        sHH01.put("ls02pe14", bi.ls02pe02f.getText().toString());
        sHH01.put("ls02pe15", bi.ls02pe02g.getText().toString());

        sHH01.put("ls02pe16", bi.ls02pe02c01.isChecked() ? "1"
                : bi.ls02pe02h01.isChecked() ? "2"
                : bi.ls02pe02h02.isChecked() ? "3"
                : bi.ls02pe02h03.isChecked() ? "4"
                : bi.ls02pe02h04.isChecked() ? "5"
                : bi.ls02pe02h05.isChecked() ? "6"
                : bi.ls02pe02h06.isChecked() ? "7"
                : bi.ls02pe02h96.isChecked() ? "96"
                : bi.ls02pe02h98.isChecked() ? "98"
                : "0");
        sHH01.put("ls02pe1696x", bi.ls02pe02h96x.getText().toString());

        sHH01.put("ls02pe17", bi.ls02pe03a01.isChecked() ? "1"
                : bi.ls02pe03a02.isChecked() ? "2"
                : "0");
        sHH01.put("ls02pe18", bi.ls02pe03b01.isChecked() ? "1"
                : bi.ls02pe03b02.isChecked() ? "2"
                : "0");

        sHH01.put("ls02pe19", bi.ls02pe03c.getText().toString());

        sHH01.put("ls02pe20", bi.ls02pe03d01.isChecked() ? "1"
                : bi.ls02pe03d02.isChecked() ? "2"
                : bi.ls02pe03d03.isChecked() ? "3"
                : bi.ls02pe03d04.isChecked() ? "4"
                : bi.ls02pe03d96.isChecked() ? "96"
                : bi.ls02pe03d98.isChecked() ? "98"
                : "0");


        sHH01.put("ls02pe2096x", bi.ls02pe03d96x.getText().toString());

        Form01Enrolment.fc_4_5.setSa1(String.valueOf(sHH01));

    }

    private boolean formValidation() {

        if (!validatorClass.EmptyRadioButton(this, bi.ls02pe01a, bi.ls02pe01a01, getString(R.string.ls02pe01a))) {
            return false;
        }
        if (bi.ls02pe01a01.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.ls02pe01b, getString(R.string.ls02pe01b))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.ls02pe01c, bi.ls02pe01c01, getString(R.string.ls02pe01c))) {
                return false;
            }
            if (bi.ls02pe01c96.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.ls02pe01c96x, getString(R.string.ls02pe01c))) {
                    return false;
                }
            }
            if (bi.ls02pe01c05.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.ls02pe01d, getString(R.string.ls02pe01d))) {
                    return false;
                }
                if (!validatorClass.EmptyTextBox(this, bi.ls02pe01e, getString(R.string.ls02pe01e))) {
                    return false;
                }
                if (!validatorClass.EmptyTextBox(this, bi.ls02pe01f, getString(R.string.ls02pe01f))) {
                    return false;
                }
            }
            if (!validatorClass.EmptyTextBox(this, bi.ls02pe01g, getString(R.string.ls02pe01g))) {
                return false;
            }
            if (!validatorClass.EmptyTextBox(this, bi.ls02pe01h, getString(R.string.ls02pe01h))) {
                return false;
            }

            if (!validatorClass.EmptyRadioButton(this, bi.ls02pe03a, bi.ls02pe03a01, getString(R.string.ls02pe03a))) {
                return false;
            }
            if (bi.ls02pe03a01.isChecked()) {
                if (!validatorClass.EmptyRadioButton(this, bi.ls02pe03b, bi.ls02pe03b01, getString(R.string.ls02pe03b))) {
                    return false;
                }
                if (!validatorClass.EmptyTextBox(this, bi.ls02pe03c, getString(R.string.ls02pe03c))) {
                    return false;
                }
                if (!validatorClass.EmptyRadioButton(this, bi.ls02pe03d, bi.ls02pe03d01, getString(R.string.ls02pe03d))) {
                    return false;
                }

                if (bi.ls02pe03d96.isChecked()) {
                    return validatorClass.EmptyTextBox(this, bi.ls02pe03d96x, getString(R.string.ls02pe03d));
                }
            }

        } else {
            if (!validatorClass.EmptyRadioButton(this, bi.ls02pe02a, bi.ls02pe02a01, getString(R.string.ls02pe02a))) {
                return false;
            }
            if (!bi.ls02pe02a02.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.ls02pe02b, getString(R.string.ls02pe02b))) {
                    return false;
                }
                if (!validatorClass.EmptyRadioButton(this, bi.ls02pe02c, bi.ls02pe02c01, getString(R.string.ls02pe02c))) {
                    return false;
                }
                if (bi.ls02pe02c96.isChecked()) {
                    if (!validatorClass.EmptyTextBox(this, bi.ls02pe02c96x, getString(R.string.ls02pe02c))) {
                        return false;
                    }
                }
                if (bi.ls02pe02c05.isChecked()) {
                    if (!validatorClass.EmptyTextBox(this, bi.ls02pe02d, getString(R.string.ls02pe02d))) {
                        return false;
                    }
                    if (!validatorClass.EmptyTextBox(this, bi.ls02pe02e, getString(R.string.ls02pe02e))) {
                        return false;
                    }
                    if (!validatorClass.EmptyTextBox(this, bi.ls02pe02f, getString(R.string.ls02pe02f))) {
                        return false;
                    }
                }
                if (!validatorClass.EmptyTextBox(this, bi.ls02pe02g, getString(R.string.ls02pe02g))) {
                    return false;
                }
                if (!validatorClass.EmptyRadioButton(this, bi.ls02pe02h, bi.ls02pe02h01, getString(R.string.ls02pe02h))) {
                    return false;
                }
                if (bi.ls02pe02h96.isChecked()) {
                    if (!validatorClass.EmptyTextBox(this, bi.ls02pe02h96x, getString(R.string.ls02pe02h))) {
                        return false;
                    }
                }
                if (!validatorClass.EmptyRadioButton(this, bi.ls02pe03a, bi.ls02pe03a01, getString(R.string.ls02pe03a))) {
                    return false;
                }
                if (bi.ls02pe03a01.isChecked()) {
                    if (!validatorClass.EmptyRadioButton(this, bi.ls02pe03b, bi.ls02pe03b01, getString(R.string.ls02pe03b))) {
                        return false;
                    }
                    if (!validatorClass.EmptyTextBox(this, bi.ls02pe03c, getString(R.string.ls02pe03c))) {
                        return false;
                    }
                    if (!validatorClass.EmptyRadioButton(this, bi.ls02pe03d, bi.ls02pe03d01, getString(R.string.ls02pe03d))) {
                        return false;
                    }

                    if (bi.ls02pe03d96.isChecked()) {
                        return validatorClass.EmptyTextBox(this, bi.ls02pe03d96x, getString(R.string.ls02pe03d));
                    }
                }
            } else {
                if (!validatorClass.EmptyRadioButton(this, bi.ls02pe03a, bi.ls02pe03a01, getString(R.string.ls02pe03a))) {
                    return false;
                }
                if (bi.ls02pe03a01.isChecked()) {
                    if (!validatorClass.EmptyRadioButton(this, bi.ls02pe03b, bi.ls02pe03b01, getString(R.string.ls02pe03b))) {
                        return false;
                    }
                    if (!validatorClass.EmptyTextBox(this, bi.ls02pe03c, getString(R.string.ls02pe03c))) {
                        return false;
                    }
                    if (!validatorClass.EmptyRadioButton(this, bi.ls02pe03d, bi.ls02pe03d01, getString(R.string.ls02pe03d))) {
                        return false;
                    }

                    if (bi.ls02pe03d96.isChecked()) {
                        return validatorClass.EmptyTextBox(this, bi.ls02pe03d96x, getString(R.string.ls02pe03d));
                    }
                }


            }


        }


        return true;
    }

    public void BtnEnd() {
        MainApp.endActivity(this, this, EndingActivity.class, false, Form01Enrolment.fc_4_5);
    }

    @Override
    public void onBackPressed() {

        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }

}
