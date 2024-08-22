package com.baidu.talos.core;

import com.baidu.pyramid.annotation.Provider;
import com.baidu.pyramid.annotation.component.DefaultListHolder;
import com.baidu.pyramid.annotation.component.ListHolder;
import com.baidu.talos.core.api.TalosAPIProvider;
import com.baidu.talos.core.context.IRuntimeContext;
import com.baidu.talos.core.module.ITalosModuleWrapper;
import com.baidu.talos.core.module.ITalosModuleWrapper_TalosExtendModules_ListProvider;
import com.baidu.talos.core.module.TalosJSModule;
import com.baidu.talos.core.module.TalosNativeModule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TalosExtendModules implements TalosAPIProvider {
    ListHolder<ITalosModuleWrapper> moduleWrapperList;

    public void initmoduleWrapperList() {
        DefaultListHolder create = DefaultListHolder.create();
        this.moduleWrapperList = create;
        create.setList(new ITalosModuleWrapper_TalosExtendModules_ListProvider());
    }

    public TalosExtendModules() {
        initmoduleWrapperList();
        ListHolder<ITalosModuleWrapper> listHolder = this.moduleWrapperList;
        if (listHolder != null) {
            listHolder.setDefaultList(new Provider<List<ITalosModuleWrapper>>() {
                public List<ITalosModuleWrapper> get() {
                    return new ArrayList();
                }
            });
        }
    }

    public Map<Class<? extends TalosNativeModule>, com.baidu.talos.core.api.Provider<? extends TalosNativeModule>> getNativeModules(final IRuntimeContext context) {
        Map<Class<? extends TalosNativeModule>, com.baidu.talos.core.api.Provider<? extends TalosNativeModule>> map = new HashMap<>();
        ListHolder<ITalosModuleWrapper> listHolder = this.moduleWrapperList;
        if (listHolder == null) {
            return map;
        }
        for (final ITalosModuleWrapper moduleWrapper : listHolder.getList()) {
            if (moduleWrapper != null) {
                map.put(moduleWrapper.getModuleClass(), new com.baidu.talos.core.api.Provider<TalosNativeModule>() {
                    public TalosNativeModule get() {
                        return moduleWrapper.createModule(context);
                    }
                });
            }
        }
        return map;
    }

    public List<Class<? extends TalosJSModule>> getJavaScriptModules() {
        return null;
    }
}
