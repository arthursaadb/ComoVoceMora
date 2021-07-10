package br.com.como_voce_mora.ui.sustainablehabits;

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

public class PlantsTypeFragment extends BaseFragment implements CustomRadioButton.OnCheckedChangeListener {
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;
    @BindView(R.id.rbBrushMyTeeth)
    CustomRadioButton rbBrushMyTeeth;
    @BindView(R.id.rbDishes)
    CustomRadioButton rbDishes;
    @BindView(R.id.rbWashMachineCapacity)
    CustomRadioButton rbWashMachineCapacity;
    @BindView(R.id.tv_question)
    TextView mTvQuestion;

    SustainableHabitsAnswer sustainableHabitsAnswer = SustainableHabitsAnswer.PLANTS_TYPE;
    boolean anyOptionChecked = false;
    StringBuilder answer = new StringBuilder();
    List<String> answerList = new ArrayList<>();

    public static PlantsTypeFragment newInstance() {
        return new PlantsTypeFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_plants_type;
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (getActivity() != null && anyOptionChecked && answerList.size() > 0) {
            for (String text : answerList) {
                answer.append(text);
                answer.append(";");
            }

            ResearchFlow.addAnswer(new AnswerRequest(sustainableHabitsAnswer.getQuestion(), sustainableHabitsAnswer
                    .getQuestionPartId(), answer.toString()), this);
            ((AboutYouActivity) requireActivity()).addFragment(TransportationFragment.newInstance());
        }
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null && anyOptionChecked) {
            getActivity().onBackPressed();
        }
    }

    @Override
    public void init() {
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.HABITS);
        rbBrushMyTeeth.setOnCheckedChangeListener(this);
        rbDishes.setOnCheckedChangeListener(this);
        rbWashMachineCapacity.setOnCheckedChangeListener(this);
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
            }
        }
    }

    private void updateViews() {
        rbBrushMyTeeth.updateView();
        rbDishes.updateView();
        rbWashMachineCapacity.updateView();
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
