package com.baidu.chatsearch.aicall.comps.sse;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import com.baidu.chatsearch.aicall.comps.page.AICallPageParams;
import com.baidu.chatsearch.aicall.comps.sse.models.LiveFigureInfo;
import com.baidu.chatsearch.aicall.comps.sse.models.SSETtsResultModel;
import com.baidu.searchbox.nacomp.extension.base.BaseExtSlaveComponent;
import com.baidu.searchbox.nacomp.mvvm.impl.LifecycleComponent;
import com.baidu.searchbox.nacomp.mvvm.impl.ViewModelProviders;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010'\u001a\u00020\rH\u0007J\u0010\u0010(\u001a\u00020\r2\u0006\u0010)\u001a\u00020\u001cH\u0002J\u0018\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010,\u001a\u00020\u0002H\u0016J\b\u0010-\u001a\u00020\rH\u0016J\u0010\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u000200H\u0007J\b\u00101\u001a\u00020\rH\u0007R(\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R(\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000f\"\u0004\b\u001e\u0010\u0011R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001f\u001a\u0004\u0018\u00010 8BX\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b!\u0010\"R\u000e\u0010%\u001a\u00020&X\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/baidu/chatsearch/aicall/comps/sse/AICallSSEComp;", "Lcom/baidu/searchbox/nacomp/extension/base/BaseExtSlaveComponent;", "Lcom/baidu/chatsearch/aicall/comps/sse/AICallSSEViewModel;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "view", "Landroid/view/View;", "pageParams", "Lcom/baidu/chatsearch/aicall/comps/page/AICallPageParams;", "(Landroidx/lifecycle/LifecycleOwner;Landroid/view/View;Lcom/baidu/chatsearch/aicall/comps/page/AICallPageParams;)V", "onFirstResponseError", "Lkotlin/Function1;", "Lorg/json/JSONObject;", "", "getOnFirstResponseError$lib_chatsearch_aicall_impl_release", "()Lkotlin/jvm/functions/Function1;", "setOnFirstResponseError$lib_chatsearch_aicall_impl_release", "(Lkotlin/jvm/functions/Function1;)V", "onOpen", "Lkotlin/Function0;", "getOnOpen$lib_chatsearch_aicall_impl_release", "()Lkotlin/jvm/functions/Function0;", "setOnOpen$lib_chatsearch_aicall_impl_release", "(Lkotlin/jvm/functions/Function0;)V", "onRequestStart", "getOnRequestStart$lib_chatsearch_aicall_impl_release", "setOnRequestStart$lib_chatsearch_aicall_impl_release", "onResult", "Lcom/baidu/chatsearch/aicall/comps/sse/models/SSETtsResultModel;", "getOnResult$lib_chatsearch_aicall_impl_release", "setOnResult$lib_chatsearch_aicall_impl_release", "sendingChannel", "Lcom/baidu/chatsearch/aicall/comps/sse/SendingChannel;", "getSendingChannel", "()Lcom/baidu/chatsearch/aicall/comps/sse/SendingChannel;", "sendingChannel$delegate", "Lkotlin/Lazy;", "turnCount", "", "cancelRequestSSE", "dispatchResult", "result", "onBindViewModel", "viewModel", "onCreateViewModel", "onDestroy", "startRequestSSE", "text", "", "updateTurnCount", "lib-chatsearch-aicall-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AICallSSEComp.kt */
public final class AICallSSEComp extends BaseExtSlaveComponent<AICallSSEViewModel> {
    private Function1<? super JSONObject, Unit> onFirstResponseError;
    private Function0<Unit> onOpen;
    private Function0<Unit> onRequestStart;
    private Function1<? super SSETtsResultModel, Unit> onResult;
    /* access modifiers changed from: private */
    public final AICallPageParams pageParams;
    private final Lazy sendingChannel$delegate = LazyKt.lazy(new AICallSSEComp$sendingChannel$2(this));
    private int turnCount;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AICallSSEComp(LifecycleOwner owner, View view2, AICallPageParams pageParams2) {
        super(owner, view2, true);
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(pageParams2, "pageParams");
        this.pageParams = pageParams2;
    }

    public final Function1<SSETtsResultModel, Unit> getOnResult$lib_chatsearch_aicall_impl_release() {
        return this.onResult;
    }

    public final void setOnResult$lib_chatsearch_aicall_impl_release(Function1<? super SSETtsResultModel, Unit> function1) {
        this.onResult = function1;
    }

    public final Function0<Unit> getOnOpen$lib_chatsearch_aicall_impl_release() {
        return this.onOpen;
    }

    public final void setOnOpen$lib_chatsearch_aicall_impl_release(Function0<Unit> function0) {
        this.onOpen = function0;
    }

    public final Function0<Unit> getOnRequestStart$lib_chatsearch_aicall_impl_release() {
        return this.onRequestStart;
    }

    public final void setOnRequestStart$lib_chatsearch_aicall_impl_release(Function0<Unit> function0) {
        this.onRequestStart = function0;
    }

    public final Function1<JSONObject, Unit> getOnFirstResponseError$lib_chatsearch_aicall_impl_release() {
        return this.onFirstResponseError;
    }

    public final void setOnFirstResponseError$lib_chatsearch_aicall_impl_release(Function1<? super JSONObject, Unit> function1) {
        this.onFirstResponseError = function1;
    }

    private final SendingChannel getSendingChannel() {
        return (SendingChannel) this.sendingChannel$delegate.getValue();
    }

    public AICallSSEViewModel onCreateViewModel() {
        ViewModel viewModel = ViewModelProviders.of((LifecycleComponent) this).get(getClass().getName(), AICallSSEViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "of(this).get(javaClass.n…SSEViewModel::class.java)");
        return (AICallSSEViewModel) viewModel;
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewModel$lambda-0  reason: not valid java name */
    public static final void m13047onBindViewModel$lambda0(AICallSSEComp this$0, SSETtsResultModel result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(result, "result");
        this$0.dispatchResult(result);
    }

    public void onBindViewModel(AICallSSEViewModel viewModel, LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(owner, "owner");
        viewModel.getResult().observe(owner, new AICallSSEComp$$ExternalSyntheticLambda0(this));
        viewModel.getOnRequestStart().observe(owner, new AICallSSEComp$$ExternalSyntheticLambda1(this));
        viewModel.getOnOpen().observe(owner, new AICallSSEComp$$ExternalSyntheticLambda2(this));
        viewModel.getOnFirstError().observe(owner, new AICallSSEComp$$ExternalSyntheticLambda3(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewModel$lambda-1  reason: not valid java name */
    public static final void m13048onBindViewModel$lambda1(AICallSSEComp this$0, Object it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function0<Unit> function0 = this$0.onRequestStart;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewModel$lambda-2  reason: not valid java name */
    public static final void m13049onBindViewModel$lambda2(AICallSSEComp this$0, Object it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function0<Unit> function0 = this$0.onOpen;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewModel$lambda-3  reason: not valid java name */
    public static final void m13050onBindViewModel$lambda3(AICallSSEComp this$0, JSONObject it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function1<? super JSONObject, Unit> function1 = this$0.onFirstResponseError;
        if (function1 != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            function1.invoke(it);
        }
    }

    private final void dispatchResult(SSETtsResultModel result) {
        Function1<? super SSETtsResultModel, Unit> function1 = this.onResult;
        if (function1 != null) {
            function1.invoke(result);
        }
    }

    public final void startRequestSSE(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        ViewModel viewModel = getViewModel();
        Intrinsics.checkNotNullExpressionValue(viewModel, "viewModel");
        AICallSSEViewModel.startRequest$default((AICallSSEViewModel) viewModel, this.pageParams.getReqInfo(), text, (LiveFigureInfo) null, (Map) null, 12, (Object) null);
    }

    public final void updateTurnCount() {
        this.turnCount++;
    }

    public final void cancelRequestSSE() {
        ((AICallSSEViewModel) getViewModel()).cancelRequest();
    }

    public void onDestroy() {
        SendingChannel sendingChannel = getSendingChannel();
        if (sendingChannel != null) {
            sendingChannel.sendCloseCommand(this.pageParams.getReqInfo().getSessionId(), this.turnCount);
        }
        super.onDestroy();
    }
}
