package com.tera.scan.business.textrecognition;

import android.view.animation.TranslateAnimation;
import androidx.appcompat.widget.TooltipCompatHandler;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/view/animation/TranslateAnimation;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TextRecognitionActivity$scanlineAnimation$2 extends Lambda implements Function0<TranslateAnimation> {
    public static final TextRecognitionActivity$scanlineAnimation$2 INSTANCE = new TextRecognitionActivity$scanlineAnimation$2();

    public TextRecognitionActivity$scanlineAnimation$2() {
        super(0);
    }

    @NotNull
    public final TranslateAnimation invoke() {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, -0.3f, 2, 0.25f);
        translateAnimation.setDuration(TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS);
        translateAnimation.setRepeatCount(-1);
        translateAnimation.setRepeatMode(1);
        return translateAnimation;
    }
}
