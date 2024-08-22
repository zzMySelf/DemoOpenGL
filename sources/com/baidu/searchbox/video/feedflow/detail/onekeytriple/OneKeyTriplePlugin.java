package com.baidu.searchbox.video.feedflow.detail.onekeytriple;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.MutableLiveData;
import com.baidu.pass.face.platform.ConstPath;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.arch.ext.CoreState;
import com.baidu.searchbox.feed.detail.arch.ext.NestedAction;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.feed.detail.livedata.LiveDataPlugin;
import com.baidu.searchbox.flowvideo.detail.repos.FlowDetailRewardButtonModel;
import com.baidu.searchbox.praise.triplepraiseinterface.R;
import com.baidu.searchbox.praise.triplepraiseinterface.TripleAlign;
import com.baidu.searchbox.praise.triplepraiseinterface.TriplePraiseData;
import com.baidu.searchbox.praise.triplepraiseinterface.TriplePraiseInterface;
import com.baidu.searchbox.praise.triplepraiseinterface.TriplePraiseRewardData;
import com.baidu.searchbox.praise.triplepraiseinterface.TriplePraiseRuntime;
import com.baidu.searchbox.ui.bubble.BubbleManager;
import com.baidu.searchbox.ui.bubble.BubblePosition;
import com.baidu.searchbox.ui.bubble.builder.BubbleTextBuilder;
import com.baidu.searchbox.ui.bubble.manager.BubbleTextManager;
import com.baidu.searchbox.video.detail.business.VideoBizUtilsKt;
import com.baidu.searchbox.video.feedflow.detail.favor.FavorStateChangeModel;
import com.baidu.searchbox.video.feedflow.detail.favor.FlowDetailFavorChangeState;
import com.baidu.searchbox.video.feedflow.detail.praise.FlowDetailPraiseState;
import com.baidu.searchbox.video.feedflow.detail.praise.IPraiseService;
import com.baidu.searchbox.video.feedflow.detail.praise.PraiseModel;
import com.baidu.searchbox.video.feedflow.detail.praise.PraiseView;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import com.baidu.searchbox.video.feedflow.flow.list.WindowFocusChanged;
import com.baidu.searchbox.video.feedflow.ubc.UBC464;
import com.baidu.searchbox.video.feedflow.ubc.UBCManifestKt;
import com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper;
import com.baidu.searchbox.video.service.PageContainerService;
import com.baidu.searchbox.video.service.guidepriority.GuidePriorityService;
import com.baidu.searchbox.video.service.guidepriority.GuideType;
import com.baidu.searchbox.video.utils.VideoLoginUtils;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J<\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0016\u001a\u00020\bH\u0002J\b\u0010\u0017\u001a\u00020\u000fH\u0002J4\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0019j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\u001a2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bH\u0002J\b\u0010\u001c\u001a\u00020\bH\u0002J\u0010\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\bH\u0002J\b\u0010\u001f\u001a\u00020\u000fH\u0002J\u0010\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u0006H\u0002J\b\u0010\"\u001a\u00020\u0006H\u0002J\u0010\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\bH\u0002J\b\u0010%\u001a\u00020\u0006H\u0002J\b\u0010&\u001a\u00020\u0006H\u0002J\b\u0010'\u001a\u00020\u000fH\u0016J\b\u0010(\u001a\u00020\u000fH\u0016J\u0010\u0010)\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020+H\u0002J\u0010\u0010,\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bH\u0002J\b\u0010-\u001a\u00020\u000fH\u0002J\b\u0010.\u001a\u00020\u000fH\u0002J\u0010\u0010/\u001a\u00020\u000f2\u0006\u00100\u001a\u000201H\u0002J\u0010\u00102\u001a\u00020\u000f2\u0006\u00103\u001a\u00020\u0006H\u0002J0\u00104\u001a\u00020\u000f2\u0006\u00105\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u00062\u0006\u00108\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\bH\u0002J\u0018\u00109\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bH\u0002J\b\u0010:\u001a\u00020\u000fH\u0014J\b\u0010;\u001a\u00020\u000fH\u0014J(\u0010<\u001a\u00020\u000f2\u0006\u00105\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\bH\u0002J\b\u0010>\u001a\u00020\u000fH\u0002J\b\u0010?\u001a\u00020\u000fH\u0002J\u0010\u0010@\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020BH\u0002J\u0018\u0010C\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020B2\u0006\u0010\u0016\u001a\u00020\bH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/onekeytriple/OneKeyTriplePlugin;", "Lcom/baidu/searchbox/feed/detail/livedata/LiveDataPlugin;", "()V", "bubbleManager", "Lcom/baidu/searchbox/ui/bubble/manager/BubbleTextManager;", "currentFavorState", "", "currentTripleType", "", "tripleFollowSuccess", "triplePraiseInterface", "Lcom/baidu/searchbox/praise/triplepraiseinterface/TriplePraiseInterface;", "triplePraiseSuccess", "tripleRewardSuccess", "addRewardParams", "", "metaObj", "Lorg/json/JSONObject;", "page", "source", "thirdId", "thirdName", "tripleType", "cancelOneKeyTriple", "getTriplePraiseParams", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "positions", "getTripleType", "handleOneKeyTriple", "position", "hideBubble", "initOneKeyTripleInstance", "isCreate", "isCanShow", "isQuadruple", "type", "isQuadrupleReward", "isShownGuide", "onAttachToManager", "onDestroy", "onNestedAction", "nestedAction", "Lcom/baidu/searchbox/feed/detail/arch/ext/NestedAction;", "parseExtParams", "registerGuide", "setGuideHasShown", "showBubble", "anchorView", "Landroid/view/View;", "showOrHideGuide", "isVisible", "showTriplePraiseToast", "isPraise", "isFavor", "isFollow", "isReward", "startOneKeyTriple", "triplePraiseAnimEnd", "triplePraiseAnimReverse", "updateFavorUIAfterTriplePraise", "isRewarded", "updateFollowUIAfterTriplePraise", "updateLikeUIAfterTriplePraise", "updateRewardUIAfterTriplePraise", "data", "Lcom/baidu/searchbox/praise/triplepraiseinterface/TriplePraiseData;", "updateTriplePraiseUIByType", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OneKeyTriplePlugin.kt */
public class OneKeyTriplePlugin extends LiveDataPlugin {
    /* access modifiers changed from: private */
    public BubbleTextManager bubbleManager;
    private boolean currentFavorState;
    private String currentTripleType = "4";
    private boolean tripleFollowSuccess;
    private TriplePraiseInterface triplePraiseInterface;
    private boolean triplePraiseSuccess;
    private boolean tripleRewardSuccess;

    public void onAttachToManager() {
        FlowDetailFavorChangeState flowDetailFavorChangeState;
        MutableLiveData<FavorStateChangeModel> data;
        CoreState coreState;
        MutableLiveData<NestedAction> nestedAction;
        OneKeyTripleState oneKeyTripleState;
        MutableLiveData<Boolean> isShow;
        OneKeyTripleState $this$onAttachToManager_u24lambda_u2d1;
        super.onAttachToManager();
        Store<AbsState> store = getStore();
        if (!(store == null || ($this$onAttachToManager_u24lambda_u2d1 = (OneKeyTripleState) store.subscribe((Class<T>) OneKeyTripleState.class)) == null)) {
            $this$onAttachToManager_u24lambda_u2d1.getGuideVisible().observe(this, new OneKeyTriplePlugin$$ExternalSyntheticLambda0(this));
        }
        Store<AbsState> store2 = getStore();
        if (!(store2 == null || (oneKeyTripleState = (OneKeyTripleState) store2.subscribe((Class<T>) OneKeyTripleState.class)) == null || (isShow = oneKeyTripleState.isShow()) == null)) {
            isShow.observe(this, new OneKeyTriplePlugin$$ExternalSyntheticLambda1(this));
        }
        Store<AbsState> store3 = getStore();
        if (!(store3 == null || (coreState = (CoreState) store3.subscribe((Class<T>) CoreState.class)) == null || (nestedAction = coreState.getNestedAction()) == null)) {
            nestedAction.observe(this, new OneKeyTriplePlugin$$ExternalSyntheticLambda2(this));
        }
        Store<AbsState> store4 = getStore();
        if (store4 != null && (flowDetailFavorChangeState = (FlowDetailFavorChangeState) store4.subscribe((Class<T>) FlowDetailFavorChangeState.class)) != null && (data = flowDetailFavorChangeState.getData()) != null) {
            data.observe(this, new OneKeyTriplePlugin$$ExternalSyntheticLambda3(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-1$lambda-0  reason: not valid java name */
    public static final void m11885onAttachToManager$lambda1$lambda0(OneKeyTriplePlugin this$0, Boolean isVisible) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(isVisible, "isVisible");
        this$0.showOrHideGuide(isVisible.booleanValue());
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0014, code lost:
        r0 = (com.baidu.searchbox.video.feedflow.detail.onekeytriple.OneKeyTripleState) (r0 = r0.getState()).select(com.baidu.searchbox.video.feedflow.detail.onekeytriple.OneKeyTripleState.class);
     */
    /* renamed from: onAttachToManager$lambda-3  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m11886onAttachToManager$lambda3(com.baidu.searchbox.video.feedflow.detail.onekeytriple.OneKeyTriplePlugin r3, java.lang.Boolean r4) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            com.baidu.searchbox.feed.detail.frame.Store r0 = r3.getStore()
            if (r0 == 0) goto L_0x0023
            com.baidu.searchbox.feed.detail.frame.State r0 = r0.getState()
            com.baidu.searchbox.feed.detail.frame.AbsState r0 = (com.baidu.searchbox.feed.detail.frame.AbsState) r0
            if (r0 == 0) goto L_0x0023
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.onekeytriple.OneKeyTripleState> r1 = com.baidu.searchbox.video.feedflow.detail.onekeytriple.OneKeyTripleState.class
            java.lang.Object r0 = r0.select(r1)
            com.baidu.searchbox.video.feedflow.detail.onekeytriple.OneKeyTripleState r0 = (com.baidu.searchbox.video.feedflow.detail.onekeytriple.OneKeyTripleState) r0
            if (r0 == 0) goto L_0x0023
            java.lang.String r0 = r0.getPosition()
            goto L_0x0024
        L_0x0023:
            r0 = 0
        L_0x0024:
            r1 = 0
            r2 = r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x0033
            int r2 = r2.length()
            if (r2 != 0) goto L_0x0031
            goto L_0x0033
        L_0x0031:
            r2 = 0
            goto L_0x0034
        L_0x0033:
            r2 = 1
        L_0x0034:
            if (r2 != 0) goto L_0x0046
            java.lang.String r2 = "isShow"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r2)
            boolean r2 = r4.booleanValue()
            if (r2 == 0) goto L_0x0046
            r3.handleOneKeyTriple(r0)
            goto L_0x0049
        L_0x0046:
            r3.cancelOneKeyTriple()
        L_0x0049:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.onekeytriple.OneKeyTriplePlugin.m11886onAttachToManager$lambda3(com.baidu.searchbox.video.feedflow.detail.onekeytriple.OneKeyTriplePlugin, java.lang.Boolean):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-5  reason: not valid java name */
    public static final void m11887onAttachToManager$lambda5(OneKeyTriplePlugin this$0, NestedAction nestedAction) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (nestedAction != null) {
            this$0.onNestedAction(nestedAction);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0019, code lost:
        r1 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) (r1 = r1.getState()).select(com.baidu.searchbox.video.feedflow.flow.list.ItemModel.class);
     */
    /* renamed from: onAttachToManager$lambda-6  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m11888onAttachToManager$lambda6(com.baidu.searchbox.video.feedflow.detail.onekeytriple.OneKeyTriplePlugin r7, com.baidu.searchbox.video.feedflow.detail.favor.FavorStateChangeModel r8) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = r8.getNid()
            com.baidu.searchbox.feed.detail.frame.Store r1 = r7.getStore()
            r2 = 0
            if (r1 == 0) goto L_0x0028
            com.baidu.searchbox.feed.detail.frame.State r1 = r1.getState()
            com.baidu.searchbox.feed.detail.frame.AbsState r1 = (com.baidu.searchbox.feed.detail.frame.AbsState) r1
            if (r1 == 0) goto L_0x0028
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.ItemModel> r3 = com.baidu.searchbox.video.feedflow.flow.list.ItemModel.class
            java.lang.Object r1 = r1.select(r3)
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r1 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r1
            if (r1 == 0) goto L_0x0028
            java.lang.String r1 = r1.getNid()
            goto L_0x0029
        L_0x0028:
            r1 = r2
        L_0x0029:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x0035
            boolean r0 = r8.isFavor()
            r7.currentFavorState = r0
        L_0x0035:
            java.lang.String r0 = r8.getSource()
            java.lang.String r1 = "onekeytriple"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x0078
            java.lang.String r0 = r8.getNid()
            com.baidu.searchbox.feed.detail.frame.Store r1 = r7.getStore()
            if (r1 == 0) goto L_0x0062
            com.baidu.searchbox.feed.detail.frame.State r1 = r1.getState()
            com.baidu.searchbox.feed.detail.frame.AbsState r1 = (com.baidu.searchbox.feed.detail.frame.AbsState) r1
            if (r1 == 0) goto L_0x0062
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.ItemModel> r3 = com.baidu.searchbox.video.feedflow.flow.list.ItemModel.class
            java.lang.Object r1 = r1.select(r3)
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r1 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r1
            if (r1 == 0) goto L_0x0062
            java.lang.String r2 = r1.getNid()
        L_0x0062:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r2)
            if (r0 == 0) goto L_0x0078
            boolean r2 = r7.triplePraiseSuccess
            boolean r3 = r8.isFavor()
            boolean r4 = r7.tripleFollowSuccess
            boolean r5 = r7.tripleRewardSuccess
            java.lang.String r6 = r7.currentTripleType
            r1 = r7
            r1.showTriplePraiseToast(r2, r3, r4, r5, r6)
        L_0x0078:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.onekeytriple.OneKeyTriplePlugin.m11888onAttachToManager$lambda6(com.baidu.searchbox.video.feedflow.detail.onekeytriple.OneKeyTriplePlugin, com.baidu.searchbox.video.feedflow.detail.favor.FavorStateChangeModel):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0062, code lost:
        r2 = (r2 = (r2 = (com.baidu.searchbox.video.feedflow.detail.praise.FlowDetailPraiseState) (r2 = r2.getState()).select(com.baidu.searchbox.video.feedflow.detail.praise.FlowDetailPraiseState.class)).getData()).getValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void handleOneKeyTriple(java.lang.String r19) {
        /*
            r18 = this;
            r0 = r18
            com.baidu.searchbox.feed.detail.frame.Store r1 = r18.getStore()
            r2 = 0
            r3 = 1
            boolean r1 = com.baidu.searchbox.video.feedflow.detail.challenge.challengefromcomment.ChallengeUtilsKt.isFromCommentChallenge$default((com.baidu.searchbox.feed.detail.frame.Store) r1, (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r2, (int) r3, (java.lang.Object) r2)
            if (r1 == 0) goto L_0x000f
            return
        L_0x000f:
            boolean r1 = com.baidu.searchbox.player.utils.BdNetUtils.isNetUp()
            if (r1 != 0) goto L_0x0039
            com.baidu.searchbox.feed.detail.frame.Store r1 = r18.getStore()
            if (r1 == 0) goto L_0x0038
            com.baidu.searchbox.video.component.toast.ToastAction$SolidShow r16 = new com.baidu.searchbox.video.component.toast.ToastAction$SolidShow
            int r3 = com.baidu.searchbox.praise.triplepraiseinterface.R.string.triplePraise_network_error
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 2046(0x7fe, float:2.867E-42)
            r15 = 0
            r2 = r16
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r2 = r16
            com.baidu.searchbox.feed.detail.frame.Action r2 = (com.baidu.searchbox.feed.detail.frame.Action) r2
            r1.dispatch(r2)
        L_0x0038:
            return
        L_0x0039:
            java.lang.String r1 = r18.getTripleType()
            r0.currentTripleType = r1
            boolean r1 = r18.isQuadrupleReward()
            com.baidu.searchbox.feed.detail.frame.Store r2 = r18.getStore()
            r4 = 0
            if (r2 == 0) goto L_0x0072
            com.baidu.searchbox.feed.detail.frame.State r2 = r2.getState()
            com.baidu.searchbox.feed.detail.frame.AbsState r2 = (com.baidu.searchbox.feed.detail.frame.AbsState) r2
            if (r2 == 0) goto L_0x0072
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.praise.FlowDetailPraiseState> r5 = com.baidu.searchbox.video.feedflow.detail.praise.FlowDetailPraiseState.class
            java.lang.Object r2 = r2.select(r5)
            com.baidu.searchbox.video.feedflow.detail.praise.FlowDetailPraiseState r2 = (com.baidu.searchbox.video.feedflow.detail.praise.FlowDetailPraiseState) r2
            if (r2 == 0) goto L_0x0072
            androidx.lifecycle.MutableLiveData r2 = r2.getData()
            if (r2 == 0) goto L_0x0072
            java.lang.Object r2 = r2.getValue()
            com.baidu.searchbox.video.feedflow.detail.praise.PraiseModel r2 = (com.baidu.searchbox.video.feedflow.detail.praise.PraiseModel) r2
            if (r2 == 0) goto L_0x0072
            boolean r2 = r2.getLiked()
            if (r2 != r3) goto L_0x0072
            r2 = r3
            goto L_0x0073
        L_0x0072:
            r2 = r4
        L_0x0073:
            if (r2 == 0) goto L_0x011d
            com.baidu.searchbox.feed.detail.frame.Store r2 = r18.getStore()
            if (r2 == 0) goto L_0x00a8
            com.baidu.searchbox.feed.detail.frame.State r2 = r2.getState()
            com.baidu.searchbox.feed.detail.frame.AbsState r2 = (com.baidu.searchbox.feed.detail.frame.AbsState) r2
            if (r2 == 0) goto L_0x00a8
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.author.AuthorState> r5 = com.baidu.searchbox.video.feedflow.detail.author.AuthorState.class
            java.lang.Object r2 = r2.select(r5)
            com.baidu.searchbox.video.feedflow.detail.author.AuthorState r2 = (com.baidu.searchbox.video.feedflow.detail.author.AuthorState) r2
            if (r2 == 0) goto L_0x00a8
            androidx.lifecycle.MutableLiveData r2 = r2.getData()
            if (r2 == 0) goto L_0x00a8
            java.lang.Object r2 = r2.getValue()
            com.baidu.searchbox.video.feedflow.detail.author.AuthorModel r2 = (com.baidu.searchbox.video.feedflow.detail.author.AuthorModel) r2
            if (r2 == 0) goto L_0x00a8
            com.baidu.searchbox.video.feedflow.detail.author.AuthorFollowInfo r2 = r2.getFollowInfo()
            if (r2 == 0) goto L_0x00a8
            boolean r2 = r2.isFollow()
            if (r2 != r3) goto L_0x00a8
            goto L_0x00a9
        L_0x00a8:
            r3 = r4
        L_0x00a9:
            if (r3 == 0) goto L_0x011d
            boolean r2 = r0.currentFavorState
            if (r2 == 0) goto L_0x011d
            java.lang.String r2 = r0.currentTripleType
            boolean r2 = r0.isQuadruple(r2)
            if (r2 == 0) goto L_0x00b9
            if (r1 == 0) goto L_0x011d
        L_0x00b9:
            kotlin.random.Random$Default r2 = kotlin.random.Random.Default
            boolean r2 = r2.nextBoolean()
            if (r2 == 0) goto L_0x00ef
            com.baidu.searchbox.feed.detail.frame.Store r2 = r18.getStore()
            if (r2 == 0) goto L_0x00ec
            com.baidu.searchbox.video.component.toast.ToastAction$SolidShow r17 = new com.baidu.searchbox.video.component.toast.ToastAction$SolidShow
            if (r1 == 0) goto L_0x00cf
            int r3 = com.baidu.searchbox.praise.triplepraiseinterface.R.string.quadruplePraise_trigger_again_first
            r4 = r3
            goto L_0x00d2
        L_0x00cf:
            int r3 = com.baidu.searchbox.praise.triplepraiseinterface.R.string.triplePraise_trigger_again_first
            r4 = r3
        L_0x00d2:
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 2046(0x7fe, float:2.867E-42)
            r16 = 0
            r3 = r17
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r3 = r17
            com.baidu.searchbox.feed.detail.frame.Action r3 = (com.baidu.searchbox.feed.detail.frame.Action) r3
            r2.dispatch(r3)
        L_0x00ec:
            r3 = r19
            goto L_0x0124
        L_0x00ef:
            com.baidu.searchbox.feed.detail.frame.Store r2 = r18.getStore()
            if (r2 == 0) goto L_0x011a
            com.baidu.searchbox.video.component.toast.ToastAction$SolidShow r17 = new com.baidu.searchbox.video.component.toast.ToastAction$SolidShow
            if (r1 == 0) goto L_0x00fd
            int r3 = com.baidu.searchbox.praise.triplepraiseinterface.R.string.quadruplePraise_trigger_again_second
            r4 = r3
            goto L_0x0100
        L_0x00fd:
            int r3 = com.baidu.searchbox.praise.triplepraiseinterface.R.string.triplePraise_trigger_again_second
            r4 = r3
        L_0x0100:
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 2046(0x7fe, float:2.867E-42)
            r16 = 0
            r3 = r17
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r3 = r17
            com.baidu.searchbox.feed.detail.frame.Action r3 = (com.baidu.searchbox.feed.detail.frame.Action) r3
            r2.dispatch(r3)
        L_0x011a:
            r3 = r19
            goto L_0x0124
        L_0x011d:
            java.lang.String r2 = r0.currentTripleType
            r3 = r19
            r0.startOneKeyTriple(r3, r2)
        L_0x0124:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.onekeytriple.OneKeyTriplePlugin.handleOneKeyTriple(java.lang.String):void");
    }

    private final void initOneKeyTripleInstance(boolean isCreate) {
        OneKeyTripleInstanceState oneKeyTripleInstanceState;
        OneKeyTripleInstanceState oneKeyTripleInstanceState2;
        if (isCreate && this.triplePraiseInterface == null) {
            this.triplePraiseInterface = TriplePraiseRuntime.get();
            Store $this$select$iv = getStore();
            if ($this$select$iv != null) {
                AbsState state = $this$select$iv.getState();
                CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
                oneKeyTripleInstanceState2 = (OneKeyTripleInstanceState) (commonState != null ? commonState.select(OneKeyTripleInstanceState.class) : null);
            } else {
                oneKeyTripleInstanceState2 = null;
            }
            if (oneKeyTripleInstanceState2 != null) {
                oneKeyTripleInstanceState2.setTriplePraiseInterface(this.triplePraiseInterface);
            }
        }
        if (!isCreate) {
            this.triplePraiseInterface = null;
            Store $this$select$iv2 = getStore();
            if ($this$select$iv2 != null) {
                AbsState state2 = $this$select$iv2.getState();
                CommonState commonState2 = state2 instanceof CommonState ? (CommonState) state2 : null;
                oneKeyTripleInstanceState = (OneKeyTripleInstanceState) (commonState2 != null ? commonState2.select(OneKeyTripleInstanceState.class) : null);
            } else {
                oneKeyTripleInstanceState = null;
            }
            if (oneKeyTripleInstanceState != null) {
                oneKeyTripleInstanceState.setTriplePraiseInterface((TriplePraiseInterface) null);
            }
        }
    }

    private final void startOneKeyTriple(String position, String tripleType) {
        Store<AbsState> store = getStore();
        if (store != null) {
            store.dispatch(new WindowFocusChanged(false, false, 2, (DefaultConstructorMarker) null));
        }
        Store<AbsState> store2 = getStore();
        if (store2 != null) {
            store2.dispatch(OneKeyTripleAnimatorStartAction.INSTANCE);
        }
        initOneKeyTripleInstance(true);
        TriplePraiseInterface triplePraiseInterface2 = this.triplePraiseInterface;
        if (triplePraiseInterface2 != null) {
            triplePraiseInterface2.play(getContext(), getTriplePraiseParams(position, tripleType), new OneKeyTriplePlugin$startOneKeyTriple$1(this, tripleType));
        }
    }

    /* access modifiers changed from: protected */
    public void triplePraiseAnimReverse() {
        AbsState state;
        ItemModel itemModel;
        VideoFlowUBCHelper videoFlowUBCHelper = VideoFlowUBCHelper.INSTANCE;
        Store<AbsState> store = getStore();
        String str = null;
        AbsState state2 = store != null ? store.getState() : null;
        Store<AbsState> store2 = getStore();
        if (!(store2 == null || (state = store2.getState()) == null || (itemModel = (ItemModel) state.select(ItemModel.class)) == null)) {
            str = itemModel.getNid();
        }
        VideoFlowUBCHelper.upload464Ubc$default(videoFlowUBCHelper, state2, UBC464.Type.TYPE_ONE_KEY_TRIPLE, "long_press", (String) null, (String) null, (String) null, str, "464", 56, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void triplePraiseAnimEnd() {
        AbsState state;
        ItemModel itemModel;
        VideoFlowUBCHelper videoFlowUBCHelper = VideoFlowUBCHelper.INSTANCE;
        Store<AbsState> store = getStore();
        String str = null;
        AbsState state2 = store != null ? store.getState() : null;
        Store<AbsState> store2 = getStore();
        if (!(store2 == null || (state = store2.getState()) == null || (itemModel = (ItemModel) state.select(ItemModel.class)) == null)) {
            str = itemModel.getNid();
        }
        VideoFlowUBCHelper.upload464Ubc$default(videoFlowUBCHelper, state2, UBC464.Type.TYPE_ONE_KEY_TRIPLE, UBC464.Value.VALUE_TOUCH_OFF, (String) null, (String) null, (String) null, str, "464", 56, (Object) null);
    }

    private final HashMap<String, String> getTriplePraiseParams(String positions, String tripleType) {
        int i2;
        HashMap<String, String> hashMap = new HashMap<>();
        String extParams = parseExtParams(tripleType);
        AbsState absState = null;
        if (!TextUtils.isEmpty(positions) && !TextUtils.isEmpty(extParams)) {
            hashMap.put("positions", positions);
            hashMap.put("type", tripleType);
            hashMap.put(ConstPath.KEY_ALIGN, TripleAlign.ALIGN_HORIZON_LEFT);
            Map map = hashMap;
            StringBuilder sb = new StringBuilder();
            Store<AbsState> store = getStore();
            map.put("loginSource", sb.append(UBCManifestKt.getPage(store != null ? store.getState() : null)).append("_onekeytriple").toString());
            Map map2 = hashMap;
            Context context = getContext();
            if (isQuadruple(tripleType)) {
                i2 = R.string.quadruplePraise_login_title;
            } else {
                i2 = R.string.triplePraise_login_title;
            }
            String string = context.getString(i2);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(\n     …          }\n            )");
            map2.put("loginTitle", string);
            hashMap.put("ext", extParams);
        }
        Store<AbsState> store2 = getStore();
        if (store2 != null) {
            absState = store2.getState();
        }
        if (VideoBizUtilsKt.isFromSearch(UBCManifestKt.getPage(absState))) {
            hashMap.put("loginSource", "hudong_video_immersevideo_immerse_onekeytriple");
        }
        return hashMap;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0018, code lost:
        r0 = (r0 = (com.baidu.searchbox.video.feedflow.detail.author.AuthorState) (r0 = r0.getState()).select(com.baidu.searchbox.video.feedflow.detail.author.AuthorState.class)).getData();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String parseExtParams(java.lang.String r20) {
        /*
            r19 = this;
            com.baidu.searchbox.feed.detail.frame.Store r0 = r19.getStore()
            if (r0 == 0) goto L_0x0025
            com.baidu.searchbox.feed.detail.frame.State r0 = r0.getState()
            com.baidu.searchbox.feed.detail.frame.AbsState r0 = (com.baidu.searchbox.feed.detail.frame.AbsState) r0
            if (r0 == 0) goto L_0x0025
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.author.AuthorState> r2 = com.baidu.searchbox.video.feedflow.detail.author.AuthorState.class
            java.lang.Object r0 = r0.select(r2)
            com.baidu.searchbox.video.feedflow.detail.author.AuthorState r0 = (com.baidu.searchbox.video.feedflow.detail.author.AuthorState) r0
            if (r0 == 0) goto L_0x0025
            androidx.lifecycle.MutableLiveData r0 = r0.getData()
            if (r0 == 0) goto L_0x0025
            java.lang.Object r0 = r0.getValue()
            com.baidu.searchbox.video.feedflow.detail.author.AuthorModel r0 = (com.baidu.searchbox.video.feedflow.detail.author.AuthorModel) r0
            goto L_0x0026
        L_0x0025:
            r0 = 0
        L_0x0026:
            com.baidu.searchbox.feed.detail.frame.Store r2 = r19.getStore()
            if (r2 == 0) goto L_0x004b
            com.baidu.searchbox.feed.detail.frame.State r2 = r2.getState()
            com.baidu.searchbox.feed.detail.frame.AbsState r2 = (com.baidu.searchbox.feed.detail.frame.AbsState) r2
            if (r2 == 0) goto L_0x004b
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.praise.FlowDetailPraiseState> r3 = com.baidu.searchbox.video.feedflow.detail.praise.FlowDetailPraiseState.class
            java.lang.Object r2 = r2.select(r3)
            com.baidu.searchbox.video.feedflow.detail.praise.FlowDetailPraiseState r2 = (com.baidu.searchbox.video.feedflow.detail.praise.FlowDetailPraiseState) r2
            if (r2 == 0) goto L_0x004b
            androidx.lifecycle.MutableLiveData r2 = r2.getData()
            if (r2 == 0) goto L_0x004b
            java.lang.Object r2 = r2.getValue()
            com.baidu.searchbox.video.feedflow.detail.praise.PraiseModel r2 = (com.baidu.searchbox.video.feedflow.detail.praise.PraiseModel) r2
            goto L_0x004c
        L_0x004b:
            r2 = 0
        L_0x004c:
            com.baidu.searchbox.feed.detail.frame.Store r3 = r19.getStore()
            if (r3 == 0) goto L_0x0059
            com.baidu.searchbox.feed.detail.frame.State r3 = r3.getState()
            com.baidu.searchbox.feed.detail.frame.AbsState r3 = (com.baidu.searchbox.feed.detail.frame.AbsState) r3
            goto L_0x005a
        L_0x0059:
            r3 = 0
        L_0x005a:
            java.lang.String r3 = com.baidu.searchbox.video.feedflow.ubc.UBCManifestKt.getPage(r3)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            com.baidu.searchbox.feed.detail.frame.Store r5 = r19.getStore()
            if (r5 == 0) goto L_0x0070
            com.baidu.searchbox.feed.detail.frame.State r5 = r5.getState()
            com.baidu.searchbox.feed.detail.frame.AbsState r5 = (com.baidu.searchbox.feed.detail.frame.AbsState) r5
            goto L_0x0071
        L_0x0070:
            r5 = 0
        L_0x0071:
            java.lang.String r5 = com.baidu.searchbox.video.feedflow.ubc.UBCManifestKt.getPage(r5)
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r5 = "_onekeytriple"
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r4 = r4.toString()
            com.baidu.searchbox.feed.detail.frame.Store r5 = r19.getStore()
            if (r5 == 0) goto L_0x0090
            com.baidu.searchbox.feed.detail.frame.State r5 = r5.getState()
            com.baidu.searchbox.feed.detail.frame.AbsState r5 = (com.baidu.searchbox.feed.detail.frame.AbsState) r5
            goto L_0x0091
        L_0x0090:
            r5 = 0
        L_0x0091:
            java.lang.String r5 = com.baidu.searchbox.video.feedflow.ubc.UBCManifestKt.getPage(r5)
            boolean r5 = com.baidu.searchbox.video.detail.business.VideoBizUtilsKt.isFromSearch(r5)
            if (r5 == 0) goto L_0x00a1
            java.lang.String r3 = "search"
            java.lang.String r4 = "video_immerse_onekeytriple"
        L_0x00a1:
            org.json.JSONObject r5 = new org.json.JSONObject
            r5.<init>()
            r12 = r5
            org.json.JSONObject r5 = new org.json.JSONObject
            r5.<init>()
            r13 = r5
            org.json.JSONObject r5 = new org.json.JSONObject
            r5.<init>()
            r14 = r5
            java.lang.String r15 = ""
            if (r2 == 0) goto L_0x00bd
            java.lang.String r5 = r2.getNid()
            if (r5 != 0) goto L_0x00be
        L_0x00bd:
            r5 = r15
        L_0x00be:
            java.lang.String r11 = "id"
            r14.putOpt(r11, r5)
            java.lang.String r5 = "sfrom"
            r14.putOpt(r5, r3)
            r10 = 1
            r6 = 0
            if (r2 == 0) goto L_0x00d6
            boolean r7 = r2.getLiked()
            if (r7 != r10) goto L_0x00d6
            r7 = r10
            goto L_0x00d7
        L_0x00d6:
            r7 = r6
        L_0x00d7:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.String r8 = "status"
            r14.putOpt(r8, r7)
            java.lang.String r7 = "source"
            r14.putOpt(r7, r4)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r6)
            java.lang.String r1 = "need_cancel"
            r14.putOpt(r1, r9)
            java.lang.String r1 = "praise"
            r13.putOpt(r1, r14)
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            r1.putOpt(r5, r3)
            if (r0 == 0) goto L_0x010d
            com.baidu.searchbox.video.feedflow.detail.author.AuthorFollowInfo r5 = r0.getFollowInfo()
            if (r5 == 0) goto L_0x010d
            java.lang.String r5 = r5.getThirdId()
            if (r5 != 0) goto L_0x010e
        L_0x010d:
            r5 = r15
        L_0x010e:
            java.lang.String r9 = "third_id"
            r1.putOpt(r9, r5)
            if (r0 == 0) goto L_0x0123
            com.baidu.searchbox.video.feedflow.detail.author.AuthorFollowInfo r5 = r0.getFollowInfo()
            if (r5 == 0) goto L_0x0123
            boolean r5 = r5.isFollow()
            if (r5 != r10) goto L_0x0123
            r6 = r10
        L_0x0123:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r6)
            r1.putOpt(r8, r5)
            if (r0 == 0) goto L_0x0138
            com.baidu.searchbox.video.feedflow.detail.author.AuthorFollowInfo r5 = r0.getFollowInfo()
            if (r5 == 0) goto L_0x0138
            java.lang.String r5 = r5.getType()
            if (r5 != 0) goto L_0x0139
        L_0x0138:
            r5 = r15
        L_0x0139:
            java.lang.String r9 = "type"
            r1.putOpt(r9, r5)
            r1.putOpt(r7, r4)
            java.lang.String r5 = "follow"
            r13.putOpt(r5, r1)
            if (r0 == 0) goto L_0x0150
            java.lang.String r5 = r0.getId()
            r17 = r5
            goto L_0x0152
        L_0x0150:
            r17 = 0
        L_0x0152:
            if (r0 == 0) goto L_0x015b
            java.lang.String r5 = r0.getName()
            r16 = r5
            goto L_0x015d
        L_0x015b:
            r16 = 0
        L_0x015d:
            r5 = r19
            r6 = r13
            r7 = r3
            r8 = r4
            r18 = r0
            r0 = r9
            r9 = r17
            r17 = r10
            r10 = r16
            r16 = r1
            r1 = r11
            r11 = r20
            r5.addRewardParams(r6, r7, r8, r9, r10, r11)
            java.lang.String r5 = "meta"
            r12.putOpt(r5, r13)
            if (r2 == 0) goto L_0x0183
            java.lang.String r5 = r2.getNid()
            if (r5 != 0) goto L_0x0182
            goto L_0x0183
        L_0x0182:
            r15 = r5
        L_0x0183:
            r12.putOpt(r1, r15)
            boolean r1 = r19.isQuadruple(r20)
            if (r1 == 0) goto L_0x0190
            r10 = 2
            goto L_0x0192
        L_0x0190:
            r10 = r17
        L_0x0192:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r10)
            r12.putOpt(r0, r1)
            java.lang.String r0 = r12.toString()
            java.lang.String r1 = "extParams.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.onekeytriple.OneKeyTriplePlugin.parseExtParams(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00ab  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void addRewardParams(org.json.JSONObject r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13) {
        /*
            r7 = this;
            boolean r0 = r7.isQuadruple(r13)
            if (r0 == 0) goto L_0x00bc
            boolean r0 = r7.isQuadrupleReward()
            if (r0 != 0) goto L_0x00bc
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            com.baidu.searchbox.feed.detail.frame.Store r1 = r7.getStore()
            r2 = 0
            if (r1 == 0) goto L_0x0038
            r3 = 0
            com.baidu.searchbox.feed.detail.frame.State r4 = r1.getState()
            boolean r5 = r4 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r5 == 0) goto L_0x0024
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r4 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r4
            goto L_0x0025
        L_0x0024:
            r4 = r2
        L_0x0025:
            if (r4 == 0) goto L_0x002e
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.FlowDetailState> r5 = com.baidu.searchbox.video.feedflow.detail.FlowDetailState.class
            java.lang.Object r4 = r4.select(r5)
            goto L_0x002f
        L_0x002e:
            r4 = r2
        L_0x002f:
            com.baidu.searchbox.video.feedflow.detail.FlowDetailState r4 = (com.baidu.searchbox.video.feedflow.detail.FlowDetailState) r4
            if (r4 == 0) goto L_0x0038
            com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel r1 = r4.getData()
            goto L_0x0039
        L_0x0038:
            r1 = r2
        L_0x0039:
            com.baidu.searchbox.feed.detail.frame.Store r3 = r7.getStore()
            if (r3 == 0) goto L_0x005e
            r4 = 0
            com.baidu.searchbox.feed.detail.frame.State r5 = r3.getState()
            boolean r6 = r5 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r6 == 0) goto L_0x004b
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r5 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r5
            goto L_0x004c
        L_0x004b:
            r5 = r2
        L_0x004c:
            if (r5 == 0) goto L_0x0055
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.onekeytriple.OneKeyTripleState> r6 = com.baidu.searchbox.video.feedflow.detail.onekeytriple.OneKeyTripleState.class
            java.lang.Object r5 = r5.select(r6)
            goto L_0x0056
        L_0x0055:
            r5 = r2
        L_0x0056:
            com.baidu.searchbox.video.feedflow.detail.onekeytriple.OneKeyTripleState r5 = (com.baidu.searchbox.video.feedflow.detail.onekeytriple.OneKeyTripleState) r5
            if (r5 == 0) goto L_0x005e
            com.baidu.searchbox.flowvideo.detail.repos.FlowDetailRewardButtonModel r2 = r5.getRewardData()
        L_0x005e:
            java.lang.String r3 = "sfrom"
            r0.putOpt(r3, r9)
            java.lang.String r3 = "source"
            r0.putOpt(r3, r10)
            com.baidu.searchbox.praise.triplepraiseinterface.TriplePraiseInterface r3 = r7.triplePraiseInterface
            if (r3 == 0) goto L_0x0073
            int r3 = r3.getTripleRewardCount()
            goto L_0x0074
        L_0x0073:
            r3 = 2
        L_0x0074:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.String r4 = "amount"
            r0.putOpt(r4, r3)
            java.lang.String r3 = ""
            if (r11 != 0) goto L_0x0083
            r4 = r3
            goto L_0x0084
        L_0x0083:
            r4 = r11
        L_0x0084:
            java.lang.String r5 = "third_id"
            r0.putOpt(r5, r4)
            if (r12 != 0) goto L_0x008e
            r4 = r3
            goto L_0x008f
        L_0x008e:
            r4 = r12
        L_0x008f:
            java.lang.String r5 = "third_name"
            r0.putOpt(r5, r4)
            if (r1 == 0) goto L_0x009f
            java.lang.String r4 = r1.getTitle()
            if (r4 != 0) goto L_0x009e
            goto L_0x009f
        L_0x009e:
            r3 = r4
        L_0x009f:
            java.lang.String r4 = "article_title"
            r0.putOpt(r4, r3)
            if (r2 == 0) goto L_0x00ab
            int r3 = r2.isRewarded()
            goto L_0x00ac
        L_0x00ab:
            r3 = 0
        L_0x00ac:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.String r4 = "status"
            r0.putOpt(r4, r3)
            java.lang.String r3 = "reward"
            r8.putOpt(r3, r0)
        L_0x00bc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.onekeytriple.OneKeyTriplePlugin.addRewardParams(org.json.JSONObject, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    private final boolean isQuadrupleReward() {
        MutableLiveData<PraiseModel> data;
        PraiseModel value;
        Store $this$select$iv = getStore();
        if ($this$select$iv != null) {
            AbsState state = $this$select$iv.getState();
            Object obj = null;
            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
            if (commonState != null) {
                obj = commonState.select(FlowDetailPraiseState.class);
            }
            FlowDetailPraiseState flowDetailPraiseState = (FlowDetailPraiseState) obj;
            if (!(flowDetailPraiseState == null || (data = flowDetailPraiseState.getData()) == null || (value = data.getValue()) == null || value.getHasOneKeyTripleReward() != 1)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final boolean isQuadruple(String type) {
        return Intrinsics.areEqual((Object) type, (Object) "5");
    }

    private final String getTripleType() {
        Store $this$select$iv = getStore();
        FlowDetailRewardButtonModel flowDetailRewardButtonModel = null;
        if ($this$select$iv != null) {
            AbsState state = $this$select$iv.getState();
            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
            OneKeyTripleState oneKeyTripleState = (OneKeyTripleState) (commonState != null ? commonState.select(OneKeyTripleState.class) : null);
            if (oneKeyTripleState != null) {
                flowDetailRewardButtonModel = oneKeyTripleState.getRewardData();
            }
        }
        if (flowDetailRewardButtonModel != null) {
            return "5";
        }
        return "4";
    }

    /* access modifiers changed from: private */
    public final void updateTriplePraiseUIByType(TriplePraiseData data, String tripleType) {
        this.triplePraiseSuccess = data.isPraise();
        this.tripleFollowSuccess = data.isFollow();
        this.tripleRewardSuccess = isQuadrupleReward() ? true : data.isRewardSuccess();
        if (data.isPraise()) {
            updateLikeUIAfterTriplePraise();
        }
        if (data.isFollow()) {
            updateFollowUIAfterTriplePraise();
        }
        if (isQuadruple(tripleType)) {
            updateRewardUIAfterTriplePraise(data);
        }
        if (VideoLoginUtils.isLogin()) {
            updateFavorUIAfterTriplePraise(data.isPraise(), data.isFollow(), this.tripleRewardSuccess, tripleType);
        } else {
            showTriplePraiseToast(this.triplePraiseSuccess, false, this.tripleFollowSuccess, this.tripleRewardSuccess, tripleType);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0049, code lost:
        if (((java.lang.Number) r0.getFirst()).intValue() == 1) goto L_0x004d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void updateFavorUIAfterTriplePraise(boolean r9, boolean r10, boolean r11, java.lang.String r12) {
        /*
            r8 = this;
            boolean r0 = r8.currentFavorState
            if (r0 == 0) goto L_0x000f
            r3 = 1
            r1 = r8
            r2 = r9
            r4 = r10
            r5 = r11
            r6 = r12
            r1.showTriplePraiseToast(r2, r3, r4, r5, r6)
            goto L_0x007c
        L_0x000f:
            com.baidu.searchbox.feed.detail.frame.Store r0 = r8.getStore()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x004c
            r3 = 0
            com.baidu.searchbox.feed.detail.frame.State r4 = r0.getState()
            boolean r5 = r4 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            r6 = 0
            if (r5 == 0) goto L_0x0024
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r4 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r4
            goto L_0x0025
        L_0x0024:
            r4 = r6
        L_0x0025:
            if (r4 == 0) goto L_0x002d
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.favor.FavorViewStatusChangeState> r5 = com.baidu.searchbox.video.feedflow.detail.favor.FavorViewStatusChangeState.class
            java.lang.Object r6 = r4.select(r5)
        L_0x002d:
            com.baidu.searchbox.video.feedflow.detail.favor.FavorViewStatusChangeState r6 = (com.baidu.searchbox.video.feedflow.detail.favor.FavorViewStatusChangeState) r6
            if (r6 == 0) goto L_0x004c
            androidx.lifecycle.MutableLiveData r0 = r6.getData()
            if (r0 == 0) goto L_0x004c
            java.lang.Object r0 = r0.getValue()
            kotlin.Pair r0 = (kotlin.Pair) r0
            if (r0 == 0) goto L_0x004c
            java.lang.Object r0 = r0.getFirst()
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            if (r0 != r1) goto L_0x004c
            goto L_0x004d
        L_0x004c:
            r1 = r2
        L_0x004d:
            if (r1 != 0) goto L_0x0059
            r4 = 0
            r2 = r8
            r3 = r9
            r5 = r10
            r6 = r11
            r7 = r12
            r2.showTriplePraiseToast(r3, r4, r5, r6, r7)
            goto L_0x007c
        L_0x0059:
            com.baidu.searchbox.feed.detail.frame.Store r0 = r8.getStore()
            if (r0 == 0) goto L_0x0069
            com.baidu.searchbox.video.feedflow.detail.favor.ShowFavorScaleAnimAction r1 = new com.baidu.searchbox.video.feedflow.detail.favor.ShowFavorScaleAnimAction
            r1.<init>()
            com.baidu.searchbox.feed.detail.frame.Action r1 = (com.baidu.searchbox.feed.detail.frame.Action) r1
            r0.dispatch(r1)
        L_0x0069:
            com.baidu.searchbox.feed.detail.frame.Store r0 = r8.getStore()
            if (r0 == 0) goto L_0x007c
            com.baidu.searchbox.video.feedflow.detail.onekeytriple.OneKeyTripleUpdateFavorAction r1 = new com.baidu.searchbox.video.feedflow.detail.onekeytriple.OneKeyTripleUpdateFavorAction
            java.lang.String r2 = "onekeytriple"
            r1.<init>(r2)
            com.baidu.searchbox.feed.detail.frame.Action r1 = (com.baidu.searchbox.feed.detail.frame.Action) r1
            r0.dispatch(r1)
        L_0x007c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.onekeytriple.OneKeyTriplePlugin.updateFavorUIAfterTriplePraise(boolean, boolean, boolean, java.lang.String):void");
    }

    private final void updateLikeUIAfterTriplePraise() {
        AbsState state;
        FlowDetailPraiseState flowDetailPraiseState;
        MutableLiveData<PraiseModel> data;
        PraiseModel $this$updateLikeUIAfterTriplePraise_u24lambda_u2d7;
        Store<AbsState> store;
        Store<AbsState> store2 = getStore();
        if (store2 != null && (state = store2.getState()) != null && (flowDetailPraiseState = (FlowDetailPraiseState) state.select(FlowDetailPraiseState.class)) != null && (data = flowDetailPraiseState.getData()) != null && ($this$updateLikeUIAfterTriplePraise_u24lambda_u2d7 = data.getValue()) != null && !$this$updateLikeUIAfterTriplePraise_u24lambda_u2d7.getLiked() && (store = getStore()) != null) {
            store.dispatch(new OneKeyTripleUpdatePraiseAction());
        }
    }

    private final void updateFollowUIAfterTriplePraise() {
        Store<AbsState> store = getStore();
        if (store != null) {
            store.dispatch(new OneKeyTripleUpdateFollowAction());
        }
    }

    private final void updateRewardUIAfterTriplePraise(TriplePraiseData data) {
        Long l;
        String str;
        if (data.isRewardSuccess()) {
            try {
                Result.Companion companion = Result.Companion;
                OneKeyTriplePlugin oneKeyTriplePlugin = this;
                TriplePraiseRewardData reward = data.getReward();
                if (reward == null || (str = reward.getCost()) == null) {
                    str = "0";
                }
                l = Result.m8971constructorimpl(Long.valueOf(Long.parseLong(str)));
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                l = Result.m8971constructorimpl(ResultKt.createFailure(th2));
            }
            if (Result.m8977isFailureimpl(l)) {
                l = 0L;
            }
            long amount = ((Number) l).longValue();
            Store<AbsState> store = getStore();
            if (store != null) {
                TriplePraiseRewardData reward2 = data.getReward();
                store.dispatch(new OneKeyTripleRewardCompleteAction("", amount, String.valueOf(reward2 != null ? reward2.getRewardAmount() : 0)));
            }
        }
    }

    private final void showTriplePraiseToast(boolean isPraise, boolean isFavor, boolean isFollow, boolean isReward, String tripleType) {
        if (isQuadruple(tripleType)) {
            TriplePraiseInterface triplePraiseInterface2 = this.triplePraiseInterface;
            if (triplePraiseInterface2 != null) {
                triplePraiseInterface2.showQuadruplePraiseToast(isPraise, isFavor, isFollow, isReward);
                return;
            }
            return;
        }
        TriplePraiseInterface triplePraiseInterface3 = this.triplePraiseInterface;
        if (triplePraiseInterface3 != null) {
            triplePraiseInterface3.showTriplePraiseToast(isPraise, isFavor, isFollow);
        }
    }

    private final void cancelOneKeyTriple() {
        TriplePraiseInterface triplePraiseInterface2 = this.triplePraiseInterface;
        if (triplePraiseInterface2 != null) {
            triplePraiseInterface2.handleLongPressCancel();
        }
    }

    /* access modifiers changed from: private */
    public final void showOrHideGuide(boolean isVisible) {
        Boolean oneKeyTripleEnable;
        PraiseView praiseView;
        AbsState state;
        FlowDetailPraiseState flowDetailPraiseState;
        MutableLiveData<PraiseModel> data;
        PraiseModel value;
        Store<AbsState> store = getStore();
        if (store == null || (state = store.getState()) == null || (flowDetailPraiseState = (FlowDetailPraiseState) state.select(FlowDetailPraiseState.class)) == null || (data = flowDetailPraiseState.getData()) == null || (value = data.getValue()) == null) {
            oneKeyTripleEnable = null;
        } else {
            oneKeyTripleEnable = Boolean.valueOf(value.getOneKeyTripleEnable());
        }
        if (!Intrinsics.areEqual((Object) oneKeyTripleEnable, (Object) true) || !isVisible || !isCanShow()) {
            hideBubble();
            return;
        }
        IPraiseService iPraiseService = (IPraiseService) getManager().getService(IPraiseService.class);
        if (iPraiseService != null && (praiseView = iPraiseService.getCoolPraiseView()) != null && praiseView.getVisibility() == 0) {
            showBubble(praiseView.getPraiseImage());
        }
    }

    private final void registerGuide() {
        GuidePriorityService guidePriorityService = (GuidePriorityService) getManager().getService(GuidePriorityService.class);
        if (guidePriorityService != null) {
            GuidePriorityService.DefaultImpls.registerGuide$default(guidePriorityService, new OneKeyTriplePlugin$registerGuide$1(this), new OneKeyTriplePlugin$registerGuide$2(this), new OneKeyTriplePlugin$registerGuide$3(this), 35, false, GuideType.INTERACTION, false, 64, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final boolean isShownGuide() {
        return DIFactory.INSTANCE.getConfig().isHasShownOneKeyTripleGuide();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005a, code lost:
        if (r3.isInterceptOneKeyTripGuideShow() == true) goto L_0x005e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean isCanShow() {
        /*
            r8 = this;
            boolean r0 = r8.isShownGuide()
            r1 = 1
            r0 = r0 ^ r1
            com.baidu.searchbox.feed.detail.frame.Store r2 = r8.getStore()
            r3 = 0
            if (r2 == 0) goto L_0x0014
            com.baidu.searchbox.feed.detail.frame.State r2 = r2.getState()
            com.baidu.searchbox.feed.detail.frame.AbsState r2 = (com.baidu.searchbox.feed.detail.frame.AbsState) r2
            goto L_0x0015
        L_0x0014:
            r2 = r3
        L_0x0015:
            boolean r2 = com.baidu.searchbox.video.feedflow.flow.flowstyle.LandscapeFlowSwitchKt.isLandscapeFlowMode((com.baidu.searchbox.feed.detail.frame.AbsState) r2)
            if (r2 == 0) goto L_0x001c
            r0 = 0
        L_0x001c:
            r2 = 0
            if (r0 == 0) goto L_0x0037
            com.baidu.searchbox.feed.detail.arch.ComponentArchManager r4 = r8.getManager()
            java.lang.Class<com.baidu.searchbox.video.service.guidepriority.GuidePriorityService> r5 = com.baidu.searchbox.video.service.guidepriority.GuidePriorityService.class
            com.baidu.searchbox.feed.detail.arch.api.IService r4 = r4.getService(r5)
            com.baidu.searchbox.video.service.guidepriority.GuidePriorityService r4 = (com.baidu.searchbox.video.service.guidepriority.GuidePriorityService) r4
            if (r4 == 0) goto L_0x0035
            r5 = 35
            r6 = 2
            boolean r4 = com.baidu.searchbox.video.service.guidepriority.GuidePriorityService.DefaultImpls.isCanShow$default(r4, r5, r3, r6, r3)
            goto L_0x0036
        L_0x0035:
            r4 = r2
        L_0x0036:
            r0 = r4
        L_0x0037:
            com.baidu.searchbox.feed.detail.frame.Store r4 = r8.getStore()
            if (r4 == 0) goto L_0x005d
            r5 = 0
            com.baidu.searchbox.feed.detail.frame.State r6 = r4.getState()
            boolean r7 = r6 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r7 == 0) goto L_0x0049
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r6 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r6
            goto L_0x004a
        L_0x0049:
            r6 = r3
        L_0x004a:
            if (r6 == 0) goto L_0x0052
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.intercept.InterceptState> r3 = com.baidu.searchbox.video.feedflow.detail.intercept.InterceptState.class
            java.lang.Object r3 = r6.select(r3)
        L_0x0052:
            com.baidu.searchbox.video.feedflow.detail.intercept.InterceptState r3 = (com.baidu.searchbox.video.feedflow.detail.intercept.InterceptState) r3
            if (r3 == 0) goto L_0x005d
            boolean r3 = r3.isInterceptOneKeyTripGuideShow()
            if (r3 != r1) goto L_0x005d
            goto L_0x005e
        L_0x005d:
            r1 = r2
        L_0x005e:
            if (r1 == 0) goto L_0x0061
            r0 = 0
        L_0x0061:
            com.baidu.searchbox.feed.detail.frame.Store r1 = r8.getStore()
            boolean r1 = com.baidu.searchbox.video.feedflow.common.config.BottomInteractAreaConfigHelperKt.isBottomInteractAreaStyle(r1)
            if (r1 == 0) goto L_0x006c
            r0 = 0
        L_0x006c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.onekeytriple.OneKeyTriplePlugin.isCanShow():boolean");
    }

    private final void setGuideHasShown() {
        DIFactory.INSTANCE.getConfig().setOneKeyTripleGuideHasShown();
    }

    private final void showBubble(View anchorView) {
        ViewGroup portraitContainer;
        int i2;
        PageContainerService pageContainerService = (PageContainerService) getManager().getService(PageContainerService.class);
        if (pageContainerService != null && (portraitContainer = pageContainerService.getPageContainerPortrait()) != null) {
            BubbleTextBuilder anchorAndRootView = ((BubbleTextBuilder) BubbleManager.newBuilder(new BubbleTextBuilder().getClass())).setAnchorAndRootView(anchorView, portraitContainer);
            Context context = getContext();
            if (isQuadruple(getTripleType())) {
                i2 = R.string.quadruplePraise_bubble_guidance_tips;
            } else {
                i2 = R.string.triplePraise_bubble_guidance_tips;
            }
            BubbleTextManager $this$showBubble_u24lambda_u2d11 = anchorAndRootView.setText(context.getString(i2)).setAutoDismissInterval(5000).setForceShowPosition(BubblePosition.LEFT).setOnBubbleEventListener((BubbleManager.OnBubbleEventListener) new OneKeyTriplePlugin$showBubble$1(this)).build();
            this.bubbleManager = $this$showBubble_u24lambda_u2d11;
            if ($this$showBubble_u24lambda_u2d11 != null) {
                $this$showBubble_u24lambda_u2d11.enableAnimation(true);
                $this$showBubble_u24lambda_u2d11.showBubble();
            }
            setGuideHasShown();
        }
    }

    private final void hideBubble() {
        BubbleTextManager bubbleTextManager = this.bubbleManager;
        if (bubbleTextManager != null) {
            bubbleTextManager.dismissBubble();
        }
    }

    private final void onNestedAction(NestedAction nestedAction) {
        if (nestedAction instanceof NestedAction.OnBindData) {
            initOneKeyTripleInstance(false);
        } else if (nestedAction instanceof NestedAction.OnDetachFromScreen) {
            hideBubble();
            TriplePraiseInterface triplePraiseInterface2 = this.triplePraiseInterface;
            if (triplePraiseInterface2 != null) {
                triplePraiseInterface2.dismissTripleAnimation();
            }
            initOneKeyTripleInstance(false);
        } else if (nestedAction instanceof NestedAction.OnPageSelected) {
            registerGuide();
            this.triplePraiseSuccess = false;
            this.tripleFollowSuccess = false;
            this.tripleRewardSuccess = false;
            this.currentTripleType = "4";
        }
    }

    public void onDestroy() {
        super.onDestroy();
        TriplePraiseInterface triplePraiseInterface2 = this.triplePraiseInterface;
        if (triplePraiseInterface2 != null) {
            triplePraiseInterface2.dismissTripleAnimation();
        }
    }
}
