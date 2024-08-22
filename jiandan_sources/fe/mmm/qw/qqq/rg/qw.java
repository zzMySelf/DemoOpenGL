package fe.mmm.qw.qqq.rg;

import com.tera.scan.record.model.ScanRecordExportFile;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class qw {

    /* renamed from: ad  reason: collision with root package name */
    public final int f8224ad;

    /* renamed from: de  reason: collision with root package name */
    public final boolean f8225de;
    @NotNull
    public final ScanRecordExportFile qw;

    public qw(@NotNull ScanRecordExportFile scanRecordExportFile, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(scanRecordExportFile, "scanRecordExportFile");
        this.qw = scanRecordExportFile;
        this.f8224ad = i2;
        this.f8225de = z;
    }

    @NotNull
    public final ScanRecordExportFile ad() {
        return this.qw;
    }

    public final boolean de() {
        return this.f8225de;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof qw)) {
            return false;
        }
        qw qwVar = (qw) obj;
        return Intrinsics.areEqual((Object) this.qw, (Object) qwVar.qw) && this.f8224ad == qwVar.f8224ad && this.f8225de == qwVar.f8225de;
    }

    public int hashCode() {
        int hashCode = ((this.qw.hashCode() * 31) + this.f8224ad) * 31;
        boolean z = this.f8225de;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public final int qw() {
        return this.f8224ad;
    }

    @NotNull
    public String toString() {
        return "MergePdfItemData(scanRecordExportFile=" + this.qw + ", pageCount=" + this.f8224ad + ", isEncryptDoc=" + this.f8225de + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ qw(ScanRecordExportFile scanRecordExportFile, int i2, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(scanRecordExportFile, i2, (i3 & 4) != 0 ? false : z);
    }
}
