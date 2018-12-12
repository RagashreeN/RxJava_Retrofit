package com.rxjava.example.rest;


import com.rxjava.example.adapter.EmployeeResponse;


import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by ragashree on 10/12/18.
 */

public interface NetworkApi {

    @GET("example_data/fruits_array.json")
    Observable<EmployeeResponse> loginUser();
}
