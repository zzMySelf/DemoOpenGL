package com.baidu.swan.apps.ioc.interfaces;

import android.app.Activity;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.baidu.swan.apps.llm.api.StartVoiceRecognitionApi;
import com.baidu.swan.apps.util.typedbox.TypedCallback;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0002\u0013\u0014J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tH&J,\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J$\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&¨\u0006\u0015"}, d2 = {"Lcom/baidu/swan/apps/ioc/interfaces/IStartVoiceRecognition;", "", "handleBackPressed", "", "container", "Landroid/view/ViewGroup;", "isVoicePanelShowing", "", "listener", "Lcom/baidu/swan/apps/util/typedbox/TypedCallback;", "startLongPressVoiceRecognition", "swanActivity", "Landroid/app/Activity;", "holder", "Lcom/baidu/swan/apps/ioc/interfaces/IStartVoiceRecognition$ITouchEventHandlerHolder;", "Lcom/baidu/swan/apps/llm/api/StartVoiceRecognitionApi$IVoiceRecognitionResultCallback;", "buttonAnimation", "", "startVoiceRecognition", "ITouchEventHandler", "ITouchEventHandlerHolder", "lib-swan-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IStartVoiceRecognition.kt */
public interface IStartVoiceRecognition {

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/baidu/swan/apps/ioc/interfaces/IStartVoiceRecognition$ITouchEventHandler;", "", "onTouchEvent", "", "touchDownPosition", "Landroid/graphics/PointF;", "touchEvent", "Landroid/view/MotionEvent;", "lib-swan-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IStartVoiceRecognition.kt */
    public interface ITouchEventHandler {
        void onTouchEvent(PointF pointF, MotionEvent motionEvent);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/baidu/swan/apps/ioc/interfaces/IStartVoiceRecognition$ITouchEventHandlerHolder;", "", "touchEventHandler", "Lcom/baidu/swan/apps/ioc/interfaces/IStartVoiceRecognition$ITouchEventHandler;", "getTouchEventHandler", "()Lcom/baidu/swan/apps/ioc/interfaces/IStartVoiceRecognition$ITouchEventHandler;", "setTouchEventHandler", "(Lcom/baidu/swan/apps/ioc/interfaces/IStartVoiceRecognition$ITouchEventHandler;)V", "lib-swan-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IStartVoiceRecognition.kt */
    public interface ITouchEventHandlerHolder {
        ITouchEventHandler getTouchEventHandler();

        void setTouchEventHandler(ITouchEventHandler iTouchEventHandler);
    }

    boolean handleBackPressed(ViewGroup viewGroup);

    void isVoicePanelShowing(TypedCallback<Boolean> typedCallback);

    void startLongPressVoiceRecognition(Activity activity, ITouchEventHandlerHolder iTouchEventHandlerHolder, StartVoiceRecognitionApi.IVoiceRecognitionResultCallback iVoiceRecognitionResultCallback, String str);

    void startVoiceRecognition(Activity activity, StartVoiceRecognitionApi.IVoiceRecognitionResultCallback iVoiceRecognitionResultCallback, String str);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IStartVoiceRecognition.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void startVoiceRecognition$default(IStartVoiceRecognition iStartVoiceRecognition, Activity activity, StartVoiceRecognitionApi.IVoiceRecognitionResultCallback iVoiceRecognitionResultCallback, String str, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 4) != 0) {
                    str = null;
                }
                iStartVoiceRecognition.startVoiceRecognition(activity, iVoiceRecognitionResultCallback, str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startVoiceRecognition");
        }

        public static /* synthetic */ void startLongPressVoiceRecognition$default(IStartVoiceRecognition iStartVoiceRecognition, Activity activity, ITouchEventHandlerHolder iTouchEventHandlerHolder, StartVoiceRecognitionApi.IVoiceRecognitionResultCallback iVoiceRecognitionResultCallback, String str, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 8) != 0) {
                    str = null;
                }
                iStartVoiceRecognition.startLongPressVoiceRecognition(activity, iTouchEventHandlerHolder, iVoiceRecognitionResultCallback, str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startLongPressVoiceRecognition");
        }
    }
}
