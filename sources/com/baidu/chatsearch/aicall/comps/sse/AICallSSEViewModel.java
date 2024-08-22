package com.baidu.chatsearch.aicall.comps.sse;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.chatsearch.aicall.comps.page.ReqInfo;
import com.baidu.chatsearch.aicall.comps.sse.models.LiveFigureInfo;
import com.baidu.chatsearch.aicall.comps.sse.models.SSEContentCommand;
import com.baidu.chatsearch.aicall.comps.sse.models.SSEEventResponse;
import com.baidu.chatsearch.aicall.comps.sse.models.SSELiveFigureInfoCommand;
import com.baidu.chatsearch.aicall.comps.sse.models.SSEMessageCommand;
import com.baidu.chatsearch.aicall.comps.sse.models.SSERequestCommand;
import com.baidu.chatsearch.aicall.comps.sse.models.SSEResponseError;
import com.baidu.chatsearch.aicall.comps.sse.models.SSETextQueryCommand;
import com.baidu.chatsearch.aicall.comps.sse.models.SSETtsResultModel;
import com.baidu.chatsearch.aicall.repo.AICallSSEResult;
import com.baidu.chatsearch.aicall.statistic.AICallUbcExceptionUtils;
import com.baidu.chatsearch.aicall.utils.LinkUtilsKt;
import com.baidu.searchbox.aicall.yalog.AICallYalog;
import com.baidu.searchbox.nacomp.mvvm.impl.BaseViewModel;
import com.baidu.searchbox.util.BaiduIdentityManager;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.subscriptions.CompositeSubscription;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\u0018\u0000 52\u00020\u0001:\u000245B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\b\u0010\u001f\u001a\u00020\u001dH\u0007J\b\u0010 \u001a\u00020\u001dH\u0002J\u001c\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#H\u0002J\b\u0010%\u001a\u00020\u001dH\u0002J\u0012\u0010&\u001a\u00020\u001d2\b\u0010'\u001a\u0004\u0018\u00010(H\u0002J\b\u0010)\u001a\u00020\u001dH\u0014J\b\u0010*\u001a\u00020\u001dH\u0002J\b\u0010+\u001a\u00020\u001dH\u0002J<\u0010,\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020#2\n\b\u0002\u00100\u001a\u0004\u0018\u0001012\u0016\b\u0002\u00102\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020#\u0018\u000103H\u0007R\u0014\u0010\u0005\u001a\b\u0018\u00010\u0006R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0018\u00010\u0006R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/baidu/chatsearch/aicall/comps/sse/AICallSSEViewModel;", "Lcom/baidu/searchbox/nacomp/mvvm/impl/BaseViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "connectTimeoutRunnable", "Lcom/baidu/chatsearch/aicall/comps/sse/AICallSSEViewModel$CancelSSETimeoutRunnable;", "generatorTimeoutRunnable", "isCompleted", "", "isFirstResponse", "onFirstError", "Landroidx/lifecycle/MutableLiveData;", "Lorg/json/JSONObject;", "getOnFirstError", "()Landroidx/lifecycle/MutableLiveData;", "onOpen", "", "getOnOpen", "onRequestStart", "getOnRequestStart", "result", "Lcom/baidu/chatsearch/aicall/comps/sse/models/SSETtsResultModel;", "getResult", "sseRepo", "Lcom/baidu/chatsearch/aicall/comps/sse/AICallSSEApiService;", "subscription", "Lrx/subscriptions/CompositeSubscription;", "cancelConnectTimeout", "", "cancelGeneratorTimeout", "cancelRequest", "dispatchComplete", "dispatchFirstResponseError", "error", "", "status", "dispatcherError", "dispatcherResult", "ttsResult", "Lcom/baidu/chatsearch/aicall/comps/sse/models/SSEEventResponse;", "onCleared", "startConnectTimeout", "startGeneratorTimeout", "startRequest", "reqInfo", "Lcom/baidu/chatsearch/aicall/comps/page/ReqInfo;", "text", "liveFigureInfo", "Lcom/baidu/chatsearch/aicall/comps/sse/models/LiveFigureInfo;", "extParam", "", "CancelSSETimeoutRunnable", "Companion", "lib-chatsearch-aicall-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AICallSSEViewModel.kt */
public final class AICallSSEViewModel extends BaseViewModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "AICallSSEViewModel";
    private static final long TIMEOUT_GENERATOR = 200000;
    private static final long TIMEOUT_REQUEST = 10000;
    private CancelSSETimeoutRunnable connectTimeoutRunnable;
    private CancelSSETimeoutRunnable generatorTimeoutRunnable;
    private boolean isCompleted;
    private boolean isFirstResponse = true;
    private final MutableLiveData<JSONObject> onFirstError = new MutableLiveData<>();
    private final MutableLiveData<Object> onOpen = new MutableLiveData<>();
    private final MutableLiveData<Object> onRequestStart = new MutableLiveData<>();
    private final MutableLiveData<SSETtsResultModel> result = new MutableLiveData<>();
    private final AICallSSEApiService sseRepo = new AICallSSEApiService();
    private final CompositeSubscription subscription = new CompositeSubscription();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AICallSSEViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
    }

    public final MutableLiveData<SSETtsResultModel> getResult() {
        return this.result;
    }

    public final MutableLiveData<Object> getOnRequestStart() {
        return this.onRequestStart;
    }

    public final MutableLiveData<Object> getOnOpen() {
        return this.onOpen;
    }

    public final MutableLiveData<JSONObject> getOnFirstError() {
        return this.onFirstError;
    }

    public static /* synthetic */ void startRequest$default(AICallSSEViewModel aICallSSEViewModel, ReqInfo reqInfo, String str, LiveFigureInfo liveFigureInfo, Map map, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            liveFigureInfo = null;
        }
        if ((i2 & 8) != 0) {
            map = null;
        }
        aICallSSEViewModel.startRequest(reqInfo, str, liveFigureInfo, map);
    }

    public final void startRequest(ReqInfo reqInfo, String text, LiveFigureInfo liveFigureInfo, Map<String, String> extParam) {
        Object obj;
        Intrinsics.checkNotNullParameter(reqInfo, "reqInfo");
        Intrinsics.checkNotNullParameter(text, "text");
        cancelRequest();
        this.isCompleted = false;
        this.isFirstResponse = true;
        try {
            Result.Companion companion = Result.Companion;
            String sessionId = reqInfo.getSessionId();
            JSONObject jSONObject = new JSONObject(reqInfo.getBusinessParams());
            String source = reqInfo.getSource();
            SSEContentCommand r7 = SSEContentCommand.m13071boximpl(SSEContentCommand.m13072constructorimpl(SSETextQueryCommand.m13088boximpl(SSETextQueryCommand.Companion.m13096createycDOBSU(text))));
            JSONObject r8 = SSELiveFigureInfoCommand.Companion.m13087createEnkvEwA(liveFigureInfo);
            SSERequestCommand requestCommand = new SSERequestCommand(sessionId, new SSEMessageCommand(jSONObject, source, r7, r8 != null ? SSELiveFigureInfoCommand.m13079boximpl(r8) : null));
            this.onRequestStart.setValue(new Object());
            String requestUrl = BaiduIdentityManager.getInstance().appendParam(LinkUtilsKt.appendParams(reqInfo.getReqUrl(), extParam), 1, true, true);
            CompositeSubscription compositeSubscription = this.subscription;
            AICallSSEApiService aICallSSEApiService = this.sseRepo;
            Intrinsics.checkNotNullExpressionValue(requestUrl, "requestUrl");
            Subscription subscribe = aICallSSEApiService.sendTextMessage(requestUrl, requestCommand, new AICallSSEViewModel$startRequest$1$1(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new AICallSSEViewModel$$ExternalSyntheticLambda0(this), new AICallSSEViewModel$$ExternalSyntheticLambda1(this), new AICallSSEViewModel$$ExternalSyntheticLambda2(this));
            Subscription subscription2 = subscribe;
            startConnectTimeout();
            compositeSubscription.add(subscribe);
            obj = Result.m8971constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m8974exceptionOrNullimpl(obj) != null) {
            AICallYalog.INSTANCE.i(TAG, "startRequest error");
            dispatcherError();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: startRequest$lambda-4$lambda-0  reason: not valid java name */
    public static final void m13051startRequest$lambda4$lambda0(AICallSSEViewModel this$0, AICallSSEResult it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.cancelConnectTimeout();
        this$0.startGeneratorTimeout();
        this$0.dispatcherResult(it != null ? (SSEEventResponse) it.getData() : null);
    }

    /* access modifiers changed from: private */
    /* renamed from: startRequest$lambda-4$lambda-1  reason: not valid java name */
    public static final void m13052startRequest$lambda4$lambda1(AICallSSEViewModel this$0, Throwable it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dispatcherError();
        this$0.cancelConnectTimeout();
        this$0.cancelGeneratorTimeout();
    }

    /* access modifiers changed from: private */
    /* renamed from: startRequest$lambda-4$lambda-2  reason: not valid java name */
    public static final void m13053startRequest$lambda4$lambda2(AICallSSEViewModel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dispatchComplete();
        this$0.cancelConnectTimeout();
        this$0.cancelGeneratorTimeout();
    }

    private final void dispatcherResult(SSEEventResponse ttsResult) {
        Unit unit;
        SSEEventResponse $this$dispatcherResult_u24lambda_u2d9;
        boolean z = false;
        if (ttsResult != null) {
            SSEEventResponse $this$dispatcherResult_u24lambda_u2d92 = ttsResult;
            List<String> ttsTextList = $this$dispatcherResult_u24lambda_u2d92.getTtsTextList();
            boolean isFinish = !$this$dispatcherResult_u24lambda_u2d92.isSuccess() || $this$dispatcherResult_u24lambda_u2d92.isEndTurn();
            if (Intrinsics.areEqual((Object) $this$dispatcherResult_u24lambda_u2d92.getStatus(), (Object) "0") && $this$dispatcherResult_u24lambda_u2d92.getData() == null) {
                AICallUbcExceptionUtils.ubcExceptionUpload$default(AICallUbcExceptionUtils.INSTANCE, AICallUbcExceptionUtils.TYPE_CONVERSATION, AICallUbcExceptionUtils.EXT_TYPE_RESP_MODEL, (JSONObject) null, 4, (Object) null);
                dispatchFirstResponseError$default(this, AICallUbcExceptionUtils.EXT_TYPE_RESP_MODEL, (String) null, 2, (Object) null);
            } else if (!Intrinsics.areEqual((Object) $this$dispatcherResult_u24lambda_u2d92.getStatus(), (Object) "0")) {
                AICallUbcExceptionUtils aICallUbcExceptionUtils = AICallUbcExceptionUtils.INSTANCE;
                JSONObject $this$dispatcherResult_u24lambda_u2d9_u24lambda_u2d6 = new JSONObject();
                $this$dispatcherResult_u24lambda_u2d9_u24lambda_u2d6.put("code", $this$dispatcherResult_u24lambda_u2d92.getStatus());
                Unit unit2 = Unit.INSTANCE;
                aICallUbcExceptionUtils.ubcExceptionUpload(AICallUbcExceptionUtils.TYPE_CONVERSATION, AICallUbcExceptionUtils.EXT_TYPE_STATUS, $this$dispatcherResult_u24lambda_u2d9_u24lambda_u2d6);
                dispatchFirstResponseError(AICallUbcExceptionUtils.EXT_TYPE_STATUS, $this$dispatcherResult_u24lambda_u2d92.getStatus());
            }
            if (!isFinish) {
                Collection collection = ttsTextList;
                if (collection == null || collection.isEmpty()) {
                    AICallYalog.INSTANCE.i(TAG, "dispatcherResult: filter success but no tts text");
                    return;
                }
            }
            if (!Intrinsics.areEqual((Object) $this$dispatcherResult_u24lambda_u2d92.getStatus(), (Object) "0") || $this$dispatcherResult_u24lambda_u2d92.getData() != null) {
                String errorType = SSEResponseError.Companion.convertErrorType($this$dispatcherResult_u24lambda_u2d92.getStatus());
                if (ttsTextList != null) {
                    for (String it : ttsTextList) {
                        if (it.length() > 0 ? true : z) {
                            MutableLiveData<SSETtsResultModel> mutableLiveData = this.result;
                            SSETtsResultModel $this$dispatcherResult_u24lambda_u2d9_u24lambda_u2d8_u24lambda_u2d7 = SSETtsResultModel.Companion.create(it, z, errorType);
                            $this$dispatcherResult_u24lambda_u2d9 = $this$dispatcherResult_u24lambda_u2d92;
                            $this$dispatcherResult_u24lambda_u2d9_u24lambda_u2d8_u24lambda_u2d7.setMsgId($this$dispatcherResult_u24lambda_u2d92.getTtsMsgId());
                            mutableLiveData.setValue($this$dispatcherResult_u24lambda_u2d9_u24lambda_u2d8_u24lambda_u2d7);
                            this.isFirstResponse = false;
                        } else {
                            $this$dispatcherResult_u24lambda_u2d9 = $this$dispatcherResult_u24lambda_u2d92;
                        }
                        AICallYalog.INSTANCE.i(TAG, "dispatcherResult: " + it);
                        $this$dispatcherResult_u24lambda_u2d92 = $this$dispatcherResult_u24lambda_u2d9;
                        z = false;
                    }
                }
                if (isFinish) {
                    AICallYalog.INSTANCE.i(TAG, "dispatcherResult finish");
                    this.result.setValue(SSETtsResultModel.Companion.create((String) null, true, errorType));
                    cancelRequest();
                }
                unit = Unit.INSTANCE;
            } else {
                dispatcherError();
                return;
            }
        } else {
            unit = null;
        }
        if (unit == null) {
            AICallSSEViewModel $this$dispatcherResult_u24lambda_u2d10 = this;
            AICallUbcExceptionUtils.ubcExceptionUpload$default(AICallUbcExceptionUtils.INSTANCE, AICallUbcExceptionUtils.TYPE_CONVERSATION, AICallUbcExceptionUtils.EXT_TYPE_RESP_MODEL, (JSONObject) null, 4, (Object) null);
            dispatchFirstResponseError$default($this$dispatcherResult_u24lambda_u2d10, AICallUbcExceptionUtils.EXT_TYPE_RESP_MODEL, (String) null, 2, (Object) null);
            $this$dispatcherResult_u24lambda_u2d10.isFirstResponse = false;
        }
    }

    private final void dispatchComplete() {
        if (!this.isCompleted) {
            AICallYalog.INSTANCE.i(TAG, "dispatcherError");
            cancelRequest();
            this.result.setValue(SSETtsResultModel.Companion.create$default(SSETtsResultModel.Companion, (String) null, true, (String) null, 4, (Object) null));
        }
    }

    /* access modifiers changed from: private */
    public final void dispatcherError() {
        String state;
        if (!this.isCompleted) {
            AICallYalog.INSTANCE.i(TAG, "dispatcherError");
            if (NetWorkUtils.isNetworkConnected()) {
                AICallUbcExceptionUtils.ubcExceptionUpload$default(AICallUbcExceptionUtils.INSTANCE, AICallUbcExceptionUtils.TYPE_CONVERSATION, AICallUbcExceptionUtils.EXT_TYPE_SSE, (JSONObject) null, 4, (Object) null);
                dispatchFirstResponseError$default(this, AICallUbcExceptionUtils.EXT_TYPE_SSE, (String) null, 2, (Object) null);
                state = "-1001";
            } else {
                dispatchFirstResponseError$default(this, AICallUbcExceptionUtils.EXT_TYPE_NETWORK, (String) null, 2, (Object) null);
                AICallUbcExceptionUtils.ubcExceptionUpload$default(AICallUbcExceptionUtils.INSTANCE, AICallUbcExceptionUtils.TYPE_CONVERSATION, AICallUbcExceptionUtils.EXT_TYPE_NETWORK, (JSONObject) null, 4, (Object) null);
                state = "-1000";
            }
            cancelRequest();
            this.result.setValue(SSETtsResultModel.Companion.create((String) null, true, SSEResponseError.Companion.convertErrorType(state)));
        }
    }

    static /* synthetic */ void dispatchFirstResponseError$default(AICallSSEViewModel aICallSSEViewModel, String str, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        aICallSSEViewModel.dispatchFirstResponseError(str, str2);
    }

    private final void dispatchFirstResponseError(String error, String status) {
        if (this.isFirstResponse) {
            MutableLiveData<JSONObject> mutableLiveData = this.onFirstError;
            JSONObject jSONObject = new JSONObject();
            JSONObject $this$dispatchFirstResponseError_u24lambda_u2d13 = jSONObject;
            $this$dispatchFirstResponseError_u24lambda_u2d13.put("type", error);
            if (status != null) {
                String str = status;
                JSONObject $this$dispatchFirstResponseError_u24lambda_u2d13_u24lambda_u2d12_u24lambda_u2d11 = new JSONObject();
                $this$dispatchFirstResponseError_u24lambda_u2d13_u24lambda_u2d12_u24lambda_u2d11.put("code", status);
                Unit unit = Unit.INSTANCE;
                $this$dispatchFirstResponseError_u24lambda_u2d13.put("info", $this$dispatchFirstResponseError_u24lambda_u2d13_u24lambda_u2d12_u24lambda_u2d11);
            }
            mutableLiveData.setValue(jSONObject);
        }
    }

    private final void startConnectTimeout() {
        cancelConnectTimeout();
        CancelSSETimeoutRunnable runnable = new CancelSSETimeoutRunnable(this, this, "Connect");
        this.connectTimeoutRunnable = runnable;
        UiThreadUtils.getMainHandler().postDelayed(runnable, 10000);
        AICallYalog.INSTANCE.i(TAG, "startConnectTimeout");
    }

    /* access modifiers changed from: private */
    public final void cancelConnectTimeout() {
        CancelSSETimeoutRunnable $this$cancelConnectTimeout_u24lambda_u2d14 = this.connectTimeoutRunnable;
        if ($this$cancelConnectTimeout_u24lambda_u2d14 != null) {
            UiThreadUtils.getMainHandler().removeCallbacks($this$cancelConnectTimeout_u24lambda_u2d14);
            AICallYalog.INSTANCE.i(TAG, "cancelConnectTimeout");
        }
        this.connectTimeoutRunnable = null;
    }

    /* access modifiers changed from: private */
    public final void startGeneratorTimeout() {
        cancelGeneratorTimeout();
        CancelSSETimeoutRunnable runnable = new CancelSSETimeoutRunnable(this, this, "Generator");
        this.generatorTimeoutRunnable = runnable;
        UiThreadUtils.getMainHandler().postDelayed(runnable, TIMEOUT_GENERATOR);
        AICallYalog.INSTANCE.i(TAG, "startGeneratorTimeout");
    }

    private final void cancelGeneratorTimeout() {
        CancelSSETimeoutRunnable $this$cancelGeneratorTimeout_u24lambda_u2d15 = this.generatorTimeoutRunnable;
        if ($this$cancelGeneratorTimeout_u24lambda_u2d15 != null) {
            UiThreadUtils.getMainHandler().removeCallbacks($this$cancelGeneratorTimeout_u24lambda_u2d15);
            AICallYalog.INSTANCE.i(TAG, "cancelGeneratorTimeout");
        }
        this.generatorTimeoutRunnable = null;
    }

    public final void cancelRequest() {
        cancelConnectTimeout();
        cancelGeneratorTimeout();
        this.subscription.clear();
        this.sseRepo.cancelRequest();
        this.isCompleted = true;
        this.isFirstResponse = true;
        AICallYalog.INSTANCE.i(TAG, "cancelRequest");
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        this.subscription.unsubscribe();
        cancelRequest();
        super.onCleared();
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0007\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00030\u00030\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/baidu/chatsearch/aicall/comps/sse/AICallSSEViewModel$CancelSSETimeoutRunnable;", "Ljava/lang/Runnable;", "viewModel", "Lcom/baidu/chatsearch/aicall/comps/sse/AICallSSEViewModel;", "tag", "", "(Lcom/baidu/chatsearch/aicall/comps/sse/AICallSSEViewModel;Lcom/baidu/chatsearch/aicall/comps/sse/AICallSSEViewModel;Ljava/lang/String;)V", "viewModelRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "getViewModelRef", "()Ljava/lang/ref/WeakReference;", "run", "", "lib-chatsearch-aicall-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AICallSSEViewModel.kt */
    private final class CancelSSETimeoutRunnable implements Runnable {
        private final String tag;
        final /* synthetic */ AICallSSEViewModel this$0;
        private final WeakReference<AICallSSEViewModel> viewModelRef;

        public CancelSSETimeoutRunnable(AICallSSEViewModel this$02, AICallSSEViewModel viewModel, String tag2) {
            Intrinsics.checkNotNullParameter(viewModel, "viewModel");
            Intrinsics.checkNotNullParameter(tag2, "tag");
            this.this$0 = this$02;
            this.tag = tag2;
            this.viewModelRef = new WeakReference<>(viewModel);
        }

        public final WeakReference<AICallSSEViewModel> getViewModelRef() {
            return this.viewModelRef;
        }

        public void run() {
            AICallYalog.INSTANCE.i(AICallSSEViewModel.TAG, "run timer " + this.tag);
            AICallSSEViewModel aICallSSEViewModel = (AICallSSEViewModel) this.viewModelRef.get();
            if (aICallSSEViewModel != null) {
                aICallSSEViewModel.dispatcherError();
            }
            AICallSSEViewModel aICallSSEViewModel2 = (AICallSSEViewModel) this.viewModelRef.get();
            if (aICallSSEViewModel2 != null) {
                aICallSSEViewModel2.cancelRequest();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/baidu/chatsearch/aicall/comps/sse/AICallSSEViewModel$Companion;", "", "()V", "TAG", "", "TIMEOUT_GENERATOR", "", "TIMEOUT_REQUEST", "lib-chatsearch-aicall-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AICallSSEViewModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
