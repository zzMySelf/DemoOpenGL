package com.tera.scan.widget.selecttext;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.aiscan.R;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001f B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t0\b¢\u0006\u0002\u0010\fJ\b\u0010\u0014\u001a\u00020\nH\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\nH\u0016J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\nH\u0016J\u0010\u0010\u001d\u001a\u00020\u00162\b\u0010\u001e\u001a\u0004\u0018\u00010\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t0\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011¨\u0006!"}, d2 = {"Lcom/tera/scan/widget/selecttext/SelectTextPopAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tera/scan/widget/selecttext/SelectTextPopAdapter$SelectTextPopViewHolder;", "context", "Landroid/content/Context;", "itemWrapContent", "", "list", "", "Landroid/util/Pair;", "", "", "(Landroid/content/Context;ZLjava/util/List;)V", "listener", "Lcom/tera/scan/widget/selecttext/SelectTextPopAdapter$ClickItemListener;", "paddingHorizontal", "getPaddingHorizontal", "()I", "paddingHorizontal$delegate", "Lkotlin/Lazy;", "getItemCount", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setOnclickItemListener", "l", "ClickItemListener", "SelectTextPopViewHolder", "x-widgets_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SelectTextPopAdapter extends RecyclerView.Adapter<SelectTextPopViewHolder> {

    /* renamed from: ad  reason: collision with root package name */
    public final boolean f7530ad;
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public final List<Pair<Integer, String>> f7531de;
    @Nullable

    /* renamed from: fe  reason: collision with root package name */
    public ClickItemListener f7532fe;
    @NotNull
    public final Context qw;
    @NotNull

    /* renamed from: rg  reason: collision with root package name */
    public final Lazy f7533rg;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/tera/scan/widget/selecttext/SelectTextPopAdapter$ClickItemListener;", "", "onClick", "", "position", "", "x-widgets_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface ClickItemListener {
        void qw(int i2);
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/tera/scan/widget/selecttext/SelectTextPopAdapter$SelectTextPopViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "ivPopIcon", "Landroid/widget/ImageView;", "getIvPopIcon", "()Landroid/widget/ImageView;", "tvPopFunc", "Landroid/widget/TextView;", "getTvPopFunc", "()Landroid/widget/TextView;", "x-widgets_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SelectTextPopViewHolder extends RecyclerView.ViewHolder {
        @NotNull

        /* renamed from: ad  reason: collision with root package name */
        public final TextView f7534ad;
        @NotNull
        public final ImageView qw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SelectTextPopViewHolder(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            View findViewById = view.findViewById(R.id.iv_pop_icon);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.iv_pop_icon)");
            this.qw = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.tv_pop_func);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.tv_pop_func)");
            this.f7534ad = (TextView) findViewById2;
        }

        @NotNull
        public final ImageView getIvPopIcon() {
            return this.qw;
        }

        @NotNull
        public final TextView getTvPopFunc() {
            return this.f7534ad;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SelectTextPopAdapter(Context context, boolean z, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? false : z, list);
    }

    public static final void ad(SelectTextPopAdapter selectTextPopAdapter, int i2, View view) {
        Intrinsics.checkNotNullParameter(selectTextPopAdapter, "this$0");
        ClickItemListener clickItemListener = selectTextPopAdapter.f7532fe;
        if (clickItemListener != null) {
            clickItemListener.qw(i2);
        }
    }

    public int getItemCount() {
        return this.f7531de.size();
    }

    public final int qw() {
        return ((Number) this.f7533rg.getValue()).intValue();
    }

    public final void setOnclickItemListener(@Nullable ClickItemListener clickItemListener) {
        this.f7532fe = clickItemListener;
    }

    public SelectTextPopAdapter(@NotNull Context context, boolean z, @NotNull List<? extends Pair<Integer, String>> list) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "list");
        this.qw = context;
        this.f7530ad = z;
        this.f7531de = list;
        this.f7533rg = LazyKt__LazyJVMKt.lazy(SelectTextPopAdapter$paddingHorizontal$2.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull com.tera.scan.widget.selecttext.SelectTextPopAdapter.SelectTextPopViewHolder r5, int r6) {
        /*
            r4 = this;
            java.lang.String r0 = "viewHolder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.util.List<android.util.Pair<java.lang.Integer, java.lang.String>> r0 = r4.f7531de
            java.lang.Object r0 = kotlin.collections.CollectionsKt___CollectionsKt.getOrNull(r0, r6)
            android.util.Pair r0 = (android.util.Pair) r0
            r1 = 0
            if (r0 == 0) goto L_0x0015
            java.lang.Object r0 = r0.first
            java.lang.Integer r0 = (java.lang.Integer) r0
            goto L_0x0016
        L_0x0015:
            r0 = r1
        L_0x0016:
            if (r0 == 0) goto L_0x0026
            r0.intValue()
            android.widget.ImageView r2 = r5.getIvPopIcon()
            int r0 = r0.intValue()
            r2.setBackgroundResource(r0)
        L_0x0026:
            java.util.List<android.util.Pair<java.lang.Integer, java.lang.String>> r0 = r4.f7531de
            java.lang.Object r0 = kotlin.collections.CollectionsKt___CollectionsKt.getOrNull(r0, r6)
            android.util.Pair r0 = (android.util.Pair) r0
            if (r0 == 0) goto L_0x0035
            java.lang.Object r0 = r0.second
            r1 = r0
            java.lang.String r1 = (java.lang.String) r1
        L_0x0035:
            android.widget.TextView r0 = r5.getTvPopFunc()
            r0.setText(r1)
            boolean r0 = r4.f7530ad
            if (r0 == 0) goto L_0x0062
            android.widget.TextView r0 = r5.getTvPopFunc()
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            r1 = -2
            r0.width = r1
            android.widget.TextView r1 = r5.getTvPopFunc()
            r1.setLayoutParams(r0)
            android.widget.TextView r0 = r5.getTvPopFunc()
            int r1 = r4.qw()
            int r2 = r4.qw()
            r3 = 0
            r0.setPadding(r1, r3, r2, r3)
        L_0x0062:
            android.view.View r5 = r5.itemView
            fe.mmm.qw.n.fe.qw r0 = new fe.mmm.qw.n.fe.qw
            r0.<init>(r4, r6)
            r5.setOnClickListener(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.widget.selecttext.SelectTextPopAdapter.onBindViewHolder(com.tera.scan.widget.selecttext.SelectTextPopAdapter$SelectTextPopViewHolder, int):void");
    }

    @NotNull
    public SelectTextPopViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i2) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.qw).inflate(R.layout.item_select_text_pop, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        return new SelectTextPopViewHolder(inflate);
    }
}
