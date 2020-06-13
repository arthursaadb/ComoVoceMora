package br.com.como_voce_mora.presenter;

public class ServicesPresenterContract {

    public interface Presenter {
        void callService();

        void postAnswers(String dwellerId);
    }

    public interface View {
        void showId(String dwellerId);

        void showError(String azedou);

        void advice();

    }

}
