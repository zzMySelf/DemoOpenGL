package com.tera.scan.doc.preview.document.ui.view.webview;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.tera.scan.doc.preview.document.ui.view.webview.DocWebView;
import com.tera.scan.doc.preview.document.ui.view.widget.IWebViewScaleCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/tera/scan/doc/preview/document/ui/view/webview/DocWebView$init$1", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "onDoubleTap", "", "e", "Landroid/view/MotionEvent;", "onDown", "onSingleTapConfirmed", "preview-document_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DocWebView$init$1 extends GestureDetector.SimpleOnGestureListener {
    public final /* synthetic */ DocWebView this$0;

    public DocWebView$init$1(DocWebView docWebView) {
        this.this$0 = docWebView;
    }

    public boolean onDoubleTap(@NotNull MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "e");
        IWebViewScaleCallback access$getScaleCallback$p = this.this$0.scaleCallback;
        if (access$getScaleCallback$p == null) {
            return true;
        }
        access$getScaleCallback$p.ad();
        return true;
    }

    public boolean onDown(@NotNull MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "e");
        return true;
    }

    public boolean onSingleTapConfirmed(@NotNull MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "e");
        DocWebView.qw access$getClickHandler$p = this.this$0.clickHandler;
        if (access$getClickHandler$p != null) {
            access$getClickHandler$p.sendEmptyMessageDelayed(0, 100);
        }
        return super.onSingleTapConfirmed(motionEvent);
    }
}
