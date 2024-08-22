package com.tera.scan.widget.customrecyclerview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.aiscan.R;

public class AlbumRefreshHeaderView extends RefreshHeaderView {
    public AlbumRefreshHeaderView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    public void initView(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.album_loading_lottie, this);
        this.mHeadView = inflate;
        this.mLayoutlottie = (LinearLayout) inflate.findViewById(R.id.layout_lottie);
        this.mLottieAnimationView = (LottieAnimationView) this.mHeadView.findViewById(R.id.loading_lottie);
        this.mRefreshTip = (TextView) this.mHeadView.findViewById(R.id.refresh_tip);
    }

    public void setBackground(Drawable drawable) {
        this.mLayoutlottie.setBackground(drawable);
    }

    public AlbumRefreshHeaderView(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AlbumRefreshHeaderView(@NonNull Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
