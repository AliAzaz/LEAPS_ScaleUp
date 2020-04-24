package com.example.hassannaqvi.leaps_scaleup.JSON;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.cardview.widget.CardView;

import com.example.hassannaqvi.leaps_scaleup.R;
import com.example.hassannaqvi.leaps_scaleup.validation.validatorClass;

import org.json.JSONException;
import org.json.JSONObject;

import io.blackbox_vision.datetimepickeredittext.view.DatePickerInputEditText;

public abstract class GeneratorClass {

    private static JSONObject formJSON;

    public static JSONObject getContainerJSON(LinearLayout lv, boolean flag, String... convention) {

        if (flag)
            formJSON = new JSONObject();

        try {

            for (int i = 0; i < lv.getChildCount(); i++) {
                View view = lv.getChildAt(i);

                String assig_id = convention.length > 0 ? convention[0] : "";

                if (view instanceof CardView) {
                    for (int j = 0; j < ((CardView) view).getChildCount(); j++) {
                        View view1 = ((CardView) view).getChildAt(j);
                        if (view1 instanceof LinearLayout) {
                            getContainerJSON((LinearLayout) view1, false, assig_id);
                        }
                    }
                } else if (view instanceof RadioGroup) {

                    RadioGroup rdp = (RadioGroup) view;
                    assig_id += validatorClass.getIDComponent(rdp);
                    int rdbID = rdp.getCheckedRadioButtonId();

                    if (rdbID != -1) {

                        for (byte j = 0; j < ((RadioGroup) view).getChildCount(); j++) {

                            if (rdbID == ((RadioGroup) view).getChildAt(j).getId()) {

                                RadioButton rdb = rdp.findViewById(((RadioGroup) view).getChildAt(j).getId());

                                formJSON.put(assig_id, getValues(validatorClass.getIDComponent(rdb)));

                                break;
                            }

                        }
                    } else {
                        formJSON.put(assig_id, "0");
                    }
                } else if (view instanceof io.blackbox_vision.datetimepickeredittext.view.DatePickerInputEditText) {
                    assig_id += validatorClass.getIDComponent(view);
                    formJSON.put(assig_id, ((DatePickerInputEditText) view).getText().toString());
                } else if (view instanceof EditText) {
                    assig_id += validatorClass.getIDComponent(view);
                    formJSON.put(assig_id, ((EditText) view).getText().toString());
                } else if (view instanceof CheckBox) {
                    assig_id += validatorClass.getIDComponent(view);
                    if (((CheckBox) view).isChecked()) {
                        formJSON.put(assig_id, getValues(assig_id));
                    } else {
                        formJSON.put(assig_id, "0");
                    }
                } else if (view instanceof Spinner) {
                    assig_id += validatorClass.getIDComponent(view);
                    if (((Spinner) view).getSelectedItemPosition() != 0) {
                        formJSON.put(assig_id, ((Spinner) view).getSelectedItem());
                    } else {
                        formJSON.put(assig_id, "");
                    }
                }

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return formJSON;
    }

    public static JSONObject getContainerJSON(Context context, LinearLayout lv, boolean flag, JSONObject formJSON, String... convention) {

        if (flag)
            formJSON = new JSONObject();

        try {

            for (int i = 0; i < lv.getChildCount(); i++) {
                View view = lv.getChildAt(i);

                String assig_id = convention.length > 0 ? convention[0] : "";

                if (view instanceof CardView) {
                    for (int j = 0; j < ((CardView) view).getChildCount(); j++) {
                        View view1 = ((CardView) view).getChildAt(j);
                        if (view1 instanceof LinearLayout) {
                            getContainerJSON(context, (LinearLayout) view1, false, formJSON, assig_id);
                        }
                    }
                } else if (view instanceof LinearLayout) {
                    for (int j = 0; j < ((LinearLayout) view).getChildCount(); j++) {
                        View view1 = ((LinearLayout) view).getChildAt(j);
                        if (view1 instanceof LinearLayout) {
                            getContainerJSON(context, (LinearLayout) view1, false, formJSON, assig_id);
                        }
                    }
                } else if (view instanceof RadioGroup) {

                    RadioGroup rdp = (RadioGroup) view;
                    assig_id += validatorClass.getIDComponent(rdp);
                    int rdbID = rdp.getCheckedRadioButtonId();

                    if (rdbID != -1) {

                        for (byte j = 0; j < ((RadioGroup) view).getChildCount(); j++) {

                            if (rdbID == ((RadioGroup) view).getChildAt(j).getId()) {

                                RadioButton rdb = rdp.findViewById(((RadioGroup) view).getChildAt(j).getId());

                                formJSON.put(assig_id, getValues(validatorClass.getIDComponent(rdb)));

                                break;
                            }

                        }
                    } else {
                        formJSON.put(assig_id, "0");
                    }
                } else if (view instanceof io.blackbox_vision.datetimepickeredittext.view.DatePickerInputEditText) {
                    assig_id += validatorClass.getIDComponent(view);
                    formJSON.put(assig_id, ((DatePickerInputEditText) view).getText().toString());
                } else if (view instanceof EditText) {
                    /*altering as per needed*/
                    assig_id += validatorClass.getIDComponent(view);
                    String edtxtValue = ((EditText) view).getText().toString();
                    if (edtxtValue.equals(context.getResources().getString(R.string.blue))) {
                        formJSON.put(assig_id, "1");
                    } else if (edtxtValue.equals(context.getResources().getString(R.string.star))) {
                        formJSON.put(assig_id, "1");
                    } else if (edtxtValue.equals(context.getResources().getString(R.string.bluestar))) {
                        formJSON.put(assig_id, "1");
                    } else if (edtxtValue.equals(context.getResources().getString(R.string.red))) {
                        formJSON.put(assig_id, "2");
                    } else if (edtxtValue.equals(context.getResources().getString(R.string.truck))) {
                        formJSON.put(assig_id, "2");
                    } else if (edtxtValue.equals(context.getResources().getString(R.string.redtruck))) {
                        formJSON.put(assig_id, "2");
                    } else if (edtxtValue.equals(context.getResources().getString(R.string.other))) {
                        formJSON.put(assig_id, "96");
                    } else if (edtxtValue.equals(context.getResources().getString(R.string.ls04ignore))) {
                        formJSON.put(assig_id, "99");
                    } else {
                        formJSON.put(assig_id, "0");
                    }

                } else if (view instanceof CheckBox) {
                    assig_id += validatorClass.getIDComponent(view);
                    if (((CheckBox) view).isChecked()) {
                        formJSON.put(assig_id, getValues(assig_id));
                    } else {
                        formJSON.put(assig_id, "0");
                    }
                } else if (view instanceof Spinner) {
                    assig_id += validatorClass.getIDComponent(view);
                    if (((Spinner) view).getSelectedItemPosition() != 0) {
                        formJSON.put(assig_id, ((Spinner) view).getSelectedItem());
                    } else {
                        formJSON.put(assig_id, "");
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
            );

            char[] str_str = str.toLowerCase().toCharArray();

            if (str.charAt(str.length() - 1) <= '9') {
                return String.valueOf(Integer.parseInt(str));
            } else {

                String ascii_letters = "abcdefghijklmnopqrstuvwxyz";

                for (byte i = 0; i < ascii_letters.length(); i++) {
                    if (str_str[str.length() - 1] == ascii_letters.charAt(i)) {
                        return String.valueOf(i + 1);
                    }
                }

                return "0";

            }
        } else {
            return "";
        }
    }

}
