package br.com.como_voce_mora.ui.previoushouse;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.custom.VolumeVertical;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.PreviousHouseAnswer;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.currentresidence.CurrentHomeFragment;
import butterknife.BindView;
import butterknife.OnClick;

public class PreviousHouseTimeFragment extends BaseFragment implements VolumeVertical.OnListener {
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;
    @BindView(R.id.iv_school)
    ImageView mIvSchool;
    @BindView(R.id.tv_school)
    TextView nTvSchool;
    @BindView(R.id.tv_question)
    TextView tvQuestion;
    @BindView(R.id.volume)
    VolumeVertical volumeVertical;

    private boolean anyOptionChecked = false;
    private AnswerRequest answerRequest;
    private PreviousHouseAnswer previous = PreviousHouseAnswer.STAY_TIME;
    private List<Integer> images;
    private List<String> texts;

    public static PreviousHouseTimeFragment newInstance() {
        return new PreviousHouseTimeFragment();
    }

    @Override
    public void init() {
        tvQuestion.setText(previous.getQuestion());
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.BEFORE_RESIDENCE);

        texts = new ArrayList<>();
        texts.add(getString(R.string.mais_de_cinco));
        texts.add(getString(R.string.tres_a_quatro));
        texts.add(getString(R.string.dois_a_tres));
        texts.add(getString(R.string.um_a_dois));
        texts.add(getString(R.string.zero_a_um));
        images = new ArrayList<>();
        images.add(R.drawable.cinco_anos);
        images.add(R.drawable.tres_anos_meio);
        images.add(R.drawable.dois_anos_meio);
        images.add(R.drawable.um_ano_meio);
        images.add(R.drawable.um_ano);
        volumeVertical.setListener(this);
        volumeVertical.setMax(texts.size() - 1);
    }


    @Override
    public int getResLayout() {
        return R.layout.fragment_previous_house_time;
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (anyOptionChecked) {
            ResearchFlow.addAnswer(previous.getQuestion(), answerRequest);
            ((AboutYouActivity) requireActivity()).addFragment(CurrentHomeFragment.newInstance());
        }
    }

    @Override
    public void positionVolume(int position) {
        mIvSchool.setImageResource(images.get(position));
        nTvSchool.setText(texts.get(position));
        nTvSchool.setVisibility(View.VISIBLE);

        anyOptionChecked = true;
        answerRequest = new AnswerRequest(previous.getQuestion(), previous.getQuestionPartId(), texts.get(position));
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

}
