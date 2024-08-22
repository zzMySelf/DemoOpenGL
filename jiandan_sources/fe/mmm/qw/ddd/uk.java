package fe.mmm.qw.ddd;

import android.content.Context;
import androidx.annotation.WorkerThread;
import com.baidu.sapi2.activity.LoginActivity;
import com.terascan.algo.DocumentScanAPI;
import com.terascan.algo.Point;
import java.util.ArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class uk {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final Object f7737ad = new Object();

    /* renamed from: de  reason: collision with root package name */
    public int f7738de;

    /* renamed from: fe  reason: collision with root package name */
    public int f7739fe;
    @Nullable
    public DocumentScanAPI qw;

    /* renamed from: rg  reason: collision with root package name */
    public int f7740rg;

    /* renamed from: th  reason: collision with root package name */
    public int f7741th;

    /* renamed from: yj  reason: collision with root package name */
    public int f7742yj;

    public final boolean ad(@NotNull ArrayList<Point> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, LoginActivity.EXTRA_PARAM_THIRD_VERIFY_RESPONSE);
        Point point = arrayList.get(0);
        Intrinsics.checkNotNullExpressionValue(point, "response[ZERO]");
        Point point2 = arrayList.get(1);
        Intrinsics.checkNotNullExpressionValue(point2, "response[ONE]");
        Point point3 = arrayList.get(2);
        Intrinsics.checkNotNullExpressionValue(point3, "response[TWO]");
        double rg2 = rg(point, point2, point3);
        Point point4 = arrayList.get(1);
        Intrinsics.checkNotNullExpressionValue(point4, "response[ONE]");
        Point point5 = arrayList.get(2);
        Intrinsics.checkNotNullExpressionValue(point5, "response[TWO]");
        Point point6 = arrayList.get(3);
        Intrinsics.checkNotNullExpressionValue(point6, "response[THREE]");
        double rg3 = rg(point4, point5, point6);
        Point point7 = arrayList.get(2);
        Intrinsics.checkNotNullExpressionValue(point7, "response[TWO]");
        Point point8 = arrayList.get(3);
        Intrinsics.checkNotNullExpressionValue(point8, "response[THREE]");
        Point point9 = arrayList.get(0);
        Intrinsics.checkNotNullExpressionValue(point9, "response[ZERO]");
        double rg4 = rg(point7, point8, point9);
        if (rg2 < 55.0d || rg2 > 125.0d) {
            this.f7741th++;
            return true;
        } else if (rg3 < 55.0d || rg3 > 125.0d) {
            this.f7741th++;
            return true;
        } else if (rg4 >= 55.0d && rg4 <= 125.0d) {
            return false;
        } else {
            this.f7741th++;
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00e3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean de(int r8, int r9, @org.jetbrains.annotations.NotNull java.util.ArrayList<com.terascan.algo.Point> r10) {
        /*
            r7 = this;
            java.lang.String r0 = "response"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = 0
            java.lang.Object r1 = r10.get(r0)
            com.terascan.algo.Point r1 = (com.terascan.algo.Point) r1
            float r1 = r1.getX()
            r2 = 0
            r3 = 1
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 != 0) goto L_0x0018
            r1 = 1
            goto L_0x0019
        L_0x0018:
            r1 = 0
        L_0x0019:
            if (r1 == 0) goto L_0x0034
            java.lang.Object r1 = r10.get(r0)
            com.terascan.algo.Point r1 = (com.terascan.algo.Point) r1
            float r1 = r1.getY()
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 != 0) goto L_0x002b
            r1 = 1
            goto L_0x002c
        L_0x002b:
            r1 = 0
        L_0x002c:
            if (r1 == 0) goto L_0x0034
            int r8 = r7.f7738de
            int r8 = r8 + r3
            r7.f7738de = r8
            return r3
        L_0x0034:
            java.lang.Object r1 = r10.get(r0)
            com.terascan.algo.Point r1 = (com.terascan.algo.Point) r1
            float r1 = r1.getX()
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 != 0) goto L_0x0044
            r1 = 1
            goto L_0x0045
        L_0x0044:
            r1 = 0
        L_0x0045:
            if (r1 == 0) goto L_0x0060
            java.lang.Object r1 = r10.get(r3)
            com.terascan.algo.Point r1 = (com.terascan.algo.Point) r1
            float r1 = r1.getX()
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 != 0) goto L_0x0057
            r1 = 1
            goto L_0x0058
        L_0x0057:
            r1 = 0
        L_0x0058:
            if (r1 == 0) goto L_0x0060
            int r8 = r7.f7738de
            int r8 = r8 + r3
            r7.f7738de = r8
            return r3
        L_0x0060:
            r1 = 2
            java.lang.Object r4 = r10.get(r1)
            com.terascan.algo.Point r4 = (com.terascan.algo.Point) r4
            float r4 = r4.getX()
            float r8 = (float) r8
            float r4 = r4 - r8
            float r4 = java.lang.Math.abs(r4)
            r5 = 3
            r6 = 1092616192(0x41200000, float:10.0)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 >= 0) goto L_0x0091
            java.lang.Object r4 = r10.get(r5)
            com.terascan.algo.Point r4 = (com.terascan.algo.Point) r4
            float r4 = r4.getX()
            float r4 = r4 - r8
            float r8 = java.lang.Math.abs(r4)
            int r8 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r8 >= 0) goto L_0x0091
            int r8 = r7.f7739fe
            int r8 = r8 + r3
            r7.f7739fe = r8
            return r3
        L_0x0091:
            java.lang.Object r8 = r10.get(r0)
            com.terascan.algo.Point r8 = (com.terascan.algo.Point) r8
            float r8 = r8.getY()
            int r8 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r8 != 0) goto L_0x00a1
            r8 = 1
            goto L_0x00a2
        L_0x00a1:
            r8 = 0
        L_0x00a2:
            if (r8 == 0) goto L_0x00b9
            java.lang.Object r8 = r10.get(r5)
            com.terascan.algo.Point r8 = (com.terascan.algo.Point) r8
            float r8 = r8.getY()
            int r8 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r8 != 0) goto L_0x00b4
            r8 = 1
            goto L_0x00b5
        L_0x00b4:
            r8 = 0
        L_0x00b5:
            if (r8 == 0) goto L_0x00b9
            r8 = 1
            goto L_0x00ba
        L_0x00b9:
            r8 = 0
        L_0x00ba:
            java.lang.Object r2 = r10.get(r3)
            com.terascan.algo.Point r2 = (com.terascan.algo.Point) r2
            float r2 = r2.getY()
            float r9 = (float) r9
            float r2 = r2 - r9
            float r2 = java.lang.Math.abs(r2)
            int r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r2 >= 0) goto L_0x00e3
            java.lang.Object r10 = r10.get(r1)
            com.terascan.algo.Point r10 = (com.terascan.algo.Point) r10
            float r10 = r10.getY()
            float r10 = r10 - r9
            float r9 = java.lang.Math.abs(r10)
            int r9 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r9 >= 0) goto L_0x00e3
            r9 = 1
            goto L_0x00e4
        L_0x00e3:
            r9 = 0
        L_0x00e4:
            if (r8 == 0) goto L_0x00ee
            if (r9 == 0) goto L_0x00ee
            int r8 = r7.f7739fe
            int r8 = r8 + r3
            r7.f7739fe = r8
            return r3
        L_0x00ee:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.ddd.uk.de(int, int, java.util.ArrayList):boolean");
    }

    public final boolean fe(@NotNull ArrayList<Point> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, LoginActivity.EXTRA_PARAM_THIRD_VERIFY_RESPONSE);
        float sqrt = (float) Math.sqrt((double) (i.de(arrayList.get(0).getX() - arrayList.get(1).getX()) + i.de(arrayList.get(0).getY() - arrayList.get(1).getY())));
        float sqrt2 = sqrt / (((float) Math.sqrt((double) (i.de(arrayList.get(2).getX() - arrayList.get(3).getX()) + i.de(arrayList.get(2).getY() - arrayList.get(3).getY())))) + sqrt);
        if (sqrt2 < 0.35f || sqrt2 > 0.65f) {
            this.f7740rg++;
            return true;
        }
        float sqrt3 = (float) Math.sqrt((double) (i.de(arrayList.get(0).getX() - arrayList.get(3).getX()) + i.de(arrayList.get(0).getY() - arrayList.get(3).getY())));
        float sqrt4 = sqrt3 / (((float) Math.sqrt((double) (i.de(arrayList.get(1).getX() - arrayList.get(2).getX()) + i.de(arrayList.get(1).getY() - arrayList.get(2).getY())))) + sqrt3);
        if (sqrt4 >= 0.35f && sqrt4 <= 0.65f) {
            return false;
        }
        this.f7740rg++;
        return true;
    }

    public final boolean qw(int i2, int i3, @NotNull ArrayList<Point> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "it");
        if (i2 == 0 || i3 == 0) {
            return false;
        }
        int i4 = i2 * i3;
        double ad2 = i.ad(arrayList);
        if (i4 != 0 && ad2 / ((double) i4) >= 0.1d) {
            return false;
        }
        this.f7742yj++;
        return true;
    }

    public final double rg(Point point, Point point2, Point point3) {
        float x = point.getX() - point2.getX();
        float y = point.getY() - point2.getY();
        float x2 = point3.getX() - point2.getX();
        float y2 = point3.getY() - point2.getY();
        return ((double) (((float) Math.acos((double) (((x * x2) + (y * y2)) / (((float) Math.sqrt((double) (i.de(x) + i.de(y)))) * ((float) Math.sqrt((double) (i.de(x2) + i.de(y2)))))))) * ((float) 180))) / 3.141592653589793d;
    }

    @Nullable
    public final DocumentScanAPI th() {
        return this.qw;
    }

    public void uk() {
        synchronized (this.f7737ad) {
            DocumentScanAPI documentScanAPI = this.qw;
            if (documentScanAPI != null) {
                documentScanAPI.release();
            }
            this.qw = null;
            Unit unit = Unit.INSTANCE;
        }
    }

    @WorkerThread
    public final boolean yj(@NotNull Context context) {
        Object obj;
        Boolean bool;
        Intrinsics.checkNotNullParameter(context, "context");
        DocumentScanAPI documentScanAPI = this.qw;
        boolean z = false;
        if (documentScanAPI != null ? Intrinsics.areEqual((Object) documentScanAPI.isInit(), (Object) Boolean.TRUE) : false) {
            return true;
        }
        synchronized (this.f7737ad) {
            DocumentScanAPI documentScanAPI2 = new DocumentScanAPI(context.getAssets());
            this.qw = documentScanAPI2;
            Object obj2 = null;
            try {
                Result.Companion companion = Result.Companion;
                if (documentScanAPI2 != null) {
                    bool = Boolean.valueOf(documentScanAPI2.init("model/" + "ocrwangpanscan_v4_models/enc_scan_384_ziyan_7114_20240202_ohem_opencl.nb", "model/LICENSE", false, false));
                } else {
                    bool = null;
                }
                obj = Result.m1155constructorimpl(bool);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m1155constructorimpl(ResultKt.createFailure(th2));
            }
            if (!Result.m1161isFailureimpl(obj)) {
                obj2 = obj;
            }
            Boolean bool2 = (Boolean) obj2;
            if (bool2 != null) {
                z = bool2.booleanValue();
            }
        }
        return z;
    }
}
