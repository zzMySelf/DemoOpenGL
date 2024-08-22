package com.facebook.imagepipeline.filter;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import com.baidu.talos.core.render.bindingx.internal.BindingXConstants;
import com.facebook.common.internal.Preconditions;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/facebook/imagepipeline/filter/XferRoundFilter;", "", "()V", "xferRoundBitmap", "", "output", "Landroid/graphics/Bitmap;", "source", "enableAntiAliasing", "", "imagepipeline_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: XferRoundFilter.kt */
public final class XferRoundFilter {
    public static final XferRoundFilter INSTANCE = new XferRoundFilter();

    private XferRoundFilter() {
    }

    @JvmStatic
    public static final void xferRoundBitmap(Bitmap output, Bitmap source, boolean enableAntiAliasing) {
        Paint circlePaint;
        Paint xfermodePaint;
        Intrinsics.checkNotNullParameter(output, BindingXConstants.KEY_INTERPOLATER_OUTPUT);
        Intrinsics.checkNotNullParameter(source, "source");
        Preconditions.checkNotNull(source);
        Preconditions.checkNotNull(output);
        output.setHasAlpha(true);
        if (enableAntiAliasing) {
            circlePaint = new Paint(1);
            xfermodePaint = new Paint(1);
        } else {
            circlePaint = new Paint();
            xfermodePaint = new Paint();
        }
        circlePaint.setColor(-16777216);
        xfermodePaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        float xCenter = ((float) source.getWidth()) / 2.0f;
        float yCenter = ((float) source.getHeight()) / 2.0f;
        Canvas $this$xferRoundBitmap_u24lambda_u2d0 = new Canvas(output);
        $this$xferRoundBitmap_u24lambda_u2d0.drawCircle(xCenter, yCenter, Math.min(xCenter, yCenter), circlePaint);
        $this$xferRoundBitmap_u24lambda_u2d0.drawBitmap(source, 0.0f, 0.0f, xfermodePaint);
    }
}
