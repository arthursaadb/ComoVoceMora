package br.com.como_voce_mora.ui.previoushouse;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.custom.CustomRadioButton;
import br.com.como_voce_mora.ui.custom.HowYouLiveProgressBar;
import butterknife.BindView;
import butterknife.OnClick;

public class WhichApartamentFragment extends BaseFragment implements CompoundButton.OnCheckedChangeListener {
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;
    @BindView(R.id.rb_1)
    CustomRadioButton mRb1;
    @BindView(R.id.rb_2)
    CustomRadioButton mRb2;
    @BindView(R.id.rb_3)
    CustomRadioButton mRb3;
    @BindView(R.id.rb_4)
    CustomRadioButton mRb4;
    @BindView(R.id.rb_5)
    CustomRadioButton mRb5;
    @BindView(R.id.rb_6)
    CustomRadioButton mRb6;

    public static WhichApartamentFragment newInstance() {
        return new WhichApartamentFragment();
    }

    @Override
    public void init() {
        super.init();

        mRb1.setOnCheckedChangeListener(this);
        mRb2.setOnCheckedChangeListener(this);
        mRb3.setOnCheckedChangeListener(this);
        mRb4.setOnCheckedChangeListener(this);
        mRb5.setOnCheckedChangeListener(this);
        mRb6.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            switch (buttonView.getId()) {
                case R.id.rb_1:
                    mRb1.setChecked(true);
                    mRb2.setChecked(false);
                    mRb3.setChecked(false);
                    mRb4.setChecked(false);
                    mRb5.setChecked(false);
                    mRb6.setChecked(false);
                    break;
                case R.id.rb_2:
                    mRb1.setChecked(false);
                    mRb2.setChecked(true);
                    mRb3.setChecked(false);
                    mRb4.setChecked(false);
                    mRb5.setChecked(false);
                    mRb6.setChecked(false);
                    break;
                case R.id.rb_3:
                    mRb1.setChecked(false);
                    mRb2.setChecked(false);
                    mRb3.setChecked(true);
                    mRb4.setChecked(false);
                    mRb5.setChecked(false);
                    mRb6.setChecked(false);
                    break;
                case R.id.rb_4:
                    mRb1.setChecked(false);
                    mRb2.setChecked(false);
                    mRb3.setChecked(false);
                    mRb4.setChecked(true);
                    mRb5.setChecked(false);
                    mRb6.setChecked(false);
                    break;
                case R.id.rb_5:
                    mRb1.setChecked(false);
                    mRb2.setChecked(false);
                    mRb3.setChecked(false);
                    mRb4.setChecked(false);
                    mRb5.setChecked(true);
                    mRb6.setChecked(false);
                    break;
                case R.id.rb_6:
                    mRb1.setChecked(false);
                    mRb2.setChecked(false);
                    mRb3.setChecked(false);
                    mRb4.setChecked(false);
                    mRb5.setChecked(false);
                    mRb6.setChecked(true);
                    break;
            }
        }
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_which_apartament;
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) getActivity()).addFragment(AcquisitionStateFragment.newInstance());
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
