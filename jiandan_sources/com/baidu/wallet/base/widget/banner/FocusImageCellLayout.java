package com.baidu.wallet.base.widget.banner;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.apollon.base.widget.NetImageView;

public class FocusImageCellLayout extends RelativeLayout {
    public NetImageView a;

    public interface FocusImageEvent {
        void submitPage(int i2);
    }

    public FocusImageCellLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    private void a(Context context) {
        b(context);
    }

    private void b(Context context) {
        NetImageView netImageView = new NetImageView(context);
        this.a = netImageView;
        netImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.a, new RelativeLayout.LayoutParams(-1, -1));
    }

    public NetImageView getFocusView() {
        return this.a;
    }

    public void updateImage(int i2) {
        this.a.setBackgroundResource(i2);
    }

    public FocusImageCellLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void updateImage(Drawable drawable) {
        this.a.setImageDrawable(drawable);
    }

    public FocusImageCellLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }
}
