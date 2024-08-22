package com.yy.mediaframework.api;

public class YMFWeakNetConfigInfo {
    public int mBitRate;
    public int mFrameRate;
    public int mHeight;
    public int mIndex;
    public int mStreamId;
    public int mWidth;

    public YMFWeakNetConfigInfo(int streamId, int index, int width, int height, int frameRate, int bitRate) {
        this.mStreamId = streamId;
        this.mIndex = index;
        this.mFrameRate = frameRate;
        this.mBitRate = bitRate;
        this.mWidth = width;
        this.mHeight = height;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" mStreamId:").append(this.mStreamId);
        sb.append(" mIndex:").append(this.mIndex);
        sb.append(" mWidth:").append(this.mWidth);
        sb.append(" mHeight:").append(this.mHeight);
        sb.append(" mFrameRate:").append(this.mFrameRate);
        sb.append(" mBitRate:").append(this.mBitRate);
        return sb.toString();
    }

    public void assign(YMFWeakNetConfigInfo info) {
        this.mStreamId = info.mStreamId;
        this.mIndex = info.mIndex;
        this.mFrameRate = info.mFrameRate;
        this.mBitRate = info.mBitRate;
        this.mWidth = info.mWidth;
        this.mHeight = info.mHeight;
    }
}
