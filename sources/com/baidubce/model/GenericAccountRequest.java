package com.baidubce.model;

import com.baidubce.auth.BceCredentials;

public class GenericAccountRequest extends AbstractBceRequest {
    public GenericAccountRequest withRequestCredentials(BceCredentials credentials) {
        setRequestCredentials(credentials);
        return this;
    }
}
