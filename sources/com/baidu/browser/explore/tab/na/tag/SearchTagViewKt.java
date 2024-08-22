package com.baidu.browser.explore.tab.na.tag;

import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.browser.R;
import com.baidu.search.basic.utils.ResultPageABTest;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.FontSizeHelper;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001¨\u0006\u0002"}, d2 = {"tagHeight", "", "lib-browser_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchTagView.kt */
public final class SearchTagViewKt {
    public static final int tagHeight() {
        if (ResultPageABTest.isIntergenerational()) {
            return ((int) FontSizeHelper.getScaledSizeRes(3, R.dimen.dimens_12dp)) + DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), 19.0f);
        }
        return ((int) FontSizeHelper.getScaledSizeRes(3, R.dimen.dimens_12dp)) + DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), 28.0f);
    }
}
