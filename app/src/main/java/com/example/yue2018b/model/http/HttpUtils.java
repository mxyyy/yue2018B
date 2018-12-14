package com.example.yue2018b.model.http;

import android.util.Log;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
public class HttpUtils {

    public final Api api;

    public HttpUtils() {
        OkHttpClient client = new OkHttpClient.Builder().addNetworkInterceptor(new logging()).build();
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(Contast.url)
                .client(client)
                .build();
        api = retrofit.create(Api.class);
    }
    //日志拦截器
    class  logging implements Interceptor{
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Log.d("aaa","request"+request);
            Response response = chain.proceed(request);
            return response;
        }
    }
     private static class getInstance{
        private static HttpUtils httpUtils=new HttpUtils();
     }
     public static HttpUtils instance(){
        return getInstance.httpUtils;
     }

}
