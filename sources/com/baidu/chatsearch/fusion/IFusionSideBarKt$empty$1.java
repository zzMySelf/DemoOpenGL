package com.baidu.chatsearch.fusion;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001c\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0012\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u0010"}, d2 = {"com/baidu/chatsearch/fusion/IFusionSideBarKt$empty$1", "Lcom/baidu/chatsearch/fusion/IFusionSideBar;", "closeSideBar", "", "activity", "Landroid/content/Context;", "scene", "", "openSideBar", "sideBarContext", "Lcom/baidu/chatsearch/fusion/IFusionSideBarContext;", "releaseSideBar", "", "requestNetData", "updateItemContent", "content", "lib-chatsearch-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IFusionSideBar.kt */
public final class IFusionSideBarKt$empty$1 implements IFusionSideBar {
    IFusionSideBarKt$empty$1() {
    }

    public boolean openSideBar(Context activity, IFusionSideBarContext sideBarContext) {
        return false;
    }

    public boolean closeSideBar(Context activity, String scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        return false;
    }

    public void releaseSideBar(Context activity) {
    }

    public void updateItemContent(String content) {
    }

    public void requestNetData() {
    }
}
