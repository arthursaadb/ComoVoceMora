package br.com.como_voce_mora.repository;

import br.com.como_voce_mora.api.BaseCallBack;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.DwellerId;

public interface CallServices {
    void getDwellerId(BaseCallBack<DwellerId> dwellerIdBaseCallBack);
    void getServiceInfo(BaseCallBack<DwellerId> dwellerIdBaseCallBack);
    void saveAnswers(AnswerRequest answerRequest, BaseCallBack<AnswerRequest> answerRequestBaseCallBack);
}