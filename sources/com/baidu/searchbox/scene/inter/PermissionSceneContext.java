package com.baidu.searchbox.scene.inter;

import com.baidu.pyramid.annotation.tekes.StableApi;
import kotlin.Metadata;

@StableApi
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\"\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH&¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/scene/inter/PermissionSceneContext;", "", "isAgent", "", "permission", "", "sceneID", "show", "", "weakGuide", "Lcom/baidu/searchbox/scene/inter/PermissionSceneView;", "lib-oem-permission_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PermissionSceneContext.kt */
public interface PermissionSceneContext {
    boolean isAgent(String str, String str2);

    void show(String str, String str2, PermissionSceneView permissionSceneView);
}
