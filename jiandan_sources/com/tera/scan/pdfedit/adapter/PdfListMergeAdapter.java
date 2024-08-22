package com.tera.scan.pdfedit.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.aiscan.R;
import com.tera.scan.framework.kernel.BaseApplication;
import com.tera.scan.libanalytics.ScanAnalyticsBaseEvent;
import fe.mmm.qw.qqq.qw.ad;
import fe.mmm.qw.qqq.qw.th;
import fe.mmm.qw.qqq.rg.qw;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002+,B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u001f\u001a\u00020\u001aH\u0016J\u0010\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u001aH\u0016J\u0018\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u001aH\u0016J\u0018\u0010$\u001a\u00020\u00022\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001aH\u0016J\u0016\u0010(\u001a\u00020\u00132\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\b0*H\u0007R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R.\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/tera/scan/pdfedit/adapter/PdfListMergeAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "showAddFileItem", "", "(Z)V", "dataList", "", "Lcom/tera/scan/pdfedit/data/MergePdfItemData;", "dateFormat", "Ljava/text/SimpleDateFormat;", "itemTouchHelper", "Landroidx/recyclerview/widget/ItemTouchHelper;", "getItemTouchHelper", "()Landroidx/recyclerview/widget/ItemTouchHelper;", "setItemTouchHelper", "(Landroidx/recyclerview/widget/ItemTouchHelper;)V", "onItemAddListener", "Lkotlin/Function0;", "", "getOnItemAddListener", "()Lkotlin/jvm/functions/Function0;", "setOnItemAddListener", "(Lkotlin/jvm/functions/Function0;)V", "onItemDeleteListener", "Lkotlin/Function2;", "", "getOnItemDeleteListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemDeleteListener", "(Lkotlin/jvm/functions/Function2;)V", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateData", "pdfList", "", "AddItemViewHolder", "PdfItemViewHolder", "BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PdfListMergeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final List<qw> f7059ad;
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public final SimpleDateFormat f7060de;
    @Nullable

    /* renamed from: fe  reason: collision with root package name */
    public Function2<? super Integer, ? super qw, Unit> f7061fe;
    public final boolean qw;
    @Nullable

    /* renamed from: rg  reason: collision with root package name */
    public Function0<Unit> f7062rg;
    @Nullable

    /* renamed from: th  reason: collision with root package name */
    public ItemTouchHelper f7063th;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b¨\u0006\t"}, d2 = {"Lcom/tera/scan/pdfedit/adapter/PdfListMergeAdapter$AddItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "bind", "", "onItemAddListener", "Lkotlin/Function0;", "BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class AddItemViewHolder extends RecyclerView.ViewHolder {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AddItemViewHolder(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
        }

        public static final void qw(Function0 function0, View view) {
            if (function0 != null) {
                function0.invoke();
            }
        }

        public final void bind(@Nullable Function0<Unit> function0) {
            this.itemView.setOnClickListener(new ad(function0));
        }
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JF\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u001a\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u0016\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00030\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0006*\u0004\u0018\u00010\u00030\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0006*\u0004\u0018\u00010\u000b0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0006*\u0004\u0018\u00010\u000b0\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/tera/scan/pdfedit/adapter/PdfListMergeAdapter$PdfItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "ivDeleteItem", "kotlin.jvm.PlatformType", "ivDocIcon", "Landroid/widget/ImageView;", "ivMove", "tvItemFileDesc", "Landroid/widget/TextView;", "tvItemFileName", "bind", "", "item", "Lcom/tera/scan/pdfedit/data/MergePdfItemData;", "position", "", "dateFormat", "Ljava/text/SimpleDateFormat;", "onItemDeleteListener", "Lkotlin/Function2;", "itemTouchHelper", "Landroidx/recyclerview/widget/ItemTouchHelper;", "getFileDesTitle", "", "BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class PdfItemViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: ad  reason: collision with root package name */
        public final TextView f7064ad;

        /* renamed from: de  reason: collision with root package name */
        public final TextView f7065de;

        /* renamed from: fe  reason: collision with root package name */
        public final View f7066fe;
        public final View qw;

        /* renamed from: rg  reason: collision with root package name */
        public final ImageView f7067rg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PdfItemViewHolder(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.qw = view.findViewById(R.id.iv_delete_item);
            this.f7064ad = (TextView) view.findViewById(R.id.tv_item_file_name);
            this.f7065de = (TextView) view.findViewById(R.id.tv_item_file_des);
            this.f7066fe = view.findViewById(R.id.iv_file_item_move);
            this.f7067rg = (ImageView) view.findViewById(R.id.iv_style_icon);
        }

        public static final boolean ad(ItemTouchHelper itemTouchHelper, PdfItemViewHolder pdfItemViewHolder, View view, MotionEvent motionEvent) {
            Intrinsics.checkNotNullParameter(pdfItemViewHolder, "this$0");
            if (motionEvent.getAction() != 0) {
                return true;
            }
            ScanAnalyticsBaseEvent.qw.qw(fe.mmm.qw.ggg.qw.qw, "scan_change_order_move_pdf_click", (List) null, 2, (Object) null);
            if (itemTouchHelper == null) {
                return true;
            }
            itemTouchHelper.startDrag(pdfItemViewHolder);
            return true;
        }

        public static final void qw(Function2 function2, int i2, qw qwVar, View view) {
            Intrinsics.checkNotNullParameter(qwVar, "$item");
            if (function2 != null) {
                function2.invoke(Integer.valueOf(i2), qwVar);
            }
        }

        @SuppressLint({"ClickableViewAccessibility"})
        public final void bind(@NotNull qw qwVar, int i2, @NotNull SimpleDateFormat simpleDateFormat, @Nullable Function2<? super Integer, ? super qw, Unit> function2, @Nullable ItemTouchHelper itemTouchHelper) {
            Intrinsics.checkNotNullParameter(qwVar, "item");
            Intrinsics.checkNotNullParameter(simpleDateFormat, "dateFormat");
            this.f7064ad.setText(qwVar.ad().getFileName());
            this.f7065de.setText(de(qwVar, simpleDateFormat));
            this.qw.setOnClickListener(new th(function2, i2, qwVar));
            this.f7067rg.setImageResource(qwVar.de() ? R.drawable.icon_encrypt_pdf_no_padding : R.drawable.icon_pdf_no_padding);
            this.f7066fe.setOnTouchListener(new fe.mmm.qw.qqq.qw.qw(itemTouchHelper, this));
        }

        public final CharSequence de(qw qwVar, SimpleDateFormat simpleDateFormat) {
            Object obj;
            try {
                Result.Companion companion = Result.Companion;
                obj = Result.m1155constructorimpl(simpleDateFormat.format(new Date(qwVar.ad().getServerCtime() * 1000)));
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m1155constructorimpl(ResultKt.createFailure(th2));
            }
            if (Result.m1161isFailureimpl(obj)) {
                obj = null;
            }
            String str = (String) obj;
            String str2 = "";
            if (str == null) {
                str = str2;
            }
            String qw2 = fe.mmm.qw.j.th.qw((long) qwVar.ad().getSize());
            Context instance = BaseApplication.getInstance();
            Object[] objArr = new Object[3];
            objArr[0] = str;
            objArr[1] = qw2;
            if (qwVar.qw() > 0) {
                str2 = String.valueOf(qwVar.qw());
            }
            objArr[2] = str2;
            String string = instance.getString(R.string.pdf_merge_file_desc, objArr);
            Intrinsics.checkNotNullExpressionValue(string, "getInstance().getString(….toString()\n            )");
            return string;
        }
    }

    public PdfListMergeAdapter() {
        this(false, 1, (DefaultConstructorMarker) null);
    }

    public PdfListMergeAdapter(boolean z) {
        this.qw = z;
        this.f7059ad = new ArrayList();
        this.f7060de = fe.mmm.qw.rg.qw.qw.qw.qw.qw();
    }

    public int getItemCount() {
        return this.qw ? this.f7059ad.size() + 1 : this.f7059ad.size();
    }

    @Nullable
    public final ItemTouchHelper getItemTouchHelper() {
        return this.f7063th;
    }

    public int getItemViewType(int i2) {
        return i2 == this.f7059ad.size() ? 112 : 111;
    }

    @Nullable
    public final Function0<Unit> getOnItemAddListener() {
        return this.f7062rg;
    }

    @Nullable
    public final Function2<Integer, qw, Unit> getOnItemDeleteListener() {
        return this.f7061fe;
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i2) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (viewHolder instanceof PdfItemViewHolder) {
            ((PdfItemViewHolder) viewHolder).bind(this.f7059ad.get(i2), i2, this.f7060de, this.f7061fe, this.f7063th);
        } else if (viewHolder instanceof AddItemViewHolder) {
            ((AddItemViewHolder) viewHolder).bind(this.f7062rg);
        }
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i2) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (i2 == 111) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_merge_pdf, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "itemView");
            return new PdfItemViewHolder(inflate);
        }
        View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_add_for_merge_pdf, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate2, "itemView");
        return new AddItemViewHolder(inflate2);
    }

    public final void setItemTouchHelper(@Nullable ItemTouchHelper itemTouchHelper) {
        this.f7063th = itemTouchHelper;
    }

    public final void setOnItemAddListener(@Nullable Function0<Unit> function0) {
        this.f7062rg = function0;
    }

    public final void setOnItemDeleteListener(@Nullable Function2<? super Integer, ? super qw, Unit> function2) {
        this.f7061fe = function2;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void updateData(@NotNull List<qw> list) {
        Intrinsics.checkNotNullParameter(list, "pdfList");
        this.f7059ad.clear();
        if (!list.isEmpty()) {
            this.f7059ad.addAll(list);
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PdfListMergeAdapter(boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? true : z);
    }
}
