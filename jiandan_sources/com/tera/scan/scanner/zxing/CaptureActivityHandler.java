package com.tera.scan.scanner.zxing;

import android.os.Handler;
import android.os.Message;
import com.baidu.aiscan.R;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import fe.mmm.qw.tt.th.fe;
import fe.mmm.qw.tt.th.yj;
import java.util.Collection;
import java.util.Map;

public final class CaptureActivityHandler extends Handler {

    /* renamed from: rg  reason: collision with root package name */
    public static final String f7335rg = CaptureActivityHandler.class.getSimpleName();

    /* renamed from: ad  reason: collision with root package name */
    public final fe f7336ad;

    /* renamed from: de  reason: collision with root package name */
    public State f7337de = State.SUCCESS;

    /* renamed from: fe  reason: collision with root package name */
    public final fe.mmm.qw.tt.th.uk.fe f7338fe;
    public final CaptureActivity qw;

    public enum State {
        PREVIEW,
        SUCCESS,
        DONE
    }

    public CaptureActivityHandler(CaptureActivity captureActivity, Collection<BarcodeFormat> collection, Map<DecodeHintType, ?> map, String str, fe.mmm.qw.tt.th.uk.fe feVar) {
        this.qw = captureActivity;
        fe feVar2 = new fe(captureActivity, collection, map, str, new yj(captureActivity.getViewfinderView()));
        this.f7336ad = feVar2;
        feVar2.start();
        this.f7338fe = feVar;
        feVar.pf();
        ad();
    }

    public final void ad() {
        if (this.f7337de == State.SUCCESS) {
            this.f7337de = State.PREVIEW;
            this.f7338fe.uk(this.f7336ad.qw(), R.id.decode);
            this.qw.drawViewfinder();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: android.graphics.Bitmap} */
    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r4v4 */
    /* JADX WARNING: type inference failed for: r4v5 */
    /* JADX WARNING: type inference failed for: r4v6 */
    /* JADX WARNING: type inference failed for: r4v7 */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00d5, code lost:
        if (r4.equals("com.android.browser") != false) goto L_0x00d9;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleMessage(android.os.Message r7) {
        /*
            r6 = this;
            int r0 = r7.what
            r1 = 2131363176(0x7f0a0568, float:1.8346153E38)
            if (r0 != r1) goto L_0x000c
            r6.ad()
            goto L_0x00f0
        L_0x000c:
            r1 = 2131362229(0x7f0a01b5, float:1.8344233E38)
            r2 = 0
            r3 = 1
            r4 = 0
            if (r0 != r1) goto L_0x0045
            com.tera.scan.scanner.zxing.CaptureActivityHandler$State r0 = com.tera.scan.scanner.zxing.CaptureActivityHandler.State.SUCCESS
            r6.f7337de = r0
            android.os.Bundle r0 = r7.getData()
            r1 = 1065353216(0x3f800000, float:1.0)
            if (r0 == 0) goto L_0x003a
            java.lang.String r1 = "barcode_bitmap"
            byte[] r1 = r0.getByteArray(r1)
            if (r1 == 0) goto L_0x0034
            int r5 = r1.length
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeByteArray(r1, r2, r5, r4)
            android.graphics.Bitmap$Config r2 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r1 = r1.copy(r2, r3)
            r4 = r1
        L_0x0034:
            java.lang.String r1 = "barcode_scaled_factor"
            float r1 = r0.getFloat(r1)
        L_0x003a:
            com.tera.scan.scanner.zxing.CaptureActivity r0 = r6.qw
            java.lang.Object r7 = r7.obj
            com.google.zxing.Result r7 = (com.google.zxing.Result) r7
            r0.handleDecode(r7, r4, r1)
            goto L_0x00f0
        L_0x0045:
            r1 = 2131362228(0x7f0a01b4, float:1.834423E38)
            if (r0 != r1) goto L_0x005e
            com.tera.scan.scanner.zxing.CaptureActivityHandler$State r7 = com.tera.scan.scanner.zxing.CaptureActivityHandler.State.PREVIEW
            r6.f7337de = r7
            fe.mmm.qw.tt.th.uk.fe r7 = r6.f7338fe
            fe.mmm.qw.tt.th.fe r0 = r6.f7336ad
            android.os.Handler r0 = r0.qw()
            r1 = 2131362227(0x7f0a01b3, float:1.8344229E38)
            r7.uk(r0, r1)
            goto L_0x00f0
        L_0x005e:
            r1 = 2131363177(0x7f0a0569, float:1.8346155E38)
            r5 = -1
            if (r0 != r1) goto L_0x0074
            com.tera.scan.scanner.zxing.CaptureActivity r0 = r6.qw
            java.lang.Object r7 = r7.obj
            android.content.Intent r7 = (android.content.Intent) r7
            r0.setResult(r5, r7)
            com.tera.scan.scanner.zxing.CaptureActivity r7 = r6.qw
            r7.finish()
            goto L_0x00f0
        L_0x0074:
            r1 = 2131362699(0x7f0a038b, float:1.8345186E38)
            if (r0 != r1) goto L_0x00f0
            java.lang.Object r7 = r7.obj
            java.lang.String r7 = (java.lang.String) r7
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "android.intent.action.VIEW"
            r0.<init>(r1)
            r1 = 524288(0x80000, float:7.34684E-40)
            r0.addFlags(r1)
            android.net.Uri r7 = android.net.Uri.parse(r7)
            r0.setData(r7)
            com.tera.scan.scanner.zxing.CaptureActivity r7 = r6.qw
            android.content.pm.PackageManager r7 = r7.getPackageManager()
            r1 = 65536(0x10000, float:9.18355E-41)
            android.content.pm.ResolveInfo r7 = r7.resolveActivity(r0, r1)
            if (r7 == 0) goto L_0x00b4
            android.content.pm.ActivityInfo r7 = r7.activityInfo
            if (r7 == 0) goto L_0x00b4
            java.lang.String r4 = r7.packageName
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r1 = "Using browser in package "
            r7.append(r1)
            r7.append(r4)
            r7.toString()
        L_0x00b4:
            if (r4 == 0) goto L_0x00eb
            int r7 = r4.hashCode()
            r1 = -1243492292(0xffffffffb5e1d03c, float:-1.682441E-6)
            if (r7 == r1) goto L_0x00cf
            r1 = 256457446(0xf493ae6, float:9.9214085E-30)
            if (r7 == r1) goto L_0x00c5
            goto L_0x00d8
        L_0x00c5:
            java.lang.String r7 = "com.android.chrome"
            boolean r7 = r4.equals(r7)
            if (r7 == 0) goto L_0x00d8
            r2 = 1
            goto L_0x00d9
        L_0x00cf:
            java.lang.String r7 = "com.android.browser"
            boolean r7 = r4.equals(r7)
            if (r7 == 0) goto L_0x00d8
            goto L_0x00d9
        L_0x00d8:
            r2 = -1
        L_0x00d9:
            if (r2 == 0) goto L_0x00de
            if (r2 == r3) goto L_0x00de
            goto L_0x00eb
        L_0x00de:
            r0.setPackage(r4)
            r7 = 268435456(0x10000000, float:2.5243549E-29)
            r0.addFlags(r7)
            java.lang.String r7 = "com.android.browser.application_id"
            r0.putExtra(r7, r4)
        L_0x00eb:
            com.tera.scan.scanner.zxing.CaptureActivity r7 = r6.qw     // Catch:{ ActivityNotFoundException -> 0x00f0 }
            r7.startActivity(r0)     // Catch:{ ActivityNotFoundException -> 0x00f0 }
        L_0x00f0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.scanner.zxing.CaptureActivityHandler.handleMessage(android.os.Message):void");
    }

    public void qw() {
        this.f7337de = State.DONE;
        this.f7338fe.m1008if();
        Message.obtain(this.f7336ad.qw(), R.id.quit).sendToTarget();
        try {
            this.f7336ad.join(500);
        } catch (InterruptedException unused) {
        }
        removeMessages(R.id.decode_succeeded);
        removeMessages(R.id.decode_failed);
    }
}
