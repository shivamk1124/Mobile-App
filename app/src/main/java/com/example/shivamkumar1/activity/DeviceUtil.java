package com.example.shivamkumar1.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class DeviceUtil {
  public  static   ProgressDialog prgLoading = null;


    public static boolean isNetworkAvailable(Activity activity, Context context) {
        context = context != null ? context : activity;
        boolean HaveConnectedWifi = false;
        boolean HaveConnectedMobile = false;
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                    HaveConnectedWifi = true;
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected()) {
                    HaveConnectedMobile = true;
                }

        }
        return HaveConnectedWifi || HaveConnectedMobile;
    }

    public static void showLoading(String msg, Context context) {

        if (prgLoading != null && prgLoading.isShowing())
            prgLoading.setMessage(msg);
        else
            prgLoading = ProgressDialog.show(context, "", msg);

    }

    public static void hideLoading() {

        try {
            if (prgLoading != null && prgLoading.isShowing()) {
                prgLoading.dismiss();
                // prgLoading.cancel();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
