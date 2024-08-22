package io.flutter.plugin.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import java.nio.ByteBuffer;

public interface BinaryMessenger {

    public interface BinaryMessageHandler {
        @UiThread
        void onMessage(@Nullable ByteBuffer byteBuffer, @NonNull BinaryReply binaryReply);
    }

    public interface BinaryReply {
        void reply(@Nullable ByteBuffer byteBuffer);
    }

    public interface TaskQueue {
    }

    @UiThread
    TaskQueue makeBackgroundTaskQueue();

    @UiThread
    void send(@NonNull String str, @Nullable ByteBuffer byteBuffer);

    @UiThread
    void send(@NonNull String str, @Nullable ByteBuffer byteBuffer, @Nullable BinaryReply binaryReply);

    @UiThread
    void setMessageHandler(@NonNull String str, @Nullable BinaryMessageHandler binaryMessageHandler);

    @UiThread
    void setMessageHandler(@NonNull String str, @Nullable BinaryMessageHandler binaryMessageHandler, @Nullable TaskQueue taskQueue);
}
