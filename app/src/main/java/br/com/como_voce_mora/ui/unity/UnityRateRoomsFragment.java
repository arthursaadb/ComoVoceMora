package br.com.como_voce_mora.ui.unity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.custom.VolumeVertical;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.model.UnityAnswer;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.building.BuildingSplashFragment;
import butterknife.BindView;
import butterknife.OnClick;

import static br.com.como_voce_mora.model.UnityAnswer.CHARACTERISTICS_SATISFACTION_BATHROOM;

public class UnityRateRoomsFragment extends BaseFragment implements VolumeVertical.OnListener {
    @BindView(R.id.volume)
    VolumeVertical mVolume;
    @BindView(R.id.iv_school)
    ImageView mIvAge;
    @BindView(R.id.tv_school)
    TextView mTvAge;
    @BindView(R.id.tv_question)
    TextView tvQuestion;

    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar progressBar;
    private AnswerRequest answerRequest;
    private UnityAnswer unityAnswer = UnityAnswer.SATISFACTION_FOR_ROOMS;
    private boolean anyOptionChecked = false;

    private List<UnityAnswer> roomsList;
    private List<Integer> images;
    private List<String> texts;

    public static UnityRateRoomsFragment newInstance(List<UnityAnswer> roomList) {

        Bundle args = new Bundle();
        args.putSerializable("list", (Serializable) roomList);
        UnityRateRoomsFragment fragment = new UnityRateRoomsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_unity_rate_rooms;
    }

    @Override
    public void init() {
        tvQuestion.setText(unityAnswer.getQuestion());
        progressBar.setProgress(HowYouLiveProgressBar.HowYouLive.UNITY);
        images = new ArrayList<>();
        texts = new ArrayList<>();

        images.add(R.drawable.ic_droiosdodroios);
        images.add(R.drawable.ic_droios);
        images.add(R.drawable.ic_mec);
        images.add(R.drawable.ic_suave);
        images.add(R.drawable.ic_supersuave);

        texts.add("Muito dif??cil");
        texts.add("Dif??cil");
        texts.add("Regular");
        texts.add("F??cil");
        texts.add("Muito f??cil");


        Collections.reverse(images);
        Collections.reverse(texts);
        mVolume.setListener(this);
        mVolume.setMax(images.size() - 1);
        answerRequest = new AnswerRequest(unityAnswer.getQuestion(), unityAnswer.getQuestionPartId(), texts.get(0));
        roomsList = (List<UnityAnswer>) getArguments().getSerializable("list");
    }

    @Override
    public void positionVolume(int position) {
        anyOptionChecked = true;
        mIvAge.setImageResource(images.get(position));
        mTvAge.setText(texts.get(position));
        mTvAge.setVisibility(View.VISIBLE);
        answerRequest = new AnswerRequest(unityAnswer.getQuestion(), unityAnswer.getQuestionPartId(), texts.get(position));
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (getActivity() != null) {
            if (anyOptionChecked) {
                ResearchFlow.addAnswer(answerRequest, this);
                ((AboutYouActivity) getActivity()).addFragment(UnitySatisfactionRoom.newInstance(roomsList, 0));
            }
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
