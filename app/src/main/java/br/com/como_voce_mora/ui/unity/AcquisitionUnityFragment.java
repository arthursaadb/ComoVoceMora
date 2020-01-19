package br.com.como_voce_mora.ui.unity;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.previoushouse.CondominiumFragment;
import butterknife.BindView;
import butterknife.OnClick;

public class AcquisitionUnityFragment extends BaseFragment {

    @BindView(R.id.progressBar)
    HowYouLiveProgressBar mProgress;

    public static AcquisitionUnityFragment newInstance() {
        return new AcquisitionUnityFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_unity_home_acquisition;
    }

    @Override
    public void init() {
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.UNITY);
    }

    @OnClick(R.id.btNext)
    public void onBtNextClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) getActivity()).addFragment(WhichApartamentUnityFragment.newInstance());
        }
    }

    @OnClick(R.id.btBack)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }
}
