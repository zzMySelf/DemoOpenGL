package fe.mmm.qw.rg.qw.de.ad;

import android.content.Context;
import android.widget.Toast;
import com.baidu.aiscan.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class ad {
    @NotNull
    public static final ad qw = new ad();

    public final void ad(@NotNull Context context, @NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "fileList");
        try {
            qw qwVar = new qw(context);
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
            for (String qw2 : list) {
                arrayList.add(qw.qw(qw2));
            }
            qwVar.pf(list, arrayList, (String) null, (String) null);
        } catch (Exception unused) {
            de(context);
        }
    }

    public final void de(Context context) {
        Toast.makeText(context, context.getString(R.string.error), 0).show();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        if (r5 == null) goto L_0x000d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String qw(java.lang.String r5) {
        /*
            r4 = this;
            if (r5 == 0) goto L_0x000d
            java.lang.String r5 = r5.toLowerCase()
            java.lang.String r0 = "this as java.lang.String).toLowerCase()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            if (r5 != 0) goto L_0x000f
        L_0x000d:
            java.lang.String r5 = ""
        L_0x000f:
            java.lang.String r0 = ".doc"
            r1 = 0
            r2 = 2
            r3 = 0
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.endsWith$default(r5, r0, r1, r2, r3)
            if (r0 == 0) goto L_0x001d
            java.lang.String r5 = "application/msword"
            goto L_0x0070
        L_0x001d:
            java.lang.String r0 = ".docx"
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.endsWith$default(r5, r0, r1, r2, r3)
            if (r0 == 0) goto L_0x0028
            java.lang.String r5 = "application/vnd.openxmlformats-officedocument.wordprocessingml.document"
            goto L_0x0070
        L_0x0028:
            java.lang.String r0 = ".pdf"
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.endsWith$default(r5, r0, r1, r2, r3)
            if (r0 != 0) goto L_0x006e
            java.lang.String r0 = ".pdfx"
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.endsWith$default(r5, r0, r1, r2, r3)
            if (r0 == 0) goto L_0x0039
            goto L_0x006e
        L_0x0039:
            java.lang.String r0 = ".xls"
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.endsWith$default(r5, r0, r1, r2, r3)
            if (r0 == 0) goto L_0x0044
            java.lang.String r5 = "application/vnd.ms-excel"
            goto L_0x0070
        L_0x0044:
            java.lang.String r0 = ".xlsx"
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.endsWith$default(r5, r0, r1, r2, r3)
            if (r0 == 0) goto L_0x004f
            java.lang.String r5 = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"
            goto L_0x0070
        L_0x004f:
            java.lang.String r0 = ".png"
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.endsWith$default(r5, r0, r1, r2, r3)
            if (r0 != 0) goto L_0x006b
            java.lang.String r0 = ".jpeg"
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.endsWith$default(r5, r0, r1, r2, r3)
            if (r0 != 0) goto L_0x006b
            java.lang.String r0 = ".jpg"
            boolean r5 = kotlin.text.StringsKt__StringsJVMKt.endsWith$default(r5, r0, r1, r2, r3)
            if (r5 == 0) goto L_0x0068
            goto L_0x006b
        L_0x0068:
            java.lang.String r5 = "*/*"
            goto L_0x0070
        L_0x006b:
            java.lang.String r5 = "image/*"
            goto L_0x0070
        L_0x006e:
            java.lang.String r5 = "application/pdf"
        L_0x0070:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.rg.qw.de.ad.ad.qw(java.lang.String):java.lang.String");
    }
}
