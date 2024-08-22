package com.baidu.searchbox.scene;

import com.baidu.pyramid.annotation.nps.PluginAccessible;
import com.baidu.pyramid.annotation.tekes.StableApi;
import kotlin.Metadata;

@StableApi
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/scene/IScenePermissionCallback;", "", "onPermissionStateChange", "", "state", "", "lib-oem-permission_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PluginAccessible
/* compiled from: IScenePermissionCallback.kt */
public interface IScenePermissionCallback {
    void onPermissionStateChange(boolean z);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IScenePermissionCallback.kt */
    public static final class DefaultImpls {
        public static void onPermissionStateChange(IScenePermissionCallback iScenePermissionCallback, boolean state) {
        }
    }
}
