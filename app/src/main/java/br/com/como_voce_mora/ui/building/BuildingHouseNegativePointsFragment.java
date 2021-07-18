package br.com.como_voce_mora.ui.building;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.CustomPodium;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.BuildingAnswer;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.housegroup.HouseGroupFragment;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.OnClick;

public class BuildingHouseNegativePointsFragment extends BaseFragment {
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;
    @BindView(R.id.cpPodium)
    CustomPodium customPodium;
    @BindViews({R.id.btFirstOption, R.id.btSecondOption, R.id.btThirdOption, R.id.btForthOption,
            R.id.btFifthOption, R.id.btSixOption, R.id.btSevenOption})
    List<Button> mButtons;
    @BindView(R.id.tv_question)
    TextView tvQuestion;
    List<Integer> list = new ArrayList<>();
    private boolean anyOneSelected = false;
    String positions[] = new String[]{"1o Lugar", "2 Lugar", "3 Lugar", "4 Lugar"};
    private List<AnswerRequest> answerRequests = new ArrayList<>();
    private BuildingAnswer houseGroupAnswer = BuildingAnswer.NEGATIVE_POINTS_LIVE_IN_HOUSE;
    private BuildingAnswer vizinhos = BuildingAnswer.COEXISTENCE_BBETWEEN_NEIGHBORS;
    private BuildingAnswer privacidade = BuildingAnswer.PRIVACY;
    private BuildingAnswer faltaSeguranca = BuildingAnswer.LACK_OF_SECURITY;
    private BuildingAnswer dificuldadeReforma = BuildingAnswer.LIMITATIONS_TO_REFORMS;
    private BuildingAnswer faltaEspaco = BuildingAnswer.LACK_OF_SPACE;
    private BuildingAnswer vidaSocial = BuildingAnswer.CONTROL_OF_SOCIAL_LIFE;
    private BuildingAnswer outros = BuildingAnswer.OTHER_NEGATIVE;


    public static BuildingHouseNegativePointsFragment newInstance() {
        return new BuildingHouseNegativePointsFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_house_negative_points;
    }

    @Override
    public void init() {
        tvQuestion.setText(houseGroupAnswer.getQuestion());
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.BUILDING);
        customPodium.setOnPodiumListener(xqdl -> {
            for (Button b : mButtons) {
                if (b.getText().equals(xqdl)) {
                    b.setVisibility(View.VISIBLE);
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i) == b.getId()) {
                            list.remove(i);
                            break;
                        }
                    }
                }
            }
        });
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (anyOneSelected && list.size() == 4) {
            if (getActivity() != null) {
                setAnswers();
                ((AboutYouActivity) getActivity()).addFragment(BuildingLotSatisfactionFragment.newInstance());
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
                    case "Falta de Segurança":
                        answerRequests.add(new AnswerRequest(faltaSeguranca.getQuestion(), faltaSeguranca.getQuestionPartId(), position));
                        break;
                    case "Espaço Reduzido":
                        answerRequests.add(new AnswerRequest(faltaEspaco.getQuestion(), faltaEspaco.getQuestionPartId(), position));
                        break;
                    case "Limitação à reformas":
                        answerRequests.add(new AnswerRequest(dificuldadeReforma.getQuestion(), dificuldadeReforma.getQuestionPartId(), position));
                        break;
                    case "Convivência com vizinhos":
                        answerRequests.add(new AnswerRequest(vizinhos.getQuestion(), vizinhos.getQuestionPartId(), position));
                        break;
                    case "Falta de Privacidade":
                        answerRequests.add(new AnswerRequest(privacidade.getQuestion(), privacidade.getQuestionPartId(), position));
                        break;
                    case "Vida Social Controlada":
                        answerRequests.add(new AnswerRequest(vidaSocial.getQuestion(), vidaSocial.getQuestionPartId(), position));
                        break;
                    case "Outros":
                        answerRequests.add(new AnswerRequest(outros.getQuestion(), outros.getQuestionPartId(), position));
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
            R.id.btFifthOption, R.id.btSixOption, R.id.btSevenOption})
    public void onClickOptions(View view) {
        anyOneSelected = true;
        Button textView = (Button) view;
        customPodium.putOnPodium(textView.getText().toString());
        textView.setVisibility(View.INVISIBLE);

        if (list.size() == 4) {
            TextView myTextView = (TextView) getView().findViewById(list.get(3));
            myTextView.setVisibility(View.VISIBLE);
            list.remove(3);
        }

        list.add(textView.getId());
    }

    @OnClick(R.id.btPreviousSession)
    public void onBtPreviouSessionClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) requireActivity()).addFragment(HouseGroupFragment.newInstance());
        }
    }
}
