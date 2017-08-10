package com.example.z021722.myapplication;

import android.app.Application;

/**
 * Created by z021722 on 09-08-2017.
 */

public class MyApplication extends Application {

    public boolean loadFragmentsList = false;
    public boolean loadViewsByFragment = true;

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
