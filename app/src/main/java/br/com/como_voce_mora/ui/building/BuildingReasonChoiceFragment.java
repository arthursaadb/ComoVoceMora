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
import br.com.como_voce_mora.ui.housegroup.HouseGroupFragment;
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
    String positions[] = new String[]{"1o Lugar", "2 Lugar", "3 Lugar", "4 Lugar"};
    List<Integer> list = new ArrayList<>();
    private boolean anyOneSelected = false;
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
                if (ResearchFlow.getHouse()) {
                    ((AboutYouActivity) requireActivity()).addFragment(BuildingHouseNegativePointsFragment.newInstance());
                } else {
                    ((AboutYouActivity) requireActivity()).addFragment(BuildingApartmentNegativePointsFragment.newInstance());
                }
            }
        }
    }

    private void setAnswers() {
        String[] podiumSelected = customPodium.getPodium();
        for (int i = 0; i < podiumSelected.length; i++) {
            String pos = podiumSelected[i];
            String position = positions[i];
            switch (pos) {
                case "Segurança":
                    answerRequests.add(new AnswerRequest(seguranca.getQuestion(), seguranca.getQuestionPartId(), position));
                    break;
                case "Qualidade":
                    answerRequests.add(new AnswerRequest(qualidadeConstrucao.getQuestion(), qualidadeConstrucao.getQuestionPartId(), position));
                    break;
                case "Status Social":
                    answerRequests.add(new AnswerRequest(statusSocial.getQuestion(), statusSocial.getQuestionPartId(), position));
                    break;
                case "Vista Privilegiada":
                    answerRequests.add(new AnswerRequest(vista.getQuestion(), vista.getQuestionPartId(), position));
                    break;
                case "Localização":
                    answerRequests.add(new AnswerRequest(localizao.getQuestion(), localizao.getQuestionPartId(), position));
                    break;
                case "Investimentos":
                    answerRequests.add(new AnswerRequest(investimento.getQuestion(), investimento.getQuestionPartId(), position));
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
