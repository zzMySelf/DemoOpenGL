package com.baidu.searchbox.download.center.ui.fusion.adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.download.model.CategoryInfoData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/download/center/ui/fusion/adapter/RecentDownloadEmptyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "updateUI", "", "itemData", "Lcom/baidu/searchbox/download/model/CategoryInfoData;", "lib-download-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RecentDownloadEmptyViewHolder.kt */
public final class RecentDownloadEmptyViewHolder extends RecyclerView.ViewHolder {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecentDownloadEmptyViewHolder(View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
    }

    public final void updateUI(CategoryInfoData itemData) {
        Intrinsics.checkNotNullParameter(itemData, "itemData");
    }
}
