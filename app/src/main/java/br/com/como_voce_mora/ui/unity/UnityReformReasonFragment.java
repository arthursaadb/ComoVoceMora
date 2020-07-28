package br.com.como_voce_mora.ui.unity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.OnClick;
import kotlin.Unit;

public class UnityReformReasonFragment extends BaseFragment {
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;
    @BindView(R.id.cpPodium)
    CustomPodium customPodium;
    @BindViews({R.id.btFirstOption, R.id.btSecondOption, R.id.btThirdOption, R.id.btForthOption,
            R.id.btFifthOption, R.id.btSixOption, R.id.btSevenOption, R.id.btEightOption})
    List<Button> mButtons;
    @BindView(R.id.tv_question)
    TextView tvQuestion;

    private List<AnswerRequest> answerRequests = new ArrayList<>();
    private UnityAnswer unityAnswer = UnityAnswer.REFORM_REASON;
    private UnityAnswer ampliarComodo = UnityAnswer.ENLARGE_ROOM;
    private UnityAnswer melhorarAcabamento = UnityAnswer.IMPROVE_FINISHING;
    private UnityAnswer melhorarConforto = UnityAnswer.IMPROVE_CONFORT;
    private UnityAnswer resolverProblema = UnityAnswer.RESOLVE_TECNICAL_INSUE;
    private UnityAnswer diminuirComodo = UnityAnswer.DECREASE_ROOM;
    private UnityAnswer funcaoCondicao = UnityAnswer.CHANGE_ROOM_FUNCTION;
    private UnityAnswer outraRasao = UnityAnswer.OTHER_REASON;
    private UnityAnswer eliminar = UnityAnswer.ELIMINATE_ROOM;

    public static UnityReformReasonFragment newInstance() {
        return new UnityReformReasonFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_unity_reform_reason;
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

    private void setAnswers() {
        String[] podiumSelected = customPodium.getPodium();
        if (podiumSelected != null) {
            for (String pos : podiumSelected) {
                switch (pos) {
                    case "AMPLIAR COMODO":
                        answerRequests.add(new AnswerRequest(ampliarComodo.getQuestion(), ampliarComodo.getQuestionPartId(), pos));
                        break;
                    case "DIMINUIR COMODO":
                        answerRequests.add(new AnswerRequest(diminuirComodo.getQuestion(), diminuirComodo.getQuestionPartId(), pos));
                        break;
                    case "MELHORAR ACABAMENTO":
                        answerRequests.add(new AnswerRequest(melhorarAcabamento.getQuestion(), melhorarAcabamento.getQuestionPartId(), pos));
                        break;
                    case "MELHORAR CONFORTO":
                        answerRequests.add(new AnswerRequest(melhorarConforto.getQuestion(), melhorarConforto.getQuestionPartId(), pos));
                        break;
                    case "PROBLEMA TECNICO":
                        answerRequests.add(new AnswerRequest(resolverProblema.getQuestion(), resolverProblema.getQuestionPartId(), pos));
                        break;
                    case "ELIMINAR COMODO":
                        answerRequests.add(new AnswerRequest(eliminar.getQuestion(), eliminar.getQuestionPartId(), pos));
                        break;
                    case "FUNÇÃO DO COMODO":
                        answerRequests.add(new AnswerRequest(funcaoCondicao.getQuestion(), funcaoCondicao.getQuestionPartId(), pos));
                        break;
                    case "OUTROS":
                        answerRequests.add(new AnswerRequest(outraRasao.getQuestion(), outraRasao.getQuestionPartId(), pos));
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

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (getActivity() != null) {
            setAnswers();
            ((AboutYouActivity) getActivity()).addFragment(UnitySunLightFragment.newInstance());
        }
    }

    @OnClick({R.id.btFirstOption, R.id.btSecondOption, R.id.btThirdOption, R.id.btForthOption,
            R.id.btFifthOption, R.id.btSixOption, R.id.btSevenOption, R.id.btEightOption})
    public void onClickOptions(View view) {
        Button textView = (Button) view;
        customPodium.putOnPodium(textView.getText().toString());
        textView.setVisibility(View.INVISIBLE);
    }

}
