package br.com.como_voce_mora.ui.previoushouse;

import android.content.Intent;
import android.widget.CompoundButton;
import android.widget.TextView;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.PreviousHouseAnswer;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.custom.CustomRadioButton;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.ui.aboutyou.SplashAboutYouActivity;
import butterknife.BindView;
import butterknife.OnClick;

public class PreviousAcquisitionStateFragment extends BaseFragment implements CustomRadioButton.OnCheckedChangeListener {
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;
    @BindView(R.id.rbRent)
    CustomRadioButton mRb1;
    @BindView(R.id.rbFinanced)
    CustomRadioButton mRb2;
    @BindView(R.id.rbOwn)
    CustomRadioButton mRb3;
    @BindView(R.id.rbBorrowed)
    CustomRadioButton mRb4;
    @BindView(R.id.tv_question)
    TextView tvQuestion;

    private boolean anyOptionChecked = false;
    private AnswerRequest answerRequest;
    private PreviousHouseAnswer previous = PreviousHouseAnswer.BUY_TYPE;

    public static PreviousAcquisitionStateFragment newInstance() {
        return new PreviousAcquisitionStateFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_acquisition_state;
    }

    @Override
    public void init() {
        tvQuestion.setText(previous.getQuestion());
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.BEFORE_RESIDENCE);

        mRb1.setOnCheckedChangeListener(this);
        mRb2.setOnCheckedChangeListener(this);
        mRb3.setOnCheckedChangeListener(this);
        mRb4.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        anyOptionChecked = true;
        if (isChecked) {
            switch (buttonView.getId()) {
                case R.id.rbRent:
                    mRb1.setChecked(true);
                    mRb2.setChecked(false);
                    mRb3.setChecked(false);
                    mRb4.setChecked(false);
                    setAnswer(mRb1.getText().toString());
                    updateRbs();
                    break;
                case R.id.rbFinanced:
                    mRb1.setChecked(false);
                    mRb2.setChecked(true);
                    mRb3.setChecked(false);
                    mRb4.setChecked(false);
                    setAnswer(mRb2.getText().toString());
                    updateRbs();
                    break;
                case R.id.rbOwn:
                    mRb1.setChecked(false);
                    mRb2.setChecked(false);
                    mRb3.setChecked(true);
                    mRb4.setChecked(false);
                    setAnswer(mRb3.getText().toString());
                    updateRbs();
                    break;
                case R.id.rbBorrowed:
                    mRb1.setChecked(false);
                    mRb2.setChecked(false);
                    mRb3.setChecked(false);
                    mRb4.setChecked(true);
                    setAnswer(mRb4.getText().toString());
                    updateRbs();
                    break;
            }
        }
    }

    private void setAnswer(String text) {
        answerRequest = new AnswerRequest(previous.getQuestion(), previous.getQuestionPartId(), text);
    }

    private void updateRbs() {
        mRb1.updateView();
        mRb2.updateView();
        mRb3.updateView();
        mRb4.updateView();
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (anyOptionChecked) {
            ResearchFlow.addAnswer(answerRequest, this);
            ((AboutYouActivity) requireActivity()).addFragment(PreviousSatisfactionRateFragment.newInstance());
        }
    }


    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    @OnClick(R.id.btPreviousSession)
    public void onBtPreviouSessionClicked() {
        Intent intent = new Intent(getActivity(), SplashAboutYouActivity.class);
        startActivity(intent);
        getActivity().finish();
    }
}
