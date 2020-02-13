package br.com.como_voce_mora.ui.previoushouse;

import android.view.View;
import android.widget.TextView;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.CustomSelectedView;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.PreviousHouseAnswer;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.currentresidence.CurrentHomeFragment;
import butterknife.BindView;
import butterknife.OnClick;

public class PreviousHouseTimeFragment extends BaseFragment {
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;
    @BindView(R.id.view_1)
    CustomSelectedView mView1;
    @BindView(R.id.view_2)
    CustomSelectedView mView2;
    @BindView(R.id.view_3)
    CustomSelectedView mView3;
    @BindView(R.id.view_4)
    CustomSelectedView mView4;
    @BindView(R.id.view_5)
    CustomSelectedView mView5;
    @BindView(R.id.tv_question)
    TextView tvQuestion;

    private boolean anyOptionChecked = false;
    private AnswerRequest answerRequest;
    private PreviousHouseAnswer previous = PreviousHouseAnswer.STAY_TIME;

    public static PreviousHouseTimeFragment newInstance() {
        return new PreviousHouseTimeFragment();
    }

    @Override
    public void init() {
        tvQuestion.setText(previous.getQuestion());
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.BEFORE_RESIDENCE);

    }

    @OnClick({R.id.view_1, R.id.view_2, R.id.view_3, R.id.view_4, R.id.view_5})
    void onClickViews(View view) {
        anyOptionChecked = true;
        switch (view.getId()) {
            case R.id.view_1:
                mView1.setChecked(true);
                mView2.setChecked(false);
                mView3.setChecked(false);
                mView4.setChecked(false);
                mView5.setChecked(false);
                setAnswer(mView1.getText());
                break;
            case R.id.view_2:
                mView1.setChecked(false);
                mView2.setChecked(true);
                mView3.setChecked(false);
                mView4.setChecked(false);
                mView5.setChecked(false);
                setAnswer(mView2.getText());
                break;
            case R.id.view_3:
                mView1.setChecked(false);
                mView2.setChecked(false);
                mView3.setChecked(true);
                mView4.setChecked(false);
                mView5.setChecked(false);
                setAnswer(mView3.getText());
                break;
            case R.id.view_4:
                mView1.setChecked(false);
                mView2.setChecked(false);
                mView3.setChecked(false);
                mView4.setChecked(true);
                mView5.setChecked(false);
                setAnswer(mView4.getText());
                break;
            case R.id.view_5:
                mView1.setChecked(false);
                mView2.setChecked(false);
                mView3.setChecked(false);
                mView4.setChecked(false);
                mView5.setChecked(true);
                setAnswer(mView5.getText());
                break;
        }
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_previous_house_time;
    }

    private void setAnswer(String text) {
        answerRequest = new AnswerRequest(previous.getQuestion(), previous.getQuestionPartId(), text);
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (anyOptionChecked) {
            ResearchFlow.addAnswer(previous.getQuestion(), answerRequest);
            ((AboutYouActivity) requireActivity()).addFragment(CurrentHomeFragment.newInstance());
        }
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

}
