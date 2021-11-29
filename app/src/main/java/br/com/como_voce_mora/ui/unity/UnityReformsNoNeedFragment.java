package br.com.como_voce_mora.ui.unity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.CustomRadioButton;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.model.UnityAnswer;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.building.BuildingSplashFragment;
import butterknife.BindView;
import butterknife.OnClick;

public class UnityReformsNoNeedFragment extends BaseFragment implements CustomRadioButton.OnCheckedChangeListener {
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;
    @BindView(R.id.tv_question)
    TextView tvQuestion;
    @BindView(R.id.rbYes)
    CustomRadioButton rb1;
    @BindView(R.id.rbNo)
    CustomRadioButton rb2;
    @BindView(R.id.rbParedes)
    CustomRadioButton rb3;
    @BindView(R.id.rbPortas)
    CustomRadioButton rb4;
    @BindView(R.id.rbJanelas)
    CustomRadioButton rb5;
    @BindView(R.id.rbSacada)
    CustomRadioButton rb6;
    @BindView(R.id.rbNew1)
    CustomRadioButton rb7;
    @BindView(R.id.rbNew2)
    CustomRadioButton rb8;

    private final UnityAnswer unityAnswer = UnityAnswer.WHY_DONT_REFORM;
    private List<String> answerList = new ArrayList<>();
    StringBuilder answerResponse = new StringBuilder();

    public static UnityReformsNoNeedFragment newInstance(List<UnityAnswer> room) {
        Bundle args = new Bundle();
        args.putSerializable("list", (Serializable) room);
        UnityReformsNoNeedFragment fragment = new UnityReformsNoNeedFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_unity_reforms_no_need;
    }

    @Override
    public void init() {
        tvQuestion.setText(unityAnswer.getQuestion());
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.UNITY);
        rb1.setOnCheckedChangeListener(this);
        rb2.setOnCheckedChangeListener(this);
        rb3.setOnCheckedChangeListener(this);
        rb4.setOnCheckedChangeListener(this);
        rb5.setOnCheckedChangeListener(this);
        rb6.setOnCheckedChangeListener(this);
        rb7.setOnCheckedChangeListener(this);
        rb8.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            buttonView.setChecked(true);
            answerList.add(buttonView.getText().toString());
        } else {
            buttonView.setChecked(false);
            answerList.remove(buttonView.getText().toString());
        }

        updateRbs();
    }

    private void updateRbs() {
        rb1.updateView();
        rb2.updateView();
        rb3.updateView();
        rb4.updateView();
        rb5.updateView();
        rb6.updateView();
        rb7.updateView();
        rb8.updateView();
    }


    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (!answerList.isEmpty()) {
            for (String r : answerList) {
                answerResponse.append(r);
                answerResponse.append(";");
            }
        }

        AnswerRequest answer = new AnswerRequest(unityAnswer.getQuestion(),
                unityAnswer.getQuestionPartId(), answerResponse.toString());

        ResearchFlow.addAnswer(answer, this);

        ((AboutYouActivity) requireActivity()).addFragment(UnitySunLightFragment.newInstance((List<UnityAnswer>) getArguments().getSerializable("list")));
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