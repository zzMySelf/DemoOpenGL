package com.baidu.talos.core.animated;

import android.util.SparseArray;
import com.baidu.talos.core.callback.Callback;
import com.baidu.talos.core.common.MapBuilder;
import com.baidu.talos.core.data.ParamArray;
import com.baidu.talos.core.data.ParamMap;
import com.baidu.talos.core.data.ParamMapImpl;
import com.baidu.talos.core.exception.JSApplicationIllegalArgumentException;
import com.baidu.talos.core.render.IUIManagerInterface;
import com.baidu.talos.core.render.events.EventDispatcher;
import com.baidu.talos.core.render.events.EventDispatcherListener;
import com.baidu.talos.core.render.events.IUIEventDispatcher;
import com.baidu.talos.core.render.views.rncwebview.events.TopLoadingErrorEvent;
import com.baidu.talos.core.render.views.rncwebview.events.TopLoadingFinishEvent;
import com.baidu.talos.core.render.views.rncwebview.events.TopLoadingStartEvent;
import com.baidu.talos.exception.TalosExceptionHandler;
import com.baidu.talos.util.UiThreadUtil;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import javax.annotation.Nullable;

class NativeAnimatedNodesManager implements EventDispatcherListener {
    private static final String EXCEPTION_CLASS_NAME = "NativeAnimatedNodesManager";
    private final ArrayList<AnimationDriver> mActiveAnimations = new ArrayList<>();
    private int mAnimatedGraphBFSColor = 0;
    private final SparseArray<AnimatedNode> mAnimatedNodes = new SparseArray<>();
    private final Map<String, Map<String, String>> mCustomEventTypes;
    private final Map<String, EventAnimationDriver> mEventDrivers = new HashMap();
    private final IUIManagerInterface mUIManager;
    private final ArrayList<AnimatedNode> mUpdatedNodes = new ArrayList<>();

    public NativeAnimatedNodesManager(IUIManagerInterface uiManagerInterface) {
        this.mUIManager = uiManagerInterface;
        IUIEventDispatcher eventDispatcher = uiManagerInterface.getRenderImplementation().getEventDispatcher();
        if (eventDispatcher instanceof EventDispatcher) {
            ((EventDispatcher) eventDispatcher).addListener(this);
        }
        this.mCustomEventTypes = getDirectEventTypeConstants();
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public AnimatedNode getNodeById(int id) {
        return this.mAnimatedNodes.get(id);
    }

    public boolean hasActiveAnimations() {
        return !this.mActiveAnimations.isEmpty() || !this.mUpdatedNodes.isEmpty();
    }

    public void createAnimatedNode(int tag, ParamMap config) {
        AnimatedNode node;
        if (this.mAnimatedNodes.get(tag) != null) {
            TalosExceptionHandler.handleFromRN(new JSApplicationIllegalArgumentException("Animated node with tag " + tag + " already exists"), EXCEPTION_CLASS_NAME, false);
        }
        String type = config.getString("type");
        if ("style".equals(type)) {
            node = new StyleAnimatedNode(config, this);
        } else if ("value".equals(type)) {
            node = new ValueAnimatedNode(config);
            this.mUpdatedNodes.add(node);
        } else if ("props".equals(type)) {
            node = new PropsAnimatedNode(config, this);
        } else if ("interpolation".equals(type)) {
            node = new InterpolationAnimatedNode(config);
        } else if ("addition".equals(type)) {
            node = new AdditionAnimatedNode(config, this);
        } else if ("multiplication".equals(type)) {
            node = new MultiplicationAnimatedNode(config, this);
        } else if ("diffclamp".equals(type)) {
            node = new DiffClampAnimatedNode(config, this);
        } else if ("transform".equals(type)) {
            node = new TransformAnimatedNode(config, this);
        } else {
            throw new JSApplicationIllegalArgumentException("Unsupported node type: " + type);
        }
        node.mTag = tag;
        this.mAnimatedNodes.put(tag, node);
    }

    public void dropAnimatedNode(int tag) {
        this.mAnimatedNodes.remove(tag);
    }

    public void startListeningToAnimatedNodeValue(int tag, AnimatedNodeValueListener listener) {
        AnimatedNode node = this.mAnimatedNodes.get(tag);
        if (node == null || !(node instanceof ValueAnimatedNode)) {
            TalosExceptionHandler.handleFromRN(new JSApplicationIllegalArgumentException("Animated node with tag " + tag + " does not exists or is not a 'value' node"), EXCEPTION_CLASS_NAME, false);
        } else {
            ((ValueAnimatedNode) node).setValueListener(listener);
        }
    }

    public void stopListeningToAnimatedNodeValue(int tag) {
        AnimatedNode node = this.mAnimatedNodes.get(tag);
        if (node == null || !(node instanceof ValueAnimatedNode)) {
            TalosExceptionHandler.handleFromRN(new JSApplicationIllegalArgumentException("Animated node with tag " + tag + " does not exists or is not a 'value' node"), EXCEPTION_CLASS_NAME, false);
        } else {
            ((ValueAnimatedNode) node).setValueListener((AnimatedNodeValueListener) null);
        }
    }

    public void setAnimatedNodeValue(int tag, double value) {
        AnimatedNode node = this.mAnimatedNodes.get(tag);
        if (node == null || !(node instanceof ValueAnimatedNode)) {
            TalosExceptionHandler.handleFromRN(new JSApplicationIllegalArgumentException("Animated node with tag " + tag + " does not exists or is not a 'value' node"), EXCEPTION_CLASS_NAME, false);
            return;
        }
        ((ValueAnimatedNode) node).mValue = value;
        this.mUpdatedNodes.add(node);
    }

    public void startAnimatingNode(int animationId, int animatedNodeTag, ParamMap animationConfig, Callback endCallback) {
        AnimationDriver animation;
        AnimatedNode node = this.mAnimatedNodes.get(animatedNodeTag);
        if (node == null) {
            TalosExceptionHandler.handleFromRN(new JSApplicationIllegalArgumentException("Animated node with tag " + animatedNodeTag + " does not exists"), EXCEPTION_CLASS_NAME, false);
        } else if (!(node instanceof ValueAnimatedNode)) {
            TalosExceptionHandler.handleFromRN(new JSApplicationIllegalArgumentException("Animated node should be of type " + ValueAnimatedNode.class.getName()), EXCEPTION_CLASS_NAME, false);
        } else {
            String type = animationConfig.getString("type");
            if ("frames".equals(type)) {
                animation = new FrameBasedAnimationDriver(animationConfig);
            } else if ("spring".equals(type)) {
                animation = new SpringAnimation(animationConfig);
            } else if ("decay".equals(type)) {
                animation = new DecayAnimation(animationConfig);
            } else {
                TalosExceptionHandler.handleFromRN(new JSApplicationIllegalArgumentException("Unsupported animation type: " + type), EXCEPTION_CLASS_NAME, false);
                return;
            }
            animation.mId = animationId;
            animation.mEndCallback = endCallback;
            animation.mAnimatedValue = (ValueAnimatedNode) node;
            this.mActiveAnimations.add(animation);
        }
    }

    public void stopAnimation(int animationId) {
        for (int i2 = 0; i2 < this.mActiveAnimations.size(); i2++) {
            AnimationDriver animation = this.mActiveAnimations.get(i2);
            if (animation.mId == animationId) {
                ParamMap endCallbackResponse = new ParamMapImpl();
                endCallbackResponse.putBoolean("finished", false);
                animation.mEndCallback.invoke(endCallbackResponse);
                this.mActiveAnimations.remove(i2);
                return;
            }
        }
    }

    public void connectAnimatedNodes(int parentNodeTag, int childNodeTag) {
        AnimatedNode parentNode = this.mAnimatedNodes.get(parentNodeTag);
        if (parentNode == null) {
            TalosExceptionHandler.handleFromRN(new JSApplicationIllegalArgumentException("Animated node with tag " + parentNodeTag + " does not exists"), EXCEPTION_CLASS_NAME, false);
            return;
        }
        AnimatedNode childNode = this.mAnimatedNodes.get(childNodeTag);
        if (childNode == null) {
            TalosExceptionHandler.handleFromRN(new JSApplicationIllegalArgumentException("Animated node with tag " + childNodeTag + " does not exists"), EXCEPTION_CLASS_NAME, false);
        } else {
            parentNode.addChild(childNode);
        }
    }

    public void disconnectAnimatedNodes(int parentNodeTag, int childNodeTag) {
        AnimatedNode parentNode = this.mAnimatedNodes.get(parentNodeTag);
        if (parentNode == null) {
            TalosExceptionHandler.handleFromRN(new JSApplicationIllegalArgumentException("Animated node with tag " + parentNodeTag + " does not exists"), EXCEPTION_CLASS_NAME, false);
            return;
        }
        AnimatedNode childNode = this.mAnimatedNodes.get(childNodeTag);
        if (childNode == null) {
            TalosExceptionHandler.handleFromRN(new JSApplicationIllegalArgumentException("Animated node with tag " + childNodeTag + " does not exists"), EXCEPTION_CLASS_NAME, false);
        } else {
            parentNode.removeChild(childNode);
        }
    }

    public void connectAnimatedNodeToView(int animatedNodeTag, int viewTag) {
        AnimatedNode node = this.mAnimatedNodes.get(animatedNodeTag);
        if (node == null) {
            TalosExceptionHandler.handleFromRN(new JSApplicationIllegalArgumentException("Animated node with tag " + animatedNodeTag + " does not exists"), EXCEPTION_CLASS_NAME, false);
        } else if (!(node instanceof PropsAnimatedNode)) {
            TalosExceptionHandler.handleFromRN(new JSApplicationIllegalArgumentException("Animated node connected to view should beof type " + PropsAnimatedNode.class.getName()), EXCEPTION_CLASS_NAME, false);
        } else {
            PropsAnimatedNode propsAnimatedNode = (PropsAnimatedNode) node;
            if (propsAnimatedNode.mConnectedViewTag != -1) {
                TalosExceptionHandler.handleFromRN(new JSApplicationIllegalArgumentException("Animated node " + animatedNodeTag + " is already attached to a view"), EXCEPTION_CLASS_NAME, false);
            } else {
                propsAnimatedNode.mConnectedViewTag = viewTag;
            }
        }
    }

    public void disconnectAnimatedNodeFromView(int animatedNodeTag, int viewTag) {
        AnimatedNode node = this.mAnimatedNodes.get(animatedNodeTag);
        if (node == null) {
            TalosExceptionHandler.handleFromRN(new JSApplicationIllegalArgumentException("Animated node with tag " + animatedNodeTag + " does not exists"), EXCEPTION_CLASS_NAME, false);
        } else if (!(node instanceof PropsAnimatedNode)) {
            TalosExceptionHandler.handleFromRN(new JSApplicationIllegalArgumentException("Animated node connected to view should beof type " + PropsAnimatedNode.class.getName()), EXCEPTION_CLASS_NAME, false);
        } else {
            PropsAnimatedNode propsAnimatedNode = (PropsAnimatedNode) node;
            if (propsAnimatedNode.mConnectedViewTag != viewTag) {
                TalosExceptionHandler.handleFromRN(new JSApplicationIllegalArgumentException("Attempting to disconnect view that has not been connected with the given animated node"), EXCEPTION_CLASS_NAME, false);
            } else {
                propsAnimatedNode.mConnectedViewTag = -1;
            }
        }
    }

    public void addAnimatedEventToView(int viewTag, String eventName, ParamMap eventMapping) {
        int nodeTag = eventMapping.getInteger("animatedValueTag");
        AnimatedNode node = this.mAnimatedNodes.get(nodeTag);
        if (node == null) {
            TalosExceptionHandler.handleFromRN(new JSApplicationIllegalArgumentException("Animated node with tag " + nodeTag + " does not exists"), EXCEPTION_CLASS_NAME, false);
        } else if (!(node instanceof ValueAnimatedNode)) {
            TalosExceptionHandler.handleFromRN(new JSApplicationIllegalArgumentException("Animated node connected to event should beof type " + ValueAnimatedNode.class.getName()), EXCEPTION_CLASS_NAME, false);
        } else {
            ParamArray path = eventMapping.getArray("nativeEventPath");
            List<String> pathList = new ArrayList<>(path.size());
            for (int i2 = 0; i2 < path.size(); i2++) {
                pathList.add(path.getString(i2));
            }
            this.mEventDrivers.put(viewTag + eventName, new EventAnimationDriver(pathList, (ValueAnimatedNode) node));
        }
    }

    public void removeAnimatedEventFromView(int viewTag, String eventName) {
        this.mEventDrivers.remove(viewTag + eventName);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onEventDispatch(com.baidu.talos.core.render.events.Event r8) {
        /*
            r7 = this;
            boolean r0 = com.baidu.talos.util.UiThreadUtil.isOnUiThread()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            java.util.Map<java.lang.String, com.baidu.talos.core.animated.EventAnimationDriver> r0 = r7.mEventDrivers
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0053
            java.lang.String r0 = r8.getEventName()
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> r2 = r7.mCustomEventTypes
            java.lang.Object r2 = r2.get(r0)
            java.util.Map r2 = (java.util.Map) r2
            if (r2 == 0) goto L_0x0028
            java.lang.String r3 = "registrationName"
            java.lang.Object r3 = r2.get(r3)
            r0 = r3
            java.lang.String r0 = (java.lang.String) r0
        L_0x0028:
            java.util.Map<java.lang.String, com.baidu.talos.core.animated.EventAnimationDriver> r3 = r7.mEventDrivers
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            long r5 = r8.getViewTag()
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r0)
            java.lang.String r4 = r4.toString()
            java.lang.Object r3 = r3.get(r4)
            com.baidu.talos.core.animated.EventAnimationDriver r3 = (com.baidu.talos.core.animated.EventAnimationDriver) r3
            if (r3 == 0) goto L_0x0053
            r8.dispatch(r3)
            java.util.ArrayList<com.baidu.talos.core.animated.AnimatedNode> r1 = r7.mUpdatedNodes
            com.baidu.talos.core.animated.ValueAnimatedNode r4 = r3.mValueNode
            r1.add(r4)
            r1 = 1
            return r1
        L_0x0053:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.talos.core.animated.NativeAnimatedNodesManager.onEventDispatch(com.baidu.talos.core.render.events.Event):boolean");
    }

    public void runUpdates(long frameTimeNanos) {
        int i2;
        int i3;
        UiThreadUtil.assertOnUiThread();
        int activeNodesCount = 0;
        int updatedNodesCount = 0;
        boolean hasFinishedAnimations = false;
        int i4 = this.mAnimatedGraphBFSColor + 1;
        this.mAnimatedGraphBFSColor = i4;
        if (i4 == 0) {
            this.mAnimatedGraphBFSColor = i4 + 1;
        }
        Queue<AnimatedNode> nodesQueue = new ArrayDeque<>();
        for (int i5 = 0; i5 < this.mUpdatedNodes.size(); i5++) {
            AnimatedNode node = this.mUpdatedNodes.get(i5);
            int i6 = node.mBFSColor;
            int i7 = this.mAnimatedGraphBFSColor;
            if (i6 != i7) {
                node.mBFSColor = i7;
                activeNodesCount++;
                nodesQueue.add(node);
            }
        }
        for (int i8 = 0; i8 < this.mActiveAnimations.size(); i8++) {
            AnimationDriver animation = this.mActiveAnimations.get(i8);
            animation.runAnimationStep(frameTimeNanos);
            AnimatedNode valueNode = animation.mAnimatedValue;
            int i9 = valueNode.mBFSColor;
            int i10 = this.mAnimatedGraphBFSColor;
            if (i9 != i10) {
                valueNode.mBFSColor = i10;
                activeNodesCount++;
                nodesQueue.add(valueNode);
            }
            if (animation.mHasFinished) {
                hasFinishedAnimations = true;
            }
        }
        while (nodesQueue.isEmpty() == 0) {
            AnimatedNode nextNode = nodesQueue.poll();
            if (nextNode.mChildren != null) {
                for (int i11 = 0; i11 < nextNode.mChildren.size(); i11++) {
                    AnimatedNode child = nextNode.mChildren.get(i11);
                    child.mActiveIncomingNodes++;
                    int i12 = child.mBFSColor;
                    int i13 = this.mAnimatedGraphBFSColor;
                    if (i12 != i13) {
                        child.mBFSColor = i13;
                        activeNodesCount++;
                        nodesQueue.add(child);
                    }
                }
            }
        }
        int i14 = this.mAnimatedGraphBFSColor + 1;
        this.mAnimatedGraphBFSColor = i14;
        if (i14 == 0) {
            this.mAnimatedGraphBFSColor = i14 + 1;
        }
        for (int i15 = 0; i15 < this.mUpdatedNodes.size(); i15++) {
            AnimatedNode node2 = this.mUpdatedNodes.get(i15);
            if (node2.mActiveIncomingNodes == 0 && node2.mBFSColor != (i3 = this.mAnimatedGraphBFSColor)) {
                node2.mBFSColor = i3;
                updatedNodesCount++;
                nodesQueue.add(node2);
            }
        }
        for (int i16 = 0; i16 < this.mActiveAnimations.size(); i16++) {
            AnimatedNode valueNode2 = this.mActiveAnimations.get(i16).mAnimatedValue;
            if (valueNode2.mActiveIncomingNodes == 0 && valueNode2.mBFSColor != (i2 = this.mAnimatedGraphBFSColor)) {
                valueNode2.mBFSColor = i2;
                updatedNodesCount++;
                nodesQueue.add(valueNode2);
            }
        }
        while (nodesQueue.isEmpty() == 0) {
            AnimatedNode nextNode2 = nodesQueue.poll();
            nextNode2.update();
            if (nextNode2 instanceof PropsAnimatedNode) {
                ((PropsAnimatedNode) nextNode2).updateView(this.mUIManager);
            }
            if (nextNode2 instanceof ValueAnimatedNode) {
                ((ValueAnimatedNode) nextNode2).onValueUpdate();
            }
            if (nextNode2.mChildren != null) {
                for (int i17 = 0; i17 < nextNode2.mChildren.size(); i17++) {
                    AnimatedNode child2 = nextNode2.mChildren.get(i17);
                    child2.mActiveIncomingNodes--;
                    if (child2.mBFSColor != this.mAnimatedGraphBFSColor && child2.mActiveIncomingNodes == 0) {
                        child2.mBFSColor = this.mAnimatedGraphBFSColor;
                        updatedNodesCount++;
                        nodesQueue.add(child2);
                    }
                }
            }
        }
        if (activeNodesCount == updatedNodesCount) {
            this.mUpdatedNodes.clear();
            if (hasFinishedAnimations) {
                int dest = 0;
                for (int i18 = 0; i18 < this.mActiveAnimations.size(); i18++) {
                    AnimationDriver animation2 = this.mActiveAnimations.get(i18);
                    if (!animation2.mHasFinished) {
                        this.mActiveAnimations.set(dest, animation2);
                        dest++;
                    } else {
                        ParamMap endCallbackResponse = new ParamMapImpl();
                        endCallbackResponse.putBoolean("finished", true);
                        animation2.mEndCallback.invoke(endCallbackResponse);
                    }
                }
                for (int i19 = this.mActiveAnimations.size() - 1; i19 >= dest; i19--) {
                    this.mActiveAnimations.remove(i19);
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("Looks like animated nodes graph has cycles, there are " + activeNodesCount + " but toposort visited only " + updatedNodesCount);
    }

    private Map getDirectEventTypeConstants() {
        return MapBuilder.builder().put("topContentSizeChange", MapBuilder.of("registrationName", "onContentSizeChange")).put("topLayout", MapBuilder.of("registrationName", "onLayout")).put(TopLoadingErrorEvent.EVENT_NAME, MapBuilder.of("registrationName", "onLoadingError")).put(TopLoadingFinishEvent.EVENT_NAME, MapBuilder.of("registrationName", "onLoadingFinish")).put(TopLoadingStartEvent.EVENT_NAME, MapBuilder.of("registrationName", "onLoadingStart")).put("topSelectionChange", MapBuilder.of("registrationName", "onSelectionChange")).build();
    }
}
