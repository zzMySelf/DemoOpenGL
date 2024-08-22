package com.dxmpay.wallet.passport;

import android.content.Context;
import com.baidu.wallet.api.ILoginBackListener;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.core.NoProguard;
import java.lang.ref.WeakReference;

public class LoginBackListenerProxy implements ILoginBackListener, NoProguard {
    public ILoginBackListener loginBackListener;
    public WeakReference<Context> mContext;

    public LoginBackListenerProxy(Context context, ILoginBackListener iLoginBackListener) {
        this.mContext = new WeakReference<>(context);
        this.loginBackListener = iLoginBackListener;
    }

    public Context getContext() {
        WeakReference<Context> weakReference = this.mContext;
        if (weakReference == null) {
            return null;
        }
        return (Context) weakReference.get();
    }

    public ILoginBackListener getLoginBackListener() {
        return this.loginBackListener;
    }

    public void onFail(int i2, String str) {
        ILoginBackListener iLoginBackListener = this.loginBackListener;
        if (iLoginBackListener != null) {
            iLoginBackListener.onFail(i2, str);
        }
    }

    public void onSuccess(int i2, String str) {
        if (this.loginBackListener != null) {
            WalletLoginHelper.getInstance().getOpenBduss(true, this);
        }
    }
}
