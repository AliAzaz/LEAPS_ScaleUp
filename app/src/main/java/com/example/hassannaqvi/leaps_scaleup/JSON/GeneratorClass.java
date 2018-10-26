package com.example.hassannaqvi.leaps_scaleup.JSON;

import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.hassannaqvi.leaps_scaleup.validation.validatorClass;

import org.json.JSONException;
import org.json.JSONObject;

public abstract class GeneratorClass {

    private static JSONObject formJSON;

    public static JSONObject getContainerJSON(LinearLayout lv, boolean flag) {

        if (flag)
            formJSON = new JSONObject();

        try {

            for (int i = 0, count = lv.getChildCount(); i < count; ++i) {
                View view = lv.getChildAt(i);

                if (view instanceof CardView) {
                    for (int j = 0; j < ((CardView) view).getChildCount(); j++) {
                        View view1 = ((CardView) view).getChildAt(j);
                        if (view1 instanceof LinearLayout) {
                            getContainerJSON((LinearLayout) view1, false);
                        }
                    }
                } else if (view instanceof RadioGroup) {

                    RadioGroup rdp = (RadioGroup) view;
                    String rdpID = validatorClass.getIDComponent(rdp);
                    int rdbID = rdp.getCheckedRadioButtonId();

                    if (rdbID != -1) {

                        for (byte j = 0; j < ((RadioGroup) view).getChildCount(); j++) {

                            if (rdbID == ((RadioGroup) view).getChildAt(j).getId()) {

                                RadioButton rdb = rdp.findViewById(((RadioGroup) view).getChildAt(j).getId());

                                formJSON.put(rdpID, getValues(validatorClass.getIDComponent(rdb)));

                                break;
                            }

                        }
                    } else {
                        formJSON.put(rdpID, "0");
                    }
                } else if (view instanceof EditText) {
                    String edtID = validatorClass.getIDComponent(view);
                    formJSON.put(edtID, getValues(edtID));
                } else if (view instanceof CheckBox) {
                    if (((CheckBox) view).isChecked()) {
                        String chkID = validatorClass.getIDComponent(view);
                        formJSON.put(chkID, getValues(chkID));
                    }
                } else if (view instanceof Spinner) {
                    if (((Spinner) view).getSelectedItemPosition() != 0) {
                        String spID = validatorClass.getIDComponent(view);
                        formJSON.put(spID, ((Spinner) view).getSelectedItem());
                    }
                }

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return formJSON;
    }

    private static String getValues(String nameconv) {

        if (nameconv.length() > 0) {

            String str = nameconv.substring(nameconv.length() - (nameconv.length() >= 2 ? 2 : 1)
                    , nameconv.length());

            char[] str_str = str.toCharArray();

            switch (str) {
                case "01":
                    return "1";
                case "02":
                    return "2";
                case "03":
                    return "3";
                case "04":
                    return "4";
                case "88":
                    return "88";
                case "99":
                    return "99";
                default: {
                    switch (str_str[str.length() - 1]) {
                        case 'a':
                            return "1";
                        case 'b':
                            return "2";
                        case 'c':
                            return "3";
                        case 'd':
                            return "4";
                        default:
                            return "0";
                    }
                }
            }

        } else {
            return "";
        }
    }

}
