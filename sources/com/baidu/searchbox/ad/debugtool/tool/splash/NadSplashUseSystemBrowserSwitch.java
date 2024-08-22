package com.baidu.searchbox.ad.debugtool.tool.splash;

import com.baidu.nadcore.unifiedtool.NadAbsCheckBoxTool;
import com.baidu.searchbox.feed.ad.ISplashUseSystemBrowserSwitch;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\f\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/ad/debugtool/tool/splash/NadSplashUseSystemBrowserSwitch;", "Lcom/baidu/nadcore/unifiedtool/NadAbsCheckBoxTool;", "Lcom/baidu/searchbox/feed/ad/ISplashUseSystemBrowserSwitch;", "()V", "clazz", "Ljava/lang/Class;", "describe", "", "getUseSystemBrowserSwitch", "", "lib-ad-debug_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadSplashUseSystemBrowserSwitch.kt */
public final class NadSplashUseSystemBrowserSwitch extends NadAbsCheckBoxTool implements ISplashUseSystemBrowserSwitch {
    public Class<?> clazz() {
        return ISplashUseSystemBrowserSwitch.class;
    }

    public String describe() {
        return "使用系统浏览器打开开屏落地页";
    }

    public boolean getUseSystemBrowserSwitch() {
        if (getDebug()) {
            return getState().isChecked();
        }
        return false;
    }
}
