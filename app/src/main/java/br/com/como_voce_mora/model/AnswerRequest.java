package br.com.como_voce_mora.model;

import android.os.Parcel;
import android.os.Parcelable;

public class AnswerRequest implements Parcelable {
    private String dwellerId;
    private String questionPartId;
    private String texto;
    private String evaluationId;

    public AnswerRequest() {
    }

    public AnswerRequest(String dwellerId, String questionPartId, String texto, String evaluationId) {
        this.dwellerId = dwellerId;
        this.questionPartId = questionPartId;
        this.texto = texto;
        this.evaluationId = "5dc4a37451f72163e4182fe9";
    }

    public AnswerRequest(String dwellerId, String questionPartId, String texto) {
        this.dwellerId = dwellerId;
        this.questionPartId = questionPartId;
        this.texto = texto;
        this.evaluationId = "5dc4a37451f72163e4182fe9";
    }

    public String getDwellerId() {
        return dwellerId;
    }

    public void setDwellerId(String dwellerId) {
        this.dwellerId = dwellerId;
    }

    public String getQuestionPartId() {
        return questionPartId;
    }

    public void setQuestionPartId(String questionPartId) {
        this.questionPartId = questionPartId;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getEvaluationId() {
        return evaluationId;
    }

    public void setEvaluationId(String evaluationId) {
        this.evaluationId = evaluationId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.dwellerId);
        dest.writeString(this.questionPartId);
        dest.writeString(this.texto);
        dest.writeString(this.evaluationId);
    }

    public void readFromParcel(Parcel source) {
        this.dwellerId = source.readString();
        this.questionPartId = source.readString();
        this.texto = source.readString();
        this.evaluationId = source.readString();
    }

    protected AnswerRequest(Parcel in) {
        this.dwellerId = in.readString();
        this.questionPartId = in.readString();
        this.texto = in.readString();
        this.evaluationId = in.readString();
    }

    public static final Parcelable.Creator<AnswerRequest> CREATOR = new Parcelable.Creator<AnswerRequest>() {
        @Override
        public AnswerRequest createFromParcel(Parcel source) {
            return new AnswerRequest(source);
        }

        @Override
        public AnswerRequest[] newArray(int size) {
            return new AnswerRequest[size];
        }
    };
}