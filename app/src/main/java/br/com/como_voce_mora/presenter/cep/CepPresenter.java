package br.com.como_voce_mora.presenter.cep;

import br.com.como_voce_mora.api.BaseCallBack;
import br.com.como_voce_mora.model.CepResponse;
import br.com.como_voce_mora.model.ResponseError;
import br.com.como_voce_mora.repository.viacep.CepRepository;

public class CepPresenter implements CepContract.Presenter {

    private CepContract.View mView;
    private CepRepository mRepository;

    public CepPresenter(CepContract.View mView) {
        this.mView = mView;
        mRepository = new CepRepository();
    }

    @Override
    public void getCep(String cep) {
        mView.showLaoding();
        mRepository.getCep(cep, new BaseCallBack<CepResponse>() {
            @Override
            public void onSuccess(CepResponse response) {
                mView.hideLoading();
                if (response != null) {
                    mView.presentData(response);
                } else {
                    mView.showError();
                }
            }

            @Override
            public void onError(ResponseError error) {
                mView.hideLoading();
                mView.showError();
            }
        });
    }
}
