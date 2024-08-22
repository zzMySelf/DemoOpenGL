package com.baidu.searchbox.qrcode.result.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.searchbox.qrcode.result.IActionBarRightZoneCallback;

public class BarcodeResultView extends BaseChildResultView {
    public BarcodeResultView(Context context) {
        super(context);
    }

    public BarcodeResultView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BarcodeResultView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setShareButtonCallback(IActionBarRightZoneCallback iActionBarRightZoneCallback) {
    }

    public boolean selfScroll() {
        return true;
    }
}
