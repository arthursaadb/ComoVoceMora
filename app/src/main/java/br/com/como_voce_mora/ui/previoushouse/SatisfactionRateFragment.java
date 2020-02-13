package br.com.como_voce_mora.ui.previoushouse;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.PreviousHouseAnswer;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.custom.CustomRadioButton;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import butterknife.BindView;
import butterknife.OnClick;

public class SatisfactionRateFragment extends BaseFragment implements CompoundButton.OnCheckedChangeListener {
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;
    @BindView(R.id.rb_1)
    CustomRadioButton mRb1;
    @BindView(R.id.rb_2)
    CustomRadioButton mRb2;
    @BindView(R.id.rb_3)
    CustomRadioButton mRb3;
    @BindView(R.id.rb_4)
    CustomRadioButton mRb4;
    @BindView(R.id.rb_5)
    CustomRadioButton mRb5;
    @BindView(R.id.tv_question)
    TextView tvQuestion;

    private boolean anyOptionChecked = false;
    private AnswerRequest answerRequest;
    private PreviousHouseAnswer previous = PreviousHouseAnswer.PREVIUS_HOUSE_SATISFACTION;

    public static SatisfactionRateFragment newInstance() {
        return new SatisfactionRateFragment();
    }

    @Override
    public void init() {
        super.init();
        tvQuestion.setText(previous.getQuestion());
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.BEFORE_RESIDENCE);

        mRb1.setOnCheckedChangeListener(this);
        mRb2.setOnCheckedChangeListener(this);
        mRb3.setOnCheckedChangeListener(this);
        mRb4.setOnCheckedChangeListener(this);
        mRb5.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            anyOptionChecked = true;
            switch (buttonView.getId()) {
                case R.id.rb_1:
                    mRb1.setChecked(true);
                    mRb2.setChecked(false);
                    mRb3.setChecked(false);
                    mRb4.setChecked(false);
                    mRb5.setChecked(false);
                    setAnswer(mRb1.getText().toString());
                    break;
                case R.id.rb_2:
                    mRb1.setChecked(false);
                    mRb2.setChecked(true);
                    mRb3.setChecked(false);
                    mRb4.setChecked(false);
                    mRb5.setChecked(false);
                    setAnswer(mRb2.getText().toString());
                    break;
                case R.id.rb_3:
                    mRb1.setChecked(false);
                    mRb2.setChecked(false);
                    mRb3.setChecked(true);
                    mRb4.setChecked(false);
                    mRb5.setChecked(false);
                    setAnswer(mRb3.getText().toString());
                    break;
                case R.id.rb_4:
                    mRb1.setChecked(false);
                    mRb2.setChecked(false);
                    mRb3.setChecked(false);
                    mRb4.setChecked(true);
                    mRb5.setChecked(false);
                    setAnswer(mRb4.getText().toString());
                    break;
                case R.id.rb_5:
                    mRb1.setChecked(false);
                    mRb2.setChecked(false);
                    mRb3.setChecked(false);
                    mRb4.setChecked(false);
                    mRb5.setChecked(true);
                    setAnswer(mRb5.getText().toString());
                    break;
            }

            updateRbs();
        }
    }

    private void updateRbs() {
        mRb1.updateView();
        mRb2.updateView();
        mRb3.updateView();
        mRb4.updateView();
        mRb5.updateView();
    }

    private void setAnswer(String text) {
        answerRequest = new AnswerRequest(previous.getQuestion(), previous.getQuestionPartId(), text);
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_satisfaction_rate;
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (anyOptionChecked) {
            ResearchFlow.addAnswer(previous.getQuestion(), answerRequest);
            ((AboutYouActivity) requireActivity()).addFragment(PreviousHouseTimeFragment.newInstance());
        }
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

}
