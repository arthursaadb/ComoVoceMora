package br.com.como_voce_mora.ui.currentresidence;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.CustomSelectedView;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.CurrentResidenceAnswer;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.ui.previoushouse.PreviousHomeSplashFragment;
import butterknife.BindView;
import butterknife.OnClick;

public class EquipamentsFragment extends BaseFragment {

    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar progressBar;
    @BindView(R.id.tv_question)
    TextView tvQuestion;
    private String saude = "";
    private String escola = "";
    private String cultura = "";
    private String lazer = "";
    private String esporte = "";
    private String seguranca = "";
    private Boolean recreation = false;

    private List<AnswerRequest> answerRequests = new ArrayList<>();

    private CurrentResidenceAnswer currentResidenceAnswer = CurrentResidenceAnswer.URBAN_EQUIPMENT;

    private CurrentResidenceAnswer saudeCurrentResidenceAnswer = CurrentResidenceAnswer.SAUDE;
    private CurrentResidenceAnswer escolaCurrentResidenceAnswer = CurrentResidenceAnswer.ESCOLA;
    private CurrentResidenceAnswer culturaCurrentResidenceAnswer = CurrentResidenceAnswer.CULTURA;
    private CurrentResidenceAnswer lazerCurrentResidenceAnswer = CurrentResidenceAnswer.LAZER;
    private CurrentResidenceAnswer esporteCurrentResidenceAnswer = CurrentResidenceAnswer.ESPORTE;
    private CurrentResidenceAnswer segurancaCurrentResidenceAnswer = CurrentResidenceAnswer.SEGURANCA;

    private AnswerRequest saudeNao = new AnswerRequest(saudeCurrentResidenceAnswer.getQuestion(), saudeCurrentResidenceAnswer.getQuestionPartId(), "Não");
    private AnswerRequest escolaNao = new AnswerRequest(escolaCurrentResidenceAnswer.getQuestion(), escolaCurrentResidenceAnswer.getQuestionPartId(), "Não");
    private AnswerRequest culturaNao = new AnswerRequest(culturaCurrentResidenceAnswer.getQuestion(), culturaCurrentResidenceAnswer.getQuestionPartId(), "Não");
    private AnswerRequest lazerNao = new AnswerRequest(lazerCurrentResidenceAnswer.getQuestion(), lazerCurrentResidenceAnswer.getQuestionPartId(), "Não");
    private AnswerRequest esporteNao = new AnswerRequest(esporteCurrentResidenceAnswer.getQuestion(), esporteCurrentResidenceAnswer.getQuestionPartId(), "Não");
    private AnswerRequest segurancaNao = new AnswerRequest(segurancaCurrentResidenceAnswer.getQuestion(), segurancaCurrentResidenceAnswer.getQuestionPartId(), "Não");

    private AnswerRequest saudeSim = new AnswerRequest(saudeCurrentResidenceAnswer.getQuestion(), saudeCurrentResidenceAnswer.getQuestionPartId(), "Sim");
    private AnswerRequest escolaSim = new AnswerRequest(escolaCurrentResidenceAnswer.getQuestion(), escolaCurrentResidenceAnswer.getQuestionPartId(), "Sim");
    private AnswerRequest culturaSim = new AnswerRequest(culturaCurrentResidenceAnswer.getQuestion(), culturaCurrentResidenceAnswer.getQuestionPartId(), "Sim");
    private AnswerRequest lazerSim = new AnswerRequest(lazerCurrentResidenceAnswer.getQuestion(), lazerCurrentResidenceAnswer.getQuestionPartId(), "Sim");
    private AnswerRequest esporteSim = new AnswerRequest(esporteCurrentResidenceAnswer.getQuestion(), esporteCurrentResidenceAnswer.getQuestionPartId(), "Sim");
    private AnswerRequest segurancaSim = new AnswerRequest(segurancaCurrentResidenceAnswer.getQuestion(), segurancaCurrentResidenceAnswer.getQuestionPartId(), "Sim");

    public static EquipamentsFragment newInstance() {

        Bundle args = new Bundle();

        EquipamentsFragment fragment = new EquipamentsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_equipaments;
    }

    @Override
    public void init() {
        tvQuestion.setText(currentResidenceAnswer.getQuestion());
        progressBar.setProgress(HowYouLiveProgressBar.HowYouLive.ACTUAL_RESIDENCE);
        initList();
    }

    private void initList() {
        answerRequests.add(saudeNao);
        answerRequests.add(escolaNao);
        answerRequests.add(culturaNao);
        answerRequests.add(lazerNao);
        answerRequests.add(esporteNao);
        answerRequests.add(segurancaNao);
    }

    @OnClick({R.id.csvSaude, R.id.csvEscola, R.id.csvCultura,
            R.id.csvLazer, R.id.csvEsporte, R.id.csvSeguranca})
    void onClickViews(View view) {
        CustomSelectedView csv = (CustomSelectedView) view;
        switch (view.getId()) {
            case R.id.csvSaude:
                if (!csv.isChecked()) {
                    csv.setChecked(true);
                    saude = csv.getText();
                    answerRequests.remove(saudeNao);
                    answerRequests.add(saudeSim);
                    break;
                } else {
                    csv.setChecked(false);
                    answerRequests.add(saudeNao);
                    answerRequests.remove(saudeSim);
                    break;
                }
            case R.id.csvEscola:
                if (!csv.isChecked()) {
                    csv.setChecked(true);
                    escola = csv.getText();
                    answerRequests.remove(escolaNao);
                    answerRequests.add(escolaSim);
                    break;
                } else {
                    csv.setChecked(false);
                    answerRequests.remove(escolaSim);
                    answerRequests.add(escolaNao);
                    break;
                }
            case R.id.csvCultura:
                if (!csv.isChecked()) {
                    csv.setChecked(true);
                    cultura = csv.getText();
                    answerRequests.remove(culturaNao);
                    answerRequests.add(culturaSim);
                    break;
                } else {
                    csv.setChecked(false);
                    answerRequests.add(culturaNao);
                    answerRequests.remove(culturaSim);
                    break;
                }
            case R.id.csvLazer:
                if (!csv.isChecked()) {
                    recreation = true;
                    csv.setChecked(true);
                    lazer = csv.getText();
                    answerRequests.remove(lazerNao);
                    answerRequests.add(lazerSim);
                    break;
                } else {
                    recreation = false;
                    csv.setChecked(false);
                    answerRequests.add(lazerNao);
                    answerRequests.remove(lazerSim);
                    break;
                }
            case R.id.csvEsporte:
                if (!csv.isChecked()) {
                    recreation = true;
                    csv.setChecked(true);
                    esporte = csv.getText();
                    answerRequests.remove(esporteNao);
                    answerRequests.add(esporteSim);
                    break;
                } else {
                    recreation = false;
                    answerRequests.add(esporteNao);
                    answerRequests.remove(esporteSim);
                    csv.setChecked(false);
                    break;
                }
            case R.id.csvSeguranca:
                if (!csv.isChecked()) {
                    csv.setChecked(true);
                    seguranca = csv.getText();
                    answerRequests.remove(segurancaNao);
                    answerRequests.add(segurancaSim);
                    break;
                } else {
                    csv.setChecked(false);
                    answerRequests.add(segurancaNao);
                    answerRequests.remove(segurancaSim);
                    break;
                }
        }
    }


    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (!answerRequests.isEmpty()) {
            setAnswer();
            if (recreation) {
                ((AboutYouActivity) requireActivity()).addFragment(WhatsYourSatisfactionFragment.newInstance());
            } else {
                ((AboutYouActivity) requireActivity()).addFragment(ComercialFragment.newInstance());
            }
        }
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    private void setAnswer() {
        for (AnswerRequest r : answerRequests) {
            ResearchFlow.addAnswer(r, this);
        }
    }

    @OnClick(R.id.btPreviousSession)
    public void onBtPreviouSessionClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) requireActivity()).addFragment(PreviousHomeSplashFragment.newInstance());
        }
    }
}
