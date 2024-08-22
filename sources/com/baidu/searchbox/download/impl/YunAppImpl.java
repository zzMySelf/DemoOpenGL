package com.baidu.searchbox.download.impl;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.browser.ILightBrowser;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.download.ioc.IYunApp;
import com.baidu.searchbox.unitedscheme.BaseRouter;
import com.baidu.searchbox.util.Utility;

public class YunAppImpl implements IYunApp {
    public String getHashedString(String url) {
        return Utility.getHashedString(url);
    }

    public String encodeUrl(String url) {
        return Utility.encodeUrl(url);
    }

    public void openNetDiskHomePage(String panUrl) {
        ((ILightBrowser) ServiceManager.getService(ILightBrowser.SERVICE_REFERENCE)).open(AppRuntime.getAppContext(), UrlUtil.handleAbnormalUrlIfNeeded(panUrl), (String) null, false);
    }

    public void openNetDiskBySwan(String schema) {
        if (!TextUtils.isEmpty(schema)) {
            BaseRouter.invoke(AppRuntime.getAppContext(), schema);
        }
    }

    public void loadUrl(Context context, String url, boolean fromHome, boolean openInNewWindow) {
        Utility.loadUrl(context, url, fromHome, openInNewWindow);
    }
}
