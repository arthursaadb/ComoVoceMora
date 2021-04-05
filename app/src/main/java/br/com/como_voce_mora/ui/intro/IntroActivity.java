package br.com.como_voce_mora.ui.intro;

import android.content.ContentValues;
import android.content.Intent;
import android.content.ServiceConnection;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;

import br.com.como_voce_mora.AppController;
import br.com.como_voce_mora.R;
import br.com.como_voce_mora.db.PostContract;
import br.com.como_voce_mora.db.SingletonCurrentResident;
import br.com.como_voce_mora.model.ResearchFlow;
import br.com.como_voce_mora.model.ScreenAndMoradorId;
import br.com.como_voce_mora.presenter.ServicesPresenter;
import br.com.como_voce_mora.presenter.ServicesPresenterContract;
import br.com.como_voce_mora.ui.BaseActivity;
import br.com.como_voce_mora.ui.PlayGroundActivity;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.sustainablehabits.TransportationReasonFragment;
import butterknife.BindView;
import butterknife.OnClick;

public class IntroActivity extends BaseActivity implements ServicesPresenterContract.View {
    @BindView(R.id.ib_sound)
    ImageButton mIbSound;
    @BindView(R.id.bt_send_answers)
    Button button;
    @BindView(R.id.bt_continue)
    Button btContinue;
    @BindView(R.id.layout_loading_intro)
    FrameLayout layoutLoading;

    private ScreenAndMoradorId screenAndMoradorId;
    ServicesPresenter mPresenter = new ServicesPresenter(this);

    @Override
    public int getResLayout() {
        return R.layout.activity_intro;
    }


    @OnClick(R.id.ib_sound)
    public void playSound() {
        if (AppController.getInstance().mMediaPlayer.isPlaying()) {
            AppController.getInstance().mMediaPlayer.pause();
            mIbSound.setImageResource(R.drawable.ic_speaker_off);
            return;
        }

        AppController.getInstance().mMediaPlayer.start();
        mIbSound.setImageResource(R.drawable.ic_speaker_on);
    }

    @Override
    protected void onResume() {
        super.onResume();

        mIbSound.setImageResource(AppController.getInstance().mMediaPlayer.isPlaying() ? R.drawable.ic_speaker_on : R.drawable.ic_speaker_off);
    }

    @OnClick(R.id.bt_start)
    public void start() {
        checkService();
    }

    @OnClick(R.id.bt_continue)
    public void continueFlow() {
        SingletonCurrentResident.getInstance().setCurrentResident(Long.parseLong(screenAndMoradorId.getMoradorId()));

        Intent intent = new Intent(this, AboutYouActivity.class);
        intent.putExtra(AboutYouActivity.SCREEN_FRAGMENT, screenAndMoradorId.getScreen());
        startActivity(intent);
    }

    @OnClick(R.id.bt_send_answers)
    public void openSendAnswers() {
        Intent intent = new Intent(this, PlayGroundActivity.class);
        startActivity(intent);
    }

    @Override
    public void init() {
        super.init();

        screenAndMoradorId = ResearchFlow.getQuestionLast();
        button.setVisibility(View.GONE);
        if (screenAndMoradorId != null && !screenAndMoradorId.getScreen().equals(TransportationReasonFragment.class.getName())) {
            btContinue.setVisibility(View.VISIBLE);
        } else {
            btContinue.setVisibility(View.GONE);
        }
    }

    public void createNewTable() {
        SQLiteDatabase db = AppController.getInstance().getDbHelper().getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.putNull(PostContract.PostEntry.COLUMN_NAME_MORADOR_ID);

        long id = db.insertOrThrow(PostContract.PostEntry.TABLE_NAME_MORADOR, null, contentValues);

        SingletonCurrentResident.getInstance().setCurrentResident(id);
    }

    private void checkService(){
        mPresenter.getServiceStatus();
    }

    @Override
    public void showLoad() {
        layoutLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void showId(String dwellerId) {

    }

    @Override
    public void showError(String azedou) {
        Toast.makeText(this, azedou, Toast.LENGTH_LONG).show();

    }

    @Override
    public void advice() {
        createNewTable();
        Intent intent = new Intent(this, InfoSaveDataActivity.class);
        startActivity(intent);
    }

    @Override
    public void stopLoad() {
        layoutLoading.setVisibility(View.GONE);
    }
}
