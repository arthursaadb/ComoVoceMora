package br.com.como_voce_mora.ui.previoushouse;

import android.content.Intent;
import android.widget.CompoundButton;
import android.widget.TextView;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.CustomRadioButton;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.PreviousHouseAnswer;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.ui.aboutyou.SplashAboutYouActivity;
import br.com.como_voce_mora.ui.currentresidence.CurrentHomeFragment;
import butterknife.BindView;
import butterknife.OnClick;

public class PreviousHomeFragment extends BaseFragment implements CustomRadioButton.OnCheckedChangeListener {

    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;
    @BindView(R.id.tv_question)
    TextView tvQuestion;
    @BindView(R.id.rbRent)
    CustomRadioButton rbRent;
    @BindView(R.id.rbFinanced)
    CustomRadioButton rbFinanced;
    private boolean yesChecked = false;
    private boolean anyOptionChecked = false;
    private AnswerRequest answerRequest;
    private PreviousHouseAnswer previous = PreviousHouseAnswer.LIVED_IN_SAME_PLACE;

    public static PreviousHomeFragment newInstance() {
        return new PreviousHomeFragment();
    }

    @Override
    public void init() {
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.BEFORE_RESIDENCE);
        tvQuestion.setText(previous.getQuestion());
        rbRent.setOnCheckedChangeListener(this);
        rbFinanced.setOnCheckedChangeListener(this);
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_previous_home;
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (anyOptionChecked) {
            ResearchFlow.addAnswer(answerRequest, this);
            if (yesChecked) {
                ((AboutYouActivity) requireActivity()).addFragment(PreviousCondominiumFragment.newInstance());
            } else {
                ((AboutYouActivity) requireActivity()).addFragment(CurrentHomeFragment.newInstance());
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
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        anyOptionChecked = true;
        setAnswer(buttonView.getText().toString());
        if (isChecked) {
            switch (buttonView.getId()) {
                case R.id.rbRent:
                    yesChecked = true;
                    rbRent.setChecked(true);
                    rbFinanced.setChecked(false);
                    updateRbs();
                    break;
                case R.id.rbFinanced:
                    yesChecked = false;
                    rbRent.setChecked(false);
                    rbFinanced.setChecked(true);
                    updateRbs();
                    break;
            }
        }
    }

    private void setAnswer(String text) {
        answerRequest = new AnswerRequest(previous.getQuestion(), previous.getQuestionPartId(), text);
    }

    private void updateRbs() {
        rbRent.updateView();
        rbFinanced.updateView();
    }

    @OnClick(R.id.btPreviousSession)
    public void onBtPreviouSessionClicked() {
        Intent intent = new Intent(getActivity(), SplashAboutYouActivity.class);
        startActivity(intent);
        getActivity().finish();
    }

}
