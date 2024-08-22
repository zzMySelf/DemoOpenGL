package com.baidu.searchbox.bigimage.utils;

import com.baidu.searchbox.bigimage.runtime.BigImageRuntime;
import com.baidu.ubc.UBCManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\u001aL\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00032\b\u0010.\u001a\u0004\u0018\u00010\u00032\b\u0010/\u001a\u0004\u0018\u00010\u00032\b\u00100\u001a\u0004\u0018\u00010\u00032\b\u00101\u001a\u0004\u0018\u00010\u00032\b\u00102\u001a\u0004\u0018\u00010\u00032\b\u00103\u001a\u0004\u0018\u000104H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u0011\u0010 \u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#\"\u000e\u0010$\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u001d\u0010%\u001a\u0004\u0018\u00010&8BX\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b'\u0010(¨\u00065"}, d2 = {"BIG_IMAGE_DEFAULT_0", "", "BIG_IMAGE_FETCH_OPEN_IMAGE_BASE64", "", "BIG_IMAGE_FETCH_OPEN_IMAGE_CACHE", "BIG_IMAGE_FETCH_OPEN_IMAGE_NONE", "BIG_IMAGE_FETCH_OPEN_IMAGE_PREFETCH", "BIG_IMAGE_IS_NOT_UD", "BIG_IMAGE_IS_UD", "BIG_IMAGE_OPEN_IMG_FETCH_MODE", "BIG_IMAGE_PIC_INFO_KEY_PIC_TYPE_MULT", "BIG_IMAGE_PIC_INFO_KEY_PIC_TYPE_SINGLE", "BIG_IMAGE_PREFETCH_OPEN_IMG_FAIL", "BIG_IMAGE_PREFETCH_OPEN_IMG_START", "BIG_IMAGE_PREFETCH_OPEN_IMG_SUCCESS", "BIG_IMAGE_RENDER_MONITOR_SCHEME_VOLUME", "BIG_IMAGE_STATISTICS_VALUE_CATE_COMMODITY", "BIG_IMAGE_STATISTICS_VALUE_CATE_FIRST_SCREEN", "BIG_IMAGE_STATISTICS_VALUE_CATE_RECOMMEND", "BIG_IMAGE_STATISTICS_VALUE_DETAILFR_RELATION", "BIG_IMAGE_STATISTICS_VALUE_DETAIL_DOWNLOAD_CLICK", "BIG_IMAGE_STATISTICS_VALUE_DETAIL_DOWN_BACK", "BIG_IMAGE_STATISTICS_VALUE_DETAIL_SHARE_CLICK", "BIG_IMAGE_STATISTICS_VALUE_DIR_FIRST_ENTER", "BIG_IMAGE_STATISTICS_VALUE_DIR_LEFT_SWIPE", "BIG_IMAGE_STATISTICS_VALUE_DIR_RIGHT_SWIPE", "BIG_IMAGE_STATISTICS_VALUE_IMG_SHITU_CLICK", "BIG_IMAGE_STATISTICS_VALUE_IS_FS_IMMERSIVE", "BIG_IMAGE_STATISTICS_VALUE_IS_FS_NO_IMMERSIVE", "BIG_IMAGE_STATISTICS_VALUE_IS_FS_WALLPAPER_IMMERSIVE", "BIG_IMAGE_STATISTICS_VALUE_IS_FS_WALLPAPER_NO_IMMERSIVE", "BIG_IMAGE_STATISTICS_VALUE_WALLPAPER_PREVIEW_CLICK", "DEBUG", "", "getDEBUG", "()Z", "TAG", "ubcManager", "Lcom/baidu/ubc/UBCManager;", "getUbcManager", "()Lcom/baidu/ubc/UBCManager;", "ubcManager$delegate", "Lkotlin/Lazy;", "onUBCStat", "", "id", "from", "type", "page", "source", "value", "ext", "", "lib-search-bigimage_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: BigImageUBCUtils.kt */
public final class BigImageUBCUtilsKt {
    public static final int BIG_IMAGE_DEFAULT_0 = 0;
    public static final String BIG_IMAGE_FETCH_OPEN_IMAGE_BASE64 = "base64";
    public static final String BIG_IMAGE_FETCH_OPEN_IMAGE_CACHE = "cache";
    public static final String BIG_IMAGE_FETCH_OPEN_IMAGE_NONE = "none";
    public static final String BIG_IMAGE_FETCH_OPEN_IMAGE_PREFETCH = "prefetch";
    public static final int BIG_IMAGE_IS_NOT_UD = 0;
    public static final int BIG_IMAGE_IS_UD = 1;
    public static final String BIG_IMAGE_OPEN_IMG_FETCH_MODE = "open_img_fetch_mode";
    public static final int BIG_IMAGE_PIC_INFO_KEY_PIC_TYPE_MULT = 6;
    public static final int BIG_IMAGE_PIC_INFO_KEY_PIC_TYPE_SINGLE = 5;
    public static final String BIG_IMAGE_PREFETCH_OPEN_IMG_FAIL = "prefetch_open_img_fail";
    public static final String BIG_IMAGE_PREFETCH_OPEN_IMG_START = "prefetch_open_img_start";
    public static final String BIG_IMAGE_PREFETCH_OPEN_IMG_SUCCESS = "prefetch_open_img_success";
    public static final String BIG_IMAGE_RENDER_MONITOR_SCHEME_VOLUME = "schemeVolume";
    public static final int BIG_IMAGE_STATISTICS_VALUE_CATE_COMMODITY = 7;
    public static final int BIG_IMAGE_STATISTICS_VALUE_CATE_FIRST_SCREEN = 1;
    public static final int BIG_IMAGE_STATISTICS_VALUE_CATE_RECOMMEND = 1;
    public static final String BIG_IMAGE_STATISTICS_VALUE_DETAILFR_RELATION = "relation";
    public static final String BIG_IMAGE_STATISTICS_VALUE_DETAIL_DOWNLOAD_CLICK = "detail_downloadclick";
    public static final String BIG_IMAGE_STATISTICS_VALUE_DETAIL_DOWN_BACK = "detail_downback";
    public static final String BIG_IMAGE_STATISTICS_VALUE_DETAIL_SHARE_CLICK = "detail_shareclick";
    public static final int BIG_IMAGE_STATISTICS_VALUE_DIR_FIRST_ENTER = 0;
    public static final int BIG_IMAGE_STATISTICS_VALUE_DIR_LEFT_SWIPE = -1;
    public static final int BIG_IMAGE_STATISTICS_VALUE_DIR_RIGHT_SWIPE = 1;
    public static final String BIG_IMAGE_STATISTICS_VALUE_IMG_SHITU_CLICK = "detail_imgshituclick";
    public static final int BIG_IMAGE_STATISTICS_VALUE_IS_FS_IMMERSIVE = 1;
    public static final int BIG_IMAGE_STATISTICS_VALUE_IS_FS_NO_IMMERSIVE = 0;
    public static final int BIG_IMAGE_STATISTICS_VALUE_IS_FS_WALLPAPER_IMMERSIVE = 3;
    public static final int BIG_IMAGE_STATISTICS_VALUE_IS_FS_WALLPAPER_NO_IMMERSIVE = 2;
    public static final String BIG_IMAGE_STATISTICS_VALUE_WALLPAPER_PREVIEW_CLICK = "wallpaper_previewclick";
    private static final boolean DEBUG = BigImageRuntime.GLOBAL_DEBUG;
    private static final String TAG = "BigImageUBC";
    private static final Lazy ubcManager$delegate = LazyKt.lazy(BigImageUBCUtilsKt$ubcManager$2.INSTANCE);

    public static final boolean getDEBUG() {
        return DEBUG;
    }

    private static final UBCManager getUbcManager() {
        return (UBCManager) ubcManager$delegate.getValue();
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0023 A[Catch:{ all -> 0x00b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002d A[Catch:{ all -> 0x00b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0039 A[Catch:{ all -> 0x00b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0044 A[Catch:{ all -> 0x00b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0050 A[Catch:{ all -> 0x00b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x005b A[Catch:{ all -> 0x00b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0067 A[Catch:{ all -> 0x00b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x007b A[Catch:{ all -> 0x00b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0083 A[Catch:{ all -> 0x00b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x008e A[Catch:{ all -> 0x00b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0095 A[Catch:{ all -> 0x00b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void onUBCStat(java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.Object r12) {
        /*
            java.lang.String r0 = "BigImageUBC"
            java.lang.String r1 = "id"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r1)
            kotlin.Result$Companion r1 = kotlin.Result.Companion     // Catch:{ all -> 0x00b4 }
            r1 = 0
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x00b4 }
            r2.<init>()     // Catch:{ all -> 0x00b4 }
            r3 = r7
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x00b4 }
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L_0x0020
            int r3 = r3.length()     // Catch:{ all -> 0x00b4 }
            if (r3 != 0) goto L_0x001e
            goto L_0x0020
        L_0x001e:
            r3 = r4
            goto L_0x0021
        L_0x0020:
            r3 = r5
        L_0x0021:
            if (r3 != 0) goto L_0x0028
            java.lang.String r3 = "from"
            r2.put(r3, r7)     // Catch:{ all -> 0x00b4 }
        L_0x0028:
            r3 = r8
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x00b4 }
            if (r3 == 0) goto L_0x0036
            int r3 = r3.length()     // Catch:{ all -> 0x00b4 }
            if (r3 != 0) goto L_0x0034
            goto L_0x0036
        L_0x0034:
            r3 = r4
            goto L_0x0037
        L_0x0036:
            r3 = r5
        L_0x0037:
            if (r3 != 0) goto L_0x003f
            java.lang.String r3 = "type"
            r2.put(r3, r8)     // Catch:{ all -> 0x00b4 }
        L_0x003f:
            r3 = r9
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x00b4 }
            if (r3 == 0) goto L_0x004d
            int r3 = r3.length()     // Catch:{ all -> 0x00b4 }
            if (r3 != 0) goto L_0x004b
            goto L_0x004d
        L_0x004b:
            r3 = r4
            goto L_0x004e
        L_0x004d:
            r3 = r5
        L_0x004e:
            if (r3 != 0) goto L_0x0056
            java.lang.String r3 = "page"
            r2.put(r3, r9)     // Catch:{ all -> 0x00b4 }
        L_0x0056:
            r3 = r10
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x00b4 }
            if (r3 == 0) goto L_0x0064
            int r3 = r3.length()     // Catch:{ all -> 0x00b4 }
            if (r3 != 0) goto L_0x0062
            goto L_0x0064
        L_0x0062:
            r3 = r4
            goto L_0x0065
        L_0x0064:
            r3 = r5
        L_0x0065:
            if (r3 != 0) goto L_0x006d
            java.lang.String r3 = "source"
            r2.put(r3, r10)     // Catch:{ all -> 0x00b4 }
        L_0x006d:
            r3 = r11
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x00b4 }
            if (r3 == 0) goto L_0x0078
            int r3 = r3.length()     // Catch:{ all -> 0x00b4 }
            if (r3 != 0) goto L_0x0079
        L_0x0078:
            r4 = r5
        L_0x0079:
            if (r4 != 0) goto L_0x0081
            java.lang.String r3 = "value"
            r2.put(r3, r11)     // Catch:{ all -> 0x00b4 }
        L_0x0081:
            if (r12 == 0) goto L_0x0088
            java.lang.String r3 = "ext"
            r2.put(r3, r12)     // Catch:{ all -> 0x00b4 }
        L_0x0088:
            com.baidu.ubc.UBCManager r3 = getUbcManager()     // Catch:{ all -> 0x00b4 }
            if (r3 == 0) goto L_0x0091
            r3.onEvent((java.lang.String) r6, (org.json.JSONObject) r2)     // Catch:{ all -> 0x00b4 }
        L_0x0091:
            boolean r3 = DEBUG     // Catch:{ all -> 0x00b4 }
            if (r3 == 0) goto L_0x00ac
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b4 }
            r3.<init>()     // Catch:{ all -> 0x00b4 }
            java.lang.String r4 = "大图ubc日志："
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ all -> 0x00b4 }
            java.lang.StringBuilder r3 = r3.append(r2)     // Catch:{ all -> 0x00b4 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00b4 }
            android.util.Log.d(r0, r3)     // Catch:{ all -> 0x00b4 }
        L_0x00ac:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00b4 }
            java.lang.Object r1 = kotlin.Result.m8971constructorimpl(r1)     // Catch:{ all -> 0x00b4 }
            goto L_0x00bf
        L_0x00b4:
            r1 = move-exception
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r1 = kotlin.ResultKt.createFailure(r1)
            java.lang.Object r1 = kotlin.Result.m8971constructorimpl(r1)
        L_0x00bf:
            java.lang.Throwable r1 = kotlin.Result.m8974exceptionOrNullimpl(r1)
            if (r1 == 0) goto L_0x00e7
            r2 = 0
            boolean r3 = DEBUG
            if (r3 == 0) goto L_0x00e5
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "大图ubc日志出错："
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r4 = r1.getMessage()
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            android.util.Log.e(r0, r3)
        L_0x00e5:
        L_0x00e7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.bigimage.utils.BigImageUBCUtilsKt.onUBCStat(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Object):void");
    }
}
