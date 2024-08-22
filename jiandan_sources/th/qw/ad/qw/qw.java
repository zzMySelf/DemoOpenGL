package th.qw.ad.qw;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import io.flutter.plugin.common.BinaryMessenger;

/* compiled from: BinaryMessenger */
public final /* synthetic */ class qw {
    @UiThread
    public static BinaryMessenger.TaskQueue $default$makeBackgroundTaskQueue(BinaryMessenger _this) {
        throw new UnsupportedOperationException("makeBackgroundTaskQueue not implemented.");
    }

    @UiThread
    public static void $default$setMessageHandler(@NonNull BinaryMessenger _this, @Nullable String str, @Nullable BinaryMessenger.BinaryMessageHandler binaryMessageHandler, BinaryMessenger.TaskQueue taskQueue) {
        if (taskQueue == null) {
            _this.setMessageHandler(str, binaryMessageHandler);
            return;
        }
        throw new UnsupportedOperationException("setMessageHandler called with nonnull taskQueue is not supported.");
    }
}
