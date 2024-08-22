package com.baidu.searchbox.aisearch.abtest;

import com.baidu.searchbox.aisearch.store.AISearchHostDebugStore;
import com.baidu.searchbox.config.AppConfig;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.Retention;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/aisearch/abtest/AISearchBeeSwitch;", "", "Companion", "lib-aisearch-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Retention(AnnotationRetention.SOURCE)
@java.lang.annotation.Retention(RetentionPolicy.SOURCE)
/* compiled from: AISearchBeeSwitch.kt */
public @interface AISearchBeeSwitch {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final int DISABLED = 0;
    public static final int ENABLE = 1;
    public static final int FOLLOW_AB = -1;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/aisearch/abtest/AISearchBeeSwitch$Companion;", "", "()V", "DISABLED", "", "ENABLE", "FOLLOW_AB", "enableAiSearchBeeSwitch", "", "lib-aisearch-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AISearchBeeSwitch.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int DISABLED = 0;
        public static final int ENABLE = 1;
        public static final int FOLLOW_AB = -1;

        private Companion() {
        }

        public final boolean enableAiSearchBeeSwitch() {
            if (!AppConfig.isDebug()) {
                return AbtestConfig.INSTANCE.getBeeSwitch() == 1;
            }
            int debugSwitch = AISearchHostDebugStore.INSTANCE.getEnableBeeSwitch();
            if (debugSwitch == -1) {
                if (AbtestConfig.INSTANCE.getBeeSwitch() == 1) {
                    return true;
                }
                return false;
            } else if (debugSwitch == 0) {
                return true;
            } else {
                return false;
            }
        }
    }
}
