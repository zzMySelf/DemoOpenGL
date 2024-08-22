package com.baidu.searchbox.home.feed.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.searchbox.home.feedview.R;
import com.baidu.searchbox.kotlinx.ViewExtensionsKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0006\u0010\u0014\u001a\u00020\u0011J\u000e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0006J\u0006\u0010\u0017\u001a\u00020\u0011R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/baidu/searchbox/home/feed/ui/FeedTabDividerLine;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "currentMargin", "", "dividerRect", "Landroid/graphics/Rect;", "initMargin", "getInitMargin", "()I", "needUpdateDivider", "", "paint", "Landroid/graphics/Paint;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "resetDivider", "setDividerMargin", "margin", "updateUi", "lib-feed-home_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedTabDividerLine.kt */
public final class FeedTabDividerLine extends View {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private int currentMargin;
    private Rect dividerRect;
    private final int initMargin;
    private boolean needUpdateDivider;
    private final Paint paint;

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view2 = map.get(Integer.valueOf(i2));
        if (view2 != null) {
            return view2;
        }
        View findViewById = findViewById(i2);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedTabDividerLine(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Paint paint2 = new Paint();
        Paint $this$paint_u24lambda_u2d0 = paint2;
        $this$paint_u24lambda_u2d0.setShader((Shader) null);
        $this$paint_u24lambda_u2d0.setAntiAlias(true);
        this.paint = paint2;
        this.needUpdateDivider = true;
        this.dividerRect = new Rect();
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.feed_tab_bottom_line_margin);
        this.initMargin = dimensionPixelSize;
        this.currentMargin = dimensionPixelSize;
        setLayoutParams(new ViewGroup.MarginLayoutParams(-1, context.getResources().getDimensionPixelSize(com.baidu.searchbox.gamecore.R.dimen.dimen_1px)));
        updateUi();
    }

    public final int getInitMargin() {
        return this.initMargin;
    }

    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.draw(canvas);
        if (this.needUpdateDivider) {
            this.needUpdateDivider = false;
            this.paint.setColor(getResources().getColor(com.baidu.android.common.ui.style.R.color.GC34));
            this.dividerRect = new Rect(this.currentMargin, 0, getMeasuredWidth() - this.currentMargin, getMeasuredHeight());
        }
        canvas.drawRect(this.dividerRect, this.paint);
    }

    public final void updateUi() {
        this.needUpdateDivider = true;
        ViewExtensionsKt.setBackgroundRes(this, com.baidu.android.common.ui.style.R.color.GC9);
    }

    public final void setDividerMargin(int margin) {
        this.needUpdateDivider = true;
        this.currentMargin = margin;
        invalidate();
    }

    public final void resetDivider() {
        setDividerMargin(this.initMargin);
    }
}
