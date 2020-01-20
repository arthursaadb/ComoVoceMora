package br.com.como_voce_mora.ui.building;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import butterknife.OnClick;

public class RateBuildingFragment extends BaseFragment {


    public static RateBuildingFragment newInstance() {

        Bundle args = new Bundle();

        RateBuildingFragment fragment = new RateBuildingFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_splash_building;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void init() {
        super.init();

    }

    @OnClick(R.id.bt_touch_next)
    public void onClickedBtNext() {
        ((AboutYouActivity) getActivity()).addFragment(HadAChoiceFragment.newInstance());
    }
}
