package fe.mmm.qw.p024if.pf.rg;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import com.mars.kotlin.extension.ExpectKt;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import fe.mmm.qw.p024if.pf.de.yj;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Tag("FlutterDataLoader")
/* renamed from: fe.mmm.qw.if.pf.rg.switch  reason: invalid class name and invalid package */
public final class Cswitch {
    @Nullable

    /* renamed from: ad  reason: collision with root package name */
    public Uri f7905ad;
    @Nullable

    /* renamed from: de  reason: collision with root package name */
    public List<String> f7906de;
    @Nullable

    /* renamed from: fe  reason: collision with root package name */
    public String f7907fe;
    @NotNull
    public final Context qw;
    @Nullable

    /* renamed from: rg  reason: collision with root package name */
    public List<String> f7908rg;
    @Nullable

    /* renamed from: th  reason: collision with root package name */
    public String f7909th;
    @Nullable

    /* renamed from: yj  reason: collision with root package name */
    public Cursor f7910yj;

    public Cswitch(@Nullable MethodChannel methodChannel, @NotNull MethodCall methodCall, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(context, "context");
        this.qw = context;
        String str = (String) methodCall.argument("uri");
        this.f7905ad = str != null ? Uri.parse(str) : null;
        this.f7906de = (List) methodCall.argument("projection");
        this.f7907fe = (String) methodCall.argument("selection");
        this.f7908rg = (List) methodCall.argument("selectionArgs");
        this.f7909th = (String) methodCall.argument("sortOrder");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x017e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object ad(fe.mmm.qw.p024if.pf.rg.Cswitch r15, android.net.Uri r16, java.lang.Integer r17, java.lang.Integer r18, boolean r19, io.flutter.plugin.common.MethodChannel.Result r20) {
        /*
            r0 = r15
            r2 = r16
            r7 = r19
            r8 = r20
            java.lang.String r1 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r1)
            java.lang.String r1 = "$uriCopy"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)
            java.lang.String r1 = "$result"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r1)
            long r9 = android.os.SystemClock.elapsedRealtime()
            java.util.List<java.lang.String> r1 = r0.f7908rg
            r11 = 1
            java.lang.String r3 = "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>"
            r12 = 0
            r13 = 0
            if (r1 == 0) goto L_0x0063
            java.lang.String[] r4 = new java.lang.String[r12]
            java.lang.Object[] r1 = r1.toArray(r4)
            if (r1 == 0) goto L_0x005d
            java.lang.String[] r1 = (java.lang.String[]) r1
            if (r1 == 0) goto L_0x0063
            kotlin.sequences.Sequence r1 = kotlin.collections.ArraysKt___ArraysKt.asSequence((T[]) r1)
            if (r1 == 0) goto L_0x0063
            java.util.Iterator r1 = r1.iterator()
        L_0x0039:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x005a
            java.lang.Object r4 = r1.next()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "mSelectionArgs item is:"
            r5.append(r6)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            com.mars.kotlin.extension.LoggerKt.d$default(r4, r13, r11, r13)
            goto L_0x0039
        L_0x005a:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            goto L_0x0064
        L_0x005d:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>(r3)
            throw r0
        L_0x0063:
            r1 = r13
        L_0x0064:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "uriCopy is: "
            r4.append(r5)
            r4.append(r2)
            java.lang.String r5 = ", mProjection?.toTypedArray() is ："
            r4.append(r5)
            java.util.List<java.lang.String> r5 = r0.f7906de
            if (r5 == 0) goto L_0x008b
            java.lang.String[] r6 = new java.lang.String[r12]
            java.lang.Object[] r5 = r5.toArray(r6)
            if (r5 == 0) goto L_0x0085
            java.lang.String[] r5 = (java.lang.String[]) r5
            goto L_0x008c
        L_0x0085:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>(r3)
            throw r0
        L_0x008b:
            r5 = r13
        L_0x008c:
            r4.append(r5)
            java.lang.String r5 = ",mSelection is :"
            r4.append(r5)
            java.lang.String r5 = r0.f7907fe
            r4.append(r5)
            java.lang.String r5 = ", mSelectionArgs is :"
            r4.append(r5)
            r4.append(r1)
            java.lang.String r1 = ",mSortOrder is :"
            r4.append(r1)
            java.lang.String r1 = r0.f7909th
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            com.mars.kotlin.extension.LoggerKt.d$default(r1, r13, r11, r13)
            android.content.Context r1 = r0.qw
            android.content.ContentResolver r1 = r1.getContentResolver()
            java.util.List<java.lang.String> r4 = r0.f7906de
            if (r4 == 0) goto L_0x00cd
            java.lang.String[] r5 = new java.lang.String[r12]
            java.lang.Object[] r4 = r4.toArray(r5)
            if (r4 == 0) goto L_0x00c7
            java.lang.String[] r4 = (java.lang.String[]) r4
            goto L_0x00ce
        L_0x00c7:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>(r3)
            throw r0
        L_0x00cd:
            r4 = r13
        L_0x00ce:
            java.lang.String r5 = r0.f7907fe
            java.util.List<java.lang.String> r6 = r0.f7908rg
            if (r6 == 0) goto L_0x00e5
            java.lang.String[] r14 = new java.lang.String[r12]
            java.lang.Object[] r6 = r6.toArray(r14)
            if (r6 == 0) goto L_0x00df
            java.lang.String[] r6 = (java.lang.String[]) r6
            goto L_0x00e6
        L_0x00df:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>(r3)
            throw r0
        L_0x00e5:
            r6 = r13
        L_0x00e6:
            java.lang.String r14 = r0.f7909th
            r2 = r16
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r14
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6)
            r0.f7910yj = r1
            long r1 = android.os.SystemClock.elapsedRealtime()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "query db spent "
            r3.append(r4)
            long r4 = r1 - r9
            r3.append(r4)
            java.lang.String r4 = "ms"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.mars.kotlin.extension.LoggerKt.d$default(r3, r13, r11, r13)
            android.database.Cursor r3 = r0.f7910yj
            if (r3 == 0) goto L_0x017e
            r3 = r17
            r5 = r18
            java.util.List r3 = r15.th(r3, r5)
            long r5 = android.os.SystemClock.elapsedRealtime()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "cursor read spent "
            r9.append(r10)
            long r5 = r5 - r1
            r9.append(r5)
            r9.append(r4)
            java.lang.String r1 = r9.toString()
            com.mars.kotlin.extension.LoggerKt.d$default(r1, r13, r11, r13)
            java.util.LinkedHashMap r1 = new java.util.LinkedHashMap
            r1.<init>()
            if (r7 == 0) goto L_0x016b
            android.database.Cursor r0 = r0.f7910yj
            if (r0 == 0) goto L_0x014a
            int r12 = r0.getCount()
        L_0x014a:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r12)
            java.lang.String r2 = "count"
            r1.put(r2, r0)
            java.lang.String r0 = "data"
            r1.put(r0, r3)
            android.os.Handler r0 = new android.os.Handler
            android.os.Looper r2 = android.os.Looper.getMainLooper()
            r0.<init>(r2)
            fe.mmm.qw.if.pf.rg.ad r2 = new fe.mmm.qw.if.pf.rg.ad
            r2.<init>(r8, r1)
            boolean r0 = r0.post(r2)
            goto L_0x0190
        L_0x016b:
            android.os.Handler r0 = new android.os.Handler
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            r0.<init>(r1)
            fe.mmm.qw.if.pf.rg.th r1 = new fe.mmm.qw.if.pf.rg.th
            r1.<init>(r8, r3)
            boolean r0 = r0.post(r1)
            goto L_0x0190
        L_0x017e:
            android.os.Handler r0 = new android.os.Handler
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            r0.<init>(r1)
            fe.mmm.qw.if.pf.rg.yj r1 = new fe.mmm.qw.if.pf.rg.yj
            r1.<init>(r7, r8)
            boolean r0 = r0.post(r1)
        L_0x0190:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.p024if.pf.rg.Cswitch.ad(fe.mmm.qw.if.pf.rg.switch, android.net.Uri, java.lang.Integer, java.lang.Integer, boolean, io.flutter.plugin.common.MethodChannel$Result):java.lang.Object");
    }

    public static final void de(MethodChannel.Result result, Map map) {
        Intrinsics.checkNotNullParameter(result, "$result");
        Intrinsics.checkNotNullParameter(map, "$mapResult");
        result.success(map);
    }

    public static final void fe(MethodChannel.Result result, List list) {
        Intrinsics.checkNotNullParameter(result, "$result");
        Intrinsics.checkNotNullParameter(list, "$data");
        result.success(list);
    }

    public static final void rg(boolean z, MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(result, "$result");
        if (z) {
            result.success(MapsKt__MapsKt.emptyMap());
        } else {
            result.success(CollectionsKt__CollectionsKt.emptyList());
        }
    }

    public final void qw(@NotNull MethodChannel.Result result, @Nullable Integer num, @Nullable Integer num2, boolean z) {
        Intrinsics.checkNotNullParameter(result, "result");
        Uri uri = this.f7905ad;
        if (uri != null) {
            Intrinsics.checkNotNull(uri);
            Cursor cursor = this.f7910yj;
            if (cursor != null) {
                cursor.close();
            }
            yj.qw("flutter_db_query", new o(this, uri, num, num2, z, result));
        } else if (z) {
            result.success(MapsKt__MapsKt.emptyMap());
        } else {
            result.success(CollectionsKt__CollectionsKt.emptyList());
        }
    }

    public final List<Map<String, Object>> th(Integer num, Integer num2) {
        int intValue = num != null ? num.intValue() : 0;
        int intValue2 = num2 != null ? num2.intValue() : 30;
        ArrayList arrayList = new ArrayList();
        Cursor cursor = this.f7910yj;
        if (cursor != null) {
            try {
                int count = cursor.getCount();
                int i2 = intValue2 == -1 ? count : intValue2;
                String[] columnNames = cursor.getColumnNames();
                int i3 = 0;
                while (true) {
                    if (i3 >= i2) {
                        break;
                    }
                    int i4 = intValue + i3;
                    if (i4 >= count) {
                        break;
                    }
                    cursor.moveToPosition(i4);
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put("pos_in_cursor", String.valueOf(i4));
                    Intrinsics.checkNotNullExpressionValue(columnNames, "names");
                    int length = columnNames.length;
                    int i5 = 0;
                    int i6 = 0;
                    while (i6 < length) {
                        String str = columnNames[i6];
                        int i7 = i5 + 1;
                        String string = cursor.getString(i5);
                        if (string != null) {
                            Intrinsics.checkNotNullExpressionValue(str, "name");
                            linkedHashMap.put(str, string);
                        }
                        i6++;
                        i5 = i7;
                    }
                    arrayList.add(linkedHashMap);
                    i3++;
                }
                ExpectKt.success(Unit.INSTANCE);
            } catch (Exception e) {
                e.printStackTrace();
            } catch (Throwable th2) {
                try {
                    LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
                    ExpectKt.failure(th2);
                } catch (Throwable th3) {
                    Throwable th4 = th3;
                    try {
                        throw th4;
                    } catch (Throwable th5) {
                        Throwable th6 = th5;
                        CloseableKt.closeFinally(cursor, th4);
                        throw th6;
                    }
                }
            }
            CloseableKt.closeFinally(cursor, (Throwable) null);
        }
        return arrayList;
    }
}
