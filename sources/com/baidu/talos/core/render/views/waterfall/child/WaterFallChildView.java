package com.baidu.talos.core.render.views.waterfall.child;

import android.view.MotionEvent;
import com.baidu.talos.core.context.TalosPageContext;
import com.baidu.talos.core.render.views.viewgroup.ReactViewGroup;

public class WaterFallChildView extends ReactViewGroup {
    private OnDispatchTouchListener mOnDispatchTouchListener;

    public interface OnDispatchTouchListener {
        void onDispatchTouch(MotionEvent motionEvent);
    }

    public WaterFallChildView(TalosPageContext context) {
        super(context);
    }

    public boolean dispatchTouchEvent(MotionEvent ev) {
        OnDispatchTouchListener onDispatchTouchListener = this.mOnDispatchTouchListener;
        if (onDispatchTouchListener != null) {
            onDispatchTouchListener.onDispatchTouch(ev);
        }
        return super.dispatchTouchEvent(ev);
    }

    public void setOnDispatchTouchListener(OnDispatchTouchListener listener) {
        this.mOnDispatchTouchListener = listener;
    }
}
