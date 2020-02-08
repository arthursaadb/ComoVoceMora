package br.com.como_voce_mora.ui.unity;

import android.widget.CompoundButton;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.CustomRadioButton;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.building.BuildingPublicAreaFragment;
import butterknife.BindView;
import butterknife.OnClick;

public class ExtraIncomeUnityFragment extends BaseFragment implements CustomRadioButton.OnCheckedChangeListener{
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar progressBar;
    @BindView(R.id.rbYes)
    CustomRadioButton mRb1;
    @BindView(R.id.rbNo)
    CustomRadioButton mRb2;

    public static ExtraIncomeUnityFragment newInstance() {
        return new ExtraIncomeUnityFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_unity_extra_incoming;
    }

    @Override
    public void init() {
        progressBar.setProgress(HowYouLiveProgressBar.HowYouLive.UNITY);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            switch (buttonView.getId()) {
                case R.id.rbYes:
                    mRb1.setChecked(true);
                    mRb2.setChecked(false);
                    updateRbs();
                    break;
                case R.id.rbNo:
                    mRb1.setChecked(false);
                    mRb2.setChecked(true);

                    updateRbs();
                    break;

            }
        }
    }

    private void updateRbs() {
        mRb1.updateView();
        mRb2.updateView();
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) getActivity()).addFragment(ResidentsUnityFragment.newInstance());
        }
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }
}
