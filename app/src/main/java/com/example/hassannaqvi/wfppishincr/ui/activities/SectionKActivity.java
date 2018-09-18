package com.example.hassannaqvi.wfppishincr.ui.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.hassannaqvi.wfppishincr.R;
import com.example.hassannaqvi.wfppishincr.core.DatabaseHelper;
import com.example.hassannaqvi.wfppishincr.core.MainApp;
import com.example.hassannaqvi.wfppishincr.databinding.ActivitySectionKBinding;
import com.example.hassannaqvi.wfppishincr.validation.validatorClass;

import org.json.JSONException;
import org.json.JSONObject;

public class SectionKActivity extends AppCompatActivity {
    ActivitySectionKBinding bi;
    private static final String TAG = SectionKActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_k);
        bi.setCallback(this);
        this.setTitle("Section K");

        bi.cck05i.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.fldGrpcck06.setVisibility(View.GONE);
                    bi.cck06.clearCheck();
                    bi.cck07.setText(null);
                    bi.cck0798.setChecked(false);
                } else {
                    bi.fldGrpcck06.setVisibility(View.VISIBLE);
                }
            }
        });


        // ====================== Q9 Skip Pattern =========================

        bi.cck09j.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.cckGrp09.setVisibility(View.GONE);
                    bi.cck10.clearCheck();
                    bi.cck1096x.setText(null);
                } else {
                    bi.cckGrp09.setVisibility(View.VISIBLE);
                }
            }
        });

        // ====================== Q17 Skip Pattern =========================
        bi.cck17b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.cckGrp17.setVisibility(View.GONE);
                    bi.cck1898.setChecked(false);
                    bi.cck18a.setText(null);
                    bi.cck18b.setText(null);
                    bi.cck18c.setText(null);
                } else {
                    bi.cckGrp17.setVisibility(View.VISIBLE);
                }
            }
        });

        // ====================== Q19 Skip Pattern =========================

        bi.cck19b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.cckGrp19.setVisibility(View.GONE);
                    bi.cck20a.setText(null);
                    bi.cck20b.setText(null);
                    bi.cck20c.setText(null);
                    bi.cck20d.setText(null);
                    bi.cck20e.setText(null);
                    bi.cck20f.setText(null);
                    bi.cck20g.setText(null);

                } else {
                    bi.cckGrp19.setVisibility(View.VISIBLE);
                }
            }
        });

        // =================== Q1 Others ====================

        bi.cck0196.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.cck0196x.setVisibility(View.VISIBLE);
                } else {
                    bi.cck0196x.setVisibility(View.GONE);
                    bi.cck0196x.setText(null);
                }
            }
        });

        // =================== Q2 Others ====================

        bi.cck0296.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.cck0296x.setVisibility(View.VISIBLE);
                } else {
                    bi.cck0296x.setVisibility(View.GONE);
                    bi.cck0296x.setText(null);
                }
            }
        });

        // =================== Q4 Others ====================

        bi.cck0496.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.cck0496x.setVisibility(View.VISIBLE);
                } else {
                    bi.cck0496x.setVisibility(View.GONE);
                    bi.cck0496x.setText(null);
                }
            }
        });

        // =================== Q5 Others ====================

        bi.cck0596.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.cck0596x.setVisibility(View.VISIBLE);
                } else {
                    bi.cck0596x.setVisibility(View.GONE);
                    bi.cck0596x.setText(null);
                }
            }
        });

        // =================== Q9 Others ====================

        bi.cck0996.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.cck0996x.setVisibility(View.VISIBLE);
                } else {
                    bi.cck0996x.setVisibility(View.GONE);
                    bi.cck0996x.setText(null);
                }
            }
        });

        // =================== Q10 Others ====================

        bi.cck1096.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.cck1096x.setVisibility(View.VISIBLE);
                } else {
                    bi.cck1096x.setVisibility(View.GONE);
                    bi.cck1096x.setText(null);
                }
            }
        });

        // =================== Q12 Others ====================

        bi.cck1296.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.cck1296x.setVisibility(View.VISIBLE);
                } else {
                    bi.cck1296x.setVisibility(View.GONE);
                    bi.cck1296x.setText(null);
                }
            }
        });

        // =================== Q13 Others ====================

        bi.cck1396.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.cck1396x.setVisibility(View.VISIBLE);
                } else {
                    bi.cck1396x.setVisibility(View.GONE);
                    bi.cck1396x.setText(null);
                }
            }
        });

        // =================== Q14 Others ====================

        bi.cck1496.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.cck1496x.setVisibility(View.VISIBLE);
                } else {
                    bi.cck1496x.setVisibility(View.GONE);
                    bi.cck1496x.setText(null);
                }
            }
        });

        //================= Q4 Skip pattern ===============
        bi.cck03.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (bi.cck03a.isChecked()) {
                    bi.fldGrpcck04.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpcck04.setVisibility(View.GONE);
                    bi.cck04.clearCheck();
                    bi.cck0496x.setText(null);
                }
            }
        });

        //================= Q6 Skip pattern ===============
        bi.cck06.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (bi.cck06a.isChecked()) {
                    bi.fldGrpcck07.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpcck07.setVisibility(View.GONE);
                    bi.cck07.setText(null);
                    bi.cck0798.setChecked(false);
                }
            }
        });
        bi.cck0798.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.cck07.setVisibility(View.GONE);
                    bi.cck07.setText(null);
                } else {
                    bi.cck07.setVisibility(View.VISIBLE);
                }
            }
        });

        bi.cck1898.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.cck18a.setVisibility(View.GONE);
                    bi.cck18a.setText(null);
                    bi.cck18b.setVisibility(View.GONE);
                    bi.cck18b.setText(null);
                    bi.cck18c.setVisibility(View.GONE);
                    bi.cck18c.setText(null);
                } else {
                    bi.cck18a.setVisibility(View.VISIBLE);
                    bi.cck18b.setVisibility(View.VISIBLE);
                    bi.cck18c.setVisibility(View.VISIBLE);
                }
            }
        });


    }

    public void BtnContinue() {
        Toast.makeText(this, "Processing this section", Toast.LENGTH_SHORT).show();
        if (validateForm()) {
            try {
                saveDrafts();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (updateDb()) {
                Toast.makeText(this, "starting next section", Toast.LENGTH_SHORT).show();

                finish();
                Intent secL = new Intent(this, SectionLActivity.class);
                startActivity(secL);

            } else {
                Toast.makeText(this, "Failed to update Database", Toast.LENGTH_SHORT).show();
            }
        }

    }

   public void BtnEnd() {
        MainApp.endActivity(this, this);
    }

    private boolean updateDb() {
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSK();

        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void saveDrafts() throws JSONException {
        Toast.makeText(this, "saving Drafts", Toast.LENGTH_SHORT).show();

        JSONObject si = new JSONObject();

        si.put("cck01", bi.cck01a.isChecked() ? "1" : bi.cck01b.isChecked() ? "2" : bi.cck01c.isChecked() ? "3"
                : bi.cck01d.isChecked() ? "4" : bi.cck01e.isChecked() ? "5" : bi.cck01f.isChecked() ? "6"
                : bi.cck0196.isChecked() ? "96" : "0");
        si.put("cck0196x", bi.cck0196x.getText().toString());
        si.put("cck02", bi.cck02a.isChecked() ? "1" : bi.cck02b.isChecked() ? "2" : bi.cck02c.isChecked() ? "3"
                : bi.cck02d.isChecked() ? "4" : bi.cck02e.isChecked() ? "5" : bi.cck02f.isChecked() ? "6"
                : bi.cck02g.isChecked() ? "7" : bi.cck02h.isChecked() ? "8" : bi.cck02i.isChecked() ? "9"
                : bi.cck02j.isChecked() ? "10" : bi.cck02k.isChecked() ? "11" : bi.cck02l.isChecked() ? "12"
                : bi.cck02m.isChecked() ? "13" : bi.cck02n.isChecked() ? "14" : bi.cck02o.isChecked() ? "15"
                : bi.cck0296.isChecked() ? "96" : "0");
        si.put("cck0296x", bi.cck0296x.getText().toString());
        si.put("cck03", bi.cck03a.isChecked() ? "1" : bi.cck03b.isChecked() ? "2" : "0");
        si.put("cck04", bi.cck04a.isChecked() ? "1" : bi.cck04b.isChecked() ? "2" : bi.cck04c.isChecked() ? "3"
                : bi.cck04d.isChecked() ? "4" : bi.cck04e.isChecked() ? "5" : bi.cck04f.isChecked() ? "6"
                : bi.cck0496.isChecked() ? "96" : "0");
        si.put("cck04x", bi.cck0496x.getText().toString());
        si.put("cck05", bi.cck05a.isChecked() ? "1" : bi.cck05b.isChecked() ? "2" : bi.cck05c.isChecked() ? "3"
                : bi.cck05d.isChecked() ? "4" : bi.cck05e.isChecked() ? "5" : bi.cck05f.isChecked() ? "6"
                : bi.cck05g.isChecked() ? "7" : bi.cck05h.isChecked() ? "8" : bi.cck05i.isChecked() ? "9"
                : bi.cck0596.isChecked() ? "96" : "0");
        si.put("cck0596x", bi.cck0596x.getText().toString());
        si.put("cck06", bi.cck06a.isChecked() ? "1" : bi.cck06b.isChecked() ? "2" : "0");
        si.put("cck07", bi.cck0798.isChecked() ? "98" : bi.cck07.getText().toString());
        si.put("cck08a", bi.cck08a01.isChecked() ? "1" : bi.cck08a02.isChecked() ? "2" : "0");
        si.put("cck08b", bi.cck08b01.isChecked() ? "1" : bi.cck08b02.isChecked() ? "2" : "0");
        si.put("cck08c", bi.cck08c01.isChecked() ? "1" : bi.cck08c02.isChecked() ? "2" : "0");
        si.put("cck08d", bi.cck08d01.isChecked() ? "1" : bi.cck08d02.isChecked() ? "2" : "0");
        si.put("cck08e", bi.cck08e01.isChecked() ? "1" : bi.cck08e02.isChecked() ? "2" : "0");
        si.put("cck08f", bi.cck08f01.isChecked() ? "1" : bi.cck08f02.isChecked() ? "2" : "0");
        si.put("cck08g", bi.cck08g01.isChecked() ? "1" : bi.cck08g02.isChecked() ? "2" : "0");
        si.put("cck08h", bi.cck08h01.isChecked() ? "1" : bi.cck08h02.isChecked() ? "2" : "0");
        si.put("cck08i", bi.cck08i01.isChecked() ? "1" : bi.cck08i02.isChecked() ? "2" : "0");
        si.put("cck08j", bi.cck08j01.isChecked() ? "1" : bi.cck08j02.isChecked() ? "2" : "0");
        si.put("cck08k", bi.cck08k01.isChecked() ? "1" : bi.cck08k02.isChecked() ? "2" : "0");
        si.put("cck08l", bi.cck08l01.isChecked() ? "1" : bi.cck08l02.isChecked() ? "2" : "0");
        si.put("cck08m", bi.cck08m01.isChecked() ? "1" : bi.cck08m02.isChecked() ? "2" : "0");
        si.put("cck08n", bi.cck08n01.isChecked() ? "1" : bi.cck08n02.isChecked() ? "2" : "0");
        si.put("cck08o", bi.cck08o01.isChecked() ? "1" : bi.cck08o02.isChecked() ? "2" : "0");
        si.put("cck08p", bi.cck08p01.isChecked() ? "1" : bi.cck08p02.isChecked() ? "2" : "0");
        si.put("cck08q", bi.cck08q01.isChecked() ? "1" : bi.cck08q02.isChecked() ? "2" : "0");
        si.put("cck08r", bi.cck08r01.isChecked() ? "1" : bi.cck08r02.isChecked() ? "2" : "0");
        si.put("cck09", bi.cck09a.isChecked() ? "1" : bi.cck09b.isChecked() ? "2" : bi.cck09c.isChecked() ? "3"
                : bi.cck09d.isChecked() ? "4" : bi.cck09e.isChecked() ? "5" : bi.cck09f.isChecked() ? "6"
                : bi.cck09g.isChecked() ? "7" : bi.cck09h.isChecked() ? "8" : bi.cck09i.isChecked() ? "9"
                : bi.cck09j.isChecked() ? "10" : bi.cck09k.isChecked() ? "11" : bi.cck0996.isChecked() ? "96" : "0");
        si.put("cck0996x", bi.cck0996x.getText().toString());
        si.put("cck10", bi.cck10a.isChecked() ? "1" : bi.cck10b.isChecked() ? "2" : bi.cck10c.isChecked() ? "3" : bi.cck1096.isChecked()? "96" : "0");
        si.put("cck1096x", bi.cck1096x.getText().toString());
        si.put("cck11", bi.cck11a.isChecked() ? "1" : bi.cck11b.isChecked() ? "2" : "0");
        si.put("cck12", bi.cck12a.isChecked() ? "1" : bi.cck12b.isChecked() ? "2" : bi.cck12c.isChecked() ? "3"
                : bi.cck12d.isChecked() ? "4" : bi.cck12e.isChecked() ? "5" : bi.cck12f.isChecked() ? "6"
                : bi.cck12g.isChecked() ? "7" : bi.cck12h.isChecked() ? "8" : bi.cck12i.isChecked() ? "9"
                : bi.cck12j.isChecked() ? "10" : bi.cck12k.isChecked() ? "11" : bi.cck1296.isChecked() ? "96" : "0");
        si.put("cck1296x", bi.cck1296x.getText().toString());
        si.put("cck13", bi.cck13a.isChecked() ? "1" : bi.cck13b.isChecked() ? "2" : bi.cck13c.isChecked() ? "3"
                : bi.cck13d.isChecked() ? "4" : bi.cck13e.isChecked() ? "5" : bi.cck13f.isChecked() ? "6"
                : bi.cck13g.isChecked() ? "7" : bi.cck13h.isChecked() ? "8" : bi.cck13i.isChecked() ? "9"
                : bi.cck13j.isChecked() ? "10" : bi.cck13k.isChecked() ? "11" : bi.cck13l.isChecked() ? "12"
                : bi.cck1396.isChecked() ? "96" : "0");
        si.put("cck1396x", bi.cck1396x.getText().toString());
        si.put("cck14", bi.cck14a.isChecked() ? "1" : bi.cck14b.isChecked() ? "2" : bi.cck14c.isChecked() ? "3"
                : bi.cck14d.isChecked() ? "4" : bi.cck14e.isChecked() ? "5" : bi.cck14f.isChecked() ? "6"
                : bi.cck14g.isChecked() ? "7" : bi.cck14h.isChecked() ? "8" : bi.cck14i.isChecked() ? "9"
                : bi.cck14j.isChecked() ? "10" : bi.cck14k.isChecked() ? "11" : bi.cck14l.isChecked() ? "12" :
                bi.cck14m.isChecked() ? "13" : bi.cck14n.isChecked() ? "14" : bi.cck14o.isChecked() ? "15" :
                        bi.cck14p.isChecked() ? "16" : bi.cck1496.isChecked() ? "96" : "0");
        si.put("cck1496x", bi.cck1496x.getText().toString());
        si.put("cck15", bi.cck15.getText().toString());
        si.put("cck16a", bi.cck16a01.isChecked() ? "1" : bi.cck16a02.isChecked() ? "2" : "0");
        si.put("cck16b", bi.cck16b01.isChecked() ? "1" : bi.cck16b02.isChecked() ? "2" : "0");
        si.put("cck16c", bi.cck16c01.isChecked() ? "1" : bi.cck16c02.isChecked() ? "2" : "0");
        si.put("cck16d", bi.cck16d01.isChecked() ? "1" : bi.cck16d02.isChecked() ? "2" : "0");
        si.put("cck16e", bi.cck16e01.isChecked() ? "1" : bi.cck16e02.isChecked() ? "2" : "0");
        si.put("cck16f", bi.cck16f01.isChecked() ? "1" : bi.cck16f02.isChecked() ? "2" : "0");
        si.put("cck16g", bi.cck16g01.isChecked() ? "1" : bi.cck16g02.isChecked() ? "2" : "0");
        si.put("cck17", bi.cck17a.isChecked() ? "1" : bi.cck17b.isChecked() ? "2" : "0");
        si.put("cck18a", bi.cck18a.getText().toString());
        si.put("cck18b", bi.cck18b.getText().toString());
        si.put("cck18c", bi.cck18c.getText().toString());
        si.put("cck1898", bi.cck1898.isChecked() ? "98" : "0");
        si.put("cck19", bi.cck19a.isChecked() ? "1" : bi.cck19b.isChecked() ? "2" : "0");
        si.put("cck20a", bi.cck20a.getText().toString());
        si.put("cck20b", bi.cck20b.getText().toString());
        si.put("cck20c", bi.cck20c.getText().toString());
        si.put("cck20d", bi.cck20d.getText().toString());
        si.put("cck20e", bi.cck20e.getText().toString());
        si.put("cck20f", bi.cck20f.getText().toString());
        si.put("cck20g", bi.cck20g.getText().toString());

        MainApp.fc.setsK(String.valueOf(si));

        Toast.makeText(this, "Validation Succecful", Toast.LENGTH_SHORT).show();

    }

    public boolean validateForm() {

        // =================== Q1 ====================
        if (bi.cck01.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.cck01), Toast.LENGTH_SHORT).show();
            bi.cck0196.setError("This Data is required");
            Log.d(TAG, "cck01 : This Data is required");
            return false;
        } else {
            bi.cck0196.setError(null);
        }

        if (bi.cck01.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.cck01), Toast.LENGTH_SHORT).show();
            bi.cck0196.setError("This Data is required");
            Log.d(TAG, "cck01 :This Data is required ");
            return false;
        } else {
            bi.cck0196.setError(null);
        }


        if (bi.cck0196.isChecked() && bi.cck0196x.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.cck01) + " - " + getString(R.string.other), Toast.LENGTH_LONG).show();
            bi.cck0196x.setError("This data is Required!");    // Set Error on last radio button
            Log.d(TAG, "cck0196: This data is Required!");
            return false;
        } else {
            bi.cck0196x.setError(null);
        }

        // =================== Q2 ====================
        if (bi.cck02.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.cck02), Toast.LENGTH_SHORT).show();
            bi.cck0296.setError("This Data is required");
            Log.d(TAG, "cck02 :This Data is required");
            return false;
        } else {
            bi.cck0296.setError(null);
        }

        if (bi.cck0296.isChecked() && bi.cck0296x.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.cck02) + " - " + getString(R.string.other), Toast.LENGTH_LONG).show();
            bi.cck0296x.setError("This data is Required!");    // Set Error on last radio button
            Log.d(TAG, "cck0296: This data is Required!");
            return false;
        } else {
            bi.cck0296x.setError(null);
        }

        // =================== Q3 ====================
        if (bi.cck03.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.cck03), Toast.LENGTH_SHORT).show();
            bi.cck03b.setError("This Data is required");
            Log.d(TAG, "cck02  :This Data is required ");
            return false;
        } else {
            bi.cck03b.setError(null);
        }


        if (bi.cck03a.isChecked()) {
            // =================== Q4 ====================
            if (bi.cck04.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(Empty)" + getString(R.string.cck04), Toast.LENGTH_SHORT).show();
                bi.cck0496.setError("This Data is required");
                Log.d(TAG, "cck04 : This Data is required ");
                return false;
            } else {
                bi.cck0496.setError(null);
            }

            if (bi.cck0496.isChecked() && bi.cck0496x.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.cck04) + " - " + getString(R.string.other), Toast.LENGTH_LONG).show();
                bi.cck0496x.setError("This data is Required!");    // Set Error on last radio button
                Log.d(TAG, "cck0496x: This data is Required!");
                return false;
            } else {
                bi.cck0496x.setError(null);
            }
        }

        // =================== Q5 ====================
        if (bi.cck05.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.cck05), Toast.LENGTH_SHORT).show();
            bi.cck0596.setError("This Data is required");
            Log.d(TAG, "cck05 : This Data is required ");
            return false;
        } else {
            bi.cck0596.setError(null);
        }

        if (bi.cck0596.isChecked() && bi.cck0596x.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.cck05) + " - " + getString(R.string.other), Toast.LENGTH_LONG).show();
            bi.cck0596x.setError("This data is Required!");    // Set Error on last radio button
            Log.d(TAG, "cck0596x: This data is Required!");
            return false;
        } else {
            bi.cck0596x.setError(null);
        }

        if (!bi.cck05i.isChecked()) {
            // =================== Q6 ====================
            if (bi.cck06.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(Empty)" + getString(R.string.cck06), Toast.LENGTH_SHORT).show();
                bi.cck06b.setError("This Data is required");
                Log.d(TAG, "cck06 : This Data is required ");
                return false;
            } else {
                bi.cck06b.setError(null);
            }

            if (bi.cck06a.isChecked()) {
                // =================== Q7 ====================
                if (bi.cck07.getText().toString().isEmpty() && !bi.cck0798.isChecked()) {
                    Toast.makeText(this, "ERROR(Empty)" + getString(R.string.cck07), Toast.LENGTH_SHORT).show();
                    bi.cck07.setError("This data is required");
                    Log.d(TAG, "cck07  : This Data is required ");
                    return false;
                } else {
                    bi.cck07.setError(null);
                }
                if (!bi.cck0798.isChecked()) {
                    if (!validatorClass.RangeTextBox(this, bi.cck07, 1, 10, getString(R.string.cck07), " number")) {
                        return false;
                    }

                }
            }
        }

        // =================== Q801 ====================
        if (bi.cck08a.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.cck08a), Toast.LENGTH_SHORT).show();
            bi.cck08a02.setError("This Data is required");
            Log.d(TAG, " bi.cck08a :This Data is required");
            return false;
        } else {
            bi.cck08a02.setError(null);
        }

        // =================== Q802 ====================
        if (bi.cck08b.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.cck08b), Toast.LENGTH_SHORT).show();
            bi.cck08b02.setError("This Data is required");
            Log.d(TAG, "cck08b : This Data is required ");
            return false;
        } else {
            bi.cck08b02.setError(null);
        }

        // =================== Q803 ====================
        if (bi.cck08c.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.cck08c), Toast.LENGTH_SHORT).show();
            bi.cck08c02.setError("This Data is required");
            Log.d(TAG, "cck08c : This Data is required ");
            return false;
        } else {
            bi.cck08c02.setError(null);
        }

        // =================== Q804 ====================
        if (bi.cck08d.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.cck08d), Toast.LENGTH_SHORT).show();
            bi.cck08d02.setError("This Data is required");
            Log.d(TAG, "cck08d : This Data is required ");
            return false;
        } else {
            bi.cck08d02.setError(null);
        }
        // =================== Q805 ====================
        if (bi.cck08e.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.cck08e), Toast.LENGTH_SHORT).show();
            bi.cck08e02.setError("This Data is required");
            Log.d(TAG, "cck08e : This Data is required ");
            return false;
        } else {
            bi.cck08e02.setError(null);
        }

        // =================== Q806 ====================
        if (bi.cck08f.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.cck08f), Toast.LENGTH_SHORT).show();
            bi.cck08f02.setError("This Data is required");
            Log.d(TAG, "cck08f : This Data is required ");
            return false;
        } else {
            bi.cck08f02.setError(null);
        }

        // =================== Q807 ====================
        if (bi.cck08g.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.cck08g), Toast.LENGTH_SHORT).show();
            bi.cck08g02.setError("This Data is required");
            Log.d(TAG, "cck08g : This Data is required ");
            return false;
        } else {
            bi.cck08g02.setError(null);
        }

        // =================== Q807 ====================
        if (bi.cck08g.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.cck08g), Toast.LENGTH_SHORT).show();
            bi.cck08g02.setError("This Data is required");
            Log.d(TAG, "cck08g : This Data is required ");
            return false;
        } else {
            bi.cck08g02.setError(null);
        }

        // =================== Q808 ====================
        if (bi.cck08h.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.cck08h), Toast.LENGTH_SHORT).show();
            bi.cck08h02.setError("This Data is required");
            Log.d(TAG, "cck08h :This Data is required ");
            return false;
        } else {
            bi.cck08h02.setError(null);
        }

        // =================== Q809 ====================
        if (bi.cck08i.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.cck08i), Toast.LENGTH_SHORT).show();
            bi.cck08i02.setError("This Data is required");
            Log.d(TAG, "cck08i : This Data is required ");
            return false;
        } else {
            bi.cck08i02.setError(null);
        }

        // =================== Q810 ====================
        if (bi.cck08j.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.cck08j), Toast.LENGTH_SHORT).show();
            bi.cck08j02.setError("This Data is required");
            Log.d(TAG, "cck08j : This Data is required");
            return false;
        } else {
            bi.cck08j02.setError(null);
        }

        // =================== Q811 ====================
        if (bi.cck08k.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.cck08k), Toast.LENGTH_SHORT).show();
            bi.cck08k02.setError("This Data is required");
            Log.d(TAG, "cck08k : This Data is required");
            return false;
        } else {
            bi.cck08k02.setError(null);
        }

        // =================== Q812 ====================
        if (bi.cck08l.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.cck08l), Toast.LENGTH_SHORT).show();
            bi.cck08l02.setError("This Data is required");
            Log.d(TAG, "cck08l : This Data is required ");
            return false;
        } else {
            bi.cck08l02.setError(null);
        }

        // =================== Q813 ====================
        if (bi.cck08m.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.cck08m), Toast.LENGTH_SHORT).show();
            bi.cck08m02.setError("This Data is required");
            Log.d(TAG, "cck08m : This Data is required ");
            return false;
        } else {
            bi.cck08m02.setError(null);
        }

        // =================== Q814 ====================
        if (bi.cck08n.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "" + getString(R.string.cck08n), Toast.LENGTH_SHORT).show();
            bi.cck08n02.setError("This Data is required");
            Log.d(TAG, "cck08n :This Data is required ");
            return false;
        } else {
            bi.cck08n02.setError(null);
        }
        // =================== Q815 ====================
        if (bi.cck08o.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.cck08o), Toast.LENGTH_SHORT).show();
            bi.cck08o02.setError("This Data is required");
            Log.d(TAG, "cck08o : This Data is required ");
            return false;
        } else {
            bi.cck08o02.setError(null);
        }

        // =================== Q816 ====================
        if (bi.cck08p.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.cck08p), Toast.LENGTH_SHORT).show();
            bi.cck08p02.setError("This Data is required");
            Log.d(TAG, "cck08p :This Data is required ");
            return false;
        } else {
            bi.cck08p02.setError(null);
        }

        // =================== Q817 ====================
        if (bi.cck08q.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.cck08q), Toast.LENGTH_SHORT).show();
            bi.cck08q02.setError("This Data is required");
            Log.d(TAG, "cck08q :This Data is required ");
            return false;
        } else {
            bi.cck08q02.setError(null);
        }

        // =================== Q818 ====================
        if (bi.cck08r.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.cck08r), Toast.LENGTH_SHORT).show();
            bi.cck08r02.setError("This Data is required");
            Log.d(TAG, "cck08r : This Data is required ");
            return false;
        } else {
            bi.cck08r02.setError(null);
        }


        // =================== Q9 ====================
        if (bi.cck09.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.cck09), Toast.LENGTH_SHORT).show();
            bi.cck0996.setError("This Data is required");
            Log.d(TAG, "cck09 :This Data is required ");
            return false;
        } else {
            bi.cck0996.setError(null);
        }

        if (bi.cck0996.isChecked() && bi.cck0996x.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.cck09) + " - " + getString(R.string.other), Toast.LENGTH_LONG).show();
            bi.cck0996x.setError("This data is Required!");    // Set Error on last radio button
            Log.d(TAG, "cck0996x: This data is Required!");
            return false;
        } else {
            bi.cck0996x.setError(null);
        }

        if (!bi.cck09j.isChecked()) {
            // =================== Q10 ====================
            if (bi.cck10.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(Empty)" + getString(R.string.cck10), Toast.LENGTH_SHORT).show();
                bi.cck1096.setError("This Data is required");
                Log.d(TAG, "cck10 : This Data is required ");
                return false;
            } else {
                bi.cck1096.setError(null);
            }

            if (bi.cck1096.isChecked() && bi.cck1096x.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.cck10) + " - " + getString(R.string.other), Toast.LENGTH_LONG).show();
                bi.cck1096x.setError("This data is Required!");    // Set Error on last radio button
                Log.d(TAG, "cck1096x: This data is Required!");
                return false;
            } else {
                bi.cck1096x.setError(null);
            }
        }

        // =================== Q11 ====================
        if (bi.cck11.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.cck11), Toast.LENGTH_SHORT).show();
            bi.cck11b.setError("This Data is required");
            Log.d(TAG, "cck11 : This Data is required ");
            return false;
        } else {
            bi.cck11b.setError(null);
        }

        // =================== Q12 ====================
        if (bi.cck12.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.cck12), Toast.LENGTH_SHORT).show();
            bi.cck1296.setError("This Data is required");
            Log.d(TAG, "cck12 : This Data is required ");
            return false;
        } else {
            bi.cck1296.setError(null);
        }

        if (bi.cck1296.isChecked() && bi.cck1296x.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.cck12) + " - " + getString(R.string.other), Toast.LENGTH_LONG).show();
            bi.cck1296x.setError("This data is Required!");    // Set Error on last radio button
            Log.d(TAG, "cck1296x: This data is Required!");
            return false;
        } else {
            bi.cck1296x.setError(null);
        }

        // =================== Q13 ====================
        if (bi.cck13.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.cck13), Toast.LENGTH_SHORT).show();
            bi.cck1396.setError("This Data is required");
            Log.d(TAG, "cck13 : This Data is required ");
            return false;
        } else {
            bi.cck1396.setError(null);
        }

        if (bi.cck1396.isChecked() && bi.cck1396x.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.cck13) + " - " + getString(R.string.other), Toast.LENGTH_LONG).show();
            bi.cck1396x.setError("This data is Required!");    // Set Error on last radio button
            Log.d(TAG, "cck1396x: This data is Required!");
            return false;
        } else {
            bi.cck1396x.setError(null);
        }

        // =================== Q14 ====================
        if (bi.cck14.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.cck14), Toast.LENGTH_SHORT).show();
            bi.cck1496.setError("This Data is required");
            Log.d(TAG, "cck14 :This Data is required ");
            return false;
        } else {
            bi.cck1496.setError(null);
        }

        if (bi.cck1496.isChecked() && bi.cck1496x.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.cck14) + " - " + getString(R.string.other), Toast.LENGTH_LONG).show();
            bi.cck1496x.setError("This data is Required!");    // Set Error on last radio button
            Log.d(TAG, "cck1496x: This data is Required!");
            return false;
        } else {
            bi.cck1496x.setError(null);
        }

        // =================== Q15 ====================
        if (bi.cck15.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.cck15), Toast.LENGTH_SHORT).show();
            bi.cck15.setError("This data is required");
            Log.d(TAG, "cck15  : This Data is required ");
            return false;
        } else {
            bi.cck15.setError(null);
        }

        if ((Integer.parseInt(bi.cck15.getText().toString()) == 0)) {
            Toast.makeText(this, "ERROR: " + getString(R.string.cck15), Toast.LENGTH_LONG).show();
            bi.cck15.setError("No. of rooms cannot be zero");
            Log.i(TAG, "cck15: No. of rooms cannot  not be zero");
            return false;
        } else {
            bi.cck15.setError(null);
        }
        if (!validatorClass.RangeTextBox(this, bi.cck15, 1, 15, getString(R.string.cck15), " Rooms")) {
            return false;
        }

        // =================== Q16a ====================
        if (bi.cck16a.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.cck16a), Toast.LENGTH_SHORT).show();
            bi.cck16a02.setError("This Data is required");
            Log.d(TAG, "cck16a : This Data is required ");
            return false;
        } else {
            bi.cck16a02.setError(null);
        }

        // =================== Q16b ====================
        if (bi.cck16b.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.cck16b), Toast.LENGTH_SHORT).show();
            bi.cck16b02.setError("This Data is required");
            Log.d(TAG, "cck16b : This Data is required ");
            return false;
        } else {
            bi.cck16b02.setError(null);
        }

        // =================== Q16c ====================
        if (bi.cck16c.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.cck16c), Toast.LENGTH_SHORT).show();
            bi.cck16c02.setError("This Data is required");
            Log.d(TAG, "cck16c : This Data is required");
            return false;
        } else {
            bi.cck16c02.setError(null);
        }

        // =================== Q16d ====================
        if (bi.cck16d.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.cck16d), Toast.LENGTH_SHORT).show();
            bi.cck16d02.setError("This Data is required");
            Log.d(TAG, "cck16d : This Data is required ");
            return false;
        } else {
            bi.cck16d02.setError(null);
        }

        // =================== Q16e ====================
        if (bi.cck16e.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.cck16e), Toast.LENGTH_SHORT).show();
            bi.cck16e02.setError("This Data is required");
            Log.d(TAG, "cck16e : This Data is required");
            return false;
        } else {
            bi.cck16e02.setError(null);
        }

        // =================== Q16f ====================
        if (bi.cck16f.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.cck16f), Toast.LENGTH_SHORT).show();
            bi.cck16f02.setError("This Data is required");
            Log.d(TAG, "cck16f : This Data is required");
            return false;
        } else {
            bi.cck16f02.setError(null);
        }

        // =================== Q16g ====================
        if (bi.cck16g.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.cck16g), Toast.LENGTH_SHORT).show();
            bi.cck16g02.setError("This Data is required");
            Log.d(TAG, "cck16g :This Data is required");
            return false;
        } else {
            bi.cck16g02.setError(null);
        }

        // =================== Q17 ====================
        if (bi.cck17.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.cck17), Toast.LENGTH_SHORT).show();
            bi.cck17b.setError("This Data is required");
            Log.d(TAG, "cck17 : This Data is required");
            return false;
        } else {
            bi.cck17b.setError(null);
        }

        if (bi.cck17a.isChecked()) {
            // =================== Q1801 ====================

            if ((bi.cck18a.getText().toString().isEmpty() && bi.cck18b.getText().toString().isEmpty()
                    && bi.cck18c.getText().toString().isEmpty())
                    && !bi.cck1898.isChecked()) {
                Toast.makeText(this, "ERROR(empty)" + getString(R.string.cck18), Toast.LENGTH_SHORT).show();
                bi.cck1898.setError("This data is required");
                Log.d(TAG, "cck1801: This data is required  ");
                return false;
            } else {
                bi.cck1898.setError(null);
            }

            if (!bi.cck1898.isChecked()) {
                if ((Integer.parseInt(bi.cck18a.getText().toString().isEmpty() ? "0" : bi.cck18a.getText().toString()) < 1)
                        && Integer.parseInt(bi.cck18b.getText().toString().isEmpty() ? "0" : bi.cck18b.getText().toString()) < 1
                        && Integer.parseInt(bi.cck18c.getText().toString().isEmpty() ? "0" : bi.cck18c.getText().toString()) < 1) {
                    Toast.makeText(this, "ERROR(Invalid): " + getString(R.string.cck18), Toast.LENGTH_SHORT).show();
                    bi.cck18a.setError("Zero not allowed");
                    Log.i(TAG, "cck18: Zero not allowed");
                    return false;
                } else {
                    bi.cck18a.setError(null);
                }
            }
        }

        // =================== Q19 ====================
        if (bi.cck19.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(empty)" + getString(R.string.cck19), Toast.LENGTH_SHORT).show();
            bi.cck19b.setError("This Data is required");
            Log.d(TAG, "cck19 :This Data is required ");
            return false;
        } else {
            bi.cck19b.setError(null);
        }
        if (bi.cck19a.isChecked()) {

            // =================== Q20.01 ====================
            if (bi.cck20a.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(Empty)" + getString(R.string.cck20) + getString(R.string.cck20a), Toast.LENGTH_SHORT).show();
                bi.cck20a.setError("This data is required");
                Log.d(TAG, "cck2001 :This Data is required");
                return false;
            } else {
                bi.cck20a.setError(null);
            }

            // =================== Q20.02 ====================
            if (bi.cck20b.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(Empty)" + getString(R.string.cck20) + getString(R.string.cck20b), Toast.LENGTH_SHORT).show();
                bi.cck20b.setError("This data is required");
                Log.d(TAG, "cck2002  :This Data is required");
                return false;
            } else {
                bi.cck20b.setError(null);
            }

            // =================== Q20.03 ====================
            if (bi.cck20c.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(Empty)" + getString(R.string.cck20) + getString(R.string.cck20c), Toast.LENGTH_SHORT).show();
                bi.cck20c.setError("This data is required");
                Log.d(TAG, "cck2003  : This Data is required ");
                return false;
            } else {
                bi.cck20c.setError(null);
            }

            // =================== Q20.04 ====================
            if (bi.cck20d.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(Empty)" + getString(R.string.cck20) + getString(R.string.cck20d), Toast.LENGTH_SHORT).show();
                bi.cck20d.setError("This data is required");
                Log.d(TAG, "cck2004 : This Data is required ");
                return false;
            } else {
                bi.cck20d.setError(null);
            }


            // =================== Q20.05 ====================
            if (bi.cck20e.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(Empty)" + getString(R.string.cck20) + getString(R.string.cck20e), Toast.LENGTH_SHORT).show();
                bi.cck20e.setError("This data is required");
                Log.d(TAG, "cck2005  : This Data is required ");
                return false;
            } else {
                bi.cck20e.setError(null);
            }

            // =================== Q20.06 ====================
            if (bi.cck20f.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(Empty)" + getString(R.string.cck20) + getString(R.string.cck20f), Toast.LENGTH_SHORT).show();
                bi.cck20f.setError("This data is required");
                Log.d(TAG, "cck2006 :This Data is required ");
                return false;
            } else {
                bi.cck20f.setError(null);
            }

            // =================== Q20.07 ====================
            if (bi.cck20g.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(Empty)" + getString(R.string.cck20) + getString(R.string.cck20g), Toast.LENGTH_SHORT).show();
                bi.cck20g.setError("This data is required");
                Log.d(TAG, "cck2007 :This Data is required ");
                return false;
            } else {
                bi.cck20g.setError(null);
            }

        }

        return true;
    }


}
