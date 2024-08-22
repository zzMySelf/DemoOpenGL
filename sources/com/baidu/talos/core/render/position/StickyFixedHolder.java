package com.baidu.talos.core.render.position;

import android.graphics.Rect;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.talos.core.Debug;
import com.baidu.talos.core.layout.LayoutConstants;
import com.baidu.talos.core.layout.LayoutUnit;
import com.baidu.talos.core.layout.LayoutValue;
import com.baidu.talos.core.render.IRenderInnerInterface;
import com.baidu.talos.core.render.IRenderInterface;
import com.baidu.talos.core.render.LayoutShadowNode;
import com.baidu.talos.core.render.ReactShadowNode;
import com.baidu.talos.core.render.TalosRenderImplementation;
import com.baidu.talos.core.render.TalosUIManagerHelper;
import com.baidu.talos.core.render.TalosUIViewOperationQueue;
import com.baidu.talos.core.render.ViewGroupManager;
import com.baidu.talos.core.render.ViewManager;
import com.baidu.talos.core.render.ViewProps;
import com.baidu.talos.core.render.events.ITalosTouchEventRegister;
import com.baidu.talos.core.render.util.RootViewUtil;
import com.baidu.talos.core.render.views.talosrecycleview.TLSRecyclerViewManager;
import com.baidu.talos.core.render.views.talosrecycleview.TLSTemplateManager;
import com.baidu.talos.core.render.views.waterfall.WaterfallRecycleViewManager;
import com.baidu.talos.view.scroll.IScroller;
import java.util.Set;

class StickyFixedHolder {
    static final int SCROLLER_Y_UNDEFINE = -1;
    static final int STICKY_STATUS_FIXED = 1;
    static final int STICKY_STATUS_NORMAL = 0;
    private static final String TAG = "PositionManager";
    private boolean hasSettleHandleTouch;
    private Boolean isNodeInRecyclerView;
    private final Rect mClipBounds = new Rect();
    private final LayoutShadowNode mCssNode;
    private boolean mHasInit;
    private boolean mHasScrollListener;
    private final int[] mLocation;
    private int mMiniScrollY = 0;
    private View mNodeView;
    private View mPlaceholderView;
    private String mPositionType;
    private final RecyclerView.OnScrollListener mRecyclerScrollListener = new RecyclerView.OnScrollListener() {
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            StickyFixedHolder.this.handleScrollChanged();
        }
    };
    private ReactShadowNode mRecyclerViewDirectChild;
    private ViewGroup mRootView;
    private ViewManager mRootViewManager;
    private View mScrollableView;
    private int mStickyNodeStatus = 0;

    public StickyFixedHolder(LayoutShadowNode node) {
        this.mCssNode = node;
        this.mLocation = new int[2];
    }

    public void release() {
        removeScrollListener();
    }

    private void initLayoutIfNeeded() {
        findPositioningView();
        if (!this.mHasInit && setViewNormal(-1)) {
            this.mHasInit = true;
        }
    }

    public void setPositionType(String type) {
        findPositioningView();
        if (Debug.isDebug()) {
            Log.d("PositionManager", "[StickyFixedHolder] setPosition:" + type + " nodeId:" + this.mCssNode.getReactTag());
        }
        if (ViewProps.POSITION_STICKY.equals(type)) {
            addScrollListener();
        } else {
            removeScrollListener();
        }
        this.mPositionType = type;
        setHandleTouchEvent();
    }

    public String getPositionType() {
        return this.mPositionType;
    }

    public ReactShadowNode getRecyclerViewDirectChild() {
        ReactShadowNode reactShadowNode = this.mRecyclerViewDirectChild;
        if (reactShadowNode != null) {
            return reactShadowNode;
        }
        if (!isNodeInRecyclerView()) {
            return null;
        }
        return this.mRecyclerViewDirectChild;
    }

    public boolean isViewCreated() {
        findPositioningView();
        return this.mNodeView != null;
    }

    public boolean isNodeInRecyclerView() {
        Boolean bool = this.isNodeInRecyclerView;
        if (bool != null) {
            return bool.booleanValue();
        }
        ReactShadowNode node = this.mCssNode;
        while (node != null && !node.isRootNode()) {
            ReactShadowNode parentNode = node.getParent();
            if (parentNode == null) {
                break;
            }
            String parentViewClass = parentNode.getViewClass();
            if (TLSRecyclerViewManager.TALOS_RECYCLER_CLASS_NAME.equals(parentViewClass) || WaterfallRecycleViewManager.REACT_CLASS.equals(parentViewClass)) {
                this.mRecyclerViewDirectChild = node;
                this.isNodeInRecyclerView = true;
                return true;
            }
            node = parentNode;
        }
        this.isNodeInRecyclerView = false;
        return false;
    }

    public boolean isFixedOrStickyFixed() {
        String positionType = this.mCssNode.getPositionTypeString();
        if (!"fixed".equals(positionType) && !ViewProps.POSITION_STICKY.equals(positionType)) {
            return false;
        }
        return true;
    }

    public void onNodeRemoved(TalosUIViewOperationQueue uiViewOperationQueue) {
        if (isFixedOrStickyFixed()) {
            if (Debug.isDebug()) {
                Log.d("PositionManager", "[StickyFixedHolder]节点被移除：" + this.mCssNode.getReactTag());
            }
            ReactShadowNode rootNode = this.mCssNode.getRootNode();
            if (rootNode != null) {
                uiViewOperationQueue.enqueueDeleteChildren(rootNode.getReactTag(), new long[]{this.mCssNode.getReactTag()});
            }
        }
    }

    public void checkPositionStatus() {
        findPositioningView();
        if (this.mNodeView != null) {
            initLayoutIfNeeded();
            if (ViewProps.POSITION_STICKY.equals(this.mPositionType)) {
                addScrollListener();
            } else {
                removeScrollListener();
            }
            if (ViewProps.POSITION_STICKY.equals(this.mPositionType)) {
                handleStickyType2(false);
            } else if ("fixed".equals(this.mPositionType)) {
                handleFixedType();
            } else {
                setViewNormal(-1);
            }
        }
    }

    public View getNodeView() {
        if (this.mNodeView == null) {
            findPositioningView();
        }
        return this.mNodeView;
    }

    public void updateViewProps(TLSTemplateManager templateManager) {
        View view2 = this.mNodeView;
        if (view2 != null) {
            templateManager.updateViewProps(view2, this.mCssNode, (Set<Long>) null);
        }
    }

    private float getPositionTopValue() {
        SparseArray<LayoutValue> layoutValues = this.mCssNode.getPositionValues();
        if (layoutValues == null) {
            return 0.0f;
        }
        return getPositionValue(layoutValues.get(1));
    }

    private float getPositionValue(LayoutValue value) {
        if (value == null) {
            return 0.0f;
        }
        if ((value.unit == LayoutUnit.POINT || value.unit == LayoutUnit.UNDEFINED) && !LayoutConstants.isUndefined(value.value)) {
            return value.value;
        }
        return 0.0f;
    }

    private void setHandleTouchEvent() {
        if (!this.hasSettleHandleTouch && this.mNodeView != null) {
            if (ViewProps.POSITION_STICKY.equals(this.mPositionType) || "fixed".equals(this.mPositionType)) {
                View view2 = this.mNodeView;
                if (view2 instanceof ITalosTouchEventRegister) {
                    ITalosTouchEventRegister register = (ITalosTouchEventRegister) view2;
                    register.registeEventType(2);
                    register.registeEventType(3);
                    register.registeEventType(4);
                    register.registeEventType(5);
                    register.registeEventType(0);
                    register.registeEventType(1);
                    this.hasSettleHandleTouch = true;
                }
            }
        }
    }

    private void findPositioningView() {
        if (this.mNodeView == null) {
            this.mNodeView = TalosUIManagerHelper.getRenderImpl(this.mCssNode.getThemedContext()).resolveView(this.mCssNode.getReactTag());
        }
        setHandleTouchEvent();
    }

    private void addScrollListener() {
        if (!this.mHasScrollListener && this.mNodeView != null && !this.mCssNode.isRootNode()) {
            for (ViewParent parent = this.mNodeView.getParent(); parent != null; parent = parent.getParent()) {
                if (parent instanceof RecyclerView) {
                    ((RecyclerView) parent).addOnScrollListener(this.mRecyclerScrollListener);
                    this.mScrollableView = (RecyclerView) parent;
                    this.mHasScrollListener = true;
                    return;
                }
            }
        }
    }

    private void removeScrollListener() {
        if (this.mHasScrollListener) {
            View view2 = this.mScrollableView;
            if (view2 instanceof RecyclerView) {
                ((RecyclerView) view2).removeOnScrollListener(this.mRecyclerScrollListener);
            }
            this.mHasScrollListener = false;
        }
    }

    /* access modifiers changed from: private */
    public void handleScrollChanged() {
        if (this.mNodeView != null && ViewProps.POSITION_STICKY.equals(this.mPositionType)) {
            handleStickyType2(true);
        }
    }

    private void findRootView() {
        ReactShadowNode rootNode;
        View view2 = this.mNodeView;
        if (view2 != null && this.mRootView == null) {
            this.mRootView = (ViewGroup) RootViewUtil.getRootView(view2);
        }
        IRenderInterface uiManager = TalosUIManagerHelper.getRenderImpl(this.mCssNode.getThemedContext());
        if (uiManager != null && (rootNode = this.mCssNode.getRootNode()) != null) {
            if (this.mRootView == null) {
                this.mRootView = (ViewGroup) uiManager.resolveView(rootNode.getReactTag());
            }
            this.mRootViewManager = ((TalosRenderImplementation) uiManager).resolveViewManager(rootNode.getReactTag());
        }
    }

    private void handleFixedType() {
        findRootView();
        if (this.mNodeView != null) {
            setViewFixed();
        }
    }

    private void handleStickyType2(boolean byScrollChanged) {
        ViewGroup viewGroup;
        findRootView();
        if (this.mNodeView != null && (viewGroup = this.mRootView) != null && (this.mScrollableView instanceof IScroller)) {
            int[] location = new int[2];
            viewGroup.getLocationInWindow(location);
            float rootInWindowTop = (float) location[1];
            this.mScrollableView.getLocationInWindow(location);
            float scrollableInWindowTop = (float) location[1];
            float positionTopValue = getPositionTopValue();
            int curScrollerY = ((IScroller) this.mScrollableView).getScrollerY();
            if (isNormal()) {
                this.mNodeView.getLocationInWindow(location);
                float nodeInWindowTop = (float) location[1];
                if (nodeInWindowTop - scrollableInWindowTop >= positionTopValue) {
                    this.mNodeView.getLocationInWindow(this.mLocation);
                    setViewNormal(curScrollerY);
                    return;
                }
                this.mMiniScrollY = curScrollerY - Math.round(positionTopValue - (nodeInWindowTop - scrollableInWindowTop));
            } else if (curScrollerY < this.mMiniScrollY) {
                setViewNormal(curScrollerY);
                return;
            }
            if (addNodeToRoot(this.mNodeView, this.mCssNode, true, curScrollerY)) {
                int viewInWindowLeft = this.mLocation[0];
                float destOffsetYInRoot = (scrollableInWindowTop - rootInWindowTop) + positionTopValue;
                if (destOffsetYInRoot >= (scrollableInWindowTop - rootInWindowTop) + ((float) this.mScrollableView.getHeight())) {
                    if (Debug.isDebug()) {
                        Log.d("PositionManager", "[StickyFixedHolder][handleStickyType2] PositionItem已经在屏幕底部外了：" + this.mCssNode.getReactTag());
                    }
                    setViewNormal(curScrollerY);
                    return;
                }
                this.mStickyNodeStatus = 1;
                if (this.mCssNode.getLayoutHeight() + destOffsetYInRoot > (scrollableInWindowTop - rootInWindowTop) + ((float) this.mScrollableView.getHeight())) {
                    this.mClipBounds.set(0, 0, this.mNodeView.getWidth(), (int) (((scrollableInWindowTop - rootInWindowTop) + ((float) this.mScrollableView.getHeight())) - destOffsetYInRoot));
                    this.mNodeView.setClipBounds(this.mClipBounds);
                } else {
                    this.mNodeView.setClipBounds((Rect) null);
                }
                if (Debug.isDebug() && destOffsetYInRoot == 0.0f) {
                    Log.d("PositionManager", "[StickyFixedHolder][handleStickyType2] layout到根节点顶部。" + this.mCssNode.getReactTag() + " rootInWindowTop:" + rootInWindowTop + " scrollableInWindowTop:" + scrollableInWindowTop + " positionTopValue:" + positionTopValue);
                }
                this.mNodeView.measure(View.MeasureSpec.makeMeasureSpec(this.mCssNode.getScreenWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.mCssNode.getScreenHeight(), 1073741824));
                this.mNodeView.layout((int) (((float) viewInWindowLeft) + this.mCssNode.getLayoutX()), (int) destOffsetYInRoot, (int) (((float) viewInWindowLeft) + this.mCssNode.getLayoutX() + this.mCssNode.getLayoutWidth()), (int) (this.mCssNode.getLayoutHeight() + destOffsetYInRoot));
            }
        }
    }

    private boolean addNodeToRoot(View nodeView, LayoutShadowNode node, boolean addPlaceholder, int scrollerY) {
        ViewGroup parentView;
        if (nodeView == null || node == null || (parentView = (ViewGroup) nodeView.getParent()) == null || !parentView.isAttachedToWindow()) {
            return false;
        }
        if (parentView == this.mRootView || this.mStickyNodeStatus == 1) {
            return true;
        }
        ReactShadowNode parentNode = node.getParent();
        if (parentNode == null) {
            return false;
        }
        IRenderInnerInterface renderImpl = TalosUIManagerHelper.getRenderImpl(node.getThemedContext());
        ViewGroup parentNodeView = (ViewGroup) renderImpl.resolveView(parentNode.getReactTag());
        if (parentNodeView == null) {
            return false;
        }
        this.mStickyNodeStatus = 1;
        ViewManager parentViewManager = ((TalosRenderImplementation) renderImpl).resolveViewManager(parentNode.getViewClass());
        if (!(parentViewManager instanceof ViewGroupManager)) {
            return false;
        }
        ((ViewGroupManager) parentViewManager).removeView(parentNodeView, nodeView);
        if (addPlaceholder) {
            addPlaceholder(parentViewManager, parentNodeView, parentNode.indexOf(node));
            View view2 = this.mScrollableView;
            if (view2 instanceof IScroller) {
                ((IScroller) view2).setScrollerY(scrollerY >= 0 ? scrollerY : this.mMiniScrollY);
            }
        }
        parentView.removeView(nodeView);
        ViewManager viewManager = this.mRootViewManager;
        if (viewManager instanceof ViewGroupManager) {
            ((ViewGroupManager) viewManager).addView(this.mRootView, nodeView, -1);
        } else {
            this.mRootView.addView(nodeView);
        }
        return true;
    }

    private boolean addNodeToOrigin(View nodeView, LayoutShadowNode node, int scrollerY) {
        ViewGroup currentParentView;
        if (nodeView == null || node == null || (currentParentView = (ViewGroup) nodeView.getParent()) == null) {
            return false;
        }
        if (currentParentView != this.mRootView || this.mStickyNodeStatus == 0) {
            return true;
        }
        ReactShadowNode parentNode = node.getParent();
        if (parentNode == null) {
            return false;
        }
        IRenderInnerInterface renderImpl = TalosUIManagerHelper.getRenderImpl(node.getThemedContext());
        ViewManager parentViewManager = ((TalosRenderImplementation) renderImpl).resolveViewManager(parentNode.getViewClass());
        ViewGroup parentNodeView = (ViewGroup) renderImpl.resolveView(parentNode.getReactTag());
        if (parentNodeView == null || parentViewManager == null) {
            return false;
        }
        this.mStickyNodeStatus = 0;
        ViewManager viewManager = this.mRootViewManager;
        if (viewManager instanceof ViewGroupManager) {
            ((ViewGroupManager) viewManager).removeView(currentParentView, nodeView);
        } else {
            currentParentView.removeView(nodeView);
        }
        if (!(parentViewManager instanceof ViewGroupManager)) {
            return false;
        }
        ((ViewGroupManager) parentViewManager).removeView(parentNodeView, this.mPlaceholderView);
        ((ViewGroupManager) parentViewManager).addView(parentNodeView, nodeView, parentNode.indexOf(node));
        if (scrollerY >= 0) {
            View view2 = this.mScrollableView;
            if (view2 instanceof IScroller) {
                ((IScroller) view2).setScrollerY(scrollerY);
            }
        }
        return true;
    }

    private void addPlaceholder(ViewManager viewManager, ViewGroup parent, int index) {
        View view2 = this.mPlaceholderView;
        if (view2 == null) {
            this.mPlaceholderView = new View(parent.getContext());
        } else {
            ViewGroup placeHolderParent = (ViewGroup) view2.getParent();
            if (placeHolderParent != null) {
                placeHolderParent.removeView(this.mPlaceholderView);
            }
        }
        if (viewManager instanceof ViewGroupManager) {
            ((ViewGroupManager) viewManager).addView(parent, this.mPlaceholderView, index);
        } else {
            parent.addView(this.mPlaceholderView, index);
        }
        float x = this.mCssNode.getLayoutX();
        float y = this.mCssNode.getLayoutY();
        this.mPlaceholderView.measure(View.MeasureSpec.makeMeasureSpec(this.mCssNode.getScreenWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.mCssNode.getScreenHeight(), 1073741824));
        this.mPlaceholderView.layout((int) x, (int) y, (int) (this.mCssNode.getLayoutWidth() + x), (int) (this.mCssNode.getLayoutHeight() + y));
    }

    /* access modifiers changed from: package-private */
    public boolean isNormal() {
        return ((ViewGroup) this.mNodeView.getParent()) != this.mRootView;
    }

    /* access modifiers changed from: package-private */
    public boolean setViewNormal(int scrollerY) {
        if (!addNodeToOrigin(this.mNodeView, this.mCssNode, scrollerY)) {
            return false;
        }
        this.mStickyNodeStatus = 0;
        float x = this.mCssNode.getLayoutX();
        float y = this.mCssNode.getLayoutY();
        if (((float) this.mNodeView.getLeft()) == x && ((float) this.mNodeView.getTop()) == y && ((float) this.mNodeView.getRight()) == this.mCssNode.getLayoutWidth() + x && ((float) this.mNodeView.getBottom()) == this.mCssNode.getLayoutHeight() + y) {
            return true;
        }
        this.mNodeView.measure(View.MeasureSpec.makeMeasureSpec(this.mCssNode.getScreenWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.mCssNode.getScreenHeight(), 1073741824));
        this.mNodeView.layout((int) x, (int) y, (int) (this.mCssNode.getLayoutWidth() + x), (int) (this.mCssNode.getLayoutHeight() + y));
        return true;
    }

    /* access modifiers changed from: private */
    public void setViewFixed() {
        SparseArray<LayoutValue> layoutValues;
        ViewGroup nodeParent = (ViewGroup) this.mNodeView.getParent();
        ViewGroup viewGroup = this.mRootView;
        if (viewGroup != null) {
            if (viewGroup.getHeight() <= 0) {
                this.mRootView.postDelayed(new Runnable() {
                    public void run() {
                        StickyFixedHolder.this.setViewFixed();
                    }
                }, 20);
                return;
            }
            boolean z = false;
            if (addNodeToRoot(this.mNodeView, this.mCssNode, false, -1) && (layoutValues = this.mCssNode.getPositionValues()) != null) {
                LayoutValue leftValue = layoutValues.get(4);
                LayoutValue topValue = layoutValues.get(1);
                LayoutValue rightValue = layoutValues.get(5);
                LayoutValue bottomValue = layoutValues.get(3);
                boolean leftValid = leftValue != null && !LayoutConstants.isUndefined(leftValue.value);
                boolean topValid = topValue != null && !LayoutConstants.isUndefined(topValue.value);
                boolean rightValid = rightValue != null && !LayoutConstants.isUndefined(rightValue.value);
                if (bottomValue != null && !LayoutConstants.isUndefined(bottomValue.value)) {
                    z = true;
                }
                boolean bottomValid = z;
                int x = 0;
                if (leftValid) {
                    x = (int) getPositionValue(leftValue);
                } else if (rightValid) {
                    x = (int) ((((float) this.mRootView.getWidth()) - this.mCssNode.getLayoutWidth()) - getPositionValue(rightValue));
                }
                int y = 0;
                if (topValid) {
                    y = (int) getPositionValue(topValue);
                } else if (bottomValid) {
                    y = (int) ((((float) this.mRootView.getHeight()) - this.mCssNode.getLayoutHeight()) - getPositionValue(bottomValue));
                }
                ViewGroup viewGroup2 = nodeParent;
                this.mNodeView.measure(View.MeasureSpec.makeMeasureSpec(this.mCssNode.getScreenWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.mCssNode.getScreenHeight(), 1073741824));
                this.mNodeView.layout(x, y, (int) (((float) x) + this.mCssNode.getLayoutWidth()), (int) (((float) y) + this.mCssNode.getLayoutHeight()));
            }
        }
    }
}
