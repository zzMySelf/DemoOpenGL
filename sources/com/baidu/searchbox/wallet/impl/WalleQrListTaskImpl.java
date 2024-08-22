package com.baidu.searchbox.wallet.impl;

import android.content.Context;
import com.baidu.searchbox.ioc.IWalletQrListTask;
import com.baidu.searchbox.net.common.IResponseHandler;
import com.baidu.searchbox.wallet.WalletQrListTask;
import com.baidu.searchbox.wallet.data.WalletQrList;

public class WalleQrListTaskImpl implements IWalletQrListTask {
    public boolean isVersionReset(Context context) {
        return WalletQrListTask.isVersionReset(context);
    }

    public void setVersionToSP(Context context, int version) {
        WalletQrListTask.setVersionToSP(context, version);
    }

    public void setVersionChange(Context context, boolean change) {
        WalletQrListTask.setVersionChange(context, change);
    }

    public void setCallbackAndExecute(IResponseHandler.ResponseCallback<WalletQrList> callback, Context context) {
        WalletQrListTask task = new WalletQrListTask(WalletQrListTask.getVersionFromSP(context));
        task.setCallback(callback);
        task.execute();
    }

    public int getVersionFromSP(Context context) {
        return WalletQrListTask.getVersionFromSP(context);
    }
}
