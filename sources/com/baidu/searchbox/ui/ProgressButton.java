package com.baidu.searchbox.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.common.ui.R;

public class ProgressButton extends RelativeLayout {
    public static final int IN_PROGRESS = 2;
    public static final int NOT_IN_PROGRESS = 1;
    private String defaultText;
    private SmoothProgressBar progressBar;
    private String progressText;
    private TextView progressTextView;

    public ProgressButton(Context context) {
        super(context);
        init(context);
    }

    public ProgressButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ProgressButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.progress_button, this);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.progressBar = (SmoothProgressBar) findViewById(R.id.local_video_scan_progress);
        this.progressTextView = (TextView) findViewById(R.id.local_video_scan_button);
        stopProgress();
    }

    public String getDefaultText() {
        return this.defaultText;
    }

    public void setDefaultText(String defaultText2) {
        this.defaultText = defaultText2;
    }

    public String getProgressText() {
        return this.progressText;
    }

    public void setProgressText(String progressText2) {
        this.progressText = progressText2;
    }

    public void startProgress() {
        this.progressBar.setVisibility(0);
        this.progressTextView.setText(this.progressText);
    }

    public void stopProgress() {
        this.progressBar.setVisibility(8);
        this.progressTextView.setText(this.defaultText);
    }

    public int getProgressStatus() {
        if (TextUtils.isEmpty(this.progressText) || !TextUtils.equals(this.progressText, this.progressTextView.getText())) {
            return 1;
        }
        return 2;
    }

    public void setIndeterminateDrawable(Drawable drawable) {
        this.progressBar.setIndeterminateDrawable(drawable);
    }

    public void setIndeterminate(boolean indeterminate) {
        this.progressBar.setIndeterminate(indeterminate);
    }
}
