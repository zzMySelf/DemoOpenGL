package com.baidu.wallet;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.LogUtil;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.apollon.utils.SharedPreferencesUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.wallet.api.ILightappInvokerCallback;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.api.WalletServiceBeanConst;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.core.BaseActivity;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.core.utils.BaiduWalletUtils;
import com.baidu.wallet.lightapp.base.LightappConstants;
import com.baidu.wallet.passport.LoginBackListenerProxy;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import java.util.HashMap;
import org.json.JSONObject;

public class BaiduWalletServiceController {
    public static final String H5CHECKPWDCB = "H5CheckPwd";
    public static final String b = "BaiduWalletServiceController";
    public static final String c = "BaiduWalletServiceController";
    public static int d = 1;
    public static final Object e = new Object();
    public static LoginBackListenerProxy f;
    public ILightappInvokerCallback a;
    public long g;

    public static class a {
        public static BaiduWalletServiceController a = new BaiduWalletServiceController();
    }

    private boolean b() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.g;
        LogUtil.logd("timeD=" + j);
        if (0 < j && j < 800) {
            return true;
        }
        this.g = currentTimeMillis;
        return false;
    }

    public static BaiduWalletServiceController getInstance() {
        return a.a;
    }

    public static void getOpenBdussFirst(final Context context, final Intent intent, final boolean z, boolean z2) {
        WalletLoginHelper.getInstance().verifyPassLogin(z2, new LoginBackListenerProxy(context, new ILoginBackListener() {
            public void onFail(int i2, String str) {
                context.startActivity(intent);
                Context context = context;
                if (!(context instanceof Activity)) {
                    return;
                }
                if (z) {
                    BaiduWalletUtils.startActivityAnim(context);
                } else {
                    BaiduWalletUtils.overridePendingTransitionNoAnim((Activity) context);
                }
            }

            public void onSuccess(int i2, String str) {
                context.startActivity(intent);
                Context context = context;
                if (!(context instanceof Activity)) {
                    return;
                }
                if (z) {
                    BaiduWalletUtils.startActivityAnim(context);
                } else {
                    BaiduWalletUtils.overridePendingTransitionNoAnim((Activity) context);
                }
            }
        }));
    }

    public static void loginFirst(final Context context, final Intent intent, final boolean z) {
        if (context instanceof Activity) {
            com.baidu.wallet.core.utils.LogUtil.d("BaiduWalletServiceController", "context is activity!");
        } else {
            intent.setFlags(268435456);
        }
        f = new LoginBackListenerProxy(context, new ILoginBackListener() {
            public void onFail(int i2, String str) {
                if (i2 == 603) {
                    WalletLoginHelper.getInstance().onlyLogin(BaiduWalletServiceController.f);
                } else {
                    LoginBackListenerProxy unused = BaiduWalletServiceController.f = null;
                }
            }

            public void onSuccess(int i2, String str) {
                intent.putExtra("with_anim", z);
                context.startActivity(intent);
                Context context = context;
                if (context instanceof Activity) {
                    if (z) {
                        BaiduWalletUtils.startActivityAnim(context);
                    } else {
                        BaiduWalletUtils.overridePendingTransitionNoAnim((Activity) context);
                    }
                }
                LoginBackListenerProxy unused = BaiduWalletServiceController.f = null;
            }
        });
        WalletLoginHelper.getInstance().login(f);
    }

    public void accessBusCardChargeNFC(Context context, Parcelable parcelable) {
        LocalRouter.getInstance(context).route(context, new RouterRequest().provider("nfc").action("nfchome").data("android.nfc.extra.TAG", parcelable), new RouterCallback() {
            public void onResult(int i2, HashMap hashMap) {
                if (i2 == 5) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("provider", "nfc");
                    hashMap2.put("action", "nfchome");
                    DXMSdkSAUtils.onEventEndWithValues("sdk_router_error", i2, hashMap2.values());
                }
            }
        });
    }

    public boolean enterTransConfirm(BaseActivity baseActivity, JSONObject jSONObject, String str) {
        LocalRouter.getInstance(baseActivity).route(baseActivity, new RouterRequest().provider("transfer").action("entertransferconfirm").data("params", jSONObject.toString()).data("url", str), new RouterCallback() {
            public void onResult(int i2, HashMap hashMap) {
                if (i2 == 5) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("provider", "transfer");
                    hashMap2.put("action", "entertransferconfirm");
                    DXMSdkSAUtils.onEventEndWithValues("sdk_router_error", i2, hashMap2.values());
                }
            }
        });
        return true;
    }

    public void gotoWalletService(Context context, String str, String str2, boolean z) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                gotoWalletService(context, Long.parseLong(str), str2, z);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public boolean isDxmPayService(long j) {
        return (j == 1 || j == 64 || j == 16384 || j == WalletServiceBeanConst.SERVICE_ID_WALLET_HOME_CREDIT || j == WalletServiceBeanConst.SERVICE_ID_WALLET_HOME_FINANCE || j == 32768) ? false : true;
    }

    public boolean startWallet(Context context, boolean z, boolean z2) {
        Boolean bool = (Boolean) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, BeanConstants.PREFS_KEY_USE_NEW_HOME, Boolean.TRUE);
        if ("baidulite".equalsIgnoreCase(BeanConstants.CHANNEL_ID)) {
            bool = Boolean.FALSE;
        }
        final String str = bool.booleanValue() ? "newhome" : "home";
        LocalRouter.getInstance(context).route(context, new RouterRequest().provider(str).action("launcher").data("withAnim", Boolean.toString(z)).data("pageType", Boolean.toString(z2)), new RouterCallback() {
            public void onResult(int i2, HashMap hashMap) {
                if (i2 == 5) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("provider", str);
                    hashMap2.put("action", "launcher");
                    DXMSdkSAUtils.onEventEndWithValues("sdk_router_error", i2, hashMap2.values());
                }
            }
        });
        return true;
    }

    public BaiduWalletServiceController() {
        this.a = null;
    }

    private void a(Context context, boolean z, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(SapiAccount.SAPI_ACCOUNT_EXTRA, str);
        hashMap.put("withAnim", Boolean.toString(z));
        LocalRouter.getInstance(context).route(context, new RouterRequest().provider("fastpay").action("doPhoneCharge").data(hashMap), new RouterCallback() {
            public void onResult(int i2, HashMap hashMap) {
                if (i2 == 5) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("provider", "fastpay");
                    hashMap2.put("action", "doPhoneCharge");
                    DXMSdkSAUtils.onEventEndWithValues("sdk_router_error", i2, hashMap2.values());
                }
            }
        });
    }

    public void gotoWalletService(Context context, String str, String str2) {
        gotoWalletService(context, str, str2, true);
    }

    private void b(final Context context, boolean z, String str) {
        boolean z2 = true;
        int i2 = (TextUtils.isEmpty(str) || !str.contains("barqrcodeType=2")) ? 1 : 2;
        if (TextUtils.isEmpty(str) || !str.contains("showQrCodeBtns")) {
            z2 = false;
        }
        LocalRouter.getInstance(context).route(context, new RouterRequest().provider("saoyisao").action("qrcodescanner").data("withAnim", Boolean.toString(z)).data("showQrCodeBtns", Boolean.valueOf(z2)).data("type", Integer.valueOf(i2)), new RouterCallback() {
            public void onResult(int i2, HashMap hashMap) {
                if (i2 == 5) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("provider", "saoyisao");
                    hashMap2.put("action", "qrcodescanner");
                    if (hashMap != null && hashMap.size() > 0 && "notSupport".equals(hashMap.get("errorMsg"))) {
                        Context context = context;
                        GlobalUtils.toast(context, ResUtils.getString(context, "bd_wallet_not_include_tips"));
                        hashMap2.put("errmsg", hashMap.get("errorMsg"));
                    }
                    DXMSdkSAUtils.onEventEndWithValues("sdk_router_error", i2, hashMap2.values());
                }
            }
        });
    }

    public void gotoWalletService(Context context, String str, String str2, ILightappInvokerCallback iLightappInvokerCallback) {
        if (iLightappInvokerCallback != null) {
            this.a = iLightappInvokerCallback;
            gotoWalletService(context, str, str2, true);
        }
    }

    public void gotoWalletService(Context context, long j, String str) {
        gotoWalletService(context, j, str, true);
    }

    public void gotoWalletService(Context context, long j, String str, boolean z) {
        if (context != null && j >= 0 && !b()) {
            if (LocalRouter.getInstance(context).isProviderExisted(BaiduWalletServiceProviderMap.getInstance().getProviderNameBySerID(j))) {
                WalletLoginHelper.getInstance().clearOpenBduss();
                if (j == 1) {
                    DXMSdkSAUtils.onEvent("#phoneFeeCharge");
                    a(context, z, str);
                } else if (j == 64) {
                    DXMSdkSAUtils.onEvent("#coupon");
                    a(context, str, z);
                } else if (j == 2) {
                    LocalRouter.getInstance(context).route(context, new RouterRequest().provider("transfer").action("entertransfer").data("withAnim", Boolean.toString(z)), new RouterCallback() {
                        public void onResult(int i2, HashMap hashMap) {
                            if (i2 == 5) {
                                HashMap hashMap2 = new HashMap();
                                hashMap2.put("provider", "transfer");
                                hashMap2.put("action", "entertransfer");
                                DXMSdkSAUtils.onEventEndWithValues("sdk_router_error", i2, hashMap2.values());
                            }
                        }
                    });
                } else if (j == 1024) {
                    LocalRouter.getInstance(context).route(context, new RouterRequest().provider("nfc").action("nfchome").data("withAnim", Boolean.toString(z)), new RouterCallback() {
                        public void onResult(int i2, HashMap hashMap) {
                            if (i2 == 5) {
                                HashMap hashMap2 = new HashMap();
                                hashMap2.put("provider", "nfc");
                                hashMap2.put("action", "nfchome");
                                DXMSdkSAUtils.onEventEndWithValues("sdk_router_error", i2, hashMap2.values());
                            }
                        }
                    });
                } else if (j == 16384) {
                    DXMSdkSAUtils.onEvent("#startWallet");
                    startWallet(context, z, false);
                } else if (j == WalletServiceBeanConst.SERVICE_ID_WALLET_HOME_CREDIT) {
                    DXMSdkSAUtils.onEvent("#startWalletCredit");
                    startWallet(context, z, true);
                } else if (j == WalletServiceBeanConst.SERVICE_ID_WALLET_HOME_FINANCE) {
                    DXMSdkSAUtils.onEvent("#startWalletFinance");
                    LocalRouter.getInstance(context).route(context, new RouterRequest().provider("tab").action("startWalletFinance").data("withAnim", Boolean.toString(z)), new RouterCallback() {
                        public void onResult(int i2, HashMap hashMap) {
                            if (i2 == 5) {
                                HashMap hashMap2 = new HashMap();
                                hashMap2.put("provider", "tab");
                                hashMap2.put("action", "startWalletFinance");
                                DXMSdkSAUtils.onEventEndWithValues("sdk_router_error", i2, hashMap2.values());
                            }
                        }
                    });
                } else if (j == 32768) {
                    DXMSdkSAUtils.onEvent("#ownerQrCode");
                    b(context, z, str);
                } else if (j == WalletServiceBeanConst.SERVICE_ID_WALLET_NFC_BUS_CARD_SETTING) {
                    LocalRouter.getInstance(context).route(context, new RouterRequest().provider("nfc").action("nfcsetting").data("withAnim", Boolean.toString(z)), new RouterCallback() {
                        public void onResult(int i2, HashMap hashMap) {
                            if (i2 == 5) {
                                HashMap hashMap2 = new HashMap();
                                hashMap2.put("provider", "nfc");
                                hashMap2.put("action", "nfcsetting");
                                DXMSdkSAUtils.onEventEndWithValues("sdk_router_error", i2, hashMap2.values());
                            }
                        }
                    });
                }
            } else {
                com.baidu.wallet.core.utils.LogUtil.d(b, "dxmpay clearOpenBduss");
                com.dxmpay.wallet.api.WalletLoginHelper.getInstance().clearOpenBduss();
                HashMap hashMap = new HashMap();
                hashMap.put(LightappConstants.ACCESS_WALLET_SERVICE_PARAM_SERVICE, Long.toString(j));
                hashMap.put(SapiAccount.SAPI_ACCOUNT_EXTRA, str);
                hashMap.put("withAnim", Boolean.toString(z));
                LocalRouter.getInstance(context).route(context, new RouterRequest().provider("dxmPay").action("gotoWalletService").data(hashMap), new RouterCallback() {
                    public void onResult(int i2, HashMap hashMap) {
                        if (i2 == 5) {
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("provider", "dxmPay");
                            hashMap2.put("action", "gotoWalletService");
                            DXMSdkSAUtils.onEventEndWithValues("sdk_router_error", i2, hashMap2.values());
                        }
                    }
                });
            }
        }
    }

    private void a(Context context, String str, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put(SapiAccount.SAPI_ACCOUNT_EXTRA, str);
        hashMap.put("withAnim", Boolean.toString(z));
        LocalRouter.getInstance(context).route(context, new RouterRequest().provider("personal").action("entercoupon").data(hashMap), new RouterCallback() {
            public void onResult(int i2, HashMap hashMap) {
                if (i2 == 5) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("provider", "personal");
                    hashMap2.put("action", "entercoupon");
                    DXMSdkSAUtils.onEventEndWithValues("sdk_router_error", i2, hashMap2.values());
                }
            }
        });
    }
}
