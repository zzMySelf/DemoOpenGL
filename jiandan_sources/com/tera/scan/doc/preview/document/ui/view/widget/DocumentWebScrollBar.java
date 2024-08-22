package com.tera.scan.doc.preview.document.ui.view.widget;

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
import com.baidu.aiscan.R;
import fe.p013if.ad.qw.p015switch.fe;

public class DocumentWebScrollBar extends RelativeLayout {
    public static final int HANDLE_SHORT = 47;
    public float currentPos;
    public RelativeLayout mContainer;
    public Handler mHandler;
    public Runnable mHidePageScrollerRunnable;
    public ScrollBarListener mListener;
    public View mRoot;
    public fe.mmm.qw.o.qw.qw.ad.qw mStaticUtils;
    public ImageView mThumb;
    public float relativeHandlerMiddle;

    public interface ScrollBarListener {
        void qw(float f);
    }

    public class ad implements View.OnTouchListener {
        public ad() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        DocumentWebScrollBar.this.setPosition((motionEvent.getRawY() - DocumentWebScrollBar.this.currentPos) + DocumentWebScrollBar.this.relativeHandlerMiddle);
                        if (DocumentWebScrollBar.this.mListener != null) {
                            DocumentWebScrollBar.this.mListener.qw(DocumentWebScrollBar.this.relativeHandlerMiddle / ((float) DocumentWebScrollBar.this.getHeight()));
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
                DocumentWebScrollBar.this.hideDelayed();
                if (DocumentWebScrollBar.this.mStaticUtils != null) {
                    DocumentWebScrollBar.this.mStaticUtils.th();
                }
                return true;
            }
            DocumentWebScrollBar.this.mHandler.removeCallbacks(DocumentWebScrollBar.this.mHidePageScrollerRunnable);
            float unused = DocumentWebScrollBar.this.currentPos = motionEvent.getRawY() - DocumentWebScrollBar.this.getY();
            return true;
        }
    }

    public class qw implements Runnable {
        public qw() {
        }

        public void run() {
            DocumentWebScrollBar.this.hide();
        }
    }

    public DocumentWebScrollBar(Context context) {
        this(context, (AttributeSet) null);
    }

    private void calculateMiddle() {
        this.relativeHandlerMiddle = ((getY() + this.relativeHandlerMiddle) / ((float) this.mContainer.getHeight())) * ((float) getHeight());
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.widget_document_web_scroll_bar, this, true);
        this.mRoot = inflate;
        ImageView imageView = (ImageView) inflate.findViewById(R.id.thumb);
        this.mThumb = imageView;
        imageView.setOnTouchListener(new ad());
        setVisibility(4);
    }

    /* access modifiers changed from: private */
    public void setPosition(float f) {
        if (!Float.isInfinite(f) && !Float.isNaN(f)) {
            float height = (float) this.mContainer.getHeight();
            float f2 = f - this.relativeHandlerMiddle;
            if (f2 < 0.0f) {
                f2 = 0.0f;
            } else if (f2 > height - ((float) fe.qw(getContext(), 47))) {
                f2 = height - ((float) fe.qw(getContext(), 47));
            }
            setY(f2);
            calculateMiddle();
            invalidate();
        }
    }

    public void destroyLayout() {
        this.mContainer.removeView(this);
    }

    public void hide() {
        setVisibility(4);
    }

    public void hideDelayed() {
        this.mHandler.removeCallbacks(this.mHidePageScrollerRunnable);
        this.mHandler.postDelayed(this.mHidePageScrollerRunnable, 1000);
    }

    public void setListener(ScrollBarListener scrollBarListener) {
        this.mListener = scrollBarListener;
    }

    public void setScroll(float f) {
        if (!shown()) {
            show();
        } else {
            this.mHandler.removeCallbacks(this.mHidePageScrollerRunnable);
        }
        setPosition(((float) this.mContainer.getHeight()) * f);
        hideDelayed();
    }

    public void setStaticUtils(fe.mmm.qw.o.qw.qw.ad.qw qwVar) {
        this.mStaticUtils = qwVar;
    }

    public void setupLayout(RelativeLayout relativeLayout) {
        this.mContainer = relativeLayout;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        layoutParams.addRule(11);
        this.mContainer.addView(this, layoutParams);
    }

    public void show() {
        setVisibility(0);
    }

    public boolean shown() {
        return getVisibility() == 0;
    }

    public DocumentWebScrollBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DocumentWebScrollBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.relativeHandlerMiddle = 0.0f;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mHidePageScrollerRunnable = new qw();
        init();
    }
}
