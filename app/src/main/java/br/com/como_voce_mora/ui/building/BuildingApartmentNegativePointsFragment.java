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
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.OnClick;

public class BuildingApartmentNegativePointsFragment extends BaseFragment {
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;
    @BindView(R.id.cpPodium)
    CustomPodium customPodium;
    @BindViews({R.id.btFirstOption, R.id.btSecondOption, R.id.btThirdOption, R.id.btForthOption,
            R.id.btFifthOption, R.id.btSixOption, R.id.btSevenOption})
    List<Button> mButtons;

    @BindView(R.id.tv_question)
    TextView tvQuestion;

    private List<AnswerRequest> answerRequests = new ArrayList<>();
    private BuildingAnswer houseGroupAnswer = BuildingAnswer.NEGATIVE_POINTS_LIVE_IN_APARTAMENT;
    private BuildingAnswer privacidade = BuildingAnswer.LACK_OF_PRIVATY_BBETWEEN_NEIGHBORS;
    private BuildingAnswer jardim = BuildingAnswer.LACK_OF_GARDEN;
    private BuildingAnswer dificuldadeReforma = BuildingAnswer.LIMITATIONS_TO_REFORMS_APARTAMENTS;
    private BuildingAnswer faltaSeguranca = BuildingAnswer.CONTROL_OF_SOCIAL_LIFE_BY_CONDOMINIUM;
    private BuildingAnswer faltaEspaco = BuildingAnswer.LACK_OF_SPACE_IN_APARTAMENT;
    private BuildingAnswer vidaSocial = BuildingAnswer.PUBLIC_SOCIAL_RELATIONSHIP;
    private BuildingAnswer outros = BuildingAnswer.OTHER_MOTIVE;


    public static BuildingApartmentNegativePointsFragment newInstance() {
        return new BuildingApartmentNegativePointsFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_apartment_negative_points;
    }

    @Override
    public void init() {
        tvQuestion.setText(houseGroupAnswer.getQuestion());
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.BUILDING);
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
        if (getActivity() != null) {
            setAnswers();
            ((AboutYouActivity) getActivity()).addFragment(BuildingFloorFragment.newInstance());
        }
    }

    private void setAnswers() {
        String[] podiumSelected = customPodium.getPodium();
        if (podiumSelected != null) {
            for (String pos : podiumSelected) {
                switch (pos) {
                    case "CONVIVIO SOCIAL COLETIVO":
                        answerRequests.add(new AnswerRequest(faltaSeguranca.getQuestion(), faltaSeguranca.getQuestionPartId(), pos));
                        break;
                    case "ESPAÇO REDUZIDO":
                        answerRequests.add(new AnswerRequest(faltaEspaco.getQuestion(), faltaEspaco.getQuestionPartId(), pos));
                        break;
                    case "LIMITAÇÃO A REFORMAS":
                        answerRequests.add(new AnswerRequest(dificuldadeReforma.getQuestion(), dificuldadeReforma.getQuestionPartId(), pos));
                        break;
                    case "AUSENCIA DE QUINTAL":
                        answerRequests.add(new AnswerRequest(jardim.getQuestion(), jardim.getQuestionPartId(), pos));
                        break;
                    case "FALTA DE PRIVACIDADE":
                        answerRequests.add(new AnswerRequest(privacidade.getQuestion(), privacidade.getQuestionPartId(), pos));
                        break;
                    case "VIDA SOCIAL CONTROLADA":
                        answerRequests.add(new AnswerRequest(vidaSocial.getQuestion(), vidaSocial.getQuestionPartId(), pos));
                        break;
                    case "OUTROS":
                        answerRequests.add(new AnswerRequest(outros.getQuestion(), outros.getQuestionPartId(), pos));
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
        Button textView = (Button) view;
        customPodium.putOnPodium(textView.getText().toString());
        textView.setVisibility(View.INVISIBLE);
    }


}
