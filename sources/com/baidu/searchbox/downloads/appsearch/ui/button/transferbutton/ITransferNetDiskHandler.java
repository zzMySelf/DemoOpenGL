package com.baidu.searchbox.downloads.appsearch.ui.button.transferbutton;

import com.baidu.searchbox.downloads.appsearch.helper.ToastMessageInfo;

public interface ITransferNetDiskHandler {
    void jump(String str, String str2);

    void setTransferNetDiskButton(AbsTransferNetDiskButton absTransferNetDiskButton);

    void setTransferNetDiskInfo(String str, String str2);

    void show(String str, String str2, ToastMessageInfo toastMessageInfo);

    void start();
}
