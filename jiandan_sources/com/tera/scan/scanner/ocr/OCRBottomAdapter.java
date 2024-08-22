package com.tera.scan.scanner.ocr;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.aiscan.R;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tera.scan.scanner.ocr.control.IOCRTakePhotoControl;
import fe.mmm.qw.d.fe.yj;
import fe.mmm.qw.tt.ad.i;
import fe.mmm.qw.tt.ad.rg;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u0006\u0010\u001e\u001a\u00020\u0007J\b\u0010\u001f\u001a\u00020\u0007H\u0016J\u000e\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0007J\u000e\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007J\u0018\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u0007H\u0016J\u0018\u0010'\u001a\u00020\u00022\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0007H\u0016J\u000e\u0010+\u001a\u00020%2\u0006\u0010#\u001a\u00020\u0007R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006,"}, d2 = {"Lcom/tera/scan/scanner/ocr/OCRBottomAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "items", "", "Lcom/tera/scan/scanner/ocr/OCRBottomTab;", "currentTab", "", "listener", "Lcom/tera/scan/scanner/ocr/OnItemClickListener;", "(Ljava/util/List;ILcom/tera/scan/scanner/ocr/OnItemClickListener;)V", "getCurrentTab", "()I", "setCurrentTab", "(I)V", "currentTabItem", "getCurrentTabItem", "()Lcom/tera/scan/scanner/ocr/OCRBottomTab;", "setCurrentTabItem", "(Lcom/tera/scan/scanner/ocr/OCRBottomTab;)V", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "getListener", "()Lcom/tera/scan/scanner/ocr/OnItemClickListener;", "setListener", "(Lcom/tera/scan/scanner/ocr/OnItemClickListener;)V", "getCurControl", "Lcom/tera/scan/scanner/ocr/control/IOCRTakePhotoControl;", "getCurPosition", "getItemCount", "getPosition", "tab", "getTab", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "selectItem", "scanner_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OCRBottomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: ad  reason: collision with root package name */
    public int f7176ad;
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public OnItemClickListener f7177de;
    @Nullable

    /* renamed from: fe  reason: collision with root package name */
    public i f7178fe;
    @NotNull
    public List<i> qw;

    public OCRBottomAdapter(@NotNull List<i> list, int i2, @NotNull OnItemClickListener onItemClickListener) {
        Intrinsics.checkNotNullParameter(list, "items");
        Intrinsics.checkNotNullParameter(onItemClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.qw = list;
        this.f7176ad = i2;
        this.f7177de = onItemClickListener;
    }

    public static final void qw(OCRBottomAdapter oCRBottomAdapter, int i2, View view) {
        Intrinsics.checkNotNullParameter(oCRBottomAdapter, "this$0");
        oCRBottomAdapter.f7177de.onItemClick(i2);
    }

    @Nullable
    public final IOCRTakePhotoControl getCurControl() {
        return this.qw.get(getPosition(this.f7176ad)).ad();
    }

    public final int getCurPosition() {
        return getPosition(this.f7176ad);
    }

    public final int getCurrentTab() {
        return this.f7176ad;
    }

    @Nullable
    public final i getCurrentTabItem() {
        return this.f7178fe;
    }

    public int getItemCount() {
        return this.qw.size();
    }

    @NotNull
    public final List<i> getItems() {
        return this.qw;
    }

    @NotNull
    public final OnItemClickListener getListener() {
        return this.f7177de;
    }

    public final int getPosition(int i2) {
        int i3 = 0;
        for (T next : this.qw) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (((i) next).de() == i2) {
                return i3;
            }
            i3 = i4;
        }
        return 0;
    }

    public final int getTab(int i2) {
        if (i2 >= this.qw.size() || i2 < 0) {
            return -1;
        }
        return this.qw.get(i2).de();
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i2) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if ((viewHolder instanceof OCRBottomViewHolder) && i2 <= this.qw.size() && i2 >= 0) {
            OCRBottomViewHolder oCRBottomViewHolder = (OCRBottomViewHolder) viewHolder;
            oCRBottomViewHolder.getTitle().setText(this.qw.get(i2).th());
            if (this.qw.get(i2).de() == this.f7176ad) {
                oCRBottomViewHolder.getTitle().setTextColor(yj.qw(R.color.ui_color_gc4));
                oCRBottomViewHolder.getTitle().setTypeface(Typeface.defaultFromStyle(1));
            } else {
                oCRBottomViewHolder.getTitle().setTextColor(viewHolder.itemView.getContext().getResources().getColor(R.color.ui_color_gc2));
                oCRBottomViewHolder.getTitle().setTypeface(Typeface.defaultFromStyle(0));
            }
            viewHolder.itemView.setOnClickListener(new rg(this, i2));
            oCRBottomViewHolder.getFreeTip().setVisibility(8);
        }
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i2) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ocr_tab_item_layout, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf…rent, false\n            )");
        return new OCRBottomViewHolder(inflate);
    }

    public final void selectItem(int i2) {
        IOCRTakePhotoControl ad2;
        IOCRTakePhotoControl ad3;
        this.f7178fe = this.qw.get(i2);
        i iVar = (i) CollectionsKt___CollectionsKt.getOrNull(this.qw, getCurPosition());
        if (!(iVar == null || (ad3 = iVar.ad()) == null)) {
            ad3.de();
        }
        this.f7176ad = this.qw.get(i2).de();
        this.qw.get(i2).yj("");
        notifyDataSetChanged();
        i iVar2 = (i) CollectionsKt___CollectionsKt.getOrNull(this.qw, getCurPosition());
        if (iVar2 != null && (ad2 = iVar2.ad()) != null) {
            ad2.ad();
        }
    }

    public final void setCurrentTab(int i2) {
        this.f7176ad = i2;
    }

    public final void setCurrentTabItem(@Nullable i iVar) {
        this.f7178fe = iVar;
    }

    public final void setItems(@NotNull List<i> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.qw = list;
    }

    public final void setListener(@NotNull OnItemClickListener onItemClickListener) {
        Intrinsics.checkNotNullParameter(onItemClickListener, "<set-?>");
        this.f7177de = onItemClickListener;
    }
}
