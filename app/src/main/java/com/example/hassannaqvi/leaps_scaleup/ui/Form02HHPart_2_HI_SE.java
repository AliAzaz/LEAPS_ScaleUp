package com.example.hassannaqvi.leaps_scaleup.ui;

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
import com.example.hassannaqvi.leaps_scaleup.core.MainApp;
import com.example.hassannaqvi.leaps_scaleup.data.DAO.FormsDAO;
import com.example.hassannaqvi.leaps_scaleup.databinding.ActivityForm02Hhpart2HiSeBinding;
import com.example.hassannaqvi.leaps_scaleup.validation.ClearClass;
import com.example.hassannaqvi.leaps_scaleup.validation.validatorClass;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

import static com.example.hassannaqvi.leaps_scaleup.ui.LoginActivity.db;

public class Form02HHPart_2_HI_SE extends AppCompatActivity {


    ActivityForm02Hhpart2HiSeBinding bi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_form02_hhpart_2_hi_se);
        bi.setCallback(this);

        this.setTitle(R.string.lsseheading);

        setupViews();
    }

    private void setupViews() {

        bi.ls02se02.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i != R.id.ls02se02b) {
                    bi.fldgrpls0207.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrpls0207);
                } else {
                    bi.fldgrpls0207.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrpls0207);
                }

            }
        });

        bi.ls02se09.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i != R.id.ls02se09a) {
                    bi.fldgrpls0214.setVisibility(View.GONE);
                    ClearClass.ClearAllCardFields(bi.fldgrpls0214);
                } else {
                    bi.fldgrpls0214.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllCardFields(bi.fldgrpls0214);
                }
            }
        });


    }

    public void BtnContinue() {
        if (formValidation()) {
            try {
                SaveDraft();
                if (UpdateDB()) {
                    startActivity(new Intent(getApplicationContext(), Form02HHPart_2_FS.class));
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

        JSONObject sHI_SE = new JSONObject();
        sHI_SE.put("ls02hi01", bi.ls02hi01a.isChecked() ? "1" : bi.ls02hi01b.isChecked() ? "2" : "0");
        sHI_SE.put("ls02hi02", bi.ls02hi02.getText().toString());
        sHI_SE.put("ls02se01", bi.ls02se01a01.isChecked() ? "1"
                : bi.ls02se01a02.isChecked() ? "2"
                : bi.ls02se01a03.isChecked() ? "3"
                : bi.ls02se01a96.isChecked() ? "96"
                : "0");
        sHI_SE.put("ls02se0196x", bi.ls02se01a96x.getText().toString());
        sHI_SE.put("ls02se02", bi.ls02se01b01.isChecked() ? "1"
                : bi.ls02se01b02.isChecked() ? "2"
                : bi.ls02se01b03.isChecked() ? "3"
                : bi.ls02se01b96.isChecked() ? "96"
                : "0");
        sHI_SE.put("ls02se0296x", bi.ls02se01b96x.getText().toString());

        sHI_SE.put("ls02se03", bi.ls02se01c01.isChecked() ? "1"
                : bi.ls02se01c02.isChecked() ? "2"
                : bi.ls02se01c03.isChecked() ? "3"
                : bi.ls02se01c96.isChecked() ? "96"
                : "0");
        sHI_SE.put("ls02se0396x", bi.ls02se01c96x.getText().toString());

        sHI_SE.put("ls02se04", bi.ls02se02a.isChecked() ? "1"
                : bi.ls02se02b.isChecked() ? "2"
                : bi.ls02se02c.isChecked() ? "3"
                : bi.ls02se02d.isChecked() ? "3"
                : bi.ls02se0296.isChecked() ? "96"
                : "0");
        sHI_SE.put("ls02se0496x", bi.ls02se0296x.getText().toString());

        sHI_SE.put("ls02se0598", bi.ls02se0398.isChecked() ? "98" : "0");
        sHI_SE.put("ls02se0598x", bi.ls02se03.getText().toString());

        sHI_SE.put("ls02se06", bi.ls02se04.getText().toString());

        sHI_SE.put("ls02se07", bi.ls02se05a.isChecked() ? "1"
                : bi.ls02se05b.isChecked() ? "2"
                : bi.ls02se05c.isChecked() ? "3"
                : bi.ls02se05d.isChecked() ? "4"
                : bi.ls02se05e.isChecked() ? "5"
                : bi.ls02se05f.isChecked() ? "6"
                : bi.ls02se05g.isChecked() ? "7"
                : bi.ls02se05h.isChecked() ? "8"
                : bi.ls02se05i.isChecked() ? "9"
                : bi.ls02se05j.isChecked() ? "10"
                : bi.ls02se05k.isChecked() ? "11"
                : bi.ls02se05l.isChecked() ? "12"
                : bi.ls02se05m.isChecked() ? "13"
                : bi.ls02se05n.isChecked() ? "14"
                : bi.ls02se0596.isChecked() ? "96"
                : "0");

        sHI_SE.put("ls02se0796x", bi.ls02se0596x.getText().toString());


        sHI_SE.put("ls02se0898", bi.ls02se0698.isChecked() ? "98" : "0");
        sHI_SE.put("ls02se0898x", bi.ls02se06.getText().toString());

        sHI_SE.put("ls02se09", bi.ls02se07a.isChecked() ? "1"
                : bi.ls02se07b.isChecked() ? "2"
                : bi.ls02se07c.isChecked() ? "3"
                : "0");

        sHI_SE.put("ls02se10", bi.ls02se08a.isChecked() ? "1"
                : bi.ls02se08b.isChecked() ? "2"
                : bi.ls02se0896.isChecked() ? "96"
                : bi.ls02se0898.isChecked() ? "98"
                : "0");
        sHI_SE.put("ls02se1096x", bi.ls02se0896x.getText().toString());

        sHI_SE.put("ls02se11", bi.ls02se09a.isChecked() ? "1"
                : bi.ls02se09b.isChecked() ? "2"
                : bi.ls02se09c.isChecked() ? "3"
                : bi.ls02se0996.isChecked() ? "96"
                : "0");
        sHI_SE.put("ls02se1196x", bi.ls02se0996x.getText().toString());

        sHI_SE.put("ls02se1298", bi.ls02se1098.isChecked() ? "98" : "0");
        sHI_SE.put("ls02se1298x", bi.ls02se10.getText().toString());

        sHI_SE.put("ls02se13", bi.ls02se11a.isChecked() ? "1"
                : bi.ls02se11b.isChecked() ? "2"
                : bi.ls02se11c.isChecked() ? "3"
                : bi.ls02se11d.isChecked() ? "4"
                : bi.ls02se1196.isChecked() ? "96"
                : "0");

        sHI_SE.put("ls02se1396x", bi.ls02se1196x.getText().toString());

        sHI_SE.put("ls02se1498", bi.ls02se1298.isChecked() ? "98" : "0");
        sHI_SE.put("ls02se1498x", bi.ls02se12.getText().toString());

        sHI_SE.put("ls02se1598", bi.ls02se1398.isChecked() ? "98" : "0");
        sHI_SE.put("ls02se1598x", bi.ls02se13.getText().toString());

        sHI_SE.put("ls02se16", bi.ls02se14a01.isChecked() ? "1"
                : bi.ls02se14a02.isChecked() ? "2"
                : bi.ls02se14a03.isChecked() ? "3"
                : bi.ls02se14a04.isChecked() ? "4"
                : bi.ls02se14a05.isChecked() ? "5"
                : bi.ls02se14a06.isChecked() ? "6"
                : bi.ls02se14a0196.isChecked() ? "96"
                : "0");

        sHI_SE.put("ls02se1696x", bi.ls02se14a0196x.getText().toString());

        sHI_SE.put("ls02se17", bi.ls02se14b01.isChecked() ? "1"
                : bi.ls02se14b02.isChecked() ? "2"
                : bi.ls02se14b03.isChecked() ? "3"
                : bi.ls02se14b0196.isChecked() ? "96"
                : "0");

        sHI_SE.put("ls02se1796x", bi.ls02se14b0196x.getText().toString());

        sHI_SE.put("ls02se18a", bi.ls02se15a.getText().toString());
        sHI_SE.put("ls02se18b", bi.ls02se15b.getText().toString());
        sHI_SE.put("ls02se18c", bi.ls02se15c.getText().toString());
        sHI_SE.put("ls02se18d", bi.ls02se15d.getText().toString());
        sHI_SE.put("ls02se18e", bi.ls02se15e.getText().toString());
        sHI_SE.put("ls02se18f", bi.ls02se15f.getText().toString());
        sHI_SE.put("ls02se18g", bi.ls02se15g.getText().toString());
        sHI_SE.put("ls02se18h", bi.ls02se15h.getText().toString());
        sHI_SE.put("ls02se18i", bi.ls02se15i.getText().toString());
        sHI_SE.put("ls02se18j", bi.ls02se15j.getText().toString());
        sHI_SE.put("ls02se18k", bi.ls02se15k.getText().toString());
        sHI_SE.put("ls02se18l", bi.ls02se15l.getText().toString());
        sHI_SE.put("ls02se18m", bi.ls02se15m.getText().toString());
        sHI_SE.put("ls02se18n", bi.ls02se15n.getText().toString());
        sHI_SE.put("ls02se18o", bi.ls02se15o.getText().toString());
        sHI_SE.put("ls02se18p", bi.ls02se15p.getText().toString());
        sHI_SE.put("ls02se18q", bi.ls02se15q.getText().toString());
        sHI_SE.put("ls02se18r", bi.ls02se15r.getText().toString());

        Form01Enrolment.fc_4_5.setSa2(String.valueOf(sHI_SE));
    }

    private boolean formValidation() {

        if (!validatorClass.EmptyRadioButton(this, bi.ls02hi01, bi.ls02hi01a, getString(R.string.ls02hi01))) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.ls02hi02, getString(R.string.ls02hi02))) {
            return false;
        }
        if(!validatorClass.RangeTextBox(this,bi.ls02hi02,2,99,getString(R.string.ls02hi02),"Age")){
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls02se01a, bi.ls02se01a01, getString(R.string.ls02se01a))) {
            return false;
        }
        if (bi.ls02se01a96.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.ls02se01a96x, getString(R.string.ls02se01a))) {
                return false;
            }
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls02se01b, bi.ls02se01b01, getString(R.string.ls02se01b))) {
            return false;
        }
        if (bi.ls02se01b96.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.ls02se01b96x, getString(R.string.ls02se01b))) {
                return false;
            }
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls02se01c, bi.ls02se01c02, getString(R.string.ls02se01c))) {
            return false;
        }
        if (bi.ls02se01c96.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.ls02se01c96x, getString(R.string.ls02se01c))) {
                return false;
            }
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls02se02, bi.ls02se02a, getString(R.string.ls02se02))) {
            return false;
        }

        if (bi.ls02se0296.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.ls02se0296x, getString(R.string.ls02se02))) {
                return false;
            }
        }
        if (bi.ls02se02b.isChecked()) {
            if (!bi.ls02se0398.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.ls02se03, getString(R.string.ls02se03))) {
                    return false;
                }
            }

        }
        if (!validatorClass.EmptyTextBox(this, bi.ls02se04, getString(R.string.ls02se04))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls02se05, bi.ls02se05a, getString(R.string.ls02se05))) {
            return false;
        }
        if (bi.ls02se0596.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.ls02se0596x, getString(R.string.ls02se05))) {
                return false;
            }
        }
        if (!bi.ls02se0698.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.ls02se06, getString(R.string.ls02se06))) {
                return false;
            }
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls02se07, bi.ls02se07a, getString(R.string.ls02se07))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls02se08, bi.ls02se08a, getString(R.string.ls02se08))) {
            return false;
        }
        if (bi.ls02se0896.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.ls02se0896x, getString(R.string.ls02se08))) {
                return false;
            }
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls02se09, bi.ls02se09a, getString(R.string.ls02se09))) {
            return false;
        }
        if (bi.ls02se0996.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.ls02se0996x, getString(R.string.ls02se09))) {
                return false;
            }
        }
        if (bi.ls02se09a.isChecked()) {
            if (!bi.ls02se1098.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.ls02se10, getString(R.string.ls02se10))) {
                    return false;
                }
            }
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls02se11, bi.ls02se11a, getString(R.string.ls02se11))) {
            return false;
        }
        if (bi.ls02se1196.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.ls02se1196x, getString(R.string.ls02se11))) {
                return false;
            }
        }
        if (!bi.ls02se1298.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.ls02se12, getString(R.string.ls02se12))) {
                return false;
            }
        }
        if (!bi.ls02se1398.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.ls02se13, getString(R.string.ls02se13))) {
                return false;
            }
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls02se14a, bi.ls02se14a01, getString(R.string.ls02se14a))) {
            return false;
        }
        if (bi.ls02se14a0196.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.ls02se14a0196x, getString(R.string.ls02se14a))) {
                return false;
            }
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls02se14b, bi.ls02se14b01, getString(R.string.ls02se14b))) {
            return false;
        }
        if (bi.ls02se14b0196.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.ls02se14b0196x, getString(R.string.ls02se14b))) {
                return false;
            }
        }
        if (!validatorClass.EmptyTextBox(this, bi.ls02se15a, getString(R.string.ls02se15a))) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.ls02se15b, getString(R.string.ls02se15b))) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.ls02se15c, getString(R.string.ls02se15c))) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.ls02se15d, getString(R.string.ls02se15d))) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.ls02se15e, getString(R.string.ls02se15e))) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.ls02se15f, getString(R.string.ls02se15f))) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.ls02se15g, getString(R.string.ls02se15g))) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.ls02se15h, getString(R.string.ls02se15h))) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.ls02se15i, getString(R.string.ls02se15i))) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.ls02se15j, getString(R.string.ls02se15j))) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.ls02se15k, getString(R.string.ls02se15k))) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.ls02se15l, getString(R.string.ls02se15l))) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.ls02se15m, getString(R.string.ls02se15m))) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.ls02se15n, getString(R.string.ls02se15n))) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.ls02se15o, getString(R.string.ls02se15o))) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.ls02se15p, getString(R.string.ls02se15p))) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.ls02se15q, getString(R.string.ls02se15q))) {
            return false;
        }
        return validatorClass.EmptyTextBox(this, bi.ls02se15r, getString(R.string.ls02se15r));
    }

    public void BtnEnd() {
        MainApp.endActivity(this, this, EndingActivity.class, false, Form01Enrolment.fc_4_5);
    }

    @Override
    public void onBackPressed() {

        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }
}
