package br.com.como_voce_mora.ui.building;

import android.os.Bundle;
import android.widget.Toast;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.ui.BaseFragment;
import butterknife.BindView;
import butterknife.OnClick;

public class BuildingPublicAreaFragment extends BaseFragment {

    @BindView(R.id.progressBar)
    HowYouLiveProgressBar progressBar;

    public static BuildingPublicAreaFragment newInstance() {

        Bundle args = new Bundle();

        BuildingPublicAreaFragment fragment = new BuildingPublicAreaFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_building_public_area;
    }

    @Override
    public void init() {
        progressBar.setProgress(HowYouLiveProgressBar.HowYouLive.ATUAL_RESIDENCE);
        super.init();
    }

    @OnClick(R.id.btNext)
    public void onBtNextClicked() {
        if (getActivity() != null) {
//            ((AboutYouActivity) getActivity()).addFragment(OrganizationFragment.newInstance());
            Toast.makeText(getContext(), "Em Desenvolvimento!", Toast.LENGTH_LONG).show();
        }
    }

    @OnClick(R.id.btBack)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }
}
