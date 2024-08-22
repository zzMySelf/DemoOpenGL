package com.github.barteksc.pdfviewer.scroll;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.aiscan.R;
import com.github.barteksc.pdfviewer.PDFView;
import fe.p013if.ad.qw.p015switch.fe;

public class DefaultScrollHandle extends RelativeLayout implements ScrollHandle {
    public static final int DEFAULT_TEXT_SIZE = 16;
    public static final int HANDLE_LONG = 65;
    public static final int HANDLE_SHORT = 40;
    public Context context;
    public float currentPos;
    public Handler handler;
    public Runnable hidePageScrollerRunnable;
    public boolean inverted;
    public PDFView pdfView;
    public float relativeHandlerMiddle;
    public TextView textView;

    public class qw implements Runnable {
        public qw() {
        }

        public void run() {
            DefaultScrollHandle.this.hide();
        }
    }

    public DefaultScrollHandle(Context context2) {
        this(context2, false);
    }

    private void calculateMiddle() {
        int i2;
        float f;
        float f2;
        if (this.pdfView.isSwipeVertical()) {
            f2 = getY();
            f = (float) getHeight();
            i2 = this.pdfView.getHeight();
        } else {
            f2 = getX();
            f = (float) getWidth();
            i2 = this.pdfView.getWidth();
        }
        this.relativeHandlerMiddle = ((f2 + this.relativeHandlerMiddle) / ((float) i2)) * f;
    }

    private boolean isPDFViewReady() {
        PDFView pDFView = this.pdfView;
        return pDFView != null && pDFView.getPageCount() > 0 && !this.pdfView.documentFitsView();
    }

    private void setPosition(float f) {
        int i2;
        if (!Float.isInfinite(f) && !Float.isNaN(f)) {
            if (this.pdfView.isSwipeVertical()) {
                i2 = this.pdfView.getHeight();
            } else {
                i2 = this.pdfView.getWidth();
            }
            float f2 = (float) i2;
            float f3 = f - this.relativeHandlerMiddle;
            if (f3 < 0.0f) {
                f3 = 0.0f;
            } else if (f3 > f2 - ((float) fe.qw(this.context, 40))) {
                f3 = f2 - ((float) fe.qw(this.context, 40));
            }
            if (this.pdfView.isSwipeVertical()) {
                setY(f3);
            } else {
                setX(f3);
            }
            calculateMiddle();
            invalidate();
        }
    }

    public void destroyLayout() {
        this.pdfView.removeView(this);
    }

    public void hide() {
        setVisibility(4);
    }

    public void hideDelayed() {
        this.handler.postDelayed(this.hidePageScrollerRunnable, 1000);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isPDFViewReady()) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (this.pdfView.isSwipeVertical()) {
                        setPosition((motionEvent.getRawY() - this.currentPos) + this.relativeHandlerMiddle);
                        this.pdfView.setPositionOffset(this.relativeHandlerMiddle / ((float) getHeight()), false);
                    } else {
                        setPosition((motionEvent.getRawX() - this.currentPos) + this.relativeHandlerMiddle);
                        this.pdfView.setPositionOffset(this.relativeHandlerMiddle / ((float) getWidth()), false);
                    }
                    return true;
                } else if (action != 3) {
                    if (action != 5) {
                        if (action != 6) {
                            return super.onTouchEvent(motionEvent);
                        }
                    }
                }
            }
            hideDelayed();
            this.pdfView.performPageSnap();
            return true;
        }
        this.pdfView.stopFling();
        this.handler.removeCallbacks(this.hidePageScrollerRunnable);
        if (this.pdfView.isSwipeVertical()) {
            this.currentPos = motionEvent.getRawY() - getY();
        } else {
            this.currentPos = motionEvent.getRawX() - getX();
        }
        return true;
    }

    public void setPageNum(int i2) {
        String valueOf = String.valueOf(i2);
        if (!this.textView.getText().equals(valueOf)) {
            this.textView.setText(valueOf);
        }
    }

    public void setScroll(float f) {
        if (!shown()) {
            show();
        } else {
            this.handler.removeCallbacks(this.hidePageScrollerRunnable);
        }
        PDFView pDFView = this.pdfView;
        if (pDFView != null) {
            setPosition(((float) (pDFView.isSwipeVertical() ? this.pdfView.getHeight() : this.pdfView.getWidth())) * f);
        }
    }

    public void setTextColor(int i2) {
        this.textView.setTextColor(i2);
    }

    public void setTextSize(int i2) {
        this.textView.setTextSize(1, (float) i2);
    }

    public void setupLayout(PDFView pDFView) {
        Drawable drawable;
        int i2;
        int i3 = 65;
        int i4 = 40;
        if (!pDFView.isSwipeVertical()) {
            if (this.inverted) {
                i2 = 10;
                drawable = this.context.getResources().getDrawable(R.drawable.default_scroll_handle_top);
            } else {
                i2 = 12;
                drawable = this.context.getResources().getDrawable(R.drawable.default_scroll_handle_bottom);
            }
            i3 = 40;
            i4 = 65;
        } else if (this.inverted) {
            i2 = 9;
            drawable = this.context.getResources().getDrawable(R.drawable.default_scroll_handle_left);
        } else {
            i2 = 11;
            drawable = this.context.getResources().getDrawable(R.drawable.default_scroll_handle_right);
        }
        if (Build.VERSION.SDK_INT < 16) {
            setBackgroundDrawable(drawable);
        } else {
            setBackground(drawable);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(fe.qw(this.context, i3), fe.qw(this.context, i4));
        layoutParams.setMargins(0, 0, 0, 0);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13, -1);
        addView(this.textView, layoutParams2);
        layoutParams.addRule(i2);
        pDFView.addView(this, layoutParams);
        this.pdfView = pDFView;
    }

    public void show() {
        setVisibility(0);
    }

    public boolean shown() {
        return getVisibility() == 0;
    }

    public DefaultScrollHandle(Context context2, boolean z) {
        super(context2);
        this.relativeHandlerMiddle = 0.0f;
        this.handler = new Handler();
        this.hidePageScrollerRunnable = new qw();
        this.context = context2;
        this.inverted = z;
        this.textView = new TextView(context2);
        setVisibility(4);
        setTextColor(-16777216);
        setTextSize(16);
    }
}
