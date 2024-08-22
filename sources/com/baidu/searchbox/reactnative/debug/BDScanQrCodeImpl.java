package com.baidu.searchbox.reactnative.debug;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.searchbox.unitedscheme.BaseRouter;
import com.baidu.talos.adapter.IScanQrCodeInterface;

public class BDScanQrCodeImpl implements IScanQrCodeInterface {
    private static final String SCAN_SCHEME = "baiduboxapp://v16/ucenter/scan";

    public void startScanQrCode(Activity activity) {
        BaseRouter.invoke((Context) activity, SCAN_SCHEME);
    }

    public void onScanQrCodeResult(Activity activity, int resultCode, Intent data) {
    }
}
