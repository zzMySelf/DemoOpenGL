package leakcanary.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import leakcanary.LeakCanary;
import shark.HeapAnalysis;
import shark.HeapAnalysisException;
import shark.HeapAnalysisFailure;
import shark.HeapAnalyzer;
import shark.LeakingObjectFinder;
import shark.MetadataExtractor;
import shark.ObjectInspector;
import shark.OnAnalysisProgressListener;
import shark.ProguardMapping;
import shark.ProguardMappingReader;
import shark.ReferenceMatcher;
import shark.SharkLog;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00132\u00020\u00012\u00020\u0002:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014¨\u0006\u0014"}, d2 = {"Lleakcanary/internal/HeapAnalyzerService;", "Lleakcanary/internal/ForegroundService;", "Lshark/OnAnalysisProgressListener;", "()V", "analyzeHeap", "Lshark/HeapAnalysis;", "heapDumpFile", "Ljava/io/File;", "config", "Lleakcanary/LeakCanary$Config;", "missingFileFailure", "Lshark/HeapAnalysisFailure;", "onAnalysisProgress", "", "step", "Lshark/OnAnalysisProgressListener$Step;", "onHandleIntentInForeground", "intent", "Landroid/content/Intent;", "Companion", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: HeapAnalyzerService.kt */
public final class HeapAnalyzerService extends ForegroundService implements OnAnalysisProgressListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String HEAPDUMP_DURATION_MILLIS_EXTRA = "HEAPDUMP_DURATION_MILLIS_EXTRA";
    private static final String HEAPDUMP_FILE_EXTRA = "HEAPDUMP_FILE_EXTRA";
    private static final String HEAPDUMP_REASON_EXTRA = "HEAPDUMP_REASON_EXTRA";
    private static final String PROGUARD_MAPPING_FILE_NAME = "leakCanaryObfuscationMapping.txt";

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HeapAnalyzerService() {
        /*
            r3 = this;
            java.lang.Class<leakcanary.internal.HeapAnalyzerService> r0 = leakcanary.internal.HeapAnalyzerService.class
            java.lang.String r0 = r0.getSimpleName()
            java.lang.String r1 = "HeapAnalyzerService::class.java.simpleName"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            int r1 = com.squareup.leakcanary.core.R.string.leak_canary_notification_analysing
            int r2 = com.squareup.leakcanary.core.R.id.leak_canary_notification_analyzing_heap
            r3.<init>(r0, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: leakcanary.internal.HeapAnalyzerService.<init>():void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v0, resolved type: shark.HeapAnalysisSuccess} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v10, resolved type: shark.HeapAnalysisSuccess} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v1, resolved type: shark.HeapAnalysisFailure} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v3, resolved type: shark.HeapAnalysisFailure} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v18, resolved type: shark.HeapAnalysisFailure} */
    /* JADX WARNING: type inference failed for: r7v16, types: [shark.HeapAnalysis] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onHandleIntentInForeground(android.content.Intent r24) {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            if (r1 == 0) goto L_0x00c1
            java.lang.String r2 = "HEAPDUMP_FILE_EXTRA"
            boolean r3 = r1.hasExtra(r2)
            if (r3 != 0) goto L_0x0010
            goto L_0x00c1
        L_0x0010:
            r3 = 10
            android.os.Process.setThreadPriority(r3)
            java.io.Serializable r2 = r1.getSerializableExtra(r2)
            if (r2 == 0) goto L_0x00b8
            java.io.File r2 = (java.io.File) r2
            java.lang.String r3 = "HEAPDUMP_REASON_EXTRA"
            java.lang.String r3 = r1.getStringExtra(r3)
            r4 = -1
            java.lang.String r6 = "HEAPDUMP_DURATION_MILLIS_EXTRA"
            long r4 = r1.getLongExtra(r6, r4)
            leakcanary.LeakCanary$Config r6 = leakcanary.LeakCanary.getConfig()
            boolean r7 = r2.exists()
            if (r7 == 0) goto L_0x003a
            shark.HeapAnalysis r7 = r0.analyzeHeap(r2, r6)
            goto L_0x0040
        L_0x003a:
            shark.HeapAnalysisFailure r7 = r0.missingFileFailure(r2)
            shark.HeapAnalysis r7 = (shark.HeapAnalysis) r7
        L_0x0040:
            r15 = r7
            boolean r7 = r15 instanceof shark.HeapAnalysisSuccess
            if (r7 == 0) goto L_0x0081
            r7 = r15
            shark.HeapAnalysisSuccess r7 = (shark.HeapAnalysisSuccess) r7
            r8 = 0
            r9 = 0
            r13 = 0
            r11 = r15
            shark.HeapAnalysisSuccess r11 = (shark.HeapAnalysisSuccess) r11
            java.util.Map r11 = r11.getMetadata()
            java.lang.String r12 = "Heap dump reason"
            kotlin.Pair r12 = kotlin.TuplesKt.to(r12, r3)
            java.util.Map r16 = kotlin.collections.MapsKt.plus(r11, r12)
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 235(0xeb, float:3.3E-43)
            r21 = 0
            r11 = r4
            r22 = r15
            r15 = r16
            r16 = r17
            r17 = r18
            r18 = r19
            r19 = r20
            r20 = r21
            shark.HeapAnalysisSuccess r7 = shark.HeapAnalysisSuccess.copy$default(r7, r8, r9, r11, r13, r15, r16, r17, r18, r19, r20)
            shark.HeapAnalysis r7 = (shark.HeapAnalysis) r7
            r19 = r22
            goto L_0x00a4
        L_0x0081:
            r22 = r15
            boolean r7 = r15 instanceof shark.HeapAnalysisFailure
            if (r7 == 0) goto L_0x00b2
            r7 = r15
            shark.HeapAnalysisFailure r7 = (shark.HeapAnalysisFailure) r7
            r8 = 0
            r9 = 0
            r13 = 0
            r16 = 0
            r17 = 27
            r18 = 0
            r11 = r4
            r19 = r15
            r15 = r16
            r16 = r17
            r17 = r18
            shark.HeapAnalysisFailure r7 = shark.HeapAnalysisFailure.copy$default(r7, r8, r9, r11, r13, r15, r16, r17)
            shark.HeapAnalysis r7 = (shark.HeapAnalysis) r7
        L_0x00a4:
            shark.OnAnalysisProgressListener$Step r8 = shark.OnAnalysisProgressListener.Step.REPORTING_HEAP_ANALYSIS
            r0.onAnalysisProgress(r8)
            leakcanary.OnHeapAnalyzedListener r8 = r6.getOnHeapAnalyzedListener()
            r8.onHeapAnalyzed(r7)
            return
        L_0x00b2:
            kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
            r7.<init>()
            throw r7
        L_0x00b8:
            kotlin.TypeCastException r2 = new kotlin.TypeCastException
            java.lang.String r3 = "null cannot be cast to non-null type java.io.File"
            r2.<init>(r3)
            throw r2
        L_0x00c1:
            shark.SharkLog r2 = shark.SharkLog.INSTANCE
            r3 = 0
            shark.SharkLog$Logger r4 = r2.getLogger()
            if (r4 == 0) goto L_0x00d2
            r5 = 0
            java.lang.String r5 = "HeapAnalyzerService received a null or empty intent, ignoring."
            r4.d(r5)
        L_0x00d2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: leakcanary.internal.HeapAnalyzerService.onHandleIntentInForeground(android.content.Intent):void");
    }

    private final HeapAnalysis analyzeHeap(File heapDumpFile, LeakCanary.Config config) {
        ProguardMappingReader proguardMappingReader;
        HeapAnalyzer heapAnalyzer = new HeapAnalyzer(this);
        ProguardMapping proguardMapping = null;
        try {
            InputStream open = getAssets().open(PROGUARD_MAPPING_FILE_NAME);
            Intrinsics.checkExpressionValueIsNotNull(open, "assets.open(PROGUARD_MAPPING_FILE_NAME)");
            proguardMappingReader = new ProguardMappingReader(open);
        } catch (IOException e2) {
            proguardMappingReader = null;
        }
        ProguardMappingReader proguardMappingReader2 = proguardMappingReader;
        LeakingObjectFinder leakingObjectFinder = config.getLeakingObjectFinder();
        List<ReferenceMatcher> referenceMatchers = config.getReferenceMatchers();
        boolean computeRetainedHeapSize = config.getComputeRetainedHeapSize();
        List<ObjectInspector> objectInspectors = config.getObjectInspectors();
        MetadataExtractor metadataExtractor = config.getMetadataExtractor();
        if (proguardMappingReader2 != null) {
            proguardMapping = proguardMappingReader2.readProguardMapping();
        }
        return heapAnalyzer.analyze(heapDumpFile, leakingObjectFinder, (List<? extends ReferenceMatcher>) referenceMatchers, computeRetainedHeapSize, (List<? extends ObjectInspector>) objectInspectors, metadataExtractor, proguardMapping);
    }

    private final HeapAnalysisFailure missingFileFailure(File heapDumpFile) {
        return new HeapAnalysisFailure(heapDumpFile, System.currentTimeMillis(), 0, 0, new HeapAnalysisException(new IllegalStateException("Hprof file " + heapDumpFile + " missing, deleted because: " + LeakDirectoryProvider.Companion.hprofDeleteReason(heapDumpFile))), 4, (DefaultConstructorMarker) null);
    }

    public void onAnalysisProgress(OnAnalysisProgressListener.Step step) {
        Intrinsics.checkParameterIsNotNull(step, "step");
        int percent = (int) ((((float) step.ordinal()) * 100.0f) / ((float) OnAnalysisProgressListener.Step.values().length));
        SharkLog.Logger logger$iv = SharkLog.INSTANCE.getLogger();
        if (logger$iv != null) {
            logger$iv.d("Analysis in progress, working on: " + step.name());
        }
        String replace$default = StringsKt.replace$default(step.name(), "_", " ", false, 4, (Object) null);
        Locale locale = Locale.US;
        Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.US");
        if (replace$default != null) {
            String lowercase = replace$default.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowercase, "(this as java.lang.String).toLowerCase(locale)");
            StringBuilder sb = new StringBuilder();
            if (lowercase != null) {
                String substring = lowercase.substring(0, 1);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                Locale locale2 = Locale.US;
                Intrinsics.checkExpressionValueIsNotNull(locale2, "Locale.US");
                if (substring != null) {
                    String upperCase = substring.toUpperCase(locale2);
                    Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase(locale)");
                    StringBuilder append = sb.append(upperCase);
                    if (lowercase != null) {
                        String substring2 = lowercase.substring(1);
                        Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.String).substring(startIndex)");
                        showForegroundNotification(100, percent, false, append.append(substring2).toString());
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J1\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0004¢\u0006\u0002\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lleakcanary/internal/HeapAnalyzerService$Companion;", "", "()V", "HEAPDUMP_DURATION_MILLIS_EXTRA", "", "HEAPDUMP_FILE_EXTRA", "HEAPDUMP_REASON_EXTRA", "PROGUARD_MAPPING_FILE_NAME", "runAnalysis", "", "context", "Landroid/content/Context;", "heapDumpFile", "Ljava/io/File;", "heapDumpDurationMillis", "", "heapDumpReason", "(Landroid/content/Context;Ljava/io/File;Ljava/lang/Long;Ljava/lang/String;)V", "startForegroundService", "intent", "Landroid/content/Intent;", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
    /* compiled from: HeapAnalyzerService.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public static /* synthetic */ void runAnalysis$default(Companion companion, Context context, File file, Long l, String str, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                l = null;
                Long l2 = null;
            }
            if ((i2 & 8) != 0) {
                str = "Unknown";
            }
            companion.runAnalysis(context, file, l, str);
        }

        public final void runAnalysis(Context context, File heapDumpFile, Long heapDumpDurationMillis, String heapDumpReason) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intrinsics.checkParameterIsNotNull(heapDumpFile, "heapDumpFile");
            Intrinsics.checkParameterIsNotNull(heapDumpReason, "heapDumpReason");
            Intent intent = new Intent(context, HeapAnalyzerService.class);
            intent.putExtra(HeapAnalyzerService.HEAPDUMP_FILE_EXTRA, heapDumpFile);
            intent.putExtra(HeapAnalyzerService.HEAPDUMP_REASON_EXTRA, heapDumpReason);
            if (heapDumpDurationMillis != null) {
                long longValue = heapDumpDurationMillis.longValue();
                intent.putExtra(HeapAnalyzerService.HEAPDUMP_DURATION_MILLIS_EXTRA, heapDumpDurationMillis.longValue());
            }
            startForegroundService(context, intent);
        }

        private final void startForegroundService(Context context, Intent intent) {
            if (Build.VERSION.SDK_INT >= 26) {
                context.startForegroundService(intent);
            } else {
                context.startService(intent);
            }
        }
    }
}
