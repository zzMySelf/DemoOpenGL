package androidx.core.transition;

import android.transition.Transition;
import com.baidu.searchbox.video.videoplayer.invoker.PluginInvokerConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\u001aÆ\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022#\b\u0006\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\b\u001a2\u0010\r\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\b\u001a2\u0010\u000f\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\b\u001a2\u0010\u0010\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\b\u001a2\u0010\u0011\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\b\u001a2\u0010\u0012\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\b¨\u0006\u0013"}, d2 = {"addListener", "Landroid/transition/Transition$TransitionListener;", "Landroid/transition/Transition;", "onEnd", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "transition", "", "onStart", "onCancel", "onResume", "onPause", "doOnCancel", "action", "doOnEnd", "doOnPause", "doOnResume", "doOnStart", "core-ktx_release"}, k = 2, mv = {1, 1, 16})
/* compiled from: Transition.kt */
public final class TransitionKt {
    public static final Transition.TransitionListener doOnEnd(Transition $this$doOnEnd, Function1<? super Transition, Unit> action) {
        Intrinsics.checkParameterIsNotNull($this$doOnEnd, "$this$doOnEnd");
        Intrinsics.checkParameterIsNotNull(action, "action");
        TransitionKt$doOnEnd$$inlined$addListener$1 listener$iv = new TransitionKt$doOnEnd$$inlined$addListener$1(action);
        $this$doOnEnd.addListener(listener$iv);
        return listener$iv;
    }

    public static final Transition.TransitionListener doOnStart(Transition $this$doOnStart, Function1<? super Transition, Unit> action) {
        Intrinsics.checkParameterIsNotNull($this$doOnStart, "$this$doOnStart");
        Intrinsics.checkParameterIsNotNull(action, "action");
        TransitionKt$doOnStart$$inlined$addListener$1 listener$iv = new TransitionKt$doOnStart$$inlined$addListener$1(action);
        $this$doOnStart.addListener(listener$iv);
        return listener$iv;
    }

    public static final Transition.TransitionListener doOnCancel(Transition $this$doOnCancel, Function1<? super Transition, Unit> action) {
        Intrinsics.checkParameterIsNotNull($this$doOnCancel, "$this$doOnCancel");
        Intrinsics.checkParameterIsNotNull(action, "action");
        TransitionKt$doOnCancel$$inlined$addListener$1 listener$iv = new TransitionKt$doOnCancel$$inlined$addListener$1(action);
        $this$doOnCancel.addListener(listener$iv);
        return listener$iv;
    }

    public static final Transition.TransitionListener doOnResume(Transition $this$doOnResume, Function1<? super Transition, Unit> action) {
        Intrinsics.checkParameterIsNotNull($this$doOnResume, "$this$doOnResume");
        Intrinsics.checkParameterIsNotNull(action, "action");
        TransitionKt$doOnResume$$inlined$addListener$1 listener$iv = new TransitionKt$doOnResume$$inlined$addListener$1(action);
        $this$doOnResume.addListener(listener$iv);
        return listener$iv;
    }

    public static final Transition.TransitionListener doOnPause(Transition $this$doOnPause, Function1<? super Transition, Unit> action) {
        Intrinsics.checkParameterIsNotNull($this$doOnPause, "$this$doOnPause");
        Intrinsics.checkParameterIsNotNull(action, "action");
        TransitionKt$doOnPause$$inlined$addListener$1 listener$iv = new TransitionKt$doOnPause$$inlined$addListener$1(action);
        $this$doOnPause.addListener(listener$iv);
        return listener$iv;
    }

    public static /* synthetic */ Transition.TransitionListener addListener$default(Transition $this$addListener, Function1 onEnd, Function1 onStart, Function1 onCancel, Function1 onResume, Function1 onPause, int i2, Object obj) {
        Function1 onStart2;
        Function1 onCancel2;
        Function1 onResume2;
        Function1 onPause2;
        if ((i2 & 1) != 0) {
            onEnd = TransitionKt$addListener$1.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            onStart2 = TransitionKt$addListener$2.INSTANCE;
        } else {
            onStart2 = onStart;
        }
        if ((i2 & 4) != 0) {
            onCancel2 = TransitionKt$addListener$3.INSTANCE;
        } else {
            onCancel2 = onCancel;
        }
        if ((i2 & 8) != 0) {
            onResume2 = TransitionKt$addListener$4.INSTANCE;
        } else {
            onResume2 = onResume;
        }
        if ((i2 & 16) != 0) {
            onPause2 = TransitionKt$addListener$5.INSTANCE;
        } else {
            onPause2 = onPause;
        }
        Intrinsics.checkParameterIsNotNull($this$addListener, "$this$addListener");
        Intrinsics.checkParameterIsNotNull(onEnd, "onEnd");
        Intrinsics.checkParameterIsNotNull(onStart2, "onStart");
        Intrinsics.checkParameterIsNotNull(onCancel2, "onCancel");
        Intrinsics.checkParameterIsNotNull(onResume2, PluginInvokerConstants.METHOD_ACTIVITY_ONRESUME);
        Intrinsics.checkParameterIsNotNull(onPause2, "onPause");
        TransitionKt$addListener$listener$1 listener = new TransitionKt$addListener$listener$1(onEnd, onResume2, onPause2, onCancel2, onStart2);
        $this$addListener.addListener(listener);
        return listener;
    }

    public static final Transition.TransitionListener addListener(Transition $this$addListener, Function1<? super Transition, Unit> onEnd, Function1<? super Transition, Unit> onStart, Function1<? super Transition, Unit> onCancel, Function1<? super Transition, Unit> onResume, Function1<? super Transition, Unit> onPause) {
        Intrinsics.checkParameterIsNotNull($this$addListener, "$this$addListener");
        Intrinsics.checkParameterIsNotNull(onEnd, "onEnd");
        Intrinsics.checkParameterIsNotNull(onStart, "onStart");
        Intrinsics.checkParameterIsNotNull(onCancel, "onCancel");
        Intrinsics.checkParameterIsNotNull(onResume, PluginInvokerConstants.METHOD_ACTIVITY_ONRESUME);
        Intrinsics.checkParameterIsNotNull(onPause, "onPause");
        TransitionKt$addListener$listener$1 transitionKt$addListener$listener$1 = new TransitionKt$addListener$listener$1(onEnd, onResume, onPause, onCancel, onStart);
        $this$addListener.addListener(transitionKt$addListener$listener$1);
        return transitionKt$addListener$listener$1;
    }
}
