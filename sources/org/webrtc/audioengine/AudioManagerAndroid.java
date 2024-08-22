package org.webrtc.audioengine;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaExtractor;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Looper;
import android.os.Process;
import com.alipay.sdk.m.c.a;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.StringTokenizer;

class AudioManagerAndroid implements AudioRoutingListener, VolumeChangeListener, AppBackgroundMonitorListener {
    private static final int DEFAULT_FRAMES_PER_BUFFER = 256;
    private static final int DEFAULT_SAMPLING_RATE = 44100;
    private static final String TAG = "[AudioManagerAndroid]";
    private static String mAppCachePath = "";
    private static HwAudioKaraokeFeature mHwAudioKaraokeFeature;
    private boolean initialized = false;
    private int mAudioLowLatencyOutputFrameSize;
    private boolean mAudioLowLatencySupported;
    private final AudioManager mAudioManager;
    private AudioRoutingController mAudioRoutingController;
    private final Context mContext;
    private int mNativeOutputSampleRate;
    private AppBackgroundMonitor mNotifyAppBackground;
    private Boolean mShouldNotify = false;
    private VolumeChangeReceiver mVolumeBroadcastReceiver;

    private static native void nativeLogDebugInfo(String str);

    private native void nativeNotifyAppBackground(boolean z);

    private native void nativeNotifyAudioRouteChanged(int i2);

    private native void nativeNotifyBluetoothPlug(int i2);

    private native void nativeNotifyBluetoothScoState(int i2);

    private native void nativeNotifyHeadsetPlug(int i2);

    private native void nativeNotifyPhoneCallReceive(int i2);

    private native void nativeNotifySystemVolumeChange(int i2);

    private AudioManagerAndroid(Context context) {
        this.mContext = context;
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        this.mAudioManager = audioManager;
        this.mNativeOutputSampleRate = 44100;
        this.mAudioLowLatencyOutputFrameSize = 256;
        if (Build.VERSION.SDK_INT >= 17) {
            String sampleRateString = audioManager.getProperty("android.media.property.OUTPUT_SAMPLE_RATE");
            if (sampleRateString != null) {
                int sampleRate = Integer.parseInt(sampleRateString);
                if (sampleRate == 8000 || sampleRate == 16000 || sampleRate == 32000 || sampleRate == 44100 || sampleRate == 48000) {
                    this.mNativeOutputSampleRate = sampleRate;
                    doLog("[AudioManagerAndroid]Android native sample rate: " + sampleRate);
                } else {
                    doLog("[AudioManagerAndroid]Unsupported sample rate: " + sampleRate);
                }
            }
            String framesPerBuffer = audioManager.getProperty("android.media.property.OUTPUT_FRAMES_PER_BUFFER");
            if (framesPerBuffer != null) {
                this.mAudioLowLatencyOutputFrameSize = Integer.parseInt(framesPerBuffer);
            }
        }
        try {
            this.mAudioLowLatencySupported = context.getPackageManager().hasSystemFeature("android.hardware.audio.low_latency");
        } catch (RuntimeException e2) {
            this.mAudioLowLatencySupported = false;
        }
        try {
            mAppCachePath = this.mContext.getExternalCacheDir().getPath();
            doLog("[AudioManagerAndroid]cache filepath: " + mAppCachePath);
        } catch (Exception e3) {
            doLog("[AudioManagerAndroid]getExternalCacheDir failed. exception: " + e3.getMessage());
        }
        this.mAudioRoutingController = new AudioRoutingController(this.mContext, this);
        this.mVolumeBroadcastReceiver = new VolumeChangeReceiver(this.mContext, this);
        this.mNotifyAppBackground = new AppBackgroundMonitor(this.mContext, this);
    }

    private void init(Context context) {
        if (!this.initialized) {
            doLog("[AudioManagerAndroid]audio mode is: " + this.mAudioManager.getMode());
            this.initialized = true;
        }
    }

    private void setNotify(int notify) {
        if (notify == 1) {
            synchronized (this.mShouldNotify) {
                this.mShouldNotify = true;
            }
            this.mAudioRoutingController.init();
            this.mVolumeBroadcastReceiver.init();
            this.mNotifyAppBackground.init();
            return;
        }
        this.mAudioRoutingController.uninit();
        this.mVolumeBroadcastReceiver.uninit();
        this.mNotifyAppBackground.uninit();
        synchronized (this.mShouldNotify) {
            this.mShouldNotify = false;
        }
    }

    private int getNativeOutputSampleRate() {
        return this.mNativeOutputSampleRate;
    }

    private boolean isAudioLowLatencySupported() {
        return this.mAudioLowLatencySupported;
    }

    private int getAudioLowLatencyOutputFrameSize() {
        return this.mAudioLowLatencyOutputFrameSize;
    }

    private static int getMode(Context context) {
        try {
            return ((AudioManager) context.getSystemService("audio")).getMode();
        } catch (Exception e2) {
            doLog("AudioManagerAndroid getMode error");
            return 0;
        }
    }

    private static int getMaxDeviceVolume(Context context, int mode) {
        try {
            return ((AudioManager) context.getSystemService("audio")).getStreamMaxVolume(mode);
        } catch (Exception e2) {
            doLog("AudioManagerAndroid getMode error");
            return 0;
        }
    }

    private static int getCurDeviceVolume(Context context, int mode) {
        try {
            return ((AudioManager) context.getSystemService("audio")).getStreamVolume(mode);
        } catch (Exception e2) {
            doLog("AudioManagerAndroid getMode error");
            return 0;
        }
    }

    private void setSpeakerphoneOn(Context context, boolean on) {
        AudioRoutingController audioRoutingController = this.mAudioRoutingController;
        if (audioRoutingController != null) {
            audioRoutingController.setSpeakerphoneOn(on);
        }
    }

    private int queryAudioOutputRouting() {
        int ret = -1;
        AudioRoutingController audioRoutingController = this.mAudioRoutingController;
        if (audioRoutingController != null) {
            ret = audioRoutingController.queryAudioOutputRouting();
        }
        doLog("[AudioManagerAndroid]queryAudioOutputRouting: " + ret);
        return ret;
    }

    private boolean isSpeakerphoneOn() {
        AudioRoutingController audioRoutingController = this.mAudioRoutingController;
        if (audioRoutingController != null) {
            return audioRoutingController.isSpeakerphoneOn();
        }
        return false;
    }

    private static int isBlueToothConnected(Context context) {
        if (Build.VERSION.SDK_INT >= 31 || (AudioRoutingController.hasPermission(context, "android.permission.BLUETOOTH") && AudioRoutingController.hasPermission(context, "android.permission.BLUETOOTH_ADMIN"))) {
            if (Build.VERSION.SDK_INT >= 31 && !AudioRoutingController.hasPermission(context, "android.permission.BLUETOOTH_CONNECT")) {
                doLog("[AudioManagerAndroid]BLUETOOTH_CONNECT permission failed.");
            }
            return AudioRoutingController.isBluetoothHeadsetConnected(context) ? 1 : 0;
        }
        doLog("[AudioManagerAndroid]BLUETOOTH/BLUETOOTH_ADMIN permission failed.");
        return 0;
    }

    private static int isHeadsetPlugin(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        return Build.VERSION.SDK_INT < 23 ? audioManager.isWiredHeadsetOn() ? 1 : 0 : AudioRoutingController.isWiredHeadsetAvailable(audioManager) ? 1 : 0;
    }

    private static void setMode(final Context context, final int mode) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            AsyncTask.execute(new Runnable() {
                public void run() {
                    AudioManagerAndroid.setModeInner(context, mode);
                }
            });
        } else {
            setModeInner(context, mode);
        }
    }

    /* access modifiers changed from: private */
    public static void setModeInner(Context context, int mode) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        try {
            int mMediaMaxVolume = audioManager.getStreamMaxVolume(3);
            int mCurrMediaVolume = audioManager.getStreamVolume(3);
            int mVoipMaxVolume = audioManager.getStreamMaxVolume(0);
            int mCurrVoipVolume = audioManager.getStreamVolume(0);
            int origMode = audioManager.getMode();
            audioManager.setMode(mode);
            doLog("[AudioManagerAndroid]setMode : " + origMode + " >> " + mode);
            doLog("[AudioManagerAndroid] systemMediaVol: " + mCurrMediaVolume + " systemMediaMaxVol:" + mMediaMaxVolume + " mediaVolLevel: " + ((((float) mCurrMediaVolume) / ((float) mMediaMaxVolume)) * 100.0f) + "%");
            doLog("[AudioManagerAndroid] systemVoipVol:" + mCurrVoipVolume + " systemVoipMaxVol: " + mVoipMaxVolume + " voipVolLevel:" + (100.0f * (((float) mCurrVoipVolume) / ((float) mVoipMaxVolume))) + "%");
        } catch (Exception e2) {
            doLog("[AudioManagerAndroid]setMode failed: " + e2.getMessage().toString());
        }
    }

    private void startOrStopBluetoothSco(Context context, boolean start) {
        AudioRoutingController audioRoutingController = this.mAudioRoutingController;
        if (audioRoutingController != null) {
            audioRoutingController.startOrStopBluetoothSco(start);
        }
    }

    private static byte[] getBlueToothDeviceName(Context context) {
        String deviceName = "";
        if (Build.VERSION.SDK_INT < 31 || AudioRoutingController.hasPermission(context, "android.permission.BLUETOOTH_CONNECT")) {
            deviceName = AudioRoutingController.getBlueToothDeviceName();
        } else {
            doLog("[AudioManagerAndroid]getBlueToothDeviceName BLUETOOTH_CONNECT permission failed.");
        }
        return deviceName.getBytes();
    }

    private boolean isBluetoothScoOn() {
        AudioRoutingController audioRoutingController = this.mAudioRoutingController;
        if (audioRoutingController != null) {
            return audioRoutingController.isBluetoothScoOn();
        }
        return false;
    }

    private void checkPhoneStateListener() {
        AudioRoutingController audioRoutingController = this.mAudioRoutingController;
        if (audioRoutingController != null) {
            audioRoutingController.checkPhoneStateListener();
        }
    }

    public static void doLog(String msg) {
        nativeLogDebugInfo(msg);
    }

    private static boolean isMultiAudioTrackFile(String filePath) {
        boolean result = false;
        try {
            MediaExtractor mediaExtractor = new MediaExtractor();
            mediaExtractor.setDataSource(filePath);
            int nTracks = mediaExtractor.getTrackCount();
            int nAudioTracks = 0;
            for (int i2 = 0; i2 < nTracks; i2++) {
                if (mediaExtractor.getTrackFormat(i2).getString("mime").contains("audio/")) {
                    nAudioTracks++;
                }
            }
            if (nAudioTracks > 1) {
                result = true;
            }
            mediaExtractor.release();
        } catch (Exception e2) {
            doLog("[AudioManagerAndroid]isMultiAudioTrackFile exception: " + e2.getMessage());
        }
        return result;
    }

    private static boolean isSupportHuaWeiSystemKaraoke() {
        boolean result = false;
        try {
            String emuiStr = getEMUI();
            if (emuiStr == null) {
                result = false;
            } else {
                doLog("[AudioManagerAndroid]emuiStr: " + emuiStr);
                result = Integer.parseInt(emuiStr.substring(10, emuiStr.indexOf("."))) >= 10;
            }
        } catch (Exception e2) {
            doLog("[AudioManagerAndroid]isSupportHuaWeiSystemKaraoke exception: " + e2.getMessage());
        }
        doLog("[AudioManagerAndroid]isSupportHuaWeiSystemKaraoke: " + result);
        return result;
    }

    private static String getEMUI() {
        if (Build.VERSION.SDK_INT < 19) {
            return null;
        }
        try {
            Class<?> classType = Class.forName("android.os.SystemProperties");
            return (String) classType.getDeclaredMethod("get", new Class[]{String.class}).invoke(classType, new Object[]{a.f2101a});
        } catch (Exception e2) {
            doLog("[AudioManagerAndroid]getEMUI exception: " + e2.getMessage());
            return null;
        }
    }

    private static boolean isSupportVivoSystemKaraoke(Context context) {
        boolean result = false;
        try {
            StringTokenizer st = new StringTokenizer(((AudioManager) context.getSystemService("audio")).getParameters("vivo_ktv_mic_type"), "=");
            if (st.countTokens() != 2) {
                result = false;
            } else if (st.nextToken().equals("vivo_ktv_mic_type")) {
                int state = Integer.parseInt(st.nextToken());
                if (state == 1 || state == 0) {
                    result = true;
                }
            }
        } catch (Exception ex) {
            doLog("[AudioManagerAndroid]isSupportVivoSystemKaraoke exception: " + ex.getMessage());
        }
        doLog("[AudioManagerAndroid]isSupportVivoSystemKaraoke: " + result);
        return result;
    }

    public static boolean setThreadPriorityAudio(int tid, int priority) {
        int priority2;
        if (Build.VERSION.SDK_INT != 16 || !(Build.BRAND.toLowerCase() + "-" + Build.MODEL.toLowerCase()).equals("samsung-gt-s6818")) {
            if (priority == 4) {
                priority2 = -16;
            } else {
                priority2 = -19;
            }
            doLog("setThreadPriorityAudio " + tid + " pri:" + priority2);
            Process.setThreadPriority(tid, priority2);
            return false;
        }
        doLog("setThreadPriorityAudio " + tid);
        Process.setThreadPriority(tid, -16);
        return true;
    }

    private static int getAndroidOSVersion() {
        return Build.VERSION.SDK_INT;
    }

    private static byte[] getSystemProperty(byte[] name) {
        try {
            if (!new String(name).equals("ro.product.cpu.abilist")) {
                String p = System.getProperty(new String(name));
                if (p != null) {
                    return p.getBytes();
                }
                doLog("[AudioManagerAndroid]getSystemProperty " + name + " failed.");
                return " ".getBytes();
            } else if (Build.VERSION.SDK_INT >= 21) {
                return Build.SUPPORTED_ABIS[0].getBytes();
            } else {
                return Build.CPU_ABI.getBytes();
            }
        } catch (Exception ex) {
            doLog("[AudioManagerAndroid]getSystemProperty error, ex: " + ex.getMessage());
            return "".getBytes();
        }
    }

    private static byte[] getAssetsFileData(Context context, String filename) {
        if (context == null || filename.isEmpty()) {
            return null;
        }
        BufferedInputStream bufferedInputStream = null;
        ByteBuffer outBuffer = null;
        int bufferLength = 0;
        int readLength = 0;
        try {
            InputStream inputStream = context.getAssets().open(filename);
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(inputStream);
            bufferLength = inputStream.available();
            outBuffer = ByteBuffer.allocateDirect(bufferLength);
            outBuffer.rewind();
            byte[] tmpBytes = new byte[1024000];
            while (bufferLength > readLength) {
                int len = bufferedInputStream2.read(tmpBytes);
                outBuffer.put(tmpBytes, 0, len);
                readLength += len;
            }
            try {
                bufferedInputStream2.close();
            } catch (IOException e2) {
                doLog("GetAssetsFile: bufferedInputStream close failed");
            }
        } catch (IOException e3) {
            e3.printStackTrace();
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
        } catch (Throwable th2) {
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e4) {
                    doLog("GetAssetsFile: bufferedInputStream close failed");
                }
            }
            throw th2;
        }
        if (bufferLength != readLength || outBuffer == null) {
            return null;
        }
        byte[] outBytes = new byte[bufferLength];
        outBuffer.rewind();
        outBuffer.get(outBytes);
        return outBytes;
    }

    private static byte[] getExternalCacheDir() {
        return mAppCachePath.getBytes();
    }

    private static void initHwLowLatency(Context context) {
        if (context == null) {
            doLog("[AudioManagerAndroid]initHwLowLatency context is null ");
        } else if (mHwAudioKaraokeFeature == null) {
            HwAudioKaraokeFeature hwAudioKaraokeFeature = new HwAudioKaraokeFeature();
            mHwAudioKaraokeFeature = hwAudioKaraokeFeature;
            hwAudioKaraokeFeature.init(context);
        }
    }

    private static void terminateHwLowLatency() {
        HwAudioKaraokeFeature hwAudioKaraokeFeature = mHwAudioKaraokeFeature;
        if (hwAudioKaraokeFeature != null) {
            hwAudioKaraokeFeature.terminate();
            mHwAudioKaraokeFeature = null;
        }
    }

    public void onAudioRoutingChanged(int routing) {
        synchronized (this.mShouldNotify) {
            if (this.mShouldNotify.booleanValue()) {
                nativeNotifyAudioRouteChanged(routing);
            }
        }
    }

    public void onBluetoothState(int state) {
        synchronized (this.mShouldNotify) {
            if (this.mShouldNotify.booleanValue()) {
                nativeNotifyBluetoothPlug(state);
            }
        }
    }

    public void onBluetoothScoState(int state) {
        synchronized (this.mShouldNotify) {
            if (this.mShouldNotify.booleanValue()) {
                nativeNotifyBluetoothScoState(state);
            }
        }
    }

    public void onHeadsetState(int state) {
        synchronized (this.mShouldNotify) {
            if (this.mShouldNotify.booleanValue()) {
                nativeNotifyHeadsetPlug(state);
            }
        }
    }

    public void onPhoneCallState(int state) {
        synchronized (this.mShouldNotify) {
            if (this.mShouldNotify.booleanValue()) {
                nativeNotifyPhoneCallReceive(state);
            }
        }
    }

    public void onSystemVolumeChange(int volume) {
        synchronized (this.mShouldNotify) {
            if (this.mShouldNotify.booleanValue()) {
                nativeNotifySystemVolumeChange(volume);
            }
        }
    }

    public void notifyAppBackground(boolean isbg) {
        synchronized (this.mShouldNotify) {
            if (this.mShouldNotify.booleanValue()) {
                nativeNotifyAppBackground(isbg);
            }
        }
    }

    private static boolean hasRecordPermission(Context context) {
        return WebRtcAudioRecord.hasRecPermission(context, "android.permission.RECORD_AUDIO");
    }
}
