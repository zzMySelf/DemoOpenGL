package com.pichillilorenzo.flutter_inappwebview.types;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public class DownloadStartRequest {
    @NonNull
    public String contentDisposition;
    public long contentLength;
    @NonNull
    public String mimeType;
    @Nullable
    public String suggestedFilename;
    @Nullable
    public String textEncodingName;
    @NonNull
    public String url;
    @NonNull
    public String userAgent;

    public DownloadStartRequest(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, long j, @Nullable String str5, @Nullable String str6) {
        this.url = str;
        this.userAgent = str2;
        this.contentDisposition = str3;
        this.mimeType = str4;
        this.contentLength = j;
        this.suggestedFilename = str5;
        this.textEncodingName = str6;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DownloadStartRequest.class != obj.getClass()) {
            return false;
        }
        DownloadStartRequest downloadStartRequest = (DownloadStartRequest) obj;
        if (this.contentLength != downloadStartRequest.contentLength || !this.url.equals(downloadStartRequest.url) || !this.userAgent.equals(downloadStartRequest.userAgent) || !this.contentDisposition.equals(downloadStartRequest.contentDisposition) || !this.mimeType.equals(downloadStartRequest.mimeType)) {
            return false;
        }
        String str = this.suggestedFilename;
        if (str == null ? downloadStartRequest.suggestedFilename != null : !str.equals(downloadStartRequest.suggestedFilename)) {
            return false;
        }
        String str2 = this.textEncodingName;
        String str3 = downloadStartRequest.textEncodingName;
        return str2 != null ? str2.equals(str3) : str3 == null;
    }

    @NonNull
    public String getContentDisposition() {
        return this.contentDisposition;
    }

    public long getContentLength() {
        return this.contentLength;
    }

    @NonNull
    public String getMimeType() {
        return this.mimeType;
    }

    @Nullable
    public String getSuggestedFilename() {
        return this.suggestedFilename;
    }

    @Nullable
    public String getTextEncodingName() {
        return this.textEncodingName;
    }

    @NonNull
    public String getUrl() {
        return this.url;
    }

    @NonNull
    public String getUserAgent() {
        return this.userAgent;
    }

    public int hashCode() {
        long j = this.contentLength;
        int hashCode = ((((((((this.url.hashCode() * 31) + this.userAgent.hashCode()) * 31) + this.contentDisposition.hashCode()) * 31) + this.mimeType.hashCode()) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        String str = this.suggestedFilename;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.textEncodingName;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode2 + i2;
    }

    public void setContentDisposition(@NonNull String str) {
        this.contentDisposition = str;
    }

    public void setContentLength(long j) {
        this.contentLength = j;
    }

    public void setMimeType(@NonNull String str) {
        this.mimeType = str;
    }

    public void setSuggestedFilename(@Nullable String str) {
        this.suggestedFilename = str;
    }

    public void setTextEncodingName(@Nullable String str) {
        this.textEncodingName = str;
    }

    public void setUrl(@NonNull String str) {
        this.url = str;
    }

    public void setUserAgent(@NonNull String str) {
        this.userAgent = str;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("url", this.url);
        hashMap.put("userAgent", this.userAgent);
        hashMap.put("contentDisposition", this.contentDisposition);
        hashMap.put("mimeType", this.mimeType);
        hashMap.put("contentLength", Long.valueOf(this.contentLength));
        hashMap.put("suggestedFilename", this.suggestedFilename);
        hashMap.put("textEncodingName", this.textEncodingName);
        return hashMap;
    }

    public String toString() {
        return "DownloadStartRequest{url='" + this.url + ExtendedMessageFormat.QUOTE + ", userAgent='" + this.userAgent + ExtendedMessageFormat.QUOTE + ", contentDisposition='" + this.contentDisposition + ExtendedMessageFormat.QUOTE + ", mimeType='" + this.mimeType + ExtendedMessageFormat.QUOTE + ", contentLength=" + this.contentLength + ", suggestedFilename='" + this.suggestedFilename + ExtendedMessageFormat.QUOTE + ", textEncodingName='" + this.textEncodingName + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
    }
}
