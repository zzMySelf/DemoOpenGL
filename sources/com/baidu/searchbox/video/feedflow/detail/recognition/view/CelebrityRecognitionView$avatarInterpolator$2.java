package com.baidu.searchbox.video.feedflow.detail.recognition.view;

import android.view.animation.Interpolator;
import androidx.core.view.animation.PathInterpolatorCompat;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/view/animation/Interpolator;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CelebrityRecognitionView.kt */
final class CelebrityRecognitionView$avatarInterpolator$2 extends Lambda implements Function0<Interpolator> {
    public static final CelebrityRecognitionView$avatarInterpolator$2 INSTANCE = new CelebrityRecognitionView$avatarInterpolator$2();

    CelebrityRecognitionView$avatarInterpolator$2() {
        super(0);
    }

    public final Interpolator invoke() {
        return PathInterpolatorCompat.create(0.2f, 0.0f, 0.2f, 1.0f);
    }
}
