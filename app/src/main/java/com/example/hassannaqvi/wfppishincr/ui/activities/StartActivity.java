package com.example.hassannaqvi.wfppishincr.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hassannaqvi.wfppishincr.R;
import com.example.hassannaqvi.wfppishincr.core.crudOperations;
import com.example.hassannaqvi.wfppishincr.data.AppDatabase;
import com.example.hassannaqvi.wfppishincr.data.entities.Forms;

import java.util.concurrent.ExecutionException;

public class StartActivity extends AppCompatActivity {

    public static Forms formContract;
    public static AppDatabase db;

    EditText txtName;
    Button btn_saveData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        initialization();

        // Room DB instantiate
        db = AppDatabase.getDatabase(getApplicationContext());

        btn_saveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SaveDraft();
                if (UpdateDB()) {
                    startActivity(new Intent(getApplicationContext(), EndInterview.class));
                } else {
                    Toast.makeText(StartActivity.this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        dbBackup();

        /*try {
            Toast.makeText(this, new GetAllDBData(db, new Forms(),2).execute().get().getUsername(), Toast.LENGTH_SHORT).show();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/

    }

    public void dbBackup() {

        /*File folder = new File(Environment.getExternalStorageDirectory() + File.separator + "PHISIN-CR");
        boolean success = true;
        if (!folder.exists()) {
            success = folder.mkdirs();
        }
        if (success) {

            folder = new File(folder.getPath());
            if (!folder.exists()) {
                success = folder.mkdirs();
            }
            if (success) {

                try {
                    File dbFile = new File(this.getDatabasePath(AppDatabase.Sub_DBConnection.DATABASE_NAME).getPath());
                    FileInputStream fis = new FileInputStream(dbFile);

                    String outFileName = folder.getPath() + File.separator +
                            AppDatabase.Sub_DBConnection.DATABASE_NAME + ".db";

                    // Open the empty db as the output stream
                    OutputStream output = new FileOutputStream(outFileName);

                    // Transfer bytes from the inputfile to the outputfile
                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = fis.read(buffer)) > 0) {
                        output.write(buffer, 0, length);
                    }
                    // Close the streams
                    output.flush();
                    output.close();
                    fis.close();
                } catch (IOException e) {
                    Log.e("dbBackup:", e.getMessage());
                }

            }

        } else {
            Toast.makeText(this, "Not create folder", Toast.LENGTH_SHORT).show();
        }*/

    }

    public void initialization() {

        // Initialize variables
        txtName = findViewById(R.id.txt_name);
        btn_saveData = findViewById(R.id.btn_save);
    }

    public void SaveDraft() {

        formContract = new Forms();
        formContract.setUsername(txtName.getText().toString());

    }

    public boolean UpdateDB() {
        try {

            Long longID = new crudOperations(0, db, formContract).execute().get();

            if (longID != 0) {
                formContract.setId(longID.intValue());
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
}
