package br.com.como_voce_mora.ui.aboutyou;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.ui.BaseFragment;
import butterknife.OnClick;

public class WhatYourGenderFragment extends BaseFragment {

    public static WhatYourGenderFragment newInstance() {
        return new WhatYourGenderFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_what_your_gender;
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) getActivity()).addFragment(HowOldAreYouFragment.newInstance());
        }
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }
}
