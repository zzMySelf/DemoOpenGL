package com.baidu.searchbox.download.center.clearcache.view.funison.download.linear;

import android.view.ViewGroup;
import com.baidu.searchbox.clearcache.business.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClearCacheDownloadLinearViewHolder.kt */
final class ClearCacheDownloadLinearViewHolder$mContainerRootView$2 extends Lambda implements Function0<ViewGroup> {
    final /* synthetic */ ClearCacheDownloadLinearViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ClearCacheDownloadLinearViewHolder$mContainerRootView$2(ClearCacheDownloadLinearViewHolder clearCacheDownloadLinearViewHolder) {
        super(0);
        this.this$0 = clearCacheDownloadLinearViewHolder;
    }

    public final ViewGroup invoke() {
        return (ViewGroup) this.this$0.itemView.findViewById(R.id.clearCacheDownloadLinearItemRootView);
    }
}
