package com.baidu.searchbox.praise;

import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.Retention;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/praise/PraiseEffectType;", "", "Companion", "lib-praise-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Retention(AnnotationRetention.SOURCE)
@java.lang.annotation.Retention(RetentionPolicy.SOURCE)
/* compiled from: PraiseConstants.kt */
public @interface PraiseEffectType {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final String PRAISE_EFFECT_TYPE_DEFAULT = "default";
    public static final String PRAISE_EFFECT_TYPE_STRONG = "strong";
    public static final String PRAISE_EFFECT_TYPE_STRONG_HEART = "strong_heart";
    public static final String PRAISE_EFFECT_TYPE_WEAK = "weak";
    public static final String PRAISE_EFFECT_TYPE_WEAK_HEART = "weak_heart";

    @JvmStatic
    static String map(String str) {
        return Companion.map(str);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/praise/PraiseEffectType$Companion;", "", "()V", "PRAISE_EFFECT_TYPE_DEFAULT", "", "PRAISE_EFFECT_TYPE_STRONG", "PRAISE_EFFECT_TYPE_STRONG_HEART", "PRAISE_EFFECT_TYPE_WEAK", "PRAISE_EFFECT_TYPE_WEAK_HEART", "map", "h5Type", "lib-praise-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PraiseConstants.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String PRAISE_EFFECT_TYPE_DEFAULT = "default";
        public static final String PRAISE_EFFECT_TYPE_STRONG = "strong";
        public static final String PRAISE_EFFECT_TYPE_STRONG_HEART = "strong_heart";
        public static final String PRAISE_EFFECT_TYPE_WEAK = "weak";
        public static final String PRAISE_EFFECT_TYPE_WEAK_HEART = "weak_heart";

        private Companion() {
        }

        @JvmStatic
        public final String map(String h5Type) {
            if (Intrinsics.areEqual((Object) h5Type, (Object) "1")) {
                return "weak";
            }
            if (Intrinsics.areEqual((Object) h5Type, (Object) "2")) {
                return "strong";
            }
            return "default";
        }
    }
}
