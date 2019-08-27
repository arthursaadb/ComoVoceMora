package br.com.como_voce_mora.ui.aboutyou;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.ui.BaseFragment;
import butterknife.OnClick;

public class WorkForYouFragment extends BaseFragment {
    public static WorkForYouFragment newInstance() {
        return new WorkForYouFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_work_for_you;
    }

    @Override
    public void init() {
        super.init();
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) getActivity()).addFragment(FamilyIncomeFragment.newInstance());
        }
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }
}
