package com.tera.scan.main.home;

import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.util.io.DocumentOpenUtil;
import fe.mmm.qw.th.qw.rg.fe.de.qw;
import fe.mmm.qw.xxx.yj.Cif;
import fe.mmm.qw.xxx.yj.when;
import fe.rg.qw.ad;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u001f\u0010\r\u001a\u0004\u0018\u0001H\u000e\"\b\b\u0000\u0010\u000e*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\n¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013J\u0016\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nJ\u0016\u0010\u0015\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0013J1\u0010\u0017\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\b0\u0019J5\u0010\u001d\u001a\u00020\b2\n\u0010\u001e\u001a\u00020\u001f\"\u00020\n2!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\b0\u0019J\u0016\u0010 \u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010!\u001a\u00020\u0013J\u0016\u0010\"\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nJ\u0016\u0010\"\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010#\u001a\u00020\fJ\u0016\u0010$\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u0013R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/tera/scan/main/home/BaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "mViews", "Landroid/util/SparseArray;", "displayImage", "", "viewId", "", "imgUrl", "", "findViewWithId", "T", "resId", "(I)Landroid/view/View;", "setEnable", "enable", "", "setImageRes", "setInvisibleOrNot", "invisible", "setOnClickListener", "clickListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "view", "setOnClickListeners", "viewIds", "", "setSelected", "selected", "setText", "txt", "setVisibleOrGone", "visible", "app-main_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class BaseViewHolder extends RecyclerView.ViewHolder {
    @NotNull
    public final SparseArray<View> qw = new SparseArray<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
    }

    public static final void ad(Function1 function1, View view) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(view);
    }

    public static final void qw(Function1 function1, View view) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(view);
    }

    public final void displayImage(int i2, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "imgUrl");
        ImageView imageView = (ImageView) findViewWithId(i2);
        if (imageView != null) {
            ad.mmm(imageView.getContext()).vvv(str).m317switch(imageView);
        }
    }

    @Nullable
    public final <T extends View> T findViewWithId(int i2) {
        T t = (View) this.qw.get(i2);
        if (t == null) {
            t = this.itemView.findViewById(i2);
            this.qw.put(i2, t);
        }
        if (t instanceof View) {
            return t;
        }
        return null;
    }

    public final void setEnable(int i2, boolean z) {
        View findViewWithId = findViewWithId(i2);
        if (findViewWithId != null) {
            findViewWithId.setEnabled(z);
        }
    }

    public final void setImageRes(int i2, int i3) {
        ImageView imageView = (ImageView) findViewWithId(i2);
        if (imageView != null) {
            imageView.setImageResource(i3);
        }
    }

    public final void setInvisibleOrNot(int i2, boolean z) {
        View findViewWithId = findViewWithId(i2);
        if (findViewWithId != null) {
            qw.de(findViewWithId, z);
        }
    }

    public final void setOnClickListener(int i2, @NotNull Function1<? super View, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "clickListener");
        View findViewWithId = findViewWithId(i2);
        if (findViewWithId != null) {
            findViewWithId.setOnClickListener(new Cif(function1));
        }
    }

    public final void setOnClickListeners(@NotNull int[] iArr, @NotNull Function1<? super View, Unit> function1) {
        Intrinsics.checkNotNullParameter(iArr, "viewIds");
        Intrinsics.checkNotNullParameter(function1, "clickListener");
        for (int findViewWithId : iArr) {
            View findViewWithId2 = findViewWithId(findViewWithId);
            if (findViewWithId2 != null) {
                findViewWithId2.setOnClickListener(new when(function1));
            }
        }
    }

    public final void setSelected(int i2, boolean z) {
        View findViewWithId = findViewWithId(i2);
        if (findViewWithId != null) {
            findViewWithId.setSelected(z);
        }
    }

    public final void setText(int i2, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, DocumentOpenUtil.TXT);
        TextView textView = (TextView) findViewWithId(i2);
        if (textView != null) {
            textView.setText(str);
        }
    }

    public final void setVisibleOrGone(int i2, boolean z) {
        View findViewWithId = findViewWithId(i2);
        if (findViewWithId != null) {
            findViewWithId.setVisibility(z ? 0 : 8);
        }
    }

    public final void setText(int i2, int i3) {
        TextView textView = (TextView) findViewWithId(i2);
        if (textView != null) {
            textView.setText(i3);
        }
    }
}
