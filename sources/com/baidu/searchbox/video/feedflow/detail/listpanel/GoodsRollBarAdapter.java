package com.baidu.searchbox.video.feedflow.detail.listpanel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.baidu.searchbox.favor.data.FavorModel;
import com.baidu.searchbox.video.feedflow.view.VideoFlowMarqueeView;
import com.baidu.searchbox.video.inf.GoodsRollBarModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u0007H\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/listpanel/GoodsRollBarAdapter;", "Lcom/baidu/searchbox/video/feedflow/view/VideoFlowMarqueeView$Adapter;", "Lcom/baidu/searchbox/video/feedflow/detail/listpanel/GoodsRollBarHolder;", "list", "", "Lcom/baidu/searchbox/video/inf/GoodsRollBarModel;", "style", "", "(Ljava/util/List;I)V", "getList", "()Ljava/util/List;", "getStyle", "()I", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GoodsRollBarAdapter.kt */
public final class GoodsRollBarAdapter extends VideoFlowMarqueeView.Adapter<GoodsRollBarHolder> {
    private final List<GoodsRollBarModel> list;
    private final int style;

    public GoodsRollBarAdapter(List<GoodsRollBarModel> list2, int style2) {
        Intrinsics.checkNotNullParameter(list2, "list");
        this.list = list2;
        this.style = style2;
    }

    public final List<GoodsRollBarModel> getList() {
        return this.list;
    }

    public final int getStyle() {
        return this.style;
    }

    public GoodsRollBarHolder onCreateViewHolder(ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, FavorModel.KEY_PARENT);
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        return new GoodsRollBarHolder(new GoodsItemPurchaseInfoView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null));
    }

    public void onBindViewHolder(GoodsRollBarHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bindData((GoodsRollBarModel) CollectionsKt.getOrNull(this.list, position), this.style);
    }

    public int getItemCount() {
        return this.list.size();
    }
}
