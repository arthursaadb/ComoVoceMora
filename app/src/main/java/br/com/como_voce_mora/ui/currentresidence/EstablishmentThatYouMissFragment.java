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
    @BindView(R.id.csvBanco)
    CustomSelectedView csvBanco;
    @BindView(R.id.csvLoterica)
    CustomSelectedView csvLoterica;
    @BindView(R.id.csvMercado)
    CustomSelectedView csvMercado;
    @BindView(R.id.csvLoja)
    CustomSelectedView csvLoja;
    @BindView(R.id.csvFarmacia)
    CustomSelectedView csvFarmacia;
    @BindView(R.id.csvPosto)
    CustomSelectedView csvPosto;
    @BindView(R.id.csvAcademia)
    CustomSelectedView csvAcademia;
    @BindView(R.id.csvPadaria)
    CustomSelectedView csvPadaria;
    @BindView(R.id.csvAcougue)
    CustomSelectedView csvAcougue;
    @BindView(R.id.csvRestaurante)
    CustomSelectedView csvRestaurante;
    @BindView(R.id.csvOutros)
    CustomSelectedView csvOutros;
    @BindView(R.id.csvNenhum)
    CustomSelectedView csvNenhum;

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
        anyOneSelected = true;
        switch (view.getId()) {
            case R.id.csvBanco:
                if (!csvBanco.isChecked()) {
                    csvBanco.setChecked(true);
                    banco = csvBanco.getText();
                    answerRequests.add(new AnswerRequest(CurrentResidenceAnswer.BANCO.getQuestion(),
                            CurrentResidenceAnswer.BANCO.getQuestionPartId(), "sim"));
                    break;
                } else {
                    csvBanco.setChecked(false);
                    answerRequests.add(new AnswerRequest(CurrentResidenceAnswer.BANCO.getQuestion(),
                            CurrentResidenceAnswer.BANCO.getQuestionPartId(), "não"));
                    break;
                }
            case R.id.csvLoterica:
                if (!csvLoterica.isChecked()) {
                    csvLoterica.setChecked(true);
                    loterica = csvLoterica.getText();
                    answerRequests.add(new AnswerRequest(CurrentResidenceAnswer.LOTERICA.getQuestion(),
                            CurrentResidenceAnswer.LOTERICA.getQuestionPartId(), "sim"));
                    break;
                } else {
                    csvLoterica.setChecked(false);
                    answerRequests.add(new AnswerRequest(CurrentResidenceAnswer.LOTERICA.getQuestion(),
                            CurrentResidenceAnswer.LOTERICA.getQuestionPartId(), "não"));
                    break;
                }
            case R.id.csvMercado:
                if (!csvMercado.isChecked()) {
                    csvMercado.setChecked(true);
                    mercado = csvMercado.getText();
                    answerRequests.add(new AnswerRequest(CurrentResidenceAnswer.MERCADO.getQuestion(),
                            CurrentResidenceAnswer.MERCADO.getQuestionPartId(), "sim"));
                    break;
                } else {
                    csvMercado.setChecked(false);
                    answerRequests.add(new AnswerRequest(CurrentResidenceAnswer.MERCADO.getQuestion(),
                            CurrentResidenceAnswer.MERCADO.getQuestionPartId(), "não"));
                    break;
                }
            case R.id.csvLoja:
                if (!csvLoja.isChecked()) {
                    csvLoja.setChecked(true);
                    loja = csvLoja.getText();
                    answerRequests.add(new AnswerRequest(CurrentResidenceAnswer.LOJA.getQuestion(),
                            CurrentResidenceAnswer.LOJA.getQuestionPartId(), "sim"));
                    break;
                } else {
                    csvLoja.setChecked(false);
                    answerRequests.add(new AnswerRequest(CurrentResidenceAnswer.LOJA.getQuestion(),
                            CurrentResidenceAnswer.LOJA.getQuestionPartId(), "não"));
                    break;
                }
            case R.id.csvFarmacia:
                if (!csvFarmacia.isChecked()) {
                    csvFarmacia.setChecked(true);
                    farmacia = csvFarmacia.getText();
                    answerRequests.add(new AnswerRequest(CurrentResidenceAnswer.FARMACIA.getQuestion(),
                            CurrentResidenceAnswer.FARMACIA.getQuestionPartId(), "sim"));
                    break;
                } else {
                    csvFarmacia.setChecked(false);
                    answerRequests.add(new AnswerRequest(CurrentResidenceAnswer.FARMACIA.getQuestion(),
                            CurrentResidenceAnswer.FARMACIA.getQuestionPartId(), "não"));
                    break;
                }
            case R.id.csvPosto:
                if (!csvPosto.isChecked()) {
                    csvPosto.setChecked(true);
                    posto = csvPosto.getText();
                    answerRequests.add(new AnswerRequest(CurrentResidenceAnswer.POSTO_DE_GASOLINA.getQuestion(),
                            CurrentResidenceAnswer.POSTO_DE_GASOLINA.getQuestionPartId(), "sim"));
                    break;
                } else {
                    csvPosto.setChecked(false);
                    answerRequests.add(new AnswerRequest(CurrentResidenceAnswer.POSTO_DE_GASOLINA.getQuestion(),
                            CurrentResidenceAnswer.POSTO_DE_GASOLINA.getQuestionPartId(), "não"));
                    break;
                }

            case R.id.csvAcademia:
                if (!csvAcademia.isChecked()) {
                    csvAcademia.setChecked(true);
                    academia = csvAcademia.getText();
                    answerRequests.add(new AnswerRequest(CurrentResidenceAnswer.ACADEMIA.getQuestion(),
                            CurrentResidenceAnswer.ACADEMIA.getQuestionPartId(), "sim"));
                    break;
                } else {
                    csvAcademia.setChecked(false);
                    answerRequests.add(new AnswerRequest(CurrentResidenceAnswer.ACADEMIA.getQuestion(),
                            CurrentResidenceAnswer.ACADEMIA.getQuestionPartId(), "não"));
                    break;
                }

            case R.id.csvPadaria:
                if (!csvPadaria.isChecked()) {
                    csvPadaria.setChecked(true);
                    padaria = csvPadaria.getText();
                    answerRequests.add(new AnswerRequest(CurrentResidenceAnswer.PADARIA.getQuestion(),
                            CurrentResidenceAnswer.PADARIA.getQuestionPartId(), "sim"));
                    break;
                } else {
                    csvPadaria.setChecked(false);
                    removeItem(CurrentResidenceAnswer.PADARIA.getQuestion());
                    answerRequests.add(new AnswerRequest(CurrentResidenceAnswer.PADARIA.getQuestion(),
                            CurrentResidenceAnswer.PADARIA.getQuestionPartId(), "não"));
                    break;
                }

            case R.id.csvAcougue:
                if (!csvAcougue.isChecked()) {
                    csvAcougue.setChecked(true);
                    acougue = csvAcougue.getText();
                    answerRequests.add(new AnswerRequest(CurrentResidenceAnswer.ACOUGUE.getQuestion(),
                            CurrentResidenceAnswer.ACOUGUE.getQuestionPartId(), "sim"));
                    break;
                } else {
                    csvAcougue.setChecked(false);
                    answerRequests.add(new AnswerRequest(CurrentResidenceAnswer.ACOUGUE.getQuestion(),
                            CurrentResidenceAnswer.ACOUGUE.getQuestionPartId(), "não"));
                    break;
                }

            case R.id.csvRestaurante:
                if (!csvRestaurante.isChecked()) {
                    csvRestaurante.setChecked(true);
                    restaurante = csvRestaurante.getText();
                    answerRequests.add(new AnswerRequest(CurrentResidenceAnswer.RESTAURANTE.getQuestion(),
                            CurrentResidenceAnswer.RESTAURANTE.getQuestionPartId(), "sim"));
                    break;
                } else {
                    csvRestaurante.setChecked(false);
                    answerRequests.add(new AnswerRequest(CurrentResidenceAnswer.RESTAURANTE.getQuestion(),
                            CurrentResidenceAnswer.RESTAURANTE.getQuestionPartId(), "não"));
                    break;
                }

            case R.id.csvOutros:
                if (!csvOutros.isChecked()) {
                    csvOutros.setChecked(true);
                    outros = csvOutros.getText();
                    answerRequests.add(new AnswerRequest(CurrentResidenceAnswer.OUTROS.getQuestion(),
                            CurrentResidenceAnswer.OUTROS.getQuestionPartId(), "sim"));
                    break;
                } else {
                    csvOutros.setChecked(false);
                    answerRequests.add(new AnswerRequest(CurrentResidenceAnswer.OUTROS.getQuestion(),
                            CurrentResidenceAnswer.OUTROS.getQuestionPartId(), "não"));
                    break;
                }

            case R.id.csvNenhum:
                if (!csvNenhum.isChecked()) {
                    csvNenhum.setChecked(true);
                    nenhum = csvNenhum.getText();
                    answerRequests.add(new AnswerRequest(CurrentResidenceAnswer.NENHUM.getQuestion(),
                            CurrentResidenceAnswer.NENHUM.getQuestionPartId(), "sim"));
                    break;
                } else {
                    csvNenhum.setChecked(false);
                    answerRequests.add(new AnswerRequest(CurrentResidenceAnswer.NENHUM.getQuestion(),
                            CurrentResidenceAnswer.NENHUM.getQuestionPartId(), "não"));
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
