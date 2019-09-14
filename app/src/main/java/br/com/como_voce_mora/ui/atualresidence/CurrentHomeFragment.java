package br.com.como_voce_mora.ui.atualresidence;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.custom.HowYouLiveProgressBar;
import butterknife.BindView;
import butterknife.OnClick;

public class CurrentHomeFragment extends BaseFragment {

    public static CurrentHomeFragment newInstance() {

        Bundle args = new Bundle();

        CurrentHomeFragment fragment = new CurrentHomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_splash_atual;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void init() {
        super.init();
    }

    @OnClick(R.id.bt_touch_next)
    public void onClickedBtNext() {
        ((AboutYouActivity) getActivity()).addFragment(CountryFragment.newInstance());
    }
}
