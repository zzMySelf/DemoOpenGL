package fe.mmm.qw.p024if.pf.rg;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import com.mars.kotlin.extension.ExpectKt;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Tag("FlutterVectorDataLoader")
/* renamed from: fe.mmm.qw.if.pf.rg.ppp  reason: invalid package */
public final class ppp {
    @Nullable

    /* renamed from: ad  reason: collision with root package name */
    public Uri f7896ad;
    @Nullable

    /* renamed from: de  reason: collision with root package name */
    public String f7897de;
    @Nullable

    /* renamed from: fe  reason: collision with root package name */
    public final List<Double> f7898fe;
    @NotNull
    public final Context qw;
    @Nullable

    /* renamed from: rg  reason: collision with root package name */
    public final Double f7899rg;
    @Nullable

    /* renamed from: th  reason: collision with root package name */
    public Cursor f7900th;

    public ppp(@Nullable MethodChannel methodChannel, @NotNull MethodCall methodCall, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(context, "context");
        this.qw = context;
        String str = (String) methodCall.argument("uri");
        this.f7896ad = str != null ? Uri.parse(str) : null;
        this.f7897de = (String) methodCall.argument("selection");
        this.f7898fe = (List) methodCall.argument(VectorDrawableCompat.SHAPE_VECTOR);
        this.f7899rg = (Double) methodCall.argument("confidence");
    }

    public static final void i(MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(result, "$result");
        result.success(MapsKt__MapsKt.emptyMap());
    }

    public static final void rg(ppp ppp, Uri uri, MethodChannel.Result result) {
        int i2;
        List<Map<String, Object>> list;
        ppp ppp2 = ppp;
        MethodChannel.Result result2 = result;
        Intrinsics.checkNotNullParameter(ppp2, "this$0");
        Intrinsics.checkNotNullParameter(uri, "$uriCopy");
        Intrinsics.checkNotNullParameter(result2, "$result");
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            ppp2.f7900th = ppp2.qw.getContentResolver().query(uri, (String[]) null, ppp2.f7897de, (String[]) null, "rawQuery");
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            LoggerKt.d$default("向量查询: query db spent " + (elapsedRealtime2 - elapsedRealtime) + "ms", (Object) null, 1, (Object) null);
            if (ppp2.f7900th != null) {
                List<Map<String, Object>> o2 = ppp.o();
                long elapsedRealtime3 = SystemClock.elapsedRealtime();
                LoggerKt.d$default("向量查询: 共查出：" + o2.size() + "条数据，cursor read spent " + (elapsedRealtime3 - elapsedRealtime2) + "ms", (Object) null, 1, (Object) null);
                HashMap hashMap = new HashMap();
                if (o2.size() <= 1000) {
                    hashMap.putAll(ppp2.de(o2, ppp2.f7898fe));
                } else {
                    ExecutorCompletionService executorCompletionService = new ExecutorCompletionService(when.qw);
                    int size = o2.size() / 1000;
                    int size2 = o2.size() % 1000;
                    if (size >= 0) {
                        int i3 = 0;
                        i2 = 0;
                        while (true) {
                            int i4 = size - 1;
                            if (i3 < i4) {
                                list = o2.subList(i3 * 1000, (i3 + 1) * 1000);
                            } else if (i3 == i4) {
                                if (size2 < 500) {
                                    list = o2.subList(i3 * 1000, o2.size());
                                } else {
                                    list = o2.subList(i3 * 1000, (i3 + 1) * 1000);
                                }
                            } else if (size2 < 500) {
                                list = CollectionsKt__CollectionsKt.emptyList();
                            } else {
                                list = o2.subList(i3 * 1000, o2.size());
                            }
                            if (!list.isEmpty()) {
                                i2++;
                                executorCompletionService.submit(new uk(ppp2, list));
                            }
                            if (i3 == size) {
                                break;
                            }
                            i3++;
                        }
                    } else {
                        i2 = 0;
                    }
                    for (int i5 = 0; i5 < i2; i5++) {
                        hashMap.putAll((Map) executorCompletionService.take().get());
                    }
                }
                long elapsedRealtime4 = SystemClock.elapsedRealtime();
                LoggerKt.d$default("向量查询: 余弦计算：" + o2.size() + "条 spent " + (elapsedRealtime4 - elapsedRealtime3) + "ms", (Object) null, 1, (Object) null);
                new Handler(Looper.getMainLooper()).post(new pf(result2, hashMap));
                return;
            }
            new Handler(Looper.getMainLooper()).post(new fe(result2));
        } catch (Exception e) {
            LoggerKt.e$default(e.toString(), (Object) null, 1, (Object) null);
            new Handler(Looper.getMainLooper()).post(new i(result2));
        }
    }

    public static final Map th(ppp ppp, List list) {
        Intrinsics.checkNotNullParameter(ppp, "this$0");
        Intrinsics.checkNotNullParameter(list, "$vectorList");
        return ppp.de(list, ppp.f7898fe);
    }

    public static final void uk(MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(result, "$result");
        result.success(MapsKt__MapsKt.emptyMap());
    }

    public static final void yj(MethodChannel.Result result, HashMap hashMap) {
        Intrinsics.checkNotNullParameter(result, "$result");
        Intrinsics.checkNotNullParameter(hashMap, "$resultInfo");
        result.success(hashMap);
    }

    @NotNull
    public final List<Float> ad(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "vectorBytes");
        if ((bArr.length == 0) || bArr.length % 4 != 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        FloatBuffer asFloatBuffer = ByteBuffer.wrap(bArr).asFloatBuffer();
        float[] fArr = new float[(bArr.length / 4)];
        asFloatBuffer.get(fArr);
        return ArraysKt___ArraysJvmKt.asList(fArr);
    }

    @NotNull
    public final Map<String, Double> de(@NotNull List<? extends Map<String, ? extends Object>> list, @NotNull List<Double> list2) {
        Intrinsics.checkNotNullParameter(list, "vectorList");
        Intrinsics.checkNotNullParameter(list2, "queryVector");
        HashMap hashMap = new HashMap();
        for (Map map : list) {
            Object obj = map.get(VectorDrawableCompat.SHAPE_VECTOR);
            if (obj != null) {
                byte[] bArr = (byte[]) obj;
                Object obj2 = map.get("fs_id");
                if (obj2 != null) {
                    String str = (String) obj2;
                    List<Float> ad2 = ad(bArr);
                    if (ad2.size() == list2.size()) {
                        double qw2 = qw(ad2, list2);
                        Double d = this.f7899rg;
                        if (d != null && qw2 >= d.doubleValue()) {
                            hashMap.put(str, Double.valueOf(qw2));
                        }
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.ByteArray");
            }
        }
        return hashMap;
    }

    public final void fe(@NotNull MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (this.f7896ad == null || this.f7898fe == null || this.f7899rg == null || when.qw == null) {
            result.success(MapsKt__MapsKt.emptyMap());
            return;
        }
        Uri uri = this.f7896ad;
        Intrinsics.checkNotNull(uri);
        Cursor cursor = this.f7900th;
        if (cursor != null) {
            cursor.close();
        }
        ThreadPoolExecutor qw2 = when.qw;
        if (qw2 != null) {
            qw2.execute(new qw(this, uri, result));
        }
    }

    @SuppressLint({"Range"})
    public final List<Map<String, Object>> o() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = this.f7900th;
        if (cursor != null) {
            try {
                int count = cursor.getCount();
                for (int i2 = 0; i2 < count; i2++) {
                    cursor.moveToPosition(i2);
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    String string = cursor.getString(cursor.getColumnIndex("fs_id"));
                    Intrinsics.checkNotNullExpressionValue(string, "it.getString(it.getColumnIndex(COLUMN_FS_ID))");
                    linkedHashMap.put("fs_id", string);
                    byte[] blob = cursor.getBlob(cursor.getColumnIndex(VectorDrawableCompat.SHAPE_VECTOR));
                    Intrinsics.checkNotNullExpressionValue(blob, "it.getBlob(it.getColumnIndex(COLUMN_VECTOR))");
                    linkedHashMap.put(VectorDrawableCompat.SHAPE_VECTOR, blob);
                    arrayList.add(linkedHashMap);
                }
                ExpectKt.success(Unit.INSTANCE);
            } catch (Throwable th2) {
                LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
                ExpectKt.failure(th2);
            }
            CloseableKt.closeFinally(cursor, (Throwable) null);
        }
        return arrayList;
        try {
        } catch (Throwable th3) {
            CloseableKt.closeFinally(cursor, r0);
            throw th3;
        }
    }

    public final double qw(@NotNull List<Float> list, @NotNull List<Double> list2) {
        Intrinsics.checkNotNullParameter(list, "vector1");
        Intrinsics.checkNotNullParameter(list2, "vector2");
        int size = list.size();
        double d = 0.0d;
        for (int i2 = 0; i2 < size; i2++) {
            d += Math.pow(list.get(i2).doubleValue() - list2.get(i2).doubleValue(), 2.0d);
        }
        return ((double) 1) - ((d * d) / ((double) 4));
    }
}
