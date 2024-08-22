package fe.fe.when.qw.qw.fe;

import android.net.Uri;
import com.mars.kotlin.extension.ExpectKt;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.fp.Either;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public final class ad {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String ad(@org.jetbrains.annotations.NotNull java.lang.String r3, @org.jetbrains.annotations.Nullable java.lang.String r4, @org.jetbrains.annotations.Nullable java.lang.String r5) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = 0
            r1 = 1
            if (r4 == 0) goto L_0x0012
            int r2 = r4.length()
            if (r2 != 0) goto L_0x0010
            goto L_0x0012
        L_0x0010:
            r2 = 0
            goto L_0x0013
        L_0x0012:
            r2 = 1
        L_0x0013:
            if (r2 != 0) goto L_0x0059
            if (r5 == 0) goto L_0x001d
            int r2 = r5.length()
            if (r2 != 0) goto L_0x001e
        L_0x001d:
            r0 = 1
        L_0x001e:
            if (r0 == 0) goto L_0x0021
            goto L_0x0059
        L_0x0021:
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0044 }
            android.net.Uri r0 = android.net.Uri.parse(r3)     // Catch:{ all -> 0x0044 }
            java.util.Set r1 = r0.getQueryParameterNames()     // Catch:{ all -> 0x0044 }
            boolean r1 = r1.contains(r4)     // Catch:{ all -> 0x0044 }
            if (r1 != 0) goto L_0x003e
            android.net.Uri$Builder r0 = r0.buildUpon()     // Catch:{ all -> 0x0044 }
            android.net.Uri$Builder r4 = r0.appendQueryParameter(r4, r5)     // Catch:{ all -> 0x0044 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0044 }
            goto L_0x003f
        L_0x003e:
            r4 = r3
        L_0x003f:
            java.lang.Object r4 = kotlin.Result.m1155constructorimpl(r4)     // Catch:{ all -> 0x0044 }
            goto L_0x004f
        L_0x0044:
            r4 = move-exception
            kotlin.Result$Companion r5 = kotlin.Result.Companion
            java.lang.Object r4 = kotlin.ResultKt.createFailure(r4)
            java.lang.Object r4 = kotlin.Result.m1155constructorimpl(r4)
        L_0x004f:
            boolean r5 = kotlin.Result.m1161isFailureimpl(r4)
            if (r5 == 0) goto L_0x0056
            goto L_0x0057
        L_0x0056:
            r3 = r4
        L_0x0057:
            java.lang.String r3 = (java.lang.String) r3
        L_0x0059:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.when.qw.qw.fe.ad.ad(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    @NotNull
    public static final Map<String, String> de(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        HashMap hashMap = new HashMap();
        try {
            Result.Companion companion = Result.Companion;
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String string = jSONObject.getString(next);
                Intrinsics.checkNotNullExpressionValue(next, "key");
                Intrinsics.checkNotNullExpressionValue(string, "value");
                hashMap.put(next, string);
            }
            Result.m1155constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
        return hashMap;
    }

    @NotNull
    public static final Map<String, String> fe(@Nullable String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (str == null || str.length() == 0) {
            return linkedHashMap;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "result.keys()");
            while (keys.hasNext()) {
                String next = keys.next();
                Intrinsics.checkNotNullExpressionValue(next, "it");
                String string = jSONObject.getString(next);
                Intrinsics.checkNotNullExpressionValue(string, "result.getString(it)");
                linkedHashMap.put(next, string);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return linkedHashMap;
    }

    @Nullable
    public static final String qw(@Nullable String str, @NotNull String str2) {
        Object obj;
        Intrinsics.checkNotNullParameter(str2, "key");
        Object obj2 = null;
        try {
            obj = ExpectKt.success(Uri.decode(new JSONObject(str).get(str2).toString()));
        } catch (Throwable th2) {
            LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
            obj = ExpectKt.failure(th2);
        }
        if (!(obj instanceof Either.Left)) {
            if (obj instanceof Either.Right) {
                obj2 = ((Either.Right) obj).getValue();
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        return (String) obj2;
    }
}
