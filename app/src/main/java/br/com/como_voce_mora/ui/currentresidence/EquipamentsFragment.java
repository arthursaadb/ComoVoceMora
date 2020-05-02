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
    String answer = "";
    boolean anyOneSelected = false;

    private List<AnswerRequest> answerRequests = new ArrayList<>();
    private CurrentResidenceAnswer currentResidenceAnswer = CurrentResidenceAnswer.URBAN_EQUIPMENT;
    private CurrentResidenceAnswer saudeCurrentResidenceAnswer =CurrentResidenceAnswer.SAUDE;
    private CurrentResidenceAnswer escolaCurrentResidenceAnswer =CurrentResidenceAnswer.ESCOLA;
    private CurrentResidenceAnswer culturaCurrentResidenceAnswer = CurrentResidenceAnswer.CULTURA;
    private CurrentResidenceAnswer lazerCurrentResidenceAnswer = CurrentResidenceAnswer.LAZER;
    private CurrentResidenceAnswer esporteCurrentResidenceAnswer = CurrentResidenceAnswer.ESPORTE;
    private CurrentResidenceAnswer segurancaCurrentResidenceAnswer =CurrentResidenceAnswer.SEGURANCA;

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
        super.init();
    }

    @OnClick({R.id.csvSaude, R.id.csvEscola, R.id.csvCultura,
        R.id.csvLazer, R.id.csvEsporte, R.id.csvSeguranca})
    void onClickViews(View view) {
        CustomSelectedView csv = (CustomSelectedView) view;
        anyOneSelected = true;
        switch (view.getId()) {
            case R.id.csvSaude:
                if (!csv.isChecked()) {
                    csv.setChecked(true);
                    saude = csv.getText();
                    answerRequests.add(new AnswerRequest(saudeCurrentResidenceAnswer.getQuestion(), saudeCurrentResidenceAnswer.getQuestionPartId(), saude));
                    break;
                } else {
                    csv.setChecked(false);
                    removeItem(saudeCurrentResidenceAnswer.getQuestion());
                    break;
                }
            case R.id.csvEscola:
                if (!csv.isChecked()) {
                    csv.setChecked(true);
                    escola = csv.getText();
                    answerRequests.add(new AnswerRequest(escolaCurrentResidenceAnswer.getQuestion(),
                        escolaCurrentResidenceAnswer.getQuestionPartId(), escola));
                    break;
                } else {
                    csv.setChecked(false);
                    removeItem(escolaCurrentResidenceAnswer.getQuestion());
                }
            case R.id.csvCultura:
                if (!csv.isChecked()) {
                    csv.setChecked(true);
                    cultura = csv.getText();
                    answerRequests.add(new AnswerRequest(culturaCurrentResidenceAnswer.getQuestion(),
                        culturaCurrentResidenceAnswer.getQuestionPartId(), cultura));
                    break;
                } else {
                    csv.setChecked(false);
                    removeItem(culturaCurrentResidenceAnswer.getQuestion());
                }
            case R.id.csvLazer:
                if (!csv.isChecked()) {
                    csv.setChecked(true);
                    lazer = csv.getText();
                    answerRequests.add(new AnswerRequest(lazerCurrentResidenceAnswer.getQuestion(),
                        lazerCurrentResidenceAnswer.getQuestionPartId(), lazer));
                    break;
                } else {
                    csv.setChecked(false);
                    removeItem(lazerCurrentResidenceAnswer.getQuestion());
                }
            case R.id.csvEsporte:
                if (!csv.isChecked()) {
                    csv.setChecked(true);
                    esporte = csv.getText();
                    answerRequests.add(new AnswerRequest(esporteCurrentResidenceAnswer.getQuestion(),
                        esporteCurrentResidenceAnswer.getQuestionPartId(), esporte));
                    break;
                } else {
                    csv.setChecked(false);
                    removeItem(esporteCurrentResidenceAnswer.getQuestion());
                }
            case R.id.csvSeguranca:
                if (!csv.isChecked()) {
                    seguranca = csv.getText();
                    answerRequests.add(new AnswerRequest(segurancaCurrentResidenceAnswer.getQuestion(),
                        segurancaCurrentResidenceAnswer.getQuestionPartId(), seguranca));
                    break;
                } else {
                    csv.setChecked(false);
                    removeItem(segurancaCurrentResidenceAnswer.getQuestion());
                }
        }
    }

    private void removeItem(String question) {
        int cont = 0;
        int pos = cont;
        if (!answerRequests.isEmpty()) {
            for (AnswerRequest r : answerRequests) {
                if (r.getDwellerId().equals(question)) {
                    pos = cont;
                }
                cont++;
            }
            answerRequests.remove(pos);
        }
    }


    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (anyOneSelected) {
            setAnswer();
            ((AboutYouActivity) requireActivity()).addFragment(ComercialFragment.newInstance());
        }
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    private void setAnswer() {
        AnswerRequest answerRequest = new AnswerRequest(currentResidenceAnswer.getQuestion(), currentResidenceAnswer.getQuestionPartId(), "");
        ResearchFlow.addAnswer(currentResidenceAnswer.getQuestion(), answerRequest);
        for (AnswerRequest r : answerRequests) {
            ResearchFlow.addAnswer(r.getDwellerId(), r);
        }
    }
}
