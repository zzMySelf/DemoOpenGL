package fe.fe.ddd.when.fe.i.ad;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.logsystem.logsys.eventscene.handler.EventSceneHandler;
import com.baidu.searchbox.logsystem.logsys.eventscene.snapshot.DeviceSnapshotType;
import fe.fe.ddd.when.fe.fe;
import fe.fe.ddd.when.fe.i.qw;
import fe.fe.ddd.when.yj.ad;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class de extends ad {
    public final List<ad> qw = new LinkedList();

    @Nullable
    public Set<DeviceSnapshotType> ad(@NonNull Context context, @NonNull qw qwVar) {
        HashSet hashSet = null;
        for (ad next : this.qw) {
            if (next != null) {
                try {
                    Set<DeviceSnapshotType> ad2 = next.ad(context, qwVar);
                    if (ad2 != null && ad2.size() > 0) {
                        if (hashSet == null) {
                            hashSet = new HashSet(5);
                        }
                        hashSet.addAll(ad2);
                    }
                } catch (Exception e) {
                    if (ad.qw) {
                        Log.getStackTraceString(e);
                    }
                }
            }
        }
        return hashSet;
    }

    public boolean de(@NonNull Context context, @NonNull qw qwVar, @NonNull File file) {
        Iterator<ad> it = this.qw.iterator();
        while (true) {
            boolean z = false;
            while (true) {
                if (!it.hasNext()) {
                    return z;
                }
                ad next = it.next();
                if (next != null) {
                    try {
                        boolean de2 = next.de(context, qwVar, file);
                        if (z || de2) {
                            z = true;
                        }
                    } catch (Exception e) {
                        if (ad.qw) {
                            Log.getStackTraceString(e);
                        }
                    }
                }
            }
        }
    }

    public de fe(@NonNull ad adVar) {
        if (adVar != null) {
            this.qw.add(adVar);
        } else {
            boolean z = ad.qw;
        }
        return this;
    }

    @Nullable
    public Set<fe> qw(@NonNull Context context, @NonNull File file, @NonNull qw qwVar) {
        if (context == null) {
            boolean z = ad.qw;
        }
        HashSet hashSet = null;
        for (EventSceneHandler next : this.qw) {
            if (next != null) {
                try {
                    Set<fe> qw2 = next.qw(context, file, qwVar);
                    if (qw2 != null && qw2.size() > 0) {
                        if (hashSet == null) {
                            hashSet = new HashSet(qw2.size());
                        }
                        hashSet.addAll(qw2);
                    }
                } catch (Exception e) {
                    if (ad.qw) {
                        Log.getStackTraceString(e);
                    }
                }
            }
        }
        return hashSet;
    }
}
