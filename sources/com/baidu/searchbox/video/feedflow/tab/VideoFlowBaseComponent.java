package com.baidu.searchbox.video.feedflow.tab;

import android.util.AttributeSet;
import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.arch.ext.CoreAction;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.State;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.feed.detail.frame.api.IActionTransferInterceptor;
import com.baidu.searchbox.video.component.autoplay.service.IAutoPlayInterceptorService;
import com.baidu.searchbox.video.component.base.AbsItemComponent;
import com.baidu.searchbox.video.detail.core.model.IntentData;
import com.baidu.searchbox.video.feedflow.ad.carousel.INadCarouselService;
import com.baidu.searchbox.video.feedflow.ad.dynamic.carouselpic.INadCarouselPicService;
import com.baidu.searchbox.video.feedflow.common.FlowSwitchState;
import com.baidu.searchbox.video.feedflow.common.serviceimpl.NestedServiceRegisterHelper;
import com.baidu.searchbox.video.feedflow.detail.air.AirPlayStatusState;
import com.baidu.searchbox.video.feedflow.detail.livereal.ILiveRealContainerService;
import com.baidu.searchbox.video.feedflow.detail.moveup.IPanelMoveUpService;
import com.baidu.searchbox.video.feedflow.detail.onekeytriple.OneKeyTripleInstanceState;
import com.baidu.searchbox.video.feedflow.detail.payment.player.service.IPaymentFlowPlayerService;
import com.baidu.searchbox.video.feedflow.detail.talosassessbig.common.IAssessmentCard2Service;
import com.baidu.searchbox.video.feedflow.detail.videosummary.IVideoSummaryService;
import com.baidu.searchbox.video.feedflow.flow.bottom.BottomBarState;
import com.baidu.searchbox.video.feedflow.flow.enterpathway.EnterPathWayState;
import com.baidu.searchbox.video.feedflow.flow.globalmuteguide.GlobalMuteGuideState;
import com.baidu.searchbox.video.feedflow.flow.list.IntentToFlowModelState;
import com.baidu.searchbox.video.feedflow.flow.playmode.IPlayModeService;
import com.baidu.searchbox.video.feedflow.flow.pullrefresh.IPullRefreshService;
import com.baidu.searchbox.video.feedflow.flow.screenorientation.PlayerOrientationState;
import com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService;
import com.baidu.searchbox.video.feedflow.flow.talos.TalosNativeState;
import com.baidu.searchbox.video.feedflow.flow.topexpand.expandable.ITopExpandableService;
import com.baidu.searchbox.video.feedflow.helper.VideoItemComponentHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0014J\b\u0010\u0007\u001a\u00020\bH\u0014J\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0014J\b\u0010\u0010\u001a\u00020\fH\u0014J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0002H\u0014J\b\u0010\u0014\u001a\u00020\fH\u0016J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0014J\b\u0010\u0016\u001a\u00020\fH\u0014J \u0010\u0017\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\u000fH\u0014J\b\u0010\u001a\u001a\u00020\fH\u0014J\b\u0010\u001b\u001a\u00020\fH\u0014¨\u0006\u001c"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/tab/VideoFlowBaseComponent;", "Lcom/baidu/searchbox/video/component/base/AbsItemComponent;", "Lcom/baidu/searchbox/video/feedflow/tab/TabInfoModel;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "createViewInternal", "Lcom/baidu/searchbox/video/feedflow/tab/TabItemView;", "getActionInterceptor", "Lcom/baidu/searchbox/feed/detail/frame/api/IActionTransferInterceptor;", "getTabPosition", "", "injectService", "", "onAttachToScreen", "tag", "", "onAttachToViewTree", "onBindData", "position", "model", "onCreate", "onDetachFromScreen", "onDetachFromViewTree", "onSelected", "isUp", "", "registerTransmitServices", "transmitStateToChildStore", "feed-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoFlowBaseComponent.kt */
public abstract class VideoFlowBaseComponent extends AbsItemComponent<TabInfoModel, CommonState> {
    /* access modifiers changed from: protected */
    public TabItemView createViewInternal() {
        TabItemView $this$createViewInternal_u24lambda_u2d0 = new TabItemView(getContext(), (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        $this$createViewInternal_u24lambda_u2d0.addView(getItemManager().createView());
        $this$createViewInternal_u24lambda_u2d0.setStateListener(getItemViewStateListener());
        return $this$createViewInternal_u24lambda_u2d0;
    }

    /* access modifiers changed from: protected */
    public void transmitStateToChildStore() {
        AbsState absState;
        Object $this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv;
        AbsState absState2;
        Object $this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv2;
        AbsState absState3;
        Object $this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv3;
        AbsState absState4;
        Object $this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv4;
        AbsState absState5;
        Object $this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv5;
        AbsState absState6;
        Object $this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv6;
        AbsState absState7;
        Object $this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv7;
        AbsState absState8;
        Object $this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv8;
        AbsState absState9;
        Object $this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv9;
        AbsState absState10;
        Object $this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv10;
        Store $this$transmitStateToChildStore_u24lambda_u2d1 = getStore();
        if ($this$transmitStateToChildStore_u24lambda_u2d1 != null) {
            VideoItemComponentHelper.Impl.INSTANCE.get().transmitVideoItemState($this$transmitStateToChildStore_u24lambda_u2d1, getItemStore());
        }
        AbsItemComponent this_$iv = this;
        Store access$getStore = this_$iv.store;
        if (!(access$getStore == null || (absState10 = (AbsState) access$getStore.getState()) == null || ($this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv10 = absState10.select(PlayerOrientationState.class)) == null)) {
            AbsState state = this_$iv.getItemStore().getState();
            String name = PlayerOrientationState.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, "T::class.java.name");
            state.put(name, $this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv10);
        }
        AbsItemComponent this_$iv2 = this;
        Store access$getStore2 = this_$iv2.store;
        if (!(access$getStore2 == null || (absState9 = (AbsState) access$getStore2.getState()) == null || ($this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv9 = absState9.select(TabState.class)) == null)) {
            AbsState state2 = this_$iv2.getItemStore().getState();
            String name2 = TabState.class.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "T::class.java.name");
            state2.put(name2, $this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv9);
        }
        AbsItemComponent this_$iv3 = this;
        Store access$getStore3 = this_$iv3.store;
        if (!(access$getStore3 == null || (absState8 = (AbsState) access$getStore3.getState()) == null || ($this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv8 = absState8.select(FlowSwitchState.class)) == null)) {
            AbsState state3 = this_$iv3.getItemStore().getState();
            String name3 = FlowSwitchState.class.getName();
            Intrinsics.checkNotNullExpressionValue(name3, "T::class.java.name");
            state3.put(name3, $this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv8);
        }
        AbsItemComponent this_$iv4 = this;
        Store access$getStore4 = this_$iv4.store;
        if (!(access$getStore4 == null || (absState7 = (AbsState) access$getStore4.getState()) == null || ($this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv7 = absState7.select(OneKeyTripleInstanceState.class)) == null)) {
            AbsState state4 = this_$iv4.getItemStore().getState();
            String name4 = OneKeyTripleInstanceState.class.getName();
            Intrinsics.checkNotNullExpressionValue(name4, "T::class.java.name");
            state4.put(name4, $this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv7);
        }
        AbsItemComponent this_$iv5 = this;
        Store access$getStore5 = this_$iv5.store;
        if (!(access$getStore5 == null || (absState6 = (AbsState) access$getStore5.getState()) == null || ($this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv6 = absState6.select(EnterPathWayState.class)) == null)) {
            AbsState state5 = this_$iv5.getItemStore().getState();
            String name5 = EnterPathWayState.class.getName();
            Intrinsics.checkNotNullExpressionValue(name5, "T::class.java.name");
            state5.put(name5, $this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv6);
        }
        AbsItemComponent this_$iv6 = this;
        Store access$getStore6 = this_$iv6.store;
        if (!(access$getStore6 == null || (absState5 = (AbsState) access$getStore6.getState()) == null || ($this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv5 = absState5.select(IntentToFlowModelState.class)) == null)) {
            AbsState state6 = this_$iv6.getItemStore().getState();
            String name6 = IntentToFlowModelState.class.getName();
            Intrinsics.checkNotNullExpressionValue(name6, "T::class.java.name");
            state6.put(name6, $this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv5);
        }
        AbsItemComponent this_$iv7 = this;
        Store access$getStore7 = this_$iv7.store;
        if (!(access$getStore7 == null || (absState4 = (AbsState) access$getStore7.getState()) == null || ($this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv4 = absState4.select(BottomBarState.class)) == null)) {
            AbsState state7 = this_$iv7.getItemStore().getState();
            String name7 = BottomBarState.class.getName();
            Intrinsics.checkNotNullExpressionValue(name7, "T::class.java.name");
            state7.put(name7, $this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv4);
        }
        AbsItemComponent this_$iv8 = this;
        Store access$getStore8 = this_$iv8.store;
        if (!(access$getStore8 == null || (absState3 = (AbsState) access$getStore8.getState()) == null || ($this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv3 = absState3.select(TalosNativeState.class)) == null)) {
            AbsState state8 = this_$iv8.getItemStore().getState();
            String name8 = TalosNativeState.class.getName();
            Intrinsics.checkNotNullExpressionValue(name8, "T::class.java.name");
            state8.put(name8, $this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv3);
        }
        AbsItemComponent this_$iv9 = this;
        Store access$getStore9 = this_$iv9.store;
        if (!(access$getStore9 == null || (absState2 = (AbsState) access$getStore9.getState()) == null || ($this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv2 = absState2.select(AirPlayStatusState.class)) == null)) {
            AbsState state9 = this_$iv9.getItemStore().getState();
            String name9 = AirPlayStatusState.class.getName();
            Intrinsics.checkNotNullExpressionValue(name9, "T::class.java.name");
            state9.put(name9, $this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv2);
        }
        AbsItemComponent this_$iv10 = this;
        Store access$getStore10 = this_$iv10.store;
        if (access$getStore10 != null && (absState = (AbsState) access$getStore10.getState()) != null && ($this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv = absState.select(GlobalMuteGuideState.class)) != null) {
            AbsState state10 = this_$iv10.getItemStore().getState();
            String name10 = GlobalMuteGuideState.class.getName();
            Intrinsics.checkNotNullExpressionValue(name10, "T::class.java.name");
            state10.put(name10, $this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv);
        }
    }

    public void onCreate() {
        super.onCreate();
        Store $this$select$iv = getStore();
        if ($this$select$iv != null) {
            State state = $this$select$iv.getState();
            Object obj = null;
            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
            if (commonState != null) {
                obj = commonState.select(IntentData.class);
            }
            IntentData intentData = (IntentData) obj;
            if (intentData != null) {
                getItemStore().dispatch(new CoreAction.NewIntent(intentData));
            }
        }
    }

    public void injectService() {
        super.injectService();
        NestedServiceRegisterHelper.INSTANCE.injectService(this, getManager(), getItemManager());
    }

    /* access modifiers changed from: protected */
    public void registerTransmitServices() {
        VideoItemComponentHelper.Impl.INSTANCE.get().transmitVideoItemServices(new VideoFlowBaseComponent$registerTransmitServices$1(this));
        registerServiceInternal(IAutoPlayInterceptorService.class);
        registerServiceInternal(IFlowComponentService.class);
        registerServiceInternal(IVideoSummaryService.class);
        registerServiceInternal(IAssessmentCard2Service.class);
        registerServiceInternal(IPullRefreshService.class);
        registerServiceInternal(ITopExpandableService.class);
        registerServiceInternal(IPaymentFlowPlayerService.class);
        registerServiceInternal(IPlayModeService.class);
        registerServiceInternal(ILiveRealContainerService.class);
        registerServiceInternal(INadCarouselService.class);
        registerServiceInternal(IPanelMoveUpService.class);
        registerServiceInternal(INadCarouselPicService.class);
    }

    /* access modifiers changed from: protected */
    public IActionTransferInterceptor getActionInterceptor() {
        return new TabFlowActionInterceptor();
    }

    /* access modifiers changed from: protected */
    public void onBindData(int position, TabInfoModel model) {
        MutableLiveData<List<TabInfoModel>> tabItems;
        List value;
        Intrinsics.checkNotNullParameter(model, "model");
        State state = getItemStore().getState();
        Object obj = null;
        CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
        FlowTabState flowTabState = (FlowTabState) (commonState != null ? commonState.select(FlowTabState.class) : null);
        if (flowTabState != null) {
            FlowTabState $this$onBindData_u24lambda_u2d3 = flowTabState;
            $this$onBindData_u24lambda_u2d3.setTabInfo(model);
            State state2 = getItemStore().getState();
            CommonState commonState2 = state2 instanceof CommonState ? (CommonState) state2 : null;
            if (commonState2 != null) {
                obj = commonState2.select(TabState.class);
            }
            TabState tabState = (TabState) obj;
            $this$onBindData_u24lambda_u2d3.setTabSize((tabState == null || (tabItems = tabState.getTabItems()) == null || (value = tabItems.getValue()) == null) ? 1 : value.size());
            $this$onBindData_u24lambda_u2d3.getBindData().setValue(model);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachToViewTree() {
        super.onAttachToViewTree();
    }

    /* access modifiers changed from: protected */
    public void onAttachToScreen(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        super.onAttachToScreen(tag);
    }

    /* access modifiers changed from: protected */
    public void onSelected(int position, boolean isUp, String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        super.onSelected(position, isUp, tag);
    }

    /* access modifiers changed from: protected */
    public void onDetachFromScreen(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        super.onDetachFromScreen(tag);
    }

    /* access modifiers changed from: protected */
    public void onDetachFromViewTree() {
        super.onDetachFromViewTree();
    }

    private final int getTabPosition() {
        TabInfoModel tabInfo;
        State state = getItemStore().getState();
        Object obj = null;
        CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
        if (commonState != null) {
            obj = commonState.select(FlowTabState.class);
        }
        FlowTabState flowTabState = (FlowTabState) obj;
        if (flowTabState == null || (tabInfo = flowTabState.getTabInfo()) == null) {
            return -1;
        }
        return tabInfo.getPos();
    }
}
