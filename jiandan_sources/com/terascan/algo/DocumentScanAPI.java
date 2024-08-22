package com.terascan.algo;

import android.content.res.AssetManager;
import com.getkeepsafe.relinker.ReLinker;
import fe.mmm.qw.ppp.qw;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class DocumentScanAPI {
    public static final String NAME = "com.tera.scan";
    public static final int SCAN_TYPE_CARD = 0;
    public static final int SCAN_TYPE_DOCUMENT = 1;
    public static final String TAG = "DocumentScanAPI";
    public long algoPtr = -1;
    public DocumentScanJNI documentScanJNI = new DocumentScanJNI();
    public AssetManager manager;
    public AtomicInteger reference = new AtomicInteger(0);
    public AtomicBoolean shouldRelease = new AtomicBoolean(false);

    static {
        try {
            ReLinker.qw(qw.qw.qw(), DocumentEnhanceAPI.LIBRARY_NAME);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public DocumentScanAPI(AssetManager assetManager) {
        this.manager = assetManager;
    }

    private boolean decrementAndGetReference() {
        try {
            this.reference.decrementAndGet();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean incrementAndGetReference() {
        try {
            this.reference.incrementAndGet();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private void tryRelease() {
        try {
            int i2 = this.reference.get();
            boolean z = this.shouldRelease.get();
            if (i2 <= 0 && z) {
                this.documentScanJNI.nativeReleaseAlgoInstance(this.algoPtr);
                this.algoPtr = -1;
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public DocumentResult detect(byte[] bArr, int i2, int i3, boolean z) {
        if (!(bArr == null || this.algoPtr == -1 || this.shouldRelease.get())) {
            boolean incrementAndGetReference = incrementAndGetReference();
            try {
                DocumentResult nativeScan = this.documentScanJNI.nativeScan(this.algoPtr, bArr, (long) bArr.length, i2, i3, z);
                if (incrementAndGetReference) {
                    decrementAndGetReference();
                }
                tryRelease();
                return nativeScan;
            } catch (Throwable th2) {
                if (incrementAndGetReference) {
                    decrementAndGetReference();
                }
                tryRelease();
                throw th2;
            }
        }
        return null;
    }

    public boolean init(String str, String str2, boolean z, boolean z2) {
        byte[] bArr;
        byte[] bArr2;
        String str3 = str2;
        try {
            if (this.algoPtr != -1) {
                return true;
            }
            if (z) {
                bArr = loadLocalFile(str);
            } else {
                bArr = loadAssetsFile(str);
            }
            byte[] bArr3 = bArr;
            if (z2) {
                bArr2 = loadLocalFile(str3);
            } else {
                bArr2 = loadAssetsFile(str3);
            }
            byte[] bArr4 = bArr2;
            this.algoPtr = this.documentScanJNI.nativeCreateAlgoInstance(bArr3, (long) bArr3.length, bArr4, (long) bArr4.length, "com.tera.scan");
            this.reference.set(0);
            this.shouldRelease.set(false);
            return this.algoPtr != -1;
        } catch (Exception unused) {
        }
    }

    public Boolean isInit() {
        return Boolean.valueOf(this.algoPtr != -1 && !this.shouldRelease.get());
    }

    public byte[] loadAssetsFile(String str) throws IOException {
        InputStream open = this.manager.open(str);
        byte[] bArr = new byte[open.available()];
        open.read(bArr);
        open.close();
        return bArr;
    }

    public byte[] loadLocalFile(String str) throws IOException {
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        byte[] bArr = new byte[((int) file.length())];
        FileInputStream fileInputStream = new FileInputStream(file);
        fileInputStream.read(bArr);
        fileInputStream.close();
        return bArr;
    }

    public byte[] rectify(byte[] bArr, ArrayList<Point> arrayList, int i2, int i3, int i4, int i5) {
        byte[] bArr2 = bArr;
        if (!(bArr2 == null || this.algoPtr == -1 || this.shouldRelease.get())) {
            boolean incrementAndGetReference = incrementAndGetReference();
            try {
                byte[] nativeRectify = this.documentScanJNI.nativeRectify(this.algoPtr, bArr, (long) bArr2.length, arrayList, i2, i3, i4, i5, false);
                if (incrementAndGetReference) {
                    decrementAndGetReference();
                }
                tryRelease();
                return nativeRectify;
            } catch (Throwable th2) {
                Throwable th3 = th2;
                if (incrementAndGetReference) {
                    decrementAndGetReference();
                }
                tryRelease();
                throw th3;
            }
        }
        return null;
    }

    public void release() {
        this.shouldRelease.compareAndSet(false, true);
        tryRelease();
    }
}
