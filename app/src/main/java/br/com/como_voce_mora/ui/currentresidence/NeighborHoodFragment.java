package br.com.como_voce_mora.ui.currentresidence;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.model.AboutYouAnswer;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.CurrentResidenceAnswer;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.custom.VolumeVertical;
import butterknife.BindView;
import butterknife.OnClick;

public class NeighborHoodFragment extends BaseFragment implements VolumeVertical.OnListener {
    @BindView(R.id.volume)
    VolumeVertical mVolume;
    @BindView(R.id.iv_age)
    ImageView mIvAge;
    @BindView(R.id.tv_age)
    TextView mTvAge;
    @BindView(R.id.tv_question)
    TextView tvQuesion;
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar progressBar;

    private List<Integer> images;
    private List<String> texts;
    private AnswerRequest answerRequest;
    private CurrentResidenceAnswer currentResidenceAnswer = CurrentResidenceAnswer.NEIGHBORHOOD_IDENTIFICATION;

    public static NeighborHoodFragment newInstance() {

        Bundle args = new Bundle();

        NeighborHoodFragment fragment = new NeighborHoodFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_neighborhood;
    }

    @Override
    public void init() {
        super.init();
        tvQuesion.setText(currentResidenceAnswer.getQuestion());
        progressBar.setProgress(HowYouLiveProgressBar.HowYouLive.ATUAL_RESIDENCE);
        images = new ArrayList<>();
        texts = new ArrayList<>();
        images.add(R.drawable.ic_muito_bom);
        texts.add("Plenamente");
        images.add(R.drawable.ic_bom);
        texts.add("Muito");
        images.add(R.drawable.ic_regular);
        texts.add("Medio");
        images.add(R.drawable.ic_ruim);
        texts.add("Pouco");
        images.add(R.drawable.ic_muito_ruim);
        texts.add("Ligeiramente");

        mVolume.setListener(this);
        mVolume.setMax(images.size() - 1);
        answerRequest = new AnswerRequest(currentResidenceAnswer.getQuestion(), currentResidenceAnswer.getQuestionPartId(), texts.get(2));
    }

    @Override
    public void positionVolume(int position) {
        mIvAge.setImageResource(images.get(position));
        mTvAge.setText(texts.get(position));
        mTvAge.setVisibility(View.VISIBLE);
        answerRequest = new AnswerRequest(currentResidenceAnswer.getQuestion(), currentResidenceAnswer.getQuestionPartId(), texts.get(position));
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        ResearchFlow.addAnswer(currentResidenceAnswer.getQuestion(), answerRequest);
        ((AboutYouActivity) requireActivity()).addFragment(EquipamentsFragment.newInstance());
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }
}
