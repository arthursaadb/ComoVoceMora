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
import br.com.como_voce_mora.ui.unity.UnitySplashFragment;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrganicFoodWhyNotFragment extends BaseFragment implements CustomRadioButton.OnCheckedChangeListener {
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;
    @BindView(R.id.rbBrushMyTeeth)
    CustomRadioButton rbBrushMyTeeth;
    @BindView(R.id.rbDishes)
    CustomRadioButton rbDishes;
    @BindView(R.id.rbQuickShowers)
    CustomRadioButton rbQuickShowers;
    @BindView(R.id.rbFewDevices)
    CustomRadioButton rbFewDevices;
    @BindView(R.id.tv_question)
    TextView mTvQuestion;

    SustainableHabitsAnswer sustainableHabitsAnswer = SustainableHabitsAnswer.ORGANIC_FOOD_WHY_NOT;
    AnswerRequest answerRequest;
    StringBuilder answer = new StringBuilder();

    public static OrganicFoodWhyNotFragment newInstance() {
        return new OrganicFoodWhyNotFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_organic_food_why_not;
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (getActivity() != null) {
            ResearchFlow.addAnswer(new AnswerRequest(sustainableHabitsAnswer.getQuestion(), sustainableHabitsAnswer.getQuestionPartId(), answer.toString()), this);
            ((AboutYouActivity) requireActivity()).addFragment(OrganicFoodTransportFragment.newInstance());
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
                    rbQuickShowers.setChecked(false);
                    rbFewDevices.setChecked(false);

                    updateViews();
                    break;
                case R.id.rbDishes:
                    rbBrushMyTeeth.setChecked(false);
                    rbDishes.setChecked(true);
                    rbQuickShowers.setChecked(false);
                    rbFewDevices.setChecked(false);

                    updateViews();
                    break;
                case R.id.rbQuickShowers:
                    rbBrushMyTeeth.setChecked(false);
                    rbDishes.setChecked(false);
                    rbQuickShowers.setChecked(true);
                    rbFewDevices.setChecked(false);

                    updateViews();
                    break;
                case R.id.rbFewDevices:
                    rbBrushMyTeeth.setChecked(false);
                    rbDishes.setChecked(false);
                    rbQuickShowers.setChecked(false);
                    rbFewDevices.setChecked(true);

                    updateViews();
                    break;
            }
        }
    }

    private void updateViews() {
        rbBrushMyTeeth.updateView();
        rbDishes.updateView();
        rbQuickShowers.updateView();
        rbFewDevices.updateView();
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
