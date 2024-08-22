package com.temp.mario.audio.easy;

import com.temp.mario.audio.AudioParams;
import java.nio.ByteBuffer;

public interface EasyAudioCallback {
    void onAudioFrameAvailable(ByteBuffer byteBuffer, int i2, long j2);

    void onAudioStart(boolean z, AudioParams audioParams);

    void onAudioStop(boolean z);
}
