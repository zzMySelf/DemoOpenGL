package com.tera.scan.main.importfile.adapter;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.aiscan.R;
import fe.mmm.qw.j.th;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\u0018\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000bH\u0016J\u0016\u0010\u001b\u001a\u00020\u000f2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u001cH\u0007R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R7\u0010\t\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/tera/scan/main/importfile/adapter/ImportDocListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tera/scan/main/importfile/adapter/ImportDocListAdapter$ImportFileViewHolder;", "()V", "dataList", "", "Lcom/tera/scan/main/importfile/data/ImportFile;", "dateFormat", "Ljava/text/SimpleDateFormat;", "onItemClick", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "position", "", "getOnItemClick", "()Lkotlin/jvm/functions/Function1;", "setOnItemClick", "(Lkotlin/jvm/functions/Function1;)V", "getItemCount", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateData", "", "ImportFileViewHolder", "app-main_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ImportDocListAdapter extends RecyclerView.Adapter<ImportFileViewHolder> {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final SimpleDateFormat f6970ad = qw.qw();
    @Nullable

    /* renamed from: de  reason: collision with root package name */
    public Function1<? super Integer, Unit> f6971de;
    @NotNull
    public final List<fe.mmm.qw.xxx.uk.when.qw> qw = new ArrayList();

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JC\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112#\u0010\u0012\u001a\u001f\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\r\u0018\u00010\u00132\u0006\u0010\u0017\u001a\u00020\u0014J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u0019H\u0002R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/tera/scan/main/importfile/adapter/ImportDocListAdapter$ImportFileViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "desTitle", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "imageView", "Landroid/widget/ImageView;", "selectIcon", "title", "bind", "", "dataItem", "Lcom/tera/scan/main/importfile/data/ImportFile;", "dateFormat", "Ljava/text/SimpleDateFormat;", "onItemClick", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "position", "getFileDesTitle", "", "getIconResIdByName", "fileName", "app-main_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ImportFileViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: ad  reason: collision with root package name */
        public final TextView f6972ad;

        /* renamed from: de  reason: collision with root package name */
        public final ImageView f6973de;

        /* renamed from: fe  reason: collision with root package name */
        public final ImageView f6974fe;
        public final TextView qw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ImportFileViewHolder(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.qw = (TextView) view.findViewById(R.id.tv_item_file_name);
            this.f6972ad = (TextView) view.findViewById(R.id.tv_item_file_des);
            this.f6973de = (ImageView) view.findViewById(R.id.iv_file_item_select);
            this.f6974fe = (ImageView) view.findViewById(R.id.iv_style_icon);
        }

        public static final void qw(Function1 function1, int i2, View view) {
            if (function1 != null) {
                function1.invoke(Integer.valueOf(i2));
            }
        }

        public final String ad(fe.mmm.qw.xxx.uk.when.qw qwVar, SimpleDateFormat simpleDateFormat) {
            Object obj;
            try {
                Result.Companion companion = Result.Companion;
                obj = Result.m1155constructorimpl(simpleDateFormat.format(new Date(qwVar.de())));
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
            String qw2 = th.qw(qwVar.ad());
            return str + "  " + qw2;
        }

        public final void bind(@NotNull fe.mmm.qw.xxx.uk.when.qw qwVar, @NotNull SimpleDateFormat simpleDateFormat, @Nullable Function1<? super Integer, Unit> function1, int i2) {
            int i3;
            Intrinsics.checkNotNullParameter(qwVar, "dataItem");
            Intrinsics.checkNotNullParameter(simpleDateFormat, "dateFormat");
            TextView textView = this.qw;
            if (textView != null) {
                textView.setText(qwVar.qw());
            }
            TextView textView2 = this.f6972ad;
            if (textView2 != null) {
                textView2.setText(ad(qwVar, simpleDateFormat));
            }
            ImageView imageView = this.f6973de;
            if (imageView != null) {
                imageView.setSelected(qwVar.rg());
            }
            Resources resources = this.itemView.getResources();
            View view = this.itemView;
            if (qwVar.rg()) {
                i3 = resources.getColor(R.color.file_item_selected_background_color);
            } else {
                i3 = resources.getColor(R.color.file_item_not_selected_background_color);
            }
            view.setBackgroundColor(i3);
            this.f6974fe.setVisibility(0);
            ad.mmm(this.itemView.getContext()).ggg(Integer.valueOf(de(qwVar.qw()))).m317switch(this.f6974fe);
            this.itemView.setOnClickListener(new fe.mmm.qw.xxx.uk.p035switch.qw(function1, i2));
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

    @Nullable
    public final Function1<Integer, Unit> getOnItemClick() {
        return this.f6971de;
    }

    public final void setOnItemClick(@Nullable Function1<? super Integer, Unit> function1) {
        this.f6971de = function1;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void updateData(@NotNull List<fe.mmm.qw.xxx.uk.when.qw> list) {
        Intrinsics.checkNotNullParameter(list, "dataList");
        this.qw.clear();
        if (!list.isEmpty()) {
            this.qw.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void onBindViewHolder(@NotNull ImportFileViewHolder importFileViewHolder, int i2) {
        Intrinsics.checkNotNullParameter(importFileViewHolder, "holder");
        importFileViewHolder.bind(this.qw.get(i2), this.f6970ad, this.f6971de, i2);
    }

    @NotNull
    public ImportFileViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i2) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_common_file_list, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "itemView");
        return new ImportFileViewHolder(inflate);
    }
}
