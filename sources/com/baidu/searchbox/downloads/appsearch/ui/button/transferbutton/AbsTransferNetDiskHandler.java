package com.baidu.searchbox.downloads.appsearch.ui.button.transferbutton;

import android.content.Context;
import com.baidu.searchbox.downloads.appsearch.helper.ToastMessageInfo;

public class AbsTransferNetDiskHandler implements ITransferNetDiskHandler {
    /* access modifiers changed from: protected */
    public Context mContext;
    protected String mTitle;
    protected AbsTransferNetDiskButton mTransferButton;
    protected String mUrl;

    public AbsTransferNetDiskHandler(Context context) {
        this.mContext = context;
    }

    public void setTransferNetDiskButton(AbsTransferNetDiskButton button) {
        this.mTransferButton = button;
    }

    public void setTransferNetDiskInfo(String url, String title) {
        this.mUrl = url;
        this.mTitle = title;
    }

    public void start() {
    }

    public void jump(String fsid, String savePath) {
    }

    public void show(String fsid, String savePath, ToastMessageInfo toastInfo) {
    }
}
