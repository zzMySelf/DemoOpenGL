package fe.mmm.qw.rrr.de;

import android.database.Cursor;
import com.tera.scan.flutter.documentscan.OCRRectifyActivity;
import com.tera.scan.record.model.FileUploadStatus;
import com.tera.scan.record.model.ScanRecord;
import com.tera.scan.record.model.ScanRecordExportFile;
import com.tera.scan.record.model.ScanRecordFile;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class qw {
    @NotNull
    public static final ScanRecord ad(@NotNull Cursor cursor) {
        Cursor cursor2 = cursor;
        Intrinsics.checkNotNullParameter(cursor2, "<this>");
        return new ScanRecord(fe.mmm.qw.rrr.ad.qw.rg(cursor2, "name", ""), fe.mmm.qw.rrr.ad.qw.th(cursor2, "display_name"), fe.mmm.qw.rrr.ad.qw.rg(cursor2, "record_id", ""), fe.mmm.qw.rrr.ad.qw.de(cursor2, "m_time", 0), fe.mmm.qw.rrr.ad.qw.qw(cursor2, "category", 0), fe.mmm.qw.rrr.ad.qw.th(cursor2, OCRRectifyActivity.EXTRA_SAVE_PATH), fe.mmm.qw.rrr.ad.qw.de(cursor2, "c_time", 0), fe.mmm.qw.rrr.ad.qw.de(cursor2, "open_time", 0), (List) null, (String) null, 0, 1792, (DefaultConstructorMarker) null);
    }

    @NotNull
    public static final ScanRecordFile de(@NotNull Cursor cursor) {
        Intrinsics.checkNotNullParameter(cursor, "<this>");
        return new ScanRecordFile(fe.mmm.qw.rrr.ad.qw.rg(cursor, "record_id", ""), fe.mmm.qw.rrr.ad.qw.qw(cursor, "position", 0), fe.mmm.qw.rrr.ad.qw.th(cursor, "fsid"), fe.mmm.qw.rrr.ad.qw.th(cursor, "server_path"), fe.mmm.qw.rrr.ad.qw.th(cursor, "local_path"), fe.mmm.qw.rrr.ad.qw.qw(cursor, "size", 0), FileUploadStatus.values()[fe.mmm.qw.rrr.ad.qw.qw(cursor, "status", FileUploadStatus.LOCAL.ordinal())]);
    }

    @NotNull
    public static final ScanRecordExportFile qw(@NotNull Cursor cursor) {
        Intrinsics.checkNotNullParameter(cursor, "<this>");
        return new ScanRecordExportFile(fe.mmm.qw.rrr.ad.qw.rg(cursor, "record_id", ""), fe.mmm.qw.rrr.ad.qw.rg(cursor, "filename", ""), fe.mmm.qw.rrr.ad.qw.th(cursor, "server_path"), fe.mmm.qw.rrr.ad.qw.th(cursor, "fsid"), fe.mmm.qw.rrr.ad.qw.qw(cursor, "size", 0), fe.mmm.qw.rrr.ad.qw.de(cursor, "server_ctime", 0), fe.mmm.qw.rrr.ad.qw.th(cursor, "local_path"), FileUploadStatus.values()[fe.mmm.qw.rrr.ad.qw.qw(cursor, "status", FileUploadStatus.LOCAL.ordinal())]);
    }
}
