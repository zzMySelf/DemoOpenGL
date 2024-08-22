package com.baidu.browser.iocimpl;

import com.baidu.searchbox.SearchBox;
import com.baidu.searchbox.browser.ioc.IJsInterfaceSearchBox;

public class JsInterfaceSearchBoxImpl implements IJsInterfaceSearchBox {
    public void setUseHttps(boolean useHttps) {
        SearchBox.setUseHttps(useHttps);
    }
}
