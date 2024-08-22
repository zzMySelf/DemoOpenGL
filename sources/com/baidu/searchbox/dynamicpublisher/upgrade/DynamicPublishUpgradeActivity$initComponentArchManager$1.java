package com.baidu.searchbox.dynamicpublisher.upgrade;

import com.baidu.searchbox.dynamicpublisher.DynamicPublishArchDetailFactory;
import com.baidu.searchbox.feed.detail.arch.api.ComponentFactory;
import com.baidu.searchbox.feed.detail.arch.api.ILayoutManager;
import com.baidu.searchbox.feed.detail.arch.api.IPlugin;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/baidu/searchbox/dynamicpublisher/upgrade/DynamicPublishUpgradeActivity$initComponentArchManager$1", "Lcom/baidu/searchbox/dynamicpublisher/DynamicPublishArchDetailFactory;", "getAnnotatedPlugins", "", "Lcom/baidu/searchbox/feed/detail/arch/api/IPlugin;", "getComponentFactory", "Lcom/baidu/searchbox/feed/detail/arch/api/ComponentFactory;", "getLayoutManager", "Lcom/baidu/searchbox/feed/detail/arch/api/ILayoutManager;", "lib-publisher-dynamic_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DynamicPublishUpgradeActivity.kt */
public final class DynamicPublishUpgradeActivity$initComponentArchManager$1 extends DynamicPublishArchDetailFactory {
    DynamicPublishUpgradeActivity$initComponentArchManager$1() {
    }

    public ILayoutManager getLayoutManager() {
        return new DynamicPublishUpgradeLayoutManager();
    }

    public ComponentFactory getComponentFactory() {
        return DynamicPublishUpgradeComponentRegister.Companion.getComponentFactory();
    }

    public List<IPlugin> getAnnotatedPlugins() {
        return DynamicPublishUpgradeComponentRegister.Companion.getPlugins();
    }
}
