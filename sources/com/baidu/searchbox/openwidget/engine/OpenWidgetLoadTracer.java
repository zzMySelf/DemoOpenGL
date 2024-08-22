package com.baidu.searchbox.openwidget.engine;

import com.baidu.mobstat.Config;
import com.baidu.searchbox.openwidget.engine.web.WebViewLoadError;
import com.baidu.searchbox.openwidget.utils.Normalizable;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u0000 !2\u00020\u0001:\u0001!B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0012H\u0007J\b\u0010\u0013\u001a\u00020\u0014H\u0007J\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0001H\u0007J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0007H\u0007J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u0007H\u0007J\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020 H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\n0\tX\u0004¢\u0006\u0002\n\u0000R \u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\n0\tX\u0004¢\u0006\u0002\n\u0000R \u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\n0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/baidu/searchbox/openwidget/engine/OpenWidgetLoadTracer;", "", "()V", "currRound", "Ljava/util/concurrent/atomic/AtomicLong;", "customInfo", "Ljava/util/concurrent/ConcurrentHashMap;", "", "jsErrors", "Ljava/util/LinkedList;", "Lkotlin/Pair;", "", "naErrors", "resErrors", "startTimeMillis", "startTimes", "traceNodes", "dump", "", "start", "", "traceCustom", "key", "value", "traceEvent", "tag", "traceJsError", "logText", "traceResError", "throwable", "Lcom/baidu/searchbox/openwidget/engine/web/WebViewLoadError;", "traceThrowable", "", "Companion", "lib-openwidget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OpenWidgetLoadTracer.kt */
public final class OpenWidgetLoadTracer {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EV_ANIM_ERR = "tl_anim_err";
    public static final String EV_ANIM_ERR_DETAIL = "tl_anim_err_detail";
    public static final String EV_ANIM_ERR_TYPE = "tl_anim_err_type";
    public static final String EV_ANIM_EXIT = "tl_anim_exit";
    public static final String EV_ANIM_LOAD_END = "tl_anim_le";
    public static final String EV_ANIM_LOAD_START = "tl_anim_ls";
    public static final String EV_ANIM_START = "tl_anim_start";
    public static final String EV_JOB_CANCEL = "tl_cancel";
    public static final String EV_SET_WIDGET_ANIMATION = "tl_swa";
    public static final String EV_SET_WIDGET_RENDERED = "tl_swr";
    public static final String EV_SET_WIDGET_TOUCH = "tl_swt";
    public static final String EV_START = "tl_start";
    public static final String INFO_BLOCK_IMAGE = "blockimage";
    public static final String INFO_CANCEL_TYPE = "canceltype";
    public static final String INFO_ROUND = "tl_round";
    public static final String LOG_JS_ERROR = "tl_jserror";
    public static final String LOG_NA_ERROR = "tl_naerror";
    public static final String LOG_RES_ERROR = "tl_reserror";
    private final AtomicLong currRound = new AtomicLong(0);
    private final ConcurrentHashMap<String, Object> customInfo = new ConcurrentHashMap<>();
    private final LinkedList<Pair<Long, String>> jsErrors = new LinkedList<>();
    private final LinkedList<Pair<Long, String>> naErrors = new LinkedList<>();
    private final LinkedList<Pair<Long, String>> resErrors = new LinkedList<>();
    private volatile long startTimeMillis = -1;
    private final ConcurrentHashMap<String, Long> startTimes = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Long> traceNodes = new ConcurrentHashMap<>();

    public final void start() {
        long round = this.currRound.incrementAndGet();
        int i2 = (round > 1 ? 1 : (round == 1 ? 0 : -1));
        String str = EV_START;
        if (i2 > 0) {
            str = str + round;
        }
        String key = str;
        long currentTimeMillis = System.currentTimeMillis();
        this.startTimes.put(key, Long.valueOf(currentTimeMillis));
        this.startTimeMillis = currentTimeMillis;
    }

    public final void traceEvent(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        long round = this.currRound.get();
        this.traceNodes.put(round <= 1 ? tag : tag + round, Long.valueOf(System.currentTimeMillis() - this.startTimeMillis));
    }

    public final void traceCustom(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.customInfo.put(key, value);
    }

    public final void traceJsError(String logText) {
        Intrinsics.checkNotNullParameter(logText, "logText");
        Pair entry = new Pair(Long.valueOf(System.currentTimeMillis()), logText);
        synchronized (this.jsErrors) {
            this.jsErrors.add(entry);
        }
    }

    public final void traceThrowable(Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        JSONObject jSONObject = new JSONObject();
        JSONObject $this$traceThrowable_u24lambda_u2d1 = jSONObject;
        $this$traceThrowable_u24lambda_u2d1.put(Config.EXCEPTION_PART, throwable.getClass().getName());
        String message = throwable.getMessage();
        if (message == null) {
            message = "";
        }
        $this$traceThrowable_u24lambda_u2d1.put("msg", message);
        if (throwable instanceof Normalizable) {
            $this$traceThrowable_u24lambda_u2d1.put("detail", ((Normalizable) throwable).normalizeAsJsonObject());
        }
        String logText = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(logText, "JSONObject().apply {\n   …   }\n        }.toString()");
        Pair entry = new Pair(Long.valueOf(System.currentTimeMillis()), logText);
        synchronized (this.naErrors) {
            this.naErrors.add(entry);
        }
    }

    public final void traceResError(WebViewLoadError throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        String logText = throwable.normalizeAsJsonObject().toString();
        Intrinsics.checkNotNullExpressionValue(logText, "throwable.normalizeAsJsonObject().toString()");
        Pair entry = new Pair(Long.valueOf(System.currentTimeMillis()), logText);
        synchronized (this.resErrors) {
            this.resErrors.add(entry);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x00a3, code lost:
        r3 = r8;
        r2.put(LOG_JS_ERROR, r3);
        r4 = r1.naErrors;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x00ac, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00ad, code lost:
        r5 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r6 = r1.naErrors;
        r7 = false;
        r8 = new org.json.JSONArray();
        r11 = r6.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00c4, code lost:
        if (r11.hasNext() == false) goto L_0x0112;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00c6, code lost:
        r15 = (kotlin.Pair) r11.next();
        r17 = new org.json.JSONObject();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00d6, code lost:
        r18 = r17;
        r21 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r23 = r5;
        r24 = r6;
        r22 = r7;
        r7 = r18;
        r7.put("t", ((java.lang.Number) r15.getFirst()).longValue());
        r7.put("v", r15.getSecond());
        r8.put(r17);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0106, code lost:
        r3 = r21;
        r7 = r22;
        r5 = r23;
        r6 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x010f, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0112, code lost:
        r21 = r3;
        r23 = r5;
        r24 = r6;
        r22 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x011c, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x011d, code lost:
        r3 = r8;
        r2.put(LOG_NA_ERROR, r3);
        r4 = r1.resErrors;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0126, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0127, code lost:
        r5 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        r6 = r1.resErrors;
        r8 = new org.json.JSONArray();
        r11 = r6.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x013e, code lost:
        if (r11.hasNext() == false) goto L_0x0189;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0140, code lost:
        r15 = (kotlin.Pair) r11.next();
        r17 = new org.json.JSONObject();
        r23 = r5;
        r24 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0165, code lost:
        r22 = r3;
        r3 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        r3.put("t", ((java.lang.Number) r15.getFirst()).longValue());
        r3.put("v", r15.getSecond());
        r8.put(r17);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x017e, code lost:
        r1 = r25;
        r3 = r22;
        r5 = r23;
        r6 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0187, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0189, code lost:
        r22 = r3;
        r23 = r5;
        r24 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0191, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0192, code lost:
        r2.put(LOG_RES_ERROR, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x019a, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x019b, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x019c, code lost:
        r22 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x019e, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x019f, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x01a0, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x01a1, code lost:
        r21 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x01a3, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x01a4, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.String, java.lang.Object> dump() {
        /*
            r25 = this;
            r1 = r25
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>()
            java.util.Map r0 = (java.util.Map) r0
            r2 = r0
            r3 = 0
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Long> r4 = r1.startTimes
            java.util.Map r4 = (java.util.Map) r4
            r2.putAll(r4)
            java.lang.String r4 = "tl_round"
            java.util.concurrent.atomic.AtomicLong r5 = r1.currRound
            long r5 = r5.get()
            java.lang.Long r5 = java.lang.Long.valueOf(r5)
            r2.put(r4, r5)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Long> r4 = r1.traceNodes
            java.util.Map r4 = (java.util.Map) r4
            r2.putAll(r4)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Object> r4 = r1.customInfo
            java.util.Map r4 = (java.util.Map) r4
            r2.putAll(r4)
            java.util.LinkedList<kotlin.Pair<java.lang.Long, java.lang.String>> r4 = r1.jsErrors
            monitor-enter(r4)
            r5 = 0
            java.util.LinkedList<kotlin.Pair<java.lang.Long, java.lang.String>> r6 = r1.jsErrors     // Catch:{ all -> 0x01a5 }
            java.util.Collection r6 = (java.util.Collection) r6     // Catch:{ all -> 0x01a5 }
            r7 = 0
            org.json.JSONArray r8 = new org.json.JSONArray     // Catch:{ all -> 0x01a5 }
            r8.<init>()     // Catch:{ all -> 0x01a5 }
            r9 = r6
            java.lang.Iterable r9 = (java.lang.Iterable) r9     // Catch:{ all -> 0x01a5 }
            r10 = 0
            java.util.Iterator r11 = r9.iterator()     // Catch:{ all -> 0x01a5 }
        L_0x0046:
            boolean r12 = r11.hasNext()     // Catch:{ all -> 0x01a5 }
            if (r12 == 0) goto L_0x0098
            java.lang.Object r12 = r11.next()     // Catch:{ all -> 0x01a5 }
            r13 = r12
            r14 = 0
            r15 = r13
            kotlin.Pair r15 = (kotlin.Pair) r15     // Catch:{ all -> 0x01a5 }
            r16 = 0
            org.json.JSONObject r17 = new org.json.JSONObject     // Catch:{ all -> 0x01a5 }
            r17.<init>()     // Catch:{ all -> 0x01a5 }
            r18 = r17
            r19 = 0
            r20 = r3
            java.lang.String r3 = "t"
            java.lang.Object r21 = r15.getFirst()     // Catch:{ all -> 0x0095 }
            java.lang.Number r21 = (java.lang.Number) r21     // Catch:{ all -> 0x0095 }
            r22 = r5
            r23 = r6
            long r5 = r21.longValue()     // Catch:{ all -> 0x0095 }
            r21 = r7
            r7 = r18
            r7.put(r3, r5)     // Catch:{ all -> 0x0095 }
            java.lang.String r3 = "v"
            java.lang.Object r5 = r15.getSecond()     // Catch:{ all -> 0x0095 }
            r7.put(r3, r5)     // Catch:{ all -> 0x0095 }
            r3 = r17
            r5 = 0
            r8.put(r3)     // Catch:{ all -> 0x0095 }
            r3 = r20
            r7 = r21
            r5 = r22
            r6 = r23
            goto L_0x0046
        L_0x0095:
            r0 = move-exception
            goto L_0x01a8
        L_0x0098:
            r20 = r3
            r22 = r5
            r23 = r6
            r21 = r7
            monitor-exit(r4)
            r3 = r8
            java.lang.String r4 = "tl_jserror"
            r2.put(r4, r3)
            java.util.LinkedList<kotlin.Pair<java.lang.Long, java.lang.String>> r4 = r1.naErrors
            monitor-enter(r4)
            r5 = 0
            java.util.LinkedList<kotlin.Pair<java.lang.Long, java.lang.String>> r6 = r1.naErrors     // Catch:{ all -> 0x01a0 }
            java.util.Collection r6 = (java.util.Collection) r6     // Catch:{ all -> 0x01a0 }
            r7 = 0
            org.json.JSONArray r8 = new org.json.JSONArray     // Catch:{ all -> 0x01a0 }
            r8.<init>()     // Catch:{ all -> 0x01a0 }
            r9 = r6
            java.lang.Iterable r9 = (java.lang.Iterable) r9     // Catch:{ all -> 0x01a0 }
            r10 = 0
            java.util.Iterator r11 = r9.iterator()     // Catch:{ all -> 0x01a0 }
        L_0x00c0:
            boolean r12 = r11.hasNext()     // Catch:{ all -> 0x01a0 }
            if (r12 == 0) goto L_0x0112
            java.lang.Object r12 = r11.next()     // Catch:{ all -> 0x01a0 }
            r13 = r12
            r14 = 0
            r15 = r13
            kotlin.Pair r15 = (kotlin.Pair) r15     // Catch:{ all -> 0x01a0 }
            r16 = 0
            org.json.JSONObject r17 = new org.json.JSONObject     // Catch:{ all -> 0x01a0 }
            r17.<init>()     // Catch:{ all -> 0x01a0 }
            r18 = r17
            r19 = 0
            r21 = r3
            java.lang.String r3 = "t"
            java.lang.Object r22 = r15.getFirst()     // Catch:{ all -> 0x010f }
            java.lang.Number r22 = (java.lang.Number) r22     // Catch:{ all -> 0x010f }
            r23 = r5
            r24 = r6
            long r5 = r22.longValue()     // Catch:{ all -> 0x010f }
            r22 = r7
            r7 = r18
            r7.put(r3, r5)     // Catch:{ all -> 0x010f }
            java.lang.String r3 = "v"
            java.lang.Object r5 = r15.getSecond()     // Catch:{ all -> 0x010f }
            r7.put(r3, r5)     // Catch:{ all -> 0x010f }
            r3 = r17
            r5 = 0
            r8.put(r3)     // Catch:{ all -> 0x010f }
            r3 = r21
            r7 = r22
            r5 = r23
            r6 = r24
            goto L_0x00c0
        L_0x010f:
            r0 = move-exception
            goto L_0x01a3
        L_0x0112:
            r21 = r3
            r23 = r5
            r24 = r6
            r22 = r7
            monitor-exit(r4)
            r3 = r8
            java.lang.String r4 = "tl_naerror"
            r2.put(r4, r3)
            java.util.LinkedList<kotlin.Pair<java.lang.Long, java.lang.String>> r4 = r1.resErrors
            monitor-enter(r4)
            r5 = 0
            java.util.LinkedList<kotlin.Pair<java.lang.Long, java.lang.String>> r6 = r1.resErrors     // Catch:{ all -> 0x019b }
            java.util.Collection r6 = (java.util.Collection) r6     // Catch:{ all -> 0x019b }
            r7 = 0
            org.json.JSONArray r8 = new org.json.JSONArray     // Catch:{ all -> 0x019b }
            r8.<init>()     // Catch:{ all -> 0x019b }
            r9 = r6
            java.lang.Iterable r9 = (java.lang.Iterable) r9     // Catch:{ all -> 0x019b }
            r10 = 0
            java.util.Iterator r11 = r9.iterator()     // Catch:{ all -> 0x019b }
        L_0x013a:
            boolean r12 = r11.hasNext()     // Catch:{ all -> 0x019b }
            if (r12 == 0) goto L_0x0189
            java.lang.Object r12 = r11.next()     // Catch:{ all -> 0x019b }
            r13 = r12
            r14 = 0
            r15 = r13
            kotlin.Pair r15 = (kotlin.Pair) r15     // Catch:{ all -> 0x019b }
            r16 = 0
            org.json.JSONObject r17 = new org.json.JSONObject     // Catch:{ all -> 0x019b }
            r17.<init>()     // Catch:{ all -> 0x019b }
            r18 = r17
            r19 = 0
            java.lang.String r1 = "t"
            java.lang.Object r22 = r15.getFirst()     // Catch:{ all -> 0x019b }
            java.lang.Number r22 = (java.lang.Number) r22     // Catch:{ all -> 0x019b }
            r23 = r5
            r24 = r6
            long r5 = r22.longValue()     // Catch:{ all -> 0x019b }
            r22 = r3
            r3 = r18
            r3.put(r1, r5)     // Catch:{ all -> 0x0187 }
            java.lang.String r1 = "v"
            java.lang.Object r5 = r15.getSecond()     // Catch:{ all -> 0x0187 }
            r3.put(r1, r5)     // Catch:{ all -> 0x0187 }
            r1 = r17
            r3 = 0
            r8.put(r1)     // Catch:{ all -> 0x0187 }
            r1 = r25
            r3 = r22
            r5 = r23
            r6 = r24
            goto L_0x013a
        L_0x0187:
            r0 = move-exception
            goto L_0x019e
        L_0x0189:
            r22 = r3
            r23 = r5
            r24 = r6
            monitor-exit(r4)
            r1 = r8
            java.lang.String r3 = "tl_reserror"
            r2.put(r3, r1)
            return r0
        L_0x019b:
            r0 = move-exception
            r22 = r3
        L_0x019e:
            monitor-exit(r4)
            throw r0
        L_0x01a0:
            r0 = move-exception
            r21 = r3
        L_0x01a3:
            monitor-exit(r4)
            throw r0
        L_0x01a5:
            r0 = move-exception
            r20 = r3
        L_0x01a8:
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.openwidget.engine.OpenWidgetLoadTracer.dump():java.util.Map");
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/openwidget/engine/OpenWidgetLoadTracer$Companion;", "", "()V", "EV_ANIM_ERR", "", "EV_ANIM_ERR_DETAIL", "EV_ANIM_ERR_TYPE", "EV_ANIM_EXIT", "EV_ANIM_LOAD_END", "EV_ANIM_LOAD_START", "EV_ANIM_START", "EV_JOB_CANCEL", "EV_SET_WIDGET_ANIMATION", "EV_SET_WIDGET_RENDERED", "EV_SET_WIDGET_TOUCH", "EV_START", "INFO_BLOCK_IMAGE", "INFO_CANCEL_TYPE", "INFO_ROUND", "LOG_JS_ERROR", "LOG_NA_ERROR", "LOG_RES_ERROR", "lib-openwidget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: OpenWidgetLoadTracer.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
