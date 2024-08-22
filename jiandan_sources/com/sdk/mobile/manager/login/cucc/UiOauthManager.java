package com.sdk.mobile.manager.login.cucc;

import android.content.Context;
import android.net.ConnectivityManager;
import com.sdk.base.api.CallBack;
import com.sdk.base.api.OnCustomViewListener;
import com.sdk.base.api.UiOauthListener;
import com.sdk.base.framework.bean.OauthResultMode;
import com.sdk.base.module.manager.SDKManager;
import com.sdk.f.f;
import com.sdk.j.a;
import com.sdk.p.f;
import java.util.ArrayList;

public class UiOauthManager extends SDKManager {
    public static Boolean isDebug = Boolean.valueOf(f.a);
    public static volatile UiOauthManager manager;
    public String TAG = UiOauthManager.class.getSimpleName();
    public boolean cancel;
    public Context mContext;
    public com.sdk.y.f mHandler;
    public UiOauthListener oauthListener;
    public OnCustomViewListener otherLoginListener;
    public OauthResultMode resultMode;

    public UiOauthManager(Context context) {
        this.mContext = context;
    }

    private <T> void dispatchHandler(int i2, final CallBack<T> callBack) {
        new com.sdk.y.f(this.mContext, i2, new CallBack<T>() {
            public void onFailed(int i2, int i3, String str, String str2) {
                "onFailed code--->" + i2;
                "onFailed status--->" + i3;
                callBack.onFailed(i2, i3, str, str2);
            }

            public void onSuccess(int i2, String str, int i3, T t, String str2) {
                "onSuccess code--->" + i2;
                "onSuccess msg--->" + str;
                "onSuccess status--->" + i3;
                "onSuccess response--->" + t;
                if (i2 == 0) {
                    callBack.onSuccess(i2, str, i3, t, str2);
                }
                if (i2 == 1) {
                    callBack.onSuccess(i2, str, i3, null, str2);
                }
            }
        }).a(0);
    }

    public static UiOauthManager getInstance(Context context) {
        if (manager == null) {
            synchronized (UiOauthManager.class) {
                if (manager == null) {
                    manager = new UiOauthManager(context);
                }
            }
        }
        return manager;
    }

    public void cancel() {
        this.cancel = true;
    }

    public OnCustomViewListener getOtherLoginListener() {
        return this.otherLoginListener;
    }

    public <T> void login(int i2, CallBack<T> callBack) {
        int a = a.a();
        int a2 = com.sdk.p.f.a(this.mContext, (ArrayList<String>) null).a();
        if (a >= 23 || a2 == f.a.NET.a()) {
            com.sdk.y.f fVar = new com.sdk.y.f(this.mContext, i2, callBack);
            this.mHandler = fVar;
            fVar.a(0);
            return;
        }
        callBack.onFailed(102001, 1, "选择流量通道失败", "qcandroidabc000");
    }

    public void setOtherLoginListener(OnCustomViewListener onCustomViewListener) {
        this.otherLoginListener = onCustomViewListener;
    }

    public void unregisterNetworkCallback() {
        ConnectivityManager connectivityManager;
        ConnectivityManager.NetworkCallback networkCallback;
        com.sdk.y.f fVar = this.mHandler;
        if (fVar != null && (connectivityManager = fVar.j) != null && (networkCallback = com.sdk.y.f.c) != null) {
            connectivityManager.unregisterNetworkCallback(networkCallback);
            com.sdk.y.f.c = null;
        }
    }
}
