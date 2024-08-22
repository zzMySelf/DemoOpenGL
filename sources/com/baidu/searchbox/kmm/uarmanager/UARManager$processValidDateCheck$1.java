package com.baidu.searchbox.kmm.uarmanager;

import com.baidu.searchbox.kmm.db.uarmanager.UARManagerDB;
import com.baidu.searchbox.kmm.db.uarmanager.Uar_recordQueries;
import com.baidu.searchbox.kmm.foundation.utils.KmmLog;
import com.baidu.searchbox.kmm.foundation.utils.datetime.Date;
import com.baidu.searchbox.kmm.foundation.utils.datetime.TimeUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: UARManager.kt */
final class UARManager$processValidDateCheck$1 extends Lambda implements Function0<Unit> {
    public static final UARManager$processValidDateCheck$1 INSTANCE = new UARManager$processValidDateCheck$1();

    UARManager$processValidDateCheck$1() {
        super(0);
    }

    public final void invoke() {
        Uar_recordQueries uar_recordQueries;
        long thirtyDayBeforeMs = Date.millis(Date.getDateWithoutTime(TimeUtils.getCurrentTimeStamp())) - 2592000000L;
        try {
            KmmLog.printLog("UARKMM", "processValidDateCheck invoke");
            UARManagerDB access$getDataBase = UARManager.INSTANCE.getDataBase();
            if (access$getDataBase != null && (uar_recordQueries = access$getDataBase.getUar_recordQueries()) != null) {
                uar_recordQueries.deleteAllSmallOrEqualThan(Long.valueOf(thirtyDayBeforeMs));
            }
        } catch (Exception e2) {
            UARManager.INSTANCE.printStackTrace(e2);
        }
    }
}
