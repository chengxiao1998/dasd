package com.bwie.myokhttp.demo;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by rookie on 2018/1/24.
 */
public class NetInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        String url = request.url().toString();
        Log.i("t", "request url===" + url);
        Response response = chain.proceed(request);
        if (response.isSuccessful()) {
            Log.i("t", "response result===" + response.body().string());
        }
        return chain.proceed(request);
    }
}
