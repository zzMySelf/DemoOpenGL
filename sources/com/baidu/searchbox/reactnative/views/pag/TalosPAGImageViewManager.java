package com.baidu.searchbox.reactnative.views.pag;

import android.util.Log;
import com.baidu.searchbox.reactnative.views.pag.event.TalosPAGAnimationStatusChangeEvent;
import com.baidu.searchbox.reactnative.views.pag.event.TalosPAGEventUtil;
import com.baidu.searchbox.reactnative.views.pag.event.TalosPAGNotifyEvent;
import com.baidu.talos.core.Debug;
import com.baidu.talos.core.common.MapBuilder;
import com.baidu.talos.core.context.TalosPageContext;
import com.baidu.talos.core.data.ParamArray;
import com.baidu.talos.core.render.IViewManagerStub;
import com.baidu.talos.core.render.SimpleViewManager;
import com.baidu.talos.core.render.TalosUIManagerHelper;
import com.baidu.talos.core.render.events.IUIEventDispatcher;
import com.baidu.talos.core.util.ViewIDConvertUtil;
import com.baidu.talos.react.uimanager.annotations.TalosProp;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001&B\u0005¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J \u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\r0\u000bH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0014J\u0012\u0010\u0012\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\fH\u0002J&\u0010\u0017\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\u0018\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010 \u001a\u00020!H\u0007J\u0018\u0010\"\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010#\u001a\u00020!H\u0007J\u001a\u0010$\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\b\u0010%\u001a\u0004\u0018\u00010\fH\u0007R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/baidu/searchbox/reactnative/views/pag/TalosPAGImageViewManager;", "Lcom/baidu/talos/core/render/SimpleViewManager;", "Lcom/baidu/searchbox/reactnative/views/pag/TalosPAGImageView;", "Lcom/baidu/talos/core/render/IViewManagerStub;", "()V", "mEventDispatcher", "Lcom/baidu/talos/core/render/events/IUIEventDispatcher;", "createViewInstance", "context", "Lcom/baidu/talos/core/context/TalosPageContext;", "getExportedCustomDirectEventTypeConstants", "", "", "", "getName", "onAfterUpdateTransaction", "", "view", "onDropViewInstance", "onNotifyPAGInfo", "viewId", "", "jsonString", "receiveCommand", "root", "commandId", "args", "Lcom/baidu/talos/core/data/ParamArray;", "setAutoplay", "autoplay", "", "setLoop", "repeatCount", "", "setScaleMode", "scaleMode", "setSource", "url", "Companion", "lib-talos-searchbox-modules_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TalosPAGImageViewManager.kt */
public final class TalosPAGImageViewManager extends SimpleViewManager<TalosPAGImageView> implements IViewManagerStub {
    private static final String COMMAND_IS_PLAYING = "isPlaying";
    private static final String COMMAND_PAUSE = "pause";
    private static final String COMMAND_PLAY = "play";
    private static final String COMMAND_RESUME = "resume";
    private static final String COMMAND_STOP = "stop";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String REACT_CLASS = "PAGImageView";
    private static final String TAG = "TalosPAGImageView";
    private IUIEventDispatcher mEventDispatcher;

    public String getName() {
        return REACT_CLASS;
    }

    /* access modifiers changed from: protected */
    public TalosPAGImageView createViewInstance(TalosPageContext context) {
        this.mEventDispatcher = TalosUIManagerHelper.getRenderImpl(context).getEventDispatcher();
        return new TalosPAGImageView(context);
    }

    @TalosProp(defaultInt = -1, name = "repeatCount")
    public final void setLoop(TalosPAGImageView view2, int repeatCount) {
        Intrinsics.checkNotNullParameter(view2, "view");
        view2.setRepeatCount(repeatCount);
    }

    @TalosProp(defaultBoolean = false, name = "autoplay")
    public final void setAutoplay(TalosPAGImageView view2, boolean autoplay) {
        Intrinsics.checkNotNullParameter(view2, "view");
        view2.setAutoplay(autoplay);
    }

    @TalosProp(name = "src")
    public final void setSource(TalosPAGImageView view2, String url) {
        Intrinsics.checkNotNullParameter(view2, "view");
        if (url != null) {
            view2.setPathAsync(url);
        }
    }

    @TalosProp(name = "scaleMode")
    public final void setScaleMode(TalosPAGImageView view2, int scaleMode) {
        Intrinsics.checkNotNullParameter(view2, "view");
        view2.setScaleMode(scaleMode);
    }

    /* access modifiers changed from: protected */
    public void onAfterUpdateTransaction(TalosPAGImageView view2) {
        super.onAfterUpdateTransaction(view2);
        if (view2 != null) {
            view2.onAfterUpdateTransaction();
        }
    }

    public void receiveCommand(TalosPAGImageView root, String commandId, ParamArray args) {
        super.receiveCommand(root, commandId, args);
        if (commandId != null) {
            switch (commandId.hashCode()) {
                case -1073342556:
                    if (commandId.equals("isPlaying") && root != null) {
                        TalosPAGImageView talosPAGImageView = root;
                        onNotifyPAGInfo(ViewIDConvertUtil.getTalosViewTag(root), TalosPAGEventUtil.INSTANCE.buildEventJSONString("isPlaying", root.isPlaying()));
                        return;
                    }
                    return;
                case -934426579:
                    if (commandId.equals("resume") && root != null) {
                        root.play();
                        return;
                    }
                    return;
                case 3443508:
                    if (commandId.equals("play") && root != null) {
                        root.play();
                        return;
                    }
                    return;
                case 3540994:
                    if (commandId.equals("stop") && root != null) {
                        root.pause();
                        return;
                    }
                    return;
                case 106440182:
                    if (commandId.equals("pause") && root != null) {
                        root.pause();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private final void onNotifyPAGInfo(long viewId, String jsonString) {
        if (Debug.isDebug()) {
            Log.d(TAG, "onNotifyPAGInfo() " + jsonString);
        }
        TalosPAGNotifyEvent event = new TalosPAGNotifyEvent(viewId);
        event.setNotifyEventInfo(jsonString);
        IUIEventDispatcher iUIEventDispatcher = this.mEventDispatcher;
        if (iUIEventDispatcher != null) {
            iUIEventDispatcher.dispatchEvent(event);
        }
    }

    public Map<String, Map<String, String>> getExportedCustomDirectEventTypeConstants() {
        Map<String, Map<String, String>> of = MapBuilder.of(TalosPAGAnimationStatusChangeEvent.PAG_ANIMATION_STATUS_CHANGE, MapBuilder.of("registrationName", "onAnimationStatusChange"), TalosPAGNotifyEvent.PAG_NOTIFY_EVENT, MapBuilder.of("registrationName", "onpagNotify"));
        Intrinsics.checkNotNullExpressionValue(of, "of<String, Map<String, S… \"onpagNotify\")\n        )");
        return of;
    }

    public void onDropViewInstance(TalosPAGImageView view2) {
        super.onDropViewInstance(view2);
        if (view2 != null) {
            view2.destroy();
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/reactnative/views/pag/TalosPAGImageViewManager$Companion;", "", "()V", "COMMAND_IS_PLAYING", "", "COMMAND_PAUSE", "COMMAND_PLAY", "COMMAND_RESUME", "COMMAND_STOP", "REACT_CLASS", "TAG", "lib-talos-searchbox-modules_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TalosPAGImageViewManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
