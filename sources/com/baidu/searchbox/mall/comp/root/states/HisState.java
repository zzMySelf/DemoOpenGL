package com.baidu.searchbox.mall.comp.root.states;

import androidx.lifecycle.Lifecycle;
import com.baidu.searchbox.mall.comp.box.SearchBoxComp;
import com.baidu.searchbox.mall.comp.his.SearchHisComp;
import com.baidu.searchbox.mall.comp.result.MallResultComp;
import com.baidu.searchbox.mall.comp.root.MallRootComp;
import com.baidu.searchbox.mall.comp.sug.SugComp;
import com.baidu.searchbox.mall.utils.CompExtKt;
import com.baidu.searchbox.nacomp.fsm.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0002¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/mall/comp/root/states/HisState;", "Lcom/baidu/searchbox/mall/comp/root/states/HissugSubState;", "()V", "enter", "", "owner", "Lcom/baidu/searchbox/mall/comp/root/states/HissugState;", "exit", "observeQueryChange", "parent", "rootComp", "Lcom/baidu/searchbox/mall/comp/root/MallRootComp;", "updateComponentLifecycle", "lib-search-mall_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HisState.kt */
public final class HisState extends HissugSubState {
    public void enter(HissugState owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        super.enter(owner);
        MallRootComp rootComp = owner.getRootComp();
        owner.getRootComp().getIncognitoSwitchComp$lib_search_mall_release().onAttachStateChange(this);
        observeQueryChange(owner, rootComp);
        updateComponentLifecycle(rootComp);
        rootComp.getBoxComp$lib_search_mall_release().changeToHisSug("his");
    }

    private final void observeQueryChange(HissugState parent, MallRootComp rootComp) {
        rootComp.getBoxComp$lib_search_mall_release().setQueryChangedCallback(new HisState$observeQueryChange$1(this, parent));
    }

    private final void updateComponentLifecycle(MallRootComp rootComp) {
        SearchBoxComp $this$updateComponentLifecycle_u24lambda_u2d0 = rootComp.getBoxComp$lib_search_mall_release();
        CompExtKt.setMaxLifecycle($this$updateComponentLifecycle_u24lambda_u2d0, Lifecycle.State.RESUMED);
        $this$updateComponentLifecycle_u24lambda_u2d0.getView().setVisibility(0);
        MallResultComp $this$updateComponentLifecycle_u24lambda_u2d1 = rootComp.getResultComp$lib_search_mall_release();
        CompExtKt.setMaxLifecycle($this$updateComponentLifecycle_u24lambda_u2d1, Lifecycle.State.CREATED);
        $this$updateComponentLifecycle_u24lambda_u2d1.getView().setVisibility(8);
        SearchHisComp $this$updateComponentLifecycle_u24lambda_u2d2 = rootComp.getHisComp$lib_search_mall_release();
        CompExtKt.setMaxLifecycle($this$updateComponentLifecycle_u24lambda_u2d2, Lifecycle.State.RESUMED);
        $this$updateComponentLifecycle_u24lambda_u2d2.getView().setVisibility(0);
        SugComp $this$updateComponentLifecycle_u24lambda_u2d3 = rootComp.getSugComp$lib_search_mall_release();
        CompExtKt.setMaxLifecycle($this$updateComponentLifecycle_u24lambda_u2d3, Lifecycle.State.CREATED);
        $this$updateComponentLifecycle_u24lambda_u2d3.getView().setVisibility(8);
    }

    public void exit(HissugState owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        super.exit(owner);
        owner.getRootComp().getIncognitoSwitchComp$lib_search_mall_release().onAttachStateChange((State<?>) null);
        owner.getRootComp().getBoxComp$lib_search_mall_release().setQueryChangedCallback((Function1<? super String, Unit>) null);
    }
}
