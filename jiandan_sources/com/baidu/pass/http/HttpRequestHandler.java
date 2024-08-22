package com.baidu.pass.http;

import android.os.Handler;
import android.os.Looper;
import com.baidu.pass.a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class HttpRequestHandler extends Handler implements a {
    public static final int BEGIN_COMPRESS = 0;
    public boolean executCallbackInChildThread;

    public HttpRequestHandler(Looper looper) {
        this(looper, false);
    }

    /* JADX INFO: finally extract failed */
    public byte[] compress(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        try {
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.finish();
            gZIPOutputStream.flush();
            gZIPOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th2) {
            gZIPOutputStream.close();
            throw th2;
        }
    }

    public HttpRequestHandler(Looper looper, boolean z) {
        super(looper);
        this.executCallbackInChildThread = z;
    }
}
