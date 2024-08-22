package com.baidubce.services.bos.model;

import com.baidubce.util.CheckUtils;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class ObjectMetadata {
    private long appendOffset;
    private String bceContentSha256;
    private String cacheControl;
    private String contentDisposition;
    private String contentEncoding;
    private long contentLength = -1;
    private String contentMd5;
    private String contentRange;
    private String contentType;
    private String eTag;
    private String expires;
    private long instanceLength = -1;
    private Date lastModified;
    private String objectType;
    private String storageClass;
    private Map<String, String> userMetadata = new HashMap();

    public ObjectMetadata() {
    }

    public ObjectMetadata(ObjectMetadata other) {
        if (other.userMetadata != null) {
            this.userMetadata = new HashMap(other.userMetadata);
        }
        setBceContentSha256(other.getBceContentSha256());
        setContentDisposition(other.getContentDisposition());
        setContentEncoding(other.getContentEncoding());
        setContentLength(other.getContentLength());
        setContentMd5(other.getContentMd5());
        setContentType(other.getContentType());
        setETag(other.getETag());
        setInstanceLength(other.getInstanceLength());
        setLastModified(other.getLastModified());
        setExpires(other.getExpires());
        setAppendOffset(other.getAppendOffset());
        setObjectType(other.getObjectType());
        setCacheControl(other.getCacheControl());
        setStorageClass(other.getStorageClass());
    }

    public Map<String, String> getUserMetadata() {
        return this.userMetadata;
    }

    public void setUserMetadata(Map<String, String> userMetadata2) {
        CheckUtils.isNotNull(userMetadata2, "userMetadata should not be null.");
        this.userMetadata = userMetadata2;
    }

    public void addUserMetadata(String key, String value) {
        this.userMetadata.put(key, value);
    }

    public String getUserMetaDataOf(String key) {
        Map<String, String> map = this.userMetadata;
        if (map == null) {
            return null;
        }
        return map.get(key);
    }

    public void setContentRange(String contentRange2) {
        this.contentRange = contentRange2;
    }

    public String getContentRange() {
        return this.contentRange;
    }

    public String getBceContentSha256() {
        return this.bceContentSha256;
    }

    public void setBceContentSha256(String bceContentSha2562) {
        this.bceContentSha256 = bceContentSha2562;
    }

    public String getContentDisposition() {
        return this.contentDisposition;
    }

    public void setContentDisposition(String contentDisposition2) {
        this.contentDisposition = contentDisposition2;
    }

    public String getContentEncoding() {
        return this.contentEncoding;
    }

    public void setContentEncoding(String contentEncoding2) {
        this.contentEncoding = contentEncoding2;
    }

    public long getContentLength() {
        return this.contentLength;
    }

    public void setContentLength(long contentLength2) {
        this.contentLength = contentLength2;
    }

    public String getContentMd5() {
        return this.contentMd5;
    }

    public void setContentMd5(String contentMd52) {
        this.contentMd5 = contentMd52;
    }

    public String getContentType() {
        return this.contentType;
    }

    public void setContentType(String contentType2) {
        this.contentType = contentType2;
    }

    public String getETag() {
        return this.eTag;
    }

    public void setETag(String eTag2) {
        this.eTag = eTag2;
    }

    public long getInstanceLength() {
        return this.instanceLength;
    }

    public void setInstanceLength(long instanceLength2) {
        this.instanceLength = instanceLength2;
    }

    public Date getLastModified() {
        return this.lastModified;
    }

    public void setLastModified(Date lastModified2) {
        this.lastModified = lastModified2;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder("ObjectMetadata [");
        builder.append("userMetadata=").append(this.userMetadata);
        if (this.bceContentSha256 != null) {
            builder.append(", bceContentSha256=").append(this.bceContentSha256);
        }
        if (this.contentDisposition != null) {
            builder.append(", contentDisposition=").append(this.contentDisposition);
        }
        if (this.contentEncoding != null) {
            builder.append(", contentEncoding=").append(this.contentEncoding);
        }
        if (this.contentLength >= 0) {
            builder.append(", contentLength=").append(this.contentLength);
        }
        if (this.contentMd5 != null) {
            builder.append(", contentMd5=").append(this.contentMd5);
        }
        if (this.contentType != null) {
            builder.append(", contentType=").append(this.contentType);
        }
        if (this.eTag != null) {
            builder.append(", eTag=").append(this.eTag);
        }
        if (this.instanceLength >= 0) {
            builder.append(", instanceLength=").append(this.instanceLength);
        }
        if (this.lastModified != null) {
            builder.append(", lastModified=").append(this.lastModified);
        }
        if (this.cacheControl != null) {
            builder.append(", cacheControl=").append(this.cacheControl);
        }
        if (this.storageClass != null) {
            builder.append(", storageClass=").append(this.storageClass);
        }
        builder.append(AbstractJsonLexerKt.END_LIST);
        return builder.toString();
    }

    public String getExpires() {
        return this.expires;
    }

    public void setExpires(String expires2) {
        this.expires = expires2;
    }

    public long getAppendOffset() {
        return this.appendOffset;
    }

    public void setAppendOffset(long appendOffset2) {
        this.appendOffset = appendOffset2;
    }

    public String getObjectType() {
        return this.objectType;
    }

    public void setObjectType(String objectType2) {
        this.objectType = objectType2;
    }

    public String getCacheControl() {
        return this.cacheControl;
    }

    public void setCacheControl(String cacheControl2) {
        this.cacheControl = cacheControl2;
    }

    public String getStorageClass() {
        return this.storageClass;
    }

    public void setStorageClass(String storageClass2) {
        this.storageClass = storageClass2;
    }
}
