package com.yy.videoplayer;

public class VideoDecodeEventNotify {
    public long mPts = 0;
    public long mStreamId = 0;

    public VideoDecodeEventNotify(long streamId, long pts) {
        this.mStreamId = streamId;
        this.mPts = pts;
    }
}
