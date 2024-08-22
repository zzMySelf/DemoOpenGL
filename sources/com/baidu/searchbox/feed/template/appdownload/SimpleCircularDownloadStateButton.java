package com.baidu.searchbox.feed.template.appdownload;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.searchbox.feed.template.R;

public class SimpleCircularDownloadStateButton extends CircularDownloadStateButton {
    public SimpleCircularDownloadStateButton(Context context) {
        super(context);
    }

    public SimpleCircularDownloadStateButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SimpleCircularDownloadStateButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.ad_simple_download_circular_view;
    }
}
