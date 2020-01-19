package br.com.como_voce_mora.ui.unity;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import butterknife.OnClick;

public class UsedSpaceUnityFragment extends BaseFragment {

    public static UsedSpaceUnityFragment newInstance() {
        return new UsedSpaceUnityFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_unity_used_space;
    }

    @Override
    public void init() {

    }

    @OnClick(R.id.btNext)
    public void onBtNextClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) getActivity()).addFragment(ResidentsUnityFragment.newInstance());
        }
    }

    @OnClick(R.id.btBack)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }
}
