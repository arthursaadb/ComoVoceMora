package br.com.como_voce_mora.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.widget.AppCompatImageView;

import br.com.como_voce_mora.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class HowYouLiveProgressBar extends RelativeLayout {

    @BindView(R.id.ivProgress)
    AppCompatImageView ivProgress;

    public HowYouLiveProgressBar(Context context) {
        super(context);
        init(context);
    }

    public HowYouLiveProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public HowYouLiveProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        View v = inflate(context, R.layout.custom_howyoulive_progressbar, this);
        ButterKnife.bind(this, v);
        ivProgress.setImageDrawable(context.getResources().getDrawable(HowYouLive.ABOUT_YOU.resource));
    }

    public void setProgress(HowYouLive howYouLive) {
        ivProgress.setImageDrawable(getContext().getResources().getDrawable(howYouLive.resource));
    }

    public enum HowYouLive {
        ABOUT_YOU(R.drawable.sobre_voce),
        BEFORE_RESIDENCE(R.drawable.moradia_anterior),
        ATUAL_RESIDENCE(R.drawable.moradia_atual),
        GROUP(R.drawable.conjunto),
        BUILDING(R.drawable.avaliar_moradia),
        UNITY(R.drawable.avaliar_unidade),
        HABITS(R.drawable.habitos_sustentaveis);

        public int getResource() {
            return resource;
        }

        public void setResource(int resource) {
            this.resource = resource;
        }

        int resource;

        HowYouLive(int resource) {
            this.resource = resource;
        }
    }
}
