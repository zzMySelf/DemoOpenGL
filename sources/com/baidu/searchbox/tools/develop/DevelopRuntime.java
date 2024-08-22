package com.baidu.searchbox.tools.develop;

import com.baidu.searchbox.developer.DevelopContext_Factory;

public class DevelopRuntime {
    public static IDevelopContext getDevelopContext() {
        return DevelopContext_Factory.get();
    }
}
