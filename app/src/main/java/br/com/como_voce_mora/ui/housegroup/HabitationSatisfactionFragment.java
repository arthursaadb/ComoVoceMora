package br.com.como_voce_mora.ui.housegroup;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.CustomRadioButton;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.HouseGroupAnswer;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.building.BuildingWhichDivisionFragment;
import br.com.como_voce_mora.ui.currentresidence.CurrentHomeFragment;
import butterknife.BindView;
import butterknife.OnClick;

public class HabitationSatisfactionFragment extends BaseFragment implements View.OnClickListener {

    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar progressBar;
    @BindView(R.id.tv_question)
    TextView tvQuestion;
    @BindView(R.id.rbChildrenPool)
    CustomRadioButton mRbChildrenPool;
    @BindView(R.id.rbGourmetSpace)
    CustomRadioButton mRbGourmetSpace;
    @BindView(R.id.rbGameRoom)
    CustomRadioButton mRbGameRoom;
    @BindView(R.id.rbSteamRoom)
    CustomRadioButton mRbSteamRoom;
    @BindView(R.id.rbkiosk)
    CustomRadioButton mRbkiosk;
    @BindView(R.id.rbAdultPool)
    CustomRadioButton mRbAdultPool;
    @BindView(R.id.rbPartyRoom)
    CustomRadioButton mRbPartyRoom;
    @BindView(R.id.rbBlock)
    CustomRadioButton mRbBlock;
    @BindView(R.id.rbPlayground)
    CustomRadioButton mRbPlayground;
    @BindView(R.id.rbGym)
    CustomRadioButton mRbGym;
    @BindView(R.id.rbBarbecue)
    CustomRadioButton mRbBarbecue;
    @BindView(R.id.rbOther)
    CustomRadioButton mRbOther;

    private StringBuilder answer = new StringBuilder();
    HouseGroupAnswer houseGroupAnswer = HouseGroupAnswer.EQUIPMENTS_TO_ADD;
    private boolean anyOptionChecked = false;

    public static HabitationSatisfactionFragment newInstance() {

        Bundle args = new Bundle();

        HabitationSatisfactionFragment fragment = new HabitationSatisfactionFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_habitation_satisfaction;
    }

    @Override
    public void init() {
        progressBar.setProgress(HowYouLiveProgressBar.HowYouLive.GROUP);
        tvQuestion.setText(houseGroupAnswer.getQuestion());
        mRbChildrenPool.setOnClickListener(this);
        mRbGourmetSpace.setOnClickListener(this);
        mRbGameRoom.setOnClickListener(this);
        mRbSteamRoom.setOnClickListener(this);
        mRbkiosk.setOnClickListener(this);
        mRbAdultPool.setOnClickListener(this);
        mRbPartyRoom.setOnClickListener(this);
        mRbBlock.setOnClickListener(this);
        mRbPlayground.setOnClickListener(this);
        mRbGym.setOnClickListener(this);
        mRbBarbecue.setOnClickListener(this);
        mRbOther.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        CustomRadioButton option = (CustomRadioButton) v;
        anyOptionChecked = true;
        if (v.isPressed()) {
            answer.append(option.getText().toString());
            answer.append(";");
            updateRbs();
        }
    }

    private void updateRbs() {
        mRbChildrenPool.updateView();
        mRbGourmetSpace.updateView();
        mRbGameRoom.updateView();
        mRbSteamRoom.updateView();
        mRbkiosk.updateView();
        mRbAdultPool.updateView();
        mRbPartyRoom.updateView();
        mRbBlock.updateView();
        mRbPlayground.updateView();
        mRbGym.updateView();
        mRbBarbecue.updateView();
        mRbOther.updateView();
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (anyOptionChecked) {
            if (getActivity() != null) {
                ResearchFlow.addAnswer(new AnswerRequest(houseGroupAnswer.getQuestion(), houseGroupAnswer.getQuestionPartId(), answer.toString()), this);
                ((AboutYouActivity) getActivity()).addFragment(HabitationEquipmentsMeaningFragment.newInstance());
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
            ((AboutYouActivity) requireActivity()).addFragment(CurrentHomeFragment.newInstance());
        }
    }
}
