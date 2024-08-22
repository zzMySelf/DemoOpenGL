package com.baidu.searchbox.widget.listener;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import com.baidu.searchbox.widget.cache.WidgetSharePreferenceUtils;
import com.baidu.searchbox.widget.config.WidgetAnimationConfigKt;
import com.baidu.searchbox.widget.debug.WidgetDebugKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J6\u0010\f\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0016J&\u0010\u0011\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/widget/listener/AnimationWidgetListener;", "Lcom/baidu/searchbox/net/update/v2/JSONObjectCommandListener;", "()V", "addPostData", "", "context", "Landroid/content/Context;", "module", "", "action", "postData", "Lcom/baidu/searchbox/net/update/CommandPostData;", "executeCommand", "", "value", "Lcom/baidu/searchbox/net/update/v2/ActionData;", "Lorg/json/JSONObject;", "getLocalVersion", "p0", "p1", "p2", "Companion", "lib-widget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AnimationWidgetListener.kt */
public final class AnimationWidgetListener extends JSONObjectCommandListener {
    private static final String ANIMATION_DELAY_MILLIS_WIDGET_ANIMATION_PLAY = "delay_miliss_widget_animation_play";
    private static final String ANIMATION_ENABLE_DXX_ANIMATION_PLAY = "enable_dxx_animation_play";
    private static final String ANIMATION_ENABLE_FOREGROUND_TO_BACKGROUND_REFRESH = "enable_foreground_to_background_refresh";
    private static final String ANIMATION_ENABLE_FOREGROUND_TO_BACKGROUND_REQUEST = "enable_foreground_to_background_request";
    private static final String ANIMATION_ENABLE_REGISTER_SCREEN = "enable_register_screen";
    private static final String ANIMATION_ENABLE_SCREEN_REFRESH = "enable_screen_refresh";
    private static final String ANIMATION_TOTAL_MILLIS_WIDGET_ANIMATION_PLAY = "total_miliss_widget_animation_play";
    public static final String ANIMATION_WIDGET_ACTION = "animation_widget";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String DEFAULT_VERSION = "0";
    private static final String KEY_SP_WIDGET_VERSION = "key_sp_animation_widget_version";

    public void addPostData(Context context, String module, String action, CommandPostData postData) {
        if ((postData != null ? postData.getVersion() : null) != null) {
            postData.getVersion().put(ANIMATION_WIDGET_ACTION, getLocalVersion(context, module, action));
        }
    }

    public boolean executeCommand(Context context, String module, String action, ActionData<JSONObject> value) {
        ActionData<JSONObject> actionData = value;
        if ((actionData != null ? (JSONObject) actionData.data : null) == null || !TextUtils.equals(action, ANIMATION_WIDGET_ACTION)) {
            return false;
        }
        boolean enableRegisterScreen = ((JSONObject) actionData.data).optBoolean(ANIMATION_ENABLE_REGISTER_SCREEN);
        boolean enableScreenRefresh = ((JSONObject) actionData.data).optBoolean(ANIMATION_ENABLE_SCREEN_REFRESH);
        boolean enableForToBackground = ((JSONObject) actionData.data).optBoolean(ANIMATION_ENABLE_FOREGROUND_TO_BACKGROUND_REFRESH);
        long delayWidgetAnimation = ((JSONObject) actionData.data).optLong(ANIMATION_DELAY_MILLIS_WIDGET_ANIMATION_PLAY);
        long totalWidgetAnimation = ((JSONObject) actionData.data).optLong(ANIMATION_TOTAL_MILLIS_WIDGET_ANIMATION_PLAY);
        boolean enableForToBackgroundRequestValue = ((JSONObject) actionData.data).optBoolean(ANIMATION_ENABLE_FOREGROUND_TO_BACKGROUND_REQUEST);
        boolean enableDxxAnimationPlay = ((JSONObject) actionData.data).optBoolean(ANIMATION_ENABLE_DXX_ANIMATION_PLAY);
        WidgetDebugKt.printLog(WidgetDebugKt.TAG_WIDGET_ANIMATION, StringsKt.trimIndent("\n            enableRegisterScreen = " + enableRegisterScreen + ",\n            enableScreenRefresh = " + enableScreenRefresh + ",\n            enableForToBackground = " + enableForToBackground + ",\n            delayWidgetAnimation = " + delayWidgetAnimation + ",\n            totalWidgetAnimation = " + totalWidgetAnimation + "\n            enableForToBackgroundRequestValue = " + enableForToBackgroundRequestValue + "\n            enableDxxAnimationPlay = " + enableDxxAnimationPlay + "\n        "));
        AnimationWidgetListener$$ExternalSyntheticLambda0 animationWidgetListener$$ExternalSyntheticLambda0 = r0;
        long j2 = totalWidgetAnimation;
        long j3 = delayWidgetAnimation;
        AnimationWidgetListener$$ExternalSyntheticLambda0 animationWidgetListener$$ExternalSyntheticLambda02 = new AnimationWidgetListener$$ExternalSyntheticLambda0(enableRegisterScreen, enableForToBackground, enableScreenRefresh, delayWidgetAnimation, totalWidgetAnimation, enableForToBackgroundRequestValue, enableDxxAnimationPlay, value);
        ExecutorUtilsExt.postOnElastic(animationWidgetListener$$ExternalSyntheticLambda0, "task_animation_widget", 2);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: executeCommand$lambda-0  reason: not valid java name */
    public static final void m7701executeCommand$lambda0(boolean $enableRegisterScreen, boolean $enableForToBackground, boolean $enableScreenRefresh, long $delayWidgetAnimation, long $totalWidgetAnimation, boolean $enableForToBackgroundRequestValue, boolean $enableDxxAnimationPlay, ActionData $value) {
        WidgetAnimationConfigKt.setEnableWidgetRegisterScreen($enableRegisterScreen);
        WidgetAnimationConfigKt.setEnableWidgetForToBackRefresh($enableForToBackground);
        WidgetAnimationConfigKt.setEnableWidgetScreenRefresh($enableScreenRefresh);
        WidgetAnimationConfigKt.setDelayWidgetAnimationPlay($delayWidgetAnimation);
        WidgetAnimationConfigKt.setTotalWidgetAnimationPlay($totalWidgetAnimation);
        WidgetAnimationConfigKt.setEnableForToBackgroundRequest($enableForToBackgroundRequestValue);
        WidgetAnimationConfigKt.setEnableWidgetDxxAnimationPlay($enableDxxAnimationPlay);
        WidgetSharePreferenceUtils.Companion.getInstance().putString(KEY_SP_WIDGET_VERSION, $value.version);
    }

    public String getLocalVersion(Context p0, String p1, String p2) {
        String string = WidgetSharePreferenceUtils.Companion.getInstance().getString(KEY_SP_WIDGET_VERSION, "0");
        return string == null ? "0" : string;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/widget/listener/AnimationWidgetListener$Companion;", "", "()V", "ANIMATION_DELAY_MILLIS_WIDGET_ANIMATION_PLAY", "", "ANIMATION_ENABLE_DXX_ANIMATION_PLAY", "ANIMATION_ENABLE_FOREGROUND_TO_BACKGROUND_REFRESH", "ANIMATION_ENABLE_FOREGROUND_TO_BACKGROUND_REQUEST", "ANIMATION_ENABLE_REGISTER_SCREEN", "ANIMATION_ENABLE_SCREEN_REFRESH", "ANIMATION_TOTAL_MILLIS_WIDGET_ANIMATION_PLAY", "ANIMATION_WIDGET_ACTION", "DEFAULT_VERSION", "KEY_SP_WIDGET_VERSION", "lib-widget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AnimationWidgetListener.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
