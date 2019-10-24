package br.com.como_voce_mora.presenter;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

import br.com.como_voce_mora.model.Answer;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.ResponseError;
import br.com.como_voce_mora.api.BaseCallBack;
import br.com.como_voce_mora.model.DwellerId;
import br.com.como_voce_mora.repository.CallServicesRetrofitRepository;

public class ServicesPresenter implements ServicesPresenterContract.Presenter {
    private CallServicesRetrofitRepository mRepository;
    private ServicesPresenterContract.View mView;
    private String dwellerId;

    public ServicesPresenter(ServicesPresenterContract.View mView) {
        this.mRepository = new CallServicesRetrofitRepository();
        this.mView = mView;
        this.dwellerId = "";
    }

    @Override
    public void getDwellerId() {
        mRepository.getDwellerId(new BaseCallBack<DwellerId>() {
            @Override
            public void onSuccess(DwellerId response) {
                dwellerId = String.valueOf(response.getDwellerId());
                mView.showId(dwellerId);
            }

            @Override
            public void onError(ResponseError error) {
                mView.showError("Erro Inesperado");
            }
        });
    }

    @Override
    public void postAnswers() {
        if (dwellerId.equals("")) {
            mView.advice();
            return;
        }
        List<AnswerRequest> list = getAnwerLists();
        for (AnswerRequest answerRequest : list) {
            mRepository.saveAnswers(answerRequest, new BaseCallBack<AnswerRequest>() {
                @Override
                public void onSuccess(AnswerRequest response) {

                }

                @Override
                public void onError(ResponseError error) {
                    mView.showError("Erro Inesperado");
                }
            });
        }

    }

    private List<AnswerRequest> getAnwerLists() {
        List<AnswerRequest> list = new ArrayList<>();
        list.add(new AnswerRequest(dwellerId, "3c07a8d2-f39e-417f-bc92-6fdcc1811e14", "Masculino", "36"));
        list.add(new AnswerRequest(dwellerId, "befef56c-00a6-44c7-9d17-0edb368d007a", "De 21 a 30", "36"));
        list.add(new AnswerRequest(dwellerId, "ba65610d-2364-4365-bfda-72f8614ca0f3", "Ensino superior completo", "36"));
        list.add(new AnswerRequest(dwellerId, "b8e1b168-b27f-4211-ac4c-28f4fcd1bd5a", "Animal De Estimação", "36"));
        list.add(new AnswerRequest(dwellerId, "0d70117e-9901-476b-9cdb-339e3456cea3", "Não", "36"));
        list.add(new AnswerRequest(dwellerId, "17c7ca75-55bc-47d2-9ef0-d6770d65ee0d", "Não", "36"));
        list.add(new AnswerRequest(dwellerId, "216db099-3479-4dca-955a-d47275fe6813", "até 3000 reais", "36"));
        list.add(new AnswerRequest(dwellerId, "408f937b-2e42-4fae-ade5-b246771bc7ef", "Digite Aqui", "36"));
        return list;
    }

}
