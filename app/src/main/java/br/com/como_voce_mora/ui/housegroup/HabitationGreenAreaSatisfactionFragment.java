package br.com.como_voce_mora.ui.housegroup;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.custom.VolumeVertical;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.HouseGroupAnswer;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.building.BuildingSplashFragment;
import br.com.como_voce_mora.ui.building.BuildingWhichDivisionFragment;
import br.com.como_voce_mora.ui.currentresidence.CurrentHomeFragment;
import butterknife.BindView;
import butterknife.OnClick;

public class HabitationGreenAreaSatisfactionFragment extends BaseFragment implements VolumeVertical.OnListener {
    @BindView(R.id.volume)
    VolumeVertical mVolume;
    @BindView(R.id.iv_age)
    ImageView mIvAge;
    @BindView(R.id.tv_age)
    TextView mTvAge;
    @BindView(R.id.tv_question)
    TextView mTvQuestion;
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar progressBar;

    private List<Integer> agesImage;
    private List<String> agesText;

    private AnswerRequest answerRequest;
    private HouseGroupAnswer aboutYouAnswer = HouseGroupAnswer.GREEN_AREA_SATISFACTION;
    private boolean anyOptionChecked = false;

    public static HabitationGreenAreaSatisfactionFragment newInstance() {
        return new HabitationGreenAreaSatisfactionFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_habitation_green_area_satisfaction;
    }

    @Override
    public void init() {
        progressBar.setProgress(HowYouLiveProgressBar.HowYouLive.GROUP);
        mTvQuestion.setText(aboutYouAnswer.getQuestion());

        agesImage = new ArrayList<>();
        agesImage.add(R.drawable.ic_supersuave);
        agesImage.add(R.drawable.ic_suave);
        agesImage.add(R.drawable.ic_mec);
        agesImage.add(R.drawable.ic_droios);
        agesImage.add(R.drawable.ic_droiosdodroios);

        agesText = new ArrayList<>();
        agesText.add("Muito Bom");
        agesText.add("Bom");
        agesText.add("Regular");
        agesText.add("Ruim");
        agesText.add("Muito Ruim");

        mVolume.setListener(this);
        mVolume.setMax(agesImage.size() - 1);

        mIvAge.setImageResource(agesImage.get(agesImage.size() / 2));
        answerRequest = new AnswerRequest(aboutYouAnswer.getQuestion(), aboutYouAnswer.getQuestionPartId(), agesText.get(0));
    }

    @Override
    public void positionVolume(int position) {
        anyOptionChecked = true;
        mIvAge.setImageResource(agesImage.get(position));
        mTvAge.setText(agesText.get(position));
        answerRequest = new AnswerRequest(aboutYouAnswer.getQuestion(), aboutYouAnswer.getQuestionPartId(), agesText.get(position));
        mTvAge.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (anyOptionChecked) {
            ResearchFlow.addAnswer(answerRequest, this);
            ((AboutYouActivity) requireActivity()).addFragment(BuildingSplashFragment.newInstance());
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
            ((AboutYouActivity) requireActivity()).addFragment(CurrentHomeFragment.newInstance());
        }
    }
}
