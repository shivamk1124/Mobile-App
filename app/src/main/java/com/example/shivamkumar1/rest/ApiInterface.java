package com.example.shivamkumar1.rest;


import com.example.shivamkumar1.model.Example;
import com.example.shivamkumar1.model.ExamplePurchase;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface ApiInterface {
    @GET("bdcbafbc1f4197dda178b9e69f6ccee9/techAlchemyDeveloperTest1/allEvents")
    Call<Example> getallEvents();


    @GET("bdcbafbc1f4197dda178b9e69f6ccee9/techAlchemyDeveloperTest1/eventDetails")
    Call<Example> getEventDetail();

    @POST("bdcbafbc1f4197dda178b9e69f6ccee9/techAlchemyDeveloperTest1/purchase")
    Call<Example> sendPurchaseDetail(@Body ExamplePurchase example);



}
