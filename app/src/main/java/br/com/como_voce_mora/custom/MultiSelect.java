package br.com.como_voce_mora.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import br.com.como_voce_mora.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MultiSelect extends RelativeLayout {
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.iv_image)
    ImageView mIvImage;
    @BindView(R.id.tv_value)
    TextView mTvValue;
    @BindView(R.id.ll_count)
    LinearLayout mLlCount;

    private int count = 0;
    private boolean selected = false;

    public MultiSelect(Context context) {
        super(context);

        init(null);
    }

    public MultiSelect(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(attrs);
    }

    private void init(AttributeSet attrs) {
        View view = inflate(getContext(), R.layout.fragment_multi_select, this);
        ButterKnife.bind(view, this);

        TypedArray typedArray = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.CustomMultiSelect, 0, 0);
        int resImage = typedArray.getResourceId(R.styleable.CustomMultiSelect_image, R.drawable.ic_mr_clipboard_15a20);
        String name = getResources().getString(typedArray.getResourceId(R.styleable.CustomMultiSelect_name, R.string.name_default));
        int textColor = typedArray.getColor(R.styleable.CustomMultiSelect_textColor, getResources().getColor(R.color.colorBlack));

        mTvTitle.setText(name);
        mTvTitle.setTextColor(textColor);
        mIvImage.setImageResource(resImage);
    }

    @OnClick(R.id.rl_root_view)
    public void onClickRootView() {
        if (selected) {
            return;
        }


        selected = true;

        mLlCount.setVisibility(VISIBLE);
        mTvValue.setText(String.valueOf(count));
        mTvTitle.setTextColor(getResources().getColor(R.color.colorWhite));
        mTvTitle.setBackgroundResource(R.drawable.bg_ballon_pressed_type_1);
    }

    @OnClick(R.id.bt_up)
    public void onClickUp() {
        count++;
        mTvValue.setText(String.valueOf(count));
    }

    @OnClick(R.id.bt_down)
    public void onClickDown() {
        if (count == 0) {
            return;
        }

        count--;
        mTvValue.setText(String.valueOf(count));
    }
}
