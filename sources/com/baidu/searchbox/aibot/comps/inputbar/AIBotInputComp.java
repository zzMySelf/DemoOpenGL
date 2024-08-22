package com.baidu.searchbox.aibot.comps.inputbar;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.baidu.searchbox.aibot.R;
import com.baidu.searchbox.aibot.comps.conversation.intercept.AIBotWebImageInterceptConfig;
import com.baidu.searchbox.aibot.repo.AIBotManifestModel;
import com.baidu.searchbox.aisearch.comps.input.AISearchInputComp;
import com.baidu.searchbox.aisearch.comps.input.AISearchInputConfig;
import com.baidu.searchbox.aisearch.comps.input.AISearchInputParams;
import com.baidu.searchbox.aisearch.comps.input.CameraConfig;
import com.baidu.searchbox.aisearch.utils.ResExtKt;
import com.baidu.searchbox.nacomp.extension.util.JSONExtKt;
import com.baidu.searchbox.nacomp.util.UniqueId;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u0012\u001a\u00020\u000eH\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007R\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001a"}, d2 = {"Lcom/baidu/searchbox/aibot/comps/inputbar/AIBotInputComp;", "Lcom/baidu/searchbox/aisearch/comps/input/AISearchInputComp;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "view", "Landroid/view/View;", "inputParams", "Lcom/baidu/searchbox/aisearch/comps/input/AISearchInputParams;", "inputConfig", "Lcom/baidu/searchbox/aisearch/comps/input/AISearchInputConfig;", "pageToken", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "(Landroidx/lifecycle/LifecycleOwner;Landroid/view/View;Lcom/baidu/searchbox/aisearch/comps/input/AISearchInputParams;Lcom/baidu/searchbox/aisearch/comps/input/AISearchInputConfig;Lcom/baidu/searchbox/nacomp/util/UniqueId;)V", "isAlreadyUpdateByFe", "", "()Z", "setAlreadyUpdateByFe", "(Z)V", "shouldShowCameraTips", "updateViewData", "", "source", "", "jsonObject", "Lorg/json/JSONObject;", "Companion", "lib-aibot-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AIBotInputComp.kt */
public final class AIBotInputComp extends AISearchInputComp {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String PARAMS_CAMERA_ENABLE = "vision";
    public static final String PARAMS_REFRESH_ENABLE = "refresh";
    public static final String PARAMS_TEXT_HINT = "placeholder";
    public static final String PARAMS_VOICE_ENABLE = "voice";
    private boolean isAlreadyUpdateByFe;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AIBotInputComp(LifecycleOwner owner, View view2, AISearchInputParams inputParams, AISearchInputConfig inputConfig, UniqueId pageToken) {
        super(owner, view2, inputParams, inputConfig, pageToken);
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(inputParams, "inputParams");
        Intrinsics.checkNotNullParameter(inputConfig, "inputConfig");
        Intrinsics.checkNotNullParameter(pageToken, "pageToken");
    }

    public final boolean isAlreadyUpdateByFe() {
        return this.isAlreadyUpdateByFe;
    }

    public final void setAlreadyUpdateByFe(boolean z) {
        this.isAlreadyUpdateByFe = z;
    }

    public boolean shouldShowCameraTips() {
        return false;
    }

    public final void updateViewData(String source, JSONObject jsonObject) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (jsonObject != null && !this.isAlreadyUpdateByFe) {
            if ((Intrinsics.areEqual((Object) source, (Object) AIBotManifestModel.SOURCE_FE) ? source : null) != null) {
                this.isAlreadyUpdateByFe = true;
            }
            updateInputConfig(new AISearchInputConfig(1, JSONExtKt.optStringIgnoreNulls(jsonObject, "placeholder", ResExtKt.getString(R.string.ai_bot_input_text_hint)), jsonObject.optBoolean("voice"), jsonObject.optBoolean(PARAMS_CAMERA_ENABLE), jsonObject.optBoolean("refresh", false), new CameraConfig(AIBotWebImageInterceptConfig.WEB_IMAGE_DIR_NAME)));
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/aibot/comps/inputbar/AIBotInputComp$Companion;", "", "()V", "PARAMS_CAMERA_ENABLE", "", "PARAMS_REFRESH_ENABLE", "PARAMS_TEXT_HINT", "PARAMS_VOICE_ENABLE", "lib-aibot-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AIBotInputComp.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
