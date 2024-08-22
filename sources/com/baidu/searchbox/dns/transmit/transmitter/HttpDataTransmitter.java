package com.baidu.searchbox.dns.transmit.transmitter;

import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.dns.HttpDnsRuntime;
import com.baidu.searchbox.dns.transmit.transmitter.exception.ExceptionMessage;
import com.baidu.searchbox.dns.transmit.transmitter.exception.RetryException;
import com.baidu.searchbox.dns.transmit.transmitter.exception.StopRequestException;
import com.baidu.searchbox.dns.util.DnsUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;

public abstract class HttpDataTransmitter<T> implements HttpTransmitter<T> {
    public static final String CHARSET = "UTF-8";
    public static final String CONTENT_TYPE = "application/x-www-form-urlencoded;charset=UTF-8";
    public static final String CONTENT_TYPE_KEY = "Content-Type";
    protected static final int RETRY_DELAY = 5000;
    protected static final int RETRY_MAX_TIMES = 2;
    public static final int SUCCESS_CODE = 200;
    public static final int TIMEOUT = 30000;
    public static final String USER_AGENT = "Mozilla/5.0 (Linux; Android %s) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30";
    private boolean mIsCancel = false;
    protected int maxRetryTimes = getMaxRetryTimes();
    protected int retryTimes = 0;

    /* access modifiers changed from: protected */
    public abstract Map<String, Object> getParameters();

    /* access modifiers changed from: protected */
    public abstract String getUrl();

    /* access modifiers changed from: protected */
    public abstract void handleException(Exception exc);

    /* access modifiers changed from: protected */
    public abstract void handleServerError(int i2);

    /* access modifiers changed from: protected */
    public abstract T parseResult(String str);

    /* access modifiers changed from: protected */
    public abstract void postHandleConnection(HttpURLConnection httpURLConnection) throws RetryException;

    protected HttpDataTransmitter() {
    }

    /* access modifiers changed from: protected */
    public int getMaxRetryTimes() {
        return 2;
    }

    /* access modifiers changed from: protected */
    public boolean isHttps() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void processExtraConnection(HttpURLConnection connection) throws ProtocolException {
        connection.setRequestProperty("Content-Type", CONTENT_TYPE);
        connection.setRequestProperty("User-Agent", getUserAgent());
    }

    /* access modifiers changed from: protected */
    public String getUserAgent() {
        StringBuffer buffer = new StringBuffer();
        String version = Build.VERSION.RELEASE;
        if (version.length() > 0) {
            buffer.append(version);
        } else {
            buffer.append("1.0");
        }
        if ("REL".equals(Build.VERSION.CODENAME)) {
            String model = Build.MODEL;
            if (model.length() > 0) {
                buffer.append("; ");
                buffer.append(model);
            }
        }
        String id = Build.ID;
        if (id.length() > 0) {
            buffer.append(" Build/");
            buffer.append(id);
        }
        return String.format(USER_AGENT, new Object[]{buffer});
    }

    /* access modifiers changed from: protected */
    public String buildParametersString(Map<String, Object> parameters) {
        StringBuilder paraBuilder = new StringBuilder();
        for (Map.Entry<String, Object> entry : parameters.entrySet()) {
            try {
                paraBuilder.append(entry.getKey() + "=" + URLEncoder.encode(entry.getValue().toString(), "UTF-8"));
                paraBuilder.append("&");
            } catch (UnsupportedEncodingException e2) {
                return null;
            }
        }
        if (paraBuilder.length() > 0) {
            paraBuilder.deleteCharAt(paraBuilder.length() - 1);
        }
        return paraBuilder.toString();
    }

    private T transmitData() throws RetryException, StopRequestException {
        HttpURLConnection connection;
        if (!this.mIsCancel) {
            HttpURLConnection connection2 = null;
            String url = getUrl();
            if (DnsUtil.DEBUG) {
                Log.d(DnsUtil.TAG, " sendRequest url:" + url);
            }
            if (!TextUtils.isEmpty(url)) {
                try {
                    if (!isHttps()) {
                        connection = (HttpURLConnection) new URL(url).openConnection();
                    } else {
                        connection = (HttpsURLConnection) new URL(url).openConnection();
                    }
                    connection.setRequestProperty("Charsert", "UTF-8");
                    connection.setConnectTimeout(30000);
                    connection.setReadTimeout(30000);
                    processExtraConnection(connection);
                    connection.connect();
                    postHandleConnection(connection);
                    handleResponseCode(connection);
                    T result = parseResult(handleResponseEntity(connection));
                    if (connection != null) {
                        connection.disconnect();
                    }
                    return result;
                } catch (Exception e2) {
                    throw new RetryException(e2.getMessage());
                } catch (Throwable th2) {
                    if (connection2 != null) {
                        connection2.disconnect();
                    }
                    throw th2;
                }
            } else {
                throw new StopRequestException(ExceptionMessage.URL_EMPTY);
            }
        } else {
            throw new StopRequestException(10002, ExceptionMessage.CANCEL);
        }
    }

    /* access modifiers changed from: protected */
    public void doRetry(RetryException e2) throws StopRequestException {
        int i2 = this.retryTimes + 1;
        this.retryTimes = i2;
        if (i2 <= this.maxRetryTimes) {
            SystemClock.sleep(5000);
        } else if (e2.getFailStatus() == 10001) {
            throw new StopRequestException(e2.getFailStatus(), e2.getDetailErrorCode(), " retry count reach fail ");
        } else {
            throw new StopRequestException(" retry count reach fail ");
        }
    }

    /* access modifiers changed from: protected */
    public void handleResponseCode(HttpURLConnection connection) throws RetryException, StopRequestException {
        try {
            int statusCode = connection.getResponseCode();
            if (statusCode != 200) {
                String errMessage = " http response error -> " + statusCode;
                if (isNoRetryServerError(statusCode)) {
                    throw new StopRequestException(10001, statusCode, errMessage);
                }
                throw new RetryException(10001, statusCode, errMessage);
            }
        } catch (IOException e2) {
            throw new RetryException(e2.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public String handleResponseEntity(HttpURLConnection connection) throws RetryException, StopRequestException {
        BufferedReader reader = null;
        InputStream inputStream = null;
        try {
            String encoding = connection.getContentEncoding();
            InputStream inputStream2 = connection.getInputStream();
            if (!TextUtils.isEmpty(encoding) && encoding.equals("gzip")) {
                inputStream2 = new GZIPInputStream(inputStream2);
            }
            BufferedReader reader2 = new BufferedReader(new InputStreamReader(inputStream2, "utf-8"));
            StringBuffer sb = new StringBuffer();
            while (true) {
                String readLine = reader2.readLine();
                String lines = readLine;
                if (readLine == null) {
                    break;
                }
                sb.append(new String(lines.getBytes("utf-8"), "utf-8"));
            }
            String responseString = sb.toString();
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
            try {
                reader2.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            return responseString;
        } catch (Exception e2) {
            throw new StopRequestException(e2.getMessage());
        } catch (Throwable th2) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException exception2) {
                    exception2.printStackTrace();
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ioException2) {
                    ioException2.printStackTrace();
                }
            }
            throw th2;
        }
    }

    /* access modifiers changed from: protected */
    public boolean isNoRetryServerError(int httpResponseCode) {
        if (403 == httpResponseCode || 404 == httpResponseCode) {
            return true;
        }
        return false;
    }

    public T sendRequest() {
        this.retryTimes = 0;
        try {
            if (HttpDnsRuntime.getHttpDnsConfig() != null) {
                while (this.retryTimes <= this.maxRetryTimes) {
                    try {
                        return transmitData();
                    } catch (RetryException e2) {
                        doRetry(e2);
                    }
                }
                return null;
            }
            throw new StopRequestException(10003, ExceptionMessage.CLIENT_INIT_ERROR_MSG);
        } catch (StopRequestException ex) {
            if (ex.getFailStatus() == 10001) {
                handleServerError(ex.getDetailErrorCode());
                return null;
            }
            handleException(ex);
            return null;
        }
    }

    public void cancel() {
        this.mIsCancel = true;
    }
}
