package com.baidu.searchbox.account.userinfo.activity;

import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/account/userinfo/activity/BannerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemview", "Lcom/facebook/drawee/view/SimpleDraweeView;", "(Lcom/facebook/drawee/view/SimpleDraweeView;)V", "getItemview", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "lib-account_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PortraitSettingActivity.kt */
public final class BannerViewHolder extends RecyclerView.ViewHolder {
    private final SimpleDraweeView itemview;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BannerViewHolder(SimpleDraweeView itemview2) {
        super(itemview2);
        Intrinsics.checkNotNullParameter(itemview2, "itemview");
        this.itemview = itemview2;
    }

    public final SimpleDraweeView getItemview() {
        return this.itemview;
    }
}
