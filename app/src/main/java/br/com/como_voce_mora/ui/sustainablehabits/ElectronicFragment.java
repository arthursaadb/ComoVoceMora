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

public class ElectronicFragment extends BaseFragment implements CustomRadioButton.OnCheckedChangeListener {
    @BindView(R.id.progress_bar) HowYouLiveProgressBar mProgress;
    @BindView(R.id.rbBrushMyTeeth) CustomRadioButton rbBrushMyTeeth;
    @BindView(R.id.rbDishes) CustomRadioButton rbDishes;
    @BindView(R.id.rbWashMachineCapacity) CustomRadioButton rbWashMachineCapacity;
    @BindView(R.id.rbUnknow) CustomRadioButton rbUnknown;
    @BindView(R.id.tv_question) TextView mTvQuestion;

    SustainableHabitsAnswer sustainableHabitsAnswer = SustainableHabitsAnswer.ELETRONIC;
    AnswerRequest answerRequest;
    BaseFragment mNextFrag;

    public static ElectronicFragment newInstance() {
        return new ElectronicFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_eletronic;
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (getActivity() != null) {
            ResearchFlow.addAnswer(answerRequest, this);
            ((AboutYouActivity) requireActivity()).addFragment(mNextFrag);
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
        rbUnknown.setOnCheckedChangeListener(this);
        mTvQuestion.setText(sustainableHabitsAnswer.getQuestion());
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            setAnswer(buttonView.getText().toString());
            switch (buttonView.getId()) {
                case R.id.rbBrushMyTeeth:
                    mNextFrag = DoYouKnowBatteryFragment.newInstance();
                    rbBrushMyTeeth.setChecked(true);
                    rbDishes.setChecked(false);
                    rbWashMachineCapacity.setChecked(false);
                    rbUnknown.setChecked(false);
                    updateViews();
                    break;
                case R.id.rbDishes:
                    mNextFrag = DoYouKnowBatteryFragment.newInstance();
                    rbBrushMyTeeth.setChecked(false);
                    rbDishes.setChecked(true);
                    rbWashMachineCapacity.setChecked(false);
                    rbUnknown.setChecked(false);
                    updateViews();
                    break;
                case R.id.rbWashMachineCapacity:
                    mNextFrag = ExpiredMedicationFragment.newInstance();
                    rbBrushMyTeeth.setChecked(false);
                    rbDishes.setChecked(false);
                    rbWashMachineCapacity.setChecked(true);
                    rbUnknown.setChecked(false);
                    updateViews();
                    break;
                case R.id.rbUnknow:
                    mNextFrag = DoYouKnowBatteryFragment.newInstance();
                    rbBrushMyTeeth.setChecked(false);
                    rbDishes.setChecked(false);
                    rbWashMachineCapacity.setChecked(false);
                    rbUnknown.setChecked(true);

                    updateViews();
                    break;
            }
        }
    }

    private void updateViews() {
        rbBrushMyTeeth.updateView();
        rbDishes.updateView();
        rbWashMachineCapacity.updateView();
        rbUnknown.updateView();
    }

    private void setAnswer(String text) {
        answerRequest = new AnswerRequest(sustainableHabitsAnswer.getQuestion(), sustainableHabitsAnswer.getQuestionPartId(), text);
    }
}
