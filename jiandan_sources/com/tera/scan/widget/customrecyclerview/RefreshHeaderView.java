package com.tera.scan.widget.customrecyclerview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.OnCompositionLoadedListener;
import com.baidu.aiscan.R;
import com.tera.scan.widget.PullDownCircleProgressBar;
import fe.qw.qw.de;

public class RefreshHeaderView extends FrameLayout implements RefreshTrigger {
    public static final String TAG = "RefreshHeaderView";
    public PullDownCircleProgressBar mCircleProgress;
    public Context mContext;
    public View mHeadView;
    public int mHeight;
    public String mKeyOfRefreshTime;
    public LinearLayout mLayoutlottie;
    public LottieAnimationView mLottieAnimationView;
    public TextView mRefreshTip;
    public String pullLabel;
    public String refreshingLabel;
    public String releaseLabel;

    public class qw implements OnCompositionLoadedListener {
        public qw() {
        }

        public void qw(de deVar) {
            RefreshHeaderView.this.mLottieAnimationView.setComposition(deVar);
            RefreshHeaderView.this.mLottieAnimationView.playAnimation();
        }
    }

    public RefreshHeaderView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private String getStringByRes(int i2) {
        return getResources().getString(i2);
    }

    private void saveUpdateTime(String str) {
    }

    public TextView getRefreshTip() {
        return this.mRefreshTip;
    }

    public void initView(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.refresh_header_loading, this);
        this.mHeadView = inflate;
        this.mLayoutlottie = (LinearLayout) inflate.findViewById(R.id.layout_lottie);
        this.mLottieAnimationView = (LottieAnimationView) this.mHeadView.findViewById(R.id.loading_lottie);
        this.mRefreshTip = (TextView) this.mHeadView.findViewById(R.id.refresh_tip);
    }

    public void onComplete() {
        this.mLottieAnimationView.setProgress(0.0f);
        this.mLottieAnimationView.cancelAnimation();
    }

    public void onMove(boolean z, boolean z2, int i2) {
        float f = ((float) i2) / ((float) (this.mHeight * 2));
        fe.mmm.qw.i.qw.uk(TAG, " scale = " + f);
        if (f >= 1.0f) {
            f = 1.0f;
        }
        this.mLottieAnimationView.setScale(f);
    }

    public void onRefresh() {
        this.mLottieAnimationView.setScale(1.0f);
    }

    public void onRelease() {
        this.mLottieAnimationView.setScale(1.0f);
    }

    public void onReset() {
        this.mLottieAnimationView.setProgress(0.0f);
        this.mLottieAnimationView.cancelAnimation();
    }

    public void onStart(boolean z, int i2, int i3) {
        this.mHeight = i2;
        de.ad.qw(getContext(), "pullToRefresh.json", new qw());
    }

    public void setBackground(Drawable drawable) {
    }

    public RefreshHeaderView(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RefreshHeaderView(@NonNull Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        initView(context);
    }
}
