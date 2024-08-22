package com.baidu.searchbox.push.subscribe.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.baidu.searchbox.bridge.MessageRuntime;
import com.baidu.searchbox.config.ext.FontSizeTextViewExtKt;
import com.baidu.searchbox.push.R;
import com.baidu.searchbox.widget.preference.TwoStatePreference;

public class TextLoadingPreference extends TwoStatePreference {
    private static final String TAG = "TextLoadingPreference";
    private String mCheckedText;
    private int mCustomBackground;
    private boolean mLoading;
    private String mNormalText;
    private ProgressBar mProgress;
    private FrameLayout mRootLayout;
    private TextView mTextView;

    public TextLoadingPreference(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mLoading = false;
        this.mCustomBackground = 0;
        setWidgetLayoutResource(R.layout.push_preference_widget_text_loading);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TextLoadingPreference);
        this.mNormalText = ta.getString(R.styleable.TextLoadingPreference_normal_text);
        this.mCheckedText = ta.getString(R.styleable.TextLoadingPreference_checked_text);
        ta.recycle();
    }

    public TextLoadingPreference(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TextLoadingPreference(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: protected */
    public void onBindView(View view2) {
        super.onBindView(view2);
        this.mTextView = (TextView) view2.findViewById(R.id.push_subscribe_button_text);
        this.mProgress = (ProgressBar) view2.findViewById(R.id.push_subscribe_button_progress);
        this.mRootLayout = (FrameLayout) view2.findViewById(R.id.push_subscribe_button_root);
        upDataView();
    }

    public void loadingStart() {
        this.mLoading = true;
        upDataView();
    }

    public void loadingComplete() {
        this.mLoading = false;
        upDataView();
    }

    public void upDataView() {
        String txt;
        super.upDataView();
        if (this.mTextView != null && this.mProgress != null && this.mRootLayout != null) {
            setWidgetBackground();
            if (this.mLoading) {
                this.mTextView.setVisibility(4);
                this.mProgress.setVisibility(0);
                return;
            }
            this.mTextView.setVisibility(0);
            this.mProgress.setVisibility(8);
            String str = "";
            if (isChecked()) {
                if (!TextUtils.isEmpty(this.mCheckedText)) {
                    str = this.mCheckedText;
                }
                txt = str;
            } else {
                if (!TextUtils.isEmpty(this.mNormalText)) {
                    str = this.mNormalText;
                }
                txt = str;
            }
            this.mTextView.setText(txt);
            FontSizeTextViewExtKt.setScaledSizeRes(this.mTextView, 0, R.dimen.text_size_11dp);
        }
    }

    public void setCustomBackground(int resourceId) {
        this.mCustomBackground = resourceId;
        upDataView();
    }

    private void setWidgetBackground() {
        if (MessageRuntime.GLOBAL_DEBUG) {
            Log.d(TAG, "setWidgetBackground mCustomBackground = " + this.mCustomBackground + " isChecked = " + isChecked() + " mLoading = " + this.mLoading);
        }
        Resources resources = getContext().getResources();
        if (resources != null) {
            if (!isChecked() && !this.mLoading) {
                this.mRootLayout.setBackground(ResourcesCompat.getDrawable(resources, R.drawable.push_preference_widget_bg, (Resources.Theme) null));
                this.mTextView.setTextColor(resources.getColor(com.baidu.android.common.ui.style.R.color.BC60));
            } else if (this.mLoading) {
                this.mRootLayout.setBackground(ResourcesCompat.getDrawable(resources, R.drawable.push_preference_widget_unchecked_bg, (Resources.Theme) null));
            } else if (isChecked()) {
                this.mRootLayout.setBackground(ResourcesCompat.getDrawable(resources, R.drawable.push_preference_widget_checked_bg, (Resources.Theme) null));
                this.mTextView.setTextColor(resources.getColor(R.color.BC69));
            }
            int i2 = this.mCustomBackground;
            if (i2 > 0) {
                this.mRootLayout.setBackgroundResource(i2);
            }
        }
    }

    public void setNormalText(String text) {
        this.mNormalText = text;
    }

    public void setCheckedText(String text) {
        this.mCheckedText = text;
    }
}
