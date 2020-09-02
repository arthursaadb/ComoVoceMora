package br.com.como_voce_mora.ui.unity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.CustomSelectedView;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.model.UnityAnswer;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.building.BuildingSplashFragment;
import br.com.como_voce_mora.ui.currentresidence.CurrentHomeFragment;
import br.com.como_voce_mora.ui.sustainablehabits.SustainableHabitsIntroFragment;
import butterknife.BindView;
import butterknife.OnClick;

import static br.com.como_voce_mora.model.UnityAnswer.BALCONY_ACTIVITIES;
import static br.com.como_voce_mora.model.UnityAnswer.BATHROOM_ACTIVITIES;
import static br.com.como_voce_mora.model.UnityAnswer.BIGROOM_ACTIVITIES;
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

    private AnswerRequest answerCsv1;
    private AnswerRequest answerCsv2;
    private AnswerRequest answerCsv3;
    private AnswerRequest answerCsv4;
    private AnswerRequest answerCsv5;
    private AnswerRequest answerCsv6;
    private AnswerRequest answerCsv7;
    private AnswerRequest answerCsv8;
    private AnswerRequest answerCsv9;
    private AnswerRequest answerCsv10;
    private AnswerRequest answerCsv11;
    private AnswerRequest answerCsv12;


    private ArrayList<AnswerRequest> answerRequests = new ArrayList<>();
    private UnityAnswer roomType = KITCHEN_ACTIVITIES;

    public static UnityActivitiesByRoom newInstance(UnityAnswer room) {

        Bundle args = new Bundle();

        UnityActivitiesByRoom fragment = new UnityActivitiesByRoom();
        fragment.setArguments(args);
        fragment.roomType = room;
        return fragment;
    }

    @Override
    public int getResLayout() {
        return R.layout.unity_activities_by_room;
    }

    @Override
    public void init() {
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.UNITY);
        tvQuestion.setText(roomType.getQuestion());
        setImages();
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (getActivity() != null) {
            setAnswer();
            if (roomType == KITCHEN_ACTIVITIES) {
                ((AboutYouActivity) getActivity()).addFragment(UnityActivitiesByRoom.newInstance(BALCONY_ACTIVITIES));
            } else if (roomType == BALCONY_ACTIVITIES) {
                ((AboutYouActivity) getActivity()).addFragment(UnityActivitiesByRoom.newInstance(DINNERROOM_ACTIVITIES));
            } else if (roomType == DINNERROOM_ACTIVITIES) {
                ((AboutYouActivity) getActivity()).addFragment(UnityActivitiesByRoom.newInstance(ROOM_ACTIVITIES));
            } else if (roomType == ROOM_ACTIVITIES) {
                ((AboutYouActivity) getActivity()).addFragment(UnityActivitiesByRoom.newInstance(SINGLEROMM_ACTIVITIES));
            } else if (roomType == SINGLEROMM_ACTIVITIES) {
                ((AboutYouActivity) getActivity()).addFragment(UnityActivitiesByRoom.newInstance(BIGROOM_ACTIVITIES));
            } else if (roomType == BIGROOM_ACTIVITIES) {
                ((AboutYouActivity) getActivity()).addFragment(UnityActivitiesByRoom.newInstance(BATHROOM_ACTIVITIES));
            } else if (roomType == BATHROOM_ACTIVITIES) {
                ((AboutYouActivity) getActivity()).addFragment(UnityActivitiesByRoom.newInstance(SERVICE_AREA_ACTIVITIES));
            } else if (roomType == SERVICE_AREA_ACTIVITIES) {
                ((AboutYouActivity) requireActivity()).addFragment(SustainableHabitsIntroFragment.newInstance());
            }
        }
    }

    private void setImages() {
        if (roomType==KITCHEN_ACTIVITIES) {
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
        } else if (roomType==BALCONY_ACTIVITIES) {
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
        } else if (roomType==DINNERROOM_ACTIVITIES) {
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
        } else if (roomType==ROOM_ACTIVITIES) {
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
        } else if (roomType==SINGLEROMM_ACTIVITIES) {
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
        } else if (roomType==BIGROOM_ACTIVITIES) {
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
        } else if (roomType==BATHROOM_ACTIVITIES) {
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
        } else if (roomType==SERVICE_AREA_ACTIVITIES) {
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
            csv11.setText("USAR INNTERNET");
            csv12.setImage(R.drawable.nenhum);
            csv12.setText("NENHUM");
        }
    }

    private void setAnswer() {
        if (answerCsv1 != null) {
            answerRequests.add(answerCsv1);
        }
        if (answerCsv2 != null) {
            answerRequests.add(answerCsv2);
        }
        if (answerCsv3 != null) {
            answerRequests.add(answerCsv3);
        }
        if (answerCsv4 != null) {
            answerRequests.add(answerCsv4);
        }
        if (answerCsv5 != null) {
            answerRequests.add(answerCsv5);
        }
        if (answerCsv6 != null) {
            answerRequests.add(answerCsv6);
        }
        if (answerCsv7 != null) {
            answerRequests.add(answerCsv7);
        }
        if (answerCsv8 != null) {
            answerRequests.add(answerCsv8);
        }
        if (answerCsv9 != null) {
            answerRequests.add(answerCsv9);
        }
        if (answerCsv10 != null) {
            answerRequests.add(answerCsv10);
        }
        if (answerCsv11 != null) {
            answerRequests.add(answerCsv11);
        }
        if (answerCsv12 != null) {
            answerRequests.add(answerCsv12);
        }
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


    @OnClick({R.id.csv1, R.id.csv2, R.id.csv3, R.id.csv4, R.id.csv5,
            R.id.csv6, R.id.csv7, R.id.csv8, R.id.csv9, R.id.csv10,
            R.id.csv11, R.id.csv12})
    public void onClickViews(View view) {
        String text = ((CustomSelectedView) view).getText();
        switch (view.getId()) {
            case R.id.csv1:
                if (csv1.isChecked()) {
                    csv1.setChecked(false);
                    answerCsv1 = null;
                } else {
                    answerCsv1 = new AnswerRequest(roomType.getQuestion(), roomType.getQuestionPartId(), text);
                    csv1.setChecked(true);
                }
                break;
            case R.id.csv2:
                if (csv2.isChecked()) {
                    answerCsv2 = null;
                    csv2.setChecked(false);
                } else {
                    answerCsv2 = new AnswerRequest(roomType.getQuestion(), roomType.getQuestionPartId(), text);
                    csv2.setChecked(true);
                }
                break;
            case R.id.csv3:
                if (csv3.isChecked()) {
                    answerCsv3 = null;
                    csv3.setChecked(false);
                } else {
                    answerCsv3 = new AnswerRequest(roomType.getQuestion(), roomType.getQuestionPartId(), text);
                    csv3.setChecked(true);
                }
                break;
            case R.id.csv4:
                if (csv4.isChecked()) {
                    answerCsv4 = null;
                    csv4.setChecked(false);
                } else {
                    answerCsv4 = new AnswerRequest(roomType.getQuestion(), roomType.getQuestionPartId(), text);
                    csv4.setChecked(true);
                }

                break;
            case R.id.csv5:
                if (csv5.isChecked()) {
                    answerCsv5 = null;
                    csv5.setChecked(false);
                } else {
                    answerCsv5 = new AnswerRequest(roomType.getQuestion(), roomType.getQuestionPartId(), text);
                    csv5.setChecked(true);
                }

                break;
            case R.id.csv6:
                if (csv6.isChecked()) {
                    answerCsv6 = null;
                    csv6.setChecked(false);
                } else {
                    answerCsv6 = new AnswerRequest(roomType.getQuestion(), roomType.getQuestionPartId(), text);
                    csv6.setChecked(true);
                }

                break;
            case R.id.csv7:
                if (csv7.isChecked()) {
                    answerCsv7 = null;
                    csv7.setChecked(false);
                } else {
                    answerCsv7 = new AnswerRequest(roomType.getQuestion(), roomType.getQuestionPartId(), text);
                    csv7.setChecked(true);
                }
                break;
            case R.id.csv8:
                if (csv8.isChecked()) {
                    answerCsv8 = null;
                    csv8.setChecked(false);
                } else {
                    answerCsv8 = new AnswerRequest(roomType.getQuestion(), roomType.getQuestionPartId(), text);
                    csv8.setChecked(true);
                }
                break;
            case R.id.csv9:
                if (csv9.isChecked()) {
                    answerCsv9 = null;
                    csv9.setChecked(false);
                } else {
                    answerCsv9 = new AnswerRequest(roomType.getQuestion(), roomType.getQuestionPartId(), text);
                    csv9.setChecked(true);
                }
                break;
            case R.id.csv10:
                if (csv10.isChecked()) {
                    answerCsv10 = null;
                    csv10.setChecked(false);
                } else {
                    answerCsv10 = new AnswerRequest(roomType.getQuestion(), roomType.getQuestionPartId(), text);
                    csv10.setChecked(true);
                }
                break;
            case R.id.csv11:
                if (csv11.isChecked()) {
                    answerCsv11 = null;
                    csv11.setChecked(false);
                } else {
                    answerCsv11 = new AnswerRequest(roomType.getQuestion(), roomType.getQuestionPartId(), text);
                    csv11.setChecked(true);
                }
                break;
            case R.id.csv12:
                if (csv12.isChecked()) {
                    answerCsv12 = null;
                    csv12.setChecked(false);
                } else {
                    answerCsv12 = new AnswerRequest(roomType.getQuestion(), roomType.getQuestionPartId(), text);
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
