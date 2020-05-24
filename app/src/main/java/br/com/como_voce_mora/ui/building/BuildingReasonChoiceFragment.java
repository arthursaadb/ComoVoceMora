package br.com.como_voce_mora.ui.building;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.CustomPodium;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.model.Answer;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.BuildingAnswer;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.OnClick;

public class BuildingReasonChoiceFragment extends BaseFragment {
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;
    @BindView(R.id.cpPodium)
    CustomPodium customPodium;
    @BindView(R.id.tv_question)
    TextView tvQuestion;
    @BindViews({R.id.btFirstOption, R.id.btSecondOption, R.id.btThirdOption, R.id.btForthOption,
            R.id.btFifthOption, R.id.btSixOption, R.id.btSevenOption})
    List<Button> mButtons;

    private List<AnswerRequest> answerRequests = new ArrayList<>();
    private BuildingAnswer houseGroupAnswer = BuildingAnswer.LIVED_IN_SAME_PLACE;
    private BuildingAnswer seguranca = BuildingAnswer.SECURITY;
    private BuildingAnswer qualidadeConstrucao = BuildingAnswer.CONSTRUCTION_QUALITY;
    private BuildingAnswer statusSocial = BuildingAnswer.SOCIAL_STATUS;
    private BuildingAnswer localizao = BuildingAnswer.LOCATION;
    private BuildingAnswer vista = BuildingAnswer.VIEW;
    private BuildingAnswer investimento = BuildingAnswer.INVESTIMENT;
    private BuildingAnswer outros = BuildingAnswer.OTHER;


    public static BuildingReasonChoiceFragment newInstance() {
        return new BuildingReasonChoiceFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_building_reason_choice;
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
            if (ResearchFlow.getHouse()) {
                ((AboutYouActivity) requireActivity()).addFragment(BuildingHouseNegativePointsFragment.newInstance());
            } else {
                ((AboutYouActivity) requireActivity()).addFragment(BuildingApartmentNegativePointsFragment.newInstance());
            }
        }
    }

    private void setAnswers() {
        String[] podiumSelected = customPodium.getPodium();
        for (String pos : podiumSelected) {
            switch (pos) {
                case "SEGURANÇA":
                    answerRequests.add(new AnswerRequest(seguranca.getQuestion(), seguranca.getQuestionPartId(), pos));
                    break;
                case "QUALIDADE":
                    answerRequests.add(new AnswerRequest(qualidadeConstrucao.getQuestion(), qualidadeConstrucao.getQuestionPartId(), pos));
                    break;
                case "STATUS SOCIAL":
                    answerRequests.add(new AnswerRequest(statusSocial.getQuestion(), statusSocial.getQuestionPartId(), pos));
                    break;
                case "VISTA PRIVILEGIADA":
                    answerRequests.add(new AnswerRequest(vista.getQuestion(), vista.getQuestionPartId(), pos));
                    break;
                case "LOCALIZAÇÃO":
                    answerRequests.add(new AnswerRequest(localizao.getQuestion(), localizao.getQuestionPartId(), pos));
                    break;
                case "INVESTIMENTOS":
                    answerRequests.add(new AnswerRequest(investimento.getQuestion(), investimento.getQuestionPartId(), pos));
                    break;
                case "OUTROS":
                    answerRequests.add(new AnswerRequest(outros.getQuestion(), outros.getQuestionPartId(), pos));
                    break;
            }
        }
        for (AnswerRequest r : answerRequests) {
            ResearchFlow.addAnswer(r.getDwellerId(), r);
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
