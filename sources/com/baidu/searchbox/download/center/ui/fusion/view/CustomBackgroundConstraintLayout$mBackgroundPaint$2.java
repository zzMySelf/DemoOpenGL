package com.baidu.searchbox.download.center.ui.fusion.view;

import android.graphics.Paint;
import androidx.core.content.ContextCompat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.download.center.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/graphics/Paint;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CustomBackgroundConstraintLayout.kt */
final class CustomBackgroundConstraintLayout$mBackgroundPaint$2 extends Lambda implements Function0<Paint> {
    public static final CustomBackgroundConstraintLayout$mBackgroundPaint$2 INSTANCE = new CustomBackgroundConstraintLayout$mBackgroundPaint$2();

    CustomBackgroundConstraintLayout$mBackgroundPaint$2() {
        super(0);
    }

    public final Paint invoke() {
        Paint paint = new Paint();
        Paint $this$invoke_u24lambda_u2d0 = paint;
        $this$invoke_u24lambda_u2d0.setColor(ContextCompat.getColor(AppRuntime.getAppContext(), R.color.BC157));
        $this$invoke_u24lambda_u2d0.setAntiAlias(true);
        return paint;
    }
}
