package br.com.como_voce_mora.ui.previoushouse;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.custom.CustomSelectedView;
import br.com.como_voce_mora.ui.custom.HowYouLiveProgressBar;
import butterknife.BindView;
import butterknife.OnClick;

public class PreviousHomeTypeFragment extends BaseFragment {
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;
    @BindView(R.id.csvHouse)
    CustomSelectedView csvHouse;
    @BindView(R.id.csvApartament)
    CustomSelectedView csvApartment;

    public static PreviousHomeTypeFragment newInstance() {
        return new PreviousHomeTypeFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_previous_home_type;
    }

    @Override
    public void init() {
        csvHouse.setOnClickListener(view -> ((AboutYouActivity) getActivity()).addFragment(WhichHouseFragment.newInstance()));
        csvApartment.setOnClickListener(view -> ((AboutYouActivity) getActivity()).addFragment(WhichApartamentFragment.newInstance()));
    }

    @OnClick(R.id.btNext)
    public void onBtNextClicked() {

    }

    @OnClick(R.id.btBack)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.BEFORE_RESIDENCE);
    }
}
