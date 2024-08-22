package com.baidu.wallet.base.widget;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.NetworkUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.BaiduWalletServiceController;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.widget.banner.BannerBaseItemInfo;
import com.baidu.wallet.passport.LoginBackListenerProxy;

public class SDKJumpManager {
    public LoginBackListenerProxy a;

    public interface OnJumpListener {
        void beforeJump(Context context, String str, String str2, String str3, boolean z);
    }

    public static class a {
        public static SDKJumpManager a = new SDKJumpManager();
    }

    public static SDKJumpManager getInstance() {
        return a.a;
    }

    public void doSDKJump(final Context context, String str, String str2, final String str3, boolean z, OnJumpListener onJumpListener) {
        if (onJumpListener != null) {
            onJumpListener.beforeJump(context, str, str2, str3, z);
        }
        if ("3".equals(str2) && !TextUtils.isEmpty(str3)) {
            BaiduWalletServiceController.getInstance().gotoWalletService(context, str3, "");
        } else if (!"1".equals(str2) || TextUtils.isEmpty(str3)) {
            if (!"2".equals(str2) || TextUtils.isEmpty(str3)) {
                if ("4".equals(str2) && !TextUtils.isEmpty(str3)) {
                    BaiduWalletDelegate.getInstance().invokeHostNative(str3, "");
                } else if (BannerBaseItemInfo.TYPE_LOGIN.equals(str2)) {
                    this.a = new LoginBackListenerProxy(context, new ILoginBackListener() {
                        public void onFail(int i2, String str) {
                            if (i2 == 603) {
                                WalletLoginHelper.getInstance().onlyLogin(SDKJumpManager.this.a);
                            }
                            LoginBackListenerProxy unused = SDKJumpManager.this.a = null;
                        }

                        public void onSuccess(int i2, String str) {
                            LoginBackListenerProxy unused = SDKJumpManager.this.a = null;
                        }
                    });
                    WalletLoginHelper.getInstance().login(this.a);
                } else if (BannerBaseItemInfo.TYPE_SCHEME.equals(str2) && !a(context, str3)) {
                    GlobalUtils.toast(context, ResUtils.getString(context, "wallet_base_string_service_forbidden"));
                }
            } else if (!NetworkUtils.isNetworkAvailable(context)) {
                GlobalUtils.toast(context, ResUtils.getString(context, "ebpay_no_network"));
            } else {
                WalletLoginHelper.getInstance().startPage(str3);
            }
        } else if (!NetworkUtils.isNetworkAvailable(context)) {
            GlobalUtils.toast(context, ResUtils.getString(context, "ebpay_no_network"));
        } else if (z) {
            this.a = new LoginBackListenerProxy(context, new ILoginBackListener() {
                public void onFail(int i2, String str) {
                    if (i2 == 603) {
                        WalletLoginHelper.getInstance().onlyLogin(SDKJumpManager.this.a);
                    }
                    LoginBackListenerProxy unused = SDKJumpManager.this.a = null;
                }

                public void onSuccess(int i2, String str) {
                    BaiduWalletDelegate.getInstance().openH5Module(context, str3, true);
                    LoginBackListenerProxy unused = SDKJumpManager.this.a = null;
                }
            });
            WalletLoginHelper.getInstance().login(this.a);
        } else {
            BaiduWalletDelegate.getInstance().openH5Module(context, str3, true);
        }
    }

    public SDKJumpManager() {
    }

    private boolean a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            if (!(context instanceof Activity)) {
                intent.setFlags(268435456);
            }
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }
}
