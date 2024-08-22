package com.baidu.searchbox.live.nps.videoinsert;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.util.Log;
import android.view.KeyEvent;
import com.baidu.searchbox.live.host2live.video.ILiveActInterface;
import com.baidu.searchbox.live.host2live.video.ILiveItem;
import com.baidu.searchbox.live.host2live.video.IPreloadItem;
import com.baidu.searchbox.live.nps.LiveYYPluginManager;
import com.baidu.searchbox.live.nps.yyplugin.NpsHelperUtils;
import com.baidu.swan.apps.database.subscribe.SwanAppSubscribeMsgTable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\u0018\u0000 $2\u00020\u0001:\u0001$B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J.\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\"\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J-\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\t2\u000e\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u001f2\u0006\u0010 \u001a\u00020!H\u0016¢\u0006\u0002\u0010\"J\b\u0010#\u001a\u00020\u000fH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/baidu/searchbox/live/nps/videoinsert/YYActInterfaceWrap;", "Lcom/baidu/searchbox/live/host2live/video/ILiveActInterface;", "delegate", "(Lcom/baidu/searchbox/live/host2live/video/ILiveActInterface;)V", "getLiveItem", "Lcom/baidu/searchbox/live/host2live/video/ILiveItem;", "scheme", "", "position", "", "getPreloadItem", "Lcom/baidu/searchbox/live/host2live/video/IPreloadItem;", "extMap", "", "init", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onKeyDown", "", "keyCode", "event", "Landroid/view/KeyEvent;", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "release", "Companion", "lib-live_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: YYActInterfaceWrap.kt */
public final class YYActInterfaceWrap implements ILiveActInterface {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int OLD_TEMPLATE_VIDEO_INSERT_MIN_VER = 678000000;
    public static final String TEMPLATE_ID_NEW_ENT = "33554534";
    public static final String TEMPLATE_ID_NEW_GAME = "33554533";
    private final ILiveActInterface delegate;

    public YYActInterfaceWrap(ILiveActInterface delegate2) {
        this.delegate = delegate2;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/live/nps/videoinsert/YYActInterfaceWrap$Companion;", "", "()V", "OLD_TEMPLATE_VIDEO_INSERT_MIN_VER", "", "TEMPLATE_ID_NEW_ENT", "", "TEMPLATE_ID_NEW_GAME", "lib-live_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: YYActInterfaceWrap.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public ILiveItem getLiveItem(String scheme, int position) {
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        ILiveActInterface it = this.delegate;
        if (it == null) {
            return null;
        }
        if (NpsHelperUtils.getPluginInstallVersion() < 678000000) {
            String params = Uri.parse(scheme).getQueryParameter("params");
            if (params == null) {
                params = "{}";
            }
            Intrinsics.checkNotNullExpressionValue(params, "schemaUri.getQueryParameter(\"params\") ?: \"{}\"");
            try {
                String templateId = new JSONObject(params).getString(SwanAppSubscribeMsgTable.COLUMN_TEMPLATE_ID);
                if (!Intrinsics.areEqual((Object) templateId, (Object) TEMPLATE_ID_NEW_GAME) && !Intrinsics.areEqual((Object) templateId, (Object) TEMPLATE_ID_NEW_ENT)) {
                    LiveYYPluginManager.getInstance().log("old template");
                    return null;
                }
            } catch (Exception e2) {
                LiveYYPluginManager.getInstance().log("excpetion when parse json, " + Log.getStackTraceString(e2));
                return null;
            }
        }
        return it.getLiveItem(scheme, position);
    }

    public IPreloadItem getPreloadItem(String scheme, int position, Map<String, String> extMap) {
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        Intrinsics.checkNotNullParameter(extMap, "extMap");
        ILiveActInterface it = this.delegate;
        if (it == null) {
            return null;
        }
        try {
            return it.getPreloadItem(scheme, position, extMap);
        } catch (Throwable th2) {
            LiveYYPluginManager.getInstance().log("excpetion when getPreloadItem, " + Log.getStackTraceString(th2));
            return null;
        }
    }

    public void init() {
        ILiveActInterface iLiveActInterface = this.delegate;
        if (iLiveActInterface != null) {
            iLiveActInterface.init();
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        ILiveActInterface iLiveActInterface = this.delegate;
        if (iLiveActInterface != null) {
            iLiveActInterface.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void onConfigurationChanged(Configuration newConfig) {
        ILiveActInterface iLiveActInterface = this.delegate;
        if (iLiveActInterface != null) {
            iLiveActInterface.onConfigurationChanged(newConfig);
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        ILiveActInterface it = this.delegate;
        if (it != null) {
            return it.onKeyDown(keyCode, event);
        }
        return false;
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        ILiveActInterface iLiveActInterface = this.delegate;
        if (iLiveActInterface != null) {
            iLiveActInterface.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    public void release() {
        ILiveActInterface iLiveActInterface = this.delegate;
        if (iLiveActInterface != null) {
            iLiveActInterface.release();
        }
    }
}
