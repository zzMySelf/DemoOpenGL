package com.baidu.browser.components.commonmenu.impl.item;

import android.text.TextUtils;
import android.view.View;
import com.baidu.android.common.menu.CommonMenu;
import com.baidu.android.common.menu.CommonMenuItem;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.browser.arch.component.IBrowserComponentManager;
import com.baidu.browser.components.ad.utils.AdUtils;
import com.baidu.browser.components.commonmenu.core.DefaultMenuItemClickListener;
import com.baidu.browser.components.commonmenu.core.ICommonMenuContext;
import com.baidu.browser.components.commonmenu.core.SearchCommonMenuItem;
import com.baidu.browser.components.commonmenu.core.SearchCommonMenuItemKt;
import com.baidu.browser.components.commonmenu.impl.NewMenuUbcHelperKt;
import com.baidu.browser.components.videotranscoding.IVideoTransService;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.common.menu.data.R;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.favor.IFavorManager;
import com.baidu.searchbox.search.eventbus.SearchMovieFavorPlayModelUpdateEvent;
import com.baidu.searchbox.search.pyramid.FavorPlayModel;
import com.baidu.searchbox.search.pyramid.SearchH5FavorService;
import com.baidu.searchbox.search.webvideo.utils.SearchH5AbManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0014\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\fH\u0002J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0006H\u0002J\b\u0010\u0016\u001a\u00020\bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/baidu/browser/components/commonmenu/impl/item/CommonMenuStarItem;", "Lcom/baidu/browser/components/commonmenu/core/SearchCommonMenuItem;", "commonMenuContext", "Lcom/baidu/browser/components/commonmenu/core/ICommonMenuContext;", "(Lcom/baidu/browser/components/commonmenu/core/ICommonMenuContext;)V", "isFavored", "", "clean", "", "getSearchMovieFavorAGG", "Lcom/baidu/searchbox/search/pyramid/FavorPlayModel;", "pageUrl", "", "onItemClick", "view", "Landroid/view/View;", "queryUrlIsFavored", "url", "updateStarCommonMenuItemState", "startMenuItem", "Lcom/baidu/android/common/menu/CommonMenuItem;", "favored", "updateState", "lib-browser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommonMenuStarItem.kt */
public final class CommonMenuStarItem extends SearchCommonMenuItem {
    private boolean isFavored;

    public CommonMenuStarItem(ICommonMenuContext commonMenuContext) {
        super(commonMenuContext, SearchCommonMenuItemKt.makeItem(1));
        if (SearchH5AbManager.isSearchH5VideoFavorAGG()) {
            BdEventBus.Companion.getDefault().register(this, SearchMovieFavorPlayModelUpdateEvent.class, 1, new CommonMenuStarItem$$ExternalSyntheticLambda0(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m12665_init_$lambda0(CommonMenuStarItem this$0, SearchMovieFavorPlayModelUpdateEvent it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        if (!this$0.isFavored) {
            this$0.updateState();
        }
    }

    public void updateState() {
        String str = null;
        ICommonMenuContext commonMenuContext = getCommonMenuContext();
        String str2 = null;
        String mLandingPageAdFaverData = commonMenuContext != null ? commonMenuContext.getLandingAdFaverData() : null;
        if (mLandingPageAdFaverData != null) {
            str = AdUtils.getUkeyFromLandingPageAdFaver(mLandingPageAdFaverData);
        }
        if (TextUtils.isEmpty(str)) {
            ICommonMenuContext commonMenuContext2 = getCommonMenuContext();
            if (commonMenuContext2 != null) {
                str2 = commonMenuContext2.getFavorUrl();
            }
            str = str2;
        }
        if (!TextUtils.isEmpty(str)) {
            String webUrl = str == null ? "" : str;
            SearchH5FavorService favorService = (SearchH5FavorService) ServiceManager.getService(SearchH5FavorService.Companion.getReference());
            if (favorService == null || !favorService.interceptQueryFavor(webUrl, getSearchMovieFavorAGG(webUrl), new CommonMenuStarItem$updateState$2(this))) {
                ExecutorUtilsExt.postOnElastic(new CommonMenuStarItem$$ExternalSyntheticLambda1(this, webUrl), "query_url_is_favored", 0);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: updateState$lambda-3  reason: not valid java name */
    public static final void m12666updateState$lambda3(CommonMenuStarItem this$0, String $webUrl) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($webUrl, "$webUrl");
        UiThreadUtils.runOnUiThread(new CommonMenuStarItem$$ExternalSyntheticLambda2(this$0, this$0.queryUrlIsFavored($webUrl)));
    }

    /* access modifiers changed from: private */
    /* renamed from: updateState$lambda-3$lambda-2  reason: not valid java name */
    public static final void m12667updateState$lambda3$lambda2(CommonMenuStarItem this$0, boolean $favored) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.updateStarCommonMenuItemState(this$0, $favored);
    }

    private final FavorPlayModel getSearchMovieFavorAGG(String pageUrl) {
        IBrowserComponentManager componentManager;
        IVideoTransService videoTransService;
        ICommonMenuContext commonMenuContext = getCommonMenuContext();
        if (commonMenuContext == null || (componentManager = commonMenuContext.getComponentManager()) == null || (videoTransService = (IVideoTransService) componentManager.getService(IVideoTransService.class)) == null) {
            return null;
        }
        return videoTransService.getSearchMovieFavorAGG(pageUrl);
    }

    public void clean() {
        if (SearchH5AbManager.isSearchH5VideoFavorAGG()) {
            BdEventBus.Companion.getDefault().unregister(this);
        }
        super.clean();
    }

    /* access modifiers changed from: private */
    public final void updateStarCommonMenuItemState(CommonMenuItem startMenuItem, boolean favored) {
        int icon;
        int title;
        CommonMenu it;
        this.isFavored = favored;
        if (favored) {
            icon = R.drawable.common_menu_item_stared;
        } else {
            icon = R.drawable.common_menu_item_star;
        }
        if (favored) {
            title = R.string.common_menu_text_stared;
        } else {
            title = R.string.common_menu_text_star;
        }
        startMenuItem.setIcon(icon);
        startMenuItem.setTitle(title);
        ICommonMenuContext commonMenuContext = getCommonMenuContext();
        if (commonMenuContext != null && (it = commonMenuContext.getCommonMenu()) != null && it.isShowing()) {
            it.notifyDataChanged();
        }
    }

    private final boolean queryUrlIsFavored(String url) {
        return ((IFavorManager) ServiceManager.getService(IFavorManager.SERVICE_REFERENCE)).isFavored(url);
    }

    public boolean onItemClick(View view2) {
        DefaultMenuItemClickListener defaultMenuItemClickListener;
        Intrinsics.checkNotNullParameter(view2, "view");
        if (this.isFavored) {
            NewMenuUbcHelperKt.menuBtnClickUBC$default("cancelcollection", getCommonMenuContext(), NewMenuUbcHelperKt.getDotNum(getNewTip(), getTip()), (String) null, 8, (Object) null);
        } else {
            NewMenuUbcHelperKt.menuBtnClickUBC$default("addcollection", getCommonMenuContext(), NewMenuUbcHelperKt.getDotNum(getNewTip(), getTip()), (String) null, 8, (Object) null);
        }
        ICommonMenuContext commonMenuContext = getCommonMenuContext();
        if (commonMenuContext == null || (defaultMenuItemClickListener = commonMenuContext.getDefaultMenuItemClickListener()) == null) {
            return true;
        }
        defaultMenuItemClickListener.onClick(view2, this);
        return true;
    }
}
