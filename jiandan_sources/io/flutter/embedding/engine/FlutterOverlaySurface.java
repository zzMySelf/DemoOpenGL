package io.flutter.embedding.engine;

import android.view.Surface;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;

@Keep
public class FlutterOverlaySurface {
    public final int id;
    @NonNull
    public final Surface surface;

    public FlutterOverlaySurface(int i2, @NonNull Surface surface2) {
        this.id = i2;
        this.surface = surface2;
    }

    public int getId() {
        return this.id;
    }

    public Surface getSurface() {
        return this.surface;
    }
}
