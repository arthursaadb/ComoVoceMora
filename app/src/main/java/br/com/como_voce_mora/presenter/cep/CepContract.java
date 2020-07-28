package br.com.como_voce_mora.presenter.cep;

import br.com.como_voce_mora.model.CepResponse;

public class CepContract {
    interface Presenter {
        void getCep(String cep);
    }

    public interface View {
        void showLaoding();

        void hideLoading();

        void showError();

        void presentData(CepResponse cepResponse);
    }
}
