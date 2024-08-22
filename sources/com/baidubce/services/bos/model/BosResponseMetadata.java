package com.baidubce.services.bos.model;

import com.baidubce.BceResponseMetadata;

public class BosResponseMetadata extends BceResponseMetadata {
    private String debugId;
    private Long nextAppendOffset;

    public String getBosDebugId() {
        return this.debugId;
    }

    public void setBosDebugId(String debugId2) {
        this.debugId = debugId2;
    }

    public Long getNextAppendOffset() {
        return this.nextAppendOffset;
    }

    public void setNextAppendOffset(Long nextAppendOffset2) {
        this.nextAppendOffset = nextAppendOffset2;
    }
}
