package br.com.como_voce_mora.ui.unity;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import butterknife.BindView;
import butterknife.OnClick;

public class UnityUsedSpaceFragment extends BaseFragment {

    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar progressBar;

    public static UnityUsedSpaceFragment newInstance() {
        return new UnityUsedSpaceFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_unity_used_space;
    }

    @Override
    public void init() {
        progressBar.setProgress(HowYouLiveProgressBar.HowYouLive.UNITY);
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) getActivity()).addFragment(UnityResidentsFragment.newInstance());
        }
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }
}
