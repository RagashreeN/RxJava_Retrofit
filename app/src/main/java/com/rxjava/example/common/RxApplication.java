package com.rxjava.example.common;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rxjava.example.rest.NetworkService;

import java.sql.Timestamp;

/**
 * Created by ragashree on 10/12/18.
 */

public class RxApplication extends Application{

    public static NetworkService networkService;
    @Override
    public void onCreate() {
        super.onCreate();

        networkService = new NetworkService();
    }

}
