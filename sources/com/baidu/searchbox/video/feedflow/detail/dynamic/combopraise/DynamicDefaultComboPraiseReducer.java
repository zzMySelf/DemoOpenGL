package com.baidu.searchbox.video.feedflow.detail.dynamic.combopraise;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.arch.ext.NetAction;
import com.baidu.searchbox.flowvideo.detail.repos.FlowDetailPraiseModel;
import com.baidu.searchbox.flowvideo.detail.repos.FlowDetailPraiseStyleModel;
import com.baidu.searchbox.flowvideo.dynamic.repos.DynamicDetailModel;
import com.baidu.searchbox.video.feedflow.detail.defaultcombopraise.DefaultComboPraiseReducer;
import com.baidu.searchbox.video.feedflow.detail.defaultcombopraise.DefaultComboPraiseState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0014J\u001c\u0010\t\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\u0007\u001a\u00020\bH\u0014¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/dynamic/combopraise/DynamicDefaultComboPraiseReducer;", "Lcom/baidu/searchbox/video/feedflow/detail/defaultcombopraise/DefaultComboPraiseReducer;", "()V", "onFail", "", "action", "Lcom/baidu/searchbox/feed/detail/arch/ext/NetAction$Failure;", "state", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "onSuccess", "Lcom/baidu/searchbox/feed/detail/arch/ext/NetAction$Success;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DynamicDefaultComboPraiseReducer.kt */
public final class DynamicDefaultComboPraiseReducer extends DefaultComboPraiseReducer {
    /* access modifiers changed from: protected */
    public void onSuccess(NetAction.Success<?> action, CommonState state) {
        DefaultComboPraiseState $this$onSuccess_u24lambda_u2d1_u24lambda_u2d0;
        FlowDetailPraiseStyleModel praiseStyle;
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(state, "state");
        Object data = action.getData();
        Boolean bool = null;
        DynamicDetailModel bean = data instanceof DynamicDetailModel ? (DynamicDetailModel) data : null;
        if (bean != null && ($this$onSuccess_u24lambda_u2d1_u24lambda_u2d0 = (DefaultComboPraiseState) state.select(DefaultComboPraiseState.class)) != null) {
            $this$onSuccess_u24lambda_u2d1_u24lambda_u2d0.isEnable().setValue(Boolean.valueOf(bean.isPraiseEnable()));
            FlowDetailPraiseModel praise = bean.getPraise();
            if (!(praise == null || (praiseStyle = praise.getPraiseStyle()) == null)) {
                bool = Boolean.valueOf(praiseStyle.isDisableAnimation());
            }
            $this$onSuccess_u24lambda_u2d1_u24lambda_u2d0.setDisableAnimation(bool);
        }
    }

    /* access modifiers changed from: protected */
    public void onFail(NetAction.Failure<?> action, CommonState state) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(state, "state");
        if (Intrinsics.areEqual((Object) action.getClazz(), (Object) DynamicDetailModel.class)) {
            DefaultComboPraiseState defaultComboPraiseState = (DefaultComboPraiseState) state.select(DefaultComboPraiseState.class);
            MutableLiveData<Boolean> isEnable = defaultComboPraiseState != null ? defaultComboPraiseState.isEnable() : null;
            if (isEnable != null) {
                isEnable.setValue(false);
            }
        }
    }
}
