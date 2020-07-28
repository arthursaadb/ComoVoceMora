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
 * Use the {@link OrganicFoodTypeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OrganicFoodTypeFragment extends BaseFragment implements CustomRadioButton.OnCheckedChangeListener {
    @BindView(R.id.progress_bar) HowYouLiveProgressBar mProgress;
    @BindView(R.id.rbBrushMyTeeth) CustomRadioButton rbBrushMyTeeth;
    @BindView(R.id.rbDishes) CustomRadioButton rbDishes;
    @BindView(R.id.rbWashMachineCapacity) CustomRadioButton rbWashMachineCapacity;
    @BindView(R.id.rbQuickShowers) CustomRadioButton rbQuickShowers;
    @BindView(R.id.rbFewDevices) CustomRadioButton rbFewDevices;
    @BindView(R.id.rbOthers) CustomRadioButton rbOthers;
    @BindView(R.id.tv_question) TextView mTvQuestion;

    SustainableHabitsAnswer sustainableHabitsAnswer = SustainableHabitsAnswer.ORGANIC_FOOD_TYPE;
    AnswerRequest answerRequest;

    public static OrganicFoodTypeFragment newInstance() {
        return new OrganicFoodTypeFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_organic_food_type;
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (getActivity() != null) {
            ResearchFlow.addAnswer(answerRequest, this);
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
        rbWashMachineCapacity.setOnCheckedChangeListener(this);
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
                case R.id.rbQuickShowers:
                    rbQuickShowers.setChecked(true);

                    updateViews();
                    break;
                case R.id.rbFewDevices:
                    rbFewDevices.setChecked(true);

                    updateViews();
                    break;
                case R.id.rbOther:
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
        rbQuickShowers.updateView();
        rbFewDevices.updateView();
        rbOthers.updateView();
    }

    private void setAnswer(String text) {
        answerRequest = new AnswerRequest(sustainableHabitsAnswer.getQuestion(), sustainableHabitsAnswer.getQuestionPartId(), text);
    }
}
