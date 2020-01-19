package br.com.como_voce_mora.ui.previoushouse;

import android.view.View;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.CustomSelectedView;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import butterknife.BindView;
import butterknife.OnClick;

public class WhichApartamentFragment extends BaseFragment {
    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;
    @BindView(R.id.csvDuplex)
    CustomSelectedView csvDuplex;
    @BindView(R.id.csvTiplex)
    CustomSelectedView csvTiplex;
    @BindView(R.id.csvQuintinete)
    CustomSelectedView csvQuintinete;
    @BindView(R.id.csvLoft)
    CustomSelectedView csvLoft;
    @BindView(R.id.csvConvencional)
    CustomSelectedView csvConvencional;
    @BindView(R.id.csvCobertura)
    CustomSelectedView csvCobertura;

    public static WhichApartamentFragment newInstance() {
        return new WhichApartamentFragment();
    }

    @Override
    public void init() {
        super.init();
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.BEFORE_RESIDENCE);

    }

    @OnClick({R.id.csvDuplex, R.id.csvTiplex, R.id.csvQuintinete, R.id.csvLoft, R.id.csvConvencional, R.id.csvCobertura})
    public void onCheckedChanged(View view) {
            switch (view.getId()) {
                case R.id.csvDuplex:
                    csvDuplex.setChecked(true);
                    csvTiplex.setChecked(false);
                    csvQuintinete.setChecked(false);
                    csvLoft.setChecked(false);
                    csvConvencional.setChecked(false);
                    csvCobertura.setChecked(false);
                    break;
                case R.id.csvTiplex:
                    csvDuplex.setChecked(false);
                    csvTiplex.setChecked(true);
                    csvQuintinete.setChecked(false);
                    csvLoft.setChecked(false);
                    csvConvencional.setChecked(false);
                    csvCobertura.setChecked(false);
                    break;
                case R.id.csvQuintinete:
                    csvDuplex.setChecked(false);
                    csvTiplex.setChecked(false);
                    csvQuintinete.setChecked(true);
                    csvLoft.setChecked(false);
                    csvConvencional.setChecked(false);
                    csvCobertura.setChecked(false);
                    break;
                case R.id.csvLoft:
                    csvDuplex.setChecked(false);
                    csvTiplex.setChecked(false);
                    csvQuintinete.setChecked(false);
                    csvLoft.setChecked(true);
                    csvConvencional.setChecked(false);
                    csvCobertura.setChecked(false);
                    break;
                case R.id.csvConvencional:
                    csvDuplex.setChecked(false);
                    csvTiplex.setChecked(false);
                    csvQuintinete.setChecked(false);
                    csvLoft.setChecked(false);
                    csvConvencional.setChecked(true);
                    csvCobertura.setChecked(false);
                    break;
                case R.id.csvCobertura:
                    csvDuplex.setChecked(false);
                    csvTiplex.setChecked(false);
                    csvQuintinete.setChecked(false);
                    csvLoft.setChecked(false);
                    csvConvencional.setChecked(true);
                    csvCobertura.setChecked(true);
                    break;
            }
    }


    @Override
    public int getResLayout() {
        return R.layout.fragment_which_apartament;
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) getActivity()).addFragment(AcquisitionStateFragment.newInstance());
        }
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }
}
