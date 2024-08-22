package com.baidu.searchbox.widget.aiwidget.anim;

import android.content.Context;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import com.baidu.searchbox.widget.cache.WidgetSharePreferenceUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J6\u0010\f\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0016J&\u0010\u0011\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/widget/aiwidget/anim/AiWidgetAnimConfigListener;", "Lcom/baidu/searchbox/net/update/v2/JSONObjectCommandListener;", "()V", "addPostData", "", "context", "Landroid/content/Context;", "module", "", "action", "postData", "Lcom/baidu/searchbox/net/update/CommandPostData;", "executeCommand", "", "value", "Lcom/baidu/searchbox/net/update/v2/ActionData;", "Lorg/json/JSONObject;", "getLocalVersion", "Companion", "lib-widget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AiWidgetAnimConfigListener.kt */
public final class AiWidgetAnimConfigListener extends JSONObjectCommandListener {
    public static final String AI_WIDGET_ANIM_CONFIG_ACTION = "ai_widget_anim_config";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String DEFAULT_VERSION = "0";
    public static final String KEY_SP_AI_WIDGET_ANIM_CONFIG_DATA = "key_sp_ai_widget_anim_config_data";
    private static final String KEY_SP_AI_WIDGET_ANIM_CONFIG_VERSION = "key_sp_ai_widget_anim_config_version";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/widget/aiwidget/anim/AiWidgetAnimConfigListener$Companion;", "", "()V", "AI_WIDGET_ANIM_CONFIG_ACTION", "", "DEFAULT_VERSION", "KEY_SP_AI_WIDGET_ANIM_CONFIG_DATA", "KEY_SP_AI_WIDGET_ANIM_CONFIG_VERSION", "lib-widget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AiWidgetAnimConfigListener.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public void addPostData(Context context, String module, String action, CommandPostData postData) {
        JSONObject it;
        if (postData != null && (it = postData.getVersion()) != null) {
            it.put(AI_WIDGET_ANIM_CONFIG_ACTION, getLocalVersion(context, module, action));
        }
    }

    public boolean executeCommand(Context context, String module, String action, ActionData<JSONObject> value) {
        if ((value != null ? (JSONObject) value.data : null) == null || !Intrinsics.areEqual((Object) action, (Object) AI_WIDGET_ANIM_CONFIG_ACTION)) {
            return false;
        }
        ExecutorUtilsExt.postOnElastic(new AiWidgetAnimConfigListener$$ExternalSyntheticLambda0(value), "", 2);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: executeCommand$lambda-1  reason: not valid java name */
    public static final void m7623executeCommand$lambda1(ActionData $value) {
        WidgetSharePreferenceUtils.Companion.getInstance().putString(KEY_SP_AI_WIDGET_ANIM_CONFIG_DATA, ((JSONObject) $value.data).toString());
        WidgetSharePreferenceUtils.Companion.getInstance().putString(KEY_SP_AI_WIDGET_ANIM_CONFIG_VERSION, $value.version);
    }

    public String getLocalVersion(Context context, String module, String action) {
        String string = WidgetSharePreferenceUtils.Companion.getInstance().getString(KEY_SP_AI_WIDGET_ANIM_CONFIG_VERSION, "0");
        return string == null ? "0" : string;
    }
}
