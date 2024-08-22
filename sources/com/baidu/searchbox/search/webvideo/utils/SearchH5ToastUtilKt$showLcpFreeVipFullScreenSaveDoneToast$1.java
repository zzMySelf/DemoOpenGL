package com.baidu.searchbox.search.webvideo.utils;

import com.baidu.searchbox.Router;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchH5ToastUtil.kt */
final class SearchH5ToastUtilKt$showLcpFreeVipFullScreenSaveDoneToast$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $fsid;
    final /* synthetic */ boolean $isRapid;
    final /* synthetic */ boolean $saveBefore;
    final /* synthetic */ String $savePath;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SearchH5ToastUtilKt$showLcpFreeVipFullScreenSaveDoneToast$1(String str, String str2, boolean z, boolean z2) {
        super(0);
        this.$savePath = str;
        this.$fsid = str2;
        this.$isRapid = z;
        this.$saveBefore = z2;
    }

    public final void invoke() {
        Router.invoke(BdBoxActivityManager.getTopActivity(), NetDiskAbUtils.getNetDiskGuideOpenScheme4Test(this.$savePath, this.$fsid));
        SearchH5VideoUbcUtils.lcbVideoStepCommonUbc(SearchH5VideoUbcUtils.STEP_LCB_WANGPAN_DOWNLOAD_PLAY);
        SearchH5VideoUbcUtils.addCompleteToastClick(this.$isRapid, this.$saveBefore, true);
    }
}
