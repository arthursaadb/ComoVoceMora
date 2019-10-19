package br.com.como_voce_mora.presenter;

public class ServicesPresenterContract {

    public interface Presenter {
        void getDwellerId();
    }

    public interface View {
        void showId(String dwellerId);

        void showError(String azedou);
    }

}
