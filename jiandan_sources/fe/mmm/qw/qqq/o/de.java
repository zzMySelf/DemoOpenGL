package fe.mmm.qw.qqq.o;

import com.tera.scan.record.model.ScanRecordExportFile;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class de {

    public static final class ad extends de {
        @NotNull
        public final ScanRecordExportFile qw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ad(@NotNull ScanRecordExportFile scanRecordExportFile) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(scanRecordExportFile, "scanRecordExportFile");
            this.qw = scanRecordExportFile;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ad) && Intrinsics.areEqual((Object) this.qw, (Object) ((ad) obj).qw);
        }

        public int hashCode() {
            return this.qw.hashCode();
        }

        @NotNull
        public final ScanRecordExportFile qw() {
            return this.qw;
        }

        @NotNull
        public String toString() {
            return "CreatePdfSuccess(scanRecordExportFile=" + this.qw + ')';
        }
    }

    public static final class qw extends de {
        @Nullable
        public final Integer qw;

        public qw() {
            this((Integer) null, 1, (DefaultConstructorMarker) null);
        }

        public qw(@Nullable Integer num) {
            super((DefaultConstructorMarker) null);
            this.qw = num;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof qw) && Intrinsics.areEqual((Object) this.qw, (Object) ((qw) obj).qw);
        }

        public int hashCode() {
            Integer num = this.qw;
            if (num == null) {
                return 0;
            }
            return num.hashCode();
        }

        @NotNull
        public String toString() {
            return "CreatePdfFail(msgId=" + this.qw + ')';
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ qw(Integer num, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? null : num);
        }
    }

    public de() {
    }

    public /* synthetic */ de(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
