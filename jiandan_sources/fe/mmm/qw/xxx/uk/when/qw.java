package fe.mmm.qw.xxx.uk.when;

import java.io.File;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class qw {

    /* renamed from: ad  reason: collision with root package name */
    public boolean f8672ad;
    @NotNull
    public final File qw;

    public qw(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        this.qw = file;
    }

    public final long ad() {
        return this.qw.length();
    }

    public final long de() {
        return this.qw.lastModified();
    }

    @NotNull
    public final String fe() {
        String absolutePath = this.qw.getAbsolutePath();
        return absolutePath == null ? "" : absolutePath;
    }

    @NotNull
    public final String qw() {
        String name = this.qw.getName();
        Intrinsics.checkNotNullExpressionValue(name, "file.name");
        return name;
    }

    public final boolean rg() {
        return this.f8672ad;
    }

    public final void th(boolean z) {
        this.f8672ad = z;
    }
}
