package fe.fe.ddd.when.qw.fe;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.logsystem.logsys.eventscene.snapshot.ProcessSnapshotType;
import fe.fe.ddd.when.fe.i.qw;
import java.util.HashSet;
import java.util.Set;

public class uk extends fe {
    @Nullable
    public Set<ProcessSnapshotType> ad(@NonNull Context context, @NonNull qw qwVar) {
        String str = qwVar.qw;
        if ((!str.contains("java.lang.OutOfMemoryError") || !str.contains("pthread_create")) && !str.contains("android.database.CursorWindowAllocationException: Cursor window allocation")) {
            return null;
        }
        Set<ProcessSnapshotType> ad2 = super.ad(context, qwVar);
        if (ad2 == null) {
            ad2 = new HashSet<>(4);
        }
        ad2.add(ProcessSnapshotType.PROCESS_SMAPS);
        ad2.add(ProcessSnapshotType.PROCESS_MAPS);
        ad2.add(ProcessSnapshotType.PROCESS_THREAD_LIST);
        ad2.add(ProcessSnapshotType.PROCESS_FILE_DESCRIPTOR);
        return ad2;
    }
}
