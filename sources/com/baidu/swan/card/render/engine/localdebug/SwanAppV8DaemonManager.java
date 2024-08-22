package com.baidu.swan.card.render.engine.localdebug;

import com.baidu.swan.card.render.engine.SwanCardBaseV8Engine;
import com.baidu.swan.card.render.engine.V8LoadingCallback;

public class SwanAppV8DaemonManager {
    private SwanCardV8Daemon mV8Daemon = new SwanCardV8Daemon(LocalDebugBundleHelper.getDebugUnzipFolder().getPath(), LocalDebugBundleHelper.DAEMON_JS);

    public SwanCardBaseV8Engine getV8Engine() {
        SwanCardV8Daemon swanCardV8Daemon = this.mV8Daemon;
        if (swanCardV8Daemon != null) {
            return swanCardV8Daemon.getV8Engine();
        }
        return null;
    }

    public void setV8LoadingCallback(final V8LoadingCallback callback) {
        SwanCardV8Daemon swanCardV8Daemon = this.mV8Daemon;
        if (swanCardV8Daemon != null) {
            swanCardV8Daemon.setV8LoadingCallback(new V8LoadingCallback() {
                public void onReady(SwanCardBaseV8Engine engine) {
                    V8LoadingCallback v8LoadingCallback = callback;
                    if (v8LoadingCallback != null) {
                        v8LoadingCallback.onReady(engine);
                    }
                }
            });
        }
    }

    public void release() {
        SwanCardV8Daemon swanCardV8Daemon = this.mV8Daemon;
        if (swanCardV8Daemon != null) {
            swanCardV8Daemon.release();
            this.mV8Daemon = null;
        }
    }
}
