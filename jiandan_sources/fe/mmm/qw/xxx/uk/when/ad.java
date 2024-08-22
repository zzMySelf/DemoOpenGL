package fe.mmm.qw.xxx.uk.when;

import android.content.Context;
import com.baidu.aiscan.R;
import com.tera.scan.record.model.FileUploadStatus;
import com.tera.scan.record.model.ScanRecordExportFile;
import fe.mmm.qw.p030switch.rg.yj;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class ad {
    @NotNull
    public static final ScanRecordExportFile qw(@NotNull qw qwVar, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(qwVar, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        String qw = yj.qw();
        String qw2 = qwVar.qw();
        return new ScanRecordExportFile(qw, qw2, '/' + context.getResources().getString(R.string.document_scan_export_default_path) + '/' + qwVar.qw(), (String) null, (int) qwVar.ad(), System.currentTimeMillis() / ((long) 1000), qwVar.fe(), FileUploadStatus.LOCAL);
    }
}
