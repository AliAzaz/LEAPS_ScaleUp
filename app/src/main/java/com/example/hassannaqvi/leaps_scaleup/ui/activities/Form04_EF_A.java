package com.example.hassannaqvi.leaps_scaleup.ui.activities;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.hassannaqvi.leaps_scaleup.R;
import com.example.hassannaqvi.leaps_scaleup.core.MainApp;
import com.example.hassannaqvi.leaps_scaleup.databinding.ActivityForm04EfABinding;

import java.util.Objects;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class Form04_EF_A extends AppCompatActivity {
    ActivityForm04EfABinding bi;
    String ls04aa01a = "";
    String ls04aa01b = "";
    String ls04aa02a = "";
    String ls04aa02b = "";
    String ls04aa03a = "";
    String ls04aa03b = "";
    String ls04aa04a = "";
    String ls04aa04b = "";

    String aa01pattern = "37";
    String aa02pattern = "64";
    String aa03pattern = "37";
    String aa04pattern = "64";

    /*level 2*/

    int ab01, ab02, ab03, ab04, ab05, ab06, ab07, ab08, ab09, ab10, ab11, ab12;
    String ls04ab01 = "", ls04ab02 = "", ls04ab03 = "", ls04ab04 = "", ls04ab05 = "", ls04ab06 = "", ls04ab07 = "", ls04ab08 = "", ls04ab09 = "", ls04ab10 = "", ls04ab11 = "", ls04ab12 = "";
    String ab01pattern = "57";
    String ab02pattern = "21";
    String ab03pattern = "82";
    String ab04pattern = "436";
    String ab05pattern = "381";
    String ab06pattern = "527";
    String ab07pattern = "3249";
    String ab08pattern = "1765";
    String ab09pattern = "3571";
    String ab10pattern = "34875";
    String ab11pattern = "81536";
    String ab12pattern = "64529";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form04_ef_a);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_form04_ef_a);
        bi.setCallback(this);

        /*listners*/
        attachingListners();
        attachingListnerLevelone();


    }

    private void attachingListnerLevelone() {
        /* level 2*/
        /*  ls04ab01 */
        bi.ls04ab01a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04ab01 = ls04ab01 + "5";
                ab01 =  settingAnswers( bi.ls04ab01,ls04ab01,ab01,ab01pattern);
                if(isConditionSatisfied(ab01,ab02,ab03)){
                    bi.level3.setVisibility(VISIBLE);
                }else {
                    bi.level3.setVisibility(GONE);
                }
            }
        });
        bi.ls04ab01b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04ab01 = ls04ab01 + "7";
                ab01 =  settingAnswers( bi.ls04ab01,ls04ab01,ab01,ab01pattern);
                if(isConditionSatisfied(ab01,ab02,ab03)){
                    bi.level3.setVisibility(VISIBLE);
                }else {
                    bi.level3.setVisibility(GONE);
                }
            }
        });
        bi.ls04ab01x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04ab01 = ls04ab01 + "X";
                ab01 =  settingAnswers( bi.ls04ab01,ls04ab01,ab01,ab01pattern);
                if(isConditionSatisfied(ab01,ab02,ab03)){
                    bi.level3.setVisibility(VISIBLE);
                }else {
                    bi.level3.setVisibility(GONE);
                }
            }
        });

        /*  ls04ab02 */
        bi.ls04ab02a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04ab02 = ls04ab02 + "2";
                ab02 =  settingAnswers( bi.ls04ab02,ls04ab02,ab02,ab02pattern);
                if(isConditionSatisfied(ab01,ab02,ab03)){
                    bi.level3.setVisibility(VISIBLE);
                }else {
                    bi.level3.setVisibility(GONE);
                }

            }
        });
        bi.ls04ab02b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04ab02 = ls04ab02 + "1";
                ab02 =  settingAnswers( bi.ls04ab02,ls04ab02,ab02,ab02pattern);
                if(isConditionSatisfied(ab01,ab02,ab03)){
                    bi.level3.setVisibility(VISIBLE);
                }else {
                    bi.level3.setVisibility(GONE);
                }
            }
        });
        bi.ls04ab02x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04ab02 = ls04ab02 + "X";
                ab02 =  settingAnswers( bi.ls04ab02,ls04ab02,ab02,ab02pattern);
                if(isConditionSatisfied(ab01,ab02,ab03)){
                    bi.level3.setVisibility(VISIBLE);
                }else {
                    bi.level3.setVisibility(GONE);
                }
            }
        });

        /*  ls04ab03 */
        bi.ls04ab03a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04ab03 = ls04ab03 + "8";
                ab03 =  settingAnswers( bi.ls04ab03,ls04ab03,ab03,ab03pattern);
                if(isConditionSatisfied(ab01,ab02,ab03)){
                    bi.level3.setVisibility(VISIBLE);
                }else {
                    bi.level3.setVisibility(GONE);
                }

            }
        });
        bi.ls04ab03b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04ab03 = ls04ab03 + "2";
                ab03 =  settingAnswers( bi.ls04ab03,ls04ab03,ab03,ab03pattern);
                if(isConditionSatisfied(ab01,ab02,ab03)){
                    bi.level3.setVisibility(VISIBLE);
                }else {
                    bi.level3.setVisibility(GONE);
                }
            }
        });
        bi.ls04ab03x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04ab03 = ls04ab03 + "X";
                ab03 =  settingAnswers( bi.ls04ab03,ls04ab03,ab03,ab03pattern);
                if(isConditionSatisfied(ab01,ab02,ab03)){
                    bi.level3.setVisibility(VISIBLE);
                }else {
                    bi.level3.setVisibility(GONE);
                }
            }
        });

        /* level 3*/
        /*  ls04ab04 */
        bi.ls04ab04a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04ab04 = ls04ab04 + "4";
                ab04 =  settingAnswers( bi.ls04ab04,ls04ab04,ab04,ab04pattern);
                if(isConditionSatisfied(ab04,ab05,ab06)){
                    bi.level4.setVisibility(VISIBLE);
                }else {
                    bi.level4.setVisibility(GONE);
                }
            }
        });
        bi.ls04ab04b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04ab04 = ls04ab04 + "3";
                ab04 =  settingAnswers( bi.ls04ab04,ls04ab04,ab04,ab04pattern);
                if(isConditionSatisfied(ab04,ab05,ab06)){
                    bi.level4.setVisibility(VISIBLE);
                }else {
                    bi.level4.setVisibility(GONE);
                }
            }
        });
        bi.ls04ab04c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04ab04 = ls04ab04 + "6";
                ab04 =  settingAnswers( bi.ls04ab04,ls04ab04,ab04,ab04pattern);
                if(isConditionSatisfied(ab04,ab05,ab06)){
                    bi.level4.setVisibility(VISIBLE);
                }else {
                    bi.level4.setVisibility(GONE);
                }
            }
        });
        bi.ls04ab04x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04ab04 = ls04ab04 + "X";
                ab04 =  settingAnswers( bi.ls04ab04,ls04ab04,ab04,ab04pattern);
                if(isConditionSatisfied(ab04,ab05,ab06)){
                    bi.level4.setVisibility(VISIBLE);
                }else {
                    bi.level4.setVisibility(GONE);
                }
            }
        });

        /*  ls04ab05 */
        bi.ls04ab05a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04ab05 = ls04ab05 + "3";
                ab05 =  settingAnswers( bi.ls04ab05,ls04ab05,ab05,ab05pattern);
                if(isConditionSatisfied(ab04,ab05,ab06)){
                    bi.level4.setVisibility(VISIBLE);
                }else {
                    bi.level4.setVisibility(GONE);
                }
            }
        });
        bi.ls04ab05b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04ab05 = ls04ab05 + "8";
                ab05 =  settingAnswers( bi.ls04ab05,ls04ab05,ab05,ab05pattern);
                if(isConditionSatisfied(ab04,ab05,ab06)){
                    bi.level4.setVisibility(VISIBLE);
                }else {
                    bi.level4.setVisibility(GONE);
                }
            }
        });
        bi.ls04ab05c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04ab05 = ls04ab05 + "1";
                ab05 =  settingAnswers( bi.ls04ab05,ls04ab05,ab05,ab05pattern);
                if(isConditionSatisfied(ab04,ab05,ab06)){
                    bi.level4.setVisibility(VISIBLE);
                }else {
                    bi.level4.setVisibility(GONE);
                }
            }
        });
        bi.ls04ab05x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04ab05 = ls04ab05 + "X";
                ab05 =  settingAnswers( bi.ls04ab05,ls04ab05,ab05,ab05pattern);
                if(isConditionSatisfied(ab04,ab05,ab06)){
                    bi.level4.setVisibility(VISIBLE);
                }else {
                    bi.level4.setVisibility(GONE);
                }
            }
        });


        /*  ls04ab06 */
        bi.ls04ab06a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04ab06 = ls04ab06 + "5";
                ab06 =  settingAnswers( bi.ls04ab06,ls04ab06,ab06,ab06pattern);
                if(isConditionSatisfied(ab04,ab05,ab06)){
                    bi.level4.setVisibility(VISIBLE);
                }else {
                    bi.level4.setVisibility(GONE);
                }
            }
        });
        bi.ls04ab06b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04ab06 = ls04ab06 + "2";
                ab06 =  settingAnswers( bi.ls04ab06,ls04ab06,ab06,ab06pattern);
                if(isConditionSatisfied(ab04,ab05,ab06)){
                    bi.level4.setVisibility(VISIBLE);
                }else {
                    bi.level4.setVisibility(GONE);
                }
            }
        });
        bi.ls04ab06c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04ab06 = ls04ab06 + "7";
                ab06 =  settingAnswers( bi.ls04ab06,ls04ab06,ab06,ab06pattern);
                if(isConditionSatisfied(ab04,ab05,ab06)){
                    bi.level4.setVisibility(VISIBLE);
                }else {
                    bi.level4.setVisibility(GONE);
                }
            }
        });
        bi.ls04ab06x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04ab06 = ls04ab06 + "X";
                ab06 =  settingAnswers( bi.ls04ab06,ls04ab06,ab06,ab06pattern);
                if(isConditionSatisfied(ab04,ab05,ab06)){
                    bi.level4.setVisibility(VISIBLE);
                }else {
                    bi.level4.setVisibility(GONE);
                }
            }
        });
/*level 4*/
        /*  ls04ab07 */
        bi.ls04ab07a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04ab07 = ls04ab07 + "3";
                ab07 =  settingAnswers( bi.ls04ab07,ls04ab07,ab07,ab07pattern);
                if(isConditionSatisfied(ab07,ab08,ab09)){
                    bi.level5.setVisibility(VISIBLE);
                }else {
                    bi.level5.setVisibility(GONE);
                }
            }
        });
        bi.ls04ab07b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04ab07 = ls04ab07 + "2";
                ab07 =  settingAnswers( bi.ls04ab07,ls04ab07,ab07,ab07pattern);
                if(isConditionSatisfied(ab07,ab08,ab09)){
                    bi.level5.setVisibility(VISIBLE);
                }else {
                    bi.level5.setVisibility(GONE);
                }
            }
        });
        bi.ls04ab07c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04ab07 = ls04ab07 + "4";
                ab07 =  settingAnswers( bi.ls04ab07,ls04ab07,ab07,ab07pattern);
                if(isConditionSatisfied(ab07,ab08,ab09)){
                    bi.level5.setVisibility(VISIBLE);
                }else {
                    bi.level5.setVisibility(GONE);
                }
            }
        });
        bi.ls04ab07d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04ab07 = ls04ab07 + "9";
                ab07 =  settingAnswers( bi.ls04ab07,ls04ab07,ab07,ab07pattern);
                if(isConditionSatisfied(ab07,ab08,ab09)){
                    bi.level5.setVisibility(VISIBLE);
                }else {
                    bi.level5.setVisibility(GONE);
                }
            }
        });
        bi.ls04ab07x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04ab07 = ls04ab07 + "X";
                ab07 =  settingAnswers( bi.ls04ab07,ls04ab07,ab07,ab07pattern);
                if(isConditionSatisfied(ab07,ab08,ab09)){
                    bi.level5.setVisibility(VISIBLE);
                }else {
                    bi.level5.setVisibility(GONE);
                }
            }
        });
        /*  ls04ab08 */
        bi.ls04ab08a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04ab08 = ls04ab08 + "1";
                ab08 =  settingAnswers( bi.ls04ab08,ls04ab08,ab08,ab08pattern);
                if(isConditionSatisfied(ab07,ab08,ab09)){
                    bi.level5.setVisibility(VISIBLE);
                }else {
                    bi.level5.setVisibility(GONE);
                }
            }
        });

        bi.ls04ab08b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04ab08 = ls04ab08 + "7";
                ab08 =  settingAnswers( bi.ls04ab08,ls04ab08,ab08,ab08pattern);
                if(isConditionSatisfied(ab07,ab08,ab09)){
                    bi.level5.setVisibility(VISIBLE);
                }else {
                    bi.level5.setVisibility(GONE);
                }
            }
        });

        bi.ls04ab08c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04ab08 = ls04ab08 + "6";
                ab08 =  settingAnswers( bi.ls04ab08,ls04ab08,ab08,ab08pattern);
                if(isConditionSatisfied(ab07,ab08,ab09)){
                    bi.level5.setVisibility(VISIBLE);
                }else {
                    bi.level5.setVisibility(GONE);
                }
            }
        });
        bi.ls04ab08d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04ab08 = ls04ab08 + "5";
                ab08 =  settingAnswers( bi.ls04ab08,ls04ab08,ab08,ab08pattern);
                if(isConditionSatisfied(ab07,ab08,ab09)){
                    bi.level5.setVisibility(VISIBLE);
                }else {
                    bi.level5.setVisibility(GONE);
                }
            }
        });
        bi.ls04ab08x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04ab08 = ls04ab08 + "X";
                ab08 =  settingAnswers( bi.ls04ab08,ls04ab08,ab08,ab08pattern);
                if(isConditionSatisfied(ab07,ab08,ab09)){
                    bi.level5.setVisibility(VISIBLE);
                }else {
                    bi.level5.setVisibility(GONE);
                }
            }
        });
        /*  ls04ab09 */
        bi.ls04ab09a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04ab09 = ls04ab09 + "3";
                ab09 =  settingAnswers( bi.ls04ab09,ls04ab09,ab09,ab09pattern);
                if(isConditionSatisfied(ab07,ab08,ab09)){
                    bi.level5.setVisibility(VISIBLE);
                }else {
                    bi.level5.setVisibility(GONE);
                }
            }
        });
        bi.ls04ab09b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04ab09 = ls04ab09 + "5";
                ab09 =  settingAnswers( bi.ls04ab09,ls04ab09,ab09,ab09pattern);
                if(isConditionSatisfied(ab07,ab08,ab09)){
                    bi.level5.setVisibility(VISIBLE);
                }else {
                    bi.level5.setVisibility(GONE);
                }
            }
        });
        bi.ls04ab09c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04ab09 = ls04ab09 + "7";
                ab09 =  settingAnswers( bi.ls04ab09,ls04ab09,ab09,ab09pattern);
                if(isConditionSatisfied(ab07,ab08,ab09)){
                    bi.level5.setVisibility(VISIBLE);
                }else {
                    bi.level5.setVisibility(GONE);
                }
            }
        });
        bi.ls04ab09d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04ab09 = ls04ab09 + "1";
                ab09 =  settingAnswers( bi.ls04ab09,ls04ab09,ab09,ab09pattern);
                if(isConditionSatisfied(ab07,ab08,ab09)){
                    bi.level5.setVisibility(VISIBLE);
                }else {
                    bi.level5.setVisibility(GONE);
                }
            }
        });
        bi.ls04ab09x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04ab09 = ls04ab09 + "X";
                ab09 =  settingAnswers( bi.ls04ab09,ls04ab09,ab09,ab09pattern);
                if(isConditionSatisfied(ab07,ab08,ab09)){
                    bi.level5.setVisibility(VISIBLE);
                }else {
                    bi.level5.setVisibility(GONE);
                }
            }
        });
        /*level 5*/
        /*  ls04ab10 */
        bi.ls04ab10a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04ab10 = ls04ab10 + "3";
                ab10 =  settingAnswers( bi.ls04ab10,ls04ab10,ab10,ab10pattern);
            }
        });
        bi.ls04ab10b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04ab10 = ls04ab10 + "4";
                ab10 =  settingAnswers( bi.ls04ab10,ls04ab10,ab10,ab10pattern);
            }
        });
        bi.ls04ab10c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04ab10 = ls04ab10 + "8";
                ab10 =  settingAnswers( bi.ls04ab10,ls04ab10,ab10,ab10pattern);
            }
        });
        bi.ls04ab10d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04ab10 = ls04ab10 + "7";
                ab10 =  settingAnswers( bi.ls04ab10,ls04ab10,ab10,ab10pattern);
            }
        });
        bi.ls04ab10e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04ab10 = ls04ab10 + "5";
                ab10 =  settingAnswers( bi.ls04ab10,ls04ab10,ab10,ab10pattern);
            }
        });
        bi.ls04ab10x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04ab10 = ls04ab10 + "X";
                ab10 =  settingAnswers( bi.ls04ab10,ls04ab10,ab10,ab10pattern);
            }
        });
        /*  ls04ab11 */
        bi.ls04ab11a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04ab11 = ls04ab11 + "8";
                ab11 =  settingAnswers( bi.ls04ab11,ls04ab11,ab11,ab11pattern);
            }
        });
        bi.ls04ab11b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04ab11 = ls04ab11 + "1";
                ab11 =  settingAnswers( bi.ls04ab11,ls04ab11,ab11,ab11pattern);
            }
        });
        bi.ls04ab11c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04ab11 = ls04ab11 + "5";
                ab11 =  settingAnswers( bi.ls04ab11,ls04ab11,ab11,ab11pattern);
            }
        });
        bi.ls04ab11d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04ab11 = ls04ab11 + "3";
                ab11 =  settingAnswers( bi.ls04ab11,ls04ab11,ab11,ab11pattern);
            }
        });
        bi.ls04ab11e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04ab11 = ls04ab11 + "6";
                ab11 =  settingAnswers( bi.ls04ab11,ls04ab11,ab11,ab11pattern);
            }
        });
        bi.ls04ab11x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04ab11 = ls04ab11 + "X";
                ab11 =  settingAnswers( bi.ls04ab11,ls04ab11,ab11,ab11pattern);
            }
        });

        /*  ls04ab12 */
        bi.ls04ab12a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04ab12 = ls04ab12 + "6";
                ab12 =  settingAnswers( bi.ls04ab12,ls04ab12,ab12,ab12pattern);
            }
        });
        bi.ls04ab12b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04ab12 = ls04ab12 + "4";
                ab12 =  settingAnswers( bi.ls04ab12,ls04ab12,ab12,ab12pattern);
            }
        });
        bi.ls04ab12c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04ab12 = ls04ab12 + "5";
                ab12 =  settingAnswers( bi.ls04ab12,ls04ab12,ab12,ab12pattern);
            }
        });
        bi.ls04ab12d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04ab12 = ls04ab12 + "2";
                ab12 =  settingAnswers( bi.ls04ab12,ls04ab12,ab12,ab12pattern);
            }
        });
        bi.ls04ab12e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04ab12 = ls04ab12 + "9";
                ab12 =  settingAnswers( bi.ls04ab12,ls04ab12,ab12,ab12pattern);
            }
        });
        bi.ls04ab12x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04ab12 = ls04ab12 + "X";
                ab12 =  settingAnswers( bi.ls04ab12,ls04ab12,ab12,ab12pattern);
            }
        });

    }

    int settingAnswers(TextView txtview,String txtValue, int answer, String pattern){

        txtview.setText(txtValue);
        if (!TextUtils.isEmpty(txtview.getText().toString())) {
            if (txtview.getText().toString().equals(pattern)) {
                answer = 1;
            } else {
                answer = 2;
            }
        }else {
            answer = 0;

        }
        return answer;
    }

    private void attachingListners() {
        /* Practice Trial*/
        /*       01     */
        /*    a     */
        bi.ls04aa01a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04aa01a = ls04aa01a + "3";
                skipPractice(bi.ls04aa01a, ls04aa01a, bi.fldgrpls04aa01b, aa01pattern,bi.ls04aa01b);

            }
        });
        bi.ls04aa01a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04aa01a = ls04aa01a + "7";
                skipPractice(bi.ls04aa01a, ls04aa01a, bi.fldgrpls04aa01b, aa01pattern,bi.ls04aa01b);

            }
        });
        bi.ls04aa01ax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04aa01a = ls04aa01a + "X";
                skipPractice(bi.ls04aa01a, ls04aa01a, bi.fldgrpls04aa01b, aa01pattern,bi.ls04aa01b);

            }
        });
        /*    b     */
        bi.ls04aa01b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04aa01b = ls04aa01b + "3";
                bi.ls04aa01b.setText(ls04aa01b);
            }
        });
        bi.ls04aa01b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04aa01b = ls04aa01b + "7";
                bi.ls04aa01b.setText(ls04aa01b);

            }
        });
        bi.ls04aa01bx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04aa01b = ls04aa01b + "X";
                bi.ls04aa01b.setText(ls04aa01b);
            }
        });

        /*      02            */
        /*       a      */
        bi.ls04aa02a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04aa02a = ls04aa02a + "6";
                skipPractice(bi.ls04aa02a, ls04aa02a, bi.fldgrpls04aa02b, aa02pattern,bi.ls04aa02b);
                if (bi.ls04aa01a.getText().toString().equals("37") && bi.ls04aa02a.getText().toString().equals("64")) {
                    bi.fldgrpll01.setVisibility(GONE);
                    bi.ls04aa03a.setText(null);
                    bi.ls04aa04a.setText(null);
                } else {
                    bi.fldgrpll01.setVisibility(VISIBLE);
                }

            }
        });
        bi.ls04aa02a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04aa02a = ls04aa02a + "4";
                skipPractice(bi.ls04aa02a, ls04aa02a, bi.fldgrpls04aa02b, aa02pattern,bi.ls04aa02b);
                if (bi.ls04aa01a.getText().toString().equals("37") && bi.ls04aa02a.getText().toString().equals("64")) {
                    bi.fldgrpll01.setVisibility(GONE);
                    bi.ls04aa03a.setText(null);
                    bi.ls04aa04a.setText(null);
                } else {
                    bi.fldgrpll01.setVisibility(VISIBLE);
                }
            }
        });
        bi.ls04aa02ax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04aa02a = ls04aa02a + "X";
                skipPractice(bi.ls04aa02a, ls04aa02a, bi.fldgrpls04aa02b, aa02pattern,bi.ls04aa02b);
                if (bi.ls04aa01a.getText().toString().equals("37") && bi.ls04aa02a.getText().toString().equals("64")) {
                    bi.fldgrpll01.setVisibility(GONE);
                    bi.ls04aa03a.setText(null);
                    bi.ls04aa04a.setText(null);
                } else {
                    bi.fldgrpll01.setVisibility(VISIBLE);
                }
            }
        });
        /*    b     */
        bi.ls04aa02b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04aa02b = ls04aa02b + "6";
                bi.ls04aa02b.setText(ls04aa02b);
            }
        });
        bi.ls04aa02b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04aa02b = ls04aa02b + "4";
                bi.ls04aa02b.setText(ls04aa02b);

            }
        });
        bi.ls04aa02bx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04aa02b = ls04aa02b + "X";
                bi.ls04aa02b.setText(ls04aa02b);
            }
        });

        /*      03    */
        /*     a    */
        bi.ls04aa03a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04aa03a = ls04aa03a + "3";
                skipPractice(bi.ls04aa03a, ls04aa03a, bi.fldgrpls04aa03b, aa03pattern,bi.ls04aa03b);

            }
        });
        bi.ls04aa03a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04aa03a = ls04aa03a + "7";
                skipPractice(bi.ls04aa03a, ls04aa03a, bi.fldgrpls04aa03b, aa03pattern, bi.ls04aa03b);

            }
        });
        bi.ls04aa03ax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04aa03a = ls04aa03a + "X";
                skipPractice(bi.ls04aa03a, ls04aa03a, bi.fldgrpls04aa03b, aa03pattern,bi.ls04aa03b);

            }
        });

        /*     b    */
        bi.ls04aa03b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04aa03b = ls04aa03b + "3";
                bi.ls04aa03b.setText(ls04aa03b);


            }
        });
        bi.ls04aa03b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04aa03b = ls04aa03b + "7";
                bi.ls04aa03b.setText(ls04aa03b);

            }
        });
        bi.ls04aa03bx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04aa03b = ls04aa03b + "X";
                bi.ls04aa03b.setText(ls04aa03b);

            }
        });


        /*    04    */
        /*   a    */
        bi.ls04aa04a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04aa04a = ls04aa04a + "6";
                skipPractice(bi.ls04aa04a, ls04aa04a, bi.fldgrpls04aa04b, aa04pattern,bi.ls04aa04b);
            }
        });
        bi.ls04aa04a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04aa04a = ls04aa04a + "4";
                skipPractice(bi.ls04aa04a, ls04aa04a, bi.fldgrpls04aa04b, aa04pattern,bi.ls04aa04b);
            }
        });
        bi.ls04aa04ax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04aa04a = ls04aa04a + "X";
                skipPractice(bi.ls04aa04a, ls04aa04a, bi.fldgrpls04aa04b, aa04pattern,bi.ls04aa04b);

            }
        });
        /*   b    */
        bi.ls04aa04b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04aa04b = ls04aa04b + "6";
                bi.ls04aa04b.setText(ls04aa04b);

            }
        });
        bi.ls04aa04b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04aa04b = ls04aa04b + "4";
                bi.ls04aa04b.setText(ls04aa04b);

            }
        });
        bi.ls04aa04bx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls04aa04b = ls04aa04b + "X";
                bi.ls04aa04b.setText(ls04aa04b);
            }
        });


    }

    private static String removeLastChar(String str) {
        return str.substring(0, str.length() - 1);
    }

    public void BtnContinue() {

    }

    public void BtnEnd() {

    }

    public boolean isConditionSatisfied(int a, int b, int c) {
        if(Objects.equals(a, 1) && Objects.equals(b, 1)){
            return true;
        }else if(Objects.equals(b, 1) && Objects.equals(c, 1)){
            return true;
        }else if(Objects.equals(a, 1) && Objects.equals(c, 1)){
            return true;
        }else {
            return false;
        }
//        return Objects.equals(a, b) || Objects.equals(b, c) || Objects.equals(a, c);
    }

    public void skipPractice(TextView txtview, String response, android.support.v7.widget.CardView fldGrp, String pattern, TextView nextTxtView) {
        txtview.setText(response);
        if (txtview.getText().toString().equals(pattern)) {
            fldGrp.setVisibility(View.GONE);
//            txtview.setText(null);
            nextTxtView.setText(null);
        } else {
            fldGrp.setVisibility(View.VISIBLE);

        }

    }
   /* public void processButton(View v) {

       android.widget.Button b = (android.widget.Button) v;
       // Check question
       String qID = getResources().getResourceEntryName(v.getId());
       qID = qID.substring(0, qID.length() - 1);

       TextView tv = (TextView)findViewById(getResources().getIdentifier(qID, "id", getPackageName()));
       String btnPressed = b.getText().toString();
       switch (btnPressed){

           case "3":

               ls04aa01a = ls04aa01a + btnPressed;
               skipPractice(bi.ls04aa01a, ls04aa01a, bi.fldgrpls04aa01b, aa01pattern,bi.ls04aa01b);


       }


   }*/
}
