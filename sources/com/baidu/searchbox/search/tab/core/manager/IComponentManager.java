package com.baidu.searchbox.search.tab.core.manager;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.searchbox.search.tab.core.component.IComponent;
import com.baidu.searchbox.search.tab.core.component.ViewComponent;
import com.baidu.searchbox.search.tab.core.message.IMessage;
import com.baidu.searchbox.search.tab.core.model.ISharedData;
import com.baidu.searchbox.search.tab.core.service.IService;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J'\u0010\b\u001a\u0004\u0018\u0001H\t\"\b\b\u0000\u0010\t*\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\fH&¢\u0006\u0002\u0010\rJ\u0015\u0010\u000e\u001a\u0004\u0018\u0001H\t\"\u0004\b\u0000\u0010\tH&¢\u0006\u0002\u0010\u000fJ'\u0010\u0010\u001a\u0004\u0018\u0001H\t\"\b\b\u0000\u0010\t*\u00020\u00112\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\fH&¢\u0006\u0002\u0010\u0012J\b\u0010\u0013\u001a\u00020\u0014H&J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0003H&J\b\u0010\u0017\u001a\u00020\u0014H&J\u0012\u0010\u0018\u001a\u00020\u00142\b\b\u0001\u0010\u0019\u001a\u00020\u001aH&J\b\u0010\u001b\u001a\u00020\u0014H&J\u0012\u0010\u001c\u001a\u00020\u00142\b\b\u0001\u0010\u001d\u001a\u00020\u001eH&J\u0012\u0010\u001f\u001a\u00020\u00142\b\b\u0001\u0010 \u001a\u00020!H&J\u0012\u0010\"\u001a\u00020\u00142\b\b\u0001\u0010#\u001a\u00020\u0007H&J\u0012\u0010$\u001a\u00020\u00142\b\b\u0001\u0010%\u001a\u00020&H&J$\u0010'\u001a\u00020\u00142\u0010\b\u0001\u0010(\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001e0\f2\b\b\u0001\u0010\u0019\u001a\u00020\u001aH&J\u0012\u0010)\u001a\u00020\u00142\b\b\u0001\u0010\u0019\u001a\u00020\u001aH&¨\u0006*"}, d2 = {"Lcom/baidu/searchbox/search/tab/core/manager/IComponentManager;", "", "canGoBack", "", "getContext", "Landroid/content/Context;", "getDataManager", "Lcom/baidu/searchbox/search/tab/core/manager/IDataManager;", "getService", "T", "Lcom/baidu/searchbox/search/tab/core/service/IService;", "c", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/baidu/searchbox/search/tab/core/service/IService;", "getSharedData", "()Ljava/lang/Object;", "getViewComponent", "Lcom/baidu/searchbox/search/tab/core/component/ViewComponent;", "(Ljava/lang/Class;)Lcom/baidu/searchbox/search/tab/core/component/ViewComponent;", "goBack", "", "onNightModeChanged", "nightMode", "onReEnter", "registerComponent", "component", "Lcom/baidu/searchbox/search/tab/core/component/IComponent;", "reset", "sendMessage", "message", "Lcom/baidu/searchbox/search/tab/core/message/IMessage;", "setContentView", "parent", "Landroid/view/ViewGroup;", "setDataManager", "manager", "setSharedData", "data", "Lcom/baidu/searchbox/search/tab/core/model/ISharedData;", "subscribe", "messageType", "unSubscribe", "search_video_framework_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IComponentManager.kt */
public interface IComponentManager {
    boolean canGoBack();

    Context getContext();

    IDataManager getDataManager();

    <T extends IService> T getService(Class<T> cls);

    <T> T getSharedData();

    <T extends ViewComponent> T getViewComponent(Class<T> cls);

    void goBack();

    void onNightModeChanged(boolean z);

    void onReEnter();

    void registerComponent(IComponent iComponent);

    void reset();

    void sendMessage(IMessage iMessage);

    void setContentView(ViewGroup viewGroup);

    void setDataManager(IDataManager iDataManager);

    void setSharedData(ISharedData iSharedData);

    void subscribe(Class<? extends IMessage> cls, IComponent iComponent);

    void unSubscribe(IComponent iComponent);
}
