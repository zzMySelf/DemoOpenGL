package com.baidu.searchbox.video.flow.provider.creator;

import com.baidu.searchbox.feed.detail.arch.ComponentArchManager;
import com.baidu.searchbox.feed.detail.arch.ComponentManager;
import com.baidu.searchbox.feed.detail.arch.api.IArchDetailFactory;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.AbsStore;
import com.baidu.searchbox.video.channel.assemble.creator.ChannelTabComponentCreator;
import com.baidu.searchbox.video.channel.assemble.provider.ChannelTabUnitProvider;
import com.baidu.searchbox.video.channel.assemble.provider.ChannelTabUnitProviderKt;
import com.baidu.searchbox.video.channel.tab.ChannelTabFactory;
import com.baidu.searchbox.video.channel.tab.ChannelTabProcessCollection;
import com.baidu.searchbox.video.channel.tab.ChannelTabStore;
import com.baidu.searchbox.video.component.base.TypeViewCreatorService;
import com.baidu.searchbox.video.detail.business.VideoBusiness;
import com.baidu.searchbox.video.feedflow.common.IDetailItemCoreEventService;
import com.baidu.searchbox.video.feedflow.common.ITouchEventListenerService;
import com.baidu.searchbox.video.feedflow.common.TouchEventListenerServiceImpl;
import com.baidu.searchbox.video.feedflow.common.serviceimpl.DetailItemCoreEventServiceImpl;
import com.baidu.searchbox.video.feedflow.provider.IChannelTabUnitProvider;
import com.baidu.searchbox.video.feedflow.tab.TabItemCreatorService;
import com.baidu.searchbox.video.service.guidepriority.GuidePriorityService;
import com.baidu.searchbox.video.service.guidepriority.GuidePriorityServiceImpl;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\u0012\u0010\u0013\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/video/flow/provider/creator/ChannelTabComponentCreatorImpl;", "Lcom/baidu/searchbox/video/channel/assemble/creator/ChannelTabComponentCreator;", "()V", "providerMap", "", "", "Lcom/baidu/searchbox/video/feedflow/provider/IChannelTabUnitProvider;", "createFactory", "Lcom/baidu/searchbox/feed/detail/arch/api/IArchDetailFactory;", "business", "Lcom/baidu/searchbox/video/detail/business/VideoBusiness;", "createManager", "Lcom/baidu/searchbox/feed/detail/arch/ComponentArchManager;", "createStore", "Lcom/baidu/searchbox/feed/detail/frame/AbsStore;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "getInitState", "", "", "initProvider", "video-dependency-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelTabComponentCreatorImpl.kt */
public final class ChannelTabComponentCreatorImpl implements ChannelTabComponentCreator {
    private final Map<String, IChannelTabUnitProvider> providerMap = new LinkedHashMap();

    public ComponentArchManager createManager() {
        ComponentArchManager componentManager = new ComponentManager();
        ComponentArchManager $this$createManager_u24lambda_u2d0 = componentManager;
        $this$createManager_u24lambda_u2d0.registerServices(TypeViewCreatorService.class, new TabItemCreatorService($this$createManager_u24lambda_u2d0));
        $this$createManager_u24lambda_u2d0.registerServices(GuidePriorityService.class, new GuidePriorityServiceImpl());
        $this$createManager_u24lambda_u2d0.registerServices(ITouchEventListenerService.class, new TouchEventListenerServiceImpl());
        $this$createManager_u24lambda_u2d0.registerServices(IDetailItemCoreEventService.class, new DetailItemCoreEventServiceImpl());
        return componentManager;
    }

    public AbsStore<CommonState> createStore(VideoBusiness business) {
        String key = initProvider(business);
        List initState = getInitState(business);
        CommonState commonState = new CommonState(new LinkedHashMap());
        IChannelTabUnitProvider iChannelTabUnitProvider = this.providerMap.get(key);
        Intrinsics.checkNotNull(iChannelTabUnitProvider);
        ChannelTabStore $this$createStore_u24lambda_u2d1 = new ChannelTabStore(commonState, initState, new ChannelTabProcessCollection(iChannelTabUnitProvider, business));
        String name = VideoBusiness.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "VideoBusiness::class.java.name");
        ((CommonState) $this$createStore_u24lambda_u2d1.getState()).put(name, business);
        return $this$createStore_u24lambda_u2d1;
    }

    public IArchDetailFactory createFactory(VideoBusiness business) {
        IChannelTabUnitProvider iChannelTabUnitProvider = this.providerMap.get(initProvider(business));
        Intrinsics.checkNotNull(iChannelTabUnitProvider);
        return new ChannelTabFactory(business, iChannelTabUnitProvider);
    }

    private final String initProvider(VideoBusiness business) {
        String key;
        if (business == null || (key = business.tpl()) == null) {
            key = "";
        }
        if (this.providerMap.get(key) == null) {
            this.providerMap.put(key, new ChannelTabUnitProvider());
        }
        return key;
    }

    private final List<Object> getInitState(VideoBusiness business) {
        return ChannelTabUnitProviderKt.collectChannelInitState();
    }
}
