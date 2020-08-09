package br.com.como_voce_mora.ui.unity;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.building.BuildingSplashFragment;
import br.com.como_voce_mora.ui.building.BuildingWhichDivisionFragment;
import butterknife.OnClick;

public class UnitySplashFragment extends BaseFragment {


    public static UnitySplashFragment newInstance() {

        Bundle args = new Bundle();

        UnitySplashFragment fragment = new UnitySplashFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_splash_unity;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void init() {

    }

    @OnClick(R.id.bt_touch_next)
    public void onClickedBtNext() {
        if (ResearchFlow.getHouse()) {
            ((AboutYouActivity) requireActivity()).addFragment(BuildingWhichDivisionFragment.newInstance());
        } else {
            ((AboutYouActivity) getActivity()).addFragment(UnityAcquisitionFragment.newInstance());
        }
    }
}
