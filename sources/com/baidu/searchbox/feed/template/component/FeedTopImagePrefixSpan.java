package com.baidu.searchbox.feed.template.component;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.style.ReplacementSpan;
import android.widget.TextView;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.core.R;
import com.baidu.searchbox.ui.util.PorterDuffModeHelper;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJR\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\"H\u0016J4\u0010#\u001a\u00020\t2\u0006\u0010!\u001a\u00020\"2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\u0015H\u0002J\b\u0010'\u001a\u00020(H\u0002R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/baidu/searchbox/feed/template/component/FeedTopImagePrefixSpan;", "Landroid/text/style/ReplacementSpan;", "context", "Landroid/content/Context;", "textView", "Landroid/widget/TextView;", "url", "", "imageWidth", "", "(Landroid/content/Context;Landroid/widget/TextView;Ljava/lang/String;I)V", "colorFilter", "Ljava/lang/Integer;", "height", "marginRight", "placeHolderBg", "Landroid/graphics/drawable/Drawable;", "placeHolderWidth", "prefixDrawable", "width", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "end", "x", "", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "getSize", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "requestPrefixImageIfNeed", "shouldDecorate", "", "lib-feed-template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedTopImagePrefixSpan.kt */
public final class FeedTopImagePrefixSpan extends ReplacementSpan {
    private Integer colorFilter;
    /* access modifiers changed from: private */
    public final Context context;
    private final int height;
    private final int marginRight;
    private final Drawable placeHolderBg;
    private int placeHolderWidth = FeedRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.dimens_27dp);
    /* access modifiers changed from: private */
    public Drawable prefixDrawable;
    /* access modifiers changed from: private */
    public final TextView textView;
    private final String url;
    private final int width;

    public FeedTopImagePrefixSpan(Context context2, TextView textView2, String url2, int imageWidth) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(url2, "url");
        this.context = context2;
        this.textView = textView2;
        this.url = url2;
        Drawable drawable = context2.getResources().getDrawable(com.baidu.searchbox.feed.template.R.drawable.feed_title_image_top_prefix_placeholder);
        Intrinsics.checkNotNullExpressionValue(drawable, "context.resources.getDra…e_top_prefix_placeholder)");
        this.placeHolderBg = drawable;
        this.width = DeviceUtil.ScreenInfo.dp2px(context2, (float) imageWidth);
        this.height = context2.getResources().getDimensionPixelSize(R.dimen.dimens_15dp);
        this.marginRight = context2.getResources().getDimensionPixelSize(R.dimen.feed_template_new_m15);
        requestPrefixImageIfNeed();
    }

    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        if (fm != null) {
            fm.ascent = -this.height;
        }
        if (fm != null) {
            fm.descent = 0;
        }
        if (fm != null) {
            fm.top = fm.ascent;
        }
        if (fm != null) {
            fm.bottom = 0;
        }
        if (this.prefixDrawable == null) {
            return this.placeHolderWidth + this.marginRight;
        }
        return this.width + this.marginRight;
    }

    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        Canvas canvas2 = canvas;
        float f2 = x;
        Intrinsics.checkNotNullParameter(canvas2, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Paint.FontMetrics metrics = paint.getFontMetrics();
        float textHeight = metrics.descent - metrics.ascent;
        Drawable drawable = this.prefixDrawable;
        if (drawable == null) {
            drawable = this.placeHolderBg;
        }
        float borderStartY = ((float) y) + metrics.ascent + ((textHeight - ((float) this.height)) / ((float) 2));
        Rect imageBounds = new Rect((int) f2, (int) borderStartY, this.width, (int) (((float) this.height) + borderStartY));
        if (drawable != null) {
            drawable.setBounds(imageBounds);
        }
        if (shouldDecorate()) {
            PorterDuffModeHelper.decorateSrcATopMode(this.context, this.placeHolderBg);
            Drawable drawable2 = this.prefixDrawable;
            if (drawable2 != null) {
                PorterDuffModeHelper.decorateSrcATopMode(this.context, drawable2);
            }
        }
        if (this.prefixDrawable == null && drawable != null) {
            drawable.setBounds(new Rect((int) f2, (int) borderStartY, this.placeHolderWidth, (int) (((float) this.height) + borderStartY)));
        }
        if (drawable != null) {
            drawable.draw(canvas2);
        }
    }

    private final void requestPrefixImageIfNeed() {
        if (this.prefixDrawable == null && this.textView != null) {
            Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(Uri.parse(this.url)).build(), this.context).subscribe(new FeedTopImagePrefixSpan$requestPrefixImageIfNeed$1(this), UiThreadImmediateExecutorService.getInstance());
        }
    }

    private final boolean shouldDecorate() {
        Integer num = this.colorFilter;
        return num == null || num.intValue() != PorterDuffModeHelper.getUiCoverLayerColor(this.context);
    }
}
