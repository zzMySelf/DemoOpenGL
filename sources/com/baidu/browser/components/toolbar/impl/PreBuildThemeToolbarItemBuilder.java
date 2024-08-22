package com.baidu.browser.components.toolbar.impl;

import android.view.View;
import com.baidu.browser.components.toolbar.core.ISearchBoxToolbarContext;
import com.baidu.browser.components.toolbar.core.SearchBoxToolbarItem;
import com.baidu.browser.components.toolbar.impl.item.ToolbarBackItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/baidu/browser/components/toolbar/impl/PreBuildThemeToolbarItemBuilder;", "Lcom/baidu/browser/components/toolbar/impl/SearchBoxToolbarItemBuilder;", "()V", "buildToolbarItemList", "", "Lcom/baidu/browser/components/toolbar/core/SearchBoxToolbarItem;", "toolbarContext", "Lcom/baidu/browser/components/toolbar/core/ISearchBoxToolbarContext;", "lib-browser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchBoxToolbarItemBuilder.kt */
public final class PreBuildThemeToolbarItemBuilder extends SearchBoxToolbarItemBuilder {
    public List<SearchBoxToolbarItem> buildToolbarItemList(ISearchBoxToolbarContext toolbarContext) {
        ArrayList itemList = new ArrayList();
        itemList.add(new ToolbarBackItem(toolbarContext, (View) null, 2, (DefaultConstructorMarker) null));
        return itemList;
    }
}
