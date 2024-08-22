package com.baidu.growthsystem.wealth.common.popup;

import android.util.Log;
import com.baidu.growthsystem.wealth.common.constant.WealthVideoDialogUbcConstantKt;
import com.baidu.growthsystem.wealth.common.constant.WealthVideoYalogConstantKt;
import com.baidu.growthsystem.wealth.common.popup.base.biz.IWealthVideoDialogBizCallback;
import com.baidu.growthsystem.wealth.common.popup.base.biz.IWealthVideoDialogBizListener;
import com.baidu.growthsystem.wealth.common.popup.base.biz.WealthVideoDialogBizModel;
import com.baidu.growthsystem.wealth.common.popup.base.biz.WealthVideoDialogBizResult;
import com.baidu.growthsystem.wealth.common.popup.base.request.WealthVideoDialogRequestConfig;
import com.baidu.growthsystem.wealth.common.popup.model.WealthVideoDialogModel;
import com.baidu.growthsystem.wealth.common.popup.util.WealthVideoDialogNetUtilKt;
import com.baidu.growthsystem.wealth.common.popup.util.WealthVideoDialogYalogUtilKt;
import com.baidu.growthsystem.wealth.common.ubc.WealthVideoSceneUBCUtilKt;
import com.baidu.growthsystem.wealth.common.util.WealthVideoDialogUbcUtilKt;
import com.baidu.growthsystem.wealth.common.util.WealthVideoYalogUtilKt;
import com.baidu.growthsystem.wealth.context.popupinterceptor.DialogPopupInterceptResult;
import com.baidu.growthsystem.wealth.context.popupinterceptor.IDialogPopupInterceptor;
import com.baidu.growthsystem.wealth.dialog.seq.IWealthTaskDialogSeqCallback;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u000f\u001a\u00020\u0002H\u0016J\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J5\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001c2#\u0010\u001d\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0017¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00110\u001eH\u0002J\u0006\u0010!\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/baidu/growthsystem/wealth/common/popup/WealthVideoDialogTask;", "Ljava/util/concurrent/Callable;", "Lcom/baidu/growthsystem/wealth/common/popup/base/biz/WealthVideoDialogBizResult;", "bizListener", "Lcom/baidu/growthsystem/wealth/common/popup/base/biz/IWealthVideoDialogBizListener;", "config", "Lcom/baidu/growthsystem/wealth/common/popup/base/request/WealthVideoDialogRequestConfig;", "model", "Lcom/baidu/growthsystem/wealth/common/popup/model/WealthVideoDialogModel;", "passive", "", "(Lcom/baidu/growthsystem/wealth/common/popup/base/biz/IWealthVideoDialogBizListener;Lcom/baidu/growthsystem/wealth/common/popup/base/request/WealthVideoDialogRequestConfig;Lcom/baidu/growthsystem/wealth/common/popup/model/WealthVideoDialogModel;Z)V", "isRunning", "waitCheckInterceptedLatch", "Ljava/util/concurrent/CountDownLatch;", "call", "cancel", "", "executeDialogBizLogic", "bizCallback", "Lcom/baidu/growthsystem/wealth/common/popup/base/biz/IWealthVideoDialogBizCallback;", "executeDialogBizLogicNow", "data", "Lorg/json/JSONObject;", "getPopupDialogInterceptResult", "Lcom/baidu/growthsystem/wealth/context/popupinterceptor/DialogPopupInterceptResult;", "requestData", "type", "", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "tryShowNextDialogImmediately", "wealth-task-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WealthVideoDialogTask.kt */
public final class WealthVideoDialogTask implements Callable<WealthVideoDialogBizResult> {
    private final IWealthVideoDialogBizListener bizListener;
    private final WealthVideoDialogRequestConfig config;
    private volatile boolean isRunning;
    private final WealthVideoDialogModel model;
    private final boolean passive;
    private CountDownLatch waitCheckInterceptedLatch;

    public WealthVideoDialogTask(IWealthVideoDialogBizListener bizListener2, WealthVideoDialogRequestConfig config2, WealthVideoDialogModel model2, boolean passive2) {
        Intrinsics.checkNotNullParameter(bizListener2, "bizListener");
        Intrinsics.checkNotNullParameter(config2, "config");
        Intrinsics.checkNotNullParameter(model2, "model");
        this.bizListener = bizListener2;
        this.config = config2;
        this.model = model2;
        this.passive = passive2;
    }

    public WealthVideoDialogBizResult call() {
        Object obj;
        this.isRunning = true;
        if (WealthVideoDialogTaskKt.DEBUG) {
            Log.d("WealthVideoDialogTask", "Dialog task start: type = " + this.model.getType());
        }
        Ref.ObjectRef dialogBizResult = new Ref.ObjectRef();
        dialogBizResult.element = new WealthVideoDialogBizResult.Builder().build();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        WealthVideoDialogTask$call$callback$1 callback = new WealthVideoDialogTask$call$callback$1(dialogBizResult, countDownLatch);
        try {
            Result.Companion companion = Result.Companion;
            executeDialogBizLogic(callback);
            countDownLatch.await();
            obj = Result.m8971constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable it = Result.m8974exceptionOrNullimpl(obj);
        if (it != null && (it instanceof InterruptedException)) {
            if (WealthVideoDialogTaskKt.DEBUG) {
                Log.d("WealthVideoDialogTask", "Dialog task cancel: type = " + this.model.getType());
            }
            this.bizListener.onCancelled();
        }
        this.isRunning = false;
        if (WealthVideoDialogTaskKt.DEBUG) {
            Log.d("WealthVideoDialogTask", "Dialog task finish: type = " + this.model.getType());
        }
        return (WealthVideoDialogBizResult) dialogBizResult.element;
    }

    public final void tryShowNextDialogImmediately() {
        CountDownLatch countDownLatch = this.waitCheckInterceptedLatch;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
        if (WealthVideoDialogTaskKt.DEBUG) {
            Log.d("WealthVideoDialogTask", "Try show next dialog immediately");
        }
    }

    public final void cancel() {
        this.bizListener.onCancelled();
        this.isRunning = false;
    }

    private final void executeDialogBizLogic(IWealthVideoDialogBizCallback bizCallback) {
        if (WealthVideoDialogTaskKt.DEBUG) {
            Log.d("WealthVideoDialogTask", "Execute dialog biz logic: type = " + this.model.getType() + ", real time = " + this.model.isRealtime());
        }
        if (!Intrinsics.areEqual((Object) this.model.isRealtime(), (Object) "1")) {
            executeDialogBizLogicNow(this.model.getData(), bizCallback);
        } else {
            requestData(this.model.getType(), new WealthVideoDialogTask$executeDialogBizLogic$1(bizCallback, this));
        }
    }

    /* access modifiers changed from: private */
    public final void executeDialogBizLogicNow(JSONObject data, IWealthVideoDialogBizCallback bizCallback) {
        DialogPopupInterceptResult dialogInterceptResult = getPopupDialogInterceptResult();
        if (!dialogInterceptResult.getShowAble()) {
            if (WealthVideoDialogTaskKt.DEBUG) {
                Log.d("WealthVideoDialogTask", "No need to execute dialog logic since dialog is intercepted: ubc value = " + dialogInterceptResult.getUbcValue() + ", msg = " + dialogInterceptResult.getMsg());
            }
            IWealthTaskDialogSeqCallback dialogSeqCallback = this.config.getDialogSeqCallback();
            if (dialogSeqCallback != null) {
                dialogSeqCallback.onIntercepted();
            }
            bizCallback.onFinished(IWealthVideoDialogBizCallback.ActionCode.CANCEL);
            WealthVideoDialogUbcUtilKt.ubcOnDialogIntercepted(this.model.getType(), dialogInterceptResult.getUbcValue(), WealthVideoSceneUBCUtilKt.getUbcPage(this.config.getSceneModel()), WealthVideoSceneUBCUtilKt.addSceneExtParams(this.config.getSceneModel()));
            WealthVideoDialogYalogUtilKt.logOnDialogSequenceExecute(WealthVideoYalogConstantKt.YALOG_VALUE_ACTION_SEQ_INTERCEPTED, WealthVideoYalogUtilKt.toYalogJson(dialogInterceptResult));
        } else if (this.isRunning) {
            this.bizListener.onExecuted(new WealthVideoDialogBizModel(data, bizCallback, this.config, this.passive));
        } else if (WealthVideoDialogTaskKt.DEBUG) {
            Log.d("WealthVideoDialogTask", "No need to execute dialog logic since task is not running");
        }
    }

    private final void requestData(String type, Function1<? super JSONObject, Unit> callback) {
        WealthVideoDialogNetUtilKt.requestDialogData(type, this.config.getSceneModel(), new WealthVideoDialogTask$requestData$1(type, callback));
    }

    private final DialogPopupInterceptResult getPopupDialogInterceptResult() {
        DialogPopupInterceptResult showAbleWithReason;
        CountDownLatch latch = new CountDownLatch(1);
        this.waitCheckInterceptedLatch = latch;
        try {
            Result.Companion companion = Result.Companion;
            WealthVideoDialogTask wealthVideoDialogTask = this;
            boolean result = latch.await(100, TimeUnit.MILLISECONDS);
            if (WealthVideoDialogTaskKt.DEBUG) {
                Log.d("WealthVideoDialogTask", "Popup interception check latch: " + (result ? "the count reached zero" : "waiting time elapsed"));
            }
            Result.m8971constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        this.waitCheckInterceptedLatch = null;
        IDialogPopupInterceptor $this$getPopupDialogInterceptResult_u24lambda_u2d4 = this.config.getPopupInterceptor();
        if ($this$getPopupDialogInterceptResult_u24lambda_u2d4 == null || (showAbleWithReason = $this$getPopupDialogInterceptResult_u24lambda_u2d4.showAbleWithReason()) == null) {
            return new DialogPopupInterceptResult(false, WealthVideoDialogUbcConstantKt.UBC_VALUE_INTERCEPTOR_NOT_DEFINED, "未定义弹窗拦截器");
        }
        return showAbleWithReason;
    }
}
