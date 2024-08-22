package com.baidu.spswitch.pms.manager;

import com.baidu.spswitch.pms.channel.DanmakuEmotionEffectChannelKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/baidu/spswitch/pms/manager/DanmakuEmotionEffectAPSManager;", "Lcom/baidu/spswitch/pms/manager/CommentEmotionEffectAPSManager;", "()V", "getPackageName", "", "Companion", "emotion-keyboard_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DanmakuEmotionEffectAPSManager.kt */
public final class DanmakuEmotionEffectAPSManager extends CommentEmotionEffectAPSManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Lazy<DanmakuEmotionEffectAPSManager> instance$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, DanmakuEmotionEffectAPSManager$Companion$instance$2.INSTANCE);

    public /* synthetic */ DanmakuEmotionEffectAPSManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private DanmakuEmotionEffectAPSManager() {
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/baidu/spswitch/pms/manager/DanmakuEmotionEffectAPSManager$Companion;", "", "()V", "instance", "Lcom/baidu/spswitch/pms/manager/DanmakuEmotionEffectAPSManager;", "getInstance", "()Lcom/baidu/spswitch/pms/manager/DanmakuEmotionEffectAPSManager;", "instance$delegate", "Lkotlin/Lazy;", "emotion-keyboard_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DanmakuEmotionEffectAPSManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DanmakuEmotionEffectAPSManager getInstance() {
            return (DanmakuEmotionEffectAPSManager) DanmakuEmotionEffectAPSManager.instance$delegate.getValue();
        }
    }

    public String getPackageName() {
        return DanmakuEmotionEffectChannelKt.DANMAKU_EMOTION_EFFECT_APS_PACKAGE_NAME;
    }
}
