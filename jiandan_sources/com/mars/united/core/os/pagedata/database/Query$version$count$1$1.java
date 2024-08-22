package com.mars.united.core.os.pagedata.database;

import android.database.Cursor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class Query$version$count$1$1 extends Lambda implements Function0<Integer> {
    public final /* synthetic */ Cursor $it;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Query$version$count$1$1(Cursor cursor) {
        super(0);
        this.$it = cursor;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0027 A[Catch:{ Exception -> 0x0036 }] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0028 A[Catch:{ Exception -> 0x0036 }] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Integer invoke() {
        /*
            r3 = this;
            android.database.Cursor r0 = r3.$it
            java.lang.String r1 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.String r1 = "count"
            java.lang.String r1 = r1.toString()
            int r1 = r0.getColumnIndex(r1)
            r2 = 0
            if (r1 >= 0) goto L_0x0015
            goto L_0x0036
        L_0x0015:
            java.lang.String r0 = r0.getString(r1)     // Catch:{ Exception -> 0x0036 }
            if (r0 == 0) goto L_0x0024
            int r1 = r0.length()     // Catch:{ Exception -> 0x0036 }
            if (r1 != 0) goto L_0x0022
            goto L_0x0024
        L_0x0022:
            r1 = 0
            goto L_0x0025
        L_0x0024:
            r1 = 1
        L_0x0025:
            if (r1 == 0) goto L_0x0028
            goto L_0x0036
        L_0x0028:
            java.lang.String r1 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch:{ Exception -> 0x0036 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x0036 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x0036 }
            r2 = r0
        L_0x0036:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mars.united.core.os.pagedata.database.Query$version$count$1$1.invoke():java.lang.Integer");
    }
}
