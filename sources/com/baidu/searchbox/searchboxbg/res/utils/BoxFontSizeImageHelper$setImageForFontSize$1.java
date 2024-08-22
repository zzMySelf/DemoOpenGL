package com.baidu.searchbox.searchboxbg.res.utils;

import android.view.View;
import android.widget.ImageView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JR\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¨\u0006\u000f"}, d2 = {"com/baidu/searchbox/searchboxbg/res/utils/BoxFontSizeImageHelper$setImageForFontSize$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "lib-searchboxbg-res_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BoxFontSizeImageHelper.kt */
public final class BoxFontSizeImageHelper$setImageForFontSize$1 implements View.OnLayoutChangeListener {
    final /* synthetic */ int $base;
    final /* synthetic */ int $dheight;
    final /* synthetic */ int $dwidth;
    final /* synthetic */ ImageView $imageView;
    final /* synthetic */ float $scale;

    BoxFontSizeImageHelper$setImageForFontSize$1(ImageView $imageView2, int $base2, float $scale2, int $dheight2, int $dwidth2) {
        this.$imageView = $imageView2;
        this.$base = $base2;
        this.$scale = $scale2;
        this.$dheight = $dheight2;
        this.$dwidth = $dwidth2;
    }

    public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        if (v != null) {
            BoxFontSizeImageHelper.INSTANCE.setImageMatrix(this.$imageView, this.$base, this.$scale, this.$dheight, this.$dwidth, (v.getWidth() - v.getPaddingLeft()) - this.$imageView.getPaddingRight(), (v.getHeight() - v.getPaddingTop()) - this.$imageView.getPaddingBottom());
            v.removeOnLayoutChangeListener(this);
        }
    }
}
