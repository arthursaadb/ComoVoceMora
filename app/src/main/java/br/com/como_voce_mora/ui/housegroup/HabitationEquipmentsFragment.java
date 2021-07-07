package br.com.como_voce_mora.ui.housegroup;

import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.HouseGroupAnswer;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.custom.CustomSelectedView;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.ui.currentresidence.CurrentHomeFragment;
import butterknife.BindView;
import butterknife.OnClick;

public class HabitationEquipmentsFragment extends BaseFragment {

    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;
    @BindView(R.id.csvGamesRoom)
    CustomSelectedView csvGamesRoom;
    @BindView(R.id.csvGym)
    CustomSelectedView csvGymRoom;
    @BindView(R.id.csvPartyRoom)
    CustomSelectedView csvPartyRoom;
    @BindView(R.id.csvPoolPlusEighteen)
    CustomSelectedView csvPoolPlusEighteen;
    @BindView(R.id.csvGourmet)
    CustomSelectedView csvGourmet;
    @BindView(R.id.csvPlayGround)
    CustomSelectedView csvPlayGround;
    @BindView(R.id.csvSqaure)
    CustomSelectedView csvSquare;
    @BindView(R.id.csvChildPool)
    CustomSelectedView csvChildPool;
    @BindView(R.id.tv_question)
    TextView tvQuestion;

    private ArrayList<AnswerRequest> answerRequests = new ArrayList<>();
    private ArrayList<AnswerRequest> answerRequestsYes = new ArrayList<>();
    private HouseGroupAnswer houseGroupAnser = HouseGroupAnswer.CONDOMINIUM_PUBLIC_EQUIPMENT;

    private AnswerRequest academiaNao = new AnswerRequest(HouseGroupAnswer.ACADEMIA.getQuestion(), HouseGroupAnswer.ACADEMIA.getQuestionPartId(), "Não");
    private AnswerRequest salaoFestasNao = new AnswerRequest(HouseGroupAnswer.SALAO_DE_FESTAS.getQuestion(), HouseGroupAnswer.SALAO_DE_FESTAS.getQuestionPartId(), "Não");
    private AnswerRequest playgroundNao = new AnswerRequest(HouseGroupAnswer.PLAYGROUND.getQuestion(), HouseGroupAnswer.PLAYGROUND.getQuestionPartId(), "Não");
    private AnswerRequest quadraNao = new AnswerRequest(HouseGroupAnswer.QUADRA_DE_ESPORTES.getQuestion(), HouseGroupAnswer.QUADRA_DE_ESPORTES.getQuestionPartId(), "Não");
    private AnswerRequest salaJogosNao = new AnswerRequest(HouseGroupAnswer.SALAO_DE_JOGOS.getQuestion(), HouseGroupAnswer.SALAO_DE_JOGOS.getQuestionPartId(), "Não");
    private AnswerRequest gourmetNao = new AnswerRequest(HouseGroupAnswer.ESPACO_GOURMET.getQuestion(), HouseGroupAnswer.ESPACO_GOURMET.getQuestionPartId(), "Não");
    private AnswerRequest piscinaAdultoNao = new AnswerRequest(HouseGroupAnswer.PISCINA_ADULTO.getQuestion(), HouseGroupAnswer.PISCINA_ADULTO.getQuestionPartId(), "Não");
    private AnswerRequest piscinaInfantilNao = new AnswerRequest(HouseGroupAnswer.PISCINA_INFANTIL.getQuestion(), HouseGroupAnswer.PISCINA_INFANTIL.getQuestionPartId(), "Não");

    private AnswerRequest academiaSim = new AnswerRequest(HouseGroupAnswer.ACADEMIA.getQuestion(), HouseGroupAnswer.ACADEMIA.getQuestionPartId(), "Sim");
    private AnswerRequest salaoFestasSim = new AnswerRequest(HouseGroupAnswer.SALAO_DE_FESTAS.getQuestion(), HouseGroupAnswer.SALAO_DE_FESTAS.getQuestionPartId(), "Sim");
    private AnswerRequest playgroundSim = new AnswerRequest(HouseGroupAnswer.PLAYGROUND.getQuestion(), HouseGroupAnswer.PLAYGROUND.getQuestionPartId(), "Sim");
    private AnswerRequest quadraSim = new AnswerRequest(HouseGroupAnswer.QUADRA_DE_ESPORTES.getQuestion(), HouseGroupAnswer.QUADRA_DE_ESPORTES.getQuestionPartId(), "Sim");
    private AnswerRequest salaJogosSim = new AnswerRequest(HouseGroupAnswer.SALAO_DE_JOGOS.getQuestion(), HouseGroupAnswer.SALAO_DE_JOGOS.getQuestionPartId(), "Sim");
    private AnswerRequest gourmetSim = new AnswerRequest(HouseGroupAnswer.ESPACO_GOURMET.getQuestion(), HouseGroupAnswer.ESPACO_GOURMET.getQuestionPartId(), "Sim");
    private AnswerRequest piscinaAdultoSim = new AnswerRequest(HouseGroupAnswer.PISCINA_ADULTO.getQuestion(), HouseGroupAnswer.PISCINA_ADULTO.getQuestionPartId(), "Sim");
    private AnswerRequest piscinaInfantilSim = new AnswerRequest(HouseGroupAnswer.PISCINA_INFANTIL.getQuestion(), HouseGroupAnswer.PISCINA_INFANTIL.getQuestionPartId(), "Sim");

    public static HabitationEquipmentsFragment newInstance() {
        return new HabitationEquipmentsFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_habitation_equipaments;
    }

    @Override
    public void init() {
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.GROUP);
        tvQuestion.setText(houseGroupAnser.getQuestion());
        initList();
    }

    private void initList() {
        answerRequests.add(academiaNao);
        answerRequests.add(salaoFestasNao);
        answerRequests.add(playgroundNao);
        answerRequests.add(quadraNao);
        answerRequests.add(salaJogosNao);
        answerRequests.add(gourmetNao);
        answerRequests.add(piscinaAdultoNao);
        answerRequests.add(piscinaInfantilNao);
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        setAnswer();
        if (answerRequestsYes.isEmpty()) {
            ((AboutYouActivity) getActivity()).addFragment(HabitationAspectsFragment.newInstance());
        } else {
            ((AboutYouActivity) getActivity()).addFragment(HabitationEquipmentsSatisfactionFragment.newInstance(answerRequestsYes));
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


    @OnClick({R.id.csvGamesRoom, R.id.csvGym, R.id.csvPartyRoom, R.id.csvPoolPlusEighteen, R.id.csvGourmet,
            R.id.csvPlayGround, R.id.csvSqaure, R.id.csvChildPool})
    public void onClickViews(View view) {
        switch (view.getId()) {
            case R.id.csvGamesRoom:
                if (csvGamesRoom.isChecked()) {
                    csvGamesRoom.setChecked(false);
                    answerRequests.add(salaJogosNao);
                    answerRequests.remove(salaJogosSim);
                    answerRequestsYes.remove(salaJogosSim);

                } else {
                    answerRequests.remove(salaJogosNao);
                    answerRequests.add(salaJogosSim);
                    answerRequestsYes.add(salaJogosSim);
                    csvGamesRoom.setChecked(true);
                }
                break;
            case R.id.csvGym:
                if (csvGymRoom.isChecked()) {
                    answerRequests.add(academiaNao);
                    answerRequests.remove(academiaSim);
                    answerRequestsYes.remove(academiaSim);
                    csvGymRoom.setChecked(false);
                } else {
                    answerRequests.remove(academiaNao);
                    answerRequests.add(academiaSim);
                    answerRequestsYes.add(academiaSim);
                    answerRequests.add(new AnswerRequest(HouseGroupAnswer.ACADEMIA.getQuestion(), HouseGroupAnswer.ACADEMIA.getQuestionPartId(), "Sim"));
                    csvGymRoom.setChecked(true);
                }
                break;
            case R.id.csvPartyRoom:
                if (csvPartyRoom.isChecked()) {
                    answerRequests.add(salaoFestasNao);
                    answerRequests.remove(salaoFestasSim);
                    answerRequestsYes.remove(salaoFestasSim);
                    csvPartyRoom.setChecked(false);
                } else {
                    answerRequests.remove(salaoFestasNao);
                    answerRequests.add(salaoFestasSim);
                    answerRequestsYes.add(salaoFestasSim);
                    csvPartyRoom.setChecked(true);
                }
                break;
            case R.id.csvPoolPlusEighteen:
                if (csvPoolPlusEighteen.isChecked()) {
                    answerRequests.add(piscinaAdultoNao);
                    answerRequests.remove(piscinaAdultoSim);
                    answerRequestsYes.remove(piscinaAdultoSim);
                    csvPoolPlusEighteen.setChecked(false);
                } else {
                    answerRequests.remove(piscinaAdultoNao);
                    answerRequests.add(piscinaAdultoSim);
                    answerRequestsYes.add(piscinaAdultoSim);
                    csvPoolPlusEighteen.setChecked(true);
                }

                break;
            case R.id.csvGourmet:
                if (csvGourmet.isChecked()) {
                    answerRequests.add(gourmetNao);
                    answerRequests.remove(gourmetSim);
                    answerRequestsYes.remove(gourmetSim);
                    csvGourmet.setChecked(false);
                } else {
                    answerRequests.remove(gourmetNao);
                    answerRequests.add(gourmetSim);
                    answerRequestsYes.add(gourmetSim);
                    csvGourmet.setChecked(true);
                }
                break;
            case R.id.csvPlayGround:
                if (csvPlayGround.isChecked()) {
                    answerRequests.add(playgroundNao);
                    answerRequests.remove(playgroundSim);
                    answerRequestsYes.remove(playgroundSim);
                    csvPlayGround.setChecked(false);
                } else {
                    answerRequests.remove(playgroundNao);
                    answerRequests.add(playgroundSim);
                    answerRequestsYes.add(playgroundSim);
                    csvPlayGround.setChecked(true);
                }
                break;
            case R.id.csvSqaure:
                if (csvSquare.isChecked()) {
                    answerRequests.add(quadraNao);
                    answerRequests.remove(quadraSim);
                    answerRequestsYes.remove(quadraSim);
                    csvSquare.setChecked(false);
                } else {
                    answerRequests.remove(quadraNao);
                    answerRequests.add(quadraSim);
                    answerRequestsYes.add(quadraSim);
                    csvSquare.setChecked(true);
                }
                break;
            case R.id.csvChildPool:
                if (csvChildPool.isChecked()) {
                    answerRequests.add(piscinaInfantilNao);
                    answerRequests.remove(piscinaInfantilSim);
                    answerRequestsYes.remove(piscinaInfantilSim);
                    csvChildPool.setChecked(false);
                } else {
                    answerRequests.remove(piscinaInfantilNao);
                    answerRequests.add(piscinaInfantilSim);
                    answerRequestsYes.add(piscinaInfantilSim);
                    csvChildPool.setChecked(true);
                }
                break;
        }
    }

    @OnClick(R.id.btPreviousSession)
    public void onBtPreviouSessionClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) requireActivity()).addFragment(CurrentHomeFragment.newInstance());
        }
    }
}
