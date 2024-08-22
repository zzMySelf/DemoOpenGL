package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.transition.Transition;

public interface Target<R> extends LifecycleListener {
    void ad(@Nullable Drawable drawable);

    void de(@Nullable Drawable drawable);

    void fe(@NonNull SizeReadyCallback sizeReadyCallback);

    @Nullable
    Request getRequest();

    void qw(@Nullable Drawable drawable);

    void rg(@NonNull R r, @Nullable Transition<? super R> transition);

    void th(@Nullable Request request);

    void yj(@NonNull SizeReadyCallback sizeReadyCallback);
}
