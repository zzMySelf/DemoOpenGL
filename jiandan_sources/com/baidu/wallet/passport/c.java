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
import com.baidu.sapi2.dto.WebLoginDTO;
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
import com.dxm.pass_basic.DxmAccount;
import com.dxm.pass_basic.callback.IDxmWeb2NativeLoginCallback;
import com.dxm.pass_basic.callback.IGetDxmAccountCallback;
import com.dxm.pass_basic.dto.DxmLoginDTO;
import com.dxm.pass_basic.result.DxmTplStokenResult;
import com.dxm.pass_basic.result.DxmWeb2NativeLoginResult;
import com.dxm.pass_basic.shell.listener.DxmAuthListener;
import com.dxm.pass_basic.shell.result.DxmAuthResult;
import com.dxm.pass_gate.DxmAccountManager;
import com.dxm.pass_gate.DxmPortSDK;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class c extends e {
    public static final int a = 603;
    public static final String b = "DxmLoginUtilImpl";
    public static final long c = 300;
    public static final long d = 7000;
    public static final int e = 601;
    public static final int f = 602;
    public static final int g = 604;
    public static final int h = 605;

    /* renamed from: i  reason: collision with root package name */
    public static final int f3590i = -201;
    public static final int j = -202;
    public static final int k = -203;
    public static final int l = -901;
    public static final int m = 1;
    public static final int n = 2;

    /* renamed from: o  reason: collision with root package name */
    public static final int f3591o = 3;
    public static final int p = 4;
    public static final int q = 6;
    public static final int r = 7;
    public volatile DxmAccount s;
    public CountDownTimer t;
    public CountDownTimer u;
    public boolean v;
    public long w;
    public boolean x;

    public static class a {
        public static final c a = new c();
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

    public c() {
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
        return DxmAccountManager.getInstance().dxmIsLogin();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0044, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean d() {
        /*
            r3 = this;
            monitor-enter(r3)
            com.dxm.pass_gate.DxmAccountManager r0 = com.dxm.pass_gate.DxmAccountManager.getInstance()     // Catch:{ all -> 0x0047 }
            boolean r0 = r0.dxmIsLogin()     // Catch:{ all -> 0x0047 }
            r1 = 0
            if (r0 == 0) goto L_0x0045
            com.dxm.pass_basic.DxmAccount r0 = r3.s     // Catch:{ all -> 0x0047 }
            if (r0 == 0) goto L_0x0043
            com.dxm.pass_basic.DxmAccount r0 = r3.s     // Catch:{ all -> 0x0047 }
            java.lang.String r0 = r0.openbduss     // Catch:{ all -> 0x0047 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0047 }
            if (r0 != 0) goto L_0x0043
            com.dxm.pass_basic.DxmAccount r0 = r3.s     // Catch:{ all -> 0x0047 }
            java.lang.String r0 = r0.unionid     // Catch:{ all -> 0x0047 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0047 }
            if (r0 != 0) goto L_0x0043
            com.dxm.pass_basic.DxmAccount r0 = r3.s     // Catch:{ all -> 0x0047 }
            java.util.Map r0 = r0.tplStokenMap     // Catch:{ all -> 0x0047 }
            if (r0 == 0) goto L_0x0043
            com.dxm.pass_basic.DxmAccount r0 = r3.s     // Catch:{ all -> 0x0047 }
            java.util.Map r0 = r0.tplStokenMap     // Catch:{ all -> 0x0047 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.passport.c.d():boolean");
    }

    public synchronized String e() {
        String str;
        str = "";
        if (d()) {
            str = this.s.openbduss;
        }
        return str;
    }

    public synchronized void f() {
        DxmAccountManager.getInstance().dxmLogout(true);
        a.a().b();
        g();
    }

    private void c(final boolean z, final ILoginBackListener iLoginBackListener, final int i2) {
        a(z, iLoginBackListener);
        b(z, iLoginBackListener);
        ArrayList arrayList = new ArrayList();
        arrayList.add(WalletLoginHelper.getInstance().getTpl());
        DXMSdkSAUtils.onEventStart("DXMGetOpenbduss");
        DxmAccountManager.getInstance().getOpenBduss(arrayList, false, new IGetDxmAccountCallback() {
            /* renamed from: a */
            public void onSuccess(DxmTplStokenResult dxmTplStokenResult) {
                ILoginBackListener iLoginBackListener;
                if (dxmTplStokenResult != null) {
                    DxmAccount dxmAccount = dxmTplStokenResult.dxmAccount;
                    DXMSdkSAUtils.onEventEndWithValues("DXMGetOpenbduss", dxmAccount != null ? dxmTplStokenResult.getResultCode() : BannerFocusImageViewGroup.f, Arrays.asList(new String[]{String.valueOf(i2), String.valueOf(c.this.c()), String.valueOf(c.this.d())}));
                    c.this.h();
                    c.this.j();
                    c.this.a(-1);
                    if (dxmAccount == null) {
                        return;
                    }
                    if (c.this.v) {
                        c.this.i();
                        return;
                    }
                    DxmAccount unused = c.this.s = dxmAccount;
                    ILoginBackListener iLoginBackListener2 = iLoginBackListener;
                    Context context = null;
                    if (iLoginBackListener2 instanceof LoginBackListenerProxy) {
                        context = ((LoginBackListenerProxy) iLoginBackListener2).getContext();
                        iLoginBackListener = ((LoginBackListenerProxy) iLoginBackListener).getLoginBackListener();
                    } else {
                        iLoginBackListener = null;
                    }
                    if (!TextUtils.isEmpty(dxmAccount.openbduss) && !TextUtils.isEmpty(dxmAccount.unionid) && dxmAccount.tplStokenMap != null && !TextUtils.isEmpty((CharSequence) dxmAccount.tplStokenMap.get(WalletLoginHelper.getInstance().getTpl()))) {
                        a.a().a(dxmAccount.openbduss);
                        if (iLoginBackListener != null) {
                            c.this.b(true);
                            iLoginBackListener.onSuccess(2, dxmAccount.openbduss);
                        }
                    } else if (context != null && iLoginBackListener != null) {
                        if (z && c.this.x) {
                            GlobalUtils.toast(context, ResUtils.getString(context, "wallet_base_open_bduss_network_resolve_error"));
                        }
                        c.this.b(true);
                        DXMSdkSAUtils.onEvent("DXMGetOpenbdussSuccessNoUserInfo");
                        iLoginBackListener.onFail(602, dxmTplStokenResult.getResultMsg());
                    }
                }
            }

            /* renamed from: b */
            public void onFailure(DxmTplStokenResult dxmTplStokenResult) {
                c.this.h();
                c.this.j();
                c.this.a(-1);
                if (dxmTplStokenResult != null && dxmTplStokenResult.dxmAccount != null) {
                    DXMSdkSAUtils.onEventEndWithValues("DXMGetOpenbduss", dxmTplStokenResult.getResultCode(), Arrays.asList(new String[]{String.valueOf(i2), String.valueOf(c.this.c()), String.valueOf(c.this.d())}));
                    if (c.this.v) {
                        c.this.i();
                        return;
                    }
                    c.this.a(false);
                    ILoginBackListener iLoginBackListener = iLoginBackListener;
                    if (iLoginBackListener instanceof LoginBackListenerProxy) {
                        Context context = ((LoginBackListenerProxy) iLoginBackListener).getContext();
                        ILoginBackListener loginBackListener = ((LoginBackListenerProxy) iLoginBackListener).getLoginBackListener();
                        if (loginBackListener == null) {
                            return;
                        }
                        if (dxmTplStokenResult.getResultCode() == 2 || dxmTplStokenResult.getResultCode() == 6 || dxmTplStokenResult.getResultCode() == -901) {
                            loginBackListener.onFail(603, dxmTplStokenResult.getResultMsg());
                        } else if (dxmTplStokenResult.getResultCode() == -203) {
                            if (context != null && z && c.this.x) {
                                GlobalUtils.toast(context, ResUtils.getString(context, "wallet_base_open_bduss_network_ssl_error"));
                            }
                            c.this.b(true);
                            loginBackListener.onFail(605, dxmTplStokenResult.getResultMsg());
                        } else if (dxmTplStokenResult.getResultCode() == -201 || dxmTplStokenResult.getResultCode() == -202) {
                            if (context != null && z && c.this.x) {
                                GlobalUtils.toast(context, ResUtils.getString(context, "wallet_base_open_bduss_network_error"));
                            }
                            c.this.b(true);
                            loginBackListener.onFail(601, dxmTplStokenResult.getResultMsg());
                        } else if (dxmTplStokenResult.getResultCode() == 3 || dxmTplStokenResult.getResultCode() == 4 || dxmTplStokenResult.getResultCode() == 7) {
                            if (context != null && z && c.this.x) {
                                GlobalUtils.toast(context, ResUtils.getString(context, "wallet_base_open_bduss_network_resolve_error"));
                            }
                            c.this.b(true);
                            loginBackListener.onFail(602, dxmTplStokenResult.getResultMsg());
                        } else if (dxmTplStokenResult.getResultCode() != 1) {
                            if (context != null && z && c.this.x) {
                                GlobalUtils.toast(context, ResUtils.getString(context, "wallet_base_open_bduss_network_resolve_error"));
                            }
                            c.this.b(true);
                            loginBackListener.onFail(602, dxmTplStokenResult.getResultMsg());
                        } else if (context == null || !z || !c.this.x) {
                            c.this.b(true);
                            loginBackListener.onFail(604, dxmTplStokenResult.getResultMsg());
                        } else {
                            c.this.b(true);
                            try {
                                PassLoginDialogUtil.getInstance().showLoginTipDialog(context, iLoginBackListener, 604, dxmTplStokenResult.getResultMsg());
                            } catch (Exception e) {
                                LogUtil.e("PassLoginDialog", "dialog Exception", e);
                                GlobalUtils.toast(context, ResUtils.getString(context, "wallet_base_open_bduss_network_resolve_error"));
                                loginBackListener.onFail(604, dxmTplStokenResult.getResultMsg());
                            }
                        }
                    }
                }
            }

            public void onFinish() {
            }

            public void onStart() {
            }
        });
    }

    public synchronized void b(boolean z) {
        this.x = z;
    }

    public static c a() {
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
                    c.this.a(-1);
                    if (c.this.s == null && z2) {
                        ILoginBackListener iLoginBackListener = iLoginBackListener2;
                        if (iLoginBackListener instanceof LoginBackListenerProxy) {
                            c.this.a(((LoginBackListenerProxy) iLoginBackListener).getContext());
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
            if (!TextUtils.isEmpty(this.s.displayName)) {
                hashMap.put("pass_user_name", this.s.displayName);
            }
            if (!TextUtils.isEmpty(this.s.openbduss)) {
                hashMap.put("pass_open_bduss", this.s.openbduss);
            }
            if (!TextUtils.isEmpty(this.s.unionid)) {
                hashMap.put("pass_union_id", this.s.unionid);
            }
            if (this.s.tplStokenMap != null && !TextUtils.isEmpty((CharSequence) this.s.tplStokenMap.get(str))) {
                hashMap.put("pass_stoken", this.s.tplStokenMap.get(str));
            }
            hashMap.put(IWalletLoginListener.KEY_LOGIN_TYPE, "0");
        }
        return hashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.lang.String a(java.lang.String r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            r0 = 0
            boolean r1 = r2.d()     // Catch:{ all -> 0x0015 }
            if (r1 == 0) goto L_0x0013
            com.dxm.pass_basic.DxmAccount r0 = r2.s     // Catch:{ all -> 0x0015 }
            java.util.Map r0 = r0.tplStokenMap     // Catch:{ all -> 0x0015 }
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x0015 }
            r0 = r3
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0015 }
        L_0x0013:
            monitor-exit(r2)
            return r0
        L_0x0015:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.passport.c.a(java.lang.String):java.lang.String");
    }

    public synchronized void a(boolean z) {
        if (z) {
            DxmAccountManager.getInstance().dxmLogout(z);
        }
        a.a().b();
        g();
    }

    public synchronized void a(final boolean z, final ILoginBackListener iLoginBackListener, final int i2) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            MainHandler.getInstance().post(new Runnable() {
                public void run() {
                    c.this.b(z, iLoginBackListener, i2);
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
        WebLoginDTO webLoginDTO = new WebLoginDTO();
        webLoginDTO.loginType = WebLoginDTO.EXTRA_LOGIN_WITH_SMS;
        webLoginDTO.finishActivityAfterSuc = false;
        DxmLoginDTO dxmLoginDTO = new DxmLoginDTO();
        dxmLoginDTO.bdWebLoginDTO = webLoginDTO;
        if (!TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            JsonUtil.jsonStringToNameValuePairList(str, arrayList);
            webLoginDTO.extraParams = arrayList;
        }
        DxmPortSDK.getInstance().dxmStartLogin(context, new DxmAuthListener() {
            /* renamed from: a */
            public void onSuccess(DxmAuthResult dxmAuthResult) {
                ILoginBackListener iLoginBackListener = iLoginBackListener;
                if (iLoginBackListener != null) {
                    iLoginBackListener.onSuccess(0, "");
                }
            }

            /* renamed from: b */
            public void onFailure(DxmAuthResult dxmAuthResult) {
                ILoginBackListener iLoginBackListener = iLoginBackListener;
                if (iLoginBackListener != null && dxmAuthResult != null) {
                    iLoginBackListener.onFail(dxmAuthResult.getResultCode(), dxmAuthResult.getResultMsg());
                }
            }

            public void beforeSuccess(DxmAccount dxmAccount) {
            }
        }, dxmLoginDTO);
    }

    public void a(final e.a aVar) {
        DxmAccountManager.getInstance().web2NativeLogin(new IDxmWeb2NativeLoginCallback() {
            /* renamed from: a */
            public void onSuccess(DxmWeb2NativeLoginResult dxmWeb2NativeLoginResult) {
                e.a aVar = aVar;
                if (aVar != null) {
                    aVar.c();
                }
            }

            /* renamed from: b */
            public void onFailure(DxmWeb2NativeLoginResult dxmWeb2NativeLoginResult) {
                e.a aVar = aVar;
                if (aVar != null) {
                    aVar.d();
                }
            }

            public void onBdussEmpty(DxmWeb2NativeLoginResult dxmWeb2NativeLoginResult) {
                e.a aVar = aVar;
                if (aVar != null) {
                    aVar.a();
                }
            }

            public void onBdussExpired(DxmWeb2NativeLoginResult dxmWeb2NativeLoginResult) {
                e.a aVar = aVar;
                if (aVar != null) {
                    aVar.b();
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
                    c.this.j();
                    c.this.a(-1);
                    ILoginBackListener iLoginBackListener = iLoginBackListener2;
                    if ((iLoginBackListener instanceof LoginBackListenerProxy) && z2) {
                        Context context = ((LoginBackListenerProxy) iLoginBackListener).getContext();
                        ILoginBackListener loginBackListener = ((LoginBackListenerProxy) iLoginBackListener2).getLoginBackListener();
                        if (loginBackListener != null) {
                            if (context != null && c.this.x) {
                                GlobalUtils.toast(context, ResUtils.getString(context, "wallet_base_open_bduss_network_error"));
                            }
                            c.this.b(true);
                            boolean unused = c.this.v = true;
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
