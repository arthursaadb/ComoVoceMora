package br.com.como_voce_mora.ui.sustainablehabits;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.como_voce_mora.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DoYouKnowRefrigeratorsFragment extends Fragment {

    public DoYouKnowRefrigeratorsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_do_you_know_refrigerators, container, false);
    }
}
