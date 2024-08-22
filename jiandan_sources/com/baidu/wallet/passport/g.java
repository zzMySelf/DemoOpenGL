package com.baidu.wallet.passport;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.GetOpenBdussCallback;
import com.baidu.sapi2.callback.Web2NativeLoginCallback;
import com.baidu.sapi2.dto.GetOpenBdussDTO;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.result.OpenBdussResult;
import com.baidu.sapi2.result.Web2NativeLoginResult;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.IWalletLoginListener;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.widget.LoadingActivity;
import com.baidu.wallet.base.widget.banner.BannerFocusImageViewGroup;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.MainHandler;
import com.baidu.wallet.passport.e;
import com.baidu.wallet.paysdk.datamodel.SdkInitResponse;
import com.baidu.wallet.utils.JsonUtil;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class g extends e {
    public static final int a = 603;
    public static final String b = "PassLoginUtilImpl";
    public static final long c = 300;
    public static final long d = 7000;
    public static final int e = 601;
    public static final int f = 602;
    public static final int g = 604;
    public static final int h = 605;

    /* renamed from: i  reason: collision with root package name */
    public static final int f3592i = -201;
    public static final int j = -202;
    public static final int k = -203;
    public static final int l = -901;
    public static final int m = 1;
    public static final int n = 2;

    /* renamed from: o  reason: collision with root package name */
    public static final int f3593o = 3;
    public static final int p = 4;
    public static final int q = 6;
    public static final int r = 7;
    public volatile OpenBdussResult s;
    public CountDownTimer t;
    public CountDownTimer u;
    public boolean v;
    public long w;
    public boolean x;

    public static class a {
        public static final g a = new g();
    }

    private void g() {
        this.s = null;
    }

    /* access modifiers changed from: private */
    public void h() {
        CountDownTimer countDownTimer = this.t;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.t = null;
        }
        CountDownTimer countDownTimer2 = this.u;
        if (countDownTimer2 != null) {
            countDownTimer2.cancel();
            this.u = null;
        }
    }

    /* access modifiers changed from: private */
    public void i() {
        this.v = false;
    }

    /* access modifiers changed from: private */
    public void j() {
        LoadingActivity.exitLoading();
    }

    public void b() {
    }

    public g() {
        this.v = false;
        this.w = -1;
        this.x = true;
    }

    /* access modifiers changed from: private */
    public void b(boolean z, ILoginBackListener iLoginBackListener, int i2) {
        h();
        g();
        c(z, iLoginBackListener, i2);
    }

    public boolean c() {
        return SapiAccountManager.getInstance().isLogin();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0044, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean d() {
        /*
            r3 = this;
            monitor-enter(r3)
            com.baidu.sapi2.SapiAccountManager r0 = com.baidu.sapi2.SapiAccountManager.getInstance()     // Catch:{ all -> 0x0047 }
            boolean r0 = r0.isLogin()     // Catch:{ all -> 0x0047 }
            r1 = 0
            if (r0 == 0) goto L_0x0045
            com.baidu.sapi2.result.OpenBdussResult r0 = r3.s     // Catch:{ all -> 0x0047 }
            if (r0 == 0) goto L_0x0043
            com.baidu.sapi2.result.OpenBdussResult r0 = r3.s     // Catch:{ all -> 0x0047 }
            java.lang.String r0 = r0.openBduss     // Catch:{ all -> 0x0047 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0047 }
            if (r0 != 0) goto L_0x0043
            com.baidu.sapi2.result.OpenBdussResult r0 = r3.s     // Catch:{ all -> 0x0047 }
            java.lang.String r0 = r0.unionid     // Catch:{ all -> 0x0047 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0047 }
            if (r0 != 0) goto L_0x0043
            com.baidu.sapi2.result.OpenBdussResult r0 = r3.s     // Catch:{ all -> 0x0047 }
            java.util.Map<java.lang.String, java.lang.String> r0 = r0.tplStokenMap     // Catch:{ all -> 0x0047 }
            if (r0 == 0) goto L_0x0043
            com.baidu.sapi2.result.OpenBdussResult r0 = r3.s     // Catch:{ all -> 0x0047 }
            java.util.Map<java.lang.String, java.lang.String> r0 = r0.tplStokenMap     // Catch:{ all -> 0x0047 }
            com.baidu.wallet.api.WalletLoginHelper r2 = com.baidu.wallet.api.WalletLoginHelper.getInstance()     // Catch:{ all -> 0x0047 }
            java.lang.String r2 = r2.getTpl()     // Catch:{ all -> 0x0047 }
            java.lang.Object r0 = r0.get(r2)     // Catch:{ all -> 0x0047 }
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ all -> 0x0047 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0047 }
            if (r0 != 0) goto L_0x0043
            r1 = 1
        L_0x0043:
            monitor-exit(r3)
            return r1
        L_0x0045:
            monitor-exit(r3)
            return r1
        L_0x0047:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.passport.g.d():boolean");
    }

    public synchronized String e() {
        String str;
        str = "";
        if (d()) {
            str = this.s.openBduss;
        }
        return str;
    }

    public synchronized void f() {
        SapiAccountManager.getInstance().logout();
        a.a().b();
        g();
    }

    private void c(final boolean z, final ILoginBackListener iLoginBackListener, final int i2) {
        a(z, iLoginBackListener);
        b(z, iLoginBackListener);
        GetOpenBdussDTO getOpenBdussDTO = new GetOpenBdussDTO();
        getOpenBdussDTO.clientId = "fHUnn02XwCrywmmdUtCdK6eC";
        getOpenBdussDTO.targetTplList.add(WalletLoginHelper.getInstance().getTpl());
        DXMSdkSAUtils.onEventStart("DXMGetOpenbduss");
        SapiAccountManager.getInstance().getAccountService().getOpenBduss(getOpenBdussDTO, new GetOpenBdussCallback() {
            /* renamed from: a */
            public void onSuccess(OpenBdussResult openBdussResult) {
                ILoginBackListener iLoginBackListener;
                Map<String, String> map;
                DXMSdkSAUtils.onEventEndWithValues("DXMGetOpenbduss", openBdussResult != null ? openBdussResult.getResultCode() : BannerFocusImageViewGroup.f, Arrays.asList(new String[]{String.valueOf(i2), String.valueOf(g.this.c()), String.valueOf(g.this.d())}));
                g.this.h();
                g.this.j();
                g.this.a(-1);
                if (openBdussResult == null) {
                    return;
                }
                if (g.this.v) {
                    g.this.i();
                    return;
                }
                OpenBdussResult unused = g.this.s = openBdussResult;
                ILoginBackListener iLoginBackListener2 = iLoginBackListener;
                Context context = null;
                if (iLoginBackListener2 instanceof LoginBackListenerProxy) {
                    context = ((LoginBackListenerProxy) iLoginBackListener2).getContext();
                    iLoginBackListener = ((LoginBackListenerProxy) iLoginBackListener).getLoginBackListener();
                } else {
                    iLoginBackListener = null;
                }
                if (!TextUtils.isEmpty(openBdussResult.openBduss) && !TextUtils.isEmpty(openBdussResult.unionid) && (map = openBdussResult.tplStokenMap) != null && !TextUtils.isEmpty(map.get(WalletLoginHelper.getInstance().getTpl()))) {
                    a.a().a(openBdussResult.openBduss);
                    if (iLoginBackListener != null) {
                        g.this.b(true);
                        iLoginBackListener.onSuccess(2, openBdussResult.openBduss);
                    }
                } else if (context != null && iLoginBackListener != null) {
                    if (z && g.this.x) {
                        GlobalUtils.toast(context, ResUtils.getString(context, "wallet_base_open_bduss_network_resolve_error"));
                    }
                    g.this.b(true);
                    DXMSdkSAUtils.onEvent("DXMGetOpenbdussSuccessNoUserInfo");
                    iLoginBackListener.onFail(602, openBdussResult.getResultMsg());
                }
            }

            /* renamed from: b */
            public void onFailure(OpenBdussResult openBdussResult) {
                g.this.h();
                g.this.j();
                g.this.a(-1);
                if (openBdussResult != null) {
                    DXMSdkSAUtils.onEventEndWithValues("DXMGetOpenbduss", openBdussResult.getResultCode(), Arrays.asList(new String[]{String.valueOf(i2), String.valueOf(g.this.c()), String.valueOf(g.this.d())}));
                    if (g.this.v) {
                        g.this.i();
                        return;
                    }
                    g.this.a(false);
                    ILoginBackListener iLoginBackListener = iLoginBackListener;
                    if (iLoginBackListener instanceof LoginBackListenerProxy) {
                        Context context = ((LoginBackListenerProxy) iLoginBackListener).getContext();
                        ILoginBackListener loginBackListener = ((LoginBackListenerProxy) iLoginBackListener).getLoginBackListener();
                        if (loginBackListener == null) {
                            return;
                        }
                        if (openBdussResult.getResultCode() == 2 || openBdussResult.getResultCode() == 6 || openBdussResult.getResultCode() == -901) {
                            loginBackListener.onFail(603, openBdussResult.getResultMsg());
                        } else if (openBdussResult.getResultCode() == -203) {
                            if (context != null && z && g.this.x) {
                                GlobalUtils.toast(context, ResUtils.getString(context, "wallet_base_open_bduss_network_ssl_error"));
                            }
                            g.this.b(true);
                            loginBackListener.onFail(605, openBdussResult.getResultMsg());
                        } else if (openBdussResult.getResultCode() == -201 || openBdussResult.getResultCode() == -202) {
                            if (context != null && z && g.this.x) {
                                GlobalUtils.toast(context, ResUtils.getString(context, "wallet_base_open_bduss_network_error"));
                            }
                            g.this.b(true);
                            loginBackListener.onFail(601, openBdussResult.getResultMsg());
                        } else if (openBdussResult.getResultCode() == 3 || openBdussResult.getResultCode() == 4 || openBdussResult.getResultCode() == 7) {
                            if (context != null && z && g.this.x) {
                                GlobalUtils.toast(context, ResUtils.getString(context, "wallet_base_open_bduss_network_resolve_error"));
                            }
                            g.this.b(true);
                            loginBackListener.onFail(602, openBdussResult.getResultMsg());
                        } else if (openBdussResult.getResultCode() != 1) {
                            if (context != null && z && g.this.x) {
                                GlobalUtils.toast(context, ResUtils.getString(context, "wallet_base_open_bduss_network_resolve_error"));
                            }
                            g.this.b(true);
                            loginBackListener.onFail(602, openBdussResult.getResultMsg());
                        } else if (context == null || !z || !g.this.x) {
                            g.this.b(true);
                            loginBackListener.onFail(604, openBdussResult.getResultMsg());
                        } else {
                            g.this.b(true);
                            try {
                                PassLoginDialogUtil.getInstance().showLoginTipDialog(context, iLoginBackListener, 604, openBdussResult.getResultMsg());
                            } catch (Exception e) {
                                LogUtil.e("PassLoginDialog", "dialog Exception", e);
                                GlobalUtils.toast(context, ResUtils.getString(context, "wallet_base_open_bduss_network_resolve_error"));
                                loginBackListener.onFail(604, openBdussResult.getResultMsg());
                            }
                        }
                    }
                }
            }

            public void onFinish() {
                LogUtil.d(g.b, "Get Open BDUSS : onFinish");
            }

            public void onStart() {
                LogUtil.d(g.b, "Get Open BDUSS : onStart");
            }
        });
    }

    public synchronized void b(boolean z) {
        this.x = z;
    }

    public static g a() {
        return a.a;
    }

    private void b(boolean z, ILoginBackListener iLoginBackListener) {
        long j2;
        if (z) {
            long j3 = this.w;
            long j4 = 300;
            if (j3 < 0) {
                if (!TextUtils.isEmpty(SdkInitResponse.getInstance().needShowLoadingInterval)) {
                    try {
                        long parseLong = Long.parseLong(SdkInitResponse.getInstance().needShowLoadingInterval);
                        if (parseLong >= 0) {
                            j4 = parseLong;
                        }
                    } catch (Exception e2) {
                        LogUtil.d(e2.getMessage());
                    }
                }
                j2 = j4;
            } else {
                j2 = j3;
            }
            final boolean z2 = z;
            final ILoginBackListener iLoginBackListener2 = iLoginBackListener;
            AnonymousClass5 r1 = new CountDownTimer(j2, j2) {
                public void onFinish() {
                    g.this.a(-1);
                    if (g.this.s == null && z2) {
                        ILoginBackListener iLoginBackListener = iLoginBackListener2;
                        if (iLoginBackListener instanceof LoginBackListenerProxy) {
                            g.this.a(((LoginBackListenerProxy) iLoginBackListener).getContext());
                        }
                    }
                }

                public void onTick(long j) {
                }
            };
            this.t = r1;
            r1.start();
        }
    }

    public synchronized Map<String, String> a(Context context, String str) {
        HashMap hashMap;
        hashMap = new HashMap();
        if (d()) {
            if (!TextUtils.isEmpty(this.s.uid)) {
                hashMap.put("pass_uid", this.s.uid);
            }
            if (!TextUtils.isEmpty(this.s.displayname)) {
                hashMap.put("pass_user_name", this.s.displayname);
            }
            if (!TextUtils.isEmpty(this.s.openBduss)) {
                hashMap.put("pass_open_bduss", this.s.openBduss);
            }
            if (!TextUtils.isEmpty(this.s.unionid)) {
                hashMap.put("pass_union_id", this.s.unionid);
            }
            if (this.s.tplStokenMap != null && !TextUtils.isEmpty(this.s.tplStokenMap.get(str))) {
                hashMap.put("pass_stoken", this.s.tplStokenMap.get(str));
            }
            hashMap.put(IWalletLoginListener.KEY_LOGIN_TYPE, "0");
        }
        return hashMap;
    }

    public synchronized String a(String str) {
        String str2;
        str2 = null;
        if (d()) {
            str2 = this.s.tplStokenMap.get(str);
        }
        return str2;
    }

    public synchronized void a(boolean z) {
        if (z) {
            SapiAccountManager.getInstance().logout();
        }
        a.a().b();
        g();
    }

    public synchronized void a(final boolean z, final ILoginBackListener iLoginBackListener, final int i2) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            MainHandler.getInstance().post(new Runnable() {
                public void run() {
                    g.this.b(z, iLoginBackListener, i2);
                }
            });
        } else {
            b(z, iLoginBackListener, i2);
        }
    }

    public synchronized void a(long j2) {
        this.w = j2;
    }

    public void a(Context context, final ILoginBackListener iLoginBackListener, String str) {
        PassportSDK instance = PassportSDK.getInstance();
        WebLoginDTO webLoginDTO = new WebLoginDTO();
        webLoginDTO.loginType = WebLoginDTO.EXTRA_LOGIN_WITH_SMS;
        if (!TextUtils.isEmpty(str)) {
            JsonUtil.jsonStringToNameValuePairList(str, webLoginDTO.extraParams);
        }
        instance.startLogin(context, new WebAuthListener() {
            /* renamed from: a */
            public void onSuccess(WebAuthResult webAuthResult) {
                ILoginBackListener iLoginBackListener = iLoginBackListener;
                if (iLoginBackListener != null) {
                    iLoginBackListener.onSuccess(0, "");
                }
            }

            /* renamed from: b */
            public void onFailure(WebAuthResult webAuthResult) {
                ILoginBackListener iLoginBackListener = iLoginBackListener;
                if (iLoginBackListener != null) {
                    iLoginBackListener.onFail(webAuthResult.getResultCode(), webAuthResult.getResultMsg());
                }
            }

            public void beforeSuccess(SapiAccount sapiAccount) {
            }
        }, webLoginDTO);
    }

    public void a(final e.a aVar) {
        SapiAccountManager.getInstance().getAccountService().web2NativeLogin((Web2NativeLoginCallback) new Web2NativeLoginCallback() {
            /* renamed from: a */
            public void onBdussExpired(Web2NativeLoginResult web2NativeLoginResult) {
                e.a aVar = aVar;
                if (aVar != null) {
                    aVar.b();
                }
            }

            /* renamed from: b */
            public void onSuccess(Web2NativeLoginResult web2NativeLoginResult) {
                e.a aVar = aVar;
                if (aVar != null) {
                    aVar.c();
                }
            }

            /* renamed from: c */
            public void onFailure(Web2NativeLoginResult web2NativeLoginResult) {
                e.a aVar = aVar;
                if (aVar != null) {
                    aVar.d();
                }
            }

            public void onBdussEmpty(Web2NativeLoginResult web2NativeLoginResult) {
                e.a aVar = aVar;
                if (aVar != null) {
                    aVar.a();
                }
            }

            public void onFinish() {
                e.a aVar = aVar;
                if (aVar != null) {
                    aVar.f();
                }
            }

            public void onStart() {
                e.a aVar = aVar;
                if (aVar != null) {
                    aVar.e();
                }
            }
        }, true);
    }

    private void a(boolean z, ILoginBackListener iLoginBackListener) {
        Context context;
        if (z) {
            i();
            long j2 = 7000;
            if ((iLoginBackListener instanceof LoginBackListenerProxy) && (context = ((LoginBackListenerProxy) iLoginBackListener).getContext()) != null && !TextUtils.isEmpty(SdkInitResponse.getInstance().getLoadingDurationInterval(context))) {
                try {
                    long parseLong = Long.parseLong(SdkInitResponse.getInstance().getLoadingDurationInterval(context));
                    if (parseLong >= 0) {
                        j2 = parseLong;
                    }
                } catch (Exception e2) {
                    LogUtil.d(e2.getMessage());
                }
            }
            long j3 = j2;
            final ILoginBackListener iLoginBackListener2 = iLoginBackListener;
            final boolean z2 = z;
            AnonymousClass4 r3 = new CountDownTimer(j3, j3) {
                public void onFinish() {
                    g.this.j();
                    g.this.a(-1);
                    ILoginBackListener iLoginBackListener = iLoginBackListener2;
                    if ((iLoginBackListener instanceof LoginBackListenerProxy) && z2) {
                        Context context = ((LoginBackListenerProxy) iLoginBackListener).getContext();
                        ILoginBackListener loginBackListener = ((LoginBackListenerProxy) iLoginBackListener2).getLoginBackListener();
                        if (loginBackListener != null) {
                            if (context != null && g.this.x) {
                                GlobalUtils.toast(context, ResUtils.getString(context, "wallet_base_open_bduss_network_error"));
                            }
                            g.this.b(true);
                            boolean unused = g.this.v = true;
                            loginBackListener.onFail(601, context != null ? ResUtils.getString(context, "wallet_base_open_bduss_network_error") : "");
                        }
                    }
                }

                public void onTick(long j) {
                }
            };
            this.u = r3;
            r3.start();
        }
    }

    /* access modifiers changed from: private */
    public void a(Context context) {
        if (context != null) {
            Intent intent = new Intent(context, LoadingActivity.class);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                activity.startActivity(intent);
                activity.overridePendingTransition(0, 0);
                return;
            }
            intent.addFlags(268435456);
            DxmApplicationContextImpl.getApplicationContext(context).startActivity(intent);
        }
    }
}
