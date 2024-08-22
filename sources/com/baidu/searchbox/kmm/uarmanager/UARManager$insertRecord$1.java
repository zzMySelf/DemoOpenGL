package com.baidu.searchbox.kmm.uarmanager;

import com.baidu.searchbox.kmm.foundation.utils.datetime.Date;
import com.baidu.searchbox.kmm.foundation.utils.datetime.TimeUtils;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: UARManager.kt */
final class UARManager$insertRecord$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $action;
    final /* synthetic */ String $businessType;
    final /* synthetic */ String $extJson;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UARManager$insertRecord$1(String str, String str2, String str3) {
        super(0);
        this.$action = str;
        this.$businessType = str2;
        this.$extJson = str3;
    }

    /* JADX INFO: finally extract failed */
    public final void invoke() {
        long current = Date.millis(Date.getDateWithoutTime(TimeUtils.getCurrentTimeStamp()));
        Pair key = new Pair(Long.valueOf(current), this.$action);
        UARManager.mLock.lock();
        try {
            Object record = UARManager.INSTANCE.getMUARecordCache().get(key);
            UARManager.mLock.unlock();
            UARecordData uARecordData = (UARecordData) record;
            if (!Intrinsics.areEqual((Object) uARecordData != null ? uARecordData.getBusinessType() : null, (Object) this.$businessType) || !Intrinsics.areEqual((Object) ((UARecordData) record).getAction(), (Object) this.$action)) {
                UARecordData uARecordData2 = new UARecordData((Long) null, this.$businessType, this.$action, current, 1, this.$extJson);
                UARManager.INSTANCE.insertRecordDB(uARecordData2);
                Long access$getRecordID = UARManager.INSTANCE.getRecordID(uARecordData2);
                if (access$getRecordID != null) {
                    uARecordData2.setId(Long.valueOf(access$getRecordID.longValue()));
                    UARecordData recordFinal = uARecordData2;
                    UARManager.mLock.lock();
                    try {
                        UARManager.INSTANCE.getMUARecordCache().put(key, recordFinal);
                    } finally {
                        UARManager.mLock.unlock();
                    }
                }
            } else {
                ((UARecordData) record).setCount(((UARecordData) record).getCount() + 1);
                UARecordData recordFinal2 = (UARecordData) record;
                UARManager.mLock.lock();
                try {
                    UARManager.INSTANCE.getMUARecordCache().put(key, recordFinal2);
                    UARManager.mLock.unlock();
                    UARManager.INSTANCE.updateRecordCount(((UARecordData) record).getId(), Long.valueOf(((UARecordData) record).getCount()));
                } catch (Throwable th2) {
                    UARManager.mLock.unlock();
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            UARManager.mLock.unlock();
            throw th3;
        }
    }
}
