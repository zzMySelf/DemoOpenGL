package com.baidu.searchbox.aibot.config.conversation;

import android.util.Log;
import com.baidu.searchbox.aibot.comps.conversation.preload.AiBotPreloadSceneConfig;
import com.baidu.searchbox.aibot.utils.AIBotPrefs;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u000b\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010!\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\"\u001a\u00020\u0004H\u0002J\b\u0010#\u001a\u00020\nH\u0002J\b\u0010$\u001a\u00020\u0004H\u0002J\b\u0010%\u001a\u00020\nH\u0002J\b\u0010&\u001a\u00020\nH\u0002J\b\u0010'\u001a\u00020\nH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8FX\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u000f8FX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\b\u001a\u0004\b\u0014\u0010\u0006R\u001b\u0010\u0016\u001a\u00020\n8FX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\b\u001a\u0004\b\u0017\u0010\fR\u001b\u0010\u0019\u001a\u00020\n8FX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\b\u001a\u0004\b\u001a\u0010\fR\u001b\u0010\u001c\u001a\u00020\u001d8FX\u0002¢\u0006\f\n\u0004\b \u0010\b\u001a\u0004\b\u001e\u0010\u001f¨\u0006("}, d2 = {"Lcom/baidu/searchbox/aibot/config/conversation/AiBotConvConfig;", "", "()V", "preloadActivePeriod", "", "getPreloadActivePeriod", "()J", "preloadActivePeriod$delegate", "Lkotlin/Lazy;", "preloadActiveUsage", "", "getPreloadActiveUsage", "()I", "preloadActiveUsage$delegate", "preloadAiBotBaseUrl", "", "getPreloadAiBotBaseUrl", "()Ljava/lang/String;", "preloadAiBotBaseUrl$delegate", "preloadDelayTimeMs", "getPreloadDelayTimeMs", "preloadDelayTimeMs$delegate", "preloadScene", "getPreloadScene", "preloadScene$delegate", "preloadSwitch", "getPreloadSwitch", "preloadSwitch$delegate", "reloadWhenTerminate", "", "getReloadWhenTerminate", "()Z", "reloadWhenTerminate$delegate", "loadAiBotPreloadBaseUrl", "loadPreloadActivePeriod", "loadPreloadActiveUsage", "loadPreloadDelayTimeMs", "loadPreloadScene", "loadPreloadSwitch", "loadReloadWhenTerminate", "lib-aibot-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AiBotConvConfig.kt */
public final class AiBotConvConfig {
    public static final AiBotConvConfig INSTANCE = new AiBotConvConfig();
    private static final Lazy preloadActivePeriod$delegate = LazyKt.lazy(AiBotConvConfig$preloadActivePeriod$2.INSTANCE);
    private static final Lazy preloadActiveUsage$delegate = LazyKt.lazy(AiBotConvConfig$preloadActiveUsage$2.INSTANCE);
    private static final Lazy preloadAiBotBaseUrl$delegate = LazyKt.lazy(AiBotConvConfig$preloadAiBotBaseUrl$2.INSTANCE);
    private static final Lazy preloadDelayTimeMs$delegate = LazyKt.lazy(AiBotConvConfig$preloadDelayTimeMs$2.INSTANCE);
    private static final Lazy preloadScene$delegate = LazyKt.lazy(AiBotConvConfig$preloadScene$2.INSTANCE);
    private static final Lazy preloadSwitch$delegate = LazyKt.lazy(AiBotConvConfig$preloadSwitch$2.INSTANCE);
    private static final Lazy reloadWhenTerminate$delegate = LazyKt.lazy(AiBotConvConfig$reloadWhenTerminate$2.INSTANCE);

    private AiBotConvConfig() {
    }

    public final boolean getReloadWhenTerminate() {
        return ((Boolean) reloadWhenTerminate$delegate.getValue()).booleanValue();
    }

    public final int getPreloadSwitch() {
        return ((Number) preloadSwitch$delegate.getValue()).intValue();
    }

    public final int getPreloadScene() {
        return ((Number) preloadScene$delegate.getValue()).intValue();
    }

    public final String getPreloadAiBotBaseUrl() {
        return (String) preloadAiBotBaseUrl$delegate.getValue();
    }

    public final long getPreloadActivePeriod() {
        return ((Number) preloadActivePeriod$delegate.getValue()).longValue();
    }

    public final int getPreloadActiveUsage() {
        return ((Number) preloadActiveUsage$delegate.getValue()).intValue();
    }

    public final long getPreloadDelayTimeMs() {
        return ((Number) preloadDelayTimeMs$delegate.getValue()).longValue();
    }

    /* access modifiers changed from: private */
    public final int loadPreloadSwitch() {
        int i2 = AIBotPrefs.INSTANCE.getInt(AiBotConvConfigListenerKt.SP_PRELOAD_SWITCH, 1);
        int $this$loadPreloadSwitch_u24lambda_u2d0 = i2;
        if (AiBotConvConfigKt.DEBUG) {
            Log.d("AiBotConvConfig", "preload switch: " + $this$loadPreloadSwitch_u24lambda_u2d0);
        }
        return i2;
    }

    /* access modifiers changed from: private */
    public final int loadPreloadScene() {
        int i2 = AIBotPrefs.INSTANCE.getInt(AiBotConvConfigListenerKt.SP_AIBOT_PRELOAD_SCENE, AiBotPreloadSceneConfig.INSTANCE.getDEFAULT());
        int $this$loadPreloadScene_u24lambda_u2d1 = i2;
        if (AiBotConvConfigKt.DEBUG) {
            Log.d("AiBotConvConfig", "preload scene: " + $this$loadPreloadScene_u24lambda_u2d1);
        }
        return i2;
    }

    /* access modifiers changed from: private */
    public final String loadAiBotPreloadBaseUrl() {
        String string = AIBotPrefs.INSTANCE.getString(AiBotConvConfigListenerKt.SP_AIBOT_PRELOAD_URL, AiBotConvConfigKt.DEFAULT_AIBOT_PRELOAD_URL);
        String $this$loadAiBotPreloadBaseUrl_u24lambda_u2d2 = string;
        if (AiBotConvConfigKt.DEBUG) {
            Log.d("AiBotConvConfig", "preload base url: " + $this$loadAiBotPreloadBaseUrl_u24lambda_u2d2);
        }
        return string;
    }

    /* access modifiers changed from: private */
    public final long loadPreloadActivePeriod() {
        long j2 = AIBotPrefs.INSTANCE.getLong(AiBotConvConfigListenerKt.SP_PRELOAD_ACTIVE_PERIOD, 604800);
        long $this$loadPreloadActivePeriod_u24lambda_u2d3 = j2;
        if (AiBotConvConfigKt.DEBUG) {
            Log.d("AiBotConvConfig", "preload active period: " + $this$loadPreloadActivePeriod_u24lambda_u2d3);
        }
        return j2;
    }

    /* access modifiers changed from: private */
    public final int loadPreloadActiveUsage() {
        int i2 = AIBotPrefs.INSTANCE.getInt(AiBotConvConfigListenerKt.SP_PRELOAD_ACTIVE_USAGE, 1);
        int $this$loadPreloadActiveUsage_u24lambda_u2d4 = i2;
        if (AiBotConvConfigKt.DEBUG) {
            Log.d("AiBotConvConfig", "preload active usage: " + $this$loadPreloadActiveUsage_u24lambda_u2d4);
        }
        return i2;
    }

    /* access modifiers changed from: private */
    public final long loadPreloadDelayTimeMs() {
        long j2 = AIBotPrefs.INSTANCE.getLong(AiBotConvConfigListenerKt.SP_PRELOAD_DELAY_TIME_MS, 3000);
        long it = j2;
        if (AiBotConvConfigKt.DEBUG) {
            Log.d("AiBotConvConfig", "preload Delay Time in Ms: " + it);
        }
        return j2;
    }

    /* access modifiers changed from: private */
    public final int loadReloadWhenTerminate() {
        int i2 = AIBotPrefs.INSTANCE.getInt(AiBotConvConfigListenerKt.SP_RELOAD_WHEN_TERMINATE, 1);
        int $this$loadReloadWhenTerminate_u24lambda_u2d6 = i2;
        if (AiBotConvConfigKt.DEBUG) {
            Log.d("AiBotConvConfig", "reload when terminate: " + $this$loadReloadWhenTerminate_u24lambda_u2d6);
        }
        return i2;
    }
}
