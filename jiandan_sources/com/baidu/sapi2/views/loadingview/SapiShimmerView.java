package com.baidu.sapi2.views.loadingview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.aiscan.R;
import com.baidu.sapi2.views.loadingview.ShimmerFrameLayout;

public class SapiShimmerView extends ShimmerFrameLayout implements a<SapiShimmerView> {
    public static final int v = 0;
    public static final int w = 1;
    public ImageView t;
    public int u;

    public SapiShimmerView(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    private void h() {
        int i2 = this.u;
        if (i2 == 0) {
            this.t.setImageDrawable(getResources().getDrawable(R.drawable.sapi_sdk_loading_shimmer_black));
            setMaskShape(ShimmerFrameLayout.MaskShape.LINEAR);
        } else if (i2 == 1) {
            this.t.setImageDrawable(getResources().getDrawable(R.drawable.sapi_sdk_loading_shimmer_white));
            setMaskShape(ShimmerFrameLayout.MaskShape.WHITE_LINEAR);
        }
    }

    public void a(Context context) {
        this.t = new ImageView(context);
        this.t.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        addView(this.t);
    }

    public void dismiss() {
        setVisibility(8);
    }

    public void g() {
        h();
    }

    public SapiShimmerView getLoadingView() {
        return this;
    }

    public void setType(int i2) {
        this.u = i2;
        h();
    }

    public SapiShimmerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SapiShimmerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    public void a() {
        setVisibility(0);
    }
}
