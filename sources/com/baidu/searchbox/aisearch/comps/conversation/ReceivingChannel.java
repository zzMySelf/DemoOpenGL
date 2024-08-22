package com.baidu.searchbox.aisearch.comps.conversation;

import com.baidu.searchbox.aisearch.comps.conversation.event.AbortProcess;
import com.baidu.searchbox.aisearch.comps.conversation.event.EditH5Text;
import com.baidu.searchbox.aisearch.comps.conversation.event.EditPromptTemplate;
import com.baidu.searchbox.aisearch.comps.conversation.event.ErrorPage;
import com.baidu.searchbox.aisearch.comps.conversation.event.Fatal;
import com.baidu.searchbox.aisearch.comps.conversation.event.GenerateComplete;
import com.baidu.searchbox.aisearch.comps.conversation.event.GeneratingResponse;
import com.baidu.searchbox.aisearch.comps.conversation.event.HideKeyboard;
import com.baidu.searchbox.aisearch.comps.conversation.event.HistorySearch;
import com.baidu.searchbox.aisearch.comps.conversation.event.ManifestInfo;
import com.baidu.searchbox.aisearch.comps.conversation.event.NaTransmissionResult;
import com.baidu.searchbox.aisearch.comps.conversation.event.SendingPrompt;
import com.baidu.searchbox.aisearch.comps.conversation.event.SessionUpdate;
import com.baidu.searchbox.aisearch.comps.conversation.event.ShareResult;
import com.baidu.searchbox.aisearch.comps.conversation.event.ShareStart;
import com.baidu.searchbox.aisearch.comps.conversation.event.ShareStatus;
import com.baidu.searchbox.aisearch.comps.conversation.event.StatInfo;
import com.baidu.searchbox.aisearch.comps.conversation.event.StatPerformance;
import com.baidu.searchbox.aisearch.comps.conversation.event.StreamReady;
import com.baidu.searchbox.aisearch.comps.conversation.event.SwitchSessionResult;
import com.baidu.searchbox.aisearch.comps.conversation.event.UpdateRhetoricalTag;
import com.baidu.searchbox.aisearch.comps.conversation.event.UserStatus;
import com.baidu.searchbox.aisearch.comps.conversation.event.WaitingResponse;
import com.baidu.searchbox.aisearch.utils.AnyScene;
import com.baidu.searchbox.datachannel.DataChannel;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0003J\u001a\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0003J\b\u0010\u0014\u001a\u00020\u000eH\u0003J\b\u0010\u0015\u001a\u00020\u000eH\u0003R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/aisearch/comps/conversation/ReceivingChannel;", "Ljava/io/Closeable;", "actionId", "", "dataChannelHost", "dataChannelPage", "stateCallback", "Lcom/baidu/searchbox/aisearch/comps/conversation/IConversationStateCallback;", "interactCallback", "Lcom/baidu/searchbox/aisearch/comps/conversation/IConversationInteractCallback;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/baidu/searchbox/aisearch/comps/conversation/IConversationStateCallback;Lcom/baidu/searchbox/aisearch/comps/conversation/IConversationInteractCallback;)V", "notifyInteractAction", "notifyStateAction", "close", "", "dispatchInteractEvent", "name", "params", "Lorg/json/JSONObject;", "dispatchStateEvent", "registerInteractEvent", "registerStateEvent", "lib-aisearch-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@AnyScene
/* compiled from: ReceivingChannel.kt */
public final class ReceivingChannel implements Closeable {
    private final String dataChannelHost;
    private final String dataChannelPage;
    private final IConversationInteractCallback interactCallback;
    /* access modifiers changed from: private */
    public final String notifyInteractAction;
    /* access modifiers changed from: private */
    public final String notifyStateAction;
    private final IConversationStateCallback stateCallback;

    public ReceivingChannel(String actionId, String dataChannelHost2, String dataChannelPage2, IConversationStateCallback stateCallback2, IConversationInteractCallback interactCallback2) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(actionId, "actionId");
        Intrinsics.checkNotNullParameter(dataChannelHost2, "dataChannelHost");
        Intrinsics.checkNotNullParameter(dataChannelPage2, "dataChannelPage");
        Intrinsics.checkNotNullParameter(stateCallback2, "stateCallback");
        Intrinsics.checkNotNullParameter(interactCallback2, "interactCallback");
        this.dataChannelHost = dataChannelHost2;
        this.dataChannelPage = dataChannelPage2;
        this.stateCallback = stateCallback2;
        this.interactCallback = interactCallback2;
        if (Intrinsics.areEqual((Object) actionId, (Object) "")) {
            str = "com.baidu.searchbox.aisearch.conversation.notifyStateEvent";
        } else {
            str = "com.baidu.searchbox.aisearch.conversation.notifyStateEvent." + actionId;
        }
        this.notifyStateAction = str;
        if (Intrinsics.areEqual((Object) actionId, (Object) "")) {
            str2 = "com.baidu.searchbox.aisearch.conversation.notifyInteractEvent";
        } else {
            str2 = "com.baidu.searchbox.aisearch.conversation.notifyInteractEvent." + actionId;
        }
        this.notifyInteractAction = str2;
        registerStateEvent();
        registerInteractEvent();
    }

    private final void registerStateEvent() {
        DataChannel.Registry.registerNAReceiver(this.dataChannelHost, this.dataChannelPage, this.notifyStateAction, new ReceivingChannel$registerStateEvent$1(this));
    }

    /* access modifiers changed from: private */
    public final void dispatchStateEvent(String name, JSONObject params) {
        switch (name.hashCode()) {
            case -852496585:
                if (name.equals(ReceivingChannelKt.EVENT_SENDING_PROMPT)) {
                    this.stateCallback.m15260onSendingPrompt2d4cEi4(SendingPrompt.m15524constructorimpl(params));
                    return;
                }
                return;
            case -560686133:
                if (name.equals(ReceivingChannelKt.EVENT_GENERATING_RESP)) {
                    this.stateCallback.m15259onGeneratingResponseifi6aQ(GeneratingResponse.m15485constructorimpl(params));
                    return;
                }
                return;
            case 108386723:
                if (name.equals("ready")) {
                    this.stateCallback.m15261onStreamReadys_rIclU(StreamReady.m15585constructorimpl(params));
                    return;
                }
                return;
            case 145290450:
                if (name.equals(ReceivingChannelKt.EVENT_ABORT_PROCESS)) {
                    this.stateCallback.m15256onAbortProcessgc5ViiE(AbortProcess.m15432constructorimpl(params));
                    return;
                }
                return;
            case 289206929:
                if (name.equals(ReceivingChannelKt.EVENT_GENERATE_COMPLETE)) {
                    this.stateCallback.m15258onGenerateCompleteCLpm4I(GenerateComplete.m15476constructorimpl(params));
                    return;
                }
                return;
            case 1589884724:
                if (name.equals("error-page")) {
                    this.stateCallback.m15257onErrorPageVOi_czo(ErrorPage.m15458constructorimpl(params));
                    return;
                }
                return;
            case 1746456400:
                if (name.equals(ReceivingChannelKt.EVENT_WAITING_RESP)) {
                    this.stateCallback.m15262onWaitingResponsePEZOPEY(WaitingResponse.m15620constructorimpl(params));
                    return;
                }
                return;
            default:
                return;
        }
    }

    private final void registerInteractEvent() {
        DataChannel.Registry.registerNAReceiver(this.dataChannelHost, this.dataChannelPage, this.notifyInteractAction, new ReceivingChannel$registerInteractEvent$1(this));
    }

    /* access modifiers changed from: private */
    public final void dispatchInteractEvent(String name, JSONObject params) {
        switch (name.hashCode()) {
            case -2136976249:
                if (name.equals("stat-info")) {
                    this.interactCallback.m15251onStatInfoF0nnaMQ(StatInfo.m15566constructorimpl(params));
                    return;
                }
                return;
            case -1912197360:
                if (name.equals("edit-text")) {
                    this.interactCallback.m15240onEditH5TextQGkmeEQ(EditH5Text.m15442constructorimpl(params));
                    return;
                }
                return;
            case -1734338101:
                if (name.equals("share-result")) {
                    this.interactCallback.m15248onShareResultjY8zBU0(ShareResult.m15543constructorimpl(params));
                    return;
                }
                return;
            case -1692393056:
                if (name.equals("share-status")) {
                    this.interactCallback.m15250onShareStatuscMs_18g(ShareStatus.m15558constructorimpl(params));
                    return;
                }
                return;
            case -1576041420:
                if (name.equals("user-status") && params != null) {
                    this.interactCallback.m15255onUserStatussFJLmL4(UserStatus.m15610constructorimpl(params));
                    return;
                }
                return;
            case -1535615743:
                if (name.equals("history-search")) {
                    this.interactCallback.m15244onHistorySearchHOIS_Jk(HistorySearch.m15501constructorimpl(params));
                    return;
                }
                return;
            case -1235727817:
                if (name.equals("stat-performance")) {
                    this.interactCallback.m15252onStatPerformancesrYjkBc(StatPerformance.m15576constructorimpl(params));
                    return;
                }
                return;
            case -1180212992:
                if (name.equals("edit-prompt-template")) {
                    this.interactCallback.m15241onEditPromptTemplatetSATAGg(EditPromptTemplate.m15450constructorimpl(params));
                    return;
                }
                return;
            case -1024424716:
                if (name.equals("share-start")) {
                    this.interactCallback.m15249onShareStartAnlCWRQ(ShareStart.m15551constructorimpl(params));
                    return;
                }
                return;
            case -982195182:
                if (name.equals("hide-keyboard")) {
                    this.interactCallback.m15243onHideKeyboard2dTr3lk(HideKeyboard.m15494constructorimpl(params));
                    return;
                }
                return;
            case -297082730:
                if (name.equals("update-tag")) {
                    this.interactCallback.m15254onUpdateRhetoricalTagCW9dDqU(UpdateRhetoricalTag.m15603constructorimpl(params));
                    return;
                }
                return;
            case 97203460:
                if (name.equals("fatal")) {
                    this.interactCallback.m15242onFatalM0EhBG4(Fatal.m15469constructorimpl(params));
                    return;
                }
                return;
            case 551693280:
                if (name.equals("session-update")) {
                    this.interactCallback.m15247onSessionUpdatePGpBe2s(SessionUpdate.m15535constructorimpl(params));
                    return;
                }
                return;
            case 1067638156:
                if (name.equals("manifest-info")) {
                    this.interactCallback.m15245onManifestInfoN_bWckc(ManifestInfo.m15508constructorimpl(params));
                    return;
                }
                return;
            case 1772956940:
                if (name.equals("na-transmission-result")) {
                    this.interactCallback.m15246onNaTransmissionResultChyjj1Y(NaTransmissionResult.m15515constructorimpl(params));
                    return;
                }
                return;
            case 2107761389:
                if (name.equals("switch-session-result")) {
                    this.interactCallback.m15253onSwitchSessionResultwKOfGY(SwitchSessionResult.m15594constructorimpl(params));
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void close() {
        try {
            Result.Companion companion = Result.Companion;
            ReceivingChannel $this$close_u24lambda_u2d0 = this;
            Result.m8971constructorimpl(Boolean.valueOf(DataChannel.Registry.unregisterReceiver($this$close_u24lambda_u2d0.dataChannelHost, $this$close_u24lambda_u2d0.dataChannelPage, $this$close_u24lambda_u2d0.notifyStateAction)));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        try {
            Result.Companion companion3 = Result.Companion;
            ReceivingChannel $this$close_u24lambda_u2d1 = this;
            Result.m8971constructorimpl(Boolean.valueOf(DataChannel.Registry.unregisterReceiver($this$close_u24lambda_u2d1.dataChannelHost, $this$close_u24lambda_u2d1.dataChannelPage, $this$close_u24lambda_u2d1.notifyInteractAction)));
        } catch (Throwable th3) {
            Result.Companion companion4 = Result.Companion;
            Result.m8971constructorimpl(ResultKt.createFailure(th3));
        }
    }
}
