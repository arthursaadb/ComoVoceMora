package br.com.como_voce_mora.ui.unity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.CustomSelectedView;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.model.UnityAnswer;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.building.BuildingReasonChoiceFragment;
import br.com.como_voce_mora.ui.building.BuildingSplashFragment;
import br.com.como_voce_mora.ui.currentresidence.WhatsYourSatisfactionFragment;
import butterknife.BindView;
import butterknife.OnClick;

import static br.com.como_voce_mora.model.UnityAnswer.CHARACTERISTICS_SATISFACTION_BALCONY;
import static br.com.como_voce_mora.model.UnityAnswer.CHARACTERISTICS_SATISFACTION_BATHROOM;
import static br.com.como_voce_mora.model.UnityAnswer.CHARACTERISTICS_SATISFACTION_BIGROOM;
import static br.com.como_voce_mora.model.UnityAnswer.CHARACTERISTICS_SATISFACTION_DINNERROOM;
import static br.com.como_voce_mora.model.UnityAnswer.CHARACTERISTICS_SATISFACTION_KITCHEN;
import static br.com.como_voce_mora.model.UnityAnswer.CHARACTERISTICS_SATISFACTION_ROOM;
import static br.com.como_voce_mora.model.UnityAnswer.CHARACTERISTICS_SATISFACTION_SERVICE_AREA;
import static br.com.como_voce_mora.model.UnityAnswer.CHARACTERISTICS_SATISFACTION_SINGLEROMM;

public class UnityRoomsFragment extends BaseFragment {
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;
    @BindView(R.id.tv_question)
    TextView tvQuestion;

    List<UnityAnswer> roomList = new ArrayList<>();
    List<AnswerRequest> answerRequests = new ArrayList<>();
    UnityAnswer question = UnityAnswer.EXISTING_ROOMS;
    private boolean anyOptionChecked = false;
    private AnswerRequest salaTvNao = new AnswerRequest(UnityAnswer.SALA_TV.getQuestion(), UnityAnswer.SALA_TV.getQuestionPartId(), "Não");
    private AnswerRequest cozinhaNao = new AnswerRequest(UnityAnswer.COZINHA.getQuestion(), UnityAnswer.COZINHA.getQuestionPartId(), "Não");
    private AnswerRequest quartoSolteiroNao = new AnswerRequest(UnityAnswer.QUARTO_SOLTEIRO.getQuestion(), UnityAnswer.QUARTO_SOLTEIRO.getQuestionPartId(), "Não");
    private AnswerRequest quartoCasalNao = new AnswerRequest(UnityAnswer.QUARTO_CASAL.getQuestion(), UnityAnswer.QUARTO_CASAL.getQuestionPartId(), "Não");
    private AnswerRequest salaJantarNao = new AnswerRequest(UnityAnswer.SALA_JANTAR.getQuestion(), UnityAnswer.SALA_JANTAR.getQuestionPartId(), "Não");
    private AnswerRequest banheirosNao = new AnswerRequest(UnityAnswer.BANHEIROS.getQuestion(), UnityAnswer.BANHEIROS.getQuestionPartId(), "Não");
    private AnswerRequest varandaNao = new AnswerRequest(UnityAnswer.VARANDA.getQuestion(), UnityAnswer.VARANDA.getQuestionPartId(), "Não");
    private AnswerRequest areaServicoNao = new AnswerRequest(UnityAnswer.AREA_SERVICO.getQuestion(), UnityAnswer.AREA_SERVICO.getQuestionPartId(), "Não");

    @Override
    public int getResLayout() {
        return R.layout.fragment_unity_rooms;
    }

    public static UnityRoomsFragment newInstance() {

        Bundle args = new Bundle();

        UnityRoomsFragment fragment = new UnityRoomsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void init() {
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.UNITY);
        tvQuestion.setText(question.getQuestion());
        initList();
    }

    private void initList() {
        answerRequests.add(salaTvNao);
        answerRequests.add(cozinhaNao);
        answerRequests.add(quartoSolteiroNao);
        answerRequests.add(quartoCasalNao);
        answerRequests.add(salaJantarNao);
        answerRequests.add(banheirosNao);
        answerRequests.add(varandaNao);
        answerRequests.add(areaServicoNao);
    }

    @OnClick({R.id.csvServico, R.id.csvBanheiro, R.id.csvCasal,
            R.id.csvSolteiro, R.id.csvSala, R.id.csvCopa, R.id.csvVaranda, R.id.csvCozinha})
    void onClickViews(View view) {
        anyOptionChecked = true;
        CustomSelectedView csv = (CustomSelectedView) view;
        if (!csv.isChecked()) {
            csv.setChecked(true);
            switch (view.getId()) {
                case R.id.csvServico:
                    roomList.add(CHARACTERISTICS_SATISFACTION_SERVICE_AREA);
                    answerRequests.remove(areaServicoNao);
                    answerRequests.add(new AnswerRequest(UnityAnswer.AREA_SERVICO.getQuestion(), UnityAnswer.AREA_SERVICO.getQuestionPartId(), "Sim"));
                    break;
                case R.id.csvBanheiro:
                    roomList.add(CHARACTERISTICS_SATISFACTION_BATHROOM);
                    answerRequests.remove(banheirosNao);
                    answerRequests.add(new AnswerRequest(UnityAnswer.BANHEIROS.getQuestion(), UnityAnswer.BANHEIROS.getQuestionPartId(), "Sim"));
                    break;
                case R.id.csvCasal:
                    roomList.add(CHARACTERISTICS_SATISFACTION_BIGROOM);
                    answerRequests.remove(quartoCasalNao);
                    answerRequests.add(new AnswerRequest(UnityAnswer.QUARTO_CASAL.getQuestion(), UnityAnswer.QUARTO_CASAL.getQuestionPartId(), "Sim"));
                    break;
                case R.id.csvSolteiro:
                    roomList.add(CHARACTERISTICS_SATISFACTION_SINGLEROMM);
                    answerRequests.remove(quartoSolteiroNao);
                    answerRequests.add(new AnswerRequest(UnityAnswer.QUARTO_SOLTEIRO.getQuestion(), UnityAnswer.QUARTO_SOLTEIRO.getQuestionPartId(), "Sim"));
                    break;
                case R.id.csvSala:
                    roomList.add(CHARACTERISTICS_SATISFACTION_ROOM);
                    answerRequests.remove(salaTvNao);
                    answerRequests.add(new AnswerRequest(UnityAnswer.SALA_TV.getQuestion(), UnityAnswer.SALA_TV.getQuestionPartId(), "Sim"));
                    break;
                case R.id.csvCopa:
                    roomList.add(CHARACTERISTICS_SATISFACTION_DINNERROOM);
                    answerRequests.remove(salaJantarNao);
                    answerRequests.add(new AnswerRequest(UnityAnswer.SALA_JANTAR.getQuestion(), UnityAnswer.SALA_JANTAR.getQuestionPartId(), "Sim"));
                    break;
                case R.id.csvVaranda:
                    roomList.add(CHARACTERISTICS_SATISFACTION_BALCONY);
                    answerRequests.remove(varandaNao);
                    answerRequests.add(new AnswerRequest(UnityAnswer.VARANDA.getQuestion(), UnityAnswer.VARANDA.getQuestionPartId(), "Sim"));
                    break;
                case R.id.csvCozinha:
                    roomList.add(CHARACTERISTICS_SATISFACTION_KITCHEN);
                    answerRequests.remove(cozinhaNao);
                    answerRequests.add(new AnswerRequest(UnityAnswer.COZINHA.getQuestion(), UnityAnswer.COZINHA.getQuestionPartId(), "Sim"));
                    break;
            }
        } else {
            csv.setChecked(false);

            switch (view.getId()) {
                case R.id.csvServico:
                    roomList.remove(CHARACTERISTICS_SATISFACTION_SERVICE_AREA);
                    answerRequests.add(areaServicoNao);
                    break;
                case R.id.csvBanheiro:
                    roomList.remove(CHARACTERISTICS_SATISFACTION_BATHROOM);
                    answerRequests.add(banheirosNao);
                    break;
                case R.id.csvCasal:
                    roomList.remove(CHARACTERISTICS_SATISFACTION_BIGROOM);
                    answerRequests.add(quartoCasalNao);
                    break;
                case R.id.csvSolteiro:
                    roomList.remove(CHARACTERISTICS_SATISFACTION_SINGLEROMM);
                    answerRequests.add(quartoSolteiroNao);
                    break;
                case R.id.csvSala:
                    roomList.remove(CHARACTERISTICS_SATISFACTION_ROOM);
                    answerRequests.add(salaTvNao);
                    break;
                case R.id.csvCopa:
                    roomList.remove(CHARACTERISTICS_SATISFACTION_DINNERROOM);
                    answerRequests.add(salaJantarNao);
                    break;
                case R.id.csvVaranda:
                    roomList.remove(CHARACTERISTICS_SATISFACTION_BALCONY);
                    answerRequests.add(varandaNao);
                    break;
                case R.id.csvCozinha:
                    roomList.remove(CHARACTERISTICS_SATISFACTION_KITCHEN);
                    answerRequests.add(cozinhaNao);
                    break;
            }
        }
    }


    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (anyOptionChecked) {
            setAnswer();
            ((AboutYouActivity) requireActivity()).addFragment(UnityRateRoomsFragment.newInstance(roomList));
        }
    }

    private void setAnswer() {
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

    @OnClick(R.id.btPreviousSession)
    public void onBtPreviouSessionClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) requireActivity()).addFragment(BuildingSplashFragment.newInstance());
        }
    }

}
