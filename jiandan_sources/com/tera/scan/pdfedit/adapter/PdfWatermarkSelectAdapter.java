package com.tera.scan.pdfedit.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.aiscan.R;
import com.tera.scan.pdfedit.data.AddPdfItemData;
import fe.mmm.qw.j.th;
import fe.mmm.qw.qqq.qw.de;
import fe.mmm.qw.qqq.qw.yj;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003()*B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001dH\u0016J\u0018\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001dH\u0016J\u0018\u0010\"\u001a\u00020\u00022\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001dH\u0016J\u0016\u0010&\u001a\u00020\u00112\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0'H\u0007R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R9\u0010\u000b\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006+"}, d2 = {"Lcom/tera/scan/pdfedit/adapter/PdfWatermarkSelectAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "needMyDeviceImportHeader", "", "(Z)V", "dataList", "", "Lcom/tera/scan/pdfedit/data/AddPdfItemData;", "dateFormat", "Ljava/text/SimpleDateFormat;", "onItemClick", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "localPath", "", "getOnItemClick", "()Lkotlin/jvm/functions/Function1;", "setOnItemClick", "(Lkotlin/jvm/functions/Function1;)V", "onMyDeviceClick", "Lkotlin/Function0;", "getOnMyDeviceClick", "()Lkotlin/jvm/functions/Function0;", "setOnMyDeviceClick", "(Lkotlin/jvm/functions/Function0;)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateData", "", "Companion", "ImportFileViewHolder", "MyDeviceViewHolder", "BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PdfWatermarkSelectAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    @NotNull
    public static final qw Companion = new qw((DefaultConstructorMarker) null);
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final List<AddPdfItemData> f7076ad;
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public final SimpleDateFormat f7077de;
    @Nullable

    /* renamed from: fe  reason: collision with root package name */
    public Function1<? super String, Unit> f7078fe;
    public final boolean qw;
    @Nullable

    /* renamed from: rg  reason: collision with root package name */
    public Function0<Unit> f7079rg;

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J;\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112#\u0010\u0012\u001a\u001f\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\r\u0018\u00010\u0013J\u0018\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0014H\u0002R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/tera/scan/pdfedit/adapter/PdfWatermarkSelectAdapter$ImportFileViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "desTitle", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "imageView", "Landroid/widget/ImageView;", "selectIcon", "title", "bind", "", "dataItem", "Lcom/tera/scan/pdfedit/data/AddPdfItemData;", "dateFormat", "Ljava/text/SimpleDateFormat;", "onItemClick", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "localPath", "getFileDesTitle", "getIconResIdByName", "", "fileName", "BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ImportFileViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: ad  reason: collision with root package name */
        public final TextView f7080ad;

        /* renamed from: de  reason: collision with root package name */
        public final ImageView f7081de;

        /* renamed from: fe  reason: collision with root package name */
        public final ImageView f7082fe;
        public final TextView qw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ImportFileViewHolder(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.qw = (TextView) view.findViewById(R.id.tv_item_file_name);
            this.f7080ad = (TextView) view.findViewById(R.id.tv_item_file_des);
            this.f7081de = (ImageView) view.findViewById(R.id.iv_file_item_select);
            this.f7082fe = (ImageView) view.findViewById(R.id.iv_style_icon);
        }

        public static final void qw(Function1 function1, AddPdfItemData addPdfItemData, View view) {
            Intrinsics.checkNotNullParameter(addPdfItemData, "$dataItem");
            if (function1 != null) {
                String localPath = addPdfItemData.getScanRecordExportFile().getLocalPath();
                if (localPath == null) {
                    localPath = "";
                }
                function1.invoke(localPath);
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

        public final void bind(@NotNull AddPdfItemData addPdfItemData, @NotNull SimpleDateFormat simpleDateFormat, @Nullable Function1<? super String, Unit> function1) {
            Intrinsics.checkNotNullParameter(addPdfItemData, "dataItem");
            Intrinsics.checkNotNullParameter(simpleDateFormat, "dateFormat");
            TextView textView = this.qw;
            if (textView != null) {
                textView.setText(addPdfItemData.getFileName());
            }
            TextView textView2 = this.f7080ad;
            if (textView2 != null) {
                textView2.setText(ad(addPdfItemData, simpleDateFormat));
            }
            ImageView imageView = this.f7081de;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            this.itemView.setBackgroundColor(this.itemView.getResources().getColor(R.color.white));
            this.f7082fe.setVisibility(0);
            ad.mmm(this.itemView.getContext()).ggg(Integer.valueOf(de(addPdfItemData.getFileName()))).m317switch(this.f7082fe);
            this.itemView.setOnClickListener(new yj(function1, addPdfItemData));
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

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b¨\u0006\t"}, d2 = {"Lcom/tera/scan/pdfedit/adapter/PdfWatermarkSelectAdapter$MyDeviceViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "bind", "", "onMyDeviceClick", "Lkotlin/Function0;", "BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class MyDeviceViewHolder extends RecyclerView.ViewHolder {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MyDeviceViewHolder(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
        }

        public static final void qw(Function0 function0, View view) {
            if (function0 != null) {
                function0.invoke();
            }
        }

        public final void bind(@Nullable Function0<Unit> function0) {
            this.itemView.setOnClickListener(new de(function0));
        }
    }

    public static final class qw {
        public qw() {
        }

        public /* synthetic */ qw(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public PdfWatermarkSelectAdapter() {
        this(false, 1, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PdfWatermarkSelectAdapter(boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z);
    }

    public int getItemCount() {
        if (this.qw) {
            return this.f7076ad.size() + 1;
        }
        return this.f7076ad.size();
    }

    public int getItemViewType(int i2) {
        return (!this.qw || i2 != 0) ? 222 : 111;
    }

    @Nullable
    public final Function1<String, Unit> getOnItemClick() {
        return this.f7078fe;
    }

    @Nullable
    public final Function0<Unit> getOnMyDeviceClick() {
        return this.f7079rg;
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i2) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (viewHolder instanceof MyDeviceViewHolder) {
            ((MyDeviceViewHolder) viewHolder).bind(this.f7079rg);
        } else if (viewHolder instanceof ImportFileViewHolder) {
            if (this.qw) {
                i2--;
            }
            AddPdfItemData addPdfItemData = (AddPdfItemData) CollectionsKt___CollectionsKt.getOrNull(this.f7076ad, i2);
            if (addPdfItemData != null) {
                ((ImportFileViewHolder) viewHolder).bind(addPdfItemData, this.f7077de, this.f7078fe);
            }
        }
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i2) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (i2 == 111) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_pdf_toolbox_select, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "itemView");
            return new MyDeviceViewHolder(inflate);
        }
        View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_common_file_list, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate2, "itemView");
        return new ImportFileViewHolder(inflate2);
    }

    public final void setOnItemClick(@Nullable Function1<? super String, Unit> function1) {
        this.f7078fe = function1;
    }

    public final void setOnMyDeviceClick(@Nullable Function0<Unit> function0) {
        this.f7079rg = function0;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void updateData(@NotNull List<AddPdfItemData> list) {
        Intrinsics.checkNotNullParameter(list, "dataList");
        this.f7076ad.clear();
        if (!list.isEmpty()) {
            this.f7076ad.addAll(list);
        }
        notifyDataSetChanged();
    }

    public PdfWatermarkSelectAdapter(boolean z) {
        this.qw = z;
        this.f7076ad = new ArrayList();
        this.f7077de = fe.mmm.qw.rg.qw.qw.qw.qw.qw();
    }
}
