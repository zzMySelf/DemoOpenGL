package com.baidu.sapi2.utils;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.baidu.sapi2.NoProguard;
import java.io.PrintStream;

public class SoftKeyBoardListener implements NoProguard {
    public View a;
    public int b;
    public OnSoftKeyBoardChangeListener c;

    public interface OnSoftKeyBoardChangeListener extends NoProguard {
        void keyBoardHide(int i2);

        void keyBoardShow(int i2);
    }

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        public void onGlobalLayout() {
            Rect rect = new Rect();
            SoftKeyBoardListener.this.a.getWindowVisibleDisplayFrame(rect);
            int height = rect.height();
            PrintStream printStream = System.out;
            printStream.println("" + height);
            SoftKeyBoardListener softKeyBoardListener = SoftKeyBoardListener.this;
            int i2 = softKeyBoardListener.b;
            if (i2 == 0) {
                softKeyBoardListener.b = height;
            } else if (i2 != height) {
                if (i2 - height > 200) {
                    if (softKeyBoardListener.c != null) {
                        SoftKeyBoardListener.this.c.keyBoardShow(SoftKeyBoardListener.this.b - height);
                    }
                    SoftKeyBoardListener.this.b = height;
                } else if (height - i2 > 200) {
                    if (softKeyBoardListener.c != null) {
                        SoftKeyBoardListener.this.c.keyBoardHide(height - SoftKeyBoardListener.this.b);
                    }
                    SoftKeyBoardListener.this.b = height;
                }
            }
        }
    }

    public SoftKeyBoardListener(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        this.a = decorView;
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    public static void setListener(Activity activity, OnSoftKeyBoardChangeListener onSoftKeyBoardChangeListener) {
        new SoftKeyBoardListener(activity).a(onSoftKeyBoardChangeListener);
    }

    private void a(OnSoftKeyBoardChangeListener onSoftKeyBoardChangeListener) {
        this.c = onSoftKeyBoardChangeListener;
    }
}
