package com.tera.scan.pdfedit.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.aiscan.R;
import fe.mmm.qw.qqq.qw.rg;
import fe.mmm.qw.qqq.rg.ad;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000f\u001a\u00020\tH\u0016J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\tH\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\tH\u0016J\u0016\u0010\u0017\u001a\u00020\n2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u0019H\u0007J\u0016\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u0006R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R(\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/tera/scan/pdfedit/adapter/PdfListSplitAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tera/scan/pdfedit/adapter/PdfListSplitAdapter$PdfItemViewHolder;", "()V", "dataList", "", "Lcom/tera/scan/pdfedit/data/SplitPdfItemData;", "onItemSelectListener", "Lkotlin/Function1;", "", "", "getOnItemSelectListener", "()Lkotlin/jvm/functions/Function1;", "setOnItemSelectListener", "(Lkotlin/jvm/functions/Function1;)V", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateData", "pdfList", "", "updateItem", "index", "item", "PdfItemViewHolder", "BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PdfListSplitAdapter extends RecyclerView.Adapter<PdfItemViewHolder> {
    @Nullable

    /* renamed from: ad  reason: collision with root package name */
    public Function1<? super Integer, Unit> f7068ad;
    @NotNull
    public final List<ad> qw = new ArrayList();

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J.\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\f\u0018\u00010\u0012H\u0007R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\n0\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/tera/scan/pdfedit/adapter/PdfListSplitAdapter$PdfItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "ivPageContent", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "ivPageSelect", "tvPageIndex", "Landroid/widget/TextView;", "bind", "", "item", "Lcom/tera/scan/pdfedit/data/SplitPdfItemData;", "position", "", "onItemSelectListener", "Lkotlin/Function1;", "BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class PdfItemViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: ad  reason: collision with root package name */
        public final TextView f7069ad;

        /* renamed from: de  reason: collision with root package name */
        public final ImageView f7070de;
        public final ImageView qw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PdfItemViewHolder(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.qw = (ImageView) view.findViewById(R.id.iv_pdf_page_thumbnail);
            this.f7069ad = (TextView) view.findViewById(R.id.tv_pdf_page_index);
            this.f7070de = (ImageView) view.findViewById(R.id.iv_pdf_page_item_select);
        }

        public static final void qw(Function1 function1, int i2, View view) {
            if (function1 != null) {
                function1.invoke(Integer.valueOf(i2));
            }
        }

        @SuppressLint({"ClickableViewAccessibility"})
        public final void bind(@NotNull ad adVar, int i2, @Nullable Function1<? super Integer, Unit> function1) {
            Intrinsics.checkNotNullParameter(adVar, "item");
            this.f7070de.setSelected(adVar.de());
            this.f7069ad.setText(String.valueOf(adVar.ad() + 1));
            fe.rg.qw.ad.mmm(this.itemView.getContext()).vvv(adVar.qw()).m317switch(this.qw);
            this.f7070de.setOnClickListener(new rg(function1, i2));
        }
    }

    public int getItemCount() {
        return this.qw.size();
    }

    @Nullable
    public final Function1<Integer, Unit> getOnItemSelectListener() {
        return this.f7068ad;
    }

    public final void setOnItemSelectListener(@Nullable Function1<? super Integer, Unit> function1) {
        this.f7068ad = function1;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void updateData(@NotNull List<ad> list) {
        Intrinsics.checkNotNullParameter(list, "pdfList");
        this.qw.clear();
        if (!list.isEmpty()) {
            this.qw.addAll(list);
        }
        notifyDataSetChanged();
    }

    public final void updateItem(int i2, @NotNull ad adVar) {
        Intrinsics.checkNotNullParameter(adVar, "item");
        if (i2 < this.qw.size()) {
            this.qw.set(i2, adVar);
            notifyItemChanged(i2);
        }
    }

    public void onBindViewHolder(@NotNull PdfItemViewHolder pdfItemViewHolder, int i2) {
        Intrinsics.checkNotNullParameter(pdfItemViewHolder, "holder");
        pdfItemViewHolder.bind(this.qw.get(i2), i2, this.f7068ad);
    }

    @NotNull
    public PdfItemViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i2) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_pdf_split_page, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "itemView");
        return new PdfItemViewHolder(inflate);
    }
}
