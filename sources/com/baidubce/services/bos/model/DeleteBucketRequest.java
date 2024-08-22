package com.baidubce.services.bos.model;

import com.baidubce.auth.BceCredentials;

public class DeleteBucketRequest extends GenericBucketRequest {
    public DeleteBucketRequest(String bucketName) {
        super(bucketName);
    }

    public DeleteBucketRequest withRequestCredentials(BceCredentials credentials) {
        setRequestCredentials(credentials);
        return this;
    }

    public DeleteBucketRequest withBucketName(String bucketName) {
        setBucketName(bucketName);
        return this;
    }
}
