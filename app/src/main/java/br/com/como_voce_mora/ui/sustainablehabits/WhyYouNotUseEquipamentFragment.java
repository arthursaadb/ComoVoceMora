package br.com.como_voce_mora.ui.sustainablehabits;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

/**
 * A simple {@link Fragment} subclass.
 */
public class WhyYouNotUseEquipamentFragment extends BaseFragment implements CustomRadioButton.OnCheckedChangeListener {
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;
    @BindView(R.id.optionYes)
    CustomRadioButton rbBrushMyTeeth;
    @BindView(R.id.optionNo)
    CustomRadioButton rbDishes;
    @BindView(R.id.rbBillsPrice)
    CustomRadioButton rbWashMachineCapacity;
    @BindView(R.id.rbLessAmbientalDamage)
    CustomRadioButton rbWashMachineReuse;
    @BindView(R.id.rbDry)
    CustomRadioButton rbQuickShowers;
    @BindView(R.id.rbOthers)
    CustomRadioButton rbFewDevices;
    @BindView(R.id.tv_question)
    TextView mTvQuestion;

    SustainableHabitsAnswer sustainableHabitsAnswer = SustainableHabitsAnswer.WATHER_SAVE_EQUIPMENT;
    AnswerRequest answerRequest;

    public static WhyYouNotUseEquipamentFragment newInstance() {
        return new WhyYouNotUseEquipamentFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_why_you_not_use_equipament;
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (getActivity() != null) {
            ResearchFlow.addAnswer(sustainableHabitsAnswer.getQuestion(), answerRequest);
            ((AboutYouActivity) requireActivity()).addFragment(DoYouKnowEquipamentsFragment.newInstance());
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
        super.init();
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.HABITS);
        rbBrushMyTeeth.setOnCheckedChangeListener(this);
        rbDishes.setOnCheckedChangeListener(this);
        rbWashMachineCapacity.setOnCheckedChangeListener(this);
        rbWashMachineReuse.setOnCheckedChangeListener(this);
        rbQuickShowers.setOnCheckedChangeListener(this);
        rbFewDevices.setOnCheckedChangeListener(this);
        mTvQuestion.setText(sustainableHabitsAnswer.getQuestion());
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            setAnswer(buttonView.getText().toString());
            switch (buttonView.getId()) {
                case R.id.rbBrushMyTeeth:
                    rbBrushMyTeeth.setChecked(true);
                    rbDishes.setChecked(false);
                    rbWashMachineCapacity.setChecked(false);
                    rbWashMachineReuse.setChecked(false);
                    rbQuickShowers.setChecked(false);
                    rbFewDevices.setChecked(false);

                    updateViews();
                    break;
                case R.id.rbDishes:
                    rbBrushMyTeeth.setChecked(false);
                    rbDishes.setChecked(true);
                    rbWashMachineCapacity.setChecked(false);
                    rbWashMachineReuse.setChecked(false);
                    rbQuickShowers.setChecked(false);
                    rbFewDevices.setChecked(false);

                    updateViews();
                    break;
                case R.id.rbWashMachineCapacity:
                    rbBrushMyTeeth.setChecked(false);
                    rbDishes.setChecked(false);
                    rbWashMachineCapacity.setChecked(true);
                    rbWashMachineReuse.setChecked(false);
                    rbQuickShowers.setChecked(false);
                    rbFewDevices.setChecked(false);

                    updateViews();
                    break;
                case R.id.rbWashMachineReuse:
                    rbBrushMyTeeth.setChecked(false);
                    rbDishes.setChecked(false);
                    rbWashMachineCapacity.setChecked(false);
                    rbWashMachineReuse.setChecked(true);
                    rbQuickShowers.setChecked(false);
                    rbFewDevices.setChecked(false);

                    updateViews();
                    break;
                case R.id.rbQuickShowers:
                    rbBrushMyTeeth.setChecked(false);
                    rbDishes.setChecked(false);
                    rbWashMachineCapacity.setChecked(false);
                    rbWashMachineReuse.setChecked(false);
                    rbQuickShowers.setChecked(true);
                    rbFewDevices.setChecked(false);

                    updateViews();
                    break;
                case R.id.rbFewDevices:
                    rbBrushMyTeeth.setChecked(false);
                    rbDishes.setChecked(false);
                    rbWashMachineCapacity.setChecked(false);
                    rbWashMachineReuse.setChecked(false);
                    rbQuickShowers.setChecked(false);
                    rbFewDevices.setChecked(true);

                    updateViews();
                    break;
                case R.id.rbOther:
                    rbBrushMyTeeth.setChecked(false);
                    rbDishes.setChecked(false);
                    rbWashMachineCapacity.setChecked(false);
                    rbWashMachineReuse.setChecked(false);
                    rbQuickShowers.setChecked(false);
                    rbFewDevices.setChecked(false);

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
    }


    private void setAnswer(String text) {
        answerRequest = new AnswerRequest(sustainableHabitsAnswer.getQuestion(), sustainableHabitsAnswer.getQuestionPartId(), text);
    }
}
