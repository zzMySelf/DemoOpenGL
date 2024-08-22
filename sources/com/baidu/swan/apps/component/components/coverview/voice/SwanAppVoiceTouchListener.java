package com.baidu.swan.apps.component.components.coverview.voice;

import android.app.Activity;
import android.app.Application;
import android.graphics.PointF;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.framework.ISwanFrameContainer;
import com.baidu.swan.apps.ioc.SwanAppRuntime;
import com.baidu.swan.apps.ioc.interfaces.IStartVoiceRecognition;
import com.baidu.swan.apps.llm.api.StartVoiceRecognitionApi;
import com.baidu.swan.apps.llm.manager.VoiceRecognizePanelManager;
import com.baidu.swan.apps.runtime.Swan;
import com.baidu.swan.apps.util.SwanAppJSONUtils;
import com.baidu.swan.apps.util.SwanAppUIUtils;
import com.baidu.swan.apps.view.container.touch.SwanAppTouchListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0001.B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u001d\u001a\u00020\u000eH\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u001fH\u0002J\u001c\u0010!\u001a\u00020\f2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0017J&\u0010&\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\t2\b\b\u0002\u0010'\u001a\u00020(2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\tH\u0002J\u001c\u0010*\u001a\u00020\u001f2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u001f0,H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006/"}, d2 = {"Lcom/baidu/swan/apps/component/components/coverview/voice/SwanAppVoiceTouchListener;", "Lcom/baidu/swan/apps/view/container/touch/SwanAppTouchListener;", "Lcom/baidu/swan/apps/ioc/interfaces/IStartVoiceRecognition$ITouchEventHandlerHolder;", "model", "Lcom/baidu/swan/apps/component/components/coverview/voice/SwanAppVoiceCoverViewComponentModel;", "callbackHandler", "Lcom/baidu/searchbox/unitedscheme/CallbackHandler;", "(Lcom/baidu/swan/apps/component/components/coverview/voice/SwanAppVoiceCoverViewComponentModel;Lcom/baidu/searchbox/unitedscheme/CallbackHandler;)V", "buttonAnimation", "", "cb", "enableSendGestureMessageToWebView", "", "mDownPosition", "Landroid/graphics/PointF;", "mDownTime", "", "mInLongPressStatus", "mLongPressRunnable", "Ljava/lang/Runnable;", "mResultCallback", "Lcom/baidu/swan/apps/llm/api/StartVoiceRecognitionApi$IVoiceRecognitionResultCallback;", "showVoicePanelOnLongPress", "touchEventHandler", "Lcom/baidu/swan/apps/ioc/interfaces/IStartVoiceRecognition$ITouchEventHandler;", "getTouchEventHandler", "()Lcom/baidu/swan/apps/ioc/interfaces/IStartVoiceRecognition$ITouchEventHandler;", "setTouchEventHandler", "(Lcom/baidu/swan/apps/ioc/interfaces/IStartVoiceRecognition$ITouchEventHandler;)V", "createDefaultTouchDownPoint", "dealLongPressEvent", "", "dealTapEvent", "onTouch", "view", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "sendMessageToWebView", "code", "", "text", "verifyCurrentVoiceRuntime", "successCallback", "Lkotlin/Function1;", "Landroid/app/Activity;", "Companion", "lib-swan-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SwanAppVoiceTouchListener.kt */
public class SwanAppVoiceTouchListener extends SwanAppTouchListener implements IStartVoiceRecognition.ITouchEventHandlerHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final String EVENT_PANEL_ERROR = "voicePanelError";
    private static final String EVENT_PANEL_HIDE = "voicePanelHide";
    private static final String EVENT_PANEL_SHOW = "voicePanelShow";
    private static final String EVENT_RECOGNIZE_CONTENT = "voiceRecognizeContent";
    private static final String KEY_CODE = "code";
    private static final String KEY_MSG = "msg";
    private static final String KEY_TEXT = "text";
    private static final String KEY_TYPE = "type";
    private static final long LONG_PRESS_INTERVAL = 350;
    private static final String TAG = "SwanAppVoiceTouchListener";
    /* access modifiers changed from: private */
    public final String buttonAnimation;
    private final CallbackHandler callbackHandler;
    private final String cb;
    private final boolean enableSendGestureMessageToWebView;
    private PointF mDownPosition = createDefaultTouchDownPoint();
    private long mDownTime;
    private boolean mInLongPressStatus;
    private final Runnable mLongPressRunnable = new SwanAppVoiceTouchListener$$ExternalSyntheticLambda0(this);
    /* access modifiers changed from: private */
    public final StartVoiceRecognitionApi.IVoiceRecognitionResultCallback mResultCallback = new SwanAppVoiceTouchListener$mResultCallback$1(this);
    private final boolean showVoicePanelOnLongPress;
    private IStartVoiceRecognition.ITouchEventHandler touchEventHandler;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SwanAppVoiceTouchListener(SwanAppVoiceCoverViewComponentModel model, CallbackHandler callbackHandler2) {
        super(model.slaveId, model.componentId, model.componentType);
        Intrinsics.checkNotNullParameter(model, "model");
        this.callbackHandler = callbackHandler2;
        this.enableSendGestureMessageToWebView = model.gesture;
        this.showVoicePanelOnLongPress = model.getShowVoicePanelOnLongPress();
        this.buttonAnimation = model.getButtonAnimation();
        this.cb = model.getCb();
    }

    public IStartVoiceRecognition.ITouchEventHandler getTouchEventHandler() {
        return this.touchEventHandler;
    }

    public void setTouchEventHandler(IStartVoiceRecognition.ITouchEventHandler iTouchEventHandler) {
        this.touchEventHandler = iTouchEventHandler;
    }

    /* access modifiers changed from: private */
    /* renamed from: mLongPressRunnable$lambda-0  reason: not valid java name */
    public static final void m7922mLongPressRunnable$lambda0(SwanAppVoiceTouchListener this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mInLongPressStatus = true;
        this$0.dealLongPressEvent();
    }

    private final PointF createDefaultTouchDownPoint() {
        Application context = SwanAppRuntime.getAppContext();
        return new PointF(((float) SwanAppUIUtils.getDisplayWidth(context)) / ((float) 2), (float) SwanAppUIUtils.getDisplayHeight(context));
    }

    private final void dealTapEvent() {
        if (DEBUG) {
            Log.d(TAG, "onTouch:-Tap.");
        }
        verifyCurrentVoiceRuntime(new SwanAppVoiceTouchListener$dealTapEvent$1(this));
    }

    private final void dealLongPressEvent() {
        if (DEBUG) {
            Log.d(TAG, "onTouch:-LongPress-showPanel:" + this.showVoicePanelOnLongPress + AbstractJsonLexerKt.COMMA + this.buttonAnimation);
        }
        if (this.showVoicePanelOnLongPress) {
            verifyCurrentVoiceRuntime(new SwanAppVoiceTouchListener$dealLongPressEvent$1(this));
        }
    }

    private final void verifyCurrentVoiceRuntime(Function1<? super Activity, Unit> successCallback) {
        Activity activity = Swan.get().getActivity();
        if (activity == null) {
            sendMessageToWebView$default(this, EVENT_PANEL_ERROR, 2001, (String) null, 4, (Object) null);
            return;
        }
        ISwanFrameContainer swanFrameContainer = Swan.get().getSwanFrameContainer();
        boolean z = true;
        if (swanFrameContainer == null || !swanFrameContainer.isBackground()) {
            z = false;
        }
        if (z) {
            sendMessageToWebView$default(this, EVENT_PANEL_ERROR, 1002, (String) null, 4, (Object) null);
        } else {
            SwanAppRuntime.getStartVoiceRecognitionRuntime().isVoicePanelShowing(new SwanAppVoiceTouchListener$$ExternalSyntheticLambda1(this, successCallback, activity));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: verifyCurrentVoiceRuntime$lambda-1  reason: not valid java name */
    public static final void m7923verifyCurrentVoiceRuntime$lambda1(SwanAppVoiceTouchListener this$0, Function1 $successCallback, Activity $activity, Boolean isShowing) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($successCallback, "$successCallback");
        Intrinsics.checkNotNullExpressionValue(isShowing, "isShowing");
        if (isShowing.booleanValue()) {
            sendMessageToWebView$default(this$0, EVENT_PANEL_ERROR, 1008, (String) null, 4, (Object) null);
            return;
        }
        Intrinsics.checkNotNullExpressionValue($activity, "activity");
        $successCallback.invoke($activity);
    }

    public boolean onTouch(View view2, MotionEvent event) {
        IStartVoiceRecognition.ITouchEventHandler touchEventHandler2;
        if (view2 == null || event == null) {
            return false;
        }
        if (this.enableSendGestureMessageToWebView) {
            super.onTouch(view2, event);
        }
        if (this.mInLongPressStatus && (touchEventHandler2 = getTouchEventHandler()) != null) {
            touchEventHandler2.onTouchEvent(this.mDownPosition, event);
        }
        int action = event.getActionMasked();
        if (action == 0 && event.getPointerCount() == 1) {
            this.mDownPosition = new PointF(event.getX(), event.getY());
            this.mDownTime = event.getEventTime();
            view2.postDelayed(this.mLongPressRunnable, 350);
        } else if (action == 1 || action == 3) {
            view2.removeCallbacks(this.mLongPressRunnable);
            this.mInLongPressStatus = false;
        }
        if (action == 1 && event.getEventTime() - this.mDownTime < 350) {
            dealTapEvent();
        }
        return true;
    }

    static /* synthetic */ void sendMessageToWebView$default(SwanAppVoiceTouchListener swanAppVoiceTouchListener, String str, int i2, String str2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                i2 = 0;
            }
            if ((i3 & 4) != 0) {
                str2 = null;
            }
            swanAppVoiceTouchListener.sendMessageToWebView(str, i2, str2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendMessageToWebView");
    }

    private final void sendMessageToWebView(String event, int code, String text) {
        if (this.callbackHandler != null) {
            if (!(this.cb.length() == 0)) {
                JSONObject data = new JSONObject();
                SwanAppJSONUtils.setValue(data, "type", event);
                SwanAppJSONUtils.setValue(data, "code", Integer.valueOf(code));
                SwanAppJSONUtils.setValue(data, "text", text);
                if (code != 0) {
                    SwanAppJSONUtils.setValue(data, "msg", VoiceRecognizePanelManager.INSTANCE.getErrorMessage(code));
                }
                String result = UnitedSchemeUtility.wrapCallbackParams(data, 0).toString();
                Intrinsics.checkNotNullExpressionValue(result, "wrapCallbackParams(data, ERR_OK).toString()");
                if (DEBUG) {
                    Log.d(TAG, "sendMessageToWebView:" + result);
                }
                this.callbackHandler.handleSchemeDispatchCallback(this.cb, result);
            }
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/baidu/swan/apps/component/components/coverview/voice/SwanAppVoiceTouchListener$Companion;", "", "()V", "DEBUG", "", "EVENT_PANEL_ERROR", "", "EVENT_PANEL_HIDE", "EVENT_PANEL_SHOW", "EVENT_RECOGNIZE_CONTENT", "KEY_CODE", "KEY_MSG", "KEY_TEXT", "KEY_TYPE", "LONG_PRESS_INTERVAL", "", "TAG", "lib-swan-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SwanAppVoiceTouchListener.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
