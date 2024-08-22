package com.terascan.algo;

import android.content.res.AssetManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DocumentEnhanceAPI {
    public static final String LIBRARY_NAME = "document_scan";
    public static final String NAME = "com.tera.scan";
    public static final String TAG = "DocumentEnhanceAPI";
    public long algoPtr = -1;
    public DocumentEnhanceJNI documentEnhanceJNI = new DocumentEnhanceJNI();
    public AssetManager manager;

    static {
        System.loadLibrary(LIBRARY_NAME);
    }

    public DocumentEnhanceAPI(AssetManager assetManager) {
        this.manager = assetManager;
    }

    private byte[] loadAssetsFile(String str) throws IOException {
        InputStream open = this.manager.open(str);
        byte[] bArr = new byte[open.available()];
        open.read(bArr);
        open.close();
        return bArr;
    }

    public byte[] enhance(byte[] bArr, boolean z, boolean z2, int i2) {
        return this.documentEnhanceJNI.nativeEnhance(this.algoPtr, bArr, (long) bArr.length, z, z2, i2);
    }

    public boolean init(String str, String str2, String str3, boolean z, boolean z2) {
        byte[] bArr;
        byte[] bArr2;
        String str4 = str2;
        if (z) {
            try {
                bArr = loadLocalFile(str);
            } catch (IOException unused) {
                return false;
            }
        } else {
            bArr = loadAssetsFile(str);
        }
        byte[] bArr3 = bArr;
        if (z2) {
            bArr2 = loadLocalFile(str4);
        } else {
            bArr2 = loadAssetsFile(str4);
        }
        byte[] bArr4 = bArr2;
        this.documentEnhanceJNI.nativeCreateAlgoInstance(this.algoPtr, bArr3, (long) bArr3.length, str3, bArr4, (long) bArr4.length, "com.tera.scan");
        return true;
    }

    public boolean initAlgoApi() {
        long nativeCreateAlgoAPI = this.documentEnhanceJNI.nativeCreateAlgoAPI();
        this.algoPtr = nativeCreateAlgoAPI;
        return nativeCreateAlgoAPI != -1;
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

    public void release() {
        this.documentEnhanceJNI.nativeReleaseAlgoInstance(this.algoPtr);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0030 A[SYNTHETIC, Splitter:B:20:0x0030] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0036 A[SYNTHETIC, Splitter:B:26:0x0036] */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeLocalFile(java.lang.String r4, byte[] r5) {
        /*
            r3 = this;
            if (r5 != 0) goto L_0x0003
            return
        L_0x0003:
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ IOException -> 0x0034, all -> 0x002d }
            r1.<init>(r4)     // Catch:{ IOException -> 0x0034, all -> 0x002d }
            java.io.File r4 = r1.getParentFile()     // Catch:{ IOException -> 0x0034, all -> 0x002d }
            if (r4 == 0) goto L_0x0018
            boolean r2 = r4.exists()     // Catch:{ IOException -> 0x0034, all -> 0x002d }
            if (r2 != 0) goto L_0x0018
            r4.mkdirs()     // Catch:{ IOException -> 0x0034, all -> 0x002d }
        L_0x0018:
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0034, all -> 0x002d }
            r4.<init>(r1)     // Catch:{ IOException -> 0x0034, all -> 0x002d }
            r4.write(r5)     // Catch:{ IOException -> 0x002b, all -> 0x0027 }
            r4.flush()     // Catch:{ IOException -> 0x002b, all -> 0x0027 }
            r4.close()     // Catch:{ IOException -> 0x0039 }
            goto L_0x0039
        L_0x0027:
            r5 = move-exception
            r0 = r4
            r4 = r5
            goto L_0x002e
        L_0x002b:
            r0 = r4
            goto L_0x0034
        L_0x002d:
            r4 = move-exception
        L_0x002e:
            if (r0 == 0) goto L_0x0033
            r0.close()     // Catch:{ IOException -> 0x0033 }
        L_0x0033:
            throw r4
        L_0x0034:
            if (r0 == 0) goto L_0x0039
            r0.close()     // Catch:{ IOException -> 0x0039 }
        L_0x0039:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.terascan.algo.DocumentEnhanceAPI.writeLocalFile(java.lang.String, byte[]):void");
    }
}
