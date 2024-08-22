package com.baidu.browser.components.commonmenu.impl;

import android.util.Log;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.browser.arch.component.IBrowserComponentManager;
import com.baidu.browser.components.commonmenu.core.ICommonMenuContext;
import com.baidu.browser.components.videotranscoding.IVideoTransService;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.favor.IFavorManager;
import com.baidu.searchbox.search.pyramid.FavorPlayModel;
import com.baidu.searchbox.search.pyramid.SearchH5FavorService;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0014\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/baidu/browser/components/commonmenu/impl/CheckFavorWeakReference;", "", "menuManager", "Lcom/baidu/browser/components/commonmenu/impl/NewMenuManager;", "commonMenuContext", "Lcom/baidu/browser/components/commonmenu/core/ICommonMenuContext;", "(Lcom/baidu/browser/components/commonmenu/impl/NewMenuManager;Lcom/baidu/browser/components/commonmenu/core/ICommonMenuContext;)V", "Ljava/lang/ref/WeakReference;", "checkIsFavor", "", "url", "", "getSearchMovieFavorAGG", "Lcom/baidu/searchbox/search/pyramid/FavorPlayModel;", "pageUrl", "queryUrlIsFavored", "", "lib-browser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NewMenuManager.kt */
public final class CheckFavorWeakReference {
    private WeakReference<ICommonMenuContext> commonMenuContext;
    /* access modifiers changed from: private */
    public WeakReference<NewMenuManager> menuManager;

    public CheckFavorWeakReference(NewMenuManager menuManager2, ICommonMenuContext commonMenuContext2) {
        Intrinsics.checkNotNullParameter(menuManager2, "menuManager");
        Intrinsics.checkNotNullParameter(commonMenuContext2, "commonMenuContext");
        this.menuManager = new WeakReference<>(menuManager2);
        this.commonMenuContext = new WeakReference<>(commonMenuContext2);
    }

    public final void checkIsFavor(String url) {
        CharSequence charSequence = url;
        if (!(charSequence == null || charSequence.length() == 0)) {
            SearchH5FavorService favorService = (SearchH5FavorService) ServiceManager.getService(SearchH5FavorService.Companion.getReference());
            if (favorService == null || !favorService.interceptQueryFavor(url, getSearchMovieFavorAGG(url), new CheckFavorWeakReference$checkIsFavor$1(url, this))) {
                ExecutorUtilsExt.postOnElastic(new CheckFavorWeakReference$$ExternalSyntheticLambda0(this, url), "menu_query_url_is_favored", 0);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: checkIsFavor$lambda-1  reason: not valid java name */
    public static final void m12656checkIsFavor$lambda1(CheckFavorWeakReference this$0, String $url) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean favored = this$0.queryUrlIsFavored($url);
        UiThreadUtils.runOnUiThread(new CheckFavorWeakReference$$ExternalSyntheticLambda1(this$0, $url, favored));
        if (NewMenuManagerKt.ISDEBUG) {
            Log.d(NewMenuManagerKt.NEW_MENU_TAG, "普通页面收藏结果 ukey is " + $url + " isFavor is " + favored);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: checkIsFavor$lambda-1$lambda-0  reason: not valid java name */
    public static final void m12657checkIsFavor$lambda1$lambda0(CheckFavorWeakReference this$0, String $url, boolean $favored) {
        NewMenuManager newMenuManager;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WeakReference<NewMenuManager> weakReference = this$0.menuManager;
        if (weakReference != null && (newMenuManager = (NewMenuManager) weakReference.get()) != null) {
            newMenuManager.updateFavor($url, $favored);
        }
    }

    private final FavorPlayModel getSearchMovieFavorAGG(String pageUrl) {
        ICommonMenuContext iCommonMenuContext;
        IBrowserComponentManager componentManager;
        IVideoTransService videoTransService;
        WeakReference<ICommonMenuContext> weakReference = this.commonMenuContext;
        if (weakReference == null || (iCommonMenuContext = (ICommonMenuContext) weakReference.get()) == null || (componentManager = iCommonMenuContext.getComponentManager()) == null || (videoTransService = (IVideoTransService) componentManager.getService(IVideoTransService.class)) == null) {
            return null;
        }
        return videoTransService.getSearchMovieFavorAGG(pageUrl);
    }

    private final boolean queryUrlIsFavored(String url) {
        return ((IFavorManager) ServiceManager.getService(IFavorManager.SERVICE_REFERENCE)).isFavored(url);
    }
}
