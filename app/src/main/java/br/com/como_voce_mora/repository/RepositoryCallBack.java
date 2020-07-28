package br.com.como_voce_mora.repository;

import br.com.como_voce_mora.model.ResponseError;

public interface RepositoryCallBack<T> {
    void onSuccess(T response);

    void onError(ResponseError error);
}

