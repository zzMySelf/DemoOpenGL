package com.tera.scan.scanner.ocr.extension;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import fe.mmm.qw.tt.ad.ggg.qw;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ImageViewKt$animateToDoneView$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ View $doneView;
    public final /* synthetic */ Function0<Unit> $onFinish;
    public final /* synthetic */ ImageView $this_animateToDoneView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageViewKt$animateToDoneView$1(ImageView imageView, View view, Function0<Unit> function0) {
        super(0);
        this.$this_animateToDoneView = imageView;
        this.$doneView = view;
        this.$onFinish = function0;
    }

    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m908invoke$lambda0(Rect rect, Rect rect2, ImageView imageView, Function0 function0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(rect, "$rect");
        Intrinsics.checkNotNullParameter(rect2, "$tRect");
        Intrinsics.checkNotNullParameter(valueAnimator, "value");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            float floatValue = ((Float) animatedValue).floatValue();
            float width = ((float) rect.width()) - (((float) (rect.width() - rect2.width())) * floatValue);
            float height = ((float) rect.height()) - (((float) (rect.height() - rect2.height())) * floatValue);
            int i2 = rect2.left;
            float f = 1.0f - floatValue;
            int i3 = i2 - ((int) (((float) (i2 - rect.left)) * f));
            int i4 = rect2.top;
            int i5 = i4 - ((int) (((float) (i4 - rect.top)) * f));
            imageView.layout(i3, i5, ((int) width) + i3, ((int) height) + i5);
            if (floatValue == 1.0f) {
                imageView.setVisibility(4);
                ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                layoutParams.width = rect.right - rect.left;
                layoutParams.height = rect.bottom - rect.top;
                imageView.setLayoutParams(layoutParams);
                imageView.setImageDrawable((Drawable) null);
                if (function0 != null) {
                    function0.invoke();
                    return;
                }
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }

    public final void invoke() {
        ImageView imageView = this.$this_animateToDoneView;
        if (imageView != null) {
            Rect rect = new Rect();
            imageView.getGlobalVisibleRect(rect);
            imageView.setVisibility(0);
            this.$doneView.setVisibility(0);
            Rect rect2 = new Rect();
            this.$doneView.getGlobalVisibleRect(rect2);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            ofFloat.setDuration(500);
            ofFloat.addUpdateListener(new qw(rect, rect2, imageView, this.$onFinish));
            ofFloat.start();
        }
    }
}
