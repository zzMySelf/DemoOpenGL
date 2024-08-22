package com.baidu.searchbox.openwidget.engine;

import android.util.Log;
import com.baidu.searchbox.datachannel.NAReceiverCallback;
import com.baidu.searchbox.openwidget.model.OpenWidgetTouch;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/baidu/searchbox/openwidget/engine/CallbackByDataChannel$setWidgetTouchReceiver$1", "Lcom/baidu/searchbox/datachannel/NAReceiverCallback;", "onReceive", "", "action", "", "data", "lib-openwidget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CallbackByDataChannel.kt */
public final class CallbackByDataChannel$setWidgetTouchReceiver$1 extends NAReceiverCallback {
    final /* synthetic */ CallbackByDataChannel this$0;

    CallbackByDataChannel$setWidgetTouchReceiver$1(CallbackByDataChannel $receiver) {
        this.this$0 = $receiver;
    }

    public void onReceive(String action, String data) {
        Object obj;
        String str = data;
        if (Intrinsics.areEqual((Object) "com.baidu.searchbox.openwidget.setWidgetTouch", (Object) action)) {
            CharSequence charSequence = str;
            if (!(charSequence == null || charSequence.length() == 0)) {
                CallbackByDataChannel callbackByDataChannel = this.this$0;
                try {
                    Result.Companion companion = Result.Companion;
                    CallbackByDataChannel$setWidgetTouchReceiver$1 callbackByDataChannel$setWidgetTouchReceiver$1 = this;
                    if (CallbackByDataChannelKt.DEBUG) {
                        Log.d("CallbackByDataChannel", "receive setWidgetTouch, widgetId=" + callbackByDataChannel.getWidgetId() + ", data=" + str);
                    }
                    JSONObject json = new JSONObject(str);
                    if (json.optInt("status", -1) == 0) {
                        JSONObject optJSONObject = json.optJSONObject("data");
                        if (optJSONObject != null) {
                            Intrinsics.checkNotNullExpressionValue(optJSONObject, "optJSONObject(\"data\")");
                            JSONObject $this$onReceive_u24lambda_u2d2_u24lambda_u2d1 = optJSONObject;
                            if (callbackByDataChannel.getWidgetId() == $this$onReceive_u24lambda_u2d2_u24lambda_u2d1.optInt("widgetId", 0)) {
                                OpenWidgetTouch touch = OpenWidgetTouch.Companion.fromJson($this$onReceive_u24lambda_u2d2_u24lambda_u2d1);
                                if (touch != null) {
                                    if (CallbackByDataChannelKt.DEBUG) {
                                        Log.d("CallbackByDataChannel", "setWidgetTouch success, widgetId=" + callbackByDataChannel.getWidgetId() + ", touch=" + touch);
                                    }
                                    callbackByDataChannel.tracer.traceEvent(OpenWidgetLoadTracer.EV_SET_WIDGET_TOUCH);
                                    callbackByDataChannel.callback.onSetTouchData(touch);
                                }
                            } else if (CallbackByDataChannelKt.DEBUG) {
                                Log.w("CallbackByDataChannel", "setWidgetTouch fail, widgetId not match, data=" + str);
                            }
                        } else {
                            optJSONObject = null;
                        }
                        obj = Result.m8971constructorimpl(optJSONObject);
                        CallbackByDataChannel callbackByDataChannel2 = this.this$0;
                        Throwable it = Result.m8974exceptionOrNullimpl(obj);
                        if (it != null && CallbackByDataChannelKt.DEBUG) {
                            Log.w("CallbackByDataChannel", "setWidgetTouch fail, widgetId=" + callbackByDataChannel2.getWidgetId() + ", data=" + str + ", error=" + it);
                        }
                    } else if (CallbackByDataChannelKt.DEBUG) {
                        Log.w("CallbackByDataChannel", "setWidgetTouch fail, widgetId=" + callbackByDataChannel.getWidgetId() + ", data=" + str);
                    }
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
                }
            }
        }
    }
}
