package com.baidubce.services.bos.model;

import com.baidubce.model.AbstractBceResponse;

public class BosResponse extends AbstractBceResponse {
    public BosResponse() {
        this.metadata = new BosResponseMetadata();
    }

    public BosResponseMetadata getMetadata() {
        return (BosResponseMetadata) this.metadata;
    }
}
