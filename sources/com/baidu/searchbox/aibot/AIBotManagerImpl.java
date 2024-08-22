package com.baidu.searchbox.aibot;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.searchbox.aibot.comps.conversation.preload.AiBotConversationPreloadManager;
import com.baidu.searchbox.aibot.comps.page.AIBotPageParams;
import com.baidu.searchbox.aibot.config.conversation.AiBotConvConfig;
import com.baidu.searchbox.aibot.config.global.AiBotGlobalConfig;
import com.baidu.searchbox.aibot.runtime.AIBotRuntime;
import com.baidu.searchbox.config.AppConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/aibot/AIBotManagerImpl;", "Lcom/baidu/searchbox/aibot/AIBotManager;", "()V", "launchAIBot", "", "context", "Landroid/content/Context;", "params", "Lcom/baidu/searchbox/aibot/AIBotLaunchParams;", "schedulePreload", "", "Lcom/baidu/searchbox/aibot/AIBotPreloadParams;", "schedulePreloadWithDelay", "lib-aibot-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AIBotManagerImpl.kt */
public final class AIBotManagerImpl implements AIBotManager {
    public boolean launchAIBot(Context context, AIBotLaunchParams params) {
        AIBotPageParams it;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        AIBotManagerImpl aIBotManagerImpl = this;
        AIBotManagerImpl aIBotManagerImpl2 = AiBotGlobalConfig.INSTANCE.getUseNAContainer() ? this : null;
        AIBotManagerImpl aIBotManagerImpl3 = aIBotManagerImpl2;
        if (aIBotManagerImpl2 == null || (it = AIBotPageParams.Companion.create(params)) == null) {
            return false;
        }
        return AIBotRuntime.INSTANCE.getRouter().launchAISearch(context, it);
    }

    public void schedulePreloadWithDelay(AIBotPreloadParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        long it = Math.max(AiBotConvConfig.INSTANCE.getPreloadDelayTimeMs(), 0);
        if (AppConfig.isDebug()) {
            Log.d("ConversationPreload", "schedulePreloadWithDelay " + it + "ms");
        }
        UiThreadUtils.runOnUiThread(new AIBotManagerImpl$$ExternalSyntheticLambda0(this, params), it);
    }

    /* access modifiers changed from: private */
    /* renamed from: schedulePreloadWithDelay$lambda-4$lambda-3  reason: not valid java name */
    public static final void m14833schedulePreloadWithDelay$lambda4$lambda3(AIBotManagerImpl this$0, AIBotPreloadParams $params) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($params, "$params");
        this$0.schedulePreload($params);
    }

    public void schedulePreload(AIBotPreloadParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        long start = SystemClock.elapsedRealtime();
        AiBotConversationPreloadManager.INSTANCE.schedulePreload(params);
        long end = SystemClock.elapsedRealtime();
        if (AppConfig.isDebug()) {
            Log.d("ConversationPreload", "schedulePreload cost " + (end - start) + "ms");
        }
    }
}
