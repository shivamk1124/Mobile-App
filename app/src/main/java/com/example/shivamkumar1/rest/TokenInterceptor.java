package com.example.shivamkumar1.rest;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class TokenInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request newRequest=chain.request().newBuilder()
                .header("Authorization","Bearer 786785e9-1b74-430a-80d9-aae49678954f")
                .build();

        return chain.proceed(newRequest);
    }
}
