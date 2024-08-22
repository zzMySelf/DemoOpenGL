package com.baidu.searchbox.player.guide.config;

import java.lang.annotation.RetentionPolicy;
import java.util.List;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.Retention;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/player/guide/config/LongPressSpeedValue;", "", "Companion", "business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Retention(AnnotationRetention.SOURCE)
@java.lang.annotation.Retention(RetentionPolicy.SOURCE)
/* compiled from: LongPressSpeedConfig.kt */
public @interface LongPressSpeedValue {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final float LONG_PRESS_SPEED_1_5 = 1.5f;
    public static final float LONG_PRESS_SPEED_2 = 2.0f;
    public static final float LONG_PRESS_SPEED_3 = 3.0f;
    public static final float LONG_PRESS_SPEED_4 = 4.0f;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/player/guide/config/LongPressSpeedValue$Companion;", "", "()V", "LONG_PRESS_SPEED_1_5", "", "LONG_PRESS_SPEED_2", "LONG_PRESS_SPEED_3", "LONG_PRESS_SPEED_4", "longPressSpeedSortList", "", "getLongPressSpeedSortList", "()Ljava/util/List;", "business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LongPressSpeedConfig.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final float LONG_PRESS_SPEED_1_5 = 1.5f;
        public static final float LONG_PRESS_SPEED_2 = 2.0f;
        public static final float LONG_PRESS_SPEED_3 = 3.0f;
        public static final float LONG_PRESS_SPEED_4 = 4.0f;
        private static final List<Float> longPressSpeedSortList = CollectionsKt.mutableListOf(Float.valueOf(1.5f), Float.valueOf(2.0f), Float.valueOf(3.0f), Float.valueOf(4.0f));

        private Companion() {
        }

        public final List<Float> getLongPressSpeedSortList() {
            return longPressSpeedSortList;
        }
    }
}
