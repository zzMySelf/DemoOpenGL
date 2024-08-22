package com.baidu.searchbox.video.feedflow.detail.dynamic.banner;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.arch.ext.NetAction;
import com.baidu.searchbox.flowvideo.dynamic.repos.DynamicDetailModel;
import com.baidu.searchbox.video.feedflow.detail.banner.BannerReducer;
import com.baidu.searchbox.video.feedflow.detail.banner.BannerState;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0014J\u001e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000bH\u0014¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/dynamic/banner/DynamicBannerReducer;", "Lcom/baidu/searchbox/video/feedflow/detail/banner/BannerReducer;", "()V", "onSuccess", "", "action", "Lcom/baidu/searchbox/feed/detail/arch/ext/NetAction$Success;", "state", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "reset", "itemModel", "Lcom/baidu/searchbox/video/feedflow/flow/list/ItemModel;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DynamicBannerReducer.kt */
public final class DynamicBannerReducer extends BannerReducer {
    /* access modifiers changed from: protected */
    public void onSuccess(NetAction.Success<?> action, CommonState state) {
        BannerState $this$onSuccess_u24lambda_u2d1_u24lambda_u2d0;
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(state, "state");
        Object data = action.getData();
        JSONObject jSONObject = null;
        DynamicDetailModel bean = data instanceof DynamicDetailModel ? (DynamicDetailModel) data : null;
        if (bean != null && ($this$onSuccess_u24lambda_u2d1_u24lambda_u2d0 = (BannerState) state.select(BannerState.class)) != null) {
            MutableLiveData<JSONObject> data2 = $this$onSuccess_u24lambda_u2d1_u24lambda_u2d0.getData();
            if (!bean.isOffLine()) {
                try {
                    jSONObject = new JSONObject(bean.getBanner());
                } catch (Exception e2) {
                    JSONObject jSONObject2 = null;
                }
            } else {
                JSONObject jSONObject3 = null;
            }
            data2.setValue(jSONObject);
        }
    }

    /* access modifiers changed from: protected */
    public void reset(CommonState state, ItemModel<?> itemModel) {
        Intrinsics.checkNotNullParameter(state, "state");
        BannerState bannerState = (BannerState) state.select(BannerState.class);
        if (bannerState != null) {
            bannerState.resetData();
        }
    }
}
