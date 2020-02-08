package br.com.como_voce_mora.ui.housegroup;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.custom.CustomSelectedView;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import butterknife.BindView;
import butterknife.OnClick;

public class HabitationTypeFragment extends BaseFragment {

    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;
    @BindView(R.id.csvApartament)
    CustomSelectedView csvApartament;
    @BindView(R.id.csvHouse)
    CustomSelectedView csvHouse;

    public static HabitationTypeFragment newInstance() {
        return new HabitationTypeFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_habitation_type;
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (getActivity() != null)
            ((AboutYouActivity) getActivity()).addFragment(HabitationCondominiumFragment.newInstance());
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    @OnClick({R.id.csvHouse, R.id.csvApartament})
    public void onClickViews(View view) {
        switch (view.getId()) {
            case R.id.csvHouse:
                csvHouse.setChecked(true);
                csvApartament.setChecked(false);

                break;
            case R.id.csvApartament:
                csvHouse.setChecked(false);
                csvApartament.setChecked(true);

                break;
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.GROUP);
    }
}
