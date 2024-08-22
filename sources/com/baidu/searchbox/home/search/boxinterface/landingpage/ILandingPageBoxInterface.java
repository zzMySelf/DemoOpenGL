package com.baidu.searchbox.home.search.boxinterface.landingpage;

import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.searchbox.home.search.ISearchBoxInterface;
import kotlin.Metadata;

@StableApi
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'J\b\u0010\u0004\u001a\u00020\u0005H'J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH'¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/home/search/boxinterface/landingpage/ILandingPageBoxInterface;", "Lcom/baidu/searchbox/home/search/ISearchBoxInterface;", "getScaledSearchBoxHeight", "", "setDefaultLeftIcon", "", "showOrHideBtn", "btnType", "", "show", "", "lib-home-search-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ILandingPageBoxInterface.kt */
public interface ILandingPageBoxInterface extends ISearchBoxInterface {
    int getScaledSearchBoxHeight();

    void setDefaultLeftIcon();

    void showOrHideBtn(String str, boolean z);
}
