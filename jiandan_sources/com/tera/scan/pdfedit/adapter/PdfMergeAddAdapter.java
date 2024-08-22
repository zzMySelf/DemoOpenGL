package com.tera.scan.pdfedit.adapter;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.aiscan.R;
import com.tera.scan.pdfedit.data.AddPdfItemData;
import fe.mmm.qw.j.th;
import fe.mmm.qw.qqq.qw.fe;
import fe.mmm.qw.rg.qw.qw.qw.qw;
import fe.rg.qw.ad;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000bH\u0016J\u0016\u0010\u001c\u001a\u00020\u000f2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u001dH\u0007R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R7\u0010\t\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/tera/scan/pdfedit/adapter/PdfMergeAddAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "()V", "dataList", "", "Lcom/tera/scan/pdfedit/data/AddPdfItemData;", "dateFormat", "Ljava/text/SimpleDateFormat;", "onItemClick", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "position", "", "getOnItemClick", "()Lkotlin/jvm/functions/Function1;", "setOnItemClick", "(Lkotlin/jvm/functions/Function1;)V", "getItemCount", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateData", "", "ImportFileViewHolder", "BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PdfMergeAddAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final SimpleDateFormat f7071ad = qw.qw();
    @Nullable

    /* renamed from: de  reason: collision with root package name */
    public Function1<? super Integer, Unit> f7072de;
    @NotNull
    public final List<AddPdfItemData> qw = new ArrayList();

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JC\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112#\u0010\u0012\u001a\u001f\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\r\u0018\u00010\u00132\u0006\u0010\u0017\u001a\u00020\u0014J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u0019H\u0002R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/tera/scan/pdfedit/adapter/PdfMergeAddAdapter$ImportFileViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "desTitle", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "imageView", "Landroid/widget/ImageView;", "selectIcon", "title", "bind", "", "dataItem", "Lcom/tera/scan/pdfedit/data/AddPdfItemData;", "dateFormat", "Ljava/text/SimpleDateFormat;", "onItemClick", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "position", "getFileDesTitle", "", "getIconResIdByName", "fileName", "BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ImportFileViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: ad  reason: collision with root package name */
        public final TextView f7073ad;

        /* renamed from: de  reason: collision with root package name */
        public final ImageView f7074de;

        /* renamed from: fe  reason: collision with root package name */
        public final ImageView f7075fe;
        public final TextView qw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ImportFileViewHolder(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.qw = (TextView) view.findViewById(R.id.tv_item_file_name);
            this.f7073ad = (TextView) view.findViewById(R.id.tv_item_file_des);
            this.f7074de = (ImageView) view.findViewById(R.id.iv_file_item_select);
            this.f7075fe = (ImageView) view.findViewById(R.id.iv_style_icon);
        }

        public static final void qw(Function1 function1, int i2, View view) {
            if (function1 != null) {
                function1.invoke(Integer.valueOf(i2));
            }
        }

        public final String ad(AddPdfItemData addPdfItemData, SimpleDateFormat simpleDateFormat) {
            Object obj;
            try {
                Result.Companion companion = Result.Companion;
                obj = Result.m1155constructorimpl(simpleDateFormat.format(new Date(addPdfItemData.getLastModified())));
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m1155constructorimpl(ResultKt.createFailure(th2));
            }
            if (Result.m1161isFailureimpl(obj)) {
                obj = null;
            }
            String str = (String) obj;
            if (str == null) {
                str = "";
            }
            String qw2 = th.qw(addPdfItemData.getFileSize());
            return str + "  " + qw2;
        }

        public final void bind(@NotNull AddPdfItemData addPdfItemData, @NotNull SimpleDateFormat simpleDateFormat, @Nullable Function1<? super Integer, Unit> function1, int i2) {
            int i3;
            Intrinsics.checkNotNullParameter(addPdfItemData, "dataItem");
            Intrinsics.checkNotNullParameter(simpleDateFormat, "dateFormat");
            TextView textView = this.qw;
            if (textView != null) {
                textView.setText(addPdfItemData.getFileName());
            }
            TextView textView2 = this.f7073ad;
            if (textView2 != null) {
                textView2.setText(ad(addPdfItemData, simpleDateFormat));
            }
            ImageView imageView = this.f7074de;
            if (imageView != null) {
                imageView.setSelected(addPdfItemData.isSelected());
            }
            Resources resources = this.itemView.getResources();
            View view = this.itemView;
            if (addPdfItemData.isSelected()) {
                i3 = resources.getColor(R.color.file_item_selected_background_color);
            } else {
                i3 = resources.getColor(R.color.file_item_not_selected_background_color);
            }
            view.setBackgroundColor(i3);
            this.f7075fe.setVisibility(0);
            ad.mmm(this.itemView.getContext()).ggg(Integer.valueOf(de(addPdfItemData.getFileName()))).m317switch(this.f7075fe);
            this.itemView.setOnClickListener(new fe(function1, i2));
        }

        public final int de(String str) {
            Locale locale = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
            String lowerCase = str.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (StringsKt__StringsJVMKt.endsWith$default(lowerCase, ".pdf", false, 2, (Object) null) || StringsKt__StringsJVMKt.endsWith$default(lowerCase, ".pdfx", false, 2, (Object) null)) {
                return R.drawable.icon_main_pdf;
            }
            if (StringsKt__StringsJVMKt.endsWith$default(lowerCase, ".xls", false, 2, (Object) null) || StringsKt__StringsJVMKt.endsWith$default(lowerCase, ".xlsx", false, 2, (Object) null)) {
                return R.drawable.icon_main_exls;
            }
            return (StringsKt__StringsJVMKt.endsWith$default(lowerCase, ".doc", false, 2, (Object) null) || StringsKt__StringsJVMKt.endsWith$default(lowerCase, ".docx", false, 2, (Object) null)) ? R.drawable.icon_main_doc : R.drawable.icon_main_txt;
        }
    }

    public int getItemCount() {
        return this.qw.size();
    }

    public int getItemViewType(int i2) {
        return 222;
    }

    @Nullable
    public final Function1<Integer, Unit> getOnItemClick() {
        return this.f7072de;
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i2) {
        AddPdfItemData addPdfItemData;
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if ((viewHolder instanceof ImportFileViewHolder) && (addPdfItemData = (AddPdfItemData) CollectionsKt___CollectionsKt.getOrNull(this.qw, i2)) != null) {
            ((ImportFileViewHolder) viewHolder).bind(addPdfItemData, this.f7071ad, this.f7072de, i2);
        }
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i2) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_common_file_list, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "itemView");
        return new ImportFileViewHolder(inflate);
    }

    public final void setOnItemClick(@Nullable Function1<? super Integer, Unit> function1) {
        this.f7072de = function1;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void updateData(@NotNull List<AddPdfItemData> list) {
        Intrinsics.checkNotNullParameter(list, "dataList");
        this.qw.clear();
        if (!list.isEmpty()) {
            this.qw.addAll(list);
        }
        notifyDataSetChanged();
    }
}
