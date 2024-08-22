package com.baidu.apollon.statusbar;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;

public class ImmersiveKeyboardAdjust {
    public ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener;
    public int usableHeightPrevious;

    /* access modifiers changed from: private */
    public int computeUsableHeight(View view) {
        if (view == null) {
            return 0;
        }
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public void attachActivity(final View view) {
        if (view != null) {
            if (this.globalLayoutListener == null) {
                this.globalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
                    public void onGlobalLayout() {
                        View view;
                        int access$000 = ImmersiveKeyboardAdjust.this.computeUsableHeight(view);
                        if (access$000 != ImmersiveKeyboardAdjust.this.usableHeightPrevious && (view = view) != null) {
                            view.getLayoutParams().height = access$000;
                            view.requestLayout();
                            int unused = ImmersiveKeyboardAdjust.this.usableHeightPrevious = access$000;
                        }
                    }
                };
            }
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnGlobalLayoutListener(this.globalLayoutListener);
            }
        }
    }

    public void detachActivity(View view) {
        if (view != null) {
            if (view != null) {
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                if (!(this.globalLayoutListener == null || viewTreeObserver == null || !viewTreeObserver.isAlive())) {
                    if (Build.VERSION.SDK_INT >= 16) {
                        viewTreeObserver.removeOnGlobalLayoutListener(this.globalLayoutListener);
                    } else {
                        viewTreeObserver.removeGlobalOnLayoutListener(this.globalLayoutListener);
                    }
                }
            }
            this.globalLayoutListener = null;
            this.usableHeightPrevious = 0;
        }
    }
}
