package com.example.hassannaqvi.leaps_scaleup.ui.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.hassannaqvi.leaps_scaleup.R;
import com.example.hassannaqvi.leaps_scaleup.databinding.ActivityForm07Binding;
import com.example.hassannaqvi.leaps_scaleup.validation.validatorClass;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Form07Activity extends AppCompatActivity {


    ActivityForm07Binding bi;
    ArrayList<String> district = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this,R.layout.activity_form07);
        bi.setCallback(this);

        district.add("....");
        district.add("N/A");

        //setting spinners
        bi.ls07id15.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,district));
        bi.ls07id16.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,district));



    }

    public void BtnContinue() {

      if (formValidation()) {
        try {
            SaveDraft();

                if (UpdateDB()) {
            startActivity(new Intent(getApplicationContext(), EndingActivity.class).putExtra("complete", true));
                } else {
            Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
                }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        }
    }

    public boolean UpdateDB(){

        return true;
    }

    public boolean formValidation(){

        if(!validatorClass.EmptyTextBox(this,bi.ls07id01,getString(R.string.ls07id01))){
            return false;
        }
        if(!validatorClass.EmptyTextBox(this,bi.ls07id02,getString(R.string.ls07id02))){
            return false;
        }

        if(!validatorClass.EmptyTextBox(this,bi.ls07id03,getString(R.string.ls07id03))){
            return false;
        }
        if(!validatorClass.EmptySpinner(this,bi.ls07id15,getString(R.string.ls07id15))){
            return false;
        }

        if(!validatorClass.EmptySpinner(this,bi.ls07id16,getString(R.string.ls07id16))){
            return false;
        }

        if(!validatorClass.EmptyTextBox(this,bi.ls07id04,getString(R.string.ls07id04))){
            return false;
        }

        if(!validatorClass.EmptyRadioButton(this,bi.ls07id05,bi.ls07id05a,getString(R.string.ls07id05))){
            return false;
        }

        if(!validatorClass.EmptyTextBox(this,bi.ls07id06,getString(R.string.ls07id06))){
            return false;
        }

        if(!validatorClass.EmptyTextBox(this,bi.ls07id07,getString(R.string.ls07id07))){
            return false;
        }

        if(!validatorClass.EmptyRadioButton(this,bi.ls07id08,bi.ls07id08a,getString(R.string.ls07id08))){
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ls07id09, bi.ls07id09a, getString(R.string.ls07id09))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.ls07id10, bi.ls07id10a, getString(R.string.ls07id10))) {
            return false;
        }

        if(!validatorClass.EmptyTextBox(this,bi.ls07id11,getString(R.string.ls07id11))){
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.ls07id12, bi.ls07id12a, getString(R.string.ls07id12))) {
            return false;
        }
        if(bi.ls07id1296.isChecked()){
            if(!validatorClass.EmptyTextBox(this,bi.ls07id1296x,getString(R.string.ls07id12))){
                return false;
            }
        }

        if(!validatorClass.EmptyTextBox(this,bi.ls07id13,getString(R.string.ls07id13))){
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.ls07id14, bi.ls07id14a, getString(R.string.ls07id14))) {
            return false;
        }

        return true;
    }

    private void SaveDraft() throws JSONException {

        JSONObject f07 = new JSONObject();

        f07.put("ls0701",bi.ls07id01.getText().toString());
        f07.put("ls0702",bi.ls07id02.getText().toString());
        f07.put("ls0703",bi.ls07id03.getText().toString());
        f07.put("ls0704",bi.ls07id04.getText().toString());
        f07.put("ls0705",bi.ls07id05a.isChecked()? "1"
                : bi.ls07id05b.isChecked()? "2"
                : "0" );
        f07.put("ls0706",bi.ls07id06.getText().toString());
        f07.put("ls0707",bi.ls07id07.getText().toString());

        f07.put("ls0708",bi.ls07id08a.isChecked()? "1"
                : bi.ls07id08b.isChecked()? "2"
                : "0" );

        f07.put("ls0709",bi.ls07id09a.isChecked()? "1"
                : bi.ls07id09b.isChecked()? "2"
                : bi.ls07id0998.isChecked()? "98"
                : "0" );

        f07.put("ls0710",bi.ls07id10a.isChecked()? "1"
                : bi.ls07id10b.isChecked()? "2"
                : "0" );

        f07.put("ls0711",bi.ls07id11.getText().toString());

        f07.put("ls0712",bi.ls07id12a.isChecked()? "1"
                : bi.ls07id12b.isChecked()? "2"
                : bi.ls07id12c.isChecked()? "3"
                : bi.ls07id12d.isChecked()? "4"
                : bi.ls07id1296.isChecked()? "96"
                : "0" );
        f07.put("ls071296",bi.ls07id1296x.getText().toString());

        f07.put("ls0713",bi.ls07id13.getText().toString());

        f07.put("ls0714",bi.ls07id14a.isChecked()? "1"
                : bi.ls07id14b.isChecked()? "2"
                : bi.ls07id14c.isChecked()? "3"
                : "0" );

        f07.put("ls0715",bi.ls07id15.getSelectedItem().toString());
        f07.put("ls0716",bi.ls07id16.getSelectedItem().toString());
    }

    public void BtnEnd() {
        startActivity(new Intent(getApplicationContext(), EndingActivity.class).putExtra("complete", false));
    }
}
