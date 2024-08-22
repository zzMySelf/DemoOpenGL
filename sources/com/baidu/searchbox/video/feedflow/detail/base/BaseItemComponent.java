package com.baidu.searchbox.video.feedflow.detail.base;

import android.util.AttributeSet;
import android.view.View;
import com.baidu.searchbox.feed.detail.arch.ComponentArchManager;
import com.baidu.searchbox.feed.detail.arch.ext.AuxiliaryActionKt;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.arch.ext.CoreAction;
import com.baidu.searchbox.feed.detail.arch.ext.NestedViewHolder;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.State;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.component.base.AbsItemComponent;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.detail.core.model.IntentData;
import com.baidu.searchbox.video.feedflow.common.FlowSwitchState;
import com.baidu.searchbox.video.feedflow.common.FlowSwitchStateKt;
import com.baidu.searchbox.video.feedflow.common.IDetailItemCoreEventService;
import com.baidu.searchbox.video.feedflow.common.ItemTriggerSourceState;
import com.baidu.searchbox.video.feedflow.common.serviceimpl.NestedServiceRegisterHelper;
import com.baidu.searchbox.video.feedflow.config.GcpConfig;
import com.baidu.searchbox.video.feedflow.detail.DetailItemDetachFromScreen;
import com.baidu.searchbox.video.feedflow.detail.DetailItemSelected;
import com.baidu.searchbox.video.feedflow.detail.air.AirPlayStatusState;
import com.baidu.searchbox.video.feedflow.detail.onekeytriple.OneKeyTripleInstanceState;
import com.baidu.searchbox.video.feedflow.detail.search.FlowDetailToSugState;
import com.baidu.searchbox.video.feedflow.flow.bottom.BottomBarState;
import com.baidu.searchbox.video.feedflow.flow.enterpathway.EnterPathWayState;
import com.baidu.searchbox.video.feedflow.flow.flowstyle.FlowDataSwitchState;
import com.baidu.searchbox.video.feedflow.flow.globalmuteguide.GlobalMuteGuideState;
import com.baidu.searchbox.video.feedflow.flow.launchpanel.ColdLaunchEnterVideoTabState;
import com.baidu.searchbox.video.feedflow.flow.list.FlowState;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import com.baidu.searchbox.video.feedflow.flow.list.RunTimeStatus;
import com.baidu.searchbox.video.feedflow.flow.screenorientation.PlayerOrientationState;
import com.baidu.searchbox.video.feedflow.tab.FlowTabState;
import com.baidu.searchbox.video.feedflow.tab.TabInfoModel;
import com.baidu.searchbox.video.feedflow.tab.TabState;
import com.baidu.searchbox.video.feedflow.view.FlowItemView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0004J\u0012\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\tH\u0014J\f\u0010\n\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\u000eH\u0004J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0016J \u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\fH\u0014J\b\u0010\u0016\u001a\u00020\u0007H\u0016J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\fH\u0014J\b\u0010\u0018\u001a\u00020\u0007H\u0014J\u001c\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u000e2\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0014J\b\u0010\u001b\u001a\u00020\u0007H\u0016J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\fH\u0014J\b\u0010\u001d\u001a\u00020\u0007H\u0014J*\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000e2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010\u0012\u001a\u00020\u000eH\u0014J \u0010#\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\fH\u0014J&\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020&2\u0014\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u0007\u0018\u00010(H\u0016J\b\u0010)\u001a\u00020\u0007H\u0014¨\u0006*"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/base/BaseItemComponent;", "STATE", "Lcom/baidu/searchbox/feed/detail/frame/AbsState;", "Lcom/baidu/searchbox/video/component/base/AbsItemComponent;", "Lcom/baidu/searchbox/video/feedflow/flow/list/ItemModel;", "()V", "beforeRegisterTransmitServices", "", "createViewInternal", "Lcom/baidu/searchbox/feed/detail/arch/ext/NestedViewHolder;", "getBindModel", "getItemNid", "", "getItemPosition", "", "getTabPosition", "injectService", "notifyCurLevelItemSelected", "position", "isUp", "", "tag", "onAttachToManager", "onAttachToScreen", "onAttachToViewTree", "onBindData", "model", "onCreate", "onDetachFromScreen", "onDetachFromViewTree", "onItemStartFling", "velocityX", "velocityY", "view", "Landroid/view/View;", "onSelected", "switchComponentManager", "archManager", "Lcom/baidu/searchbox/feed/detail/arch/ComponentArchManager;", "performSwitchParent", "Lkotlin/Function1;", "transmitStateToChildStore", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaseItemComponent.kt */
public abstract class BaseItemComponent<STATE extends AbsState> extends AbsItemComponent<ItemModel<?>, STATE> {
    public void onAttachToManager() {
        Store $this$select$iv = getStore();
        if ($this$select$iv != null) {
            State state = $this$select$iv.getState();
            Object obj = null;
            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
            if (commonState != null) {
                obj = commonState.select(GcpConfig.class);
            }
            GcpConfig state2 = (GcpConfig) obj;
            if (state2 != null) {
                AbsState state3 = getItemStore().getState();
                String name = GcpConfig.class.getName();
                Intrinsics.checkNotNullExpressionValue(name, "GcpConfig::class.java.name");
                state3.put(name, state2);
            }
        }
        super.onAttachToManager();
        getItemStore().subscribe(ItemTriggerSourceState.class);
    }

    public void onCreate() {
        AbsState absState;
        IntentData intentData;
        super.onCreate();
        Store store = getStore();
        if (store != null && (absState = (AbsState) store.getState()) != null && (intentData = (IntentData) absState.select(IntentData.class)) != null) {
            getItemStore().dispatch(new CoreAction.NewIntent(intentData));
        }
    }

    public void injectService() {
        super.injectService();
        getItemManager().registerServices(IBaseItemComponentService.class, new BaseItemComponentServiceImpl(this));
        NestedServiceRegisterHelper.INSTANCE.injectService(this, getManager(), getItemManager());
    }

    /* access modifiers changed from: protected */
    public NestedViewHolder<ItemModel<?>> createViewInternal() {
        FlowItemView $this$createViewInternal_u24lambda_u2d2 = new FlowItemView(getContext(), (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        $this$createViewInternal_u24lambda_u2d2.addView(getItemManager().createView());
        $this$createViewInternal_u24lambda_u2d2.setStateListener(getItemViewStateListener());
        return $this$createViewInternal_u24lambda_u2d2;
    }

    /* access modifiers changed from: protected */
    public void onBindData(int position, ItemModel<?> model) {
        Intrinsics.checkNotNullParameter(model, "model");
    }

    /* access modifiers changed from: protected */
    public void onAttachToViewTree() {
        super.onAttachToViewTree();
    }

    /* access modifiers changed from: protected */
    public void onAttachToScreen(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        State state = getItemStore().getState();
        Object obj = null;
        CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
        if (commonState != null) {
            obj = commonState.select(ItemTriggerSourceState.class);
        }
        ItemTriggerSourceState itemTriggerSourceState = (ItemTriggerSourceState) obj;
        if (itemTriggerSourceState != null) {
            itemTriggerSourceState.setTriggerMode(tag);
        }
        super.onAttachToScreen(tag);
    }

    /* access modifiers changed from: protected */
    public void onSelected(int position, boolean isUp, String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        State state = getItemStore().getState();
        Object obj = null;
        CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
        if (commonState != null) {
            obj = commonState.select(ItemTriggerSourceState.class);
        }
        ItemTriggerSourceState itemTriggerSourceState = (ItemTriggerSourceState) obj;
        if (itemTriggerSourceState != null) {
            itemTriggerSourceState.setTriggerMode(tag);
        }
        super.onSelected(position, isUp, tag);
        notifyCurLevelItemSelected(position, isUp, tag);
    }

    /* access modifiers changed from: protected */
    public void notifyCurLevelItemSelected(int position, boolean isUp, String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Store store = getStore();
        Object obj = null;
        if (store != null) {
            State state = getItemStore().getState();
            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
            StoreExtKt.post(store, new DetailItemSelected(position, isUp, tag, (ItemModel) (commonState != null ? commonState.select(ItemModel.class) : null)));
        }
        IDetailItemCoreEventService iDetailItemCoreEventService = (IDetailItemCoreEventService) getManager().getService(IDetailItemCoreEventService.class);
        if (iDetailItemCoreEventService != null) {
            State state2 = getItemStore().getState();
            CommonState commonState2 = state2 instanceof CommonState ? (CommonState) state2 : null;
            if (commonState2 != null) {
                obj = commonState2.select(ItemModel.class);
            }
            iDetailItemCoreEventService.dispatchItemSelected(isUp, tag, (ItemModel) obj);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachFromScreen(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        State state = getItemStore().getState();
        Object obj = null;
        CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
        ItemTriggerSourceState itemTriggerSourceState = (ItemTriggerSourceState) (commonState != null ? commonState.select(ItemTriggerSourceState.class) : null);
        if (itemTriggerSourceState != null) {
            itemTriggerSourceState.setTriggerMode(tag);
        }
        State state2 = getItemStore().getState();
        CommonState commonState2 = state2 instanceof CommonState ? (CommonState) state2 : null;
        ItemModel itemModel = (ItemModel) (commonState2 != null ? commonState2.select(ItemModel.class) : null);
        RunTimeStatus runTimeStatus = itemModel != null ? itemModel.getRunTimeStatus() : null;
        if (runTimeStatus != null) {
            runTimeStatus.setDetachedOnce(true);
        }
        super.onDetachFromScreen(tag);
        Store store = getStore();
        if (store != null) {
            State state3 = getItemStore().getState();
            CommonState commonState3 = state3 instanceof CommonState ? (CommonState) state3 : null;
            StoreExtKt.post(store, new DetailItemDetachFromScreen(tag, (ItemModel) (commonState3 != null ? commonState3.select(ItemModel.class) : null)));
        }
        IDetailItemCoreEventService iDetailItemCoreEventService = (IDetailItemCoreEventService) getManager().getService(IDetailItemCoreEventService.class);
        if (iDetailItemCoreEventService != null) {
            State state4 = getItemStore().getState();
            CommonState commonState4 = state4 instanceof CommonState ? (CommonState) state4 : null;
            if (commonState4 != null) {
                obj = commonState4.select(ItemModel.class);
            }
            iDetailItemCoreEventService.dispatchItemDetachFromScreenListener(tag, (ItemModel) obj);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachFromViewTree() {
        super.onDetachFromViewTree();
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
        AbsState absState11;
        Object $this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv11;
        AbsState absState12;
        Object $this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv12;
        AbsState absState13;
        Object $this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv13;
        AbsItemComponent this_$iv = this;
        Store access$getStore = this_$iv.store;
        if (!(access$getStore == null || (absState13 = (AbsState) access$getStore.getState()) == null || ($this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv13 = absState13.select(PlayerOrientationState.class)) == null)) {
            AbsState state = this_$iv.getItemStore().getState();
            String name = PlayerOrientationState.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, "T::class.java.name");
            state.put(name, $this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv13);
        }
        AbsItemComponent this_$iv2 = this;
        Store access$getStore2 = this_$iv2.store;
        if (!(access$getStore2 == null || (absState12 = (AbsState) access$getStore2.getState()) == null || ($this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv12 = absState12.select(AirPlayStatusState.class)) == null)) {
            AbsState state2 = this_$iv2.getItemStore().getState();
            String name2 = AirPlayStatusState.class.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "T::class.java.name");
            state2.put(name2, $this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv12);
        }
        AbsItemComponent this_$iv3 = this;
        Store access$getStore3 = this_$iv3.store;
        if (!(access$getStore3 == null || (absState11 = (AbsState) access$getStore3.getState()) == null || ($this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv11 = absState11.select(FlowTabState.class)) == null)) {
            AbsState state3 = this_$iv3.getItemStore().getState();
            String name3 = FlowTabState.class.getName();
            Intrinsics.checkNotNullExpressionValue(name3, "T::class.java.name");
            state3.put(name3, $this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv11);
        }
        AbsItemComponent this_$iv4 = this;
        Store access$getStore4 = this_$iv4.store;
        if (!(access$getStore4 == null || (absState10 = (AbsState) access$getStore4.getState()) == null || ($this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv10 = absState10.select(TabState.class)) == null)) {
            AbsState state4 = this_$iv4.getItemStore().getState();
            String name4 = TabState.class.getName();
            Intrinsics.checkNotNullExpressionValue(name4, "T::class.java.name");
            state4.put(name4, $this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv10);
        }
        AbsItemComponent this_$iv5 = this;
        Store access$getStore5 = this_$iv5.store;
        if (!(access$getStore5 == null || (absState9 = (AbsState) access$getStore5.getState()) == null || ($this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv9 = absState9.select(FlowState.class)) == null)) {
            AbsState state5 = this_$iv5.getItemStore().getState();
            String name5 = FlowState.class.getName();
            Intrinsics.checkNotNullExpressionValue(name5, "T::class.java.name");
            state5.put(name5, $this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv9);
        }
        AbsItemComponent this_$iv6 = this;
        Store access$getStore6 = this_$iv6.store;
        if (!(access$getStore6 == null || (absState8 = (AbsState) access$getStore6.getState()) == null || ($this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv8 = absState8.select(FlowSwitchState.class)) == null)) {
            AbsState state6 = this_$iv6.getItemStore().getState();
            String name6 = FlowSwitchState.class.getName();
            Intrinsics.checkNotNullExpressionValue(name6, "T::class.java.name");
            state6.put(name6, $this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv8);
        }
        AbsItemComponent this_$iv7 = this;
        Store access$getStore7 = this_$iv7.store;
        if (!(access$getStore7 == null || (absState7 = (AbsState) access$getStore7.getState()) == null || ($this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv7 = absState7.select(OneKeyTripleInstanceState.class)) == null)) {
            AbsState state7 = this_$iv7.getItemStore().getState();
            String name7 = OneKeyTripleInstanceState.class.getName();
            Intrinsics.checkNotNullExpressionValue(name7, "T::class.java.name");
            state7.put(name7, $this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv7);
        }
        AbsItemComponent this_$iv8 = this;
        Store access$getStore8 = this_$iv8.store;
        if (!(access$getStore8 == null || (absState6 = (AbsState) access$getStore8.getState()) == null || ($this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv6 = absState6.select(EnterPathWayState.class)) == null)) {
            AbsState state8 = this_$iv8.getItemStore().getState();
            String name8 = EnterPathWayState.class.getName();
            Intrinsics.checkNotNullExpressionValue(name8, "T::class.java.name");
            state8.put(name8, $this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv6);
        }
        AbsItemComponent this_$iv9 = this;
        Store access$getStore9 = this_$iv9.store;
        if (!(access$getStore9 == null || (absState5 = (AbsState) access$getStore9.getState()) == null || ($this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv5 = absState5.select(FlowDetailToSugState.class)) == null)) {
            AbsState state9 = this_$iv9.getItemStore().getState();
            String name9 = FlowDetailToSugState.class.getName();
            Intrinsics.checkNotNullExpressionValue(name9, "T::class.java.name");
            state9.put(name9, $this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv5);
        }
        AbsItemComponent this_$iv10 = this;
        Store access$getStore10 = this_$iv10.store;
        if (!(access$getStore10 == null || (absState4 = (AbsState) access$getStore10.getState()) == null || ($this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv4 = absState4.select(ColdLaunchEnterVideoTabState.class)) == null)) {
            AbsState state10 = this_$iv10.getItemStore().getState();
            String name10 = ColdLaunchEnterVideoTabState.class.getName();
            Intrinsics.checkNotNullExpressionValue(name10, "T::class.java.name");
            state10.put(name10, $this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv4);
        }
        AbsItemComponent this_$iv11 = this;
        Store access$getStore11 = this_$iv11.store;
        if (!(access$getStore11 == null || (absState3 = (AbsState) access$getStore11.getState()) == null || ($this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv3 = absState3.select(FlowDataSwitchState.class)) == null)) {
            AbsState state11 = this_$iv11.getItemStore().getState();
            String name11 = FlowDataSwitchState.class.getName();
            Intrinsics.checkNotNullExpressionValue(name11, "T::class.java.name");
            state11.put(name11, $this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv3);
        }
        AbsItemComponent this_$iv12 = this;
        Store access$getStore12 = this_$iv12.store;
        if (!(access$getStore12 == null || (absState2 = (AbsState) access$getStore12.getState()) == null || ($this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv2 = absState2.select(GlobalMuteGuideState.class)) == null)) {
            AbsState state12 = this_$iv12.getItemStore().getState();
            String name12 = GlobalMuteGuideState.class.getName();
            Intrinsics.checkNotNullExpressionValue(name12, "T::class.java.name");
            state12.put(name12, $this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv2);
        }
        AbsItemComponent this_$iv13 = this;
        Store access$getStore13 = this_$iv13.store;
        if (access$getStore13 != null && (absState = (AbsState) access$getStore13.getState()) != null && ($this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv = absState.select(BottomBarState.class)) != null) {
            AbsState state13 = this_$iv13.getItemStore().getState();
            String name13 = BottomBarState.class.getName();
            Intrinsics.checkNotNullExpressionValue(name13, "T::class.java.name");
            state13.put(name13, $this$transmitStateToChildStoreInternal_u24lambda_u2d8$iv);
        }
    }

    /* access modifiers changed from: protected */
    public final void beforeRegisterTransmitServices() {
        registerServiceInternal(IBaseItemComponentService.class);
    }

    /* access modifiers changed from: protected */
    public final int getItemPosition() {
        RunTimeStatus runTimeStatus;
        State state = getItemStore().getState();
        Object obj = null;
        CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
        if (commonState != null) {
            obj = commonState.select(ItemModel.class);
        }
        ItemModel itemModel = (ItemModel) obj;
        if (itemModel == null || (runTimeStatus = itemModel.getRunTimeStatus()) == null) {
            return -1;
        }
        return runTimeStatus.getPosition();
    }

    private final String getItemNid() {
        String nid;
        State state = getItemStore().getState();
        Object obj = null;
        CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
        if (commonState != null) {
            obj = commonState.select(ItemModel.class);
        }
        ItemModel itemModel = (ItemModel) obj;
        return (itemModel == null || (nid = itemModel.getNid()) == null) ? "" : nid;
    }

    private final int getTabPosition() {
        TabInfoModel tabInfo;
        Store $this$select$iv = getStore();
        if ($this$select$iv != null) {
            State state = $this$select$iv.getState();
            Object obj = null;
            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
            if (commonState != null) {
                obj = commonState.select(FlowTabState.class);
            }
            FlowTabState flowTabState = (FlowTabState) obj;
            if (!(flowTabState == null || (tabInfo = flowTabState.getTabInfo()) == null)) {
                return tabInfo.getPos();
            }
        }
        return -1;
    }

    public final ItemModel<?> getBindModel() {
        State state = getItemStore().getState();
        Object obj = null;
        CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
        if (commonState != null) {
            obj = commonState.select(ItemModel.class);
        }
        return (ItemModel) obj;
    }

    public void switchComponentManager(ComponentArchManager archManager, Function1<? super View, Unit> performSwitchParent) {
        Intrinsics.checkNotNullParameter(archManager, "archManager");
        super.switchComponentManager(archManager, performSwitchParent);
    }

    /* access modifiers changed from: protected */
    public void onItemStartFling(int velocityX, int velocityY, View view2, int position) {
        super.onItemStartFling(velocityX, velocityY, view2, position);
        if (FlowSwitchStateKt.isPlayOnFlingEnable(getStore())) {
            AuxiliaryActionKt.dispatchOnItemStartFling(getItemStore(), velocityX, velocityY, position);
        }
    }
}
