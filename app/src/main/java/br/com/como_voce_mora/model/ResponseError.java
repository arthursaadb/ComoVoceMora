package br.com.como_voce_mora.model;


import com.google.gson.Gson;
import com.google.gson.annotations.Expose;

import okhttp3.ResponseBody;

public class ResponseError {

    public static final String UPDATE_VERSION = "111";
    public static final String NETWORK_DISABLE = "222";
    public static final String UNEXPECTED = "333";
    public static final String SESSION_EXPIRED = "444";
    public static final String GENERAL_ERROR = "GENERAL_ERROR";
    public static final String SYSTEM_MAINTENANCE = "SYSTEM_MAINTENANCE";

    @Expose
    private String code;
    @Expose
    private String detail;
    @Expose
    private String title;
    @Expose
    private String text;
    @Expose
    private int httpCode;

    public ResponseError() {

    }

    public ResponseError(String code, String detail, String title, String text, int httpCode) {
        this.code = code;
        this.detail = detail;
        this.title = title;
        this.text = text;
        this.httpCode = httpCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(int httpCode) {
        this.httpCode = httpCode;
    }

    public static final ResponseError getNetworkError() {
        final ResponseError error = new ResponseError();
        error.code = NETWORK_DISABLE;
        error.text = "Verifique sua conexão e tente novamente.";
        error.title = "Erro de conexão";
        error.setDetail("");
        return error;
    }

    public static final ResponseError getExceptionError() {
        final ResponseError error = new ResponseError();
        error.setTitle("Error inesperado");
        error.setCode(UNEXPECTED);
        error.setHttpCode(500);
        error.setText("Ops! Tivemos um problema.\nQue tal tentar de novo daqui a pouco?");
        return error;
    }

    public static final ResponseError getError500() {
        final ResponseError error = new ResponseError();
        error.setTitle("Error inesperado");
        error.setCode(UNEXPECTED);
        error.setHttpCode(500);
        error.setText("Ops! Tivemos um problema.\nQue tal tentar de novo daqui a pouco?");
        return error;
    }

    public static ResponseError getUpdateApplicationError() {
        final ResponseError error = new ResponseError();
        error.setTitle("Versão desatualizada");
        error.setCode(UPDATE_VERSION);
        error.setText("Ops! Tivemos um problema.\nQue tal tentar de novo daqui a pouco?");
        return error;
    }

    public static final ResponseError getResponseError(final ResponseBody responseBody, final int httpCode) {
        try {
            ResponseError error = new Gson().fromJson(responseBody.string(), ResponseError.class);

            if (error.getText() == null) {
                error.setText("");
            }

            error.setTitle(error.getTitle() != null ? error.getTitle() : "");
            error.setDetail(error.getDetail() != null ? error.getDetail() : "");
            error.setHttpCode(httpCode);

            return error;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return getExceptionError();
    }
}
