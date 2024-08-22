package com.baidu.searchbox.video.flow.provider.factory;

import com.baidu.searchbox.feed.detail.arch.api.AbsComponentFactory;
import com.baidu.searchbox.feed.detail.arch.api.ComponentFactory;
import com.baidu.searchbox.feed.detail.arch.api.IArchDetailFactory;
import com.baidu.searchbox.feed.detail.arch.api.ILayoutManager;
import com.baidu.searchbox.feed.detail.arch.api.IPlugin;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.video.detail.business.VideoBusiness;
import com.baidu.searchbox.video.feedflow.provider.TabUnitProvider;
import com.baidu.searchbox.video.feedflow.tab.TabLayoutManager;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/video/flow/provider/factory/TabFactory;", "Lcom/baidu/searchbox/feed/detail/arch/api/IArchDetailFactory;", "business", "Lcom/baidu/searchbox/video/detail/business/VideoBusiness;", "provider", "Lcom/baidu/searchbox/video/feedflow/provider/TabUnitProvider;", "(Lcom/baidu/searchbox/video/detail/business/VideoBusiness;Lcom/baidu/searchbox/video/feedflow/provider/TabUnitProvider;)V", "factory", "Lcom/baidu/searchbox/feed/detail/arch/api/AbsComponentFactory;", "getFactory", "()Lcom/baidu/searchbox/feed/detail/arch/api/AbsComponentFactory;", "factory$delegate", "Lkotlin/Lazy;", "getAnnotatedPlugins", "", "Lcom/baidu/searchbox/feed/detail/arch/api/IPlugin;", "getComponentFactory", "Lcom/baidu/searchbox/feed/detail/arch/api/ComponentFactory;", "getLayoutManager", "Lcom/baidu/searchbox/feed/detail/arch/api/ILayoutManager;", "video-dependency-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TabFactory.kt */
public final class TabFactory implements IArchDetailFactory {
    private final VideoBusiness business;
    private final Lazy factory$delegate;

    public TabFactory(VideoBusiness business2, TabUnitProvider provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        this.business = business2;
        this.factory$delegate = BdPlayerUtils.lazyNone(new TabFactory$factory$2(provider));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TabFactory(VideoBusiness videoBusiness, TabUnitProvider tabUnitProvider, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : videoBusiness, tabUnitProvider);
    }

    private final AbsComponentFactory getFactory() {
        return (AbsComponentFactory) this.factory$delegate.getValue();
    }

    public List<IPlugin> getAnnotatedPlugins() {
        return getFactory().getPlugins();
    }

    public ComponentFactory getComponentFactory() {
        return getFactory().getComponentFactory();
    }

    public ILayoutManager getLayoutManager() {
        return new TabLayoutManager();
    }
}
