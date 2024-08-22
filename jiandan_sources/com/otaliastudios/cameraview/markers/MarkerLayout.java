package com.otaliastudios.cameraview.markers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;

public class MarkerLayout extends FrameLayout {
    public static final int TYPE_AUTOFOCUS = 1;
    @SuppressLint({"UseSparseArrays"})
    public final HashMap<Integer, View> mViews = new HashMap<>();

    public MarkerLayout(@NonNull Context context) {
        super(context);
    }

    public void onEvent(int i2, @NonNull PointF[] pointFArr) {
        View view = this.mViews.get(Integer.valueOf(i2));
        if (view != null) {
            view.clearAnimation();
            if (i2 == 1) {
                PointF pointF = pointFArr[0];
                view.setTranslationX((float) ((int) (pointF.x - ((float) (view.getWidth() / 2)))));
                view.setTranslationY((float) ((int) (pointF.y - ((float) (view.getHeight() / 2)))));
            }
        }
    }

    public void onMarker(int i2, @Nullable Marker marker) {
        View ad2;
        View view = this.mViews.get(Integer.valueOf(i2));
        if (view != null) {
            removeView(view);
        }
        if (marker != null && (ad2 = marker.ad(getContext(), this)) != null) {
            this.mViews.put(Integer.valueOf(i2), ad2);
            addView(ad2);
        }
    }
}
