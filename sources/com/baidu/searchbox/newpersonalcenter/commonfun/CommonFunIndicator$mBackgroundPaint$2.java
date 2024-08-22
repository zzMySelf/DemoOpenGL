package com.baidu.searchbox.newpersonalcenter.commonfun;

import android.graphics.Paint;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/graphics/Paint;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommonFunIndicator.kt */
final class CommonFunIndicator$mBackgroundPaint$2 extends Lambda implements Function0<Paint> {
    public static final CommonFunIndicator$mBackgroundPaint$2 INSTANCE = new CommonFunIndicator$mBackgroundPaint$2();

    CommonFunIndicator$mBackgroundPaint$2() {
        super(0);
    }

    public final Paint invoke() {
        Paint mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
        return mPaint;
    }
}
