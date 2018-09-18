package com.example.hassannaqvi.wfppishincr.ui.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.hassannaqvi.wfppishincr.R;
import com.example.hassannaqvi.wfppishincr.core.DatabaseHelper;
import com.example.hassannaqvi.wfppishincr.core.MainApp;
import com.example.hassannaqvi.wfppishincr.databinding.ActivitySectionMBinding;

import org.json.JSONException;
import org.json.JSONObject;

public class SectionMActivity extends AppCompatActivity {
ActivitySectionMBinding bi;
    private static final String TAG = SectionMActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_m);
        bi.setCallback(this);

        this.setTitle("Section M");

        //=============== Q 1B Skip Pattern==============
        bi.ccm01d.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (Integer.parseInt(bi.ccm01d.getText().toString().isEmpty() ? "0" : bi.ccm01d.getText().toString()) > 0) {
                    bi.fldGrpccm01s.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpccm01s.setVisibility(View.GONE);
                    bi.ccm01s.clearCheck();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //=============== Q 2B Skip Pattern==============
        bi.ccm02d.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (Integer.parseInt(bi.ccm02d.getText().toString().isEmpty() ? "0" : bi.ccm02d.getText().toString()) > 0) {
                    bi.fldGrpccm02s.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpccm02s.setVisibility(View.GONE);
                    bi.ccm02s.clearCheck();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //=============== Q 3B Skip Pattern==============
        bi.ccm03d.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (Integer.parseInt(bi.ccm03d.getText().toString().isEmpty() ? "0" : bi.ccm03d.getText().toString()) > 0) {
                    bi.fldGrpccm03s.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpccm03s.setVisibility(View.GONE);
                    bi.ccm03s.clearCheck();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //=============== Q 4B Skip Pattern==============
        bi.ccm04d.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (Integer.parseInt(bi.ccm04d.getText().toString().isEmpty() ? "0" : bi.ccm04d.getText().toString()) > 0) {
                    bi.fldGrpccm04s.setVisibility(View.VISIBLE);
                    bi.fldGrpccm04.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpccm04.setVisibility(View.GONE);
                    bi.fldGrpccm04s.setVisibility(View.GONE);
                    bi.ccm04s.clearCheck();
                    bi.ccm0401d.setText(null);
                    bi.ccm0401s.clearCheck();
                    bi.ccm0402d.setText(null);
                    bi.ccm0402s.clearCheck();
                    bi.ccm0403d.setText(null);
                    bi.ccm0403s.clearCheck();
                    bi.ccm0404d.setText(null);
                    bi.ccm0404s.clearCheck();

                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //=============== Q 4.1 B Skip Pattern==============
        bi.ccm0401d.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (Integer.parseInt(bi.ccm0401d.getText().toString().isEmpty() ? "0" : bi.ccm0401d.getText().toString()) > 0) {
                    bi.fldGrpccm0401s.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpccm0401s.setVisibility(View.GONE);
                    bi.ccm0401s.clearCheck();

                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //=============== Q 4.2 B Skip Pattern==============
        bi.ccm0402d.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (Integer.parseInt(bi.ccm0402d.getText().toString().isEmpty() ? "0" : bi.ccm0402d.getText().toString()) > 0) {
                    bi.fldGrpccm0402s.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpccm0402s.setVisibility(View.GONE);
                    bi.ccm0402s.clearCheck();

                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //=============== Q 4.3 B Skip Pattern==============
        bi.ccm0403d.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (Integer.parseInt(bi.ccm0403d.getText().toString().isEmpty() ? "0" : bi.ccm0403d.getText().toString()) > 0) {
                    bi.fldGrpccm0403s.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpccm0403s.setVisibility(View.GONE);
                    bi.ccm0403s.clearCheck();

                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //=============== Q 4.4 B Skip Pattern==============
        bi.ccm0404d.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (Integer.parseInt(bi.ccm0404d.getText().toString().isEmpty() ? "0" : bi.ccm0404d.getText().toString()) > 0) {
                    bi.fldGrpccm0404s.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpccm0404s.setVisibility(View.GONE);
                    bi.ccm0404s.clearCheck();

                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        //=============== Q 5B Skip Pattern==============
        bi.ccm05d.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (Integer.parseInt(bi.ccm05d.getText().toString().isEmpty() ? "0" : bi.ccm05d.getText().toString()) > 0) {
                    bi.fldGrpccm05s.setVisibility(View.VISIBLE);
                    bi.fldGrpccm05.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpccm05s.setVisibility(View.GONE);
                    bi.fldGrpccm05.setVisibility(View.GONE);
                    bi.ccm05s.clearCheck();
                    bi.ccm0501d.setText(null);
                    bi.ccm0501s.clearCheck();
                    bi.ccm0502d.setText(null);
                    bi.ccm0502s.clearCheck();

                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //=============== Q 5.1 B Skip Pattern==============
        bi.ccm0501d.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (Integer.parseInt(bi.ccm0501d.getText().toString().isEmpty() ? "0" : bi.ccm0501d.getText().toString()) > 0) {
                    bi.fldGrpccm0501s.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpccm0501s.setVisibility(View.GONE);
                    bi.ccm0501s.clearCheck();


                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //=============== Q 5.2 B Skip Pattern==============
        bi.ccm0502d.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (Integer.parseInt(bi.ccm0502d.getText().toString().isEmpty() ? "0" : bi.ccm0502d.getText().toString()) > 0) {
                    bi.fldGrpccm0502s.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpccm0502s.setVisibility(View.GONE);
                    bi.ccm0502s.clearCheck();

                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        //=============== Q 6B Skip Pattern==============
        bi.ccm06d.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (Integer.parseInt(bi.ccm06d.getText().toString().isEmpty() ? "0" : bi.ccm06d.getText().toString()) > 0) {
                    bi.fldGrpccm06s.setVisibility(View.VISIBLE);
                    bi.fldGrpccm06.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpccm06s.setVisibility(View.GONE);
                    bi.fldGrpccm06.setVisibility(View.GONE);
                    bi.ccm06s.clearCheck();
                    bi.ccm0601d.setText(null);
                    bi.ccm0601s.clearCheck();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //=============== Q 6.1 B Skip Pattern==============
        bi.ccm0601d.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (Integer.parseInt(bi.ccm0601d.getText().toString().isEmpty() ? "0" : bi.ccm0601d.getText().toString()) > 0) {
                    bi.fldGrpccm0601s.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpccm0601s.setVisibility(View.GONE);
                    bi.ccm0601s.clearCheck();

                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //=============== Q 7B Skip Pattern==============
        bi.ccm07d.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (Integer.parseInt(bi.ccm07d.getText().toString().isEmpty() ? "0" : bi.ccm07d.getText().toString()) > 0) {
                    bi.fldGrpccm07s.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpccm07s.setVisibility(View.GONE);
                    bi.ccm07s.clearCheck();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //=============== Q 8B Skip Pattern==============
        bi.ccm08d.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (Integer.parseInt(bi.ccm08d.getText().toString().isEmpty() ? "0" : bi.ccm08d.getText().toString()) > 0) {
                    bi.fldGrpccm08s.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpccm08s.setVisibility(View.GONE);
                    bi.ccm08s.clearCheck();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //=============== Q 9B Skip Pattern==============
        bi.ccm09d.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (Integer.parseInt(bi.ccm09d.getText().toString().isEmpty() ? "0" : bi.ccm09d.getText().toString()) > 0) {
                    bi.fldGrpccm09s.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpccm09s.setVisibility(View.GONE);
                    bi.ccm09s.clearCheck();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }


   public void BtnContinue() {
        if (ValidateForm()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                Toast.makeText(this, "Starting Next Section", Toast.LENGTH_SHORT).show();

                finish();

                Intent secNext = new Intent(this, SectionNOPActivity.class);
                startActivity(secNext);

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }


    }



    public void BtnEnd() {
        MainApp.endActivity(this, this);

    }


    private void SaveDraft() throws JSONException {

        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        JSONObject sM = new JSONObject();

        sM.put("ccm01d", bi.ccm01d.getText().toString());
        sM.put("ccm01s", bi.ccm01s01.isChecked() ? "1" : bi.ccm01s02.isChecked() ? "2" : bi.ccm01s03.isChecked() ? "3"
                : bi.ccm01s04.isChecked() ? "4" : bi.ccm01s05.isChecked() ? "5" : bi.ccm01s06.isChecked() ? "6" : bi.ccm01s07.isChecked() ? "7"
                : bi.ccm01s08.isChecked() ? "8" : bi.ccm01s09.isChecked() ? "9" : bi.ccm01s10.isChecked() ? "10" : "0");

        sM.put("ccm02d", bi.ccm02d.getText().toString());
        sM.put("ccm02s", bi.ccm02s01.isChecked() ? "1" : bi.ccm02s02.isChecked() ? "2" : bi.ccm02s03.isChecked() ? "3"
                : bi.ccm02s04.isChecked() ? "4" : bi.ccm02s05.isChecked() ? "5" : bi.ccm02s06.isChecked() ? "6" : bi.ccm02s07.isChecked() ? "7"
                : bi.ccm02s08.isChecked() ? "8" : bi.ccm02s09.isChecked() ? "9" : bi.ccm02s10.isChecked() ? "10" : "0");

        sM.put("ccm03d", bi.ccm03d.getText().toString());
        sM.put("ccm03s", bi.ccm03s01.isChecked() ? "1" : bi.ccm03s02.isChecked() ? "2" : bi.ccm03s03.isChecked() ? "3"
                : bi.ccm03s04.isChecked() ? "4" : bi.ccm03s05.isChecked() ? "5" : bi.ccm03s06.isChecked() ? "6" : bi.ccm03s07.isChecked() ? "7"
                : bi.ccm03s08.isChecked() ? "8" : bi.ccm03s09.isChecked() ? "9" : bi.ccm03s10.isChecked() ? "10" : "0");

        sM.put("ccm04d", bi.ccm04d.getText().toString());
        sM.put("ccm04s", bi.ccm04s01.isChecked() ? "1" : bi.ccm04s02.isChecked() ? "2" : bi.ccm04s03.isChecked() ? "3"
                : bi.ccm04s04.isChecked() ? "4" : bi.ccm04s05.isChecked() ? "5" : bi.ccm04s06.isChecked() ? "6" : bi.ccm04s07.isChecked() ? "7"
                : bi.ccm04s08.isChecked() ? "8" : bi.ccm04s09.isChecked() ? "9" : bi.ccm04s10.isChecked() ? "10" : "0");

        sM.put("ccm0401d", bi.ccm0401d.getText().toString());
        sM.put("ccm0401s", bi.ccm0401s01.isChecked() ? "1" : bi.ccm0401s02.isChecked() ? "2" : bi.ccm0401s03.isChecked() ? "3"
                : bi.ccm0401s04.isChecked() ? "4" : bi.ccm0401s05.isChecked() ? "5" : bi.ccm0401s06.isChecked() ? "6" : bi.ccm0401s07.isChecked() ? "7"
                : bi.ccm0401s08.isChecked() ? "8" : bi.ccm0401s09.isChecked() ? "9" : bi.ccm0401s10.isChecked() ? "10" : "0");

        sM.put("ccm0402d", bi.ccm0402d.getText().toString());
        sM.put("ccm0402s", bi.ccm0402s01.isChecked() ? "1" : bi.ccm0402s02.isChecked() ? "2" : bi.ccm0402s03.isChecked() ? "3"
                : bi.ccm0402s04.isChecked() ? "4" : bi.ccm0402s05.isChecked() ? "5" : bi.ccm0402s06.isChecked() ? "6" : bi.ccm0402s07.isChecked() ? "7"
                : bi.ccm0402s08.isChecked() ? "8" : bi.ccm0402s09.isChecked() ? "9" : bi.ccm0402s10.isChecked() ? "10" : "0");

        sM.put("ccm0403d", bi.ccm0403d.getText().toString());
        sM.put("ccm0403s", bi.ccm0403s01.isChecked() ? "1" : bi.ccm0403s02.isChecked() ? "2" : bi.ccm0403s03.isChecked() ? "3"
                : bi.ccm0403s04.isChecked() ? "4" : bi.ccm0403s05.isChecked() ? "5" : bi.ccm0403s06.isChecked() ? "6" : bi.ccm0403s07.isChecked() ? "7"
                : bi.ccm0403s08.isChecked() ? "8" : bi.ccm0403s09.isChecked() ? "9" : bi.ccm0403s10.isChecked() ? "10" : "0");

        sM.put("ccm0404d", bi.ccm0404d.getText().toString());
        sM.put("ccm0404s", bi.ccm0404s01.isChecked() ? "1" : bi.ccm0404s02.isChecked() ? "2" : bi.ccm0404s03.isChecked() ? "3"
                : bi.ccm0404s04.isChecked() ? "4" : bi.ccm0404s05.isChecked() ? "5" : bi.ccm0404s06.isChecked() ? "6" : bi.ccm0404s07.isChecked() ? "7"
                : bi.ccm0404s08.isChecked() ? "8" : bi.ccm0404s09.isChecked() ? "9" : bi.ccm0404s10.isChecked() ? "10" : "0");

        sM.put("ccm05d", bi.ccm05d.getText().toString());
        sM.put("ccm05s", bi.ccm05s01.isChecked() ? "1" : bi.ccm05s02.isChecked() ? "2" : bi.ccm05s03.isChecked() ? "3"
                : bi.ccm05s04.isChecked() ? "4" : bi.ccm05s05.isChecked() ? "5" : bi.ccm05s06.isChecked() ? "6" : bi.ccm05s07.isChecked() ? "7"
                : bi.ccm05s08.isChecked() ? "8" : bi.ccm05s09.isChecked() ? "9" : bi.ccm05s10.isChecked() ? "10" : "0");

        sM.put("ccm0501d", bi.ccm0501d.getText().toString());
        sM.put("ccm0501s", bi.ccm0501s01.isChecked() ? "1" : bi.ccm0501s02.isChecked() ? "2" : bi.ccm0403s03.isChecked() ? "3"
                : bi.ccm0501s04.isChecked() ? "4" : bi.ccm0501s05.isChecked() ? "5" : bi.ccm0501s06.isChecked() ? "6" : bi.ccm0501s07.isChecked() ? "7"
                : bi.ccm0501s08.isChecked() ? "8" : bi.ccm0501s09.isChecked() ? "9" : bi.ccm0501s10.isChecked() ? "10" : "0");

        sM.put("ccm0502d", bi.ccm0502d.getText().toString());
        sM.put("ccm0502s", bi.ccm0502s01.isChecked() ? "1" : bi.ccm0502s02.isChecked() ? "2" : bi.ccm0502s03.isChecked() ? "3"
                : bi.ccm0502s04.isChecked() ? "4" : bi.ccm0502s05.isChecked() ? "5" : bi.ccm0502s06.isChecked() ? "6" : bi.ccm0502s07.isChecked() ? "7"
                : bi.ccm0502s08.isChecked() ? "8" : bi.ccm0502s09.isChecked() ? "9" : bi.ccm0502s10.isChecked() ? "10" : "0");

        sM.put("ccm06d", bi.ccm06d.getText().toString());
        sM.put("ccm06s", bi.ccm06s01.isChecked() ? "1" : bi.ccm06s02.isChecked() ? "2" : bi.ccm06s03.isChecked() ? "3"
                : bi.ccm06s04.isChecked() ? "4" : bi.ccm06s05.isChecked() ? "5" : bi.ccm06s06.isChecked() ? "6" : bi.ccm06s07.isChecked() ? "7"
                : bi.ccm06s08.isChecked() ? "8" : bi.ccm06s09.isChecked() ? "9" : bi.ccm06s10.isChecked() ? "10" : "0");

        sM.put("ccm0601d", bi.ccm0601d.getText().toString());
        sM.put("ccm0601s", bi.ccm0601s01.isChecked() ? "1" : bi.ccm0601s02.isChecked() ? "2" : bi.ccm0601s03.isChecked() ? "3"
                : bi.ccm0601s04.isChecked() ? "4" : bi.ccm0601s05.isChecked() ? "5" : bi.ccm0601s06.isChecked() ? "6" : bi.ccm0601s07.isChecked() ? "7"
                : bi.ccm0601s08.isChecked() ? "8" : bi.ccm0601s09.isChecked() ? "9" : bi.ccm0601s10.isChecked() ? "10" : "0");

        sM.put("ccm07d", bi.ccm07d.getText().toString());
        sM.put("ccm07s", bi.ccm07s01.isChecked() ? "1" : bi.ccm07s02.isChecked() ? "2" : bi.ccm07s03.isChecked() ? "3"
                : bi.ccm07s04.isChecked() ? "4" : bi.ccm07s05.isChecked() ? "5" : bi.ccm07s06.isChecked() ? "6" : bi.ccm07s07.isChecked() ? "7"
                : bi.ccm07s08.isChecked() ? "8" : bi.ccm07s09.isChecked() ? "9" : bi.ccm07s10.isChecked() ? "10" : "0");

        sM.put("ccm08d", bi.ccm08d.getText().toString());
        sM.put("ccm08s", bi.ccm08s01.isChecked() ? "1" : bi.ccm08s02.isChecked() ? "2" : bi.ccm08s03.isChecked() ? "3"
                : bi.ccm08s04.isChecked() ? "4" : bi.ccm08s05.isChecked() ? "5" : bi.ccm08s06.isChecked() ? "6" : bi.ccm08s07.isChecked() ? "7"
                : bi.ccm08s08.isChecked() ? "8" : bi.ccm08s09.isChecked() ? "9" : bi.ccm08s10.isChecked() ? "10" : "0");

        sM.put("ccm09d", bi.ccm09d.getText().toString());
        sM.put("ccm09s", bi.ccm09s01.isChecked() ? "1" : bi.ccm09s02.isChecked() ? "2" : bi.ccm09s03.isChecked() ? "3"
                : bi.ccm09s04.isChecked() ? "4" : bi.ccm09s05.isChecked() ? "5" : bi.ccm09s06.isChecked() ? "6" : bi.ccm09s07.isChecked() ? "7"
                : bi.ccm09s08.isChecked() ? "8" : bi.ccm09s09.isChecked() ? "9" : bi.ccm09s10.isChecked() ? "10" : "0");

        MainApp.fc.setsM(String.valueOf(sM));

        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();

    }

    public boolean ValidateForm() {

        Toast.makeText(this, "Validating Section M", Toast.LENGTH_SHORT).show();

        //======================= Q 1 ===============
        if (bi.ccm01d.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.ccmrec), Toast.LENGTH_SHORT).show();
            bi.ccm01d.setError("This data is Required!");
            Log.i(TAG, "ccm01d: This data is Required!");
            return false;
        } else {
            bi.ccm01d.setError(null);
        }

        if (Integer.valueOf(bi.ccm01d.getText().toString()) < 0 || Integer.valueOf(bi.ccm01d.getText().toString()) > 7) {
            Toast.makeText(this, "ERROR(Invalid): " + getString(R.string.ccmrec), Toast.LENGTH_SHORT).show();
            bi.ccm01d.setError("Range is 0 - 7 days");
            Log.i(TAG, "ccm01d: This data is Required!");
            return false;
        } else {
            bi.ccm01d.setError(null);
        }

        if (Integer.valueOf(bi.ccm01d.getText().toString()) > 0) {
            if (bi.ccm01s.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.ccmsource), Toast.LENGTH_SHORT).show();
                bi.ccm01s10.setError("This data is Required!");
                Log.i(TAG, "ccm01s: This data is Required!");
                return false;
            } else {
                bi.ccm01s10.setError(null);
            }
        }


        //======================= Q 2 ===============
        if (bi.ccm02d.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.ccmrec), Toast.LENGTH_SHORT).show();
            bi.ccm02d.setError("This data is Required!");
            Log.i(TAG, "ccm02d: This data is Required!");
            return false;
        } else {
            bi.ccm02d.setError(null);
        }

        if (Integer.valueOf(bi.ccm02d.getText().toString()) < 0 || Integer.valueOf(bi.ccm02d.getText().toString()) > 7) {
            Toast.makeText(this, "ERROR(Invalid): " + getString(R.string.ccmrec), Toast.LENGTH_SHORT).show();
            bi.ccm02d.setError("Range is 0 - 7 days");
            Log.i(TAG, "ccm02d: This data is Required!");
            return false;
        } else {
            bi.ccm02d.setError(null);
        }

        if (Integer.valueOf(bi.ccm02d.getText().toString()) > 0) {
            if (bi.ccm02s.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.ccmsource), Toast.LENGTH_SHORT).show();
                bi.ccm02s10.setError("This data is Required!");
                Log.i(TAG, "ccm02s: This data is Required!");
                return false;
            } else {
                bi.ccm02s10.setError(null);
            }

        }


        //======================= Q 3 ===============
        if (bi.ccm03d.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.ccmrec), Toast.LENGTH_SHORT).show();
            bi.ccm03d.setError("This data is Required!");
            Log.i(TAG, "ccm03d: This data is Required!");
            return false;
        } else {
            bi.ccm03d.setError(null);
        }

        if (Integer.valueOf(bi.ccm03d.getText().toString()) < 0 || Integer.valueOf(bi.ccm03d.getText().toString()) > 7) {
            Toast.makeText(this, "ERROR(Invalid): " + getString(R.string.ccmrec), Toast.LENGTH_SHORT).show();
            bi.ccm03d.setError("Range is 0 - 7 days");
            Log.i(TAG, "ccm03d: This data is Required!");
            return false;
        } else {
            bi.ccm03d.setError(null);
        }

        if (Integer.valueOf(bi.ccm03d.getText().toString()) > 0) {
            if (bi.ccm03s.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.ccmsource), Toast.LENGTH_SHORT).show();
                bi.ccm03s10.setError("This data is Required!");
                Log.i(TAG, "ccm03s: This data is Required!");
                return false;
            } else {
                bi.ccm03s10.setError(null);
            }

        }

        //======================= Q 4 ===============
        if (bi.ccm04d.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.ccmrec), Toast.LENGTH_SHORT).show();
            bi.ccm04d.setError("This data is Required!");
            Log.i(TAG, "ccm01d: This data is Required!");
            return false;
        } else {
            bi.ccm04d.setError(null);
        }

        if (Integer.valueOf(bi.ccm04d.getText().toString()) < 0 || Integer.valueOf(bi.ccm04d.getText().toString()) > 7) {
            Toast.makeText(this, "ERROR(Invalid): " + getString(R.string.ccmrec), Toast.LENGTH_SHORT).show();
            bi.ccm04d.setError("Range is 0 - 7 days");
            Log.i(TAG, "ccm04d: This data is Required!");
            return false;
        } else {
            bi.ccm04d.setError(null);
        }

        if (Integer.valueOf(bi.ccm04d.getText().toString()) > 0) {
            if (bi.ccm04s.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.ccmsource), Toast.LENGTH_SHORT).show();
                bi.ccm04s10.setError("This data is Required!");
                Log.i(TAG, "ccm04s: This data is Required!");
                return false;
            } else {
                bi.ccm04s10.setError(null);
            }

            //======================= Q 4.1 ===============
            if (bi.ccm0401d.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.ccmrec), Toast.LENGTH_SHORT).show();
                bi.ccm0401d.setError("This data is Required!");
                Log.i(TAG, "ccm0401d: This data is Required!");
                return false;
            } else {
                bi.ccm0401d.setError(null);
            }

            if (Integer.valueOf(bi.ccm0401d.getText().toString()) < 0 || Integer.valueOf(bi.ccm0401d.getText().toString()) > 7) {
                Toast.makeText(this, "ERROR(Invalid): " + getString(R.string.ccmrec), Toast.LENGTH_SHORT).show();
                bi.ccm0401d.setError("Range is 0 - 7 days");
                Log.i(TAG, "ccm01d: This data is Required!");
                return false;
            } else {
                bi.ccm0401d.setError(null);
            }

            if (Integer.valueOf(bi.ccm0401d.getText().toString()) > 0) {
                if (bi.ccm0401s.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.ccmsource), Toast.LENGTH_SHORT).show();
                    bi.ccm0401s10.setError("This data is Required!");
                    Log.i(TAG, "ccm0401s: This data is Required!");
                    return false;
                } else {
                    bi.ccm0401s10.setError(null);
                }

            }

            //======================= Q 4.2 ===============
            if (bi.ccm0402d.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.ccmrec), Toast.LENGTH_SHORT).show();
                bi.ccm0402d.setError("This data is Required!");
                Log.i(TAG, "ccm0402d: This data is Required!");
                return false;
            } else {
                bi.ccm0402d.setError(null);
            }

            if (Integer.valueOf(bi.ccm0402d.getText().toString()) < 0 || Integer.valueOf(bi.ccm0402d.getText().toString()) > 7) {
                Toast.makeText(this, "ERROR(Invalid): " + getString(R.string.ccmrec), Toast.LENGTH_SHORT).show();
                bi.ccm0402d.setError("Range is 0 - 7 days");
                Log.i(TAG, "ccm0402d: This data is Required!");
                return false;
            } else {
                bi.ccm0402d.setError(null);
            }

            if (Integer.valueOf(bi.ccm0402d.getText().toString()) > 0) {
                if (bi.ccm0402s.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.ccmsource), Toast.LENGTH_SHORT).show();
                    bi.ccm0402s10.setError("This data is Required!");
                    Log.i(TAG, "ccm0402s: This data is Required!");
                    return false;
                } else {
                    bi.ccm0402s10.setError(null);
                }

            }

            //======================= Q 4.3 ===============
            if (bi.ccm0403d.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.ccmrec), Toast.LENGTH_SHORT).show();
                bi.ccm0403d.setError("This data is Required!");
                Log.i(TAG, "ccm0403d: This data is Required!");
                return false;
            } else {
                bi.ccm0403d.setError(null);
            }

            if (Integer.valueOf(bi.ccm0403d.getText().toString()) < 0 || Integer.valueOf(bi.ccm0403d.getText().toString()) > 7) {
                Toast.makeText(this, "ERROR(Invalid): " + getString(R.string.ccmrec), Toast.LENGTH_SHORT).show();
                bi.ccm0403d.setError("Range is 0 - 7 days");
                Log.i(TAG, "ccm0403d: This data is Required!");
                return false;
            } else {
                bi.ccm0403d.setError(null);
            }

            if (Integer.valueOf(bi.ccm0403d.getText().toString()) > 0) {
                if (bi.ccm0403s.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.ccmsource), Toast.LENGTH_SHORT).show();
                    bi.ccm0403s10.setError("This data is Required!");
                    Log.i(TAG, "ccm0403s: This data is Required!");
                    return false;
                } else {
                    bi.ccm0403s10.setError(null);
                }

            }

            //======================= Q 4.4 ===============
            if (bi.ccm0404d.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.ccmrec), Toast.LENGTH_SHORT).show();
                bi.ccm0404d.setError("This data is Required!");
                Log.i(TAG, "bi.ccm0404d: This data is Required!");
                return false;
            } else {
                bi.ccm0404d.setError(null);
            }

            if (Integer.valueOf(bi.ccm0404d.getText().toString()) < 0 || Integer.valueOf(bi.ccm0404d.getText().toString()) > 7) {
                Toast.makeText(this, "ERROR(Invalid): " + getString(R.string.ccmrec), Toast.LENGTH_SHORT).show();
                bi.ccm0404d.setError("Range is 0 - 7 days");
                Log.i(TAG, "bi.ccm0404d: This data is Required!");
                return false;
            } else {
                bi.ccm0404d.setError(null);
            }

            if (Integer.valueOf(bi.ccm0404d.getText().toString()) > 0) {
                if (bi.ccm0404s.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.ccmsource), Toast.LENGTH_SHORT).show();
                    bi.ccm0404s10.setError("This data is Required!");
                    Log.i(TAG, "ccm0404s: This data is Required!");
                    return false;
                } else {
                    bi.ccm0404s10.setError(null);
                }

            }

        }

        //======================= Q 5 ===============
        if (bi.ccm05d.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.ccmrec), Toast.LENGTH_SHORT).show();
            bi.ccm05d.setError("This data is Required!");
            Log.i(TAG, "bi.ccm05d: This data is Required!");
            return false;
        } else {
            bi.ccm05d.setError(null);
        }

        if (Integer.valueOf(bi.ccm05d.getText().toString()) < 0 || Integer.valueOf(bi.ccm05d.getText().toString()) > 7) {
            Toast.makeText(this, "ERROR(Invalid): " + getString(R.string.ccmrec), Toast.LENGTH_SHORT).show();
            bi.ccm05d.setError("Range is 0 - 7 days");
            Log.i(TAG, "ccm05d: This data is Required!");
            return false;
        } else {
            bi.ccm05d.setError(null);
        }

        if (Integer.valueOf(bi.ccm05d.getText().toString()) > 0) {
            if (bi.ccm05s.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.ccmsource), Toast.LENGTH_SHORT).show();
                bi.ccm05s10.setError("This data is Required!");
                Log.i(TAG, "ccm05s: This data is Required!");
                return false;
            } else {
                bi.ccm05s10.setError(null);
            }

            //======================= Q 5.1 ===============
            if (bi.ccm0501d.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.ccmrec), Toast.LENGTH_SHORT).show();
                bi.ccm0501d.setError("This data is Required!");
                Log.i(TAG, "ccm0501d: This data is Required!");
                return false;
            } else {
                bi.ccm0501d.setError(null);
            }

            if (Integer.valueOf(bi.ccm0501d.getText().toString()) < 0 || Integer.valueOf(bi.ccm0501d.getText().toString()) > 7) {
                Toast.makeText(this, "ERROR(Invalid): " + getString(R.string.ccmrec), Toast.LENGTH_SHORT).show();
                bi.ccm0501d.setError("Range is 0 - 7 days");
                Log.i(TAG, "ccm0501d: This data is Required!");
                return false;
            } else {
                bi.ccm0501d.setError(null);
            }

            if (Integer.valueOf(bi.ccm0501d.getText().toString()) > 0) {
                if (bi.ccm0501s.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.ccmsource), Toast.LENGTH_SHORT).show();
                    bi.ccm0501s10.setError("This data is Required!");
                    Log.i(TAG, "ccm0501s: This data is Required!");
                    return false;
                } else {
                    bi.ccm0501s10.setError(null);
                }

            }

            //======================= Q 5.2 ===============
            if (bi.ccm0502d.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.ccmrec), Toast.LENGTH_SHORT).show();
                bi.ccm0502d.setError("This data is Required!");
                Log.i(TAG, "ccm0502d: This data is Required!");
                return false;
            } else {
                bi.ccm0502d.setError(null);
            }


            if (Integer.valueOf(bi.ccm0502d.getText().toString()) < 0 || Integer.valueOf(bi.ccm0502d.getText().toString()) > 7) {
                Toast.makeText(this, "ERROR(Invalid): " + getString(R.string.ccmrec), Toast.LENGTH_SHORT).show();
                bi.ccm0502d.setError("Range is 0 - 7 days");
                Log.i(TAG, "ccm0502d: This data is Required!");
                return false;
            } else {
                bi.ccm0502d.setError(null);
            }

            if (Integer.valueOf(bi.ccm0502d.getText().toString()) > 0) {
                if (bi.ccm0502s.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.ccmsource), Toast.LENGTH_SHORT).show();
                    bi.ccm0502s10.setError("This data is Required!");
                    Log.i(TAG, "ccm0502s: This data is Required!");
                    return false;
                } else {
                    bi.ccm0502s10.setError(null);
                }

            }


        }

        //======================= Q 6 ===============
        if (bi.ccm06d.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.ccmrec), Toast.LENGTH_SHORT).show();
            bi.ccm06d.setError("This data is Required!");
            Log.i(TAG, "ccm06d: This data is Required!");
            return false;
        } else {
            bi.ccm06d.setError(null);
        }

        if (Integer.valueOf(bi.ccm06d.getText().toString()) < 0 || Integer.valueOf(bi.ccm06d.getText().toString()) > 7) {
            Toast.makeText(this, "ERROR(Invalid): " + getString(R.string.ccmrec), Toast.LENGTH_SHORT).show();
            bi.ccm06d.setError("Range is 0 - 7 days");
            Log.i(TAG, "ccm06d: This data is Required!");
            return false;
        } else {
            bi.ccm06d.setError(null);
        }

        if (Integer.valueOf(bi.ccm06d.getText().toString()) > 0) {
            if (bi.ccm06s.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.ccmsource), Toast.LENGTH_SHORT).show();
                bi.ccm06s10.setError("This data is Required!");
                Log.i(TAG, "ccm06s: This data is Required!");
                return false;
            } else {
                bi.ccm06s10.setError(null);
            }

            //======================= Q 6.1 ===============
            if (bi.ccm0601d.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.ccmrec), Toast.LENGTH_SHORT).show();
                bi.ccm0601d.setError("This data is Required!");
                Log.i(TAG, "ccm0601d: This data is Required!");
                return false;
            } else {
                bi.ccm0601d.setError(null);
            }

            if (Integer.valueOf(bi.ccm0601d.getText().toString()) < 0 || Integer.valueOf(bi.ccm0601d.getText().toString()) > 7) {
                Toast.makeText(this, "ERROR(Invalid): " + getString(R.string.ccmrec), Toast.LENGTH_SHORT).show();
                bi.ccm0601d.setError("Range is 0 - 7 days");
                Log.i(TAG, "ccm0601d: This data is Required!");
                return false;
            } else {
                bi.ccm0601d.setError(null);
            }

            if (Integer.valueOf(bi.ccm0601d.getText().toString()) > 0) {
                if (bi.ccm0601s.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.ccmsource), Toast.LENGTH_SHORT).show();
                    bi.ccm0601s10.setError("This data is Required!");
                    Log.i(TAG, "bi.ccm0601s: This data is Required!");
                    return false;
                } else {
                    bi.ccm0601s10.setError(null);
                }

            }


        }

        //======================= Q 7 ===============
        if (bi.ccm07d.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.ccmrec), Toast.LENGTH_SHORT).show();
            bi.ccm07d.setError("This data is Required!");
            Log.i(TAG, "bi.ccm07d: This data is Required!");
            return false;
        } else {
            bi.ccm07d.setError(null);
        }

        if (Integer.valueOf(bi.ccm07d.getText().toString()) < 0 || Integer.valueOf(bi.ccm07d.getText().toString()) > 7) {
            Toast.makeText(this, "ERROR(Invalid): " + getString(R.string.ccmrec), Toast.LENGTH_SHORT).show();
            bi.ccm07d.setError("Range is 0 - 7 days");
            Log.i(TAG, "bi.ccm07d: This data is Required!");
            return false;
        } else {
            bi.ccm07d.setError(null);
        }

        if (Integer.valueOf(bi.ccm07d.getText().toString()) > 0) {
            if (bi.ccm07s.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.ccmsource), Toast.LENGTH_SHORT).show();
                bi.ccm07s10.setError("This data is Required!");
                Log.i(TAG, "bi.ccm07s: This data is Required!");
                return false;
            } else {
                bi.ccm07s10.setError(null);
            }

        }

        //======================= Q 8 ===============
        if (bi.ccm08d.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.ccmrec), Toast.LENGTH_SHORT).show();
            bi.ccm08d.setError("This data is Required!");
            Log.i(TAG, "bi.ccm08d: This data is Required!");
            return false;
        } else {
            bi.ccm08d.setError(null);
        }

        if (Integer.valueOf(bi.ccm08d.getText().toString()) < 0 || Integer.valueOf(bi.ccm08d.getText().toString()) > 7) {
            Toast.makeText(this, "ERROR(Invalid): " + getString(R.string.ccmrec), Toast.LENGTH_SHORT).show();
            bi.ccm08d.setError("Range is 0 - 7 days");
            Log.i(TAG, "bi.ccm08d: This data is Required!");
            return false;
        } else {
            bi.ccm08d.setError(null);
        }

        if (Integer.valueOf(bi.ccm08d.getText().toString()) > 0) {
            if (bi.ccm08s.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.ccmsource), Toast.LENGTH_SHORT).show();
                bi.ccm08s10.setError("This data is Required!");
                Log.i(TAG, "bi.ccm08s: This data is Required!");
                return false;
            } else {
                bi.ccm08s10.setError(null);
            }

        }

        //======================= Q 9 ===============
        if (bi.ccm09d.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.ccmrec), Toast.LENGTH_SHORT).show();
            bi.ccm09d.setError("This data is Required!");
            Log.i(TAG, "ccm09d: This data is Required!");
            return false;
        } else {
            bi.ccm09d.setError(null);
        }

        if (Integer.valueOf(bi.ccm09d.getText().toString()) < 0 || Integer.valueOf(bi.ccm09d.getText().toString()) > 7) {
            Toast.makeText(this, "ERROR(Invalid): " + getString(R.string.ccmrec), Toast.LENGTH_SHORT).show();
            bi.ccm09d.setError("Range is 0 - 7 days");
            Log.i(TAG, "ccm09d: This data is Required!");
            return false;
        } else {
            bi.ccm09d.setError(null);
        }

        if (Integer.valueOf(bi.ccm09d.getText().toString()) > 0) {
            if (bi.ccm09s.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.ccmsource), Toast.LENGTH_SHORT).show();
                bi.ccm09s10.setError("This data is Required!");
                Log.i(TAG, "ccm09s: This data is Required!");
                return false;
            } else {
                bi.ccm09s10.setError(null);
            }

        }

        return true;

    }

    private boolean UpdateDB() {
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSM();

        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

}
