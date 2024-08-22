package io.flutter.embedding.engine.dart;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import io.flutter.embedding.engine.dart.DartMessenger;

public class PlatformTaskQueue implements DartMessenger.DartMessengerTaskQueue {
    @NonNull
    public final Handler handler = new Handler(Looper.getMainLooper());

    public void dispatch(@NonNull Runnable runnable) {
        this.handler.post(runnable);
    }
}
