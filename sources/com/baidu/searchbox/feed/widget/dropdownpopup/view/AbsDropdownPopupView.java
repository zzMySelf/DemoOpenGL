package com.baidu.searchbox.feed.widget.dropdownpopup.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.baidu.chatsearch.aisearch.resultpage.toolbar.discovery.span.RhetoricalTagUtilKt;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.widget.dropdownpopup.FeedDropdownItemInfo;
import com.baidu.searchbox.feed.widget.dropdownpopup.FeedDropdownPopViewBuilder;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public abstract class AbsDropdownPopupView extends PopupWindow implements FeedDropdownPopViewBuilder.IPopView {
    protected static final boolean DEBUG = FeedRuntime.GLOBAL_DEBUG;
    private static final int MASK_COLOR = 1442840576;
    protected static final String TAG = "AbsDropdownPopupView";
    protected final WeakReference<Context> mContextRef;
    private final Runnable mDismissAction = new Runnable() {
        public void run() {
            AbsDropdownPopupView.super.dismiss();
        }
    };
    /* access modifiers changed from: private */
    public PopupWindow.OnDismissListener mDismissListener;
    private final Handler mHandler = new Handler();
    boolean mIgnoreTabBar = false;
    ArrayList<FeedDropdownItemInfo> mInfoList;
    /* access modifiers changed from: private */
    public boolean mIsDisMissing = false;
    private FrameLayout mMaskView;

    public abstract int getGravity();

    public abstract int getX();

    public abstract int getY();

    public abstract View onCreateContentView(View view2, LayoutInflater layoutInflater);

    /* access modifiers changed from: protected */
    public abstract Animation prepareAnimation(boolean z);

    AbsDropdownPopupView(Context context) {
        super(context);
        this.mContextRef = new WeakReference<>(context);
        init();
    }

    public void show(View anchor) {
        this.mIsDisMissing = false;
        assembleContentView(anchor);
        toggleWindow(true);
    }

    public void setOnPopupDismissListener(PopupWindow.OnDismissListener listener) {
        this.mDismissListener = listener;
    }

    /* access modifiers changed from: protected */
    public void init() {
        setWidth(-1);
        setHeight(-2);
        setFocusable(true);
        setBackgroundDrawable(new ColorDrawable(0));
        setOutsideTouchable(true);
        setOnDismissListener(new PopupWindow.OnDismissListener() {
            public void onDismiss() {
                if (AbsDropdownPopupView.this.mDismissListener != null) {
                    AbsDropdownPopupView.this.mDismissListener.onDismiss();
                }
                AbsDropdownPopupView.this.toggleWindow(false);
            }
        });
    }

    private void assembleContentView(View anchor) {
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
            showAtLocation(anchor, getGravity(), getX(), getY());
            Animation anim = prepareAnimation(true);
            if (!(anim == null || getContentView() == null)) {
                getContentView().clearAnimation();
                getContentView().startAnimation(anim);
            }
            contentView.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    if (event == null || event.getAction() != 0 || !AbsDropdownPopupView.this.isShowing() || AbsDropdownPopupView.this.mIsDisMissing) {
                        return false;
                    }
                    boolean unused = AbsDropdownPopupView.this.mIsDisMissing = true;
                    AbsDropdownPopupView.this.dismiss();
                    return false;
                }
            });
        } else if (DEBUG) {
            throw new RuntimeException("AbsDropdownPopupViewContext is Null when generating content view");
        }
    }

    public void dismiss() {
        if (isShowing()) {
            Animation anim = prepareAnimation(false);
            if (anim == null || getContentView() == null) {
                dismissImmediately();
                return;
            }
            anim.setAnimationListener(new ExitAnimListener(this));
            getContentView().clearAnimation();
            getContentView().startAnimation(anim);
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

    /* access modifiers changed from: private */
    public void toggleWindow(boolean dark) {
        Context context = (Context) this.mContextRef.get();
        if (context != null && (context instanceof Activity)) {
            if (this.mMaskView == null) {
                FrameLayout frameLayout = new FrameLayout(context);
                this.mMaskView = frameLayout;
                frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                this.mMaskView.setBackgroundColor(MASK_COLOR);
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

    private static class ExitAnimListener implements Animation.AnimationListener {
        final WeakReference<AbsDropdownPopupView> mPopWin;

        ExitAnimListener(AbsDropdownPopupView win) {
            this.mPopWin = new WeakReference<>(win);
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            AbsDropdownPopupView win = (AbsDropdownPopupView) this.mPopWin.get();
            if (win != null) {
                win.dismissImmediately();
            }
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }
}
