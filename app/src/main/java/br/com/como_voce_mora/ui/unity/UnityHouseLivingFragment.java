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

    String positions[] = new String[]{"1o Lugar", "2 Lugar", "3 Lugar", "4 Lugar"};
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
        String[] podiumSelected = customPodium.getPodium();
        if (podiumSelected != null) {
            for (int i = 0; i < podiumSelected.length; i++) {
                String pos = podiumSelected[i];
                String position = positions[i];
                switch (pos) {
                    case "Familia/Amigos":
                        answerRequests.add(new AnswerRequest(LOCAL_PESSOAS_INTERESSAM.getQuestion(), LOCAL_PESSOAS_INTERESSAM.getQuestionPartId(), position));
                        break;
                    case "Local onde durmo":
                        answerRequests.add(new AnswerRequest(LOCAL_DURMO.getQuestion(), LOCAL_DURMO.getQuestionPartId(), position));
                        break;
                    case "Passo mais tempo":
                        answerRequests.add(new AnswerRequest(LOCAL_EM_QUE_PASSO_MAIS_TEMPO.getQuestion(), LOCAL_EM_QUE_PASSO_MAIS_TEMPO.getQuestionPartId(), position));
                        break;
                    case "Local com que identifico":
                        answerRequests.add(new AnswerRequest(LOCAL_COM_O_QUE_MAIS_ME_IDENTIFICO.getQuestion(), LOCAL_COM_O_QUE_MAIS_ME_IDENTIFICO.getQuestionPartId(), position));
                        break;
                    case "Investimento material":
                        answerRequests.add(new AnswerRequest(INVESTIMENTO.getQuestion(), INVESTIMENTO.getQuestionPartId(), position));
                        break;
                    case"Local seguro":
                        answerRequests.add(new AnswerRequest(LOCAL_SEGURO.getQuestion(), LOCAL_SEGURO.getQuestionPartId(),position));
                        break;
                    case "Onde estão pertences":
                        answerRequests.add(new AnswerRequest(LOCAL_PERTENCES.getQuestion(), LOCAL_PERTENCES.getQuestionPartId(), position));
                        break;
                    case "Onde realizo atividades":
                        answerRequests.add(new AnswerRequest(LOCAL_ATIVIDADES.getQuestion(), LOCAL_ATIVIDADES.getQuestionPartId(), position));
                        break;
                    case "Outros":
                        answerRequests.add(new AnswerRequest(OUTRO.getQuestion(), OUTRO.getQuestionPartId(),position));
                        break;
                }
            }
            for (AnswerRequest r : answerRequests) {
                ResearchFlow.addAnswer(r, this);
            }
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
    }

    @OnClick(R.id.btPreviousSession)
    public void onBtPreviouSessionClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) requireActivity()).addFragment(BuildingSplashFragment.newInstance());
        }
    }
}
