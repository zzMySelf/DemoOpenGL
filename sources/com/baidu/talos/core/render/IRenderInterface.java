package com.baidu.talos.core.render;

import android.view.View;
import com.baidu.talos.core.data.ParamMap;
import com.baidu.talos.core.render.events.IUIEventDispatcher;

public interface IRenderInterface {
    IUIEventDispatcher getEventDispatcher();

    ReactShadowNode resolveShadowNode(long j2);

    View resolveView(long j2);

    void synchronouslyUpdateViewOnUIThread(long j2, ReactStylesDiffMap reactStylesDiffMap);

    void updateLayoutProps(long j2, ParamMap paramMap);

    void updateNodeSize(long j2, int i2, int i3);

    void updateViewProps(long j2, ParamMap paramMap);
}
