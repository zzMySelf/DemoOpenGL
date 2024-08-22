package com.baidu.browser.explore.mutable;

import com.baidu.browser.explore.container.SearchBoxContainer;
import com.baidu.searchbox.browserenhanceengine.container.Container;
import com.baidu.searchbox.browserenhanceengine.container.ContainerModel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u001a\u0010\u0010\u0006\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u001a\u0010\u0010\u0007\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u001a\u0010\u0010\b\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u001a\u0010\u0010\t\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¨\u0006\n"}, d2 = {"isCommentToolbarContainer", "", "container", "Lcom/baidu/browser/explore/container/SearchBoxContainer;", "Lcom/baidu/searchbox/browserenhanceengine/container/Container;", "Lcom/baidu/searchbox/browserenhanceengine/container/ContainerModel;", "isLandingPageContainer", "isResultPageContainer", "isResultPageContainerWithNaTab", "isResultShowTalosContainer", "lib-browser_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: MutableContainerUtils.kt */
public final class MutableContainerUtilsKt {
    public static final boolean isCommentToolbarContainer(Container<ContainerModel> container) {
        SearchBoxContainer searchBoxContainer = container instanceof SearchBoxContainer ? (SearchBoxContainer) container : null;
        return searchBoxContainer != null && searchBoxContainer.isCommentToolbarContainer();
    }

    public static final boolean isCommentToolbarContainer(SearchBoxContainer container) {
        return container != null && container.isCommentToolbarContainer();
    }

    public static final boolean isLandingPageContainer(SearchBoxContainer container) {
        return container != null && container.isLandingPageContainer();
    }

    public static final boolean isResultPageContainer(SearchBoxContainer container) {
        return container != null && container.isResultPageContainer();
    }

    public static final boolean isResultPageContainerWithNaTab(SearchBoxContainer container) {
        return container != null && container.isResultPageContainerWithNaTab();
    }

    public static final boolean isResultShowTalosContainer(SearchBoxContainer container) {
        return container != null && container.isResultShowTalosContainer();
    }
}
