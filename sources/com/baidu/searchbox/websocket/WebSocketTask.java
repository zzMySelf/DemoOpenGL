package com.baidu.searchbox.websocket;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u0019\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0001J\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0011\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014H\u0001J\u0011\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0005H\u0001J\u0006\u0010\u0016\u001a\u00020\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/baidu/searchbox/websocket/WebSocketTask;", "Lcom/baidu/searchbox/websocket/IWebSocketClient;", "webSocketClient", "(Lcom/baidu/searchbox/websocket/IWebSocketClient;)V", "taskId", "", "getTaskId", "()Ljava/lang/String;", "close", "", "code", "", "reason", "connect", "request", "Lcom/baidu/searchbox/websocket/WebSocketRequest;", "listener", "Lcom/baidu/searchbox/websocket/IWebSocketListener;", "send", "data", "Ljava/nio/ByteBuffer;", "message", "toJSON", "Lorg/json/JSONObject;", "lib-websocket_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: WebSocketTask.kt */
public final class WebSocketTask implements IWebSocketClient {
    private final String taskId = ("WebSocketTask-" + System.currentTimeMillis());
    private final IWebSocketClient webSocketClient;

    public void close(int i2, String str) {
        Intrinsics.checkParameterIsNotNull(str, "reason");
        this.webSocketClient.close(i2, str);
    }

    public void send(String str) {
        Intrinsics.checkParameterIsNotNull(str, "message");
        this.webSocketClient.send(str);
    }

    public void send(ByteBuffer byteBuffer) {
        Intrinsics.checkParameterIsNotNull(byteBuffer, "data");
        this.webSocketClient.send(byteBuffer);
    }

    public WebSocketTask(IWebSocketClient webSocketClient2) {
        Intrinsics.checkParameterIsNotNull(webSocketClient2, "webSocketClient");
        this.webSocketClient = webSocketClient2;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final JSONObject toJSON() {
        JSONObject $this$apply = new JSONObject();
        $this$apply.put("id", this.taskId);
        return $this$apply;
    }

    public void connect(WebSocketRequest request, IWebSocketListener listener) {
        Intrinsics.checkParameterIsNotNull(request, "request");
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        this.webSocketClient.connect(request, new WebSocketTask$connect$1(this, listener));
    }
}
