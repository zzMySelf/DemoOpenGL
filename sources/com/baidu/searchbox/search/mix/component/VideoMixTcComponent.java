package com.baidu.searchbox.search.mix.component;

import com.baidu.searchbox.search.component.VideoTabTcComponent;
import com.baidu.searchbox.search.mix.tclog.VideoMixClickHandler;
import com.baidu.searchbox.search.tab.core.component.Component;
import com.baidu.searchbox.search.tab.core.component.IComponent;
import com.baidu.searchbox.search.tab.core.manager.IServiceManager;
import com.baidu.searchbox.search.tab.implement.service.ITCService;
import com.baidu.searchbox.search.tab.tclog.TcClickData;
import com.baidu.searchbox.search.tab.tclog.VideoCommonTcClickHandler;
import com.baidu.searchbox.search.tab.tclog.VideoCommonTcShowHandler;
import com.baidu.searchbox.search.tab.utils.SearchVideoTrackUtilsKt;
import com.baidu.searchbox.search.tclog.VideoTabTcShowHandler;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010\u001d\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001f0\u001eH\u0016J\u0010\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020'2\u0006\u0010$\u001a\u00020%H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0016\u0010\u0017¨\u0006("}, d2 = {"Lcom/baidu/searchbox/search/mix/component/VideoMixTcComponent;", "Lcom/baidu/searchbox/search/tab/core/component/Component;", "Lcom/baidu/searchbox/search/tab/implement/service/ITCService;", "()V", "commonHandler", "Lcom/baidu/searchbox/search/tab/tclog/VideoCommonTcClickHandler;", "getCommonHandler", "()Lcom/baidu/searchbox/search/tab/tclog/VideoCommonTcClickHandler;", "commonHandler$delegate", "Lkotlin/Lazy;", "commonTcShowHandler", "Lcom/baidu/searchbox/search/tab/tclog/VideoCommonTcShowHandler;", "getCommonTcShowHandler", "()Lcom/baidu/searchbox/search/tab/tclog/VideoCommonTcShowHandler;", "commonTcShowHandler$delegate", "searchTcShowHandler", "Lcom/baidu/searchbox/search/tclog/VideoTabTcShowHandler;", "getSearchTcShowHandler", "()Lcom/baidu/searchbox/search/tclog/VideoTabTcShowHandler;", "searchTcShowHandler$delegate", "searchvideoHandler", "Lcom/baidu/searchbox/search/mix/tclog/VideoMixClickHandler;", "getSearchvideoHandler", "()Lcom/baidu/searchbox/search/mix/tclog/VideoMixClickHandler;", "searchvideoHandler$delegate", "beginTrack", "", "vid", "", "getComponentName", "Ljava/lang/Class;", "Lcom/baidu/searchbox/search/tab/core/component/IComponent;", "registerServices", "serviceManager", "Lcom/baidu/searchbox/search/tab/core/manager/IServiceManager;", "tcShow", "params", "Lcom/baidu/searchbox/search/tab/tclog/TcClickData;", "tcUnifiedClick", "", "lib_search_video_page_a_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoMixTcComponent.kt */
public final class VideoMixTcComponent extends Component implements ITCService {
    private final Lazy commonHandler$delegate = LazyKt.lazy(VideoMixTcComponent$commonHandler$2.INSTANCE);
    private final Lazy commonTcShowHandler$delegate = LazyKt.lazy(VideoMixTcComponent$commonTcShowHandler$2.INSTANCE);
    private final Lazy searchTcShowHandler$delegate = LazyKt.lazy(VideoMixTcComponent$searchTcShowHandler$2.INSTANCE);
    private final Lazy searchvideoHandler$delegate = LazyKt.lazy(VideoMixTcComponent$searchvideoHandler$2.INSTANCE);

    private final VideoCommonTcClickHandler getCommonHandler() {
        return (VideoCommonTcClickHandler) this.commonHandler$delegate.getValue();
    }

    private final VideoMixClickHandler getSearchvideoHandler() {
        return (VideoMixClickHandler) this.searchvideoHandler$delegate.getValue();
    }

    private final VideoCommonTcShowHandler getCommonTcShowHandler() {
        return (VideoCommonTcShowHandler) this.commonTcShowHandler$delegate.getValue();
    }

    private final VideoTabTcShowHandler getSearchTcShowHandler() {
        return (VideoTabTcShowHandler) this.searchTcShowHandler$delegate.getValue();
    }

    public Class<? extends IComponent> getComponentName() {
        return VideoTabTcComponent.class;
    }

    public void registerServices(IServiceManager serviceManager) {
        Intrinsics.checkNotNullParameter(serviceManager, "serviceManager");
        serviceManager.registerService(ITCService.class, new VideoMixTcComponent$registerServices$1(this));
    }

    public boolean tcUnifiedClick(TcClickData params) {
        Intrinsics.checkNotNullParameter(params, "params");
        getSearchvideoHandler().setNextHandler(getCommonHandler());
        return getSearchvideoHandler().handleClick(params);
    }

    public void tcShow(TcClickData params) {
        Intrinsics.checkNotNullParameter(params, "params");
        getSearchTcShowHandler().setNextHandler(getCommonTcShowHandler());
        getSearchTcShowHandler().handleClick(params);
    }

    public void beginTrack(String vid) {
        SearchVideoTrackUtilsKt.beginReportTrack(vid);
    }
}
