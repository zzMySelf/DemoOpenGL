package com.dxmpay.wallet.passport;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.GetOpenBdussCallback;
import com.baidu.sapi2.dto.GetOpenBdussDTO;
import com.baidu.sapi2.result.OpenBdussResult;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.IWalletLoginListener;
import com.baidu.wallet.router.RouterCallback;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.base.widget.LoadingActivity;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.core.utils.MainHandler;
import com.dxmpay.wallet.core.utils.PassUtil;
import com.dxmpay.wallet.dxmpass.DxmPassManagerDelegate;
import com.dxmpay.wallet.paysdk.datamodel.SdkInitResponse;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.util.HashMap;
import java.util.Map;

public class PassLoginUtil {
    public static final int LOGIN_STATUS_ERROR_CODE = 603;

    /* renamed from: ad  reason: collision with root package name */
    public CountDownTimer f4317ad;

    /* renamed from: de  reason: collision with root package name */
    public CountDownTimer f4318de;

    /* renamed from: fe  reason: collision with root package name */
    public boolean f4319fe;
    public volatile OpenBdussResult qw;

    /* renamed from: rg  reason: collision with root package name */
    public long f4320rg;

    /* renamed from: th  reason: collision with root package name */
    public boolean f4321th;

    public class ad extends CountDownTimer {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ boolean f4322ad;
        public final /* synthetic */ ILoginBackListener qw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ad(long j, long j2, ILoginBackListener iLoginBackListener, boolean z) {
            super(j, j2);
            this.qw = iLoginBackListener;
            this.f4322ad = z;
        }

        public void onFinish() {
            PassLoginUtil.this.xxx();
            PassLoginUtil.this.setIntervalDuration(-1);
            ILoginBackListener iLoginBackListener = this.qw;
            if ((iLoginBackListener instanceof LoginBackListenerProxy) && this.f4322ad) {
                Context context = ((LoginBackListenerProxy) iLoginBackListener).getContext();
                ILoginBackListener loginBackListener = ((LoginBackListenerProxy) this.qw).getLoginBackListener();
                if (loginBackListener != null) {
                    if (context != null && PassLoginUtil.this.f4321th) {
                        GlobalUtils.toast(context, ResUtils.getString(context, "dxm_wallet_base_open_bduss_network_error"));
                    }
                    PassLoginUtil.this.setErrorCodeSwitchFlag(true);
                    boolean unused = PassLoginUtil.this.f4319fe = true;
                    loginBackListener.onFail(601, context != null ? ResUtils.getString(context, "dxm_wallet_base_open_bduss_network_error") : "");
                }
            }
        }

        public void onTick(long j) {
        }
    }

    public class de extends CountDownTimer {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ ILoginBackListener f4324ad;
        public final /* synthetic */ boolean qw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public de(long j, long j2, boolean z, ILoginBackListener iLoginBackListener) {
            super(j, j2);
            this.qw = z;
            this.f4324ad = iLoginBackListener;
        }

        public void onFinish() {
            PassLoginUtil.this.setIntervalDuration(-1);
            if (PassLoginUtil.this.qw == null && this.qw) {
                ILoginBackListener iLoginBackListener = this.f4324ad;
                if (iLoginBackListener instanceof LoginBackListenerProxy) {
                    PassLoginUtil.this.fe(((LoginBackListenerProxy) iLoginBackListener).getContext());
                }
            }
        }

        public void onTick(long j) {
        }
    }

    public class fe implements RouterCallback {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ boolean f4326ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ ILoginBackListener f4327th;

        public fe(boolean z, ILoginBackListener iLoginBackListener) {
            this.f4326ad = z;
            this.f4327th = iLoginBackListener;
        }

        public void onResult(int i2, HashMap hashMap) {
            if (i2 == 0) {
                PassLoginUtil passLoginUtil = PassLoginUtil.this;
                passLoginUtil.o(this.f4326ad, this.f4327th, passLoginUtil.ad(hashMap));
            } else if (i2 == 1) {
                PassLoginUtil passLoginUtil2 = PassLoginUtil.this;
                passLoginUtil2.ppp(this.f4326ad, this.f4327th, passLoginUtil2.ad(hashMap));
            } else if (i2 != -1) {
            }
        }
    }

    public class qw implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ boolean f4329ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ ILoginBackListener f4330th;

        public qw(boolean z, ILoginBackListener iLoginBackListener) {
            this.f4329ad = z;
            this.f4330th = iLoginBackListener;
        }

        public void run() {
            PassLoginUtil.this.i(this.f4329ad, this.f4330th);
        }
    }

    public class rg extends GetOpenBdussCallback {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ boolean f4332ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ ILoginBackListener f4333th;

        public rg(boolean z, ILoginBackListener iLoginBackListener) {
            this.f4332ad = z;
            this.f4333th = iLoginBackListener;
        }

        /* renamed from: a */
        public void onSuccess(OpenBdussResult openBdussResult) {
            PassLoginUtil.this.o(this.f4332ad, this.f4333th, openBdussResult);
        }

        /* renamed from: b */
        public void onFailure(OpenBdussResult openBdussResult) {
            PassLoginUtil.this.ppp(this.f4332ad, this.f4333th, openBdussResult);
        }

        public void onFinish() {
        }

        public void onStart() {
        }
    }

    public static class th {
        public static final PassLoginUtil qw = new PassLoginUtil((qw) null);
    }

    public /* synthetic */ PassLoginUtil(qw qwVar) {
        this();
    }

    public static PassLoginUtil getInstance() {
        return th.qw;
    }

    public final OpenBdussResult ad(HashMap hashMap) {
        OpenBdussResult openBdussResult = new OpenBdussResult();
        if (hashMap != null && !hashMap.isEmpty()) {
            openBdussResult.unionid = (String) hashMap.get("unionid");
            openBdussResult.displayname = (String) hashMap.get("displayName");
            openBdussResult.openBduss = (String) hashMap.get("openbduss");
            openBdussResult.tplStokenMap = (Map) hashMap.get(DxmPassManagerDelegate.DXM_KEY_TPL_STOKE_MAP);
            openBdussResult.setResultCode(((Integer) hashMap.get("resultCode")).intValue());
            openBdussResult.setResultMsg((String) hashMap.get(DxmPassManagerDelegate.DXM_KEY_RESULT_MSG));
        }
        return openBdussResult;
    }

    public final void ddd(boolean z, ILoginBackListener iLoginBackListener) {
        long j;
        if (z) {
            long j2 = this.f4320rg;
            long j3 = 300;
            if (j2 < 0) {
                if (!TextUtils.isEmpty(SdkInitResponse.getInstance().needShowLoadingInterval)) {
                    try {
                        long parseLong = Long.parseLong(SdkInitResponse.getInstance().needShowLoadingInterval);
                        if (parseLong >= 0) {
                            j3 = parseLong;
                        }
                    } catch (Exception e) {
                        e.getMessage();
                    }
                }
                j = j3;
            } else {
                j = j2;
            }
            de deVar = new de(j, j, z, iLoginBackListener);
            this.f4317ad = deVar;
            deVar.start();
        }
    }

    public final void de() {
        CountDownTimer countDownTimer = this.f4317ad;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f4317ad = null;
        }
        CountDownTimer countDownTimer2 = this.f4318de;
        if (countDownTimer2 != null) {
            countDownTimer2.cancel();
            this.f4318de = null;
        }
    }

    public final void fe(Context context) {
        if (context != null) {
            Intent intent = new Intent(context, LoadingActivity.class);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                activity.startActivity(intent);
                activity.overridePendingTransition(0, 0);
                return;
            }
            intent.addFlags(268435456);
            context.getApplicationContext().startActivity(intent);
        }
    }

    public synchronized Map<String, String> getLoginData(Context context, String str) {
        HashMap hashMap;
        hashMap = new HashMap();
        if (isLogin()) {
            if (!TextUtils.isEmpty(this.qw.uid)) {
                hashMap.put("pass_uid", this.qw.uid);
            }
            if (!TextUtils.isEmpty(this.qw.displayname)) {
                hashMap.put("pass_user_name", this.qw.displayname);
            }
            if (!TextUtils.isEmpty(this.qw.openBduss)) {
                hashMap.put("pass_open_bduss", this.qw.openBduss);
            }
            if (!TextUtils.isEmpty(this.qw.unionid)) {
                hashMap.put("pass_union_id", this.qw.unionid);
            }
            if (DxmPassManagerDelegate.getInstance().hasDxmPass() && !TextUtils.isEmpty(DxmPassManagerDelegate.getInstance().getDxmDid())) {
                hashMap.put(PassUtil.DXM_DID, DxmPassManagerDelegate.getInstance().getDxmDid());
            }
            if (this.qw.tplStokenMap != null && !TextUtils.isEmpty(this.qw.tplStokenMap.get(str))) {
                hashMap.put("pass_stoken", this.qw.tplStokenMap.get(str));
            }
            hashMap.put(IWalletLoginListener.KEY_LOGIN_TYPE, "0");
        }
        return hashMap;
    }

    public synchronized String getLoginOpenToken() {
        String str;
        str = "";
        if (isLogin()) {
            str = this.qw.openBduss;
        }
        return str;
    }

    public synchronized String getLoginStoken(String str) {
        String str2;
        str2 = null;
        if (isLogin()) {
            str2 = this.qw.tplStokenMap.get(str);
        }
        return str2;
    }

    public synchronized void getOpenBduss(boolean z, ILoginBackListener iLoginBackListener) {
        if (Looper.getMainLooper() == Looper.myLooper() || !z) {
            i(z, iLoginBackListener);
        } else {
            MainHandler.getInstance().post(new qw(z, iLoginBackListener));
        }
    }

    public final void i(boolean z, ILoginBackListener iLoginBackListener) {
        de();
        nn(z, iLoginBackListener);
    }

    /* renamed from: if  reason: not valid java name */
    public final void m276if() {
        this.f4319fe = false;
    }

    public void init() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0067, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean isLogin() {
        /*
            r3 = this;
            monitor-enter(r3)
            com.dxmpay.wallet.dxmpass.DxmPassManagerDelegate r0 = com.dxmpay.wallet.dxmpass.DxmPassManagerDelegate.getInstance()     // Catch:{ all -> 0x006a }
            boolean r0 = r0.hasDxmPass()     // Catch:{ all -> 0x006a }
            if (r0 == 0) goto L_0x0024
            com.dxmpay.wallet.dxmpass.DxmPassManagerDelegate r0 = com.dxmpay.wallet.dxmpass.DxmPassManagerDelegate.getInstance()     // Catch:{ all -> 0x006a }
            int r0 = r0.dxmGetLoginType()     // Catch:{ all -> 0x006a }
            r1 = 2
            if (r0 != r1) goto L_0x0024
            com.baidu.sapi2.result.OpenBdussResult r0 = r3.qw     // Catch:{ all -> 0x006a }
            if (r0 == 0) goto L_0x0024
            com.dxmpay.wallet.dxmpass.DxmPassManagerDelegate r0 = com.dxmpay.wallet.dxmpass.DxmPassManagerDelegate.getInstance()     // Catch:{ all -> 0x006a }
            boolean r0 = r0.dxmIsLogin()     // Catch:{ all -> 0x006a }
            monitor-exit(r3)
            return r0
        L_0x0024:
            com.baidu.sapi2.SapiAccountManager r0 = com.baidu.sapi2.SapiAccountManager.getInstance()     // Catch:{ all -> 0x006a }
            boolean r0 = r0.isLogin()     // Catch:{ all -> 0x006a }
            r1 = 0
            if (r0 == 0) goto L_0x0068
            com.baidu.sapi2.result.OpenBdussResult r0 = r3.qw     // Catch:{ all -> 0x006a }
            if (r0 == 0) goto L_0x0066
            com.baidu.sapi2.result.OpenBdussResult r0 = r3.qw     // Catch:{ all -> 0x006a }
            java.lang.String r0 = r0.openBduss     // Catch:{ all -> 0x006a }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x006a }
            if (r0 != 0) goto L_0x0066
            com.baidu.sapi2.result.OpenBdussResult r0 = r3.qw     // Catch:{ all -> 0x006a }
            java.lang.String r0 = r0.unionid     // Catch:{ all -> 0x006a }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x006a }
            if (r0 != 0) goto L_0x0066
            com.baidu.sapi2.result.OpenBdussResult r0 = r3.qw     // Catch:{ all -> 0x006a }
            java.util.Map<java.lang.String, java.lang.String> r0 = r0.tplStokenMap     // Catch:{ all -> 0x006a }
            if (r0 == 0) goto L_0x0066
            com.baidu.sapi2.result.OpenBdussResult r0 = r3.qw     // Catch:{ all -> 0x006a }
            java.util.Map<java.lang.String, java.lang.String> r0 = r0.tplStokenMap     // Catch:{ all -> 0x006a }
            com.dxmpay.wallet.api.WalletLoginHelper r2 = com.dxmpay.wallet.api.WalletLoginHelper.getInstance()     // Catch:{ all -> 0x006a }
            java.lang.String r2 = r2.getTpl()     // Catch:{ all -> 0x006a }
            java.lang.Object r0 = r0.get(r2)     // Catch:{ all -> 0x006a }
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ all -> 0x006a }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x006a }
            if (r0 != 0) goto L_0x0066
            r1 = 1
        L_0x0066:
            monitor-exit(r3)
            return r1
        L_0x0068:
            monitor-exit(r3)
            return r1
        L_0x006a:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dxmpay.wallet.passport.PassLoginUtil.isLogin():boolean");
    }

    public boolean isPassLogin() {
        if (!DxmPassManagerDelegate.getInstance().hasDxmPass() || DxmPassManagerDelegate.getInstance().dxmGetLoginType() != 2) {
            return SapiAccountManager.getInstance().isLogin();
        }
        return DxmPassManagerDelegate.getInstance().dxmIsLogin();
    }

    public synchronized void logout() {
        if (DxmPassManagerDelegate.getInstance().hasDxmPass()) {
            DxmPassManagerDelegate.getInstance().dxmLogout();
        }
        SapiAccountManager.getInstance().logout();
        fe.i.ad.fe.qw.qw().rg();
    }

    public final void nn(boolean z, ILoginBackListener iLoginBackListener) {
        when(z, iLoginBackListener);
        ddd(z, iLoginBackListener);
        StatisticManager.onEventStart("DXMGetOpenbduss");
        if (DxmPassManagerDelegate.getInstance().hasDxmPass()) {
            DxmPassManagerDelegate.getInstance().getOpenBduss(new fe(z, iLoginBackListener));
            return;
        }
        GetOpenBdussDTO getOpenBdussDTO = new GetOpenBdussDTO();
        getOpenBdussDTO.clientId = "fHUnn02XwCrywmmdUtCdK6eC";
        getOpenBdussDTO.targetTplList.add(WalletLoginHelper.getInstance().getTpl());
        SapiAccountManager.getInstance().getAccountService().getOpenBduss(getOpenBdussDTO, new rg(z, iLoginBackListener));
    }

    public final void o(boolean z, ILoginBackListener iLoginBackListener, OpenBdussResult openBdussResult) {
        Map<String, String> map;
        Map<String, String> map2;
        de();
        xxx();
        setIntervalDuration(-1);
        if (openBdussResult != null) {
            StatisticManager.onEventEnd("DXMGetOpenbduss", openBdussResult.getResultCode());
            if (this.f4319fe) {
                m276if();
                return;
            }
            this.qw = openBdussResult;
            if (iLoginBackListener instanceof LoginBackListenerProxy) {
                LoginBackListenerProxy loginBackListenerProxy = (LoginBackListenerProxy) iLoginBackListener;
                Context context = loginBackListenerProxy.getContext();
                ILoginBackListener loginBackListener = loginBackListenerProxy.getLoginBackListener();
                if (!TextUtils.isEmpty(openBdussResult.openBduss) && (map2 = openBdussResult.tplStokenMap) != null && !TextUtils.isEmpty(map2.get(WalletLoginHelper.getInstance().getTpl()))) {
                    fe.i.ad.fe.qw.qw().fe(openBdussResult.openBduss);
                    if (loginBackListener != null) {
                        setErrorCodeSwitchFlag(true);
                        loginBackListener.onSuccess(2, openBdussResult.openBduss);
                    }
                } else if (context != null && loginBackListener != null) {
                    if (z && this.f4321th) {
                        GlobalUtils.toast(context, ResUtils.getString(context, "dxm_wallet_base_open_bduss_network_resolve_error"));
                    }
                    setErrorCodeSwitchFlag(true);
                    StatisticManager.onEvent("DXMGetOpenbdussSuccessNoUserInfo");
                    loginBackListener.onFail(602, openBdussResult.getResultMsg());
                }
            } else if (!TextUtils.isEmpty(openBdussResult.openBduss) && (map = openBdussResult.tplStokenMap) != null && !TextUtils.isEmpty(map.get(WalletLoginHelper.getInstance().getTpl()))) {
                fe.i.ad.fe.qw.qw().fe(openBdussResult.openBduss);
            }
        } else {
            this.qw = null;
        }
    }

    public final void ppp(boolean z, ILoginBackListener iLoginBackListener, OpenBdussResult openBdussResult) {
        de();
        xxx();
        setIntervalDuration(-1);
        this.qw = null;
        if (openBdussResult != null) {
            StatisticManager.onEventEnd("DXMGetOpenbduss", openBdussResult.getResultCode());
            if (this.f4319fe) {
                m276if();
                return;
            }
            logout(false);
            if (iLoginBackListener instanceof LoginBackListenerProxy) {
                LoginBackListenerProxy loginBackListenerProxy = (LoginBackListenerProxy) iLoginBackListener;
                Context context = loginBackListenerProxy.getContext();
                ILoginBackListener loginBackListener = loginBackListenerProxy.getLoginBackListener();
                if (loginBackListener == null) {
                    return;
                }
                if (openBdussResult.getResultCode() == 2 || openBdussResult.getResultCode() == 6 || openBdussResult.getResultCode() == -901) {
                    loginBackListener.onFail(603, openBdussResult.getResultMsg());
                } else if (openBdussResult.getResultCode() == -203) {
                    if (context != null && z && this.f4321th) {
                        GlobalUtils.toast(context, ResUtils.getString(context, "dxm_wallet_base_open_bduss_network_ssl_error"));
                    }
                    setErrorCodeSwitchFlag(true);
                    loginBackListener.onFail(605, openBdussResult.getResultMsg());
                } else if (openBdussResult.getResultCode() == -201 || openBdussResult.getResultCode() == -202) {
                    if (context != null && z && this.f4321th) {
                        GlobalUtils.toast(context, ResUtils.getString(context, "dxm_wallet_base_open_bduss_network_error"));
                    }
                    setErrorCodeSwitchFlag(true);
                    loginBackListener.onFail(601, openBdussResult.getResultMsg());
                } else if (openBdussResult.getResultCode() == 3 || openBdussResult.getResultCode() == 4 || openBdussResult.getResultCode() == 7) {
                    if (context != null && z && this.f4321th) {
                        GlobalUtils.toast(context, ResUtils.getString(context, "dxm_wallet_base_open_bduss_network_resolve_error"));
                    }
                    setErrorCodeSwitchFlag(true);
                    loginBackListener.onFail(602, openBdussResult.getResultMsg());
                } else if (openBdussResult.getResultCode() != 1) {
                    if (context != null && z && this.f4321th) {
                        GlobalUtils.toast(context, ResUtils.getString(context, "dxm_wallet_base_open_bduss_network_resolve_error"));
                    }
                    setErrorCodeSwitchFlag(true);
                    loginBackListener.onFail(602, openBdussResult.getResultMsg());
                } else if (context == null || !z || !this.f4321th) {
                    setErrorCodeSwitchFlag(true);
                    loginBackListener.onFail(604, openBdussResult.getResultMsg());
                } else {
                    setErrorCodeSwitchFlag(true);
                    try {
                        PassLoginDialogUtil.getInstance().showLoginTipDialog(context, iLoginBackListener, 604, openBdussResult.getResultMsg());
                    } catch (Exception e) {
                        LogUtil.e("PassLoginDialog", "dialog Exception", e);
                        GlobalUtils.toast(context, ResUtils.getString(context, "dxm_wallet_base_open_bduss_network_resolve_error"));
                        loginBackListener.onFail(604, openBdussResult.getResultMsg());
                    }
                }
            }
        }
    }

    public synchronized void setErrorCodeSwitchFlag(boolean z) {
        this.f4321th = z;
    }

    public synchronized void setIntervalDuration(long j) {
        this.f4320rg = j;
    }

    public final void when(boolean z, ILoginBackListener iLoginBackListener) {
        Context context;
        if (z) {
            m276if();
            long j = 7000;
            if ((iLoginBackListener instanceof LoginBackListenerProxy) && (context = ((LoginBackListenerProxy) iLoginBackListener).getContext()) != null && !TextUtils.isEmpty(SdkInitResponse.getInstance().getLoadingDurationInterval(context))) {
                try {
                    long parseLong = Long.parseLong(SdkInitResponse.getInstance().getLoadingDurationInterval(context));
                    if (parseLong >= 0) {
                        j = parseLong;
                    }
                } catch (Exception e) {
                    e.getMessage();
                }
            }
            long j2 = j;
            ad adVar = new ad(j2, j2, iLoginBackListener, z);
            this.f4318de = adVar;
            adVar.start();
        }
    }

    public final void xxx() {
        LoadingActivity.exitLoading();
    }

    public PassLoginUtil() {
        this.f4319fe = false;
        this.f4320rg = -1;
        this.f4321th = true;
    }

    public synchronized void logout(boolean z) {
        if (z) {
            if (DxmPassManagerDelegate.getInstance().hasDxmPass()) {
                DxmPassManagerDelegate.getInstance().dxmLogout();
            }
            SapiAccountManager.getInstance().logout();
            this.qw = null;
        }
        fe.i.ad.fe.qw.qw().rg();
    }
}
