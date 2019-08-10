package br.com.como_voce_mora.ui.intro;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.ui.BaseFragment;
import butterknife.OnClick;

public class TermsFragment extends BaseFragment {
    public static TermsFragment newInstance() {
        return new TermsFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_terms;
    }

    @OnClick(R.id.ib_back)
    public void onBackPressed() {
        if (getActivity() == null) {
            return;
        }

        getActivity().onBackPressed();
    }

    @OnClick(R.id.bt_yes)
    public void onClickYes() {
        // TODO: 2019-08-08 - Next Activity Or Fragment
    }

    @OnClick(R.id.bt_no)
    public void onClickNo() {
        if (getActivity() == null) {
            return;
        }

        getActivity().finish();
    }
}
