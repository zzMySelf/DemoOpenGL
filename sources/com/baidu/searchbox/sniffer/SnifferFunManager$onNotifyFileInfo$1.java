package com.baidu.searchbox.sniffer;

import com.baidu.searchbox.browserenhanceengine.container.ScreenShotLogStatistics;
import com.baidu.searchbox.containers.nps.netdisk.face.data.NetdiskRestFileInfo;
import com.baidu.searchbox.sniffer.utils.SnifferDetectUtilsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", "result", "", "Lcom/baidu/searchbox/containers/nps/netdisk/face/data/NetdiskRestFileInfo;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SnifferFunManager.kt */
final class SnifferFunManager$onNotifyFileInfo$1 extends Lambda implements Function3<Integer, String, List<? extends NetdiskRestFileInfo>, Unit> {
    final /* synthetic */ String $currentUrl;
    final /* synthetic */ SnifferData $snifferData;
    final /* synthetic */ SnifferFunManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SnifferFunManager$onNotifyFileInfo$1(SnifferData snifferData, SnifferFunManager snifferFunManager, String str) {
        super(3);
        this.$snifferData = snifferData;
        this.this$0 = snifferFunManager;
        this.$currentUrl = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        invoke(((Number) p1).intValue(), (String) p2, (List<NetdiskRestFileInfo>) (List) p3);
        return Unit.INSTANCE;
    }

    public final void invoke(int i2, String str, List<NetdiskRestFileInfo> result) {
        if (result != null) {
            SnifferFunManager snifferFunManager = this.this$0;
            String str2 = this.$currentUrl;
            SnifferData snifferData = this.$snifferData;
            for (NetdiskRestFileInfo it : result) {
                Intrinsics.checkNotNullExpressionValue(str2, ScreenShotLogStatistics.KEY_CURURL);
                SnifferSourceInfo snifferSource = snifferFunManager.transNetdiskRestFileToSnifferSource(it, str2);
                if (snifferSource != null) {
                    snifferData.getSnifferSourceList().add(snifferSource);
                }
            }
        }
        if (this.$snifferData.getSnifferSourceList().size() != 0) {
            SnifferDetectUtilsKt.onDetectSource(this.$snifferData);
        }
    }
}
