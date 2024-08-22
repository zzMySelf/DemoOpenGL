package com.baidu.talos.core.devsupport.performance.cpu.procfs;

import com.baidu.talos.core.devsupport.performance.cpu.Pseudo;
import com.baidu.talos.core.devsupport.performance.cpu.data.ProcStatSummary;
import com.baidu.talos.core.devsupport.performance.cpu.util.ProcPseudoUtil;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00038FX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/baidu/talos/core/devsupport/performance/cpu/procfs/ProcPseudo;", "Lcom/baidu/talos/core/devsupport/performance/cpu/Pseudo;", "procPseudoDir", "Ljava/io/File;", "(Ljava/io/File;)V", "statFile", "getStatFile", "()Ljava/io/File;", "statFile$delegate", "Lkotlin/Lazy;", "readProcStatSummary", "Lcom/baidu/talos/core/devsupport/performance/cpu/data/ProcStatSummary;", "Companion", "lib-talos-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ProcPseudo.kt */
public final class ProcPseudo implements Pseudo {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Lazy<ProcPseudo> myMainThreadProcPseudo$delegate = LazyKt.lazy(ProcPseudo$Companion$myMainThreadProcPseudo$2.INSTANCE);
    /* access modifiers changed from: private */
    public static final Lazy<ProcPseudo> myProcPseudo$delegate = LazyKt.lazy(ProcPseudo$Companion$myProcPseudo$2.INSTANCE);
    /* access modifiers changed from: private */
    public final File procPseudoDir;
    private final Lazy statFile$delegate = LazyKt.lazy(new ProcPseudo$statFile$2(this));

    @JvmStatic
    public static final ProcPseudo create(File file) {
        return Companion.create(file);
    }

    @JvmStatic
    public static final ProcPseudo myMainThreadTaskPseudo() {
        return Companion.myMainThreadTaskPseudo();
    }

    @JvmStatic
    public static final ProcPseudo myProcPseudo() {
        return Companion.myProcPseudo();
    }

    public ProcPseudo(File procPseudoDir2) {
        Intrinsics.checkNotNullParameter(procPseudoDir2, "procPseudoDir");
        this.procPseudoDir = procPseudoDir2;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0007J\b\u0010\u000f\u001a\u00020\u0004H\u0007J\b\u0010\t\u001a\u00020\u0004H\u0007R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/baidu/talos/core/devsupport/performance/cpu/procfs/ProcPseudo$Companion;", "", "()V", "myMainThreadProcPseudo", "Lcom/baidu/talos/core/devsupport/performance/cpu/procfs/ProcPseudo;", "getMyMainThreadProcPseudo", "()Lcom/baidu/talos/core/devsupport/performance/cpu/procfs/ProcPseudo;", "myMainThreadProcPseudo$delegate", "Lkotlin/Lazy;", "myProcPseudo", "getMyProcPseudo", "myProcPseudo$delegate", "create", "path", "Ljava/io/File;", "myMainThreadTaskPseudo", "lib-talos-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ProcPseudo.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ProcPseudo create(File path) {
            Intrinsics.checkNotNullParameter(path, "path");
            return new ProcPseudo(path);
        }

        private final ProcPseudo getMyProcPseudo() {
            return (ProcPseudo) ProcPseudo.myProcPseudo$delegate.getValue();
        }

        private final ProcPseudo getMyMainThreadProcPseudo() {
            return (ProcPseudo) ProcPseudo.myMainThreadProcPseudo$delegate.getValue();
        }

        @JvmStatic
        public final ProcPseudo myProcPseudo() {
            return getMyProcPseudo();
        }

        @JvmStatic
        public final ProcPseudo myMainThreadTaskPseudo() {
            return getMyMainThreadProcPseudo();
        }
    }

    public final File getStatFile() {
        return (File) this.statFile$delegate.getValue();
    }

    public final ProcStatSummary readProcStatSummary() {
        return ProcPseudoUtil.Companion.readProcStatSummary(getStatFile());
    }
}
