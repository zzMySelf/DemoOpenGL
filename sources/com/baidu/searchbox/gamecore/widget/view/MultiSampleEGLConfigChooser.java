package com.baidu.searchbox.gamecore.widget.view;

import android.opengl.GLSurfaceView;
import com.baidu.webkit.internal.monitor.MonitorType;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

public class MultiSampleEGLConfigChooser implements GLSurfaceView.EGLConfigChooser {
    private static final boolean DEBUG = false;
    private static final String TAG = MultiSampleEGLConfigChooser.class.getSimpleName();
    private boolean mUsesCoverageAa;
    private int[] mValue;

    public EGLConfig chooseConfig(EGL10 egl, EGLDisplay display) {
        int[] configSpec;
        int numConfigs;
        int[] iArr = new int[1];
        this.mValue = iArr;
        int[] configSpec2 = {MonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 8, MonitorType.MONITOR_TYPE_INIT_WEBKIT, 8, 12322, 8, 12321, 8, 12325, 16, 12352, 4, 12338, 1, 12337, 4, 12344};
        int numConfigs2 = iArr[0];
        if (numConfigs2 <= 0) {
            int[] configSpec3 = {MonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 8, MonitorType.MONITOR_TYPE_INIT_WEBKIT, 8, 12322, 8, 12321, 8, 12325, 16, 12352, 4, 12512, 1, 12513, 2, 12344};
            int numConfigs3 = iArr[0];
            if (numConfigs3 <= 0) {
                configSpec = new int[]{MonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 8, MonitorType.MONITOR_TYPE_INIT_WEBKIT, 8, 12322, 8, 12321, 8, 12325, 16, 12352, 4, 12344};
                if (egl.eglChooseConfig(display, configSpec, (EGLConfig[]) null, 0, iArr)) {
                    int numConfigs4 = this.mValue[0];
                    if (numConfigs4 > 0) {
                        numConfigs = numConfigs4;
                    } else {
                        throw new IllegalArgumentException("No configs match configSpec");
                    }
                } else {
                    throw new IllegalArgumentException("3rd eglChooseConfig failed");
                }
            } else {
                this.mUsesCoverageAa = true;
                configSpec = configSpec3;
                numConfigs = numConfigs3;
            }
        } else {
            configSpec = configSpec2;
            numConfigs = numConfigs2;
        }
        EGLConfig[] configs = new EGLConfig[numConfigs];
        if (egl.eglChooseConfig(display, configSpec, configs, numConfigs, this.mValue)) {
            int index = -1;
            int i2 = 0;
            while (true) {
                if (i2 >= configs.length) {
                    break;
                }
                if (findConfigAttrib(egl, display, configs[i2], 12321, 0) == 8) {
                    index = i2;
                    break;
                }
                i2++;
            }
            EGLConfig config = configs.length > 0 ? configs[index] : null;
            if (config != null) {
                return config;
            }
            throw new IllegalArgumentException("No config chosen");
        }
        throw new IllegalArgumentException("data eglChooseConfig failed");
    }

    private int findConfigAttrib(EGL10 egl, EGLDisplay display, EGLConfig config, int attribute, int defaultValue) {
        if (egl.eglGetConfigAttrib(display, config, attribute, this.mValue)) {
            return this.mValue[0];
        }
        return defaultValue;
    }

    public boolean usesCoverageAa() {
        return this.mUsesCoverageAa;
    }
}
