package com.dxmpay.wallet.passport;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.wallet.api.WalletApiExtListener;
import com.dxmpay.wallet.api.BaiduWalletDelegate;
import com.dxmpay.wallet.core.BaseActivity;
import com.dxmpay.wallet.paysdk.datamodel.SdkInitResponse;

public class PassSMSAuthProxyActivity extends BaseActivity {
    public static WalletApiExtListener.ThirdPartyLoginListener callback;
    public boolean PageStarted = false;

    public static void startPassSMSAuth(Activity activity, WalletApiExtListener.ThirdPartyLoginListener thirdPartyLoginListener) {
        callback = thirdPartyLoginListener;
        activity.startActivity(new Intent(activity, PassSMSAuthProxyActivity.class));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        window.setGravity(51);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = 0;
        attributes.y = 0;
        attributes.height = 1;
        attributes.width = 1;
        window.setAttributes(attributes);
    }

    public void onDestroy() {
        super.onDestroy();
        callback = null;
    }

    public void onResume() {
        super.onResume();
        if (!this.PageStarted) {
            this.PageStarted = true;
            BaiduWalletDelegate.getInstance().openH5Module(this, SdkInitResponse.getInstance().getPassAuthUrl(this), false);
            return;
        }
        WalletApiExtListener.ThirdPartyLoginListener thirdPartyLoginListener = callback;
        if (thirdPartyLoginListener != null) {
            thirdPartyLoginListener.onCallSuccess(0, (String) null);
        }
        callback = null;
        finish();
    }
}
