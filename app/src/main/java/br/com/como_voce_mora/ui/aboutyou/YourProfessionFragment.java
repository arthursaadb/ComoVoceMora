package br.com.como_voce_mora.ui.aboutyou;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.previoushouse.PreviousHomeFragment;
import br.com.como_voce_mora.ui.previoushouse.PreviousHomeSplashFragment;
import butterknife.OnClick;

public class YourProfessionFragment extends BaseFragment {
    public static YourProfessionFragment newInstance() {
        return new YourProfessionFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_your_profession;
    }

    @Override
    public void init() {
        super.init();
    }

    @OnClick(R.id.btNext)
    public void onBtNextClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) getActivity()).addFragment(PreviousHomeSplashFragment.newInstance());
        }
    }

    @OnClick(R.id.btBack)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }
}
