package com.baidu.searchbox.download.center.clearcache.view.funison.similarpicscan;

import com.baidu.searchbox.download.center.clearcache.view.funison.similarpicscan.MediaFile;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "scanFile", "Lcom/baidu/searchbox/download/center/clearcache/view/funison/similarpicscan/MediaFile$ScanMediaFile;", "kotlin.jvm.PlatformType", "invoke", "(Lcom/baidu/searchbox/download/center/clearcache/view/funison/similarpicscan/MediaFile$ScanMediaFile;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ScanSimilarPicManger.kt */
final class ScanSimilarPicManger$checkNeedStartCompare$1 extends Lambda implements Function1<MediaFile.ScanMediaFile, Boolean> {
    public static final ScanSimilarPicManger$checkNeedStartCompare$1 INSTANCE = new ScanSimilarPicManger$checkNeedStartCompare$1();

    ScanSimilarPicManger$checkNeedStartCompare$1() {
        super(1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002b, code lost:
        if (kotlin.text.StringsKt.startsWith$default(r0, com.baidu.searchbox.download.center.clearcache.view.funison.similarpicscan.ScanSimilarPicManger.mTodayDate, false, 2, (java.lang.Object) null) != false) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = r0.logs;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Boolean invoke(com.baidu.searchbox.download.center.clearcache.view.funison.similarpicscan.MediaFile.ScanMediaFile r7) {
        /*
            r6 = this;
            com.baidu.searchbox.download.center.clearcache.view.funison.similarpicscan.MediaFile$SameMediaFileForCache r0 = com.baidu.searchbox.download.center.clearcache.view.funison.similarpicscan.ScanSimilarPicManger.mResultCacheFromDisk
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0016
            java.util.Set<java.lang.String> r0 = r0.logs
            if (r0 == 0) goto L_0x0016
            java.lang.String r3 = r7.date
            boolean r0 = r0.contains(r3)
            if (r0 != r1) goto L_0x0016
            r0 = r1
            goto L_0x0017
        L_0x0016:
            r0 = r2
        L_0x0017:
            r3 = 2
            if (r0 == 0) goto L_0x002d
            java.lang.String r0 = r7.date
            java.lang.String r4 = "scanFile.date"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4)
            java.lang.String r4 = com.baidu.searchbox.download.center.clearcache.view.funison.similarpicscan.ScanSimilarPicManger.mTodayDate
            r5 = 0
            boolean r0 = kotlin.text.StringsKt.startsWith$default(r0, r4, r2, r3, r5)
            if (r0 == 0) goto L_0x0035
        L_0x002d:
            java.util.List<com.baidu.searchbox.download.center.clearcache.view.funison.fileScan.ScanBean> r0 = r7.listFile
            int r0 = r0.size()
            if (r0 >= r3) goto L_0x0036
        L_0x0035:
            goto L_0x0037
        L_0x0036:
            r1 = r2
        L_0x0037:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.download.center.clearcache.view.funison.similarpicscan.ScanSimilarPicManger$checkNeedStartCompare$1.invoke(com.baidu.searchbox.download.center.clearcache.view.funison.similarpicscan.MediaFile$ScanMediaFile):java.lang.Boolean");
    }
}
