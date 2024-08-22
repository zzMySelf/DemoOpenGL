package com.baidu.searchbox.music.statistic;

import android.util.Log;
import com.baidu.ubc.bussiness.SearchSessionObserver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016¨\u0006\b"}, d2 = {"com/baidu/searchbox/music/statistic/MusicDurationStat$registerSSessionChange$1", "Lcom/baidu/ubc/bussiness/SearchSessionObserver;", "onLidChanged", "", "lid", "", "onSSessionEnd", "onSSessionStart", "lib-music-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MusicDurationStat.kt */
public final class MusicDurationStat$registerSSessionChange$1 implements SearchSessionObserver {
    MusicDurationStat$registerSSessionChange$1() {
    }

    public void onSSessionStart() {
        synchronized (MusicDurationStat.INSTANCE) {
            if (MusicDurationStatKt.DEBUG) {
                Log.d("MusicDurationStat", "onSSessionStart");
            }
            if (!MusicDurationStat.isSSessionStarted) {
                String flowKey = MusicDurationStat.currentFlowKey;
                if (!Intrinsics.areEqual((Object) flowKey, (Object) "")) {
                    MusicDurationStat.INSTANCE.endFlow(flowKey);
                    MusicDurationStat.INSTANCE.beginFlow(flowKey);
                }
                MusicDurationStat musicDurationStat = MusicDurationStat.INSTANCE;
                MusicDurationStat.isSSessionStarted = true;
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public void onSSessionEnd() {
        synchronized (MusicDurationStat.INSTANCE) {
            if (MusicDurationStatKt.DEBUG) {
                Log.d("MusicDurationStat", "onSSessionEnd");
            }
            if (MusicDurationStat.isSSessionStarted) {
                String flowKey = MusicDurationStat.currentFlowKey;
                if (!Intrinsics.areEqual((Object) flowKey, (Object) "")) {
                    MusicDurationStat.INSTANCE.endFlow(flowKey);
                    MusicDurationStat.INSTANCE.beginFlow(flowKey);
                }
                MusicDurationStat musicDurationStat = MusicDurationStat.INSTANCE;
                MusicDurationStat.isSSessionStarted = false;
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public void onLidChanged(String lid) {
        boolean z;
        synchronized (MusicDurationStat.INSTANCE) {
            if (MusicDurationStatKt.DEBUG) {
                Log.d("MusicDurationStat", "onLidChanged: " + lid);
            }
            String flowKey = MusicDurationStat.currentFlowKey;
            boolean z2 = false;
            if (!Intrinsics.areEqual((Object) flowKey, (Object) "")) {
                CharSequence charSequence = lid;
                if (charSequence != null) {
                    if (charSequence.length() != 0) {
                        z = false;
                        if (!z && !Intrinsics.areEqual((Object) lid, (Object) MusicDurationStat.currentLid)) {
                            MusicDurationStat.INSTANCE.endFlow(flowKey);
                            MusicDurationStat.INSTANCE.beginFlow(flowKey);
                        }
                    }
                }
                z = true;
                MusicDurationStat.INSTANCE.endFlow(flowKey);
                MusicDurationStat.INSTANCE.beginFlow(flowKey);
            }
            CharSequence charSequence2 = lid;
            if (charSequence2 == null || charSequence2.length() == 0) {
                z2 = true;
            }
            if (!z2) {
                MusicDurationStat musicDurationStat = MusicDurationStat.INSTANCE;
                MusicDurationStat.currentLid = lid;
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
