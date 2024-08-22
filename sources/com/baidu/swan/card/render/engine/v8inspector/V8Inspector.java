package com.baidu.swan.card.render.engine.v8inspector;

import android.util.Log;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.v8engine.InspectorNativeChannel;
import com.baidu.swan.card.render.engine.SwanCardBaseV8Engine;
import com.baidu.swan.card.render.engine.v8inspector.httpserver.V8InspectorServer;
import com.baidu.swan.card.render.engine.v8inspector.websocket.V8WebSocket;
import com.baidu.swan.card.render.engine.v8inspector.websocket.WebSocketFrame;
import com.baidu.swan.card.utils.SwanAppLibConfig;
import com.baidu.swan.card.utils.SwanCardLog;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

public class V8Inspector {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final String SOCKET_NAME = "v8in_%s_devtools_remote";
    private static final String TAG = "V8Inspector";
    private InspectorNativeChannelImpl mChannel;
    /* access modifiers changed from: private */
    public final LinkedBlockingQueue<String> mInspectorMessages = new LinkedBlockingQueue<>();
    /* access modifiers changed from: private */
    public InspectorService mInspectorService;
    /* access modifiers changed from: private */
    public SwanCardBaseV8Engine mV8Engine;
    /* access modifiers changed from: private */
    public V8WebSocket mWebSocket;

    public interface ConnectCallback {
        V8WebSocket onConnected();
    }

    public interface InspectorService {
        public static final String COMMAND_CLOSE = "close";
        public static final String COMMAND_RELOAD = "reload";
        public static final String DEBUG_ENABLE_METHOD = "Debugger.enable";
        public static final String OP_COMMAND_KEY = "command";
        public static final String OP_METHOD_KEY = "method";
        public static final String OP_VALUE = "value";

        void start();

        void stop();
    }

    public void setV8Engine(SwanCardBaseV8Engine v8Engine) {
        this.mV8Engine = v8Engine;
        if (DEBUG) {
            Log.d(TAG, "[Inspector] setInspectorChannel, engineID=" + v8Engine.engineID);
        }
        this.mChannel = new InspectorNativeChannelImpl();
        this.mV8Engine.getEngine().setInspectorChannel(this.mChannel);
    }

    public void start() {
        ExecutorUtilsExt.postOnSerial(new Runnable() {
            public void run() {
                String socketSubName = ProcessUtils.getCurProcessName() + "_" + V8Inspector.this.mV8Engine.engineID;
                if (V8Inspector.this.mInspectorService == null) {
                    InspectorService unused = V8Inspector.this.mInspectorService = new V8InspectorServer(String.format(V8Inspector.SOCKET_NAME, new Object[]{socketSubName}), V8Inspector.this.mV8Engine, V8Inspector.this.initV8WebSocket());
                    V8Inspector.this.mInspectorService.start();
                }
            }
        }, TAG);
    }

    public void stop() {
        InspectorService inspectorService = this.mInspectorService;
        if (inspectorService != null) {
            inspectorService.stop();
            this.mInspectorService = null;
        }
        V8WebSocket v8WebSocket = this.mWebSocket;
        if (v8WebSocket != null) {
            try {
                v8WebSocket.close(WebSocketFrame.CloseCode.NormalClosure, "inspector stoped");
                this.mWebSocket = null;
            } catch (IOException e2) {
                if (DEBUG) {
                    Log.d(TAG, "[Inspector] websocket close fail");
                }
            }
        }
        if (this.mChannel != null) {
            this.mChannel = null;
        }
        this.mInspectorMessages.clear();
    }

    /* access modifiers changed from: private */
    public V8WebSocket initV8WebSocket() {
        V8WebSocket v8WebSocket = this.mWebSocket;
        if (v8WebSocket != null) {
            try {
                v8WebSocket.close(WebSocketFrame.CloseCode.NormalClosure, "inspector stoped");
                this.mWebSocket = null;
            } catch (IOException e2) {
                if (DEBUG) {
                    Log.d(TAG, "[Inspector] websocket close fail");
                }
            }
        }
        V8WebSocket v8WebSocket2 = new V8WebSocket();
        this.mWebSocket = v8WebSocket2;
        v8WebSocket2.setWebSocketListener(new V8WebSocket.V8WebSocketListener() {
            public void onOpen() {
                SwanCardLog.i(V8Inspector.TAG, "V8 inspector opened, engineID=" + V8Inspector.this.mV8Engine.engineID);
            }

            public void onClose() {
                SwanCardLog.i(V8Inspector.TAG, "V8 inspector closed, engineID=" + V8Inspector.this.mV8Engine.engineID);
            }

            public void onMessage(WebSocketFrame frame) {
                V8Inspector.this.mInspectorMessages.offer(frame.getTextPayload());
                V8Inspector.this.mV8Engine.postOnJSThread(new Runnable() {
                    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.Object} */
                    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.String} */
                    /* JADX WARNING: Multi-variable type inference failed */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void run() {
                        /*
                            r3 = this;
                            com.baidu.swan.card.render.engine.v8inspector.V8Inspector$2 r0 = com.baidu.swan.card.render.engine.v8inspector.V8Inspector.AnonymousClass2.this
                            com.baidu.swan.card.render.engine.v8inspector.V8Inspector r0 = com.baidu.swan.card.render.engine.v8inspector.V8Inspector.this
                            java.util.concurrent.LinkedBlockingQueue r0 = r0.mInspectorMessages
                            java.lang.Object r0 = r0.poll()
                            java.lang.String r0 = (java.lang.String) r0
                            com.baidu.swan.card.render.engine.v8inspector.V8Inspector$2 r1 = com.baidu.swan.card.render.engine.v8inspector.V8Inspector.AnonymousClass2.this
                            com.baidu.swan.card.render.engine.v8inspector.V8Inspector r1 = com.baidu.swan.card.render.engine.v8inspector.V8Inspector.this
                            com.baidu.swan.card.render.engine.SwanCardBaseV8Engine r1 = r1.mV8Engine
                            com.baidu.searchbox.v8engine.V8Engine r1 = r1.getEngine()
                            com.baidu.searchbox.v8engine.InspectorNativeClient r1 = r1.getInspectorNativeClient()
                        L_0x001e:
                            if (r0 == 0) goto L_0x0033
                            r1.dispatchProtocolMessage(r0)
                            com.baidu.swan.card.render.engine.v8inspector.V8Inspector$2 r2 = com.baidu.swan.card.render.engine.v8inspector.V8Inspector.AnonymousClass2.this
                            com.baidu.swan.card.render.engine.v8inspector.V8Inspector r2 = com.baidu.swan.card.render.engine.v8inspector.V8Inspector.this
                            java.util.concurrent.LinkedBlockingQueue r2 = r2.mInspectorMessages
                            java.lang.Object r2 = r2.poll()
                            r0 = r2
                            java.lang.String r0 = (java.lang.String) r0
                            goto L_0x001e
                        L_0x0033:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.baidu.swan.card.render.engine.v8inspector.V8Inspector.AnonymousClass2.AnonymousClass1.run():void");
                    }
                });
            }

            public void onException(IOException e2) {
                SwanCardLog.e(V8Inspector.TAG, "V8 inspector webSocket exception, engineID=" + V8Inspector.this.mV8Engine.engineID, e2);
            }
        });
        return this.mWebSocket;
    }

    public class InspectorNativeChannelImpl extends InspectorNativeChannel {
        public InspectorNativeChannelImpl() {
        }

        public void sendMessage(String message) {
            try {
                V8Inspector.this.mWebSocket.sendFrame(new WebSocketFrame(WebSocketFrame.OpCode.Text, true, message));
            } catch (Exception exception) {
                if (V8Inspector.DEBUG) {
                    Log.w(V8Inspector.TAG, "V8 send message fail", exception);
                }
            }
        }

        public String awaitMessage() {
            if (V8Inspector.DEBUG) {
                Log.d(V8Inspector.TAG, "getInspectorMessage");
            }
            try {
                return (String) V8Inspector.this.mInspectorMessages.take();
            } catch (InterruptedException exception) {
                if (!V8Inspector.DEBUG) {
                    return "";
                }
                Log.e(V8Inspector.TAG, "awaitMessage on Debugger", exception);
                return "";
            }
        }
    }
}
