package okhttp3;

import okio.ByteString;

public abstract class WebSocketListener {
    public void onClosed(WebSocket webSocket, int i2, String str) {
    }

    public void onClosing(WebSocket webSocket, int i2, String str) {
    }

    public void onFailure(WebSocket webSocket, Throwable th2, Response response) {
    }

    public void onMessage(WebSocket webSocket, String str) {
    }

    public void onMessage(WebSocket webSocket, ByteString byteString) {
    }

    public void onOpen(WebSocket webSocket, Response response) {
    }
}
