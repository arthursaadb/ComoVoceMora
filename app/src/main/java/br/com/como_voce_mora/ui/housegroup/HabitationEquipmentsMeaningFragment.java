package br.com.como_voce_mora.ui.housegroup;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.CustomPodium;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.building.BuildingFloorFragment;
import br.com.como_voce_mora.ui.currentresidence.CurrentHomeFragment;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.OnClick;

import static br.com.como_voce_mora.model.HouseGroupAnswer.FACILITY_IMPORTANCE;
import static br.com.como_voce_mora.model.HouseGroupAnswer.LIFE_QUALITY_IMPORTANCE;
import static br.com.como_voce_mora.model.HouseGroupAnswer.MONEY_IMPORTANCE;
import static br.com.como_voce_mora.model.HouseGroupAnswer.NO_IMPORTANCE;
import static br.com.como_voce_mora.model.HouseGroupAnswer.OTHER_MOTIVE_IMPORTANCE;
import static br.com.como_voce_mora.model.HouseGroupAnswer.PRIVACY_IMPORTANCE;
import static br.com.como_voce_mora.model.HouseGroupAnswer.SECURITY_IMPORTANCE;
import static br.com.como_voce_mora.model.HouseGroupAnswer.SOCIAL_STATUS_IMPORTANCE;
import static br.com.como_voce_mora.model.UnityAnswer.INVESTIMENTO;
import static br.com.como_voce_mora.model.UnityAnswer.LOCAL_ATIVIDADES;
import static br.com.como_voce_mora.model.UnityAnswer.LOCAL_COM_O_QUE_MAIS_ME_IDENTIFICO;
import static br.com.como_voce_mora.model.UnityAnswer.LOCAL_DURMO;
import static br.com.como_voce_mora.model.UnityAnswer.LOCAL_EM_QUE_PASSO_MAIS_TEMPO;
import static br.com.como_voce_mora.model.UnityAnswer.LOCAL_PERTENCES;
import static br.com.como_voce_mora.model.UnityAnswer.LOCAL_PESSOAS_INTERESSAM;
import static br.com.como_voce_mora.model.UnityAnswer.LOCAL_SEGURO;
import static br.com.como_voce_mora.model.UnityAnswer.OUTRO;

public class HabitationEquipmentsMeaningFragment extends BaseFragment {
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;
    @BindView(R.id.cpPodium)
    CustomPodium customPodium;
    @BindViews({R.id.btFirstOption, R.id.btSecondOption, R.id.btThirdOption, R.id.btForthOption,
            R.id.btFifthOption, R.id.btSixOption, R.id.btSevenOption, R.id.btTenOption})
    List<Button> mButtons;
    @BindView(R.id.tv_question)
    TextView tvQuestion;

    private boolean anyOptionChecked = false;
    String positions[] = new String[]{"1o Lugar", "2 Lugar", "3 Lugar", "4 Lugar"};
    List<Integer> list = new ArrayList<>();
    private List<AnswerRequest> answerRequests = new ArrayList<>();

    public static HabitationEquipmentsMeaningFragment newInstance() {
        Bundle args = new Bundle();
        HabitationEquipmentsMeaningFragment fragment = new HabitationEquipmentsMeaningFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public int getResLayout() {
        return R.layout.fragment_habitation_equipments_meaning;
    }

    @Override
    public void init() {
        tvQuestion.setText("Para você, o que significa a presença de equipamentos de uso comum em um edifício?");
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
        if (anyOptionChecked && list.size() > 0) {
            if (getActivity() != null) {
                setAnswers();
                ((AboutYouActivity) getActivity()).addFragment(HabitationGreenAreaFragment.newInstance());
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
                    case "Qualidade de vida":
                        answerRequests.add(new AnswerRequest(LIFE_QUALITY_IMPORTANCE.getQuestion(), LIFE_QUALITY_IMPORTANCE.getQuestionPartId(), position));
                        break;
                    case "Não significa nada":
                        answerRequests.add(new AnswerRequest(NO_IMPORTANCE.getQuestion(), NO_IMPORTANCE.getQuestionPartId(), position));
                        break;
                    case "Status Social":
                        answerRequests.add(new AnswerRequest(SOCIAL_STATUS_IMPORTANCE.getQuestion(), SOCIAL_STATUS_IMPORTANCE.getQuestionPartId(), position));
                        break;
                    case "Privacidade":
                        answerRequests.add(new AnswerRequest(PRIVACY_IMPORTANCE.getQuestion(), PRIVACY_IMPORTANCE.getQuestionPartId(), position));
                        break;
                    case "Valor Comercial":
                        answerRequests.add(new AnswerRequest(MONEY_IMPORTANCE.getQuestion(), MONEY_IMPORTANCE.getQuestionPartId(), position));
                        break;
                    case "Praticidade de vida":
                        answerRequests.add(new AnswerRequest(FACILITY_IMPORTANCE.getQuestion(), FACILITY_IMPORTANCE.getQuestionPartId(), position));
                        break;
                    case "Segurança":
                        answerRequests.add(new AnswerRequest(SECURITY_IMPORTANCE.getQuestion(), SECURITY_IMPORTANCE.getQuestionPartId(), position));
                        break;
                    case "Outros":
                        answerRequests.add(new AnswerRequest(OTHER_MOTIVE_IMPORTANCE.getQuestion(), OTHER_MOTIVE_IMPORTANCE.getQuestionPartId(), position));
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
            R.id.btFifthOption, R.id.btSixOption, R.id.btSevenOption, R.id.btTenOption})
    public void onClickOptions(View view) {
        anyOptionChecked = true;
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
            ((AboutYouActivity) requireActivity()).addFragment(CurrentHomeFragment.newInstance());
        }
    }
}