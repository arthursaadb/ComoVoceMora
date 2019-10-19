package br.com.como_voce_mora.api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public class RetrofitSetup {
    private static final String TAG = RetrofitSetup.class.getSimpleName();
    private static final int TIME_OUT = 300;

    public static final OkHttpClient getOkHttpClient() {
        OkHttpClient.Builder okHttpClient = new OkHttpClient().newBuilder();
        okHttpClient.addInterceptor(getLoggingInterceptor());
        okHttpClient.connectTimeout(TIME_OUT, TimeUnit.SECONDS);
        okHttpClient.readTimeout(TIME_OUT, TimeUnit.SECONDS);


        return okHttpClient.build();
    }

    private static HttpLoggingInterceptor getLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }
}
