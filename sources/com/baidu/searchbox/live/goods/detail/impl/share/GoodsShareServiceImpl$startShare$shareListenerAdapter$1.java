package com.baidu.searchbox.live.goods.detail.impl.share;

import android.view.View;
import com.baidu.searchbox.boxshare.bean.BoxMenuActionMessage;
import com.baidu.searchbox.boxshare.listener.OnBoxShareListenerAdapter;
import com.baidu.searchbox.live.goods.detail.interfaces.share.GoodsShareService;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1 = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016¨\u0006\u0012"}, d2 = {"com/baidu/searchbox/live/goods/detail/impl/share/GoodsShareServiceImpl$startShare$shareListenerAdapter$1", "Lcom/baidu/searchbox/boxshare/listener/OnBoxShareListenerAdapter;", "onCancel", "", "onClick", "", "child", "Landroid/view/View;", "actionMessage", "Lcom/baidu/searchbox/boxshare/bean/BoxMenuActionMessage;", "onFail", "errCode", "", "errInfo", "", "onSuccess", "data", "Lorg/json/JSONObject;", "lib-goods-detail-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GoodsShareServiceImpl.kt */
public final class GoodsShareServiceImpl$startShare$shareListenerAdapter$1 extends OnBoxShareListenerAdapter {
    final /* synthetic */ GoodsShareService.IOnSocialListener $listener;

    GoodsShareServiceImpl$startShare$shareListenerAdapter$1(GoodsShareService.IOnSocialListener $listener2) {
        this.$listener = $listener2;
    }

    public boolean onClick(View child, BoxMenuActionMessage actionMessage) {
        GoodsShareService.IOnSocialListener iOnSocialListener = this.$listener;
        if (iOnSocialListener != null) {
            iOnSocialListener.onItemClicked(actionMessage != null ? actionMessage.identifier : null);
        }
        return super.onClick(child, actionMessage);
    }

    public void onCancel() {
        GoodsShareService.IOnSocialListener iOnSocialListener = this.$listener;
        if (iOnSocialListener != null) {
            iOnSocialListener.onCancel("");
        }
    }

    public void onFail(int errCode, String errInfo) {
        GoodsShareService.IOnSocialListener iOnSocialListener = this.$listener;
        if (iOnSocialListener != null) {
            iOnSocialListener.onError(errInfo);
        }
    }

    public void onSuccess(JSONObject data) {
        GoodsShareService.IOnSocialListener iOnSocialListener = this.$listener;
        if (iOnSocialListener != null) {
            iOnSocialListener.onComplete(data != null ? data.toString() : null);
        }
    }
}
