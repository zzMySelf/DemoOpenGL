package com.baidu.searchbox.dns.transmit.transmitter;

import android.text.TextUtils;
import com.baidu.searchbox.dns.transmit.transmitter.exception.ExceptionMessage;
import com.baidu.searchbox.dns.transmit.transmitter.exception.RetryException;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;

public abstract class HttpPostDataTransmitter<T> extends HttpDataTransmitter<T> {
    private static final String TAG = "HttpPostDataTransmitter";

    /* access modifiers changed from: protected */
    public void processExtraConnection(HttpURLConnection connection) throws ProtocolException {
        super.processExtraConnection(connection);
        connection.setRequestMethod("POST");
        connection.setInstanceFollowRedirects(true);
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setUseCaches(false);
    }

    /* access modifiers changed from: protected */
    public void postHandleConnection(HttpURLConnection connection) throws RetryException {
        String para = buildParametersString(getParameters());
        if (!TextUtils.isEmpty(para)) {
            DataOutputStream out = null;
            try {
                out = new DataOutputStream(connection.getOutputStream());
                out.write(para.getBytes("utf-8"));
                out.flush();
                try {
                    out.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            } catch (IOException e2) {
                throw new RetryException(ExceptionMessage.WRITE_CONTENT_FAIL);
            } catch (Throwable th2) {
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException ioException2) {
                        ioException2.printStackTrace();
                    }
                }
                throw th2;
            }
        }
    }
}
