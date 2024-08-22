package com.baidu.swan.card.api.component;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.swan.card.api.component.SwanAppBaseComponentModel;
import com.baidu.swan.card.api.component.context.ISwanAppComponent;
import com.baidu.swan.card.api.component.context.SwanAppComponentContext;
import com.baidu.swan.card.api.component.diff.DiffResult;
import com.baidu.swan.card.api.component.touch.SwanAppTouchListener;
import com.baidu.swan.card.utils.SwanAppLibConfig;
import com.baidu.swan.card.utils.SwanCardLog;
import rx.Observable;
import rx.Subscriber;

public abstract class SwanAppBaseComponent<V extends View, M extends SwanAppBaseComponentModel> implements ISwanAppComponent<M> {
    protected static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final String TAG = "Component-Base";
    /* access modifiers changed from: private */
    public SwanAppComponentContext mComponentContext;
    /* access modifiers changed from: private */
    public SwanAppComponentContainerView mContainerView;
    private int mFlags;
    /* access modifiers changed from: private */
    public Subscriber mInsertSubscriber;
    /* access modifiers changed from: private */
    public M mModel;
    private M mOldModel;
    /* access modifiers changed from: private */
    public V mView;

    /* access modifiers changed from: protected */
    public abstract V inflateView(Context context);

    public SwanAppBaseComponent(Context context, M model) {
        M cloneModel = cloneModel(model);
        this.mModel = cloneModel;
        SwanAppComponentContext findComponentContext = SwanAppComponentFinder.findComponentContext((SwanAppBaseComponentModel) cloneModel);
        this.mComponentContext = findComponentContext;
        if (findComponentContext == null) {
            SwanCardLog.e(TAG, getName() + " context is null !");
        } else if (context != null) {
            findComponentContext.updateContext(context);
        }
    }

    public final SwanAppComponentResult insert() {
        String componentName = getName();
        SwanAppComponentResult modelCheckResult = checkModel(this.mModel);
        if (!modelCheckResult.isSuccess()) {
            SwanCardLog.e(TAG, componentName + " insert with a invalid model => " + modelCheckResult.msg);
            return modelCheckResult;
        }
        boolean z = DEBUG;
        if (z) {
            Log.i(TAG, "=====================" + componentName + " start insert=====================");
        }
        SwanAppComponentContext swanAppComponentContext = this.mComponentContext;
        if (swanAppComponentContext == null) {
            SwanCardLog.e(TAG, componentName + " insert with a null component context!");
            return new SwanAppComponentResult(202, "component context is null");
        }
        Context context = swanAppComponentContext.getContext();
        if (!(this.mContainerView == null && this.mView == null)) {
            SwanCardLog.w(TAG, componentName + " repeat insert");
        }
        V inflateView = inflateView(this.mComponentContext.getContext());
        this.mView = inflateView;
        onViewCreated(inflateView);
        SwanAppComponentContainerView inflateContainerView = inflateContainerView(context);
        this.mContainerView = inflateContainerView;
        inflateContainerView.setTargetView(this.mView);
        render(this.mView, this.mModel, new DiffResult(true));
        if (attach(this.mComponentContext)) {
            if (z) {
                Log.d(TAG, componentName + " insert: success");
            }
            return new SwanAppComponentResult(0, "success");
        }
        SwanCardLog.e(TAG, componentName + " insert: attach fail");
        return new SwanAppComponentResult(1001, "attach fail");
    }

    public final Subscriber insertDelayed() {
        final String componentName = getName();
        SwanAppComponentResult modelCheckResult = checkModel(this.mModel);
        if (!modelCheckResult.isSuccess()) {
            SwanCardLog.e(TAG, componentName + " insert delayed with a invalid model => " + modelCheckResult.msg);
            return null;
        }
        boolean z = DEBUG;
        if (z) {
            Log.i(TAG, "=====================" + componentName + " start insertDelayed=====================");
        }
        if (this.mComponentContext == null) {
            SwanAppComponentUtils.logErrorWithThrow(TAG, componentName + " insert delayed with a null component context!");
            return null;
        }
        if (this.mContainerView != null) {
            SwanCardLog.w(TAG, componentName + " repeat insert delayed: container view repeat");
        }
        Subscriber subscriber = this.mInsertSubscriber;
        if (subscriber != null && !subscriber.isUnsubscribed()) {
            this.mInsertSubscriber.unsubscribe();
            this.mInsertSubscriber = null;
            SwanCardLog.w(TAG, componentName + " insert delayed repeat: subscriber repeat");
        }
        this.mContainerView = inflateContainerView(this.mComponentContext.getContext());
        renderContainerView(this.mModel, new DiffResult(true));
        if (attach(this.mComponentContext)) {
            if (z) {
                Log.d(TAG, componentName + " insert delayed（container view）: success");
            }
            final long returnThreadId = Thread.currentThread().getId();
            Observable.create(new Observable.OnSubscribe<Object>() {
                public void call(Subscriber<? super Object> subscriber) {
                    if (SwanAppBaseComponent.DEBUG) {
                        Log.d(SwanAppBaseComponent.TAG, "insert delayed => save thread: " + Thread.currentThread().getName());
                    }
                    if (returnThreadId != Thread.currentThread().getId()) {
                        SwanAppComponentUtils.logErrorWithThrow(SwanAppBaseComponent.TAG, "save subscriber and return subscriber: nolinear !");
                    }
                    Subscriber unused = SwanAppBaseComponent.this.mInsertSubscriber = subscriber;
                }
            }).subscribe(new Subscriber<Object>() {
                public void onCompleted() {
                    SwanAppBaseComponent swanAppBaseComponent = SwanAppBaseComponent.this;
                    View unused = swanAppBaseComponent.mView = swanAppBaseComponent.inflateView(swanAppBaseComponent.mComponentContext.getContext());
                    SwanAppBaseComponent swanAppBaseComponent2 = SwanAppBaseComponent.this;
                    swanAppBaseComponent2.onViewCreated(swanAppBaseComponent2.mView);
                    SwanAppBaseComponent.this.mContainerView.setTargetView(SwanAppBaseComponent.this.mView, 0);
                    SwanAppBaseComponent swanAppBaseComponent3 = SwanAppBaseComponent.this;
                    swanAppBaseComponent3.render(swanAppBaseComponent3.mView, SwanAppBaseComponent.this.mModel, new DiffResult(true));
                    if (SwanAppBaseComponent.DEBUG) {
                        Log.d(SwanAppBaseComponent.TAG, componentName + " insert delayed（view）: success");
                    }
                }

                public void onError(Throwable throwable) {
                    SwanCardLog.w(SwanAppBaseComponent.TAG, componentName + " insert delayed（view）: fail");
                    if (!SwanAppBaseComponent.DEBUG || throwable == null || !TextUtils.equals(throwable.getMessage(), "save subscriber and return subscriber: nolinear !")) {
                        SwanAppBaseComponent.this.remove();
                        return;
                    }
                    throw new RuntimeException("save subscriber and return subscriber: nolinear !");
                }

                public void onNext(Object o) {
                    SwanCardLog.w(SwanAppBaseComponent.TAG, componentName + " success should call onCompleted");
                }
            });
            return this.mInsertSubscriber;
        }
        SwanCardLog.e(TAG, componentName + " insert delayed: attach fail");
        return null;
    }

    public final SwanAppComponentResult update(M newModel) {
        String componentName = getName();
        SwanAppComponentResult modelCheckResult = checkModel(newModel);
        if (!modelCheckResult.isSuccess()) {
            SwanCardLog.e(TAG, componentName + " update with a invalid model => " + modelCheckResult.msg);
            return modelCheckResult;
        }
        boolean z = DEBUG;
        if (z) {
            Log.i(TAG, "=====================" + componentName + " start update=====================");
        }
        M m = this.mModel;
        if (m == newModel) {
            String msg = componentName + " update with the same model";
            SwanAppComponentUtils.logErrorWithThrow(TAG, msg);
            return new SwanAppComponentResult(202, msg);
        } else if (!TextUtils.equals(m.componentId, newModel.componentId)) {
            String msg2 = componentName + " update with different id: " + this.mModel.componentId + ", " + newModel.componentId;
            SwanAppComponentUtils.logErrorWithThrow(TAG, msg2);
            return new SwanAppComponentResult(202, msg2);
        } else if (!TextUtils.equals(this.mModel.slaveId, newModel.slaveId)) {
            String msg3 = componentName + " update with different slave id: " + this.mModel.slaveId + ", " + newModel.slaveId;
            SwanAppComponentUtils.logErrorWithThrow(TAG, msg3);
            return new SwanAppComponentResult(202, msg3);
        } else if (this.mView == null || this.mContainerView == null) {
            String msg4 = componentName + " update must after insert succeeded";
            SwanAppComponentUtils.logErrorWithThrow(TAG, msg4);
            return new SwanAppComponentResult(202, msg4);
        } else if (this.mComponentContext == null) {
            SwanAppComponentUtils.logErrorWithThrow(TAG, componentName + " update with a null component context!");
            return new SwanAppComponentResult(202, "component context is null");
        } else {
            M m2 = this.mModel;
            this.mOldModel = m2;
            DiffResult diffResult = diff(m2, newModel);
            M cloneModel = cloneModel(newModel);
            this.mModel = cloneModel;
            render(this.mView, cloneModel, diffResult);
            boolean isUpdateComponentSuccess = this.mComponentContext.getContainer().updateComponent(this, diffResult);
            this.mOldModel = null;
            if (!isUpdateComponentSuccess) {
                String msg5 = componentName + " update component fail";
                SwanCardLog.e(TAG, msg5);
                return new SwanAppComponentResult(1001, msg5);
            }
            if (z) {
                Log.d(TAG, componentName + " component update: success");
            }
            return new SwanAppComponentResult(0, "success");
        }
    }

    public final SwanAppComponentResult remove() {
        String componentName = getName();
        boolean z = DEBUG;
        if (z) {
            Log.i(TAG, "=====================" + componentName + " start remove=====================");
        }
        SwanAppComponentContext swanAppComponentContext = this.mComponentContext;
        if (swanAppComponentContext == null) {
            SwanAppComponentUtils.logErrorWithThrow(TAG, componentName + " remove with a null component context!");
            return new SwanAppComponentResult(202, "component context is null");
        } else if (this.mContainerView == null) {
            SwanCardLog.e(TAG, componentName + " remove must after insert");
            return new SwanAppComponentResult(202, "component remove must after insert");
        } else if (!swanAppComponentContext.getContainer().removeComponent(this)) {
            String msg = componentName + " remove fail";
            SwanCardLog.e(TAG, msg);
            return new SwanAppComponentResult(1001, msg);
        } else {
            onRemove();
            if (z) {
                Log.d(TAG, componentName + " remove: success");
            }
            return new SwanAppComponentResult(0, "success");
        }
    }

    public void onDestroy() {
        if (DEBUG) {
            Log.d(TAG, getName() + " onDestroy");
        }
        tryUnsubscribe();
    }

    public final V getView() {
        return this.mView;
    }

    public final M getModel() {
        return this.mModel;
    }

    public final M getCloneModel() {
        return cloneModel(this.mModel);
    }

    public final SwanAppComponentContainerView getContainerView() {
        return this.mContainerView;
    }

    public final String getName() {
        SwanAppComponentResult result = checkModel(this.mModel);
        if (result.isSuccess()) {
            return this.mModel.getName();
        }
        return "【illegal component#" + result.msg + "】";
    }

    public final SwanAppBaseComponent addFlags(int flags) {
        this.mFlags |= flags;
        return this;
    }

    public final boolean hasFlags(int flags) {
        return (this.mFlags & flags) == flags;
    }

    /* access modifiers changed from: protected */
    public void onViewCreated(V v) {
    }

    /* access modifiers changed from: protected */
    public SwanAppComponentContainerView inflateContainerView(Context context) {
        return new SwanAppComponentContainerView(context);
    }

    /* access modifiers changed from: protected */
    public void render(V v, M model, DiffResult diffResult) {
        renderContainerView(model, diffResult);
    }

    /* access modifiers changed from: protected */
    public DiffResult diff(M oldModel, M newModel) {
        DiffResult diffResult = new DiffResult();
        if (newModel.position != null && newModel.position.diff(oldModel.position)) {
            diffResult.markDiff(3);
        }
        if (oldModel.hidden != newModel.hidden) {
            diffResult.markDiff(1);
        }
        if (oldModel.gesture != newModel.gesture) {
            diffResult.markDiff(2);
        }
        return diffResult;
    }

    /* access modifiers changed from: protected */
    public void handleContainerViewGesture(SwanAppComponentContainerView containerView, M model) {
        final boolean z = model.gesture;
        containerView.setOnTouchListener(new SwanAppTouchListener(model.slaveId, model.componentId, model.componentType) {
            public boolean onTouch(View v, MotionEvent event) {
                return z && super.onTouch(v, event);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onAttached(boolean isAttachSuccess) {
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        tryUnsubscribe();
    }

    /* access modifiers changed from: protected */
    public final M getOldModelInUpdating() {
        return this.mOldModel;
    }

    /* access modifiers changed from: protected */
    public final boolean inUpdating() {
        return this.mOldModel != null;
    }

    private boolean attach(SwanAppComponentContext componentContext) {
        boolean isSuccess = componentContext.getContainer().insertComponent(this);
        onAttached(isSuccess);
        return isSuccess;
    }

    private void renderContainerView(M model, DiffResult diffResult) {
        if (this.mContainerView == null) {
            SwanAppComponentUtils.logErrorWithThrow(TAG, "renderContainerView with a null container view");
            return;
        }
        if (diffResult.hasDiff(1)) {
            this.mContainerView.setHidden(model.hidden);
        }
        if (diffResult.hasDiff(2)) {
            handleContainerViewGesture(this.mContainerView, model);
        }
    }

    private SwanAppComponentResult checkModel(M model) {
        if (model == null) {
            return new SwanAppComponentResult(202, "model is null");
        }
        if (TextUtils.isEmpty(model.slaveId)) {
            return new SwanAppComponentResult(202, "slave id is empty");
        }
        if (!model.isValid()) {
            return new SwanAppComponentResult(202, "model is invalid");
        }
        return new SwanAppComponentResult(0, "model is valid");
    }

    private M cloneModel(M model) {
        M cloneModel = null;
        try {
            cloneModel = (SwanAppBaseComponentModel) model.clone();
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
            SwanAppComponentUtils.logErrorWithThrow(TAG, "model must implement cloneable", e2);
        } catch (Exception e3) {
            e3.printStackTrace();
            SwanAppComponentUtils.logErrorWithThrow(TAG, "clone model fail ！", e3);
        }
        if (cloneModel != null) {
            return cloneModel;
        }
        SwanAppComponentUtils.logErrorWithThrow(TAG, "clone model fail ！");
        return model;
    }

    private void tryUnsubscribe() {
        Subscriber subscriber = this.mInsertSubscriber;
        if (subscriber != null && !subscriber.isUnsubscribed()) {
            this.mInsertSubscriber.unsubscribe();
        }
    }
}
