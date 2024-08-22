package com.baidu.searchbox.safeurl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

public class SafeUrlPopCheckBox extends ImageView {
    /* access modifiers changed from: private */
    public boolean mIsChecked = true;
    /* access modifiers changed from: private */
    public OnCheckedChangeListener mOnCheckedChangeListener;

    public interface OnCheckedChangeListener {
        void onCheckedChanged(boolean z);
    }

    public SafeUrlPopCheckBox(Context context) {
        super(context);
        init();
    }

    public SafeUrlPopCheckBox(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SafeUrlPopCheckBox(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init() {
        setChecked(this.mIsChecked);
        setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SafeUrlPopCheckBox safeUrlPopCheckBox = SafeUrlPopCheckBox.this;
                safeUrlPopCheckBox.setChecked(!safeUrlPopCheckBox.mIsChecked);
                if (SafeUrlPopCheckBox.this.mOnCheckedChangeListener != null) {
                    SafeUrlPopCheckBox.this.mOnCheckedChangeListener.onCheckedChanged(SafeUrlPopCheckBox.this.mIsChecked);
                }
            }
        });
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        this.mOnCheckedChangeListener = onCheckedChangeListener;
    }

    public void setChecked(boolean isChecked) {
        this.mIsChecked = isChecked;
        if (isChecked) {
            setImageResource(R.drawable.risky_checkbox_checked);
        } else {
            setImageResource(R.drawable.risky_checkbox_unchecked);
        }
    }

    public boolean isChecked() {
        return this.mIsChecked;
    }
}
