package com.baidu.talos.core.websocket;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.talos.core.websocket.TalosParser;
import com.baidu.talos.util.LogUtils;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URI;
import java.security.KeyManagementException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

public class WebSocketClient {
    private static final int SC_SWITCHING_PROTOCOLS = 101;
    private static final String TAG = "WebSocketClient";
    private static TrustManager[] sTrustManagers;
    /* access modifiers changed from: private */
    public boolean mConnected;
    /* access modifiers changed from: private */
    public final List<Header> mExtraHeaders;
    private final Handler mHandler;
    private final HandlerThread mHandlerThread;
    /* access modifiers changed from: private */
    public final WebSocketListener mListener;
    /* access modifiers changed from: private */
    public final TalosParser mParser;
    /* access modifiers changed from: private */
    public final Object mSendLock = new Object();
    /* access modifiers changed from: private */
    public Socket mSocket;
    private Thread mThread;
    /* access modifiers changed from: private */
    public final URI mURI;

    public interface WebSocketListener {
        void onConnect();

        void onDisconnect(int i2, String str);

        void onError(Exception exc);

        void onMessage(String str);

        void onMessage(byte[] bArr);
    }

    public WebSocketClient(URI uri, WebSocketListener listener, List<Header> extraHeaders) {
        this.mURI = uri;
        this.mListener = listener;
        this.mExtraHeaders = extraHeaders;
        this.mConnected = false;
        this.mParser = new TalosParser(this);
        HandlerThread handlerThread = new HandlerThread("websocket-thread");
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper());
    }

    public static void setTrustManagers(TrustManager[] tm) {
        sTrustManagers = tm;
    }

    public void connect() {
        Thread thread = this.mThread;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new Runnable() {
                static final /* synthetic */ boolean $assertionsDisabled = false;

                static {
                    Class<WebSocketClient> cls = WebSocketClient.class;
                }

                /* Debug info: failed to restart local var, previous not found, register: 22 */
                /* JADX WARNING: Code restructure failed: missing block: B:130:?, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:131:?, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:139:?, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:60:0x02a0, code lost:
                    r19 = r8;
                    r20 = r9;
                    r21 = r10;
                    com.baidu.talos.core.websocket.WebSocketClient.access$900(r1.this$0).onConnect();
                    com.baidu.talos.core.websocket.WebSocketClient.access$1002(r1.this$0, true);
                    com.baidu.talos.core.websocket.WebSocketClient.access$1100(r1.this$0).start(r2);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:62:0x02c4, code lost:
                    if (com.baidu.talos.core.websocket.WebSocketClient.access$1000(r1.this$0) != false) goto L_?;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:64:0x02cc, code lost:
                    if (com.baidu.talos.core.websocket.WebSocketClient.access$200(r1.this$0) == null) goto L_?;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
                    com.baidu.talos.core.websocket.WebSocketClient.access$200(r1.this$0).close();
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:67:0x02d9, code lost:
                    r0 = move-exception;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:68:0x02da, code lost:
                    r2 = r0;
                    com.baidu.talos.util.LogUtils.e(com.baidu.talos.core.websocket.WebSocketClient.TAG, "Error while disconnecting", r2);
                    r3 = com.baidu.talos.core.websocket.WebSocketClient.access$900(r1.this$0);
                    r4 = new java.lang.Exception(r2);
                 */
                /* JADX WARNING: Removed duplicated region for block: B:34:0x01b5 A[Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f, all -> 0x038a, all -> 0x0369, all -> 0x03cc, all -> 0x0425 }] */
                /* JADX WARNING: Removed duplicated region for block: B:40:0x020c A[Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f, all -> 0x038a, all -> 0x0369, all -> 0x03cc, all -> 0x0425 }] */
                /* JADX WARNING: Removed duplicated region for block: B:73:0x0321 A[Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f, all -> 0x038a, all -> 0x0369, all -> 0x03cc, all -> 0x0425 }] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r22 = this;
                        r1 = r22
                        java.lang.String r2 = "\r\n"
                        java.lang.String r3 = "Error while disconnecting"
                        java.lang.String r4 = "WebSocketClient"
                        r5 = 2
                        com.baidu.talos.core.websocket.WebSocketClient r8 = com.baidu.talos.core.websocket.WebSocketClient.this     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.net.URI r8 = r8.mURI     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        int r8 = r8.getPort()     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        r9 = -1
                        java.lang.String r10 = "https"
                        java.lang.String r11 = "wss"
                        if (r8 == r9) goto L_0x0026
                        com.baidu.talos.core.websocket.WebSocketClient r8 = com.baidu.talos.core.websocket.WebSocketClient.this     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.net.URI r8 = r8.mURI     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        int r8 = r8.getPort()     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        goto L_0x004c
                    L_0x0026:
                        com.baidu.talos.core.websocket.WebSocketClient r8 = com.baidu.talos.core.websocket.WebSocketClient.this     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.net.URI r8 = r8.mURI     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.String r8 = r8.getScheme()     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        boolean r8 = r8.equals(r11)     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        if (r8 != 0) goto L_0x004a
                        com.baidu.talos.core.websocket.WebSocketClient r8 = com.baidu.talos.core.websocket.WebSocketClient.this     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.net.URI r8 = r8.mURI     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.String r8 = r8.getScheme()     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        boolean r8 = r8.equals(r10)     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        if (r8 == 0) goto L_0x0047
                        goto L_0x004a
                    L_0x0047:
                        r8 = 80
                        goto L_0x004c
                    L_0x004a:
                        r8 = 443(0x1bb, float:6.21E-43)
                    L_0x004c:
                        com.baidu.talos.core.websocket.WebSocketClient r9 = com.baidu.talos.core.websocket.WebSocketClient.this     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.net.URI r9 = r9.mURI     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.String r9 = r9.getPath()     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        if (r9 == 0) goto L_0x0060
                        java.lang.String r9 = "/"
                        goto L_0x006a
                    L_0x0060:
                        com.baidu.talos.core.websocket.WebSocketClient r9 = com.baidu.talos.core.websocket.WebSocketClient.this     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.net.URI r9 = r9.mURI     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.String r9 = r9.getPath()     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                    L_0x006a:
                        com.baidu.talos.core.websocket.WebSocketClient r12 = com.baidu.talos.core.websocket.WebSocketClient.this     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.net.URI r12 = r12.mURI     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.String r12 = r12.getQuery()     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        boolean r12 = android.text.TextUtils.isEmpty(r12)     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        if (r12 != 0) goto L_0x009c
                        java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        r12.<init>()     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.StringBuilder r12 = r12.append(r9)     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.String r13 = "?"
                        java.lang.StringBuilder r12 = r12.append(r13)     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        com.baidu.talos.core.websocket.WebSocketClient r13 = com.baidu.talos.core.websocket.WebSocketClient.this     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.net.URI r13 = r13.mURI     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.String r13 = r13.getQuery()     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.StringBuilder r12 = r12.append(r13)     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.String r12 = r12.toString()     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        r9 = r12
                    L_0x009c:
                        com.baidu.talos.core.websocket.WebSocketClient r12 = com.baidu.talos.core.websocket.WebSocketClient.this     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.net.URI r12 = r12.mURI     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.String r12 = r12.getScheme()     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        boolean r12 = r12.equals(r11)     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        if (r12 == 0) goto L_0x00ae
                        r12 = r10
                        goto L_0x00b0
                    L_0x00ae:
                        java.lang.String r12 = "http"
                    L_0x00b0:
                        java.net.URI r13 = new java.net.URI     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        r14.<init>()     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.String r15 = "//"
                        java.lang.StringBuilder r14 = r14.append(r15)     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        com.baidu.talos.core.websocket.WebSocketClient r15 = com.baidu.talos.core.websocket.WebSocketClient.this     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.net.URI r15 = r15.mURI     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.String r15 = r15.getHost()     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.StringBuilder r14 = r14.append(r15)     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.String r14 = r14.toString()     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        r15 = 0
                        r13.<init>(r12, r14, r15)     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        com.baidu.talos.core.websocket.WebSocketClient r14 = com.baidu.talos.core.websocket.WebSocketClient.this     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.net.URI r14 = r14.mURI     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.String r14 = r14.getScheme()     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        boolean r11 = r14.equals(r11)     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        if (r11 != 0) goto L_0x00f9
                        com.baidu.talos.core.websocket.WebSocketClient r11 = com.baidu.talos.core.websocket.WebSocketClient.this     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.net.URI r11 = r11.mURI     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.String r11 = r11.getScheme()     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        boolean r10 = r11.equals(r10)     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        if (r10 == 0) goto L_0x00f4
                        goto L_0x00f9
                    L_0x00f4:
                        javax.net.SocketFactory r10 = javax.net.SocketFactory.getDefault()     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        goto L_0x00ff
                    L_0x00f9:
                        com.baidu.talos.core.websocket.WebSocketClient r10 = com.baidu.talos.core.websocket.WebSocketClient.this     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        javax.net.ssl.SSLSocketFactory r10 = r10.getSSLSocketFactory()     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                    L_0x00ff:
                        com.baidu.talos.core.websocket.WebSocketClient r11 = com.baidu.talos.core.websocket.WebSocketClient.this     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.net.URI r14 = r11.mURI     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.String r14 = r14.getHost()     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.net.Socket r14 = r10.createSocket(r14, r8)     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.net.Socket unused = r11.mSocket = r14     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.io.PrintWriter r11 = new java.io.PrintWriter     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        com.baidu.talos.core.websocket.WebSocketClient r14 = com.baidu.talos.core.websocket.WebSocketClient.this     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.net.Socket r14 = r14.mSocket     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.io.OutputStream r14 = r14.getOutputStream()     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        r11.<init>(r14)     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        com.baidu.talos.core.websocket.WebSocketClient r14 = com.baidu.talos.core.websocket.WebSocketClient.this     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.String r14 = r14.createSecret()     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        r15.<init>()     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.String r6 = "GET "
                        java.lang.StringBuilder r6 = r15.append(r6)     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.StringBuilder r6 = r6.append(r9)     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.String r15 = " HTTP/1.1\r\n"
                        java.lang.StringBuilder r6 = r6.append(r15)     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.String r6 = r6.toString()     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        r11.print(r6)     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.String r6 = "Upgrade: websocket\r\n"
                        r11.print(r6)     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.String r6 = "Connection: Upgrade\r\n"
                        r11.print(r6)     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        r6.<init>()     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.String r15 = "Host: "
                        java.lang.StringBuilder r6 = r6.append(r15)     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        com.baidu.talos.core.websocket.WebSocketClient r15 = com.baidu.talos.core.websocket.WebSocketClient.this     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.net.URI r15 = r15.mURI     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.String r15 = r15.getHost()     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.StringBuilder r6 = r6.append(r15)     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.StringBuilder r6 = r6.append(r2)     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.String r6 = r6.toString()     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        r11.print(r6)     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        r6.<init>()     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.String r15 = "Origin: "
                        java.lang.StringBuilder r6 = r6.append(r15)     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.String r15 = r13.toString()     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.StringBuilder r6 = r6.append(r15)     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.StringBuilder r6 = r6.append(r2)     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.String r6 = r6.toString()     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        r11.print(r6)     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        r6.<init>()     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.String r15 = "Sec-WebSocket-Key: "
                        java.lang.StringBuilder r6 = r6.append(r15)     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.StringBuilder r6 = r6.append(r14)     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.StringBuilder r6 = r6.append(r2)     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.String r6 = r6.toString()     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        r11.print(r6)     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.String r6 = "Sec-WebSocket-Version: 13\r\n"
                        r11.print(r6)     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        com.baidu.talos.core.websocket.WebSocketClient r6 = com.baidu.talos.core.websocket.WebSocketClient.this     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.util.List r6 = r6.mExtraHeaders     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        if (r6 == 0) goto L_0x01eb
                        com.baidu.talos.core.websocket.WebSocketClient r6 = com.baidu.talos.core.websocket.WebSocketClient.this     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.util.List r6 = r6.mExtraHeaders     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.util.Iterator r6 = r6.iterator()     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                    L_0x01bf:
                        boolean r15 = r6.hasNext()     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        if (r15 == 0) goto L_0x01eb
                        java.lang.Object r15 = r6.next()     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        com.baidu.talos.core.websocket.Header r15 = (com.baidu.talos.core.websocket.Header) r15     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.String r7 = "%s: %s\r\n"
                        r18 = r6
                        java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.String r19 = r15.getName()     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        r17 = 0
                        r6[r17] = r19     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.String r19 = r15.getValue()     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        r16 = 1
                        r6[r16] = r19     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.String r6 = java.lang.String.format(r7, r6)     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        r11.print(r6)     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        r6 = r18
                        goto L_0x01bf
                    L_0x01eb:
                        r11.print(r2)     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        r11.flush()     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        com.baidu.talos.core.websocket.TalosParser$DataInputStreamTalos r2 = new com.baidu.talos.core.websocket.TalosParser$DataInputStreamTalos     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        com.baidu.talos.core.websocket.WebSocketClient r6 = com.baidu.talos.core.websocket.WebSocketClient.this     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.net.Socket r6 = r6.mSocket     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.io.InputStream r6 = r6.getInputStream()     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        r2.<init>(r6)     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        com.baidu.talos.core.websocket.WebSocketClient r6 = com.baidu.talos.core.websocket.WebSocketClient.this     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.String r7 = r6.readLine(r2)     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        com.baidu.talos.core.websocket.StatusLine r6 = r6.parseStatusLine(r7)     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        if (r6 == 0) goto L_0x0321
                        int r7 = r6.code     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        r15 = 101(0x65, float:1.42E-43)
                        if (r7 != r15) goto L_0x02f4
                    L_0x0212:
                        com.baidu.talos.core.websocket.WebSocketClient r7 = com.baidu.talos.core.websocket.WebSocketClient.this     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.String r7 = r7.readLine(r2)     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        r15 = r7
                        boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        if (r7 != 0) goto L_0x02a0
                        if (r15 == 0) goto L_0x0294
                        com.baidu.talos.core.websocket.WebSocketClient r7 = com.baidu.talos.core.websocket.WebSocketClient.this     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        com.baidu.talos.core.websocket.Header r7 = r7.parseHeader(r15)     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.String r5 = r7.getName()     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        r19 = r8
                        java.lang.String r8 = "Sec-WebSocket-Accept"
                        boolean r5 = r5.equals(r8)     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        if (r5 == 0) goto L_0x0287
                        com.baidu.talos.core.websocket.WebSocketClient r5 = com.baidu.talos.core.websocket.WebSocketClient.this     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.String r5 = r5.expectedKey(r14)     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        if (r5 == 0) goto L_0x027b
                        java.lang.String r8 = r7.getValue()     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.String r8 = r8.trim()     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        boolean r8 = r5.equals(r8)     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        if (r8 == 0) goto L_0x0250
                        r20 = r9
                        r21 = r10
                        goto L_0x028b
                    L_0x0250:
                        java.net.ConnectException r8 = new java.net.ConnectException     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        r20 = r9
                        java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        r9.<init>()     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        r21 = r10
                        java.lang.String r10 = "Invalid Sec-WebSocket-Accept, expected: "
                        java.lang.StringBuilder r9 = r9.append(r10)     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.StringBuilder r9 = r9.append(r5)     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.String r10 = ", got: "
                        java.lang.StringBuilder r9 = r9.append(r10)     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.String r10 = r7.getValue()     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.StringBuilder r9 = r9.append(r10)     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.String r9 = r9.toString()     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        r8.<init>(r9)     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        throw r8     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                    L_0x027b:
                        r20 = r9
                        r21 = r10
                        java.net.ConnectException r8 = new java.net.ConnectException     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.String r9 = "SHA-1 algorithm not found"
                        r8.<init>(r9)     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        throw r8     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                    L_0x0287:
                        r20 = r9
                        r21 = r10
                    L_0x028b:
                        r8 = r19
                        r9 = r20
                        r10 = r21
                        r5 = 2
                        goto L_0x0212
                    L_0x0294:
                        r19 = r8
                        r20 = r9
                        r21 = r10
                        java.lang.AssertionError r5 = new java.lang.AssertionError     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        r5.<init>()     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        throw r5     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                    L_0x02a0:
                        r19 = r8
                        r20 = r9
                        r21 = r10
                        com.baidu.talos.core.websocket.WebSocketClient r5 = com.baidu.talos.core.websocket.WebSocketClient.this     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        com.baidu.talos.core.websocket.WebSocketClient$WebSocketListener r5 = r5.mListener     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        r5.onConnect()     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        com.baidu.talos.core.websocket.WebSocketClient r5 = com.baidu.talos.core.websocket.WebSocketClient.this     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        r7 = 1
                        boolean unused = r5.mConnected = r7     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        com.baidu.talos.core.websocket.WebSocketClient r5 = com.baidu.talos.core.websocket.WebSocketClient.this     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        com.baidu.talos.core.websocket.TalosParser r5 = r5.mParser     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        r5.start(r2)     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        com.baidu.talos.core.websocket.WebSocketClient r2 = com.baidu.talos.core.websocket.WebSocketClient.this
                        boolean r2 = r2.mConnected
                        if (r2 != 0) goto L_0x0440
                        com.baidu.talos.core.websocket.WebSocketClient r2 = com.baidu.talos.core.websocket.WebSocketClient.this
                        java.net.Socket r2 = r2.mSocket
                        if (r2 == 0) goto L_0x0440
                        com.baidu.talos.core.websocket.WebSocketClient r2 = com.baidu.talos.core.websocket.WebSocketClient.this     // Catch:{ all -> 0x02d9 }
                        java.net.Socket r2 = r2.mSocket     // Catch:{ all -> 0x02d9 }
                        r2.close()     // Catch:{ all -> 0x02d9 }
                        goto L_0x0388
                    L_0x02d9:
                        r0 = move-exception
                        r2 = r0
                        r5 = 2
                        java.lang.Object[] r5 = new java.lang.Object[r5]
                        r6 = 0
                        r5[r6] = r3
                        r3 = 1
                        r5[r3] = r2
                        com.baidu.talos.util.LogUtils.e(r4, r5)
                        com.baidu.talos.core.websocket.WebSocketClient r3 = com.baidu.talos.core.websocket.WebSocketClient.this
                        com.baidu.talos.core.websocket.WebSocketClient$WebSocketListener r3 = r3.mListener
                        java.lang.Exception r4 = new java.lang.Exception
                        r4.<init>(r2)
                        goto L_0x0382
                    L_0x02f4:
                        r19 = r8
                        r20 = r9
                        r21 = r10
                        java.net.ConnectException r5 = new java.net.ConnectException     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        r7.<init>()     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.String r8 = "WebSocketClient connect error: code="
                        java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        int r8 = r6.code     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.String r8 = ",message="
                        java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.String r8 = r6.message     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.String r7 = r7.toString()     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        r5.<init>(r7)     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        throw r5     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                    L_0x0321:
                        r19 = r8
                        r20 = r9
                        r21 = r10
                        java.net.ConnectException r5 = new java.net.ConnectException     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        java.lang.String r7 = "WebSocketClient received no reply from server."
                        r5.<init>(r7)     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                        throw r5     // Catch:{ EOFException -> 0x03e6, SSLException -> 0x038e, all -> 0x032f }
                    L_0x032f:
                        r0 = move-exception
                        r2 = r0
                        com.baidu.talos.core.websocket.WebSocketClient r5 = com.baidu.talos.core.websocket.WebSocketClient.this     // Catch:{ all -> 0x038a }
                        com.baidu.talos.core.websocket.WebSocketClient$WebSocketListener r5 = r5.mListener     // Catch:{ all -> 0x038a }
                        java.lang.Exception r6 = new java.lang.Exception     // Catch:{ all -> 0x038a }
                        r6.<init>(r2)     // Catch:{ all -> 0x038a }
                        r5.onError(r6)     // Catch:{ all -> 0x038a }
                        r2.printStackTrace()     // Catch:{ all -> 0x038a }
                        r5 = 1
                        java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ all -> 0x038a }
                        java.lang.String r5 = android.util.Log.getStackTraceString(r2)     // Catch:{ all -> 0x038a }
                        r7 = 0
                        r6[r7] = r5     // Catch:{ all -> 0x038a }
                        com.baidu.talos.util.LogUtils.e(r4, r6)     // Catch:{ all -> 0x038a }
                        com.baidu.talos.core.websocket.WebSocketClient r2 = com.baidu.talos.core.websocket.WebSocketClient.this
                        boolean r2 = r2.mConnected
                        if (r2 != 0) goto L_0x0440
                        com.baidu.talos.core.websocket.WebSocketClient r2 = com.baidu.talos.core.websocket.WebSocketClient.this
                        java.net.Socket r2 = r2.mSocket
                        if (r2 == 0) goto L_0x0440
                        com.baidu.talos.core.websocket.WebSocketClient r2 = com.baidu.talos.core.websocket.WebSocketClient.this     // Catch:{ all -> 0x0369 }
                        java.net.Socket r2 = r2.mSocket     // Catch:{ all -> 0x0369 }
                        r2.close()     // Catch:{ all -> 0x0369 }
                        goto L_0x0388
                    L_0x0369:
                        r0 = move-exception
                        r2 = r0
                        r5 = 2
                        java.lang.Object[] r5 = new java.lang.Object[r5]
                        r6 = 0
                        r5[r6] = r3
                        r3 = 1
                        r5[r3] = r2
                        com.baidu.talos.util.LogUtils.e(r4, r5)
                        com.baidu.talos.core.websocket.WebSocketClient r3 = com.baidu.talos.core.websocket.WebSocketClient.this
                        com.baidu.talos.core.websocket.WebSocketClient$WebSocketListener r3 = r3.mListener
                        java.lang.Exception r4 = new java.lang.Exception
                        r4.<init>(r2)
                    L_0x0382:
                        r3.onError(r4)
                        r2.printStackTrace()
                    L_0x0388:
                        goto L_0x0440
                    L_0x038a:
                        r0 = move-exception
                        r2 = r0
                        goto L_0x0441
                    L_0x038e:
                        r0 = move-exception
                        r2 = r0
                        r5 = 2
                        java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ all -> 0x038a }
                        java.lang.String r5 = "Websocket SSL error!"
                        r7 = 0
                        r6[r7] = r5     // Catch:{ all -> 0x038a }
                        r5 = 1
                        r6[r5] = r2     // Catch:{ all -> 0x038a }
                        com.baidu.talos.util.LogUtils.e(r4, r6)     // Catch:{ all -> 0x038a }
                        com.baidu.talos.core.websocket.WebSocketClient r5 = com.baidu.talos.core.websocket.WebSocketClient.this     // Catch:{ all -> 0x038a }
                        com.baidu.talos.core.websocket.WebSocketClient$WebSocketListener r5 = r5.mListener     // Catch:{ all -> 0x038a }
                        java.lang.String r6 = "SSL"
                        r7 = 0
                        r5.onDisconnect(r7, r6)     // Catch:{ all -> 0x038a }
                        com.baidu.talos.core.websocket.WebSocketClient r5 = com.baidu.talos.core.websocket.WebSocketClient.this     // Catch:{ all -> 0x038a }
                        boolean unused = r5.mConnected = r7     // Catch:{ all -> 0x038a }
                        r2.printStackTrace()     // Catch:{ all -> 0x038a }
                        com.baidu.talos.core.websocket.WebSocketClient r2 = com.baidu.talos.core.websocket.WebSocketClient.this
                        boolean r2 = r2.mConnected
                        if (r2 != 0) goto L_0x0440
                        com.baidu.talos.core.websocket.WebSocketClient r2 = com.baidu.talos.core.websocket.WebSocketClient.this
                        java.net.Socket r2 = r2.mSocket
                        if (r2 == 0) goto L_0x0440
                        com.baidu.talos.core.websocket.WebSocketClient r2 = com.baidu.talos.core.websocket.WebSocketClient.this     // Catch:{ all -> 0x03cc }
                        java.net.Socket r2 = r2.mSocket     // Catch:{ all -> 0x03cc }
                        r2.close()     // Catch:{ all -> 0x03cc }
                        goto L_0x0388
                    L_0x03cc:
                        r0 = move-exception
                        r2 = r0
                        r5 = 2
                        java.lang.Object[] r5 = new java.lang.Object[r5]
                        r6 = 0
                        r5[r6] = r3
                        r3 = 1
                        r5[r3] = r2
                        com.baidu.talos.util.LogUtils.e(r4, r5)
                        com.baidu.talos.core.websocket.WebSocketClient r3 = com.baidu.talos.core.websocket.WebSocketClient.this
                        com.baidu.talos.core.websocket.WebSocketClient$WebSocketListener r3 = r3.mListener
                        java.lang.Exception r4 = new java.lang.Exception
                        r4.<init>(r2)
                        goto L_0x0382
                    L_0x03e6:
                        r0 = move-exception
                        r2 = r0
                        r5 = 2
                        java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ all -> 0x038a }
                        java.lang.String r5 = "WebSocket EOF!"
                        r7 = 0
                        r6[r7] = r5     // Catch:{ all -> 0x038a }
                        r5 = 1
                        r6[r5] = r2     // Catch:{ all -> 0x038a }
                        com.baidu.talos.util.LogUtils.e(r4, r6)     // Catch:{ all -> 0x038a }
                        com.baidu.talos.core.websocket.WebSocketClient r5 = com.baidu.talos.core.websocket.WebSocketClient.this     // Catch:{ all -> 0x038a }
                        com.baidu.talos.core.websocket.WebSocketClient$WebSocketListener r5 = r5.mListener     // Catch:{ all -> 0x038a }
                        java.lang.String r6 = "EOF"
                        r7 = 0
                        r5.onDisconnect(r7, r6)     // Catch:{ all -> 0x038a }
                        com.baidu.talos.core.websocket.WebSocketClient r5 = com.baidu.talos.core.websocket.WebSocketClient.this     // Catch:{ all -> 0x038a }
                        boolean unused = r5.mConnected = r7     // Catch:{ all -> 0x038a }
                        r2.printStackTrace()     // Catch:{ all -> 0x038a }
                        com.baidu.talos.core.websocket.WebSocketClient r2 = com.baidu.talos.core.websocket.WebSocketClient.this
                        boolean r2 = r2.mConnected
                        if (r2 != 0) goto L_0x0440
                        com.baidu.talos.core.websocket.WebSocketClient r2 = com.baidu.talos.core.websocket.WebSocketClient.this
                        java.net.Socket r2 = r2.mSocket
                        if (r2 == 0) goto L_0x0440
                        com.baidu.talos.core.websocket.WebSocketClient r2 = com.baidu.talos.core.websocket.WebSocketClient.this     // Catch:{ all -> 0x0425 }
                        java.net.Socket r2 = r2.mSocket     // Catch:{ all -> 0x0425 }
                        r2.close()     // Catch:{ all -> 0x0425 }
                        goto L_0x0388
                    L_0x0425:
                        r0 = move-exception
                        r2 = r0
                        r5 = 2
                        java.lang.Object[] r5 = new java.lang.Object[r5]
                        r6 = 0
                        r5[r6] = r3
                        r3 = 1
                        r5[r3] = r2
                        com.baidu.talos.util.LogUtils.e(r4, r5)
                        com.baidu.talos.core.websocket.WebSocketClient r3 = com.baidu.talos.core.websocket.WebSocketClient.this
                        com.baidu.talos.core.websocket.WebSocketClient$WebSocketListener r3 = r3.mListener
                        java.lang.Exception r4 = new java.lang.Exception
                        r4.<init>(r2)
                        goto L_0x0382
                    L_0x0440:
                        return
                    L_0x0441:
                        com.baidu.talos.core.websocket.WebSocketClient r5 = com.baidu.talos.core.websocket.WebSocketClient.this
                        boolean r5 = r5.mConnected
                        if (r5 != 0) goto L_0x047a
                        com.baidu.talos.core.websocket.WebSocketClient r5 = com.baidu.talos.core.websocket.WebSocketClient.this
                        java.net.Socket r5 = r5.mSocket
                        if (r5 == 0) goto L_0x047a
                        com.baidu.talos.core.websocket.WebSocketClient r5 = com.baidu.talos.core.websocket.WebSocketClient.this     // Catch:{ all -> 0x045b }
                        java.net.Socket r5 = r5.mSocket     // Catch:{ all -> 0x045b }
                        r5.close()     // Catch:{ all -> 0x045b }
                        goto L_0x047a
                    L_0x045b:
                        r0 = move-exception
                        r5 = r0
                        r6 = 2
                        java.lang.Object[] r6 = new java.lang.Object[r6]
                        r7 = 0
                        r6[r7] = r3
                        r3 = 1
                        r6[r3] = r5
                        com.baidu.talos.util.LogUtils.e(r4, r6)
                        com.baidu.talos.core.websocket.WebSocketClient r3 = com.baidu.talos.core.websocket.WebSocketClient.this
                        com.baidu.talos.core.websocket.WebSocketClient$WebSocketListener r3 = r3.mListener
                        java.lang.Exception r4 = new java.lang.Exception
                        r4.<init>(r5)
                        r3.onError(r4)
                        r5.printStackTrace()
                    L_0x047a:
                        throw r2
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.baidu.talos.core.websocket.WebSocketClient.AnonymousClass1.run():void");
                }
            });
            this.mThread = thread2;
            thread2.start();
        }
    }

    public void disconnect() {
        if (this.mSocket != null) {
            this.mHandler.post(new Runnable() {
                public void run() {
                    if (WebSocketClient.this.mSocket != null) {
                        try {
                            WebSocketClient.this.mSocket.close();
                        } catch (Throwable ex) {
                            LogUtils.d(WebSocketClient.TAG, "Error while disconnecting", ex);
                            WebSocketClient.this.mListener.onError(new Exception(ex));
                        }
                        WebSocketClient.this.mListener.onDisconnect(0, "closed");
                        Socket unused = WebSocketClient.this.mSocket = null;
                    }
                    boolean unused2 = WebSocketClient.this.mConnected = false;
                }
            });
        }
    }

    public void send(String data) {
        sendFrame(this.mParser.frame(data));
    }

    public void send(byte[] data) {
        sendFrame(this.mParser.frame(data));
    }

    public void requestClose(int code, String reason) {
        this.mParser.close(code, reason);
        disconnect();
    }

    public boolean isConnected() {
        return this.mConnected;
    }

    public Boolean isServerClose() {
        return false;
    }

    /* access modifiers changed from: private */
    public StatusLine parseStatusLine(String line) throws IOException {
        if (TextUtils.isEmpty(line)) {
            return null;
        }
        return StatusLine.parse(line);
    }

    /* access modifiers changed from: private */
    public Header parseHeader(String line) {
        int index = line.indexOf(":");
        if (index != -1) {
            return new Header(line.substring(0, index).trim(), line.substring(index + 1));
        }
        throw new IllegalArgumentException("WebSocketClient Unexpected header: " + line);
    }

    /* access modifiers changed from: private */
    public String readLine(TalosParser.DataInputStreamTalos reader) throws IOException {
        int readChar = reader.read();
        if (readChar == -1) {
            return null;
        }
        StringBuilder string = new StringBuilder();
        while (readChar != 10) {
            if (readChar != 13) {
                string.append((char) readChar);
            }
            readChar = reader.read();
            if (readChar == -1) {
                return null;
            }
        }
        return string.toString();
    }

    /* access modifiers changed from: private */
    public String expectedKey(String secret) {
        Object obj = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
        try {
            return Base64.encodeToString(MessageDigest.getInstance("SHA-1").digest((secret + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").getBytes()), 0).trim();
        } catch (NoSuchAlgorithmException e2) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public String createSecret() {
        byte[] nonce = new byte[16];
        for (int i2 = 0; i2 < 16; i2++) {
            nonce[i2] = (byte) ((int) (Math.random() * 256.0d));
        }
        return Base64.encodeToString(nonce, 0).trim();
    }

    /* access modifiers changed from: package-private */
    public void sendFrame(final byte[] frame) {
        this.mHandler.post(new Runnable() {
            /* Debug info: failed to restart local var, previous not found, register: 3 */
            public void run() {
                try {
                    synchronized (WebSocketClient.this.mSendLock) {
                        OutputStream outputStream = WebSocketClient.this.mSocket.getOutputStream();
                        outputStream.write(frame);
                        outputStream.flush();
                    }
                } catch (Throwable e2) {
                    WebSocketClient.this.mListener.onError(new Exception(e2));
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public SSLSocketFactory getSSLSocketFactory() throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext context = SSLContext.getInstance("TLS");
        context.init((KeyManager[]) null, sTrustManagers, (SecureRandom) null);
        return context.getSocketFactory();
    }

    public WebSocketListener getListener() {
        return this.mListener;
    }
}
