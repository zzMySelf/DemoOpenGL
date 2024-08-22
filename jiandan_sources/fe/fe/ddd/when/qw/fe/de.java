package fe.fe.ddd.when.qw.fe;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.logsystem.logsys.eventscene.snapshot.DeviceSnapshotType;
import fe.fe.ddd.when.fe.i.ad.ad;
import fe.fe.ddd.when.fe.i.qw;
import java.util.HashSet;
import java.util.Set;

public class de extends ad {
    @Nullable
    public Set<DeviceSnapshotType> ad(@NonNull Context context, @NonNull qw qwVar) {
        if (!qwVar.qw.contains("java.lang.OutOfMemoryError")) {
            return null;
        }
        HashSet hashSet = new HashSet(1);
        hashSet.add(DeviceSnapshotType.DEVICE_APP_DB_INFO);
        if (!qwVar.qw.contains("EGL_BAD_ALLOC")) {
            return hashSet;
        }
        hashSet.add(DeviceSnapshotType.DEVICE_GUP_MEM);
        hashSet.add(DeviceSnapshotType.DEVICE_ION_MEM);
        return hashSet;
    }
}
