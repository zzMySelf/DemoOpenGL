package com.baidu.wallet.utils.compress;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.text.TextUtils;
import android.view.Surface;
import java.io.IOException;

public class e {
    public static final String b = "video/avc";
    public static final String c = "VideoSlimEncoder";
    public static final boolean d = true;

    /* renamed from: o  reason: collision with root package name */
    public static int f3655o = 25;
    public static int p = 10;
    public static final int q = -233;
    public String a;
    public String e;
    public MediaCodec.BufferInfo f;
    public MediaMuxer g;
    public MediaCodec h;

    /* renamed from: i  reason: collision with root package name */
    public MediaCodec f3656i;
    public int j;
    public a k;
    public int l = -1;
    public int m = -1;
    public int n = -1;
    public final int r = 2500;

    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0260, code lost:
        r0 = r6;
        r6 = r7;
        r7 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:0x03d8, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:?, code lost:
        r0.getMessage();
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:235:0x0467, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x0468, code lost:
        r1 = r0;
        r4 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:264:0x04cf, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:265:0x04d0, code lost:
        r24 = r1;
        r13 = r2;
        r25 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:267:0x04d8, code lost:
        r24 = r1;
        r13 = r2;
        r25 = r7;
        r26 = r10;
        r20 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0123, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0124, code lost:
        r24 = r1;
        r4 = r2;
        r25 = r7;
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x012c, code lost:
        r24 = r1;
        r4 = r2;
        r25 = r7;
        r26 = r10;
        r20 = r15;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x01c4 A[SYNTHETIC, Splitter:B:110:0x01c4] */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x0373 A[Catch:{ Exception -> 0x046c, all -> 0x0467 }] */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x0375 A[Catch:{ Exception -> 0x046c, all -> 0x0467 }] */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x038a A[Catch:{ Exception -> 0x046c, all -> 0x0467 }] */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x0411 A[Catch:{ Exception -> 0x046c, all -> 0x0467 }] */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x0467 A[ExcHandler: all (r0v25 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:110:0x01c4] */
    /* JADX WARNING: Removed duplicated region for block: B:247:0x048e A[SYNTHETIC, Splitter:B:247:0x048e] */
    /* JADX WARNING: Removed duplicated region for block: B:264:0x04cf A[ExcHandler: all (th java.lang.Throwable), Splitter:B:50:0x0102] */
    /* JADX WARNING: Removed duplicated region for block: B:284:0x050f  */
    /* JADX WARNING: Removed duplicated region for block: B:286:0x0514  */
    /* JADX WARNING: Removed duplicated region for block: B:288:0x0519 A[SYNTHETIC, Splitter:B:288:0x0519] */
    /* JADX WARNING: Removed duplicated region for block: B:297:0x0542  */
    /* JADX WARNING: Removed duplicated region for block: B:299:0x0547  */
    /* JADX WARNING: Removed duplicated region for block: B:301:0x054c A[SYNTHETIC, Splitter:B:301:0x054c] */
    /* JADX WARNING: Removed duplicated region for block: B:313:0x0382 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0123 A[ExcHandler: all (r0v80 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:61:0x011f] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0137 A[SYNTHETIC, Splitter:B:67:0x0137] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0151 A[SYNTHETIC, Splitter:B:75:0x0151] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x016d  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0175 A[SYNTHETIC, Splitter:B:85:0x0175] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(android.content.Context r35, android.net.Uri r36, java.lang.String r37, com.baidu.wallet.utils.compress.b r38) {
        /*
            r34 = this;
            r11 = r34
            r1 = r36
            r2 = r37
            r3 = r38
            java.lang.String r12 = "time = "
            java.lang.String r0 = com.baidu.wallet.utils.compress.d.a(r35, r36)     // Catch:{ URISyntaxException -> 0x0011 }
            r11.a = r0     // Catch:{ URISyntaxException -> 0x0011 }
            goto L_0x0015
        L_0x0011:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0015:
            r11.e = r2
            java.lang.String r0 = r11.a
            boolean r0 = r11.a((java.lang.String) r0, (java.lang.String) r2)
            r13 = 0
            if (r0 == 0) goto L_0x0021
            return r13
        L_0x0021:
            android.media.MediaMetadataRetriever r0 = new android.media.MediaMetadataRetriever
            r0.<init>()
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 29
            if (r4 < r5) goto L_0x0032
            r4 = r35
            r0.setDataSource(r4, r1)
            goto L_0x0039
        L_0x0032:
            r4 = r35
            java.lang.String r6 = r11.a
            r0.setDataSource(r6)
        L_0x0039:
            r6 = 18
            java.lang.String r6 = r0.extractMetadata(r6)
            r7 = 19
            java.lang.String r7 = r0.extractMetadata(r7)
            r8 = 24
            r0.extractMetadata(r8)
            r8 = 9
            java.lang.String r0 = r0.extractMetadata(r8)
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            long r8 = r0.longValue()
            r14 = 1000(0x3e8, double:4.94E-321)
            long r8 = r8 * r14
            java.lang.Integer r0 = java.lang.Integer.valueOf(r6)
            int r0 = r0.intValue()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r7)
            int r6 = r6.intValue()
            int r7 = r0 / 2
            r11.l = r7
            int r10 = r6 / 2
            r11.m = r10
            int r10 = r7 % 2
            r14 = 1
            if (r10 == 0) goto L_0x007c
            int r7 = r7 - r14
            r11.l = r7
        L_0x007c:
            int r7 = r11.m
            int r10 = r7 % 2
            if (r10 == 0) goto L_0x0085
            int r7 = r7 - r14
            r11.m = r7
        L_0x0085:
            int r7 = r11.l
            int r10 = r11.m
            int r7 = r7 * r10
            int r7 = r7 * 2
            r11.n = r7
            long r18 = java.lang.System.currentTimeMillis()
            java.io.File r15 = new java.io.File
            r15.<init>(r2)
            java.io.File r10 = new java.io.File
            java.lang.String r2 = r11.a
            r10.<init>(r2)
            android.content.ContentResolver r2 = r35.getContentResolver()
            int r4 = android.os.Build.VERSION.SDK_INT
            if (r4 >= r5) goto L_0x00ae
            boolean r4 = r10.canRead()
            if (r4 != 0) goto L_0x00ae
            return r13
        L_0x00ae:
            java.lang.String r7 = "r"
            android.content.res.AssetFileDescriptor r7 = r2.openAssetFileDescriptor(r1, r7)     // Catch:{ Exception -> 0x0537, all -> 0x0506 }
            android.media.MediaExtractor r2 = new android.media.MediaExtractor     // Catch:{ Exception -> 0x04fc, all -> 0x04f4 }
            r2.<init>()     // Catch:{ Exception -> 0x04fc, all -> 0x04f4 }
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x04eb, all -> 0x04e4 }
            if (r1 < r5) goto L_0x00f6
            if (r7 != 0) goto L_0x00e2
            r2.release()
            if (r7 == 0) goto L_0x00cd
            r7.close()     // Catch:{ IOException -> 0x00c8 }
            goto L_0x00cd
        L_0x00c8:
            r0 = move-exception
            r1 = r0
            r1.printStackTrace()
        L_0x00cd:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
        L_0x00d2:
            r0.append(r12)
            long r1 = java.lang.System.currentTimeMillis()
            long r1 = r1 - r18
            r0.append(r1)
            r0.toString()
            return r13
        L_0x00e2:
            r2.setDataSource(r7)     // Catch:{ Exception -> 0x00ed, all -> 0x00e6 }
            goto L_0x00fd
        L_0x00e6:
            r0 = move-exception
            r1 = r0
            r4 = r2
            r25 = r7
            goto L_0x04f9
        L_0x00ed:
            r4 = r2
            r25 = r7
            r26 = r10
            r20 = r15
            goto L_0x0503
        L_0x00f6:
            java.lang.String r1 = r10.toString()     // Catch:{ Exception -> 0x04eb, all -> 0x04e4 }
            r2.setDataSource(r1)     // Catch:{ Exception -> 0x04eb, all -> 0x04e4 }
        L_0x00fd:
            android.media.MediaExtractor r1 = new android.media.MediaExtractor     // Catch:{ Exception -> 0x04eb, all -> 0x04e4 }
            r1.<init>()     // Catch:{ Exception -> 0x04eb, all -> 0x04e4 }
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x04d8, all -> 0x04cf }
            if (r4 < r5) goto L_0x0137
            if (r7 != 0) goto L_0x011f
            r2.release()
            r1.release()
            if (r7 == 0) goto L_0x0119
            r7.close()     // Catch:{ IOException -> 0x0114 }
            goto L_0x0119
        L_0x0114:
            r0 = move-exception
            r1 = r0
            r1.printStackTrace()
        L_0x0119:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            goto L_0x00d2
        L_0x011f:
            r1.setDataSource(r7)     // Catch:{ Exception -> 0x012c, all -> 0x0123 }
            goto L_0x013e
        L_0x0123:
            r0 = move-exception
            r24 = r1
            r4 = r2
            r25 = r7
            r1 = r0
            goto L_0x050d
        L_0x012c:
            r24 = r1
            r4 = r2
            r25 = r7
            r26 = r10
            r20 = r15
            goto L_0x0540
        L_0x0137:
            java.lang.String r4 = r10.toString()     // Catch:{ Exception -> 0x04d8, all -> 0x04cf }
            r1.setDataSource(r4)     // Catch:{ Exception -> 0x04d8, all -> 0x04cf }
        L_0x013e:
            android.media.MediaMuxer r4 = new android.media.MediaMuxer     // Catch:{ IOException -> 0x04bb }
            java.lang.String r5 = r11.e     // Catch:{ IOException -> 0x04bb }
            r4.<init>(r5, r13)     // Catch:{ IOException -> 0x04bb }
            r11.g = r4     // Catch:{ IOException -> 0x04bb }
            int r4 = r11.a((android.media.MediaExtractor) r1, (boolean) r14)     // Catch:{ Exception -> 0x04d8, all -> 0x04cf }
            r20 = r15
            r14 = 0
            if (r4 < 0) goto L_0x016d
            r1.selectTrack(r4)     // Catch:{ Exception -> 0x0164, all -> 0x0123 }
            r1.seekTo(r14, r13)     // Catch:{ Exception -> 0x0164, all -> 0x0123 }
            android.media.MediaFormat r4 = r1.getTrackFormat(r4)     // Catch:{ Exception -> 0x0164, all -> 0x0123 }
            android.media.MediaMuxer r5 = r11.g     // Catch:{ Exception -> 0x0164, all -> 0x0123 }
            int r4 = r5.addTrack(r4)     // Catch:{ Exception -> 0x0164, all -> 0x0123 }
            r21 = r4
            goto L_0x016f
        L_0x0164:
            r24 = r1
            r4 = r2
            r25 = r7
            r26 = r10
            goto L_0x0540
        L_0x016d:
            r21 = 0
        L_0x016f:
            int r4 = r11.l     // Catch:{ Exception -> 0x04b3, all -> 0x04cf }
            r22 = -1
            if (r4 != r0) goto L_0x01b7
            int r0 = r11.m     // Catch:{ Exception -> 0x01ad, all -> 0x01a3 }
            if (r0 == r6) goto L_0x017a
            goto L_0x01b7
        L_0x017a:
            android.media.MediaMuxer r3 = r11.g     // Catch:{ Exception -> 0x01ad, all -> 0x01a3 }
            android.media.MediaCodec$BufferInfo r4 = r11.f     // Catch:{ Exception -> 0x01ad, all -> 0x01a3 }
            r0 = 0
            r5 = -1
            r8 = -1
            r24 = r1
            r1 = r34
            r14 = r2
            r25 = r7
            r7 = r8
            r9 = r20
            r26 = r10
            r10 = r0
            long r0 = r1.a((android.media.MediaExtractor) r2, (android.media.MediaMuxer) r3, (android.media.MediaCodec.BufferInfo) r4, (long) r5, (long) r7, (java.io.File) r9, (boolean) r10)     // Catch:{ Exception -> 0x01b4, all -> 0x01a1 }
            int r2 = (r0 > r22 ? 1 : (r0 == r22 ? 0 : -1))
            if (r2 == 0) goto L_0x019b
            r5 = r0
            r10 = r14
            goto L_0x019e
        L_0x019b:
            r10 = r14
            r5 = r22
        L_0x019e:
            r15 = 0
            goto L_0x0474
        L_0x01a1:
            r0 = move-exception
            goto L_0x01a9
        L_0x01a3:
            r0 = move-exception
            r24 = r1
            r14 = r2
            r25 = r7
        L_0x01a9:
            r1 = r0
            r4 = r14
            goto L_0x050d
        L_0x01ad:
            r24 = r1
            r14 = r2
            r25 = r7
            r26 = r10
        L_0x01b4:
            r4 = r14
            goto L_0x0540
        L_0x01b7:
            r24 = r1
            r25 = r7
            r26 = r10
            r10 = r2
            int r1 = r11.a((android.media.MediaExtractor) r10, (boolean) r13)     // Catch:{ Exception -> 0x04b1, all -> 0x04ae }
            if (r1 < 0) goto L_0x0465
            r10.selectTrack(r1)     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            r10.seekTo(r14, r13)     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            android.media.MediaFormat r0 = r10.getTrackFormat(r1)     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            r11.a(r0)     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            android.media.MediaCodec r0 = r11.f3656i     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            java.nio.ByteBuffer[] r2 = r0.getInputBuffers()     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            android.media.MediaCodec r0 = r11.h     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            java.nio.ByteBuffer[] r0 = r0.getOutputBuffers()     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            r5 = 0
            r6 = 0
            r7 = -233(0xffffffffffffff17, float:NaN)
        L_0x01e1:
            if (r6 != 0) goto L_0x0465
            r13 = 2500(0x9c4, double:1.235E-320)
            r15 = -1
            if (r5 != 0) goto L_0x0256
            int r4 = r10.getSampleTrackIndex()     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            if (r4 != r1) goto L_0x0235
            android.media.MediaCodec r4 = r11.f3656i     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            int r4 = r4.dequeueInputBuffer(r13)     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            if (r4 < 0) goto L_0x0239
            int r13 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            r14 = 21
            if (r13 >= r14) goto L_0x0200
            r13 = r2[r4]     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
        L_0x01fe:
            r14 = 0
            goto L_0x0207
        L_0x0200:
            android.media.MediaCodec r13 = r11.f3656i     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            java.nio.ByteBuffer r13 = r13.getInputBuffer(r4)     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            goto L_0x01fe
        L_0x0207:
            int r30 = r10.readSampleData(r13, r14)     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            if (r30 >= 0) goto L_0x0220
            android.media.MediaCodec r5 = r11.f3656i     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            r29 = 0
            r30 = 0
            r31 = 0
            r33 = 4
            r27 = r5
            r28 = r4
            r27.queueInputBuffer(r28, r29, r30, r31, r33)     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            r5 = 1
            goto L_0x0239
        L_0x0220:
            android.media.MediaCodec r14 = r11.f3656i     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            r29 = 0
            long r31 = r10.getSampleTime()     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            r33 = 0
            r27 = r14
            r28 = r4
            r27.queueInputBuffer(r28, r29, r30, r31, r33)     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            r10.advance()     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            goto L_0x0239
        L_0x0235:
            if (r4 != r15) goto L_0x0239
            r4 = 1
            goto L_0x023a
        L_0x0239:
            r4 = 0
        L_0x023a:
            if (r4 == 0) goto L_0x0256
            android.media.MediaCodec r4 = r11.f3656i     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            r13 = 2500(0x9c4, double:1.235E-320)
            int r28 = r4.dequeueInputBuffer(r13)     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            if (r28 < 0) goto L_0x0256
            android.media.MediaCodec r4 = r11.f3656i     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            r29 = 0
            r30 = 0
            r31 = 0
            r33 = 4
            r27 = r4
            r27.queueInputBuffer(r28, r29, r30, r31, r33)     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            r5 = 1
        L_0x0256:
            r13 = r7
            r4 = 1
            r7 = r6
            r6 = r0
            r0 = 1
        L_0x025b:
            if (r4 != 0) goto L_0x0266
            if (r0 == 0) goto L_0x0260
            goto L_0x0266
        L_0x0260:
            r0 = r6
            r6 = r7
            r7 = r13
            r13 = 0
            goto L_0x01e1
        L_0x0266:
            android.media.MediaCodec r14 = r11.h     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            android.media.MediaCodec$BufferInfo r15 = r11.f     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            r29 = r4
            r28 = r5
            r4 = 2500(0x9c4, double:1.235E-320)
            int r14 = r14.dequeueOutputBuffer(r15, r4)     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            r4 = -2
            r5 = -3
            r15 = -1
            if (r14 != r15) goto L_0x027e
            r4 = 0
        L_0x027a:
            r5 = -1
            r15 = 0
            goto L_0x0380
        L_0x027e:
            if (r14 != r5) goto L_0x028e
            int r15 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            r5 = 21
            if (r15 >= r5) goto L_0x028c
            android.media.MediaCodec r5 = r11.h     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            java.nio.ByteBuffer[] r6 = r5.getOutputBuffers()     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
        L_0x028c:
            r4 = r0
            goto L_0x027a
        L_0x028e:
            if (r14 != r4) goto L_0x02a8
            android.media.MediaCodec r5 = r11.h     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            android.media.MediaFormat r5 = r5.getOutputFormat()     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            r15 = -233(0xffffffffffffff17, float:NaN)
            if (r13 != r15) goto L_0x028c
            android.media.MediaMuxer r13 = r11.g     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            int r13 = r13.addTrack(r5)     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            r11.j = r13     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            android.media.MediaMuxer r5 = r11.g     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            r5.start()     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            goto L_0x028c
        L_0x02a8:
            if (r14 < 0) goto L_0x044e
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            r7 = 21
            if (r5 >= r7) goto L_0x02b3
            r5 = r6[r14]     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            goto L_0x02b9
        L_0x02b3:
            android.media.MediaCodec r5 = r11.h     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            java.nio.ByteBuffer r5 = r5.getOutputBuffer(r14)     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
        L_0x02b9:
            if (r5 == 0) goto L_0x0432
            android.media.MediaCodec$BufferInfo r15 = r11.f     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            int r15 = r15.size     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            r7 = 1
            if (r15 <= r7) goto L_0x0369
            android.media.MediaCodec$BufferInfo r7 = r11.f     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            int r7 = r7.flags     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            r7 = r7 & 2
            if (r7 != 0) goto L_0x02d3
            android.media.MediaMuxer r7 = r11.g     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            android.media.MediaCodec$BufferInfo r15 = r11.f     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            r7.writeSampleData(r13, r5, r15)     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            goto L_0x0369
        L_0x02d3:
            r7 = -233(0xffffffffffffff17, float:NaN)
            if (r13 != r7) goto L_0x0369
            android.media.MediaCodec$BufferInfo r13 = r11.f     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            int r13 = r13.size     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            byte[] r13 = new byte[r13]     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            android.media.MediaCodec$BufferInfo r15 = r11.f     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            int r15 = r15.offset     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            android.media.MediaCodec$BufferInfo r7 = r11.f     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            int r7 = r7.size     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            int r15 = r15 + r7
            r5.limit(r15)     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            android.media.MediaCodec$BufferInfo r7 = r11.f     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            int r7 = r7.offset     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            r5.position(r7)     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            r5.get(r13)     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            android.media.MediaCodec$BufferInfo r5 = r11.f     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            int r5 = r5.size     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            r7 = 1
            int r5 = r5 - r7
        L_0x02f9:
            if (r5 < 0) goto L_0x0341
            r15 = 3
            if (r5 <= r15) goto L_0x0341
            byte r15 = r13[r5]     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            if (r15 != r7) goto L_0x0338
            int r7 = r5 + -1
            byte r7 = r13[r7]     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            if (r7 != 0) goto L_0x0338
            int r7 = r5 + -2
            byte r7 = r13[r7]     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            if (r7 != 0) goto L_0x0338
            int r7 = r5 + -3
            byte r15 = r13[r7]     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            if (r15 != 0) goto L_0x0338
            java.nio.ByteBuffer r5 = java.nio.ByteBuffer.allocate(r7)     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            android.media.MediaCodec$BufferInfo r15 = r11.f     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            int r15 = r15.size     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            int r15 = r15 - r7
            java.nio.ByteBuffer r15 = java.nio.ByteBuffer.allocate(r15)     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            r37 = r0
            r4 = 0
            java.nio.ByteBuffer r0 = r5.put(r13, r4, r7)     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            r0.position(r4)     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            android.media.MediaCodec$BufferInfo r0 = r11.f     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            int r0 = r0.size     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            int r0 = r0 - r7
            java.nio.ByteBuffer r0 = r15.put(r13, r7, r0)     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            r0.position(r4)     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            goto L_0x0345
        L_0x0338:
            r37 = r0
            int r5 = r5 + -1
            r0 = r37
            r4 = -2
            r7 = 1
            goto L_0x02f9
        L_0x0341:
            r37 = r0
            r5 = 0
            r15 = 0
        L_0x0345:
            java.lang.String r0 = "video/avc"
            int r7 = r11.l     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            int r13 = r11.m     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            android.media.MediaFormat r0 = android.media.MediaFormat.createVideoFormat(r0, r7, r13)     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            if (r5 == 0) goto L_0x035d
            if (r15 == 0) goto L_0x035d
            java.lang.String r7 = "csd-0"
            r0.setByteBuffer(r7, r5)     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            java.lang.String r5 = "csd-1"
            r0.setByteBuffer(r5, r15)     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
        L_0x035d:
            android.media.MediaMuxer r5 = r11.g     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            int r13 = r5.addTrack(r0)     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            android.media.MediaMuxer r0 = r11.g     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            r0.start()     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            goto L_0x036b
        L_0x0369:
            r37 = r0
        L_0x036b:
            android.media.MediaCodec$BufferInfo r0 = r11.f     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            int r0 = r0.flags     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            r0 = r0 & 4
            if (r0 == 0) goto L_0x0375
            r0 = 1
            goto L_0x0376
        L_0x0375:
            r0 = 0
        L_0x0376:
            android.media.MediaCodec r5 = r11.h     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            r15 = 0
            r5.releaseOutputBuffer(r14, r15)     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            r4 = r37
            r7 = r0
            r5 = -1
        L_0x0380:
            if (r14 == r5) goto L_0x038a
        L_0x0382:
            r0 = r4
            r5 = r28
            r4 = r29
            r15 = -1
            goto L_0x025b
        L_0x038a:
            android.media.MediaCodec r0 = r11.f3656i     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            android.media.MediaCodec$BufferInfo r14 = r11.f     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            r37 = r6
            r5 = 2500(0x9c4, double:1.235E-320)
            int r0 = r0.dequeueOutputBuffer(r14, r5)     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            r14 = -1
            if (r0 != r14) goto L_0x039f
            r16 = 1000(0x3e8, double:4.94E-321)
        L_0x039b:
            r29 = 0
            goto L_0x0417
        L_0x039f:
            r5 = -3
            if (r0 != r5) goto L_0x03a3
            goto L_0x03bc
        L_0x03a3:
            r5 = -2
            if (r0 != r5) goto L_0x03bf
            android.media.MediaCodec r0 = r11.f3656i     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            android.media.MediaFormat r0 = r0.getOutputFormat()     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            r5.<init>()     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            java.lang.String r6 = "newFormat = "
            r5.append(r6)     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            r5.append(r0)     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            r5.toString()     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
        L_0x03bc:
            r16 = 1000(0x3e8, double:4.94E-321)
            goto L_0x0417
        L_0x03bf:
            if (r0 < 0) goto L_0x041b
            android.media.MediaCodec$BufferInfo r5 = r11.f     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            int r5 = r5.size     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            if (r5 == 0) goto L_0x03c9
            r5 = 1
            goto L_0x03ca
        L_0x03c9:
            r5 = 0
        L_0x03ca:
            android.media.MediaCodec r6 = r11.f3656i     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            r6.releaseOutputBuffer(r0, r5)     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            if (r5 == 0) goto L_0x0407
            com.baidu.wallet.utils.compress.a r0 = r11.k     // Catch:{ Exception -> 0x03d8, all -> 0x0467 }
            r0.c()     // Catch:{ Exception -> 0x03d8, all -> 0x0467 }
            r0 = 0
            goto L_0x03dd
        L_0x03d8:
            r0 = move-exception
            r0.getMessage()     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            r0 = 1
        L_0x03dd:
            if (r0 != 0) goto L_0x0407
            com.baidu.wallet.utils.compress.a r0 = r11.k     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            r0.d()     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            com.baidu.wallet.utils.compress.a r0 = r11.k     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            android.media.MediaCodec$BufferInfo r5 = r11.f     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            long r5 = r5.presentationTimeUs     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            r16 = 1000(0x3e8, double:4.94E-321)
            long r5 = r5 * r16
            r0.a((long) r5)     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            if (r3 == 0) goto L_0x0401
            android.media.MediaCodec$BufferInfo r0 = r11.f     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            long r5 = r0.presentationTimeUs     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            float r0 = (float) r5     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            float r5 = (float) r8     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            float r0 = r0 / r5
            r5 = 1120403456(0x42c80000, float:100.0)
            float r0 = r0 * r5
            r3.a(r0)     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
        L_0x0401:
            com.baidu.wallet.utils.compress.a r0 = r11.k     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            r0.h()     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            goto L_0x0409
        L_0x0407:
            r16 = 1000(0x3e8, double:4.94E-321)
        L_0x0409:
            android.media.MediaCodec$BufferInfo r0 = r11.f     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            int r0 = r0.flags     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            r0 = r0 & 4
            if (r0 == 0) goto L_0x0417
            android.media.MediaCodec r0 = r11.h     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            r0.signalEndOfInputStream()     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            goto L_0x039b
        L_0x0417:
            r6 = r37
            goto L_0x0382
        L_0x041b:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            r2.<init>()     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            java.lang.String r3 = "unexpected result from mDecoder.dequeueOutputBuffer: "
            r2.append(r3)     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            r2.append(r0)     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            throw r1     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
        L_0x0432:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            r1.<init>()     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            java.lang.String r2 = "encoderOutputBuffer "
            r1.append(r2)     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            r1.append(r14)     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            java.lang.String r2 = " was null"
            r1.append(r2)     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            throw r0     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
        L_0x044e:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            r1.<init>()     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            java.lang.String r2 = "unexpected result from mEncoder.dequeueOutputBuffer: "
            r1.append(r2)     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            r1.append(r14)     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
            throw r0     // Catch:{ Exception -> 0x046c, all -> 0x0467 }
        L_0x0465:
            r15 = 0
            goto L_0x046f
        L_0x0467:
            r0 = move-exception
            r1 = r0
            r4 = r10
            goto L_0x050d
        L_0x046c:
            r4 = r10
            goto L_0x0540
        L_0x046f:
            r10.unselectTrack(r1)     // Catch:{ Exception -> 0x04b1, all -> 0x04ae }
            r5 = r22
        L_0x0474:
            android.media.MediaMuxer r3 = r11.g     // Catch:{ Exception -> 0x04b1, all -> 0x04ae }
            android.media.MediaCodec$BufferInfo r4 = r11.f     // Catch:{ Exception -> 0x04b1, all -> 0x04ae }
            r7 = -1
            r1 = r34
            r2 = r24
            r9 = r20
            r13 = r10
            r10 = r21
            r1.a((android.media.MediaExtractor) r2, (android.media.MediaMuxer) r3, (android.media.MediaCodec.BufferInfo) r4, (long) r5, (long) r7, (java.io.File) r9, (int) r10)     // Catch:{ Exception -> 0x04e1, all -> 0x04cd }
            r13.release()
            r24.release()
            if (r25 == 0) goto L_0x0497
            r25.close()     // Catch:{ IOException -> 0x0492 }
            goto L_0x0497
        L_0x0492:
            r0 = move-exception
            r1 = r0
            r1.printStackTrace()
        L_0x0497:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r12)
            long r1 = java.lang.System.currentTimeMillis()
            long r1 = r1 - r18
            r0.append(r1)
            r0.toString()
            r13 = 0
            goto L_0x056a
        L_0x04ae:
            r0 = move-exception
            r13 = r10
            goto L_0x04d5
        L_0x04b1:
            r13 = r10
            goto L_0x04e1
        L_0x04b3:
            r24 = r1
            r13 = r2
            r25 = r7
            r26 = r10
            goto L_0x04e1
        L_0x04bb:
            r0 = move-exception
            r24 = r1
            r13 = r2
            r25 = r7
            r26 = r10
            r20 = r15
            java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ Exception -> 0x04e1, all -> 0x04cd }
            java.lang.String r2 = "MediaMuxer creation failed"
            r1.<init>(r2, r0)     // Catch:{ Exception -> 0x04e1, all -> 0x04cd }
            throw r1     // Catch:{ Exception -> 0x04e1, all -> 0x04cd }
        L_0x04cd:
            r0 = move-exception
            goto L_0x04d5
        L_0x04cf:
            r0 = move-exception
            r24 = r1
            r13 = r2
            r25 = r7
        L_0x04d5:
            r1 = r0
            r4 = r13
            goto L_0x050d
        L_0x04d8:
            r24 = r1
            r13 = r2
            r25 = r7
            r26 = r10
            r20 = r15
        L_0x04e1:
            r4 = r13
            goto L_0x0540
        L_0x04e4:
            r0 = move-exception
            r13 = r2
            r25 = r7
            r1 = r0
            r4 = r13
            goto L_0x04f9
        L_0x04eb:
            r13 = r2
            r25 = r7
            r26 = r10
            r20 = r15
            r4 = r13
            goto L_0x0503
        L_0x04f4:
            r0 = move-exception
            r25 = r7
            r1 = r0
            r4 = 0
        L_0x04f9:
            r24 = 0
            goto L_0x050d
        L_0x04fc:
            r25 = r7
            r26 = r10
            r20 = r15
            r4 = 0
        L_0x0503:
            r24 = 0
            goto L_0x0540
        L_0x0506:
            r0 = move-exception
            r1 = r0
            r4 = 0
            r24 = 0
            r25 = 0
        L_0x050d:
            if (r4 == 0) goto L_0x0512
            r4.release()
        L_0x0512:
            if (r24 == 0) goto L_0x0517
            r24.release()
        L_0x0517:
            if (r25 == 0) goto L_0x0522
            r25.close()     // Catch:{ IOException -> 0x051d }
            goto L_0x0522
        L_0x051d:
            r0 = move-exception
            r2 = r0
            r2.printStackTrace()
        L_0x0522:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r12)
            long r2 = java.lang.System.currentTimeMillis()
            long r2 = r2 - r18
            r0.append(r2)
            r0.toString()
            throw r1
        L_0x0537:
            r26 = r10
            r20 = r15
            r4 = 0
            r24 = 0
            r25 = 0
        L_0x0540:
            if (r4 == 0) goto L_0x0545
            r4.release()
        L_0x0545:
            if (r24 == 0) goto L_0x054a
            r24.release()
        L_0x054a:
            if (r25 == 0) goto L_0x0555
            r25.close()     // Catch:{ IOException -> 0x0550 }
            goto L_0x0555
        L_0x0550:
            r0 = move-exception
            r1 = r0
            r1.printStackTrace()
        L_0x0555:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r12)
            long r1 = java.lang.System.currentTimeMillis()
            long r1 = r1 - r18
            r0.append(r1)
            r0.toString()
            r13 = 1
        L_0x056a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r11.a
            r0.append(r1)
            java.lang.String r1 = ""
            r0.append(r1)
            r0.toString()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = r20.getPath()
            r0.append(r2)
            r0.append(r1)
            r0.toString()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = r26.getPath()
            r0.append(r2)
            r0.append(r1)
            r0.toString()
            r34.a()
            r1 = 1
            r0 = r13 ^ 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.utils.compress.e.a(android.content.Context, android.net.Uri, java.lang.String, com.baidu.wallet.utils.compress.b):boolean");
    }

    private boolean a(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x008b A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private long a(android.media.MediaExtractor r19, android.media.MediaMuxer r20, android.media.MediaCodec.BufferInfo r21, long r22, long r24, java.io.File r26, boolean r27) throws java.lang.Exception {
        /*
            r18 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            r3 = r22
            r5 = r18
            r6 = r27
            int r7 = r5.a((android.media.MediaExtractor) r0, (boolean) r6)
            r8 = -1
            if (r7 < 0) goto L_0x0091
            r0.selectTrack(r7)
            android.media.MediaFormat r10 = r0.getTrackFormat(r7)
            int r11 = r1.addTrack(r10)
            if (r6 != 0) goto L_0x0024
            r20.start()
        L_0x0024:
            java.lang.String r6 = "max-input-size"
            int r6 = r10.getInteger(r6)
            r12 = 0
            r10 = 0
            int r14 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r14 <= 0) goto L_0x0035
            r0.seekTo(r3, r10)
            goto L_0x0038
        L_0x0035:
            r0.seekTo(r12, r10)
        L_0x0038:
            java.nio.ByteBuffer r3 = java.nio.ByteBuffer.allocateDirect(r6)
            r15 = r8
            r4 = 0
        L_0x003e:
            if (r4 != 0) goto L_0x008d
            int r6 = r19.getSampleTrackIndex()
            r17 = 1
            if (r6 != r7) goto L_0x0082
            int r6 = r0.readSampleData(r3, r10)
            r2.size = r6
            if (r6 >= 0) goto L_0x0053
            r2.size = r10
            goto L_0x0085
        L_0x0053:
            r26 = r11
            long r10 = r19.getSampleTime()
            r2.presentationTimeUs = r10
            if (r14 <= 0) goto L_0x0062
            int r6 = (r15 > r8 ? 1 : (r15 == r8 ? 0 : -1))
            if (r6 != 0) goto L_0x0062
            r15 = r10
        L_0x0062:
            int r6 = (r24 > r12 ? 1 : (r24 == r12 ? 0 : -1))
            if (r6 < 0) goto L_0x0070
            long r10 = r2.presentationTimeUs
            int r6 = (r10 > r24 ? 1 : (r10 == r24 ? 0 : -1))
            if (r6 >= 0) goto L_0x006d
            goto L_0x0070
        L_0x006d:
            r11 = r26
            goto L_0x0085
        L_0x0070:
            r10 = 0
            r2.offset = r10
            int r6 = r19.getSampleFlags()
            r2.flags = r6
            r11 = r26
            r1.writeSampleData(r11, r3, r2)
            r19.advance()
            goto L_0x0088
        L_0x0082:
            r10 = -1
            if (r6 != r10) goto L_0x0087
        L_0x0085:
            r10 = 1
            goto L_0x0088
        L_0x0087:
            r10 = 0
        L_0x0088:
            if (r10 == 0) goto L_0x008b
            r4 = 1
        L_0x008b:
            r10 = 0
            goto L_0x003e
        L_0x008d:
            r0.unselectTrack(r7)
            return r15
        L_0x0091:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.utils.compress.e.a(android.media.MediaExtractor, android.media.MediaMuxer, android.media.MediaCodec$BufferInfo, long, long, java.io.File, boolean):long");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0078, code lost:
        if (r9 == -1) goto L_0x007a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0080 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private long a(android.media.MediaExtractor r17, android.media.MediaMuxer r18, android.media.MediaCodec.BufferInfo r19, long r20, long r22, java.io.File r24, int r25) throws java.lang.Exception {
        /*
            r16 = this;
            r0 = r17
            r1 = r19
            r2 = r20
            r4 = 1
            r5 = r16
            int r6 = r5.a((android.media.MediaExtractor) r0, (boolean) r4)
            r7 = -1
            if (r6 < 0) goto L_0x008a
            r0.selectTrack(r6)
            android.media.MediaFormat r9 = r0.getTrackFormat(r6)
            java.lang.String r10 = "max-input-size"
            int r9 = r9.getInteger(r10)
            r10 = 0
            r12 = 0
            int r13 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r13 <= 0) goto L_0x0029
            r0.seekTo(r2, r12)
            goto L_0x002c
        L_0x0029:
            r0.seekTo(r10, r12)
        L_0x002c:
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocateDirect(r9)
            r14 = r7
            r3 = 0
        L_0x0032:
            if (r3 != 0) goto L_0x0086
            int r9 = r17.getSampleTrackIndex()
            if (r9 != r6) goto L_0x0073
            int r9 = r0.readSampleData(r2, r12)
            r1.size = r9
            if (r9 >= 0) goto L_0x0049
            r1.size = r12
        L_0x0044:
            r4 = r18
            r5 = r25
            goto L_0x007a
        L_0x0049:
            long r4 = r17.getSampleTime()
            r1.presentationTimeUs = r4
            if (r13 <= 0) goto L_0x0056
            int r9 = (r14 > r7 ? 1 : (r14 == r7 ? 0 : -1))
            if (r9 != 0) goto L_0x0056
            r14 = r4
        L_0x0056:
            int r4 = (r22 > r10 ? 1 : (r22 == r10 ? 0 : -1))
            if (r4 < 0) goto L_0x0060
            long r4 = r1.presentationTimeUs
            int r9 = (r4 > r22 ? 1 : (r4 == r22 ? 0 : -1))
            if (r9 >= 0) goto L_0x0044
        L_0x0060:
            r1.offset = r12
            int r4 = r17.getSampleFlags()
            r1.flags = r4
            r4 = r18
            r5 = r25
            r4.writeSampleData(r5, r2, r1)
            r17.advance()
            goto L_0x007c
        L_0x0073:
            r4 = r18
            r5 = r25
            r10 = -1
            if (r9 != r10) goto L_0x007c
        L_0x007a:
            r9 = 1
            goto L_0x007d
        L_0x007c:
            r9 = 0
        L_0x007d:
            if (r9 == 0) goto L_0x0080
            r3 = 1
        L_0x0080:
            r5 = r16
            r4 = 1
            r10 = 0
            goto L_0x0032
        L_0x0086:
            r0.unselectTrack(r6)
            return r14
        L_0x008a:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.utils.compress.e.a(android.media.MediaExtractor, android.media.MediaMuxer, android.media.MediaCodec$BufferInfo, long, long, java.io.File, int):long");
    }

    private int a(MediaExtractor mediaExtractor, boolean z) {
        int trackCount = mediaExtractor.getTrackCount();
        for (int i2 = 0; i2 < trackCount; i2++) {
            String string = mediaExtractor.getTrackFormat(i2).getString("mime");
            if (z) {
                if (string.startsWith("audio/")) {
                    return i2;
                }
            } else if (string.startsWith("video/")) {
                return i2;
            }
        }
        return q;
    }

    private void a(MediaFormat mediaFormat) {
        this.f = new MediaCodec.BufferInfo();
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat(b, this.l, this.m);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger("bitrate", this.n);
        createVideoFormat.setInteger("frame-rate", f3655o);
        createVideoFormat.setInteger("i-frame-interval", p);
        "format: " + createVideoFormat;
        try {
            this.h = MediaCodec.createEncoderByType(b);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        this.h.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        a aVar = new a(this.h.createInputSurface());
        this.k = aVar;
        aVar.g();
        this.h.start();
        try {
            this.f3656i = MediaCodec.createDecoderByType(mediaFormat.getString("mime"));
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        this.k.a();
        this.f3656i.configure(mediaFormat, this.k.e(), (MediaCrypto) null, 0);
        this.f3656i.start();
        this.j = -1;
    }

    private void a() {
        MediaCodec mediaCodec = this.h;
        if (mediaCodec != null) {
            mediaCodec.stop();
            this.h.release();
            this.h = null;
        }
        MediaCodec mediaCodec2 = this.f3656i;
        if (mediaCodec2 != null) {
            mediaCodec2.stop();
            this.f3656i.release();
            this.f3656i = null;
        }
        a aVar = this.k;
        if (aVar != null) {
            aVar.f();
            this.k = null;
        }
        MediaMuxer mediaMuxer = this.g;
        if (mediaMuxer != null) {
            try {
                mediaMuxer.stop();
                this.g.release();
                this.g = null;
            } catch (Exception unused) {
            }
        }
    }
}
