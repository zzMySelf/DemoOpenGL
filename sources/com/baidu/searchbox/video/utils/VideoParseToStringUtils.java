package com.baidu.searchbox.video.utils;

import com.baidu.android.util.io.StreamUtils;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Response;
import okhttp3.ResponseBody;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u001a\u0010\u0010\u0004\u001a\u00020\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u001a\u0010\u0010\u0004\u001a\u00020\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0007\u001a\u0010\u0010\b\u001a\u00020\u00012\b\u0010\t\u001a\u0004\u0018\u00010\n¨\u0006\u000b"}, d2 = {"byteArrayToStringSafely", "", "byteArray", "", "responseToStringSafely", "response", "Lcom/baidu/searchbox/network/outback/core/Response;", "Lokhttp3/Response;", "streamToString", "inputStream", "Ljava/io/InputStream;", "lib-detail-component_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoParseToStringUtils.kt */
public final class VideoParseToStringUtils {
    public static final String streamToString(InputStream inputStream) {
        if (inputStream == null) {
            return "";
        }
        InputStream inputStream2 = inputStream;
        String streamToString = StreamUtils.streamToString(inputStream);
        if (streamToString == null) {
            return "";
        }
        Intrinsics.checkNotNullExpressionValue(streamToString, "StreamUtils.streamToString(inputStream) ?: \"\"");
        return streamToString;
    }

    public static final String byteArrayToStringSafely(byte[] byteArray) {
        if (byteArray != null) {
            byte[] bArr = byteArray;
            String streamToString = streamToString(new ByteArrayInputStream(byteArray));
            if (streamToString == null) {
                return "";
            }
            return streamToString;
        }
        return "";
    }

    public static final String responseToStringSafely(Response response) {
        String str;
        if (response != null) {
            ResponseBody $this$responseToStringSafely_u24lambda_u2d3_u24lambda_u2d2 = response.body();
            if ($this$responseToStringSafely_u24lambda_u2d3_u24lambda_u2d2 != null) {
                str = streamToString($this$responseToStringSafely_u24lambda_u2d3_u24lambda_u2d2.byteStream());
            } else {
                str = null;
            }
            if (str == null) {
                return "";
            }
            return str;
        }
        return "";
    }

    public static final String responseToStringSafely(com.baidu.searchbox.network.outback.core.Response response) {
        String str;
        if (response != null) {
            com.baidu.searchbox.network.outback.core.ResponseBody $this$responseToStringSafely_u24lambda_u2d5_u24lambda_u2d4 = response.body();
            if ($this$responseToStringSafely_u24lambda_u2d5_u24lambda_u2d4 != null) {
                str = streamToString($this$responseToStringSafely_u24lambda_u2d5_u24lambda_u2d4.byteStream());
            } else {
                str = null;
            }
            if (str == null) {
                return "";
            }
            return str;
        }
        return "";
    }
}
