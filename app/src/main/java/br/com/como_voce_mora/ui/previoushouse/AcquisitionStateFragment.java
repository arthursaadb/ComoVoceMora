package br.com.como_voce_mora.ui.previoushouse;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.custom.CustomRadioButton;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import butterknife.BindView;
import butterknife.OnClick;

public class AcquisitionStateFragment extends BaseFragment implements CustomRadioButton.OnCheckedChangeListener {
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;
    @BindView(R.id.rbRent)
    CustomRadioButton mRb1;
    @BindView(R.id.rbFinanced)
    CustomRadioButton mRb2;
    @BindView(R.id.rbOwn)
    CustomRadioButton mRb3;
    @BindView(R.id.rbBorrowed)
    CustomRadioButton mRb4;

    public static AcquisitionStateFragment newInstance() {
        return new AcquisitionStateFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_acquisition_state;
    }

    @Override
    public void init() {
        super.init();
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.BEFORE_RESIDENCE);

        mRb1.setOnCheckedChangeListener(this);
        mRb2.setOnCheckedChangeListener(this);
        mRb3.setOnCheckedChangeListener(this);
        mRb4.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            switch (buttonView.getId()) {
                case R.id.rbRent:
                    mRb1.setChecked(true);
                    mRb2.setChecked(false);
                    mRb3.setChecked(false);
                    mRb4.setChecked(false);

                    updateRbs();
                    break;
                case R.id.rbFinanced:
                    mRb1.setChecked(false);
                    mRb2.setChecked(true);
                    mRb3.setChecked(false);
                    mRb4.setChecked(false);

                    updateRbs();
                    break;
                case R.id.rbOwn:
                    mRb1.setChecked(false);
                    mRb2.setChecked(false);
                    mRb3.setChecked(true);
                    mRb4.setChecked(false);

                    updateRbs();
                    break;
                case R.id.rbOther:
                    mRb1.setChecked(false);
                    mRb2.setChecked(false);
                    mRb3.setChecked(false);
                    mRb4.setChecked(true);

                    updateRbs();
                    break;
            }
        }
    }

    private void updateRbs() {
        mRb1.updateView();
        mRb2.updateView();
        mRb3.updateView();
        mRb4.updateView();
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) getActivity()).addFragment(SatisfactionRateFragment.newInstance());
        }
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }
}
