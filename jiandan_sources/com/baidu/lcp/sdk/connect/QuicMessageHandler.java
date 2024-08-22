package com.baidu.lcp.sdk.connect;

import android.content.Context;
import fe.fe.p004if.qw.de.ad;
import fe.fe.p004if.qw.de.de;
import fe.fe.p004if.qw.de.qw;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public class QuicMessageHandler extends ad implements QuicEventCallbackListener {
    static {
        System.loadLibrary("native-lib");
    }

    public QuicMessageHandler(Context context) {
        super(context);
        initGlobalRef(this);
    }

    public InputStream ad() throws EOFException, IOException {
        return null;
    }

    public native void closeStream(int i2);

    public void de(de deVar) {
    }

    public native void enableQuicCache(boolean z, String str);

    public boolean fe() throws IOException {
        return false;
    }

    public native void initGlobalRef(QuicEventCallbackListener quicEventCallbackListener);

    public de rg(String str, int i2) {
        return null;
    }

    public native int sendMsg(byte[] bArr);

    public native int startConnect(String str, String str2);

    public native int stopConnect();

    public void th(qw qwVar) throws IOException {
    }
}
