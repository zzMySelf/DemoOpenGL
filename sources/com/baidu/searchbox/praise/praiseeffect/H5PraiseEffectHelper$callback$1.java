package com.baidu.searchbox.praise.praiseeffect;

import android.graphics.Rect;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016¨\u0006\r"}, d2 = {"com/baidu/searchbox/praise/praiseeffect/H5PraiseEffectHelper$callback$1", "Lcom/baidu/searchbox/praise/praiseeffect/PraiseEffectAnimCallback;", "getPraiseViewLocation", "Landroid/graphics/Rect;", "includeExpand", "", "isAnimEnabled", "effectType", "", "effectName", "onPraiseAnimEnd", "", "onPraiseAnimStart", "lib-praise-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: H5PraiseEffectHelper.kt */
public final class H5PraiseEffectHelper$callback$1 implements PraiseEffectAnimCallback {
    final /* synthetic */ H5PraiseEffectHelper this$0;

    H5PraiseEffectHelper$callback$1(H5PraiseEffectHelper $receiver) {
        this.this$0 = $receiver;
    }

    public Rect getPraiseViewLocation(boolean includeExpand) {
        return this.this$0.location;
    }

    public boolean isAnimEnabled(String effectType, String effectName) {
        Intrinsics.checkNotNullParameter(effectType, "effectType");
        return true;
    }

    public void onPraiseAnimStart() {
    }

    public void onPraiseAnimEnd() {
        Function0<Unit> animEndCallback = this.this$0.getAnimEndCallback();
        if (animEndCallback != null) {
            animEndCallback.invoke();
        }
    }
}
