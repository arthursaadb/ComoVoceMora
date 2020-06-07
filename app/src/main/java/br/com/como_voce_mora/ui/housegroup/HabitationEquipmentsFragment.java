package br.com.como_voce_mora.ui.housegroup;

import android.view.View;

import java.util.ArrayList;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.model.AnswerRequest;
import br.com.como_voce_mora.model.HouseGroupAnswer;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.custom.CustomSelectedView;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
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
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        setAnswer();
        ((AboutYouActivity) getActivity()).addFragment(HabitationAspectsFragment.newInstance());
    }

    private void setAnswer() {
        if(answerGameRoom!= null) {
            answerRequests.add(answerGameRoom);
        }
        if(answerGym!= null) {
            answerRequests.add(answerGym);
        }
        if(answerParty!= null) {
            answerRequests.add(answerParty);
        }
        if(answerAdultPool!= null) {
            answerRequests.add(answerAdultPool);
        }
        if(answerGourmet!= null) {
            answerRequests.add(answerGourmet);
        }
        if(answerSquare!= null) {
            answerRequests.add(answerSquare);
        }
        if(answerChildPool!= null) {
            answerRequests.add(answerChildPool);
        }
        if(answerPlayGround!= null) {
            answerRequests.add(answerPlayGround);
        }
        for (AnswerRequest r : answerRequests) {
            ResearchFlow.addAnswer(r.getDwellerId(), r);
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
                answerGameRoom = new AnswerRequest(houseGroupAnser.getQuestion(), houseGroupAnser.getQuestionPartId(), text);
                csvGamesRoom.setChecked(true);
                csvGymRoom.setChecked(false);
                csvPartyRoom.setChecked(false);
                csvPoolPlusEighteen.setChecked(false);
                csvGourmet.setChecked(false);
                csvSquare.setChecked(false);
                csvChildPool.setChecked(false);
                csvPlayGround.setChecked(false);
                break;
            case R.id.csvGym:
                answerGym = new AnswerRequest(houseGroupAnser.getQuestion(), houseGroupAnser.getQuestionPartId(), text);
                csvGamesRoom.setChecked(false);
                csvGymRoom.setChecked(true);
                csvPartyRoom.setChecked(false);
                csvPoolPlusEighteen.setChecked(false);
                csvGourmet.setChecked(false);
                csvSquare.setChecked(false);
                csvChildPool.setChecked(false);
                csvPlayGround.setChecked(false);
                break;
            case R.id.csvPartyRoom:
                answerParty = new AnswerRequest(houseGroupAnser.getQuestion(), houseGroupAnser.getQuestionPartId(), text);
                csvGamesRoom.setChecked(false);
                csvGymRoom.setChecked(false);
                csvPartyRoom.setChecked(true);
                csvPoolPlusEighteen.setChecked(false);
                csvGourmet.setChecked(false);
                csvSquare.setChecked(false);
                csvChildPool.setChecked(false);
                csvPlayGround.setChecked(false);
                break;
            case R.id.csvPoolPlusEighteen:
                answerAdultPool = new AnswerRequest(houseGroupAnser.getQuestion(), houseGroupAnser.getQuestionPartId(), text);
                csvGamesRoom.setChecked(false);
                csvGymRoom.setChecked(false);
                csvPartyRoom.setChecked(false);
                csvPoolPlusEighteen.setChecked(true);
                csvGourmet.setChecked(false);
                csvSquare.setChecked(false);
                csvChildPool.setChecked(false);
                csvPlayGround.setChecked(false);
                break;
            case R.id.csvGourmet:
                answerGourmet = new AnswerRequest(houseGroupAnser.getQuestion(), houseGroupAnser.getQuestionPartId(), text);
                csvGamesRoom.setChecked(false);
                csvGymRoom.setChecked(false);
                csvPartyRoom.setChecked(false);
                csvPoolPlusEighteen.setChecked(false);
                csvGourmet.setChecked(true);
                csvSquare.setChecked(false);
                csvChildPool.setChecked(false);
                csvPlayGround.setChecked(false);
                break;
            case R.id.csvPlayGround:
                answerPlayGround = new AnswerRequest(houseGroupAnser.getQuestion(), houseGroupAnser.getQuestionPartId(), text);
                csvGamesRoom.setChecked(false);
                csvGymRoom.setChecked(false);
                csvPartyRoom.setChecked(false);
                csvPoolPlusEighteen.setChecked(false);
                csvGourmet.setChecked(false);
                csvSquare.setChecked(false);
                csvChildPool.setChecked(false);
                csvPlayGround.setChecked(true);
                break;
            case R.id.csvSqaure:
                answerSquare = new AnswerRequest(houseGroupAnser.getQuestion(), houseGroupAnser.getQuestionPartId(), text);
                csvGamesRoom.setChecked(false);
                csvGymRoom.setChecked(false);
                csvPartyRoom.setChecked(false);
                csvPoolPlusEighteen.setChecked(false);
                csvGourmet.setChecked(false);
                csvSquare.setChecked(true);
                csvChildPool.setChecked(false);
                csvPlayGround.setChecked(false);
                break;
            case R.id.csvChildPool:
                answerChildPool = new AnswerRequest(houseGroupAnser.getQuestion(), houseGroupAnser.getQuestionPartId(), text);
                csvGamesRoom.setChecked(false);
                csvGymRoom.setChecked(false);
                csvPartyRoom.setChecked(false);
                csvPoolPlusEighteen.setChecked(false);
                csvGourmet.setChecked(false);
                csvSquare.setChecked(false);
                csvChildPool.setChecked(true);
                csvPlayGround.setChecked(false);
                break;
        }
    }
}
