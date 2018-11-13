package com.example.hassannaqvi.leaps_scaleup.ui.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.hassannaqvi.leaps_scaleup.R;
import com.example.hassannaqvi.leaps_scaleup.RMOperations.crudOperations;
import com.example.hassannaqvi.leaps_scaleup.data.DAO.FormsDAO;
import com.example.hassannaqvi.leaps_scaleup.databinding.ActivityEndingYouthBinding;
import com.example.hassannaqvi.leaps_scaleup.validation.validatorClass;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;

import static com.example.hassannaqvi.leaps_scaleup.ui.activities.LoginActivity.db;


public class EndingActivityYouth extends AppCompatActivity {

    private static final String TAG = EndingActivityYouth.class.getSimpleName();
    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());

    ActivityEndingYouthBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_ending_youth);
        bi.setCallback(this);

        this.setTitle("End Interview");

        Boolean check = getIntent().getExtras().getBoolean("complete");

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

/*        istatus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (istatus88.isChecked()) {
                    istatus88x.setVisibility(View.VISIBLE);
                    //istatus88x.requestFocus();
                } else {
                    istatus88x.setText(null);
                    istatus88x.setVisibility(View.GONE);
                }
            }
        });*/

    }

    public void BtnEnd() {
        if (formValidation()) {
            SaveDraft();
            if (UpdateDB()) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            } else {
                Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void SaveDraft() {
        Form07Activity.fc.setIstatus(bi.istatusa.isChecked() ? "1" : bi.istatusb.isChecked() ? "2" : bi.istatusc.isChecked() ? "3" : bi.istatusd.isChecked() ? "4" : "0");
        Form07Activity.fc.setEndtime(dtToday);
    }

    public boolean UpdateDB() {
        try {

            Long longID = new crudOperations(db, Form07Activity.fc).execute(FormsDAO.class.getName(), "formsDao", "updateForm").get();
            return longID == 1;

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return false;
    }

    private boolean formValidation() {

        return validatorClass.EmptyRadioButton(this, bi.istatus, bi.istatusb, getString(R.string.istatus));
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "You Can't go back", Toast.LENGTH_LONG).show();
    }

}
