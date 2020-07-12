package br.com.como_voce_mora.ui.sustainablehabits;

import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

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

/**
 * A simple {@link Fragment} subclass.
 */
public class WhatYouDoToSaveWater extends BaseFragment implements CustomRadioButton.OnCheckedChangeListener {
    @BindView(R.id.progress_bar) HowYouLiveProgressBar mProgress;
    @BindView(R.id.rbBrushMyTeeth) CustomRadioButton rbBrushMyTeeth;
    @BindView(R.id.rbDishes) CustomRadioButton rbDishes;
    @BindView(R.id.rbWashMachineCapacity) CustomRadioButton rbWashMachineCapacity;
    @BindView(R.id.rbWashMachineReuse) CustomRadioButton rbWashMachineReuse;
    @BindView(R.id.rbQuickShowers) CustomRadioButton rbQuickShowers;
    @BindView(R.id.rbFewDevices) CustomRadioButton rbFewDevices;
    @BindView(R.id.rbOthers) CustomRadioButton rbOthers;
    @BindView(R.id.tv_question)
    TextView mTvQuestion;

    public static Boolean hasWater = false;
    SustainableHabitsAnswer sustainableHabitsAnswer = SustainableHabitsAnswer.WHAT_YOU_DO_TO_SAVE_WATER;
    AnswerRequest answerRequest;


    public static WhatYouDoToSaveWater newInstance() {
        return new WhatYouDoToSaveWater();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_do_your_save_water;
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (getActivity() != null) {
            ResearchFlow.addAnswer(sustainableHabitsAnswer.getQuestion(), answerRequest);
            ((AboutYouActivity) requireActivity()).addFragment(DoYouKnowWashingMachineFragment.newInstance());
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
        rbWashMachineCapacity.setOnCheckedChangeListener(this);
        rbWashMachineReuse.setOnCheckedChangeListener(this);
        rbQuickShowers.setOnCheckedChangeListener(this);
        rbFewDevices.setOnCheckedChangeListener(this);
        rbOthers.setOnCheckedChangeListener(this);
        mTvQuestion.setText(sustainableHabitsAnswer.getQuestion());
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            setAnswer(buttonView.getText().toString());

            switch (buttonView.getId()) {
                case R.id.rbBrushMyTeeth:
                    rbBrushMyTeeth.setChecked(true);

                    updateViews();
                    break;
                case R.id.rbDishes:
                    rbDishes.setChecked(true);

                    updateViews();
                    break;
                case R.id.rbWashMachineCapacity:
                    rbWashMachineCapacity.setChecked(true);

                    updateViews();
                    break;
                case R.id.rbWashMachineReuse:
                    rbWashMachineReuse.setChecked(true);

                    updateViews();
                    break;
                case R.id.rbQuickShowers:
                    rbQuickShowers.setChecked(true);

                    updateViews();
                    break;
                case R.id.rbFewDevices:
                    rbFewDevices.setChecked(true);
                    hasWater = true;

                    updateViews();
                    break;
                case R.id.rbOthers:
                    rbOthers.setChecked(true);

                    updateViews();
                    break;
            }
        }
    }

    private void updateViews() {
        rbBrushMyTeeth.updateView();
        rbDishes.updateView();
        rbWashMachineCapacity.updateView();
        rbWashMachineReuse.updateView();
        rbQuickShowers.updateView();
        rbFewDevices.updateView();
        rbOthers.updateView();
    }

    private void setAnswer(String text) {
        answerRequest = new AnswerRequest(sustainableHabitsAnswer.getQuestion(), sustainableHabitsAnswer.getQuestionPartId(), text);
    }
}
