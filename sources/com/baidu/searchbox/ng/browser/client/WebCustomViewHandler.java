package com.baidu.searchbox.ng.browser.client;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.searchbox.ng.browser.util.ViewOpUtils;
import com.baidu.webkit.sdk.WebChromeClient;

public class WebCustomViewHandler {
    private static final FrameLayout.LayoutParams COVER_SCREEN_PARAMS = new FrameLayout.LayoutParams(-1, -1);
    private Context mContext;
    private View mCustomView;
    private WebChromeClient.CustomViewCallback mCustomViewCallback;
    private FrameLayout mFullscreenContainer;
    private int mOriginalOrientation;
    private int mOriginalSystemUiVisibility;

    public WebCustomViewHandler(Context context) {
        this.mContext = context;
    }

    public void showCustomView(View view2, int requestedOrientation, WebChromeClient.CustomViewCallback callback) {
        Context context = this.mContext;
        Activity activity = null;
        if (context instanceof Activity) {
            activity = (Activity) context;
        }
        if (activity == null) {
            return;
        }
        if (this.mCustomView != null) {
            callback.onCustomViewHidden();
            return;
        }
        this.mOriginalOrientation = activity.getRequestedOrientation();
        FrameLayout decor = (FrameLayout) activity.getWindow().getDecorView();
        FullscreenHolder fullscreenHolder = new FullscreenHolder(activity);
        this.mFullscreenContainer = fullscreenHolder;
        FrameLayout.LayoutParams layoutParams = COVER_SCREEN_PARAMS;
        fullscreenHolder.addView(view2, layoutParams);
        decor.addView(this.mFullscreenContainer, layoutParams);
        this.mCustomView = view2;
        this.mOriginalSystemUiVisibility = decor.getSystemUiVisibility();
        setFullscreen(activity, true);
        this.mCustomViewCallback = callback;
        activity.setRequestedOrientation(requestedOrientation);
        if (requestedOrientation == 0) {
            decor.setSystemUiVisibility(ViewOpUtils.getImmersiveSystemUiVisibility());
        }
    }

    public void hideCustomView() {
        if (this.mCustomView != null) {
            Context context = this.mContext;
            Activity activity = null;
            if (context instanceof Activity) {
                activity = (Activity) context;
            }
            if (activity != null) {
                setFullscreen(activity, false);
                FrameLayout decor = (FrameLayout) activity.getWindow().getDecorView();
                decor.removeView(this.mFullscreenContainer);
                this.mFullscreenContainer = null;
                this.mCustomView = null;
                this.mCustomViewCallback.onCustomViewHidden();
                activity.setRequestedOrientation(this.mOriginalOrientation);
                decor.setSystemUiVisibility(this.mOriginalSystemUiVisibility);
            }
        }
    }

    public boolean isCustomViewShowing() {
        return this.mCustomView != null;
    }

    public void setFullscreen(Activity activity, boolean enabled) {
        activity.getWindow().setFlags(!enabled ? 0 : 1024, 1024);
    }

    static class FullscreenHolder extends FrameLayout {
        public FullscreenHolder(Context ctx) {
            super(ctx);
            setBackgroundColor(ctx.getResources().getColor(17170444));
        }

        public boolean onTouchEvent(MotionEvent evt) {
            return true;
        }
    }
}
