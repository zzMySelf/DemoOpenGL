package com.baidu.searchbox.aisearch.comps.drawable.flowing;

import android.graphics.Color;
import com.baidu.mms.voicesearch.mmsvoicesearchv2.model.notification.NotificationMessageID;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/aisearch/comps/drawable/flowing/Material5;", "Lcom/baidu/searchbox/aisearch/comps/drawable/flowing/BaseMaterial;", "()V", "change", "", "fraction", "", "getEndColor", "", "getStartColor", "lib-aisearch-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Material5.kt */
public final class Material5 extends BaseMaterial {
    public int getStartColor() {
        return Color.parseColor("#5CFDC8E5");
    }

    public int getEndColor() {
        return Color.parseColor("#00FDC8E5");
    }

    public void change(float fraction) {
        boolean z = true;
        if (0.0f <= fraction && fraction <= 0.28f) {
            float frac = fraction / 0.28f;
            float f2 = (float) -363;
            float f3 = (float) 1223;
            float f4 = (float) -441;
            float f5 = (float) NotificationMessageID.MICROPHONE_QUICK_SLIDE_MESSAGE_ID;
            getMatrix().setTranslate((f3 * frac) + f2, (f5 * frac) + f4);
            getMatrix().postScale(1.4f - (frac * 0.4f), 1.4f - (0.4f * frac), f2 + (f3 * frac), f4 + (f5 * frac));
        } else {
            if (0.28f <= fraction && fraction <= 0.72f) {
                float frac2 = (fraction - 0.28f) / 0.44000003f;
                float f6 = (float) 860;
                float f7 = (float) 984;
                float f8 = (float) 1101;
                float f9 = (float) 824;
                getMatrix().setTranslate((f7 * frac2) + f6, f8 - (f9 * frac2));
                getMatrix().postScale((frac2 * 0.2f) + 1.0f, (0.2f * frac2) + 1.0f, f6 + (f7 * frac2), f8 - (f9 * frac2));
            }
        }
        if (0.0f <= fraction && fraction <= 0.067f) {
            setAlpha(Math.min(255, (int) (((float) 255) * (fraction / 0.067f))));
        } else {
            if (0.552f > fraction || fraction > 0.72f) {
                z = false;
            }
            if (z) {
                setAlpha(255 - Math.min(255, (int) (((float) 255) * (fraction / 0.067f))));
            }
        }
        calculatePos();
    }
}
