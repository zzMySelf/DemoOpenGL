package io.flutter.embedding.engine.dart;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.nio.ByteBuffer;

public interface PlatformMessageHandler {
    void handleMessageFromDart(@NonNull String str, @Nullable ByteBuffer byteBuffer, int i2, long j);

    void handlePlatformMessageResponse(int i2, @Nullable ByteBuffer byteBuffer);
}
