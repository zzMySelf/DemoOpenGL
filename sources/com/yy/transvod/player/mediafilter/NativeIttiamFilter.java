package com.yy.transvod.player.mediafilter;

import android.os.Message;
import com.yy.transvod.player.core.QualityMonitor;
import com.yy.transvod.player.core.TransVodStatistic;
import com.yy.transvod.player.log.TLog;
import com.yy.transvod.player.mediacodec.FrameInfo;
import com.yy.transvod.player.mediacodec.MediaSample;
import com.yy.transvod.player.mediacodec.NativeIttiam;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

public abstract class NativeIttiamFilter extends CodecFilter {
    private static final int FRAME_NOT_READY = -2;
    private static final String TAG = "NativeIttiamFilter";
    private final long kSize2M = 2000000;
    protected NativeIttiam mCodec = new NativeIttiam();
    protected FrameInfo mDecodeFrameInfo = new FrameInfo();
    protected ByteBuffer mInputBuffer = null;
    protected boolean mIsCodecAvailable = false;
    protected boolean mIsOutputAvailable = false;
    protected ByteBuffer mOutputBuffer = null;
    protected int mOutputBufferCapacity = 0;
    protected WeakReference<QualityMonitor> mQualityMonitor = new WeakReference<>((Object) null);

    public void handleMessage(Message msg) {
        switch (msg.what) {
            case 1002:
                stopCodec();
                return;
            default:
                super.handleMessage(msg);
                return;
        }
    }

    private int ittiamProcessInput(MediaSample sample) {
        MediaSample mediaSample = sample;
        if (mediaSample == null || mediaSample.avFrame == null || mediaSample.info == null || this.mInputBuffer == null || this.mOutputBuffer == null || mediaSample.info.data == null) {
            return -1;
        }
        if (mediaSample.avFrame.playTaskID > this.mPlayTaskID) {
            this.mLogCount++;
            if (this.mLogCount >= 10 && this.mLogCount % 1000 != 0) {
                return 0;
            }
            TLog.error(TAG, this, String.format("Ittiam::sample.avFrame.playTaskID: %d > mPlayTaskID %d", new Object[]{Integer.valueOf(mediaSample.avFrame.playTaskID), Integer.valueOf(this.mPlayTaskID)}));
            return 0;
        } else if (mediaSample.avFrame.playTaskID < this.mPlayTaskID) {
            this.mLogCount++;
            if (this.mLogCount < 10 || this.mLogCount % 1000 == 0) {
                TLog.error(TAG, this, String.format("Ittiam::sample.avFrame.playTaskID: %d < mPlayTaskID %d", new Object[]{Integer.valueOf(mediaSample.avFrame.playTaskID), Integer.valueOf(this.mPlayTaskID)}));
            }
            return -1;
        } else {
            this.mInputBuffer.clear();
            this.mOutputBuffer.clear();
            this.mDecodeFrameInfo.mPts = 0;
            this.mDecodeFrameInfo.mDecoderReconfigDelay = 0;
            boolean z = mediaSample.avFrame.bEndStream;
            int len = mediaSample.info.data.capacity();
            if (mediaSample.keyFrame && mediaSample.avFrame.spsPps != null) {
                len += mediaSample.avFrame.spsPps.length + 4;
            }
            ByteBuffer byteBuffer = this.mInputBuffer;
            if (byteBuffer == null || byteBuffer.capacity() < len) {
                int increaseLen = (int) (((double) len) * 1.5d);
                if (((long) increaseLen) > 2000000 || increaseLen < len) {
                    increaseLen = len;
                }
                this.mInputBuffer = ByteBuffer.allocateDirect(increaseLen);
            }
            if (this.mInputBuffer.capacity() < len) {
                return -1;
            }
            if (mediaSample.keyFrame && mediaSample.avFrame.spsPps != null) {
                this.mInputBuffer.putInt(mediaSample.avFrame.spsPps.length);
                this.mInputBuffer.put(mediaSample.avFrame.spsPps);
            }
            if (!(mediaSample.info == null || mediaSample.info.data == null)) {
                this.mInputBuffer.put(mediaSample.info.data).flip();
            }
            int result = this.mCodec.decode(this.mInputBuffer, this.mOutputBuffer, mediaSample.keyFrame, mediaSample.pts, this.mDecodeFrameInfo);
            if (result == 0 || result == -2) {
                this.mDecodeOutputQueue.add(mediaSample);
                this.mIsOutputAvailable = result == 0;
                return 1;
            }
            TLog.error(TAG, this, "ittiam decode error.maybe");
            return -1;
        }
    }

    private int ittiamProcessOutput() {
        MediaSample sample = this.mDecodeOutputQueue.poll();
        if (sample == null || sample.avFrame == null || sample.info == null) {
            return -1;
        }
        sample.info.copy(this.mMediaInfo);
        sample.info.data = this.mOutputBuffer;
        sample.pts = this.mDecodeFrameInfo.mPts;
        processDecoderDelay(sample, this.mDecodeFrameInfo.mDecoderReconfigDelay);
        this.mOutputFrameCount++;
        TransVodStatistic.plant(sample, 6);
        processAVExtraInfo(sample);
        QualityMonitor qMonitor = (QualityMonitor) this.mQualityMonitor.get();
        if (!(qMonitor == null || sample.avFrame == null)) {
            qMonitor.addReceiveVideoDataSizeInCycle((int) sample.avFrame.length);
        }
        synchronized (this.mLock) {
            if (this.mDownStream != null) {
                this.mDownStream.processMediaSample(sample);
            }
        }
        return 1;
    }

    public int internalProcessInput(MediaSample sample) {
        this.mIsOutputAvailable = false;
        int result = ittiamProcessInput(sample);
        if (result == 1 && this.mIsOutputAvailable) {
            this.mIsOutputAvailable = false;
            ittiamProcessOutput();
        }
        return result;
    }

    public void handleEndOfStream() {
        while (!this.mDecodeOutputQueue.isEmpty() && ittiamProcessOutput() == 1) {
            TLog.warn(TAG, this, "handleEndOfStream");
            try {
                Thread.sleep(20);
            } catch (Exception e2) {
                TLog.error(TAG, this, "handleEndOfStream error:" + e2.toString());
            }
        }
    }

    public void stopCodec() {
        TLog.warn(TAG, this, "stopCodec enter.");
        this.mCodec.destroy();
        this.mInputBuffer = null;
        this.mOutputBuffer = null;
        this.mDecodeFrameInfo.mPts = 0;
        this.mOutputBufferCapacity = 0;
        this.mLogCount = 0;
        releaseOutputQueue();
        TLog.info(TAG, (Object) this, "stopCodec leave.");
    }
}
