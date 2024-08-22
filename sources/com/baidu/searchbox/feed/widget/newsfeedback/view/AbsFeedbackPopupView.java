package com.baidu.searchbox.feed.widget.newsfeedback.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.android.ext.widget.PopupWindow;
import com.baidu.chatsearch.aisearch.resultpage.toolbar.discovery.span.RhetoricalTagUtilKt;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.widget.newsfeedback.Callback;
import com.baidu.searchbox.feed.widget.newsfeedback.FeedbackPop;
import com.baidu.searchbox.feed.widget.newsfeedback.FeedbackPopViewBuilder;
import java.lang.ref.WeakReference;

public abstract class AbsFeedbackPopupView extends PopupWindow implements FeedbackPopViewBuilder.IPopView {
    private static final float BACK_ALPHA = 0.3f;
    public static final int BLACK_BACKGROUND_COLOR_ALPHA = 76;
    protected static final boolean DEBUG = FeedRuntime.GLOBAL_DEBUG;
    private static final int NO_ALPHA = 255;
    protected static final String TAG = "AbsFeedbackPopupView";
    private View mAnchorView;
    protected Callback mCallback;
    private final WeakReference<Context> mContextRef;
    private final Runnable mDismissAction = new Runnable() {
        public void run() {
            AbsFeedbackPopupView.super.dismiss();
        }
    };
    private FeedbackPop.DismissCallback mDismissCallback;
    private final Handler mHandler = new Handler();
    protected boolean mIgnoreTabBar = false;
    private ViewGroup mMaskView = null;

    public abstract int getGravity();

    public abstract int getHeight();

    public abstract int getX();

    public abstract int getY();

    public abstract View onCreateContentView(View view2, LayoutInflater layoutInflater);

    /* access modifiers changed from: protected */
    public abstract Animation prepareAnimation(boolean z);

    public AbsFeedbackPopupView(Context context) {
        super(context);
        this.mContextRef = new WeakReference<>(context);
    }

    /* access modifiers changed from: protected */
    public Context getContext() {
        return (Context) this.mContextRef.get();
    }

    public void show(View anchor) {
        this.mAnchorView = anchor;
        init();
        try {
            assembleContentView(anchor);
            toggleWindow(true);
        } catch (RuntimeException e2) {
            if (!DEBUG) {
                dismissImmediately();
                return;
            }
            throw new RuntimeException("AbsFeedbackPopupViewError while attempting to show popup.", e2);
        }
    }

    /* access modifiers changed from: protected */
    public View getAnchorView() {
        return this.mAnchorView;
    }

    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    private void init() {
        setWidth(-1);
        setHeight(getHeight());
        setFocusable(true);
        setBackgroundDrawable(new ColorDrawable(0));
        setOutsideTouchable(true);
        setOnDismissListener(new PopupWindow.OnDismissListener() {
            public void onDismiss() {
                AbsFeedbackPopupView.this.toggleWindow(false);
            }
        });
    }

    private void assembleContentView(View anchor) throws RuntimeException {
        View popupParent;
        Context ctx = (Context) this.mContextRef.get();
        if (ctx != null) {
            LayoutInflater inflater = LayoutInflater.from(ctx);
            View contentView = onCreateContentView(anchor, inflater);
            if (contentView == null) {
                if (!DEBUG) {
                    contentView = makeSimpleView(inflater);
                } else {
                    throw new IllegalArgumentException("onCreateContentView method can not return Null");
                }
            }
            setContentView(contentView);
            if (anchor != null) {
                try {
                    if (anchor.getContext() instanceof Activity) {
                        popupParent = ((Activity) anchor.getContext()).getWindow().getDecorView().getRootView();
                    } else {
                        popupParent = anchor;
                    }
                    showAtLocation(popupParent, getGravity(), getX(), getY());
                } catch (Exception e2) {
                    throw new RuntimeException(e2);
                }
            }
        } else {
            throw new RuntimeException("AbsFeedbackPopupViewContext is Null when generating contentView");
        }
    }

    /* access modifiers changed from: protected */
    public void onStartContentViewAnimation(Animation enterAnim) {
        if (enterAnim != null && getContentView() != null) {
            getContentView().clearAnimation();
            getContentView().startAnimation(enterAnim);
        }
    }

    public void dismiss() {
        if (isShowing()) {
            dismissImmediately();
            FeedbackPop.DismissCallback dismissCallback = this.mDismissCallback;
            if (dismissCallback != null) {
                dismissCallback.onDismiss();
            }
        }
    }

    /* access modifiers changed from: private */
    public void dismissImmediately() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.post(this.mDismissAction);
        }
    }

    private LinearLayout makeSimpleView(LayoutInflater inflater) {
        return new LinearLayout(inflater.getContext());
    }

    /* access modifiers changed from: protected */
    public void toggleWindow(boolean dark) {
        Context context = (Context) this.mContextRef.get();
        if (context instanceof Activity) {
            if (this.mMaskView == null) {
                FrameLayout frameLayout = new FrameLayout(context);
                this.mMaskView = frameLayout;
                frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                ColorDrawable colorDrawable = new ColorDrawable(-16777216);
                colorDrawable.setAlpha(76);
                this.mMaskView.setBackground(colorDrawable);
            }
            ViewGroup rootView = (ViewGroup) ((Activity) context).getWindow().getDecorView();
            if (dark) {
                rootView.addView(this.mMaskView);
            } else {
                rootView.removeView(this.mMaskView);
            }
        } else if (!DEBUG) {
        } else {
            if (context == null) {
                Log.e(TAG, "Context may be recycled when calls toggleWindow[dark:" + dark + RhetoricalTagUtilKt.TAG_END_SYMBOL);
            } else {
                Log.e(TAG, "Context is NOT instance of Activity");
            }
        }
    }

    public void applyConfig(FeedbackPop.FeedbackPopParams params) {
    }

    private static class ExitAnimListener implements Animation.AnimationListener {
        final WeakReference<AbsFeedbackPopupView> mPopupRef;

        public ExitAnimListener(AbsFeedbackPopupView win) {
            this.mPopupRef = new WeakReference<>(win);
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            AbsFeedbackPopupView popupView = (AbsFeedbackPopupView) this.mPopupRef.get();
            if (popupView != null) {
                popupView.dismissImmediately();
            }
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    public void setDismissCallback(FeedbackPop.DismissCallback callback) {
        this.mDismissCallback = callback;
    }

    public static int getDimensionPixelSizeById(int id) {
        return FeedRuntime.getAppContext().getResources().getDimensionPixelSize(id);
    }
}
