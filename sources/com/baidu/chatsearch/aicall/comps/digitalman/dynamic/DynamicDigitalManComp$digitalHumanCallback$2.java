package com.baidu.chatsearch.aicall.comps.digitalman.dynamic;

import android.view.View;
import com.baidu.chatsearch.aicall.event.AICallErrorType;
import com.baidu.chatsearch.aicall.event.AnswerComplete;
import com.baidu.chatsearch.aicall.event.ErrorPage;
import com.baidu.chatsearch.aicall.event.IAICallStateEvent;
import com.baidu.chatsearch.aicall.event.StartAnswer;
import com.baidu.chatsearch.aicall.event.StartRecording;
import com.baidu.chatsearch.aicall.event.StartRequest;
import com.baidu.chatsearch.aicall.statistic.AICallSpeedStats;
import com.baidu.chatsearch.aicall.statistic.AICallUbcExceptionUtils;
import com.baidu.searchbox.aicall.yalog.AICallYalog;
import com.baidu.searchbox.components.digitalhuman.service.DigitalDuration;
import com.baidu.searchbox.components.digitalhuman.service.DigitalHumanStatus;
import com.baidu.searchbox.components.digitalhuman.service.ItemDuration;
import com.baidu.searchbox.components.digitalhuman.service.error.ErrorData;
import com.baidu.searchbox.components.digitalhuman.service.render.data.CloudRenderFirstFrameData;
import com.baidu.searchbox.components.digitalhuman.service.render.data.IFirstFrameData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "com/baidu/chatsearch/aicall/comps/digitalman/dynamic/DynamicDigitalManComp$digitalHumanCallback$2$1", "invoke", "()Lcom/baidu/chatsearch/aicall/comps/digitalman/dynamic/DynamicDigitalManComp$digitalHumanCallback$2$1;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: DynamicDigitalManComp.kt */
final class DynamicDigitalManComp$digitalHumanCallback$2 extends Lambda implements Function0<AnonymousClass1> {
    final /* synthetic */ View $view;
    final /* synthetic */ DynamicDigitalManComp this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DynamicDigitalManComp$digitalHumanCallback$2(View view2, DynamicDigitalManComp dynamicDigitalManComp) {
        super(0);
        this.$view = view2;
        this.this$0 = dynamicDigitalManComp;
    }

    public final AnonymousClass1 invoke() {
        final View view2 = this.$view;
        final DynamicDigitalManComp dynamicDigitalManComp = this.this$0;
        return new DigitalHumanCallbackAdapter() {
            public void onFirstFrame(IFirstFrameData frameData) {
                CloudRenderFirstFrameData it = frameData instanceof CloudRenderFirstFrameData ? (CloudRenderFirstFrameData) frameData : null;
                if (it != null) {
                    dynamicDigitalManComp.getLlmComp().setRoomName(it.getRoomId());
                }
                view2.animate().alpha(1.0f).setDuration(240).start();
                Function0<Unit> initSuccessCallback = dynamicDigitalManComp.getInitSuccessCallback();
                if (initSuccessCallback != null) {
                    initSuccessCallback.invoke();
                }
                dynamicDigitalManComp.setInitSuccess(true);
                Function0<Unit> firstFrame = dynamicDigitalManComp.getFirstFrame();
                if (firstFrame != null) {
                    firstFrame.invoke();
                }
                AICallYalog.INSTANCE.i("DynamicDigitalManComp", "onFirstFrame:");
            }

            public void onDigitalHumanStatusChanged(DigitalHumanStatus oldHumanStatus, DigitalHumanStatus newHumanStatus) {
                Function1<IAICallStateEvent, Unit> eventHandler;
                Intrinsics.checkNotNullParameter(oldHumanStatus, "oldHumanStatus");
                Intrinsics.checkNotNullParameter(newHumanStatus, "newHumanStatus");
                if (newHumanStatus == DigitalHumanStatus.LISTENING) {
                    Function1<IAICallStateEvent, Unit> eventHandler2 = dynamicDigitalManComp.getEventHandler();
                    if (eventHandler2 != null) {
                        eventHandler2.invoke(new StartRecording((JSONObject) null));
                    }
                } else if (newHumanStatus == DigitalHumanStatus.THINKING && oldHumanStatus == DigitalHumanStatus.LISTENING) {
                    Function1<IAICallStateEvent, Unit> eventHandler3 = dynamicDigitalManComp.getEventHandler();
                    if (eventHandler3 != null) {
                        eventHandler3.invoke(new StartRequest((JSONObject) null));
                    }
                } else if (newHumanStatus == DigitalHumanStatus.ANSWERING && oldHumanStatus == DigitalHumanStatus.THINKING && (eventHandler = dynamicDigitalManComp.getEventHandler()) != null) {
                    eventHandler.invoke(new StartAnswer((JSONObject) null));
                }
                AICallYalog.INSTANCE.i("DynamicDigitalManComp", "onDigitalHumanStatusChanged: " + oldHumanStatus + "->" + newHumanStatus);
            }

            public void onTtsStart(String utteranceId) {
                Intrinsics.checkNotNullParameter(utteranceId, "utteranceId");
                super.onTtsStart(utteranceId);
                Function0<Unit> startTts = dynamicDigitalManComp.getStartTts();
                if (startTts != null) {
                    startTts.invoke();
                }
                AICallYalog.INSTANCE.i("DynamicDigitalManComp", "onTtsStart:");
            }

            public void onTtsComplete(String text, String utteranceId) {
                Intrinsics.checkNotNullParameter(text, "text");
                Intrinsics.checkNotNullParameter(utteranceId, "utteranceId");
                super.onTtsComplete(text, utteranceId);
                Function1<IAICallStateEvent, Unit> eventHandler = dynamicDigitalManComp.getEventHandler();
                if (eventHandler != null) {
                    eventHandler.invoke(new AnswerComplete((JSONObject) null, 1, (DefaultConstructorMarker) null));
                }
                AICallYalog.INSTANCE.i("DynamicDigitalManComp", "onTtsComplete:");
            }

            public void onDigitalError(ErrorData errorData) {
                String errorCode;
                Intrinsics.checkNotNullParameter(errorData, "errorData");
                String str = "clickToRetry";
                if (AICallErrorType.Companion.contain(errorData.getErrorCode()) && (errorCode = errorData.getErrorCode()) != null) {
                    str = errorCode;
                }
                String errorType = str;
                Function1<IAICallStateEvent, Unit> eventHandler = dynamicDigitalManComp.getEventHandler();
                String str2 = "";
                if (eventHandler != null) {
                    eventHandler.invoke(ErrorPage.Companion.create(errorType, str2));
                }
                AICallSpeedStats speedStatsUtil = dynamicDigitalManComp.getSpeedStatsUtil();
                if (speedStatsUtil != null) {
                    JSONObject jSONObject = new JSONObject();
                    JSONObject $this$onDigitalError_u24lambda_u2d1 = jSONObject;
                    String errorCode2 = errorData.getErrorCode();
                    if (errorCode2 != null) {
                        str2 = errorCode2;
                    }
                    $this$onDigitalError_u24lambda_u2d1.put("onDigitalError", str2);
                    Unit unit = Unit.INSTANCE;
                    speedStatsUtil.endFlow(5, jSONObject);
                }
                AICallYalog.INSTANCE.e("DynamicDigitalManComp", "onDigitalError: " + errorData.getErrorCode());
            }

            public void onFatalError(ErrorData errorData) {
                Intrinsics.checkNotNullParameter(errorData, "errorData");
                dynamicDigitalManComp.setInitSuccess(false);
                Function1<IAICallStateEvent, Unit> eventHandler = dynamicDigitalManComp.getEventHandler();
                String str = "";
                if (eventHandler != null) {
                    eventHandler.invoke(ErrorPage.Companion.create("dynamicFatalError", str));
                }
                Function1<String, Unit> onError = dynamicDigitalManComp.getOnError();
                if (onError != null) {
                    onError.invoke(AICallUbcExceptionUtils.RENDER_FAIL);
                }
                AICallSpeedStats speedStatsUtil = dynamicDigitalManComp.getSpeedStatsUtil();
                if (speedStatsUtil != null) {
                    JSONObject jSONObject = new JSONObject();
                    JSONObject $this$onFatalError_u24lambda_u2d2 = jSONObject;
                    String errorCode = errorData.getErrorCode();
                    if (errorCode != null) {
                        str = errorCode;
                    }
                    $this$onFatalError_u24lambda_u2d2.put("onFatalError", str);
                    Unit unit = Unit.INSTANCE;
                    speedStatsUtil.endFlow(5, jSONObject);
                }
                AICallYalog.INSTANCE.e("DynamicDigitalManComp", "onFatalError: " + errorData.getErrorCode());
            }

            public void onOnceWorkflowDuration(DigitalDuration digitalDuration) {
                ItemDuration $this$onOnceWorkflowDuration_u24lambda_u2d4;
                ItemDuration $this$onOnceWorkflowDuration_u24lambda_u2d3;
                AICallSpeedStats speedStatsUtil;
                if (!(digitalDuration == null || ($this$onOnceWorkflowDuration_u24lambda_u2d3 = digitalDuration.getTtsDuration()) == null || (speedStatsUtil = dynamicDigitalManComp.getSpeedStatsUtil()) == null)) {
                    speedStatsUtil.putEvent("conversation_livefigure_msg_f_time", String.valueOf($this$onOnceWorkflowDuration_u24lambda_u2d3.getStartTime()));
                }
                if (digitalDuration != null && ($this$onOnceWorkflowDuration_u24lambda_u2d4 = digitalDuration.getRenderDuration()) != null) {
                    DynamicDigitalManComp dynamicDigitalManComp = dynamicDigitalManComp;
                    AICallSpeedStats speedStatsUtil2 = dynamicDigitalManComp.getSpeedStatsUtil();
                    if (speedStatsUtil2 != null) {
                        speedStatsUtil2.putEvent("tts_livefigure_start_play_time", String.valueOf($this$onOnceWorkflowDuration_u24lambda_u2d4.getEndTime()));
                    }
                    AICallSpeedStats speedStatsUtil3 = dynamicDigitalManComp.getSpeedStatsUtil();
                    if (speedStatsUtil3 != null) {
                        AICallSpeedStats.endFlow$default(speedStatsUtil3, 0, (JSONObject) null, 2, (Object) null);
                    }
                }
            }
        };
    }
}
