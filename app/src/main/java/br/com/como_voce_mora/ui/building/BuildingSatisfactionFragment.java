package br.com.como_voce_mora.ui.building;

import android.os.Bundle;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import butterknife.BindView;
import butterknife.OnClick;

public class BuildingSatisfactionFragment extends BaseFragment {

    @BindView(R.id.progressBar)
    HowYouLiveProgressBar progressBar;

    public static BuildingSatisfactionFragment newInstance() {

        Bundle args = new Bundle();

        BuildingSatisfactionFragment fragment = new BuildingSatisfactionFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_building_satisfaction;
    }

    @Override
    public void init() {
        progressBar.setProgress(HowYouLiveProgressBar.HowYouLive.BUILDING);
        super.init();
    }

    @OnClick(R.id.btNext)
    public void onBtNextClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) getActivity()).addFragment(WhichDivisionFragment.newInstance());
        }
    }

    @OnClick(R.id.btBack)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }
}
