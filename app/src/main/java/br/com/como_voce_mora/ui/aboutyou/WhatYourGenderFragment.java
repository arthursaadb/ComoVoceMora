package br.com.como_voce_mora.ui.aboutyou;

import android.widget.CompoundButton;
import android.widget.TextView;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.CustomRadioButton;
import br.com.como_voce_mora.ui.BaseFragment;
import butterknife.BindView;
import butterknife.OnClick;

public class WhatYourGenderFragment extends BaseFragment implements CustomRadioButton.OnCheckedChangeListener{
    @BindView(R.id.rbFemale)
    CustomRadioButton mRbFemale;
    @BindView(R.id.rbMale)
    CustomRadioButton mRbMale;
    @BindView(R.id.rbOther)
    CustomRadioButton mRbOther;
    @BindView(R.id.tv_question)
    TextView mTvQuestion;

    public static WhatYourGenderFragment newInstance() {
        return new WhatYourGenderFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_what_your_gender;
    }

    @Override
    public void init() {
        super.init();

//        mTvQuestion.setText();

        mRbFemale.setOnCheckedChangeListener(this);
        mRbMale.setOnCheckedChangeListener(this);
        mRbOther.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            switch (buttonView.getId()) {
                case R.id.rbFemale:
                    mRbFemale.setChecked(true);
                    mRbMale.setChecked(false);
                    mRbOther.setChecked(false);

                    updateRbs();
                    break;
                case R.id.rbMale:
                    mRbFemale.setChecked(false);
                    mRbMale.setChecked(true);
                    mRbOther.setChecked(false);

                    updateRbs();
                    break;
                case R.id.rbOther:
                    mRbFemale.setChecked(false);
                    mRbMale.setChecked(false);
                    mRbOther.setChecked(true);

                    updateRbs();
                    break;
            }
        }
    }

    private void updateRbs() {
        mRbFemale.updateView();
        mRbMale.updateView();
        mRbOther.updateView();
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) getActivity()).addFragment(HowOldAreYouFragment.newInstance());
        }
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }
}
