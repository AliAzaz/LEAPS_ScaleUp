package com.example.hassannaqvi.leaps_scaleup.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

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
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == bi.ls02pe01a02.getId()) {
                    ClearClass.ClearAllFields(bi.fldGrpls02);
                    ClearClass.ClearAllFields(bi.fldGrp03);

                }
            }
        });

        bi.ls02pe01c.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId != bi.ls02pe01c05.getId()) {
                    ClearClass.ClearAllFields(bi.fldGrp02);
                }

            }
        });

        bi.ls02pe01i.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId != bi.ls02pe01ia.getId()) {
                    ClearClass.ClearAllCardFields(bi.fldgrplspe22);
                }
            }
        });

        bi.ls02pe02a.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == bi.ls02pe02a02.getId()) {
                    ClearClass.ClearAllFields(bi.fldGrp04);
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

        } catch (InterruptedException | ExecutionException e) {
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
                : bi.ls02pe01c06.isChecked() ? "6"
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
                : bi.ls02pe02c06.isChecked() ? "6"
                : bi.ls02pe02c96.isChecked() ? "96"
                : bi.ls02pe02c98.isChecked() ? "98"
                : "0");
        sHH01.put("ls02pe1196x", bi.ls02pe02c96x.getText().toString());
        sHH01.put("ls02pe12", bi.ls02pe02d.getText().toString());
        sHH01.put("ls02pe13", bi.ls02pe02e.getText().toString());
        sHH01.put("ls02pe14", bi.ls02pe02f.getText().toString());
        sHH01.put("ls02pe15", bi.ls02pe02g.getText().toString());

        sHH01.put("ls02pe16",
                bi.ls02pe02h01.isChecked() ? "1"
                        : bi.ls02pe02h02.isChecked() ? "2"
                        : bi.ls02pe02h03.isChecked() ? "3"
                        : bi.ls02pe02h04.isChecked() ? "4"
                        : bi.ls02pe02h05.isChecked() ? "5"
                        : bi.ls02pe02h06.isChecked() ? "6"
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

        sHH01.put("ls02pe21", bi.ls02pe01ia.isChecked() ? "1"
                : bi.ls02pe01ib.isChecked() ? "2"
                : bi.ls02pe01i98.isChecked() ? "98"
                : "0");
        sHH01.put("ls02pe22", bi.ls02pe01ja.isChecked() ? "1"
                : bi.ls02pe01jb.isChecked() ? "2"
                : bi.ls02pe01jc.isChecked() ? "3"
                : bi.ls02pe01jd.isChecked() ? "4"
                : bi.ls02pe01je.isChecked() ? "5"
                : bi.ls02pe01jf.isChecked() ? "6"
                : bi.ls02pe01j98.isChecked() ? "98"
                : bi.ls02pe0196.isChecked() ? "96"
                : "0");

        sHH01.put("ls02pe2296x", bi.ls02pe0196x.getText().toString());

        Form01Enrolment.fc_4_5.setSa1(String.valueOf(sHH01));

    }

    private boolean formValidation() {

        return validatorClass.EmptyCheckingContainer(this, bi.fldGrpleap2a);
    }

    public void BtnEnd() {
        MainApp.endActivity(this, this, EndingActivity.class, false, Form01Enrolment.fc_4_5);
    }

    @Override
    public void onBackPressed() {

        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }

}
