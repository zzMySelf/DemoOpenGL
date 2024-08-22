package com.baidu.talos.core.render.debug;

public interface NotThreadSafeViewHierarchyUpdateDebugListener {
    void onViewHierarchyUpdateEnqueued();

    void onViewHierarchyUpdateFinished();
}
