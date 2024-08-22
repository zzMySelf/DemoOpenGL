package com.dxmpay.wallet;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.wallet.api.ILightappInvokerCallback;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.WalletServiceBeanConst;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.lightapp.base.LightappConstants;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import com.dxmpay.apollon.utils.LogUtil;
import com.dxmpay.apollon.utils.SharedPreferencesUtils;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.core.utils.BaiduWalletUtils;
import com.dxmpay.wallet.passport.LoginBackListenerProxy;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.util.HashMap;

public class BaiduWalletServiceController {
    public static final String H5CHECKPWDCB = "H5CheckPwd";

    /* renamed from: ad  reason: collision with root package name */
    public static LoginBackListenerProxy f4116ad;
    public long qw;

    public class ad implements RouterCallback {
        public ad(BaiduWalletServiceController baiduWalletServiceController) {
        }

        public void onResult(int i2, HashMap hashMap) {
        }
    }

    public class de implements RouterCallback {
        public de(BaiduWalletServiceController baiduWalletServiceController) {
        }

        public void onResult(int i2, HashMap hashMap) {
        }
    }

    public static class fe implements ILoginBackListener {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Intent f4117ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ boolean f4118th;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ Context f4119yj;

        public fe(Intent intent, boolean z, Context context) {
            this.f4117ad = intent;
            this.f4118th = z;
            this.f4119yj = context;
        }

        public void onFail(int i2, String str) {
            if (i2 == 603) {
                WalletLoginHelper.getInstance().onlyLogin(BaiduWalletServiceController.f4116ad);
            }
        }

        public void onSuccess(int i2, String str) {
            if (BaiduWalletServiceController.f4116ad.getContext() != null) {
                this.f4117ad.putExtra("with_anim", this.f4118th);
                BaiduWalletServiceController.f4116ad.getContext().startActivity(this.f4117ad);
                if (!(BaiduWalletServiceController.f4116ad.getContext() instanceof Activity)) {
                    return;
                }
                if (this.f4118th) {
                    BaiduWalletUtils.startActivityAnim(this.f4119yj);
                } else {
                    BaiduWalletUtils.overridePendingTransitionNoAnim((Activity) this.f4119yj);
                }
            }
        }
    }

    public class i implements RouterCallback {
        public i(BaiduWalletServiceController baiduWalletServiceController) {
        }

        public void onResult(int i2, HashMap hashMap) {
        }
    }

    /* renamed from: com.dxmpay.wallet.BaiduWalletServiceController$if  reason: invalid class name */
    public class Cif implements RouterCallback {
        public Cif(BaiduWalletServiceController baiduWalletServiceController) {
        }

        public void onResult(int i2, HashMap hashMap) {
        }
    }

    public class o implements RouterCallback {
        public o(BaiduWalletServiceController baiduWalletServiceController) {
        }

        public void onResult(int i2, HashMap hashMap) {
        }
    }

    public class pf implements RouterCallback {
        public pf(BaiduWalletServiceController baiduWalletServiceController) {
        }

        public void onResult(int i2, HashMap hashMap) {
        }
    }

    public class qw implements RouterCallback {
        public qw(BaiduWalletServiceController baiduWalletServiceController) {
        }

        public void onResult(int i2, HashMap hashMap) {
        }
    }

    public class rg implements RouterCallback {
        public rg(BaiduWalletServiceController baiduWalletServiceController) {
        }

        public void onResult(int i2, HashMap hashMap) {
        }
    }

    /* renamed from: com.dxmpay.wallet.BaiduWalletServiceController$switch  reason: invalid class name */
    public static class Cswitch {
        public static BaiduWalletServiceController qw = new BaiduWalletServiceController((fe) null);
    }

    public class th implements RouterCallback {
        public th(BaiduWalletServiceController baiduWalletServiceController) {
        }

        public void onResult(int i2, HashMap hashMap) {
        }
    }

    public static class uk implements ILoginBackListener {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Context f4120ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ Intent f4121th;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ boolean f4122yj;

        public uk(Context context, Intent intent, boolean z) {
            this.f4120ad = context;
            this.f4121th = intent;
            this.f4122yj = z;
        }

        public void onFail(int i2, String str) {
            this.f4120ad.startActivity(this.f4121th);
            Context context = this.f4120ad;
            if (!(context instanceof Activity)) {
                return;
            }
            if (this.f4122yj) {
                BaiduWalletUtils.startActivityAnim(context);
            } else {
                BaiduWalletUtils.overridePendingTransitionNoAnim((Activity) context);
            }
        }

        public void onSuccess(int i2, String str) {
            this.f4120ad.startActivity(this.f4121th);
            Context context = this.f4120ad;
            if (!(context instanceof Activity)) {
                return;
            }
            if (this.f4122yj) {
                BaiduWalletUtils.startActivityAnim(context);
            } else {
                BaiduWalletUtils.overridePendingTransitionNoAnim((Activity) context);
            }
        }
    }

    public class yj implements RouterCallback {
        public yj(BaiduWalletServiceController baiduWalletServiceController) {
        }

        public void onResult(int i2, HashMap hashMap) {
        }
    }

    public /* synthetic */ BaiduWalletServiceController(fe feVar) {
        this();
    }

    public static BaiduWalletServiceController getInstance() {
        return Cswitch.qw;
    }

    public static void getOpenBdussFirst(Context context, Intent intent, boolean z, boolean z2) {
        WalletLoginHelper.getInstance().verifyPassLogin(z2, new LoginBackListenerProxy(context, new uk(context, intent, z)));
    }

    public static void loginFirst(Context context, Intent intent, boolean z) {
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        f4116ad = new LoginBackListenerProxy(context, new fe(intent, z, context));
        WalletLoginHelper.getInstance().login(f4116ad);
    }

    public void accessBusCardChargeNFC(Context context, Parcelable parcelable) {
        LocalRouter.getInstance(context).route(context, new RouterRequest().provider("nfc").action("nfchome").data("android.nfc.extra.TAG", parcelable), new yj(this));
    }

    public final void ad(Context context, String str, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put(SapiAccount.SAPI_ACCOUNT_EXTRA, str);
        hashMap.put("withAnim", Boolean.toString(z));
        LocalRouter.getInstance(context).route(context, new RouterRequest().provider("personal").action("entercoupon").data(hashMap), new o(this));
    }

    public final void de(Context context, boolean z) {
        LocalRouter.getInstance(context).route(context, new RouterRequest().provider("fastpay").action("doPhoneCharge").data("withAnim", String.valueOf(z)), new i(this));
    }

    public final boolean fe() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.qw;
        LogUtil.logd("timeD=" + j);
        if (0 < j && j < 800) {
            return true;
        }
        this.qw = currentTimeMillis;
        return false;
    }

    public void gotoWalletService(Context context, String str, String str2, boolean z) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                gotoWalletService(context, Long.parseLong(str), str2, z);
            } catch (Exception e) {
                com.dxmpay.wallet.core.utils.LogUtil.e("BaiduWalletServiceController", e.getMessage(), e);
            }
        }
    }

    public boolean startWallet(Context context, boolean z, boolean z2) {
        LocalRouter.getInstance(context).route(context, new RouterRequest().provider(((Boolean) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, BeanConstants.PREFS_KEY_USE_NEW_HOME, Boolean.TRUE)).booleanValue() ? "newhome" : "home").action("launcher").data("withAnim", Boolean.toString(z)).data("pageType", Boolean.toString(z2)), new th(this));
        return true;
    }

    public BaiduWalletServiceController() {
    }

    public void gotoWalletService(Context context, String str, String str2) {
        gotoWalletService(context, str, str2, true);
    }

    public void gotoWalletService(Context context, String str, String str2, ILightappInvokerCallback iLightappInvokerCallback) {
        if (iLightappInvokerCallback != null) {
            gotoWalletService(context, str, str2, true);
        }
    }

    public void gotoWalletService(Context context, long j, String str) {
        gotoWalletService(context, j, str, true);
    }

    public void gotoWalletService(Context context, long j, String str, boolean z) {
        if (context != null && j >= 0) {
            if (fe()) {
                StatisticManager.onEvent(StatServiceEvent.FAST_DOUBLE_CLICK_GOTO_WALLET_SERVICE);
                return;
            }
            WalletLoginHelper.getInstance().clearOpenBduss();
            if (!LocalRouter.getInstance(context).isProviderExisted(BaiduWalletServiceProviderMap.getInstance().getProviderNameBySerID(j))) {
                HashMap hashMap = new HashMap();
                hashMap.put(LightappConstants.ACCESS_WALLET_SERVICE_PARAM_SERVICE, Long.toString(j));
                hashMap.put(SapiAccount.SAPI_ACCOUNT_EXTRA, str);
                hashMap.put("withAnim", Boolean.toString(z));
                LocalRouter.getInstance(context).route(context, new RouterRequest().provider("dxmPay").action("gotoWalletService").data(hashMap), new rg(this));
            } else if (j == 1) {
                StatisticManager.onEvent("#phoneFeeCharge");
                de(context, z);
            } else if (j == 64) {
                StatisticManager.onEvent("#coupon");
                ad(context, str, z);
            } else if (j == 2) {
                StatisticManager.onEvent("#superAccountTrans");
                LocalRouter.getInstance(context).route(context, new RouterRequest().provider("transfer").action("entertransfer").data("withAnim", Boolean.toString(z)), new pf(this));
            } else if (j == 1024) {
                StatisticManager.onEvent("#nfcCharge");
                LocalRouter.getInstance(context).route(context, new RouterRequest().provider("nfc").action("nfchome").data("withAnim", Boolean.toString(z)), new Cif(this));
            } else if (j == 16384) {
                StatisticManager.onEvent("#startWallet");
                startWallet(context, z, false);
            } else if (j == WalletServiceBeanConst.SERVICE_ID_WALLET_HOME_CREDIT) {
                StatisticManager.onEvent("#startWalletCredit");
                startWallet(context, z, true);
            } else if (j == WalletServiceBeanConst.SERVICE_ID_WALLET_HOME_FINANCE) {
                StatisticManager.onEvent("#startWalletFinance");
                LocalRouter.getInstance(context).route(context, new RouterRequest().provider("tab").action("startWalletFinance").data("withAnim", Boolean.toString(z)), new qw(this));
            } else if (j == 32768) {
                StatisticManager.onEvent("#ownerQrCode");
                LocalRouter.getInstance(context).route(context, new RouterRequest().provider("saoyisao").action("qrcodescanner").data("withAnim", Boolean.toString(z)).data("showQrCodeBtns", Boolean.valueOf("showQrCodeBtns".equals(str))), new ad(this));
            } else if (j == WalletServiceBeanConst.SERVICE_ID_WALLET_NFC_BUS_CARD_SETTING) {
                LocalRouter.getInstance(context).route(context, new RouterRequest().provider("nfc").action("nfcsetting").data("withAnim", Boolean.toString(z)), new de(this));
            }
        }
    }
}
