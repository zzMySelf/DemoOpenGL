package com.baidu.swan.games.glsurface.touch;

import android.view.MotionEvent;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.engine.AiBaseV8Engine;

public final class SwanGameTouchDelegate {
    private AiBaseV8Engine mV8Engine;

    public void setV8Engine(AiBaseV8Engine engine) {
        this.mV8Engine = engine;
    }

    public void updateInitializeDisplaySize(int width, int height) {
        SwanGameTouchHelper.setInitializeDisplaySize(width, height);
    }

    public void setSurfaceViewCurrentSize(int width, int height) {
        SwanGameTouchHelper.setSurfaceViewCurrentSize(width, height);
    }

    public boolean onTouchEvent(MotionEvent event) {
        AiBaseV8Engine aiBaseV8Engine = this.mV8Engine;
        if (aiBaseV8Engine == null) {
            return false;
        }
        boolean hasGlobalListener = SwanGameTouchHelper.hasTouchEventListener(aiBaseV8Engine.getGlobalObject());
        boolean hasOpenListener = SwanGameTouchHelper.hasTouchEventListener(this.mV8Engine.getOpenObject());
        JSEvent touchEvent = null;
        if (hasGlobalListener || hasOpenListener) {
            touchEvent = SwanGameTouchHelper.parseMotionEvent(event);
        }
        boolean globalTouchResult = false;
        if (hasGlobalListener) {
            globalTouchResult = this.mV8Engine.dispatchEvent(touchEvent);
        }
        if (hasOpenListener && this.mV8Engine.isLoaded()) {
            this.mV8Engine.getOpenObject().dispatchEvent(touchEvent);
        }
        SwanGameTouchHelper.isTouch(true);
        return globalTouchResult;
    }
}
