package br.com.como_voce_mora.ui.sustainablehabits;

import android.widget.CompoundButton;
import android.widget.TextView;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.CustomRadioButton;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.model.SustainableHabitsAnswer;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import butterknife.BindView;
import butterknife.OnClick;

public class WhyDoYouSaveWater extends BaseFragment implements CustomRadioButton.OnCheckedChangeListener {
    @BindView(R.id.progress_bar) HowYouLiveProgressBar mProgress;
    @BindView(R.id.optionYes) CustomRadioButton rbBrushMyTeeth;
    @BindView(R.id.optionNo) CustomRadioButton rbDishes;
    @BindView(R.id.rbBillsPrice) CustomRadioButton rbBillsPrice;
    @BindView(R.id.rbLessAmbientalDamage) CustomRadioButton rbLessAmbientalDamage;
    @BindView(R.id.rbDry) CustomRadioButton rbDry;
    @BindView(R.id.rbOthers) CustomRadioButton rbOthers;
    @BindView(R.id.tv_question)
    TextView mTvQuestion;

    SustainableHabitsAnswer sustainableHabitsAnswer = SustainableHabitsAnswer.YOU_SAVE_WATER;
    AnswerRequest answerRequest;

    public static WhyDoYouSaveWater newInstance() {
        return new WhyDoYouSaveWater();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_what_you_do_to_save_water;
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (getActivity() != null) {
            ResearchFlow.addAnswer(sustainableHabitsAnswer.getQuestion(), answerRequest);
            ((AboutYouActivity) requireActivity()).addFragment(WhatYouDoToSaveWater.newInstance());
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
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.HABITS);
        rbBrushMyTeeth.setOnCheckedChangeListener(this);
        rbDishes.setOnCheckedChangeListener(this);
        rbBillsPrice.setOnCheckedChangeListener(this);
        rbLessAmbientalDamage.setOnCheckedChangeListener(this);
        rbDry.setOnCheckedChangeListener(this);
        rbOthers.setOnCheckedChangeListener(this);
        mTvQuestion.setText(sustainableHabitsAnswer.getQuestion());
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            setAnswer(buttonView.getText().toString());

            switch (buttonView.getId()) {
                case R.id.optionYes:
                    rbBrushMyTeeth.setChecked(true);
                    rbDishes.setChecked(false);
                    rbBillsPrice.setChecked(false);
                    rbLessAmbientalDamage.setChecked(false);
                    rbDry.setChecked(false);
                    rbOthers.setChecked(false);

                    updateViews();
                    break;
                case R.id.optionNo:
                    rbBrushMyTeeth.setChecked(false);
                    rbDishes.setChecked(true);
                    rbBillsPrice.setChecked(false);
                    rbLessAmbientalDamage.setChecked(false);
                    rbDry.setChecked(false);
                    rbOthers.setChecked(false);

                    updateViews();
                    break;
                case R.id.rbBillsPrice:
                    rbBrushMyTeeth.setChecked(false);
                    rbDishes.setChecked(false);
                    rbBillsPrice.setChecked(true);
                    rbLessAmbientalDamage.setChecked(false);
                    rbDry.setChecked(false);
                    rbOthers.setChecked(false);

                    updateViews();
                    break;
                case R.id.rbLessAmbientalDamage:
                    rbBrushMyTeeth.setChecked(false);
                    rbDishes.setChecked(false);
                    rbBillsPrice.setChecked(false);
                    rbLessAmbientalDamage.setChecked(true);
                    rbDry.setChecked(false);
                    rbOthers.setChecked(false);

                    updateViews();
                    break;
                case R.id.rbDry:
                    rbBrushMyTeeth.setChecked(false);
                    rbDishes.setChecked(false);
                    rbBillsPrice.setChecked(false);
                    rbLessAmbientalDamage.setChecked(false);
                    rbDry.setChecked(true);
                    rbOthers.setChecked(false);

                    updateViews();
                    break;
                case R.id.rbOthers:
                    rbBrushMyTeeth.setChecked(false);
                    rbDishes.setChecked(false);
                    rbBillsPrice.setChecked(false);
                    rbLessAmbientalDamage.setChecked(false);
                    rbDry.setChecked(false);
                    rbOthers.setChecked(true);

                    updateViews();
                    break;
            }
        }
    }

    private void updateViews() {
        rbBrushMyTeeth.updateView();
        rbDishes.updateView();
        rbBillsPrice.updateView();
        rbLessAmbientalDamage.updateView();
        rbDry.updateView();
        rbOthers.updateView();
    }

    private void setAnswer(String text) {
        answerRequest = new AnswerRequest(sustainableHabitsAnswer.getQuestion(), sustainableHabitsAnswer.getQuestionPartId(), text);
    }
}
