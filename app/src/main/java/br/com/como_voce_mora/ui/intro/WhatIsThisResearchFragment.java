package br.com.como_voce_mora.ui.intro;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.ui.BaseFragment;
import butterknife.OnClick;

public class WhatIsThisResearchFragment extends BaseFragment {

    public static WhatIsThisResearchFragment newInstance() {
        return new WhatIsThisResearchFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_what_is_this_research;
    }

    @Override
    public void init() {

    }

    @OnClick(R.id.ib_next)
    public void nextFragment() {
        if (getActivity() == null) {
            return;
        }

        ((WhatIsThisResearchActivty) getActivity()).addFragment(TermsFragment.newInstance());
    }
}
