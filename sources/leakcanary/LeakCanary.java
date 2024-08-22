package leakcanary;

import android.content.Intent;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import leakcanary.internal.HeapDumpControl;
import leakcanary.internal.InternalLeakCanary;
import leakcanary.internal.activity.LeakActivity;
import shark.LeakingObjectFinder;
import shark.MetadataExtractor;
import shark.ObjectInspector;
import shark.ReferenceMatcher;
import shark.SharkLog;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013R,\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048\u0006@FX\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0006\u0010\u0002\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lleakcanary/LeakCanary;", "", "()V", "newConfig", "Lleakcanary/LeakCanary$Config;", "config", "getConfig$annotations", "getConfig", "()Lleakcanary/LeakCanary$Config;", "setConfig", "(Lleakcanary/LeakCanary$Config;)V", "dumpHeap", "", "logConfigChange", "previousConfig", "newLeakDisplayActivityIntent", "Landroid/content/Intent;", "showLeakDisplayActivityLauncherIcon", "showLauncherIcon", "", "Config", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: LeakCanary.kt */
public final class LeakCanary {
    public static final LeakCanary INSTANCE = new LeakCanary();
    private static volatile Config config = new Config(false, false, 0, (List) null, (List) null, (OnHeapAnalyzedListener) null, (MetadataExtractor) null, false, 0, false, (LeakingObjectFinder) null, false, (String) null, (String) null, (String) null, (ICustomInfoCollector) null, false, 131071, (DefaultConstructorMarker) null);

    @JvmStatic
    public static /* synthetic */ void getConfig$annotations() {
    }

    private LeakCanary() {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b5\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001SB»\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u001b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0003¢\u0006\u0002\u0010\u001dJ\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0014HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0017HÆ\u0003J\t\u0010@\u001a\u00020\u0017HÆ\u0003J\t\u0010A\u001a\u00020\u0017HÆ\u0003J\t\u0010B\u001a\u00020\u001bHÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0006HÆ\u0003J\u000f\u0010F\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\u000f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u000b0\bHÆ\u0003J\t\u0010H\u001a\u00020\rHÆ\u0003J\t\u0010I\u001a\u00020\u000fHÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0006HÆ\u0003J¿\u0001\u0010L\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u0003HÆ\u0001J\u0013\u0010M\u001a\u00020\u00032\b\u0010N\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010O\u001a\u00020\u0006HÖ\u0001J\b\u0010P\u001a\u00020QH\u0007J\t\u0010R\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001fR\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u0011\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u0018\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b0\u0010#R\u0011\u0010\u0019\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b1\u0010#R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b2\u0010-R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b4\u0010)R\u001c\u0010\u0015\u001a\u00020\u00038\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b5\u00106\u001a\u0004\b7\u0010\u001fR\u001a\u0010\u001c\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u001f\"\u0004\b9\u0010:¨\u0006T"}, d2 = {"Lleakcanary/LeakCanary$Config;", "", "dumpHeap", "", "dumpHeapWhenDebugging", "retainedVisibleThreshold", "", "referenceMatchers", "", "Lshark/ReferenceMatcher;", "objectInspectors", "Lshark/ObjectInspector;", "onHeapAnalyzedListener", "Lleakcanary/OnHeapAnalyzedListener;", "metadataExtractor", "Lshark/MetadataExtractor;", "computeRetainedHeapSize", "maxStoredHeapDumps", "requestWriteExternalStoragePermission", "leakingObjectFinder", "Lshark/LeakingObjectFinder;", "useExperimentalLeakFinders", "deviceCUID", "", "packageBranch", "packageCommitID", "customInfoCollector", "Lleakcanary/ICustomInfoCollector;", "usingForkMode", "(ZZILjava/util/List;Ljava/util/List;Lleakcanary/OnHeapAnalyzedListener;Lshark/MetadataExtractor;ZIZLshark/LeakingObjectFinder;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lleakcanary/ICustomInfoCollector;Z)V", "getComputeRetainedHeapSize", "()Z", "getCustomInfoCollector", "()Lleakcanary/ICustomInfoCollector;", "getDeviceCUID", "()Ljava/lang/String;", "getDumpHeap", "getDumpHeapWhenDebugging", "getLeakingObjectFinder", "()Lshark/LeakingObjectFinder;", "getMaxStoredHeapDumps", "()I", "getMetadataExtractor", "()Lshark/MetadataExtractor;", "getObjectInspectors", "()Ljava/util/List;", "getOnHeapAnalyzedListener", "()Lleakcanary/OnHeapAnalyzedListener;", "getPackageBranch", "getPackageCommitID", "getReferenceMatchers", "getRequestWriteExternalStoragePermission", "getRetainedVisibleThreshold", "getUseExperimentalLeakFinders$annotations", "()V", "getUseExperimentalLeakFinders", "getUsingForkMode", "setUsingForkMode", "(Z)V", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "newBuilder", "Lleakcanary/LeakCanary$Config$Builder;", "toString", "Builder", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
    /* compiled from: LeakCanary.kt */
    public static final class Config {
        private final boolean computeRetainedHeapSize;
        private final ICustomInfoCollector customInfoCollector;
        private final String deviceCUID;
        private final boolean dumpHeap;
        private final boolean dumpHeapWhenDebugging;
        private final LeakingObjectFinder leakingObjectFinder;
        private final int maxStoredHeapDumps;
        private final MetadataExtractor metadataExtractor;
        private final List<ObjectInspector> objectInspectors;
        private final OnHeapAnalyzedListener onHeapAnalyzedListener;
        private final String packageBranch;
        private final String packageCommitID;
        private final List<ReferenceMatcher> referenceMatchers;
        private final boolean requestWriteExternalStoragePermission;
        private final int retainedVisibleThreshold;
        private final boolean useExperimentalLeakFinders;
        private boolean usingForkMode;

        public Config() {
            this(false, false, 0, (List) null, (List) null, (OnHeapAnalyzedListener) null, (MetadataExtractor) null, false, 0, false, (LeakingObjectFinder) null, false, (String) null, (String) null, (String) null, (ICustomInfoCollector) null, false, 131071, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ Config copy$default(Config config, boolean z, boolean z2, int i2, List list, List list2, OnHeapAnalyzedListener onHeapAnalyzedListener2, MetadataExtractor metadataExtractor2, boolean z3, int i3, boolean z4, LeakingObjectFinder leakingObjectFinder2, boolean z5, String str, String str2, String str3, ICustomInfoCollector iCustomInfoCollector, boolean z6, int i4, Object obj) {
            Config config2 = config;
            int i5 = i4;
            return config.copy((i5 & 1) != 0 ? config2.dumpHeap : z, (i5 & 2) != 0 ? config2.dumpHeapWhenDebugging : z2, (i5 & 4) != 0 ? config2.retainedVisibleThreshold : i2, (i5 & 8) != 0 ? config2.referenceMatchers : list, (i5 & 16) != 0 ? config2.objectInspectors : list2, (i5 & 32) != 0 ? config2.onHeapAnalyzedListener : onHeapAnalyzedListener2, (i5 & 64) != 0 ? config2.metadataExtractor : metadataExtractor2, (i5 & 128) != 0 ? config2.computeRetainedHeapSize : z3, (i5 & 256) != 0 ? config2.maxStoredHeapDumps : i3, (i5 & 512) != 0 ? config2.requestWriteExternalStoragePermission : z4, (i5 & 1024) != 0 ? config2.leakingObjectFinder : leakingObjectFinder2, (i5 & 2048) != 0 ? config2.useExperimentalLeakFinders : z5, (i5 & 4096) != 0 ? config2.deviceCUID : str, (i5 & 8192) != 0 ? config2.packageBranch : str2, (i5 & 16384) != 0 ? config2.packageCommitID : str3, (i5 & 32768) != 0 ? config2.customInfoCollector : iCustomInfoCollector, (i5 & 65536) != 0 ? config2.usingForkMode : z6);
        }

        @Deprecated(message = "This is a no-op, set a custom leakingObjectFinder instead")
        public static /* synthetic */ void getUseExperimentalLeakFinders$annotations() {
        }

        public final boolean component1() {
            return this.dumpHeap;
        }

        public final boolean component10() {
            return this.requestWriteExternalStoragePermission;
        }

        public final LeakingObjectFinder component11() {
            return this.leakingObjectFinder;
        }

        public final boolean component12() {
            return this.useExperimentalLeakFinders;
        }

        public final String component13() {
            return this.deviceCUID;
        }

        public final String component14() {
            return this.packageBranch;
        }

        public final String component15() {
            return this.packageCommitID;
        }

        public final ICustomInfoCollector component16() {
            return this.customInfoCollector;
        }

        public final boolean component17() {
            return this.usingForkMode;
        }

        public final boolean component2() {
            return this.dumpHeapWhenDebugging;
        }

        public final int component3() {
            return this.retainedVisibleThreshold;
        }

        public final List<ReferenceMatcher> component4() {
            return this.referenceMatchers;
        }

        public final List<ObjectInspector> component5() {
            return this.objectInspectors;
        }

        public final OnHeapAnalyzedListener component6() {
            return this.onHeapAnalyzedListener;
        }

        public final MetadataExtractor component7() {
            return this.metadataExtractor;
        }

        public final boolean component8() {
            return this.computeRetainedHeapSize;
        }

        public final int component9() {
            return this.maxStoredHeapDumps;
        }

        public final Config copy(boolean z, boolean z2, int i2, List<? extends ReferenceMatcher> list, List<? extends ObjectInspector> list2, OnHeapAnalyzedListener onHeapAnalyzedListener2, MetadataExtractor metadataExtractor2, boolean z3, int i3, boolean z4, LeakingObjectFinder leakingObjectFinder2, boolean z5, String str, String str2, String str3, ICustomInfoCollector iCustomInfoCollector, boolean z6) {
            Intrinsics.checkParameterIsNotNull(list, "referenceMatchers");
            Intrinsics.checkParameterIsNotNull(list2, "objectInspectors");
            Intrinsics.checkParameterIsNotNull(onHeapAnalyzedListener2, "onHeapAnalyzedListener");
            Intrinsics.checkParameterIsNotNull(metadataExtractor2, "metadataExtractor");
            Intrinsics.checkParameterIsNotNull(leakingObjectFinder2, "leakingObjectFinder");
            Intrinsics.checkParameterIsNotNull(str, "deviceCUID");
            Intrinsics.checkParameterIsNotNull(str2, "packageBranch");
            Intrinsics.checkParameterIsNotNull(str3, "packageCommitID");
            Intrinsics.checkParameterIsNotNull(iCustomInfoCollector, "customInfoCollector");
            return new Config(z, z2, i2, list, list2, onHeapAnalyzedListener2, metadataExtractor2, z3, i3, z4, leakingObjectFinder2, z5, str, str2, str3, iCustomInfoCollector, z6);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Config)) {
                return false;
            }
            Config config = (Config) obj;
            return this.dumpHeap == config.dumpHeap && this.dumpHeapWhenDebugging == config.dumpHeapWhenDebugging && this.retainedVisibleThreshold == config.retainedVisibleThreshold && Intrinsics.areEqual((Object) this.referenceMatchers, (Object) config.referenceMatchers) && Intrinsics.areEqual((Object) this.objectInspectors, (Object) config.objectInspectors) && Intrinsics.areEqual((Object) this.onHeapAnalyzedListener, (Object) config.onHeapAnalyzedListener) && Intrinsics.areEqual((Object) this.metadataExtractor, (Object) config.metadataExtractor) && this.computeRetainedHeapSize == config.computeRetainedHeapSize && this.maxStoredHeapDumps == config.maxStoredHeapDumps && this.requestWriteExternalStoragePermission == config.requestWriteExternalStoragePermission && Intrinsics.areEqual((Object) this.leakingObjectFinder, (Object) config.leakingObjectFinder) && this.useExperimentalLeakFinders == config.useExperimentalLeakFinders && Intrinsics.areEqual((Object) this.deviceCUID, (Object) config.deviceCUID) && Intrinsics.areEqual((Object) this.packageBranch, (Object) config.packageBranch) && Intrinsics.areEqual((Object) this.packageCommitID, (Object) config.packageCommitID) && Intrinsics.areEqual((Object) this.customInfoCollector, (Object) config.customInfoCollector) && this.usingForkMode == config.usingForkMode;
        }

        public int hashCode() {
            boolean z = this.dumpHeap;
            boolean z2 = true;
            if (z) {
                z = true;
            }
            int i2 = (z ? 1 : 0) * true;
            boolean z3 = this.dumpHeapWhenDebugging;
            if (z3) {
                z3 = true;
            }
            int i3 = (((i2 + (z3 ? 1 : 0)) * 31) + this.retainedVisibleThreshold) * 31;
            List<ReferenceMatcher> list = this.referenceMatchers;
            int i4 = 0;
            int hashCode = (i3 + (list != null ? list.hashCode() : 0)) * 31;
            List<ObjectInspector> list2 = this.objectInspectors;
            int hashCode2 = (hashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
            OnHeapAnalyzedListener onHeapAnalyzedListener2 = this.onHeapAnalyzedListener;
            int hashCode3 = (hashCode2 + (onHeapAnalyzedListener2 != null ? onHeapAnalyzedListener2.hashCode() : 0)) * 31;
            MetadataExtractor metadataExtractor2 = this.metadataExtractor;
            int hashCode4 = (hashCode3 + (metadataExtractor2 != null ? metadataExtractor2.hashCode() : 0)) * 31;
            boolean z4 = this.computeRetainedHeapSize;
            if (z4) {
                z4 = true;
            }
            int i5 = (((hashCode4 + (z4 ? 1 : 0)) * 31) + this.maxStoredHeapDumps) * 31;
            boolean z5 = this.requestWriteExternalStoragePermission;
            if (z5) {
                z5 = true;
            }
            int i6 = (i5 + (z5 ? 1 : 0)) * 31;
            LeakingObjectFinder leakingObjectFinder2 = this.leakingObjectFinder;
            int hashCode5 = (i6 + (leakingObjectFinder2 != null ? leakingObjectFinder2.hashCode() : 0)) * 31;
            boolean z6 = this.useExperimentalLeakFinders;
            if (z6) {
                z6 = true;
            }
            int i7 = (hashCode5 + (z6 ? 1 : 0)) * 31;
            String str = this.deviceCUID;
            int hashCode6 = (i7 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.packageBranch;
            int hashCode7 = (hashCode6 + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.packageCommitID;
            int hashCode8 = (hashCode7 + (str3 != null ? str3.hashCode() : 0)) * 31;
            ICustomInfoCollector iCustomInfoCollector = this.customInfoCollector;
            if (iCustomInfoCollector != null) {
                i4 = iCustomInfoCollector.hashCode();
            }
            int i8 = (hashCode8 + i4) * 31;
            boolean z7 = this.usingForkMode;
            if (!z7) {
                z2 = z7;
            }
            return i8 + (z2 ? 1 : 0);
        }

        public String toString() {
            return "Config(dumpHeap=" + this.dumpHeap + ", dumpHeapWhenDebugging=" + this.dumpHeapWhenDebugging + ", retainedVisibleThreshold=" + this.retainedVisibleThreshold + ", referenceMatchers=" + this.referenceMatchers + ", objectInspectors=" + this.objectInspectors + ", onHeapAnalyzedListener=" + this.onHeapAnalyzedListener + ", metadataExtractor=" + this.metadataExtractor + ", computeRetainedHeapSize=" + this.computeRetainedHeapSize + ", maxStoredHeapDumps=" + this.maxStoredHeapDumps + ", requestWriteExternalStoragePermission=" + this.requestWriteExternalStoragePermission + ", leakingObjectFinder=" + this.leakingObjectFinder + ", useExperimentalLeakFinders=" + this.useExperimentalLeakFinders + ", deviceCUID=" + this.deviceCUID + ", packageBranch=" + this.packageBranch + ", packageCommitID=" + this.packageCommitID + ", customInfoCollector=" + this.customInfoCollector + ", usingForkMode=" + this.usingForkMode + ")";
        }

        public Config(boolean dumpHeap2, boolean dumpHeapWhenDebugging2, int retainedVisibleThreshold2, List<? extends ReferenceMatcher> referenceMatchers2, List<? extends ObjectInspector> objectInspectors2, OnHeapAnalyzedListener onHeapAnalyzedListener2, MetadataExtractor metadataExtractor2, boolean computeRetainedHeapSize2, int maxStoredHeapDumps2, boolean requestWriteExternalStoragePermission2, LeakingObjectFinder leakingObjectFinder2, boolean useExperimentalLeakFinders2, String deviceCUID2, String packageBranch2, String packageCommitID2, ICustomInfoCollector customInfoCollector2, boolean usingForkMode2) {
            List<? extends ReferenceMatcher> list = referenceMatchers2;
            List<? extends ObjectInspector> list2 = objectInspectors2;
            OnHeapAnalyzedListener onHeapAnalyzedListener3 = onHeapAnalyzedListener2;
            MetadataExtractor metadataExtractor3 = metadataExtractor2;
            LeakingObjectFinder leakingObjectFinder3 = leakingObjectFinder2;
            String str = deviceCUID2;
            String str2 = packageBranch2;
            String str3 = packageCommitID2;
            ICustomInfoCollector iCustomInfoCollector = customInfoCollector2;
            Intrinsics.checkParameterIsNotNull(list, "referenceMatchers");
            Intrinsics.checkParameterIsNotNull(list2, "objectInspectors");
            Intrinsics.checkParameterIsNotNull(onHeapAnalyzedListener3, "onHeapAnalyzedListener");
            Intrinsics.checkParameterIsNotNull(metadataExtractor3, "metadataExtractor");
            Intrinsics.checkParameterIsNotNull(leakingObjectFinder3, "leakingObjectFinder");
            Intrinsics.checkParameterIsNotNull(str, "deviceCUID");
            Intrinsics.checkParameterIsNotNull(str2, "packageBranch");
            Intrinsics.checkParameterIsNotNull(str3, "packageCommitID");
            Intrinsics.checkParameterIsNotNull(iCustomInfoCollector, "customInfoCollector");
            this.dumpHeap = dumpHeap2;
            this.dumpHeapWhenDebugging = dumpHeapWhenDebugging2;
            this.retainedVisibleThreshold = retainedVisibleThreshold2;
            this.referenceMatchers = list;
            this.objectInspectors = list2;
            this.onHeapAnalyzedListener = onHeapAnalyzedListener3;
            this.metadataExtractor = metadataExtractor3;
            this.computeRetainedHeapSize = computeRetainedHeapSize2;
            this.maxStoredHeapDumps = maxStoredHeapDumps2;
            this.requestWriteExternalStoragePermission = requestWriteExternalStoragePermission2;
            this.leakingObjectFinder = leakingObjectFinder3;
            this.useExperimentalLeakFinders = useExperimentalLeakFinders2;
            this.deviceCUID = str;
            this.packageBranch = str2;
            this.packageCommitID = str3;
            this.customInfoCollector = iCustomInfoCollector;
            this.usingForkMode = usingForkMode2;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ Config(boolean r19, boolean r20, int r21, java.util.List r22, java.util.List r23, leakcanary.OnHeapAnalyzedListener r24, shark.MetadataExtractor r25, boolean r26, int r27, boolean r28, shark.LeakingObjectFinder r29, boolean r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, leakcanary.ICustomInfoCollector r34, boolean r35, int r36, kotlin.jvm.internal.DefaultConstructorMarker r37) {
            /*
                r18 = this;
                r0 = r36
                r1 = r0 & 1
                r2 = 1
                if (r1 == 0) goto L_0x0009
                r1 = r2
                goto L_0x000b
            L_0x0009:
                r1 = r19
            L_0x000b:
                r3 = r0 & 2
                if (r3 == 0) goto L_0x0011
                r3 = 0
                goto L_0x0013
            L_0x0011:
                r3 = r20
            L_0x0013:
                r5 = r0 & 4
                if (r5 == 0) goto L_0x0019
                r5 = 5
                goto L_0x001b
            L_0x0019:
                r5 = r21
            L_0x001b:
                r6 = r0 & 8
                if (r6 == 0) goto L_0x0026
                shark.AndroidReferenceMatchers$Companion r6 = shark.AndroidReferenceMatchers.Companion
                java.util.List r6 = r6.getAppDefaults()
                goto L_0x0028
            L_0x0026:
                r6 = r22
            L_0x0028:
                r7 = r0 & 16
                if (r7 == 0) goto L_0x0033
                shark.AndroidObjectInspectors$Companion r7 = shark.AndroidObjectInspectors.Companion
                java.util.List r7 = r7.getAppDefaults()
                goto L_0x0035
            L_0x0033:
                r7 = r23
            L_0x0035:
                r8 = r0 & 32
                if (r8 == 0) goto L_0x0041
                leakcanary.LeakUploader r8 = new leakcanary.LeakUploader
                r8.<init>()
                leakcanary.OnHeapAnalyzedListener r8 = (leakcanary.OnHeapAnalyzedListener) r8
                goto L_0x0043
            L_0x0041:
                r8 = r24
            L_0x0043:
                r9 = r0 & 64
                if (r9 == 0) goto L_0x004c
                shark.AndroidMetadataExtractor r9 = shark.AndroidMetadataExtractor.INSTANCE
                shark.MetadataExtractor r9 = (shark.MetadataExtractor) r9
                goto L_0x004e
            L_0x004c:
                r9 = r25
            L_0x004e:
                r10 = r0 & 128(0x80, float:1.794E-43)
                if (r10 == 0) goto L_0x0053
                goto L_0x0055
            L_0x0053:
                r2 = r26
            L_0x0055:
                r10 = r0 & 256(0x100, float:3.59E-43)
                if (r10 == 0) goto L_0x005b
                r10 = 7
                goto L_0x005d
            L_0x005b:
                r10 = r27
            L_0x005d:
                r11 = r0 & 512(0x200, float:7.175E-43)
                if (r11 == 0) goto L_0x0063
                r11 = 0
                goto L_0x0065
            L_0x0063:
                r11 = r28
            L_0x0065:
                r12 = r0 & 1024(0x400, float:1.435E-42)
                if (r12 == 0) goto L_0x006e
                shark.KeyedWeakReferenceFinder r12 = shark.KeyedWeakReferenceFinder.INSTANCE
                shark.LeakingObjectFinder r12 = (shark.LeakingObjectFinder) r12
                goto L_0x0070
            L_0x006e:
                r12 = r29
            L_0x0070:
                r13 = r0 & 2048(0x800, float:2.87E-42)
                if (r13 == 0) goto L_0x0076
                r13 = 0
                goto L_0x0078
            L_0x0076:
                r13 = r30
            L_0x0078:
                r14 = r0 & 4096(0x1000, float:5.74E-42)
                java.lang.String r15 = ""
                if (r14 == 0) goto L_0x0080
                r14 = r15
                goto L_0x0082
            L_0x0080:
                r14 = r31
            L_0x0082:
                r4 = r0 & 8192(0x2000, float:1.14794E-41)
                if (r4 == 0) goto L_0x0088
                r4 = r15
                goto L_0x008a
            L_0x0088:
                r4 = r32
            L_0x008a:
                r20 = r15
                r15 = r0 & 16384(0x4000, float:2.2959E-41)
                if (r15 == 0) goto L_0x0093
                r15 = r20
                goto L_0x0095
            L_0x0093:
                r15 = r33
            L_0x0095:
                r16 = 32768(0x8000, float:4.5918E-41)
                r16 = r0 & r16
                if (r16 == 0) goto L_0x00a1
                leakcanary.LeakCanary$Config$1 r16 = leakcanary.LeakCanary.Config.AnonymousClass1.INSTANCE
                leakcanary.ICustomInfoCollector r16 = (leakcanary.ICustomInfoCollector) r16
                goto L_0x00a3
            L_0x00a1:
                r16 = r34
            L_0x00a3:
                r17 = 65536(0x10000, float:9.18355E-41)
                r0 = r0 & r17
                if (r0 == 0) goto L_0x00ab
                r0 = 0
                goto L_0x00ad
            L_0x00ab:
                r0 = r35
            L_0x00ad:
                r19 = r1
                r20 = r3
                r21 = r5
                r22 = r6
                r23 = r7
                r24 = r8
                r25 = r9
                r26 = r2
                r27 = r10
                r28 = r11
                r29 = r12
                r30 = r13
                r31 = r14
                r32 = r4
                r33 = r15
                r34 = r16
                r35 = r0
                r18.<init>(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: leakcanary.LeakCanary.Config.<init>(boolean, boolean, int, java.util.List, java.util.List, leakcanary.OnHeapAnalyzedListener, shark.MetadataExtractor, boolean, int, boolean, shark.LeakingObjectFinder, boolean, java.lang.String, java.lang.String, java.lang.String, leakcanary.ICustomInfoCollector, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public final boolean getDumpHeap() {
            return this.dumpHeap;
        }

        public final boolean getDumpHeapWhenDebugging() {
            return this.dumpHeapWhenDebugging;
        }

        public final int getRetainedVisibleThreshold() {
            return this.retainedVisibleThreshold;
        }

        public final List<ReferenceMatcher> getReferenceMatchers() {
            return this.referenceMatchers;
        }

        public final List<ObjectInspector> getObjectInspectors() {
            return this.objectInspectors;
        }

        public final OnHeapAnalyzedListener getOnHeapAnalyzedListener() {
            return this.onHeapAnalyzedListener;
        }

        public final MetadataExtractor getMetadataExtractor() {
            return this.metadataExtractor;
        }

        public final boolean getComputeRetainedHeapSize() {
            return this.computeRetainedHeapSize;
        }

        public final int getMaxStoredHeapDumps() {
            return this.maxStoredHeapDumps;
        }

        public final boolean getRequestWriteExternalStoragePermission() {
            return this.requestWriteExternalStoragePermission;
        }

        public final LeakingObjectFinder getLeakingObjectFinder() {
            return this.leakingObjectFinder;
        }

        public final boolean getUseExperimentalLeakFinders() {
            return this.useExperimentalLeakFinders;
        }

        public final String getDeviceCUID() {
            return this.deviceCUID;
        }

        public final String getPackageBranch() {
            return this.packageBranch;
        }

        public final String getPackageCommitID() {
            return this.packageCommitID;
        }

        public final ICustomInfoCollector getCustomInfoCollector() {
            return this.customInfoCollector;
        }

        public final boolean getUsingForkMode() {
            return this.usingForkMode;
        }

        public final void setUsingForkMode(boolean z) {
            this.usingForkMode = z;
        }

        public final Builder newBuilder() {
            return new Builder(this);
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u001f\u001a\u00020\u0003J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0006J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0012J\u0014\u0010\u0013\u001a\u00020\u00002\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\nJ\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\nJ\u0014\u0010\u001a\u001a\u00020\u00002\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0014J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0006J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0010J\u000e\u0010 \u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lleakcanary/LeakCanary$Config$Builder;", "", "config", "Lleakcanary/LeakCanary$Config;", "(Lleakcanary/LeakCanary$Config;)V", "computeRetainedHeapSize", "", "customInfoCollector", "Lleakcanary/ICustomInfoCollector;", "deviceCUID", "", "dumpHeap", "dumpHeapWhenDebugging", "leakingObjectFinder", "Lshark/LeakingObjectFinder;", "maxStoredHeapDumps", "", "metadataExtractor", "Lshark/MetadataExtractor;", "objectInspectors", "", "Lshark/ObjectInspector;", "onHeapAnalyzedListener", "Lleakcanary/OnHeapAnalyzedListener;", "packageBranch", "packageCommitID", "referenceMatchers", "Lshark/ReferenceMatcher;", "requestWriteExternalStoragePermission", "retainedVisibleThreshold", "usingForkMode", "build", "setCustomInfoCollector", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
        /* compiled from: LeakCanary.kt */
        public static final class Builder {
            private boolean computeRetainedHeapSize;
            private ICustomInfoCollector customInfoCollector;
            private String deviceCUID;
            private boolean dumpHeap;
            private boolean dumpHeapWhenDebugging;
            private LeakingObjectFinder leakingObjectFinder;
            private int maxStoredHeapDumps;
            private MetadataExtractor metadataExtractor;
            private List<? extends ObjectInspector> objectInspectors;
            private OnHeapAnalyzedListener onHeapAnalyzedListener;
            private String packageBranch;
            private String packageCommitID;
            private List<? extends ReferenceMatcher> referenceMatchers;
            private boolean requestWriteExternalStoragePermission;
            private int retainedVisibleThreshold;
            private boolean usingForkMode;

            public Builder(Config config) {
                Intrinsics.checkParameterIsNotNull(config, "config");
                this.dumpHeap = config.getDumpHeap();
                this.dumpHeapWhenDebugging = config.getDumpHeapWhenDebugging();
                this.retainedVisibleThreshold = config.getRetainedVisibleThreshold();
                this.referenceMatchers = config.getReferenceMatchers();
                this.objectInspectors = config.getObjectInspectors();
                this.onHeapAnalyzedListener = config.getOnHeapAnalyzedListener();
                this.metadataExtractor = config.getMetadataExtractor();
                this.computeRetainedHeapSize = config.getComputeRetainedHeapSize();
                this.maxStoredHeapDumps = config.getMaxStoredHeapDumps();
                this.requestWriteExternalStoragePermission = config.getRequestWriteExternalStoragePermission();
                this.leakingObjectFinder = config.getLeakingObjectFinder();
                this.deviceCUID = config.getDeviceCUID();
                this.packageBranch = config.getPackageBranch();
                this.packageCommitID = config.getPackageCommitID();
                this.customInfoCollector = config.getCustomInfoCollector();
                this.usingForkMode = config.getUsingForkMode();
            }

            public final Builder dumpHeap(boolean dumpHeap2) {
                this.dumpHeap = dumpHeap2;
                return this;
            }

            public final Builder dumpHeapWhenDebugging(boolean dumpHeapWhenDebugging2) {
                this.dumpHeapWhenDebugging = dumpHeapWhenDebugging2;
                return this;
            }

            public final Builder retainedVisibleThreshold(int retainedVisibleThreshold2) {
                this.retainedVisibleThreshold = retainedVisibleThreshold2;
                return this;
            }

            public final Builder referenceMatchers(List<? extends ReferenceMatcher> referenceMatchers2) {
                Intrinsics.checkParameterIsNotNull(referenceMatchers2, "referenceMatchers");
                this.referenceMatchers = referenceMatchers2;
                return this;
            }

            public final Builder objectInspectors(List<? extends ObjectInspector> objectInspectors2) {
                Intrinsics.checkParameterIsNotNull(objectInspectors2, "objectInspectors");
                this.objectInspectors = objectInspectors2;
                return this;
            }

            public final Builder onHeapAnalyzedListener(OnHeapAnalyzedListener onHeapAnalyzedListener2) {
                Intrinsics.checkParameterIsNotNull(onHeapAnalyzedListener2, "onHeapAnalyzedListener");
                this.onHeapAnalyzedListener = onHeapAnalyzedListener2;
                return this;
            }

            public final Builder metadataExtractor(MetadataExtractor metadataExtractor2) {
                Intrinsics.checkParameterIsNotNull(metadataExtractor2, "metadataExtractor");
                this.metadataExtractor = metadataExtractor2;
                return this;
            }

            public final Builder computeRetainedHeapSize(boolean computeRetainedHeapSize2) {
                this.computeRetainedHeapSize = computeRetainedHeapSize2;
                return this;
            }

            public final Builder maxStoredHeapDumps(int maxStoredHeapDumps2) {
                this.maxStoredHeapDumps = maxStoredHeapDumps2;
                return this;
            }

            public final Builder requestWriteExternalStoragePermission(boolean requestWriteExternalStoragePermission2) {
                this.requestWriteExternalStoragePermission = requestWriteExternalStoragePermission2;
                return this;
            }

            public final Builder leakingObjectFinder(LeakingObjectFinder leakingObjectFinder2) {
                Intrinsics.checkParameterIsNotNull(leakingObjectFinder2, "leakingObjectFinder");
                this.leakingObjectFinder = leakingObjectFinder2;
                return this;
            }

            public final Builder deviceCUID(String deviceCUID2) {
                Intrinsics.checkParameterIsNotNull(deviceCUID2, "deviceCUID");
                this.deviceCUID = deviceCUID2;
                return this;
            }

            public final Builder packageBranch(String packageBranch2) {
                Intrinsics.checkParameterIsNotNull(packageBranch2, "packageBranch");
                this.packageBranch = packageBranch2;
                return this;
            }

            public final Builder packageCommitID(String packageCommitID2) {
                Intrinsics.checkParameterIsNotNull(packageCommitID2, "packageCommitID");
                this.packageCommitID = packageCommitID2;
                return this;
            }

            public final Builder setCustomInfoCollector(ICustomInfoCollector customInfoCollector2) {
                Intrinsics.checkParameterIsNotNull(customInfoCollector2, "customInfoCollector");
                this.customInfoCollector = customInfoCollector2;
                return this;
            }

            public final Config build() {
                return Config.copy$default(LeakCanary.getConfig(), this.dumpHeap, this.dumpHeapWhenDebugging, this.retainedVisibleThreshold, this.referenceMatchers, this.objectInspectors, this.onHeapAnalyzedListener, this.metadataExtractor, this.computeRetainedHeapSize, this.maxStoredHeapDumps, this.requestWriteExternalStoragePermission, this.leakingObjectFinder, false, this.deviceCUID, this.packageBranch, this.packageCommitID, this.customInfoCollector, this.usingForkMode, 2048, (Object) null);
            }
        }
    }

    public static final Config getConfig() {
        return config;
    }

    public static final void setConfig(Config newConfig) {
        Intrinsics.checkParameterIsNotNull(newConfig, "newConfig");
        Config previousConfig = config;
        config = newConfig;
        INSTANCE.logConfigChange(previousConfig, newConfig);
        HeapDumpControl.INSTANCE.updateICanHasHeap();
    }

    private final void logConfigChange(Config previousConfig, Config newConfig) {
        int i2;
        int $i$f$d;
        SharkLog this_$iv;
        SharkLog this_$iv2 = SharkLog.INSTANCE;
        int $i$f$d2 = false;
        SharkLog.Logger logger$iv = this_$iv2.getLogger();
        if (logger$iv != null) {
            int i3 = false;
            List changedFields = new ArrayList();
            Field[] declaredFields = Config.class.getDeclaredFields();
            Intrinsics.checkExpressionValueIsNotNull(declaredFields, "Config::class.java.declaredFields");
            int length = declaredFields.length;
            int i4 = 0;
            while (i4 < length) {
                Field field = declaredFields[i4];
                Intrinsics.checkExpressionValueIsNotNull(field, "field");
                field.setAccessible(true);
                Object previousValue = field.get(previousConfig);
                Object newValue = field.get(newConfig);
                if (!Intrinsics.areEqual(previousValue, newValue)) {
                    this_$iv = this_$iv2;
                    $i$f$d = $i$f$d2;
                    i2 = i3;
                    changedFields.add(field.getName() + '=' + newValue);
                } else {
                    this_$iv = this_$iv2;
                    $i$f$d = $i$f$d2;
                    i2 = i3;
                }
                i4++;
                this_$iv2 = this_$iv;
                $i$f$d2 = $i$f$d;
                i3 = i2;
            }
            Config config2 = previousConfig;
            Config config3 = newConfig;
            SharkLog sharkLog = this_$iv2;
            int i5 = $i$f$d2;
            int i6 = i3;
            logger$iv.d("Updated LeakCanary.config: Config(" + (changedFields.isEmpty() ^ true ? CollectionsKt.joinToString$default(changedFields, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) : "no changes") + ')');
            return;
        }
        Config config4 = previousConfig;
        Config config5 = newConfig;
        SharkLog sharkLog2 = this_$iv2;
    }

    public final Intent newLeakDisplayActivityIntent() {
        return LeakActivity.Companion.createIntent(InternalLeakCanary.INSTANCE.getApplication());
    }

    public final void showLeakDisplayActivityLauncherIcon(boolean showLauncherIcon) {
        InternalLeakCanary.INSTANCE.setEnabledBlocking("leakcanary.internal.activity.LeakLauncherActivity", showLauncherIcon);
    }

    public final void dumpHeap() {
        InternalLeakCanary.INSTANCE.onDumpHeapReceived(true);
    }
}
