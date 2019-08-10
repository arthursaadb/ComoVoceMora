package br.com.como_voce_mora.ui.intro;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import br.com.como_voce_mora.R;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TermsFragment extends Fragment {
    public static TermsFragment newInstance() {
        return new TermsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_terms, container, false);
        ButterKnife.bind(this, view);

        return view;
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
