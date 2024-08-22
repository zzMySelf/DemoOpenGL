package com.baidu.digital.shell;

import android.app.Activity;
import com.baidu.digital.shell.DigitalHumanEntry;
import com.baidu.digital.shell.ubc.DigitalPluginUbcManager;
import com.baidu.searchbox.components.digitalhuman.entry.IDigitalPluginEntry;
import com.baidu.searchbox.components.digitalhuman.entry.IDigitalRtcRoomEntry;
import com.baidu.searchbox.components.digitalhuman.service.DigitalHumanConfigModel;
import com.baidu.searchbox.components.digitalhuman.service.IDigitalHuman;
import com.baidu.searchbox.components.digitalhuman.service.asr.IInputService;
import com.baidu.searchbox.components.digitalhuman.service.error.ErrorData;
import com.baidu.searchbox.components.digitalhuman.service.error.ErrorType;
import com.baidu.searchbox.components.digitalhuman.service.llm.ILLMService;
import com.baidu.searchbox.components.digitalhuman.service.tts.ITtsServiceCallback;
import com.baidu.searchbox.components.digitalhuman.service.tts.PlayAction;
import com.baidu.searchbox.components.digitalhuman.service.tts.TtsPlayTask;
import com.baidu.searchbox.components.digitalhuman.service.tts.data.TTSSpeakerParams;
import com.baidu.searchbox.components.digitalhuman.service.tts.data.WelcomeConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/baidu/digital/shell/DigitalHumanEntry$createCloudRenderDigital$createRtcRoomCallback$1$onSuccess$1", "Lcom/baidu/searchbox/components/digitalhuman/entry/IDigitalRtcRoomEntry$IPreRequestEnterCallback;", "onError", "", "errorData", "Lcom/baidu/searchbox/components/digitalhuman/service/error/ErrorData;", "onSuccess", "enterSuccess", "Lcom/baidu/searchbox/components/digitalhuman/entry/IDigitalRtcRoomEntry$IPreRequestEnterSuccess;", "baidu-shell_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DigitalHumanEntry.kt */
public final class DigitalHumanEntry$createCloudRenderDigital$createRtcRoomCallback$1$onSuccess$1 implements IDigitalRtcRoomEntry.IPreRequestEnterCallback {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ String $ak;
    final /* synthetic */ DigitalHumanEntry.DigitalHumanCreateCallback $createDigitalHumanCallback;
    final /* synthetic */ String $figureId;
    final /* synthetic */ IInputService $inputService;
    final /* synthetic */ ILLMService $llmService;
    final /* synthetic */ Ref.ObjectRef<IDigitalPluginEntry> $localPluginEntry;
    final /* synthetic */ String $welcomeMsg;

    DigitalHumanEntry$createCloudRenderDigital$createRtcRoomCallback$1$onSuccess$1(DigitalHumanEntry.DigitalHumanCreateCallback $createDigitalHumanCallback2, String $ak2, String $figureId2, Ref.ObjectRef<IDigitalPluginEntry> $localPluginEntry2, Activity $activity2, IInputService $inputService2, ILLMService $llmService2, String $welcomeMsg2) {
        this.$createDigitalHumanCallback = $createDigitalHumanCallback2;
        this.$ak = $ak2;
        this.$figureId = $figureId2;
        this.$localPluginEntry = $localPluginEntry2;
        this.$activity = $activity2;
        this.$inputService = $inputService2;
        this.$llmService = $llmService2;
        this.$welcomeMsg = $welcomeMsg2;
    }

    public void onSuccess(IDigitalRtcRoomEntry.IPreRequestEnterSuccess enterSuccess) {
        Intrinsics.checkNotNullParameter(enterSuccess, "enterSuccess");
        IDigitalRtcRoomEntry.IDigitalRtcRoom digitalRoom = enterSuccess.createDigitalRtcRoom();
        if (digitalRoom == null) {
            ErrorData errorData = new ErrorData(ErrorType.DIGITAL_ENTRY, "-2", "数字人插件创建 IDigitalRtcRoom 异常", true);
            this.$createDigitalHumanCallback.onError(errorData);
            DigitalPluginUbcManager.INSTANCE.ubcDigitalInitFail(this.$ak, this.$figureId, "", errorData.getType(), errorData.getErrorCode(), errorData.getErrorMsg());
            return;
        }
        DigitalHumanConfigModel.Builder builder = new DigitalHumanConfigModel.Builder();
        IInputService iInputService = this.$inputService;
        ILLMService iLLMService = this.$llmService;
        String str = this.$welcomeMsg;
        DigitalHumanConfigModel.Builder $this$onSuccess_u24lambda_u2d0 = builder;
        $this$onSuccess_u24lambda_u2d0.setTtsAndAsrStopOrReleaseTimeout(10000, 10000);
        $this$onSuccess_u24lambda_u2d0.setAsrService(iInputService);
        $this$onSuccess_u24lambda_u2d0.setTtsService(digitalRoom.getTtsService());
        $this$onSuccess_u24lambda_u2d0.setRenderService(digitalRoom.getRenderService());
        $this$onSuccess_u24lambda_u2d0.setDownloadService(digitalRoom.getDownloadService());
        $this$onSuccess_u24lambda_u2d0.setLLMService(iLLMService);
        PlayAction playAction = PlayAction.WELCOME;
        if (str == null) {
            str = "";
        }
        TtsPlayTask ttsPlayTask = new TtsPlayTask(playAction, (String) null, str, (TTSSpeakerParams) null, (ITtsServiceCallback) null, 26, (DefaultConstructorMarker) null);
        IDigitalHuman iDigitalHuman = null;
        $this$onSuccess_u24lambda_u2d0.setWelcomeConfig(new WelcomeConfig(ttsPlayTask, false, 2, (DefaultConstructorMarker) null));
        DigitalHumanConfigModel humanConfigModel = builder.build();
        IDigitalPluginEntry iDigitalPluginEntry = (IDigitalPluginEntry) this.$localPluginEntry.element;
        if (iDigitalPluginEntry != null) {
            iDigitalHuman = iDigitalPluginEntry.createDigitalHuman(this.$activity, humanConfigModel);
        }
        IDigitalHuman digitalHuman = iDigitalHuman;
        if (digitalHuman != null) {
            this.$createDigitalHumanCallback.onSuccess(digitalHuman);
            return;
        }
        ErrorData errorData2 = new ErrorData(ErrorType.DIGITAL_ENTRY, "-1", "数字人插件创建 IDigitalHuman 异常", true);
        this.$createDigitalHumanCallback.onError(errorData2);
        DigitalPluginUbcManager.INSTANCE.ubcDigitalInitFail(this.$ak, this.$figureId, "", errorData2.getType(), errorData2.getErrorCode(), errorData2.getErrorMsg());
    }

    public void onError(ErrorData errorData) {
        Intrinsics.checkNotNullParameter(errorData, "errorData");
        this.$createDigitalHumanCallback.onError(errorData);
    }
}
