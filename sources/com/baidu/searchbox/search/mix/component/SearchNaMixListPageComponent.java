package com.baidu.searchbox.search.mix.component;

import android.view.View;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.feed.util.LogEx;
import com.baidu.searchbox.search.mix.model.SearchNaMixViewModel;
import com.baidu.searchbox.search.mix.view.SearchNaMixListPage;
import com.baidu.searchbox.search.tab.core.component.IComponent;
import com.baidu.searchbox.search.tab.core.component.ViewComponent;
import com.baidu.searchbox.search.tab.core.manager.IServiceManager;
import com.baidu.searchbox.search.tab.core.message.EventMessage;
import com.baidu.searchbox.search.tab.core.message.IMessage;
import com.baidu.searchbox.search.tab.core.message.MessageBus;
import com.baidu.searchbox.search.tab.core.model.SearchVideoBaseViewModel;
import com.baidu.searchbox.search.tab.implement.service.IVideoListViewService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u000fH\u0016J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u000fH\u0016J\b\u0010\u001c\u001a\u00020\u000fH\u0016J\b\u0010\u001d\u001a\u00020\u000fH\u0016J\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 H\u0016J\f\u0010!\u001a\u0006\u0012\u0002\b\u00030\"H\u0016J\u0010\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020%H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\f¨\u0006&"}, d2 = {"Lcom/baidu/searchbox/search/mix/component/SearchNaMixListPageComponent;", "Lcom/baidu/searchbox/search/tab/core/component/ViewComponent;", "()V", "listPage", "Lcom/baidu/searchbox/search/mix/view/SearchNaMixListPage;", "getListPage", "()Lcom/baidu/searchbox/search/mix/view/SearchNaMixListPage;", "listPage$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/baidu/searchbox/search/mix/model/SearchNaMixViewModel;", "getViewModel", "()Lcom/baidu/searchbox/search/mix/model/SearchNaMixViewModel;", "viewModel$delegate", "dispatchMessage", "", "message", "Lcom/baidu/searchbox/search/tab/core/message/IMessage;", "getComponentName", "Ljava/lang/Class;", "Lcom/baidu/searchbox/search/tab/core/component/IComponent;", "getContentView", "Landroid/view/View;", "onDestroy", "onNightModeChanged", "nightMode", "", "onPause", "onReEnter", "onResume", "registerServices", "serviceManager", "Lcom/baidu/searchbox/search/tab/core/manager/IServiceManager;", "registerViewModel", "Lcom/baidu/searchbox/search/tab/core/model/SearchVideoBaseViewModel;", "subscribe", "messageBus", "Lcom/baidu/searchbox/search/tab/core/message/MessageBus;", "lib_search_video_page_a_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchNaMixListPageComponent.kt */
public final class SearchNaMixListPageComponent extends ViewComponent {
    private final Lazy listPage$delegate = LazyKt.lazy(SearchNaMixListPageComponent$listPage$2.INSTANCE);
    private final Lazy viewModel$delegate = LazyKt.lazy(new SearchNaMixListPageComponent$viewModel$2(this));

    private final SearchNaMixViewModel getViewModel() {
        return (SearchNaMixViewModel) this.viewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final SearchNaMixListPage getListPage() {
        return (SearchNaMixListPage) this.listPage$delegate.getValue();
    }

    public SearchVideoBaseViewModel<?> registerViewModel() {
        getViewModel().observeForever(getListPage());
        return getViewModel();
    }

    public void registerServices(IServiceManager serviceManager) {
        Intrinsics.checkNotNullParameter(serviceManager, "serviceManager");
        serviceManager.registerService(IVideoListViewService.class, new SearchNaMixListPageComponent$registerServices$1(this));
    }

    public void subscribe(MessageBus messageBus) {
        Intrinsics.checkNotNullParameter(messageBus, "messageBus");
        super.subscribe(messageBus);
        messageBus.subscribe(EventMessage.class, this);
    }

    public View getContentView() {
        return getListPage().onCreateView(getManager());
    }

    public Class<? extends IComponent> getComponentName() {
        return SearchNaMixListPageComponent.class;
    }

    public void dispatchMessage(IMessage message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (message instanceof EventMessage) {
            getListPage().dispatchMessage((EventMessage) message);
        }
        if (AppConfig.isDebug()) {
            LogEx.d("SearchNaMixListPageComponent", message.toString());
        }
    }

    public void onResume() {
        super.onResume();
        getListPage().onResume();
    }

    public void onReEnter() {
        super.onReEnter();
        getListPage().onReEnter();
    }

    public void onPause() {
        super.onPause();
        getListPage().onPause();
    }

    public void onDestroy() {
        super.onDestroy();
        getListPage().onDestroy();
    }

    public void onNightModeChanged(boolean nightMode) {
        getListPage().onNightModeChanged(nightMode);
    }
}
