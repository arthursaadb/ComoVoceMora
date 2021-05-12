package br.com.como_voce_mora.ui.aboutyou;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.model.AboutYouAnswer;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.custom.VolumeVertical;
import br.com.como_voce_mora.ui.previoushouse.PreviousHomeSplashFragment;
import butterknife.BindView;
import butterknife.OnClick;

public class FamilyIncomeFragment extends BaseFragment implements VolumeVertical.OnListener {
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

    private List<Integer> images;
    private List<String> texts;

    AboutYouAnswer aboutYouAnswer = AboutYouAnswer.FAMILY_INCOME;
    AnswerRequest answerRequest;

    public static FamilyIncomeFragment newInstance() {
        return new FamilyIncomeFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_family_income;
    }

    @Override
    public void init() {
        tvQuestion.setText(aboutYouAnswer.getQuestion());
        progressBar.setProgress(HowYouLiveProgressBar.HowYouLive.ABOUT_YOU);
        images = new ArrayList<>();
        texts = new ArrayList<>();
        images.add(R.drawable.ic_1);
        images.add(R.drawable.ic_1_5);
        images.add(R.drawable.ic_2);
        images.add(R.drawable.ic_2_5);
        images.add(R.drawable.ic_3);
        images.add(R.drawable.ic_3_5);
        images.add(R.drawable.ic_4);
        images.add(R.drawable.ic_4_5);
        images.add(R.drawable.ic_5);
        images.add(R.drawable.ic_5_5);
        images.add(R.drawable.ic_6);
        images.add(R.drawable.ic_6_5);
        images.add(R.drawable.ic_7);
        images.add(R.drawable.ic_7_5);
        images.add(R.drawable.ic_8);
        images.add(R.drawable.ic_8_5);
        images.add(R.drawable.ic_9);
        images.add(R.drawable.ic_9_5);
        images.add(R.drawable.ic_10_ou_mais);
        Collections.reverse(images);
        texts.add("Até 500 reais");
        texts.add("Até 1000 reais");
        texts.add("Até 1500 reais");
        texts.add("Até 2500 reais");
        texts.add("Até 3000 reais");
        texts.add("Até 3500 reais");
        texts.add("Até 4000 reais");
        texts.add("Até 4500 reais");
        texts.add("Até 5000 reais");
        texts.add("Até 5500 reais");
        texts.add("Até 6000 reais");
        texts.add("Até 6500 reais");
        texts.add("Até 7000 reais");
        texts.add("Até 7500 reais");
        texts.add("Até 8000 reais");
        texts.add("Até 8500 reais");
        texts.add("Até 9000 reais");
        texts.add("Até 9500 reais");
        texts.add("10000 reais ou mais");
        Collections.reverse(texts);

        mVolume.setListener(this);
        mVolume.setMax(images.size() - 1);
    }

    @Override
    public void positionVolume(int position) {
        mIvAge.setImageResource(images.get(position));
        mTvAge.setText(texts.get(position));
        mTvAge.setVisibility(View.VISIBLE);
        answerRequest = new AnswerRequest(aboutYouAnswer.getQuestion(), aboutYouAnswer.getQuestionPartId(), texts.get(position));
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
            if(answerRequest == null){
                answerRequest = new AnswerRequest(aboutYouAnswer.getQuestion(), aboutYouAnswer.getQuestionPartId(), "");
            }

            ResearchFlow.addAnswer(answerRequest, this);
            ((AboutYouActivity) requireActivity()).addFragment(PreviousHomeSplashFragment.newInstance());
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }
}
