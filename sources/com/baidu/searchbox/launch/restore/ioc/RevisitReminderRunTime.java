package com.baidu.searchbox.launch.restore.ioc;

import com.baidu.searchbox.introduction.revisit.HomeRevisitReminder_Factory;
import com.baidu.searchbox.launch.restore.interfaces.IRevisitReminder;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0007R\u0010\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/launch/restore/ioc/RevisitReminderRunTime;", "", "()V", "EMPTY", "com/baidu/searchbox/launch/restore/ioc/RevisitReminderRunTime$EMPTY$1", "Lcom/baidu/searchbox/launch/restore/ioc/RevisitReminderRunTime$EMPTY$1;", "getRevisitReminder", "Lcom/baidu/searchbox/launch/restore/interfaces/IRevisitReminder;", "lib-app-launch-restore-interfaces_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RevisitReminderRunTime.kt */
public final class RevisitReminderRunTime {
    private static final RevisitReminderRunTime$EMPTY$1 EMPTY = new RevisitReminderRunTime$EMPTY$1();
    public static final RevisitReminderRunTime INSTANCE = new RevisitReminderRunTime();

    private RevisitReminderRunTime() {
    }

    public final IRevisitReminder getRevisitReminder() {
        return HomeRevisitReminder_Factory.get();
    }
}
