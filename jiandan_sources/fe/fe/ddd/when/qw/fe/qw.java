package fe.fe.ddd.when.qw.fe;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.logsystem.logsys.eventscene.snapshot.DeviceSnapshotType;
import fe.fe.ddd.when.fe.i.ad.ad;
import java.util.HashSet;
import java.util.Set;

public class qw extends ad {
    @Nullable
    public Set<DeviceSnapshotType> ad(@NonNull Context context, @NonNull fe.fe.ddd.when.fe.i.qw qwVar) {
        HashSet hashSet = new HashSet(4);
        hashSet.add(DeviceSnapshotType.DEVICE_APP_LOGCAT);
        hashSet.add(DeviceSnapshotType.DEVICE_BUILD_PROC);
        hashSet.add(DeviceSnapshotType.DEVICE_INFO);
        hashSet.add(DeviceSnapshotType.DEVICE_LINUX_KERNEL_VERSION);
        return hashSet;
    }
}
