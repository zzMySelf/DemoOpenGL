package com.baidu.searchbox.account.userinfo.activity;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/account/userinfo/activity/PortraitViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemview", "Lcom/baidu/searchbox/account/userinfo/activity/PortraitItemView;", "(Lcom/baidu/searchbox/account/userinfo/activity/PortraitItemView;)V", "getItemview", "()Lcom/baidu/searchbox/account/userinfo/activity/PortraitItemView;", "lib-account_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PortraitSettingActivity.kt */
public final class PortraitViewHolder extends RecyclerView.ViewHolder {
    private final PortraitItemView itemview;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PortraitViewHolder(PortraitItemView itemview2) {
        super(itemview2);
        Intrinsics.checkNotNullParameter(itemview2, "itemview");
        this.itemview = itemview2;
    }

    public final PortraitItemView getItemview() {
        return this.itemview;
    }
}
