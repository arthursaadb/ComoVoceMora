package br.com.como_voce_mora.repository;

import java.net.InetAddress;

import br.com.como_voce_mora.api.ApiCreator;
import br.com.como_voce_mora.api.BaseCallBack;
import br.com.como_voce_mora.api.ServiceApi;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.DwellerId;

public class CallServicesRetrofitRepository implements CallServices {
    @Override
    public void getServiceInfo(BaseCallBack<DwellerId> dwellerIdBaseCallBack) {
        ApiCreator.createService(ServiceApi.class).getServiceStatus().enqueue(dwellerIdBaseCallBack);
    }

    @Override
    public void getDwellerId(BaseCallBack<DwellerId> dwellerIdBaseCallBack) {
        ApiCreator.createService(ServiceApi.class).getUserData().enqueue(dwellerIdBaseCallBack);
    }

    @Override
    public void saveAnswers(AnswerRequest answerRequest, BaseCallBack<AnswerRequest> answerRequestBaseCallBack) {
        ApiCreator.createService(ServiceApi.class).saveAnswer(answerRequest).enqueue(answerRequestBaseCallBack);
    }
}
