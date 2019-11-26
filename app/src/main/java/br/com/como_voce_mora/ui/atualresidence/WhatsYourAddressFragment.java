package br.com.como_voce_mora.ui.atualresidence;

import android.os.Bundle;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import butterknife.BindView;
import butterknife.OnClick;

public class WhatsYourAddressFragment extends BaseFragment {


    @BindView(R.id.progressBar)
    HowYouLiveProgressBar progressBar;

    public static WhatsYourAddressFragment newInstance() {

        Bundle args = new Bundle();

        WhatsYourAddressFragment fragment = new WhatsYourAddressFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_whatsyouraddress;
    }

    @Override
    public void init() {
        super.init();
        progressBar.setProgress(HowYouLiveProgressBar.HowYouLive.ATUAL_RESIDENCE);
    }

    @OnClick(R.id.btNext)
    public void onBtNextClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) getActivity()).addFragment(NeighborHoodFragment.newInstance());
        }
    }

    @OnClick(R.id.btBack)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }
}
