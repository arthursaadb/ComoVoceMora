package br.com.como_voce_mora.ui.previoushouse;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.custom.HowYouLiveProgressBar;
import butterknife.BindView;
import butterknife.OnClick;

public class PreviousHomeTypeFragment extends BaseFragment {

    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;
    @BindView(R.id.rg_house)
    RadioGroup mRadioGroup;

    public static PreviousHomeTypeFragment newInstance() {
        return new PreviousHomeTypeFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_previous_home_type;
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        switch (mRadioGroup.getCheckedRadioButtonId()) {
            case R.id.rb_house:
                if (getActivity() != null)
                    ((AboutYouActivity) getActivity()).addFragment(WhichHouseFragment.newInstance());
                break;
            case R.id.rb_apartament:
                if (getActivity() != null)
                    ((AboutYouActivity) getActivity()).addFragment(WhichApartamentFragment.newInstance());
                break;
        }
    }

    @OnClick(R.id.bt_back)
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
