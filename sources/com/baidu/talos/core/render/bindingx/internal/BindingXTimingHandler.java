package com.baidu.talos.core.render.bindingx.internal;

import android.view.animation.AnimationUtils;
import com.baidu.talos.core.context.IRuntimeContext;
import com.baidu.talos.core.render.bindingx.BindingXCore;
import com.baidu.talos.core.render.bindingx.LogProxy;
import com.baidu.talos.core.render.bindingx.PlatformManager;
import com.baidu.talos.core.render.bindingx.internal.AnimationFrame;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class BindingXTimingHandler extends AbstractEventHandler implements AnimationFrame.Callback {
    private boolean isFinish = false;
    private AnimationFrame mAnimationFrame;
    private long mStartTime = 0;

    public BindingXTimingHandler(IRuntimeContext context, PlatformManager manager, Object... extension) {
        super(context, manager, extension);
        AnimationFrame animationFrame = this.mAnimationFrame;
        if (animationFrame == null) {
            this.mAnimationFrame = AnimationFrame.newInstance();
        } else {
            animationFrame.clear();
        }
    }

    BindingXTimingHandler(IRuntimeContext context, PlatformManager manager, AnimationFrame frame, Object... extension) {
        super(context, manager, extension);
        this.mAnimationFrame = frame;
    }

    public boolean onCreate(String sourceRef, String eventType) {
        return true;
    }

    public void onStart(String sourceRef, String eventType) {
    }

    public void onBindExpression(String eventType, Map<String, Object> globalConfig, ExpressionPair exitExpressionPair, List<Map<String, Object>> expressionArgs, Map<String, DepScope> depScopes, BindingXCore.JavaScriptCallback callback) {
        super.onBindExpression(eventType, globalConfig, exitExpressionPair, expressionArgs, depScopes, callback);
        if (this.mAnimationFrame == null) {
            this.mAnimationFrame = AnimationFrame.newInstance();
        }
        fireEventByState("start", 0, new Object[0]);
        this.mAnimationFrame.clear();
        this.mAnimationFrame.requestAnimationFrame(this);
    }

    private void handleTimingCallback() {
        long deltaT;
        JSMath.applyDepToScope(this.mPlatformManager, this.mDepScopes, this.mScope);
        if (this.mStartTime == 0) {
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            deltaT = 0;
            this.isFinish = false;
        } else {
            deltaT = AnimationUtils.currentAnimationTimeMillis() - this.mStartTime;
        }
        try {
            if (LogProxy.sEnableLog) {
                LogProxy.d(String.format(Locale.getDefault(), "[TimingHandler] timing elapsed. (t:%d)", new Object[]{Long.valueOf(deltaT)}));
            }
            JSMath.applyTimingValuesToScope(this.mScope, (double) deltaT);
            if (!this.isFinish) {
                consumeExpression(this.mExpressionHoldersMap, this.mScope, "timing");
            }
            this.isFinish = evaluateExitExpression(this.mExitExpressionPair, this.mScope);
        } catch (Exception e2) {
            LogProxy.e("runtime error", e2);
        }
    }

    public boolean onDisable(String sourceRef, String eventType) {
        fireEventByState("end", System.currentTimeMillis() - this.mStartTime, new Object[0]);
        clearExpressions();
        AnimationFrame animationFrame = this.mAnimationFrame;
        if (animationFrame != null) {
            animationFrame.clear();
        }
        this.mStartTime = 0;
        return true;
    }

    public void onDestroy() {
        super.onDestroy();
        clearExpressions();
        AnimationFrame animationFrame = this.mAnimationFrame;
        if (animationFrame != null) {
            animationFrame.terminate();
            this.mAnimationFrame = null;
        }
        this.mStartTime = 0;
    }

    /* access modifiers changed from: protected */
    public void onExit(Map<String, Object> scope) {
        fireEventByState("exit", (long) ((Double) scope.get("t")).doubleValue(), new Object[0]);
        AnimationFrame animationFrame = this.mAnimationFrame;
        if (animationFrame != null) {
            animationFrame.clear();
        }
        this.mStartTime = 0;
    }

    /* access modifiers changed from: protected */
    public void onUserIntercept(String interceptorName, Map<String, Object> scope) {
        fireEventByState(BindingXConstants.STATE_INTERCEPTOR, (long) ((Double) scope.get("t")).doubleValue(), Collections.singletonMap(BindingXConstants.STATE_INTERCEPTOR, interceptorName));
    }

    private void fireEventByState(String state, long t, Object... extension) {
        if (this.mCallback != null) {
            Map<String, Object> param = new HashMap<>();
            param.put("state", state);
            param.put("t", Long.valueOf(t));
            param.put("token", this.mToken);
            param.put("eventType", "timing");
            if (extension != null && extension.length > 0 && (extension[0] instanceof Map)) {
                param.putAll(extension[0]);
            }
            this.mCallback.callback(param);
            LogProxy.d(">>>>>>>>>>>fire event:(" + state + "," + t + ")");
        }
    }

    public void doFrame() {
        handleTimingCallback();
    }

    public void onActivityPause() {
    }

    public void onActivityResume() {
    }
}
