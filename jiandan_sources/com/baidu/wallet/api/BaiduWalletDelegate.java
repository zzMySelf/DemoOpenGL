package com.baidu.wallet.api;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import androidx.appcompat.widget.ActivityChooserModel;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.beans.BeanResponseBase;
import com.baidu.apollon.beans.IBeanResponseCallback;
import com.baidu.apollon.restnet.RestDebugConfig;
import com.baidu.apollon.restnet.a;
import com.baidu.apollon.utils.ChannelUtils;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.NetworkCallbackImpl;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.apollon.utils.SharedPreferencesUtils;
import com.baidu.apollon.utils.support.Base64;
import com.baidu.ubc.UBCManager;
import com.baidu.wallet.BaiduWalletServiceController;
import com.baidu.wallet.api.IWalletCreditFacade;
import com.baidu.wallet.base.datamodel.AccountManager;
import com.baidu.wallet.base.nopassauth.OtpTokenUtils;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.core.ActLifecycleCbs;
import com.baidu.wallet.core.DebugConfig;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.core.beans.b;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.core.utils.ActivityStackManager;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.PassUtil;
import com.baidu.wallet.core.utils.PollInitUtils;
import com.baidu.wallet.passport.LoginBackListenerProxy;
import com.baidu.wallet.paysdk.beans.WalletOuterInterfaceBean;
import com.baidu.wallet.paysdk.datamodel.SdkInitResponse;
import com.baidu.wallet.paysdk.datamodel.WalletOutInterfaceResponse;
import com.baidu.wallet.paysdk.storage.PayPreferenceManager;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import com.baidu.wallet.utils.BdWalletUtils;
import com.baidu.wallet.utils.UUIDGenerator;
import com.duxiaoman.imageloader.statistic.ImageSdkSAListener;
import fe.th.ad.ad;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class BaiduWalletDelegate implements IWalletBaseFacade, IWalletCreditFacade {
    public static final String a = "all_image_fail";
    public static final String b = "Glide";
    public static final String c = "Fresco";
    public static String d = "wallet_interface_unlogindata";
    public static final String f = "BaiduWalletDelegate";
    public static volatile boolean h = false;
    public ISecurityListener e;
    public Context g;

    /* renamed from: i  reason: collision with root package name */
    public IWalletListener f1133i;

    public static class a {
        public static final BaiduWalletDelegate a = new BaiduWalletDelegate();
    }

    public static final BaiduWalletDelegate getInstance() {
        return a.a;
    }

    public void callQRCodeScanner(Context context, final IWalletQRScannerCallback iWalletQRScannerCallback) {
        DXMSdkSAUtils.onEvent("#callQRCodeScanner");
        LocalRouter.getInstance(context).route(context, new RouterRequest().provider("saoyisao").action("qrcodescanner").data("withAnim", Boolean.toString(true)).data("qrcodeNeedResult", Boolean.TRUE), new RouterCallback() {
            /* JADX WARNING: Removed duplicated region for block: B:21:0x0056  */
            /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onResult(int r7, java.util.HashMap r8) {
                /*
                    r6 = this;
                    r0 = 2
                    r1 = 1
                    java.lang.String r2 = ""
                    r3 = -1
                    java.lang.String r4 = "失败"
                    if (r7 != 0) goto L_0x001f
                    if (r8 == 0) goto L_0x001f
                    java.lang.String r7 = "value"
                    java.lang.Object r7 = r8.get(r7)
                    java.lang.String r7 = (java.lang.String) r7
                    boolean r8 = android.text.TextUtils.isEmpty(r7)
                    if (r8 != 0) goto L_0x0051
                    r8 = 0
                    java.lang.String r4 = "成功"
                    r2 = r7
                    r0 = 0
                    goto L_0x0052
                L_0x001f:
                    r5 = 5
                    if (r7 != r5) goto L_0x0026
                    java.lang.String r4 = "扫码模块不存在"
                    r0 = 1
                    goto L_0x0052
                L_0x0026:
                    if (r7 != r1) goto L_0x0051
                    if (r8 == 0) goto L_0x0051
                    java.lang.String r7 = "errCode"
                    java.lang.Object r7 = r8.get(r7)
                    java.lang.Integer r7 = (java.lang.Integer) r7
                    int r7 = r7.intValue()
                    java.lang.String r1 = "errorMsg"
                    java.lang.Object r8 = r8.get(r1)
                    java.lang.String r8 = (java.lang.String) r8
                    if (r7 != r0) goto L_0x004b
                    java.lang.String r1 = "camera_permission_denied"
                    boolean r8 = android.text.TextUtils.equals(r8, r1)
                    if (r8 == 0) goto L_0x004b
                    java.lang.String r4 = "没有访问相机的权限"
                    goto L_0x0052
                L_0x004b:
                    if (r7 != 0) goto L_0x0051
                    r0 = 3
                    java.lang.String r4 = "用户取消"
                    goto L_0x0052
                L_0x0051:
                    r0 = -1
                L_0x0052:
                    com.baidu.wallet.api.IWalletQRScannerCallback r7 = r6
                    if (r7 == 0) goto L_0x0059
                    r7.onResult(r0, r4, r2)
                L_0x0059:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.api.BaiduWalletDelegate.AnonymousClass3.onResult(int, java.util.HashMap):void");
            }
        });
    }

    public Pair<Integer, Object> checkSecurityEvn() {
        ISecurityListener iSecurityListener = this.e;
        if (iSecurityListener != null) {
            return iSecurityListener.onCheck();
        }
        return null;
    }

    public void doBusCardChargeNFC(Context context, Parcelable parcelable) {
        if (Build.VERSION.SDK_INT <= 9) {
            GlobalUtils.toast(context, ResUtils.getString(context, "wallet_base_low_sdkversion_tip"));
        } else {
            BaiduWalletServiceController.getInstance().accessBusCardChargeNFC(context, parcelable);
        }
    }

    public Context getAppContext() {
        return this.g;
    }

    public String getBindUrl(String str) {
        return SdkInitResponse.getInstance().getLoginUrl(str);
    }

    public void getUserFinancialInfo(final Context context, final IWalletCreditFacade.Callback callback) {
        if (BdWalletUtils.isCertifiedApp(context) || callback == null) {
            WalletLoginHelper.getInstance().verifyPassLogin(false, new LoginBackListenerProxy(context, new ILoginBackListener() {
                public void onFail(int i2, String str) {
                    BaiduWalletDelegate baiduWalletDelegate = BaiduWalletDelegate.this;
                    IWalletCreditFacade.Callback callback = callback;
                    if (TextUtils.isEmpty(str)) {
                        str = "用户登录异常";
                    }
                    baiduWalletDelegate.a(callback, str);
                }

                public void onSuccess(int i2, String str) {
                    final b bVar = new b(context);
                    bVar.setResponseCallback(new IBeanResponseCallback() {
                        public void onBeanExecFailure(int i2, int i3, String str) {
                            LogUtil.d("financial", "errCode: " + i3 + ", errMsg: " + str);
                            AnonymousClass4 r2 = AnonymousClass4.this;
                            BaiduWalletDelegate.this.a(callback, str);
                        }

                        public void onBeanExecSuccess(int i2, Object obj, String str) {
                            try {
                                BeanResponseBase beanResponseBase = (BeanResponseBase) JsonUtils.fromJson(String.valueOf(obj), BeanResponseBase.class);
                                if (beanResponseBase == null) {
                                    BaiduWalletDelegate.this.a(callback, ResUtils.getString(context, "ebpay_resolve_error"));
                                } else if (bVar.a()) {
                                    callback.onResult(true, beanResponseBase.getRealResponseContent());
                                } else {
                                    BaiduWalletDelegate.this.a(callback, beanResponseBase.getRealResponseMsg());
                                }
                            } catch (JSONException unused) {
                                AnonymousClass4 r5 = AnonymousClass4.this;
                                BaiduWalletDelegate.this.a(callback, ResUtils.getString(context, "ebpay_resolve_error"));
                            }
                            LogUtil.d("financial", obj.toString());
                        }
                    });
                    bVar.execBean();
                }
            }));
        } else {
            a(callback, "验签失败");
        }
    }

    public IWalletListener getWalletListener() {
        return this.f1133i;
    }

    public String getWalletOuterInterface(final Context context, final IWalletOuterInterfaceListener iWalletOuterInterfaceListener) {
        WalletLoginHelper.getInstance().verifyPassLogin(false, new LoginBackListenerProxy(context, new ILoginBackListener() {
            public void onFail(int i2, String str) {
                BaiduWalletDelegate.this.a(context, iWalletOuterInterfaceListener);
            }

            public void onSuccess(int i2, String str) {
                BaiduWalletDelegate.this.a(context, iWalletOuterInterfaceListener);
            }
        }));
        String walletInterfaceData = PayPreferenceManager.getWalletInterfaceData(context, PayPreferenceManager.getNewPpKey(context), "");
        if ((WalletLoginHelper.getInstance().isPassLogin() || WalletLoginHelper.getInstance().isLogin()) && !TextUtils.isEmpty(walletInterfaceData)) {
            try {
                byte[] decode = Base64.decode(walletInterfaceData.getBytes());
                if (decode != null) {
                    return new String(decode);
                }
            } catch (Exception e2) {
                LogUtil.e(f, e2.getMessage(), e2);
            }
            return "";
        }
        String walletInterfaceData2 = PayPreferenceManager.getWalletInterfaceData(context, d, "");
        if (!TextUtils.isEmpty(walletInterfaceData2)) {
            return walletInterfaceData2;
        }
        return "";
    }

    public void gotoWalletService(Context context, String str, String str2) {
        BaiduWalletServiceController.getInstance().gotoWalletService(context, str, str2, true);
    }

    public void initLangBrige(IWalletListener iWalletListener) {
        LocalRouter.getInstance(this.g).route(this.g, new RouterRequest().provider("langbrige").action("langbrige_init").data("wallet_listener", iWalletListener), new RouterCallback() {
            public void onResult(int i2, HashMap hashMap) {
            }
        });
    }

    public void initWallet(Context context) {
        initWallet(context, "simplify");
    }

    public void invokeBdWalletNative(Activity activity, String str, String str2, ILightappInvokerCallback iLightappInvokerCallback) {
        LocalRouter.getInstance(activity).route(activity, new RouterRequest().provider("langbrige").action("langbrige_invokeNativeAbility").data(ActivityChooserModel.ATTRIBUTE_ACTIVITY, activity).data(UBCManager.CONTENT_KEY_SOURCE, str).data("options", str2).data("callback", iLightappInvokerCallback), new RouterCallback() {
            public void onResult(int i2, HashMap hashMap) {
            }
        });
    }

    public void invokeHostNative(String str, String str2) {
        if (WalletLoginHelper.getInstance() != null && (WalletLoginHelper.getInstance() instanceof IWalletInvokeHostListener) && !TextUtils.isEmpty(str)) {
            try {
                ((IWalletInvokeHostListener) WalletLoginHelper.getInstance()).invokeHostNative(Long.parseLong(str), str2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public boolean isInited() {
        return h;
    }

    public void logout(Context context) {
        WalletLoginHelper.getInstance().logout();
        if (context != null) {
            AccountManager.getInstance(DxmApplicationContextImpl.getApplicationContext(context)).logout();
        }
    }

    public void openH5Module(Context context, String str, boolean z) {
        LocalRouter.getInstance(context).route(context, new RouterRequest().provider("langbrige").action("langbrige_start").data("url", str).data("title", (Object) null).data("with_anim", Boolean.TRUE).data("show_share", Boolean.valueOf(z)), new RouterCallback() {
            public void onResult(int i2, HashMap hashMap) {
            }
        });
    }

    public void removeH5LifeCycleCb(Context context, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        if (context != null) {
            LocalRouter.getInstance(DxmApplicationContextImpl.getApplicationContext(context)).route(context, new RouterRequest().provider("langbrige").action("langbrige_removeLifeCycleCb").data("lifeCycleCb", activityLifecycleCallbacks).data("activty", context), new RouterCallback() {
                public void onResult(int i2, HashMap hashMap) {
                }
            });
        }
    }

    public void setDebugOn(Context context, boolean z) {
        if (z) {
            DebugConfig.getInstance(context).changeQA();
        } else {
            DebugConfig.getInstance(context).changeOnline();
        }
        RestDebugConfig.getInstance().setDebugOn(z);
    }

    public boolean startWallet(Context context) {
        DXMSdkSAUtils.onEvent("#startWallet");
        return BaiduWalletServiceController.getInstance().startWallet(context, true, false);
    }

    public BaiduWalletDelegate() {
    }

    public void initWallet(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            WalletLoginHelper.getInstance().registerGlobalCallback(context);
            WalletLoginHelper.getInstance().configPass(context);
            initWallet((IWalletListener) null, context, str);
            initLangBrige((IWalletListener) null);
            if (Build.VERSION.SDK_INT >= 21) {
                NetworkCallbackImpl.register(context);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("The channel number can not be empty.");
    }

    public void openH5Module(Context context, String str, boolean z, Bundle bundle) {
        LocalRouter.getInstance(context).route(context, new RouterRequest().provider("langbrige").action("langbrige_start").data("url", str).data("title", (Object) null).data("with_anim", Boolean.TRUE).data("show_share", Boolean.valueOf(z)).data("bundle", bundle), new RouterCallback() {
            public void onResult(int i2, HashMap hashMap) {
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(Context context) {
        long syncTime = OtpTokenUtils.syncTime(OtpTokenUtils.getmSyncWithServerTime(context));
        String str = f;
        LogUtil.d(str, "sync server time: detatime is " + syncTime);
        OtpTokenUtils.setmSyncWithServerTime(context, syncTime);
    }

    /* access modifiers changed from: private */
    public void a(IWalletCreditFacade.Callback callback, String str) {
        if (callback != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("msg", str);
                callback.onResult(false, jSONObject.toString());
            } catch (JSONException unused) {
            }
        }
    }

    public void openH5Module(Context context, String str, String str2, boolean z, boolean z2) {
        LocalRouter.getInstance(context).route(context, new RouterRequest().provider("langbrige").action("langbrige_start").data("url", str).data("title", str2).data("with_anim", Boolean.valueOf(z)).data("show_share", Boolean.valueOf(z2)), new RouterCallback() {
            public void onResult(int i2, HashMap hashMap) {
            }
        });
    }

    public void initWallet(IWalletListener iWalletListener, Context context, String str, ISecurityListener iSecurityListener) {
        if (!TextUtils.isEmpty(str)) {
            this.e = iSecurityListener;
            initWallet(iWalletListener, context, str);
            if (Build.VERSION.SDK_INT >= 21) {
                NetworkCallbackImpl.register(context);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("The channel number can not be empty.");
    }

    /* access modifiers changed from: private */
    public void a(final Context context, final IWalletOuterInterfaceListener iWalletOuterInterfaceListener) {
        final Handler handler = new Handler(context.getMainLooper());
        handler.removeCallbacksAndMessages((Object) null);
        WalletOuterInterfaceBean walletOuterInterfaceBean = new WalletOuterInterfaceBean(context);
        walletOuterInterfaceBean.setResponseCallback(new IBeanResponseCallback() {
            public void onBeanExecFailure(int i2, final int i3, final String str) {
                handler.post(new Runnable() {
                    public void run() {
                        IWalletOuterInterfaceListener iWalletOuterInterfaceListener = iWalletOuterInterfaceListener;
                        if (iWalletOuterInterfaceListener != null) {
                            iWalletOuterInterfaceListener.onReceived(i3, str);
                        }
                    }
                });
            }

            public void onBeanExecSuccess(int i2, Object obj, String str) {
                JSONObject jSONObject;
                WalletOutInterfaceResponse walletOutInterfaceResponse = obj instanceof WalletOutInterfaceResponse ? (WalletOutInterfaceResponse) obj : null;
                if (walletOutInterfaceResponse == null || (jSONObject = walletOutInterfaceResponse.login_data) == null) {
                    handler.post(new Runnable() {
                        public void run() {
                            IWalletOuterInterfaceListener iWalletOuterInterfaceListener = iWalletOuterInterfaceListener;
                            if (iWalletOuterInterfaceListener != null) {
                                iWalletOuterInterfaceListener.onReceived(-1, "");
                            }
                        }
                    });
                } else {
                    final String jSONObject2 = jSONObject.toString();
                    String encodeBytes = Base64.encodeBytes(jSONObject2.getBytes());
                    String newPpKey = PayPreferenceManager.getNewPpKey(context);
                    if (!TextUtils.isEmpty(newPpKey) && !TextUtils.isEmpty(encodeBytes)) {
                        PayPreferenceManager.setWalletInterfaceData(context, newPpKey, encodeBytes);
                    }
                    handler.post(new Runnable() {
                        public void run() {
                            IWalletOuterInterfaceListener iWalletOuterInterfaceListener = iWalletOuterInterfaceListener;
                            if (iWalletOuterInterfaceListener != null) {
                                iWalletOuterInterfaceListener.onReceived(0, jSONObject2);
                            }
                        }
                    });
                }
                if (walletOutInterfaceResponse != null && walletOutInterfaceResponse.unlogin_data != null) {
                    PayPreferenceManager.setWalletInterfaceData(context, BaiduWalletDelegate.d, walletOutInterfaceResponse.unlogin_data.toString());
                }
            }
        });
        walletOuterInterfaceBean.execBean();
    }

    public void openH5Module(Context context, Bundle bundle) {
        if (bundle != null && bundle.containsKey("url") && !TextUtils.isEmpty(bundle.getString("url"))) {
            String string = bundle.getString("url");
            String string2 = bundle.containsKey("title") ? bundle.getString("title") : null;
            boolean z = true;
            boolean z2 = bundle.containsKey("withAnim") ? bundle.getBoolean("withAnim") : true;
            if (bundle.containsKey("show_share")) {
                z = bundle.getBoolean("show_share");
            }
            bundle.remove("url");
            bundle.remove("title");
            bundle.remove("withAnim");
            bundle.remove("show_share");
            LocalRouter.getInstance(context).route(context, new RouterRequest().provider("langbrige").action("langbrige_start").data("url", string).data("title", string2).data("with_anim", Boolean.valueOf(z2)).data("show_share", Boolean.valueOf(z)).data("bundle", bundle), new RouterCallback() {
                public void onResult(int i2, HashMap hashMap) {
                }
            });
        }
    }

    public void initWallet(IWalletListener iWalletListener, final Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("The channel number can not be empty.");
        } else if (context != null) {
            this.f1133i = iWalletListener;
            if (iWalletListener != null) {
                initLangBrige(iWalletListener);
            }
            WalletLoginHelper.getInstance().init(context, iWalletListener);
            BeanConstants.CHANNEL_ID = str;
            String str2 = "BaiduWallet-" + BeanConstants.VERSION_NO + "-Android-" + BeanConstants.CHANNEL_ID;
            BeanConstants.SDK_VERSION = str2;
            ChannelUtils.initBussinessParams(str2, false);
            if (DebugConfig.getInstance().isOnline()) {
                DomainConfig.getInstance().setRtcStrategy(DomainConfig.DomainStrategyType.ONLINE, (String) SharedPreferencesUtils.getParam(context, BeanConstants.DOMAIN_CONFIG_NAME_ONLINE, BeanConstants.RTC_DOMAIN_CONFIG_KEY, ""));
                DomainConfig.getInstance().setStrategy(DomainConfig.DomainStrategyType.ONLINE, (String) SharedPreferencesUtils.getParam(context, BeanConstants.DOMAIN_CONFIG_NAME_ONLINE, "wallet_sdk_domain_config_key", ""));
                com.baidu.apollon.heartbeat.a.c().a((String) SharedPreferencesUtils.getParam(context, BeanConstants.DOMAIN_CONFIG_NAME_ONLINE, BeanConstants.DOMAIN_CONFIG_KEY_FOR_APP, ""));
            } else {
                DomainConfig.getInstance().setRtcStrategy(DomainConfig.DomainStrategyType.QA, (String) SharedPreferencesUtils.getParam(context, BeanConstants.DOMAIN_CONFIG_NAME_QA, BeanConstants.RTC_DOMAIN_CONFIG_KEY, ""));
                DomainConfig.getInstance().setStrategy(DomainConfig.DomainStrategyType.QA, (String) SharedPreferencesUtils.getParam(context, BeanConstants.DOMAIN_CONFIG_NAME_QA, "wallet_sdk_domain_config_key", ""));
                com.baidu.apollon.heartbeat.a.c().a((String) SharedPreferencesUtils.getParam(context, BeanConstants.DOMAIN_CONFIG_NAME_QA, BeanConstants.DOMAIN_CONFIG_KEY_FOR_APP, ""));
            }
            DXMSdkSAUtils.initSensorStat(context);
            com.baidu.apollon.restnet.a.a().a((a.b) new DXMSdkSAUtils());
            PassUtil.registerPassNormalize(new PassUtil.IPassNormalize() {
                public boolean onNormalize(Context context, int i2, Map<String, String> map) {
                    LogUtil.logd("onNormalize ");
                    WalletLoginHelper.getInstance().onLoginChanaged(context, map);
                    return false;
                }
            });
            MessageQueue messageQueue = null;
            if (Looper.myLooper() == Looper.getMainLooper()) {
                messageQueue = Looper.myQueue();
            } else if (Build.VERSION.SDK_INT >= 23) {
                messageQueue = Looper.getMainLooper().getQueue();
            } else {
                try {
                    Field declaredField = Looper.class.getDeclaredField("mQueue");
                    declaredField.setAccessible(true);
                    messageQueue = (MessageQueue) declaredField.get(Looper.getMainLooper());
                } catch (NoSuchFieldException e2) {
                    e2.printStackTrace();
                } catch (IllegalAccessException e3) {
                    e3.printStackTrace();
                }
            }
            if (messageQueue != null) {
                messageQueue.addIdleHandler(new MessageQueue.IdleHandler() {
                    public boolean queueIdle() {
                        Context applicationContext = DxmApplicationContextImpl.getApplicationContext(context);
                        if (applicationContext == null) {
                            return false;
                        }
                        LocalRouter.getInstance(applicationContext).route(context, new RouterRequest().provider("langbrige").action("langbrige_initWebView"), new RouterCallback() {
                            public void onResult(int i2, HashMap hashMap) {
                                LogUtil.d(BaiduWalletDelegate.f, "webview init finish");
                            }
                        });
                        return false;
                    }
                });
            }
            new Thread(new Runnable() {
                public void run() {
                    if (SafePay.getInstance().prepareCompleted()) {
                        BdWalletUtils.loadDeviceFP(DxmApplicationContextImpl.getApplicationContext(context));
                        BaiduWalletDelegate.this.a(context);
                    }
                }
            }, "walletInit").start();
            this.g = DxmApplicationContextImpl.getApplicationContext(context);
            PollInitUtils.getInstance().registerListener();
            Application application = (Application) DxmApplicationContextImpl.getApplicationContext(context);
            ActLifecycleCbs.a().a(application);
            h = true;
            ad.ad().fe(DxmApplicationContextImpl.getApplicationContext(context), new ImageSdkSAListener() {
                public void onFrescoFailEvent(String str, String str2) {
                    try {
                        DXMSdkSAUtils.onEventWithValues(DXMSdkSAUtils.SDK_EVENT_SHOW, BaiduWalletDelegate.a, Arrays.asList(new String[]{str, "Fresco," + str2}));
                        String a2 = BaiduWalletDelegate.f;
                        LogUtil.d(a2, "onFailEvent url：" + str + ",message:" + str2);
                    } catch (Exception e) {
                        String a3 = BaiduWalletDelegate.f;
                        LogUtil.d(a3, "onFrescoFailEvent 点位异常：" + e.getMessage());
                    }
                }

                public void onGlideFailEvent(String str, String str2) {
                    try {
                        DXMSdkSAUtils.onEventWithValues(DXMSdkSAUtils.SDK_EVENT_SHOW, BaiduWalletDelegate.a, Arrays.asList(new String[]{str, "Glide," + str2}));
                        String a2 = BaiduWalletDelegate.f;
                        LogUtil.d(a2, "onFailEvent url：" + str + ",message:" + str2);
                    } catch (Exception e) {
                        String a3 = BaiduWalletDelegate.f;
                        LogUtil.d(a3, "onGlideFailEvent 点位异常：" + e.getMessage());
                    }
                }
            });
            ActivityStackManager.getInstance().register(application);
            UUIDGenerator.generateUUID();
        }
    }

    public void openH5Module(Context context, String str) {
        openH5Module(context, str, true);
    }
}
