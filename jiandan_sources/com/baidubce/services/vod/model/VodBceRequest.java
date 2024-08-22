package com.baidubce.services.vod.model;

import com.baidubce.model.AbstractBceRequest;

public abstract class VodBceRequest extends AbstractBceRequest {
    public abstract String toJsonString();
}
