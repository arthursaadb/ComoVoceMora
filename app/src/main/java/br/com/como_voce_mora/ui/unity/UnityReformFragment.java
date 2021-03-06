package br.com.como_voce_mora.ui.unity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.CustomRadioButton;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.model.UnityAnswer;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.building.BuildingFloorFragment;
import br.com.como_voce_mora.ui.building.BuildingSplashFragment;
import butterknife.BindView;
import butterknife.OnClick;

public class UnityReformFragment extends BaseFragment implements CompoundButton.OnCheckedChangeListener {

    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;
    @BindView(R.id.tv_question)
    TextView mTvQuestion;
    @BindView(R.id.rbAcabamento)
    CustomRadioButton mRb1;
    @BindView(R.id.rbPortas)
    CustomRadioButton mRb2;
    @BindView(R.id.rbGesso)
    CustomRadioButton mRb3;
    @BindView(R.id.rbPintura)
    CustomRadioButton mRb4;
    @BindView(R.id.rbArmario)
    CustomRadioButton mRb5;
    @BindView(R.id.rbParedes)
    CustomRadioButton mRb6;
    @BindView(R.id.rbRachaduras)
    CustomRadioButton mRb7;
    @BindView(R.id.rbNenhuma)
    CustomRadioButton mRb8;

    private UnityAnswer unityAnswer = UnityAnswer.REFORM_MADE;
    private boolean anyOptionChecked = false;
    private List<String> answerList = new ArrayList<>();
    private StringBuilder answer = new StringBuilder();
    private Boolean none = false;

    public static UnityReformFragment newInstance(List<UnityAnswer> room) {

        Bundle args = new Bundle();
        args.putSerializable("list", (Serializable) room);
        UnityReformFragment fragment = new UnityReformFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_unity_reform;
    }

    @Override
    public void init() {
        mTvQuestion.setText(unityAnswer.getQuestion());
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.UNITY);
        mRb1.setOnCheckedChangeListener(this);
        mRb2.setOnCheckedChangeListener(this);
        mRb3.setOnCheckedChangeListener(this);
        mRb4.setOnCheckedChangeListener(this);
        mRb6.setOnCheckedChangeListener(this);
        mRb5.setOnCheckedChangeListener(this);
        mRb7.setOnCheckedChangeListener(this);
        mRb8.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        if (isChecked) {
            anyOptionChecked = true;
            compoundButton.setChecked(true);

            if (compoundButton.getId() == R.id.rbNenhuma) {
                mRb1.setChecked(false);
                mRb2.setChecked(false);
                mRb3.setChecked(false);
                mRb4.setChecked(false);
                mRb5.setChecked(false);
                mRb6.setChecked(false);
                mRb7.setChecked(false);
                answerList.clear();
                answerList.add(compoundButton.getText().toString());
                none = true;
            } else {
                answerList.add(compoundButton.getText().toString());
                mRb8.setChecked(false);
                none = false;
            }
        } else {
            answerList.remove(compoundButton.getText().toString());
            compoundButton.setChecked(false);
        }

        updateRbs();
    }

    private void updateRbs() {
        mRb1.updateView();
        mRb2.updateView();
        mRb3.updateView();
        mRb4.updateView();
        mRb5.updateView();
        mRb6.updateView();
        mRb7.updateView();
        mRb8.updateView();
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (anyOptionChecked && answerList.size() > 0) {
            if (getActivity() != null) {
                setAnswer();
                if (none) {
                    ((AboutYouActivity) requireActivity()).addFragment(UnityReformssNeeds.newInstance((List<UnityAnswer>) getArguments().getSerializable("list")));
                } else {
                    ((AboutYouActivity) getActivity()).addFragment(UnityReformReasonFragment.newInstance((List<UnityAnswer>) getArguments().getSerializable("list")));
                }
            }
        }
    }

    private void setAnswer() {
        if (answerList.size() > 0) {
            for (String value : answerList) {
                answer.append(value);
                answer.append(";");
            }
        }

        ResearchFlow.addAnswer(new AnswerRequest(unityAnswer.getQuestion(), unityAnswer.getQuestionPartId(), answer.toString()), this);
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
