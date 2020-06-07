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

public class UnityUtilAreaFragment extends BaseFragment  implements VolumeVertical.OnListener {

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
        images.add(R.drawable.ic_30mts);
        images.add(R.drawable.ic_35mts);
        images.add(R.drawable.ic_40mts);
        images.add(R.drawable.ic_45mts);
        images.add(R.drawable.ic_50mts);
        images.add(R.drawable.ic_55mts);
        images.add(R.drawable.ic_60mts);
        images.add(R.drawable.ic_65mts);
        images.add(R.drawable.ic_70mts);
        images.add(R.drawable.ic_75mts);
        images.add(R.drawable.ic_80mts);
        images.add(R.drawable.ic_85mts);
        images.add(R.drawable.ic_90mts);
        images.add(R.drawable.ic_95mts);
        images.add(R.drawable.ic_100mts);
        images.add(R.drawable.ic_105mts);
        images.add(R.drawable.ic_110mts);
        images.add(R.drawable.ic_115mts);
        images.add(R.drawable.ic_120mts);
        images.add(R.drawable.ic_125mts);
        images.add(R.drawable.ic_130mts);
        images.add(R.drawable.ic_135mts);
        images.add(R.drawable.ic_140mts);
        images.add(R.drawable.ic_145mts);
        images.add(R.drawable.ic_150mts);
        images.add(R.drawable.ic_155mts);
        images.add(R.drawable.ic_160mts);
        images.add(R.drawable.ic_165mts);
        images.add(R.drawable.ic_170mts);
        images.add(R.drawable.ic_175mts);
        images.add(R.drawable.ic_180mts);
        images.add(R.drawable.ic_185mts);
        images.add(R.drawable.ic_190mts);
        images.add(R.drawable.ic_195mts);
        images.add(R.drawable.ic_200mts);
        images.add(R.drawable.ic_205mts);
        images.add(R.drawable.ic_210mts_ou_mais);

        texts = new ArrayList<>();
        texts.add("30 m2");
        texts.add("35 m2");
        texts.add("40 m2");
        texts.add("45 m2");
        texts.add("50 m2");
        texts.add("55 m2");
        texts.add("60 m2");
        texts.add("65 m2");
        texts.add("70 m2");
        texts.add("75 m2");
        texts.add("80 m2");
        texts.add("85 m2");
        texts.add("90 m2");
        texts.add("95 m2");
        texts.add("100 m2");
        texts.add("105 m2");
        texts.add("110 m2");
        texts.add("115 m2");
        texts.add("120 m2");
        texts.add("126 m2");
        texts.add("130 m2");
        texts.add("136 m2");
        texts.add("140 m2");
        texts.add("146 m2");
        texts.add("150 m2");
        texts.add("156 m2");
        texts.add("160 m2");
        texts.add("166 m2");
        texts.add("170 m2");
        texts.add("176 m2");
        texts.add("180 m2");
        texts.add("186 m2");
        texts.add("190 m2");
        texts.add("196 m2");
        texts.add("200 m2");
        texts.add("205 m2");
        texts.add("210 m2 ou mais");

    }
}
