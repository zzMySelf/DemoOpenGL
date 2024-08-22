package shark;

import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\n"}, d2 = {"Lshark/AndroidMetadataExtractor;", "Lshark/MetadataExtractor;", "()V", "extractMetadata", "", "", "graph", "Lshark/HeapGraph;", "readLeakCanaryVersion", "readProcessName", "shark-android"}, k = 1, mv = {1, 4, 1})
/* compiled from: AndroidMetadataExtractor.kt */
public final class AndroidMetadataExtractor implements MetadataExtractor {
    public static final AndroidMetadataExtractor INSTANCE = new AndroidMetadataExtractor();

    private AndroidMetadataExtractor() {
    }

    public Map<String, String> extractMetadata(HeapGraph graph) {
        Intrinsics.checkParameterIsNotNull(graph, "graph");
        AndroidBuildMirror build = AndroidBuildMirror.Companion.fromHeapGraph(graph);
        return MapsKt.mapOf(TuplesKt.to("Build.VERSION.SDK_INT", String.valueOf(build.getSdkInt())), TuplesKt.to("Build.MANUFACTURER", build.getManufacturer()), TuplesKt.to("LeakCanary version", readLeakCanaryVersion(graph)), TuplesKt.to("App process name", readProcessName(graph)));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0018, code lost:
        r1 = (r1 = (r1 = r0.get("version")).getValue()).readAsJavaString();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String readLeakCanaryVersion(shark.HeapGraph r3) {
        /*
            r2 = this;
            java.lang.String r0 = "leakcanary.internal.InternalLeakCanary"
            shark.HeapObject$HeapClass r0 = r3.findClassByName(r0)
            if (r0 == 0) goto L_0x001f
            java.lang.String r1 = "version"
            shark.HeapField r1 = r0.get(r1)
            if (r1 == 0) goto L_0x001f
            shark.HeapValue r1 = r1.getValue()
            if (r1 == 0) goto L_0x001f
            java.lang.String r1 = r1.readAsJavaString()
            if (r1 == 0) goto L_0x001f
            goto L_0x0021
        L_0x001f:
            java.lang.String r1 = "Unknown"
        L_0x0021:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: shark.AndroidMetadataExtractor.readLeakCanaryVersion(shark.HeapGraph):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000c, code lost:
        r1 = r1.get("sCurrentActivityThread");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String readProcessName(shark.HeapGraph r6) {
        /*
            r5 = this;
            java.lang.String r0 = "android.app.ActivityThread"
            shark.HeapObject$HeapClass r1 = r6.findClassByName(r0)
            r2 = 0
            if (r1 == 0) goto L_0x001a
            java.lang.String r3 = "sCurrentActivityThread"
            shark.HeapField r1 = r1.get(r3)
            if (r1 == 0) goto L_0x001a
            shark.HeapObject$HeapInstance r1 = r1.getValueAsInstance()
            goto L_0x001b
        L_0x001a:
            r1 = r2
        L_0x001b:
            if (r1 == 0) goto L_0x002d
            java.lang.String r3 = "mBoundApplication"
            shark.HeapField r0 = r1.get((java.lang.String) r0, (java.lang.String) r3)
            if (r0 == 0) goto L_0x002d
            shark.HeapObject$HeapInstance r0 = r0.getValueAsInstance()
            goto L_0x002e
        L_0x002d:
            r0 = r2
        L_0x002e:
            if (r0 == 0) goto L_0x0040
            java.lang.String r3 = "android.app.ActivityThread$AppBindData"
            java.lang.String r4 = "appInfo"
            shark.HeapField r3 = r0.get((java.lang.String) r3, (java.lang.String) r4)
            if (r3 == 0) goto L_0x0040
            shark.HeapObject$HeapInstance r2 = r3.getValueAsInstance()
            goto L_0x0041
        L_0x0040:
        L_0x0041:
            if (r2 == 0) goto L_0x005d
            java.lang.String r3 = "android.content.pm.ApplicationInfo"
            java.lang.String r4 = "processName"
            shark.HeapField r3 = r2.get((java.lang.String) r3, (java.lang.String) r4)
            if (r3 == 0) goto L_0x005d
            shark.HeapObject$HeapInstance r3 = r3.getValueAsInstance()
            if (r3 == 0) goto L_0x005d
            java.lang.String r3 = r3.readAsJavaString()
            if (r3 == 0) goto L_0x005d
            goto L_0x005f
        L_0x005d:
            java.lang.String r3 = "Unknown"
        L_0x005f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: shark.AndroidMetadataExtractor.readProcessName(shark.HeapGraph):java.lang.String");
    }
}
