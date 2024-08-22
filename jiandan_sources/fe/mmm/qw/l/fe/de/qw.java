package fe.mmm.qw.l.fe.de;

import android.net.Uri;
import com.alipay.sdk.m.l.a;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import com.tera.scan.webview.hybrid.factory.HybridDomainCheck;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.Nullable;

@Tag("DomainCheckProvider")
public final class qw implements HybridDomainCheck {
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0037 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean ad(java.lang.String r5) {
        /*
            r4 = this;
            r0 = 1
            r1 = 0
            if (r5 == 0) goto L_0x000d
            boolean r2 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r5)
            if (r2 == 0) goto L_0x000b
            goto L_0x000d
        L_0x000b:
            r2 = 0
            goto L_0x000e
        L_0x000d:
            r2 = 1
        L_0x000e:
            if (r2 == 0) goto L_0x0011
            return r1
        L_0x0011:
            android.net.Uri r2 = android.net.Uri.parse(r5)     // Catch:{ Exception -> 0x0028 }
            java.lang.String r3 = r2.getAuthority()     // Catch:{ Exception -> 0x0028 }
            if (r3 == 0) goto L_0x002d
            java.util.ArrayList r3 = fe.mmm.qw.l.fe.de.ad.qw     // Catch:{ Exception -> 0x0028 }
            java.lang.String r2 = r2.getAuthority()     // Catch:{ Exception -> 0x0028 }
            boolean r2 = kotlin.collections.CollectionsKt___CollectionsKt.contains(r3, r2)     // Catch:{ Exception -> 0x0028 }
            goto L_0x002e
        L_0x0028:
            r2 = move-exception
            r3 = 0
            com.mars.kotlin.extension.LoggerKt.e$default(r2, r3, r0, r3)
        L_0x002d:
            r2 = 0
        L_0x002e:
            if (r2 != 0) goto L_0x0038
            boolean r5 = r4.qw(r5)
            if (r5 == 0) goto L_0x0037
            goto L_0x0038
        L_0x0037:
            r0 = 0
        L_0x0038:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.l.fe.de.qw.ad(java.lang.String):boolean");
    }

    public boolean check(@Nullable String str) {
        return fe.mmm.qw.de.qw.qw.qw.qw(str) || ad(str);
    }

    public final boolean qw(String str) {
        if (str == null || StringsKt__StringsJVMKt.isBlank(str)) {
            return false;
        }
        try {
            Uri parse = Uri.parse(str);
            if (!(parse == null || parse.getHost() == null)) {
                String host = parse.getHost();
                if ((host != null ? StringsKt__StringsKt.indexOf$default((CharSequence) host, a.B, 0, false, 6, (Object) null) : -1) > 0) {
                    return true;
                }
                return false;
            }
        } catch (Exception e) {
            LoggerKt.e$default(e, (Object) null, 1, (Object) null);
        }
        return false;
    }
}
