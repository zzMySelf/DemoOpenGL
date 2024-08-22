package com.tera.scan.vip.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.aiscan.R;
import com.tera.scan.ui.view.widget.UITextView;
import fe.mmm.qw.k.pf.i.de;
import fe.mmm.qw.k.pf.i.fe;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016J\u0014\u0010\u0017\u001a\u00020\u00112\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00110\u0019J\u0014\u0010\u001a\u001a\u00020\u00112\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00110\u0019R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/tera/scan/vip/ui/view/PrivilegeBannerView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "bannerView", "Landroid/view/View;", "closePrivilegeBanner", "Landroid/widget/ImageView;", "freeCountText", "Landroid/widget/TextView;", "openCashierDesk", "Lcom/tera/scan/ui/view/widget/UITextView;", "svipIcon", "setFreeCountText", "", "text", "", "setFreeCountTextRes", "resId", "", "setOnCloseListener", "onClick", "Lkotlin/Function0;", "setOpenCashierDeskListener", "lib_vip_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PrivilegeBannerView extends FrameLayout {
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    @Nullable
    public View bannerView;
    @Nullable
    public ImageView closePrivilegeBanner;
    @Nullable
    public TextView freeCountText;
    @Nullable
    public UITextView openCashierDesk;
    @Nullable
    public ImageView svipIcon;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PrivilegeBannerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        View inflate = LayoutInflater.from(context).inflate(R.layout.privilege_banner_view, this, false);
        addView(inflate, new FrameLayout.LayoutParams(-1, -1));
        if (inflate != null) {
            this.bannerView = inflate.findViewById(R.id.privilege_banner_root);
            this.svipIcon = (ImageView) inflate.findViewById(R.id.privilege_banner_svip_icon);
            this.freeCountText = (TextView) inflate.findViewById(R.id.privilege_banner_free_count_text);
            this.openCashierDesk = (UITextView) inflate.findViewById(R.id.privilege_banner_button_open_cashier_desk);
            this.closePrivilegeBanner = (ImageView) inflate.findViewById(R.id.close_privilege_banner);
        }
    }

    /* renamed from: setOnCloseListener$lambda-2  reason: not valid java name */
    public static final void m946setOnCloseListener$lambda2(Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(function0, "$onClick");
        function0.invoke();
    }

    /* renamed from: setOpenCashierDeskListener$lambda-3  reason: not valid java name */
    public static final void m947setOpenCashierDeskListener$lambda3(Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(function0, "$onClick");
        function0.invoke();
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void setFreeCountText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        TextView textView = this.freeCountText;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public final void setFreeCountTextRes(int i2) {
        try {
            Result.Companion companion = Result.Companion;
            TextView textView = this.freeCountText;
            if (textView != null) {
                textView.setText(getContext().getResources().getString(i2));
            }
            Result.m1155constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
    }

    public final void setOnCloseListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "onClick");
        ImageView imageView = this.closePrivilegeBanner;
        if (imageView != null) {
            imageView.setOnClickListener(new fe(function0));
        }
    }

    public final void setOpenCashierDeskListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "onClick");
        UITextView uITextView = this.openCashierDesk;
        if (uITextView != null) {
            uITextView.setOnClickListener(new de(function0));
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PrivilegeBannerView(Context context, AttributeSet attributeSet, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }
}
