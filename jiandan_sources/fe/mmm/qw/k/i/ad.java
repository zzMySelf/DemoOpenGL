package fe.mmm.qw.k.i;

import android.content.Context;
import android.os.Bundle;
import android.os.ResultReceiver;
import fe.mmm.qw.l.de;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ad {
    public static final void ad(@Nullable Context context, @NotNull String str, @Nullable ResultReceiver resultReceiver) {
        Intrinsics.checkNotNullParameter(str, "from");
        if (context != null) {
            fe.mmm.qw.k.pf.uk.ad.ad(context, qw("https://aiscan.baidu.com/wap/svip/scan?na_immerse_theme=1&isHalfCashier=1", "from", str), resultReceiver);
        } else if (resultReceiver != null) {
            resultReceiver.send(2, Bundle.EMPTY);
        }
    }

    public static final void de(@Nullable Context context, @Nullable String str, @NotNull String str2) {
        String str3;
        Intrinsics.checkNotNullParameter(str2, "from");
        if (context != null) {
            if (str == null || str.length() == 0) {
                str3 = qw("https://aiscan.baidu.com/wap/svip/scan?na_immerse_theme=1", "from", str2);
            } else {
                str3 = qw(str, "from", str2);
            }
            de.ad(context, str3);
        }
    }

    public static /* synthetic */ void fe(Context context, String str, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = "";
        }
        if ((i2 & 4) != 0) {
            str2 = "";
        }
        de(context, str, str2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String qw(java.lang.String r3, java.lang.String r4, java.lang.String r5) {
        /*
            r0 = 0
            r1 = 1
            if (r4 == 0) goto L_0x000d
            int r2 = r4.length()
            if (r2 != 0) goto L_0x000b
            goto L_0x000d
        L_0x000b:
            r2 = 0
            goto L_0x000e
        L_0x000d:
            r2 = 1
        L_0x000e:
            if (r2 != 0) goto L_0x0054
            if (r5 == 0) goto L_0x0018
            int r2 = r5.length()
            if (r2 != 0) goto L_0x0019
        L_0x0018:
            r0 = 1
        L_0x0019:
            if (r0 == 0) goto L_0x001c
            goto L_0x0054
        L_0x001c:
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x003f }
            android.net.Uri r0 = android.net.Uri.parse(r3)     // Catch:{ all -> 0x003f }
            java.util.Set r1 = r0.getQueryParameterNames()     // Catch:{ all -> 0x003f }
            boolean r1 = r1.contains(r4)     // Catch:{ all -> 0x003f }
            if (r1 != 0) goto L_0x0039
            android.net.Uri$Builder r0 = r0.buildUpon()     // Catch:{ all -> 0x003f }
            android.net.Uri$Builder r4 = r0.appendQueryParameter(r4, r5)     // Catch:{ all -> 0x003f }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x003f }
            goto L_0x003a
        L_0x0039:
            r4 = r3
        L_0x003a:
            java.lang.Object r4 = kotlin.Result.m1155constructorimpl(r4)     // Catch:{ all -> 0x003f }
            goto L_0x004a
        L_0x003f:
            r4 = move-exception
            kotlin.Result$Companion r5 = kotlin.Result.Companion
            java.lang.Object r4 = kotlin.ResultKt.createFailure(r4)
            java.lang.Object r4 = kotlin.Result.m1155constructorimpl(r4)
        L_0x004a:
            boolean r5 = kotlin.Result.m1161isFailureimpl(r4)
            if (r5 == 0) goto L_0x0051
            goto L_0x0052
        L_0x0051:
            r3 = r4
        L_0x0052:
            java.lang.String r3 = (java.lang.String) r3
        L_0x0054:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.k.i.ad.qw(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }
}
