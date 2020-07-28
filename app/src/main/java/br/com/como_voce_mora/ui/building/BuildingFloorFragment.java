package br.com.como_voce_mora.ui.building;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.custom.VolumeVertical;
import br.com.como_voce_mora.model.AboutYouAnswer;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.BuildingAnswer;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import butterknife.BindView;
import butterknife.OnClick;

public class BuildingFloorFragment extends BaseFragment implements VolumeVertical.OnListener {
    @BindView(R.id.volume)
    VolumeVertical mVolume;
    @BindView(R.id.iv_school)
    ImageView mIvAge;
    @BindView(R.id.tv_school)
    TextView mTvSchool;
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar progressBar;
    @BindView(R.id.tv_question)
    TextView tvQuestion;

    private List<Integer> images;
    private List<String> texts;

    private AnswerRequest answerRequest;
    private BuildingAnswer buildingAnswer = BuildingAnswer.NUMBER_OF_FLOORS;

    public static BuildingFloorFragment newInstance() {

        Bundle args = new Bundle();

        BuildingFloorFragment fragment = new BuildingFloorFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_floor_building;
    }

    @Override
    public void init() {
        tvQuestion.setText(buildingAnswer.getQuestion());
        progressBar.setProgress(HowYouLiveProgressBar.HowYouLive.BUILDING);
        images = new ArrayList<>();
        texts = new ArrayList<>();

        images.add(R.drawable.andar_qtd_2);
        texts.add("2° andares");
        images.add(R.drawable.andar_qtd_3);
        texts.add("3° andares");
        images.add(R.drawable.andar_qtd_4);
        texts.add("4° andares");
        images.add(R.drawable.andar_qtd_5);
        texts.add("5° andares");
        images.add(R.drawable.andar_qtd_6);
        texts.add("6° andares");
        images.add(R.drawable.andar_qtd_7);
        texts.add("7° andares");
        images.add(R.drawable.andar_qtd_8);
        texts.add("8° andares");
        images.add(R.drawable.andar_qtd_9);
        texts.add("9° andares");
        images.add(R.drawable.andar_qtd_10);
        texts.add("10° andares");
        images.add(R.drawable.andar_qtd_11);
        texts.add("11° andares");
        images.add(R.drawable.andar_qtd_12);
        texts.add("12° andares");
        images.add(R.drawable.andar_qtd_13);
        texts.add("13° andares");
        images.add(R.drawable.andar_qtd_14);
        texts.add("14° andares");
        images.add(R.drawable.andar_qtd_15);
        texts.add("15° andares");
        images.add(R.drawable.andar_qtd_16);
        texts.add("16° andares");
        images.add(R.drawable.andar_qtd_17);
        texts.add("17° andares");
        images.add(R.drawable.andar_qtd_18);
        texts.add("18° andares");
        images.add(R.drawable.andar_qtd_19);
        texts.add("19° andares");
        images.add(R.drawable.andar_qtd_20);
        texts.add("20° andares");
        Collections.reverse(images);
        Collections.reverse(texts);
        mVolume.setListener(this);
        mVolume.setMax(images.size() - 1);
    }

    @Override
    public void positionVolume(int position) {
        mIvAge.setImageResource(images.get(position));
        mTvSchool.setText(texts.get(position));
        mTvSchool.setVisibility(View.VISIBLE);
        answerRequest = new AnswerRequest(buildingAnswer.getQuestion(), buildingAnswer.getQuestionPartId(), texts.get(position));
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (getActivity() != null) {
            ResearchFlow.addAnswer(answerRequest, this);
            ((AboutYouActivity) getActivity()).addFragment(BuildingApartamentPerFloorFragment.newInstance());
        }
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }
}
