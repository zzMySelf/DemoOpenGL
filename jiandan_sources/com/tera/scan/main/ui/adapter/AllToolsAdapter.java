package com.tera.scan.main.ui.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.aiscan.R;
import com.tera.scan.main.view.GridSpacingItemDecoration;
import fe.mmm.qw.xxx.p032if.fe.qw;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0019\u001aB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\f\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nH\u0016J\u0016\u0010\u0016\u001a\u00020\u00102\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0018H\u0007R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/tera/scan/main/ui/adapter/AllToolsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "recyclerViewProvider", "Lcom/tera/scan/main/ui/adapter/RecyclerViewProvider;", "(Lcom/tera/scan/main/ui/adapter/RecyclerViewProvider;)V", "allToolsList", "", "Lcom/tera/scan/main/ui/model/AllScanToolRes;", "itemTitleHeight", "", "lastItemHeight", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "data", "", "ItemViewFooterHolder", "ItemViewHolder", "app-main_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AllToolsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: ad  reason: collision with root package name */
    public int f6990ad;
    @Nullable

    /* renamed from: de  reason: collision with root package name */
    public RecyclerViewProvider f6991de;
    @NotNull

    /* renamed from: fe  reason: collision with root package name */
    public List<qw> f6992fe = new ArrayList();
    public int qw;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/tera/scan/main/ui/adapter/AllToolsAdapter$ItemViewFooterHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tera/scan/main/ui/adapter/AllToolsAdapter;Landroid/view/View;)V", "app-main_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class ItemViewFooterHolder extends RecyclerView.ViewHolder {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ItemViewFooterHolder(@NotNull AllToolsAdapter allToolsAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/tera/scan/main/ui/adapter/AllToolsAdapter$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tera/scan/main/ui/adapter/AllToolsAdapter;Landroid/view/View;)V", "rlToolGrid", "Landroidx/recyclerview/widget/RecyclerView;", "tvToolGroupName", "Landroid/widget/TextView;", "bind", "", "data", "Lcom/tera/scan/main/ui/model/AllScanToolRes;", "app-main_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class ItemViewHolder extends RecyclerView.ViewHolder {
        @NotNull

        /* renamed from: ad  reason: collision with root package name */
        public RecyclerView f6993ad;
        @NotNull
        public TextView qw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ItemViewHolder(@NotNull AllToolsAdapter allToolsAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            View findViewById = view.findViewById(R.id.tv_tool_group_name);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.tv_tool_group_name)");
            this.qw = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.rl_tool_grid);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.rl_tool_grid)");
            this.f6993ad = (RecyclerView) findViewById2;
        }

        public final void bind(@NotNull qw qwVar) {
            Intrinsics.checkNotNullParameter(qwVar, "data");
            this.qw.setText(qwVar.ad());
            this.f6993ad.setHasFixedSize(true);
            this.f6993ad.setLayoutManager(new GridLayoutManager(this.itemView.getContext(), 4));
            if (this.f6993ad.getItemDecorationCount() == 0) {
                this.f6993ad.addItemDecoration(new GridSpacingItemDecoration(4, fe.mmm.qw.p030switch.th.de.ad.qw.qw(this.itemView.getContext(), 18.0f)));
            }
            ToolAdapter toolAdapter = new ToolAdapter();
            List<fe.ggg.qw.qw.qw> qw2 = qwVar.qw();
            if (qw2 != null) {
                toolAdapter.setData(qw2);
            }
            this.f6993ad.setAdapter(toolAdapter);
        }
    }

    public AllToolsAdapter(@NotNull RecyclerViewProvider recyclerViewProvider) {
        Intrinsics.checkNotNullParameter(recyclerViewProvider, "recyclerViewProvider");
        this.f6991de = recyclerViewProvider;
    }

    public static final void ad(AllToolsAdapter allToolsAdapter, View view) {
        Intrinsics.checkNotNullParameter(allToolsAdapter, "this$0");
        if (allToolsAdapter.f6990ad != 0) {
            return;
        }
        if (view != null) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() > 0) {
                allToolsAdapter.f6990ad = viewGroup.getChildAt(0).getHeight();
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public static final void qw(AllToolsAdapter allToolsAdapter, RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(allToolsAdapter, "this$0");
        Intrinsics.checkNotNullParameter(viewHolder, "$holder");
        allToolsAdapter.qw = viewHolder.itemView.getMeasuredHeight();
        allToolsAdapter.notifyItemChanged(allToolsAdapter.getItemCount() - 1);
    }

    public int getItemCount() {
        return this.f6992fe.size() + 1;
    }

    public int getItemViewType(int i2) {
        return i2 == this.f6992fe.size() ? 2 : 1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004b, code lost:
        r5 = r5.getRecyclerView();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull androidx.recyclerview.widget.RecyclerView.ViewHolder r4, int r5) {
        /*
            r3 = this;
            java.lang.String r0 = "holder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            boolean r0 = r4 instanceof com.tera.scan.main.ui.adapter.AllToolsAdapter.ItemViewHolder
            if (r0 == 0) goto L_0x003e
            r0 = r4
            com.tera.scan.main.ui.adapter.AllToolsAdapter$ItemViewHolder r0 = (com.tera.scan.main.ui.adapter.AllToolsAdapter.ItemViewHolder) r0
            int r1 = r0.getItemViewType()
            r2 = 1
            if (r1 != r2) goto L_0x003e
            java.util.List<fe.mmm.qw.xxx.if.fe.qw> r1 = r3.f6992fe
            java.lang.Object r1 = r1.get(r5)
            fe.mmm.qw.xxx.if.fe.qw r1 = (fe.mmm.qw.xxx.p032if.fe.qw) r1
            r0.bind(r1)
            int r0 = r3.qw
            if (r0 != 0) goto L_0x0070
            java.util.List<fe.mmm.qw.xxx.if.fe.qw> r0 = r3.f6992fe
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0070
            java.util.List<fe.mmm.qw.xxx.if.fe.qw> r0 = r3.f6992fe
            int r0 = r0.size()
            int r0 = r0 - r2
            if (r5 != r0) goto L_0x0070
            android.view.View r5 = r4.itemView
            fe.mmm.qw.xxx.if.ad.de r0 = new fe.mmm.qw.xxx.if.ad.de
            r0.<init>(r3, r4)
            r5.post(r0)
            goto L_0x0070
        L_0x003e:
            int r5 = r4.getItemViewType()
            r0 = 2
            if (r5 != r0) goto L_0x0070
            android.view.View r4 = r4.itemView
            com.tera.scan.main.ui.adapter.RecyclerViewProvider r5 = r3.f6991de
            if (r5 == 0) goto L_0x0056
            androidx.recyclerview.widget.RecyclerView r5 = r5.getRecyclerView()
            if (r5 == 0) goto L_0x0056
            int r5 = r5.getHeight()
            goto L_0x0057
        L_0x0056:
            r5 = 0
        L_0x0057:
            int r0 = r3.qw
            int r5 = r5 - r0
            r0 = 1110441984(0x42300000, float:44.0)
            int r0 = com.tera.scan.utils.SizeUtils.qw(r0)
            int r5 = r5 - r0
            int r0 = r4.getHeight()
            if (r5 == r0) goto L_0x0070
            android.view.ViewGroup$LayoutParams r0 = new android.view.ViewGroup$LayoutParams
            r1 = -1
            r0.<init>(r1, r5)
            r4.setLayoutParams(r0)
        L_0x0070:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.main.ui.adapter.AllToolsAdapter.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i2) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (i2 != 1) {
            return new ItemViewFooterHolder(this, new View(viewGroup.getContext()));
        }
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.alltool_item, viewGroup, false);
        inflate.post(new fe.mmm.qw.xxx.p032if.ad.qw(this, inflate));
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        return new ItemViewHolder(this, inflate);
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void setData(@NotNull List<qw> list) {
        Intrinsics.checkNotNullParameter(list, "data");
        this.f6992fe.clear();
        this.f6992fe.addAll(list);
        notifyDataSetChanged();
    }
}
