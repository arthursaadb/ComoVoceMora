package br.com.como_voce_mora.ui.previoushouse;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.CustomSelectedView;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.PreviousHouseAnswer;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.aboutyou.SplashAboutYouActivity;
import butterknife.BindView;
import butterknife.OnClick;

public class PreviousHomeTypeFragment extends BaseFragment {
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;
    @BindView(R.id.csvHouse)
    CustomSelectedView csvHouse;
    @BindView(R.id.csvApartament)
    CustomSelectedView csvApartment;
    @BindView(R.id.tv_question)
    TextView tvQuestion;

    private boolean anyOptionChecked = false;
    private Fragment nextFragment;
    private AnswerRequest answerRequest;
    private PreviousHouseAnswer previous = PreviousHouseAnswer.PREVIUS_PLACE_TYPE;

    public static PreviousHomeTypeFragment newInstance() {
        return new PreviousHomeTypeFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_previous_home_type;
    }

    @Override
    public void init() {
        tvQuestion.setText(previous.getQuestion());
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.BEFORE_RESIDENCE);
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (anyOptionChecked) {
            goNextFragment();
        }
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    @OnClick({R.id.csvHouse, R.id.csvApartament})
    void onClick(View view) {
        anyOptionChecked = true;
        switch (view.getId()) {
            case R.id.csvHouse:
                nextFragment = PreviousWhichHouseFragment.newInstance();
                csvHouse.setChecked(true);
                csvApartment.setChecked(false);
                setAnswer(csvHouse.getText());
                break;
            case R.id.csvApartament:
                csvHouse.setChecked(false);
                csvApartment.setChecked(true);
                nextFragment = PreviousWhichApartmentFragment.newInstance();
                setAnswer(csvApartment.getText());
                break;
        }
    }

    private void goNextFragment() {
        ResearchFlow.addAnswer(answerRequest, this);
        ((AboutYouActivity) requireActivity()).addFragment(nextFragment);
    }

    private void setAnswer(String text) {
        answerRequest = new AnswerRequest(previous.getQuestion(), previous.getQuestionPartId(), text);
    }

    @OnClick(R.id.btPreviousSession)
    public void onBtPreviouSessionClicked() {
        Intent intent = new Intent(getActivity(), SplashAboutYouActivity.class);
        startActivity(intent);
        getActivity().finish();
    }
}
