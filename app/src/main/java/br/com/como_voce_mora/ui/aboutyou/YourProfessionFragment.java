package br.com.como_voce_mora.ui.aboutyou;

import android.widget.EditText;
import android.widget.TextView;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.model.AboutYouAnswer;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.previoushouse.PreviousHomeFragment;
import br.com.como_voce_mora.ui.previoushouse.PreviousHomeSplashFragment;
import butterknife.BindView;
import butterknife.OnClick;

public class YourProfessionFragment extends BaseFragment {
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar progressBar;
    @BindView(R.id.etJob)
    EditText etJob;
    @BindView(R.id.tv_question)
    TextView tvQuestion;

    AboutYouAnswer aboutYouAnswer = AboutYouAnswer.WHATS_YOUR_PROFESSION;

    public static YourProfessionFragment newInstance() {
        return new YourProfessionFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_your_profession;
    }

    @Override
    public void init() {
        super.init();
        progressBar.setProgress(HowYouLiveProgressBar.HowYouLive.ABOUT_YOU);
        tvQuestion.setText(aboutYouAnswer.getQuestion());

    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (etJob.getText().length() != 0) {
            buildAnswer();
            ((AboutYouActivity) requireActivity()).addFragment(PreviousHomeSplashFragment.newInstance());
        }
    }

    private void buildAnswer() {
        AnswerRequest answerRequest = new AnswerRequest(aboutYouAnswer.getQuestion(), aboutYouAnswer.getQuestionPartId(), etJob.getText().toString());
        ResearchFlow.addAnswer(aboutYouAnswer.getQuestion(), answerRequest);
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }
}
