package com.baidu.searchbox.browserenhanceengine.cache;

import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.browserenhanceengine.ConstantDef;
import com.google.gson.annotations.Expose;
import java.io.Serializable;

public abstract class BaseCacheModel implements Serializable, NoProGuard {
    private static final boolean DEBUG = ConstantDef.DEBUG;
    private static final String TAG = "BaseCacheModel";
    @Expose
    public String jsonString;
    @Expose
    public String key;

    public abstract boolean loadFromModelString(String str, String str2);

    public abstract String toModelString();

    public BaseCacheModel() {
    }

    public BaseCacheModel(String key2) {
        this(key2, (String) null);
    }

    public BaseCacheModel(String key2, String jsonString2) {
        this.key = key2;
        this.jsonString = jsonString2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0071, code lost:
        if (DEBUG == false) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x003f, code lost:
        if (DEBUG == false) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0041, code lost:
        android.util.Log.d(TAG, r6.getLocalizedMessage());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object deepClone() {
        /*
            r9 = this;
            java.lang.String r0 = "BaseCacheModel"
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x004b }
            r6.<init>()     // Catch:{ Exception -> 0x004b }
            r1 = r6
            java.io.ObjectOutputStream r6 = new java.io.ObjectOutputStream     // Catch:{ Exception -> 0x004b }
            r6.<init>(r1)     // Catch:{ Exception -> 0x004b }
            r2 = r6
            r2.writeObject(r9)     // Catch:{ Exception -> 0x004b }
            java.io.ByteArrayInputStream r6 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x004b }
            byte[] r7 = r1.toByteArray()     // Catch:{ Exception -> 0x004b }
            r6.<init>(r7)     // Catch:{ Exception -> 0x004b }
            r3 = r6
            java.io.ObjectInputStream r6 = new java.io.ObjectInputStream     // Catch:{ Exception -> 0x004b }
            r6.<init>(r3)     // Catch:{ Exception -> 0x004b }
            r4 = r6
            java.lang.Object r6 = r4.readObject()     // Catch:{ Exception -> 0x004b }
            r5 = r6
            r1.close()     // Catch:{ Exception -> 0x003c }
            r2.close()     // Catch:{ Exception -> 0x003c }
            r3.close()     // Catch:{ Exception -> 0x003c }
            r4.close()     // Catch:{ Exception -> 0x003c }
        L_0x003b:
            goto L_0x0074
        L_0x003c:
            r6 = move-exception
            boolean r7 = DEBUG
            if (r7 == 0) goto L_0x0048
        L_0x0041:
            java.lang.String r7 = r6.getLocalizedMessage()
            android.util.Log.d(r0, r7)
        L_0x0048:
            goto L_0x0074
        L_0x0049:
            r6 = move-exception
            goto L_0x0075
        L_0x004b:
            r6 = move-exception
            boolean r7 = DEBUG     // Catch:{ all -> 0x0049 }
            if (r7 == 0) goto L_0x0057
            java.lang.String r7 = r6.getLocalizedMessage()     // Catch:{ all -> 0x0049 }
            android.util.Log.e(r0, r7)     // Catch:{ all -> 0x0049 }
        L_0x0057:
            if (r1 == 0) goto L_0x005f
            r1.close()     // Catch:{ Exception -> 0x005d }
            goto L_0x005f
        L_0x005d:
            r6 = move-exception
            goto L_0x006f
        L_0x005f:
            if (r2 == 0) goto L_0x0064
            r2.close()     // Catch:{ Exception -> 0x005d }
        L_0x0064:
            if (r3 == 0) goto L_0x0069
            r3.close()     // Catch:{ Exception -> 0x005d }
        L_0x0069:
            if (r4 == 0) goto L_0x003b
            r4.close()     // Catch:{ Exception -> 0x005d }
            goto L_0x003b
        L_0x006f:
            boolean r7 = DEBUG
            if (r7 == 0) goto L_0x0048
            goto L_0x0041
        L_0x0074:
            return r5
        L_0x0075:
            if (r1 == 0) goto L_0x007d
            r1.close()     // Catch:{ Exception -> 0x007b }
            goto L_0x007d
        L_0x007b:
            r7 = move-exception
            goto L_0x008d
        L_0x007d:
            if (r2 == 0) goto L_0x0082
            r2.close()     // Catch:{ Exception -> 0x007b }
        L_0x0082:
            if (r3 == 0) goto L_0x0087
            r3.close()     // Catch:{ Exception -> 0x007b }
        L_0x0087:
            if (r4 == 0) goto L_0x0099
            r4.close()     // Catch:{ Exception -> 0x007b }
            goto L_0x0099
        L_0x008d:
            boolean r8 = DEBUG
            if (r8 == 0) goto L_0x009a
            java.lang.String r8 = r7.getLocalizedMessage()
            android.util.Log.d(r0, r8)
            goto L_0x009a
        L_0x0099:
        L_0x009a:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.browserenhanceengine.cache.BaseCacheModel.deepClone():java.lang.Object");
    }
}
