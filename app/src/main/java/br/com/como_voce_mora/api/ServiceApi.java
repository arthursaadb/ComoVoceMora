package br.com.como_voce_mora.api;

import br.com.como_voce_mora.model.DwellerId;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;

public interface ServiceApi {
    @GET("getdwellerId")
    public Call<DwellerId> getUserData();
}
