package br.com.como_voce_mora.repository;

import br.com.como_voce_mora.ResponseError;

public interface RepositoryCallback<T> {
    void onSuccess(T response);

    void onError(ResponseError error);
}
