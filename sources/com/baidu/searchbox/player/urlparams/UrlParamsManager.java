package com.baidu.searchbox.player.urlparams;

import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.searchbox.player.data.ExternalFileData;
import com.baidu.searchbox.player.helper.VideoAsyncHostHelper;
import com.baidu.searchbox.player.model.VideoSceneConfig;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.searchbox.video.cdn.VideoCDNReplaceDataManager;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JV\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\n\u0010\u001c\u001a\u00060\u0005j\u0002`\u001d2\u000e\u0010\u001e\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u001f2\u000e\u0010 \u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`!2\u0010\b\u0002\u0010\"\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`#H\u0002J \u0010$\u001a\u00020\u00052\u0016\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u0002J\b\u0010&\u001a\u00020\u0005H\u0007JB\u0010'\u001a\u00020\u00052\n\u0010\u001c\u001a\u00060\u0005j\u0002`\u001d2\f\b\u0002\u0010\u001e\u001a\u00060\u0005j\u0002`\u001f2\f\b\u0002\u0010 \u001a\u00060\u0005j\u0002`!2\u0010\b\u0002\u0010\"\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`#H\u0007J\"\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00052\b\b\u0002\u0010,\u001a\u00020\u0005H\u0007J\u0010\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0005H\u0007J&\u00100\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00062\b\u00101\u001a\u0004\u0018\u00010\u0005H\u0002R/\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00068@X\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0012\u0010\u000eR/\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0015\u0018\u0001`\u00068@X\u0002¢\u0006\f\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0016\u0010\bR/\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00068BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\n\u001a\u0004\b\u0019\u0010\b¨\u00062"}, d2 = {"Lcom/baidu/searchbox/player/urlparams/UrlParamsManager;", "", "()V", "abSidList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getAbSidList$bdvideoplayer_core", "()Ljava/util/ArrayList;", "abSidList$delegate", "Lkotlin/Lazy;", "freeCardConfig", "freeCardConfigDelegate", "getFreeCardConfigDelegate", "()Ljava/lang/String;", "freeCardConfigDelegate$delegate", "Lcom/baidu/searchbox/player/data/ExternalFileData;", "pdx", "getPdx", "pdx$delegate", "sceneList", "Lcom/baidu/searchbox/player/model/VideoSceneConfig;", "getSceneList$bdvideoplayer_core", "sceneList$delegate", "whiteList", "getWhiteList", "whiteList$delegate", "buildSceneCondition", "from", "Lcom/baidu/searchbox/player/env/From;", "page", "Lcom/baidu/searchbox/player/env/Page;", "source", "Lcom/baidu/searchbox/player/env/Source;", "extLog", "Lcom/baidu/searchbox/player/env/ExtLog;", "findScene", "condition", "getFreeCardConfig", "getScene", "getUrlParams", "dt", "", "score", "scene", "isNeedAppendQuery", "", "url", "parseUrlQueryWhiteListConfig", "whiteListConfig", "bdvideoplayer-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UrlParamsManager.kt */
public final class UrlParamsManager {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(UrlParamsManager.class, "freeCardConfigDelegate", "getFreeCardConfigDelegate()Ljava/lang/String;", 0))};
    public static final UrlParamsManager INSTANCE = new UrlParamsManager();
    private static final Lazy abSidList$delegate = LazyKt.lazy(UrlParamsManager$abSidList$2.INSTANCE);
    private static String freeCardConfig = "";
    private static final ExternalFileData freeCardConfigDelegate$delegate = new ExternalFileData(VideoCDNReplaceDataManager.CDN_REPLACE_CACHE_FILE, "");
    private static final Lazy pdx$delegate = LazyKt.lazy(UrlParamsManager$pdx$2.INSTANCE);
    private static final Lazy sceneList$delegate = LazyKt.lazy(UrlParamsManager$sceneList$2.INSTANCE);
    private static final Lazy whiteList$delegate = LazyKt.lazy(UrlParamsManager$whiteList$2.INSTANCE);

    @StableApi
    @JvmStatic
    public static final String getScene(String str) {
        Intrinsics.checkNotNullParameter(str, "from");
        return getScene$default(str, (String) null, (String) null, (String) null, 14, (Object) null);
    }

    @StableApi
    @JvmStatic
    public static final String getScene(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "from");
        Intrinsics.checkNotNullParameter(str2, "page");
        return getScene$default(str, str2, (String) null, (String) null, 12, (Object) null);
    }

    @StableApi
    @JvmStatic
    public static final String getScene(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "from");
        Intrinsics.checkNotNullParameter(str2, "page");
        Intrinsics.checkNotNullParameter(str3, "source");
        return getScene$default(str, str2, str3, (String) null, 8, (Object) null);
    }

    private UrlParamsManager() {
    }

    public final ArrayList<VideoSceneConfig> getSceneList$bdvideoplayer_core() {
        return (ArrayList) sceneList$delegate.getValue();
    }

    public final ArrayList<String> getAbSidList$bdvideoplayer_core() {
        return (ArrayList) abSidList$delegate.getValue();
    }

    private final ArrayList<String> getWhiteList() {
        return (ArrayList) whiteList$delegate.getValue();
    }

    private final String getPdx() {
        return (String) pdx$delegate.getValue();
    }

    private final String getFreeCardConfigDelegate() {
        return freeCardConfigDelegate$delegate.getValue((Object) this, (KProperty) $$delegatedProperties[0]);
    }

    @StableApi
    public final String getFreeCardConfig() {
        if (freeCardConfig.length() == 0) {
            freeCardConfig = getFreeCardConfigDelegate();
        }
        BdVideoLog.i("free card config is " + freeCardConfig);
        return freeCardConfig;
    }

    public static /* synthetic */ String getScene$default(String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = "";
        }
        if ((i2 & 4) != 0) {
            str3 = "";
        }
        if ((i2 & 8) != 0) {
            str4 = "";
        }
        return getScene(str, str2, str3, str4);
    }

    @StableApi
    @JvmStatic
    public static final String getScene(String from, String page, String source, String extLog) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(source, "source");
        UrlParamsManager urlParamsManager = INSTANCE;
        return urlParamsManager.findScene(urlParamsManager.buildSceneCondition(from, page, source, extLog));
    }

    private final String findScene(ArrayList<String> condition) {
        if (condition.isEmpty()) {
            return "";
        }
        ArrayList<VideoSceneConfig> $this$forEach$iv = getSceneList$bdvideoplayer_core();
        if ($this$forEach$iv != null) {
            for (VideoSceneConfig scene : $this$forEach$iv) {
                if (UrlParamsManagerKt.matchScene(scene, BdPlayerUtils.getOrEmpty(condition, 0), BdPlayerUtils.getOrEmpty(condition, 1), BdPlayerUtils.getOrEmpty(condition, 2), BdPlayerUtils.getOrEmpty(condition, 3))) {
                    return scene.getScene();
                }
            }
        }
        CollectionsKt.removeLast(condition);
        return findScene(condition);
    }

    static /* synthetic */ ArrayList buildSceneCondition$default(UrlParamsManager urlParamsManager, String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            str4 = "";
        }
        return urlParamsManager.buildSceneCondition(str, str2, str3, str4);
    }

    private final ArrayList<String> buildSceneCondition(String from, String page, String source, String extLog) {
        ArrayList arrayList = new ArrayList(5);
        ArrayList $this$buildSceneCondition_u24lambda_u2d1 = arrayList;
        BdPlayerUtils.addNoEmpty($this$buildSceneCondition_u24lambda_u2d1, from);
        BdPlayerUtils.addNoEmpty($this$buildSceneCondition_u24lambda_u2d1, page);
        BdPlayerUtils.addNoEmpty($this$buildSceneCondition_u24lambda_u2d1, source);
        BdPlayerUtils.addNoEmpty($this$buildSceneCondition_u24lambda_u2d1, extLog);
        return arrayList;
    }

    public static /* synthetic */ String getUrlParams$default(UrlParamsManager urlParamsManager, int i2, String str, String str2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str2 = "";
        }
        return urlParamsManager.getUrlParams(i2, str, str2);
    }

    @StableApi
    public final String getUrlParams(int dt, String score, String scene) {
        Intrinsics.checkNotNullParameter(score, "score");
        Intrinsics.checkNotNullParameter(scene, "scene");
        String params = getPdx() + "&nt=" + UrlParamsManagerKt.getNewNetType() + "&dt=" + dt + "&ds_stc=" + score;
        if (!StringsKt.isBlank(scene)) {
            params = params + "&scenex=" + scene;
        }
        BdVideoLog.d("url params is " + params);
        return params;
    }

    @StableApi
    public final boolean isNeedAppendQuery(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        ArrayList<String> $this$forEach$iv = getWhiteList();
        if ($this$forEach$iv != null) {
            for (String host : $this$forEach$iv) {
                if (StringsKt.contains$default((CharSequence) url, (CharSequence) host, false, 2, (Object) null)) {
                    return true;
                }
            }
        }
        return VideoAsyncHostHelper.isVideoUrlNeedAsyncRequest(url);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0014 A[Catch:{ JSONException -> 0x0043 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.ArrayList<java.lang.String> parseUrlQueryWhiteListConfig(java.lang.String r9) {
        /*
            r8 = this;
            r0 = r9
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ JSONException -> 0x0043 }
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0011
            int r0 = r0.length()     // Catch:{ JSONException -> 0x0043 }
            if (r0 != 0) goto L_0x000f
            goto L_0x0011
        L_0x000f:
            r0 = r1
            goto L_0x0012
        L_0x0011:
            r0 = r2
        L_0x0012:
            if (r0 != 0) goto L_0x004d
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ JSONException -> 0x0043 }
            r0.<init>()     // Catch:{ JSONException -> 0x0043 }
            org.json.JSONArray r3 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0043 }
            r3.<init>(r9)     // Catch:{ JSONException -> 0x0043 }
            r4 = 0
            int r5 = r3.length()     // Catch:{ JSONException -> 0x0043 }
        L_0x0023:
            if (r4 >= r5) goto L_0x0042
            java.lang.String r6 = r3.optString(r4)     // Catch:{ JSONException -> 0x0043 }
            java.lang.String r7 = "host"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)     // Catch:{ JSONException -> 0x0043 }
            r7 = r6
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7     // Catch:{ JSONException -> 0x0043 }
            int r7 = r7.length()     // Catch:{ JSONException -> 0x0043 }
            if (r7 <= 0) goto L_0x0039
            r7 = r2
            goto L_0x003a
        L_0x0039:
            r7 = r1
        L_0x003a:
            if (r7 == 0) goto L_0x003f
            r0.add(r6)     // Catch:{ JSONException -> 0x0043 }
        L_0x003f:
            int r4 = r4 + 1
            goto L_0x0023
        L_0x0042:
            return r0
        L_0x0043:
            r0 = move-exception
            java.lang.String r1 = r0.getMessage()
            java.lang.String r2 = "UrlParamsManager"
            com.baidu.searchbox.player.utils.BdVideoLog.e((java.lang.String) r2, (java.lang.String) r1)
        L_0x004d:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.player.urlparams.UrlParamsManager.parseUrlQueryWhiteListConfig(java.lang.String):java.util.ArrayList");
    }
}
