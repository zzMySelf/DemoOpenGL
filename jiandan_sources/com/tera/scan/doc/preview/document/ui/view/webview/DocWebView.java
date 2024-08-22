package com.tera.scan.doc.preview.document.ui.view.webview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import androidx.core.view.GestureDetectorCompat;
import com.mars.kotlin.extension.Tag;
import com.tera.scan.doc.preview.document.ui.view.widget.IWebViewBackCallback;
import com.tera.scan.doc.preview.document.ui.view.widget.IWebViewScaleCallback;
import com.tera.scan.webview.TeraScanWebView;
import fe.mmm.qw.p030switch.th.ad.qw.ad;
import fe.mmm.qw.yj.de;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u0001:\u0001%B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0003J\u0018\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0006\u0010 \u001a\u00020\u001bJ\u0010\u0010!\u001a\u00020\u001b2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0012\u0010\"\u001a\u00020\u001b2\b\u0010#\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010$\u001a\u00020\u001b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0018\u00010\u000eR\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/tera/scan/doc/preview/document/ui/view/webview/DocWebView;", "Lcom/tera/scan/webview/TeraScanWebView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "callback", "Lcom/tera/scan/doc/preview/document/ui/view/widget/IWebViewBackCallback;", "clickHandler", "Lcom/tera/scan/doc/preview/document/ui/view/webview/DocWebView$ClickHandler;", "detector", "Landroidx/core/view/GestureDetectorCompat;", "isIgnoreTouch", "", "onClickListener", "Landroid/view/View$OnClickListener;", "scaleCallback", "Lcom/tera/scan/doc/preview/document/ui/view/widget/IWebViewScaleCallback;", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "init", "", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "removeClickEvent", "setBackCallback", "setOnClickListener", "l", "setScaleCallback", "ClickHandler", "preview-document_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Tag("DocWebView")
public final class DocWebView extends TeraScanWebView {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Nullable
    public IWebViewBackCallback callback;
    @Nullable
    public qw clickHandler;
    @Nullable
    public GestureDetectorCompat detector;
    public boolean isIgnoreTouch;
    @Nullable
    public View.OnClickListener onClickListener;
    @Nullable
    public IWebViewScaleCallback scaleCallback;

    public final class qw extends ad<DocWebView> {
        public qw(@Nullable DocWebView docWebView) {
            super(docWebView, Looper.getMainLooper());
        }

        /* renamed from: ad */
        public void qw(@NotNull DocWebView docWebView, @NotNull Message message) {
            View.OnClickListener access$getOnClickListener$p;
            Intrinsics.checkNotNullParameter(docWebView, "reference");
            Intrinsics.checkNotNullParameter(message, "msg");
            if (message.what == 0 && (access$getOnClickListener$p = docWebView.onClickListener) != null) {
                access$getOnClickListener$p.onClick(docWebView);
            }
        }
    }

    public DocWebView(@Nullable Context context) {
        super(context);
        init();
    }

    @SuppressLint({"ObsoleteSdkInt"})
    private final void init() {
        this.clickHandler = new qw(this);
        this.detector = new GestureDetectorCompat(getContext(), new DocWebView$init$1(this));
        if (de.ppp().fe("fe_web_view_debug_switch", false) && Build.VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public boolean dispatchTouchEvent(@NotNull MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "ev");
        if (this.isIgnoreTouch) {
            return super.dispatchTouchEvent(motionEvent);
        }
        GestureDetectorCompat gestureDetectorCompat = this.detector;
        if (gestureDetectorCompat != null) {
            gestureDetectorCompat.onTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean onKeyDown(int i2, @NotNull KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, NotificationCompat.CATEGORY_EVENT);
        IWebViewBackCallback iWebViewBackCallback = this.callback;
        if (iWebViewBackCallback != null) {
            return iWebViewBackCallback.qw(i2, keyEvent);
        }
        return super.onKeyDown(i2, keyEvent);
    }

    public final void removeClickEvent() {
        qw qwVar = this.clickHandler;
        if (qwVar != null) {
            qwVar.removeMessages(0);
        }
    }

    public final void setBackCallback(@Nullable IWebViewBackCallback iWebViewBackCallback) {
        this.callback = iWebViewBackCallback;
    }

    public void setOnClickListener(@Nullable View.OnClickListener onClickListener2) {
        this.onClickListener = onClickListener2;
    }

    public final void setScaleCallback(@Nullable IWebViewScaleCallback iWebViewScaleCallback) {
        this.scaleCallback = iWebViewScaleCallback;
    }

    public DocWebView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public DocWebView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init();
    }
}
