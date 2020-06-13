package com.example.hassannaqvi.leaps_scaleup.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.hassannaqvi.leaps_scaleup.R;
import com.example.hassannaqvi.leaps_scaleup.RMOperations.CrudOperations;
import com.example.hassannaqvi.leaps_scaleup.data.DAO.FormsDAO;
import com.example.hassannaqvi.leaps_scaleup.data.entities.Forms;
import com.example.hassannaqvi.leaps_scaleup.data.entities.Forms_04_05;
import com.example.hassannaqvi.leaps_scaleup.data.entities.Forms_GPS;
import com.example.hassannaqvi.leaps_scaleup.databinding.ActivityEndingBinding;
import com.example.hassannaqvi.leaps_scaleup.validation.validatorClass;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;

import static com.example.hassannaqvi.leaps_scaleup.ui.LoginActivity.db;


public class EndingActivity extends AppCompatActivity {

    private static final String TAG = EndingActivity.class.getSimpleName();
    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());

    ActivityEndingBinding bi;
    Forms_04_05 fc04_05;
    Forms fc_;
    Forms_GPS fc_gps;
    int flag;
    boolean istatus88x_flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_ending);
        bi.setCallback(this);

        this.setTitle("End Interview");

        boolean check = getIntent().getBooleanExtra("complete", false);

        if (check) {
            bi.istatusa.setEnabled(true);
            bi.istatusb.setEnabled(false);
            bi.istatusc.setEnabled(false);
            bi.istatusd.setEnabled(false);
        } else {
            bi.istatusa.setEnabled(false);
            bi.istatusb.setEnabled(true);
            bi.istatusc.setEnabled(true);
            bi.istatusd.setEnabled(true);
        }

        flag = getIntent().getIntExtra("typeFlag", 0);
        if (flag == 1)
            fc_ = (Forms) getIntent().getSerializableExtra("fc_data");
        else if (flag == 2)
            fc04_05 = (Forms_04_05) getIntent().getSerializableExtra("fc_data");
        else {
            fc_gps = (Forms_GPS) getIntent().getSerializableExtra("fc_data");
            bi.protocol.setVisibility(View.GONE);
            istatus88x_flag = true;
        }

        bi.istatus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                bi.istatus88x.setVisibility(checkedId == bi.istatusc.getId() && istatus88x_flag ? View.VISIBLE : View.GONE);
            }
        });


    }

    public void BtnEnd() {
        if (formValidation()) {
            SaveDraft();
            if (UpdateDB()) {
                startActivity(new Intent(this, MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            } else {
                Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void SaveDraft() {
        if (flag == 1) {
            fc_.setIstatus(bi.istatusa.isChecked() ? "1" : bi.istatusb.isChecked() ? "2" : bi.istatusc.isChecked() ? "3" : bi.istatusd.isChecked() ? "4" : "0");
            fc_.setEndtime(dtToday);
            fc_.setPdeviation(bi.pdeviationa.isChecked() ? "1" : bi.pdeviationb.isChecked() ? "2" : bi.pdeviationc.isChecked() ? "3" : "0");
        } else if (flag == 2) {
            fc04_05.setIstatus(bi.istatusa.isChecked() ? "1" : bi.istatusb.isChecked() ? "2" : bi.istatusc.isChecked() ? "3" : bi.istatusd.isChecked() ? "4" : "0");
            fc04_05.setEndtime(dtToday);
            fc04_05.setPdeviation(bi.pdeviationa.isChecked() ? "1" : bi.pdeviationb.isChecked() ? "2" : bi.pdeviationc.isChecked() ? "3" : "0");
        } else {
            fc_gps.setIstatus(bi.istatusa.isChecked() ? "1" : bi.istatusb.isChecked() ? "2" : bi.istatusc.isChecked() ? "3" : bi.istatusd.isChecked() ? "4" : "0");
            fc_gps.setEndtime(dtToday);
            fc_gps.setIstatus88x(bi.istatus88x.getText().toString());
        }
    }

    public boolean UpdateDB() {
        try {
            Long longID = new CrudOperations(db, flag == 1 ? fc_ : flag == 2 ? fc04_05 : fc_gps).execute(FormsDAO.class.getName(), "formsDao", flag == 1 ? "updateForm" : flag == 2 ? "updateForm_04_05" : "updateForm_GPS").get();
            return longID == 1;

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        return false;
    }

    private boolean formValidation() {
        if (flag == 1 || flag == 2)
            if (!validatorClass.EmptyRadioButton(this, bi.pdeviation, bi.pdeviationc, getString(R.string.pdeviation))) {
                return false;
            }
        return validatorClass.EmptyRadioButton(this, bi.istatus, bi.istatusb, getString(R.string.istatus));
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You Can't go back", Toast.LENGTH_LONG).show();
    }

}
