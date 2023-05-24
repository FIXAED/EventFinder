package com.moc.eventfinder.controller.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.moc.eventfinder.R;

public class SplashScreenActivity extends AppCompatActivity {

    private String SAVED_CITY = "CITY";
    private String FLAG = "FLAG";
    SharedPreferences prefs;
    public static final String APP_PREFERENCES = "APP_PREFERENCES";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefs = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
////        if (loadData()) {
//            Intent intent = new Intent(this, MainActivity.class);
//            startActivity(intent);
//            finish();
//        }else {
        Intent intent = new Intent(this, StartActivity.class);
        startActivity(intent);
        finish();
//        }
    }
}




//    public boolean loadData() {
//        prefs = getPreferences(MODE_PRIVATE);
//        boolean flag = prefs.getBoolean(FLAG, false);
//        Toast.makeText(this, String.valueOf(flag), Toast.LENGTH_LONG).show();
//        return flag;
//    }
//}