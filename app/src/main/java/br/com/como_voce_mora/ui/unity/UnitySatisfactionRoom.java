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
    VolumeHorizontal vhSize;
    @BindView(R.id.volume2)
    VolumeHorizontal vhDivision;
    @BindView(R.id.volume3)
    VolumeHorizontal vhQuality;
    @BindView(R.id.volume4)
    VolumeHorizontal vhClean;
    @BindView(R.id.volume5)
    VolumeHorizontal vhAdaptation;
    @BindView(R.id.volume6)
    VolumeHorizontal vhPrivacy;
    @BindView(R.id.ivImage)
    ImageView ivPhoto;

    private List<AnswerRequest> answerRequests = new ArrayList<>();
    private UnityAnswer size = UnityAnswer.SIZE_SATISFACTION;
    private UnityAnswer division = UnityAnswer.EASE_OF_FURNISHINGS;
    private UnityAnswer quality = UnityAnswer.TEMPERATURE;
    private UnityAnswer clean = UnityAnswer.NATURAL_VENTILATION;
    private UnityAnswer adaptation = UnityAnswer.NATURAL_ILUMINATION;
    private UnityAnswer privacy = UnityAnswer.NOISE_LEVEL;
    private List<String> texts = new ArrayList<>();
    private boolean anyOptionChecked = false;
    private UnityAnswer roomType;
    private List<UnityAnswer> listRoomType;
    private int index;
    private UnityRoomsImages images;

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

        vhSize.setMax(texts.size() - 1);
        vhDivision.setMax(texts.size() - 1);
        vhQuality.setMax(texts.size() - 1);
        vhClean.setMax(texts.size() - 1);
        vhAdaptation.setMax(texts.size() - 1);
        vhPrivacy.setMax(texts.size() - 1);
        initVolumes();

        if (roomType == CHARACTERISTICS_SATISFACTION_BATHROOM) {
            ivPhoto.setImageResource(R.drawable.banheiro);
            images = UnityRoomsImages.BATHROOM;
        } else if (roomType == CHARACTERISTICS_SATISFACTION_BIGROOM) {
            ivPhoto.setImageResource(R.drawable.dorm_casal);
            images = UnityRoomsImages.BIGROOM;
        } else if (roomType == CHARACTERISTICS_SATISFACTION_SINGLEROMM) {
            ivPhoto.setImageResource(R.drawable.dorm_solteiro);
            images = UnityRoomsImages.SINGLEROOM;
        } else if (roomType == CHARACTERISTICS_SATISFACTION_ROOM) {
            ivPhoto.setImageResource(R.drawable.estar);
            images = UnityRoomsImages.ROOM;
        } else if (roomType == CHARACTERISTICS_SATISFACTION_DINNERROOM) {
            ivPhoto.setImageResource(R.drawable.sala_jantar);
            images = UnityRoomsImages.DINNERROOM;
        } else if (roomType == CHARACTERISTICS_SATISFACTION_BALCONY) {
            ivPhoto.setImageResource(R.drawable.varanda);
            images = UnityRoomsImages.BALCONY;
        } else if (roomType == CHARACTERISTICS_SATISFACTION_KITCHEN) {
            ivPhoto.setImageResource(R.drawable.cozinha);
            images = UnityRoomsImages.KITCHEN;
        } else if (roomType == CHARACTERISTICS_SATISFACTION_SERVICE_AREA) {
            ivPhoto.setImageResource(R.drawable.service);
            images = UnityRoomsImages.SERVICE;
        }
    }

    private void initVolumes() {
        vhSize.setListener(position -> {
            anyOptionChecked = true;
            vhSize.setInfo(texts.get(position));
            ivPhoto.setImageResource(images.getTamanho());
            answerRequests.add(new AnswerRequest(size.getQuestion(), size.getQuestionPartId(), texts.get(position)));
        });
        vhDivision.setListener(position -> {
            vhDivision.setInfo(texts.get(position));
            ivPhoto.setImageResource(images.getMobiliar());
            answerRequests.add(new AnswerRequest(division.getQuestion(), division.getQuestionPartId(), texts.get(position)));
        });
        vhQuality.setListener(position -> {
            vhQuality.setInfo(texts.get(position));
            ivPhoto.setImageResource(images.getVentilacao());
            answerRequests.add(new AnswerRequest(quality.getQuestion(), quality.getQuestionPartId(), texts.get(position)));
        });
        vhClean.setListener(position -> {
            vhClean.setInfo(texts.get(position));
            ivPhoto.setImageResource(images.getIluminacao());
            answerRequests.add(new AnswerRequest(clean.getQuestion(), clean.getQuestionPartId(), texts.get(position)));
        });
        vhAdaptation.setListener(position -> {
            vhAdaptation.setInfo(texts.get(position));
            ivPhoto.setImageResource(images.getTemperatura());
            answerRequests.add(new AnswerRequest(adaptation.getQuestion(), adaptation.getQuestionPartId(), texts.get(position)));
        });
        vhPrivacy.setListener(position -> {
            vhPrivacy.setInfo(texts.get(position));
            ivPhoto.setImageResource(images.getRuido());
            answerRequests.add(new AnswerRequest(privacy.getQuestion(), privacy.getQuestionPartId(), texts.get(position)));
        });
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (anyOptionChecked) {
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
