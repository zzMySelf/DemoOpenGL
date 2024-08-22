package com.baidu.netdisk.trade.privilege;

import com.tera.scan.framework.kernel.architecture.ui.OldBaseActivity;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0001\u0018\u00002\u00020\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/baidu/netdisk/trade/privilege/MemberProduct;", "Ljava/lang/Enum;", "", "cluster", "Ljava/lang/String;", "getCluster", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "VIDEO_AUDIO_CARD", "BACKUP_PACKAGE", "WORK_PACKAGE", "AUDIO_VISUAL_PACKAGE", "PAY_LATER", "VIP", "NEW_VIP", "SCAN_VIP", "SVIP", "TradeMemberPrivilege_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public enum MemberProduct {
    VIDEO_AUDIO_CARD("privilegecard_audio_video"),
    BACKUP_PACKAGE("privilegecard_life"),
    WORK_PACKAGE("privilegecard_work"),
    AUDIO_VISUAL_PACKAGE("privilegecard_audio_visual"),
    PAY_LATER("pay_after_use"),
    VIP(OldBaseActivity.VIP_SERVICE),
    NEW_VIP("vipv2"),
    SCAN_VIP("scan_vip"),
    SVIP("svip");
    
    @NotNull
    public final String cluster;

    /* access modifiers changed from: public */
    MemberProduct(String str) {
        this.cluster = str;
    }

    @NotNull
    public final String getCluster() {
        return this.cluster;
    }
}
