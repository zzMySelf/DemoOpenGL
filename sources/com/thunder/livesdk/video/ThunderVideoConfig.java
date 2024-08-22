package com.thunder.livesdk.video;

import android.os.Build;
import com.thunder.livesdk.helper.ThunderNative;
import com.thunder.livesdk.log.ThunderLog;
import com.yy.videoplayer.decoder.H264DecRender;
import com.yy.videoplayer.decoder.H265DecRender;
import com.yy.videoplayer.decoder.HardDecodeDirectRenderConfig;
import com.yy.videoplayer.decoder.YYVideoLibMgr;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicBoolean;

public class ThunderVideoConfig {
    /* access modifiers changed from: private */
    public static boolean bRooted = false;
    /* access modifiers changed from: private */
    public static boolean bWindowSurfaceSupported = false;
    /* access modifiers changed from: private */
    public static Support h264HwDecoderSupport = Support.SUPPORTED;
    /* access modifiers changed from: private */
    public static Support h265HwDecoderSupport = Support.SUPPORTED;
    private static final Object testWindowSurfaceLocker = new Object();
    private HardDecodeDirectRenderConfig mHardDirectRender = new HardDecodeDirectRenderConfig();

    private enum Support {
        SUPPORTED,
        UNSUPPORTED,
        UNCERTAIN
    }

    /* access modifiers changed from: package-private */
    public void AsyncLoad() {
        new Thread(new LoadThread(), "yrtcVideoConfig").start();
    }

    private class LoadThread implements Runnable {
        private LoadThread() {
        }

        public void run() {
            try {
                boolean unused = ThunderVideoConfig.bRooted = ThunderVideoConfig.this.testRooted();
                try {
                    Thread.sleep(500);
                } catch (Exception e2) {
                    ThunderLog.error(ThunderLog.kLogTagVideo, "Exception:" + e2.toString());
                }
                Integer enable = Integer.valueOf(ThunderNative.getHardDecodeDirectRenderConfig());
                YYVideoLibMgr.instance().setConfig(0, enable);
                ThunderLog.release(ThunderLog.kLogTagVideo, "load finish - build version:" + Build.VERSION.SDK_INT + ", h264HwDecoderSupport:" + ThunderVideoConfig.h264HwDecoderSupport.name() + ", h265HwDecoderSupport:" + ThunderVideoConfig.h265HwDecoderSupport.name() + ", isRooted:" + ThunderVideoConfig.bRooted + ", isWindowSurfaceSupported:" + ThunderVideoConfig.bWindowSurfaceSupported + ", getHardDecodeDirectRenderConfig:" + enable);
            } catch (Exception e3) {
                ThunderLog.error(ThunderLog.kLogTagVideo, "load error:" + e3.getMessage());
            }
        }
    }

    private static class TestWindowSurfaceTask implements Runnable {
        private AtomicBoolean mResult = null;

        TestWindowSurfaceTask(AtomicBoolean waiter) {
            this.mResult = waiter;
        }

        public void run() {
        }
    }

    private static boolean testWindowSurfaceCreation() {
        boolean ret;
        AtomicBoolean result = new AtomicBoolean(false);
        Thread thread = new Thread(new TestWindowSurfaceTask(result), "YY_TestWindowSurface_Thread");
        Object obj = testWindowSurfaceLocker;
        synchronized (obj) {
            try {
                thread.start();
                obj.wait(500);
                ret = result.get();
            } catch (Exception e2) {
                ret = false;
            }
        }
        if (ThunderLog.isInfoValid()) {
            ThunderLog.info(ThunderLog.kLogTagVideo, "testWindowSurfaceCreation ret:" + ret);
        }
        return ret;
    }

    /* access modifiers changed from: private */
    public boolean testRooted() {
        boolean isRooted;
        try {
            isRooted = (new File("/system/bin/su").exists() && testFileExecutable("/system/bin/su")) || (new File("/system/xbin/su").exists() && testFileExecutable("/system/xbin/su"));
        } catch (Throwable th2) {
            isRooted = false;
        }
        if (ThunderLog.isInfoValid()) {
            ThunderLog.info(ThunderLog.kLogTagVideo, "testRooted: " + isRooted);
        }
        return isRooted;
    }

    private boolean testFileExecutable(String filePath) {
        Process p = null;
        try {
            p = Runtime.getRuntime().exec("ls -l " + filePath);
            String str = new BufferedReader(new InputStreamReader(p.getInputStream())).readLine();
            if (ThunderLog.isInfoValid()) {
                ThunderLog.info(ThunderLog.kLogTagVideo, "testFileExecutable " + str);
            }
            if (str != null && str.length() >= 4) {
                char flag = str.charAt(3);
                if (flag == 's' || flag == 'x') {
                    if (p != null) {
                        p.destroy();
                    }
                    return true;
                }
            }
            if (p == null) {
                return false;
            }
        } catch (IOException e2) {
            if (ThunderLog.isInfoValid()) {
                ThunderLog.info(ThunderLog.kLogTagVideo, "testFileExecutable failed:" + e2.getMessage());
            }
            if (p == null) {
                return false;
            }
        } catch (Throwable th2) {
            if (p != null) {
                p.destroy();
            }
            throw th2;
        }
        p.destroy();
        return false;
    }

    public static boolean isRooted() {
        return bRooted;
    }

    public static boolean isWindowSurfaceSupport() {
        return bWindowSurfaceSupported;
    }

    public static boolean isHw264DecodeEnabled() {
        return h264HwDecoderSupport != Support.UNSUPPORTED && H264DecRender.IsAvailable();
    }

    public static boolean isHw265DecodeEnabled() {
        return h265HwDecoderSupport != Support.UNSUPPORTED && H265DecRender.IsAvailable();
    }
}
