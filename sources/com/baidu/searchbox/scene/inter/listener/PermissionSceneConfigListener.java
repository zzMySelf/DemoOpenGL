package com.baidu.searchbox.scene.inter.listener;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import com.baidu.searchbox.permission.DangerousPermissionSpUtils;
import com.baidu.searchbox.scene.inter.PermissionSceneImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J6\u0010\f\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0016J&\u0010\u0011\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/scene/inter/listener/PermissionSceneConfigListener;", "Lcom/baidu/searchbox/net/update/v2/JSONObjectCommandListener;", "()V", "addPostData", "", "context", "Landroid/content/Context;", "module", "", "action", "postData", "Lcom/baidu/searchbox/net/update/CommandPostData;", "executeCommand", "", "actionData", "Lcom/baidu/searchbox/net/update/v2/ActionData;", "Lorg/json/JSONObject;", "getLocalVersion", "Companion", "lib-oem-permission_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PermissionSceneConfigListener.kt */
public final class PermissionSceneConfigListener extends JSONObjectCommandListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String DEFAULT_VERSION = "0";
    public static final String KEY_PERMISSION_SCENE_CONFIG_VERSION = "key_permission_scene_config_v2_version";
    public static final String KEY_SCENE_CONFIG = "sceneConfig";
    public static final String KEY_SP_PERMISSION_SCENE_CONFIG = "key_sp_permission_scene_config_v2";
    public static final String PERMISSION_SCENE_CONFIG_ACTION = "permission_scene_config";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/scene/inter/listener/PermissionSceneConfigListener$Companion;", "", "()V", "DEFAULT_VERSION", "", "KEY_PERMISSION_SCENE_CONFIG_VERSION", "KEY_SCENE_CONFIG", "KEY_SP_PERMISSION_SCENE_CONFIG", "PERMISSION_SCENE_CONFIG_ACTION", "lib-oem-permission_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PermissionSceneConfigListener.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public void addPostData(Context context, String module, String action, CommandPostData postData) {
        JSONObject versionObj;
        if (postData != null && (versionObj = postData.getVersion()) != null) {
            versionObj.put(PERMISSION_SCENE_CONFIG_ACTION, getLocalVersion(context, module, action));
        }
    }

    public boolean executeCommand(Context context, String module, String action, ActionData<JSONObject> actionData) {
        if ((actionData != null ? (JSONObject) actionData.data : null) == null || !Intrinsics.areEqual((Object) PERMISSION_SCENE_CONFIG_ACTION, (Object) action)) {
            return false;
        }
        DangerousPermissionSpUtils.getInstance().putString(KEY_PERMISSION_SCENE_CONFIG_VERSION, actionData.version);
        JSONArray sceneConfigArray = ((JSONObject) actionData.data).optJSONArray(KEY_SCENE_CONFIG);
        if (sceneConfigArray == null || sceneConfigArray.length() == 0) {
            return false;
        }
        String sceneConfigArrayStr = sceneConfigArray.toString();
        Intrinsics.checkNotNullExpressionValue(sceneConfigArrayStr, "sceneConfigArray.toString()");
        if (sceneConfigArrayStr.length() == 0) {
            return false;
        }
        if (AppConfig.isDebug()) {
            Log.d("PermissionScene", "sceneConfigArrayStr = " + sceneConfigArrayStr);
        }
        DangerousPermissionSpUtils.getInstance().putString(KEY_SP_PERMISSION_SCENE_CONFIG, sceneConfigArrayStr);
        PermissionSceneImpl.INSTANCE.parseScenePer$lib_oem_permission_release();
        PermissionSceneImpl.INSTANCE.handleUpGradeScene$lib_oem_permission_release("cssUpdate");
        return true;
    }

    public String getLocalVersion(Context context, String module, String action) {
        String string = DangerousPermissionSpUtils.getInstance().getString(KEY_PERMISSION_SCENE_CONFIG_VERSION, "0");
        return string == null ? "0" : string;
    }
}
