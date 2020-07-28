package br.com.como_voce_mora.repository.viacep;

import br.com.como_voce_mora.api.ApiCreator;
import br.com.como_voce_mora.api.BaseCallBack;
import br.com.como_voce_mora.api.CepApi;
import br.com.como_voce_mora.model.CepResponse;

public class CepRepository implements ViaCep {

    @Override
    public void getCep(String cep, BaseCallBack<CepResponse> baseCallBack) {
        ApiCreator.createServiceCep(CepApi.class).getCep(cep).enqueue(baseCallBack);
    }
}
