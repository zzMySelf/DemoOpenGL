package com.baidu.ar.remoteres;

import com.baidu.ar.DuMixController;
import com.baidu.rtc.nps.plugin.data.RtcParameterSettings;
import java.io.File;

class a implements IDuMixResProcessor {

    /* renamed from: d  reason: collision with root package name */
    private static final String[] f10319d = {RtcParameterSettings.VideoCodecId.JPEG, "turbojpeg", "protobuf", "module_recg"};

    /* renamed from: a  reason: collision with root package name */
    private boolean f10320a = false;

    /* renamed from: b  reason: collision with root package name */
    private boolean f10321b = false;

    /* renamed from: c  reason: collision with root package name */
    private boolean f10322c = false;

    a() {
    }

    public String getBusinessTag() {
        return "cloud_recognize";
    }

    public boolean isLoaded() {
        return this.f10320a;
    }

    public boolean isReady(File file, File file2) {
        if (this.f10321b) {
            return false;
        }
        if (!this.f10320a && !this.f10322c) {
            String[] strArr = f10319d;
            int length = strArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (!new File(file, "lib" + strArr[i2] + ".so").exists()) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean load(DuMixController duMixController, File file, File file2) {
        try {
            if (!this.f10322c) {
                for (String a2 : f10319d) {
                    com.baidu.ar.libloader.a.a(a2);
                }
            }
            this.f10320a = true;
            this.f10321b = false;
            return true;
        } catch (Throwable th2) {
            th2.printStackTrace();
            this.f10321b = true;
            return false;
        }
    }

    public void setUseLocalLib() {
        this.f10322c = true;
    }
}
