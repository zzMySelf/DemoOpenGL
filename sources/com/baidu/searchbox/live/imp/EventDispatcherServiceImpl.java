package com.baidu.searchbox.live.imp;

import android.util.Log;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.live.interfaces.LiveConstants;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import com.baidu.searchbox.live.interfaces.service.EventDispatcherService;
import com.baidu.searchbox.nps.live.R;
import com.baidu.webkit.sdk.WebView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/live/imp/EventDispatcherServiceImpl;", "Lcom/baidu/searchbox/live/interfaces/service/EventDispatcherService;", "()V", "isDebug", "", "tag", "", "onEvent", "", "key", "params", "", "", "lib-feed-live_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EventDispatcherServiceImpl.kt */
public final class EventDispatcherServiceImpl implements EventDispatcherService {
    private final boolean isDebug;
    private final String tag = DI.LIVE_EVENT_DISPATCHER;

    public EventDispatcherServiceImpl() {
        AppInfoService appInfoService = (AppInfoService) ServiceManager.getService(AppInfoService.Companion.getSERVICE_REFERENCE());
        this.isDebug = appInfoService != null ? appInfoService.isDebug() : false;
    }

    public void onEvent(String key, Map<String, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(key, "key");
        switch (key.hashCode()) {
            case -1269274975:
                if (key.equals(LiveConstants.SdkToHostEvents.SUB_COMPONENT_START)) {
                    UniversalToast.makeText(AppRuntime.getAppContext(), R.string.liveshow_plugin_installing).setDuration(6).showHighLoadingToast();
                    return;
                }
                return;
            case -1178396113:
                if (key.equals("yy_mem_presure")) {
                    if (this.isDebug) {
                        Log.d(this.tag, "onMemoryPresure");
                    }
                    WebView.onMemoryPresure();
                    return;
                }
                return;
            case -251613478:
                if (key.equals(LiveConstants.SdkToHostEvents.SUB_COMPONENT_END)) {
                    UniversalToast.cancelToast();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
