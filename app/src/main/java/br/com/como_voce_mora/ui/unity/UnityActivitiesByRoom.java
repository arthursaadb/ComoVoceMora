package br.com.como_voce_mora.ui.unity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.Serializable;
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
import br.com.como_voce_mora.ui.building.BuildingSplashFragment;
import br.com.como_voce_mora.ui.sustainablehabits.SustainableHabitsIntroFragment;
import butterknife.BindView;
import butterknife.OnClick;

import static br.com.como_voce_mora.model.UnityAnswer.BALCONY_ACTIVITIES;
import static br.com.como_voce_mora.model.UnityAnswer.BATHROOM_ACTIVITIES;
import static br.com.como_voce_mora.model.UnityAnswer.BIGROOM_ACTIVITIES;
import static br.com.como_voce_mora.model.UnityAnswer.CHARACTERISTICS_SATISFACTION_BALCONY;
import static br.com.como_voce_mora.model.UnityAnswer.CHARACTERISTICS_SATISFACTION_BATHROOM;
import static br.com.como_voce_mora.model.UnityAnswer.CHARACTERISTICS_SATISFACTION_BIGROOM;
import static br.com.como_voce_mora.model.UnityAnswer.CHARACTERISTICS_SATISFACTION_DINNERROOM;
import static br.com.como_voce_mora.model.UnityAnswer.CHARACTERISTICS_SATISFACTION_KITCHEN;
import static br.com.como_voce_mora.model.UnityAnswer.CHARACTERISTICS_SATISFACTION_ROOM;
import static br.com.como_voce_mora.model.UnityAnswer.CHARACTERISTICS_SATISFACTION_SERVICE_AREA;
import static br.com.como_voce_mora.model.UnityAnswer.CHARACTERISTICS_SATISFACTION_SINGLEROMM;
import static br.com.como_voce_mora.model.UnityAnswer.DINNERROOM_ACTIVITIES;
import static br.com.como_voce_mora.model.UnityAnswer.KITCHEN_ACTIVITIES;
import static br.com.como_voce_mora.model.UnityAnswer.ROOM_ACTIVITIES;
import static br.com.como_voce_mora.model.UnityAnswer.SERVICE_AREA_ACTIVITIES;
import static br.com.como_voce_mora.model.UnityAnswer.SINGLEROMM_ACTIVITIES;

public class UnityActivitiesByRoom extends BaseFragment {

    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;
    @BindView(R.id.csv1)
    CustomSelectedView csv1;
    @BindView(R.id.csv2)
    CustomSelectedView csv2;
    @BindView(R.id.csv3)
    CustomSelectedView csv3;
    @BindView(R.id.csv4)
    CustomSelectedView csv4;
    @BindView(R.id.csv5)
    CustomSelectedView csv5;
    @BindView(R.id.csv6)
    CustomSelectedView csv6;
    @BindView(R.id.csv7)
    CustomSelectedView csv7;
    @BindView(R.id.csv8)
    CustomSelectedView csv8;
    @BindView(R.id.csv9)
    CustomSelectedView csv9;
    @BindView(R.id.csv10)
    CustomSelectedView csv10;
    @BindView(R.id.csv11)
    CustomSelectedView csv11;
    @BindView(R.id.csv12)
    CustomSelectedView csv12;
    @BindView(R.id.tv_question)
    TextView tvQuestion;

    private StringBuilder answerRequests = new StringBuilder();
    private UnityAnswer roomTypeActivity;
    private UnityAnswer roomType;
    private List<UnityAnswer> listRoomType;

    public static UnityActivitiesByRoom newInstance(List<UnityAnswer> room) {

        Bundle args = new Bundle();
        args.putSerializable("list", (Serializable) room);
        UnityActivitiesByRoom fragment = new UnityActivitiesByRoom();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getResLayout() {
        return R.layout.unity_activities_by_room;
    }

    @Override
    public void init() {
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.UNITY);
        listRoomType = (List<UnityAnswer>) getArguments().getSerializable("list");
        roomType = listRoomType.get(0);
        listRoomType.remove(0);
        configQuestionAndImages();
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (getActivity() != null) {
            setAnswer();
            if (listRoomType.isEmpty()) {
                ((AboutYouActivity) requireActivity()).addFragment(SustainableHabitsIntroFragment.newInstance());
            } else {
                ((AboutYouActivity) getActivity()).addFragment(UnityActivitiesByRoom.newInstance(listRoomType));
            }
        }
    }

    private void configQuestionAndImages() {
        if (roomType == CHARACTERISTICS_SATISFACTION_BATHROOM) {
            roomTypeActivity = BATHROOM_ACTIVITIES;
            tvQuestion.setText(BATHROOM_ACTIVITIES.getQuestion());
            csv1.setImage(R.drawable.estender_roupa);
            csv1.setText("ESTENDER A ROUPA");
            csv2.setImage(R.drawable.armazenar_coisas);
            csv2.setText("ARMAZENAR COISAS");
            csv3.setImage(R.drawable.passar_roupa);
            csv3.setText("PASSAR A ROUPA");
            csv4.setImage(R.drawable.receber_pessoas);
            csv4.setText("RECEBER CONVIDADOS");
            csv5.setImage(R.drawable.usar_computador);
            csv5.setText("USAR COMPUTADOR/CELULAR");
            csv6.setImage(R.drawable.trabalhos_manuais);
            csv6.setText("FAZER TRABALHOS MANUAIS");
            csv7.setImage(R.drawable.tocar);
            csv7.setText("TOCAR INSTRUMENTO");
            csv8.setImage(R.drawable.ler);
            csv8.setText("LER/ESTUDAR");
            csv9.setImage(R.drawable.cochilar);
            csv9.setText("COCHILAR");
            csv10.setImage(R.drawable.outros);
            csv10.setText("OUTROS");
            csv11.setImage(R.drawable.jogar);
            csv11.setText("JOGAR");
            csv12.setImage(R.drawable.nenhum);
            csv12.setText("NENHUM");
        } else if (roomType == CHARACTERISTICS_SATISFACTION_BIGROOM) {
            roomTypeActivity = BIGROOM_ACTIVITIES;
            tvQuestion.setText(BIGROOM_ACTIVITIES.getQuestion());
            csv1.setImage(R.drawable.refeicao);
            csv1.setText("REFEIÇÃO RÁPIDA");
            csv2.setImage(R.drawable.armazenar_coisas);
            csv2.setText("ARMAZENAR COISAS");
            csv3.setImage(R.drawable.internet);
            csv3.setText("USAR INTERNET");
            csv4.setImage(R.drawable.receber_pessoas);
            csv4.setText("RECEBER CONVIDADOS");
            csv5.setImage(R.drawable.usar_computador);
            csv5.setText("USAR COMPUTADOR/CELULAR");
            csv6.setImage(R.drawable.trabalhar);
            csv6.setText("TRABALHAR");
            csv7.setImage(R.drawable.tocar);
            csv7.setText("TOCAR INSTRUMENTO");
            csv8.setImage(R.drawable.ler);
            csv8.setText("LER/ESTUDAR");
            csv9.setImage(R.drawable.trabalhos_manuais);
            csv9.setText("FAZER TRABALHOS MANUAIS");
            csv10.setImage(R.drawable.outros);
            csv10.setText("OUTROS");
            csv11.setImage(R.drawable.jogar);
            csv11.setText("JOGAR");
            csv12.setImage(R.drawable.nenhum);
            csv12.setText("NENHUM");
        } else if (roomType == CHARACTERISTICS_SATISFACTION_SINGLEROMM) {
            roomTypeActivity = SINGLEROMM_ACTIVITIES;
            tvQuestion.setText(SINGLEROMM_ACTIVITIES.getQuestion());
            csv1.setImage(R.drawable.refeicao);
            csv1.setText("REFEIÇÃO RÁPIDA");
            csv2.setImage(R.drawable.armazenar_coisas);
            csv2.setText("ARMAZENAR COISAS");
            csv3.setImage(R.drawable.passar_roupa);
            csv3.setText("PASSAR A ROUPA");
            csv4.setImage(R.drawable.internet);
            csv4.setText("USAR INTERNET");
            csv5.setImage(R.drawable.usar_computador);
            csv5.setText("USAR COMPUTADOR/CELULAR");
            csv6.setImage(R.drawable.trabalhos_manuais);
            csv6.setText("FAZER TRABALHOS MANUAIS");
            csv7.setImage(R.drawable.tocar);
            csv7.setText("TOCAR INSTRUMENTO");
            csv8.setImage(R.drawable.ler);
            csv8.setText("LER/ESTUDAR");
            csv9.setImage(R.drawable.jogar);
            csv9.setText("JOGAR");
            csv10.setImage(R.drawable.outros);
            csv10.setText("OUTROS");
            csv11.setImage(R.drawable.trabalhar);
            csv11.setText("TRABALHAR");
            csv12.setImage(R.drawable.nenhum);
            csv12.setText("NENHUM");
        } else if (roomType == CHARACTERISTICS_SATISFACTION_ROOM) {
            roomTypeActivity = ROOM_ACTIVITIES;
            tvQuestion.setText(ROOM_ACTIVITIES.getQuestion());
            csv1.setImage(R.drawable.dormir);
            csv1.setText("DORMIR");
            csv2.setImage(R.drawable.armazenar_coisas);
            csv2.setText("ARMAZENAR COISAS");
            csv3.setImage(R.drawable.passar_roupa);
            csv3.setText("PASSAR A ROUPA");
            csv4.setImage(R.drawable.receber_pessoas);
            csv4.setText("RECEBER CONVIDADOS");
            csv5.setImage(R.drawable.trabalhos_manuais);
            csv5.setText("FAZER TRABALHOS MANUAIS");
            csv6.setImage(R.drawable.exercitar);
            csv6.setText("EXERCITAR-SE");
            csv7.setImage(R.drawable.tocar);
            csv7.setText("TOCAR INSTRUMENTO");
            csv8.setImage(R.drawable.ler);
            csv8.setText("LER/ESTUDAR");
            csv9.setImage(R.drawable.almocar);
            csv9.setText("ALMOÇAR");
            csv10.setImage(R.drawable.outros);
            csv10.setText("OUTROS");
            csv11.setImage(R.drawable.jantar);
            csv11.setText("JANTAR");
            csv12.setImage(R.drawable.nenhum);
            csv12.setText("NENHUM");
        } else if (roomType == CHARACTERISTICS_SATISFACTION_DINNERROOM) {
            roomTypeActivity = DINNERROOM_ACTIVITIES;
            tvQuestion.setText(DINNERROOM_ACTIVITIES.getQuestion());
            csv1.setImage(R.drawable.trabalhos_manuais);
            csv1.setText("FAZER TRABALHOS MANUAIS");
            csv2.setImage(R.drawable.armazenar_coisas);
            csv2.setText("ARMAZENAR COISAS");
            csv3.setImage(R.drawable.passar_roupa);
            csv3.setText("PASSAR A ROUPA");
            csv4.setImage(R.drawable.internet);
            csv4.setText("USAR INTERNET");
            csv5.setImage(R.drawable.usar_computador);
            csv5.setText("USAR COMPUTADOR/CELULAR");
            csv6.setImage(R.drawable.exercitar);
            csv6.setText("EXERCITAR-SE");
            csv7.setImage(R.drawable.tocar);
            csv7.setText("TOCAR INSTRUMENTO");
            csv8.setImage(R.drawable.ler);
            csv8.setText("LER/ESTUDAR");
            csv9.setImage(R.drawable.dormir);
            csv9.setText("DORMIR");
            csv10.setImage(R.drawable.outros);
            csv10.setText("OUTROS");
            csv11.setImage(R.drawable.jogar);
            csv11.setText("JOGAR");
            csv12.setImage(R.drawable.nenhum);
            csv12.setText("NENHUM");
        } else if (roomType == CHARACTERISTICS_SATISFACTION_BALCONY) {
            roomTypeActivity = BALCONY_ACTIVITIES;
            tvQuestion.setText(BALCONY_ACTIVITIES.getQuestion());
            csv1.setImage(R.drawable.estender_roupa);
            csv1.setText("ESTENDER A ROUPA");
            csv2.setImage(R.drawable.armazenar_coisas);
            csv2.setText("ARMAZENAR COISAS");
            csv3.setImage(R.drawable.passar_roupa);
            csv3.setText("PASSAR A ROUPA");
            csv4.setImage(R.drawable.receber_pessoas);
            csv4.setText("RECEBER CONVIDADOS");
            csv5.setImage(R.drawable.usar_computador);
            csv5.setText("USAR COMPUTADOR/CELULAR");
            csv6.setImage(R.drawable.exercitar);
            csv6.setText("EXERCITAR-SE");
            csv7.setImage(R.drawable.tocar);
            csv7.setText("TOCAR INSTRUMENTO");
            csv8.setImage(R.drawable.ler);
            csv8.setText("LER/ESTUDAR");
            csv9.setImage(R.drawable.almocar);
            csv9.setText("ALMOÇAR");
            csv10.setImage(R.drawable.outros);
            csv10.setText("OUTROS");
            csv11.setImage(R.drawable.jantar);
            csv11.setText("JANTAR");
            csv12.setImage(R.drawable.nenhum);
            csv12.setText("NENHUM");
        } else if (roomType == CHARACTERISTICS_SATISFACTION_KITCHEN) {
            roomTypeActivity = KITCHEN_ACTIVITIES;
            tvQuestion.setText(KITCHEN_ACTIVITIES.getQuestion());
            csv1.setImage(R.drawable.estender_roupa);
            csv1.setText("ESTENDER A ROUPA");
            csv2.setImage(R.drawable.armazenar_coisas);
            csv2.setText("ARMAZENAR COISAS");
            csv3.setImage(R.drawable.passar_roupa);
            csv3.setText("PASSAR A ROUPA");
            csv4.setImage(R.drawable.receber_pessoas);
            csv4.setText("RECEBER CONVIDADOS");
            csv5.setImage(R.drawable.usar_computador);
            csv5.setText("USAR COMPUTADOR/CELULAR");
            csv6.setImage(R.drawable.trabalhos_manuais);
            csv6.setText("FAZER TRABALHOS MANUAIS");
            csv7.setImage(R.drawable.tocar);
            csv7.setText("TOCAR INSTRUMENTO");
            csv8.setImage(R.drawable.ler);
            csv8.setText("LER/ESTUDAR");
            csv9.setImage(R.drawable.lavar_roupa);
            csv9.setText("LAVAR ROUPA");
            csv10.setImage(R.drawable.outros);
            csv10.setText("OUTROS");
            csv11.setImage(R.drawable.tv);
            csv11.setText("ASSISTIR TV");
            csv12.setImage(R.drawable.nenhum);
            csv12.setText("NENHUM");
        } else if (roomType == CHARACTERISTICS_SATISFACTION_SERVICE_AREA) {
            roomTypeActivity = SERVICE_AREA_ACTIVITIES;
            tvQuestion.setText(SERVICE_AREA_ACTIVITIES.getQuestion());
            csv1.setImage(R.drawable.refeicao);
            csv1.setText("REFEIÇÃO RÁPIDA");
            csv2.setImage(R.drawable.armazenar_coisas);
            csv2.setText("ARMAZENAR COISAS");
            csv3.setImage(R.drawable.louca);
            csv3.setText("LAVAR LOUÇA");
            csv4.setImage(R.drawable.tv);
            csv4.setText("ASSISTIR TV");
            csv5.setImage(R.drawable.trabalhos_manuais);
            csv5.setText("FAZER TRABALHOS MANUAIS");
            csv6.setImage(R.drawable.exercitar);
            csv6.setText("EXERCITAR-SE");
            csv7.setImage(R.drawable.usar_computador);
            csv7.setText("USAR COMPUTADOR/CELULAR");
            csv8.setImage(R.drawable.ler);
            csv8.setText("LER/ESTUDAR");
            csv9.setImage(R.drawable.tocar);
            csv9.setText("TOCAR INSTRUMENTO");
            csv10.setImage(R.drawable.outros);
            csv10.setText("OUTROS");
            csv11.setImage(R.drawable.internet);
            csv11.setText("USAR INTERNET");
            csv12.setImage(R.drawable.nenhum);
            csv12.setText("NENHUM");
        }
    }


    private void setAnswer() {
        ResearchFlow.addAnswer(new AnswerRequest(roomTypeActivity.getQuestion(), roomTypeActivity.getQuestionPartId(), answerRequests.toString()), this);
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }


    @OnClick({R.id.csv1, R.id.csv2, R.id.csv3, R.id.csv4, R.id.csv5,
            R.id.csv6, R.id.csv7, R.id.csv8, R.id.csv9, R.id.csv10,
            R.id.csv11, R.id.csv12})
    public void onClickViews(View view) {
        String text = ((CustomSelectedView) view).getText();
        switch (view.getId()) {
            case R.id.csv1:
                if (csv1.isChecked()) {
                    csv1.setChecked(false);
                } else {
                    answerRequests.append(text);
                    answerRequests.append(";");
                    csv1.setChecked(true);
                }
                break;
            case R.id.csv2:
                if (csv2.isChecked()) {
                    csv2.setChecked(false);
                } else {
                    answerRequests.append(text);
                    answerRequests.append(";");
                    csv2.setChecked(true);
                }
                break;
            case R.id.csv3:
                if (csv3.isChecked()) {
                    csv3.setChecked(false);
                } else {
                    answerRequests.append(text);
                    answerRequests.append(";");
                    csv3.setChecked(true);
                }
                break;
            case R.id.csv4:
                if (csv4.isChecked()) {
                    csv4.setChecked(false);
                } else {
                    answerRequests.append(text);
                    answerRequests.append(";");
                    csv4.setChecked(true);
                }

                break;
            case R.id.csv5:
                if (csv5.isChecked()) {
                    csv5.setChecked(false);
                } else {
                    answerRequests.append(text);
                    answerRequests.append(";");
                    csv5.setChecked(true);
                }

                break;
            case R.id.csv6:
                if (csv6.isChecked()) {
                    csv6.setChecked(false);
                } else {
                    answerRequests.append(text);
                    answerRequests.append(";");
                    csv6.setChecked(true);
                }

                break;
            case R.id.csv7:
                if (csv7.isChecked()) {
                    csv7.setChecked(false);
                } else {
                    answerRequests.append(text);
                    answerRequests.append(";");
                    csv7.setChecked(true);
                }
                break;
            case R.id.csv8:
                if (csv8.isChecked()) {
                    csv8.setChecked(false);
                } else {
                    answerRequests.append(text);
                    answerRequests.append(";");
                    csv8.setChecked(true);
                }
                break;
            case R.id.csv9:
                if (csv9.isChecked()) {
                    csv9.setChecked(false);
                } else {
                    answerRequests.append(text);
                    answerRequests.append(";");
                    csv9.setChecked(true);
                }
                break;
            case R.id.csv10:
                if (csv10.isChecked()) {
                    csv10.setChecked(false);
                } else {
                    answerRequests.append(text);
                    answerRequests.append(";");
                    csv10.setChecked(true);
                }
                break;
            case R.id.csv11:
                if (csv11.isChecked()) {
                    csv11.setChecked(false);
                } else {
                    answerRequests.append(text);
                    answerRequests.append(";");
                    csv11.setChecked(true);
                }
                break;
            case R.id.csv12:
                if (csv12.isChecked()) {
                    csv12.setChecked(false);
                } else {
                    answerRequests.append(text);
                    answerRequests.append(";");
                    csv12.setChecked(true);
                }
                break;
        }
    }

    @OnClick(R.id.btPreviousSession)
    public void onBtPreviouSessionClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) requireActivity()).addFragment(BuildingSplashFragment.newInstance());
        }
    }
}
