package com.baidu.searchbox.feed.h5.utils;

import com.baidu.pyramid.annotation.tekes.StableApi;
import kotlin.Metadata;

@StableApi
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/feed/h5/utils/Assembler;", "", "()V", "obtainNaInfo", "Lorg/json/JSONObject;", "hybridData", "Lcom/baidu/searchbox/feed/h5/HybridData;", "lib-feed-h5_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Assembler.kt */
public final class Assembler {
    public static final Assembler INSTANCE = new Assembler();

    private Assembler() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x00b4 A[Catch:{ all -> 0x010d }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00c4 A[Catch:{ all -> 0x010d }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0107 A[Catch:{ all -> 0x010d }] */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final org.json.JSONObject obtainNaInfo(com.baidu.searchbox.feed.h5.HybridData r8) {
        /*
            java.lang.String r0 = "hybridData"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            kotlin.Result$Companion r1 = kotlin.Result.Companion     // Catch:{ all -> 0x010d }
            r1 = r0
            r2 = 0
            java.lang.String r3 = "context"
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ all -> 0x010d }
            java.lang.String r5 = r8.getCtxJsonStr()     // Catch:{ all -> 0x010d }
            r4.<init>(r5)     // Catch:{ all -> 0x010d }
            r0.put(r3, r4)     // Catch:{ all -> 0x010d }
            java.lang.String r3 = "sourceFrame"
            java.lang.String r4 = r8.getFrameSource()     // Catch:{ all -> 0x010d }
            r0.put(r3, r4)     // Catch:{ all -> 0x010d }
            java.lang.String r3 = "subSourceFrame"
            java.lang.String r4 = r8.getSubFrameSource()     // Catch:{ all -> 0x010d }
            r0.put(r3, r4)     // Catch:{ all -> 0x010d }
            java.lang.String r3 = "layoutType"
            java.lang.String r4 = r8.getExistBiSerial()     // Catch:{ all -> 0x010d }
            r0.put(r3, r4)     // Catch:{ all -> 0x010d }
            java.lang.String r3 = "naTopbar"
            java.lang.String r4 = r8.getUseNaTopBar()     // Catch:{ all -> 0x010d }
            r0.put(r3, r4)     // Catch:{ all -> 0x010d }
            java.lang.String r3 = "anchorIndex"
            java.lang.String r4 = r8.getAnchorIndex()     // Catch:{ all -> 0x010d }
            r0.put(r3, r4)     // Catch:{ all -> 0x010d }
            boolean r3 = com.baidu.searchbox.feed.h5.abtest.HybridAbtestManager.shieldSearchBoxSwitch()     // Catch:{ all -> 0x010d }
            if (r3 == 0) goto L_0x005d
            com.baidu.searchbox.feed.h5.IH5Context r3 = com.baidu.searchbox.feed.h5.H5Runtime.getH5Context()     // Catch:{ all -> 0x010d }
            boolean r3 = r3.isInSearchSession()     // Catch:{ all -> 0x010d }
            if (r3 == 0) goto L_0x0067
        L_0x005d:
            java.lang.String r3 = "topBox"
            java.lang.String r4 = com.baidu.searchbox.feed.h5.abtest.HybridAbtestManager.topSearchBoxSwitch()     // Catch:{ all -> 0x010d }
            r0.put(r3, r4)     // Catch:{ all -> 0x010d }
        L_0x0067:
            java.lang.String r3 = "feed_highlight_words"
            int r4 = com.baidu.searchbox.feed.h5.abtest.HybridAbtestManager.highLightWordSwitch()     // Catch:{ all -> 0x010d }
            r0.put(r3, r4)     // Catch:{ all -> 0x010d }
            java.lang.String r3 = "basic_newUI_Test"
            boolean r4 = com.baidu.searchbox.feed.h5.abtest.HybridAbtestManager.isTtsIconNewStyle()     // Catch:{ all -> 0x010d }
            r0.put(r3, r4)     // Catch:{ all -> 0x010d }
            java.lang.String r3 = "toolbaricons"
            org.json.JSONObject r4 = r8.getToolsBarParams()     // Catch:{ all -> 0x010d }
            r0.put(r3, r4)     // Catch:{ all -> 0x010d }
            java.lang.String r3 = "screenStatus"
            java.lang.String r4 = r8.getScreenStatus()     // Catch:{ all -> 0x010d }
            r0.put(r3, r4)     // Catch:{ all -> 0x010d }
            java.lang.String r3 = "deviceType"
            java.lang.String r4 = r8.getDeviceType()     // Catch:{ all -> 0x010d }
            r0.put(r3, r4)     // Catch:{ all -> 0x010d }
            java.lang.String r3 = "landingpage_ab_switch"
            org.json.JSONObject r4 = r8.getAbSwitch()     // Catch:{ all -> 0x010d }
            r0.put(r3, r4)     // Catch:{ all -> 0x010d }
            java.lang.String r3 = r8.getIsUpLift()     // Catch:{ all -> 0x010d }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x010d }
            if (r3 == 0) goto L_0x00b1
            int r3 = r3.length()     // Catch:{ all -> 0x010d }
            if (r3 != 0) goto L_0x00af
            goto L_0x00b1
        L_0x00af:
            r3 = 0
            goto L_0x00b2
        L_0x00b1:
            r3 = 1
        L_0x00b2:
            if (r3 != 0) goto L_0x00be
            java.lang.String r3 = "is_uplift"
            java.lang.String r4 = r8.getIsUpLift()     // Catch:{ all -> 0x010d }
            r0.put(r3, r4)     // Catch:{ all -> 0x010d }
        L_0x00be:
            java.util.Map r3 = r8.getCHReplacementMap()     // Catch:{ all -> 0x010d }
            if (r3 == 0) goto L_0x0107
            r4 = r3
            r5 = 0
            java.lang.String r6 = "fontSize"
            java.lang.String r7 = "{#baiduboxapp://utils?action=getGlobalFontSize#}"
            java.lang.Object r7 = r3.get(r7)     // Catch:{ all -> 0x010d }
            r0.put(r6, r7)     // Catch:{ all -> 0x010d }
            java.lang.String r6 = "readPos"
            java.lang.String r7 = "{#baiduboxapp://v5/feed/getpos#}"
            java.lang.Object r7 = r3.get(r7)     // Catch:{ all -> 0x010d }
            r0.put(r6, r7)     // Catch:{ all -> 0x010d }
            java.lang.String r6 = "cuid"
            java.lang.String r7 = "{#baiduboxapp://utils?action=getCuid#}"
            java.lang.Object r7 = r3.get(r7)     // Catch:{ all -> 0x010d }
            r0.put(r6, r7)     // Catch:{ all -> 0x010d }
            java.lang.String r6 = "network"
            java.lang.String r7 = "{#baiduboxapp://utils?action=getPrefetchRes&params={\"keys\":[\"network\"]}#}"
            java.lang.Object r7 = r3.get(r7)     // Catch:{ all -> 0x010d }
            r0.put(r6, r7)     // Catch:{ all -> 0x010d }
            java.lang.String r6 = "nightMode"
            java.lang.String r7 = "{#baiduboxapp://v16/theme/getNightMode#}"
            java.lang.Object r7 = r3.get(r7)     // Catch:{ all -> 0x010d }
            org.json.JSONObject r6 = r0.put(r6, r7)     // Catch:{ all -> 0x010d }
            goto L_0x0108
        L_0x0107:
            r6 = 0
        L_0x0108:
            kotlin.Result.m8971constructorimpl(r6)     // Catch:{ all -> 0x010d }
            goto L_0x0117
        L_0x010d:
            r1 = move-exception
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r1 = kotlin.ResultKt.createFailure(r1)
            kotlin.Result.m8971constructorimpl(r1)
        L_0x0117:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.h5.utils.Assembler.obtainNaInfo(com.baidu.searchbox.feed.h5.HybridData):org.json.JSONObject");
    }
}
