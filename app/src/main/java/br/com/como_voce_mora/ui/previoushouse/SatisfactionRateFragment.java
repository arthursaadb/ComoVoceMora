package br.com.como_voce_mora.ui.previoushouse;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.custom.HowYouLiveProgressBar;
import butterknife.BindView;
import butterknife.OnClick;

public class SatisfactionRateFragment extends BaseFragment {

    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;

    public static SatisfactionRateFragment newInstance() {
        return new SatisfactionRateFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_satisfaction_rate;
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) getActivity()).addFragment(PreviousHouseTimeFragment.newInstance());
        }
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.BEFORE_RESIDENCE);
    }
}
