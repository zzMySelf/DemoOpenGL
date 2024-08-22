package fe.fe.ddd.when.qw.fe;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.searchbox.logsystem.logsys.eventscene.snapshot.DeviceSnapshotType;
import fe.fe.ddd.when.fe.i.ad.ad;
import fe.fe.ddd.when.fe.i.qw;
import java.util.HashSet;
import java.util.Set;

public class yj extends ad {
    public Set<DeviceSnapshotType> ad(@NonNull Context context, @NonNull qw qwVar) {
        if (!qwVar.qw.contains("android.database.sqlite.SQLiteFullException")) {
            return null;
        }
        HashSet hashSet = new HashSet(1);
        hashSet.add(DeviceSnapshotType.DEVICE_APP_DB_INFO);
        return hashSet;
    }
}
