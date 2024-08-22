package com.baidu.chatsearch.extensions;

import android.animation.Animator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a¤\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022#\b\u0006\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\f"}, d2 = {"addListenerExt", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "onEnd", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "animator", "", "onStart", "onCancel", "onRepeat", "lib-chatsearch-utils_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Animator.kt */
public final class AnimatorKt {
    public static /* synthetic */ Animator.AnimatorListener addListenerExt$default(Animator $this$addListenerExt_u24default, Function1 onEnd, Function1 onStart, Function1 onCancel, Function1 onRepeat, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            onEnd = AnimatorKt$addListenerExt$1.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            onStart = AnimatorKt$addListenerExt$2.INSTANCE;
        }
        if ((i2 & 4) != 0) {
            onCancel = AnimatorKt$addListenerExt$3.INSTANCE;
        }
        if ((i2 & 8) != 0) {
            onRepeat = AnimatorKt$addListenerExt$4.INSTANCE;
        }
        Intrinsics.checkNotNullParameter($this$addListenerExt_u24default, "<this>");
        Intrinsics.checkNotNullParameter(onEnd, "onEnd");
        Intrinsics.checkNotNullParameter(onStart, "onStart");
        Intrinsics.checkNotNullParameter(onCancel, "onCancel");
        Intrinsics.checkNotNullParameter(onRepeat, "onRepeat");
        AnimatorKt$addListenerExt$listener$1 listener = new AnimatorKt$addListenerExt$listener$1(onRepeat, onEnd, onCancel, onStart);
        $this$addListenerExt_u24default.addListener(listener);
        return listener;
    }

    public static final Animator.AnimatorListener addListenerExt(Animator $this$addListenerExt, Function1<? super Animator, Unit> onEnd, Function1<? super Animator, Unit> onStart, Function1<? super Animator, Unit> onCancel, Function1<? super Animator, Unit> onRepeat) {
        Intrinsics.checkNotNullParameter($this$addListenerExt, "<this>");
        Intrinsics.checkNotNullParameter(onEnd, "onEnd");
        Intrinsics.checkNotNullParameter(onStart, "onStart");
        Intrinsics.checkNotNullParameter(onCancel, "onCancel");
        Intrinsics.checkNotNullParameter(onRepeat, "onRepeat");
        AnimatorKt$addListenerExt$listener$1 listener = new AnimatorKt$addListenerExt$listener$1(onRepeat, onEnd, onCancel, onStart);
        $this$addListenerExt.addListener(listener);
        return listener;
    }
}
