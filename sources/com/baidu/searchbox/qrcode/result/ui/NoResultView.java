package com.baidu.searchbox.qrcode.result.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.baidu.barcode.R;
import com.baidu.searchbox.qrcode.ui.IResultViewCallbackClient;
import com.baidu.searchbox.services.scancode.CodeResult;

public class NoResultView extends BaseChildResultView {
    public NoResultView(Context context) {
        super(context);
    }

    public NoResultView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NoResultView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setResult(CodeResult result, IResultViewCallbackClient client) {
        super.setResult(result, client);
        addView(LayoutInflater.from(getContext()).inflate(R.layout.barcode_no_result, this, false), new FrameLayout.LayoutParams(-1, -1));
    }

    public boolean selfScroll() {
        return true;
    }
}
