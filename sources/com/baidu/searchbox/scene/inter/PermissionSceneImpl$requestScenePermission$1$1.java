package com.baidu.searchbox.scene.inter;

import com.baidu.searchbox.scene.IScenePermissionCallback;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/scene/inter/PermissionSceneImpl$requestScenePermission$1$1", "Lcom/baidu/searchbox/scene/IScenePermissionCallback;", "onPermissionStateChange", "", "state", "", "lib-oem-permission_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PermissionSceneImpl.kt */
public final class PermissionSceneImpl$requestScenePermission$1$1 implements IScenePermissionCallback {
    final /* synthetic */ IScenePermissionCallback $callback;

    PermissionSceneImpl$requestScenePermission$1$1(IScenePermissionCallback $callback2) {
        this.$callback = $callback2;
    }

    public void onPermissionStateChange(boolean state) {
        this.$callback.onPermissionStateChange(state);
    }
}
