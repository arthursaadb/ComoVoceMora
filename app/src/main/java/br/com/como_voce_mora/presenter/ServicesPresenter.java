package br.com.como_voce_mora.presenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Handler;

import br.com.como_voce_mora.model.Answer;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.model.ResponseError;
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
    public void callService() {
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
                }
            });
        }

    }
}
