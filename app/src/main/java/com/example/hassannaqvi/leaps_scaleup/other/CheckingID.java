package com.example.hassannaqvi.leaps_scaleup.other;

import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hassannaqvi.leaps_scaleup.data.AppDatabase;
import com.example.hassannaqvi.leaps_scaleup.data.DAO.GetFncDAO;
import com.example.hassannaqvi.leaps_scaleup.get.db.GetIndDBData;

import java.util.concurrent.ExecutionException;

public abstract class CheckingID {

    public static boolean getIDValidation(AppDatabase db, Context mContext, EditText idTXT, String formType) {
        String txt = idTXT.getText().toString();

        try {

            if (txt.length() != 5) {
                Toast.makeText(mContext, "Invalid Length!!", Toast.LENGTH_SHORT).show();
                idTXT.setError("Invalid Length!!");
                return false;
            } else if (Integer.valueOf(txt) <= 10100 || Integer.valueOf(txt) > 89903) {
                Toast.makeText(mContext, "ID range must be 10101 - 89903!!", Toast.LENGTH_SHORT).show();
                idTXT.setError("ID range must be 10101 - 89903!!");
                return false;
            }

            switch (formType) {
                case "1a":
                case "2a":
                    if (!validateID(mContext, idTXT, Character.getNumericValue(txt.charAt(0)), 1, 4, "Start digit")) {
                        return false;
                    }
                    break;
                case "1b":
                case "2b":
                    if (!validateID(mContext, idTXT, Character.getNumericValue(txt.charAt(0)), 6)) {
                        return false;
                    }
                    break;
                case "4":
                case "5":
                case "6":
                    if (!validateID(mContext, idTXT, Character.getNumericValue(txt.charAt(0)), 1, 6, "Start digit")) {
                        return false;
                    }
                    break;
                case "7":
                case "8":
                case "9":
                    if (!validateID(mContext, idTXT, Character.getNumericValue(txt.charAt(0)), 8)) {
                        return false;
                    }
                    break;
            }

            String clsID = txt.substring(1, 3);
//            Class<Clusters> cluster = (Class<Clusters>) new GetIndDBData(db, GetFncDAO.class.getName(), "getFncDao", "getClusterRecord", 1).execute(clsID).get();
            Object cluster = new GetIndDBData(db, GetFncDAO.class.getName(), "getFncDao", "getClusterRecord").execute(clsID).get();

            if (cluster == null) {
                Toast.makeText(mContext, "Invalid Cluster!!", Toast.LENGTH_SHORT).show();
                idTXT.setError("Invalid Cluster!!");
                return false;
            }

            String lstDigits = txt.substring(txt.length() - 2, txt.length());

            if (lstDigits.equals("00")) {
                Toast.makeText(mContext, "Last digits can't be 00!!", Toast.LENGTH_SHORT).show();
                idTXT.setError("Invalid Cluster!!");
                return false;
            }

            switch (formType) {
                case "4":
                    return validateID(mContext, idTXT, Integer.valueOf(lstDigits), 1, 11, "Last digits");
                case "6":
                    return validateID(mContext, idTXT, Integer.valueOf(lstDigits), 1, 8, "Last digits");
                case "8":
                    return validateID(mContext, idTXT, Integer.valueOf(lstDigits), 1, 3, "Last digits");
            }

            return true;

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return false;
    }

    private static boolean validateID(Context mContext, EditText txt, int digits, int max) {
        if (digits != max) {
            Toast.makeText(mContext, "Start digit must be " + max + " !!", Toast.LENGTH_SHORT).show();
            txt.setError("Invalid Start Digits!!");
            return false;
        }

        return true;
    }

    private static boolean validateID(Context mContext, EditText txt, int digits, int min, int max, String msg) {
        if (digits < min || digits > max) {
            Toast.makeText(mContext, msg + " range must be > 00 && <= " + max + " !!", Toast.LENGTH_SHORT).show();
            txt.setError("Invalid " + msg + "!!");
            return false;
        }

        return true;
    }

}
