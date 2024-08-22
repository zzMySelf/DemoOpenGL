package com.baidu.swan.apps.toast;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.searchbox.story.NovelConstant;
import com.baidu.swan.apps.toast.UniversalToast;
import com.baidu.swan.apps.ui.R;

public class ToastCustom {
    public static final int CLICKABLE_TOAST_SHOW_TIME = 3;
    public static final int NORMAL_TOAST_SHOW_TIME = 2;
    private static final String TAG = "ToastCustom";
    /* access modifiers changed from: private */
    public Runnable mCancelRunnable = new Runnable() {
        public void run() {
            if (ToastCustom.this.mView != null) {
                if (ToastCustom.this.mView.getParent() != null) {
                    ToastCustom.this.mWM.removeView(ToastCustom.this.mView);
                    if (ToastCustom.this.onDismissListener != null) {
                        ToastCustom.this.onDismissListener.onDismiss();
                        UniversalToast.OnDismissListener unused = ToastCustom.this.onDismissListener = null;
                    }
                }
                View unused2 = ToastCustom.this.mView = null;
            }
            if (ToastCustom.this.mMaskView != null) {
                if (ToastCustom.this.mMaskView.getParent() != null) {
                    ToastCustom.this.mWM.removeView(ToastCustom.this.mMaskView);
                }
                View unused3 = ToastCustom.this.mMaskView = null;
            }
        }
    };
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public volatile int mDuration;
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public boolean mIsDebug;
    /* access modifiers changed from: private */
    public boolean mMask;
    /* access modifiers changed from: private */
    public View mMaskView;
    /* access modifiers changed from: private */
    public View mNextMaskView;
    /* access modifiers changed from: private */
    public View mNextView;
    private Runnable mShowRunnable;
    /* access modifiers changed from: private */
    public View mView;
    /* access modifiers changed from: private */
    public WindowManager mWM;
    /* access modifiers changed from: private */
    public WindowManager.LayoutParams mWinParams;
    /* access modifiers changed from: private */
    public UniversalToast.OnDismissListener onDismissListener;

    public ToastCustom(Context context) {
        this.mContext = context;
        this.mWM = (WindowManager) context.getSystemService("window");
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.mWinParams = layoutParams;
        layoutParams.height = -2;
        this.mWinParams.width = -2;
        this.mWinParams.format = -3;
        this.mWinParams.windowAnimations = R.style.toast_animation;
        this.mWinParams.type = 2005;
        this.mWinParams.setTitle("Toast");
        this.mWinParams.flags = NovelConstant.CONTANT_24_7;
        this.mWinParams.gravity = 81;
        this.mWinParams.y = -30;
        this.mDuration = 2;
        this.mIsDebug = false;
    }

    public static ToastCustom makeText(Context context, CharSequence text, int duration) {
        ToastCustom toast = new ToastCustom(context);
        TextView textView = new TextView(context);
        toast.mNextView = textView;
        TextView textView2 = textView;
        textView.setText(text);
        toast.mDuration = duration;
        return toast;
    }

    public void setView(View aView) {
        this.mNextView = aView;
        aView.setClickable(true);
    }

    public void setMask(boolean mask) {
        this.mMask = mask;
    }

    public void setText(CharSequence text) {
        View view2 = this.mNextView;
        if (view2 instanceof TextView) {
            ((TextView) view2).setText(text);
        }
    }

    public void setText(int resId) {
        View view2 = this.mNextView;
        if (view2 instanceof TextView) {
            ((TextView) view2).setText(resId);
        }
    }

    public void setDuration(int durationSecond) {
        this.mDuration = durationSecond > 0 ? durationSecond : 2;
    }

    public void setMargin(float horizontalMargin, float verticalMargin) {
        WindowManager.LayoutParams layoutParams = this.mWinParams;
        if (layoutParams != null) {
            layoutParams.verticalMargin = verticalMargin;
            this.mWinParams.horizontalMargin = horizontalMargin;
        }
    }

    public void setWindowParams(WindowManager.LayoutParams params) {
        this.mWinParams = params;
    }

    public void setWindowAnimation(int animation) {
        WindowManager.LayoutParams layoutParams = this.mWinParams;
        if (layoutParams != null) {
            layoutParams.windowAnimations = animation;
        }
    }

    public void setWindowType(int type) {
        WindowManager.LayoutParams layoutParams = this.mWinParams;
        if (layoutParams != null) {
            layoutParams.type = type;
        }
    }

    public void setGravity(int gravity, int xOffset, int yOffset) {
        WindowManager.LayoutParams layoutParams = this.mWinParams;
        if (layoutParams != null) {
            layoutParams.gravity = gravity;
            this.mWinParams.x = xOffset;
            this.mWinParams.y = yOffset;
        }
    }

    public void setOnClick(final UniversalToast.ToastCallback callback) {
        if (this.mNextView != null) {
            View.OnClickListener listener = new View.OnClickListener() {
                public void onClick(View v) {
                    UniversalToast.ToastCallback toastCallback = callback;
                    if (toastCallback != null) {
                        toastCallback.onToastClick();
                    }
                    ToastCustom.this.cancel();
                }
            };
            this.mNextView.setClickable(true);
            View view2 = this.mNextView.findViewById(R.id.clickable_toast_click_area);
            if (view2 != null) {
                view2.setOnClickListener(listener);
            } else {
                this.mNextView.setOnClickListener(listener);
            }
        }
    }

    public void show() {
        Runnable runnable = this.mShowRunnable;
        if (runnable != null) {
            this.mHandler.removeCallbacks(runnable);
        }
        AnonymousClass3 r0 = new Runnable() {
            public void run() {
                try {
                    if (ToastCustom.this.mMask) {
                        if (ToastCustom.this.mMaskView != null && (ToastCustom.this.mMaskView.getParent() instanceof ViewGroup)) {
                            ((ViewGroup) ToastCustom.this.mMaskView.getParent()).removeView(ToastCustom.this.mMaskView);
                        }
                        WindowManager.LayoutParams maskParams = ToastCustom.this.createMaskParams();
                        View unused = ToastCustom.this.mNextMaskView = new FrameLayout(ToastCustom.this.mContext);
                        ToastCustom.this.mNextMaskView.setClickable(true);
                        ToastCustom.this.mWM.addView(ToastCustom.this.mNextMaskView, maskParams);
                        ToastCustom toastCustom = ToastCustom.this;
                        View unused2 = toastCustom.mMaskView = toastCustom.mNextMaskView;
                    }
                    if (ToastCustom.this.mNextView != null && (ToastCustom.this.mNextView.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) ToastCustom.this.mNextView.getParent()).removeView(ToastCustom.this.mNextView);
                    }
                    ToastCustom.this.mWM.addView(ToastCustom.this.mNextView, ToastCustom.this.mWinParams);
                    ToastCustom toastCustom2 = ToastCustom.this;
                    View unused3 = toastCustom2.mView = toastCustom2.mNextView;
                    ToastCustom.this.mHandler.postDelayed(ToastCustom.this.mCancelRunnable, (long) (ToastCustom.this.mDuration * 1000));
                    if (ToastCustom.this.mIsDebug) {
                        Log.d(ToastCustom.TAG, "add mView");
                    }
                } catch (Throwable e2) {
                    if (ToastCustom.this.mIsDebug) {
                        Log.d(ToastCustom.TAG, "add View to WM failed!!");
                        throw e2;
                    }
                }
            }
        };
        this.mShowRunnable = r0;
        this.mHandler.post(r0);
    }

    public void cancel() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.post(new Runnable() {
                public void run() {
                    try {
                        if (ToastCustom.this.mView != null) {
                            if (ToastCustom.this.mView.getParent() != null) {
                                ToastCustom.this.mWM.removeViewImmediate(ToastCustom.this.mView);
                            }
                            if (ToastCustom.this.onDismissListener != null) {
                                ToastCustom.this.onDismissListener.onDismiss();
                                UniversalToast.OnDismissListener unused = ToastCustom.this.onDismissListener = null;
                            }
                            if (ToastCustom.this.mIsDebug) {
                                Log.d(ToastCustom.TAG, "remove mView");
                            }
                            View unused2 = ToastCustom.this.mView = null;
                        }
                        if (ToastCustom.this.mMaskView != null) {
                            if (ToastCustom.this.mMaskView.getParent() != null) {
                                ToastCustom.this.mWM.removeViewImmediate(ToastCustom.this.mMaskView);
                            }
                            if (ToastCustom.this.mIsDebug) {
                                Log.d(ToastCustom.TAG, "remove mMaskView");
                            }
                            View unused3 = ToastCustom.this.mMaskView = null;
                        }
                    } catch (Throwable e2) {
                        if (ToastCustom.this.mIsDebug) {
                            Log.d(ToastCustom.TAG, "remove View from WM failed!!");
                            throw e2;
                        }
                    }
                }
            });
            this.mHandler.removeCallbacks(this.mCancelRunnable);
            if (this.mIsDebug) {
                Log.d(TAG, "cancel");
            }
        }
    }

    public void setOnDissmissListener(UniversalToast.OnDismissListener onDismissListener2) {
        this.onDismissListener = onDismissListener2;
    }

    /* access modifiers changed from: private */
    public WindowManager.LayoutParams createMaskParams() {
        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        params.width = -1;
        params.height = -1;
        params.verticalMargin = (float) UniversalToast.getSwanAppStatusBarAndActionBarHeight(this.mContext);
        params.flags = 2176;
        params.type = 2005;
        return params;
    }

    public boolean isShow() {
        View view2 = this.mView;
        return (view2 == null || view2.getParent() == null) ? false : true;
    }
}
