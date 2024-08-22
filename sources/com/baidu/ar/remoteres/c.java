package com.baidu.ar.remoteres;

import com.baidu.ar.DuMixController;
import com.baidu.ar.libloader.a;
import java.io.File;

class c implements IDuMixResProcessor {

    /* renamed from: d  reason: collision with root package name */
    private static final String[] f10327d = {"ardatabasic", "AREngineCpp", "mml_framework"};

    /* renamed from: e  reason: collision with root package name */
    private static final String[] f10328e = {"dlModels/gesture"};

    /* renamed from: a  reason: collision with root package name */
    private boolean f10329a = false;

    /* renamed from: b  reason: collision with root package name */
    private boolean f10330b = false;

    /* renamed from: c  reason: collision with root package name */
    private boolean f10331c = false;

    c() {
    }

    private boolean a(File file) {
        try {
            for (String a2 : f10327d) {
                a.a(a2);
            }
            this.f10330b = false;
            return true;
        } catch (Throwable th2) {
            th2.printStackTrace();
            this.f10330b = true;
            return false;
        }
    }

    public void a(DuMixController duMixController, File file) {
        if (duMixController != null && !this.f10329a) {
            for (String file2 : f10328e) {
                File file3 = new File(file, file2);
                if (file3.exists()) {
                    duMixController.setMdlModelPath(file3.getAbsolutePath());
                }
            }
            this.f10330b = false;
            this.f10329a = true;
        }
    }

    public String getBusinessTag() {
        return "main";
    }

    public boolean isLoaded() {
        return this.f10329a;
    }

    public boolean isReady(File file, File file2) {
        if (this.f10330b) {
            return false;
        }
        if (this.f10329a) {
            return true;
        }
        if (!this.f10331c) {
            String[] strArr = f10327d;
            int length = strArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (!new File(file, "lib" + strArr[i2] + ".so").exists()) {
                    return false;
                }
            }
        }
        String[] strArr2 = f10328e;
        int length2 = strArr2.length;
        for (int i3 = 0; i3 < length2; i3++) {
            if (!new File(file2, strArr2[i3] + "/dl_config.json").exists()) {
                return false;
            }
        }
        return true;
    }

    public boolean load(DuMixController duMixController, File file, File file2) {
        return a(file);
    }

    public void setUseLocalLib() {
        this.f10331c = true;
    }
}
