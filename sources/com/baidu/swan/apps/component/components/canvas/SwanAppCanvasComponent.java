package com.baidu.swan.apps.component.components.canvas;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.swan.apps.canvas.model.CanvasBasicModel;
import com.baidu.swan.apps.canvas.model.CanvasDrawModel;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.swan.apps.component.base.SwanAppBaseComponent;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.swan.apps.component.utils.SwanAppComponentUtils;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.view.container.touch.SwanAppTouchListener;

public final class SwanAppCanvasComponent extends SwanAppBaseComponent<CanvasView, CanvasBasicModel> {
    private static final String TAG = "Component-Canvas";
    public CanvasView canvasView;

    public SwanAppCanvasComponent(Context context, CanvasBasicModel model) {
        super(context, model);
        CanvasView canvasView2 = new CanvasView(context);
        this.canvasView = canvasView2;
        canvasView2.setInterceptTouchEvent(model.disableScroll);
        this.canvasView.setHide(model.hidden);
        this.canvasView.setGesture(model.gesture);
        if (model.gesture) {
            this.canvasView.setInterceptTouchEvent(false);
        }
    }

    public boolean drawCanvas(CanvasBasicModel model, final CanvasView.OnDrawCompleteListener onDrawCompleteListener) {
        if (model == null || !(model instanceof CanvasDrawModel)) {
            SwanAppLog.e(TAG, "some params is invalid");
            onDrawCompleteListener.onDrawComplete(1001);
            return false;
        }
        CanvasBasicModel oldModel = (CanvasBasicModel) getModel();
        if (!TextUtils.equals(oldModel.componentId, model.componentId) || !TextUtils.equals(oldModel.slaveId, model.slaveId)) {
            SwanAppComponentUtils.logErrorWithThrow(TAG, "drawCanvas with illegal ids!");
        }
        CanvasDrawModel drawModel = (CanvasDrawModel) model;
        this.canvasView.addDrawActionList(drawModel.getDrawActionList(), drawModel.isReserve());
        this.canvasView.postInvalidate();
        this.canvasView.post(new Runnable() {
            public void run() {
                CanvasView.OnDrawCompleteListener onDrawCompleteListener = onDrawCompleteListener;
                if (onDrawCompleteListener != null) {
                    onDrawCompleteListener.onDrawComplete(0);
                }
            }
        });
        return true;
    }

    /* access modifiers changed from: protected */
    public void handleContainerViewGesture(SwanAppComponentContainerView containerView, CanvasBasicModel model) {
        final boolean z = model.gesture;
        containerView.setOnTouchListener(new SwanAppTouchListener(model.slaveId, model.componentId, model.componentType) {
            public boolean onTouch(View v, MotionEvent event) {
                return z && super.onTouch(v, event);
            }
        });
    }

    /* access modifiers changed from: protected */
    public CanvasView inflateView(Context context) {
        return this.canvasView;
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        this.canvasView.onRelease();
    }
}
