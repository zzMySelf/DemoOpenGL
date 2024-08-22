package com.baidubce.services.bos.model;

import com.baidubce.auth.BceCredentials;
import com.baidubce.services.bos.callback.BosProgressCallback;
import com.baidubce.util.CheckUtils;
import java.io.InputStream;

public class UploadPartRequest extends GenericUploadRequest {
    public InputStream inputStream;
    public String md5Digest;
    public int partNumber;
    public long partSize;
    public BosProgressCallback progressCallback = null;

    public UploadPartRequest() {
    }

    public InputStream getInputStream() {
        return this.inputStream;
    }

    public String getMd5Digest() {
        return this.md5Digest;
    }

    public int getPartNumber() {
        return this.partNumber;
    }

    public long getPartSize() {
        return this.partSize;
    }

    public BosProgressCallback getProgressCallback() {
        return this.progressCallback;
    }

    public void setInputStream(InputStream inputStream2) {
        CheckUtils.isNotNull(inputStream2, "inputStream should not be null.");
        this.inputStream = inputStream2;
    }

    public void setMd5Digest(String str) {
        this.md5Digest = str;
    }

    public void setPartNumber(int i2) {
        CheckUtils.checkArgument(i2 > 0, "partNumber should be positive, but is %s", Integer.valueOf(i2));
        this.partNumber = i2;
    }

    public void setPartSize(long j) {
        CheckUtils.checkArgument(j >= 0, "partSize should not be negative.");
        this.partSize = j;
    }

    public <T extends UploadPartRequest> void setProgressCallback(BosProgressCallback<T> bosProgressCallback) {
        this.progressCallback = bosProgressCallback;
    }

    public UploadPartRequest withInputStream(InputStream inputStream2) {
        setInputStream(inputStream2);
        return this;
    }

    public UploadPartRequest withMD5Digest(String str) {
        setMd5Digest(str);
        return this;
    }

    public UploadPartRequest withPartNumber(int i2) {
        setPartNumber(i2);
        return this;
    }

    public UploadPartRequest withPartSize(long j) {
        setPartSize(j);
        return this;
    }

    public <T extends UploadPartRequest> UploadPartRequest withProgressCallback(BosProgressCallback<T> bosProgressCallback) {
        this.progressCallback = bosProgressCallback;
        return this;
    }

    public UploadPartRequest withBucketName(String str) {
        setBucketName(str);
        return this;
    }

    public UploadPartRequest withKey(String str) {
        setKey(str);
        return this;
    }

    public UploadPartRequest withRequestCredentials(BceCredentials bceCredentials) {
        setRequestCredentials(bceCredentials);
        return this;
    }

    public UploadPartRequest withUploadId(String str) {
        setUploadId(str);
        return this;
    }

    public UploadPartRequest(String str, String str2, String str3, int i2, long j, InputStream inputStream2) {
        super(str, str2, str3);
        setPartNumber(i2);
        setPartSize(j);
        setInputStream(inputStream2);
    }
}
