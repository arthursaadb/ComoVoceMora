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

public class WhatIsThisResearchFragment extends Fragment {

    public static WhatIsThisResearchFragment newInstance() {
        return new WhatIsThisResearchFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_what_is_this_research, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick(R.id.ib_next)
    public void nextFragment() {
        if (getActivity() == null) {
            return;
        }

        ((WhatIsThisResearchActivty) getActivity()).addFragment(TermsFragment.newInstance());
    }
}
