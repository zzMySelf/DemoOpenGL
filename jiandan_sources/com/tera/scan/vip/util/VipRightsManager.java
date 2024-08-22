package com.tera.scan.vip.util;

import com.baidu.netdisk.trade.privilege.TradeAccount;
import com.baidu.netdisk.trade.privilege.io.model.Privilege;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import com.tera.scan.vip.model.PrivilegeType;
import fe.mmm.qw.yj.th;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JL\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062:\b\u0002\u0010\u0007\u001a4\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bJ\u0010\u0010\u000f\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0010\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0011\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H\u0002J\u0010\u0010\u0014\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0015"}, d2 = {"Lcom/tera/scan/vip/util/VipRightsManager;", "", "()V", "consumeOnceUsePrivilege", "", "type", "", "onResult", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "success", "", "freeCount", "defaultPrivilegeFreeCount", "getRightsMaxCount", "isPrivilegeEnable", "privilegeFreeCountCacheKey", "privilegeType", "queryRemaindUsePrivilege", "lib_vip_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Tag("VipRightsManager")
public final class VipRightsManager {
    @NotNull
    public static final VipRightsManager qw = new VipRightsManager();

    public final void ad(@Nullable String str, @Nullable Function2<? super Boolean, ? super Integer, Unit> function2) {
        if (str != null) {
            TradeAccount.f913rg.de(str, (String) null, new VipRightsManager$consumeOnceUsePrivilege$1$1(function2, str, str));
        }
    }

    public final int de(@Nullable String str) {
        PrivilegeType privilegeType;
        if (str == null) {
            return 0;
        }
        PrivilegeType[] values = PrivilegeType.values();
        int length = values.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                privilegeType = null;
                break;
            }
            privilegeType = values[i2];
            if (Intrinsics.areEqual((Object) privilegeType.getValue(), (Object) str)) {
                break;
            }
            i2++;
        }
        int defaultFreeCount = privilegeType != null ? privilegeType.getDefaultFreeCount() : 0;
        int rg2 = th.ppp().rg(fe(str), defaultFreeCount);
        LoggerKt.d$default("返回默认次数，defaultCount=" + defaultFreeCount + " cacheCount=" + rg2, (Object) null, 1, (Object) null);
        return RangesKt___RangesKt.coerceAtLeast(0, rg2);
    }

    public final String fe(String str) {
        return str + "_privilege_free_count";
    }

    public final int rg(@Nullable String str) {
        if (str != null) {
            Privilege yj2 = TradeAccount.f913rg.yj(str);
            Integer valueOf = yj2 != null ? Integer.valueOf(yj2.getFreeCount()) : null;
            if (valueOf != null) {
                return valueOf.intValue();
            }
        }
        return -1;
    }
}
