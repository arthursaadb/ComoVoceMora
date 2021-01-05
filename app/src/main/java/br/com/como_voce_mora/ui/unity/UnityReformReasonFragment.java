package br.com.como_voce_mora.ui.unity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
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
    String positions[] = new String[]{"1o Lugar", "2 Lugar", "3 Lugar", "4 Lugar"};
    private UnityAnswer unityAnswer = UnityAnswer.REFORM_REASON;
    private UnityAnswer ampliarComodo = UnityAnswer.ENLARGE_ROOM;
    private UnityAnswer melhorarAcabamento = UnityAnswer.IMPROVE_FINISHING;
    private UnityAnswer melhorarConforto = UnityAnswer.IMPROVE_CONFORT;
    private UnityAnswer resolverProblema = UnityAnswer.RESOLVE_TECNICAL_INSUE;
    private UnityAnswer diminuirComodo = UnityAnswer.DECREASE_ROOM;
    private UnityAnswer funcaoCondicao = UnityAnswer.CHANGE_ROOM_FUNCTION;
    private UnityAnswer outraRasao = UnityAnswer.OTHER_REASON;
    private UnityAnswer eliminar = UnityAnswer.ELIMINATE_ROOM;

    public static UnityReformReasonFragment newInstance(List<UnityAnswer> room) {

        Bundle args = new Bundle();
        args.putSerializable("list", (Serializable) room);
        UnityReformReasonFragment fragment = new UnityReformReasonFragment();
        fragment.setArguments(args);
        return fragment;
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
            for (int i = 0; i < podiumSelected.length; i++) {
                String pos = podiumSelected[i];
                String position = positions[i];
                switch (pos) {
                    case "Ampliar Cômodo":
                        answerRequests.add(new AnswerRequest(ampliarComodo.getQuestion(), ampliarComodo.getQuestionPartId(), position));
                        break;
                    case "Diminuir Cômodo":
                        answerRequests.add(new AnswerRequest(diminuirComodo.getQuestion(), diminuirComodo.getQuestionPartId(), position));
                        break;
                    case "Melhorar Acabamento":
                        answerRequests.add(new AnswerRequest(melhorarAcabamento.getQuestion(), melhorarAcabamento.getQuestionPartId(), position));
                        break;
                    case "Melhorar Conforto":
                        answerRequests.add(new AnswerRequest(melhorarConforto.getQuestion(), melhorarConforto.getQuestionPartId(), position));
                        break;
                    case "Problema Técnico":
                        answerRequests.add(new AnswerRequest(resolverProblema.getQuestion(), resolverProblema.getQuestionPartId(), position));
                        break;
                    case "Eliminar Cômodo":
                        answerRequests.add(new AnswerRequest(eliminar.getQuestion(), eliminar.getQuestionPartId(), position));
                        break;
                    case "Função do Cômodo":
                        answerRequests.add(new AnswerRequest(funcaoCondicao.getQuestion(), funcaoCondicao.getQuestionPartId(), position));
                        break;
                    case "Outros":
                        answerRequests.add(new AnswerRequest(outraRasao.getQuestion(), outraRasao.getQuestionPartId(), position));
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
            ((AboutYouActivity) getActivity()).addFragment(UnityReformssNeeds.newInstance((List<UnityAnswer>) getArguments().getSerializable("list")));
        }
    }

    @OnClick({R.id.btFirstOption, R.id.btSecondOption, R.id.btThirdOption, R.id.btForthOption,
            R.id.btFifthOption, R.id.btSixOption, R.id.btSevenOption, R.id.btEightOption})
    public void onClickOptions(View view) {
        Button textView = (Button) view;
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
