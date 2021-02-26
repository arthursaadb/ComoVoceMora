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
    private AnswerRequest bancoNao = new AnswerRequest(CurrentResidenceAnswer.BANCO.getQuestion(),
            CurrentResidenceAnswer.BANCO.getQuestionPartId(), "Não");
    private AnswerRequest lotericaNao = new AnswerRequest(CurrentResidenceAnswer.LOTERICA.getQuestion(),
            CurrentResidenceAnswer.LOTERICA.getQuestionPartId(), "Não");
    private AnswerRequest mercadoNao = new AnswerRequest(CurrentResidenceAnswer.MERCADO.getQuestion(),
            CurrentResidenceAnswer.MERCADO.getQuestionPartId(), "Não");
    private AnswerRequest lojaNao = new AnswerRequest(CurrentResidenceAnswer.LOJA.getQuestion(),
            CurrentResidenceAnswer.LOJA.getQuestionPartId(), "Não");
    private AnswerRequest farmaciaNao = new AnswerRequest(CurrentResidenceAnswer.FARMACIA.getQuestion(),
            CurrentResidenceAnswer.FARMACIA.getQuestionPartId(), "Não");
    private AnswerRequest postoNao = new AnswerRequest(CurrentResidenceAnswer.POSTO_DE_GASOLINA.getQuestion(),
            CurrentResidenceAnswer.POSTO_DE_GASOLINA.getQuestionPartId(), "Não");
    private AnswerRequest academiaNao = new AnswerRequest(CurrentResidenceAnswer.ACADEMIA.getQuestion(),
            CurrentResidenceAnswer.ACADEMIA.getQuestionPartId(), "Não");
    private AnswerRequest padariaNao = new AnswerRequest(CurrentResidenceAnswer.PADARIA.getQuestion(),
            CurrentResidenceAnswer.PADARIA.getQuestionPartId(), "Não");
    private AnswerRequest acougueNao = new AnswerRequest(CurrentResidenceAnswer.ACOUGUE.getQuestion(),
            CurrentResidenceAnswer.ACOUGUE.getQuestionPartId(), "Não");
    private AnswerRequest restauranteNao = new AnswerRequest(CurrentResidenceAnswer.RESTAURANTE.getQuestion(),
            CurrentResidenceAnswer.RESTAURANTE.getQuestionPartId(), "Não");
    private AnswerRequest outrosNao = new AnswerRequest(CurrentResidenceAnswer.OUTROS.getQuestion(),
            CurrentResidenceAnswer.OUTROS.getQuestionPartId(), "Não");
    private AnswerRequest nenhumNao = new AnswerRequest(CurrentResidenceAnswer.NENHUM.getQuestion(),
            CurrentResidenceAnswer.NENHUM.getQuestionPartId(), "Não");


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
        initList();
    }

    private void initList() {
        answerRequests.add(bancoNao);
        answerRequests.add(lotericaNao);
        answerRequests.add(mercadoNao);
        answerRequests.add(lojaNao);
        answerRequests.add(farmaciaNao);
        answerRequests.add(postoNao);
        answerRequests.add(academiaNao);
        answerRequests.add(padariaNao);
        answerRequests.add(acougueNao);
        answerRequests.add(restauranteNao);
        answerRequests.add(outrosNao);
        answerRequests.add(nenhumNao);
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
                    answerRequests.remove(bancoNao);
                    answerRequests.add(new AnswerRequest(CurrentResidenceAnswer.BANCO.getQuestion(),
                            CurrentResidenceAnswer.BANCO.getQuestionPartId(), "Sim"));
                    csvNenhum.setChecked(false);
                    break;
                } else {
                    csvBanco.setChecked(false);
                    answerRequests.add(bancoNao);
                    break;
                }
            case R.id.csvLoterica:
                if (!csvLoterica.isChecked()) {
                    csvLoterica.setChecked(true);
                    loterica = csvLoterica.getText();
                    answerRequests.remove(lotericaNao);
                    answerRequests.add(new AnswerRequest(CurrentResidenceAnswer.LOTERICA.getQuestion(),
                            CurrentResidenceAnswer.LOTERICA.getQuestionPartId(), "Sim"));
                    csvNenhum.setChecked(false);
                    break;
                } else {
                    csvLoterica.setChecked(false);
                    answerRequests.add(lotericaNao);
                    break;
                }
            case R.id.csvMercado:
                if (!csvMercado.isChecked()) {
                    csvMercado.setChecked(true);
                    mercado = csvMercado.getText();
                    answerRequests.remove(mercadoNao);
                    answerRequests.add(new AnswerRequest(CurrentResidenceAnswer.MERCADO.getQuestion(),
                            CurrentResidenceAnswer.MERCADO.getQuestionPartId(), "Sim"));
                    csvNenhum.setChecked(false);
                    break;
                } else {
                    csvMercado.setChecked(false);
                    answerRequests.add(mercadoNao);
                    break;
                }
            case R.id.csvLoja:
                if (!csvLoja.isChecked()) {
                    csvLoja.setChecked(true);
                    loja = csvLoja.getText();
                    answerRequests.remove(lojaNao);
                    answerRequests.add(new AnswerRequest(CurrentResidenceAnswer.LOJA.getQuestion(),
                            CurrentResidenceAnswer.LOJA.getQuestionPartId(), "Sim"));
                    csvNenhum.setChecked(false);
                    break;
                } else {
                    csvLoja.setChecked(false);
                    answerRequests.add(lojaNao);
                    break;
                }
            case R.id.csvFarmacia:
                if (!csvFarmacia.isChecked()) {
                    csvFarmacia.setChecked(true);
                    farmacia = csvFarmacia.getText();
                    answerRequests.remove(farmaciaNao);
                    answerRequests.add(new AnswerRequest(CurrentResidenceAnswer.FARMACIA.getQuestion(),
                            CurrentResidenceAnswer.FARMACIA.getQuestionPartId(), "Sim"));
                    csvNenhum.setChecked(false);
                    break;
                } else {
                    csvFarmacia.setChecked(false);
                    answerRequests.add(farmaciaNao);
                    break;
                }
            case R.id.csvPosto:
                if (!csvPosto.isChecked()) {
                    csvPosto.setChecked(true);
                    posto = csvPosto.getText();
                    answerRequests.remove(postoNao);
                    answerRequests.add(new AnswerRequest(CurrentResidenceAnswer.POSTO_DE_GASOLINA.getQuestion(),
                            CurrentResidenceAnswer.POSTO_DE_GASOLINA.getQuestionPartId(), "Sim"));
                    csvNenhum.setChecked(false);
                    break;
                } else {
                    csvPosto.setChecked(false);
                    answerRequests.add(postoNao);
                    break;
                }

            case R.id.csvAcademia:
                if (!csvAcademia.isChecked()) {
                    csvAcademia.setChecked(true);
                    academia = csvAcademia.getText();
                    answerRequests.remove(academiaNao);
                    answerRequests.add(new AnswerRequest(CurrentResidenceAnswer.ACADEMIA.getQuestion(),
                            CurrentResidenceAnswer.ACADEMIA.getQuestionPartId(), "Sim"));
                    csvNenhum.setChecked(false);
                    break;
                } else {
                    csvAcademia.setChecked(false);
                    answerRequests.add(academiaNao);
                    break;
                }

            case R.id.csvPadaria:
                if (!csvPadaria.isChecked()) {
                    csvPadaria.setChecked(true);
                    padaria = csvPadaria.getText();
                    answerRequests.remove(padariaNao);
                    answerRequests.add(new AnswerRequest(CurrentResidenceAnswer.PADARIA.getQuestion(),
                            CurrentResidenceAnswer.PADARIA.getQuestionPartId(), "Sim"));
                    csvNenhum.setChecked(false);
                    break;
                } else {
                    csvPadaria.setChecked(false);
                    answerRequests.add(padariaNao);
                    break;
                }

            case R.id.csvAcougue:
                if (!csvAcougue.isChecked()) {
                    csvAcougue.setChecked(true);
                    acougue = csvAcougue.getText();
                    answerRequests.remove(acougueNao);
                    answerRequests.add(new AnswerRequest(CurrentResidenceAnswer.ACOUGUE.getQuestion(),
                            CurrentResidenceAnswer.ACOUGUE.getQuestionPartId(), "Sim"));
                    csvNenhum.setChecked(false);
                    break;
                } else {
                    csvAcougue.setChecked(false);
                    answerRequests.add(acougueNao);
                    break;
                }

            case R.id.csvRestaurante:
                if (!csvRestaurante.isChecked()) {
                    csvRestaurante.setChecked(true);
                    restaurante = csvRestaurante.getText();
                    answerRequests.remove(restauranteNao);
                    answerRequests.add(new AnswerRequest(CurrentResidenceAnswer.RESTAURANTE.getQuestion(),
                            CurrentResidenceAnswer.RESTAURANTE.getQuestionPartId(), "Sim"));
                    csvNenhum.setChecked(false);
                    break;
                } else {
                    csvRestaurante.setChecked(false);
                    answerRequests.add(restauranteNao);
                    break;
                }

            case R.id.csvOutros:
                if (!csvOutros.isChecked()) {
                    csvOutros.setChecked(true);
                    outros = csvOutros.getText();
                    answerRequests.remove(outrosNao);
                    answerRequests.add(new AnswerRequest(CurrentResidenceAnswer.OUTROS.getQuestion(),
                            CurrentResidenceAnswer.OUTROS.getQuestionPartId(), "Sim"));
                    csvNenhum.setChecked(false);
                    break;
                } else {
                    csvOutros.setChecked(false);
                    answerRequests.add(outrosNao);
                    break;
                }

            case R.id.csvNenhum:
                if (!csvNenhum.isChecked()) {
                    csvNenhum.setChecked(true);
                    disableAll();
                    nenhum = csvNenhum.getText();
                    answerRequests.remove(nenhumNao);
                    answerRequests.add(new AnswerRequest(CurrentResidenceAnswer.NENHUM.getQuestion(),
                            CurrentResidenceAnswer.NENHUM.getQuestionPartId(), "Sim"));
                    break;
                } else {
                    csvNenhum.setChecked(false);
                    answerRequests.add(nenhumNao);
                    break;
                }
        }
    }

    private void disableAll() {
        csvBanco.setChecked(false);
        answerRequests.add(bancoNao);
        csvLoterica.setChecked(false);
        answerRequests.add(lotericaNao);
        csvMercado.setChecked(false);
        answerRequests.add(mercadoNao);
        csvLoja.setChecked(false);
        answerRequests.add(lojaNao);
        csvFarmacia.setChecked(false);
        answerRequests.add(farmaciaNao);
        csvPosto.setChecked(false);
        answerRequests.add(postoNao);
        csvAcademia.setChecked(false);
        answerRequests.add(academiaNao);
        csvPadaria.setChecked(false);
        answerRequests.add(padariaNao);
        csvAcougue.setChecked(false);
        answerRequests.add(acougueNao);
        csvRestaurante.setChecked(false);
        answerRequests.add(restauranteNao);
        csvOutros.setChecked(false);
        answerRequests.add(outrosNao);
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
