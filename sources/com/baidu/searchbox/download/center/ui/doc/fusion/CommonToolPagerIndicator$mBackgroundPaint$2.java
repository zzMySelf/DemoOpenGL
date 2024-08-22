package com.baidu.searchbox.download.center.ui.doc.fusion;

import android.graphics.Paint;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/graphics/Paint;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommonToolPagerIndicator.kt */
final class CommonToolPagerIndicator$mBackgroundPaint$2 extends Lambda implements Function0<Paint> {
    public static final CommonToolPagerIndicator$mBackgroundPaint$2 INSTANCE = new CommonToolPagerIndicator$mBackgroundPaint$2();

    CommonToolPagerIndicator$mBackgroundPaint$2() {
        super(0);
    }

    public final Paint invoke() {
        Paint mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
        return mPaint;
    }
}
