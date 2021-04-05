package br.com.como_voce_mora.ui.sustainablehabits;

import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.CustomSelectedView;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.model.SustainableHabitsAnswer;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.unity.UnitySplashFragment;
import butterknife.BindView;
import butterknife.OnClick;

public class WaterSaveEquipmentFragment extends BaseFragment {
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;
    @BindView(R.id.cvsSolarPlates)
    CustomSelectedView cvsSolarPlates;
    @BindView(R.id.csvPhotovoltaicPanels)
    CustomSelectedView csvPhotovoltaicPanels;
    @BindView(R.id.csv5)
    CustomSelectedView csv5;
    @BindView(R.id.csvSystems)
    CustomSelectedView csvSystems;
    @BindView(R.id.cvsNone)
    CustomSelectedView cvsNone;
    @BindView(R.id.others)
    CustomSelectedView others;
    @BindView(R.id.tv_question)
    TextView mTvQuestion;

    private String saude = "";
    private String escola = "";
    private String cultura = "";
    private String lazer = "";
    private String five = "";
    private String six = "";
    SustainableHabitsAnswer sustainableHabitsAnswer = SustainableHabitsAnswer.WATHER_SAVE_EQUIPMENT;
    AnswerRequest answerRequest;
    private List<String> answerList = new ArrayList<>();
    StringBuilder answer = new StringBuilder();
    private boolean anyOptionChecked = false;

    public static WaterSaveEquipmentFragment newInstance() {
        return new WaterSaveEquipmentFragment();
    }

    @Override
    public void init() {
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.HABITS);
        mTvQuestion.setText(sustainableHabitsAnswer.getQuestion());
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_water_save_equipment;
    }

    @OnClick({R.id.cvsSolarPlates, R.id.csvPhotovoltaicPanels, R.id.csv5, R.id.csvSystems, R.id.cvsNone, R.id.others})
    public void onCheckedChanged(View view) {
        CustomSelectedView csv = (CustomSelectedView) view;
        anyOptionChecked = true;
        switch (view.getId()) {
            case R.id.cvsSolarPlates:
                saude = csv.getText();

                if (!csv.isChecked()) {
                    csv.setChecked(true);
                    answerList.add(saude);
                } else {
                    csv.setChecked(false);
                    answerList.remove(saude);
                }
                break;
            case R.id.csvPhotovoltaicPanels:
                escola = csv.getText();

                if (!csv.isChecked()) {
                    csv.setChecked(true);
                    answerList.add(escola);
                } else {
                    csv.setChecked(false);
                    answerList.remove(escola);
                }
                break;
            case R.id.csv5:
                cultura = csv.getText();
                if (!csv.isChecked()) {
                    csv.setChecked(true);
                    answerList.add(cultura);
                } else {
                    csv.setChecked(false);
                    answerList.remove(cultura);
                }
                break;
            case R.id.csvSystems:
                lazer = csv.getText();
                if (!csv.isChecked()) {
                    csv.setChecked(true);
                    answerList.add(lazer);
                } else {
                    csv.setChecked(false);
                    answerList.remove(lazer);
                }
                break;
            case R.id.cvsNone:
                five = csv.getText();
                if (!csv.isChecked()) {
                    csv.setChecked(true);
                    answerList.add(five);
                    break;
                } else {
                    csv.setChecked(false);
                    answerList.remove(lazer);
                    break;
                }

            case R.id.others:
                six = csv.getText();
                if (!csv.isChecked()) {
                    csv.setChecked(true);
                    answerList.add(six);
                    break;
                } else {
                    csv.setChecked(false);
                    answerList.remove(six);
                    break;
                }
        }

    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (anyOptionChecked) {
            for (String value : answerList) {
                answer.append(value);
                answer.append(";");
            }

            answerRequest = new AnswerRequest(sustainableHabitsAnswer.getQuestion(), sustainableHabitsAnswer
                    .getQuestionPartId(), answer.toString());

            ResearchFlow.addAnswer(answerRequest, this);

            ((AboutYouActivity) requireActivity()).addFragment(WhyYouSaveElectricityFragment.newInstance());
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
            ((AboutYouActivity) requireActivity()).addFragment(UnitySplashFragment.newInstance());
        }
    }
}
