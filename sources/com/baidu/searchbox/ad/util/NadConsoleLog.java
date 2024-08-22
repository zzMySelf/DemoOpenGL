package com.baidu.searchbox.ad.util;

import com.baidu.nadcore.tool.NadTool;
import com.baidu.nadcore.tool.NadToolConfig;
import com.baidu.nadcore.tool.builtin.ConsoleLogItemData;
import com.baidu.nadcore.tool.builtin.INadInfoBoard;
import com.baidu.poly.statistics.ActionDescription;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u001e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/ad/util/NadConsoleLog;", "", "()V", "collAdapt", "", "content", "", "collNextAd", "eShowDupUpgrade", "dupStrategy", "eShowDupUpgrade2", "strategy", "flowAdOpt3", "flowAdReqParams", "flowDelayReplace", "flowDelayReq", "print", "k1", "k2", "resetSortCountdown", "updateFlowListState", "lib-ad_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadConsoleLog.kt */
public final class NadConsoleLog {
    public static final NadConsoleLog INSTANCE = new NadConsoleLog();

    private NadConsoleLog() {
    }

    public final void print(String k1, String k2, String content) {
        INadInfoBoard iNadInfoBoard;
        Intrinsics.checkNotNullParameter(k1, "k1");
        Intrinsics.checkNotNullParameter(k2, "k2");
        Intrinsics.checkNotNullParameter(content, "content");
        if (NadToolConfig.GLOBAL_DEBUG && (iNadInfoBoard = (INadInfoBoard) NadTool.get().select(INadInfoBoard.class)) != null) {
            iNadInfoBoard.addConsoleLog(new ConsoleLogItemData(k1, k2, content));
        }
    }

    public final void resetSortCountdown(String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        print("即时重排", "倒计时", content);
    }

    public final void flowAdOpt3(String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        print("渲染优化", "三期", content);
    }

    public final void flowAdReqParams(String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        print("请求参数", ActionDescription.CASHIER_ACTION_RIGHT_DIALOG_SHOW, content);
    }

    public final void updateFlowListState(String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        print("短小融合", "列表状态更新", content);
    }

    public final void eShowDupUpgrade(String dupStrategy, String content) {
        Intrinsics.checkNotNullParameter(dupStrategy, "dupStrategy");
        Intrinsics.checkNotNullParameter(content, "content");
        print("频控升级", dupStrategy, content);
    }

    public final void collAdapt(String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        print("短剧", "adapt", content);
    }

    public final void eShowDupUpgrade2(String strategy, String content) {
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        Intrinsics.checkNotNullParameter(content, "content");
        print("频控2", strategy, content);
    }

    public final void flowDelayReq(String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        print("延迟请求", ActionDescription.CASHIER_ACTION_RIGHT_DIALOG_SHOW, content);
    }

    public final void collNextAd(String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        print("合集点击下一集出广告", ActionDescription.CASHIER_ACTION_RIGHT_DIALOG_SHOW, content);
    }

    public final void flowDelayReplace(String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        print("延迟替换", "", content);
    }
}
