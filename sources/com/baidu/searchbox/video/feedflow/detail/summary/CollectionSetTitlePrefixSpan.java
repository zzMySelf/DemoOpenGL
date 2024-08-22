package com.baidu.searchbox.video.feedflow.detail.summary;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;
import android.text.style.ReplacementSpan;
import android.widget.TextView;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJR\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J4\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\u000fH\u0002J\u0012\u0010!\u001a\u00020\u000f2\b\u0010\"\u001a\u0004\u0018\u00010\nH\u0002J\u0012\u0010#\u001a\u00020\u000f2\b\u0010$\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/summary/CollectionSetTitlePrefixSpan;", "Landroid/text/style/ReplacementSpan;", "context", "Landroid/content/Context;", "prefixIcon", "", "textView", "Landroid/widget/TextView;", "(Landroid/content/Context;Ljava/lang/String;Landroid/widget/TextView;)V", "iconBitmap", "Landroid/graphics/Bitmap;", "prefixIconWidth", "", "rightPadding", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "end", "x", "", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "getSize", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "initData", "initPrefixIcon", "bitmap", "requestPrefixIconIfNeed", "iconUrl", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectionSetTitlePrefixSpan.kt */
public final class CollectionSetTitlePrefixSpan extends ReplacementSpan {
    private Context context;
    /* access modifiers changed from: private */
    public Bitmap iconBitmap;
    private int prefixIconWidth;
    private int rightPadding;
    /* access modifiers changed from: private */
    public TextView textView;

    public CollectionSetTitlePrefixSpan(Context context2, String prefixIcon, TextView textView2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(textView2, "textView");
        this.textView = textView2;
        Context applicationContext = context2.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        this.context = applicationContext;
        initData();
        requestPrefixIconIfNeed(prefixIcon);
    }

    /* access modifiers changed from: private */
    public final void initPrefixIcon(Bitmap bitmap) {
    }

    private final void initData() {
        Resources resources = this.context.getResources();
        this.rightPadding = 0;
        this.prefixIconWidth = 0;
    }

    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        return this.prefixIconWidth + this.rightPadding;
    }

    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        if (this.iconBitmap == null) {
            initPrefixIcon((Bitmap) null);
        }
        Bitmap $this$draw_u24lambda_u2d1 = this.iconBitmap;
        if ($this$draw_u24lambda_u2d1 != null) {
            canvas.drawBitmap($this$draw_u24lambda_u2d1, 0.0f, (float) ($this$draw_u24lambda_u2d1.getHeight() / 8), (Paint) null);
        }
    }

    private final void requestPrefixIconIfNeed(String iconUrl) {
        CharSequence charSequence = iconUrl;
        if (!(charSequence == null || charSequence.length() == 0)) {
            Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(Uri.parse(iconUrl)).build(), (Object) null).subscribe(new CollectionSetTitlePrefixSpan$requestPrefixIconIfNeed$1(this), UiThreadImmediateExecutorService.getInstance());
        }
    }
}
