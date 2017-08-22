package com.example.z021722.myapplication;

import android.app.Application;

/**
 * Created by z021722 on 09-08-2017.
 */

public class MyApplication extends Application {

    public boolean loadAsFragments = false;
    public boolean loadViewsByFragment = false;

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
