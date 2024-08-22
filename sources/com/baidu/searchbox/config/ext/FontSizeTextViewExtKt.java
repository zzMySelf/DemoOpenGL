package com.baidu.searchbox.config.ext;

import android.widget.TextView;
import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.searchbox.config.FontSizeHelper;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\u001a(\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u0007\u001a0\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u0007\u001a*\u0010\t\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u0007¨\u0006\u000b"}, d2 = {"setScaledSize", "", "Landroid/widget/TextView;", "type", "", "size", "", "numRoundPolicy", "unit", "setScaledSizeRes", "resId", "lib-fontsize_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: FontSizeTextViewExt.kt */
public final class FontSizeTextViewExtKt {
    @StableApi
    public static final void setScaledSize(TextView textView, int i2, float f2) {
        setScaledSize$default(textView, i2, f2, 0, 4, (Object) null);
    }

    @StableApi
    public static final void setScaledSize(TextView textView, int i2, int i3, float f2) {
        setScaledSize$default(textView, i2, i3, f2, 0, 8, (Object) null);
    }

    @StableApi
    public static final void setScaledSizeRes(TextView textView, int i2, int i3) {
        setScaledSizeRes$default(textView, i2, i3, 0, 4, (Object) null);
    }

    public static /* synthetic */ void setScaledSize$default(TextView textView, int i2, float f2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i3 = 2;
        }
        setScaledSize(textView, i2, f2, i3);
    }

    @StableApi
    public static final void setScaledSize(TextView $this$setScaledSize, int type, float size, int numRoundPolicy) {
        if ($this$setScaledSize != null) {
            $this$setScaledSize.setTextSize((float) FontSizeHelper.getScaledSize(type, size, numRoundPolicy));
        }
    }

    public static /* synthetic */ void setScaledSize$default(TextView textView, int i2, int i3, float f2, int i4, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            i4 = 2;
        }
        setScaledSize(textView, i2, i3, f2, i4);
    }

    @StableApi
    public static final void setScaledSize(TextView $this$setScaledSize, int type, int unit, float size, int numRoundPolicy) {
        if ($this$setScaledSize != null) {
            $this$setScaledSize.setTextSize(unit, (float) FontSizeHelper.getScaledSize(type, size, numRoundPolicy));
        }
    }

    public static /* synthetic */ void setScaledSizeRes$default(TextView textView, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            i4 = 2;
        }
        setScaledSizeRes(textView, i2, i3, i4);
    }

    @StableApi
    public static final void setScaledSizeRes(TextView $this$setScaledSizeRes, int type, int resId, int numRoundPolicy) {
        if ($this$setScaledSizeRes != null) {
            $this$setScaledSizeRes.setTextSize(0, (float) FontSizeHelper.getScaledSizeRes(type, resId, numRoundPolicy));
        }
    }
}
