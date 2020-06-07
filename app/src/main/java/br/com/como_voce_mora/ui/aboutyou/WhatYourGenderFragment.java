package br.com.como_voce_mora.ui.aboutyou;

import android.widget.CompoundButton;
import android.widget.TextView;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.CustomRadioButton;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.model.AboutYouAnswer;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.ui.BaseFragment;
import butterknife.BindView;
import butterknife.OnClick;

public class WhatYourGenderFragment extends BaseFragment implements CustomRadioButton.OnCheckedChangeListener {
    @BindView(R.id.rbFemale)
    CustomRadioButton mRbFemale;
    @BindView(R.id.rbMale)
    CustomRadioButton mRbMale;
    @BindView(R.id.rbOther)
    CustomRadioButton mRbOther;
    @BindView(R.id.tv_question)
    TextView mTvQuestion;
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar progressBar;

    private boolean anyOptionChecked = false;
    private AnswerRequest answerRequest;
    private AboutYouAnswer aboutYouAnswer = AboutYouAnswer.WHATS_YOUR_GENDER;

    public static WhatYourGenderFragment newInstance() {
        return new WhatYourGenderFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_what_your_gender;
    }

    @Override
    public void init() {
        progressBar.setProgress(HowYouLiveProgressBar.HowYouLive.ABOUT_YOU);
        mTvQuestion.setText(aboutYouAnswer.getQuestion());

        mRbFemale.setOnCheckedChangeListener(this);
        mRbMale.setOnCheckedChangeListener(this);
        mRbOther.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        anyOptionChecked = true;
        setAnswer(buttonView.getText().toString());
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

    private void setAnswer(String text) {
        answerRequest = new AnswerRequest(aboutYouAnswer.getQuestion(), aboutYouAnswer.getQuestionPartId(), text);
    }

    private void updateRbs() {
        mRbFemale.updateView();
        mRbMale.updateView();
        mRbOther.updateView();
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (anyOptionChecked) {
            ResearchFlow.addAnswer(aboutYouAnswer.getQuestion(), answerRequest);
            ((AboutYouActivity) requireActivity()).addFragment(HowOldAreYouFragment.newInstance());
        }
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }
}
