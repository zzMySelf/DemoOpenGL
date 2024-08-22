package com.baidu.searchbox.video.flow.container;

import com.baidu.searchbox.browserenhanceengine.container.Container;
import com.baidu.searchbox.browserenhanceengine.container.ContainerModel;
import com.baidu.searchbox.video.search.container.SearchVideoContainerCreator;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004H\u0016¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/video/flow/container/SearchVideoFlowContainerImpl;", "Lcom/baidu/searchbox/video/search/container/SearchVideoContainerCreator;", "()V", "getContainerClass", "Ljava/lang/Class;", "Lcom/baidu/searchbox/browserenhanceengine/container/Container;", "Lcom/baidu/searchbox/browserenhanceengine/container/ContainerModel;", "video-dependency-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchVideoFlowContainerImpl.kt */
public final class SearchVideoFlowContainerImpl implements SearchVideoContainerCreator {
    public Class<Container<ContainerModel>> getContainerClass() {
        return SearchFlowVideoContainer.class;
    }
}
