package com.bwie.myokhttp.demo;

import android.util.Log;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by rookie on 2018/1/24.
 */
public class AppInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        HttpUrl httpUrl = request.url();
        String url = httpUrl.url().toString();
        StringBuffer sb = new StringBuffer();
        if (url.lastIndexOf("?") != -1) {

        }
        sb.append(url);
        sb.append("platform")
                .append("=")
                .append("android");
        request.newBuilder().url(sb.toString());
        Log.i("t", "url===" + sb.toString());
        return chain.proceed(request);
    }
}
