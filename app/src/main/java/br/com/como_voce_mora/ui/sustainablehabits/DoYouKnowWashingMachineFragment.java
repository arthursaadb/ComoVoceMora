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
public class DoYouKnowWashingMachineFragment extends Fragment {

    public DoYouKnowWashingMachineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_do_you_know_washing_machine, container, false);
    }
}
