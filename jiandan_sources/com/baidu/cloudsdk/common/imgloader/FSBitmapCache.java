package com.baidu.cloudsdk.common.imgloader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.browser.browseractions.BrowserServiceFileProvider;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class FSBitmapCache implements IBitmapCache {
    public int mHitCountRequired;
    public Map<String, Integer> mMap = new HashMap();
    public int mMaxNumOfPixels;
    public IBitmapCache mMemCache;
    public String mStorageDir;

    public FSBitmapCache(String str, int i2, int i3, IBitmapCache iBitmapCache) {
        this.mStorageDir = str;
        this.mHitCountRequired = i2;
        this.mMaxNumOfPixels = i3;
        this.mMemCache = iBitmapCache;
    }

    public void clean() {
        for (String delete : this.mMap.keySet()) {
            delete(delete);
        }
        this.mMap.clear();
    }

    public void delete(String str) {
        new File(getFilePath(str)).delete();
    }

    public boolean exists(String str) {
        return new File(getFilePath(str)).exists();
    }

    public Bitmap get(String str) {
        IBitmapCache iBitmapCache;
        if (!exists(str)) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(getFilePath(str), options);
        options.inSampleSize = AsyncImageLoader.computeSampleSize(options, -1, this.mMaxNumOfPixels);
        options.inJustDecodeBounds = false;
        Bitmap decodeFile = BitmapFactory.decodeFile(getFilePath(str), options);
        if (decodeFile == null) {
            return null;
        }
        Integer num = this.mMap.get(str);
        if (num == null) {
            num = 0;
        }
        if (num.intValue() + 1 < this.mHitCountRequired || (iBitmapCache = this.mMemCache) == null) {
            this.mMap.put(str, Integer.valueOf(num.intValue() + 1));
            return decodeFile;
        }
        iBitmapCache.put(str, decodeFile);
        this.mMap.remove(str);
        return decodeFile;
    }

    public String getFilePath(String str) {
        return this.mStorageDir + "/" + str + BrowserServiceFileProvider.FILE_EXTENSION;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050 A[SYNTHETIC, Splitter:B:24:0x0050] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0056 A[SYNTHETIC, Splitter:B:28:0x0056] */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void put(java.lang.String r4, android.graphics.Bitmap r5) {
        /*
            r3 = this;
            java.io.File r0 = new java.io.File
            java.lang.String r1 = r3.getFilePath(r4)
            r0.<init>(r1)
            java.io.File r1 = r0.getParentFile()
            if (r1 == 0) goto L_0x0018
            boolean r2 = r1.exists()
            if (r2 != 0) goto L_0x0018
            r1.mkdirs()
        L_0x0018:
            boolean r1 = r0.exists()
            if (r1 == 0) goto L_0x0021
            r0.delete()
        L_0x0021:
            r1 = 0
            r0.createNewFile()     // Catch:{ Exception -> 0x004a }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x004a }
            r2.<init>(r0)     // Catch:{ Exception -> 0x004a }
            android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ Exception -> 0x0045, all -> 0x0042 }
            r1 = 100
            r5.compress(r0, r1, r2)     // Catch:{ Exception -> 0x0045, all -> 0x0042 }
            r2.flush()     // Catch:{ Exception -> 0x0045, all -> 0x0042 }
            java.util.Map<java.lang.String, java.lang.Integer> r5 = r3.mMap     // Catch:{ Exception -> 0x0045, all -> 0x0042 }
            r0 = 1
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x0045, all -> 0x0042 }
            r5.put(r4, r0)     // Catch:{ Exception -> 0x0045, all -> 0x0042 }
            r2.close()     // Catch:{ IOException -> 0x0053 }
            goto L_0x0053
        L_0x0042:
            r4 = move-exception
            r1 = r2
            goto L_0x0054
        L_0x0045:
            r4 = move-exception
            r1 = r2
            goto L_0x004b
        L_0x0048:
            r4 = move-exception
            goto L_0x0054
        L_0x004a:
            r4 = move-exception
        L_0x004b:
            r4.toString()     // Catch:{ all -> 0x0048 }
            if (r1 == 0) goto L_0x0053
            r1.close()     // Catch:{ IOException -> 0x0053 }
        L_0x0053:
            return
        L_0x0054:
            if (r1 == 0) goto L_0x0059
            r1.close()     // Catch:{ IOException -> 0x0059 }
        L_0x0059:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.cloudsdk.common.imgloader.FSBitmapCache.put(java.lang.String, android.graphics.Bitmap):void");
    }

    public FSBitmapCache setHitCountRequired(int i2) {
        this.mHitCountRequired = i2;
        return this;
    }

    public FSBitmapCache setMaxNumOfPixels(int i2) {
        this.mMaxNumOfPixels = i2;
        return this;
    }

    public FSBitmapCache setStorageDir(String str) {
        this.mStorageDir = str;
        return this;
    }
}
