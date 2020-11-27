package br.com.como_voce_mora.ui.sustainablehabits;

import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.CustomRadioButton;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.model.SustainableHabitsAnswer;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.unity.UnitySplashFragment;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class WhatYouDoToSaveWater extends BaseFragment implements CustomRadioButton.OnCheckedChangeListener {
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;
    @BindView(R.id.rbBrushMyTeeth)
    CustomRadioButton rbBrushMyTeeth;
    @BindView(R.id.rbDishes)
    CustomRadioButton rbDishes;
    @BindView(R.id.rbWashMachineCapacity)
    CustomRadioButton rbWashMachineCapacity;
    @BindView(R.id.rbWashMachineReuse)
    CustomRadioButton rbWashMachineReuse;
    @BindView(R.id.rbQuickShowers)
    CustomRadioButton rbQuickShowers;
    @BindView(R.id.rbFewDevices)
    CustomRadioButton rbFewDevices;
    @BindView(R.id.rbOthers)
    CustomRadioButton rbOthers;
    @BindView(R.id.tv_question)
    TextView mTvQuestion;

    SustainableHabitsAnswer sustainableHabitsAnswer = SustainableHabitsAnswer.WHAT_YOU_DO_TO_SAVE_WATER;
    StringBuilder answer = new StringBuilder();
    AnswerRequest answerRequest;
    List<BaseFragment> mNextFragments = new ArrayList<>();
    BaseFragment consumeFragment = DoYouKnowConsumeFragment.newInstance(mNextFragments);
    BaseFragment tapFragment = DoYouKnowTapFragment.newInstance(mNextFragments);
    BaseFragment washingMachineFragment = DoYouKnowWashingMachineFragment.newInstance(mNextFragments);
    BaseFragment watherSaveFragment = WaterSaveEquipmentFragment.newInstance();
    BaseFragment whynotFragment = WhyYouNotUseEquipamentFragment.newInstance();


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
            ResearchFlow.addAnswer(new AnswerRequest(sustainableHabitsAnswer.getQuestion(),
                            sustainableHabitsAnswer.getQuestionPartId(), answer.toString()), this);

            ((AboutYouActivity) requireActivity()).addFragment(mNextFragments.get(0));
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
        mNextFragments.add(consumeFragment);
        mNextFragments.add(tapFragment);
        mNextFragments.add(washingMachineFragment);
        mNextFragments.add(whynotFragment);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            setAnswer(buttonView.getText().toString());

            switch (buttonView.getId()) {
                case R.id.rbBrushMyTeeth:
                    rbBrushMyTeeth.setChecked(true);
                    mNextFragments.remove(tapFragment);
                    updateViews();
                    break;
                case R.id.rbDishes:
                    rbDishes.setChecked(true);

                    updateViews();
                    break;
                case R.id.rbWashMachineCapacity:
                    rbWashMachineCapacity.setChecked(true);
                    mNextFragments.remove(consumeFragment);
                    updateViews();
                    break;
                case R.id.rbWashMachineReuse:
                    rbWashMachineReuse.setChecked(true);
                    mNextFragments.remove(washingMachineFragment);
                    updateViews();
                    break;
                case R.id.rbQuickShowers:
                    rbQuickShowers.setChecked(true);

                    updateViews();
                    break;
                case R.id.rbFewDevices:
                    rbFewDevices.setChecked(true);
                    mNextFragments.add(watherSaveFragment);
                    mNextFragments.remove(whynotFragment);
                    updateViews();
                    break;
                case R.id.rbOthers:
                    rbOthers.setChecked(true);

                    updateViews();
                    break;
            }
        } else {
            switch (buttonView.getId()) {
                case R.id.rbBrushMyTeeth:
                    rbBrushMyTeeth.setChecked(false);
                    mNextFragments.remove(tapFragment);
                    updateViews();
                    break;
                case R.id.rbDishes:
                    rbDishes.setChecked(false);

                    updateViews();
                    break;
                case R.id.rbWashMachineCapacity:
                    rbWashMachineCapacity.setChecked(false);

                    updateViews();
                    break;
                case R.id.rbWashMachineReuse:
                    rbWashMachineReuse.setChecked(false);

                    updateViews();
                    break;
                case R.id.rbQuickShowers:
                    rbQuickShowers.setChecked(false);

                    updateViews();
                    break;
                case R.id.rbFewDevices:
                    rbFewDevices.setChecked(false);
                    mNextFragments.remove(watherSaveFragment);
                    updateViews();
                    break;
                case R.id.rbOthers:
                    rbOthers.setChecked(false);

                    updateViews();

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
        answer.append(text);
        answer.append(";");
    }

    @OnClick(R.id.btPreviousSession)
    public void onBtPreviouSessionClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) requireActivity()).addFragment(UnitySplashFragment.newInstance());
        }
    }
}
