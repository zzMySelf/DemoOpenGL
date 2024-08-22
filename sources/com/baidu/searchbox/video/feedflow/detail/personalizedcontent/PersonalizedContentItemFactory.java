package com.baidu.searchbox.video.feedflow.detail.personalizedcontent;

import com.baidu.searchbox.feed.detail.arch.api.ComponentFactory;
import com.baidu.searchbox.feed.detail.arch.api.IArchDetailFactory;
import com.baidu.searchbox.feed.detail.arch.api.ILayoutManager;
import com.baidu.searchbox.feed.detail.arch.api.IPlugin;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/personalizedcontent/PersonalizedContentItemFactory;", "Lcom/baidu/searchbox/feed/detail/arch/api/IArchDetailFactory;", "()V", "getAnnotatedPlugins", "", "Lcom/baidu/searchbox/feed/detail/arch/api/IPlugin;", "getComponentFactory", "Lcom/baidu/searchbox/feed/detail/arch/api/ComponentFactory;", "getLayoutManager", "Lcom/baidu/searchbox/feed/detail/arch/api/ILayoutManager;", "feed-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalizedContentItemFactory.kt */
public final class PersonalizedContentItemFactory implements IArchDetailFactory {
    public List<IPlugin> getAnnotatedPlugins() {
        return PersonalizedContentItemComponentRegister.Companion.getPlugins();
    }

    public ComponentFactory getComponentFactory() {
        return PersonalizedContentItemComponentRegister.Companion.getComponentFactory();
    }

    public ILayoutManager getLayoutManager() {
        return new PersonalizedContentItemLayoutManager();
    }
}
