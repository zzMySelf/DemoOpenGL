package com.baidu.talos.core.render;

import com.baidu.talos.core.common.MapBuilder;
import com.baidu.talos.core.context.IRuntimeContext;
import com.baidu.talos.core.render.IUIManagerInterface;
import java.util.List;
import java.util.Map;

public class ViewManagerRegistry {
    private IRuntimeContext mRuntimeContext;
    private final IUIManagerInterface.ViewManagerResolver mViewManagerResolver;
    private final Map<String, ViewManager> mViewManagers;

    public ViewManagerRegistry(IRuntimeContext context, List<ViewManager> viewManagerList) {
        Map<String, ViewManager> viewManagerMap = MapBuilder.newHashMap();
        for (ViewManager viewManager : viewManagerList) {
            viewManagerMap.put(viewManager.getName(), viewManager);
        }
        this.mRuntimeContext = context;
        this.mViewManagers = viewManagerMap;
        this.mViewManagerResolver = null;
    }

    public ViewManagerRegistry(IRuntimeContext context, Map<String, ViewManager> viewManagerMap) {
        Map<String, ViewManager> map;
        if (viewManagerMap != null) {
            map = viewManagerMap;
        } else {
            map = MapBuilder.newHashMap();
        }
        this.mViewManagers = map;
        this.mRuntimeContext = context;
        this.mViewManagerResolver = null;
    }

    public ViewManager get(String className) {
        ViewManager viewManager;
        ViewManager viewManager2 = this.mViewManagers.get(className);
        if (viewManager2 != null) {
            return viewManager2;
        }
        IUIManagerInterface.ViewManagerResolver viewManagerResolver = this.mViewManagerResolver;
        if (viewManagerResolver == null || (viewManager = viewManagerResolver.getViewManager(className)) == null) {
            this.mRuntimeContext.getExceptionHandler().handleJavaException("ViewManager not existe", new IllegalViewOperationException("No ViewManager defined for class " + className));
            return null;
        }
        this.mViewManagers.put(className, viewManager);
        return viewManager;
    }
}
