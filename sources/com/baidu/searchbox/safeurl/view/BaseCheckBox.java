package com.baidu.searchbox.safeurl.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.baidu.searchbox.safeurl.R;
import com.baidu.searchbox.safeurl.utils.ResourcesUtils;

public class BaseCheckBox extends ImageView {
    /* access modifiers changed from: private */
    public boolean mIsChecked = false;
    private Drawable mNormalBackground;
    /* access modifiers changed from: private */
    public OnCheckedChangeListener mOnCheckedChangeListener;
    private Drawable mSelectedBackground;

    public interface OnCheckedChangeListener {
        void onCheckedChanged(boolean z);
    }

    public BaseCheckBox(Context context) {
        super(context);
        init(context, (AttributeSet) null);
    }

    public BaseCheckBox(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public BaseCheckBox(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray typedArray;
        if (context != null) {
            this.mSelectedBackground = ResourcesUtils.getDrawable(getResources(), R.drawable.safe_url_checkbox_selected);
            this.mNormalBackground = ResourcesUtils.getDrawable(getResources(), R.drawable.safe_url_checkbox_normal);
            if (!(attrs == null || (typedArray = context.obtainStyledAttributes(attrs, R.styleable.BaseCheckBox)) == null)) {
                this.mSelectedBackground = typedArray.getDrawable(R.styleable.BaseCheckBox_selectedBackground);
                this.mNormalBackground = typedArray.getDrawable(R.styleable.BaseCheckBox_normalBackground);
                this.mIsChecked = typedArray.getBoolean(R.styleable.BaseCheckBox_selected, false);
                typedArray.recycle();
            }
            setChecked(this.mIsChecked);
            setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    BaseCheckBox baseCheckBox = BaseCheckBox.this;
                    baseCheckBox.setChecked(!baseCheckBox.mIsChecked);
                    if (BaseCheckBox.this.mOnCheckedChangeListener != null) {
                        BaseCheckBox.this.mOnCheckedChangeListener.onCheckedChanged(BaseCheckBox.this.mIsChecked);
                    }
                }
            });
        }
    }

    public void setChecked(boolean isChecked) {
        this.mIsChecked = isChecked;
        if (isChecked) {
            setImageDrawable(this.mSelectedBackground);
        } else {
            setImageDrawable(this.mNormalBackground);
        }
    }

    public void setCheckBoxBackground(Drawable selectedBackground, Drawable normalBackground) {
        this.mSelectedBackground = selectedBackground;
        this.mNormalBackground = normalBackground;
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        this.mOnCheckedChangeListener = onCheckedChangeListener;
    }
}
