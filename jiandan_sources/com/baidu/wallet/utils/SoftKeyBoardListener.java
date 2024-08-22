package com.baidu.wallet.utils;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.baidu.wallet.core.NoProguard;

public class SoftKeyBoardListener implements NoProguard {
    public OnSoftKeyBoardChangeListener onSoftKeyBoardChangeListener;
    public View rootView;
    public int rootViewVisibleHeight;

    public interface OnSoftKeyBoardChangeListener {
        void keyBoardHide(int i2);

        void keyBoardShow(int i2);
    }

    public SoftKeyBoardListener(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        this.rootView = decorView;
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                Rect rect = new Rect();
                SoftKeyBoardListener.this.rootView.getWindowVisibleDisplayFrame(rect);
                int height = rect.height();
                SoftKeyBoardListener softKeyBoardListener = SoftKeyBoardListener.this;
                int i2 = softKeyBoardListener.rootViewVisibleHeight;
                if (i2 == 0) {
                    softKeyBoardListener.rootViewVisibleHeight = height;
                } else if (i2 != height) {
                    if (i2 - height > 200) {
                        if (softKeyBoardListener.onSoftKeyBoardChangeListener != null) {
                            SoftKeyBoardListener.this.onSoftKeyBoardChangeListener.keyBoardShow(SoftKeyBoardListener.this.rootViewVisibleHeight - height);
                        }
                        SoftKeyBoardListener.this.rootViewVisibleHeight = height;
                    } else if (height - i2 > 200) {
                        if (softKeyBoardListener.onSoftKeyBoardChangeListener != null) {
                            SoftKeyBoardListener.this.onSoftKeyBoardChangeListener.keyBoardHide(height - SoftKeyBoardListener.this.rootViewVisibleHeight);
                        }
                        SoftKeyBoardListener.this.rootViewVisibleHeight = height;
                    }
                }
            }
        });
    }

    public static void setListener(Activity activity, OnSoftKeyBoardChangeListener onSoftKeyBoardChangeListener2) {
        new SoftKeyBoardListener(activity).setOnSoftKeyBoardChangeListener(onSoftKeyBoardChangeListener2);
    }

    private void setOnSoftKeyBoardChangeListener(OnSoftKeyBoardChangeListener onSoftKeyBoardChangeListener2) {
        this.onSoftKeyBoardChangeListener = onSoftKeyBoardChangeListener2;
    }
}
