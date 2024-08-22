package com.baidu.swan.games.view.recommend.proxy;

import android.content.Context;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.util.SwanAppUtils;
import com.baidu.swan.games.view.SwanGameNAViewUI;
import com.baidu.swan.games.view.recommend.base.BaseRecommendButton;
import com.baidu.swan.games.view.recommend.base.IRecommendButton;
import com.baidu.swan.games.view.recommend.base.RecommendButtonStyle;
import com.baidu.swan.games.view.recommend.model.RecommendModel;

public class RecommendButtonThreadProxy implements IRecommendButton {
    private static final String ERRMSG_NULL_CONTEXT = "context is null.";
    private static final String TAG = "RecommendButton";
    /* access modifiers changed from: private */
    public IRecommendButton mRecommendButton;

    public RecommendButtonThreadProxy(final int sourceType, final RecommendButtonStyle style, final BaseRecommendButton.OnRecommendButtonClickListener listener) {
        SwanAppUtils.runOnUiThread(new Runnable() {
            public void run() {
                Context context = SwanGameNAViewUI.getViewContext();
                if (context == null) {
                    SwanAppLog.e(RecommendButtonThreadProxy.TAG, RecommendButtonThreadProxy.ERRMSG_NULL_CONTEXT);
                    return;
                }
                IRecommendButton unused = RecommendButtonThreadProxy.this.mRecommendButton = BaseRecommendButton.createRecommendButton(sourceType, context, style);
                RecommendButtonThreadProxy.this.mRecommendButton.setOnClickListener(listener);
            }
        });
    }

    public void updateModel(final RecommendModel model) {
        SwanAppUtils.runOnUiThread(new Runnable() {
            public void run() {
                if (RecommendButtonThreadProxy.this.mRecommendButton != null) {
                    RecommendButtonThreadProxy.this.mRecommendButton.updateModel(model);
                }
            }
        });
    }

    public void setOnClickListener(final BaseRecommendButton.OnRecommendButtonClickListener listener) {
        SwanAppUtils.runOnUiThread(new Runnable() {
            public void run() {
                if (RecommendButtonThreadProxy.this.mRecommendButton != null) {
                    RecommendButtonThreadProxy.this.mRecommendButton.setOnClickListener(listener);
                }
            }
        });
    }

    public void onForegroundStateChanged(final boolean isForeground) {
        SwanAppUtils.runOnUiThread(new Runnable() {
            public void run() {
                if (RecommendButtonThreadProxy.this.mRecommendButton != null) {
                    RecommendButtonThreadProxy.this.mRecommendButton.onForegroundStateChanged(isForeground);
                }
            }
        });
    }

    public void load() {
        SwanAppUtils.runOnUiThread(new Runnable() {
            public void run() {
                if (RecommendButtonThreadProxy.this.mRecommendButton != null) {
                    RecommendButtonThreadProxy.this.mRecommendButton.load();
                }
            }
        });
    }

    public void show() {
        SwanAppUtils.runOnUiThread(new Runnable() {
            public void run() {
                if (RecommendButtonThreadProxy.this.mRecommendButton != null) {
                    RecommendButtonThreadProxy.this.mRecommendButton.show();
                }
            }
        });
    }

    public void hide() {
        SwanAppUtils.runOnUiThread(new Runnable() {
            public void run() {
                if (RecommendButtonThreadProxy.this.mRecommendButton != null) {
                    RecommendButtonThreadProxy.this.mRecommendButton.hide();
                }
            }
        });
    }

    public void destroy() {
        SwanAppUtils.runOnUiThread(new Runnable() {
            public void run() {
                if (RecommendButtonThreadProxy.this.mRecommendButton != null) {
                    RecommendButtonThreadProxy.this.mRecommendButton.destroy();
                }
            }
        });
    }

    public void update() {
        SwanAppUtils.runOnUiThread(new Runnable() {
            public void run() {
                if (RecommendButtonThreadProxy.this.mRecommendButton != null) {
                    RecommendButtonThreadProxy.this.mRecommendButton.update();
                }
            }
        });
    }
}
