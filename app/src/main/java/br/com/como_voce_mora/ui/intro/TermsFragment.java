package br.com.como_voce_mora.ui.intro;

import android.content.Intent;
import android.webkit.WebView;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.SplashAboutYouActivity;
import butterknife.BindView;
import butterknife.OnClick;

public class TermsFragment extends BaseFragment {
    @BindView(R.id.wv_terms)
    WebView mWvTerms;

    public static TermsFragment newInstance() {
        return new TermsFragment();
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_terms;
    }

    @Override
    public void init() {

        mWvTerms.loadData(getString(R.string.terms), "text/html; charset=utf-8", "UTF-8");
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
        Intent intent = new Intent(getActivity(), SplashAboutYouActivity.class);
        startActivity(intent);
        getActivity().finish();
    }

    @OnClick(R.id.bt_no)
    public void onClickNo() {
        if (getActivity() == null) {
            return;
        }

        getActivity().finish();
    }
}
