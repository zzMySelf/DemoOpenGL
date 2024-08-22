package com.baidu.searchbox.bigimage.comp.page.image;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/bigimage/comp/page/image/AnimationCallback;", "", "onEnterAnimEnd", "", "type", "Lcom/baidu/searchbox/bigimage/comp/page/image/AnimationType;", "onEnterAnimStart", "onExitAnimEnd", "onExitAnimStart", "lib-search-bigimage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AnimationCallback.kt */
public interface AnimationCallback {
    void onEnterAnimEnd(AnimationType animationType);

    void onEnterAnimStart(AnimationType animationType);

    void onExitAnimEnd(AnimationType animationType);

    void onExitAnimStart(AnimationType animationType);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AnimationCallback.kt */
    public static final class DefaultImpls {
        public static void onEnterAnimStart(AnimationCallback animationCallback, AnimationType type) {
            Intrinsics.checkNotNullParameter(type, "type");
        }

        public static void onEnterAnimEnd(AnimationCallback animationCallback, AnimationType type) {
            Intrinsics.checkNotNullParameter(type, "type");
        }

        public static void onExitAnimStart(AnimationCallback animationCallback, AnimationType type) {
            Intrinsics.checkNotNullParameter(type, "type");
        }

        public static void onExitAnimEnd(AnimationCallback animationCallback, AnimationType type) {
            Intrinsics.checkNotNullParameter(type, "type");
        }
    }
}
