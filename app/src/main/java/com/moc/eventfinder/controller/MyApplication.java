package com.moc.eventfinder.controller;

import android.app.Application;

import com.yandex.mapkit.MapKitFactory;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        MapKitFactory.setApiKey("1cdbfa33-1749-4f74-b813-a7705a70ca16");
    }
}