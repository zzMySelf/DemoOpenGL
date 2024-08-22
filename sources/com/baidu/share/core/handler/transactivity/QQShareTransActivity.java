package com.baidu.share.core.handler.transactivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.baidu.share.R;
import com.baidu.share.common.util.Utils;
import com.baidu.share.widget.ShareRuntime;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

public class QQShareTransActivity extends BdShareTransBaseActivity {
    public static final String TAG = QQShareTransActivity.class.getSimpleName();
    private IUiListener mQQShareListener = new IUiListener() {
        public void onCancel() {
            QQShareTransActivity.this.cancelCallback();
            QQShareTransActivity.this.finish();
        }

        public void onComplete(Object response) {
            QQShareTransActivity.this.successCallback();
            QQShareTransActivity.this.finish();
        }

        public void onError(UiError e2) {
            if (ShareRuntime.isDebug()) {
                Log.e(QQShareTransActivity.TAG, e2.errorMessage);
            }
            QQShareTransActivity.this.errorCallback(-1);
            QQShareTransActivity.this.finish();
        }

        public void onWarning(int code) {
            if (ShareRuntime.isDebug() && code == -19) {
                Utils.showToast(R.string.bdshare_qq_authority_tip, true);
            }
            QQShareTransActivity.this.errorCallback(-1);
            QQShareTransActivity.this.finish();
        }
    };
    private Tencent mTencent;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Tencent createInstance = Tencent.createInstance(this.mClientId, getApplicationContext(), Utils.getProviderAuthority());
        this.mTencent = createInstance;
        if (createInstance == null) {
            errorCallback(-1);
            finish();
            return;
        }
        createInstance.shareToQQ(this, this.mParams, this.mQQShareListener);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 10103) {
            Tencent.onActivityResultData(requestCode, resultCode, data, this.mQQShareListener);
        } else {
            finish();
        }
    }
}
