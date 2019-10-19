package br.com.como_voce_mora.repository;

import br.com.como_voce_mora.api.ApiCreator;
import br.com.como_voce_mora.api.BaseCallBack;
import br.com.como_voce_mora.api.ServiceApi;
import br.com.como_voce_mora.model.DwellerId;

public class CallServicesRetrofitRepository implements CallServices {

    @Override
    public void getDwellerId(BaseCallBack<DwellerId> dwellerIdBaseCallBack) {
        ApiCreator.createService(ServiceApi.class).getUserData().enqueue(dwellerIdBaseCallBack);
    }
}
