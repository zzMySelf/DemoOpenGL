package com.temp.mario.audio;

public class AudioParams {
    public static final int DEFAULT_AUDIO_BUFFER_SIZE = 32768;
    public static final int DEFAULT_AUDIO_FORMAT = 2;
    public static final int DEFAULT_AUDIO_SOURCE = 1;
    public static final int DEFAULT_BUFFER_FRAME_COUNT = 32;
    public static final int DEFAULT_CHANNEL_CONFIG = 16;
    public static final int DEFAULT_FRAME_SIZE = 1024;
    public static final int DEFAULT_SAMPLE_RATE = 16000;
    public static final int SAMPLES_PER_FRAME = 1024;
    private int mAudioBufferSize = 32768;
    private int mAudioFormat = 2;
    private int mAudioSource = 1;
    private int mChannelConfig = 16;
    private int mFrameBufferCount = 32;
    private int mFrameSize = 1024;
    private int mSampleRate = 16000;

    public int getAudioSource() {
        return this.mAudioSource;
    }

    public void setAudioSource(int audioSource) {
        this.mAudioSource = audioSource;
    }

    public int getSampleRate() {
        return this.mSampleRate;
    }

    public void setSampleRate(int sampleRate) {
        this.mSampleRate = sampleRate;
    }

    public int getChannelConfig() {
        return this.mChannelConfig;
    }

    public void setChannelConfig(int channelConfig) {
        this.mChannelConfig = channelConfig;
    }

    public int getAudioFormat() {
        return this.mAudioFormat;
    }

    public void setAudioFormat(int audioFormat) {
        this.mAudioFormat = audioFormat;
    }

    public int getFrameSize() {
        return this.mFrameSize;
    }

    public void setFrameSize(int frameSize) {
        this.mFrameSize = frameSize;
    }

    public int getFrameBufferCount() {
        return this.mFrameBufferCount;
    }

    public void setFrameBufferCount(int frameBufferCount) {
        this.mFrameBufferCount = frameBufferCount;
    }

    public int getAudioBufferSize() {
        return this.mAudioBufferSize;
    }

    public void setAudioBufferSize(int audioBufferSize) {
        this.mAudioBufferSize = audioBufferSize;
    }

    public boolean equals(Object params) {
        if (this == params) {
            return true;
        }
        if (params == null || !(params instanceof AudioParams)) {
            return false;
        }
        AudioParams audioParams = (AudioParams) params;
        if (this.mAudioSource == audioParams.mAudioSource && this.mSampleRate == audioParams.getSampleRate() && this.mChannelConfig == audioParams.getChannelConfig() && this.mAudioFormat == audioParams.getAudioFormat() && this.mFrameSize == audioParams.getFrameSize()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((1 * 31) + this.mAudioSource) * 31) + this.mSampleRate) * 31) + this.mChannelConfig) * 31) + this.mAudioFormat) * 31) + this.mFrameSize;
    }
}
