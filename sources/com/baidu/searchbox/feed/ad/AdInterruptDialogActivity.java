package com.baidu.searchbox.feed.ad;

import android.os.Bundle;
import android.widget.TextView;
import com.baidu.searchbox.common.runtime.AppRuntime;

public class AdInterruptDialogActivity extends AdDialogActivity {
    private static final String INTENT_KEY_PERCENT = "percent";
    private TextView mContent;
    private int mPercent;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void initCustomView() {
        if (this.mIntent != null) {
            this.mPercent = this.mIntent.getIntExtra("percent", 50);
        }
        TextView textView = (TextView) findViewById(R.id.tv_interrupt_dialog_content);
        this.mContent = textView;
        textView.setTextColor(AppRuntime.getAppContext().getResources().getColor(R.color.ad_dialog_content_text_color));
        this.mContent.setText(String.format(getResources().getString(R.string.tv_interrupt_dialog_content_text), new Object[]{this.mPercent + "%"}), TextView.BufferType.NORMAL);
    }

    public int containerLayoutId() {
        return R.layout.ad_interrupt_dialog_act;
    }

    public void clickPositive() {
        AdRuntimeHolder.getAdDownloadDialog().posClick();
        finish();
    }

    public void clickNegative() {
        AdRuntimeHolder.getAdDownloadDialog().negClick();
        finish();
    }

    public boolean isPositiveBtnEnable() {
        return true;
    }

    public String posBtnText() {
        return getResources().getString(R.string.ad_interrupt_dialog_pos_text);
    }

    public boolean isNegativeBtnEnable() {
        return true;
    }

    public String negBtnText() {
        return getResources().getString(R.string.ad_interrupt_dialog_nag_text);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        if (AdRuntimeHolder.getAdDownloadDialog().hasDownloadSuccess()) {
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }
}
