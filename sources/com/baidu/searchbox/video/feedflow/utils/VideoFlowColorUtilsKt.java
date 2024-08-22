package com.baidu.searchbox.video.feedflow.utils;

import android.graphics.Color;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0002¨\u0006\u0006"}, d2 = {"getCurrentColor", "", "fraction", "", "startColor", "endColor", "lib-flow-component_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoFlowColorUtils.kt */
public final class VideoFlowColorUtilsKt {
    private static final int getCurrentColor(float fraction, int startColor, int endColor) {
        int i2 = startColor;
        int i3 = endColor;
        if (i2 == i3 || fraction <= 0.0f) {
            return i2;
        }
        if (fraction >= 1.0f) {
            return i3;
        }
        int redStart = Color.red(startColor);
        int blueStart = Color.blue(startColor);
        int greenStart = Color.green(startColor);
        int alphaStart = Color.alpha(startColor);
        int redEnd = Color.red(endColor);
        int blueEnd = Color.blue(endColor);
        int greenDifference = Color.green(endColor) - greenStart;
        int greenCurrent = (int) (((float) greenStart) + (((float) greenDifference) * fraction));
        int i4 = greenDifference;
        return Color.argb((int) (((float) alphaStart) + (((float) (Color.alpha(endColor) - alphaStart)) * fraction)), (int) (((float) redStart) + (((float) (redEnd - redStart)) * fraction)), greenCurrent, (int) (((float) blueStart) + (((float) (blueEnd - blueStart)) * fraction)));
    }
}
