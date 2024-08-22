package com.tera.scan.doc.preview.document.ui.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.webkit.WebSettings;

public class ExcelWebView extends DocumentWebView {
    public ScaleGestureDetector mScaleGestureDetector;

    public class qw implements ScaleGestureDetector.OnScaleGestureListener {
        public qw() {
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            fe.mmm.qw.i.qw.ad("ExcelWebView", "scale onScale scaleFactor:" + scaleFactor);
            ExcelWebView.this.zoomBy(scaleFactor);
            return true;
        }

        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            IWebViewScaleCallback iWebViewScaleCallback = ExcelWebView.this.mScaleCallback;
            if (iWebViewScaleCallback == null) {
                return true;
            }
            iWebViewScaleCallback.qw();
            return true;
        }

        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            IWebViewScaleCallback iWebViewScaleCallback = ExcelWebView.this.mScaleCallback;
            if (iWebViewScaleCallback != null) {
                iWebViewScaleCallback.de();
            }
        }
    }

    public ExcelWebView(Context context) {
        super(context);
        initSettings();
    }

    private void initSettings() {
        WebSettings settings = getSettings();
        settings.setSupportZoom(false);
        settings.setBuiltInZoomControls(false);
        this.mScaleGestureDetector = new ScaleGestureDetector(getContext(), new qw());
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.mScaleGestureDetector.onTouchEvent(motionEvent);
        return super.onTouchEvent(motionEvent);
    }

    public void zoomBy(float f) {
        try {
            super.zoomBy(f);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public ExcelWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initSettings();
    }

    public ExcelWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        initSettings();
    }
}
