package com.tera.scan.pdfedit.ui;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import com.tera.scan.pdfedit.adapter.PdfListMergeAdapter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0016H\u0016J\u001a\u0010\u001c\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001d\u001a\u00020\u0007H\u0016J\u0018\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u0007H\u0016RL\u0010\u0005\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/tera/scan/pdfedit/ui/PdfMergeItemTouchHelper;", "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;", "pdfListMergeAdapter", "Lcom/tera/scan/pdfedit/adapter/PdfListMergeAdapter;", "(Lcom/tera/scan/pdfedit/adapter/PdfListMergeAdapter;)V", "changeListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "fromPosition", "toPosition", "", "getChangeListener", "()Lkotlin/jvm/functions/Function2;", "setChangeListener", "(Lkotlin/jvm/functions/Function2;)V", "longClickPosition", "clearView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getMovementFlags", "isLongPressDragEnabled", "", "onMove", "target", "onSelectedChanged", "actionState", "onSwiped", "direction", "BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PdfMergeItemTouchHelper extends ItemTouchHelper.Callback {

    /* renamed from: ad  reason: collision with root package name */
    public int f7083ad = -1;
    @Nullable

    /* renamed from: de  reason: collision with root package name */
    public Function2<? super Integer, ? super Integer, Unit> f7084de;
    @NotNull
    public final PdfListMergeAdapter qw;

    public PdfMergeItemTouchHelper(@NotNull PdfListMergeAdapter pdfListMergeAdapter) {
        Intrinsics.checkNotNullParameter(pdfListMergeAdapter, "pdfListMergeAdapter");
        this.qw = pdfListMergeAdapter;
    }

    public void clearView(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        int adapterPosition = viewHolder.getAdapterPosition();
        Function2<? super Integer, ? super Integer, Unit> function2 = this.f7084de;
        if (function2 != null) {
            function2.invoke(Integer.valueOf(this.f7083ad), Integer.valueOf(adapterPosition));
        }
        super.clearView(recyclerView, viewHolder);
    }

    @Nullable
    public final Function2<Integer, Integer, Unit> getChangeListener() {
        return this.f7084de;
    }

    public int getMovementFlags(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        return ItemTouchHelper.Callback.makeMovementFlags(3, 0);
    }

    public boolean isLongPressDragEnabled() {
        return false;
    }

    public boolean onMove(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder, @NotNull RecyclerView.ViewHolder viewHolder2) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(viewHolder2, AnimatedVectorDrawableCompat.TARGET);
        recyclerView.getParent().requestDisallowInterceptTouchEvent(true);
        int adapterPosition = viewHolder.getAdapterPosition();
        int adapterPosition2 = viewHolder2.getAdapterPosition();
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter != null) {
            adapter.getItemCount();
        }
        this.qw.notifyItemMoved(adapterPosition, adapterPosition2);
        return true;
    }

    public void onSelectedChanged(@Nullable RecyclerView.ViewHolder viewHolder, int i2) {
        if (viewHolder != null) {
            this.f7083ad = viewHolder.getAdapterPosition();
        }
        super.onSelectedChanged(viewHolder, i2);
    }

    public void onSwiped(@NotNull RecyclerView.ViewHolder viewHolder, int i2) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
    }

    public final void setChangeListener(@Nullable Function2<? super Integer, ? super Integer, Unit> function2) {
        this.f7084de = function2;
    }
}
