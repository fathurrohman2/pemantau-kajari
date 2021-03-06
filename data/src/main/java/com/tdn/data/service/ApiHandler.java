package com.tdn.data.service;

import android.util.Log;

import java.util.Objects;

/*
 * author Trian Damai
 * 04 august 2020
 * TODO :: this is service
 * */
public class ApiHandler {
    private static final String TAG = "ApiHandler";

    public static boolean cek(int res) {
        try {
            if (res == Integer.parseInt("200")) {
                Log.d(TAG, "response code = 200 : ");
                return true;
            } else if (res == Integer.parseInt("400")) {
                Log.d(TAG, "response code = 400 : ");
                return false;
            } else if (res == Integer.parseInt("401")) {
                Log.d(TAG, "response code = 401 : ");
                return false;
            } else if (res == Integer.parseInt("404")) {
                Log.d(TAG, "response code = 404 : ");
                return false;
            } else if (res == Integer.parseInt("500")) {
                Log.d(TAG, "response code = 500 : ");
                return false;
            } else {
                Log.d(TAG, "response code = Tidak diketahui : ");
                return false;
            }
        } catch (NullPointerException | NumberFormatException e) {
            Log.e(TAG, Objects.requireNonNull(e.getMessage()));
            return false;
        }

    }

    public static boolean cek(String res) {
        try {
            if (res.equalsIgnoreCase("200")) {
                Log.d(TAG, "response code = 200 : ");
                return true;
            } else if (res.equalsIgnoreCase("400")) {
                Log.d(TAG, "response code = 400 : ");
                return false;
            } else if (res.equalsIgnoreCase("401")) {
                Log.d(TAG, "response code = 401 : ");
                return false;
            } else if (res.equalsIgnoreCase("404")) {
                Log.d(TAG, "response code = 404 : ");
                return false;
            } else if (res.equalsIgnoreCase("500")) {
                Log.d(TAG, "response code = 500 : ");
                return false;
            } else {
                Log.d(TAG, "response code = Tidak diketahui : ");
                return false;
            }
        } catch (NullPointerException e) {
            Log.e(TAG, Objects.requireNonNull(e.getMessage()));
            return false;
        }

    }

    public static boolean cek(int code, String res) {
        try {
            if (cek(code)) {
                if (cek(res)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (NullPointerException e) {
            Log.e(TAG, Objects.requireNonNull(e.getMessage()));
            return false;
        }

    }

    public static boolean cek(int code, int res) {
        try {
            if (cek(code)) {
                if (cek(res)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (NullPointerException e) {
            Log.e(TAG, Objects.requireNonNull(e.getMessage()));
            return false;
        }

    }
}
