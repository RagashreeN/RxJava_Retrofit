package com.rxjava.example.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.rxjava.example.R;
import com.rxjava.example.adapter.EmployeeResponse;
import com.rxjava.example.common.RxApplication;


import org.reactivestreams.Subscriber;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.textview)
    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    public Observable<EmployeeResponse> getResponse() {
        /*return Observable.defer(new Func0<Observable<EmployeeResponse>>() {
            @Override
            public Observable<EmployeeResponse> call() {
                try {
                    return Observable.just(getResponseValue());
                } catch (Exception ex) {
                    ex.printStackTrace();
                    return null;
                }
            }
        });*/

        return RxApplication.networkService.getNetworkAPI().loginUser();
    }

   /* @Nullable
    public EmployeeResponse getResponseValue() throws IOException {
        *//*OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://www.thecrazyprogrammer.com/example_data/fruits_array.json")
                .build();

        Response response = okHttpClient.newCall(request).execute();
        //Toast.makeText(this,response.body().string(),Toast.LENGTH_SHORT).show();
        if (response.isSuccessful()) {
            EmployeeResponse employeeResponse = new Gson().fromJson(response.body().toString(), EmployeeResponse.class);
            return employeeResponse;
        }
        return null;*//*

        //return RxApplication.networkService.getNetworkAPI().loginUser();


    }*/

    @OnClick(R.id.button)
    public void onViewClicked() {

        /*subscription = getResponse().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<EmployeeResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        textview.setText("Error");
                    }

                    @Override
                    public void onNext(EmployeeResponse employeeResponse) {
                        textview.setText(employeeResponse.getFruits().get(0));
                    }
                });*/

        /*Observable.merge(getResponse()).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(this.handleResult(),this.handleError());*/

        getResponse().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        .subscribeWith(new DisposableObserver<EmployeeResponse>() {
            @Override
            public void onNext(EmployeeResponse employeeResponse) {
                textview.setText(employeeResponse.getFruits().get(0));
            }

            @Override
            public void onError(Throwable e) {
                textview.setText("Error");
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
