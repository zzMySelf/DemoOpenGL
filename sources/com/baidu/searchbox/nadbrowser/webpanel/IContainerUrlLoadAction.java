package com.baidu.searchbox.nadbrowser.webpanel;

import com.baidu.nadcore.webpanel.proxy.IContainerContextHelper;

public interface IContainerUrlLoadAction {
    boolean handleUrlLoading(IContainerContextHelper iContainerContextHelper, String str);

    void notifyPageFinished(IContainerContextHelper iContainerContextHelper, String str);
}
