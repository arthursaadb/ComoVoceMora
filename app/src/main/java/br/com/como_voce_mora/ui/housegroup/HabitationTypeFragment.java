package br.com.como_voce_mora.ui.housegroup;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.HouseGroupAnswer;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.custom.CustomSelectedView;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.ui.currentresidence.CurrentHomeFragment;
import butterknife.BindView;
import butterknife.OnClick;

public class HabitationTypeFragment extends BaseFragment {

    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;
    @BindView(R.id.csvApartament)
    CustomSelectedView csvApartament;
    @BindView(R.id.csvHouse)
    CustomSelectedView csvHouse;
    @BindView(R.id.tv_question)
    TextView tvQuestion;

    private boolean anyOneSelected = false;
    private AnswerRequest answerRequests;
    private HouseGroupAnswer houseGroupAnser = HouseGroupAnswer.HOUSING_TYPOLOGY;
    private boolean houseChecked = false;

    public static HabitationTypeFragment newInstance() {
        return new HabitationTypeFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_habitation_type;
    }

    @Override
    public void init() {
        tvQuestion.setText(houseGroupAnser.getQuestion());
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (anyOneSelected) {
            ResearchFlow.addAnswer(answerRequests, this);
            ResearchFlow.setHouse(houseChecked);
            ((AboutYouActivity) requireActivity()).addFragment(HabitationCondominiumFragment.newInstance());
        }
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    @OnClick({R.id.csvHouse, R.id.csvApartament})
    public void onClickViews(View view) {
        anyOneSelected = true;
        setAnswer(((CustomSelectedView) view).getText());
        switch (view.getId()) {
            case R.id.csvHouse:
                houseChecked = true;
                csvHouse.setChecked(true);
                csvApartament.setChecked(false);
                break;
            case R.id.csvApartament:
                houseChecked = false;
                csvHouse.setChecked(false);
                csvApartament.setChecked(true);
                break;
        }
    }

    private void setAnswer(String text) {
        answerRequests = new AnswerRequest(houseGroupAnser.getQuestion(), houseGroupAnser.getQuestionPartId(), text);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.GROUP);
    }

    @OnClick(R.id.btPreviousSession)
    public void onBtPreviouSessionClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) requireActivity()).addFragment(CurrentHomeFragment.newInstance());
        }
    }
}
