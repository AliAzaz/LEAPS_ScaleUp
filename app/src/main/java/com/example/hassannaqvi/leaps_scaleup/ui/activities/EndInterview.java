package com.example.hassannaqvi.leaps_scaleup.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.hassannaqvi.leaps_scaleup.R;
import com.example.hassannaqvi.leaps_scaleup.core.crudOperations;

import java.util.concurrent.ExecutionException;

public class EndInterview extends AppCompatActivity {

    RadioButton istatusa, istatusb;
    Button btn_saveData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_interview);

        initialization();

        btn_saveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SaveDraft();
                if (UpdateDB()) {
                    startActivity(new Intent(getApplicationContext(), StartActivity.class));
                } else {
                    Toast.makeText(EndInterview.this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    public void initialization() {

        // Initialize variables
        istatusa = findViewById(R.id.istatusa);
        istatusb = findViewById(R.id.istatusb);
        btn_saveData = findViewById(R.id.btn_save);
    }

    public void SaveDraft() {
        StartActivity.fc.setIstatus(istatusa.isChecked() ? "1" : istatusb.isChecked() ? "2" : "0");
    }

    public boolean UpdateDB() {
        try {

            Long longID = new crudOperations(1, MainActivity.db, StartActivity.fc).execute().get();
            return longID == 1;

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return false;
    }
}
