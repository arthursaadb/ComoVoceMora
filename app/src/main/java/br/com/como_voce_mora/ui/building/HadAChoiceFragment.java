package br.com.como_voce_mora.ui.building;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.aboutyou.HowOldAreYouFragment;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import butterknife.BindView;
import butterknife.OnClick;

public class HadAChoiceFragment extends BaseFragment {
    @BindView(R.id.progressBar)
    HowYouLiveProgressBar mProgress;

    public static HadAChoiceFragment newInstance() {
        return new HadAChoiceFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_had_choice;
    }

    @OnClick(R.id.btNext)
    public void onBtNextClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) getActivity()).addFragment(NegativePointsFragment.newInstance());
        }
    }

    @OnClick(R.id.btBack)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    @Override
    public void init() {
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.BUILDING);
        super.init();
    }
}
