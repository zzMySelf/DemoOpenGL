package com.yy.mediaframework.stat;

import android.os.Build;
import com.yy.mediaframework.YYVideoCodec;
import com.yy.mediaframework.camera.YMFCamera;
import com.yy.mediaframework.utils.CPUTool;
import com.yy.mediaframework.utils.CommonUtil;
import com.yy.mediaframework.utils.YMFLog;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class VideoDataStatistic {
    private static final String TAG = "VideoDataStatistic";
    private static ConcurrentHashMap<String, Object> mAssistantUploadDataHashMap = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, Object> mBaseUploadDataHashMap = new ConcurrentHashMap<>();
    private static int mCameraCaptureMeanLatency = 0;
    private static int mCameraCaptureRealFrameRate = 0;
    private static int mCaptureType = -1;
    private static ConcurrentHashMap<String, Object> mCoreUploadDataHashMap = new ConcurrentHashMap<>();
    private static String mCpuName = "";
    private static HashMap<Integer, Integer> mDesiredBitrate = new HashMap<>();
    private static HashMap<Integer, Integer> mDesiredFps = new HashMap<>();
    private static long mDynamicEncodeFrameRate = 0;
    private static HashMap<Integer, Integer> mEncodeMaxLatency = new HashMap<>();
    private static HashMap<Integer, Integer> mEncodeMeanLatency = new HashMap<>();
    private static String mGpuName = "";
    private static HashMap<Integer, Integer> mPmDesiredEncodeBitrate = new HashMap<>();
    private static HashMap<Integer, Integer> mPmDesiredEncodeFps = new HashMap<>();
    private static HashMap<Integer, Integer> mPmDesiredEncodeHeight = new HashMap<>();
    private static HashMap<Integer, Integer> mPmDesiredEncodeWidth = new HashMap<>();
    private static int mPreProcessMaxLatency = 0;
    private static int mPreProcessMeanLatency = 0;
    private static long mPreviewFrameRate = 0;
    private static HashMap<Integer, Integer> mRealFps = new HashMap<>();
    private static HashMap<Integer, Integer> mRealMaxBitrate = new HashMap<>();
    private static HashMap<Integer, Integer> mRealMeanBitrate = new HashMap<>();
    private static HashMap<Integer, Integer> mRealMinFps = new HashMap<>();
    private static String mVersion = "";
    private static HashMap<Integer, Integer> mVideoCapture2EncodeLatency = new HashMap<>();
    private static int mVideoCaptureStallingIndication = 0;
    private static HashMap<Integer, Integer> mVideoEncodeHeight = new HashMap<>();
    private static HashMap<Integer, Integer> mVideoEncodeId = new HashMap<>();
    private static HashMap<Integer, Integer> mVideoEncodeTimeDiff = new HashMap<>();
    private static HashMap<Integer, Integer> mVideoEncodeWidth = new HashMap<>();
    private static HashMap<Integer, Integer> mVideoPtsDtsMaxDiff = new HashMap<>();
    private static int mVideoPtsMaxDiff = 0;

    private interface AnchorHiidoAssistantStatisticKey {
        public static final String CpuDeviceInfo = "cpu";
        public static final String GpuDeviceInfo = "gpu";
        public static final String H265SupportInfo = "hevc";
        public static final String ModelInfo = "model";
        public static final String VideoLibVer = "vver";
    }

    public interface AnchorHiidoCoreStatisticKey {
        public static final String AppCpuRate = "s7";
        public static final String CaptureDesiredFps = "sfr";
        public static final String CaptureDesiredResolutionHeight = "sh";
        public static final String CaptureDesiredResolutionWidth = "sw";
        public static final String CaptureMeanLatency = "cal";
        public static final String CaptureRealFps = "rfr";
        public static final String CaptureRealResolutionHeight = "rh";
        public static final String CaptureRealResolutionWidth = "rw";
        public static final String CaptureType = "vct";
        public static final String PmDesiredEncodeBitrate = "pmbr";
        public static final String PmDesiredEncodeFps = "pmfr";
        public static final String PmDesiredEncodeHeight = "pmh";
        public static final String PmDesiredEncodeWidth = "pmw";
        public static final String VideoCapture2EncodeLatency = "c2el";
        public static final String VideoCaptureStallingIndication = "vcsi";
        public static final String VideoEncodeDesiredBitrate = "epbr";
        public static final String VideoEncodeDesiredFps = "esfr";
        public static final String VideoEncodeHeight = "eh";
        public static final String VideoEncodeId = "eid";
        public static final String VideoEncodeMaxLatency = "eml";
        public static final String VideoEncodeMeanLatency = "eal";
        public static final String VideoEncodeRealFps = "erfr";
        public static final String VideoEncodeRealMaxBitrate = "embr";
        public static final String VideoEncodeRealMeanBitrate = "ebr";
        public static final String VideoEncodeTimeDiff = "emd";
        public static final String VideoEncodeWidth = "ew";
        public static final String VideoPreProcessMaxLatency = "fml";
        public static final String VideoPreProcessMeanLatency = "fal";
        public static final String VideoPtsDtsMaxDiff = "pdmd";
        public static final String VideoPtsMaxDiff = "epd";
    }

    public VideoDataStatistic() {
        initInfo();
    }

    private void initInfo() {
        mVersion = "200.4.4.3.4";
        mCpuName = CPUTool.getCpuInfo();
    }

    public void setDesiredParam(int publishId, int encodeWidth, int encodeHeight, int bitrate, int fps) {
        HashMap<Integer, Integer> hashMap = mPmDesiredEncodeWidth;
        if (hashMap != null) {
            hashMap.put(Integer.valueOf(publishId), Integer.valueOf(encodeWidth));
        }
        HashMap<Integer, Integer> hashMap2 = mPmDesiredEncodeHeight;
        if (hashMap2 != null) {
            hashMap2.put(Integer.valueOf(publishId), Integer.valueOf(encodeHeight));
        }
        HashMap<Integer, Integer> hashMap3 = mPmDesiredEncodeBitrate;
        if (hashMap3 != null) {
            hashMap3.put(Integer.valueOf(publishId), Integer.valueOf(bitrate));
        }
        HashMap<Integer, Integer> hashMap4 = mPmDesiredEncodeFps;
        if (hashMap4 != null) {
            hashMap4.put(Integer.valueOf(publishId), Integer.valueOf(fps));
        }
    }

    public void setGpuDeviceName(String name) {
        mGpuName = name;
    }

    public void setCameraCaptureFrameRate(int frameRate) {
        mCameraCaptureRealFrameRate = frameRate;
    }

    public void setCameraCaptureMeanLatency(int time) {
        mCameraCaptureMeanLatency = time;
    }

    public void setPreProcessMeanLatency(int time) {
        mPreProcessMeanLatency = time;
    }

    public void setPreProcessMaxLatency(int time) {
        mPreProcessMaxLatency = time;
    }

    public void setVideoEncodeTypeId(int publishId, int id) {
        HashMap<Integer, Integer> hashMap = mVideoEncodeId;
        if (hashMap != null) {
            hashMap.put(Integer.valueOf(publishId), Integer.valueOf(id));
        }
    }

    public void setVideoEncodeWidth(int publishId, int width) {
        HashMap<Integer, Integer> hashMap = mVideoEncodeWidth;
        if (hashMap != null) {
            hashMap.put(Integer.valueOf(publishId), Integer.valueOf(width));
        }
    }

    public void setVideoEncodeHeight(int publishId, int height) {
        HashMap<Integer, Integer> hashMap = mVideoEncodeHeight;
        if (hashMap != null) {
            hashMap.put(Integer.valueOf(publishId), Integer.valueOf(height));
        }
    }

    public void setVideoEncodeDesiredFps(int publishId, int fps) {
        if (mRealFps != null) {
            mDesiredFps.put(Integer.valueOf(publishId), Integer.valueOf(fps));
        }
    }

    public void setVideoRealEncodeFps(int publishId, int realFps) {
        HashMap<Integer, Integer> hashMap = mRealFps;
        if (hashMap != null) {
            hashMap.put(Integer.valueOf(publishId), Integer.valueOf(realFps));
        }
    }

    public void setVideoRealMinEncodeFps(int publishId, int realFps) {
        HashMap<Integer, Integer> hashMap = mRealMinFps;
        if (hashMap != null) {
            hashMap.put(Integer.valueOf(publishId), Integer.valueOf(realFps));
        }
    }

    public void setVideoDesiredEncodeBitrate(int publishId, int bitrate) {
        HashMap<Integer, Integer> hashMap = mDesiredBitrate;
        if (hashMap != null) {
            hashMap.put(Integer.valueOf(publishId), Integer.valueOf(bitrate));
        }
    }

    public void setVideoRealMeanBitrate(int publishId, int bitrate) {
        HashMap<Integer, Integer> hashMap = mRealMeanBitrate;
        if (hashMap != null) {
            hashMap.put(Integer.valueOf(publishId), Integer.valueOf(bitrate));
        }
    }

    public void setVideoRealMaxBitrate(int publishId, int bitrate) {
        HashMap<Integer, Integer> hashMap = mRealMaxBitrate;
        if (hashMap != null) {
            hashMap.put(Integer.valueOf(publishId), Integer.valueOf(bitrate));
        }
    }

    public void setVideoEncodeMeanLatency(int publishId, int encodeMeanLatency) {
        HashMap<Integer, Integer> hashMap = mEncodeMeanLatency;
        if (hashMap != null) {
            hashMap.put(Integer.valueOf(publishId), Integer.valueOf(encodeMeanLatency));
        }
    }

    public void setVideoEncodeMaxLatency(int publishId, int encodeMaxLatency) {
        HashMap<Integer, Integer> hashMap = mEncodeMaxLatency;
        if (hashMap != null) {
            hashMap.put(Integer.valueOf(publishId), Integer.valueOf(encodeMaxLatency));
        }
    }

    public void setVideoCapture2EncodeLatency(int publishId, int videoCapture2EncodeLatency) {
        HashMap<Integer, Integer> hashMap = mVideoCapture2EncodeLatency;
        if (hashMap != null) {
            hashMap.put(Integer.valueOf(publishId), Integer.valueOf(videoCapture2EncodeLatency));
        }
    }

    public void setVideoPtsMaxDiff(int videoPtsMaxDiff) {
        mVideoPtsMaxDiff = videoPtsMaxDiff;
    }

    public void setVideoCaptureStallingIndication(int videoCaptureStallingIndication) {
        mVideoCaptureStallingIndication = videoCaptureStallingIndication;
    }

    public void setVideoPtsDtsMaxDiff(int publishId, int videoPtsDtsMaxDiff) {
        HashMap<Integer, Integer> hashMap = mVideoPtsDtsMaxDiff;
        if (hashMap != null) {
            hashMap.put(Integer.valueOf(publishId), Integer.valueOf(videoPtsDtsMaxDiff));
        }
    }

    public void setVideoEncodeTimeDiff(int publishId, int videoEncodeTimeDiff) {
        HashMap<Integer, Integer> hashMap = mVideoEncodeTimeDiff;
        if (hashMap != null) {
            hashMap.put(Integer.valueOf(publishId), Integer.valueOf(videoEncodeTimeDiff));
        }
    }

    public void setCaptureType(int type) {
        mCaptureType = type;
    }

    public static String getBaseUploadVideoStatistics(int sendSeq) {
        if (sendSeq >= 3) {
            return "";
        }
        mBaseUploadDataHashMap.put("vver", CommonUtil.toURLEncoded(mVersion));
        mBaseUploadDataHashMap.put("model", CommonUtil.toURLEncoded(Build.MODEL));
        mBaseUploadDataHashMap.put("cpu", CommonUtil.toURLEncoded(mCpuName));
        mBaseUploadDataHashMap.put("gpu", CommonUtil.toURLEncoded(mGpuName));
        mBaseUploadDataHashMap.put(AnchorHiidoAssistantStatisticKey.H265SupportInfo, CommonUtil.toURLEncoded(String.valueOf(YYVideoCodec.getSupportH265Property())));
        String data = CommonUtil.getParamsOrderByKey(mBaseUploadDataHashMap);
        YMFLog.info(TAG, "[Procedur]", "statistic upload hiido data:" + data);
        return data;
    }

    public static String getUploadVideoStatistics(boolean bKeyStat, int publishId) {
        String data;
        if (bKeyStat) {
            int i2 = -1;
            mCoreUploadDataHashMap.put(AnchorHiidoCoreStatisticKey.PmDesiredEncodeWidth, Integer.valueOf(mPmDesiredEncodeWidth.containsKey(Integer.valueOf(publishId)) ? mPmDesiredEncodeWidth.get(Integer.valueOf(publishId)).intValue() : -1));
            mCoreUploadDataHashMap.put(AnchorHiidoCoreStatisticKey.PmDesiredEncodeHeight, Integer.valueOf(mPmDesiredEncodeHeight.containsKey(Integer.valueOf(publishId)) ? mPmDesiredEncodeHeight.get(Integer.valueOf(publishId)).intValue() : -1));
            mCoreUploadDataHashMap.put(AnchorHiidoCoreStatisticKey.PmDesiredEncodeBitrate, Integer.valueOf(mPmDesiredEncodeBitrate.containsKey(Integer.valueOf(publishId)) ? mPmDesiredEncodeBitrate.get(Integer.valueOf(publishId)).intValue() : -1));
            mCoreUploadDataHashMap.put(AnchorHiidoCoreStatisticKey.PmDesiredEncodeFps, Integer.valueOf(mPmDesiredEncodeFps.containsKey(Integer.valueOf(publishId)) ? mPmDesiredEncodeFps.get(Integer.valueOf(publishId)).intValue() : -1));
            mCoreUploadDataHashMap.put(AnchorHiidoCoreStatisticKey.CaptureDesiredFps, Integer.valueOf(YMFCamera.getInstance().getDesiredFps()));
            mCoreUploadDataHashMap.put(AnchorHiidoCoreStatisticKey.CaptureType, Integer.valueOf(mCaptureType));
            mCoreUploadDataHashMap.put("sw", Integer.valueOf(YMFCamera.getInstance().getCameraPreviewDesiredWidth()));
            mCoreUploadDataHashMap.put("sh", Integer.valueOf(YMFCamera.getInstance().getCameraPreviewDesiredHeight()));
            if (YMFCamera.getInstance().getPreviewSize() != null) {
                mCoreUploadDataHashMap.put(AnchorHiidoCoreStatisticKey.CaptureRealResolutionWidth, Integer.valueOf(YMFCamera.getInstance().getPreviewSize().getWidth()));
            } else {
                mCoreUploadDataHashMap.put(AnchorHiidoCoreStatisticKey.CaptureRealResolutionWidth, -1);
            }
            if (YMFCamera.getInstance().getPreviewSize() != null) {
                mCoreUploadDataHashMap.put(AnchorHiidoCoreStatisticKey.CaptureRealResolutionHeight, Integer.valueOf(YMFCamera.getInstance().getPreviewSize().getHeight()));
            } else {
                mCoreUploadDataHashMap.put(AnchorHiidoCoreStatisticKey.CaptureRealResolutionHeight, -1);
            }
            mCoreUploadDataHashMap.put(AnchorHiidoCoreStatisticKey.CaptureRealFps, Integer.valueOf(mCameraCaptureRealFrameRate));
            mCoreUploadDataHashMap.put(AnchorHiidoCoreStatisticKey.CaptureMeanLatency, Integer.valueOf(mCameraCaptureMeanLatency));
            mCoreUploadDataHashMap.put(AnchorHiidoCoreStatisticKey.VideoPreProcessMeanLatency, Integer.valueOf(mPreProcessMeanLatency));
            mCoreUploadDataHashMap.put(AnchorHiidoCoreStatisticKey.VideoPreProcessMaxLatency, Integer.valueOf(mPreProcessMaxLatency));
            mCoreUploadDataHashMap.put(AnchorHiidoCoreStatisticKey.VideoEncodeId, Integer.valueOf(mVideoEncodeId.containsKey(Integer.valueOf(publishId)) ? mVideoEncodeId.get(Integer.valueOf(publishId)).intValue() : -1));
            mCoreUploadDataHashMap.put(AnchorHiidoCoreStatisticKey.VideoEncodeWidth, Integer.valueOf(mVideoEncodeWidth.containsKey(Integer.valueOf(publishId)) ? mVideoEncodeWidth.get(Integer.valueOf(publishId)).intValue() : -1));
            mCoreUploadDataHashMap.put(AnchorHiidoCoreStatisticKey.VideoEncodeHeight, Integer.valueOf(mVideoEncodeHeight.containsKey(Integer.valueOf(publishId)) ? mVideoEncodeHeight.get(Integer.valueOf(publishId)).intValue() : -1));
            mCoreUploadDataHashMap.put(AnchorHiidoCoreStatisticKey.VideoEncodeDesiredFps, Integer.valueOf(mDesiredFps.containsKey(Integer.valueOf(publishId)) ? mDesiredFps.get(Integer.valueOf(publishId)).intValue() : -1));
            mCoreUploadDataHashMap.put(AnchorHiidoCoreStatisticKey.VideoEncodeRealFps, Integer.valueOf(mRealFps.containsKey(Integer.valueOf(publishId)) ? mRealFps.get(Integer.valueOf(publishId)).intValue() : -1));
            mCoreUploadDataHashMap.put(AnchorHiidoCoreStatisticKey.VideoEncodeDesiredBitrate, Integer.valueOf(mDesiredBitrate.containsKey(Integer.valueOf(publishId)) ? mDesiredBitrate.get(Integer.valueOf(publishId)).intValue() : -1));
            mCoreUploadDataHashMap.put(AnchorHiidoCoreStatisticKey.VideoEncodeRealMeanBitrate, Integer.valueOf(mRealMeanBitrate.containsKey(Integer.valueOf(publishId)) ? mRealMeanBitrate.get(Integer.valueOf(publishId)).intValue() : -1));
            mCoreUploadDataHashMap.put(AnchorHiidoCoreStatisticKey.VideoEncodeRealMaxBitrate, Integer.valueOf(mRealMaxBitrate.containsKey(Integer.valueOf(publishId)) ? mRealMaxBitrate.get(Integer.valueOf(publishId)).intValue() : -1));
            mCoreUploadDataHashMap.put(AnchorHiidoCoreStatisticKey.VideoEncodeMeanLatency, Integer.valueOf(mEncodeMeanLatency.containsKey(Integer.valueOf(publishId)) ? mEncodeMeanLatency.get(Integer.valueOf(publishId)).intValue() : -1));
            mCoreUploadDataHashMap.put(AnchorHiidoCoreStatisticKey.VideoEncodeMaxLatency, Integer.valueOf(mEncodeMaxLatency.containsKey(Integer.valueOf(publishId)) ? mEncodeMaxLatency.get(Integer.valueOf(publishId)).intValue() : -1));
            mCoreUploadDataHashMap.put(AnchorHiidoCoreStatisticKey.VideoCapture2EncodeLatency, Integer.valueOf(mVideoCapture2EncodeLatency.containsKey(Integer.valueOf(publishId)) ? mVideoCapture2EncodeLatency.get(Integer.valueOf(publishId)).intValue() : -1));
            mCoreUploadDataHashMap.put(AnchorHiidoCoreStatisticKey.VideoPtsMaxDiff, Integer.valueOf(mVideoPtsMaxDiff));
            mCoreUploadDataHashMap.put(AnchorHiidoCoreStatisticKey.VideoCaptureStallingIndication, Integer.valueOf(mVideoCaptureStallingIndication));
            mCoreUploadDataHashMap.put(AnchorHiidoCoreStatisticKey.VideoPtsDtsMaxDiff, Integer.valueOf(mVideoPtsDtsMaxDiff.containsKey(Integer.valueOf(publishId)) ? mVideoPtsDtsMaxDiff.get(Integer.valueOf(publishId)).intValue() : -1));
            ConcurrentHashMap<String, Object> concurrentHashMap = mCoreUploadDataHashMap;
            if (mVideoEncodeTimeDiff.containsKey(Integer.valueOf(publishId))) {
                i2 = mVideoEncodeTimeDiff.get(Integer.valueOf(publishId)).intValue();
            }
            concurrentHashMap.put(AnchorHiidoCoreStatisticKey.VideoEncodeTimeDiff, Integer.valueOf(i2));
            data = CommonUtil.getParamsOrderByKey(mCoreUploadDataHashMap);
        } else {
            data = CommonUtil.getParamsOrderByKey(mAssistantUploadDataHashMap);
        }
        YMFLog.info(TAG, "[Procedur]", "statistic upload hiido publishId:" + publishId + " data:" + data);
        return data;
    }

    public static void setPreviewFrameRate(long framerate) {
        mPreviewFrameRate = framerate;
    }

    public static void setDynamicEncodeFrameRate(long framerate) {
        mDynamicEncodeFrameRate = framerate;
    }

    public static int getDynamicEncodeFrameRate() {
        return (int) mDynamicEncodeFrameRate;
    }

    public static int getPreviewFrameRate() {
        return (int) mPreviewFrameRate;
    }
}
