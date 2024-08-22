package com.baidu.searchbox.rewardsystem.tips;

import com.baidu.searchbox.rewardsystem.ubc.TipToastUBCStatisticsUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/rewardsystem/tips/IrregularTimerViewPageTypeHelper;", "", "()V", "currentHomePageType", "", "getCurrentHomePageType", "()Ljava/lang/String;", "setCurrentHomePageType", "(Ljava/lang/String;)V", "updateCurrentPageType", "", "pageType", "lib_bdptask_operation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IrregularTimerViewPageTypeHelper.kt */
public final class IrregularTimerViewPageTypeHelper {
    public static final IrregularTimerViewPageTypeHelper INSTANCE = new IrregularTimerViewPageTypeHelper();
    private static String currentHomePageType = TipToastUBCStatisticsUtils.PAGE_BAR_HOME;

    private IrregularTimerViewPageTypeHelper() {
    }

    public final String getCurrentHomePageType() {
        return currentHomePageType;
    }

    public final void setCurrentHomePageType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        currentHomePageType = str;
    }

    public final void updateCurrentPageType(String pageType) {
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        currentHomePageType = pageType;
    }
}
