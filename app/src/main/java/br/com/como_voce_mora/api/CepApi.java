package br.com.como_voce_mora.api;

import br.com.como_voce_mora.model.CepResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CepApi {

    @GET("{cep}/json")
    public Call<CepResponse> getCep(@Path("cep") String cep);
}
