package com.baidubce.services.bos.model;

import com.baidubce.auth.BceCredentials;
import com.baidubce.services.bos.callback.BosProgressCallback;
import com.baidubce.util.CheckUtils;

public class GetObjectRequest extends GenericObjectRequest {
    private BosProgressCallback progressCallback = null;
    private long[] range;

    public GetObjectRequest() {
    }

    public GetObjectRequest(String bucketName, String key) {
        super(bucketName, key);
    }

    public GetObjectRequest withRequestCredentials(BceCredentials credentials) {
        setRequestCredentials(credentials);
        return this;
    }

    public GetObjectRequest withBucketName(String bucketName) {
        setBucketName(bucketName);
        return this;
    }

    public GetObjectRequest withKey(String key) {
        setKey(key);
        return this;
    }

    public long[] getRange() {
        long[] jArr = this.range;
        if (jArr == null) {
            return null;
        }
        return (long[]) jArr.clone();
    }

    public void setRange(long start, long end) {
        CheckUtils.checkArgument(start >= 0, "start should be non-negative.");
        CheckUtils.checkArgument(start <= end, "start should not be greater than end");
        this.range = new long[]{start, end};
    }

    public GetObjectRequest withRange(long start, long end) {
        setRange(start, end);
        return this;
    }

    public BosProgressCallback getProgressCallback() {
        return this.progressCallback;
    }

    public <T extends GetObjectRequest> void setProgressCallback(BosProgressCallback<T> progressCallback2) {
        this.progressCallback = progressCallback2;
    }

    public <T extends GetObjectRequest> GetObjectRequest withProgressCallback(BosProgressCallback<T> progressCallback2) {
        this.progressCallback = progressCallback2;
        return this;
    }
}
