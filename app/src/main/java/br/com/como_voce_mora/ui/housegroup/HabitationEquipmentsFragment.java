package br.com.como_voce_mora.ui.housegroup;

import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

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

public class HabitationEquipmentsFragment extends BaseFragment {

    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;
    @BindView(R.id.csvGamesRoom)
    CustomSelectedView csvGamesRoom;
    @BindView(R.id.csvGym)
    CustomSelectedView csvGymRoom;
    @BindView(R.id.csvPartyRoom)
    CustomSelectedView csvPartyRoom;
    @BindView(R.id.csvPoolPlusEighteen)
    CustomSelectedView csvPoolPlusEighteen;
    @BindView(R.id.csvGourmet)
    CustomSelectedView csvGourmet;
    @BindView(R.id.csvPlayGround)
    CustomSelectedView csvPlayGround;
    @BindView(R.id.csvSqaure)
    CustomSelectedView csvSquare;
    @BindView(R.id.csvChildPool)
    CustomSelectedView csvChildPool;
    @BindView(R.id.tv_question)
    TextView tvQuestion;

    private AnswerRequest answerGameRoom;
    private AnswerRequest answerGym;
    private AnswerRequest answerParty;
    private AnswerRequest answerAdultPool;
    private AnswerRequest answerGourmet;
    private AnswerRequest answerSquare;
    private AnswerRequest answerChildPool;
    private AnswerRequest answerPlayGround;


    private ArrayList<AnswerRequest> answerRequests = new ArrayList<>();
    private HouseGroupAnswer houseGroupAnser = HouseGroupAnswer.CONDOMINIUM_PUBLIC_EQUIPMENT;

    public static HabitationEquipmentsFragment newInstance() {
        return new HabitationEquipmentsFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_habitation_equipaments;
    }

    @Override
    public void init() {
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.GROUP);
        tvQuestion.setText(houseGroupAnser.getQuestion());
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
            setAnswer();
            ((AboutYouActivity) getActivity()).addFragment(HabitationAspectsFragment.newInstance());
    }

    private void setAnswer() {
        if (answerGameRoom != null) {
            answerRequests.add(answerGameRoom);
        }
        if (answerGym != null) {
            answerRequests.add(answerGym);
        }
        if (answerParty != null) {
            answerRequests.add(answerParty);
        }
        if (answerAdultPool != null) {
            answerRequests.add(answerAdultPool);
        }
        if (answerGourmet != null) {
            answerRequests.add(answerGourmet);
        }
        if (answerSquare != null) {
            answerRequests.add(answerSquare);
        }
        if (answerChildPool != null) {
            answerRequests.add(answerChildPool);
        }
        if (answerPlayGround != null) {
            answerRequests.add(answerPlayGround);
        }
        for (AnswerRequest r : answerRequests) {
            ResearchFlow.addAnswer(r, this);
        }
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }


    @OnClick({R.id.csvGamesRoom, R.id.csvGym, R.id.csvPartyRoom, R.id.csvPoolPlusEighteen, R.id.csvGourmet,
            R.id.csvPlayGround, R.id.csvSqaure, R.id.csvChildPool})
    public void onClickViews(View view) {
        String text = ((CustomSelectedView) view).getText();
        switch (view.getId()) {
            case R.id.csvGamesRoom:
                if (csvGamesRoom.isChecked()) {
                    csvGamesRoom.setChecked(false);
                    answerGameRoom = null;
                } else {
                    answerGameRoom = new AnswerRequest(houseGroupAnser.getQuestion(), houseGroupAnser.getQuestionPartId(), text);
                    csvGamesRoom.setChecked(true);
                }
                break;
            case R.id.csvGym:
                if (csvGymRoom.isChecked()) {
                    answerGym = null;
                    csvGymRoom.setChecked(false);
                } else {
                    answerGym = new AnswerRequest(houseGroupAnser.getQuestion(), houseGroupAnser.getQuestionPartId(), text);
                    csvGymRoom.setChecked(true);
                }
                break;
            case R.id.csvPartyRoom:
                if (csvPartyRoom.isChecked()) {
                    answerParty = null;
                    csvPartyRoom.setChecked(false);
                } else {
                    answerParty = new AnswerRequest(houseGroupAnser.getQuestion(), houseGroupAnser.getQuestionPartId(), text);
                    csvPartyRoom.setChecked(true);
                }
                break;
            case R.id.csvPoolPlusEighteen:
                if (csvPoolPlusEighteen.isChecked()) {
                    answerAdultPool = null;
                    csvPoolPlusEighteen.setChecked(false);
                } else {
                    answerAdultPool = new AnswerRequest(houseGroupAnser.getQuestion(), houseGroupAnser.getQuestionPartId(), text);
                    csvPoolPlusEighteen.setChecked(true);
                }

                break;
            case R.id.csvGourmet:
                if (csvGourmet.isChecked()) {
                    answerGourmet = null;
                    csvGourmet.setChecked(false);
                } else {
                    answerGourmet = new AnswerRequest(houseGroupAnser.getQuestion(), houseGroupAnser.getQuestionPartId(), text);
                    csvGourmet.setChecked(true);
                }

                break;
            case R.id.csvPlayGround:
                if (csvPlayGround.isChecked()) {
                    answerPlayGround = null;
                    csvPlayGround.setChecked(false);
                } else {
                    answerPlayGround = new AnswerRequest(houseGroupAnser.getQuestion(), houseGroupAnser.getQuestionPartId(), text);
                    csvPlayGround.setChecked(true);
                }

                break;
            case R.id.csvSqaure:
                if (csvSquare.isChecked()) {
                    answerSquare = null;
                    csvSquare.setChecked(false);
                } else {
                    answerSquare = new AnswerRequest(houseGroupAnser.getQuestion(), houseGroupAnser.getQuestionPartId(), text);
                    csvSquare.setChecked(true);
                }
                break;
            case R.id.csvChildPool:
                if (csvChildPool.isChecked()) {
                    answerChildPool = null;
                    csvChildPool.setChecked(false);
                } else {
                    answerChildPool = new AnswerRequest(houseGroupAnser.getQuestion(), houseGroupAnser.getQuestionPartId(), text);
                    csvChildPool.setChecked(true);
                }

                break;
        }
    }

    @OnClick(R.id.btPreviousSession)
    public void onBtPreviouSessionClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) requireActivity()).addFragment(CurrentHomeFragment.newInstance());
        }
    }
}
