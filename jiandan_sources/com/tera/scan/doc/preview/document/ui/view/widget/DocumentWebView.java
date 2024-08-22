package com.tera.scan.doc.preview.document.ui.view.widget;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import androidx.core.view.GestureDetectorCompat;
import com.tera.scan.doc.preview.document.ui.view.widget.DocumentWebScrollBar;

public class DocumentWebView extends WebView {
    public static final String TAG = "DocumentWebView";
    public IWebViewBackCallback mCallback;
    public de mClickHandler;
    public GestureDetectorCompat mDetector;
    public boolean mIgnoreTouch = false;
    public View.OnClickListener mOnClickListener;
    public IWebViewScaleCallback mScaleCallback;
    public DocumentWebScrollBar mScrollBar;

    public class ad implements DocumentWebScrollBar.ScrollBarListener {
        public ad() {
        }

        public void qw(float f) {
            DocumentWebView.this.scrollTo(DocumentWebView.this.getScrollX(), (int) (((float) DocumentWebView.this.getContentHeight()) * DocumentWebView.this.getScale() * f));
        }
    }

    public static class de extends fe.mmm.qw.p030switch.th.ad.qw.ad<DocumentWebView> {
        public de(DocumentWebView documentWebView) {
            super(documentWebView, Looper.getMainLooper());
        }

        /* renamed from: ad */
        public void qw(DocumentWebView documentWebView, Message message) {
            if (message.what == 0 && documentWebView.mOnClickListener != null) {
                documentWebView.mOnClickListener.onClick(documentWebView);
            }
        }
    }

    public class qw extends GestureDetector.SimpleOnGestureListener {
        public qw() {
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            IWebViewScaleCallback iWebViewScaleCallback = DocumentWebView.this.mScaleCallback;
            if (iWebViewScaleCallback == null) {
                return true;
            }
            iWebViewScaleCallback.ad();
            return true;
        }

        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (DocumentWebView.this.mOnClickListener != null) {
                DocumentWebView.this.mClickHandler.sendEmptyMessageDelayed(0, 100);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    public DocumentWebView(Context context) {
        super(context);
        init();
    }

    private float calcProgress(float f, float f2) {
        return Math.max(0.0f, Math.min(1.0f, f / f2));
    }

    private void init() {
        this.mClickHandler = new de(this);
        this.mDetector = new GestureDetectorCompat(getContext(), new qw());
        clearCache(false);
        setVerticalScrollBarEnabled(false);
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        settings.setAllowFileAccess(true);
        settings.setAllowFileAccessFromFileURLs(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        if (fe.mmm.qw.yj.de.ppp().fe("fe_web_view_debug_switch", false) && Build.VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        DocumentWebScrollBar documentWebScrollBar;
        if (isIgnoreTouch()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        this.mDetector.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if ((action == 1 || action == 3 || action == 6) && (documentWebScrollBar = this.mScrollBar) != null) {
            documentWebScrollBar.hideDelayed();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean isIgnoreTouch() {
        return this.mIgnoreTouch;
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        IWebViewBackCallback iWebViewBackCallback = this.mCallback;
        if (iWebViewBackCallback != null) {
            return iWebViewBackCallback.qw(i2, keyEvent);
        }
        return super.onKeyDown(i2, keyEvent);
    }

    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        if (this.mScrollBar != null) {
            float contentHeight = (((float) getContentHeight()) * getScale()) - ((float) getHeight());
            if (contentHeight > 0.0f) {
                this.mScrollBar.setScroll(calcProgress(((float) i3) * 1.0f, contentHeight));
            } else {
                this.mScrollBar.setScroll(0.0f);
            }
        }
    }

    public void removeClickEvent() {
        this.mClickHandler.removeMessages(0);
    }

    public void setBackCallback(IWebViewBackCallback iWebViewBackCallback) {
        this.mCallback = iWebViewBackCallback;
    }

    public void setIgnoreTouch(boolean z) {
        this.mIgnoreTouch = z;
    }

    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setScaleCallback(IWebViewScaleCallback iWebViewScaleCallback) {
        this.mScaleCallback = iWebViewScaleCallback;
    }

    public void setScrollBar(DocumentWebScrollBar documentWebScrollBar) {
        this.mScrollBar = documentWebScrollBar;
        documentWebScrollBar.setListener(new ad());
    }

    public DocumentWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public DocumentWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init();
    }
}
