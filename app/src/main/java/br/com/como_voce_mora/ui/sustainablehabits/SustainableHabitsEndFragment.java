package br.com.como_voce_mora.ui.sustainablehabits;

import android.content.Intent;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.presenter.ServicesPresenter;
import br.com.como_voce_mora.presenter.ServicesPresenterContract;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.intro.IntroActivity;
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
    @BindView(R.id.layout_loading_end)
    FrameLayout layoutLoadingEnd;

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

    @OnClick({R.id.rootLayout, R.id.bt_next})
    public void onClickRoot() {
        Intent intent = new Intent(getActivity(), IntroActivity.class);
        startActivity(intent);
    }

    @Override
    public void showLoad() {
        layoutLoadingEnd.setVisibility(View.VISIBLE);
    }

    @Override
    public void showId(String dwellerId) {
        Intent intent = new Intent(getActivity(), IntroActivity.class);
        startActivity(intent);
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
        layoutLoadingEnd.setVisibility(View.GONE);
    }
}
