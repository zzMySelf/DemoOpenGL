package fe.mmm.qw.qqq.o;

import com.tera.scan.record.model.ScanRecordExportFile;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class rg {

    public static final class ad extends rg {

        /* renamed from: ad  reason: collision with root package name */
        public final int f8208ad;
        @NotNull
        public final ScanRecordExportFile qw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ad(@NotNull ScanRecordExportFile scanRecordExportFile, int i2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(scanRecordExportFile, "scanRecordExportFile");
            this.qw = scanRecordExportFile;
            this.f8208ad = i2;
        }

        @NotNull
        public final ScanRecordExportFile ad() {
            return this.qw;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ad)) {
                return false;
            }
            ad adVar = (ad) obj;
            return Intrinsics.areEqual((Object) this.qw, (Object) adVar.qw) && this.f8208ad == adVar.f8208ad;
        }

        public int hashCode() {
            return (this.qw.hashCode() * 31) + this.f8208ad;
        }

        public final int qw() {
            return this.f8208ad;
        }

        @NotNull
        public String toString() {
            return "SplitPdfSuccess(scanRecordExportFile=" + this.qw + ", pdfPageCount=" + this.f8208ad + ')';
        }
    }

    public static final class qw extends rg {
        public final int qw;

        public qw(int i2) {
            super((DefaultConstructorMarker) null);
            this.qw = i2;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof qw) && this.qw == ((qw) obj).qw;
        }

        public int hashCode() {
            return this.qw;
        }

        public final int qw() {
            return this.qw;
        }

        @NotNull
        public String toString() {
            return "SplitPdfFail(msgId=" + this.qw + ')';
        }
    }

    public rg() {
    }

    public /* synthetic */ rg(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
