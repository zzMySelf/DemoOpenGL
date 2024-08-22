package com.tera.scan.main.ui.adapter;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.aiscan.R;
import fe.ggg.qw.qw.qw;
import fe.mmm.qw.th.qw.fe.ad;
import fe.rg.qw.rg;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\bH\u0016J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0016\u0010\u0011\u001a\u00020\n2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0013H\u0007R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/tera/scan/main/ui/adapter/ToolAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "()V", "toolList", "", "Lcom/mars/amis/entity/ScanServiceToolSubItem;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "data", "", "ToolHolder", "app-main_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ToolAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    @NotNull
    public List<qw> qw = new ArrayList();

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/tera/scan/main/ui/adapter/ToolAdapter$ToolHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tera/scan/main/ui/adapter/ToolAdapter;Landroid/view/View;)V", "ivToolIc", "Landroid/widget/ImageView;", "tvToolName", "Landroid/widget/TextView;", "bind", "", "data", "Lcom/mars/amis/entity/ScanServiceToolSubItem;", "app-main_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class ToolHolder extends RecyclerView.ViewHolder {
        @NotNull

        /* renamed from: ad  reason: collision with root package name */
        public final TextView f6994ad;
        @NotNull
        public final ImageView qw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ToolHolder(@NotNull ToolAdapter toolAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            View findViewById = view.findViewById(R.id.iv_tool_ic);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.iv_tool_ic)");
            this.qw = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.tv_tool_name);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.tv_tool_name)");
            this.f6994ad = (TextView) findViewById2;
        }

        public static final void qw(qw qwVar, View view) {
            Intrinsics.checkNotNullParameter(qwVar, "$data");
            String de2 = qwVar.de();
            if (de2 != null) {
                ad.qw.ad(de2);
            }
            String qw2 = qwVar.qw();
            if (qw2 != null) {
                fe.mmm.qw.xxx.pf.ad.ad(qw2, "AllTools", (String) null, (Map) null, 12, (Object) null);
            }
        }

        @SuppressLint({"RestrictedApi"})
        public final void bind(@NotNull qw qwVar) {
            Intrinsics.checkNotNullParameter(qwVar, "data");
            this.f6994ad.setText(qwVar.fe());
            this.itemView.setOnClickListener(new fe.mmm.qw.xxx.p032if.ad.ad(qwVar));
            rg<Bitmap> i2 = fe.rg.qw.ad.aaa(this.qw).i();
            i2.nn(qwVar.ad());
            i2.m317switch(this.qw);
        }
    }

    public int getItemCount() {
        return this.qw.size();
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i2) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (viewHolder instanceof ToolHolder) {
            ((ToolHolder) viewHolder).bind(this.qw.get(i2));
        }
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i2) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.alltool_item_inner_content, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf…r_content, parent, false)");
        return new ToolHolder(this, inflate);
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void setData(@NotNull List<qw> list) {
        Intrinsics.checkNotNullParameter(list, "data");
        this.qw.clear();
        this.qw.addAll(list);
        notifyDataSetChanged();
    }
}
