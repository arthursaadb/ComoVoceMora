package br.com.como_voce_mora.ui.aboutyou;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.model.AboutYouAnswer;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.custom.VolumeVertical;
import butterknife.BindView;
import butterknife.OnClick;

public class SchoolingFragment extends BaseFragment implements VolumeVertical.OnListener {
    @BindView(R.id.volume)
    VolumeVertical mVolume;
    @BindView(R.id.iv_school)
    ImageView mIvSchool;
    @BindView(R.id.tv_school)
    TextView nTvSchool;
    @BindView(R.id.tv_question)
    TextView tvQuestion;

    private List<Integer> images;
    private List<String> texts;

    private AnswerRequest answerRequest;
    private AboutYouAnswer aboutYouAnswer = AboutYouAnswer.SCHOOLING;

    public static SchoolingFragment newInstance() {
        return new SchoolingFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_schooling;
    }

    @Override
    public void init() {
        tvQuestion.setText(aboutYouAnswer.getQuestion());

        images = new ArrayList<>();
        images.add(R.drawable.ic_escola_superior_completo);
        images.add(R.drawable.ic_escola_superior_completo);
        images.add(R.drawable.ic_escola_superior_completo);
        images.add(R.drawable.ic_escola_superior_incompleto);
        images.add(R.drawable.ic_escola_media_completo_3);
        images.add(R.drawable.ic_escola_medio_incompleto_3);
        images.add(R.drawable.ic_escola_media_completo_2);
        images.add(R.drawable.ic_escola_medio_incompleto_2);
        images.add(R.drawable.ic_escola_media_completo_1);
        images.add(R.drawable.ic_escola_medio_incompleto_1);
        images.add(R.drawable.ic_escola_fundamental_completo_9);
        images.add(R.drawable.ic_escola_fundamental_incompleto_9);
        images.add(R.drawable.ic_escola_fundamental_completo_8);
        images.add(R.drawable.ic_escola_fundamental_incompleto_8);
        images.add(R.drawable.ic_escola_fundamental_completo_7);
        images.add(R.drawable.ic_escola_fundamental_incompleto_7);
        images.add(R.drawable.ic_escola_fundamental_completo_6);
        images.add(R.drawable.ic_escola_fundamental_incompleto_6);
        images.add(R.drawable.ic_escola_fundamental_completo_5);
        images.add(R.drawable.ic_escola_fundamental_incompleto_5);
        images.add(R.drawable.ic_escola_fundamental_completo_4);
        images.add(R.drawable.ic_escola_fundamental_incompleto_4);
        images.add(R.drawable.ic_escola_fundamental_completo_3);
        images.add(R.drawable.ic_escola_fundamental_incompleto_3);
        images.add(R.drawable.ic_escola_fundamental_completo_2);
        images.add(R.drawable.ic_escola_fundamental_incompleto_2);
        images.add(R.drawable.ic_escola_fundamental_completo_1);
        images.add(R.drawable.ic_escola_fundamental_incompleto_1);
        images.add(R.drawable.ic_escola_nunca_fui);

        texts = new ArrayList<>();
        texts.add("Pós-graduação completo");
        texts.add("Pós-graduação incompleto");
        texts.add("ensino superior completo");
        texts.add("ensino superior incompleto");
        texts.add("3° ano médio completo");
        texts.add("3° ano médio incompleto");
        texts.add("2° ano médio completo");
        texts.add("2° ano médio incompleto");
        texts.add("1° ano médio completo");
        texts.add("1° ano médio incompleto");
        texts.add("9° ano fundamental completo");
        texts.add("9° ano fundamental incompleto");
        texts.add("8° ano fundamental completo");
        texts.add("8° ano fundamental incompleto");
        texts.add("7° ano fundamental completo");
        texts.add("7° ano fundamental incompleto");
        texts.add("6° ano fundamental completo");
        texts.add("6° ano fundamental incompleto");
        texts.add("5° ano fundamental completo");
        texts.add("5° ano fundamental incompleto");
        texts.add("4° ano fundamental completo");
        texts.add("4° ano fundamental incompleto");
        texts.add("3° ano fundamental completo");
        texts.add("3° ano fundamental incompleto");
        texts.add("2° ano fundamental completo");
        texts.add("2° ano fundamental incompleto");
        texts.add("1° ano fundamental completo");
        texts.add("1° ano fundamental incompleto");
        texts.add("nunca fui à escola");

        mVolume.setListener(this);
        mVolume.setMax(images.size() - 1);

        mIvSchool.setImageResource(images.get(images.size() / 2));
        answerRequest = new AnswerRequest(aboutYouAnswer.getQuestion(), aboutYouAnswer.getQuestionPartId(), texts.get(0));
    }

    @Override
    public void positionVolume(int position) {
        mIvSchool.setImageResource(images.get(position));
        nTvSchool.setText(texts.get(position));
        nTvSchool.setVisibility(View.VISIBLE);
        answerRequest = new AnswerRequest(aboutYouAnswer.getQuestion(), aboutYouAnswer.getQuestionPartId(), texts.get(position));
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        ResearchFlow.addAnswer(aboutYouAnswer.getQuestion(), answerRequest);
        ((AboutYouActivity) requireActivity()).addFragment(WithWhomYouLiveFragment.newInstance());

    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }
}
