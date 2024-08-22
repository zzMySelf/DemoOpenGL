package com.dxmbumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.dxmbumptech.glide.manager.LifecycleListener;
import com.dxmbumptech.glide.request.Request;
import com.dxmbumptech.glide.request.transition.Transition;

public interface Target<R> extends LifecycleListener {
    void ad(@Nullable Drawable drawable);

    void de(@Nullable Drawable drawable);

    void fe(@NonNull R r, @Nullable Transition<? super R> transition);

    @Nullable
    Request getRequest();

    void qw(@Nullable Drawable drawable);

    void rg(@NonNull SizeReadyCallback sizeReadyCallback);

    void th(@NonNull SizeReadyCallback sizeReadyCallback);

    void yj(@Nullable Request request);
}
