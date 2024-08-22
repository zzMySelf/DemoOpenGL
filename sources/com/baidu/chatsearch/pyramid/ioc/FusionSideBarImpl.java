package com.baidu.chatsearch.pyramid.ioc;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.baidu.chatsearch.fusion.IFusionSideBar;
import com.baidu.chatsearch.fusion.IFusionSideBarContext;
import com.baidu.chatsearch.fusion.sidebar.FusionSideBarUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001c\u0010\t\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0012\u0010\u000f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\u0011"}, d2 = {"Lcom/baidu/chatsearch/pyramid/ioc/FusionSideBarImpl;", "Lcom/baidu/chatsearch/fusion/IFusionSideBar;", "()V", "closeSideBar", "", "activity", "Landroid/content/Context;", "scene", "", "openSideBar", "sideBarContext", "Lcom/baidu/chatsearch/fusion/IFusionSideBarContext;", "releaseSideBar", "", "requestNetData", "updateItemContent", "content", "lib-searchbox-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FusionSideBarImpl.kt */
public final class FusionSideBarImpl implements IFusionSideBar {
    public boolean openSideBar(Context activity, IFusionSideBarContext sideBarContext) {
        Activity curActivity = activity instanceof Activity ? (Activity) activity : null;
        if (curActivity == null) {
            return false;
        }
        return FusionSideBarUtils.INSTANCE.openSideBar(curActivity, (ViewGroup) null, sideBarContext);
    }

    public boolean closeSideBar(Context activity, String scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        Activity curActivity = activity instanceof Activity ? (Activity) activity : null;
        if (curActivity == null) {
            return false;
        }
        return FusionSideBarUtils.INSTANCE.closeSideBar(curActivity, scene);
    }

    public void releaseSideBar(Context activity) {
        Activity curActivity = activity instanceof Activity ? (Activity) activity : null;
        if (curActivity != null) {
            FusionSideBarUtils.INSTANCE.releaseSideBar(curActivity);
        }
    }

    public void updateItemContent(String content) {
        FusionSideBarUtils.INSTANCE.updateItemContent(content);
    }

    public void requestNetData() {
        FusionSideBarUtils.INSTANCE.requestNetData();
    }
}
