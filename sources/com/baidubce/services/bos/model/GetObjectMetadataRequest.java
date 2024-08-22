package com.baidubce.services.bos.model;

import com.baidubce.auth.BceCredentials;

public class GetObjectMetadataRequest extends GenericObjectRequest {
    public GetObjectMetadataRequest(String bucketName, String key) {
        super(bucketName, key);
    }

    public GetObjectMetadataRequest withRequestCredentials(BceCredentials credentials) {
        setRequestCredentials(credentials);
        return this;
    }

    public GetObjectMetadataRequest withBucketName(String bucketName) {
        setBucketName(bucketName);
        return this;
    }

    public GetObjectMetadataRequest withKey(String key) {
        setKey(key);
        return this;
    }
}
