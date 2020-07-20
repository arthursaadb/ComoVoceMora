package br.com.como_voce_mora.ui.unity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.VolumeVertical;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.model.UnityAnswer;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import butterknife.BindView;
import butterknife.OnClick;

public class UnityUtilAreaFragment extends BaseFragment implements VolumeVertical.OnListener {

    @BindView(R.id.volume)
    VolumeVertical mVolume;
    @BindView(R.id.iv_school)
    ImageView ivSchool;
    @BindView(R.id.tv_school)
    TextView tvSchool;
    @BindView(R.id.tv_question)
    TextView tvQuestion;
    private List<Integer> images;
    private List<String> texts;

    private AnswerRequest answerRequest;
    private UnityAnswer unityAnswer = UnityAnswer.UTIL_AREA;

    public static UnityUtilAreaFragment newInstance() {

        Bundle args = new Bundle();

        UnityUtilAreaFragment fragment = new UnityUtilAreaFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_unity_util_area;
    }

    @Override
    public void init() {
        tvQuestion.setText(unityAnswer.getQuestion());
        startVolume();
        mVolume.setListener(this);
        mVolume.setMax(images.size() - 1);

        ivSchool.setImageResource(images.get(images.size() / 2));
        answerRequest = new AnswerRequest(unityAnswer.getQuestion(), unityAnswer.getQuestionPartId(), texts.get(0));

    }


    @Override
    public void positionVolume(int position) {
        ivSchool.setImageResource(images.get(position));
        tvSchool.setText(texts.get(position));
        tvSchool.setVisibility(View.VISIBLE);
        answerRequest = new AnswerRequest(unityAnswer.getQuestion(), unityAnswer.getQuestionPartId(), texts.get(position));
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        ResearchFlow.addAnswer(unityAnswer.getQuestion(), answerRequest);
        ((AboutYouActivity) requireActivity()).addFragment(UnityRoomsFragment.newInstance());

    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    private void startVolume() {
        images = new ArrayList<>();
        images.add(R.drawable.ic_210mts_ou_mais);
        images.add(R.drawable.ic_100mts);
        images.add(R.drawable.ic_50mts);
        images.add(R.drawable.ic_30mts);

        texts = new ArrayList<>();
        texts.add("Mais de 200\u00B2");
        texts.add("100m\u00B2 a 150m\u00B2");
        texts.add("50m\u00B2 a 100m\u00B2");
        texts.add("50m\u00B2");

    }
}
