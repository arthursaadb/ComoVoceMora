package br.com.como_voce_mora.ui.building;

import android.widget.CompoundButton;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.CustomRadioButton;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.aboutyou.HowOldAreYouFragment;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import butterknife.BindView;
import butterknife.OnClick;

public class HadAChoiceFragment extends BaseFragment implements CustomRadioButton.OnCheckedChangeListener {
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;
    @BindView(R.id.rbFemale)
    CustomRadioButton mRbFemale;
    @BindView(R.id.rbMale)
    CustomRadioButton mRbMale;

    public static HadAChoiceFragment newInstance() {
        return new HadAChoiceFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_had_choice;
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) getActivity()).addFragment(NegativePointsFragment.newInstance());
        }
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    @Override
    public void init() {
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.BUILDING);
        mRbFemale.setOnCheckedChangeListener(this);
        mRbMale.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            switch (buttonView.getId()) {
                case R.id.rbFemale:
                    mRbFemale.setChecked(true);
                    mRbMale.setChecked(false);

                    updateRbs();
                    break;
                case R.id.rbMale:
                    mRbFemale.setChecked(false);
                    mRbMale.setChecked(true);

                    updateRbs();
                    break;
                case R.id.rbOther:
                    mRbFemale.setChecked(false);
                    mRbMale.setChecked(false);

                    updateRbs();
                    break;
            }
        }
    }

    private void updateRbs() {
        mRbFemale.updateView();
        mRbMale.updateView();
    }

}
