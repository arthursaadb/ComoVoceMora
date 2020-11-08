package br.com.como_voce_mora.ui.unity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.CustomPodium;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.model.UnityAnswer;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.building.BuildingSplashFragment;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.OnClick;

import static br.com.como_voce_mora.model.UnityAnswer.INVESTIMENTO;
import static br.com.como_voce_mora.model.UnityAnswer.LOCAL_ATIVIDADES;
import static br.com.como_voce_mora.model.UnityAnswer.LOCAL_COM_O_QUE_MAIS_ME_IDENTIFICO;
import static br.com.como_voce_mora.model.UnityAnswer.LOCAL_DURMO;
import static br.com.como_voce_mora.model.UnityAnswer.LOCAL_EM_QUE_PASSO_MAIS_TEMPO;
import static br.com.como_voce_mora.model.UnityAnswer.LOCAL_PERTENCES;
import static br.com.como_voce_mora.model.UnityAnswer.LOCAL_PESSOAS_INTERESSAM;
import static br.com.como_voce_mora.model.UnityAnswer.LOCAL_SEGURO;
import static br.com.como_voce_mora.model.UnityAnswer.OUTRO;

public class UnityHouseLivingFragment extends BaseFragment {
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;
    @BindView(R.id.cpPodium)
    CustomPodium customPodium;
    @BindViews({R.id.btFirstOption, R.id.btSecondOption, R.id.btThirdOption, R.id.btForthOption,
            R.id.btFifthOption, R.id.btSixOption, R.id.btSevenOption, R.id.btEightOption, R.id.btNineOption})
    List<Button> mButtons;
    @BindView(R.id.tv_question)
    TextView tvQuestion;

    private UnityAnswer unityAnswer = UnityAnswer.HOME_TYPE;
    private List<AnswerRequest> answerRequests = new ArrayList<>();
    private boolean anyOptionChecked = false;

    public static UnityHouseLivingFragment newInstance() {
        return new UnityHouseLivingFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_unity_house_living;
    }

    @Override
    public void init() {
        tvQuestion.setText(unityAnswer.getQuestion());
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.UNITY);
        customPodium.setOnPodiumListener(xqdl -> {
            for (Button b : mButtons) {
                if (b.getText().equals(xqdl)) {
                    b.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (anyOptionChecked) {
            if (getActivity() != null) {
                setAnswers();
                ((AboutYouActivity) getActivity()).addFragment(UnityAdaptFragment.newInstance());
            }
        }
    }

    private void setAnswers() {
        for (AnswerRequest r : answerRequests) {
            ResearchFlow.addAnswer(r, this);
        }
    }


    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    @OnClick({R.id.btFirstOption, R.id.btSecondOption, R.id.btThirdOption, R.id.btForthOption,
            R.id.btFifthOption, R.id.btSixOption, R.id.btSevenOption, R.id.btEightOption, R.id.btNineOption})
    public void onClickOptions(View view) {
        Button textView = (Button) view;
        anyOptionChecked = true;
        customPodium.putOnPodium(textView.getText().toString());
        textView.setVisibility(View.INVISIBLE);

        switch (view.getId()) {
            case R.id.btFirstOption:
                answerRequests.add(new AnswerRequest(LOCAL_PESSOAS_INTERESSAM.getQuestion(), LOCAL_PESSOAS_INTERESSAM.getQuestionPartId(), textView.getText().toString()));
                break;
            case R.id.btSecondOption:
                answerRequests.add(new AnswerRequest(LOCAL_SEGURO.getQuestion(), LOCAL_SEGURO.getQuestionPartId(), textView.getText().toString()));
                break;
            case R.id.btThirdOption:
                answerRequests.add(new AnswerRequest(LOCAL_DURMO.getQuestion(), LOCAL_DURMO.getQuestionPartId(), textView.getText().toString()));
                break;
            case R.id.btForthOption:
                answerRequests.add(new AnswerRequest(LOCAL_PERTENCES.getQuestion(), LOCAL_PERTENCES.getQuestionPartId(), textView.getText().toString()));
                break;
            case R.id.btFifthOption:
                answerRequests.add(new AnswerRequest(LOCAL_EM_QUE_PASSO_MAIS_TEMPO.getQuestion(), LOCAL_EM_QUE_PASSO_MAIS_TEMPO.getQuestionPartId(), textView.getText().toString()));
                break;
            case R.id.btSixOption:
                answerRequests.add(new AnswerRequest(LOCAL_ATIVIDADES.getQuestion(), LOCAL_ATIVIDADES.getQuestionPartId(), textView.getText().toString()));
                break;
            case R.id.btSevenOption:
                answerRequests.add(new AnswerRequest(LOCAL_COM_O_QUE_MAIS_ME_IDENTIFICO.getQuestion(), LOCAL_COM_O_QUE_MAIS_ME_IDENTIFICO.getQuestionPartId(), textView.getText().toString()));
                break;
            case R.id.btEightOption:
                answerRequests.add(new AnswerRequest(OUTRO.getQuestion(), OUTRO.getQuestionPartId(), textView.getText().toString()));
                break;
            case R.id.btNineOption:
                answerRequests.add(new AnswerRequest(INVESTIMENTO.getQuestion(), INVESTIMENTO.getQuestionPartId(), textView.getText().toString()));
                break;
        }
    }

    @OnClick(R.id.btPreviousSession)
    public void onBtPreviouSessionClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) requireActivity()).addFragment(BuildingSplashFragment.newInstance());
        }
    }
}
