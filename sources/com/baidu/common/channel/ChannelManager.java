package com.baidu.common.channel;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.common.param.R;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ChannelManager {
    private static boolean DEBUG = AppConfig.isDebug();
    private static final String KEY_CHANNEL = "channel";
    private static final String PREFS_NAME = "com.baidu.common.pubparam";
    private static final String TAG = "ChannelManager";
    private static ChannelManager sInstance;
    private SharedPreferences mCache;
    private String mChannel;
    private String mLastChannel;

    public static ChannelManager getInstance() {
        if (sInstance == null) {
            synchronized (ChannelManager.class) {
                if (sInstance == null) {
                    sInstance = new ChannelManager();
                }
            }
        }
        return sInstance;
    }

    private ChannelManager() {
        init();
    }

    private void init() {
        this.mCache = AppRuntime.getAppContext().getSharedPreferences(PREFS_NAME, 0);
        initLastChannel();
        initChanel();
    }

    public String getChannel() {
        return this.mChannel;
    }

    public String getLastChannel() {
        return this.mLastChannel;
    }

    private void initLastChannel() {
        String readLastChannelFromRaw = readLastChannelFromRaw();
        this.mLastChannel = readLastChannelFromRaw;
        if (TextUtils.isEmpty(readLastChannelFromRaw)) {
            this.mLastChannel = readLastChannelFromAssets();
        }
    }

    private void initChanel() {
        String readChannelFromCache = readChannelFromCache();
        this.mChannel = readChannelFromCache;
        if (TextUtils.isEmpty(readChannelFromCache) && !TextUtils.isEmpty(this.mLastChannel)) {
            this.mChannel = this.mLastChannel;
            saveCannelToCache();
        }
    }

    private String readChannelFromCache() {
        return this.mCache.getString("channel", (String) null);
    }

    private void saveCannelToCache() {
        this.mCache.edit().putString("channel", this.mChannel).apply();
    }

    /* Debug info: failed to restart local var, previous not found, register: 10 */
    private String readLastChannelFromRaw() {
        InputStream inputStream;
        BufferedReader reader;
        String channel = null;
        try {
            inputStream = AppRuntime.getAppContext().getResources().openRawResource(R.raw.tnconfig);
            reader = new BufferedReader(new InputStreamReader(inputStream));
            try {
                channel = reader.readLine();
                try {
                    inputStream.close();
                    reader.close();
                } catch (Exception e2) {
                    if (DEBUG) {
                        Log.e(TAG, "readLastChannelFromRaw", e2);
                    }
                }
            } catch (Exception e3) {
                if (DEBUG) {
                    Log.e(TAG, "readLastChannelFromRaw", e3);
                }
                try {
                    inputStream.close();
                    reader.close();
                } catch (Exception e4) {
                    if (DEBUG) {
                        Log.e(TAG, "readLastChannelFromRaw", e4);
                    }
                }
            }
        } catch (Exception e5) {
            if (DEBUG) {
                Log.e(TAG, "readLastChannelFromAssets", e5);
            }
        } catch (Throwable th2) {
            try {
                inputStream.close();
                reader.close();
            } catch (Exception e6) {
                if (DEBUG) {
                    Log.e(TAG, "readLastChannelFromRaw", e6);
                }
            }
            throw th2;
        }
        return channel;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003f, code lost:
        if (DEBUG == false) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0041, code lost:
        android.util.Log.e(TAG, "readLastChannelFromAssets", r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0068, code lost:
        if (DEBUG == false) goto L_0x006b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String readLastChannelFromAssets() {
        /*
            r9 = this;
            java.lang.String r0 = "readLastChannelFromAssets"
            java.lang.String r1 = "ChannelManager"
            java.lang.String r2 = "channel"
            r3 = 0
            r4 = 0
            r5 = 0
            android.content.Context r6 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()     // Catch:{ Exception -> 0x0047 }
            android.content.res.AssetManager r6 = r6.getAssets()     // Catch:{ Exception -> 0x0047 }
            java.io.InputStream r6 = r6.open(r2)     // Catch:{ Exception -> 0x0047 }
            r4 = r6
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0047 }
            java.io.InputStreamReader r7 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0047 }
            r7.<init>(r4)     // Catch:{ Exception -> 0x0047 }
            r6.<init>(r7)     // Catch:{ Exception -> 0x0047 }
            r5 = r6
            java.lang.String r6 = r5.readLine()     // Catch:{ Exception -> 0x0047 }
            r3 = r6
            if (r4 == 0) goto L_0x0036
            r4.close()     // Catch:{ Exception -> 0x002d }
            goto L_0x0036
        L_0x002d:
            r6 = move-exception
            boolean r7 = DEBUG
            if (r7 == 0) goto L_0x0037
            android.util.Log.e(r1, r0, r6)
            goto L_0x0037
        L_0x0036:
        L_0x0037:
            r5.close()     // Catch:{ Exception -> 0x003c }
        L_0x003b:
            goto L_0x006b
        L_0x003c:
            r6 = move-exception
            boolean r7 = DEBUG
            if (r7 == 0) goto L_0x0044
        L_0x0041:
            android.util.Log.e(r1, r0, r6)
        L_0x0044:
            goto L_0x006b
        L_0x0045:
            r6 = move-exception
            goto L_0x006c
        L_0x0047:
            r6 = move-exception
            boolean r7 = DEBUG     // Catch:{ all -> 0x0045 }
            if (r7 == 0) goto L_0x004f
            android.util.Log.e(r1, r0, r6)     // Catch:{ all -> 0x0045 }
        L_0x004f:
            if (r4 == 0) goto L_0x005e
            r4.close()     // Catch:{ Exception -> 0x0055 }
            goto L_0x005e
        L_0x0055:
            r6 = move-exception
            boolean r7 = DEBUG
            if (r7 == 0) goto L_0x005f
            android.util.Log.e(r1, r0, r6)
            goto L_0x005f
        L_0x005e:
        L_0x005f:
            if (r5 == 0) goto L_0x003b
            r5.close()     // Catch:{ Exception -> 0x0065 }
            goto L_0x003b
        L_0x0065:
            r6 = move-exception
            boolean r7 = DEBUG
            if (r7 == 0) goto L_0x0044
            goto L_0x0041
        L_0x006b:
            return r3
        L_0x006c:
            if (r4 == 0) goto L_0x007b
            r4.close()     // Catch:{ Exception -> 0x0072 }
            goto L_0x007b
        L_0x0072:
            r7 = move-exception
            boolean r8 = DEBUG
            if (r8 == 0) goto L_0x007c
            android.util.Log.e(r1, r0, r7)
            goto L_0x007c
        L_0x007b:
        L_0x007c:
            if (r5 == 0) goto L_0x008b
            r5.close()     // Catch:{ Exception -> 0x0082 }
            goto L_0x008b
        L_0x0082:
            r7 = move-exception
            boolean r8 = DEBUG
            if (r8 == 0) goto L_0x008c
            android.util.Log.e(r1, r0, r7)
            goto L_0x008c
        L_0x008b:
        L_0x008c:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.common.channel.ChannelManager.readLastChannelFromAssets():java.lang.String");
    }
}
