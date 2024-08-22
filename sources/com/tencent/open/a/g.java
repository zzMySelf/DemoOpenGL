package com.tencent.open.a;

import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.searchbox.BuildConfig;
import com.baidu.searchbox.feed.tts.db.contract.SpeakerConfigTable;
import com.baidu.swan.game.ad.interfaces.IGdtAdResonseInfo;
import com.github.moduth.blockcanary.internal.BlockInfo;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.f;
import com.tencent.open.utils.j;
import com.tencent.open.utils.l;
import java.io.Serializable;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.Executor;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.ByteArrayEntity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class g {

    /* renamed from: a  reason: collision with root package name */
    protected static g f5889a;

    /* renamed from: b  reason: collision with root package name */
    protected Random f5890b = new Random();

    /* renamed from: c  reason: collision with root package name */
    protected List<Serializable> f5891c = Collections.synchronizedList(new ArrayList());

    /* renamed from: d  reason: collision with root package name */
    protected List<Serializable> f5892d = Collections.synchronizedList(new ArrayList());

    /* renamed from: e  reason: collision with root package name */
    protected HandlerThread f5893e = null;

    /* renamed from: f  reason: collision with root package name */
    protected Handler f5894f;

    /* renamed from: g  reason: collision with root package name */
    protected Executor f5895g = j.b();

    /* renamed from: h  reason: collision with root package name */
    protected Executor f5896h = j.b();

    public static synchronized g a() {
        g gVar;
        synchronized (g.class) {
            if (f5889a == null) {
                f5889a = new g();
            }
            gVar = f5889a;
        }
        return gVar;
    }

    private g() {
        if (this.f5893e == null) {
            HandlerThread handlerThread = new HandlerThread("opensdk.report.handlerthread", 10);
            this.f5893e = handlerThread;
            handlerThread.start();
        }
        if (this.f5893e.isAlive() && this.f5893e.getLooper() != null) {
            this.f5894f = new Handler(this.f5893e.getLooper()) {
                public void handleMessage(Message message) {
                    switch (message.what) {
                        case 1000:
                            g.this.b();
                            break;
                        case 1001:
                            g.this.e();
                            break;
                    }
                    super.handleMessage(message);
                }
            };
        }
    }

    public void a(final Bundle bundle, String str, final boolean z) {
        if (bundle != null) {
            SLog.v("openSDK_LOG.ReportManager", "-->reportVia, bundle: " + bundle.toString());
            if (a("report_via", str) || z) {
                this.f5895g.execute(new Runnable() {
                    public void run() {
                        try {
                            String k = l.k(c.b(f.a()));
                            String k2 = l.k(c.c(f.a()));
                            String k3 = l.k(c.a());
                            String k4 = l.k(c.d(f.a()));
                            Bundle bundle = new Bundle();
                            bundle.putString("uin", "1000");
                            bundle.putString("imei", k);
                            bundle.putString("imsi", k2);
                            bundle.putString("android_id", k4);
                            bundle.putString("mac", k3);
                            bundle.putString("platform", "1");
                            bundle.putString("os_ver", Build.VERSION.RELEASE);
                            bundle.putString("position", "");
                            bundle.putString("network", a.a(f.a()));
                            bundle.putString("language", c.b());
                            bundle.putString(IGdtAdResonseInfo.VIDEO_RESOLUTION, c.a(f.a()));
                            bundle.putString("apn", a.b(f.a()));
                            bundle.putString(SpeakerConfigTable.MODEL_NAME, Build.MODEL);
                            bundle.putString("timezone", TimeZone.getDefault().getID());
                            bundle.putString("sdk_ver", Constants.SDK_VERSION);
                            bundle.putString("qz_ver", l.d(f.a(), Constants.PACKAGE_QZONE));
                            bundle.putString("qq_ver", l.c(f.a(), "com.tencent.mobileqq"));
                            bundle.putString(BlockInfo.KEY_QUA, l.e(f.a(), f.b()));
                            bundle.putString("packagename", f.b());
                            bundle.putString("app_ver", l.d(f.a(), f.b()));
                            Bundle bundle2 = bundle;
                            if (bundle2 != null) {
                                bundle.putAll(bundle2);
                            }
                            g.this.f5892d.add(new b(bundle));
                            int size = g.this.f5892d.size();
                            int a2 = com.tencent.open.utils.g.a(f.a(), (String) null).a("Agent_ReportTimeInterval");
                            if (a2 == 0) {
                                a2 = 10000;
                            }
                            if (!g.this.a("report_via", size)) {
                                if (!z) {
                                    if (!g.this.f5894f.hasMessages(1001)) {
                                        Message obtain = Message.obtain();
                                        obtain.what = 1001;
                                        g.this.f5894f.sendMessageDelayed(obtain, (long) a2);
                                        return;
                                    }
                                    return;
                                }
                            }
                            g.this.e();
                            g.this.f5894f.removeMessages(1001);
                        } catch (Exception e2) {
                            SLog.e("openSDK_LOG.ReportManager", "--> reporVia, exception in sub thread.", e2);
                        }
                    }
                });
            }
        }
    }

    public void a(String str, long j2, long j3, long j4, int i2) {
        a(str, j2, j3, j4, i2, "", false);
    }

    public void a(String str, long j2, long j3, long j4, int i2, String str2, boolean z) {
        int i3 = i2;
        String str3 = str;
        SLog.v("openSDK_LOG.ReportManager", "-->reportCgi, command: " + str + " | startTime: " + j2 + " | reqSize:" + j3 + " | rspSize: " + j4 + " | responseCode: " + i3 + " | detail: " + str2);
        if (a("report_cgi", "" + i3) || z) {
            final long j5 = j2;
            final String str4 = str;
            final String str5 = str2;
            final int i4 = i2;
            final long j6 = j3;
            final long j7 = j4;
            final boolean z2 = z;
            this.f5896h.execute(new Runnable() {
                public void run() {
                    try {
                        long elapsedRealtime = SystemClock.elapsedRealtime() - j5;
                        Bundle bundle = new Bundle();
                        String a2 = a.a(f.a());
                        bundle.putString("apn", a2);
                        bundle.putString("appid", "1000067");
                        bundle.putString("commandid", str4);
                        bundle.putString("detail", str5);
                        StringBuilder sb = new StringBuilder();
                        sb.append("network=").append(a2).append('&');
                        int i2 = 1;
                        sb.append("sdcard=").append(Environment.getExternalStorageState().equals("mounted") ? 1 : 0).append('&');
                        sb.append("wifi=").append(a.e(f.a()));
                        bundle.putString("deviceInfo", sb.toString());
                        int a3 = 100 / g.this.a(i4);
                        if (a3 > 0) {
                            if (a3 > 100) {
                                i2 = 100;
                            } else {
                                i2 = a3;
                            }
                        }
                        bundle.putString("frequency", i2 + "");
                        bundle.putString("reqSize", j6 + "");
                        bundle.putString("resultCode", i4 + "");
                        bundle.putString("rspSize", j7 + "");
                        bundle.putString("timeCost", elapsedRealtime + "");
                        bundle.putString("uin", "1000");
                        g.this.f5891c.add(new b(bundle));
                        int size = g.this.f5891c.size();
                        int a4 = com.tencent.open.utils.g.a(f.a(), (String) null).a("Agent_ReportTimeInterval");
                        if (a4 == 0) {
                            a4 = 10000;
                        }
                        if (!g.this.a("report_cgi", size)) {
                            if (!z2) {
                                if (!g.this.f5894f.hasMessages(1000)) {
                                    Message obtain = Message.obtain();
                                    obtain.what = 1000;
                                    g.this.f5894f.sendMessageDelayed(obtain, (long) a4);
                                    return;
                                }
                                return;
                            }
                        }
                        g.this.b();
                        g.this.f5894f.removeMessages(1000);
                    } catch (Exception e2) {
                        SLog.e("openSDK_LOG.ReportManager", "--> reportCGI, exception in sub thread.", e2);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void b() {
        this.f5896h.execute(new Runnable() {
            /*  JADX ERROR: IF instruction can be used only in fallback mode
                jadx.core.utils.exceptions.CodegenException: IF instruction can be used only in fallback mode
                	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:579)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:485)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:205)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:311)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:68)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                */
            public void run() {
                /*
                    r14 = this;
                    java.lang.String r0 = "report_cgi"
                    java.lang.String r1 = "https://wspeed.qq.com/w.cgi"
                    java.lang.String r2 = "-->doReportCgi, doupload exception"
                    java.lang.String r3 = "openSDK_LOG.ReportManager"
                    com.tencent.open.a.g r4 = com.tencent.open.a.g.this     // Catch:{ Exception -> 0x00c2 }
                    android.os.Bundle r4 = r4.c()     // Catch:{ Exception -> 0x00c2 }
                    if (r4 != 0) goto L_0x0013
                    return
                L_0x0013:
                    android.content.Context r5 = com.tencent.open.utils.f.a()     // Catch:{ Exception -> 0x00c2 }
                    r6 = 0
                    com.tencent.open.utils.g r5 = com.tencent.open.utils.g.a((android.content.Context) r5, (java.lang.String) r6)     // Catch:{ Exception -> 0x00c2 }
                    java.lang.String r7 = "Common_HttpRetryCount"
                    int r5 = r5.a((java.lang.String) r7)     // Catch:{ Exception -> 0x00c2 }
                    if (r5 != 0) goto L_0x0026
                    r5 = 3
                L_0x0026:
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c2 }
                    r7.<init>()     // Catch:{ Exception -> 0x00c2 }
                    java.lang.String r8 = "-->doReportCgi, retryCount: "
                    java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ Exception -> 0x00c2 }
                    java.lang.StringBuilder r7 = r7.append(r5)     // Catch:{ Exception -> 0x00c2 }
                    java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x00c2 }
                    com.tencent.open.log.SLog.d(r3, r7)     // Catch:{ Exception -> 0x00c2 }
                    r7 = 0
                    r8 = r7
                L_0x003e:
                    r9 = 1
                    int r8 = r8 + r9
                    android.content.Context r10 = com.tencent.open.utils.f.a()     // Catch:{ ConnectTimeoutException -> 0x00a6, SocketTimeoutException -> 0x00a1, Exception -> 0x009c }
                    org.apache.http.client.HttpClient r10 = com.tencent.open.utils.HttpUtils.getHttpClient(r10, r6, r1)     // Catch:{ ConnectTimeoutException -> 0x00a6, SocketTimeoutException -> 0x00a1, Exception -> 0x009c }
                    org.apache.http.client.methods.HttpPost r11 = new org.apache.http.client.methods.HttpPost     // Catch:{ ConnectTimeoutException -> 0x00a6, SocketTimeoutException -> 0x00a1, Exception -> 0x009c }
                    r11.<init>(r1)     // Catch:{ ConnectTimeoutException -> 0x00a6, SocketTimeoutException -> 0x00a1, Exception -> 0x009c }
                    java.lang.String r12 = "Accept-Encoding"
                    java.lang.String r13 = "gzip"
                    r11.addHeader(r12, r13)     // Catch:{ ConnectTimeoutException -> 0x00a6, SocketTimeoutException -> 0x00a1, Exception -> 0x009c }
                    java.lang.String r12 = "Content-Type"
                    java.lang.String r13 = "application/x-www-form-urlencoded"
                    r11.setHeader(r12, r13)     // Catch:{ ConnectTimeoutException -> 0x00a6, SocketTimeoutException -> 0x00a1, Exception -> 0x009c }
                    java.lang.String r12 = com.tencent.open.utils.HttpUtils.encodeUrl(r4)     // Catch:{ ConnectTimeoutException -> 0x00a6, SocketTimeoutException -> 0x00a1, Exception -> 0x009c }
                    byte[] r12 = com.tencent.open.utils.l.i(r12)     // Catch:{ ConnectTimeoutException -> 0x00a6, SocketTimeoutException -> 0x00a1, Exception -> 0x009c }
                    org.apache.http.entity.ByteArrayEntity r13 = new org.apache.http.entity.ByteArrayEntity     // Catch:{ ConnectTimeoutException -> 0x00a6, SocketTimeoutException -> 0x00a1, Exception -> 0x009c }
                    r13.<init>(r12)     // Catch:{ ConnectTimeoutException -> 0x00a6, SocketTimeoutException -> 0x00a1, Exception -> 0x009c }
                    r11.setEntity(r13)     // Catch:{ ConnectTimeoutException -> 0x00a6, SocketTimeoutException -> 0x00a1, Exception -> 0x009c }
                    org.apache.http.HttpResponse r10 = r10.execute(r11)     // Catch:{ ConnectTimeoutException -> 0x00a6, SocketTimeoutException -> 0x00a1, Exception -> 0x009c }
                    org.apache.http.StatusLine r10 = r10.getStatusLine()     // Catch:{ ConnectTimeoutException -> 0x00a6, SocketTimeoutException -> 0x00a1, Exception -> 0x009c }
                    int r10 = r10.getStatusCode()     // Catch:{ ConnectTimeoutException -> 0x00a6, SocketTimeoutException -> 0x00a1, Exception -> 0x009c }
                    java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ ConnectTimeoutException -> 0x00a6, SocketTimeoutException -> 0x00a1, Exception -> 0x009c }
                    r11.<init>()     // Catch:{ ConnectTimeoutException -> 0x00a6, SocketTimeoutException -> 0x00a1, Exception -> 0x009c }
                    java.lang.String r12 = "-->doReportCgi, statusCode: "
                    java.lang.StringBuilder r11 = r11.append(r12)     // Catch:{ ConnectTimeoutException -> 0x00a6, SocketTimeoutException -> 0x00a1, Exception -> 0x009c }
                    java.lang.StringBuilder r11 = r11.append(r10)     // Catch:{ ConnectTimeoutException -> 0x00a6, SocketTimeoutException -> 0x00a1, Exception -> 0x009c }
                    java.lang.String r11 = r11.toString()     // Catch:{ ConnectTimeoutException -> 0x00a6, SocketTimeoutException -> 0x00a1, Exception -> 0x009c }
                    com.tencent.open.log.SLog.d(r3, r11)     // Catch:{ ConnectTimeoutException -> 0x00a6, SocketTimeoutException -> 0x00a1, Exception -> 0x009c }
                    r11 = 200(0xc8, float:2.8E-43)
                    if (r10 != r11) goto L_0x009b
                    com.tencent.open.a.f r10 = com.tencent.open.a.f.a()     // Catch:{ ConnectTimeoutException -> 0x00a6, SocketTimeoutException -> 0x00a1, Exception -> 0x009c }
                    r10.b(r0)     // Catch:{ ConnectTimeoutException -> 0x00a6, SocketTimeoutException -> 0x00a1, Exception -> 0x009c }
                    r7 = r9
                L_0x009b:
                    goto L_0x00ad
                L_0x009c:
                    r1 = move-exception
                    com.tencent.open.log.SLog.e(r3, r2, r1)     // Catch:{ Exception -> 0x00c2 }
                    goto L_0x00ad
                L_0x00a1:
                    r9 = move-exception
                    com.tencent.open.log.SLog.e(r3, r2, r9)     // Catch:{ Exception -> 0x00c2 }
                    goto L_0x00aa
                L_0x00a6:
                    r9 = move-exception
                    com.tencent.open.log.SLog.e(r3, r2, r9)     // Catch:{ Exception -> 0x00c2 }
                L_0x00aa:
                    if (r8 < r5) goto L_0x003e
                L_0x00ad:
                    if (r7 != 0) goto L_0x00ba
                    com.tencent.open.a.f r1 = com.tencent.open.a.f.a()     // Catch:{ Exception -> 0x00c2 }
                    com.tencent.open.a.g r2 = com.tencent.open.a.g.this     // Catch:{ Exception -> 0x00c2 }
                    java.util.List<java.io.Serializable> r2 = r2.f5891c     // Catch:{ Exception -> 0x00c2 }
                    r1.a(r0, r2)     // Catch:{ Exception -> 0x00c2 }
                L_0x00ba:
                    com.tencent.open.a.g r0 = com.tencent.open.a.g.this     // Catch:{ Exception -> 0x00c2 }
                    java.util.List<java.io.Serializable> r0 = r0.f5891c     // Catch:{ Exception -> 0x00c2 }
                    r0.clear()     // Catch:{ Exception -> 0x00c2 }
                    goto L_0x00c8
                L_0x00c2:
                    r0 = move-exception
                    java.lang.String r1 = "-->doReportCgi, doupload exception out."
                    com.tencent.open.log.SLog.e(r3, r1, r0)
                L_0x00c8:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.a.g.AnonymousClass4.run():void");
            }
        });
    }

    /* access modifiers changed from: protected */
    public boolean a(String str, String str2) {
        SLog.d("openSDK_LOG.ReportManager", "-->availableFrequency, report: " + str + " | ext: " + str2);
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i2 = 100;
        if (str.equals("report_cgi")) {
            try {
                int a2 = a(Integer.parseInt(str2));
                if (this.f5890b.nextInt(100) < a2) {
                    z = true;
                }
                i2 = a2;
            } catch (Exception e2) {
                return false;
            }
        } else if (str.equals("report_via")) {
            int a3 = e.a(str2);
            if (this.f5890b.nextInt(100) < a3) {
                i2 = a3;
                z = true;
            } else {
                i2 = a3;
            }
        }
        SLog.d("openSDK_LOG.ReportManager", "-->availableFrequency, result: " + z + " | frequency: " + i2);
        return z;
    }

    /* access modifiers changed from: protected */
    public boolean a(String str, int i2) {
        int i3 = 5;
        if (str.equals("report_cgi")) {
            int a2 = com.tencent.open.utils.g.a(f.a(), (String) null).a("Common_CGIReportMaxcount");
            if (a2 != 0) {
                i3 = a2;
            }
        } else if (str.equals("report_via")) {
            int a3 = com.tencent.open.utils.g.a(f.a(), (String) null).a("Agent_ReportBatchCount");
            if (a3 != 0) {
                i3 = a3;
            }
        } else {
            i3 = 0;
        }
        SLog.d("openSDK_LOG.ReportManager", "-->availableCount, report: " + str + " | dataSize: " + i2 + " | maxcount: " + i3);
        if (i2 >= i3) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public int a(int i2) {
        if (i2 == 0) {
            int a2 = com.tencent.open.utils.g.a(f.a(), (String) null).a("Common_CGIReportFrequencySuccess");
            if (a2 == 0) {
                return 10;
            }
            return a2;
        }
        int a3 = com.tencent.open.utils.g.a(f.a(), (String) null).a("Common_CGIReportFrequencyFailed");
        if (a3 == 0) {
            return 100;
        }
        return a3;
    }

    /* access modifiers changed from: protected */
    public Bundle c() {
        if (this.f5891c.size() == 0) {
            return null;
        }
        b bVar = (b) this.f5891c.get(0);
        if (bVar == null) {
            SLog.d("openSDK_LOG.ReportManager", "-->prepareCgiData, the 0th cgireportitem is null.");
            return null;
        }
        String str = bVar.f5883a.get("appid");
        List<Serializable> a2 = f.a().a("report_cgi");
        if (a2 != null) {
            this.f5891c.addAll(a2);
        }
        SLog.d("openSDK_LOG.ReportManager", "-->prepareCgiData, mCgiList size: " + this.f5891c.size());
        if (this.f5891c.size() == 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        try {
            bundle.putString("appid", str);
            bundle.putString("releaseversion", Constants.SDK_VERSION_REPORT);
            bundle.putString("device", Build.DEVICE);
            bundle.putString(BlockInfo.KEY_QUA, Constants.SDK_QUA);
            bundle.putString("key", "apn,frequency,commandid,resultcode,tmcost,reqsize,rspsize,detail,touin,deviceinfo");
            for (int i2 = 0; i2 < this.f5891c.size(); i2++) {
                b bVar2 = (b) this.f5891c.get(i2);
                bundle.putString(i2 + BuildConfig.CHANNEL_EXTRA, bVar2.f5883a.get("apn"));
                bundle.putString(i2 + "_2", bVar2.f5883a.get("frequency"));
                bundle.putString(i2 + "_3", bVar2.f5883a.get("commandid"));
                bundle.putString(i2 + "_4", bVar2.f5883a.get("resultCode"));
                bundle.putString(i2 + "_5", bVar2.f5883a.get("timeCost"));
                bundle.putString(i2 + "_6", bVar2.f5883a.get("reqSize"));
                bundle.putString(i2 + "_7", bVar2.f5883a.get("rspSize"));
                bundle.putString(i2 + "_8", bVar2.f5883a.get("detail"));
                bundle.putString(i2 + "_9", bVar2.f5883a.get("uin"));
                bundle.putString(i2 + "_10", c.e(f.a()) + "&" + bVar2.f5883a.get("deviceInfo"));
            }
            SLog.v("openSDK_LOG.ReportManager", "-->prepareCgiData, end. params: " + bundle.toString());
            return bundle;
        } catch (Exception e2) {
            SLog.e("openSDK_LOG.ReportManager", "-->prepareCgiData, exception.", e2);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public Bundle d() {
        List<Serializable> a2 = f.a().a("report_via");
        if (a2 != null) {
            this.f5892d.addAll(a2);
        }
        SLog.d("openSDK_LOG.ReportManager", "-->prepareViaData, mViaList size: " + this.f5892d.size());
        if (this.f5892d.size() == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<Serializable> it = this.f5892d.iterator();
        while (it.hasNext()) {
            JSONObject jSONObject = new JSONObject();
            b bVar = (b) it.next();
            for (String next : bVar.f5883a.keySet()) {
                try {
                    String str = bVar.f5883a.get(next);
                    if (str == null) {
                        str = "";
                    }
                    jSONObject.put(next, str);
                } catch (JSONException e2) {
                    SLog.e("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e2);
                }
            }
            jSONArray.put(jSONObject);
        }
        SLog.v("openSDK_LOG.ReportManager", "-->prepareViaData, JSONArray array: " + jSONArray.toString());
        Bundle bundle = new Bundle();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("data", jSONArray);
            bundle.putString("data", jSONObject2.toString());
            return bundle;
        } catch (JSONException e3) {
            SLog.e("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e3);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void e() {
        this.f5895g.execute(new Runnable() {
            /* JADX WARNING: Code restructure failed: missing block: B:14:0x005d, code lost:
                r0 = -4;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:18:0x0067, code lost:
                if (android.text.TextUtils.isEmpty(r7.f6041a) == false) goto L_0x0069;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:23:0x0075, code lost:
                r6 = -6;
                r0 = r4;
                r11 = 0;
                r13 = 0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:24:0x007f, code lost:
                r0 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:27:0x0086, code lost:
                r6 = com.tencent.open.utils.HttpUtils.getErrorCodeFromException(r0);
                r0 = r16;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:28:0x008a, code lost:
                r0 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
                r6 = java.lang.Integer.parseInt(r0.getMessage().replace(com.tencent.open.utils.HttpUtils.HttpStatusException.ERROR_INFO, ""));
             */
            /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
                r1.f5910a.f5892d.clear();
                com.tencent.open.log.SLog.d("openSDK_LOG.ReportManager", "doReportVia, NetworkUnavailableException.");
             */
            /* JADX WARNING: Code restructure failed: missing block: B:36:0x00af, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:41:0x00be, code lost:
                r6 = android.os.SystemClock.elapsedRealtime();
                r0 = -8;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:43:0x00c7, code lost:
                r6 = android.os.SystemClock.elapsedRealtime();
                r0 = -7;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ce, code lost:
                r9 = r6;
                r11 = 0;
                r13 = 0;
                r6 = r0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:59:0x00d6, code lost:
                continue;
             */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Removed duplicated region for block: B:22:0x0074 A[ExcHandler: Exception (e java.lang.Exception), Splitter:B:8:0x0041] */
            /* JADX WARNING: Removed duplicated region for block: B:24:0x007f A[ExcHandler: IOException (r0v33 'e' java.io.IOException A[CUSTOM_DECLARE]), Splitter:B:8:0x0041] */
            /* JADX WARNING: Removed duplicated region for block: B:28:0x008a A[ExcHandler: HttpStatusException (r0v29 'e' com.tencent.open.utils.HttpUtils$HttpStatusException A[CUSTOM_DECLARE]), Splitter:B:8:0x0041] */
            /* JADX WARNING: Removed duplicated region for block: B:33:0x00a2 A[ExcHandler: NetworkUnavailableException (e com.tencent.open.utils.HttpUtils$NetworkUnavailableException), Splitter:B:8:0x0041] */
            /* JADX WARNING: Removed duplicated region for block: B:40:0x00bd A[Catch:{ Exception -> 0x011d }, ExcHandler: SocketTimeoutException (e java.net.SocketTimeoutException), Splitter:B:8:0x0041] */
            /* JADX WARNING: Removed duplicated region for block: B:42:0x00c6 A[Catch:{ Exception -> 0x011d }, ExcHandler: ConnectTimeoutException (e org.apache.http.conn.ConnectTimeoutException), Splitter:B:8:0x0041] */
            /* JADX WARNING: Removed duplicated region for block: B:51:0x00ec A[SYNTHETIC, Splitter:B:51:0x00ec] */
            /* JADX WARNING: Removed duplicated region for block: B:53:0x00f4 A[Catch:{ Exception -> 0x011d }] */
            /* JADX WARNING: Removed duplicated region for block: B:57:0x00d8 A[SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r18 = this;
                    r1 = r18
                    java.lang.String r2 = "openSDK_LOG.ReportManager"
                    com.tencent.open.a.g r0 = com.tencent.open.a.g.this     // Catch:{ Exception -> 0x011d }
                    android.os.Bundle r3 = r0.d()     // Catch:{ Exception -> 0x011d }
                    if (r3 != 0) goto L_0x000e
                    return
                L_0x000e:
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x011d }
                    r0.<init>()     // Catch:{ Exception -> 0x011d }
                    java.lang.String r4 = "-->doReportVia, params: "
                    java.lang.StringBuilder r0 = r0.append(r4)     // Catch:{ Exception -> 0x011d }
                    java.lang.String r4 = r3.toString()     // Catch:{ Exception -> 0x011d }
                    java.lang.StringBuilder r0 = r0.append(r4)     // Catch:{ Exception -> 0x011d }
                    java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x011d }
                    com.tencent.open.log.SLog.v(r2, r0)     // Catch:{ Exception -> 0x011d }
                    int r4 = com.tencent.open.a.e.a()     // Catch:{ Exception -> 0x011d }
                    long r5 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x011d }
                    r0 = 0
                    r9 = r5
                    r11 = 0
                    r13 = 0
                    r5 = r0
                    r6 = r5
                L_0x003c:
                    r15 = 1
                    int r16 = r0 + 1
                    r17 = -4
                    android.content.Context r0 = com.tencent.open.utils.f.a()     // Catch:{ ConnectTimeoutException -> 0x00c6, SocketTimeoutException -> 0x00bd, JSONException -> 0x00b0, NetworkUnavailableException -> 0x00a2, HttpStatusException -> 0x008a, IOException -> 0x007f, Exception -> 0x0074 }
                    java.lang.String r7 = "https://appsupport.qq.com/cgi-bin/appstage/mstats_batch_report"
                    java.lang.String r8 = "POST"
                    com.tencent.open.utils.l$a r7 = com.tencent.open.utils.HttpUtils.openUrl2(r0, r7, r8, r3)     // Catch:{ ConnectTimeoutException -> 0x00c6, SocketTimeoutException -> 0x00bd, JSONException -> 0x00b0, NetworkUnavailableException -> 0x00a2, HttpStatusException -> 0x008a, IOException -> 0x007f, Exception -> 0x0074 }
                    java.lang.String r0 = r7.f6041a     // Catch:{ ConnectTimeoutException -> 0x00c6, SocketTimeoutException -> 0x00bd, JSONException -> 0x00b0, NetworkUnavailableException -> 0x00a2, HttpStatusException -> 0x008a, IOException -> 0x007f, Exception -> 0x0074 }
                    org.json.JSONObject r0 = com.tencent.open.utils.l.d((java.lang.String) r0)     // Catch:{ ConnectTimeoutException -> 0x00c6, SocketTimeoutException -> 0x00bd, JSONException -> 0x00b0, NetworkUnavailableException -> 0x00a2, HttpStatusException -> 0x008a, IOException -> 0x007f, Exception -> 0x0074 }
                    java.lang.String r8 = "ret"
                    int r0 = r0.getInt(r8)     // Catch:{ JSONException -> 0x005c, ConnectTimeoutException -> 0x00c6, SocketTimeoutException -> 0x00bd, NetworkUnavailableException -> 0x00a2, HttpStatusException -> 0x008a, IOException -> 0x007f, Exception -> 0x0074 }
                    goto L_0x005f
                L_0x005c:
                    r0 = move-exception
                    r0 = r17
                L_0x005f:
                    if (r0 == 0) goto L_0x0069
                    java.lang.String r0 = r7.f6041a     // Catch:{ ConnectTimeoutException -> 0x00c6, SocketTimeoutException -> 0x00bd, JSONException -> 0x00b0, NetworkUnavailableException -> 0x00a2, HttpStatusException -> 0x008a, IOException -> 0x007f, Exception -> 0x0074 }
                    boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ ConnectTimeoutException -> 0x00c6, SocketTimeoutException -> 0x00bd, JSONException -> 0x00b0, NetworkUnavailableException -> 0x00a2, HttpStatusException -> 0x008a, IOException -> 0x007f, Exception -> 0x0074 }
                    if (r0 != 0) goto L_0x006d
                L_0x0069:
                    r16 = r4
                    r5 = r15
                L_0x006d:
                    long r11 = r7.f6042b     // Catch:{ ConnectTimeoutException -> 0x00c6, SocketTimeoutException -> 0x00bd, JSONException -> 0x00b0, NetworkUnavailableException -> 0x00a2, HttpStatusException -> 0x008a, IOException -> 0x007f, Exception -> 0x0074 }
                    long r7 = r7.f6043c     // Catch:{ ConnectTimeoutException -> 0x00c6, SocketTimeoutException -> 0x00bd, JSONException -> 0x00b0, NetworkUnavailableException -> 0x00a2, HttpStatusException -> 0x008a, IOException -> 0x007f, Exception -> 0x0074 }
                    r13 = r7
                    goto L_0x00d4
                L_0x0074:
                    r0 = move-exception
                    r0 = -6
                    r6 = r0
                    r0 = r4
                    r11 = 0
                    r13 = 0
                    goto L_0x00d6
                L_0x007f:
                    r0 = move-exception
                    int r0 = com.tencent.open.utils.HttpUtils.getErrorCodeFromException(r0)     // Catch:{ Exception -> 0x011d }
                    r6 = r0
                    r0 = r16
                    goto L_0x00b8
                L_0x008a:
                    r0 = move-exception
                    java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x009c }
                    java.lang.String r3 = "http status code error:"
                    java.lang.String r4 = ""
                    java.lang.String r0 = r0.replace(r3, r4)     // Catch:{ Exception -> 0x009c }
                    int r6 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x009c }
                    goto L_0x009d
                L_0x009c:
                    r0 = move-exception
                L_0x009d:
                    r8 = r9
                    r10 = r11
                    r12 = r13
                    r14 = r6
                    goto L_0x00dc
                L_0x00a2:
                    r0 = move-exception
                    com.tencent.open.a.g r0 = com.tencent.open.a.g.this     // Catch:{ Exception -> 0x011d }
                    java.util.List<java.io.Serializable> r0 = r0.f5892d     // Catch:{ Exception -> 0x011d }
                    r0.clear()     // Catch:{ Exception -> 0x011d }
                    java.lang.String r0 = "doReportVia, NetworkUnavailableException."
                    com.tencent.open.log.SLog.d(r2, r0)     // Catch:{ Exception -> 0x011d }
                    return
                L_0x00b0:
                    r0 = move-exception
                    r0 = r16
                    r6 = r17
                L_0x00b8:
                    r11 = 0
                    r13 = 0
                    goto L_0x00d6
                L_0x00bd:
                    r0 = move-exception
                    long r6 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x011d }
                    r0 = -8
                    goto L_0x00ce
                L_0x00c6:
                    r0 = move-exception
                    long r6 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x011d }
                    r0 = -7
                L_0x00ce:
                    r9 = r6
                    r11 = 0
                    r13 = 0
                    r6 = r0
                L_0x00d4:
                    r0 = r16
                L_0x00d6:
                    if (r0 < r4) goto L_0x003c
                    r8 = r9
                    r10 = r11
                    r12 = r13
                    r14 = r6
                L_0x00dc:
                    com.tencent.open.a.g r6 = com.tencent.open.a.g.this     // Catch:{ Exception -> 0x011d }
                    java.lang.String r7 = "mapp_apptrace_sdk"
                    r15 = 0
                    r16 = 0
                    r6.a(r7, r8, r10, r12, r14, r15, r16)     // Catch:{ Exception -> 0x011d }
                    java.lang.String r0 = "report_via"
                    if (r5 == 0) goto L_0x00f4
                    com.tencent.open.a.f r3 = com.tencent.open.a.f.a()     // Catch:{ Exception -> 0x011d }
                    r3.b(r0)     // Catch:{ Exception -> 0x011d }
                    goto L_0x00ff
                L_0x00f4:
                    com.tencent.open.a.f r3 = com.tencent.open.a.f.a()     // Catch:{ Exception -> 0x011d }
                    com.tencent.open.a.g r4 = com.tencent.open.a.g.this     // Catch:{ Exception -> 0x011d }
                    java.util.List<java.io.Serializable> r4 = r4.f5892d     // Catch:{ Exception -> 0x011d }
                    r3.a(r0, r4)     // Catch:{ Exception -> 0x011d }
                L_0x00ff:
                    com.tencent.open.a.g r0 = com.tencent.open.a.g.this     // Catch:{ Exception -> 0x011d }
                    java.util.List<java.io.Serializable> r0 = r0.f5892d     // Catch:{ Exception -> 0x011d }
                    r0.clear()     // Catch:{ Exception -> 0x011d }
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x011d }
                    r0.<init>()     // Catch:{ Exception -> 0x011d }
                    java.lang.String r1 = "-->doReportVia, uploadSuccess: "
                    java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Exception -> 0x011d }
                    java.lang.StringBuilder r0 = r0.append(r5)     // Catch:{ Exception -> 0x011d }
                    java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x011d }
                    com.tencent.open.log.SLog.d(r2, r0)     // Catch:{ Exception -> 0x011d }
                    goto L_0x0123
                L_0x011d:
                    r0 = move-exception
                    java.lang.String r1 = "-->doReportVia, exception in serial executor."
                    com.tencent.open.log.SLog.e(r2, r1, r0)
                L_0x0123:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.a.g.AnonymousClass5.run():void");
            }
        });
    }

    public void a(String str, String str2, Bundle bundle, boolean z) {
        final Bundle bundle2 = bundle;
        final String str3 = str;
        final boolean z2 = z;
        final String str4 = str2;
        j.a(new Runnable() {
            /* JADX WARNING: Code restructure failed: missing block: B:31:0x00d3, code lost:
                if (r9 == null) goto L_0x0140;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
                r2 = r9.getEntity();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:34:0x00d9, code lost:
                if (r2 == null) goto L_0x0140;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:35:0x00db, code lost:
                r2.consumeContent();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:36:0x00e0, code lost:
                r2 = e;
             */
            /* JADX WARNING: Removed duplicated region for block: B:107:0x0140 A[EDGE_INSN: B:107:0x0140->B:87:0x0140 ?: BREAK  , SYNTHETIC] */
            /* JADX WARNING: Removed duplicated region for block: B:108:0x013e A[SYNTHETIC] */
            /* JADX WARNING: Removed duplicated region for block: B:109:0x013e A[SYNTHETIC] */
            /* JADX WARNING: Removed duplicated region for block: B:57:0x0104 A[SYNTHETIC, Splitter:B:57:0x0104] */
            /* JADX WARNING: Removed duplicated region for block: B:68:0x0119 A[SYNTHETIC, Splitter:B:68:0x0119] */
            /* JADX WARNING: Removed duplicated region for block: B:81:0x0132 A[SYNTHETIC, Splitter:B:81:0x0132] */
            /* JADX WARNING: Removed duplicated region for block: B:88:0x0142  */
            /* JADX WARNING: Removed duplicated region for block: B:91:0x0148 A[Catch:{ Exception -> 0x0165 }] */
            /* JADX WARNING: Removed duplicated region for block: B:93:0x0150 A[SYNTHETIC, Splitter:B:93:0x0150] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r13 = this;
                    java.lang.String r0 = "-->ReportCenter httpRequest consumeContent Exception:"
                    java.lang.String r1 = "openSDK_LOG.ReportManager"
                    android.os.Bundle r2 = r2     // Catch:{ Exception -> 0x0165 }
                    if (r2 != 0) goto L_0x000f
                    java.lang.String r0 = "-->httpRequest, params is null!"
                    com.tencent.open.log.SLog.e(r1, r0)     // Catch:{ Exception -> 0x0165 }
                    return
                L_0x000f:
                    int r2 = com.tencent.open.a.e.a()     // Catch:{ Exception -> 0x0165 }
                    if (r2 != 0) goto L_0x0017
                    r2 = 3
                L_0x0017:
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0165 }
                    r3.<init>()     // Catch:{ Exception -> 0x0165 }
                    java.lang.String r4 = "-->httpRequest, retryCount: "
                    java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ Exception -> 0x0165 }
                    java.lang.StringBuilder r3 = r3.append(r2)     // Catch:{ Exception -> 0x0165 }
                    java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0165 }
                    com.tencent.open.log.SLog.d(r1, r3)     // Catch:{ Exception -> 0x0165 }
                    android.content.Context r3 = com.tencent.open.utils.f.a()     // Catch:{ Exception -> 0x0165 }
                    java.lang.String r4 = r3     // Catch:{ Exception -> 0x0165 }
                    r5 = 0
                    org.apache.http.client.HttpClient r3 = com.tencent.open.utils.HttpUtils.getHttpClient(r3, r5, r4)     // Catch:{ Exception -> 0x0165 }
                    android.os.Bundle r4 = r2     // Catch:{ Exception -> 0x0165 }
                    java.lang.String r4 = com.tencent.open.utils.HttpUtils.encodeUrl(r4)     // Catch:{ Exception -> 0x0165 }
                    boolean r6 = r4     // Catch:{ Exception -> 0x0165 }
                    if (r6 == 0) goto L_0x0048
                    java.lang.String r4 = java.net.URLEncoder.encode(r4)     // Catch:{ Exception -> 0x0165 }
                L_0x0048:
                    java.lang.String r6 = r5     // Catch:{ Exception -> 0x0165 }
                    java.lang.String r6 = r6.toUpperCase()     // Catch:{ Exception -> 0x0165 }
                    java.lang.String r7 = "GET"
                    boolean r6 = r6.equals(r7)     // Catch:{ Exception -> 0x0165 }
                    if (r6 == 0) goto L_0x006a
                    java.lang.StringBuffer r6 = new java.lang.StringBuffer     // Catch:{ Exception -> 0x0165 }
                    java.lang.String r7 = r3     // Catch:{ Exception -> 0x0165 }
                    r6.<init>(r7)     // Catch:{ Exception -> 0x0165 }
                    r6.append(r4)     // Catch:{ Exception -> 0x0165 }
                    org.apache.http.client.methods.HttpGet r4 = new org.apache.http.client.methods.HttpGet     // Catch:{ Exception -> 0x0165 }
                    java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0165 }
                    r4.<init>(r6)     // Catch:{ Exception -> 0x0165 }
                    goto L_0x008d
                L_0x006a:
                    java.lang.String r6 = r5     // Catch:{ Exception -> 0x0165 }
                    java.lang.String r6 = r6.toUpperCase()     // Catch:{ Exception -> 0x0165 }
                    java.lang.String r7 = "POST"
                    boolean r6 = r6.equals(r7)     // Catch:{ Exception -> 0x0165 }
                    if (r6 == 0) goto L_0x015f
                    org.apache.http.client.methods.HttpPost r6 = new org.apache.http.client.methods.HttpPost     // Catch:{ Exception -> 0x0165 }
                    java.lang.String r7 = r3     // Catch:{ Exception -> 0x0165 }
                    r6.<init>(r7)     // Catch:{ Exception -> 0x0165 }
                    byte[] r4 = com.tencent.open.utils.l.i(r4)     // Catch:{ Exception -> 0x0165 }
                    org.apache.http.entity.ByteArrayEntity r7 = new org.apache.http.entity.ByteArrayEntity     // Catch:{ Exception -> 0x0165 }
                    r7.<init>(r4)     // Catch:{ Exception -> 0x0165 }
                    r6.setEntity(r7)     // Catch:{ Exception -> 0x0165 }
                    r4 = r6
                L_0x008d:
                    java.lang.String r6 = "Accept-Encoding"
                    java.lang.String r7 = "gzip"
                    r4.addHeader(r6, r7)     // Catch:{ Exception -> 0x0165 }
                    java.lang.String r6 = "Content-Type"
                    java.lang.String r7 = "application/x-www-form-urlencoded"
                    r4.addHeader(r6, r7)     // Catch:{ Exception -> 0x0165 }
                    r6 = 0
                    r7 = r6
                L_0x009d:
                    r8 = 1
                    int r6 = r6 + r8
                    org.apache.http.HttpResponse r9 = r3.execute(r4)     // Catch:{ ConnectTimeoutException -> 0x0129, SocketTimeoutException -> 0x0110, Exception -> 0x00fc }
                    org.apache.http.StatusLine r10 = r9.getStatusLine()     // Catch:{ ConnectTimeoutException -> 0x00f8, SocketTimeoutException -> 0x00f6, Exception -> 0x00f3 }
                    int r10 = r10.getStatusCode()     // Catch:{ ConnectTimeoutException -> 0x00f8, SocketTimeoutException -> 0x00f6, Exception -> 0x00f3 }
                    java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ ConnectTimeoutException -> 0x00f8, SocketTimeoutException -> 0x00f6, Exception -> 0x00f3 }
                    r11.<init>()     // Catch:{ ConnectTimeoutException -> 0x00f8, SocketTimeoutException -> 0x00f6, Exception -> 0x00f3 }
                    java.lang.String r12 = "-->httpRequest, statusCode: "
                    java.lang.StringBuilder r11 = r11.append(r12)     // Catch:{ ConnectTimeoutException -> 0x00f8, SocketTimeoutException -> 0x00f6, Exception -> 0x00f3 }
                    java.lang.StringBuilder r11 = r11.append(r10)     // Catch:{ ConnectTimeoutException -> 0x00f8, SocketTimeoutException -> 0x00f6, Exception -> 0x00f3 }
                    java.lang.String r11 = r11.toString()     // Catch:{ ConnectTimeoutException -> 0x00f8, SocketTimeoutException -> 0x00f6, Exception -> 0x00f3 }
                    com.tencent.open.log.SLog.d(r1, r11)     // Catch:{ ConnectTimeoutException -> 0x00f8, SocketTimeoutException -> 0x00f6, Exception -> 0x00f3 }
                    r11 = 200(0xc8, float:2.8E-43)
                    if (r10 == r11) goto L_0x00cc
                    java.lang.String r10 = "-->ReportCenter httpRequest : HttpStatuscode != 200"
                    com.tencent.open.log.SLog.d(r1, r10)     // Catch:{ ConnectTimeoutException -> 0x00f8, SocketTimeoutException -> 0x00f6, Exception -> 0x00f3 }
                    goto L_0x00d3
                L_0x00cc:
                    java.lang.String r7 = "-->ReportCenter httpRequest Thread success"
                    com.tencent.open.log.SLog.d(r1, r7)     // Catch:{ ConnectTimeoutException -> 0x00ec, SocketTimeoutException -> 0x00e9, Exception -> 0x00e6 }
                    r7 = r8
                L_0x00d3:
                    if (r9 == 0) goto L_0x0140
                    org.apache.http.HttpEntity r2 = r9.getEntity()     // Catch:{ Exception -> 0x00e0 }
                    if (r2 == 0) goto L_0x00de
                    r2.consumeContent()     // Catch:{ Exception -> 0x00e0 }
                L_0x00de:
                    goto L_0x0140
                L_0x00e0:
                    r2 = move-exception
                L_0x00e2:
                    com.tencent.open.log.SLog.e(r1, r0, r2)     // Catch:{ Exception -> 0x0165 }
                    goto L_0x00de
                L_0x00e6:
                    r2 = move-exception
                    r7 = r8
                    goto L_0x00f4
                L_0x00e9:
                    r10 = move-exception
                    r7 = r8
                    goto L_0x0112
                L_0x00ec:
                    r10 = move-exception
                    r7 = r8
                    goto L_0x012b
                L_0x00ef:
                    r2 = move-exception
                    r5 = r9
                    goto L_0x014e
                L_0x00f3:
                    r2 = move-exception
                L_0x00f4:
                    r5 = r9
                    goto L_0x00fd
                L_0x00f6:
                    r10 = move-exception
                    goto L_0x0112
                L_0x00f8:
                    r10 = move-exception
                    goto L_0x012b
                L_0x00fa:
                    r2 = move-exception
                    goto L_0x014e
                L_0x00fc:
                    r2 = move-exception
                L_0x00fd:
                    java.lang.String r3 = "-->ReportCenter httpRequest Exception:"
                    com.tencent.open.log.SLog.e(r1, r3, r2)     // Catch:{ all -> 0x00fa }
                    if (r5 == 0) goto L_0x0140
                    org.apache.http.HttpEntity r2 = r5.getEntity()     // Catch:{ Exception -> 0x010e }
                    if (r2 == 0) goto L_0x00de
                    r2.consumeContent()     // Catch:{ Exception -> 0x010e }
                    goto L_0x00de
                L_0x010e:
                    r2 = move-exception
                    goto L_0x00e2
                L_0x0110:
                    r10 = move-exception
                    r9 = r5
                L_0x0112:
                    java.lang.String r11 = "-->ReportCenter httpRequest SocketTimeoutException:"
                    com.tencent.open.log.SLog.e(r1, r11, r10)     // Catch:{ all -> 0x00ef }
                    if (r9 == 0) goto L_0x013e
                    org.apache.http.HttpEntity r9 = r9.getEntity()     // Catch:{ Exception -> 0x0123 }
                    if (r9 == 0) goto L_0x0122
                    r9.consumeContent()     // Catch:{ Exception -> 0x0123 }
                L_0x0122:
                    goto L_0x013e
                L_0x0123:
                    r9 = move-exception
                L_0x0125:
                    com.tencent.open.log.SLog.e(r1, r0, r9)     // Catch:{ Exception -> 0x0165 }
                    goto L_0x0122
                L_0x0129:
                    r10 = move-exception
                    r9 = r5
                L_0x012b:
                    java.lang.String r11 = "-->ReportCenter httpRequest ConnectTimeoutException:"
                    com.tencent.open.log.SLog.e(r1, r11, r10)     // Catch:{ all -> 0x00ef }
                    if (r9 == 0) goto L_0x013e
                    org.apache.http.HttpEntity r9 = r9.getEntity()     // Catch:{ Exception -> 0x013c }
                    if (r9 == 0) goto L_0x0122
                    r9.consumeContent()     // Catch:{ Exception -> 0x013c }
                    goto L_0x0122
                L_0x013c:
                    r9 = move-exception
                    goto L_0x0125
                L_0x013e:
                    if (r6 < r2) goto L_0x009d
                L_0x0140:
                    if (r7 != r8) goto L_0x0148
                    java.lang.String r0 = "-->ReportCenter httpRequest Thread request success"
                    com.tencent.open.log.SLog.d(r1, r0)     // Catch:{ Exception -> 0x0165 }
                    goto L_0x014d
                L_0x0148:
                    java.lang.String r0 = "-->ReportCenter httpRequest Thread request failed"
                    com.tencent.open.log.SLog.d(r1, r0)     // Catch:{ Exception -> 0x0165 }
                L_0x014d:
                    goto L_0x016b
                L_0x014e:
                    if (r5 == 0) goto L_0x015e
                    org.apache.http.HttpEntity r3 = r5.getEntity()     // Catch:{ Exception -> 0x015a }
                    if (r3 == 0) goto L_0x0159
                    r3.consumeContent()     // Catch:{ Exception -> 0x015a }
                L_0x0159:
                    goto L_0x015e
                L_0x015a:
                    r3 = move-exception
                    com.tencent.open.log.SLog.e(r1, r0, r3)     // Catch:{ Exception -> 0x0165 }
                L_0x015e:
                    throw r2     // Catch:{ Exception -> 0x0165 }
                L_0x015f:
                    java.lang.String r0 = "-->httpRequest unkonw request method return."
                    com.tencent.open.log.SLog.e(r1, r0)     // Catch:{ Exception -> 0x0165 }
                    return
                L_0x0165:
                    r0 = move-exception
                    java.lang.String r2 = "-->httpRequest, exception in serial executor:"
                    com.tencent.open.log.SLog.e(r1, r2, r0)
                L_0x016b:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.a.g.AnonymousClass6.run():void");
            }
        });
    }
}
