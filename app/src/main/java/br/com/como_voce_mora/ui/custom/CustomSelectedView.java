package br.com.como_voce_mora.ui.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import br.com.como_voce_mora.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomSelectedView extends RelativeLayout {
    @BindView(R.id.tv_name)
    TextView mTvName;
    @BindView(R.id.iv_image)
    ImageView mIvImage;

    private boolean selected;

    public CustomSelectedView(Context context) {
        super(context);

        init(null);
    }

    public CustomSelectedView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(attrs);
    }


    private void init(AttributeSet attrs) {
        View view = inflate(getContext(), R.layout.custom_view_radiobutton_with_bottom_image, this);
        ButterKnife.bind(view, this);

        TypedArray typedArray = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.CustomSelectedView, 0, 0);
        int resImage = typedArray.getResourceId(R.styleable.CustomSelectedView_imageItem, R.drawable.ic_mr_clipboard_15a20);
        String name = getResources().getString(typedArray.getResourceId(R.styleable.CustomSelectedView_nameItem, R.string.name_default));

        mTvName.setText(name);
        mIvImage.setImageResource(resImage);
    }

    public void setChecked(boolean selected) {
        this.selected = selected;

        mTvName.setBackgroundResource(selected ? R.drawable.bg_ballon_pressed_type_1 : R.drawable.bg_ballon_normal_type_1);
    }

    public boolean isChecked() {
        return selected;
    }

    public void setImage(int image) {
        mIvImage.setImageResource(image);
    }

    public void setText(int text) {
        mTvName.setText(text);
    }
}
