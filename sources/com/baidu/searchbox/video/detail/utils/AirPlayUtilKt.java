package com.baidu.searchbox.video.detail.utils;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¨\u0006\u0004"}, d2 = {"getAirPlayEnable", "", "tpl", "", "lib-detail-component_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: AirPlayUtil.kt */
public final class AirPlayUtilKt {
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002c, code lost:
        return com.baidu.searchbox.video.detail.utils.VideoSharedPrefsUtils.getBoolean(com.baidu.searchbox.video.videoplayer.constants.VideoPlayerConstants.KEY_PLAYER_AIRPLAY_SWITCH, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0011, code lost:
        if (r2.equals("feed") == false) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001a, code lost:
        if (r2.equals("search") != false) goto L_0x0026;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0023, code lost:
        if (r2.equals("feedpayment") == false) goto L_0x002d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean getAirPlayEnable(java.lang.String r2) {
        /*
            r0 = 0
            if (r2 == 0) goto L_0x002d
            int r1 = r2.hashCode()
            switch(r1) {
                case -1742053720: goto L_0x001d;
                case -906336856: goto L_0x0014;
                case 3138974: goto L_0x000b;
                default: goto L_0x000a;
            }
        L_0x000a:
            goto L_0x002d
        L_0x000b:
            java.lang.String r1 = "feed"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L_0x0026
            goto L_0x002d
        L_0x0014:
            java.lang.String r1 = "search"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x002d
            goto L_0x0026
        L_0x001d:
            java.lang.String r1 = "feedpayment"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L_0x0026
            goto L_0x002d
        L_0x0026:
            java.lang.String r1 = "airPlayEnable"
            boolean r0 = com.baidu.searchbox.video.detail.utils.VideoSharedPrefsUtils.getBoolean(r1, r0)
            return r0
        L_0x002d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.detail.utils.AirPlayUtilKt.getAirPlayEnable(java.lang.String):boolean");
    }
}
