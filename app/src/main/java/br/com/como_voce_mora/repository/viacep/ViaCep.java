package br.com.como_voce_mora.repository.viacep;

import br.com.como_voce_mora.api.BaseCallBack;
import br.com.como_voce_mora.model.CepResponse;

public interface ViaCep {
    void getCep(String cep, BaseCallBack<CepResponse> baseCallBack);
}
