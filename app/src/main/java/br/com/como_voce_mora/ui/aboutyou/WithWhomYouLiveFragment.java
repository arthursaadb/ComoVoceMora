package br.com.como_voce_mora.ui.aboutyou;

import android.widget.Toast;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.ui.BaseFragment;
import butterknife.OnClick;

public class WithWhomYouLiveFragment extends BaseFragment {

    public static WithWhomYouLiveFragment newInstance() {
        return new WithWhomYouLiveFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_withwhomyoulive;
    }

    @Override
    public void init() {
        super.init();
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) getActivity()).addFragment(WorkForYouFragment.newInstance());
        }
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

}
