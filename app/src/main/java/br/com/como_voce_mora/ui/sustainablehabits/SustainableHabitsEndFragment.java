package br.com.como_voce_mora.ui.sustainablehabits;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.presenter.ServicesPresenter;
import br.com.como_voce_mora.presenter.ServicesPresenterContract;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.zup.multistatelayout.MultiStateLayout;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class SustainableHabitsEndFragment extends BaseFragment implements ServicesPresenterContract.View {
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;
    @BindView(R.id.tv_question)
    TextView mTvQuestion;
    @BindView(R.id.multiStateLayout)
    MultiStateLayout multiStateLayout;

    private ServicesPresenter mPresenter = new ServicesPresenter(this);

    public static SustainableHabitsEndFragment newInstance() {
        return new SustainableHabitsEndFragment();
    }


    @Override
    public int getResLayout() {
        return R.layout.fragment_sustainable_habits_end;
    }

    @Override
    public void init() {
        mProgress.setVisibility(View.GONE);
        mTvQuestion.setText("Muito Obrigado! Para finalizar, toque na tela.");
        mPresenter.callService();
    }

    @OnClick(R.id.rootLayout)
    public void onClickRoot() {
//        ((AboutYouActivity) requireActivity()).addFragment(WhyDoYouSaveWater.newInstance());
    }

    @Override
    public void showLoad() {
        multiStateLayout.setState(MultiStateLayout.State.LOADING);
    }

    @Override
    public void showId(String dwellerId) {

    }

    @Override
    public void showError(String azedou) {
        Toast.makeText(getContext(), azedou, Toast.LENGTH_LONG).show();
    }

    @Override
    public void advice() {

    }

    @Override
    public void stopLoad() {
        multiStateLayout.setState(MultiStateLayout.State.CONTENT);
    }
}
