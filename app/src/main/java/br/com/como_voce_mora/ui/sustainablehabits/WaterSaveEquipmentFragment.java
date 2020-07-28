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

    private List<AnswerRequest> answerRequests = new ArrayList<>();
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
                if (!csv.isChecked()) {
                    csv.setChecked(true);
                    saude = csv.getText();
                    answerRequests.add(new AnswerRequest(sustainableHabitsAnswer.getQuestion(),
                            sustainableHabitsAnswer.getQuestionPartId(), saude));
                    break;
                } else {
                    csv.setChecked(false);
                    removeItem(sustainableHabitsAnswer.getQuestion());
                    break;
                }
            case R.id.csvPhotovoltaicPanels:
                if (!csv.isChecked()) {
                    csv.setChecked(true);
                    escola = csv.getText();
                    answerRequests.add(new AnswerRequest(sustainableHabitsAnswer.getQuestion(),
                            sustainableHabitsAnswer.getQuestionPartId(), escola));
                    break;
                } else {
                    csv.setChecked(false);
                    removeItem(sustainableHabitsAnswer.getQuestion());
                }
            case R.id.csv5:
                if (!csv.isChecked()) {
                    csv.setChecked(true);
                    cultura = csv.getText();
                    answerRequests.add(new AnswerRequest(sustainableHabitsAnswer.getQuestion(),
                            sustainableHabitsAnswer.getQuestionPartId(), cultura));
                    break;
                } else {
                    csv.setChecked(false);
                    removeItem(sustainableHabitsAnswer.getQuestion());
                }
            case R.id.csvSystems:
                if (!csv.isChecked()) {
                    csv.setChecked(true);
                    lazer = csv.getText();
                    answerRequests.add(new AnswerRequest(sustainableHabitsAnswer.getQuestion(),
                            sustainableHabitsAnswer.getQuestionPartId(), lazer));
                    break;
                } else {
                    csv.setChecked(false);
                    removeItem(sustainableHabitsAnswer.getQuestion());
                }
            case R.id.cvsNone:
                if (!csv.isChecked()) {
                    csv.setChecked(true);
                    five = csv.getText();
                    answerRequests.add(new AnswerRequest(sustainableHabitsAnswer.getQuestion(),
                            sustainableHabitsAnswer.getQuestionPartId(), five));
                    break;
                } else {
                    csv.setChecked(false);
                    removeItem(sustainableHabitsAnswer.getQuestion());
                }

            case R.id.others:
                if (!csv.isChecked()) {
                    csv.setChecked(true);
                    six = csv.getText();
                    answerRequests.add(new AnswerRequest(sustainableHabitsAnswer.getQuestion(),
                            sustainableHabitsAnswer.getQuestionPartId(), six));
                    break;
                } else {
                    csv.setChecked(false);
                    removeItem(sustainableHabitsAnswer.getQuestion());
                }
        }

    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (anyOptionChecked) {
            setAnswer();
            ((AboutYouActivity) requireActivity()).addFragment(DoYouSaveElectricityFragment.newInstance());
        }
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    private void removeItem(String question) {
        int cont = 0;
        int pos = cont;
        if (!answerRequests.isEmpty()) {
            for (AnswerRequest r : answerRequests) {
                if (r.getDwellerId().equals(question)) {
                    pos = cont;
                }
                cont++;
            }
            answerRequests.remove(pos);
        }
    }

    private void setAnswer() {
        AnswerRequest answerRequest = new AnswerRequest(sustainableHabitsAnswer.getQuestion(), sustainableHabitsAnswer.getQuestionPartId(), "");
        ResearchFlow.addAnswer(answerRequest, this);
        for (AnswerRequest r : answerRequests) {
            ResearchFlow.addAnswer(r, this);
        }
    }
}
