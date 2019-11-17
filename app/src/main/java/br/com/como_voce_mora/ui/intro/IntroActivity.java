package br.com.como_voce_mora.ui.intro;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ImageButton;

import br.com.como_voce_mora.AppController;
import br.com.como_voce_mora.R;
import br.com.como_voce_mora.db.PostContract;
import br.com.como_voce_mora.db.SingletonCurrentResident;
import br.com.como_voce_mora.ui.BaseActivity;
import butterknife.BindView;
import butterknife.OnClick;

public class IntroActivity extends BaseActivity {
    @BindView(R.id.ib_sound)
    ImageButton mIbSound;

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
        SQLiteDatabase db = AppController.getInstance().getDbHelper().getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.putNull(PostContract.PostEntry.COLUMN_NAME_MORADOR_ID);

        long id = db.insertOrThrow(PostContract.PostEntry.TABLE_NAME_MORADOR, null, contentValues);

        SingletonCurrentResident.getInstance().setCurrentResident(id);

        Intent intent = new Intent(this, InfoSaveDataActivity.class);
        startActivity(intent);
    }
}
