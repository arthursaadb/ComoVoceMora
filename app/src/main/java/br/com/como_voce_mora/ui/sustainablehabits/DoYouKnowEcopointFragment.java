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

public class DoYouKnowEcopointFragment extends BaseFragment implements CustomRadioButton.OnCheckedChangeListener {
    @BindView(R.id.progress_bar) HowYouLiveProgressBar mProgress;
    @BindView(R.id.optionYes) CustomRadioButton optionYes;
    @BindView(R.id.optionNo) CustomRadioButton optionNo;
    @BindView(R.id.tv_question) TextView mTvQuestion;

    SustainableHabitsAnswer sustainableHabitsAnswer = SustainableHabitsAnswer.ECOPOINT;
    AnswerRequest answerRequest;

    public static DoYouKnowEcopointFragment newInstance() {
        return new DoYouKnowEcopointFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_do_you_know_ecopoint;
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (getActivity() != null) {
            ResearchFlow.addAnswer(sustainableHabitsAnswer.getQuestion(), answerRequest);
            ((AboutYouActivity) requireActivity()).addFragment(DoYouSeparateOilFragment.newInstance());
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
        optionYes.setOnCheckedChangeListener(this);
        optionNo.setOnCheckedChangeListener(this);
        mTvQuestion.setText(sustainableHabitsAnswer.getQuestion());
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            setAnswer(buttonView.getText().toString());

            switch (buttonView.getId()) {
                case R.id.optionYes:
                    optionYes.setChecked(true);
                    optionNo.setChecked(false);

                    updateViews();
                    break;
                case R.id.optionNo:
                    optionYes.setChecked(false);
                    optionNo.setChecked(true);

                    updateViews();
                    break;
            }
        }
    }

    private void updateViews() {
        optionYes.updateView();
        optionNo.updateView();
    }

    private void setAnswer(String text) {
        answerRequest = new AnswerRequest(sustainableHabitsAnswer.getQuestion(), sustainableHabitsAnswer.getQuestionPartId(), text);
    }
}
