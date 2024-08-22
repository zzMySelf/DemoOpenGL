package com.baidu.wallet.paysdk.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.wallet.api.ILoginBackListener;
import com.dxmpay.apollon.utils.CheckUtils;
import com.dxmpay.wallet.api.BaiduWalletDelegate;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.base.widget.BdActionBar;
import com.dxmpay.wallet.passport.LoginBackListenerProxy;
import com.dxmpay.wallet.statistics.api.StatisticManager;

public class b {
    public static void a(final Context context, BdActionBar bdActionBar, final String str, String str2, final String str3, final String str4) {
        if (bdActionBar != null && !TextUtils.isEmpty(str2)) {
            bdActionBar.setRightImgZone2Visibility(0);
            bdActionBar.setRightImgZone2Enable(true);
            bdActionBar.setRightImgZone2Src(str2);
            bdActionBar.setRightImgZone2OnClickListener(new View.OnClickListener() {
                public LoginBackListenerProxy e;

                public void onClick(View view) {
                    if (!CheckUtils.isFastDoubleClick()) {
                        if (!TextUtils.isEmpty(str4)) {
                            StatisticManager.onEvent(str4);
                        }
                        this.e = new LoginBackListenerProxy(context, new ILoginBackListener() {
                            public void onFail(int i2, String str) {
                                if (i2 == 603) {
                                    WalletLoginHelper.getInstance().onlyLogin(AnonymousClass1.this.e);
                                }
                            }

                            public void onSuccess(int i2, String str) {
                                if (!TextUtils.isEmpty(str)) {
                                    BaiduWalletDelegate instance = BaiduWalletDelegate.getInstance();
                                    AnonymousClass1 r7 = AnonymousClass1.this;
                                    instance.openH5Module(context, str, str3, true, false);
                                }
                            }
                        });
                        WalletLoginHelper.getInstance().login(this.e);
                    }
                }
            });
        }
    }
}
