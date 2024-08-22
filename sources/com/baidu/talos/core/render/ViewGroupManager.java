package com.baidu.talos.core.render;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.talos.core.layout.ILayoutContext;
import com.baidu.talos.core.render.events.ITalosTouchEventRegister;
import com.baidu.talos.react.uimanager.annotations.TalosProp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

public abstract class ViewGroupManager<T extends ViewGroup & ITalosTouchEventRegister> extends BaseViewManager<T, LayoutShadowNode> {
    public static Map<View, Integer> mZIndexHash = Collections.synchronizedMap(new WeakHashMap());

    public LayoutShadowNode createShadowNodeInstance(ILayoutContext environment) {
        return new LayoutShadowNode(environment);
    }

    public Class<? extends LayoutShadowNode> getShadowNodeClass() {
        return LayoutShadowNode.class;
    }

    public void updateExtraData(T t, Object extraData) {
    }

    public void addView(T parent, View child, int index) {
        if (child.getParent() != null) {
            ((ViewGroup) child.getParent()).removeView(child);
        }
        if (index > parent.getChildCount()) {
            index = parent.getChildCount();
        }
        parent.addView(child, index);
        reorderChildrenByZIndex(parent);
    }

    public void addViews(T parent, List<View> views) {
        int size = views.size();
        for (int i2 = 0; i2 < size; i2++) {
            addView(parent, views.get(i2), i2);
        }
    }

    public static void setViewZIndex(View view2, int zIndex) {
        mZIndexHash.put(view2, Integer.valueOf(zIndex));
        ViewGroup parent = (ViewGroup) view2.getParent();
        if (parent != null) {
            reorderChildrenByZIndex(parent);
        }
    }

    public static void reorderChildrenByZIndex(ViewGroup view2) {
        boolean containsZIndexedElement = false;
        Iterator<Integer> it = mZIndexHash.values().iterator();
        while (true) {
            if (it.hasNext()) {
                if (it.next().intValue() != 0) {
                    containsZIndexedElement = true;
                    break;
                }
            } else {
                break;
            }
        }
        if (containsZIndexedElement) {
            ArrayList<View> viewsToSort = new ArrayList<>();
            for (int i2 = 0; i2 < view2.getChildCount(); i2++) {
                viewsToSort.add(view2.getChildAt(i2));
            }
            Collections.sort(viewsToSort, new Comparator<View>() {
                public int compare(View view1, View view2) {
                    return Integer.compare(ViewGroupManager.getViewZIndex(view1), ViewGroupManager.getViewZIndex(view2));
                }
            });
            for (int i3 = 0; i3 < viewsToSort.size(); i3++) {
                viewsToSort.get(i3).bringToFront();
            }
            view2.invalidate();
        }
    }

    /* access modifiers changed from: private */
    public static int getViewZIndex(View view2) {
        View tempView = view2;
        if (tempView instanceof ITouchDelegator) {
            tempView = ((ITouchDelegator) tempView).getLayerView();
        }
        Integer view1ZIndex = mZIndexHash.get(tempView);
        if (view1ZIndex == null) {
            view1ZIndex = 0;
        }
        return view1ZIndex.intValue();
    }

    public int getChildCount(T parent) {
        return parent.getChildCount();
    }

    public View getChildAt(T parent, int index) {
        return parent.getChildAt(index);
    }

    public void removeViewAt(T parent, int index) {
        parent.removeViewAt(index);
    }

    public void removeView(T parent, View view2) {
        for (int i2 = 0; i2 < getChildCount(parent); i2++) {
            if (getChildAt(parent, i2) == view2) {
                removeViewAt(parent, i2);
                return;
            }
        }
    }

    public void removeAllViews(T parent) {
        for (int i2 = getChildCount(parent) - 1; i2 >= 0; i2--) {
            removeViewAt(parent, i2);
        }
    }

    public boolean needsCustomLayoutForChildren() {
        return false;
    }

    public boolean shouldPromoteGrandchildren() {
        return false;
    }

    @TalosProp(defaultBoolean = false, name = "onInterceptTouchEvent")
    public void setOnInterceptTouchEvent(T view2, boolean flag) {
        setTouchEventType(view2, 6, flag);
    }

    @TalosProp(defaultBoolean = false, name = "onInterceptPullUpEvent")
    public void setOnInterceptPullUpEvent(T view2, boolean flag) {
        setTouchEventType(view2, 7, flag);
    }
}
