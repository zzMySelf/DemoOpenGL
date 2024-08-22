package com.baidubce.model;

import com.baidubce.auth.BceCredentials;

public abstract class AbstractBceRequest {
    public BceCredentials credentials;

    public BceCredentials getRequestCredentials() {
        return this.credentials;
    }

    public void setRequestCredentials(BceCredentials bceCredentials) {
        this.credentials = bceCredentials;
    }

    public abstract AbstractBceRequest withRequestCredentials(BceCredentials bceCredentials);
}
