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

    public static UnitySatisfactionRoom newInstance(List<UnityAnswer> room) {

        Bundle args = new Bundle();
        args.putSerializable("list", (Serializable) room);
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
        roomType = listRoomType.get(0);
        listRoomType.remove(0);
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
        } else if (roomType == CHARACTERISTICS_SATISFACTION_BIGROOM) {
            ivPhoto.setImageResource(R.drawable.dorm_casal);
        } else if (roomType == CHARACTERISTICS_SATISFACTION_SINGLEROMM) {
            ivPhoto.setImageResource(R.drawable.dorm_solteiro);
        } else if (roomType == CHARACTERISTICS_SATISFACTION_ROOM) {
            ivPhoto.setImageResource(R.drawable.estar);
        } else if (roomType == CHARACTERISTICS_SATISFACTION_DINNERROOM) {
            ivPhoto.setImageResource(R.drawable.sala_jantar);
        } else if (roomType == CHARACTERISTICS_SATISFACTION_BALCONY) {
            ivPhoto.setImageResource(R.drawable.varanda);
        } else if (roomType == CHARACTERISTICS_SATISFACTION_KITCHEN) {
            ivPhoto.setImageResource(R.drawable.cozinha);
        } else if (roomType == CHARACTERISTICS_SATISFACTION_SERVICE_AREA) {
            ivPhoto.setImageResource(R.drawable.service);
        }
    }

    private void initVolumes() {
        vhSize.setListener(position -> {
            anyOptionChecked = true;
            vhSize.setInfo(texts.get(position));
            answerRequests.add(new AnswerRequest(size.getQuestion(), size.getQuestionPartId(), texts.get(position)));
        });
        vhDivision.setListener(position -> {
            vhDivision.setInfo(texts.get(position));
            answerRequests.add(new AnswerRequest(division.getQuestion(), division.getQuestionPartId(), texts.get(position)));
        });
        vhQuality.setListener(position -> {
            vhQuality.setInfo(texts.get(position));
            answerRequests.add(new AnswerRequest(quality.getQuestion(), quality.getQuestionPartId(), texts.get(position)));
        });
        vhClean.setListener(position -> {
            vhClean.setInfo(texts.get(position));
            answerRequests.add(new AnswerRequest(clean.getQuestion(), clean.getQuestionPartId(), texts.get(position)));
        });
        vhAdaptation.setListener(position -> {
            vhAdaptation.setInfo(texts.get(position));
            answerRequests.add(new AnswerRequest(adaptation.getQuestion(), adaptation.getQuestionPartId(), texts.get(position)));
        });
        vhPrivacy.setListener(position -> {
            vhPrivacy.setInfo(texts.get(position));
            answerRequests.add(new AnswerRequest(privacy.getQuestion(), privacy.getQuestionPartId(), texts.get(position)));
        });
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (anyOptionChecked) {
            if (getActivity() != null) {
                setAnswers();
                if (listRoomType.isEmpty()) {
                    ((AboutYouActivity) getActivity()).addFragment(UnityReformFragment.newInstance());
                } else {
                    ((AboutYouActivity) getActivity()).addFragment(UnitySatisfactionRoom.newInstance(listRoomType));
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
