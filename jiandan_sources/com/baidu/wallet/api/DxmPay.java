package com.baidu.wallet.api;

import android.app.Application;
import android.content.Context;
import com.baidu.wallet.fingerprint.DxmpayFingerprintManager;
import com.baidu.wallet.fingerprint.IPayBiometricCallback;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterProvider;
import com.dxmpay.wallet.api.BaiduWalletDelegate;
import com.dxmpay.wallet.core.utils.ReflectUtils;
import com.dxmpay.wallet.paysdk.PayUtils;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;

public class DxmPay {

    public static class a {
        public static final DxmPay a = new DxmPay();
    }

    private void a(Application application) {
        Object providerObject = ReflectUtils.getProviderObject("com.baidu.wallet.paysdk.entrance.DxmPaySDKProvider");
        if (providerObject != null && (providerObject instanceof RouterProvider)) {
            LocalRouter.getInstance(application).registerProvider("dxmPay", (RouterProvider) providerObject);
        }
        Object providerObject2 = ReflectUtils.getProviderObject("com.dxmpay.wallet.router.DxmPayServiceSDKProvider");
        if (providerObject2 != null && (providerObject2 instanceof RouterProvider)) {
            LocalRouter.getInstance(application).registerProvider("dxmPayService", (RouterProvider) providerObject2);
        }
        Object providerObject3 = ReflectUtils.getProviderObject("com.anyiht.mertool.entrance.EnterDxmMertoolServiceProvider");
        if (providerObject3 != null && (providerObject3 instanceof RouterProvider)) {
            LocalRouter.getInstance(application).registerProvider(EnterDxmPayServiceAction.MODULE_DXM_JUHE_APP_FUNCTION, (RouterProvider) providerObject3);
        }
    }

    public static DxmPay getInstance() {
        return a.a;
    }

    public void getDxmPayBiometricStatus(Context context, IPayBiometricCallback iPayBiometricCallback) {
        DxmpayFingerprintManager.getInstance().getDxmPayBiometric(context, iPayBiometricCallback);
    }

    public void initWallet(Context context) {
        a((Application) context.getApplicationContext());
        BaiduWalletDelegate.getInstance().initWallet(context);
    }

    public void setDxmOaid(String str) {
        PayUtils.setDxmOaid(str);
    }

    public DxmPay() {
    }

    public void initWallet(Context context, String str) {
        a((Application) context.getApplicationContext());
        BaiduWalletDelegate.getInstance().initWallet(context, str);
    }

    public void initWallet(IWalletListener iWalletListener, Context context, String str) {
        a((Application) context.getApplicationContext());
        BaiduWalletDelegate.getInstance().initWallet(iWalletListener, context, str);
    }

    public void initWallet(IWalletListener iWalletListener, Context context, String str, ISecurityListener iSecurityListener) {
        a((Application) context.getApplicationContext());
        BaiduWalletDelegate.getInstance().initWallet(iWalletListener, context, str, iSecurityListener);
    }
}
