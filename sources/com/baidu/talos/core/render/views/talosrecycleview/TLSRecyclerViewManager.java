package com.baidu.talos.core.render.views.talosrecycleview;

import com.baidu.talos.core.Debug;
import com.baidu.talos.core.context.TalosPageContext;
import com.baidu.talos.core.render.views.talosrecycleview.base.BaseRecyclerViewManager;
import com.baidu.talos.react.uimanager.annotations.TalosProp;
import com.baidu.talos.react.uimanager.annotations.TalosPropGroup;

public class TLSRecyclerViewManager extends BaseRecyclerViewManager<TLSRecycleView> {
    private static final boolean DEBUG = Debug.isDebug();
    private static final int[] SPACING_TYPES = {8, 0, 2, 1, 3};
    public static final String TALOS_RECYCLER_CLASS_NAME = "TalosRecycleView";

    public String getName() {
        return TALOS_RECYCLER_CLASS_NAME;
    }

    /* access modifiers changed from: protected */
    public TLSRecycleView createViewInstance(TalosPageContext reactContext) {
        return new TLSRecycleView(reactContext);
    }

    @TalosPropGroup(defaultFloat = Float.NaN, names = {"borderWidth", "borderLeftWidth", "borderRightWidth", "borderTopWidth", "borderBottomWidth"})
    public void setBorderWidth(TLSRecycleView view2, int position, float width) {
        view2.setBorderWidth(SPACING_TYPES[position], width);
    }

    @TalosProp(name = "borderStyle")
    public void setBorderStyle(TLSRecycleView view2, String borderStyle) {
        view2.setBorderStyle(borderStyle);
    }

    @TalosPropGroup(customType = "Color", names = {"borderColor", "borderLeftColor", "borderRightColor", "borderTopColor", "borderBottomColor"})
    public void setBorderColor(TLSRecycleView view2, int index, Integer color) {
        float rgbComponent;
        float alphaComponent = Float.NaN;
        if (color == null) {
            rgbComponent = Float.NaN;
        } else {
            rgbComponent = (float) (color.intValue() & 16777215);
        }
        if (color != null) {
            alphaComponent = (float) (color.intValue() >>> 24);
        }
        view2.setBorderColor(SPACING_TYPES[index], rgbComponent, alphaComponent);
    }

    @TalosProp(name = "pagingEnabled")
    public void setPagingEnabled(TLSRecycleView view2, boolean pagingEnabled) {
        view2.setPagingEnabled(pagingEnabled);
    }
}
