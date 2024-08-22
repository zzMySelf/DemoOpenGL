package com.yy.mediaframework.model;

import com.yy.mediaframework.base.VideoEncoderType;
import java.nio.ByteBuffer;

public class JVideoEncodedData {
    public ByteBuffer mByteBuffer = null;
    public long mDataLen = 0;
    public long mDts = 0;
    public VideoEncoderType mEncodeType = VideoEncoderType.SOFT_ENCODER_X264;
    public int mFrameType = 255;
    public long mPts = 0;

    public static native void nativeClassInit();

    private native void nativeRelaseVideoByteBuffer();

    public void releaseVideoByteBuffer() {
        if (this.mByteBuffer != null) {
            nativeRelaseVideoByteBuffer();
            this.mByteBuffer = null;
        }
    }

    public YYMediaSample toYYMediaSample() {
        YYMediaSample sample = YYMediaSampleAlloc.instance().alloc();
        sample.mDataByteBuffer = this.mByteBuffer;
        sample.mBufferSize = (int) this.mDataLen;
        sample.mYYPtsMillions = this.mPts;
        sample.mDtsMillions = this.mDts;
        sample.mFrameType = this.mFrameType;
        sample.mEncoderType = this.mEncodeType;
        return sample;
    }

    static {
        nativeClassInit();
    }
}
