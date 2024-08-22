package com.baidu.talos.core.render.layoutanimation;

import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.baidu.talos.core.common.MapBuilder;
import com.baidu.talos.core.data.ParamMap;
import java.util.Map;
import javax.annotation.Nullable;

abstract class AbstractLayoutAnimation {
    private static final String EXCEPTION_CLASS_NAME = "AbstractLayoutAnimation";
    private static final Map<InterpolatorType, Interpolator> INTERPOLATOR = MapBuilder.of(InterpolatorType.LINEAR, new LinearInterpolator(), InterpolatorType.EASE_IN, new AccelerateInterpolator(), InterpolatorType.EASE_OUT, new DecelerateInterpolator(), InterpolatorType.EASE_IN_EASE_OUT, new AccelerateDecelerateInterpolator(), InterpolatorType.SPRING, new SimpleSpringInterpolator());
    private static final boolean SLOWDOWN_ANIMATION_MODE = false;
    @Nullable
    protected AnimatedPropertyType mAnimatedProperty;
    private int mDelayMs;
    protected int mDurationMs;
    @Nullable
    private Interpolator mInterpolator;

    /* access modifiers changed from: package-private */
    @Nullable
    public abstract Animation createAnimationImpl(View view2, int i2, int i3, int i4, int i5);

    /* access modifiers changed from: package-private */
    public abstract boolean isValid();

    AbstractLayoutAnimation() {
    }

    public void reset() {
        this.mAnimatedProperty = null;
        this.mDurationMs = 0;
        this.mDelayMs = 0;
        this.mInterpolator = null;
    }

    public void initializeFromConfig(ParamMap data, int globalDuration) {
        this.mAnimatedProperty = data.hasKey("property") ? AnimatedPropertyType.fromString(data.getString("property")) : null;
        this.mDurationMs = data.hasKey("duration") ? data.getInteger("duration") : globalDuration;
        this.mDelayMs = data.hasKey("delay") ? data.getInteger("delay") : 0;
        if (!data.hasKey("type")) {
            Log.e(EXCEPTION_CLASS_NAME, "Missing interpolation type.");
            return;
        }
        this.mInterpolator = getInterpolator(InterpolatorType.fromString(data.getString("type")));
        if (!isValid()) {
            Log.e(EXCEPTION_CLASS_NAME, "Invalid layout animation : " + data);
        }
    }

    @Nullable
    public final Animation createAnimation(View view2, int x, int y, int width, int height) {
        if (!isValid()) {
            return null;
        }
        Animation animation = createAnimationImpl(view2, x, y, width, height);
        if (animation != null) {
            animation.setDuration((long) (this.mDurationMs * 1));
            animation.setStartOffset((long) (this.mDelayMs * 1));
            Interpolator interpolator = this.mInterpolator;
            if (interpolator != null) {
                animation.setInterpolator(interpolator);
            }
        }
        return animation;
    }

    private static Interpolator getInterpolator(InterpolatorType type) {
        return INTERPOLATOR.get(type);
    }
}
