package com.tera.scan.doc.preview.pdf.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.aiscan.R;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.ScrollHandle;
import fe.p013if.ad.qw.p015switch.fe;

public class PDFScrollHandle extends RelativeLayout implements ScrollHandle {
    public static final int HANDLE_SHORT = 47;
    public float currentPos;
    public Context mContext;
    public Handler mHandler;
    public Runnable mHidePageScrollerRunnable;
    public TextView mLabel;
    public PDFView mPDFView;
    public boolean mPressed;
    public View mRoot;
    public fe.mmm.qw.o.qw.qw.ad.qw mStaticUtils;
    public ImageView mThumb;
    public float relativeHandlerMiddle;

    public class ad implements View.OnTouchListener {
        public ad() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (!PDFScrollHandle.this.isPDFViewReady()) {
                return false;
            }
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        if (PDFScrollHandle.this.mPDFView.isSwipeVertical()) {
                            PDFScrollHandle.this.setPosition((motionEvent.getRawY() - PDFScrollHandle.this.currentPos) + PDFScrollHandle.this.relativeHandlerMiddle);
                            PDFScrollHandle.this.mPDFView.setPositionOffset(PDFScrollHandle.this.relativeHandlerMiddle / ((float) PDFScrollHandle.this.getHeight()), false);
                        } else {
                            PDFScrollHandle.this.setPosition((motionEvent.getRawX() - PDFScrollHandle.this.currentPos) + PDFScrollHandle.this.relativeHandlerMiddle);
                            PDFScrollHandle.this.mPDFView.setPositionOffset(PDFScrollHandle.this.relativeHandlerMiddle / ((float) PDFScrollHandle.this.getWidth()), false);
                        }
                        return true;
                    } else if (action != 3) {
                        if (action != 5) {
                            if (action != 6) {
                                return false;
                            }
                        }
                    }
                }
                boolean unused = PDFScrollHandle.this.mPressed = false;
                PDFScrollHandle.this.hideDelayed();
                PDFScrollHandle.this.mPDFView.performPageSnap();
                PDFScrollHandle.this.mLabel.setVisibility(4);
                return true;
            }
            PDFScrollHandle.this.mPDFView.stopFling();
            PDFScrollHandle.this.mHandler.removeCallbacks(PDFScrollHandle.this.mHidePageScrollerRunnable);
            if (PDFScrollHandle.this.mPDFView.isSwipeVertical()) {
                float unused2 = PDFScrollHandle.this.currentPos = motionEvent.getRawY() - PDFScrollHandle.this.getY();
            } else {
                float unused3 = PDFScrollHandle.this.currentPos = motionEvent.getRawX() - PDFScrollHandle.this.getX();
            }
            PDFScrollHandle.this.mLabel.setVisibility(0);
            boolean unused4 = PDFScrollHandle.this.mPressed = true;
            return true;
        }
    }

    public class qw implements Runnable {
        public qw() {
        }

        public void run() {
            PDFScrollHandle.this.hide();
        }
    }

    public PDFScrollHandle(Context context) {
        this(context, (AttributeSet) null);
    }

    private void calculateMiddle() {
        int i2;
        float f;
        float f2;
        if (this.mPDFView.isSwipeVertical()) {
            f2 = getY();
            f = (float) getHeight();
            i2 = this.mPDFView.getHeight();
        } else {
            f2 = getX();
            f = (float) getWidth();
            i2 = this.mPDFView.getWidth();
        }
        this.relativeHandlerMiddle = ((f2 + this.relativeHandlerMiddle) / ((float) i2)) * f;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void init() {
        Context context = getContext();
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.widget_pdf_scroll_bar, this, true);
        this.mRoot = inflate;
        this.mThumb = (ImageView) inflate.findViewById(R.id.thumb);
        this.mLabel = (TextView) this.mRoot.findViewById(R.id.label);
        this.mThumb.setOnTouchListener(new ad());
        setVisibility(4);
    }

    /* access modifiers changed from: private */
    public boolean isPDFViewReady() {
        PDFView pDFView = this.mPDFView;
        return pDFView != null && pDFView.getPageCount() > 0 && !this.mPDFView.documentFitsView();
    }

    /* access modifiers changed from: private */
    public void setPosition(float f) {
        if (!Float.isInfinite(f) && !Float.isNaN(f)) {
            PDFView pDFView = this.mPDFView;
            if (pDFView == null || !pDFView.isSwipeVertical()) {
                hide();
                return;
            }
            float height = (float) this.mPDFView.getHeight();
            float f2 = f - this.relativeHandlerMiddle;
            if (f2 < 0.0f) {
                f2 = 0.0f;
            } else if (f2 > height - ((float) fe.qw(this.mContext, 47))) {
                f2 = height - ((float) fe.qw(this.mContext, 47));
            }
            setY(f2);
            calculateMiddle();
            invalidate();
        }
    }

    public void destroyLayout() {
        this.mPDFView.removeView(this);
    }

    public void hide() {
        if (!this.mPressed) {
            setVisibility(4);
        }
    }

    public void hideDelayed() {
        this.mHandler.postDelayed(this.mHidePageScrollerRunnable, 1000);
    }

    public void setPageNum(int i2) {
        if (this.mPDFView != null) {
            TextView textView = this.mLabel;
            textView.setText(i2 + "/" + this.mPDFView.getPageCount());
        }
    }

    public void setScroll(float f) {
        PDFView pDFView = this.mPDFView;
        if (pDFView == null || !pDFView.isSwipeVertical()) {
            hide();
            return;
        }
        if (!shown()) {
            show();
        } else {
            this.mHandler.removeCallbacks(this.mHidePageScrollerRunnable);
        }
        setPosition(((float) this.mPDFView.getHeight()) * f);
    }

    public void setStaticUtils(fe.mmm.qw.o.qw.qw.ad.qw qwVar) {
        this.mStaticUtils = qwVar;
    }

    public void setupLayout(PDFView pDFView) {
        this.mPDFView = pDFView;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        layoutParams.addRule(11);
        this.mPDFView.addView(this, layoutParams);
    }

    public void show() {
        PDFView pDFView = this.mPDFView;
        if (pDFView != null && pDFView.isSwipeVertical()) {
            setVisibility(0);
        }
    }

    public boolean shown() {
        return getVisibility() == 0;
    }

    public PDFScrollHandle(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PDFScrollHandle(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.relativeHandlerMiddle = 0.0f;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mHidePageScrollerRunnable = new qw();
        init();
    }
}
