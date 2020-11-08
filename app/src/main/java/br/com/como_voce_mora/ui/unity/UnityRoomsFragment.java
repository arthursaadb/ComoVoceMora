package br.com.como_voce_mora.ui.unity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.CustomSelectedView;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.model.UnityAnswer;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.building.BuildingReasonChoiceFragment;
import br.com.como_voce_mora.ui.building.BuildingSplashFragment;
import br.com.como_voce_mora.ui.currentresidence.WhatsYourSatisfactionFragment;
import butterknife.BindView;
import butterknife.OnClick;

import static br.com.como_voce_mora.model.UnityAnswer.CHARACTERISTICS_SATISFACTION_BALCONY;
import static br.com.como_voce_mora.model.UnityAnswer.CHARACTERISTICS_SATISFACTION_BATHROOM;
import static br.com.como_voce_mora.model.UnityAnswer.CHARACTERISTICS_SATISFACTION_BIGROOM;
import static br.com.como_voce_mora.model.UnityAnswer.CHARACTERISTICS_SATISFACTION_DINNERROOM;
import static br.com.como_voce_mora.model.UnityAnswer.CHARACTERISTICS_SATISFACTION_KITCHEN;
import static br.com.como_voce_mora.model.UnityAnswer.CHARACTERISTICS_SATISFACTION_ROOM;
import static br.com.como_voce_mora.model.UnityAnswer.CHARACTERISTICS_SATISFACTION_SERVICE_AREA;
import static br.com.como_voce_mora.model.UnityAnswer.CHARACTERISTICS_SATISFACTION_SINGLEROMM;

public class UnityRoomsFragment extends BaseFragment {
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;
    @BindView(R.id.tv_question)
    TextView tvQuestion;

    List<UnityAnswer> roomList = new ArrayList<>();
    List<AnswerRequest> answerRequests = new ArrayList<>();
    UnityAnswer question = UnityAnswer.EXISTING_ROOMS;
    private boolean anyOptionChecked = false;

    @Override
    public int getResLayout() {
        return R.layout.fragment_unity_rooms;
    }

    public static UnityRoomsFragment newInstance() {

        Bundle args = new Bundle();

        UnityRoomsFragment fragment = new UnityRoomsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void init() {
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.UNITY);
        tvQuestion.setText(question.getQuestion());
    }

    @OnClick({R.id.csvServico, R.id.csvBanheiro, R.id.csvCasal,
            R.id.csvSolteiro, R.id.csvSala, R.id.csvCopa, R.id.csvVaranda, R.id.csvCozinha})
    void onClickViews(View view) {
        anyOptionChecked = true;
        CustomSelectedView csv = (CustomSelectedView) view;
        if (!csv.isChecked()) {
            csv.setChecked(true);

            switch (view.getId()) {
                case R.id.csvServico:
                    roomList.add(CHARACTERISTICS_SATISFACTION_SERVICE_AREA);
                    break;
                case R.id.csvBanheiro:
                    roomList.add(CHARACTERISTICS_SATISFACTION_BATHROOM);
                    break;
                case R.id.csvCasal:
                    roomList.add(CHARACTERISTICS_SATISFACTION_BIGROOM);
                    break;
                case R.id.csvSolteiro:
                    roomList.add(CHARACTERISTICS_SATISFACTION_SINGLEROMM);
                    break;
                case R.id.csvSala:
                    roomList.add(CHARACTERISTICS_SATISFACTION_ROOM);
                    break;
                case R.id.csvCopa:
                    roomList.add(CHARACTERISTICS_SATISFACTION_DINNERROOM);
                    break;
                case R.id.csvVaranda:
                    roomList.add(CHARACTERISTICS_SATISFACTION_BALCONY);
                    break;
                case R.id.csvCozinha:
                    roomList.add(CHARACTERISTICS_SATISFACTION_KITCHEN);
                    break;
            }
//                    answerRequests.add(new AnswerRequest(currentResidenceAnswer.getQuestion(),
//                            currentResidenceAnswer.getQuestionPartId(), csv.getText()));
        } else {
            csv.setChecked(false);
            removeItem(csv.getText());

            switch (view.getId()) {
                case R.id.csvServico:
                    roomList.remove(CHARACTERISTICS_SATISFACTION_SERVICE_AREA);
                    break;
                case R.id.csvBanheiro:
                    roomList.remove(CHARACTERISTICS_SATISFACTION_BATHROOM);
                    break;
                case R.id.csvCasal:
                    roomList.remove(CHARACTERISTICS_SATISFACTION_BIGROOM);
                    break;
                case R.id.csvSolteiro:
                    roomList.remove(CHARACTERISTICS_SATISFACTION_SINGLEROMM);
                    break;
                case R.id.csvSala:
                    roomList.remove(CHARACTERISTICS_SATISFACTION_ROOM);
                    break;
                case R.id.csvCopa:
                    roomList.remove(CHARACTERISTICS_SATISFACTION_DINNERROOM);
                    break;
                case R.id.csvVaranda:
                    roomList.remove(CHARACTERISTICS_SATISFACTION_BALCONY);
                    break;
                case R.id.csvCozinha:
                    roomList.remove(CHARACTERISTICS_SATISFACTION_KITCHEN);
                    break;
            }
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

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (anyOptionChecked) {
//        setAnswer();
            ((AboutYouActivity) requireActivity()).addFragment(UnityRateRoomsFragment.newInstance(roomList));
        }
    }

//    private void setAnswer() {
//        AnswerRequest answerRequest = new AnswerRequest(currentResidenceAnswer.getQuestion(), currentResidenceAnswer.getQuestionPartId(), "");
//        ResearchFlow.addAnswer(currentResidenceAnswer.getQuestion(), answerRequest);
//        for (AnswerRequest r : answerRequests) {
//            ResearchFlow.addAnswer(r.getDwellerId(), r);
//        }
//    }

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
