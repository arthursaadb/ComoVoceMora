package br.com.como_voce_mora.ui.sustainablehabits;

import android.view.View;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

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
import br.com.como_voce_mora.ui.previoushouse.AcquisitionStateFragment;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class SolarEquipamentTypeFragment extends BaseFragment {
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;
    @BindView(R.id.csvCasaGerminada)
    CustomSelectedView csvCasaGerminada;
    @BindView(R.id.csvSobrado)
    CustomSelectedView csvSobrado;
    @BindView(R.id.csvVila)
    CustomSelectedView csvVila;
    @BindView(R.id.csvTerreo)
    CustomSelectedView csvTerreo;
    @BindView(R.id.tv_question)
    TextView mTvQuestion;

    private String saude = "";
    private String escola = "";
    private String cultura = "";
    private String lazer = "";
    SustainableHabitsAnswer sustainableHabitsAnswer = SustainableHabitsAnswer.EQUIPMENT_SOLAR_ENERGY;

    private List<AnswerRequest> answerRequests = new ArrayList<>();
    private boolean anyOptionChecked = false;

    public static SolarEquipamentTypeFragment newInstance() {
        return new SolarEquipamentTypeFragment();
    }

    @Override
    public void init() {
        super.init();
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.HABITS);
        mTvQuestion.setText(sustainableHabitsAnswer.getQuestion());
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_solar_equipament_type;
    }

    @OnClick({R.id.csvCasaGerminada, R.id.csvSobrado, R.id.csvVila, R.id.csvTerreo, R.id.csvFundo})
    public void onCheckedChanged(View view) {
        CustomSelectedView csv = (CustomSelectedView) view;
        anyOptionChecked = true;
        switch (view.getId()) {
            case R.id.csvCasaGerminada:
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
            case R.id.csvSobrado:
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
            case R.id.csvVila:
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
            case R.id.csvTerreo:
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
        }

    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (anyOptionChecked) {
            setAnswer();
            ((AboutYouActivity) requireActivity()).addFragment(WhyReasonEquipamentFragment.newInstance());
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
        ResearchFlow.addAnswer(sustainableHabitsAnswer.getQuestion(), answerRequest);
        for (AnswerRequest r : answerRequests) {
            ResearchFlow.addAnswer(r.getDwellerId(), r);
        }
    }
}
