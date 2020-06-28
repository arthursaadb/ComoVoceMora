package br.com.como_voce_mora.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.presenter.ServicesPresenter;
import br.com.como_voce_mora.presenter.ServicesPresenterContract;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PlayGroundActivity extends AppCompatActivity implements ServicesPresenterContract.View {

    ServicesPresenter mPresenter = new ServicesPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_ground);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btGetId)
    public void onClick(View v) {
        mPresenter.callService();
    }

    @OnClick(R.id.btSendAnswers)
    public void onClickBtSend(View v) {
        Toast.makeText(this, "Enviando Dados da Pesquisa...", Toast.LENGTH_LONG).show();
        new Handler().postDelayed(() -> {
            Toast.makeText(this, "Dados Enviados com Sucesso", Toast.LENGTH_LONG).show();
        }, 1000);
    }

    @Override
    public void showLoad() {

    }

    @Override
    public void showId(String dwellerId) {
        Toast.makeText(this, dwellerId, Toast.LENGTH_LONG).show();

    }

    @Override
    public void showError(String azedou) {
        Toast.makeText(this, azedou, Toast.LENGTH_LONG).show();
    }

    @Override
    public void advice() {
        Toast.makeText(this, "Sem DwellerId", Toast.LENGTH_LONG).show();
    }

    @Override
    public void stopLoad() {

    }


}
