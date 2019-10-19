package br.com.como_voce_mora.api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiCreator {
    public static String API_BASE_URL = "http://200.131.206.11:8080/api/mobile/";

    private static OkHttpClient httpClient = RetrofitSetup.getOkHttpClient();

    private static Retrofit.Builder builder = new Retrofit.Builder()
        .baseUrl(API_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create());

    public static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = builder.client(httpClient).build();
        return retrofit.create(serviceClass);
    }
}