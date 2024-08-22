package com.baidu.nadcore.net.request;

import android.text.TextUtils;
import com.baidu.nadcore.safe.CollectionUtils;
import com.baidu.nadcore.safe.MapUtils;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequestBody {
    public static final byte[] EMPTY_BYTE_ARRAY;
    public static final RequestBody EMPTY_BYTE_REQUEST;
    public static final RequestBody EMPTY_FORM_REQUEST = create((String) null, (Map<String, String>) new HashMap());
    public static final String[] EMPTY_STRING_ARRAY = new String[0];
    public static final RequestBody EMPTY_STRING_REQUEST = create((String) null, "");
    private static final String MEDIA_APPLICATION_FORM = "application/x-www-form-urlencoded";
    private static final String MEDIA_APPLICATION_OCTET_STREAM = "application/octet-stream";
    private static final String MEDIA_TEXT_PLAIN = "text/plain";
    public byte[] byteContent;
    public String content;
    public File file;
    public String mediaType;
    public Map<String, String> params;
    public BodyStyle style;

    static {
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        EMPTY_BYTE_REQUEST = create((String) null, bArr);
    }

    public RequestBody setStyle(BodyStyle style2) {
        this.style = style2;
        return this;
    }

    public RequestBody setMediaType(String mediaType2) {
        this.mediaType = mediaType2;
        return this;
    }

    public RequestBody setContent(String content2) {
        this.content = content2;
        return this;
    }

    public RequestBody setByteContent(byte[] byteContent2) {
        this.byteContent = byteContent2;
        return this;
    }

    public RequestBody setFile(File file2) {
        this.file = file2;
        return this;
    }

    public RequestBody setParams(Map<String, String> params2) {
        this.params = params2;
        return this;
    }

    public RequestBody addParam(String key, String value) {
        if (this.params == null) {
            this.params = new HashMap();
        }
        this.params.put(key, value);
        return this;
    }

    public RequestBody removeParam(String key) {
        if (!MapUtils.isEmpty(this.params)) {
            this.params.remove(key);
        }
        return this;
    }

    public RequestBody removeParams(List<String> keys) {
        if (!MapUtils.isEmpty(this.params) && keys != null && keys.size() > 0) {
            for (String key : keys) {
                this.params.remove(key);
            }
        }
        return this;
    }

    /* renamed from: com.baidu.nadcore.net.request.RequestBody$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$nadcore$net$request$BodyStyle;

        static {
            int[] iArr = new int[BodyStyle.values().length];
            $SwitchMap$com$baidu$nadcore$net$request$BodyStyle = iArr;
            try {
                iArr[BodyStyle.BYTE.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$baidu$nadcore$net$request$BodyStyle[BodyStyle.STRING.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$baidu$nadcore$net$request$BodyStyle[BodyStyle.FILE.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$baidu$nadcore$net$request$BodyStyle[BodyStyle.FORM.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public long size() {
        switch (AnonymousClass1.$SwitchMap$com$baidu$nadcore$net$request$BodyStyle[this.style.ordinal()]) {
            case 1:
                return (long) CollectionUtils.size(this.byteContent);
            case 2:
                String str = this.content;
                if (str == null) {
                    return 0;
                }
                return (long) str.length();
            case 3:
                File file2 = this.file;
                if (file2 != null) {
                    return file2.length();
                }
                return 0;
            case 4:
                Map<String, String> map = this.params;
                if (map != null) {
                    return (long) map.size();
                }
                return 0;
            default:
                return 0;
        }
    }

    public long contentLength() {
        switch (AnonymousClass1.$SwitchMap$com$baidu$nadcore$net$request$BodyStyle[this.style.ordinal()]) {
            case 1:
                return (long) CollectionUtils.size(this.byteContent);
            case 2:
                String str = this.content;
                if (str == null) {
                    return 0;
                }
                return (long) str.getBytes().length;
            case 3:
                File file2 = this.file;
                if (file2 != null) {
                    return file2.length();
                }
                return 0;
            case 4:
                return formLength(this.params);
            default:
                return 0;
        }
    }

    private long formLength(Map<String, String> params2) {
        if (CollectionUtils.isNullOrEmpty(params2)) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : params2.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                if (sb.length() > 0) {
                    sb.append('&');
                }
                sb.append(entry.getKey());
                sb.append('=');
                sb.append(entry.getValue());
            }
        }
        return (long) CollectionUtils.size(sb.toString().getBytes());
    }

    public static RequestBody create(String content2) {
        return create("text/plain", content2);
    }

    public static RequestBody create(String mediaType2, String content2) {
        return new RequestBody().setStyle(BodyStyle.STRING).setMediaType(mediaType2).setContent(content2);
    }

    public static RequestBody create(String mediaType2, byte[] byteContent2) {
        return new RequestBody().setStyle(BodyStyle.BYTE).setMediaType(mediaType2).setByteContent(byteContent2);
    }

    public static RequestBody create(byte[] byteContent2) {
        return create("application/octet-stream", byteContent2);
    }

    public static RequestBody create(String mediaType2, File file2) {
        return new RequestBody().setStyle(BodyStyle.FILE).setMediaType(mediaType2).setFile(file2);
    }

    public static RequestBody create(File file2) {
        return create("application/octet-stream", file2);
    }

    public static RequestBody create(String mediaType2, Map<String, String> params2) {
        return new RequestBody().setStyle(BodyStyle.FORM).setMediaType(mediaType2).setParams(params2);
    }

    public static RequestBody create(Map<String, String> params2) {
        return create("application/x-www-form-urlencoded", params2);
    }
}
