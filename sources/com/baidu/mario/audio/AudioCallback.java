package com.baidu.mario.audio;

import java.nio.ByteBuffer;

public interface AudioCallback {
    void onAudioFrameAvailable(ByteBuffer byteBuffer, int i2, long j2);

    void onAudioRelease();

    void onAudioSetup(boolean z);

    void onAudioStart(boolean z);

    void onAudioStop(boolean z);
}
