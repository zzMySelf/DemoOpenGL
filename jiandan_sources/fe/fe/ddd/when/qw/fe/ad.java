package fe.fe.ddd.when.qw.fe;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.logsystem.logsys.eventscene.snapshot.ProcessSnapshotType;
import fe.fe.ddd.when.fe.i.ad.rg;
import fe.fe.ddd.when.fe.i.qw;
import java.util.HashSet;
import java.util.Set;

public class ad extends rg {
    public static void fe() {
    }

    @Nullable
    public Set<ProcessSnapshotType> ad(@NonNull Context context, @NonNull qw qwVar) {
        HashSet hashSet = new HashSet(3);
        hashSet.add(ProcessSnapshotType.PROCESS_UI_TRACE);
        hashSet.add(ProcessSnapshotType.PROCESS_RUNNING_STATUS);
        hashSet.add(ProcessSnapshotType.PROCESS_STATUS);
        return hashSet;
    }
}
