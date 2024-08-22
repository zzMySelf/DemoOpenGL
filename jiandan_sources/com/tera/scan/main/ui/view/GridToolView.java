package com.tera.scan.main.ui.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.aiscan.R;
import fe.mmm.qw.n.qw;
import fe.rg.qw.rg;
import fe.rg.qw.when.ad;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0012H\u0007J\u000e\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0012J\u000e\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0012R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/tera/scan/main/ui/view/GridToolView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "iconImage", "Landroid/widget/ImageView;", "mButtonClickCtrl", "Lcom/tera/scan/widget/ButtonClickCtrlUtil;", "titleView", "Landroid/widget/TextView;", "setIcon", "", "url", "", "setIconUrl", "", "setJumpUrl", "title", "setTitle", "app-main_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GridToolView extends RelativeLayout {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    public final ImageView iconImage;
    @NotNull
    public final qw mButtonClickCtrl;
    @NotNull
    public final TextView titleView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GridToolView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mButtonClickCtrl = new qw();
        Object systemService = context.getSystemService("layout_inflater");
        if (systemService != null) {
            View inflate = ((LayoutInflater) systemService).inflate(R.layout.home_grid_item_view, this);
            View findViewById = inflate.findViewById(R.id.iv_tool_ic);
            if (findViewById != null) {
                this.iconImage = (ImageView) findViewById;
                View findViewById2 = inflate.findViewById(R.id.tv_tool_title);
                Intrinsics.checkNotNullExpressionValue(findViewById2, "inflate.findViewById(R.id.tv_tool_title)");
                this.titleView = (TextView) findViewById2;
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.LayoutInflater");
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

    public final void setIcon(int i2) {
        this.iconImage.setImageResource(i2);
    }

    @SuppressLint({"RestrictedApi"})
    public final void setIconUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        ad v = new ad().w(R.drawable.background_gc9).o(R.drawable.background_gc9).pf(R.drawable.background_gc9).v(this.iconImage.getWidth(), this.iconImage.getHeight());
        Intrinsics.checkNotNullExpressionValue(v, "RequestOptions().placeho….width, iconImage.height)");
        rg<Drawable> vvv = fe.rg.qw.ad.mmm(getContext()).vvv(str);
        vvv.de(v);
        vvv.m317switch(this.iconImage);
    }

    public final void setJumpUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
    }

    public final void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.titleView.setText(str);
    }
}
