package com.dxmpay.apollon.statusbar;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;

public class ImmersiveKeyboardAdjust {
    public ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener;
    public int usableHeightPrevious;

    public class qw implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ View f4044ad;

        public qw(View view) {
            this.f4044ad = view;
        }

        public void onGlobalLayout() {
            View view;
            int access$000 = ImmersiveKeyboardAdjust.this.computeUsableHeight(this.f4044ad);
            if (access$000 != ImmersiveKeyboardAdjust.this.usableHeightPrevious && (view = this.f4044ad) != null) {
                view.getLayoutParams().height = access$000;
                this.f4044ad.requestLayout();
                int unused = ImmersiveKeyboardAdjust.this.usableHeightPrevious = access$000;
            }
        }
    }

    /* access modifiers changed from: private */
    public int computeUsableHeight(View view) {
        if (view == null) {
            return 0;
        }
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public void attachActivity(View view) {
        if (view != null) {
            if (this.globalLayoutListener == null) {
                this.globalLayoutListener = new qw(view);
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
