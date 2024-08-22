package com.baidu.searchbox.reactnative.views.pag;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.searchbox.reactnative.views.pag.event.TalosPAGAnimationStatusChangeEvent;
import com.baidu.searchbox.reactnative.views.pag.event.TalosPAGEventUtil;
import com.baidu.talos.core.Debug;
import com.baidu.talos.core.context.TalosPageContext;
import com.baidu.talos.core.render.TalosUIManagerHelper;
import com.baidu.talos.core.render.events.Event;
import com.baidu.talos.core.render.events.ITalosTouchEventRegister;
import com.baidu.talos.core.render.events.IUIEventDispatcher;
import com.baidu.talos.core.render.events.TalosEventProcessor;
import com.baidu.talos.core.render.events.TalosTouchEventType;
import com.baidu.talos.core.util.ViewIDConvertUtil;
import java.io.File;
import java.net.URI;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.libpag.PAGImageView;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001&B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012J\u0012\u0010\u0014\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0012H\u0014J\b\u0010\u0018\u001a\u00020\u0012H\u0014J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\u00122\b\b\u0001\u0010\u001d\u001a\u00020\u001eH\u0016J\u0016\u0010\u001f\u001a\u00020\u00122\f\u0010\u001a\u001a\b\u0012\u0002\b\u0003\u0018\u00010 H\u0002J\u000e\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u0007J\u000e\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u0016J\u0012\u0010%\u001a\u00020\u00122\b\b\u0001\u0010\u001d\u001a\u00020\u001eH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/baidu/searchbox/reactnative/views/pag/TalosPAGImageView;", "Lorg/libpag/PAGImageView;", "Lcom/baidu/talos/core/render/events/ITalosTouchEventRegister;", "context", "Lcom/baidu/talos/core/context/TalosPageContext;", "(Lcom/baidu/talos/core/context/TalosPageContext;)V", "autoplay", "", "isAfterUpdateTransaction", "isOnLoad", "listener", "Lorg/libpag/PAGImageView$PAGImageViewListener;", "mCanceledDuetoDetached", "mEventDispatcher", "Lcom/baidu/talos/core/render/events/IUIEventDispatcher;", "mEventProcessor", "Lcom/baidu/talos/core/render/events/TalosEventProcessor;", "destroy", "", "onAfterUpdateTransaction", "onAnimationStatusChange", "jsonString", "", "onAttachedToWindow", "onDetachedFromWindow", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "registeEventType", "type", "", "sendEvent", "Lcom/baidu/talos/core/render/events/Event;", "setAutoplay", "isAutoplay", "setPathAsync", "path", "unregisteEventType", "Companion", "lib-talos-searchbox-modules_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TalosPAGImageView.kt */
public final class TalosPAGImageView extends PAGImageView implements ITalosTouchEventRegister {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "TalosPAGImageView";
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    /* access modifiers changed from: private */
    public boolean autoplay;
    /* access modifiers changed from: private */
    public boolean isAfterUpdateTransaction;
    /* access modifiers changed from: private */
    public boolean isOnLoad;
    private PAGImageView.PAGImageViewListener listener;
    private boolean mCanceledDuetoDetached;
    private IUIEventDispatcher mEventDispatcher;
    private TalosEventProcessor mEventProcessor;

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view2 = map.get(Integer.valueOf(i2));
        if (view2 != null) {
            return view2;
        }
        View findViewById = findViewById(i2);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public TalosPAGImageView(TalosPageContext context) {
        super(context);
        this.autoplay = true;
        this.mEventDispatcher = TalosUIManagerHelper.getRenderImpl(context).getEventDispatcher();
        PAGImageView.PAGImageViewListener r0 = new PAGImageView.PAGImageViewListener(this) {
            final /* synthetic */ TalosPAGImageView this$0;

            {
                this.this$0 = $receiver;
            }

            public void onAnimationStart(PAGImageView pagImageView) {
                this.this$0.onAnimationStatusChange(TalosPAGEventUtil.INSTANCE.buildAnimationEventJSONString("start", "0"));
            }

            public void onAnimationEnd(PAGImageView pagImageView) {
                this.this$0.onAnimationStatusChange(TalosPAGEventUtil.INSTANCE.buildAnimationEventJSONString("end", "0"));
            }

            public void onAnimationCancel(PAGImageView pagImageView) {
                this.this$0.onAnimationStatusChange(TalosPAGEventUtil.INSTANCE.buildAnimationEventJSONString("cancel", "0"));
            }

            public void onAnimationRepeat(PAGImageView pagImageView) {
                this.this$0.onAnimationStatusChange(TalosPAGEventUtil.INSTANCE.buildAnimationEventJSONString("repeat", "0"));
            }

            public void onAnimationUpdate(PAGImageView pagImageView) {
            }
        };
        this.listener = r0;
        addListener(r0);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/reactnative/views/pag/TalosPAGImageView$Companion;", "", "()V", "TAG", "", "lib-talos-searchbox-modules_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TalosPAGImageView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void setAutoplay(boolean isAutoplay) {
        this.autoplay = isAutoplay;
    }

    public final void setPathAsync(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        this.isOnLoad = false;
        this.isAfterUpdateTransaction = false;
        String newPath = path;
        try {
            if (!TextUtils.isEmpty(path)) {
                if (StringsKt.startsWith$default(path, "file://", false, 2, (Object) null)) {
                    String path2 = new File(new URI(path)).getPath();
                    Intrinsics.checkNotNullExpressionValue(path2, "File(URI(path)).path");
                    newPath = path2;
                }
                if (!TextUtils.isEmpty(newPath)) {
                    setPathAsync(newPath, new TalosPAGImageView$setPathAsync$1(this));
                }
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public final void onAfterUpdateTransaction() {
        this.isAfterUpdateTransaction = true;
        if (this.isOnLoad && this.autoplay && !isPlaying()) {
            play();
        }
    }

    public void registeEventType(@TalosTouchEventType.TouchEventType int type) {
        if (this.mEventProcessor == null) {
            this.mEventProcessor = new TalosEventProcessor();
        }
        TalosEventProcessor talosEventProcessor = this.mEventProcessor;
        if (talosEventProcessor != null) {
            talosEventProcessor.addEventType(type);
        }
    }

    public void unregisteEventType(@TalosTouchEventType.TouchEventType int type) {
        if (this.mEventProcessor == null) {
            this.mEventProcessor = new TalosEventProcessor();
        }
        TalosEventProcessor talosEventProcessor = this.mEventProcessor;
        if (talosEventProcessor != null) {
            talosEventProcessor.removeEventType(type);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        boolean handle = super.onTouchEvent(event);
        TalosEventProcessor talosEventProcessor = this.mEventProcessor;
        if (talosEventProcessor == null) {
            return handle;
        }
        boolean z = true;
        if (talosEventProcessor == null || !talosEventProcessor.handleTouchEvent(this, event)) {
            z = false;
        }
        return handle | z;
    }

    /* access modifiers changed from: private */
    public final void onAnimationStatusChange(String jsonString) {
        if (Debug.isDebug()) {
            Log.d(TAG, "onAnimationStatusChange() " + jsonString);
        }
        TalosPAGAnimationStatusChangeEvent event = new TalosPAGAnimationStatusChangeEvent(ViewIDConvertUtil.getTalosViewTag(this));
        event.setAnimationStatusChange(jsonString);
        sendEvent(event);
    }

    private final void sendEvent(Event<?> event) {
        IUIEventDispatcher iUIEventDispatcher = this.mEventDispatcher;
        if (iUIEventDispatcher != null && event != null && iUIEventDispatcher != null) {
            iUIEventDispatcher.dispatchEvent(event);
        }
    }

    public final void destroy() {
        if (isPlaying()) {
            pause();
        }
        PAGImageView.PAGImageViewListener l = this.listener;
        if (l != null) {
            removeListener(l);
        }
    }
}
