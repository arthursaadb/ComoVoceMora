package br.com.como_voce_mora.ui.unity;

import android.os.Bundle;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.building.BuildingPublicAreaFragment;
import butterknife.BindView;
import butterknife.OnClick;

public class ActualHouseLivingUnityFragment extends BaseFragment {

    @BindView(R.id.progressBar)
    HowYouLiveProgressBar progressBar;

    public static ActualHouseLivingUnityFragment newInstance() {
        return new ActualHouseLivingUnityFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_unity_actual_living;
    }

    @Override
    public void init() {
        progressBar.setProgress(HowYouLiveProgressBar.HowYouLive.UNITY);
    }

    @OnClick(R.id.btNext)
    public void onBtNextClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) getActivity()).addFragment(ExtraIncomeUnityFragment.newInstance());
        }
    }

    @OnClick(R.id.btBack)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }
}
