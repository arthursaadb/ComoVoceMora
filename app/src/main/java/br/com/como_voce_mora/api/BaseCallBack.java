package br.com.como_voce_mora.api;

import br.com.como_voce_mora.ResponseError;
import br.com.como_voce_mora.repository.RepositoryCallback;
import retrofit2.Call;
import retrofit2.Response;

public abstract class BaseCallBack<T> implements retrofit2.Callback<T>, RepositoryCallback<T> {


    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            onSuccess(response.body());
            return;
        }

        ResponseError responseError = ResponseError.getExceptionError();
        if (response.code() == 401) {
            responseError = ResponseError.getResponseError(response.errorBody(), response.code());

            if (responseError == null || responseError.getCode() == null) {
//                responseError = ResponseError.getExceptionError();
            }

        } else if (response.code() == 403) {
            return;

        } else if (response.code() == 422) {
            responseError = ResponseError.getResponseError(response.errorBody(), response.code());

            if (responseError.getCode() != null && responseError.getCode().equals(ResponseError.SYSTEM_MAINTENANCE)) {
                return;
            }
        }

        onError(responseError);
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        onError(ResponseError.getNetworkError());
    }
}