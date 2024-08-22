package com.yy.mediaframework.filters;

import com.yy.mediaframework.IEncoderListener;
import com.yy.mediaframework.IMediaFilter;
import com.yy.mediaframework.YMFStreamSyncSourceManager;
import com.yy.mediaframework.YYVideoSDK;
import com.yy.mediaframework.api.YMFVideoEncodeFrame;
import com.yy.mediaframework.base.VideoEncoderType;
import com.yy.mediaframework.camera.YMFCamera;
import com.yy.mediaframework.extra.YYSeiData;
import com.yy.mediaframework.model.ByteVector;
import com.yy.mediaframework.model.YYMediaSample;
import com.yy.mediaframework.stat.YMFLiveStatisticManager;
import com.yy.mediaframework.utils.YMFLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransmitUploadFilter implements IMediaFilter {
    byte[] externNaluData = new byte[2];
    private ByteVector mBytesVector = null;
    private long mDeltaPtsDts = 0;
    private VideoLiveFilterContext mFilterContext = null;
    private IEncoderListener mLiveSession = null;
    private long mPrevDts = Long.MIN_VALUE;
    private HashMap<Integer, TransmitUploadInfo> mTransmitUploadInfoMap = new HashMap<>();
    private YMFVideoEncodeFrame mVideoEncodeFrame = new YMFVideoEncodeFrame();
    private MediaMuxerFilter mediaMuxerFilter = new MediaMuxerFilter();
    private int svcSid;
    private int svcTid;

    private class TransmitUploadInfo {
        public int bitRate;
        public int count;
        public int fps;
        /* access modifiers changed from: private */
        public boolean isSvdData;
        public int keyFrames;
        public long lastEncodeRecordTime;
        public long lastFrameTime;
        private List<Long> mDeltaPtsList;
        public long mLastPrintTime;
        public long mLastPts;
        private long mMaxDeltaEncodeTime;
        private long mMaxDeltaPts;

        private TransmitUploadInfo() {
            this.lastEncodeRecordTime = 0;
            this.lastFrameTime = 0;
            this.count = 0;
            this.mLastPts = 0;
            this.mLastPrintTime = 0;
            this.mMaxDeltaEncodeTime = 0;
            this.mDeltaPtsList = new ArrayList();
            this.mMaxDeltaPts = 0;
            this.isSvdData = false;
        }

        /* access modifiers changed from: private */
        public void printfDeltaPts(long pts) {
            long now = System.currentTimeMillis();
            long j2 = this.mLastPts;
            if (j2 == 0) {
                this.mLastPrintTime = now;
                this.mLastPts = pts;
                return;
            }
            this.mDeltaPtsList.add(Long.valueOf(pts - j2));
            long j3 = this.mMaxDeltaPts;
            long j4 = this.mLastPts;
            if (j3 < pts - j4) {
                j3 = pts - j4;
            }
            this.mMaxDeltaPts = j3;
            this.mLastPts = pts;
            if (now - this.mLastPrintTime >= 3000) {
                String str = " " + pts + " ";
                for (int i2 = 0; i2 < this.mDeltaPtsList.size(); i2++) {
                    str = str + this.mDeltaPtsList.get(i2) + ",";
                }
                YMFLog.info(this, "[Encoder ]", "TransmitUploadFilter printfDeltaPts [" + str + "]MAX:" + this.mMaxDeltaPts + " in " + this.mDeltaPtsList.size());
                this.mDeltaPtsList.clear();
                this.mLastPrintTime = now;
                this.mMaxDeltaPts = 0;
            }
        }

        public void calcDeltaMaxPtsDts(int streamId, long pts, long dts) {
            YMFLiveStatisticManager.getInstance().setVideoPtsDtsMaxDiff(streamId, (int) Math.abs(pts - dts));
        }

        public void calcEncodeInfo(YYMediaSample sample) {
            int i2 = sample.mStreamId;
            long now = System.currentTimeMillis();
            if (this.lastEncodeRecordTime != 0) {
                long j2 = this.lastFrameTime;
                if (j2 != 0) {
                    long delta = Math.abs(now - j2);
                    this.lastFrameTime = now;
                    YMFLiveStatisticManager.getInstance().setVideoEncodeTimeDiff(sample.mStreamId, (int) delta);
                    long j3 = this.mMaxDeltaEncodeTime;
                    if (delta >= j3) {
                        j3 = delta;
                    }
                    this.mMaxDeltaEncodeTime = j3;
                    if (now - this.lastEncodeRecordTime >= 1000) {
                        if (this.count == 10) {
                            YMFLog.info(this, "[Encoder ]", "mStreamId：" + sample.mStreamId + ",publishVideoFrameBuffer bitRate:" + (this.bitRate * 8) + "bps, fps:" + this.fps + ", 6s keyFrames:" + this.keyFrames + ",isSvc " + this.isSvdData);
                            this.count = 0;
                        }
                        this.count++;
                        YMFLiveStatisticManager.getInstance().setVideoRealBitrate(sample.mStreamId, (this.bitRate * 8) / 1000);
                        YMFLiveStatisticManager.getInstance().setVideoRealEncodeFps(sample.mStreamId, this.fps);
                        this.fps = 0;
                        this.keyFrames = 0;
                        this.bitRate = 0;
                        this.lastEncodeRecordTime = System.currentTimeMillis();
                    }
                    this.fps++;
                    this.bitRate += sample.mBufferSize;
                    return;
                }
            }
            this.lastEncodeRecordTime = now;
            this.lastFrameTime = now;
        }
    }

    public TransmitUploadFilter(VideoLiveFilterContext filterContext, IEncoderListener liveSession) {
        this.mFilterContext = filterContext;
        this.mLiveSession = liveSession;
        this.mBytesVector = new ByteVector(4096);
        this.mDeltaPtsDts = YYVideoSDK.getInstance().getDeltaYYPtsMillions();
        YMFLog.info(this, "[Encoder ]", "TransmitUploadFilter mDeltaPtsDts:" + this.mDeltaPtsDts);
    }

    public boolean processMediaSample(YYMediaSample sample, Object upstream) {
        YYMediaSample yYMediaSample = sample;
        YMFLiveStatisticManager.getInstance().beginTransmitUpload();
        if (!this.mTransmitUploadInfoMap.containsKey(Integer.valueOf(yYMediaSample.mStreamId))) {
            this.mTransmitUploadInfoMap.put(Integer.valueOf(yYMediaSample.mStreamId), new TransmitUploadInfo());
        }
        this.mBytesVector.reserve(yYMediaSample.mBufferSize);
        byte[] frameData = this.mBytesVector.getBytes();
        if (yYMediaSample.mEncoderType == VideoEncoderType.HARD_ENCODER_H264) {
            if (yYMediaSample.mFrameType != 6 && yYMediaSample.mFrameType != 5) {
                int realFrameLength = yYMediaSample.mBufferSize - 4;
                frameData[0] = (byte) ((realFrameLength >>> 24) & 255);
                frameData[1] = (byte) ((realFrameLength >>> 16) & 255);
                frameData[2] = (byte) ((realFrameLength >>> 8) & 255);
                frameData[3] = (byte) (realFrameLength & 255);
                yYMediaSample.mDataByteBuffer.position(yYMediaSample.mBufferOffset + 4);
                yYMediaSample.mDataByteBuffer.limit(yYMediaSample.mBufferOffset + yYMediaSample.mBufferSize);
                yYMediaSample.mDataByteBuffer.get(frameData, 4, yYMediaSample.mBufferSize - 4);
            } else if (this.mFilterContext.getLiveMode() == LiveSessionType.LIVE_MODE_SCREEN_RECORD) {
                yYMediaSample.mDataByteBuffer.rewind();
                yYMediaSample.mDataByteBuffer.get(frameData, 0, yYMediaSample.mBufferSize);
            } else {
                yYMediaSample.mDataByteBuffer.rewind();
                yYMediaSample.mDataByteBuffer.get(frameData, 0, yYMediaSample.mBufferSize);
            }
        } else if (!(yYMediaSample.mEncoderType == VideoEncoderType.HARD_ENCODER_H265 && yYMediaSample.mFrameType == 255)) {
            if (yYMediaSample.mEncoderType == VideoEncoderType.SOFT_ENCODER_X264) {
                yYMediaSample.mDataByteBuffer.rewind();
                yYMediaSample.mDataByteBuffer.get(frameData, 0, yYMediaSample.mBufferSize);
            } else if (this.mFilterContext.getLiveMode() == LiveSessionType.LIVE_MODE_SCREEN_RECORD) {
                yYMediaSample.mDataByteBuffer.rewind();
                yYMediaSample.mDataByteBuffer.get(frameData, 0, yYMediaSample.mBufferSize);
            } else {
                yYMediaSample.mDataByteBuffer.rewind();
                yYMediaSample.mDataByteBuffer.get(frameData, 0, yYMediaSample.mBufferSize);
            }
        }
        this.svcTid = 255;
        this.svcSid = 255;
        boolean unused = this.mTransmitUploadInfoMap.get(Integer.valueOf(yYMediaSample.mStreamId)).isSvdData = false;
        if (yYMediaSample.mEncoderType == VideoEncoderType.SOFT_ENCODER_X264 && yYMediaSample.mBufferSize >= 6) {
            yYMediaSample.mDataByteBuffer.rewind();
            yYMediaSample.mDataByteBuffer.position(4);
            yYMediaSample.mDataByteBuffer.get(this.externNaluData, 0, 2);
            byte[] bArr = this.externNaluData;
            if ((bArr[0] & 31) == 14) {
                byte b2 = bArr[1];
                int i2 = (b2 >>> 3) & 7;
                this.svcSid = i2;
                byte b3 = b2 & 7;
                this.svcTid = b3;
                if (!(i2 == 255 && b3 == 255)) {
                    boolean unused2 = this.mTransmitUploadInfoMap.get(Integer.valueOf(yYMediaSample.mStreamId)).isSvdData = true;
                }
            }
        }
        if (!yYMediaSample.isUsePbo) {
            this.mVideoEncodeFrame.pts = yYMediaSample.mYYPtsMillions + this.mDeltaPtsDts;
            this.mVideoEncodeFrame.dts = yYMediaSample.mDtsMillions + this.mDeltaPtsDts;
        } else {
            this.mVideoEncodeFrame.pts = (yYMediaSample.mYYPtsMillions + this.mDeltaPtsDts) - yYMediaSample.mFrameDeltaDts;
            this.mVideoEncodeFrame.dts = (yYMediaSample.mDtsMillions + this.mDeltaPtsDts) - yYMediaSample.mFrameDeltaDts;
        }
        YMFStreamSyncSourceManager.getInstance().updateHighStreamStartEncodeTime(yYMediaSample.mYYPtsMillions);
        this.mVideoEncodeFrame.svcSid = this.svcSid;
        this.mVideoEncodeFrame.svcTid = this.svcTid;
        this.mVideoEncodeFrame.data = frameData;
        this.mVideoEncodeFrame.len = yYMediaSample.mBufferSize;
        this.mVideoEncodeFrame.width = yYMediaSample.mWidth;
        this.mVideoEncodeFrame.height = yYMediaSample.mHeight;
        this.mVideoEncodeFrame.streamId = yYMediaSample.mStreamId;
        this.mVideoEncodeFrame.frameType = yYMediaSample.mFrameType;
        this.mVideoEncodeFrame.encodeType = yYMediaSample.mEncoderType;
        this.mVideoEncodeFrame.yySeiData = null;
        long pts = this.mVideoEncodeFrame.pts - this.mDeltaPtsDts;
        if (YMFCamera.getInstance().getPtsSeiMap() != null && YMFCamera.getInstance().getPtsSeiMap().containsKey(Long.valueOf(pts))) {
            for (Map.Entry<Long, YYSeiData> entry : YMFCamera.getInstance().getPtsSeiMap().entrySet()) {
                long key = entry.getKey().longValue();
                if (key < pts - 1000) {
                    YMFCamera.getInstance().getPtsSeiMap().remove(Long.valueOf(key));
                }
            }
            YYSeiData seiData = YMFCamera.getInstance().getPtsSeiMap().remove(Long.valueOf(pts));
            if (!(seiData == null || seiData.data == null)) {
                this.mVideoEncodeFrame.yySeiData = seiData.data;
            }
        }
        if (this.mVideoEncodeFrame.frameType == 4 || this.mVideoEncodeFrame.frameType == 0 || this.mVideoEncodeFrame.frameType == 2 || this.mVideoEncodeFrame.frameType == 1) {
            if (this.mPrevDts >= this.mVideoEncodeFrame.dts) {
                this.mVideoEncodeFrame.dts = this.mPrevDts + 1;
            }
            this.mPrevDts = this.mVideoEncodeFrame.dts;
        }
        this.mLiveSession.onEncodeFrameData(this.mVideoEncodeFrame);
        MediaMuxerFilter mediaMuxerFilter2 = this.mediaMuxerFilter;
        if (mediaMuxerFilter2 != null) {
            mediaMuxerFilter2.writeMuxer(frameData, yYMediaSample.mWidth, yYMediaSample.mHeight, yYMediaSample.mBufferSize, yYMediaSample.mEncoderType, yYMediaSample.mFrameType);
        }
        this.mBytesVector.clear();
        if (!(yYMediaSample.mFrameType == 6 || yYMediaSample.mFrameType == 5 || yYMediaSample.mFrameType == 9)) {
            this.mTransmitUploadInfoMap.get(Integer.valueOf(yYMediaSample.mStreamId)).printfDeltaPts(yYMediaSample.mYYPtsMillions);
            this.mTransmitUploadInfoMap.get(Integer.valueOf(yYMediaSample.mStreamId)).calcDeltaMaxPtsDts(yYMediaSample.mStreamId, yYMediaSample.mYYPtsMillions, yYMediaSample.mDtsMillions);
        }
        this.mTransmitUploadInfoMap.get(Integer.valueOf(yYMediaSample.mStreamId)).calcEncodeInfo(yYMediaSample);
        YMFLiveStatisticManager.getInstance().endTransmitUpload();
        return false;
    }

    public void startMediaRecording(String path) {
        MediaMuxerFilter mediaMuxerFilter2 = this.mediaMuxerFilter;
        if (mediaMuxerFilter2 != null) {
            mediaMuxerFilter2.start(path);
        }
    }

    public void stopMediaRecording() {
        MediaMuxerFilter mediaMuxerFilter2 = this.mediaMuxerFilter;
        if (mediaMuxerFilter2 != null) {
            mediaMuxerFilter2.stop();
        }
    }
}
