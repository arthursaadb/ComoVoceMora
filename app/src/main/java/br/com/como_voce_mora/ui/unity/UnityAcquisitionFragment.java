package br.com.como_voce_mora.ui.unity;

import android.widget.CompoundButton;
import android.widget.TextView;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.CustomRadioButton;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.model.UnityAnswer;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.building.BuildingSplashFragment;
import br.com.como_voce_mora.ui.currentresidence.CurrentHomeFragment;
import butterknife.BindView;
import butterknife.OnClick;

public class UnityAcquisitionFragment extends BaseFragment implements CustomRadioButton.OnCheckedChangeListener {

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
    TextView mTvQuestion;

    public static UnityAcquisitionFragment newInstance() {
        return new UnityAcquisitionFragment();
    }

    private boolean anyOptionChecked = false;
    private AnswerRequest answerRequest;
    private UnityAnswer unityAnswer = UnityAnswer.HOUSING_STATE;

    @Override
    public int getResLayout() {
        return R.layout.fragment_unity_home_acquisition;
    }

    @Override
    public void init() {
        mTvQuestion.setText(unityAnswer.getQuestion());
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.UNITY);
        mRb1.setOnCheckedChangeListener(this);
        mRb2.setOnCheckedChangeListener(this);
        mRb3.setOnCheckedChangeListener(this);
        mRb4.setOnCheckedChangeListener(this);
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (anyOptionChecked) {
            if (getActivity() != null) {
                ResearchFlow.addAnswer(answerRequest, this);
                if (ResearchFlow.getHouse()) {
                    ((AboutYouActivity) getActivity()).addFragment(UnityHouseTypeFragment.newInstance());
                } else {
                    ((AboutYouActivity) getActivity()).addFragment(UnityWhichApartmentFragment.newInstance());
                }
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
        if (isChecked) {
            anyOptionChecked = true;
            setAnswer(buttonView.getText().toString());
            switch (buttonView.getId()) {
                case R.id.rbRent:
                    mRb1.setChecked(true);
                    mRb2.setChecked(false);
                    mRb3.setChecked(false);
                    mRb4.setChecked(false);
                    updateRbs();
                    break;
                case R.id.rbFinanced:
                    mRb1.setChecked(false);
                    mRb2.setChecked(true);
                    mRb3.setChecked(false);
                    mRb4.setChecked(false);
                    updateRbs();
                    break;
                case R.id.rbOwn:
                    mRb1.setChecked(false);
                    mRb2.setChecked(false);
                    mRb3.setChecked(true);
                    mRb4.setChecked(false);
                    updateRbs();
                    break;
                case R.id.rbBorrowed:
                    mRb1.setChecked(false);
                    mRb2.setChecked(false);
                    mRb3.setChecked(false);
                    mRb4.setChecked(true);
                    updateRbs();
                    break;
            }
        }
    }

    private void setAnswer(String text) {
        answerRequest = new AnswerRequest(unityAnswer.getQuestion(), unityAnswer.getQuestionPartId(), text);
    }

    private void updateRbs() {
        mRb1.updateView();
        mRb2.updateView();
        mRb3.updateView();
        mRb4.updateView();
    }

    @OnClick(R.id.btPreviousSession)
    public void onBtPreviouSessionClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) requireActivity()).addFragment(BuildingSplashFragment.newInstance());
        }
    }
}
