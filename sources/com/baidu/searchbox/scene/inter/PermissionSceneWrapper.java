package com.baidu.searchbox.scene.inter;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/scene/inter/PermissionSceneWrapper;", "", "()V", "currentPermissionState", "", "getCurrentPermissionState", "()Z", "setCurrentPermissionState", "(Z)V", "permissionSceneInfo", "Lcom/baidu/searchbox/scene/inter/PermissionSceneInfo;", "getPermissionSceneInfo", "()Lcom/baidu/searchbox/scene/inter/PermissionSceneInfo;", "setPermissionSceneInfo", "(Lcom/baidu/searchbox/scene/inter/PermissionSceneInfo;)V", "lib-oem-permission_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PermissionSceneWrapper.kt */
public final class PermissionSceneWrapper {
    private boolean currentPermissionState;
    private PermissionSceneInfo permissionSceneInfo;

    public final PermissionSceneInfo getPermissionSceneInfo() {
        return this.permissionSceneInfo;
    }

    public final void setPermissionSceneInfo(PermissionSceneInfo permissionSceneInfo2) {
        this.permissionSceneInfo = permissionSceneInfo2;
    }

    public final boolean getCurrentPermissionState() {
        return this.currentPermissionState;
    }

    public final void setCurrentPermissionState(boolean z) {
        this.currentPermissionState = z;
    }
}
