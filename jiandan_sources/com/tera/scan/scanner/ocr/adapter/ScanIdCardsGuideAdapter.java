package com.tera.scan.scanner.ocr.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.aiscan.R;
import com.tera.scan.scanner.ocr.model.ScanIdCardsModel;
import com.tera.scan.ui.view.widget.UITextView;
import fe.mmm.qw.th.qw.th.yj;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001*B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\b\u0010!\u001a\u00020\tH\u0016J\u0018\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\tH\u0016J\u0018\u0010%\u001a\u00020\u00022\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\tH\u0016J\u0010\u0010)\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\tH\u0003R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010RL\u0010\u0011\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006+"}, d2 = {"Lcom/tera/scan/scanner/ocr/adapter/ScanIdCardsGuideAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "activity", "Landroid/app/Activity;", "mItemList", "", "Lcom/tera/scan/scanner/ocr/model/ScanIdCardsModel;", "currentSelectPosition", "", "(Landroid/app/Activity;Ljava/util/List;I)V", "getActivity", "()Landroid/app/Activity;", "getCurrentSelectPosition", "()I", "setCurrentSelectPosition", "(I)V", "mItemClickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "selectItem", "selectPosition", "", "getMItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setMItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "getMItemList", "()Ljava/util/List;", "setMItemList", "(Ljava/util/List;)V", "getAllData", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateSelectItem", "ScanIdCardsGuideViewHolder", "scanner_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ScanIdCardsGuideAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public List<ScanIdCardsModel> f7184ad;

    /* renamed from: de  reason: collision with root package name */
    public int f7185de;
    @Nullable

    /* renamed from: fe  reason: collision with root package name */
    public Function2<? super ScanIdCardsModel, ? super Integer, Unit> f7186fe;
    @NotNull
    public final Activity qw;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/tera/scan/scanner/ocr/adapter/ScanIdCardsGuideAdapter$ScanIdCardsGuideViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemview", "Landroid/view/View;", "(Landroid/view/View;)V", "title", "Lcom/tera/scan/ui/view/widget/UITextView;", "getTitle", "()Lcom/tera/scan/ui/view/widget/UITextView;", "scanner_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ScanIdCardsGuideViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        public final UITextView qw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ScanIdCardsGuideViewHolder(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemview");
            View findViewById = this.itemView.findViewById(R.id.btn_card_title);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.btn_card_title)");
            this.qw = (UITextView) findViewById;
        }

        @NotNull
        public final UITextView getTitle() {
            return this.qw;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ScanIdCardsGuideAdapter(Activity activity, List list, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity, list, (i3 & 4) != 0 ? 0 : i2);
    }

    @NotNull
    public final Activity getActivity() {
        return this.qw;
    }

    @NotNull
    public final List<ScanIdCardsModel> getAllData() {
        return this.f7184ad;
    }

    public final int getCurrentSelectPosition() {
        return this.f7185de;
    }

    public int getItemCount() {
        return this.f7184ad.size();
    }

    @Nullable
    public final Function2<ScanIdCardsModel, Integer, Unit> getMItemClickListener() {
        return this.f7186fe;
    }

    @NotNull
    public final List<ScanIdCardsModel> getMItemList() {
        return this.f7184ad;
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i2) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if ((viewHolder instanceof ScanIdCardsGuideViewHolder) && i2 <= this.f7184ad.size() && i2 >= 0) {
            Integer titleRes = this.f7184ad.get(i2).getTitleRes();
            if (titleRes != null) {
                ((ScanIdCardsGuideViewHolder) viewHolder).getTitle().setText(this.qw.getResources().getString(titleRes.intValue()));
            }
            ScanIdCardsGuideViewHolder scanIdCardsGuideViewHolder = (ScanIdCardsGuideViewHolder) viewHolder;
            scanIdCardsGuideViewHolder.getTitle().setSelected(i2 == this.f7185de);
            yj.de(scanIdCardsGuideViewHolder.getTitle(), 0, new ScanIdCardsGuideAdapter$onBindViewHolder$2(this, i2), 1, (Object) null);
        }
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i2) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_scan_id_cards_guide_layout, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf…rent, false\n            )");
        return new ScanIdCardsGuideViewHolder(inflate);
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void qw(int i2) {
        if ((!this.f7184ad.isEmpty()) && this.f7184ad.size() > i2) {
            this.f7185de = i2;
            Function2<? super ScanIdCardsModel, ? super Integer, Unit> function2 = this.f7186fe;
            if (function2 != null) {
                function2.invoke(this.f7184ad.get(i2), Integer.valueOf(i2));
            }
            notifyDataSetChanged();
        }
    }

    public final void setCurrentSelectPosition(int i2) {
        this.f7185de = i2;
    }

    public final void setMItemClickListener(@Nullable Function2<? super ScanIdCardsModel, ? super Integer, Unit> function2) {
        this.f7186fe = function2;
    }

    public final void setMItemList(@NotNull List<ScanIdCardsModel> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.f7184ad = list;
    }

    public ScanIdCardsGuideAdapter(@NotNull Activity activity, @NotNull List<ScanIdCardsModel> list, int i2) {
        Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics.checkNotNullParameter(list, "mItemList");
        this.qw = activity;
        this.f7184ad = list;
        this.f7185de = i2;
    }
}
