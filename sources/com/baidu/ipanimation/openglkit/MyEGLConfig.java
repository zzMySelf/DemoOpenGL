package com.baidu.ipanimation.openglkit;

import com.baidu.searchbox.afx.gl.GLTextureView;
import com.baidu.webkit.internal.monitor.MonitorType;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

class MyEGLConfig implements GLTextureView.EGLConfigChooser {
    MyEGLConfig() {
    }

    public EGLConfig chooseConfig(EGL10 egl, EGLDisplay display) {
        EGLConfig[] configs = new EGLConfig[1];
        int[] configCounts = new int[1];
        egl.eglChooseConfig(display, new int[]{12329, 0, 12352, 4, 12351, 12430, MonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 8, MonitorType.MONITOR_TYPE_INIT_WEBKIT, 8, 12322, 8, 12325, 16, 12338, 1, 12337, 4, 12344}, configs, 1, configCounts);
        if (configCounts[0] == 0) {
            return null;
        }
        return configs[0];
    }
}
