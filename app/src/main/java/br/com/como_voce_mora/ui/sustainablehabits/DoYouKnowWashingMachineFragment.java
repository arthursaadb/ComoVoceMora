package br.com.como_voce_mora.ui.sustainablehabits;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.Serializable;
import java.util.List;

import br.com.como_voce_mora.R;
import br.com.como_voce_mora.custom.HowYouLiveProgressBar;
import br.com.como_voce_mora.ui.BaseFragment;
import br.com.como_voce_mora.ui.aboutyou.AboutYouActivity;
import br.com.como_voce_mora.ui.unity.UnitySplashFragment;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class DoYouKnowWashingMachineFragment extends BaseFragment {

    @BindView(R.id.progress_bar)
    HowYouLiveProgressBar mProgress;

    List<BaseFragment> mNextFragments;

    public static DoYouKnowWashingMachineFragment newInstance(List<BaseFragment> mNextFragments) {
        DoYouKnowWashingMachineFragment frag = new DoYouKnowWashingMachineFragment();
        Bundle b = new Bundle();
        b.putSerializable("mNextFragments", (Serializable) mNextFragments);
        frag.setArguments(b);
        return frag;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            this.mNextFragments = (List<BaseFragment>) getArguments().get("mNextFragments");
        }
    }

    @Override
    public int getResLayout() {
        return R.layout.fragment_do_you_know_washing_machine;
    }

    @OnClick(R.id.bt_next)
    public void onBtNextClicked() {
        if (getActivity() != null) {
            ((AboutYouActivity) requireActivity()).addFragment(mNextFragments.get(0));
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
        mNextFragments.remove(0);
        mProgress.setProgress(HowYouLiveProgressBar.HowYouLive.HABITS);
    }
}
