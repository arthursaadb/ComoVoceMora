package br.com.como_voce_mora.ui.unity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.custom.VolumeHorizontal;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.model.UnityAnswer;
import br.com.como_voce_mora.model.UnityRoomsImages;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.building.BuildingSplashFragment;
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

public class UnitySatisfactionRoom extends BaseFragment {
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar progressBar;
    @BindView(R.id.tv_question)
    TextView tvQuestion;
    @BindView(R.id.volume1)
    VolumeHorizontal volume1;
    @BindView(R.id.volume2)
    VolumeHorizontal volume2;
    @BindView(R.id.volume3)
    VolumeHorizontal volume3;
    @BindView(R.id.volume4)
    VolumeHorizontal volume4;
    @BindView(R.id.volume5)
    VolumeHorizontal volume5;
    @BindView(R.id.volume6)
    VolumeHorizontal volume6;
    @BindView(R.id.ivImage)
    ImageView ivPhoto;

    private List<AnswerRequest> answerRequests = new ArrayList<>();
    private List<String> texts = new ArrayList<>();
    private UnityAnswer roomType;
    private UnityAnswer mobiliar;
    private UnityAnswer temperatura;
    private UnityAnswer convivencia;
    private UnityAnswer iluminacao;
    private UnityAnswer ruido;
    private UnityAnswer tamanho;

    private List<UnityAnswer> listRoomType;
    private int index;
    private UnityRoomsImages images;

    private boolean anyOptionChecked1 = false;
    private boolean anyOptionChecked2 = false;
    private boolean anyOptionChecked3 = false;
    private boolean anyOptionChecked4 = false;
    private boolean anyOptionChecked5 = false;
    private boolean anyOptionChecked6 = false;


    public static UnitySatisfactionRoom newInstance(List<UnityAnswer> room, int index) {

        Bundle args = new Bundle();
        args.putSerializable("list", (Serializable) room);
        args.putInt("index", index);
        UnitySatisfactionRoom fragment = new UnitySatisfactionRoom();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_unity_satisfaction_room;
    }

    @Override
    public void init() {
        texts.clear();
        listRoomType = (List<UnityAnswer>) getArguments().getSerializable("list");
        index = getArguments().getInt("index");
        roomType = listRoomType.get(index);
        index++;
        tvQuestion.setText(roomType.getQuestion());
        progressBar.setProgress(HowYouLiveProgressBar.HowYouLive.UNITY);
        texts.add("Muito Ruim");
        texts.add("Ruim");
        texts.add("Regular");
        texts.add("Bom");
        texts.add("Muito Bom");

        volume1.setMax(texts.size() - 1);
        volume2.setMax(texts.size() - 1);
        volume3.setMax(texts.size() - 1);
        volume4.setMax(texts.size() - 1);
        volume5.setMax(texts.size() - 1);
        volume6.setMax(texts.size() - 1);
        initVolumes();

        if (roomType == CHARACTERISTICS_SATISFACTION_BATHROOM) {
            ivPhoto.setImageResource(R.drawable.banheiro);
            images = UnityRoomsImages.BATHROOM;
            mobiliar = UnityAnswer.EASE_OF_FURNISHINGS_BATHROOM;
            temperatura = UnityAnswer.TEMPERATURE_BATHROOM;
            convivencia = UnityAnswer.NATURAL_VENTILATION_BATHROOM;
            iluminacao = UnityAnswer.NATURAL_ILUMINATION_BATHROOM;
            ruido = UnityAnswer.NOISE_LEVEL_BATHROOM ;
            tamanho = UnityAnswer.SIZE_SATISFACTION_BATHROOM;
        } else if (roomType == CHARACTERISTICS_SATISFACTION_BIGROOM) {
            ivPhoto.setImageResource(R.drawable.dorm_casal);
            images = UnityRoomsImages.BIGROOM;
            mobiliar = UnityAnswer.EASE_OF_FURNISHINGS_BIGROOM;
            temperatura = UnityAnswer.TEMPERATURE_BIGROOM;
            convivencia = UnityAnswer.NATURAL_VENTILATION_BIGROOM;
            iluminacao = UnityAnswer.NATURAL_ILUMINATION_BIGROOM;
            ruido = UnityAnswer.NOISE_LEVEL_BIGROOM ;
            tamanho = UnityAnswer.SIZE_SATISFACTION_BIGROOM;
        } else if (roomType == CHARACTERISTICS_SATISFACTION_SINGLEROMM) {
            ivPhoto.setImageResource(R.drawable.dorm_solteiro);
            images = UnityRoomsImages.SINGLEROOM;
            mobiliar = UnityAnswer.EASE_OF_FURNISHINGS_SINGLEROMM;
            temperatura = UnityAnswer.TEMPERATURE_SINGLEROMM;
            convivencia = UnityAnswer.NATURAL_VENTILATION_SINGLEROMM;
            iluminacao = UnityAnswer.NATURAL_ILUMINATION_SINGLEROMM;
            ruido = UnityAnswer.NOISE_LEVEL_SINGLEROMM;
            tamanho = UnityAnswer.SIZE_SATISFACTION_SINGLEROMM;
        } else if (roomType == CHARACTERISTICS_SATISFACTION_ROOM) {
            ivPhoto.setImageResource(R.drawable.estar);
            images = UnityRoomsImages.ROOM;
            mobiliar = UnityAnswer.EASE_OF_FURNISHINGS_ROOM;
            temperatura = UnityAnswer.TEMPERATURE_ROOM;
            convivencia = UnityAnswer.NATURAL_VENTILATION_ROOM;
            iluminacao = UnityAnswer.NATURAL_ILUMINATION_ROOM;
            ruido = UnityAnswer.NOISE_LEVEL_ROOM;
            tamanho = UnityAnswer.SIZE_SATISFACTION_ROOM;
        } else if (roomType == CHARACTERISTICS_SATISFACTION_DINNERROOM) {
            ivPhoto.setImageResource(R.drawable.sala_jantar);
            images = UnityRoomsImages.DINNERROOM;
            mobiliar = UnityAnswer.EASE_OF_FURNISHINGS_DINNERROOM;
            temperatura = UnityAnswer.TEMPERATURE_DINNERROOM;
            convivencia = UnityAnswer.NATURAL_VENTILATION_DINNERROOM;
            iluminacao = UnityAnswer.NATURAL_ILUMINATION_DINNERROOM;
            ruido = UnityAnswer.NOISE_LEVEL_DINNERROOM;
            tamanho = UnityAnswer.SIZE_SATISFACTION_DINNERROOM;
        } else if (roomType == CHARACTERISTICS_SATISFACTION_BALCONY) {
            ivPhoto.setImageResource(R.drawable.varanda);
            images = UnityRoomsImages.BALCONY;
            mobiliar = UnityAnswer.EASE_OF_FURNISHINGS_BALCONY;
            temperatura = UnityAnswer.TEMPERATURE_BALCONY;
            convivencia = UnityAnswer.NATURAL_VENTILATION_BALCONY;
            iluminacao = UnityAnswer.NATURAL_ILUMINATION_BALCONY;
            ruido = UnityAnswer.NOISE_LEVEL_BALCONY;
            tamanho = UnityAnswer.SIZE_SATISFACTION_BALCONY;
        } else if (roomType == CHARACTERISTICS_SATISFACTION_KITCHEN) {
            ivPhoto.setImageResource(R.drawable.cozinha);
            images = UnityRoomsImages.KITCHEN;
            mobiliar = UnityAnswer.EASE_OF_FURNISHINGS_KITCHEN;
            temperatura = UnityAnswer.TEMPERATURE_KITCHEN;
            convivencia = UnityAnswer.NATURAL_VENTILATION_KITCHEN;
            iluminacao = UnityAnswer.NATURAL_ILUMINATION_KITCHEN;
            ruido = UnityAnswer.NOISE_LEVEL_KITCHEN;
            tamanho = UnityAnswer.SIZE_SATISFACTION_KITCHEN;
        } else if (roomType == CHARACTERISTICS_SATISFACTION_SERVICE_AREA) {
            ivPhoto.setImageResource(R.drawable.service);
            images = UnityRoomsImages.SERVICE;
            mobiliar = UnityAnswer.EASE_OF_FURNISHINGS_SERVICE_AREA;
            temperatura = UnityAnswer.TEMPERATURE_SERVICE_AREA;
            convivencia = UnityAnswer.NATURAL_VENTILATION_SERVICE_AREA;
            iluminacao = UnityAnswer.NATURAL_ILUMINATION_SERVICE_AREA;
            ruido = UnityAnswer.NOISE_LEVEL_SERVICE_AREA;
            tamanho = UnityAnswer.SIZE_SATISFACTION_SERVICE_AREA;
        }
    }

    private void initVolumes() {
        volume1.setListener(position -> {
            anyOptionChecked1 = true;
            volume1.setInfo(texts.get(position));
            ivPhoto.setImageResource(images.getTamanho());
            answerRequests.add(new AnswerRequest(tamanho.getQuestion(), tamanho.getQuestionPartId(), texts.get(position)));
        });
        volume2.setListener(position -> {
            anyOptionChecked2 = true;
            volume2.setInfo(texts.get(position));
            ivPhoto.setImageResource(images.getMobiliar());
            answerRequests.add(new AnswerRequest(mobiliar.getQuestion(), mobiliar.getQuestionPartId(), texts.get(position)));
        });
        volume3.setListener(position -> {
            anyOptionChecked3 = true;
            volume3.setInfo(texts.get(position));
            ivPhoto.setImageResource(images.getVentilacao());
            answerRequests.add(new AnswerRequest(convivencia.getQuestion(), convivencia.getQuestionPartId(), texts.get(position)));
        });
        volume4.setListener(position -> {
            anyOptionChecked4 = true;
            volume4.setInfo(texts.get(position));
            ivPhoto.setImageResource(images.getIluminacao());
            answerRequests.add(new AnswerRequest(iluminacao.getQuestion(), iluminacao.getQuestionPartId(), texts.get(position)));
        });
        volume5.setListener(position -> {
            anyOptionChecked5 = true;
            volume5.setInfo(texts.get(position));
            ivPhoto.setImageResource(images.getTemperatura());
            answerRequests.add(new AnswerRequest(temperatura.getQuestion(), temperatura.getQuestionPartId(), texts.get(position)));
        });
        volume6.setListener(position -> {
            anyOptionChecked6 = true;
            volume6.setInfo(texts.get(position));
            ivPhoto.setImageResource(images.getRuido());
            answerRequests.add(new AnswerRequest(ruido.getQuestion(), ruido.getQuestionPartId(), texts.get(position)));
        });
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (anyOptionChecked1 && anyOptionChecked2 && anyOptionChecked3 && anyOptionChecked4 && anyOptionChecked5 && anyOptionChecked6) {
            if (getActivity() != null) {
                setAnswers();
                if (index == listRoomType.size()) {
                    ((AboutYouActivity) getActivity()).addFragment(UnityReformFragment.newInstance(listRoomType));
                } else {
                    ((AboutYouActivity) getActivity()).addFragment(UnitySatisfactionRoom.newInstance(listRoomType, index++));
                }
            }
        }
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    private void setAnswers() {
        for (AnswerRequest r : answerRequests) {
            ResearchFlow.addAnswer(r, this);
        }
    }

    @OnClick(R.id.btPreviousSession)
    public void onBtPreviouSessionClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) requireActivity()).addFragment(BuildingSplashFragment.newInstance());
        }
    }
}
