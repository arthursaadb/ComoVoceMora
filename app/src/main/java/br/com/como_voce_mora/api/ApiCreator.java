package br.com.como_voce_mora.api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiCreator {
    public static String API_BASE_URL = "http://200.131.206.11:8080/api/mobile/";
    public static String API_VIACEP_URL = "http://viacep.com.br/ws/";

    private static OkHttpClient httpClient = RetrofitSetup.getOkHttpClient();

    private static Retrofit.Builder builder = new Retrofit.Builder()
        .baseUrl(API_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit.Builder cepBuilder = new Retrofit.Builder()
        .baseUrl(API_VIACEP_URL)
        .addConverterFactory(GsonConverterFactory.create());

    public static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = builder.client(httpClient).build();
        return retrofit.create(serviceClass);
    }

    public static <S> S createServiceCep(Class<S> serviceClass) {
        Retrofit retrofit = cepBuilder.client(httpClient).build();
        return retrofit.create(serviceClass);
    }



}