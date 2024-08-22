package com.baidu.swan.games.network.websocket;

import com.baidu.searchbox.websocket.WebSocketTask;
import com.baidu.swan.apps.network.SwanAppWebSocket;
import com.baidu.swan.apps.runtime.SwanApp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0002¨\u0006\u000e"}, d2 = {"Lcom/baidu/swan/games/network/websocket/SwanGameWebSocketManager;", "", "()V", "allowConnectNewSocket", "", "attachTask", "", "task", "Lcom/baidu/searchbox/websocket/WebSocketTask;", "detachTask", "taskId", "", "getSwanAppWebSocket", "Lcom/baidu/swan/apps/network/SwanAppWebSocket;", "lib-swan-game_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SwanGameWebSocketManager.kt */
public final class SwanGameWebSocketManager {
    public final void attachTask(WebSocketTask task) {
        Intrinsics.checkNotNullParameter(task, "task");
        SwanAppWebSocket swanAppWebSocket = getSwanAppWebSocket();
        if (swanAppWebSocket != null) {
            swanAppWebSocket.attachTask(task);
        }
    }

    public final void detachTask(String taskId) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        SwanAppWebSocket swanAppWebSocket = getSwanAppWebSocket();
        if (swanAppWebSocket != null) {
            swanAppWebSocket.detachTask(taskId);
        }
    }

    public final boolean allowConnectNewSocket() {
        SwanAppWebSocket swanAppWebSocket = getSwanAppWebSocket();
        if (swanAppWebSocket != null) {
            return swanAppWebSocket.allowConnectNewSocket();
        }
        return false;
    }

    private final SwanAppWebSocket getSwanAppWebSocket() {
        SwanApp swanApp = SwanApp.get();
        if (swanApp != null) {
            return swanApp.getWebSocket();
        }
        return null;
    }
}
