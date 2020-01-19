package br.com.como_voce_mora.ui.previoushouse;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.custom.CustomSelectedView;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import butterknife.BindView;
import butterknife.OnClick;

public class PreviousHomeTypeFragment extends BaseFragment {
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;
    @BindView(R.id.csvHouse)
    CustomSelectedView csvHouse;
    @BindView(R.id.csvApartament)
    CustomSelectedView csvApartment;

    Fragment nextFragment;

    public static PreviousHomeTypeFragment newInstance() {
        return new PreviousHomeTypeFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_previous_home_type;
    }

    @Override
    public void init() {
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.BEFORE_RESIDENCE);
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        goNextFragment();
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    @OnClick({R.id.csvHouse, R.id.csvApartament})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.csvHouse:
                nextFragment = WhichHouseFragment.newInstance();
                csvHouse.setChecked(true);
                csvApartment.setChecked(false);
                break;
            case R.id.csvApartament:
                csvHouse.setChecked(false);
                csvApartment.setChecked(true);
                nextFragment = WhichApartamentFragment.newInstance();
                break;
        }
    }

    private void goNextFragment() {
        if (nextFragment != null) {
            ((AboutYouActivity) getActivity()).addFragment(nextFragment);
        }
    }
}
