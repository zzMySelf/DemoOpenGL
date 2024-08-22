package com.baidu.talos.core.modules.appregister;

import com.baidu.talos.core.anno.TalosMethod;
import com.baidu.talos.core.anno.TalosModule;
import com.baidu.talos.core.context.IRuntimeContext;
import com.baidu.talos.core.module.TalosNativeModule;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@TalosModule(name = "AppRegistryQueueModule")
public class AppRegistryQueueModule extends TalosNativeModule {
    private final List<String> componentList = new CopyOnWriteArrayList();
    private final List<AppRegistryQueueChangeListener> listeners = new CopyOnWriteArrayList();

    public interface AppRegistryQueueChangeListener {
        void change(List<String> list);
    }

    public AppRegistryQueueModule(IRuntimeContext reactContext) {
        super(reactContext);
    }

    public void initialize() {
    }

    public void destroy() {
    }

    public void removeAppRegistryQueueChangeListener(AppRegistryQueueChangeListener listener) {
        this.listeners.remove(listener);
    }

    public void addAppRegistryQueueChangeListener(AppRegistryQueueChangeListener listener) {
        this.listeners.add(listener);
    }

    public synchronized void addAppRegistryQueueChangeListenerAndImmediately(AppRegistryQueueChangeListener listener) {
        addAppRegistryQueueChangeListener(listener);
        listener.change(this.componentList);
    }

    private synchronized void fireAppRegistryQueueChangeListener() {
        for (AppRegistryQueueChangeListener listener : this.listeners) {
            listener.change(this.componentList);
        }
    }

    @TalosMethod(thread = TalosMethod.Thread.BRIDGE, type = TalosMethod.Type.CALLBACK)
    public void registryComponent(String componentName) {
        if (!this.componentList.contains(componentName)) {
            this.componentList.add(componentName);
            fireAppRegistryQueueChangeListener();
        }
    }
}
