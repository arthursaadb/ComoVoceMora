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
import butterknife.BindView;
import butterknife.OnClick;

public class UnityExtraIncomeFragment extends BaseFragment implements CustomRadioButton.OnCheckedChangeListener{
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar progressBar;
    @BindView(R.id.rbYes)
    CustomRadioButton mRb1;
    @BindView(R.id.rbNo)
    CustomRadioButton mRb2;
    @BindView(R.id.tv_question)
    TextView tvQuestion;

    private boolean anyOptionChecked = false;
    private AnswerRequest answerRequest;
    private UnityAnswer unityAnswer = UnityAnswer.USE_AS_EXTRA;

    public static UnityExtraIncomeFragment newInstance() {
        return new UnityExtraIncomeFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_unity_extra_incoming;
    }

    @Override
    public void init() {
        tvQuestion.setText(unityAnswer.getQuestion());
        progressBar.setProgress(HowYouLiveProgressBar.HowYouLive.UNITY);
        mRb1.setOnCheckedChangeListener(this);
        mRb2.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            anyOptionChecked = true;
            setAnswer(buttonView.getText().toString());
            switch (buttonView.getId()) {
                case R.id.rbYes:
                    mRb1.setChecked(true);
                    mRb2.setChecked(false);
                    updateRbs();
                    break;
                case R.id.rbNo:
                    mRb1.setChecked(false);
                    mRb2.setChecked(true);

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
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (getActivity() != null) {
            ResearchFlow.addAnswer(unityAnswer.getQuestion(), answerRequest);
            ((AboutYouActivity) getActivity()).addFragment(UnityRateLivingFragment.newInstance());
        }
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }
}
