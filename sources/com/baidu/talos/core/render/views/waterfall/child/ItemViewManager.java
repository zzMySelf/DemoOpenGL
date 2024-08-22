package com.baidu.talos.core.render.views.waterfall.child;

import com.baidu.talos.core.context.TalosPageContext;
import com.baidu.talos.core.layout.ILayoutContext;
import com.baidu.talos.core.render.LayoutShadowNode;
import com.baidu.talos.core.render.views.viewgroup.ReactViewGroup;
import java.util.Map;
import javax.annotation.Nullable;

public class ItemViewManager extends BaseChildViewManager {
    public static final String REACT_CLASS = "WaterfallItem";

    public /* bridge */ /* synthetic */ LayoutShadowNode createShadowNodeInstance(ILayoutContext iLayoutContext) {
        return super.createShadowNodeInstance(iLayoutContext);
    }

    public /* bridge */ /* synthetic */ ReactViewGroup createViewInstance(TalosPageContext talosPageContext) {
        return super.createViewInstance(talosPageContext);
    }

    @Nullable
    public /* bridge */ /* synthetic */ Map getExportedCustomDirectEventTypeConstants() {
        return super.getExportedCustomDirectEventTypeConstants();
    }

    public /* bridge */ /* synthetic */ Class getShadowNodeClass() {
        return super.getShadowNodeClass();
    }

    public String getName() {
        return REACT_CLASS;
    }
}
