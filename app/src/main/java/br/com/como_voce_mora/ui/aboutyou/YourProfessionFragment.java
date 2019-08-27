package br.com.como_voce_mora.ui.aboutyou;

import android.widget.Toast;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.ui.BaseFragment;
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

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (getActivity() != null) {
//            ((AboutYouActivity) getActivity()).addFragment(FamilyIncomeFragment.newInstance());
            Toast.makeText(getContext(), "Em Desenvolvimento!", Toast.LENGTH_LONG).show();
        }
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }
}
