package com.baidu.searchbox.radio.ttsfloatingwindow;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.View;
import com.baidu.nps.main.manager.Bundle;
import java.lang.ref.WeakReference;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/radio/ttsfloatingwindow/TTSFloatingWindow;", "", "()V", "Builder", "Companion", "lib-bdmedia-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TTSFloatingWindow.kt */
public final class TTSFloatingWindow {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static WeakReference<Activity> activityWeakReference;
    /* access modifiers changed from: private */
    public static boolean isDebug;
    /* access modifiers changed from: private */
    public static boolean isInitialized;
    /* access modifiers changed from: private */
    public static Pair<Integer, Integer> lastPosition;

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0010\u001a\u00020\u0011J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0006\u001a\u00020\u0007J\u0018\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u000bJ\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bR\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R(\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/baidu/searchbox/radio/ttsfloatingwindow/TTSFloatingWindow$Companion;", "", "()V", "activityWeakReference", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "isDebug", "", "isInitialized", "lastPosition", "Lkotlin/Pair;", "", "getLastPosition", "()Lkotlin/Pair;", "setLastPosition", "(Lkotlin/Pair;)V", "dismissAppFloating", "", "init", "application", "Landroid/app/Application;", "setWindowWidth", "width", "x", "with", "Lcom/baidu/searchbox/radio/ttsfloatingwindow/TTSFloatingWindow$Builder;", "activity", "Landroid/content/Context;", "lib-bdmedia-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TTSFloatingWindow.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Pair<Integer, Integer> getLastPosition() {
            return TTSFloatingWindow.lastPosition;
        }

        public final void setLastPosition(Pair<Integer, Integer> pair) {
            TTSFloatingWindow.lastPosition = pair;
        }

        public static /* synthetic */ void init$default(Companion companion, Application application, boolean z, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                z = false;
            }
            companion.init(application, z);
        }

        public final void init(Application application, boolean isDebug) {
            Intrinsics.checkNotNullParameter(application, "application");
            TTSFloatingWindow.isDebug = isDebug;
            TTSFloatingWindow.isInitialized = true;
            ActivityCount.INSTANCE.setAppLifecycle(application);
        }

        public final Builder with(Context activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (activity instanceof Activity) {
                TTSFloatingWindow.activityWeakReference = new WeakReference(activity);
            }
            return new Builder(activity);
        }

        public final void dismissAppFloating() {
            FloatingWindowFactory.INSTANCE.dismissAppFloating();
        }

        public static /* synthetic */ void setWindowWidth$default(Companion companion, int i2, int i3, int i4, Object obj) {
            if ((i4 & 2) != 0) {
                i3 = 0;
            }
            companion.setWindowWidth(i2, i3);
        }

        public final void setWindowWidth(int width, int x) {
            FloatingWindowFactory.INSTANCE.setWindowWidth(width, x);
        }
    }

    @Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\bH\u0002J\b\u0010\u000e\u001a\u00020\bH\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0002J\u0016\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\fJ'\u0010!\u001a\u00020\u00002\u001a\u0010\"\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030$0#\"\u0006\u0012\u0002\b\u00030$¢\u0006\u0002\u0010%J\"\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u00142\b\b\u0002\u0010(\u001a\u00020\u00142\b\b\u0002\u0010)\u001a\u00020\u0014J\u0010\u0010*\u001a\u00020\u00002\b\u0010+\u001a\u0004\u0018\u00010,J\u001a\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\u00142\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,J\u001a\u0010/\u001a\u00020\u00002\b\b\u0002\u00100\u001a\u00020\f2\b\b\u0002\u00101\u001a\u00020\fJ\u000e\u00102\u001a\u00020\u00002\u0006\u00103\u001a\u000204J\u000e\u00105\u001a\u00020\u00002\u0006\u00106\u001a\u000207J\u000e\u00108\u001a\u00020\u00002\u0006\u00109\u001a\u00020:J\u0006\u0010;\u001a\u00020\bJ\u0006\u0010<\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/baidu/searchbox/radio/ttsfloatingwindow/TTSFloatingWindow$Builder;", "Lcom/baidu/searchbox/radio/ttsfloatingwindow/IOverlayPermissionResult;", "activity", "Landroid/content/Context;", "(Landroid/content/Context;)V", "config", "Lcom/baidu/searchbox/radio/ttsfloatingwindow/FloatingWindowConfig;", "callbackCreateFailed", "", "reason", "", "checkUninitialized", "", "createActivityFloatingWindow", "createAppFloatingWindow", "permissionResult", "isOpen", "requestPermission", "setAnchorPair", "x", "", "y", "setAppFloatingWindowAnimation", "animation", "Lcom/baidu/searchbox/radio/ttsfloatingwindow/IFloatingWindowAnimation;", "setContent", "view", "Landroid/view/View;", "setDisplayHeight", "displayHeight", "Lcom/baidu/searchbox/radio/ttsfloatingwindow/IDisplayHeight;", "setDragEnable", "dragEnable", "setFilter", "clazz", "", "Ljava/lang/Class;", "([Ljava/lang/Class;)Lcom/baidu/searchbox/radio/ttsfloatingwindow/TTSFloatingWindow$Builder;", "setGravity", "gravity", "offsetX", "offsetY", "setInvokeListener", "contentViewClickListener", "Lcom/baidu/searchbox/radio/ttsfloatingwindow/IContentViewClickListener;", "setLayout", "layoutId", "setMatchParent", "widthMatch", "heightMatch", "setShowPattern", "showPattern", "Lcom/baidu/searchbox/radio/ttsfloatingwindow/ShowStrategy;", "setSidePattern", "sideStrategy", "Lcom/baidu/searchbox/radio/ttsfloatingwindow/SideStrategy;", "setStatusListener", "listener", "Lcom/baidu/searchbox/radio/ttsfloatingwindow/IFloatingWindowListener;", "show", "showV1", "lib-bdmedia-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TTSFloatingWindow.kt */
    public static final class Builder implements IOverlayPermissionResult {
        private final Context activity;
        private final FloatingWindowConfig config = new FloatingWindowConfig();

        public Builder(Context activity2) {
            Intrinsics.checkNotNullParameter(activity2, "activity");
            this.activity = activity2;
        }

        public final Builder setSidePattern(SideStrategy sideStrategy) {
            Intrinsics.checkNotNullParameter(sideStrategy, "sideStrategy");
            this.config.setSideStrategy(sideStrategy);
            return this;
        }

        public final Builder setShowPattern(ShowStrategy showPattern) {
            Intrinsics.checkNotNullParameter(showPattern, "showPattern");
            this.config.setShowPattern(showPattern);
            return this;
        }

        public static /* synthetic */ Builder setLayout$default(Builder builder, int i2, IContentViewClickListener iContentViewClickListener, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                iContentViewClickListener = null;
            }
            return builder.setLayout(i2, iContentViewClickListener);
        }

        public final Builder setLayout(int layoutId, IContentViewClickListener contentViewClickListener) {
            Builder $this$setLayout_u24lambda_u2d2 = this;
            $this$setLayout_u24lambda_u2d2.config.setLayoutId(Integer.valueOf(layoutId));
            $this$setLayout_u24lambda_u2d2.config.setContentViewClickListener(contentViewClickListener);
            return this;
        }

        public final Builder setContent(View view2) {
            Intrinsics.checkNotNullParameter(view2, "view");
            this.config.setContent(view2);
            return this;
        }

        public final Builder setInvokeListener(IContentViewClickListener contentViewClickListener) {
            this.config.setContentViewClickListener(contentViewClickListener);
            return this;
        }

        public static /* synthetic */ Builder setGravity$default(Builder builder, int i2, int i3, int i4, int i5, Object obj) {
            if ((i5 & 2) != 0) {
                i3 = 0;
            }
            if ((i5 & 4) != 0) {
                i4 = 0;
            }
            return builder.setGravity(i2, i3, i4);
        }

        public final Builder setGravity(int gravity, int offsetX, int offsetY) {
            Builder $this$setGravity_u24lambda_u2d5 = this;
            $this$setGravity_u24lambda_u2d5.config.setGravity(gravity);
            $this$setGravity_u24lambda_u2d5.config.setOffsetPair(new Pair(Integer.valueOf(offsetX), Integer.valueOf(offsetY)));
            return this;
        }

        public final Builder setAnchorPair(int x, int y) {
            Builder $this$setAnchorPair_u24lambda_u2d7 = this;
            $this$setAnchorPair_u24lambda_u2d7.config.setAnchorPair(new Pair(Integer.valueOf(x), Integer.valueOf(y)));
            Pair it = TTSFloatingWindow.Companion.getLastPosition();
            if (it != null) {
                $this$setAnchorPair_u24lambda_u2d7.config.setAnchorPair(it);
            }
            return this;
        }

        public final Builder setDragEnable(boolean dragEnable) {
            this.config.setDragEnable(dragEnable);
            return this;
        }

        public final Builder setAppFloatingWindowAnimation(IFloatingWindowAnimation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            this.config.setFloatingWindowAnimation(animation);
            return this;
        }

        public final Builder setDisplayHeight(IDisplayHeight displayHeight) {
            Intrinsics.checkNotNullParameter(displayHeight, "displayHeight");
            this.config.setDisplayHeight(displayHeight);
            return this;
        }

        public static /* synthetic */ Builder setMatchParent$default(Builder builder, boolean z, boolean z2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z = false;
            }
            if ((i2 & 2) != 0) {
                z2 = false;
            }
            return builder.setMatchParent(z, z2);
        }

        public final Builder setMatchParent(boolean widthMatch, boolean heightMatch) {
            Builder $this$setMatchParent_u24lambda_u2d11 = this;
            $this$setMatchParent_u24lambda_u2d11.config.setWidthMatch(widthMatch);
            $this$setMatchParent_u24lambda_u2d11.config.setHeightMatch(heightMatch);
            return this;
        }

        public final Builder setFilter(Class<?>... clazz) {
            Intrinsics.checkNotNullParameter(clazz, Bundle.EXTRA_KEY_CLAZZ);
            Builder $this$setFilter_u24lambda_u2d13 = this;
            for (Class it : clazz) {
                Set<String> filterSet = $this$setFilter_u24lambda_u2d13.config.getFilterSet();
                String name = it.getName();
                Intrinsics.checkNotNullExpressionValue(name, "it.name");
                filterSet.add(name);
                if (($this$setFilter_u24lambda_u2d13.activity instanceof Activity) && Intrinsics.areEqual((Object) it.getName(), (Object) ((Activity) $this$setFilter_u24lambda_u2d13.activity).getComponentName().getClassName())) {
                    $this$setFilter_u24lambda_u2d13.config.setFilterSelf(true);
                }
            }
            return this;
        }

        public final Builder setStatusListener(IFloatingWindowListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.config.setFloatingWindowListener(listener);
            return this;
        }

        public final void showV1() {
            if (this.config.getLayoutId() == null) {
                callbackCreateFailed(TTSFloatingWindowKt.WARN_NO_LAYOUT);
            } else if (checkUninitialized()) {
                callbackCreateFailed(TTSFloatingWindowKt.WARN_UNINITIALIZED);
            } else if (this.config.getShowPattern() == ShowStrategy.CURRENT_ACTIVITY) {
                createActivityFloatingWindow();
            } else if (OverlayPermissionUtils.INSTANCE.checkPermission(this.activity)) {
                createAppFloatingWindow();
            } else {
                requestPermission();
            }
        }

        public final void show() {
            createAppFloatingWindow();
        }

        private final void createActivityFloatingWindow() {
            if (this.activity instanceof Activity) {
                new ActivityFloatingWindow((Activity) this.activity).createFloat(this.config);
            } else {
                callbackCreateFailed(TTSFloatingWindowKt.WARN_CONTEXT_ACTIVITY);
            }
        }

        private final void createAppFloatingWindow() {
            FloatingWindowFactory.INSTANCE.create(this.activity, this.config);
        }

        private final void requestPermission() {
            if (this.activity instanceof Activity) {
                OverlayPermissionUtils.INSTANCE.requestPermission((Activity) this.activity, this);
            } else {
                callbackCreateFailed(TTSFloatingWindowKt.WARN_CONTEXT_REQUEST);
            }
        }

        private final boolean checkUninitialized() {
            return false;
        }

        private final void callbackCreateFailed(String reason) {
        }

        public void permissionResult(boolean isOpen) {
            if (isOpen) {
                createAppFloatingWindow();
            } else {
                callbackCreateFailed(TTSFloatingWindowKt.WARN_PERMISSION);
            }
        }
    }
}
