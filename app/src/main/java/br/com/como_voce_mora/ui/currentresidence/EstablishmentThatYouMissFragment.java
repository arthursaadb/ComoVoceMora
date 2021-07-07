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
    private AnswerRequest bancoSim = new AnswerRequest(CurrentResidenceAnswer.BANCO.getQuestion(),
            CurrentResidenceAnswer.BANCO.getQuestionPartId(), "Sim");
    private AnswerRequest lotericaSim = new AnswerRequest(CurrentResidenceAnswer.LOTERICA.getQuestion(),
            CurrentResidenceAnswer.LOTERICA.getQuestionPartId(), "Sim");
    private AnswerRequest mercadoSim = new AnswerRequest(CurrentResidenceAnswer.MERCADO.getQuestion(),
            CurrentResidenceAnswer.MERCADO.getQuestionPartId(), "Sim");
    private AnswerRequest lojaSim = new AnswerRequest(CurrentResidenceAnswer.LOJA.getQuestion(),
            CurrentResidenceAnswer.LOJA.getQuestionPartId(), "Sim");
    private AnswerRequest farmaciaSim = new AnswerRequest(CurrentResidenceAnswer.FARMACIA.getQuestion(),
            CurrentResidenceAnswer.FARMACIA.getQuestionPartId(), "Sim");
    private AnswerRequest postoSim = new AnswerRequest(CurrentResidenceAnswer.POSTO_DE_GASOLINA.getQuestion(),
            CurrentResidenceAnswer.POSTO_DE_GASOLINA.getQuestionPartId(), "Sim");
    private AnswerRequest academiaSim = new AnswerRequest(CurrentResidenceAnswer.ACADEMIA.getQuestion(),
            CurrentResidenceAnswer.ACADEMIA.getQuestionPartId(), "Sim");
    private AnswerRequest padariaSim = new AnswerRequest(CurrentResidenceAnswer.PADARIA.getQuestion(),
            CurrentResidenceAnswer.PADARIA.getQuestionPartId(), "Sim");
    private AnswerRequest acougueSim = new AnswerRequest(CurrentResidenceAnswer.ACOUGUE.getQuestion(),
            CurrentResidenceAnswer.ACOUGUE.getQuestionPartId(), "Sim");
    private AnswerRequest restauranteSim = new AnswerRequest(CurrentResidenceAnswer.RESTAURANTE.getQuestion(),
            CurrentResidenceAnswer.RESTAURANTE.getQuestionPartId(), "Sim");
    private AnswerRequest outrosSim = new AnswerRequest(CurrentResidenceAnswer.OUTROS.getQuestion(),
            CurrentResidenceAnswer.OUTROS.getQuestionPartId(), "Sim");
    private AnswerRequest nenhumSim = new AnswerRequest(CurrentResidenceAnswer.NENHUM.getQuestion(),
            CurrentResidenceAnswer.NENHUM.getQuestionPartId(), "Sim");


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

        if (view.getId() != R.id.csvNenhum && answerRequests.contains(nenhumSim)) {
            answerRequests.remove(nenhumSim);
            answerRequests.add(nenhumNao);
        }

        switch (view.getId()) {
            case R.id.csvBanco:
                if (!csvBanco.isChecked()) {
                    csvBanco.setChecked(true);
                    banco = csvBanco.getText();
                    answerRequests.remove(bancoNao);
                    answerRequests.add(bancoSim);
                    csvNenhum.setChecked(false);
                    break;
                } else {
                    csvBanco.setChecked(false);
                    answerRequests.add(bancoNao);
                    answerRequests.remove(bancoSim);
                    break;
                }
            case R.id.csvLoterica:
                if (!csvLoterica.isChecked()) {
                    csvLoterica.setChecked(true);
                    loterica = csvLoterica.getText();
                    answerRequests.remove(lotericaNao);
                    answerRequests.add(lotericaSim);
                    csvNenhum.setChecked(false);
                    break;
                } else {
                    csvLoterica.setChecked(false);
                    answerRequests.add(lotericaNao);
                    answerRequests.remove(lotericaSim);
                    break;
                }
            case R.id.csvMercado:
                if (!csvMercado.isChecked()) {
                    csvMercado.setChecked(true);
                    mercado = csvMercado.getText();
                    answerRequests.remove(mercadoNao);
                    answerRequests.add(mercadoSim);
                    csvNenhum.setChecked(false);
                    break;
                } else {
                    csvMercado.setChecked(false);
                    answerRequests.add(mercadoNao);
                    answerRequests.remove(mercadoSim);
                    break;
                }
            case R.id.csvLoja:
                if (!csvLoja.isChecked()) {
                    csvLoja.setChecked(true);
                    loja = csvLoja.getText();
                    answerRequests.remove(lojaNao);
                    answerRequests.add(lojaSim);
                    csvNenhum.setChecked(false);
                    break;
                } else {
                    csvLoja.setChecked(false);
                    answerRequests.add(lojaNao);
                    answerRequests.remove(lojaSim);
                    break;
                }
            case R.id.csvFarmacia:
                if (!csvFarmacia.isChecked()) {
                    csvFarmacia.setChecked(true);
                    farmacia = csvFarmacia.getText();
                    answerRequests.remove(farmaciaNao);
                    answerRequests.add(farmaciaSim);
                    csvNenhum.setChecked(false);
                    break;
                } else {
                    csvFarmacia.setChecked(false);
                    answerRequests.add(farmaciaNao);
                    answerRequests.remove(farmaciaSim);
                    break;
                }
            case R.id.csvPosto:
                if (!csvPosto.isChecked()) {
                    csvPosto.setChecked(true);
                    posto = csvPosto.getText();
                    answerRequests.remove(postoNao);
                    answerRequests.add(postoSim);
                    csvNenhum.setChecked(false);
                    break;
                } else {
                    csvPosto.setChecked(false);
                    answerRequests.add(postoNao);
                    answerRequests.remove(postoSim);
                    break;
                }

            case R.id.csvAcademia:
                if (!csvAcademia.isChecked()) {
                    csvAcademia.setChecked(true);
                    academia = csvAcademia.getText();
                    answerRequests.remove(academiaNao);
                    answerRequests.add(academiaSim);
                    csvNenhum.setChecked(false);
                    break;
                } else {
                    csvAcademia.setChecked(false);
                    answerRequests.remove(academiaSim);
                    answerRequests.add(academiaNao);
                    break;
                }

            case R.id.csvPadaria:
                if (!csvPadaria.isChecked()) {
                    csvPadaria.setChecked(true);
                    padaria = csvPadaria.getText();
                    answerRequests.remove(padariaNao);
                    answerRequests.add(padariaSim);
                    csvNenhum.setChecked(false);
                    break;
                } else {
                    csvPadaria.setChecked(false);
                    answerRequests.remove(padariaSim);
                    answerRequests.add(padariaNao);
                    break;
                }

            case R.id.csvAcougue:
                if (!csvAcougue.isChecked()) {
                    csvAcougue.setChecked(true);
                    acougue = csvAcougue.getText();
                    answerRequests.remove(acougueNao);
                    answerRequests.add(acougueSim);
                    csvNenhum.setChecked(false);
                    break;
                } else {
                    csvAcougue.setChecked(false);
                    answerRequests.remove(acougueSim);
                    answerRequests.add(acougueNao);
                    break;
                }

            case R.id.csvRestaurante:
                if (!csvRestaurante.isChecked()) {
                    csvRestaurante.setChecked(true);
                    restaurante = csvRestaurante.getText();
                    answerRequests.remove(restauranteNao);
                    answerRequests.add(restauranteSim);
                    csvNenhum.setChecked(false);
                    break;
                } else {
                    csvRestaurante.setChecked(false);
                    answerRequests.remove(restauranteSim);
                    answerRequests.add(restauranteNao);
                    break;
                }

            case R.id.csvOutros:
                if (!csvOutros.isChecked()) {
                    csvOutros.setChecked(true);
                    outros = csvOutros.getText();
                    answerRequests.remove(outrosNao);
                    answerRequests.add(outrosSim);
                    csvNenhum.setChecked(false);
                    break;
                } else {
                    csvOutros.setChecked(false);
                    answerRequests.remove(outrosSim);
                    answerRequests.add(outrosNao);
                    break;
                }

            case R.id.csvNenhum:
                if (!csvNenhum.isChecked()) {
                    disableAll();
                    csvNenhum.setChecked(true);
                    nenhum = csvNenhum.getText();

                    answerRequests.add(nenhumSim);
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
                    break;
                } else {
                    csvNenhum.setChecked(false);
                    answerRequests.add(nenhumNao);
                    answerRequests.remove(nenhumSim);
                    break;
                }
        }
    }

    private void disableAll() {
        answerRequests.clear();
        csvBanco.setChecked(false);
        csvLoterica.setChecked(false);
        csvMercado.setChecked(false);
        csvLoja.setChecked(false);
        csvFarmacia.setChecked(false);
        csvPosto.setChecked(false);
        csvAcademia.setChecked(false);
        csvPadaria.setChecked(false);
        csvAcougue.setChecked(false);
        csvRestaurante.setChecked(false);
        csvOutros.setChecked(false);
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
