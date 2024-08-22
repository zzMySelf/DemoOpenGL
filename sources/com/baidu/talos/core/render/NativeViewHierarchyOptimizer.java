package com.baidu.talos.core.render;

import android.util.Log;
import android.util.LongSparseArray;
import com.baidu.talos.core.context.TalosPageContext;
import com.baidu.talos.core.data.ParamArray;
import com.baidu.talos.core.data.ParamMapKeySetIterator;
import com.baidu.talos.core.render.position.PositionManager;
import com.baidu.talos.core.render.precreate.ViewPreCreateManager;
import com.baidu.talos.util.NumberUtils;
import com.facebook.infer.annotation.Assertions;
import java.util.Set;

public class NativeViewHierarchyOptimizer implements IUIViewUpdater {
    public static final String TAG = "TLS_NVHOptimizer";
    private final boolean mEnable;
    private final ShadowNodeRegistry mShadowNodeRegistry;
    private final LongSparseArray<Boolean> mTagsWithLayoutVisited = new LongSparseArray<>();
    private final UIViewOperationQueue mUIViewOperationQueue;

    private static class NodeIndexPair {
        public final int index;
        public final ReactShadowNode node;

        NodeIndexPair(ReactShadowNode node2, int index2) {
            this.node = node2;
            this.index = index2;
        }
    }

    public NativeViewHierarchyOptimizer(UIViewOperationQueue uiViewOperationQueue, ShadowNodeRegistry shadowNodeRegistry, boolean enable) {
        this.mUIViewOperationQueue = uiViewOperationQueue;
        this.mShadowNodeRegistry = shadowNodeRegistry;
        this.mEnable = enable;
    }

    public UIViewOperationQueue getUIViewOperationQueue() {
        return this.mUIViewOperationQueue;
    }

    public void handleCreateView(ReactShadowNode node, TalosPageContext themedContext, ReactStylesDiffMap initialProps, ViewPreCreateManager preCreateManager) {
        if (!this.mEnable) {
            this.mUIViewOperationQueue.enqueueCreateView(themedContext, node.getReactTag(), node.getViewClass(), initialProps, preCreateManager);
            return;
        }
        boolean isLayoutOnly = false;
        if (!node.mIsForceNonLayout) {
            isLayoutOnly = node.getViewClass().equals("View") && isLayoutOnlyAndCollapsable(initialProps);
        }
        node.setIsLayoutOnly(isLayoutOnly);
        if (!isLayoutOnly) {
            this.mUIViewOperationQueue.enqueueCreateView(themedContext, node.getReactTag(), node.getViewClass(), initialProps, preCreateManager);
        }
    }

    public void handleRemoveNode(ReactShadowNode node) {
        node.removeAllNativeChildren();
    }

    public void handleUpdateView(ReactShadowNode node, String className, ReactStylesDiffMap props, Set<String> ignoreProps) {
        if (!this.mEnable) {
            this.mUIViewOperationQueue.enqueueUpdateProperties(node.getReactTag(), className, props, ignoreProps);
            return;
        }
        if (node.isLayoutOnly() && !isLayoutOnlyAndCollapsable(props)) {
            transitionLayoutOnlyViewToNativeView(node, props);
        } else if (!node.isLayoutOnly()) {
            this.mUIViewOperationQueue.enqueueUpdateProperties(node.getReactTag(), className, props, ignoreProps);
        }
    }

    public void handleUpdateViewForNative(ReactShadowNode node, String className, ReactStylesDiffMap props) {
        if (!this.mEnable) {
            this.mUIViewOperationQueue.enqueueUpdatePropertiesForNative(node.getReactTag(), className, props);
            return;
        }
        if (node.isLayoutOnly() && !isLayoutOnlyAndCollapsable(props)) {
            transitionLayoutOnlyViewToNativeView(node, props);
        } else if (!node.isLayoutOnly()) {
            this.mUIViewOperationQueue.enqueueUpdatePropertiesForNative(node.getReactTag(), className, props);
        }
    }

    public void handleManageChildren(ReactShadowNode nodeToManage, int[] indicesToRemove, int[] tagsToRemove, ViewAtIndex[] viewsToAdd, long[] tagsToDelete) {
        if (!this.mEnable) {
            this.mUIViewOperationQueue.enqueueManageChildren(nodeToManage.getReactTag(), indicesToRemove, viewsToAdd, tagsToDelete);
            return;
        }
        for (int tagToRemove : tagsToRemove) {
            boolean delete = false;
            int j2 = 0;
            while (true) {
                if (j2 >= tagsToDelete.length) {
                    break;
                } else if (tagsToDelete[j2] == ((long) tagToRemove)) {
                    delete = true;
                    break;
                } else {
                    j2++;
                }
            }
            removeNodeFromParent(this.mShadowNodeRegistry.getNode((long) tagToRemove), delete);
        }
        int i2 = 0;
        while (i2 < viewsToAdd.length) {
            ViewAtIndex toAdd = viewsToAdd[i2];
            ReactShadowNode nodeToAdd = this.mShadowNodeRegistry.getNode(toAdd.mTag);
            if (nodeToAdd == null) {
                Log.w(TAG, "Tried to addNodeToNode, but nodeToAdd is a non-existent tag: " + toAdd.mTag);
                return;
            } else {
                addNodeToNode(nodeToManage, nodeToAdd, toAdd.mIndex);
                i2++;
            }
        }
    }

    public void handleSetChildren(ReactShadowNode nodeToManage, ParamArray childrenTags) {
        if (!this.mEnable) {
            this.mUIViewOperationQueue.enqueueSetChildren(nodeToManage.getReactTag(), childrenTags);
            return;
        }
        for (int i2 = 0; i2 < childrenTags.size(); i2++) {
            addNodeToNode(nodeToManage, this.mShadowNodeRegistry.getNode((long) childrenTags.getInteger(i2)), i2);
        }
    }

    public void enqueueUpdateExtraData(long reactTag, Object extraData) {
        this.mUIViewOperationQueue.enqueueUpdateExtraData(reactTag, extraData);
    }

    public void handleUpdateLayout(ReactShadowNode node) {
        if (node.mCellNodeTag == 0) {
            if (!this.mEnable) {
                PositionManager positionManager = PositionManager.from(node);
                if (positionManager == null || positionManager.needYogaLayoutView(node)) {
                    ReactShadowNode pNode = node.getParent();
                    if (pNode != null) {
                        this.mUIViewOperationQueue.enqueueUpdateLayout(pNode.getReactTag(), node.getReactTag(), node.getScreenX(), node.getScreenY(), node.getScreenX(), node.getScreenY(), node.getScreenWidth(), node.getScreenHeight(), node.shouldNotifyOnLayoutAndResetFlag(false));
                    } else {
                        Log.e(TAG, "pNode is null");
                    }
                }
            } else {
                applyLayoutBase(node);
            }
        }
    }

    public void onBatchComplete() {
        this.mTagsWithLayoutVisited.clear();
    }

    private NodeIndexPair walkUpUntilNonLayoutOnly(ReactShadowNode node, int indexInNativeChildren) {
        int indexOffset;
        while (node.isLayoutOnly()) {
            ReactShadowNode parent = node.getParent();
            if (parent == null || (indexOffset = parent.getNativeOffsetForChild(node)) < 0) {
                return null;
            }
            indexInNativeChildren += indexOffset;
            node = parent;
        }
        return new NodeIndexPair(node, indexInNativeChildren);
    }

    public void addNodeToNode(ReactShadowNode parent, ReactShadowNode child, int index) {
        int indexInNativeChildren;
        if (index >= 0 && index <= parent.getChildCount() - 1 && parent.getChildAt(index) != null && (indexInNativeChildren = parent.getNativeOffsetForChild(parent.getChildAt(index))) >= 0) {
            if (parent.isLayoutOnly()) {
                NodeIndexPair result = walkUpUntilNonLayoutOnly(parent, indexInNativeChildren);
                if (result != null) {
                    parent = result.node;
                    indexInNativeChildren = result.index;
                } else {
                    return;
                }
            }
            if (!child.isLayoutOnly()) {
                addNonLayoutNode(parent, child, indexInNativeChildren);
            } else {
                addLayoutOnlyNode(parent, child, indexInNativeChildren);
            }
        }
    }

    private void removeNodeFromParent(ReactShadowNode nodeToRemove, boolean shouldDelete) {
        ReactShadowNode nativeNodeToRemoveFrom = nodeToRemove.getNativeParent();
        if (nativeNodeToRemoveFrom != null) {
            int index = nativeNodeToRemoveFrom.indexOfNativeChild(nodeToRemove);
            nativeNodeToRemoveFrom.removeNativeChildAt(index);
            this.mUIViewOperationQueue.enqueueManageChildren(nativeNodeToRemoveFrom.getReactTag(), new int[]{index}, (ViewAtIndex[]) null, shouldDelete ? new long[]{nodeToRemove.getReactTag()} : null);
            return;
        }
        for (int i2 = nodeToRemove.getChildCount() - 1; i2 >= 0; i2--) {
            removeNodeFromParent(nodeToRemove.getChildAt(i2), shouldDelete);
        }
    }

    private void addLayoutOnlyNode(ReactShadowNode nonLayoutOnlyNode, ReactShadowNode layoutOnlyNode, int index) {
        addGrandchildren(nonLayoutOnlyNode, layoutOnlyNode, index);
    }

    private void addNonLayoutNode(ReactShadowNode parent, ReactShadowNode child, int index) {
        parent.addNativeChildAt(child, index);
        this.mUIViewOperationQueue.enqueueManageChildren(parent.getReactTag(), (int[]) null, new ViewAtIndex[]{new ViewAtIndex(child.getReactTag(), index)}, (long[]) null);
    }

    private void addGrandchildren(ReactShadowNode nativeParent, ReactShadowNode child, int index) {
        if (!nativeParent.isLayoutOnly()) {
            Log.e(TAG, " nativeParent.isLayoutOnly() false");
            return;
        }
        int currentIndex = index;
        for (int i2 = 0; i2 < child.getChildCount(); i2++) {
            ReactShadowNode grandchild = child.getChildAt(i2);
            if (grandchild.getNativeParent() == null) {
                Log.e(TAG, "grandchild can not find a parent, stop current operation");
                return;
            }
            if (grandchild.isLayoutOnly()) {
                int grandchildCountBefore = nativeParent.getNativeChildCount();
                addLayoutOnlyNode(nativeParent, grandchild, currentIndex);
                currentIndex += nativeParent.getNativeChildCount() - grandchildCountBefore;
            } else {
                addNonLayoutNode(nativeParent, grandchild, currentIndex);
                currentIndex++;
            }
        }
    }

    private void applyLayoutBase(ReactShadowNode node) {
        long tag = node.getReactTag();
        if (!NumberUtils.value(this.mTagsWithLayoutVisited.get(tag))) {
            this.mTagsWithLayoutVisited.put(tag, true);
            ReactShadowNode parent = node.getParent();
            int x = node.getScreenX();
            int y = node.getScreenY();
            while (parent != null && parent.isLayoutOnly()) {
                x += Math.round(parent.getLayoutX());
                y += Math.round(parent.getLayoutY());
                parent = parent.getParent();
            }
            applyLayoutRecursive(node, x, y);
        }
    }

    private void applyLayoutRecursive(ReactShadowNode toUpdate, int x, int y) {
        ReactShadowNode reactShadowNode = toUpdate;
        if (toUpdate.isLayoutOnly() || toUpdate.getNativeParent() == null) {
            for (int i2 = 0; i2 < toUpdate.getChildCount(); i2++) {
                ReactShadowNode child = reactShadowNode.getChildAt(i2);
                long childTag = child.getReactTag();
                if (!NumberUtils.value(this.mTagsWithLayoutVisited.get(childTag))) {
                    this.mTagsWithLayoutVisited.put(childTag, true);
                    applyLayoutRecursive(child, child.getScreenX() + x, child.getScreenY() + y);
                }
            }
            return;
        }
        PositionManager positionManager = PositionManager.from(toUpdate);
        if (positionManager == null || positionManager.needYogaLayoutView(reactShadowNode)) {
            this.mUIViewOperationQueue.enqueueUpdateLayout(toUpdate.getNativeParent().getReactTag(), toUpdate.getReactTag(), x, y, toUpdate.getScreenX(), toUpdate.getScreenY(), toUpdate.getScreenWidth(), toUpdate.getScreenHeight(), reactShadowNode.shouldNotifyOnLayoutAndResetFlag(false));
        }
    }

    private void transitionLayoutOnlyViewToNativeView(ReactShadowNode node, ReactStylesDiffMap props) {
        ReactShadowNode parent = node.getParent();
        boolean z = false;
        if (parent == null) {
            node.setIsLayoutOnly(false);
            return;
        }
        int childIndex = parent.indexOf(node);
        parent.removeChildAt(childIndex);
        removeNodeFromParent(node, false);
        node.setIsLayoutOnly(false);
        ReactShadowNode rootNode = node.getRootNode();
        if (rootNode != null) {
            this.mUIViewOperationQueue.enqueueCreateView(rootNode.getThemedContext(), node.getReactTag(), node.getViewClass(), props, (ViewPreCreateManager) null);
            parent.addChildAt(node, childIndex);
            addNodeToNode(parent, node, childIndex);
            for (int i2 = 0; i2 < node.getChildCount(); i2++) {
                addNodeToNode(node, node.getChildAt(i2), i2);
            }
            if (this.mTagsWithLayoutVisited.size() == 0) {
                z = true;
            }
            Assertions.assertCondition(z);
            applyLayoutBase(node);
            for (int i3 = 0; i3 < node.getChildCount(); i3++) {
                applyLayoutBase(node.getChildAt(i3));
            }
            this.mTagsWithLayoutVisited.clear();
        }
    }

    private static boolean isLayoutOnlyAndCollapsable(ReactStylesDiffMap props) {
        if (props == null) {
            return true;
        }
        if (props.hasKey(ViewProps.COLLAPSABLE) && !props.getBoolean(ViewProps.COLLAPSABLE, true)) {
            return false;
        }
        ParamMapKeySetIterator keyIterator = props.mBackingMap.keySetIterator();
        while (keyIterator.hasNextKey()) {
            if (!ViewProps.isLayoutOnly(props.mBackingMap, keyIterator.nextKey())) {
                return false;
            }
        }
        return true;
    }
}
