package com.otaliastudios.cameraview.markers;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public interface Marker {
    @Nullable
    View ad(@NonNull Context context, @NonNull ViewGroup viewGroup);
}
