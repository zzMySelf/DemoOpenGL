package com.baidu.browser.explore.mutable;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.ext.widget.toast.ToastTemplate;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.browser.R;
import com.baidu.browser.explore.tab.na.tag.data.SearchTagItem;
import com.baidu.browser.explore.tab.webview.BaseWebViewTabContainer;
import com.baidu.browser.tabna.BaseTabContainer;
import com.baidu.browser.tabna.SearchTabItem;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.search.basic.utils.SearchABTestUtils;
import com.baidu.searchbox.video.detail.message.MessageManifest;
import com.baidu.ubc.UBCManager;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0002\u001a\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u001a\u001a\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u001a\u001a\u0010\n\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u001a\u0010\u0010\u000b\u001a\u00020\u00012\b\u0010\f\u001a\u0004\u0018\u00010\r¨\u0006\u000e"}, d2 = {"filterBackToastShowUbc", "", "hideBackToNoFilterToast", "isContainerInFilter", "", "container", "Lcom/baidu/browser/tabna/BaseTabContainer;", "isSwitchInFilter", "currContainer", "nextContainer", "isSwitchOtherTab", "showBackToNoFilterToast", "context", "Landroid/content/Context;", "lib-browser_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: MultiTagHelper.kt */
public final class MultiTagHelperKt {
    public static final boolean isSwitchInFilter(BaseTabContainer currContainer, BaseTabContainer nextContainer) {
        Boolean isTagBack = SearchABTestUtils.isTagBack();
        Intrinsics.checkNotNullExpressionValue(isTagBack, "isTagBack()");
        if (!isTagBack.booleanValue() || nextContainer == null || isContainerInFilter(currContainer) || !isContainerInFilter(nextContainer)) {
            return false;
        }
        return true;
    }

    public static final boolean isSwitchOtherTab(BaseTabContainer currContainer, BaseTabContainer nextContainer) {
        if (currContainer == null || nextContainer == null) {
            return false;
        }
        SearchTabItem tabItem = currContainer.getTabItem();
        String nextPd = null;
        String currPd = tabItem != null ? tabItem.pd : null;
        SearchTabItem tabItem2 = nextContainer.getTabItem();
        if (tabItem2 != null) {
            nextPd = tabItem2.pd;
        }
        boolean currIsInFilter = isContainerInFilter(currContainer);
        boolean nextIsInFilter = isContainerInFilter(nextContainer);
        if ((TextUtils.isEmpty(currPd) || currIsInFilter) && !TextUtils.isEmpty(nextPd) && !nextIsInFilter) {
            return true;
        }
        return false;
    }

    public static final boolean isContainerInFilter(BaseTabContainer container) {
        SearchTabItem tabItem;
        if ((container instanceof BaseWebViewTabContainer) && ((BaseWebViewTabContainer) container).currTag != null) {
            SearchTagItem searchTagItem = ((BaseWebViewTabContainer) container).currTag;
            if (searchTagItem == null || !searchTagItem.isInMoreFilter()) {
                return false;
            }
            return true;
        } else if (container == null || (tabItem = container.getTabItem()) == null || !tabItem.isInFilter) {
            return false;
        } else {
            return true;
        }
    }

    public static final void showBackToNoFilterToast(Context context) {
        if (context != null) {
            Context finalContext = context;
            UniversalToast.makeText(finalContext, finalContext.getText(R.string.search_filter_back)).setTemplate(ToastTemplate.T2).show();
            filterBackToastShowUbc();
        }
    }

    public static final void hideBackToNoFilterToast() {
        UniversalToast.cancelToast();
    }

    private static final void filterBackToastShowUbc() {
        JSONObject ubcObject = new JSONObject();
        try {
            Result.Companion companion = Result.Companion;
            ubcObject.put("from", "search");
            Result.m8971constructorimpl(ubcObject.put("page", "a"));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        JSONObject extObject = new JSONObject();
        JSONObject valueInfoObject = new JSONObject();
        JSONObject subValueInfoObject = new JSONObject();
        JSONArray valueInfoArray = new JSONArray();
        try {
            Result.Companion companion3 = Result.Companion;
            subValueInfoObject.put(MessageManifest.Advert.Key.AREA, "toast_r_a_flt");
            valueInfoObject.put("sort", "show");
            valueInfoObject.put("sub_valueinfo", subValueInfoObject);
            valueInfoArray.put(valueInfoObject);
            extObject.put("valueInfo", valueInfoArray);
            Result.m8971constructorimpl(ubcObject.put("ext", extObject));
        } catch (Throwable th3) {
            Result.Companion companion4 = Result.Companion;
            Result.m8971constructorimpl(ResultKt.createFailure(th3));
        }
        UBCManager ubc = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        if (ubc != null) {
            ubc.onEvent("6640", ubcObject);
        }
    }
}
