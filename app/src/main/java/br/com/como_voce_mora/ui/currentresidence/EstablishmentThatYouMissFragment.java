package br.com.como_voce_mora.ui.currentresidence;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.CustomSelectedView;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.CurrentResidenceAnswer;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.previoushouse.PreviousHomeSplashFragment;
import butterknife.BindView;
import butterknife.OnClick;

public class EstablishmentThatYouMissFragment extends BaseFragment {
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar progressBar;
    @BindView(R.id.tv_question)
    TextView tvQuestion;
    private String banco = "";
    private String loterica = "";
    private String mercado = "";
    private String loja = "";
    private String farmacia = "";
    private String posto = "";
    private String academia = "";
    private String padaria = "";
    private String acougue = "";
    private String restaurante = "";
    private String outros = "";
    private String nenhum = "";
    String answer = "";
    boolean anyOneSelected = false;

    private List<AnswerRequest> answerRequests = new ArrayList<>();
    private CurrentResidenceAnswer currentResidenceAnswer = CurrentResidenceAnswer.COMMERCE_TYPE_MISSING;

    public static EstablishmentThatYouMissFragment newInstance() {

        Bundle args = new Bundle();

        EstablishmentThatYouMissFragment fragment = new EstablishmentThatYouMissFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_establishment_that_you_miss;
    }

    @Override
    public void init() {
        tvQuestion.setText(currentResidenceAnswer.getQuestion());
        progressBar.setProgress(HowYouLiveProgressBar.HowYouLive.ACTUAL_RESIDENCE);
    }

    @OnClick({R.id.csvBanco, R.id.csvLoterica, R.id.csvMercado,
            R.id.csvLoja, R.id.csvFarmacia, R.id.csvPosto, R.id.csvAcademia, R.id.csvPadaria,
            R.id.csvAcougue, R.id.csvRestaurante, R.id.csvOutros, R.id.csvNenhum})
    void onClickViews(View view) {
        CustomSelectedView csv = (CustomSelectedView) view;
        anyOneSelected = true;
        switch (view.getId()) {
            case R.id.csvBanco:
                if (!csv.isChecked()) {
                    csv.setChecked(true);
                    banco = csv.getText();
                    answerRequests.add(new AnswerRequest(currentResidenceAnswer.getQuestion(),
                            currentResidenceAnswer.getQuestionPartId(), banco));
                    break;
                } else {
                    csv.setChecked(false);
                    removeItem(currentResidenceAnswer.getQuestion());
                    break;
                }
            case R.id.csvLoterica:
                if (!csv.isChecked()) {
                    csv.setChecked(true);
                    loterica = csv.getText();
                    answerRequests.add(new AnswerRequest(currentResidenceAnswer.getQuestion(),
                            currentResidenceAnswer.getQuestionPartId(), loterica));
                    break;
                } else {
                    csv.setChecked(false);
                    removeItem(currentResidenceAnswer.getQuestion());
                    break;
                }
            case R.id.csvMercado:
                if (!csv.isChecked()) {
                    csv.setChecked(true);
                    mercado = csv.getText();
                    answerRequests.add(new AnswerRequest(currentResidenceAnswer.getQuestion(),
                            currentResidenceAnswer.getQuestionPartId(), mercado));
                    break;
                } else {
                    csv.setChecked(false);
                    removeItem(currentResidenceAnswer.getQuestion());
                    break;
                }
            case R.id.csvLoja:
                if (!csv.isChecked()) {
                    csv.setChecked(true);
                    loja = csv.getText();
                    answerRequests.add(new AnswerRequest(currentResidenceAnswer.getQuestion(),
                            currentResidenceAnswer.getQuestionPartId(), loja));
                    break;
                } else {
                    csv.setChecked(false);
                    removeItem(currentResidenceAnswer.getQuestion());
                    break;
                }
            case R.id.csvFarmacia:
                if (!csv.isChecked()) {
                    csv.setChecked(true);
                    farmacia = csv.getText();
                    answerRequests.add(new AnswerRequest(currentResidenceAnswer.getQuestion(),
                            currentResidenceAnswer.getQuestionPartId(), farmacia));
                    break;
                } else {
                    csv.setChecked(false);
                    removeItem(currentResidenceAnswer.getQuestion());
                    break;
                }
            case R.id.csvPosto:
                if (!csv.isChecked()) {
                    csv.setChecked(true);
                    posto = csv.getText();
                    answerRequests.add(new AnswerRequest(currentResidenceAnswer.getQuestion(),
                            currentResidenceAnswer.getQuestionPartId(), posto));
                    break;
                } else {
                    csv.setChecked(false);
                    removeItem(currentResidenceAnswer.getQuestion());
                    break;
                }

            case R.id.csvAcademia:
                if (!csv.isChecked()) {
                    csv.setChecked(true);
                    academia = csv.getText();
                    answerRequests.add(new AnswerRequest(currentResidenceAnswer.getQuestion(),
                            currentResidenceAnswer.getQuestionPartId(), academia));
                    break;
                } else {
                    csv.setChecked(false);
                    removeItem(currentResidenceAnswer.getQuestion());
                    break;
                }

            case R.id.csvPadaria:
                if (!csv.isChecked()) {
                    csv.setChecked(true);
                    padaria = csv.getText();
                    answerRequests.add(new AnswerRequest(currentResidenceAnswer.getQuestion(),
                            currentResidenceAnswer.getQuestionPartId(), padaria));
                    break;
                } else {
                    csv.setChecked(false);
                    removeItem(currentResidenceAnswer.getQuestion());
                    break;
                }

            case R.id.csvAcougue:
                if (!csv.isChecked()) {
                    csv.setChecked(true);
                    acougue = csv.getText();
                    answerRequests.add(new AnswerRequest(currentResidenceAnswer.getQuestion(),
                            currentResidenceAnswer.getQuestionPartId(), acougue));
                    break;
                } else {
                    csv.setChecked(false);
                    removeItem(currentResidenceAnswer.getQuestion());
                    break;
                }

            case R.id.csvRestaurante:
                if (!csv.isChecked()) {
                    csv.setChecked(true);
                    restaurante = csv.getText();
                    answerRequests.add(new AnswerRequest(currentResidenceAnswer.getQuestion(),
                            currentResidenceAnswer.getQuestionPartId(), restaurante));
                    break;
                } else {
                    csv.setChecked(false);
                    removeItem(currentResidenceAnswer.getQuestion());
                    break;
                }

            case R.id.csvOutros:
                if (!csv.isChecked()) {
                    csv.setChecked(true);
                    outros = csv.getText();
                    answerRequests.add(new AnswerRequest(currentResidenceAnswer.getQuestion(),
                            currentResidenceAnswer.getQuestionPartId(), outros));
                    break;
                } else {
                    csv.setChecked(false);
                    removeItem(currentResidenceAnswer.getQuestion());
                    break;
                }

            case R.id.csvNenhum:
                if (!csv.isChecked()) {
                    csv.setChecked(true);
                    nenhum = csv.getText();
                    answerRequests.add(new AnswerRequest(currentResidenceAnswer.getQuestion(),
                            currentResidenceAnswer.getQuestionPartId(), nenhum));
                    break;
                } else {
                    csv.setChecked(false);
                    removeItem(currentResidenceAnswer.getQuestion());
                    break;
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
            ((AboutYouActivity) requireActivity()).addFragment(ClassifyAspectesFragment.newInstance());
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
        ResearchFlow.addAnswer(answerRequest, this);
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
