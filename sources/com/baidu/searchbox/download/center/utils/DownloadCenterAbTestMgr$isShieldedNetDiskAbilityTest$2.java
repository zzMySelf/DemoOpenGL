package com.baidu.searchbox.download.center.utils;

import com.baidu.searchbox.abtest.AbTestManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: DownloadCenterAbTestMgr.kt */
final class DownloadCenterAbTestMgr$isShieldedNetDiskAbilityTest$2 extends Lambda implements Function0<Integer> {
    public static final DownloadCenterAbTestMgr$isShieldedNetDiskAbilityTest$2 INSTANCE = new DownloadCenterAbTestMgr$isShieldedNetDiskAbilityTest$2();

    DownloadCenterAbTestMgr$isShieldedNetDiskAbilityTest$2() {
        super(0);
    }

    public final Integer invoke() {
        return Integer.valueOf(AbTestManager.getInstance().getSwitch("basic_wangpan_inversion_switch", 0));
    }
}
