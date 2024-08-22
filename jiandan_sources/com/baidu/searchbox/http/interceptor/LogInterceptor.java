package com.baidu.searchbox.http.interceptor;

import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.google.common.base.Ascii;
import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.concurrent.TimeUnit;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpHeaders;
import okio.Buffer;
import okio.BufferedSource;

public class LogInterceptor implements Interceptor {

    /* renamed from: de  reason: collision with root package name */
    public static final Charset f1042de = Charset.forName("UTF-8");

    /* renamed from: ad  reason: collision with root package name */
    public volatile Level f1043ad;
    public final Logger qw;

    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    public interface Logger {
        void log(String str);
    }

    public class qw implements Logger {
        public String qw;

        public qw(LogInterceptor logInterceptor, String str) {
            if (!TextUtils.isEmpty(str)) {
                this.qw = str;
            }
        }

        public void log(String str) {
        }
    }

    public LogInterceptor(String str, Level level) {
        this((Logger) null, str, level);
    }

    public static boolean ad(Buffer buffer) throws EOFException {
        try {
            Buffer buffer2 = new Buffer();
            buffer.copyTo(buffer2, 0, buffer.size() < 64 ? buffer.size() : 64);
            for (int i2 = 0; i2 < 16; i2++) {
                if (buffer2.exhausted()) {
                    return true;
                }
                if (Character.isISOControl(buffer2.readUtf8CodePoint())) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        boolean z;
        String str;
        String str2;
        boolean z2;
        Interceptor.Chain chain2 = chain;
        Level level = this.f1043ad;
        Request request = chain.request();
        if (level == null || level == Level.NONE) {
            return chain2.proceed(request);
        }
        boolean z3 = true;
        boolean z4 = level == Level.BODY;
        boolean z5 = z4 || level == Level.HEADERS;
        RequestBody body = request.body();
        if (body == null) {
            z3 = false;
        }
        Connection connection = chain.connection();
        String str3 = "--> " + request.method() + Ascii.CASE_MASK + request.url() + Ascii.CASE_MASK + (connection != null ? connection.protocol() : Protocol.HTTP_1_1);
        if (!z5 && z3) {
            str3 = str3 + " (" + body.contentLength() + "-byte body)";
        }
        this.qw.log(str3);
        if (z5) {
            if (z3) {
                if (body.contentType() != null) {
                    this.qw.log("Content-Type: " + body.contentType());
                }
                if (body.contentLength() != -1) {
                    this.qw.log("Content-Length: " + body.contentLength());
                }
            }
            Headers headers = request.headers();
            int size = headers.size();
            int i2 = 0;
            while (i2 < size) {
                String name = headers.name(i2);
                int i3 = size;
                if ("Content-Type".equalsIgnoreCase(name) || "Content-Length".equalsIgnoreCase(name)) {
                    z2 = z5;
                } else {
                    z2 = z5;
                    this.qw.log(name + ": " + headers.value(i2));
                }
                i2++;
                size = i3;
                z5 = z2;
            }
            z = z5;
            if (!z4 || !z3) {
                this.qw.log("--> END " + request.method());
            } else if (qw(request.headers())) {
                this.qw.log("--> END " + request.method() + " (encoded body omitted)");
            } else {
                Buffer buffer = new Buffer();
                body.writeTo(buffer);
                Charset charset = f1042de;
                MediaType contentType = body.contentType();
                if (contentType != null) {
                    charset = contentType.charset(f1042de);
                }
                this.qw.log("");
                if (ad(buffer)) {
                    this.qw.log(buffer.readString(charset));
                    this.qw.log("--> END " + request.method() + " (" + body.contentLength() + "-byte body)");
                } else {
                    this.qw.log("--> END " + request.method() + " (binary " + body.contentLength() + "-byte body omitted)");
                }
            }
        } else {
            z = z5;
        }
        long nanoTime = System.nanoTime();
        Response proceed = chain2.proceed(request);
        long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime);
        ResponseBody body2 = proceed.body();
        long contentLength = body2.contentLength();
        if (contentLength != -1) {
            str = contentLength + "-byte";
        } else {
            str = "unknown-length";
        }
        Logger logger = this.qw;
        StringBuilder sb = new StringBuilder();
        String str4 = "-byte body)";
        sb.append("<-- ");
        sb.append(proceed.code());
        sb.append(Ascii.CASE_MASK);
        long j = contentLength;
        sb.append(proceed.message());
        sb.append(Ascii.CASE_MASK);
        sb.append(proceed.request().url());
        sb.append(" (");
        sb.append(millis);
        sb.append("ms");
        if (!z) {
            str2 = StringUtil.ARRAY_ELEMENT_SEPARATOR + str + " body";
        } else {
            str2 = "";
        }
        sb.append(str2);
        sb.append(')');
        logger.log(sb.toString());
        if (z) {
            Headers headers2 = proceed.headers();
            int size2 = headers2.size();
            for (int i4 = 0; i4 < size2; i4++) {
                this.qw.log(headers2.name(i4) + ": " + headers2.value(i4));
            }
            if (!z4 || !HttpHeaders.hasBody(proceed)) {
                this.qw.log("<-- END HTTP");
            } else if (qw(proceed.headers())) {
                this.qw.log("<-- END HTTP (encoded body omitted)");
            } else {
                BufferedSource source = body2.source();
                source.request(Long.MAX_VALUE);
                Buffer buffer2 = source.buffer();
                Charset charset2 = f1042de;
                MediaType contentType2 = body2.contentType();
                if (contentType2 != null) {
                    try {
                        charset2 = contentType2.charset(f1042de);
                    } catch (UnsupportedCharsetException unused) {
                        this.qw.log("");
                        this.qw.log("Couldn't decode the response body; charset is likely malformed.");
                        this.qw.log("<-- END HTTP");
                        return proceed;
                    }
                }
                if (!ad(buffer2)) {
                    this.qw.log("");
                    this.qw.log("<-- END HTTP (binary " + buffer2.size() + "-byte body omitted)");
                    return proceed;
                }
                if (j != 0) {
                    this.qw.log("");
                    this.qw.log(buffer2.clone().readString(charset2));
                }
                this.qw.log("<-- END HTTP (" + buffer2.size() + str4);
            }
        }
        return proceed;
    }

    public final boolean qw(Headers headers) {
        String str = headers.get("Content-Encoding");
        return str != null && !str.equalsIgnoreCase("identity");
    }

    public LogInterceptor(Logger logger, String str, Level level) {
        this.f1043ad = Level.NONE;
        if (logger != null) {
            this.qw = logger;
        } else {
            this.qw = new qw(this, str);
        }
        this.f1043ad = level;
    }
}
