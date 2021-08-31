package br.com.como_voce_mora.ui.sustainablehabits;

import androidx.fragment.app.Fragment;

import android.widget.CompoundButton;
import android.widget.TextView;

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

public class WhyYouNotUseEquipamentFragment extends BaseFragment implements CustomRadioButton.OnCheckedChangeListener {
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;
    @BindView(R.id.rbBrushMyTeeth)
    CustomRadioButton rbBrushMyTeeth;
    @BindView(R.id.rbDishes)
    CustomRadioButton rbDishes;
    @BindView(R.id.rbWashMachineCapacity)
    CustomRadioButton rbWashMachineCapacity;
    @BindView(R.id.rbQuickShowers)
    CustomRadioButton rbQuickShowers;
    @BindView(R.id.rbFewDevices)
    CustomRadioButton rbFewDevices;
    @BindView(R.id.tv_question)
    TextView mTvQuestion;

    SustainableHabitsAnswer sustainableHabitsAnswer = SustainableHabitsAnswer.WATER_SAVE_NO_EQUIPMENT;
    AnswerRequest answerRequest;
    private boolean anyOptionChecked = false;
    StringBuilder answer = new StringBuilder();
    List<String> answerList = new ArrayList<>();

    public static WhyYouNotUseEquipamentFragment newInstance() {
        return new WhyYouNotUseEquipamentFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_why_you_not_use_equipament;
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (anyOptionChecked && answerList.size() > 0) {
            if (getActivity() != null) {
                for (String text : answerList) {
                    answer.append(text);
                    answer.append(";");
                }
                ResearchFlow.addAnswer(new AnswerRequest(sustainableHabitsAnswer.getQuestion(), sustainableHabitsAnswer.getQuestionPartId(), answer.toString()), this);
                ((AboutYouActivity) requireActivity()).addFragment(WhyYouSaveElectricityFragment.newInstance());
            }
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
        rbQuickShowers.setOnCheckedChangeListener(this);
        rbFewDevices.setOnCheckedChangeListener(this);
        mTvQuestion.setText(sustainableHabitsAnswer.getQuestion());
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            anyOptionChecked = true;
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
                case R.id.rbQuickShowers:
                    rbQuickShowers.setChecked(true);

                    updateViews();
                    break;
                case R.id.rbFewDevices:
                    rbFewDevices.setChecked(true);


                    updateViews();
                    break;
            }
        } else {
            answerList.remove(buttonView.getText().toString());
            switch (buttonView.getId()) {
                case R.id.rbBrushMyTeeth:
                    rbBrushMyTeeth.setChecked(false);

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
                case R.id.rbQuickShowers:
                    rbQuickShowers.setChecked(false);

                    updateViews();
                    break;
                case R.id.rbFewDevices:
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
        rbQuickShowers.updateView();
        rbFewDevices.updateView();
    }


    private void setAnswer(String text) {
        answerList.add(text);
    }

    @OnClick(R.id.btPreviousSession)
    public void onBtPreviouSessionClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) requireActivity()).addFragment(UnitySplashFragment.newInstance());
        }
    }
}
