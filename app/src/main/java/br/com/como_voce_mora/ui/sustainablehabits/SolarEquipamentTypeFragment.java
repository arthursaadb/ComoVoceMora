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
import br.com.como_voce_mora.ui.unity.UnitySplashFragment;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class SolarEquipamentTypeFragment extends BaseFragment {
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;
    @BindView(R.id.cvsSolarPlates)
    CustomSelectedView csvCasaGerminada;
    @BindView(R.id.csvPhotovoltaicPanels)
    CustomSelectedView csvSobrado;
    @BindView(R.id.csvSystems)
    CustomSelectedView csvVila;
    @BindView(R.id.cvsNone)
    CustomSelectedView csvTerreo;
    @BindView(R.id.tv_question)
    TextView mTvQuestion;

    private String saude = "";
    private String escola = "";
    private String cultura = "";
    private String lazer = "";
    SustainableHabitsAnswer sustainableHabitsAnswer = SustainableHabitsAnswer.EQUIPMENT_SOLAR_ENERGY;
    private BaseFragment mNextFrag;
    private List<String> answerList = new ArrayList<>();
    private boolean anyOptionChecked = false;
    private BaseFragment nextFragment;

    public static SolarEquipamentTypeFragment newInstance() {
        return new SolarEquipamentTypeFragment();
    }

    @Override
    public void init() {
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.HABITS);
        mTvQuestion.setText(sustainableHabitsAnswer.getQuestion());
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_solar_equipament_type;
    }

    @OnClick({R.id.cvsSolarPlates, R.id.csvPhotovoltaicPanels, R.id.csvSystems, R.id.cvsNone})
    public void onCheckedChanged(View view) {
        mNextFrag = WhyReasonEquipamentFragment.newInstance();
        CustomSelectedView csv = (CustomSelectedView) view;
        anyOptionChecked = true;
        switch (view.getId()) {
            case R.id.cvsSolarPlates:
                if (!csv.isChecked()) {
                    answerList.clear();
                    mNextFrag = WhyReasonEquipamentFragment.newInstance();
                    csv.setChecked(true);
                    csvSobrado.setChecked(false);
                    csvVila.setChecked(false);
                    csvTerreo.setChecked(false);
                    answerList.add(csv.getText());
                    break;
                } else {
                    csv.setChecked(false);
                    answerList.remove(csv.getText());
                    break;
                }
            case R.id.csvPhotovoltaicPanels:
                if (!csv.isChecked()) {
                    answerList.clear();
                    mNextFrag = WhyReasonEquipamentFragment.newInstance();
                    csv.setChecked(true);
                    escola = csv.getText();
                    csvCasaGerminada.setChecked(false);
                    csvVila.setChecked(false);
                    csvTerreo.setChecked(false);
                    answerList.add(csv.getText());
                    break;
                } else {
                    csv.setChecked(false);
                    answerList.remove(csv.getText());
                    break;
                }
            case R.id.csvSystems:
                if (!csv.isChecked()) {
                    answerList.clear();
                    csv.setChecked(true);
                    csvCasaGerminada.setChecked(false);
                    csvSobrado.setChecked(false);
                    csvTerreo.setChecked(false);
                    mNextFrag = DoYouSeparateGarbageFragment.newInstance();
                    answerList.add(csv.getText());
                    break;
                } else {
                    csv.setChecked(false);
                    answerList.remove(csv.getText());
                    break;
                }
            case R.id.cvsNone:
                if (!csv.isChecked()) {
                    answerList.clear();
                    mNextFrag = WhyReasonEquipamentFragment.newInstance();
                    csv.setChecked(true);
                    csvCasaGerminada.setChecked(false);
                    csvSobrado.setChecked(false);
                    csvVila.setChecked(false);
                    answerList.add(csv.getText());
                    break;
                } else {
                    csv.setChecked(false);
                    answerList.remove(csv.getText());
                    break;
                }
        }

    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (anyOptionChecked && !answerList.isEmpty()) {
            setAnswer(answerList.get(0));
            ((AboutYouActivity) requireActivity()).addFragment(mNextFrag);
        }
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    private void setAnswer(String text) {
        ResearchFlow.addAnswer(new AnswerRequest(sustainableHabitsAnswer.getQuestion(), sustainableHabitsAnswer.getQuestionPartId(), text), this);
    }

    @OnClick(R.id.btPreviousSession)
    public void onBtPreviouSessionClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) requireActivity()).addFragment(UnitySplashFragment.newInstance());
        }
    }
}
