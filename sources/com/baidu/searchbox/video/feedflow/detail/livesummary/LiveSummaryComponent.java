package com.baidu.searchbox.video.feedflow.detail.livesummary;

import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.feed.styles.R;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.feedflow.common.FlowSwitchStateKt;
import com.baidu.searchbox.video.feedflow.detail.author.AuthorAction;
import com.baidu.searchbox.video.feedflow.detail.author.AuthorState;
import com.baidu.searchbox.video.feedflow.detail.livefollowguide.LiveFollowGuideState;
import com.baidu.searchbox.video.feedflow.detail.summary.SummaryComponent;
import com.baidu.searchbox.video.feedflow.utils.VideoFlowUtilsKt;
import com.baidu.searchbox.video.feedflow.view.FolderTextViewContainer;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016J\b\u0010\u0012\u001a\u00020\fH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/livesummary/LiveSummaryComponent;", "Lcom/baidu/searchbox/video/feedflow/detail/summary/SummaryComponent;", "()V", "enterLiveHandler", "Landroid/os/Handler;", "enterLiveRunnable", "Ljava/lang/Runnable;", "getEnterLiveRunnable", "()Ljava/lang/Runnable;", "enterLiveRunnable$delegate", "Lkotlin/Lazy;", "delayEnterLive", "", "getSummaryFoldWidth", "", "initSummaryView", "onAttachToManager", "onDestroy", "registerListeners", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveSummaryComponent.kt */
public final class LiveSummaryComponent extends SummaryComponent {
    private Handler enterLiveHandler;
    private final Lazy enterLiveRunnable$delegate = BdPlayerUtils.lazyNone(new LiveSummaryComponent$enterLiveRunnable$2(this));

    public void initSummaryView() {
        if (FlowSwitchStateKt.flowSwitchState((Store<?>) getStore()).getLiveSummaryAuthorFollowType() == 0) {
            super.initSummaryView();
            return;
        }
        LiveFolderTextViewContainer $this$initSummaryView_u24lambda_u2d0 = new LiveFolderTextViewContainer(getContext(), (AttributeSet) null, 2, (DefaultConstructorMarker) null);
        $this$initSummaryView_u24lambda_u2d0.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setSummaryView($this$initSummaryView_u24lambda_u2d0);
    }

    public void onAttachToManager() {
        LiveFollowGuideState liveFollowGuideState;
        MutableLiveData<Unit> delayEnterLiveStop;
        AuthorState $this$onAttachToManager_u24lambda_u2d6;
        if (FlowSwitchStateKt.flowSwitchState((Store<?>) getStore()).getLiveSummaryAuthorFollowType() == 0) {
            super.onAttachToManager();
            return;
        }
        super.onAttachToManager();
        Store $this$subscribe$iv = getStore();
        if (!($this$subscribe$iv == null || ($this$onAttachToManager_u24lambda_u2d6 = (AuthorState) $this$subscribe$iv.subscribe(AuthorState.class)) == null)) {
            $this$onAttachToManager_u24lambda_u2d6.getData().observe(this, new LiveSummaryComponent$$ExternalSyntheticLambda0(this));
            $this$onAttachToManager_u24lambda_u2d6.isFollow().observe(this, new LiveSummaryComponent$$ExternalSyntheticLambda1($this$onAttachToManager_u24lambda_u2d6, this));
            $this$onAttachToManager_u24lambda_u2d6.getOnFollowSuccess().observe(this, new LiveSummaryComponent$$ExternalSyntheticLambda2(this));
        }
        Store $this$subscribe$iv2 = getStore();
        if ($this$subscribe$iv2 != null && (liveFollowGuideState = (LiveFollowGuideState) $this$subscribe$iv2.subscribe(LiveFollowGuideState.class)) != null && (delayEnterLiveStop = liveFollowGuideState.getDelayEnterLiveStop()) != null) {
            delayEnterLiveStop.observe(this, new LiveSummaryComponent$$ExternalSyntheticLambda3(this));
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = r7.getFollowInfo();
     */
    /* renamed from: onAttachToManager$lambda-6$lambda-2  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m11693onAttachToManager$lambda6$lambda2(com.baidu.searchbox.video.feedflow.detail.livesummary.LiveSummaryComponent r6, com.baidu.searchbox.video.feedflow.detail.author.AuthorModel r7) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            if (r7 == 0) goto L_0x0013
            com.baidu.searchbox.video.feedflow.detail.author.AuthorFollowInfo r0 = r7.getFollowInfo()
            if (r0 == 0) goto L_0x0013
            java.lang.String r0 = r0.getThirdId()
            goto L_0x0014
        L_0x0013:
            r0 = 0
        L_0x0014:
            if (r0 == 0) goto L_0x0030
            r1 = r0
            r2 = 0
            com.baidu.searchbox.follow.button.FollowStatusManager r3 = com.baidu.searchbox.follow.button.FollowStatusManager.INSTANCE
            java.lang.Boolean r3 = r3.isFollow(r1)
            if (r3 == 0) goto L_0x002e
            com.baidu.searchbox.video.feedflow.detail.author.AuthorFollowInfo r4 = r7.getFollowInfo()
            if (r4 != 0) goto L_0x0027
            goto L_0x002e
        L_0x0027:
            boolean r5 = r3.booleanValue()
            r4.setFollow(r5)
        L_0x002e:
        L_0x0030:
            com.baidu.searchbox.feed.detail.frame.Store r1 = r6.getStore()
            if (r1 == 0) goto L_0x0052
            com.baidu.searchbox.video.feedflow.detail.author.AuthorAction$OnFollowDataBindAction r2 = new com.baidu.searchbox.video.feedflow.detail.author.AuthorAction$OnFollowDataBindAction
            r3 = 1
            r4 = 0
            if (r7 == 0) goto L_0x0049
            com.baidu.searchbox.video.feedflow.detail.author.AuthorFollowInfo r5 = r7.getFollowInfo()
            if (r5 == 0) goto L_0x0049
            boolean r5 = r5.isFollow()
            if (r5 != r3) goto L_0x0049
            goto L_0x004a
        L_0x0049:
            r3 = r4
        L_0x004a:
            r2.<init>(r3)
            com.baidu.searchbox.feed.detail.frame.Action r2 = (com.baidu.searchbox.feed.detail.frame.Action) r2
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r1, r2)
        L_0x0052:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.livesummary.LiveSummaryComponent.m11693onAttachToManager$lambda6$lambda2(com.baidu.searchbox.video.feedflow.detail.livesummary.LiveSummaryComponent, com.baidu.searchbox.video.feedflow.detail.author.AuthorModel):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-6$lambda-4  reason: not valid java name */
    public static final void m11694onAttachToManager$lambda6$lambda4(AuthorState $this_run, LiveSummaryComponent this$0, Boolean isFollow) {
        Store<AbsState> store;
        Intrinsics.checkNotNullParameter($this_run, "$this_run");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean isFollowed = Intrinsics.areEqual((Object) isFollow, (Object) true);
        if ($this_run.getData().getValue() != null && (store = this$0.getStore()) != null) {
            StoreExtKt.post(store, new AuthorAction.OnFollowStateChangedAction(isFollowed));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-6$lambda-5  reason: not valid java name */
    public static final void m11695onAttachToManager$lambda6$lambda5(LiveSummaryComponent this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FolderTextViewContainer summaryView = this$0.getSummaryView();
        LiveFolderTextViewContainer liveFolderTextViewContainer = summaryView instanceof LiveFolderTextViewContainer ? (LiveFolderTextViewContainer) summaryView : null;
        if (liveFolderTextViewContainer != null) {
            liveFolderTextViewContainer.onFollowSuccess();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-7  reason: not valid java name */
    public static final void m11696onAttachToManager$lambda7(LiveSummaryComponent this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Handler handler = this$0.enterLiveHandler;
        if (handler != null) {
            handler.removeCallbacks(this$0.getEnterLiveRunnable());
        }
    }

    public void registerListeners() {
        if (FlowSwitchStateKt.flowSwitchState((Store<?>) getStore()).getLiveSummaryAuthorFollowType() == 0) {
            super.registerListeners();
            return;
        }
        super.registerListeners();
        FolderTextViewContainer summaryView = getSummaryView();
        LiveFolderTextViewContainer liveFolderTextViewContainer = summaryView instanceof LiveFolderTextViewContainer ? (LiveFolderTextViewContainer) summaryView : null;
        if (liveFolderTextViewContainer != null) {
            liveFolderTextViewContainer.setClickCallback(new LiveSummaryComponent$registerListeners$1(this));
        }
    }

    public int getSummaryFoldWidth() {
        int leftMargin = getContext().getResources().getDimensionPixelOffset(R.dimen.F_M_W_X402);
        return Math.max((VideoFlowUtilsKt.getActivityContentSize(getContext(), true)[0].intValue() - leftMargin) - getContext().getResources().getDimensionPixelOffset(R.dimen.F_M_W_X402), 0);
    }

    /* access modifiers changed from: private */
    public final void delayEnterLive() {
        if (this.enterLiveHandler == null) {
            this.enterLiveHandler = new Handler(Looper.getMainLooper());
        }
        Handler handler = this.enterLiveHandler;
        if (handler != null) {
            handler.removeCallbacks(getEnterLiveRunnable());
        }
        Handler handler2 = this.enterLiveHandler;
        if (handler2 != null) {
            handler2.postDelayed(getEnterLiveRunnable(), 300);
        }
    }

    private final Runnable getEnterLiveRunnable() {
        return (Runnable) this.enterLiveRunnable$delegate.getValue();
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [com.baidu.searchbox.video.feedflow.view.FolderTextViewContainer] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDestroy() {
        /*
            r3 = this;
            super.onDestroy()
            android.os.Handler r0 = r3.enterLiveHandler
            r1 = 0
            if (r0 == 0) goto L_0x000b
            r0.removeCallbacksAndMessages(r1)
        L_0x000b:
            com.baidu.searchbox.video.feedflow.view.FolderTextViewContainer r0 = r3.getSummaryView()
            boolean r2 = r0 instanceof com.baidu.searchbox.video.feedflow.detail.livesummary.LiveFolderTextViewContainer
            if (r2 == 0) goto L_0x0016
            r1 = r0
            com.baidu.searchbox.video.feedflow.detail.livesummary.LiveFolderTextViewContainer r1 = (com.baidu.searchbox.video.feedflow.detail.livesummary.LiveFolderTextViewContainer) r1
        L_0x0016:
            if (r1 == 0) goto L_0x001b
            r1.onDestroy()
        L_0x001b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.livesummary.LiveSummaryComponent.onDestroy():void");
    }
}
