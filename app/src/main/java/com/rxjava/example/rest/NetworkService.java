package com.rxjava.example.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rxjava.example.common.LongToTimestampDeserializer;

import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ragashree on 10/12/18.
 */

public class NetworkService {
    public static final String API_KEY = "YnjYUKBcfOCGG2C";
    private NetworkApi networkApi;
    //Testing Server // GulfOil
    public static final String BASE_URL = "https://www.thecrazyprogrammer.com/";
    public NetworkService(){
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .enableComplexMapKeySerialization()
                .registerTypeAdapter(Timestamp.class, new LongToTimestampDeserializer())
                .create();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.addInterceptor(logging);
        okHttpClient.readTimeout(60, TimeUnit.SECONDS);
        okHttpClient.writeTimeout(60,TimeUnit.SECONDS);

        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient.build()).build();

        networkApi = retrofit.create(NetworkApi.class);
    }

    public NetworkApi getNetworkAPI(){
        return networkApi;
    }
}
