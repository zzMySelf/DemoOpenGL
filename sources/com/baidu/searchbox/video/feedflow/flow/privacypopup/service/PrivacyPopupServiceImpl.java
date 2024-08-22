package com.baidu.searchbox.video.feedflow.flow.privacypopup.service;

import com.baidu.searchbox.video.feedflow.flow.privacypopup.PrivacyPopupPlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/privacypopup/service/PrivacyPopupServiceImpl;", "Lcom/baidu/searchbox/video/feedflow/flow/privacypopup/service/IPrivacyPopupService;", "plugin", "Lcom/baidu/searchbox/video/feedflow/flow/privacypopup/PrivacyPopupPlugin;", "(Lcom/baidu/searchbox/video/feedflow/flow/privacypopup/PrivacyPopupPlugin;)V", "getPlugin", "()Lcom/baidu/searchbox/video/feedflow/flow/privacypopup/PrivacyPopupPlugin;", "isShowing", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PrivacyPopupServiceImpl.kt */
public final class PrivacyPopupServiceImpl implements IPrivacyPopupService {
    private final PrivacyPopupPlugin plugin;

    public PrivacyPopupServiceImpl(PrivacyPopupPlugin plugin2) {
        Intrinsics.checkNotNullParameter(plugin2, "plugin");
        this.plugin = plugin2;
    }

    public final PrivacyPopupPlugin getPlugin() {
        return this.plugin;
    }

    public boolean isShowing() {
        return this.plugin.isShowing();
    }
}
