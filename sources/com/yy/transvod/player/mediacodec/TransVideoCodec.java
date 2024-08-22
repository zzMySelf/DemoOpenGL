package com.yy.transvod.player.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.util.Log;
import android.view.Surface;
import com.yy.mediaframework.stat.VideoDataStatistic;
import com.yy.transvod.player.log.TLog;

public class TransVideoCodec {
    public static final int DEFAULT_H265 = -1;
    public static final int IFRAME_INTERVAL = 3;
    public static final String MIME_H264 = "video/avc";
    public static final String MIME_H265 = "video/hevc";
    public static final int SUPPORT_H265_DECODE = 1;
    public static final int SUPPORT_H265_ENCODE = 2;
    public static final int SUPPORT_H265_ENCODE_DECODE = 3;
    public static final String TAG = "TransVideoCodec";
    public static final int UNSUPPORT_H265 = 0;
    private static String mEncoderH264Name = "";
    private static String mEncoderH265Name = "";
    private static Object mLock = new Object();
    public static int mSupportH265 = -1;

    private static boolean testVideoEncoderCrash(String mime) {
        StringBuilder sb;
        boolean crashed = false;
        MediaCodec encoder = null;
        Surface surface = null;
        try {
            MediaFormat format = MediaFormat.createVideoFormat(mime, 720, 1280);
            format.setInteger("color-format", 2130708361);
            format.setInteger("bitrate", 2000000);
            format.setInteger("frame-rate", 30);
            format.setInteger("i-frame-interval", 3);
            if (Build.VERSION.SDK_INT >= 21) {
                format.setInteger("bitrate-mode", 2);
            }
            TLog.info(TAG, "testVideoEncoder mime:" + mime + ", MediaCodec format:" + format);
            MediaCodec encoder2 = MediaCodec.createEncoderByType(mime);
            String encoderName = encoder2.getName();
            if (mime.equals("video/avc")) {
                mEncoderH264Name = encoderName;
            } else if (mime.equals("video/hevc")) {
                mEncoderH265Name = encoderName;
            }
            TLog.info(TAG, "testVideoEncoder mime:" + mime + ", MediaCodec encoder:" + encoderName);
            encoder2.configure(format, (Surface) null, (MediaCrypto) null, 1);
            Surface surface2 = encoder2.createInputSurface();
            encoder2.start();
            if (encoder2 != null) {
                if (surface2 != null) {
                    try {
                        surface2.release();
                    } catch (Throwable th2) {
                        throwable = th2;
                        sb = new StringBuilder();
                        TLog.error(TAG, sb.append("release test encoder error! mime:").append(mime).append(", reason:").append(throwable).toString());
                        return crashed;
                    }
                }
                encoder2.stop();
                encoder2.release();
            }
        } catch (Throwable th3) {
            throwable = th3;
            sb = new StringBuilder();
            TLog.error(TAG, sb.append("release test encoder error! mime:").append(mime).append(", reason:").append(throwable).toString());
            return crashed;
        }
        return crashed;
    }

    private static boolean testVideoDecoderCrash(String mime) {
        StringBuilder sb;
        boolean crashed = false;
        MediaCodec decoder = null;
        int colorFormat = 0;
        try {
            MediaFormat format = MediaFormat.createVideoFormat(mime, 720, 1280);
            MediaCodec decoder2 = MediaCodec.createDecoderByType(mime);
            if (Build.VERSION.SDK_INT >= 18) {
                int[] iArr = decoder2.getCodecInfo().getCapabilitiesForType(mime).colorFormats;
                int length = iArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    int c2 = iArr[i2];
                    if (c2 == 19) {
                        colorFormat = 19;
                        break;
                    }
                    if (c2 == 21) {
                        colorFormat = 21;
                    }
                    i2++;
                }
                format.setInteger("color-format", colorFormat);
            }
            decoder2.configure(format, (Surface) null, (MediaCrypto) null, 0);
            decoder2.start();
            TLog.info(TAG, "testVideoDecoder mime:" + mime + ", MediaCodec format:" + format);
            if (decoder2 != null) {
                try {
                    decoder2.stop();
                    decoder2.release();
                } catch (Throwable th2) {
                    throwable = th2;
                    sb = new StringBuilder();
                }
            }
        } catch (Throwable th3) {
            throwable = th3;
            sb = new StringBuilder();
        }
        return crashed;
        TLog.error(TAG, sb.append("release test encoder error! mime:").append(mime).append(", reason:").append(Log.getStackTraceString(throwable)).toString());
        return crashed;
    }

    public static void testSupportH265Encode() {
        synchronized (mLock) {
            boolean isHardEncodeAvailable = Build.VERSION.SDK_INT >= 18;
            boolean h265Crashed = testVideoEncoderCrash("video/hevc");
            if (1 == 0 || h265Crashed || !isHardEncodeAvailable) {
                mSupportH265 = 0;
                TLog.warn(TAG, "testVideoEncoderSupport h265 isSupportH265:" + true + " h265Crashed " + h265Crashed + " mSupportH265 " + mSupportH265);
            } else {
                mSupportH265 = 3;
                TLog.warn(TAG, "testVideoEncoderSupport h265 isSupportH265Encode:" + true + " h265Crashed " + h265Crashed + " mSupportH265 " + mSupportH265);
            }
        }
    }

    public static void testSupportH265Decode() {
        synchronized (mLock) {
            boolean isHardEncodeAvailable = Build.VERSION.SDK_INT >= 18;
            boolean h265Crashed = testVideoDecoderCrash("video/hevc");
            if (1 == 0 || h265Crashed || !isHardEncodeAvailable) {
                mSupportH265 = 0;
                TLog.warn(TAG, "testSupportH265Decode h265 isSupportH265Decode:" + true + " h265Crashed " + h265Crashed + " mSupportH265 " + 0);
            } else {
                mSupportH265 = 1;
                TLog.warn(TAG, "testSupportH265Decode h265 isSupportH265:" + true + " h265Crashed " + h265Crashed + " mSupportH265 " + 1);
            }
        }
    }

    public static int getSupportH265() {
        if (mSupportH265 == -1) {
            testSupportH265Encode();
            if (mSupportH265 == 3) {
                return 3;
            }
            testSupportH265Decode();
            if (mSupportH265 == 1) {
                return 1;
            }
        }
        return mSupportH265;
    }

    public static boolean isH265EncoderSupport() {
        int count = MediaCodecList.getCodecCount();
        for (int i2 = 0; i2 < count; i2++) {
            String name = MediaCodecList.getCodecInfoAt(i2).getName();
            if (name != null && name.toLowerCase().contains(VideoDataStatistic.AnchorHiidoAssistantStatisticKey.H265SupportInfo) && !isSWCodec(name)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSWCodec(String codecName) {
        if (!codecName.startsWith("OMX.google.") && codecName.startsWith("OMX.")) {
            return false;
        }
        return true;
    }
}
