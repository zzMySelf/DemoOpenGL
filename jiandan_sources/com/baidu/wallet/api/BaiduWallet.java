package com.baidu.wallet.api;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.android.pay.BindBack;
import com.baidu.android.pay.PayCallBack;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.wallet.BaiduWalletServiceController;
import com.baidu.wallet.api.IWalletCreditFacade;
import com.baidu.wallet.core.utils.ReflectUtils;
import com.baidu.wallet.rnauth.RNAuthCallBack;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterProvider;
import com.dxmpay.wallet.api.BaiduWalletDelegate;
import java.lang.reflect.Proxy;
import java.util.Map;

public final class BaiduWallet implements IWalletFacade {
    public static final String TAG = "BaiduWallet";

    public static class a {
        public static final IWalletFacade a;

        static {
            WalletFacadeAOP walletFacadeAOP = new WalletFacadeAOP(new BaiduWallet());
            a = (IWalletFacade) Proxy.newProxyInstance(BaiduWallet.class.getClassLoader(), new Class[]{IWalletFacade.class}, walletFacadeAOP);
        }
    }

    private void a(Application application) {
        Object providerObject = ReflectUtils.getProviderObject("com.baidu.wallet.personal.entrance.PersonalProvider");
        if (providerObject != null && (providerObject instanceof RouterProvider)) {
            LocalRouter.getInstance(application).registerProvider("personal", (RouterProvider) providerObject);
        }
        Object providerObject2 = ReflectUtils.getProviderObject("com.baidu.wallet.lightapp.entrance.LangbrigeProvider");
        if (providerObject2 != null && (providerObject2 instanceof RouterProvider)) {
            LocalRouter.getInstance(application).registerProvider("langbrige", (RouterProvider) providerObject2);
        }
        Object providerObject3 = ReflectUtils.getProviderObject("com.baidu.wallet.base.iddetect.entrance.IDCardDetectProvider");
        if (providerObject3 != null && (providerObject3 instanceof RouterProvider)) {
            LocalRouter.getInstance(application).registerProvider("idcarddetect", (RouterProvider) providerObject3);
        }
    }

    public static IWalletFacade getInstance() {
        return a.a;
    }

    public void accessWalletEntry(Context context, String str) {
        BaiduPayDelegate.getInstance().accessWalletEntry(context, str);
    }

    public void callQRCodeScanner(Context context, IWalletQRScannerCallback iWalletQRScannerCallback) {
        BaiduWalletDelegate.getInstance().callQRCodeScanner(context, iWalletQRScannerCallback);
    }

    public void changePayMethod(Activity activity, String str, @NonNull IPrecashierCallback iPrecashierCallback) {
        BaiduPayDelegate.getInstance().changePayMethod(activity, str, iPrecashierCallback);
    }

    public void checkPwd(Context context, CheckCallBack checkCallBack) {
        BaiduPayDelegate.getInstance().checkPwd(context, checkCallBack);
    }

    public void doBind(Context context, BindBack bindBack, Map<String, String> map) {
        BaiduPayDelegate.getInstance().doBind(context, bindBack, map);
    }

    public void doBindCardIndependent(Context context, BindBack bindBack, String str) {
        BaiduPayDelegate.getInstance().doBindCardIndependent(context, bindBack, str);
    }

    public void doCheckPwd(Context context, Map<String, String> map, CheckCallBack checkCallBack) {
        BaiduPayDelegate.getInstance().doCheckPwd(context, map, checkCallBack);
    }

    public void doPay(Context context, String str, PayCallBack payCallBack) {
        BaiduPayDelegate.getInstance().doPay(context, str, payCallBack);
    }

    public void doRNAuth(Context context, Map<String, String> map, RNAuthCallBack rNAuthCallBack) {
        BaiduPayDelegate.getInstance().doRNAuth(context, map, rNAuthCallBack);
    }

    public String getBindUrl(String str) {
        return BaiduWalletDelegate.getInstance().getBindUrl(str);
    }

    public void getPayMethod(Context context, String str, IPrecashierCallback iPrecashierCallback) {
        BaiduPayDelegate.getInstance().getPayMethod(context, str, iPrecashierCallback);
    }

    public void getUserFinancialInfo(Context context, IWalletCreditFacade.Callback callback) {
        BaiduWalletDelegate.getInstance().getUserFinancialInfo(context, callback);
    }

    public String getWalletOuterInterface(Context context, IWalletOuterInterfaceListener iWalletOuterInterfaceListener) {
        return BaiduWalletDelegate.getInstance().getWalletOuterInterface(context, iWalletOuterInterfaceListener);
    }

    public void gotoWalletService(Context context, String str, String str2) {
        BaiduWalletServiceController.getInstance().gotoWalletService(context, str, str2);
    }

    public void initWallet(Context context) {
        a((Application) DxmApplicationContextImpl.getApplicationContext(context));
        BaiduWalletDelegate.getInstance().initWallet(context);
        DxmPay.getInstance().initWallet(context);
    }

    public void invokeBdWalletNative(Activity activity, String str, String str2, ILightappInvokerCallback iLightappInvokerCallback) {
        BaiduWalletDelegate.getInstance().invokeBdWalletNative(activity, str, str2, iLightappInvokerCallback);
    }

    public void logout(Context context) {
        BaiduWalletDelegate.getInstance().logout(context);
        BaiduWalletDelegate.getInstance().logout(context);
    }

    public void openH5Module(Context context, String str, boolean z) {
        BaiduWalletDelegate.getInstance().openH5Module(context, str, z);
    }

    public void preOrderPay(Context context, String str, IPrecashierCallback iPrecashierCallback) {
        BaiduPayDelegate.getInstance().preOrderPay(context, str, iPrecashierCallback);
    }

    public void setDebugOn(Context context, boolean z) {
        BaiduWalletDelegate.getInstance().setDebugOn(context, z);
        BaiduWalletDelegate.getInstance().setDebugOn(context, z);
    }

    public boolean startWallet(Context context) {
        return BaiduWalletDelegate.getInstance().startWallet(context);
    }

    public BaiduWallet() {
    }

    public void doPay(Context context, String str, PayCallBack payCallBack, @NonNull Map<String, String> map) {
        BaiduPayDelegate.getInstance().doPay(context, str, payCallBack, map);
    }

    public void openH5Module(Context context, String str, boolean z, Bundle bundle) {
        BaiduWalletDelegate.getInstance().openH5Module(context, str, z, bundle);
    }

    public void initWallet(Context context, String str) {
        a((Application) DxmApplicationContextImpl.getApplicationContext(context));
        BaiduWalletDelegate.getInstance().initWallet(context, str);
        DxmPay.getInstance().initWallet(context, str);
    }

    public void initWallet(IWalletListener iWalletListener, Context context, String str) {
        a((Application) DxmApplicationContextImpl.getApplicationContext(context));
        BaiduWalletDelegate.getInstance().initWallet(iWalletListener, context, str);
        DxmPay.getInstance().initWallet(iWalletListener, context, str);
    }

    public void initWallet(IWalletListener iWalletListener, Context context, String str, ISecurityListener iSecurityListener) {
        a((Application) DxmApplicationContextImpl.getApplicationContext(context));
        BaiduWalletDelegate.getInstance().initWallet(iWalletListener, context, str, iSecurityListener);
        DxmPay.getInstance().initWallet(iWalletListener, context, str, iSecurityListener);
    }
}
