package fe.fe.ddd.when.qw.fe;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.logsystem.logsys.eventscene.snapshot.ProcessSnapshotType;
import fe.fe.ddd.when.fe.i.ad.rg;
import fe.fe.ddd.when.fe.i.qw;
import java.util.HashSet;
import java.util.Set;

public class fe extends rg {
    @Nullable
    public Set<ProcessSnapshotType> ad(@NonNull Context context, @NonNull qw qwVar) {
        if (!qwVar.qw.contains("java.lang.OutOfMemoryError")) {
            return null;
        }
        HashSet hashSet = new HashSet(1);
        hashSet.add(ProcessSnapshotType.PROCESS_MEMORY_STATUS);
        return hashSet;
    }
}
