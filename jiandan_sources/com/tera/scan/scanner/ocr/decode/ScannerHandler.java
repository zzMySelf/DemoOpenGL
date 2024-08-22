package com.tera.scan.scanner.ocr.decode;

import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import com.google.zxing.Result;
import fe.mmm.qw.tt.ad.ppp.fe;

public class ScannerHandler extends Handler {

    /* renamed from: ad  reason: collision with root package name */
    public fe f7270ad;

    /* renamed from: de  reason: collision with root package name */
    public Messenger f7271de;

    /* renamed from: fe  reason: collision with root package name */
    public volatile boolean f7272fe;
    public MessageState qw = MessageState.FREE;

    /* renamed from: rg  reason: collision with root package name */
    public byte[] f7273rg = null;

    /* renamed from: th  reason: collision with root package name */
    public ScannerCallback f7274th;

    /* renamed from: uk  reason: collision with root package name */
    public int f7275uk = 0;

    /* renamed from: yj  reason: collision with root package name */
    public int f7276yj = 0;

    public enum MessageState {
        FREE,
        WORKING,
        DONE
    }

    public ScannerHandler(ScannerCallback scannerCallback) {
        fe feVar = new fe();
        this.f7270ad = feVar;
        feVar.start();
        this.f7271de = new Messenger(this);
        this.f7274th = scannerCallback;
    }

    public void ad() {
        this.qw = MessageState.FREE;
        this.f7272fe = true;
        fe feVar = this.f7270ad;
        if (!(feVar == null || feVar.qw() == null)) {
            this.f7270ad.qw().removeMessages(0);
        }
        removeMessages(2);
        removeMessages(1);
        this.f7273rg = null;
        fe feVar2 = this.f7270ad;
        if (feVar2 != null) {
            feVar2.ad();
            this.f7270ad = null;
        }
        if (this.f7271de != null) {
            this.f7271de = null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void de() {
        /*
            r8 = this;
            monitor-enter(r8)
            boolean r0 = r8.f7272fe     // Catch:{ all -> 0x005e }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r8)
            return
        L_0x0007:
            com.tera.scan.scanner.ocr.decode.ScannerHandler$MessageState r0 = r8.qw     // Catch:{ all -> 0x005e }
            com.tera.scan.scanner.ocr.decode.ScannerHandler$MessageState r1 = com.tera.scan.scanner.ocr.decode.ScannerHandler.MessageState.WORKING     // Catch:{ all -> 0x005e }
            if (r0 == r1) goto L_0x005c
            com.tera.scan.scanner.ocr.decode.ScannerCallback r0 = r8.f7274th     // Catch:{ all -> 0x005e }
            android.graphics.Rect r0 = r0.getPreviewRect()     // Catch:{ all -> 0x005e }
            if (r0 == 0) goto L_0x005c
            com.tera.scan.scanner.ocr.decode.ScannerCallback r0 = r8.f7274th     // Catch:{ all -> 0x005e }
            int r0 = r0.o()     // Catch:{ all -> 0x005e }
            if (r0 == 0) goto L_0x005c
            com.tera.scan.scanner.ocr.decode.ScannerCallback r0 = r8.f7274th     // Catch:{ all -> 0x005e }
            int r0 = r0.rg()     // Catch:{ all -> 0x005e }
            if (r0 != 0) goto L_0x0026
            goto L_0x005c
        L_0x0026:
            com.tera.scan.scanner.ocr.decode.ScannerHandler$MessageState r0 = com.tera.scan.scanner.ocr.decode.ScannerHandler.MessageState.WORKING     // Catch:{ all -> 0x005e }
            r8.qw = r0     // Catch:{ all -> 0x005e }
            fe.mmm.qw.tt.ad.ppp.de r0 = new fe.mmm.qw.tt.ad.ppp.de     // Catch:{ all -> 0x005e }
            byte[] r2 = r8.f7273rg     // Catch:{ all -> 0x005e }
            int r3 = r8.f7276yj     // Catch:{ all -> 0x005e }
            int r4 = r8.f7275uk     // Catch:{ all -> 0x005e }
            com.tera.scan.scanner.ocr.decode.ScannerCallback r1 = r8.f7274th     // Catch:{ all -> 0x005e }
            android.graphics.Rect r5 = r1.getPreviewRect()     // Catch:{ all -> 0x005e }
            com.tera.scan.scanner.ocr.decode.ScannerCallback r1 = r8.f7274th     // Catch:{ all -> 0x005e }
            int r6 = r1.o()     // Catch:{ all -> 0x005e }
            com.tera.scan.scanner.ocr.decode.ScannerCallback r1 = r8.f7274th     // Catch:{ all -> 0x005e }
            int r7 = r1.rg()     // Catch:{ all -> 0x005e }
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x005e }
            fe.mmm.qw.tt.ad.ppp.fe r1 = r8.f7270ad     // Catch:{ all -> 0x005e }
            android.os.Handler r1 = r1.qw()     // Catch:{ all -> 0x005e }
            r2 = 0
            android.os.Message r0 = r1.obtainMessage(r2, r0)     // Catch:{ all -> 0x005e }
            android.os.Messenger r1 = r8.f7271de     // Catch:{ all -> 0x005e }
            r0.replyTo = r1     // Catch:{ all -> 0x005e }
            r0.sendToTarget()     // Catch:{ all -> 0x005e }
            monitor-exit(r8)
            return
        L_0x005c:
            monitor-exit(r8)
            return
        L_0x005e:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.scanner.ocr.decode.ScannerHandler.de():void");
    }

    public void handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 1) {
            this.qw = MessageState.FREE;
        } else if (i2 == 2) {
            this.f7274th.i((Result) message.obj);
            this.qw = MessageState.DONE;
        }
    }

    public void qw(byte[] bArr, int i2, int i3) {
        if (this.f7276yj == 0 || this.f7275uk == 0) {
            this.f7276yj = i2;
            this.f7275uk = i3;
        }
        this.f7273rg = bArr;
        de();
    }
}
