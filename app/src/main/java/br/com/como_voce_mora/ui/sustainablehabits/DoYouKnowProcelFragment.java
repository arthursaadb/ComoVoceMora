package br.com.como_voce_mora.ui.sustainablehabits;

import androidx.fragment.app.Fragment;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import butterknife.BindView;
import butterknife.OnClick;

public class DoYouKnowProcelFragment extends BaseFragment {

    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;

    public static DoYouKnowProcelFragment newInstance() {
        return new DoYouKnowProcelFragment();
    }

    @Override
    public int getResLayout() {
       return R.layout.fragment_do_you_know_procel;
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) requireActivity()).addFragment(DoYouSeparateGarbageFragment.newInstance());
        }
    }

    @OnClick(R.id.bt_back)
    public void onBtBackClicked() {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    @Override
    public void init() {
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.HABITS);
    }
}
