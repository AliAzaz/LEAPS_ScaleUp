package com.example.hassannaqvi.wfppishincr.ui.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.hassannaqvi.wfppishincr.R;
import com.example.hassannaqvi.wfppishincr.core.DatabaseHelper;
import com.example.hassannaqvi.wfppishincr.core.MainApp;
import com.example.hassannaqvi.wfppishincr.databinding.ActivitySectionJBinding;
import com.example.hassannaqvi.wfppishincr.validation.ClearClass;
import com.example.hassannaqvi.wfppishincr.validation.validatorClass;

import org.json.JSONException;
import org.json.JSONObject;

public class SectionJActivity extends AppCompatActivity {


    ActivitySectionJBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_j);
        bi.setCallback(this);
        this.setTitle("Section J");


        //=========================skip patterns=======================================

        bi.ccj03.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i != R.id.ccj03a) {
                    bi.fldgrpccj04.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrpccj04, false);
                    bi.fldgrpccj05.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrpccj05, false);
                    bi.fldgrpccj06.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrpccj06, false);
                    bi.fldgrpccj07.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrpccj07, false);
                    bi.fldgrpccj08.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrpccj08, false);
                    bi.fldgrpccj09.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrpccj09, false);
                    bi.fldgrpccj10.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrpccj10, false);


                } else {
                    bi.fldgrpccj04.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj04, true);
                    bi.fldgrpccj05.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj05, true);
                    bi.fldgrpccj06.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj06, true);
                    bi.fldgrpccj07.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj07, true);
                    bi.fldgrpccj08.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj08, true);
                    bi.fldgrpccj09.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj09, true);
                    bi.fldgrpccj10.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj10, true);
                }

            }
        });


        bi.ccj09.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i != R.id.ccj09a) {
                    bi.fldgrpccj10.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrpccj10, false);
                } else {
                    bi.fldgrpccj10.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj10, true);
                }

            }
        });

        bi.ccj11.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != R.id.ccj11a) {
                    bi.fldgrpccj12.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrpccj12, false);
                    bi.fldgrpccj13.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrpccj13, false);

                } else {
                    bi.fldgrpccj12.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj12, true);
                    bi.fldgrpccj13.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj13, true);
                }
            }
        });

        bi.ccj1597.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {

                    bi.ccj15Layout.setVisibility(View.GONE);
                    bi.ccj15d.setText(null);
                    //bi.ccj1598.setChecked(false);

                } else {
                    bi.ccj15Layout.setVisibility(View.VISIBLE);
                }
            }
        });

        bi.ccj1598.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {

                    bi.ccj15Layout.setVisibility(View.GONE);
                    bi.ccj15d.setText(null);
                    //bi.ccj1597.setChecked(false);

                } else {
                    bi.ccj15Layout.setVisibility(View.VISIBLE);
                }
            }
        });

        bi.ccj14.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i != R.id.ccj14a) {
                    bi.fldgrpccj15.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrpccj15, false);
                } else {
                    bi.fldgrpccj15.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj15, true);
                }
            }
        });

        bi.ccj1797.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.ccj17a.clearCheck();
                    bi.ccj17b.clearCheck();
                    bi.ccj17c.clearCheck();
                    bi.ccj17d.clearCheck();
                    bi.ccj17e.clearCheck();
                    bi.ccj17f.clearCheck();
                    bi.ccj17g.clearCheck();
                    bi.ccj17h.clearCheck();
                    bi.ccj17i.clearCheck();
                    bi.ccj17j.clearCheck();
                    bi.ccj17k.clearCheck();
                    bi.ccj17l.clearCheck();
                    bi.ccj17m.clearCheck();
                    bi.ccj17n.clearCheck();
                    bi.ccj1796.clearCheck();
                    bi.ccj1796x.setText(null);
                    bi.fldgrpccj18.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrpccj18, false);
                    bi.fldgrpccj19.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrpccj19, false);
                    bi.fldgrpccj20.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrpccj20, false);
                    bi.fldgrpccj21.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrpccj21, false);
                    bi.fldgrpccj22.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrpccj22, false);
                    bi.fldgrpccj23.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrpccj23, false);
                    bi.fldgrpccj24.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrpccj24, false);
                    bi.fldgrpccj25.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrpccj25, false);
                    bi.fldgrpccj26.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrpccj26, false);
                    bi.fldgrpccj27.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrpccj27, false);
                    bi.fldgrpccj28.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrpccj28, false);

                } else {
                    bi.fldgrpccj18.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj18, true);
                    bi.fldgrpccj19.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj19, true);
                    bi.fldgrpccj20.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj20, true);
                    bi.fldgrpccj21.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj21, true);
                    bi.fldgrpccj22.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj22, true);
                    bi.fldgrpccj23.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj23, true);
                    bi.fldgrpccj24.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj24, true);
                    bi.fldgrpccj25.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj25, true);
                    bi.fldgrpccj26.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj26, true);
                    bi.fldgrpccj27.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj27, true);
                    bi.fldgrpccj28.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj28, true);
                }

            }
        });

        bi.ccj17a.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.ccj17a01 || i == R.id.ccj17a02) {

                    bi.ccj1797.setChecked(false);
                    bi.fldgrpccj18.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj18, true);
                    bi.fldgrpccj19.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj19, true);
                    bi.fldgrpccj20.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj20, true);
                    bi.fldgrpccj21.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj21, true);
                    bi.fldgrpccj22.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj22, true);
                    bi.fldgrpccj23.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj23, true);
                    bi.fldgrpccj24.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj24, true);
                    bi.fldgrpccj25.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj25, true);
                    bi.fldgrpccj26.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj26, true);
                    bi.fldgrpccj27.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj27, true);
                    bi.fldgrpccj28.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj28, true);

                } else {
                    bi.ccj1797.setChecked(true);
                }
            }
        });
        bi.ccj17b.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.ccj17b01 || i == R.id.ccj17b02) {

                    bi.ccj1797.setChecked(false);
                    bi.fldgrpccj18.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj18, true);
                    bi.fldgrpccj19.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj19, true);
                    bi.fldgrpccj20.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj20, true);
                    bi.fldgrpccj21.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj21, true);
                    bi.fldgrpccj22.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj22, true);
                    bi.fldgrpccj23.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj23, true);
                    bi.fldgrpccj24.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj24, true);
                    bi.fldgrpccj25.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj25, true);
                    bi.fldgrpccj26.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj26, true);
                    bi.fldgrpccj27.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj27, true);
                    bi.fldgrpccj28.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj28, true);

                } else {
                    bi.ccj1797.setChecked(true);
                }
            }
        });
        bi.ccj17c.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.ccj17c01 || i == R.id.ccj17c02) {

                    bi.ccj1797.setChecked(false);
                    bi.fldgrpccj18.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj18, true);
                    bi.fldgrpccj19.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj19, true);
                    bi.fldgrpccj20.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj20, true);
                    bi.fldgrpccj21.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj21, true);
                    bi.fldgrpccj22.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj22, true);
                    bi.fldgrpccj23.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj23, true);
                    bi.fldgrpccj24.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj24, true);
                    bi.fldgrpccj25.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj25, true);
                    bi.fldgrpccj26.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj26, true);
                    bi.fldgrpccj27.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj27, true);
                    bi.fldgrpccj28.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj28, true);

                } else {
                    bi.ccj1797.setChecked(true);
                }
            }
        });
        bi.ccj17d.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.ccj17d01 || i == R.id.ccj17d02) {

                    bi.ccj1797.setChecked(false);
                    bi.fldgrpccj18.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj18, true);
                    bi.fldgrpccj19.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj19, true);
                    bi.fldgrpccj20.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj20, true);
                    bi.fldgrpccj21.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj21, true);
                    bi.fldgrpccj22.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj22, true);
                    bi.fldgrpccj23.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj23, true);
                    bi.fldgrpccj24.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj24, true);
                    bi.fldgrpccj25.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj25, true);
                    bi.fldgrpccj26.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj26, true);
                    bi.fldgrpccj27.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj27, true);
                    bi.fldgrpccj28.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj28, true);

                } else {
                    bi.ccj1797.setChecked(true);
                }
            }
        });
        bi.ccj17e.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.ccj17e01 || i == R.id.ccj17e02) {

                    bi.ccj1797.setChecked(false);
                    bi.fldgrpccj18.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj18, true);
                    bi.fldgrpccj19.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj19, true);
                    bi.fldgrpccj20.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj20, true);
                    bi.fldgrpccj21.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj21, true);
                    bi.fldgrpccj22.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj22, true);
                    bi.fldgrpccj23.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj23, true);
                    bi.fldgrpccj24.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj24, true);
                    bi.fldgrpccj25.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj25, true);
                    bi.fldgrpccj26.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj26, true);
                    bi.fldgrpccj27.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj27, true);
                    bi.fldgrpccj28.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj28, true);

                } else {
                    bi.ccj1797.setChecked(true);
                }
            }
        });
        bi.ccj17e.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.ccj17e01 || i == R.id.ccj17e02) {

                    bi.ccj1797.setChecked(false);
                    bi.fldgrpccj18.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj18, true);
                    bi.fldgrpccj19.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj19, true);
                    bi.fldgrpccj20.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj20, true);
                    bi.fldgrpccj21.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj21, true);
                    bi.fldgrpccj22.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj22, true);
                    bi.fldgrpccj23.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj23, true);
                    bi.fldgrpccj24.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj24, true);
                    bi.fldgrpccj25.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj25, true);
                    bi.fldgrpccj26.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj26, true);
                    bi.fldgrpccj27.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj27, true);
                    bi.fldgrpccj28.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj28, true);

                } else {
                    bi.ccj1797.setChecked(true);
                }
            }
        });
        bi.ccj17f.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.ccj17f01 || i == R.id.ccj17f02) {

                    bi.ccj1797.setChecked(false);
                    bi.fldgrpccj18.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj18, true);
                    bi.fldgrpccj19.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj19, true);
                    bi.fldgrpccj20.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj20, true);
                    bi.fldgrpccj21.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj21, true);
                    bi.fldgrpccj22.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj22, true);
                    bi.fldgrpccj23.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj23, true);
                    bi.fldgrpccj24.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj24, true);
                    bi.fldgrpccj25.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj25, true);
                    bi.fldgrpccj26.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj26, true);
                    bi.fldgrpccj27.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj27, true);
                    bi.fldgrpccj28.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj28, true);

                } else {
                    bi.ccj1797.setChecked(true);
                }
            }
        });
        bi.ccj17g.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.ccj17g01 || i == R.id.ccj17g02) {

                    bi.ccj1797.setChecked(false);
                    bi.fldgrpccj18.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj18, true);
                    bi.fldgrpccj19.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj19, true);
                    bi.fldgrpccj20.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj20, true);
                    bi.fldgrpccj21.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj21, true);
                    bi.fldgrpccj22.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj22, true);
                    bi.fldgrpccj23.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj23, true);
                    bi.fldgrpccj24.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj24, true);
                    bi.fldgrpccj25.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj25, true);
                    bi.fldgrpccj26.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj26, true);
                    bi.fldgrpccj27.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj27, true);
                    bi.fldgrpccj28.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj28, true);

                } else {
                    bi.ccj1797.setChecked(true);
                }
            }
        });
        bi.ccj17h.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.ccj17h01 || i == R.id.ccj17h02) {

                    bi.ccj1797.setChecked(false);
                    bi.fldgrpccj18.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj18, true);
                    bi.fldgrpccj19.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj19, true);
                    bi.fldgrpccj20.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj20, true);
                    bi.fldgrpccj21.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj21, true);
                    bi.fldgrpccj22.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj22, true);
                    bi.fldgrpccj23.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj23, true);
                    bi.fldgrpccj24.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj24, true);
                    bi.fldgrpccj25.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj25, true);
                    bi.fldgrpccj26.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj26, true);
                    bi.fldgrpccj27.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj27, true);
                    bi.fldgrpccj28.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj28, true);

                } else {
                    bi.ccj1797.setChecked(true);
                }
            }
        });
        bi.ccj17i.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.ccj17i01 || i == R.id.ccj17i02) {

                    bi.ccj1797.setChecked(false);
                    bi.fldgrpccj18.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj18, true);
                    bi.fldgrpccj19.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj19, true);
                    bi.fldgrpccj20.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj20, true);
                    bi.fldgrpccj21.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj21, true);
                    bi.fldgrpccj22.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj22, true);
                    bi.fldgrpccj23.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj23, true);
                    bi.fldgrpccj24.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj24, true);
                    bi.fldgrpccj25.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj25, true);
                    bi.fldgrpccj26.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj26, true);
                    bi.fldgrpccj27.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj27, true);
                    bi.fldgrpccj28.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj28, true);

                } else {
                    bi.ccj1797.setChecked(true);
                }
            }
        });
        bi.ccj17j.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.ccj17j01 || i == R.id.ccj17j02) {

                    bi.ccj1797.setChecked(false);
                    bi.fldgrpccj18.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj18, true);
                    bi.fldgrpccj19.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj19, true);
                    bi.fldgrpccj20.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj20, true);
                    bi.fldgrpccj21.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj21, true);
                    bi.fldgrpccj22.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj22, true);
                    bi.fldgrpccj23.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj23, true);
                    bi.fldgrpccj24.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj24, true);
                    bi.fldgrpccj25.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj25, true);
                    bi.fldgrpccj26.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj26, true);
                    bi.fldgrpccj27.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj27, true);
                    bi.fldgrpccj28.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj28, true);

                } else {
                    bi.ccj1797.setChecked(true);
                }
            }
        });
        bi.ccj17k.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.ccj17k01 || i == R.id.ccj17k02) {

                    bi.ccj1797.setChecked(false);
                    bi.fldgrpccj18.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj18, true);
                    bi.fldgrpccj19.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj19, true);
                    bi.fldgrpccj20.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj20, true);
                    bi.fldgrpccj21.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj21, true);
                    bi.fldgrpccj22.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj22, true);
                    bi.fldgrpccj23.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj23, true);
                    bi.fldgrpccj24.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj24, true);
                    bi.fldgrpccj25.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj25, true);
                    bi.fldgrpccj26.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj26, true);
                    bi.fldgrpccj27.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj27, true);
                    bi.fldgrpccj28.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj28, true);

                } else {
                    bi.ccj1797.setChecked(true);
                }
            }
        });
        bi.ccj17l.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.ccj17l01 || i == R.id.ccj17l02) {

                    bi.ccj1797.setChecked(false);
                    bi.fldgrpccj18.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj18, true);
                    bi.fldgrpccj19.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj19, true);
                    bi.fldgrpccj20.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj20, true);
                    bi.fldgrpccj21.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj21, true);
                    bi.fldgrpccj22.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj22, true);
                    bi.fldgrpccj23.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj23, true);
                    bi.fldgrpccj24.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj24, true);
                    bi.fldgrpccj25.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj25, true);
                    bi.fldgrpccj26.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj26, true);
                    bi.fldgrpccj27.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj27, true);
                    bi.fldgrpccj28.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj28, true);

                } else {
                    bi.ccj1797.setChecked(true);
                }
            }
        });
        bi.ccj17m.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.ccj17m01 || i == R.id.ccj17m02) {

                    bi.ccj1797.setChecked(false);
                    bi.fldgrpccj18.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj18, true);
                    bi.fldgrpccj19.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj19, true);
                    bi.fldgrpccj20.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj20, true);
                    bi.fldgrpccj21.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj21, true);
                    bi.fldgrpccj22.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj22, true);
                    bi.fldgrpccj23.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj23, true);
                    bi.fldgrpccj24.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj24, true);
                    bi.fldgrpccj25.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj25, true);
                    bi.fldgrpccj26.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj26, true);
                    bi.fldgrpccj27.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj27, true);
                    bi.fldgrpccj28.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj28, true);

                } else {
                    bi.ccj1797.setChecked(true);
                }
            }
        });
        bi.ccj17n.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.ccj17n01 || i == R.id.ccj17n02) {

                    bi.ccj1797.setChecked(false);
                    bi.fldgrpccj18.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj18, true);
                    bi.fldgrpccj19.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj19, true);
                    bi.fldgrpccj20.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj20, true);
                    bi.fldgrpccj21.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj21, true);
                    bi.fldgrpccj22.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj22, true);
                    bi.fldgrpccj23.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj23, true);
                    bi.fldgrpccj24.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj24, true);
                    bi.fldgrpccj25.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj25, true);
                    bi.fldgrpccj26.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj26, true);
                    bi.fldgrpccj27.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj27, true);
                    bi.fldgrpccj28.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj28, true);

                } else {
                    bi.ccj1797.setChecked(true);
                }
            }
        });
        bi.ccj1796.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.ccj179601 || i == R.id.ccj179602) {

                    bi.ccj1797.setChecked(false);
                    bi.fldgrpccj18.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj18, true);
                    bi.fldgrpccj19.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj19, true);
                    bi.fldgrpccj20.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj20, true);
                    bi.fldgrpccj21.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj21, true);
                    bi.fldgrpccj22.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj22, true);
                    bi.fldgrpccj23.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj23, true);
                    bi.fldgrpccj24.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj24, true);
                    bi.fldgrpccj25.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj25, true);
                    bi.fldgrpccj26.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj26, true);
                    bi.fldgrpccj27.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj27, true);
                    bi.fldgrpccj28.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj28, true);

                } else {
                    bi.ccj1797.setChecked(true);
                }
            }
        });
        bi.ccj18.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i != R.id.ccj18a) {
                    bi.fldgrpccj19.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrpccj19, false);
                    bi.fldgrpccj20.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrpccj20, false);
                    bi.fldgrpccj21.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrpccj21, false);
                    bi.fldgrpccj22.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrpccj22, false);
                    bi.fldgrpccj23.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrpccj23, false);
                    bi.fldgrpccj24.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrpccj24, false);
                    bi.fldgrpccj25.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrpccj25, false);
                    bi.fldgrpccj26.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrpccj26, false);
                    bi.fldgrpccj27.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrpccj27, false);
                    bi.fldgrpccj28.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrpccj28, false);

                } else {
                    bi.fldgrpccj19.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj19, true);
                    bi.fldgrpccj20.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj20, true);
                    bi.fldgrpccj21.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj21, true);
                    bi.fldgrpccj22.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj22, true);
                    bi.fldgrpccj23.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj23, true);
                    bi.fldgrpccj24.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj24, true);
                    bi.fldgrpccj25.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj25, true);
                    bi.fldgrpccj26.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj26, true);
                    bi.fldgrpccj27.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj27, true);
                    bi.fldgrpccj28.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj28, true);
                }

            }
        });

        bi.ccj2298.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    bi.ccj22d.setText(null);
                    bi.ccj22w.setText(null);
                    bi.ccj22h.setText(null);
                    bi.fldgrpccj23.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrpccj23, false);
                } else {
                    bi.fldgrpccj23.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj23, true);
                }
            }
        });

        bi.ccj24.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.ccj24b) {
                    bi.fldgrpccj25.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrpccj25, false);
                } else {
                    bi.fldgrpccj25.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj25, true);
                }
            }
        });

        bi.ccj2697.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {

                    bi.ccj26d.setText(null);
                    bi.ccj26m.setText(null);
                    bi.fldgrpccj27.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrpccj27, false);
                    bi.fldgrpccj28.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrpccj28, false);

                } else {

                    bi.fldgrpccj27.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj27, true);
                    bi.fldgrpccj28.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpccj28, true);
                }
            }
        });


    }

    public void BtnContinue() {

        if (formValidate()) {

            try {
                saveData();
                if (updateDb()) {
                    Intent secNext = new Intent(this, SectionKActivity.class);
                    secNext.putExtra("check", false);
                    startActivity(secNext);
                    finish();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }


    }

    public boolean updateDb() {
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSJ();

        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public void saveData() throws JSONException {

        JSONObject sJ = new JSONObject();

        sJ.put("ccj01", bi.ccj01a.getText().toString());
        sJ.put("ccj02", bi.ccj02a.getText().toString());
        sJ.put("ccj03", bi.ccj03a.isChecked() ? "1" : bi.ccj03b.isChecked() ? "2" : bi.ccj0398.isChecked() ? "98" : "0");
        sJ.put("ccj04a", bi.ccj04a.isChecked() ? "1" : "0");
        sJ.put("ccj04b", bi.ccj04b.isChecked() ? "2" : "0");
        sJ.put("ccj04c", bi.ccj04c.isChecked() ? "3" : "0");
        sJ.put("ccj04d", bi.ccj04d.isChecked() ? "4" : "0");
        sJ.put("ccj04e", bi.ccj04e.isChecked() ? "5" : "0");
        sJ.put("ccj04f", bi.ccj04f.isChecked() ? "6" : "0");
        sJ.put("ccj04g", bi.ccj04g.isChecked() ? "7" : "0");
        sJ.put("ccj04h", bi.ccj04h.isChecked() ? "8" : "0");
        sJ.put("ccj0496", bi.ccj0496.isChecked() ? "96" : "0");
        sJ.put("ccj0496x", bi.ccj0496x.getText().toString());

        sJ.put("ccj05a", bi.ccj05a.isChecked() ? "1" : "0");
        sJ.put("ccj05b", bi.ccj05b.isChecked() ? "2" : "0");
        sJ.put("ccj05c", bi.ccj05c.isChecked() ? "3" : "0");
        sJ.put("ccj05d", bi.ccj05d.isChecked() ? "4" : "0");
        sJ.put("ccj0596", bi.ccj0596.isChecked() ? "96" : "0");
        sJ.put("ccj0596x", bi.ccj0596x.getText().toString());

        sJ.put("ccj06m", bi.ccj06m.getText().toString());
        sJ.put("ccj0698", bi.ccj0698.isChecked() ? "98" : "0");

        sJ.put("ccj07t", bi.ccj07t.getText().toString());
        sJ.put("ccj0798", bi.ccj0798.isChecked() ? "98" : "0");

        sJ.put("ccj08a", bi.ccj08a.isChecked() ? "1" : "0");
        sJ.put("ccj08b", bi.ccj08b.isChecked() ? "2" : "0");
        sJ.put("ccj08c", bi.ccj08c.isChecked() ? "3" : "0");
        sJ.put("ccj08d", bi.ccj08d.isChecked() ? "4" : "0");
        sJ.put("ccj08e", bi.ccj08e.isChecked() ? "5" : "0");
        sJ.put("ccj0896", bi.ccj0896.isChecked() ? "96" : "0");
        sJ.put("ccj0896x", bi.ccj0896x.getText().toString());

        sJ.put("ccj09", bi.ccj09a.isChecked() ? "1" : bi.ccj09b.isChecked() ? "2" : bi.ccj0998.isChecked() ? "98" : "0");

        sJ.put("ccj10t", bi.ccj10t.getText().toString());
        sJ.put("ccj1098", bi.ccj1098.isChecked() ? "98" : "0");

        sJ.put("ccj11", bi.ccj11a.isChecked() ? "1" : bi.ccj11b.isChecked() ? "2" : bi.ccj1198.isChecked() ? "98" : "0");
        sJ.put("ccj12t", bi.ccj12t.getText().toString());
        sJ.put("ccj1298", bi.ccj1298.isChecked() ? "98" : "0");
        sJ.put("ccj13", bi.ccj13.getText().toString());

        sJ.put("ccj14", bi.ccj14a.isChecked() ? "1" : bi.ccj14b.isChecked() ? "2" : bi.ccj1498.isChecked() ? "98" : "0");
        sJ.put("ccj15", bi.ccj1597.isChecked() ? "97" : bi.ccj1598.isChecked() ? "98" : "0");
        sJ.put("ccj15d", bi.ccj15d.getText().toString());

        sJ.put("ccj16", bi.ccj16a.isChecked() ? "1" : bi.ccj16b.isChecked() ? "2" : bi.ccj1698.isChecked() ? "98" : "0");

        sJ.put("ccj17a", bi.ccj17a01.isChecked() ? "1" : bi.ccj17a02.isChecked() ? "2" : "0");
        sJ.put("ccj17b", bi.ccj17b01.isChecked() ? "1" : bi.ccj17b02.isChecked() ? "2" : "0");
        sJ.put("ccj17c", bi.ccj17c01.isChecked() ? "1" : bi.ccj17c02.isChecked() ? "2" : "0");
        sJ.put("ccj17d", bi.ccj17d01.isChecked() ? "1" : bi.ccj17d02.isChecked() ? "2" : "0");
        sJ.put("ccj17e", bi.ccj17e01.isChecked() ? "1" : bi.ccj17e02.isChecked() ? "2" : "0");
        sJ.put("ccj17f", bi.ccj17f01.isChecked() ? "1" : bi.ccj17f02.isChecked() ? "2" : "0");
        sJ.put("ccj17g", bi.ccj17g01.isChecked() ? "1" : bi.ccj17g02.isChecked() ? "2" : "0");
        sJ.put("ccj17h", bi.ccj17h01.isChecked() ? "1" : bi.ccj17h02.isChecked() ? "2" : "0");
        sJ.put("ccj17i", bi.ccj17i01.isChecked() ? "1" : bi.ccj17i02.isChecked() ? "2" : "0");
        sJ.put("ccj17j", bi.ccj17j01.isChecked() ? "1" : bi.ccj17j02.isChecked() ? "2" : "0");
        sJ.put("ccj17k", bi.ccj17k01.isChecked() ? "1" : bi.ccj17k02.isChecked() ? "2" : "0");
        sJ.put("ccj17l", bi.ccj17l01.isChecked() ? "1" : bi.ccj17l02.isChecked() ? "2" : "0");
        sJ.put("ccj17m", bi.ccj17m01.isChecked() ? "1" : bi.ccj17m02.isChecked() ? "2" : "0");
        sJ.put("ccj17n", bi.ccj17n01.isChecked() ? "1" : bi.ccj17n02.isChecked() ? "2" : "0");
        sJ.put("ccj1796", bi.ccj179601.isChecked() ? "1" : bi.ccj179602.isChecked() ? "2" : "0");
        sJ.put("ccj1796x", bi.ccj1796x.getText().toString());
        sJ.put("ccj1797", bi.ccj1797.isChecked() ? "97" : "0");

        sJ.put("ccj18", bi.ccj18a.isChecked() ? "1" : bi.ccj18b.isChecked() ? "2" : bi.ccj1898.isChecked() ? "98" : "0");

        sJ.put("ccj19a", bi.ccj19a.isChecked() ? "1" : "0");
        sJ.put("ccj19b", bi.ccj19b.isChecked() ? "1" : "0");
        sJ.put("ccj19c", bi.ccj19c.isChecked() ? "1" : "0");
        sJ.put("ccj19d", bi.ccj19d.isChecked() ? "1" : "0");
        sJ.put("ccj19e", bi.ccj19e.isChecked() ? "1" : "0");
        sJ.put("ccj19f", bi.ccj19f.isChecked() ? "1" : "0");
        sJ.put("ccj19g", bi.ccj19g.isChecked() ? "1" : "0");
        sJ.put("ccj19h", bi.ccj19h.isChecked() ? "1" : "0");
        sJ.put("ccj1996", bi.ccj1996.isChecked() ? "96" : "0");
        sJ.put("ccj1996x", bi.ccj1996x.getText().toString());

        sJ.put("ccj20", bi.ccj20a.isChecked() ? "1" : bi.ccj20b.isChecked() ? "2" : bi.ccj20c.isChecked() ? "3" : bi.ccj2096.isChecked() ? "96" : "0");
        sJ.put("ccj2096", bi.ccj2096x.getText().toString());

        sJ.put("ccj21a", bi.ccj21a.isChecked() ? "1" : "0");
        sJ.put("ccj21b", bi.ccj21b.isChecked() ? "1" : "0");
        sJ.put("ccj21c", bi.ccj21c.isChecked() ? "1" : "0");
        sJ.put("ccj21d", bi.ccj21d.isChecked() ? "1" : "0");
        sJ.put("ccj21e", bi.ccj21e.isChecked() ? "1" : "0");
        sJ.put("ccj21f", bi.ccj21f.isChecked() ? "1" : "0");
        sJ.put("ccj21g", bi.ccj21g.isChecked() ? "1" : "0");
        sJ.put("ccj21h", bi.ccj21h.isChecked() ? "1" : "0");
        sJ.put("ccj2196", bi.ccj2196.isChecked() ? "96" : "0");
        sJ.put("ccj2196x", bi.ccj2196x.getText().toString());

        sJ.put("ccj22h", bi.ccj22h.getText().toString());
        sJ.put("ccj22d", bi.ccj22d.getText().toString());
        sJ.put("ccj22w", bi.ccj22w.getText().toString());
        sJ.put("ccj2297", bi.ccj2298.isChecked() ? "97" : "0");

        sJ.put("ccj23a", bi.ccj23a.isChecked() ? "1" : "0");
        sJ.put("ccj23b", bi.ccj23b.isChecked() ? "2" : "0");
        sJ.put("ccj23c", bi.ccj23c.isChecked() ? "3" : "0");
        sJ.put("ccj23d", bi.ccj23d.isChecked() ? "4" : "0");
        sJ.put("ccj23e", bi.ccj23e.isChecked() ? "5" : "0");
        sJ.put("ccj23f", bi.ccj23f.isChecked() ? "6" : "0");
        sJ.put("ccj23g", bi.ccj23g.isChecked() ? "7" : "0");
        sJ.put("ccj23h", bi.ccj23h.isChecked() ? "8" : "0");
        sJ.put("ccj2396", bi.ccj2396.isChecked() ? "96" : "0");
        sJ.put("ccj2396x", bi.ccj2396x.getText().toString());

        sJ.put("ccj24", bi.ccj24a.isChecked() ? "1" : bi.ccj24b.isChecked() ? "2" : "0");
        sJ.put("ccj25d", bi.ccj25d.getText().toString());
        sJ.put("ccj25ss", bi.ccj25ss.getText().toString());

        sJ.put("ccj26m", bi.ccj26m.getText().toString());
        sJ.put("ccj26d", bi.ccj26d.getText().toString());
        sJ.put("ccj2697", bi.ccj2697.isChecked() ? "97" : "0");
        sJ.put("ccj27", bi.ccj27a.isChecked() ? "1" : bi.ccj27b.isChecked() ? "2" : bi.ccj27c.isChecked() ? "3" : bi.ccj27d.isChecked() ? "4" : bi.ccj27e.isChecked() ? "5" : bi.ccj2796.isChecked() ? "96" : "0");

        sJ.put("ccj2796", bi.ccj2796.getText().toString());

        sJ.put("ccj28a", bi.ccj28a.isChecked() ? "1" : "0");
        sJ.put("ccj28b", bi.ccj28b.isChecked() ? "2" : "0");
        sJ.put("ccj28c", bi.ccj28c.isChecked() ? "3" : "0");
        sJ.put("ccj28d", bi.ccj28d.isChecked() ? "4" : "0");
        sJ.put("ccj28e", bi.ccj28e.isChecked() ? "5" : "0");
        sJ.put("ccj28f", bi.ccj28f.isChecked() ? "6" : "0");
        sJ.put("ccj28g", bi.ccj28g.isChecked() ? "7" : "0");
        sJ.put("ccj28h", bi.ccj28h.isChecked() ? "8" : "0");
        MainApp.fc.setsJ(String.valueOf(sJ));
        Toast.makeText(this, "Validation Successful", Toast.LENGTH_SHORT).show();
    }

    private boolean formValidate() {

        if (!validatorClass.EmptyTextBox(this, bi.ccj01a, getString(R.string.ccj01))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.ccj02a, getString(R.string.ccj02))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ccj03, bi.ccj03a, getString(R.string.ccj03))) {
            return false;
        }

        if (bi.ccj03a.isChecked()) {

            if (!validatorClass.EmptyCheckBox(this, bi.fldgrpccj04, bi.ccj04a, getString(R.string.ccj04))) {

                return false;
            }
            if (bi.ccj0496.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.ccj0496x, getString(R.string.ccj04))) {
                    return false;
                }
            }
            if (!validatorClass.EmptyCheckBox(this, bi.fldgrpccj05, bi.ccj05a, getString(R.string.ccj05))) {

                return false;
            }
            if (bi.ccj0596.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.ccj0596x, getString(R.string.ccj05))) {
                    return false;
                }
            }

            if (!bi.ccj0698.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.ccj06m, getString(R.string.ccj06))) {
                    return false;
                }
            }
            if (!bi.ccj0798.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.ccj07t, getString(R.string.ccj07))) {
                    return false;
                }
            }
            if (!validatorClass.EmptyCheckBox(this, bi.fldgrpccj08, bi.ccj08a, getString(R.string.ccj08))) {

                return false;
            }
            if (bi.ccj0896.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.ccj0896x, getString(R.string.ccj08))) {
                    return false;
                }
            }
            if (!validatorClass.EmptyRadioButton(this, bi.ccj09, bi.ccj09a, getString(R.string.ccj09))) {
                return false;
            }
            if (bi.ccj09a.isChecked()) {
                if (!bi.ccj1098.isChecked()) {
                    if (!validatorClass.EmptyTextBox(this, bi.ccj10t, getString(R.string.ccj10))) {
                        return false;
                    }
                }
            }
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ccj11, bi.ccj11a, getString(R.string.ccj11))) {
            return false;
        }
        if (bi.ccj11a.isChecked()) {
            if (!bi.ccj1298.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.ccj12t, getString(R.string.ccj12))) {
                    return false;
                }
            }
            if (!validatorClass.EmptyTextBox(this, bi.ccj13, getString(R.string.ccj13))) {
                return false;
            }
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ccj14, bi.ccj14a, getString(R.string.ccj14))) {
            return false;
        }
        if (bi.ccj14a.isChecked()) {

            if (!bi.ccj1597.isChecked() && !bi.ccj1598.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.ccj15d, getString(R.string.ccj15))) {
                    return false;
                }
            }
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ccj16, bi.ccj16a, getString(R.string.ccj16))) {
            return false;
        }

        if (!bi.ccj1797.isChecked()) {

            if (!validatorClass.EmptyRadioButton(this, bi.ccj17a, bi.ccj17a01, getString(R.string.ccj17a))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.ccj17b, bi.ccj17b01, getString(R.string.ccj17b))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.ccj17c, bi.ccj17c01, getString(R.string.ccj17c))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.ccj17d, bi.ccj17d01, getString(R.string.ccj17d))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.ccj17e, bi.ccj17e01, getString(R.string.ccj17e))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.ccj17f, bi.ccj17f01, getString(R.string.ccj17f))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.ccj17g, bi.ccj17g01, getString(R.string.ccj17g))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.ccj17h, bi.ccj17h01, getString(R.string.ccj17h))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.ccj17i, bi.ccj17i01, getString(R.string.ccj17i))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.ccj17j, bi.ccj17j01, getString(R.string.ccj17j))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.ccj17k, bi.ccj17k01, getString(R.string.ccj17k))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.ccj17l, bi.ccj17l01, getString(R.string.ccj17l))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.ccj17m, bi.ccj17m01, getString(R.string.ccj17m))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.ccj17n, bi.ccj17n01, getString(R.string.ccj17n))) {
                return false;
            }

            if (bi.ccj179601.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.ccj1796x, getString(R.string.ccj1796))) {
                    return false;
                }
            }

            if (!validatorClass.EmptyRadioButton(this, bi.ccj18, bi.ccj18a, getString(R.string.ccj18))) {
                return false;
            }

            if (bi.ccj18a.isChecked()) {
                if (!validatorClass.EmptyCheckBox(this, bi.fldgrpccj19, bi.ccj19a, getString(R.string.ccj19))) {

                    return false;
                }
                if (bi.ccj1996.isChecked()) {
                    if (!validatorClass.EmptyTextBox(this, bi.ccj1996x, getString(R.string.ccj19))) {
                        return false;
                    }
                }

                if (!validatorClass.EmptyRadioButton(this, bi.ccj20, bi.ccj20a, getString(R.string.ccj20))) {
                    return false;
                }
                if (bi.ccj2096.isChecked()) {
                    if (!validatorClass.EmptyTextBox(this, bi.ccj2096x, getString(R.string.ccj20))) {
                        return false;
                    }
                }

                if (!validatorClass.EmptyCheckBox(this, bi.fldgrpccj21, bi.ccj21a, getString(R.string.ccj21))) {

                    return false;
                }
                if (bi.ccj2196.isChecked()) {
                    if (!validatorClass.EmptyTextBox(this, bi.ccj2196x, getString(R.string.ccj21))) {
                        return false;
                    }
                }

                if (!bi.ccj2298.isChecked()) {
                    if (!validatorClass.EmptyTextBox(this, bi.ccj22h, getString(R.string.ccj22))) {
                        return false;
                    }
                    if (!validatorClass.EmptyTextBox(this, bi.ccj22d, getString(R.string.ccj22))) {
                        return false;
                    }
                    if (!validatorClass.EmptyTextBox(this, bi.ccj22w, getString(R.string.ccj22))) {
                        return false;
                    }
                    if (!validatorClass.EmptyCheckBox(this, bi.fldgrpccj23, bi.ccj23a, getString(R.string.ccj23))) {

                        return false;
                    }
                    if (bi.ccj2396.isChecked()) {
                        if (!validatorClass.EmptyTextBox(this, bi.ccj2396x, getString(R.string.ccj23))) {
                            return false;
                        }
                    }
                }
                if (!validatorClass.EmptyRadioButton(this, bi.ccj24, bi.ccj24a, getString(R.string.ccj24))) {
                    return false;
                }

                if (bi.ccj24a.isChecked()) {

                    if (!validatorClass.EmptyTextBox(this, bi.ccj25d, getString(R.string.ccj25))) {
                        return false;
                    }
                    if (!validatorClass.EmptyTextBox(this, bi.ccj25ss, getString(R.string.ccj25))) {
                        return false;
                    }
                }

                if (!bi.ccj2697.isChecked()) {

                    if (!validatorClass.EmptyTextBox(this, bi.ccj26m, getString(R.string.ccj26))) {
                        return false;
                    }
                    if (!validatorClass.EmptyTextBox(this, bi.ccj26d, getString(R.string.ccj26))) {
                        return false;
                    }
                    if (!validatorClass.EmptyRadioButton(this, bi.ccj27, bi.ccj27a, getString(R.string.ccj27))) {
                        return false;
                    }
                    return validatorClass.EmptyCheckBox(this, bi.fldgrpccj28, bi.ccj28a, getString(R.string.ccj28));

                }


            }


        }


        return true;
    }

    public void BtnEnd() {


        MainApp.endActivity(this, this);
    }
}
