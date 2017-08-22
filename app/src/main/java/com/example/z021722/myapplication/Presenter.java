package com.example.z021722.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * Created by z021722 on 09-08-2017.
 */

public class Presenter {

    static boolean navigateToFragment;

    public static void loadViews(View rootView, final AppCompatActivity appCompatActivity) {
        Toolbar toolbar = appCompatActivity.findViewById(R.id.toolbar);
        appCompatActivity.setSupportActionBar(toolbar);

        FloatingActionButton fab = appCompatActivity.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ScrollView scrollView= new ScrollView(appCompatActivity);
        LinearLayout mainLayout = new LinearLayout(appCompatActivity);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        String screenName = !navigateToFragment?appCompatActivity.getClass().getSimpleName()
                                                :"Fragment "+appCompatActivity.getSupportFragmentManager().getFragments().size();
        TextView titleView =new TextView(appCompatActivity);
        titleView.setPadding(0,0,0,15);
        titleView.setText(screenName);
        mainLayout.addView(titleView);
        for (int i=0; i<10; i++){
            LinearLayout ll = new LinearLayout(appCompatActivity);
            ll.setOrientation(LinearLayout.HORIZONTAL);
            ll.setTag(i);
            TextView tv=new TextView(appCompatActivity);
            tv.setText("Row " + i);
            ll.addView(tv);
            Button b = new Button(appCompatActivity);
            b.setTag(i);
            b.setText("Button " + i);
            ll.addView(b);
            mainLayout.addView(ll);
        }
        mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!navigateToFragment) {
                    Intent intent = new Intent(appCompatActivity, getDestinationActivity(appCompatActivity).getClass());
                    appCompatActivity.startActivity(intent);
                } else {
                    loadByFragment(appCompatActivity);
                }
            }
        });
        scrollView.addView(mainLayout);

        ViewGroup container = (ViewGroup)((rootView==null)?appCompatActivity.findViewById(R.id.container):rootView);
        container.addView(scrollView);
    }

    public static void loadByFragment(AppCompatActivity appCompatActivity) {
        MainActivityFragment mainActivityFragment = new MainActivityFragment();
        appCompatActivity.getSupportFragmentManager().beginTransaction().add(R.id.container, mainActivityFragment, MainActivityFragment.class.getSimpleName()).commit();
    }

    private static AppCompatActivity getDestinationActivity(AppCompatActivity srcActivity) {
        AppCompatActivity destinationActivity = null;
        String srcClassName = srcActivity.getClass().getSimpleName();
        if(srcClassName.equals(MainActivity.class.getSimpleName())) {
            destinationActivity = new ActivityB();
        } else if(srcClassName.equals(ActivityB.class.getSimpleName())) {
            destinationActivity = new ActivityC();
        } else if(srcClassName.equals(ActivityC.class.getSimpleName())) {
            destinationActivity = new ActivityD();
        } else if(srcClassName.equals(ActivityD.class.getSimpleName())) {
            destinationActivity = new MainActivity();
        }
        return destinationActivity;
    }
}
