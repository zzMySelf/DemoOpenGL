package com.baidu.searchbox.aibot.comps.page.states.handler;

import com.baidu.searchbox.aibot.comps.page.AIBotPageComp;
import com.baidu.searchbox.aisearch.comps.conversation.IConversationInteractCallback;
import com.baidu.searchbox.aisearch.comps.conversation.event.EditH5Text;
import com.baidu.searchbox.aisearch.comps.conversation.event.EditPromptTemplate;
import com.baidu.searchbox.aisearch.comps.conversation.event.Fatal;
import com.baidu.searchbox.aisearch.comps.conversation.event.HideKeyboard;
import com.baidu.searchbox.aisearch.comps.conversation.event.HistorySearch;
import com.baidu.searchbox.aisearch.comps.conversation.event.ManifestInfo;
import com.baidu.searchbox.aisearch.comps.conversation.event.NaTransmissionResult;
import com.baidu.searchbox.aisearch.comps.conversation.event.SessionUpdate;
import com.baidu.searchbox.aisearch.comps.conversation.event.ShareResult;
import com.baidu.searchbox.aisearch.comps.conversation.event.ShareStart;
import com.baidu.searchbox.aisearch.comps.conversation.event.ShareStatus;
import com.baidu.searchbox.aisearch.comps.conversation.event.StatInfo;
import com.baidu.searchbox.aisearch.comps.conversation.event.StatPerformance;
import com.baidu.searchbox.aisearch.comps.conversation.event.SwitchSessionResult;
import com.baidu.searchbox.aisearch.comps.conversation.event.UpdateRhetoricalTag;
import com.baidu.searchbox.aisearch.comps.conversation.event.UserStatus;
import com.baidu.searchbox.nacomp.fsm.StateMachine;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\u001d\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u000eH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\fJ\u001d\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0011H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\fJ\u001d\u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0014H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\fJ\u001d\u0010\u0016\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0017H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\fJ\u001d\u0010\u0019\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u001aH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\fJ\u001d\u0010\u001c\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u001dH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\fJ\u001d\u0010\u001f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020 H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\fJ\u001d\u0010\"\u001a\u00020\b2\u0006\u0010\t\u001a\u00020#H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010\fJ\u001d\u0010%\u001a\u00020\b2\u0006\u0010\t\u001a\u00020&H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b'\u0010\fJ\u001d\u0010(\u001a\u00020\b2\u0006\u0010\t\u001a\u00020)H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010\fJ\u001d\u0010+\u001a\u00020\b2\u0006\u0010\t\u001a\u00020,H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b-\u0010\fJ\u001d\u0010.\u001a\u00020\b2\u0006\u0010\t\u001a\u00020/H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u0010\fJ\u001d\u00101\u001a\u00020\b2\u0006\u0010\t\u001a\u000202H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b3\u0010\fJ\u001d\u00104\u001a\u00020\b2\u0006\u0010\t\u001a\u000205H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b6\u0010\fJ\u001d\u00107\u001a\u00020\b2\u0006\u0010\t\u001a\u000208H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b9\u0010\fR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006:"}, d2 = {"Lcom/baidu/searchbox/aibot/comps/page/states/handler/InteractCallbackToMessageHandler;", "Lcom/baidu/searchbox/aisearch/comps/conversation/IConversationInteractCallback;", "owner", "Lcom/baidu/searchbox/aibot/comps/page/AIBotPageComp;", "fsm", "Lcom/baidu/searchbox/nacomp/fsm/StateMachine;", "(Lcom/baidu/searchbox/aibot/comps/page/AIBotPageComp;Lcom/baidu/searchbox/nacomp/fsm/StateMachine;)V", "onEditH5Text", "", "data", "Lcom/baidu/searchbox/aisearch/comps/conversation/event/EditH5Text;", "onEditH5Text-QGkmeEQ", "(Lorg/json/JSONObject;)V", "onEditPromptTemplate", "Lcom/baidu/searchbox/aisearch/comps/conversation/event/EditPromptTemplate;", "onEditPromptTemplate-tSATAGg", "onFatal", "Lcom/baidu/searchbox/aisearch/comps/conversation/event/Fatal;", "onFatal-M0EhBG4", "onHideKeyboard", "Lcom/baidu/searchbox/aisearch/comps/conversation/event/HideKeyboard;", "onHideKeyboard-2dTr3lk", "onHistorySearch", "Lcom/baidu/searchbox/aisearch/comps/conversation/event/HistorySearch;", "onHistorySearch-HOIS_Jk", "onManifestInfo", "Lcom/baidu/searchbox/aisearch/comps/conversation/event/ManifestInfo;", "onManifestInfo-N_bWckc", "onNaTransmissionResult", "Lcom/baidu/searchbox/aisearch/comps/conversation/event/NaTransmissionResult;", "onNaTransmissionResult-Chyjj1Y", "onSessionUpdate", "Lcom/baidu/searchbox/aisearch/comps/conversation/event/SessionUpdate;", "onSessionUpdate-PGpBe2s", "onShareResult", "Lcom/baidu/searchbox/aisearch/comps/conversation/event/ShareResult;", "onShareResult-jY8zBU0", "onShareStart", "Lcom/baidu/searchbox/aisearch/comps/conversation/event/ShareStart;", "onShareStart-AnlCWRQ", "onShareStatus", "Lcom/baidu/searchbox/aisearch/comps/conversation/event/ShareStatus;", "onShareStatus-cMs_18g", "onStatInfo", "Lcom/baidu/searchbox/aisearch/comps/conversation/event/StatInfo;", "onStatInfo-F0nnaMQ", "onStatPerformance", "Lcom/baidu/searchbox/aisearch/comps/conversation/event/StatPerformance;", "onStatPerformance-srYjkBc", "onSwitchSessionResult", "Lcom/baidu/searchbox/aisearch/comps/conversation/event/SwitchSessionResult;", "onSwitchSessionResult-w-KOfGY", "onUpdateRhetoricalTag", "Lcom/baidu/searchbox/aisearch/comps/conversation/event/UpdateRhetoricalTag;", "onUpdateRhetoricalTag-CW9dDqU", "onUserStatus", "Lcom/baidu/searchbox/aisearch/comps/conversation/event/UserStatus;", "onUserStatus-sFJLmL4", "lib-aibot-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: InteractCallbackToMessageHandler.kt */
public final class InteractCallbackToMessageHandler implements IConversationInteractCallback {
    private final StateMachine<AIBotPageComp> fsm;
    private final AIBotPageComp owner;

    public InteractCallbackToMessageHandler(AIBotPageComp owner2, StateMachine<AIBotPageComp> fsm2) {
        Intrinsics.checkNotNullParameter(owner2, "owner");
        Intrinsics.checkNotNullParameter(fsm2, "fsm");
        this.owner = owner2;
        this.fsm = fsm2;
    }

    /* renamed from: onShareStart-AnlCWRQ  reason: not valid java name */
    public void m14901onShareStartAnlCWRQ(JSONObject data) {
        this.fsm.handleMessage(ShareStart.m15550boximpl(data));
    }

    /* renamed from: onShareStatus-cMs_18g  reason: not valid java name */
    public void m14902onShareStatuscMs_18g(JSONObject data) {
        this.fsm.handleMessage(ShareStatus.m15557boximpl(data));
    }

    /* renamed from: onShareResult-jY8zBU0  reason: not valid java name */
    public void m14900onShareResultjY8zBU0(JSONObject data) {
        this.fsm.handleMessage(ShareResult.m15542boximpl(data));
    }

    /* renamed from: onUserStatus-sFJLmL4  reason: not valid java name */
    public void m14907onUserStatussFJLmL4(JSONObject data) {
        this.fsm.handleMessage(UserStatus.m15609boximpl(data));
    }

    /* renamed from: onStatInfo-F0nnaMQ  reason: not valid java name */
    public void m14903onStatInfoF0nnaMQ(JSONObject data) {
        this.fsm.handleMessage(StatInfo.m15565boximpl(data));
    }

    /* renamed from: onEditPromptTemplate-tSATAGg  reason: not valid java name */
    public void m14893onEditPromptTemplatetSATAGg(JSONObject data) {
        this.fsm.handleMessage(EditPromptTemplate.m15449boximpl(data));
    }

    /* renamed from: onSwitchSessionResult-w-KOfGY  reason: not valid java name */
    public void m14905onSwitchSessionResultwKOfGY(JSONObject data) {
        this.fsm.handleMessage(SwitchSessionResult.m15593boximpl(data));
    }

    /* renamed from: onSessionUpdate-PGpBe2s  reason: not valid java name */
    public void m14899onSessionUpdatePGpBe2s(JSONObject data) {
        this.fsm.handleMessage(SessionUpdate.m15534boximpl(data));
    }

    /* renamed from: onHistorySearch-HOIS_Jk  reason: not valid java name */
    public void m14896onHistorySearchHOIS_Jk(JSONObject data) {
        this.fsm.handleMessage(HistorySearch.m15500boximpl(data));
    }

    /* renamed from: onStatPerformance-srYjkBc  reason: not valid java name */
    public void m14904onStatPerformancesrYjkBc(JSONObject data) {
        this.fsm.handleMessage(StatPerformance.m15575boximpl(data));
    }

    /* renamed from: onNaTransmissionResult-Chyjj1Y  reason: not valid java name */
    public void m14898onNaTransmissionResultChyjj1Y(JSONObject data) {
        this.fsm.handleMessage(NaTransmissionResult.m15514boximpl(data));
    }

    /* renamed from: onEditH5Text-QGkmeEQ  reason: not valid java name */
    public void m14892onEditH5TextQGkmeEQ(JSONObject data) {
        this.fsm.handleMessage(EditH5Text.m15441boximpl(data));
    }

    /* renamed from: onManifestInfo-N_bWckc  reason: not valid java name */
    public void m14897onManifestInfoN_bWckc(JSONObject data) {
        this.fsm.handleMessage(ManifestInfo.m15507boximpl(data));
    }

    /* renamed from: onFatal-M0EhBG4  reason: not valid java name */
    public void m14894onFatalM0EhBG4(JSONObject data) {
        this.fsm.handleMessage(Fatal.m15468boximpl(data));
    }

    /* renamed from: onUpdateRhetoricalTag-CW9dDqU  reason: not valid java name */
    public void m14906onUpdateRhetoricalTagCW9dDqU(JSONObject data) {
        this.fsm.handleMessage(UpdateRhetoricalTag.m15602boximpl(data));
    }

    /* renamed from: onHideKeyboard-2dTr3lk  reason: not valid java name */
    public void m14895onHideKeyboard2dTr3lk(JSONObject data) {
        this.fsm.handleMessage(HideKeyboard.m15493boximpl(data));
    }
}
