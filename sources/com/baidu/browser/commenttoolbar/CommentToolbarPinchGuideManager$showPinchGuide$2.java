package com.baidu.browser.commenttoolbar;

import android.util.Log;
import com.baidu.android.ext.manage.PopFinalCheck;
import com.baidu.browser.explore.mutable.IMutableContainerCallback;
import com.baidu.browser.utils.SearchPinchUtilsKt;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.search.core.utils.BrowserUrlUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.pinchsummary.interfaces.IPinchSummaryService;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/baidu/browser/commenttoolbar/CommentToolbarPinchGuideManager$showPinchGuide$2", "Lcom/baidu/android/ext/manage/PopFinalCheck;", "mutexFinalCheck", "", "lib-browser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommentToolbarPinchGuideManager.kt */
public final class CommentToolbarPinchGuideManager$showPinchGuide$2 implements PopFinalCheck {
    final /* synthetic */ IMutableContainerCallback $containerCallBack;

    CommentToolbarPinchGuideManager$showPinchGuide$2(IMutableContainerCallback $containerCallBack2) {
        this.$containerCallBack = $containerCallBack2;
    }

    public boolean mutexFinalCheck() {
        boolean isResultPage = BrowserUrlUtils.checkSearchResultUrl(this.$containerCallBack.getCurrentUrl());
        boolean isCurrentContainerResume = this.$containerCallBack.getContainerStatus() == 4116;
        IPinchSummaryService pinchService = (IPinchSummaryService) ServiceManager.getService(IPinchSummaryService.Companion.getSERVICE_REFERENCE());
        boolean isPinchAbTest = pinchService != null ? pinchService.getPinchSummaryGlobalSwitch() : false;
        if (AppConfig.isDebug()) {
            Log.d(SearchPinchUtilsKt.PINCH_TAG, "搜索条件是否能展示引导：是否是结果页：" + isResultPage + "，容器是否正在展示：" + isCurrentContainerResume + "，是否命中实验：" + isPinchAbTest);
        }
        if (isResultPage || !isCurrentContainerResume || !isPinchAbTest) {
            return false;
        }
        return true;
    }
}
