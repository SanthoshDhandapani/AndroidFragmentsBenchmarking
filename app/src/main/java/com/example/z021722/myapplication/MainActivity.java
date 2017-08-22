package com.example.z021722.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyApplication myApplication = (MyApplication) getApplication();
        if(myApplication.loadAsFragments) {
            Presenter.navigateToFragment =true;
            Presenter.loadByFragment(this);
        } else if(myApplication.loadViewsByFragment) {
            Presenter.loadByFragment(this);
        } else {
            Presenter.loadViews(null, this);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onBackPressed() {
        List<Fragment> fragmentList = getSupportFragmentManager().getFragments();
        if(fragmentList!=null && fragmentList.size()>1) {
            getSupportFragmentManager().beginTransaction().remove(fragmentList.get(fragmentList.size()-1)).commit();
        } else {
            super.onBackPressed();
        }
    }
}
