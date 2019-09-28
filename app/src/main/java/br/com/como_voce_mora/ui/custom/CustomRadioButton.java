package br.com.como_voce_mora.ui.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import br.com.como_voce_mora.R;

public class CustomRadioButton extends RadioButton implements CompoundButton.OnCheckedChangeListener {
    public CustomRadioButton(Context context) {
        super(context);

        init();
    }

    public CustomRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    public void init() {
        setBackground(getResources().getDrawable(R.drawable.bg_radio_button_normal));
        setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        setBackground(getResources().getDrawable(isChecked() ?
                R.drawable.bg_radio_button_selected :
                R.drawable.bg_radio_button_normal));
    }
}
