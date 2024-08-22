package com.baidu.searchbox.video.feedflow.flow.guide;

import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.util.time.DateTimeUtils;
import com.baidu.searchbox.appframework.BdBoxActivityLifecycle;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.video.component.guide.GuideAction;
import com.baidu.searchbox.video.feedflow.FlowComponentConstantManifestKt;
import com.baidu.searchbox.video.feedflow.common.FlowSwitchState;
import com.baidu.searchbox.video.feedflow.common.FlowSwitchStateKt;
import com.baidu.searchbox.video.feedflow.component.R;
import com.baidu.searchbox.video.feedflow.detail.challenge.challengefromcomment.ChallengeUtilsKt;
import com.baidu.searchbox.video.feedflow.detail.fullplay.FullPlaySwitchConfig;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import com.baidu.searchbox.video.feedflow.flow.flowstyle.LandscapeFlowSwitchKt;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService;
import com.baidu.searchbox.video.feedflow.flow.task.IFlowTaskOperationService;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.libpag.PAGView;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0002J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0013H\u0002J\b\u0010\u0019\u001a\u00020\u0011H\u0014J\b\u0010\u001a\u001a\u00020\u0011H\u0016J\b\u0010\u001b\u001a\u00020\u0011H\u0002J\b\u0010\u001c\u001a\u00020\u0011H\u0004J\b\u0010\u001d\u001a\u00020\u0011H\u0002J\b\u0010\u001e\u001a\u00020\u0011H\u0016J\b\u0010\u001f\u001a\u00020\u0011H\u0002J\b\u0010 \u001a\u00020\u0011H\u0003J\u0012\u0010!\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010#H\u0014J\u001c\u0010$\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010#2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010(\u001a\u00020\u0005H\u0016J\b\u0010)\u001a\u00020\u0005H\u0016J\u0010\u0010*\u001a\u00020\u00052\u0006\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020\u0005H\u0016J\b\u0010.\u001a\u00020\u0005H\u0002J\u0010\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020,H\u0016J\b\u00101\u001a\u00020\u0005H\u0016J\b\u00102\u001a\u00020\u0005H\u0016J\b\u00103\u001a\u00020\u0005H\u0016J\b\u00104\u001a\u00020\u0005H\u0016J\b\u00105\u001a\u00020\u0005H\u0004J\b\u00106\u001a\u00020\u0005H\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001d\u0010\n\u001a\u0004\u0018\u00010\u000b8DX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u00067"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/guide/FlowScrollUpGuideComponent;", "Lcom/baidu/searchbox/video/feedflow/flow/guide/AbsScrollUpGuideComponent;", "()V", "hideRunnable", "Lkotlin/Function0;", "", "getHideRunnable", "()Lkotlin/jvm/functions/Function0;", "setHideRunnable", "(Lkotlin/jvm/functions/Function0;)V", "iFlowComponentService", "Lcom/baidu/searchbox/video/feedflow/flow/service/IFlowComponentService;", "getIFlowComponentService", "()Lcom/baidu/searchbox/video/feedflow/flow/service/IFlowComponentService;", "iFlowComponentService$delegate", "Lkotlin/Lazy;", "canRegisterGuide", "", "getAnimatorJson", "", "getGuideText", "getLandscapeDownUpScrollGuide", "getNewContainerView", "Landroid/view/ViewGroup;", "getPortraitDownUpScrollGuide", "isAutoHide", "isCanShow", "isFlowTaskNeedShowGuide", "isSevenDayUnScrollInLandscapeCase", "isShowTaskPortraitGuide", "isShownGuide", "isShownPortraitGuide", "isTodayShown", "onAnimationUpdate", "view", "Lorg/libpag/PAGView;", "onChangeLottieViewSize", "pagView", "tvView", "Landroid/widget/TextView;", "onCreate", "onDestroy", "onPageSelected", "position", "", "onStop", "registerBackForegroundEvent", "scrollBy", "dy", "scrollToSelectedPosition", "setGuideHasShown", "setGuideUploadStartShow", "setGuideUploadStopShow", "setPortraitGuideHasShown", "unregisterBackForegroundEvent", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowScrollUpGuideComponent.kt */
public class FlowScrollUpGuideComponent extends AbsScrollUpGuideComponent {
    private Function0<Unit> hideRunnable = new FlowScrollUpGuideComponent$hideRunnable$1(this);
    private final Lazy iFlowComponentService$delegate = LazyKt.lazy(new FlowScrollUpGuideComponent$iFlowComponentService$2(this));

    /* access modifiers changed from: protected */
    public final IFlowComponentService getIFlowComponentService() {
        return (IFlowComponentService) this.iFlowComponentService$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public final Function0<Unit> getHideRunnable() {
        return this.hideRunnable;
    }

    /* access modifiers changed from: protected */
    public final void setHideRunnable(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.hideRunnable = function0;
    }

    public void scrollToSelectedPosition() {
    }

    public void scrollBy(int dy) {
        IFlowComponentService iFlowComponentService = getIFlowComponentService();
        if (iFlowComponentService != null) {
            iFlowComponentService.scrollBy(dy);
        }
    }

    /* access modifiers changed from: protected */
    public void onAnimationUpdate(PAGView view2) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x007f, code lost:
        if (r1 != false) goto L_0x0081;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isCanShow() {
        /*
            r8 = this;
            boolean r0 = r8.isShownGuide()
            r1 = 1
            r0 = r0 ^ r1
            r2 = 0
            r3 = 0
            if (r0 == 0) goto L_0x0021
            com.baidu.searchbox.feed.detail.arch.ComponentArchManager r4 = r8.getManager()
            java.lang.Class<com.baidu.searchbox.video.service.guidepriority.GuidePriorityService> r5 = com.baidu.searchbox.video.service.guidepriority.GuidePriorityService.class
            com.baidu.searchbox.feed.detail.arch.api.IService r4 = r4.getService(r5)
            com.baidu.searchbox.video.service.guidepriority.GuidePriorityService r4 = (com.baidu.searchbox.video.service.guidepriority.GuidePriorityService) r4
            if (r4 == 0) goto L_0x001f
            r5 = 5
            r6 = 2
            boolean r4 = com.baidu.searchbox.video.service.guidepriority.GuidePriorityService.DefaultImpls.isCanShow$default(r4, r5, r2, r6, r2)
            goto L_0x0020
        L_0x001f:
            r4 = r3
        L_0x0020:
            r0 = r4
        L_0x0021:
            com.baidu.searchbox.feed.detail.frame.Store r4 = r8.getStore()
            if (r4 == 0) goto L_0x0044
            r5 = 0
            com.baidu.searchbox.feed.detail.frame.State r6 = r4.getState()
            boolean r7 = r6 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r7 == 0) goto L_0x0033
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r6 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r6
            goto L_0x0034
        L_0x0033:
            r6 = r2
        L_0x0034:
            if (r6 == 0) goto L_0x003d
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r7 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r6 = r6.select(r7)
            goto L_0x003e
        L_0x003d:
            r6 = r2
        L_0x003e:
            com.baidu.searchbox.video.detail.core.model.IntentData r6 = (com.baidu.searchbox.video.detail.core.model.IntentData) r6
            if (r6 == 0) goto L_0x0044
            java.lang.String r2 = r6.pd
        L_0x0044:
            if (r2 != 0) goto L_0x0048
            java.lang.String r2 = ""
        L_0x0048:
            boolean r2 = com.baidu.searchbox.video.detail.business.VideoBizUtilsKt.isPdFromPushNews(r2)
            if (r2 == 0) goto L_0x004f
            r0 = 0
        L_0x004f:
            com.baidu.searchbox.feed.detail.frame.Store r2 = r8.getStore()
            if (r2 == 0) goto L_0x005d
            boolean r2 = com.baidu.searchbox.video.feedflow.utils.TabUtilsKt.isInHotTab((com.baidu.searchbox.feed.detail.frame.Store<?>) r2)
            if (r2 != r1) goto L_0x005d
            r2 = r1
            goto L_0x005e
        L_0x005d:
            r2 = r3
        L_0x005e:
            if (r2 != 0) goto L_0x0081
            com.baidu.searchbox.feed.detail.frame.Store r2 = r8.getStore()
            if (r2 == 0) goto L_0x006e
            boolean r2 = com.baidu.searchbox.video.feedflow.utils.TabUtilsKt.isInAttentionTab((com.baidu.searchbox.feed.detail.frame.Store<?>) r2)
            if (r2 != r1) goto L_0x006e
            r2 = r1
            goto L_0x006f
        L_0x006e:
            r2 = r3
        L_0x006f:
            if (r2 != 0) goto L_0x0081
            com.baidu.searchbox.feed.detail.frame.Store r2 = r8.getStore()
            if (r2 == 0) goto L_0x007e
            boolean r2 = com.baidu.searchbox.video.feedflow.utils.TabUtilsKt.isInLiveTab((com.baidu.searchbox.feed.detail.frame.Store<?>) r2)
            if (r2 != r1) goto L_0x007e
            goto L_0x007f
        L_0x007e:
            r1 = r3
        L_0x007f:
            if (r1 == 0) goto L_0x0082
        L_0x0081:
            r0 = 0
        L_0x0082:
            com.baidu.searchbox.feed.detail.frame.Store r1 = r8.getStore()
            boolean r1 = com.baidu.searchbox.video.feedflow.common.CommonStoreExtKt.isSingleVideoPage((com.baidu.searchbox.feed.detail.frame.Store<?>) r1)
            if (r1 == 0) goto L_0x008d
            r0 = 0
        L_0x008d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.flow.guide.FlowScrollUpGuideComponent.isCanShow():boolean");
    }

    public boolean isShownGuide() {
        Store<AbsState> store = getStore();
        boolean isLandscape = LandscapeFlowSwitchKt.isLandscapeFlowMode(store != null ? store.getState() : null);
        if (isLandscape && ChallengeUtilsKt.isFromCommentChallenge$default((Store) getStore(), (ItemModel) null, 1, (Object) null)) {
            return true;
        }
        if (isLandscape) {
            if (isSevenDayUnScrollInLandscapeCase()) {
                return false;
            }
            return true;
        } else if (isFlowTaskNeedShowGuide()) {
            if (!isShowTaskPortraitGuide()) {
                return true;
            }
            return false;
        } else if (!isShownPortraitGuide()) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public final boolean isSevenDayUnScrollInLandscapeCase() {
        Store $this$select$iv = getStore();
        FullPlaySwitchConfig fullPlaySwitchConfig = null;
        if ($this$select$iv != null) {
            AbsState state = $this$select$iv.getState();
            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
            FlowSwitchState flowSwitchState = (FlowSwitchState) (commonState != null ? commonState.select(FlowSwitchState.class) : null);
            if (flowSwitchState != null) {
                fullPlaySwitchConfig = flowSwitchState.getFullPlayConfigConfig();
            }
        }
        FullPlaySwitchConfig fullPlayConfigConfig = fullPlaySwitchConfig;
        if (fullPlayConfigConfig != null && fullPlayConfigConfig.getFullScreenTipSwitch() && DIFactory.INSTANCE.getConfig().getLandscapeScrollCountNumber() < fullPlayConfigConfig.getSevenDayUnScrollGuideTimes()) {
            long lastShownTime = DIFactory.INSTANCE.getConfig().getLandscapeScrollTime();
            if (lastShownTime == 0) {
                DIFactory.INSTANCE.getConfig().saveLandscapeScrollTime();
                lastShownTime = System.currentTimeMillis();
            }
            if (DateTimeUtils.interval(lastShownTime, System.currentTimeMillis()) >= 7) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0033 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00e0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean isShownPortraitGuide() {
        /*
            r7 = this;
            com.baidu.searchbox.feed.detail.frame.Store r0 = r7.getStore()
            r1 = 0
            if (r0 == 0) goto L_0x002b
            r2 = 0
            com.baidu.searchbox.feed.detail.frame.State r3 = r0.getState()
            boolean r4 = r3 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r4 == 0) goto L_0x0013
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r3 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r3
            goto L_0x0014
        L_0x0013:
            r3 = r1
        L_0x0014:
            if (r3 == 0) goto L_0x001d
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.intercept.InterceptState> r4 = com.baidu.searchbox.video.feedflow.detail.intercept.InterceptState.class
            java.lang.Object r3 = r3.select(r4)
            goto L_0x001e
        L_0x001d:
            r3 = r1
        L_0x001e:
            com.baidu.searchbox.video.feedflow.detail.intercept.InterceptState r3 = (com.baidu.searchbox.video.feedflow.detail.intercept.InterceptState) r3
            if (r3 == 0) goto L_0x002b
            boolean r0 = r3.isInterceptAutoShowPanel()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x002c
        L_0x002b:
            r0 = r1
        L_0x002c:
            boolean r0 = com.baidu.searchbox.player.utils.BdPlayerUtils.orFalse(r0)
            r2 = 0
            if (r0 == 0) goto L_0x0034
            return r2
        L_0x0034:
            com.baidu.searchbox.feed.detail.arch.ComponentArchManager r0 = r7.getManager()
            r3 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.nextbigcard.service.INextBigCardPanelService> r4 = com.baidu.searchbox.video.feedflow.detail.nextbigcard.service.INextBigCardPanelService.class
            com.baidu.searchbox.feed.detail.arch.api.IService r0 = r0.getService(r4)
            com.baidu.searchbox.video.feedflow.detail.nextbigcard.service.INextBigCardPanelService r0 = (com.baidu.searchbox.video.feedflow.detail.nextbigcard.service.INextBigCardPanelService) r0
            if (r0 == 0) goto L_0x004c
            boolean r0 = r0.isPanelShowing()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x004d
        L_0x004c:
            r0 = r1
        L_0x004d:
            boolean r0 = com.baidu.searchbox.player.utils.BdPlayerUtils.orFalse(r0)
            if (r0 == 0) goto L_0x0054
            return r2
        L_0x0054:
            com.baidu.searchbox.feed.detail.frame.Store r0 = r7.getStore()
            r3 = 1
            boolean r0 = com.baidu.searchbox.video.feedflow.detail.halfscreen.switcher.HalfScreenSwitchConfigKt.canShowHalfScreen$default((com.baidu.searchbox.feed.detail.frame.Store) r0, (boolean) r2, (int) r3, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x0063
            r7.setGuideHasShown()
            return r2
        L_0x0063:
            com.baidu.searchbox.feed.detail.frame.Store r0 = r7.getStore()
            boolean r0 = com.baidu.searchbox.video.feedflow.detail.challenge.challengefromcomment.ChallengeUtilsKt.isFromCommentChallenge$default((com.baidu.searchbox.feed.detail.frame.Store) r0, (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r1, (int) r3, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x0087
            com.baidu.searchbox.video.feedflow.di.DIFactory r0 = com.baidu.searchbox.video.feedflow.di.DIFactory.INSTANCE
            com.baidu.searchbox.video.feedflow.di.IFlowVideoConfig r0 = r0.getConfig()
            boolean r0 = r0.needShowPortraitGuide()
            if (r0 == 0) goto L_0x0086
            com.baidu.searchbox.video.feedflow.di.DIFactory r0 = com.baidu.searchbox.video.feedflow.di.DIFactory.INSTANCE
            com.baidu.searchbox.video.feedflow.di.IFlowVideoConfig r0 = r0.getConfig()
            int r0 = r0.getCommentVideoPortraitUpGuideShowCount()
            if (r0 != 0) goto L_0x0086
            r2 = r3
        L_0x0086:
            return r2
        L_0x0087:
            com.baidu.searchbox.video.feedflow.di.DIFactory r0 = com.baidu.searchbox.video.feedflow.di.DIFactory.INSTANCE
            com.baidu.searchbox.video.feedflow.di.IFlowVideoConfig r0 = r0.getConfig()
            boolean r0 = r0.needShowPortraitGuide()
            if (r0 == 0) goto L_0x0121
            boolean r0 = r7.isTodayShown()
            if (r0 != 0) goto L_0x0121
            com.baidu.searchbox.video.feedflow.di.DIFactory r0 = com.baidu.searchbox.video.feedflow.di.DIFactory.INSTANCE
            com.baidu.searchbox.video.feedflow.di.IFlowVideoConfig r0 = r0.getConfig()
            int r0 = r0.getPortraitUpGuideShowCount()
            if (r0 != 0) goto L_0x00a6
            return r3
        L_0x00a6:
            com.baidu.searchbox.video.feedflow.di.DIFactory r0 = com.baidu.searchbox.video.feedflow.di.DIFactory.INSTANCE
            com.baidu.searchbox.video.feedflow.di.IFlowVideoConfig r0 = r0.getConfig()
            int r0 = r0.getPortraitUpGuideShowCount()
            r4 = 3
            if (r0 >= r4) goto L_0x0121
            com.baidu.searchbox.feed.detail.frame.Store r0 = r7.getStore()
            if (r0 == 0) goto L_0x00d7
            r4 = 0
            com.baidu.searchbox.feed.detail.frame.State r5 = r0.getState()
            boolean r6 = r5 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r6 == 0) goto L_0x00c5
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r5 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r5
            goto L_0x00c6
        L_0x00c5:
            r5 = r1
        L_0x00c6:
            if (r5 == 0) goto L_0x00cf
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r6 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r5 = r5.select(r6)
            goto L_0x00d0
        L_0x00cf:
            r5 = r1
        L_0x00d0:
            com.baidu.searchbox.video.detail.core.model.IntentData r5 = (com.baidu.searchbox.video.detail.core.model.IntentData) r5
            if (r5 == 0) goto L_0x00d7
            java.lang.String r0 = r5.triggerType
            goto L_0x00d8
        L_0x00d7:
            r0 = r1
        L_0x00d8:
            java.lang.String r4 = "1"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r0)
            if (r0 != 0) goto L_0x0120
            com.baidu.searchbox.feed.detail.frame.Store r0 = r7.getStore()
            if (r0 == 0) goto L_0x00f4
            com.baidu.searchbox.video.feedflow.common.FlowSwitchState r0 = com.baidu.searchbox.video.feedflow.common.FlowSwitchStateKt.flowSwitchState((com.baidu.searchbox.feed.detail.frame.Store<?>) r0)
            if (r0 == 0) goto L_0x00f4
            boolean r0 = r0.getFlowUnDownCountSwitch()
            if (r0 != r3) goto L_0x00f4
            r0 = r3
            goto L_0x00f5
        L_0x00f4:
            r0 = r2
        L_0x00f5:
            if (r0 == 0) goto L_0x0121
            com.baidu.searchbox.feed.detail.frame.Store r0 = r7.getStore()
            if (r0 == 0) goto L_0x011a
            r4 = 0
            com.baidu.searchbox.feed.detail.frame.State r5 = r0.getState()
            boolean r6 = r5 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r6 == 0) goto L_0x0109
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r5 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r5
            goto L_0x010a
        L_0x0109:
            r5 = r1
        L_0x010a:
            if (r5 == 0) goto L_0x0113
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r6 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r5 = r5.select(r6)
            goto L_0x0114
        L_0x0113:
            r5 = r1
        L_0x0114:
            com.baidu.searchbox.video.detail.core.model.IntentData r5 = (com.baidu.searchbox.video.detail.core.model.IntentData) r5
            if (r5 == 0) goto L_0x011a
            java.lang.String r1 = r5.page
        L_0x011a:
            boolean r0 = com.baidu.searchbox.video.detail.business.VideoBizUtilsKt.isFromSearch(r1)
            if (r0 == 0) goto L_0x0121
        L_0x0120:
            return r3
        L_0x0121:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.flow.guide.FlowScrollUpGuideComponent.isShownPortraitGuide():boolean");
    }

    private final boolean isShowTaskPortraitGuide() {
        if (GuideSpHelper.INSTANCE.getTaskGuideCount() == 0) {
            return true;
        }
        return false;
    }

    private final boolean isFlowTaskNeedShowGuide() {
        IFlowTaskOperationService iFlowTaskOperationService = (IFlowTaskOperationService) getManager().getService(IFlowTaskOperationService.class);
        return BdPlayerUtils.orFalse(iFlowTaskOperationService != null ? Boolean.valueOf(iFlowTaskOperationService.isNeedShowTaskGuideVisible()) : null);
    }

    private final boolean isTodayShown() {
        return Intrinsics.areEqual((Object) DIFactory.INSTANCE.getConfig().getPortraitUpGuideShowData(), (Object) new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
    }

    public void setGuideHasShown() {
        Store<AbsState> store = getStore();
        if (!LandscapeFlowSwitchKt.isLandscapeFlowMode(store != null ? store.getState() : null)) {
            if (isFlowTaskNeedShowGuide()) {
                GuideSpHelper.INSTANCE.setTaskGuideCount(GuideSpHelper.INSTANCE.getTaskGuideCount() + 1);
            }
            setPortraitGuideHasShown();
        } else if (isSevenDayUnScrollInLandscapeCase()) {
            DIFactory.INSTANCE.getConfig().saveLandscapeScrollCountNumber(DIFactory.INSTANCE.getConfig().getLandscapeScrollCountNumber() + 1);
            DIFactory.INSTANCE.getConfig().saveLandscapeScrollTime();
            DIFactory.INSTANCE.getHandler().postDelayed(new FlowScrollUpGuideComponent$$ExternalSyntheticLambda1(this.hideRunnable), 3000);
        } else {
            DIFactory.INSTANCE.getConfig().setLandscapeGuideHasShown();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setGuideHasShown$lambda-0  reason: not valid java name */
    public static final void m6379setGuideHasShown$lambda0(Function0 $tmp0) {
        Intrinsics.checkNotNullParameter($tmp0, "$tmp0");
        $tmp0.invoke();
    }

    public void setGuideUploadStartShow() {
        Store<AbsState> store = getStore();
        if (!LandscapeFlowSwitchKt.isLandscapeFlowMode(store != null ? store.getState() : null) || !isSevenDayUnScrollInLandscapeCase()) {
            Store<AbsState> store2 = getStore();
            if (store2 != null) {
                store2.dispatch(GuideAction.OnGuideScrollUpStartAction.INSTANCE);
                return;
            }
            return;
        }
        Store<AbsState> store3 = getStore();
        if (store3 != null) {
            store3.dispatch(SevenDayUnScrollUpStartGuideAction.INSTANCE);
        }
    }

    public void setGuideUploadStopShow() {
        Store<AbsState> store = getStore();
        if (!LandscapeFlowSwitchKt.isLandscapeFlowMode(store != null ? store.getState() : null) || !isSevenDayUnScrollInLandscapeCase()) {
            Store<AbsState> store2 = getStore();
            if (store2 != null) {
                store2.dispatch(GuideAction.OnGuideScrollUpStopAction.INSTANCE);
                return;
            }
            return;
        }
        Store<AbsState> store3 = getStore();
        if (store3 != null) {
            store3.dispatch(SevenDayUnScrollUpStopGuideAction.INSTANCE);
        }
    }

    /* access modifiers changed from: protected */
    public final void setPortraitGuideHasShown() {
        if (ChallengeUtilsKt.isFromCommentChallenge$default((Store) getStore(), (ItemModel) null, 1, (Object) null)) {
            DIFactory.INSTANCE.getConfig().saveCommentVideoPortraitUpGuideShowCount(DIFactory.INSTANCE.getConfig().getCommentVideoPortraitUpGuideShowCount() + 1);
        } else if (isTodayShown() == 0) {
            DIFactory.INSTANCE.getConfig().savePortraitUpGuideShowData();
            int showNum = DIFactory.INSTANCE.getConfig().getPortraitUpGuideShowCount() + 1;
            DIFactory.INSTANCE.getConfig().savePortraitUpGuideShowCount(showNum);
            if (showNum >= 3) {
                DIFactory.INSTANCE.getConfig().setPortraitGuideHasShown();
            }
        }
    }

    public String getAnimatorJson() {
        Store<AbsState> store = getStore();
        if (LandscapeFlowSwitchKt.isLandscapeFlowMode(store != null ? store.getState() : null)) {
            return getLandscapeDownUpScrollGuide();
        }
        if (isFlowTaskNeedShowGuide()) {
            return "assets://pag/video_flow_task_guide_down_up_scroll.pag";
        }
        return getPortraitDownUpScrollGuide();
    }

    private final String getLandscapeDownUpScrollGuide() {
        return "assets://pag/video_flow_guide_down_up_scroll_landscape.pag";
    }

    private final String getPortraitDownUpScrollGuide() {
        return "assets://pag/video_flow_guide_down_up_scroll_portrait.pag";
    }

    public String getGuideText() {
        if (!isFlowTaskNeedShowGuide()) {
            return super.getGuideText();
        }
        String string = getContext().getString(R.string.video_flow_guide_obtain_coin);
        Intrinsics.checkNotNullExpressionValue(string, "{\n            context.ge…de_obtain_coin)\n        }");
        return string;
    }

    public void onPageSelected(int position) {
        if (position != 0 && !isShownGuide()) {
            setGuideHasShown();
        }
    }

    public ViewGroup getNewContainerView() {
        IFlowComponentService iFlowComponentService = getIFlowComponentService();
        KeyEvent.Callback curScreenItemView = iFlowComponentService != null ? iFlowComponentService.getCurScreenItemView() : null;
        if (curScreenItemView instanceof ViewGroup) {
            return (ViewGroup) curScreenItemView;
        }
        return null;
    }

    public void onChangeLottieViewSize(PAGView pagView, TextView tvView) {
        Store<AbsState> store = getStore();
        if (LandscapeFlowSwitchKt.isLandscapeFlowMode(store != null ? store.getState() : null)) {
            if (pagView != null) {
                PAGView $this$onChangeLottieViewSize_u24lambda_u2d1 = pagView;
                ViewGroup.LayoutParams layoutParams = $this$onChangeLottieViewSize_u24lambda_u2d1.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = $this$onChangeLottieViewSize_u24lambda_u2d1.getResources().getDimensionPixelOffset(R.dimen.video_flow_dimens_280dp);
                }
                ViewGroup.LayoutParams layoutParams2 = $this$onChangeLottieViewSize_u24lambda_u2d1.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.height = $this$onChangeLottieViewSize_u24lambda_u2d1.getResources().getDimensionPixelOffset(R.dimen.video_flow_dimens_250dp);
                }
            }
            if (tvView != null) {
                TextView $this$onChangeLottieViewSize_u24lambda_u2d3 = tvView;
                LinearLayout.LayoutParams $this$onChangeLottieViewSize_u24lambda_u2d3_u24lambda_u2d2 = new LinearLayout.LayoutParams(-2, -1);
                $this$onChangeLottieViewSize_u24lambda_u2d3_u24lambda_u2d2.setMargins(0, $this$onChangeLottieViewSize_u24lambda_u2d3.getResources().getDimensionPixelOffset(com.baidu.searchbox.feed.styles.R.dimen.F_M_H_X068), 0, 0);
                $this$onChangeLottieViewSize_u24lambda_u2d3.setLayoutParams($this$onChangeLottieViewSize_u24lambda_u2d3_u24lambda_u2d2);
                return;
            }
            return;
        }
        if (pagView != null) {
            PAGView $this$onChangeLottieViewSize_u24lambda_u2d4 = pagView;
            ViewGroup.LayoutParams layoutParams3 = $this$onChangeLottieViewSize_u24lambda_u2d4.getLayoutParams();
            if (layoutParams3 != null) {
                layoutParams3.width = $this$onChangeLottieViewSize_u24lambda_u2d4.getResources().getDimensionPixelOffset(R.dimen.video_flow_guide_size);
            }
            ViewGroup.LayoutParams layoutParams4 = $this$onChangeLottieViewSize_u24lambda_u2d4.getLayoutParams();
            if (layoutParams4 != null) {
                layoutParams4.height = $this$onChangeLottieViewSize_u24lambda_u2d4.getResources().getDimensionPixelOffset(R.dimen.video_flow_guide_size);
            }
        }
        if (tvView != null) {
            TextView $this$onChangeLottieViewSize_u24lambda_u2d6 = tvView;
            LinearLayout.LayoutParams $this$onChangeLottieViewSize_u24lambda_u2d6_u24lambda_u2d5 = new LinearLayout.LayoutParams(-2, -1);
            $this$onChangeLottieViewSize_u24lambda_u2d6_u24lambda_u2d5.setMargins(0, $this$onChangeLottieViewSize_u24lambda_u2d6.getResources().getDimensionPixelOffset(com.baidu.searchbox.feed.styles.R.dimen.F_M_H_X085), 0, 0);
            $this$onChangeLottieViewSize_u24lambda_u2d6.setLayoutParams($this$onChangeLottieViewSize_u24lambda_u2d6_u24lambda_u2d5);
        }
    }

    /* access modifiers changed from: protected */
    public boolean isAutoHide() {
        return isFlowTaskNeedShowGuide();
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onStop() {
        /*
            r5 = this;
            super.onStop()
            com.baidu.searchbox.feed.detail.frame.Store r0 = r5.getStore()
            if (r0 == 0) goto L_0x0037
            r1 = 0
            com.baidu.searchbox.feed.detail.frame.State r2 = r0.getState()
            boolean r3 = r2 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            r4 = 0
            if (r3 == 0) goto L_0x0016
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r2 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r2
            goto L_0x0017
        L_0x0016:
            r2 = r4
        L_0x0017:
            if (r2 == 0) goto L_0x001f
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.guide.FlowScrollUpGuideShowState> r3 = com.baidu.searchbox.video.feedflow.flow.guide.FlowScrollUpGuideShowState.class
            java.lang.Object r4 = r2.select(r3)
        L_0x001f:
            com.baidu.searchbox.video.feedflow.flow.guide.FlowScrollUpGuideShowState r4 = (com.baidu.searchbox.video.feedflow.flow.guide.FlowScrollUpGuideShowState) r4
            if (r4 == 0) goto L_0x0037
            androidx.lifecycle.MutableLiveData r0 = r4.isShowGuide()
            if (r0 == 0) goto L_0x0037
            java.lang.Object r0 = r0.getValue()
            r1 = 1
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            goto L_0x0038
        L_0x0037:
            r0 = 0
        L_0x0038:
            if (r0 == 0) goto L_0x004a
            com.baidu.searchbox.feed.detail.frame.Store r0 = r5.getStore()
            if (r0 == 0) goto L_0x004a
            com.baidu.searchbox.video.feedflow.flow.guide.GuideShowingAndBack r1 = new com.baidu.searchbox.video.feedflow.flow.guide.GuideShowingAndBack
            r1.<init>()
            com.baidu.searchbox.feed.detail.frame.Action r1 = (com.baidu.searchbox.feed.detail.frame.Action) r1
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r0, r1)
        L_0x004a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.flow.guide.FlowScrollUpGuideComponent.onStop():void");
    }

    public void onCreate() {
        super.onCreate();
        registerBackForegroundEvent();
    }

    private final void registerBackForegroundEvent() {
        BdEventBus.Companion.getDefault().register(this, BdBoxActivityLifecycle.BackForegroundEvent.class, 1, new FlowScrollUpGuideComponent$$ExternalSyntheticLambda2(this));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.baidu.searchbox.video.feedflow.flow.guide.FlowScrollUpGuideShowState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.baidu.searchbox.video.feedflow.flow.guide.FlowScrollUpGuideShowState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: com.baidu.searchbox.video.feedflow.flow.guide.FlowScrollUpGuideShowState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: com.baidu.searchbox.video.feedflow.flow.guide.FlowScrollUpGuideShowState} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: registerBackForegroundEvent$lambda-7  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m6378registerBackForegroundEvent$lambda7(com.baidu.searchbox.video.feedflow.flow.guide.FlowScrollUpGuideComponent r5, com.baidu.searchbox.appframework.BdBoxActivityLifecycle.BackForegroundEvent r6) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "type"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            com.baidu.searchbox.feed.detail.frame.Store r0 = r5.getStore()
            r1 = 0
            if (r0 == 0) goto L_0x002a
            r2 = 0
            com.baidu.searchbox.feed.detail.frame.State r3 = r0.getState()
            boolean r4 = r3 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r4 == 0) goto L_0x001f
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r3 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r3
            goto L_0x0020
        L_0x001f:
            r3 = r1
        L_0x0020:
            if (r3 == 0) goto L_0x0028
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.guide.FlowScrollUpGuideShowState> r1 = com.baidu.searchbox.video.feedflow.flow.guide.FlowScrollUpGuideShowState.class
            java.lang.Object r1 = r3.select(r1)
        L_0x0028:
            com.baidu.searchbox.video.feedflow.flow.guide.FlowScrollUpGuideShowState r1 = (com.baidu.searchbox.video.feedflow.flow.guide.FlowScrollUpGuideShowState) r1
        L_0x002a:
            if (r1 != 0) goto L_0x002d
            goto L_0x0032
        L_0x002d:
            boolean r0 = r6.isForeground
            r1.setForegroundForGuide(r0)
        L_0x0032:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.flow.guide.FlowScrollUpGuideComponent.m6378registerBackForegroundEvent$lambda7(com.baidu.searchbox.video.feedflow.flow.guide.FlowScrollUpGuideComponent, com.baidu.searchbox.appframework.BdBoxActivityLifecycle$BackForegroundEvent):void");
    }

    private final void unregisterBackForegroundEvent() {
        BdEventBus.Companion.getDefault().unregister(this);
    }

    public boolean canRegisterGuide() {
        if (((Boolean) FlowSwitchStateKt.flowSwitchState((Store<?>) getStore()).getExtra(FlowComponentConstantManifestKt.REGISTER_SEARCH_SLIDE_GUIDE_SUCCESS, false)).booleanValue()) {
            return false;
        }
        return super.canRegisterGuide();
    }

    public void onDestroy() {
        super.onDestroy();
        unregisterBackForegroundEvent();
        DIFactory.INSTANCE.getHandler().removeCallbacks(new FlowScrollUpGuideComponent$$ExternalSyntheticLambda0(this.hideRunnable));
    }

    /* access modifiers changed from: private */
    /* renamed from: onDestroy$lambda-8  reason: not valid java name */
    public static final void m6377onDestroy$lambda8(Function0 $tmp0) {
        Intrinsics.checkNotNullParameter($tmp0, "$tmp0");
        $tmp0.invoke();
    }
}
