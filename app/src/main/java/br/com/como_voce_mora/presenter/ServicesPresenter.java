package br.com.como_voce_mora.presenter;

import java.util.List;

import br.com.como_voce_mora.AppController;
import br.com.como_voce_mora.api.BaseCallBack;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.DwellerId;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.model.ResponseError;
import br.com.como_voce_mora.repository.CallServicesRetrofitRepository;

public class ServicesPresenter implements ServicesPresenterContract.Presenter {
    private CallServicesRetrofitRepository mRepository;
    private ServicesPresenterContract.View mView;

    public ServicesPresenter(ServicesPresenterContract.View mView) {
        this.mRepository = new CallServicesRetrofitRepository();
        this.mView = mView;
    }

    @Override
    public void getServiceStatus() {
        mView.showLoad();

        mRepository.getServiceInfo(new BaseCallBack<DwellerId>() {
            @Override
            public void onSuccess(DwellerId response) {
                mView.stopLoad();
                mView.advice();
            }

            @Override
            public void onError(ResponseError error) {
                if (error.getCode().equals("500")) {
                    mView.showError("Serviço indisponível no momento");
                } else {
                    mView.stopLoad();
                    mView.advice();
                }
            }
        });
    }

    @Override
    public void callService() {
        mView.showLoad();

        mRepository.getDwellerId(new BaseCallBack<DwellerId>() {
            @Override
            public void onSuccess(DwellerId response) {
                postAnswers(String.valueOf(response.getDwellerId()));
            }

            @Override
            public void onError(ResponseError error) {
            }
        });
    }

    @Override
    public void postAnswers(String dwellerId) {
        if (dwellerId.equals("")) {
            mView.advice();
            return;
        }

        List<AnswerRequest> list = ResearchFlow.getList();

        if (list == null) {
            return;
        }

        for (AnswerRequest answerRequest : list) {
            answerRequest.setDwellerId(dwellerId);
            mRepository.saveAnswers(answerRequest, new BaseCallBack<AnswerRequest>() {
                @Override
                public void onSuccess(AnswerRequest response) {
                }

                @Override
                public void onError(ResponseError error) {
                    mView.stopLoad();
                    mView.showError("Erro ao carregar as respostas");
                }
            });
        }

        ResearchFlow.resetDabase();
        mView.stopLoad();
        mView.advice();
    }
}
