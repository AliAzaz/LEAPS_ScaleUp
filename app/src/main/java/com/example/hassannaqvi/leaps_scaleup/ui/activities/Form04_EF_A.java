package com.example.hassannaqvi.leaps_scaleup.ui.activities;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;

import com.example.hassannaqvi.leaps_scaleup.R;
import com.example.hassannaqvi.leaps_scaleup.databinding.ActivityForm04EfABinding;

public class Form04_EF_A extends AppCompatActivity {
ActivityForm04EfABinding bi;
String ls04aa01a = "" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form04_ef_a);
        bi = DataBindingUtil.setContentView(this,R.layout.activity_form04_ef_a);
        bi.setCallback(this);
        bi.ls04aa01a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04aa01a =ls04aa01a+"\t"+ "3";
                bi.ls04aa01a.setText(ls04aa01a);
            }
        });
        bi.ls04aa01a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04aa01a =ls04aa01a+"\t"+ "7";
                bi.ls04aa01a.setText(ls04aa01a);
            }
        });
        bi.ls04aa01a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ls04aa01a =ls04aa01a+"\t"+ "7";
                ls04aa01a = ls04aa01a+"\t"+ "X";
                bi.ls04aa01a.setText(ls04aa01a);
            }
        });


//        setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    if(!TextUtils.isEmpty(bi.ls04aa01aa.getText().toString())){
//                        if(!bi.ls04aa01aa.getText().toString().matches("3")){
//                            ls04aa01a =ls04aa01a+"\t"+ "3";
//                        }else {
//
//                        }
//                    }else{
//
//                    }
//
//                    ls04aa01a =ls04aa01a+"\t"+ "3";
//                    bi.ls04aa01aa.setText(ls04aa01a);
//                }else {
//                    bi.ls04aa01aa.setText(null);
//
////                    removeLastChar(bi.ls04aa01a.getText().toString());
//                }
//            }
//        });
       /* bi.ls04aa01a2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
//                    ls04aa01a = ls04aa01a+"\t"+"7";
                    bi.ls04aa01ab.setText("7");
                }else {
                    bi.ls04aa01ab.setText(null);

//                    removeLastChar(bi.ls04aa01a.getText().toString());
                }
            }
        });*/



    }
    private static String removeLastChar(String str) {
        return str.substring(0, str.length() - 1);
    }
    public void BtnContinue(){

    }
    public void BtnEnd(){

    }
}
