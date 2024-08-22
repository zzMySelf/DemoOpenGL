package com.baidu.searchbox.flex.core;

import android.content.Context;
import android.graphics.Rect;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.flex.core.Component;
import com.baidu.searchbox.flex.core.RenderUnit;
import com.baidu.searchbox.flex.core.mount.MountItem;

public class FlexRenderUnit extends RenderUnit<Object> {
    private static final boolean DEBUG = AppConfig.isDebug();
    private final ComponentContext mContext;
    final long mId;
    public LayoutOutput output;

    public static ComponentContext getComponentContext(MountItem item) {
        return ((FlexRenderUnit) item.getRenderTreeNode().getRenderUnit()).mContext;
    }

    public static ComponentContext getComponentContext(RenderTreeNode node) {
        return ((FlexRenderUnit) node.getRenderUnit()).mContext;
    }

    public static ComponentContext getComponentContext(FlexRenderUnit unit) {
        return unit.mContext;
    }

    public static FlexRenderUnit create(long id, Component component, ComponentContext context, int flags) {
        return new FlexRenderUnit(id, new LayoutOutput(component, flags), context);
    }

    public static RenderTreeNode create(FlexRenderUnit unit, Rect bounds, FlexLayoutData layoutData, RenderTreeNode parent) {
        return new RenderTreeNode(parent, unit, layoutData, bounds, (Rect) null, parent != null ? parent.getChildrenCount() : 0);
    }

    public FlexRenderUnit(long id, LayoutOutput output2, ComponentContext context) {
        super(getRenderType(output2));
        this.output = output2;
        this.mContext = context;
        this.mId = id;
    }

    public Object createContent(Context c2) {
        return this.output.getComponent().createMountContent(c2);
    }

    public long getId() {
        return this.mId;
    }

    private static RenderUnit.RenderType getRenderType(LayoutOutput output2) {
        if (output2 == null && DEBUG) {
            throw new IllegalArgumentException("Null output used for FlexRenderUnit.");
        } else if (output2.getComponent().getMountType() == Component.MountType.DRAWABLE) {
            return RenderUnit.RenderType.DRAWABLE;
        } else {
            return RenderUnit.RenderType.VIEW;
        }
    }
}
