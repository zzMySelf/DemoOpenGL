package fe.mmm.qw.p024if.pf.i;

import java.io.File;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* renamed from: fe.mmm.qw.if.pf.i.ad  reason: invalid package */
public final class ad {
    @Nullable
    public File qw;

    public ad(@Nullable File file) {
        this.qw = file;
    }

    public final void ad(@Nullable File file) {
        this.qw = file;
    }

    @Nullable
    public final File qw() {
        return this.qw;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ad(File file, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : file);
    }
}
