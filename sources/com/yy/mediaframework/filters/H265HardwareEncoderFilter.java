package com.yy.mediaframework.filters;

import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaFormat;
import com.yy.mediaframework.base.VideoEncoderType;
import com.yy.mediaframework.model.ByteVector;
import com.yy.mediaframework.model.YYMediaSample;
import com.yy.mediaframework.model.YYMediaSampleAlloc;
import com.yy.mediaframework.stat.YMFLiveUsrBehaviorStat;
import com.yy.mediaframework.utils.YMFLog;
import java.nio.ByteBuffer;

public class H265HardwareEncoderFilter extends H264HardwareEncoderFilter {
    public static final int SLICE_I = 2;
    public static final int SLICE_IDR = 1;
    public static final int SLICE_UNKNOW = 255;
    private final int SyncFrameDurationMs = 3100;
    private ByteVector mBytesVector = new ByteVector(16384);
    private boolean mFirstFrameEncode = false;
    public YYMediaSample mSpsSample = new YYMediaSample();
    private int m_DepSliceSegEn = 0;
    private long m_lastSyncFrameTime = 0;
    private int m_numExtraSliceHeader = 0;
    private int m_outReadNum = 0;
    private int m_outputFlagPresentFlag = 0;

    public H265HardwareEncoderFilter(VideoLiveFilterContext filterContext) {
        super(filterContext);
    }

    public void onEncodedHeaderAvailableSample(ByteBuffer buffer, MediaCodec.BufferInfo buffInfo, long dtsMs, long ptsMs, MediaFormat mediaFormat) {
        byte[] frameData = new byte[buffInfo.size];
        if (!this.mFirstEncoderDataOut.get()) {
            onFirstEncodedDataOut();
        }
        buffer.get(frameData);
        parsePPS(frameData, buffInfo.size);
        YYMediaSample sample = YYMediaSampleAlloc.instance().alloc();
        sample.mYYPtsMillions = 0;
        sample.mDtsMillions = 0;
        sample.mMediaFormat = mediaFormat;
        sample.mFrameFlag = buffInfo.flags;
        sample.mWidth = mediaFormat.getInteger("width");
        sample.mHeight = mediaFormat.getInteger("height");
        sample.mDataByteBuffer = ByteBuffer.wrap(frameData);
        sample.mBufferOffset = 0;
        sample.mBufferSize = buffInfo.size;
        sample.mEncoderType = VideoEncoderType.HARD_ENCODER_H265;
        sample.mFrameType = 9;
        this.mSpsSample.assigne(sample);
        deliverToDownStream(sample);
        this.m_lastSyncFrameTime = System.currentTimeMillis();
        handleEncodedFrameStats((long) sample.mBufferSize, getInputFrameByteSize(), sample.mFrameType);
        sample.decRef();
        this.mEncoder.recoverCachedPtsList(dtsMs);
    }

    public void onEncodedDataAvailableSample(ByteBuffer buffer, MediaCodec.BufferInfo buffInfo, long dtsMs, long ptsMs, MediaFormat mediaFormat) {
        YYMediaSample yYMediaSample;
        ByteBuffer byteBuffer = buffer;
        MediaCodec.BufferInfo bufferInfo = buffInfo;
        MediaFormat mediaFormat2 = mediaFormat;
        YMFLog.debug((Object) this, "[Encoder ]", "OnEncodeDataAvailableSample get in");
        YYMediaSample sample = YYMediaSampleAlloc.instance().alloc();
        sample.mDtsMillions = dtsMs;
        sample.mYYPtsMillions = ptsMs;
        sample.mMediaFormat = mediaFormat2;
        sample.mFrameFlag = bufferInfo.flags;
        sample.mWidth = mediaFormat2.getInteger("width");
        sample.mHeight = mediaFormat2.getInteger("height");
        sample.mDataByteBuffer = byteBuffer;
        sample.mBufferOffset = bufferInfo.offset;
        sample.mBufferSize = bufferInfo.size;
        sample.mEncoderType = VideoEncoderType.HARD_ENCODER_H265;
        if (!this.mFirstFrameEncode) {
            YMFLiveUsrBehaviorStat.getInstance().notifyFirstFrameEncode(sample.mYYPtsMillions);
            this.mFirstFrameEncode = true;
        }
        int endPos = 0;
        while (byteBuffer.get(((bufferInfo.offset + bufferInfo.size) - 1) - endPos) == 0) {
            endPos++;
        }
        if (endPos < sample.mBufferSize) {
            sample.mBufferSize -= endPos;
        }
        byteBuffer.position(bufferInfo.offset);
        this.mBytesVector.put(byteBuffer, bufferInfo.size);
        byteBuffer.position(bufferInfo.offset);
        int type = parseSliceType(this.mBytesVector.getBytes(), this.mBytesVector.size(), (bufferInfo.flags & 1) != 0);
        if (type == 1 || type == 2) {
            sample.mFrameType = 4;
            if (type == 1) {
                this.m_lastSyncFrameTime = System.currentTimeMillis();
            }
        } else {
            sample.mFrameType = 1;
        }
        if (System.currentTimeMillis() - this.m_lastSyncFrameTime > 3100) {
            requestSyncFrame();
            this.m_lastSyncFrameTime = System.currentTimeMillis();
        }
        this.mBytesVector.clear();
        if (sample.mFrameType == 4 && (yYMediaSample = this.mSpsSample) != null) {
            deliverToDownStream(yYMediaSample);
        }
        deliverToDownStream(sample);
        handleEncodedFrameStats((long) sample.mBufferSize, getInputFrameByteSize(), sample.mFrameType);
        sample.decRef();
    }

    public VideoEncoderType getEncoderFilterType() {
        return VideoEncoderType.HARD_ENCODER_H265;
    }

    public void onEncoderFomratChanged(MediaFormat mediaFormat) {
        super.onEncoderFomratChanged(mediaFormat);
    }

    public void onPreviewTextureAvailable(SurfaceTexture surfaceTexture) {
    }

    public void onError(long eid, String exceptionId, String errMsg) {
        _OnError(eid, exceptionId, errMsg);
    }

    private static int test_bit(byte[] addr, int index) {
        return (addr[index >> 3] >> (7 - (index % 8))) & 1;
    }

    private static int read_bits(byte[] addr, int start, int length) {
        int result = 0;
        while (true) {
            int length2 = length - 1;
            if (length <= 0) {
                return result;
            }
            result = (result << 1) + test_bit(addr, start);
            length = length2;
            start++;
        }
    }

    private int read_ue(byte[] addr, int start) {
        int leadingZeroBits = -1;
        int b2 = 0;
        while (b2 == 0) {
            b2 = test_bit(addr, start + leadingZeroBits + 1);
            leadingZeroBits++;
        }
        int codeNum = ((1 << leadingZeroBits) - 1) + read_bits(addr, start + leadingZeroBits + 1, leadingZeroBits);
        this.m_outReadNum = (leadingZeroBits * 2) + 1;
        return codeNum;
    }

    public void parsePPS(byte[] frameData, int len) {
        if (frameData != null && len > 0) {
            int pos = 0;
            while (pos + 5 <= len) {
                int oldPos = pos;
                if (frameData[pos] == 0 && frameData[pos + 1] == 0 && frameData[pos + 2] == 0 && frameData[pos + 3] == 1) {
                    pos += 4;
                } else if (frameData[pos] == 0 && frameData[pos + 1] == 0 && frameData[pos + 3] == 1) {
                    pos += 3;
                }
                if (oldPos == pos) {
                    pos++;
                } else if (((frameData[pos] & 126) >> 1) == 34) {
                    break;
                }
            }
            if (pos + 5 < len) {
                int pos2 = (pos + 2) * 8;
                int picId = read_ue(frameData, pos2);
                int pos3 = pos2 + this.m_outReadNum;
                int seqId = read_ue(frameData, pos3);
                int pos4 = pos3 + this.m_outReadNum;
                int pos5 = pos4 + 1;
                this.m_DepSliceSegEn = read_bits(frameData, pos4, 1);
                int pos6 = pos5 + 1;
                this.m_outputFlagPresentFlag = read_bits(frameData, pos5, 1);
                this.m_numExtraSliceHeader = read_bits(frameData, pos6, 3);
                int pos7 = pos6 + 3;
                YMFLog.info(this, "[Encoder ]", "H265SurfaceEncoder parsePPS Type, picId:" + picId + ", seqId:" + seqId + ", m_DepSliceSegEn:" + this.m_DepSliceSegEn + ", m_outputFlagPresentFlag:" + this.m_outputFlagPresentFlag + ", m_numExtraSliceHeader:" + this.m_numExtraSliceHeader);
            }
        }
    }

    public int parseSliceType(byte[] frameData, int len, boolean isKeyFrame) {
        int pos;
        int ntype = naltype(frameData, len);
        if (ntype < 0) {
            YMFLog.info(this, "[Encoder ]", "H265SurfaceEncoder parseSliceType, unknown, ntype:" + ntype);
            return 255;
        } else if (ntype >= 16 && ntype <= 23) {
            YMFLog.info(this, "[Encoder ]", "H265SurfaceEncoder parseSliceType, IDR, ntype:" + ntype);
            return 1;
        } else if (ntype < 32 || ntype > 34) {
            if (frameData[0] == 0 && frameData[1] == 0 && frameData[2] == 0 && frameData[3] == 1) {
                pos = 32;
            } else if (frameData[0] == 0 && frameData[1] == 0 && frameData[2] == 1) {
                pos = 24;
            } else {
                YMFLog.info(this, "[Encoder ]", "H265SurfaceEncoder parseSliceType, unknown slice type");
                return 255;
            }
            int pos2 = pos + 16;
            int pos3 = pos2 + 1;
            int pos4 = read_bits(frameData, pos2, 1);
            int read_ue = read_ue(frameData, pos3);
            int pos5 = pos3 + this.m_outReadNum;
            int dependentSliceSeg = 0;
            if (pos4 == 0) {
                if (this.m_DepSliceSegEn != 0) {
                    dependentSliceSeg = read_bits(frameData, pos5, 1);
                    pos5++;
                }
                read_ue(frameData, pos5);
                pos5 += this.m_outReadNum;
            }
            if (dependentSliceSeg != 0) {
                return 255;
            }
            int i2 = 0;
            while (i2 < this.m_numExtraSliceHeader) {
                read_bits(frameData, pos5, 1);
                i2++;
                pos5++;
            }
            int type = read_ue(frameData, pos5);
            int pos6 = pos5 + this.m_outReadNum;
            if (type == 2) {
                return 2;
            }
            return 255;
        } else {
            YMFLog.info(this, "[Encoder ]", "H265SurfaceEncoder parseSliceType, PPS/VPS/SPS, ntype:" + ntype);
            if (isKeyFrame) {
                return 1;
            }
            return 255;
        }
    }

    public static int naltype(byte[] frameData, int len) {
        if (frameData[0] == 0 && frameData[1] == 0 && frameData[2] == 0 && frameData[3] == 1) {
            return (frameData[4] & 126) >> 1;
        }
        if (frameData[0] == 0 && frameData[1] == 0 && frameData[2] == 1) {
            return (frameData[3] & 126) >> 1;
        }
        return -1;
    }
}
