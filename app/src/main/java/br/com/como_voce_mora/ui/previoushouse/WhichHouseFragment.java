package br.com.como_voce_mora.ui.previoushouse;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.custom.CustomSelectedView;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import butterknife.BindView;
import butterknife.OnClick;

public class WhichHouseFragment extends BaseFragment {
    @BindView(R.id.progressBar)
    HowYouLiveProgressBar mProgress;
    @BindView(R.id.csvCasaGerminada)
    CustomSelectedView csvCasaGerminada;
    @BindView(R.id.csvSobrado)
    CustomSelectedView csvSobrado;
    @BindView(R.id.csvVila)
    CustomSelectedView csvVila;
    @BindView(R.id.csvTerreo)
    CustomSelectedView csvTerreo;
    @BindView(R.id.csvFundo)
    CustomSelectedView csvFundo;

    public static WhichHouseFragment newInstance() {
        return new WhichHouseFragment();
    }

    @Override
    public void init() {
        super.init();
    }

    @OnClick({R.id.csvCasaGerminada, R.id.csvSobrado, R.id.csvVila, R.id.csvTerreo, R.id.csvFundo})
    public void onCheckedChanged(View view) {
            switch (view.getId()) {
                case R.id.csvCasaGerminada:
                    csvCasaGerminada.setChecked(true);
                    csvSobrado.setChecked(false);
                    csvVila.setChecked(false);
                    csvTerreo.setChecked(false);
                    csvFundo.setChecked(false);
                    break;
                case R.id.csvSobrado:
                    csvCasaGerminada.setChecked(false);
                    csvSobrado.setChecked(true);
                    csvVila.setChecked(false);
                    csvTerreo.setChecked(false);
                    csvFundo.setChecked(false);
                    break;
                case R.id.csvVila:
                    csvCasaGerminada.setChecked(false);
                    csvSobrado.setChecked(false);
                    csvVila.setChecked(true);
                    csvTerreo.setChecked(false);
                    csvFundo.setChecked(false);
                    break;
                case R.id.csvTerreo:
                    csvCasaGerminada.setChecked(false);
                    csvSobrado.setChecked(false);
                    csvVila.setChecked(false);
                    csvTerreo.setChecked(true);
                    csvFundo.setChecked(false);
                    break;
                case R.id.csvFundo:
                    csvCasaGerminada.setChecked(false);
                    csvSobrado.setChecked(false);
                    csvVila.setChecked(false);
                    csvTerreo.setChecked(false);
                    csvFundo.setChecked(true);
                    break;
            }

    }



    @Override
    public int getResLayout() {
        return R.layout.fragment_which_house;
    }

    @OnClick(R.id.btNext)
    public void onBtNextClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) getActivity()).addFragment(AcquisitionStateFragment.newInstance());
        }
    }

    @OnClick(R.id.btBack)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.BEFORE_RESIDENCE);
    }
}
