package com.baidu.wallet.api;

import android.content.Context;

public interface IWalletCreditFacade {

    public interface Callback {
        void onResult(boolean z, String str);
    }

    void getUserFinancialInfo(Context context, Callback callback);
}
