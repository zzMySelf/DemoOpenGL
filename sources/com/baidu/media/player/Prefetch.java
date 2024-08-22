package com.baidu.media.player;

import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.DuMediaPrefetchBase;
import com.baidu.cyberplayer.sdk.PlayerConfigManager;
import com.baidu.cyberplayer.sdk.ab.CyberAbTestManager;
import com.baidu.cyberplayer.sdk.context.ICyberPlayServer;
import com.baidu.cyberplayer.sdk.remote.DuMediaPrefetchOptions;
import com.baidu.media.playerconfig.PlayerConfigManagerInternal;
import java.util.Map;

public class Prefetch {
    public static String TAG = "filecache-Prefetch";

    /* renamed from: a  reason: collision with root package name */
    private static DuMediaPrefetchBase.OnPrefetchListener f15228a = null;

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00e8 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void add(java.lang.String r24, java.lang.String r25, java.lang.String r26, int r27, int r28, int r29, com.baidu.cyberplayer.sdk.DuMediaNetBase.HttpDNS r30, java.lang.String r31, int r32, int r33, int r34, int r35, com.baidu.cyberplayer.sdk.remote.DuMediaPrefetchOptions r36) {
        /*
            r0 = r29
            r1 = r36
            r2 = 6291456(0x600000, float:8.816208E-39)
            r3 = 30720(0x7800, float:4.3048E-41)
            if (r0 >= r3) goto L_0x000b
            goto L_0x0010
        L_0x000b:
            if (r0 <= r2) goto L_0x000f
            r3 = r2
            goto L_0x0010
        L_0x000f:
            r3 = r0
        L_0x0010:
            if (r24 == 0) goto L_0x01b0
            int r0 = r24.length()
            if (r0 <= 0) goto L_0x01b0
            java.lang.String r0 = com.baidu.media.player.Utils.c()
            java.lang.String r2 = ""
            if (r0 != 0) goto L_0x0022
            r7 = r2
            goto L_0x0036
        L_0x0022:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "http://"
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r0 = r4.append(r0)
            java.lang.String r0 = r0.toString()
            r7 = r0
        L_0x0036:
            r4 = 1
            r5 = 0
            android.net.Uri r0 = android.net.Uri.parse(r24)     // Catch:{ Exception -> 0x00b8 }
            boolean r6 = com.baidu.cyberplayer.sdk.MPDParser.isMPD((android.net.Uri) r0)     // Catch:{ Exception -> 0x00b8 }
            if (r6 == 0) goto L_0x00b2
            com.baidu.cyberplayer.sdk.MPDParser$MPDInfo r6 = com.baidu.cyberplayer.sdk.MPDParser.getMPDInfoFromMPDStr(r24)     // Catch:{ Exception -> 0x00ac }
            int r8 = r6.mpdClarity     // Catch:{ Exception -> 0x00ac }
            int r9 = r6.mpdAuto     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r10 = r6.urlStr     // Catch:{ Exception -> 0x00a1 }
            java.lang.String r6 = r6.urlStr     // Catch:{ Exception -> 0x009f }
            int r6 = r6.length()     // Catch:{ Exception -> 0x009f }
            r11 = 5
            if (r6 >= r11) goto L_0x0057
            r6 = r5
            goto L_0x0058
        L_0x0057:
            r6 = r4
        L_0x0058:
            java.lang.String r11 = TAG     // Catch:{ Exception -> 0x009d }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009d }
            r12.<init>()     // Catch:{ Exception -> 0x009d }
            java.lang.String r13 = "mpd prefetch uri is => "
            java.lang.StringBuilder r12 = r12.append(r13)     // Catch:{ Exception -> 0x009d }
            java.lang.StringBuilder r0 = r12.append(r0)     // Catch:{ Exception -> 0x009d }
            java.lang.String r12 = " url_str: "
            java.lang.StringBuilder r0 = r0.append(r12)     // Catch:{ Exception -> 0x009d }
            java.lang.StringBuilder r0 = r0.append(r10)     // Catch:{ Exception -> 0x009d }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x009d }
            com.baidu.cyberplayer.sdk.CyberLog.d(r11, r0)     // Catch:{ Exception -> 0x009d }
            java.lang.String r0 = TAG     // Catch:{ Exception -> 0x009d }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009d }
            r11.<init>()     // Catch:{ Exception -> 0x009d }
            java.lang.String r12 = "mpd mpdClarity: => "
            java.lang.StringBuilder r11 = r11.append(r12)     // Catch:{ Exception -> 0x009d }
            java.lang.StringBuilder r11 = r11.append(r8)     // Catch:{ Exception -> 0x009d }
            java.lang.String r12 = " mpdAuto: "
            java.lang.StringBuilder r11 = r11.append(r12)     // Catch:{ Exception -> 0x009d }
            java.lang.StringBuilder r11 = r11.append(r9)     // Catch:{ Exception -> 0x009d }
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x009d }
            com.baidu.cyberplayer.sdk.CyberLog.d(r0, r11)     // Catch:{ Exception -> 0x009d }
            goto L_0x00da
        L_0x009d:
            r0 = move-exception
            goto L_0x00be
        L_0x009f:
            r0 = move-exception
            goto L_0x00a4
        L_0x00a1:
            r0 = move-exception
            r10 = r24
        L_0x00a4:
            r6 = r4
            goto L_0x00be
        L_0x00a6:
            r0 = move-exception
            r10 = r24
            r6 = r4
            r9 = r5
            goto L_0x00be
        L_0x00ac:
            r0 = move-exception
            r10 = r24
            r6 = r4
            r8 = r5
            goto L_0x00bd
        L_0x00b2:
            r10 = r24
            r6 = r5
            r8 = r6
            r9 = r8
            goto L_0x00da
        L_0x00b8:
            r0 = move-exception
            r10 = r24
            r6 = r5
            r8 = r6
        L_0x00bd:
            r9 = r8
        L_0x00be:
            java.lang.String r11 = TAG
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "mpd parse Exception:"
            java.lang.StringBuilder r12 = r12.append(r13)
            java.lang.String r0 = r0.getMessage()
            java.lang.StringBuilder r0 = r12.append(r0)
            java.lang.String r0 = r0.toString()
            com.baidu.cyberplayer.sdk.CyberLog.w(r11, r0)
        L_0x00da:
            r16 = r6
            r17 = r8
            r18 = r9
            java.lang.String r0 = "enable_sdk_append_url"
            boolean r0 = com.baidu.cyberplayer.sdk.PlayerConfigManager.get((java.lang.String) r0, (boolean) r4)
            if (r16 != 0) goto L_0x013d
            if (r0 == 0) goto L_0x013d
            java.lang.String r0 = TAG
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "adjustPrefetchPolicy call before url : "
            java.lang.StringBuilder r4 = r4.append(r6)
            java.lang.StringBuilder r4 = r4.append(r10)
            java.lang.String r6 = " prefetchSize : "
            java.lang.StringBuilder r4 = r4.append(r6)
            java.lang.StringBuilder r4 = r4.append(r3)
            java.lang.String r4 = r4.toString()
            com.baidu.cyberplayer.sdk.CyberLog.i(r0, r4)
            com.baidu.cyberplayer.sdk.context.ICyberPlayServer$AdjustInfo r0 = adjustPrefetchPolicy(r10, r3, r1)
            java.lang.String r3 = TAG
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "adjustPrefetchPolicy call after url : "
            java.lang.StringBuilder r4 = r4.append(r6)
            java.lang.String r6 = r0.adjustUrl
            java.lang.StringBuilder r4 = r4.append(r6)
            java.lang.String r6 = " info.adjustSize : "
            java.lang.StringBuilder r4 = r4.append(r6)
            int r6 = r0.adjustSize
            java.lang.StringBuilder r4 = r4.append(r6)
            java.lang.String r4 = r4.toString()
            com.baidu.cyberplayer.sdk.CyberLog.i(r3, r4)
            java.lang.String r3 = r0.adjustUrl
            int r0 = r0.adjustSize
            r10 = r0
            r4 = r3
            goto L_0x013f
        L_0x013d:
            r4 = r10
            r10 = r3
        L_0x013f:
            long r8 = com.baidu.media.player.Utils.a()
            int r0 = com.baidu.media.player.Utils.f15231b
            long r11 = (long) r0
            int r0 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r0 <= 0) goto L_0x01b0
            java.lang.String r0 = "video-bps"
            int r19 = getIntValueFromOptions(r1, r0)
            java.lang.String r0 = "video-moov-size"
            int r20 = getIntValueFromOptions(r1, r0)
            java.lang.String r0 = "video_bind_4g"
            int r21 = getIntValueFromOptions(r1, r0, r5)
            if (r25 == 0) goto L_0x0164
            r0 = r25
            goto L_0x0165
        L_0x0164:
            r0 = r2
        L_0x0165:
            if (r26 == 0) goto L_0x016a
            r6 = r26
            goto L_0x016b
        L_0x016a:
            r6 = r2
        L_0x016b:
            if (r31 == 0) goto L_0x0170
            r11 = r31
            goto L_0x0171
        L_0x0170:
            r11 = r2
        L_0x0171:
            r2 = 0
            if (r1 != 0) goto L_0x0177
            r22 = r2
            goto L_0x0189
        L_0x0177:
            java.util.Map r3 = r36.getOptions()
            java.util.Set r3 = r3.keySet()
            java.lang.String[] r8 = new java.lang.String[r5]
            java.lang.Object[] r3 = r3.toArray(r8)
            java.lang.String[] r3 = (java.lang.String[]) r3
            r22 = r3
        L_0x0189:
            if (r1 != 0) goto L_0x018e
            r23 = r2
            goto L_0x01a0
        L_0x018e:
            java.util.Map r1 = r36.getOptions()
            java.util.Collection r1 = r1.values()
            java.lang.String[] r2 = new java.lang.String[r5]
            java.lang.Object[] r1 = r1.toArray(r2)
            java.lang.String[] r1 = (java.lang.String[]) r1
            r23 = r1
        L_0x01a0:
            r5 = r0
            r8 = r27
            r9 = r28
            r12 = r32
            r13 = r33
            r14 = r34
            r15 = r35
            nativeAdd(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
        L_0x01b0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.media.player.Prefetch.add(java.lang.String, java.lang.String, java.lang.String, int, int, int, com.baidu.cyberplayer.sdk.DuMediaNetBase$HttpDNS, java.lang.String, int, int, int, int, com.baidu.cyberplayer.sdk.remote.DuMediaPrefetchOptions):void");
    }

    public static void addPrefetchListener(DuMediaPrefetchBase.OnPrefetchListener onPrefetchListener) {
        f15228a = onPrefetchListener;
    }

    public static ICyberPlayServer.AdjustInfo adjustPrefetchPolicy(String str, int i2, DuMediaPrefetchOptions duMediaPrefetchOptions) {
        int i3;
        int i4;
        ICyberPlayServer.AdjustInfo adjustInfo;
        Map<String, String> options;
        String str2;
        ICyberPlayServer.AdjustInfo adjustInfo2 = new ICyberPlayServer.AdjustInfo(str, i2);
        CyberLog.i(TAG, "adjustPrefetchPolicy call");
        if (!PlayerConfigManager.get("enable_player_policy", true)) {
            return adjustInfo2;
        }
        CyberLog.i(TAG, "adjustPrefetchPolicy call use PlayerServer");
        if (duMediaPrefetchOptions == null || (options = duMediaPrefetchOptions.getOptions()) == null) {
            i3 = 0;
            i4 = 0;
        } else {
            String str3 = options.get("video-bps");
            if (str3 != null && !str3.isEmpty()) {
                try {
                    i4 = Integer.parseInt(str3);
                } catch (Exception e2) {
                }
                str2 = options.get("video-moov-size");
                if (str2 != null && !str2.isEmpty()) {
                    i3 = Integer.parseInt(str2);
                }
                i3 = 0;
            }
            i4 = 0;
            str2 = options.get("video-moov-size");
            try {
                i3 = Integer.parseInt(str2);
            } catch (Exception e3) {
            }
        }
        CyberLog.i(TAG, "adjustPrefetchPolicy call videoBps : " + i4 + " videoMoovSize : " + i3);
        if (i4 <= 0 || i3 <= 0) {
            return adjustInfo2;
        }
        if (CyberAbTestManager.getAbSwitchInt("cyber_play_config_refactor", 0) != 0) {
            adjustInfo = PlayerConfigManager.getInstance().rebuildUrlForPrefetch(str, (String) null, i4, i3);
            if (adjustInfo == null) {
                return adjustInfo2;
            }
        } else if (PlayerConfigManagerInternal.getInstance().getPlayerConfig() == null || (adjustInfo = PlayerConfigManagerInternal.getInstance().rebuildUrlForPrefetch(str, (String) null, i4, i3)) == null) {
            return adjustInfo2;
        }
        return adjustInfo;
    }

    public static int getIntValueFromOptions(DuMediaPrefetchOptions duMediaPrefetchOptions, String str) {
        String str2;
        if (duMediaPrefetchOptions == null || (str2 = duMediaPrefetchOptions.getOptions().get(str)) == null || str2.isEmpty()) {
            return 0;
        }
        try {
            return Integer.parseInt(str2);
        } catch (Exception e2) {
            return 0;
        }
    }

    public static int getIntValueFromOptions(DuMediaPrefetchOptions duMediaPrefetchOptions, String str, int i2) {
        String str2;
        if (duMediaPrefetchOptions == null || (str2 = duMediaPrefetchOptions.getOptions().get(str)) == null || str2.isEmpty()) {
            return i2;
        }
        try {
            return Integer.parseInt(str2);
        } catch (Exception e2) {
            return i2;
        }
    }

    public static boolean hasCacheFile(String str) {
        return nativeHasCacheFile(str);
    }

    private static native void nativeAdd(String str, String str2, String str3, String str4, int i2, int i3, int i4, String str5, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, String[] strArr, String[] strArr2);

    private static native boolean nativeHasCacheFile(String str);

    private static native void nativeStopPrefetch(String str);

    private static void onPrefetchStatus(String str, boolean z, int i2, String str2) {
        CyberLog.i(TAG, "[PrefetchCallback]onPrefetchCallback:" + str + ";succeed:" + z + "errorinfo:" + str2);
        DuMediaPrefetchBase.OnPrefetchListener onPrefetchListener = f15228a;
        if (onPrefetchListener != null) {
            onPrefetchListener.onPrefetchStatusChanged(str, z, i2, str2);
        }
    }

    public static void stopPrefetch(String str) {
        nativeStopPrefetch(str);
    }
}
