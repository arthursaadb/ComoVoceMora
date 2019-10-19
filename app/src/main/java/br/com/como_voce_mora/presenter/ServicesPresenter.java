package br.com.como_voce_mora.presenter;

import br.com.como_voce_mora.ResponseError;
import br.com.como_voce_mora.api.BaseCallBack;
import br.com.como_voce_mora.model.DwellerId;
import br.com.como_voce_mora.repository.CallServicesRetrofitRepository;

public class ServicesPresenter implements ServicesPresenterContract.Presenter {
    private CallServicesRetrofitRepository mRepository;
    private ServicesPresenterContract.View mView;

    public ServicesPresenter(ServicesPresenterContract.View mView) {
        this.mRepository = new CallServicesRetrofitRepository();
        this.mView = mView;
    }

    @Override
    public void getDwellerId() {
        mRepository.getDwellerId(new BaseCallBack<DwellerId>() {
            @Override
            public void onSuccess(DwellerId response) {
                mView.showId(String.valueOf(response.getDwellerId()));
            }

            @Override
            public void onError(ResponseError error) {
                mView.showError("Azedou");
            }
        });
    }
}
