package com.baidu.searchbox.video.videoplayer.ui.loading;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;

public class BdVideoLoadingView extends AppCompatImageView {
    private static final String TAG = "BdVideoLoadingView";
    private LoadingAnimationListener mLoadingAnimListener;
    private BdVideoLoadingDrawable mLoadingDrawable;

    public interface LoadingAnimationListener {
        void onStartAnimation();

        void onStopAnimation();
    }

    public BdVideoLoadingView(Context context) {
        super(context);
        init(context);
    }

    public BdVideoLoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        setLoadingRenderer(new BdVideoRotationLoadingRender(context));
    }

    public void setLoadingRenderer(BdVideoLoadingRender loadingRenderer) {
        BdVideoLoadingDrawable bdVideoLoadingDrawable = new BdVideoLoadingDrawable(loadingRenderer);
        this.mLoadingDrawable = bdVideoLoadingDrawable;
        setImageDrawable(bdVideoLoadingDrawable);
    }

    public void startAnimation() {
        BdVideoLoadingDrawable bdVideoLoadingDrawable = this.mLoadingDrawable;
        if (bdVideoLoadingDrawable != null) {
            bdVideoLoadingDrawable.start();
            LoadingAnimationListener loadingAnimationListener = this.mLoadingAnimListener;
            if (loadingAnimationListener != null) {
                loadingAnimationListener.onStartAnimation();
            }
        }
    }

    public void stopAnimation() {
        BdVideoLoadingDrawable bdVideoLoadingDrawable = this.mLoadingDrawable;
        if (bdVideoLoadingDrawable != null) {
            bdVideoLoadingDrawable.stop();
            LoadingAnimationListener loadingAnimationListener = this.mLoadingAnimListener;
            if (loadingAnimationListener != null) {
                loadingAnimationListener.onStopAnimation();
            }
        }
    }

    public boolean isRunning() {
        return this.mLoadingDrawable.isRunning();
    }

    public void setLoadingAnimListener(LoadingAnimationListener listener) {
        this.mLoadingAnimListener = listener;
    }

    public void removeLoadingAnimListener() {
        this.mLoadingAnimListener = null;
    }
}
