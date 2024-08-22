package com.baidu.searchbox.feed.silex.infrastructure.remotedata.request;

import com.baidu.searchbox.feed.silex.config.request.IRequestCallback;

public class ResponseInfo {
    public final String assignId;
    public final String cmdLayer;
    public final boolean isResultRestful;
    public final IRequestCallback requestCallback;

    public ResponseInfo(String assignId2, boolean isResultRestful2, String cmdLayer2, IRequestCallback requestCallback2) {
        this.assignId = assignId2;
        this.isResultRestful = isResultRestful2;
        this.cmdLayer = cmdLayer2;
        this.requestCallback = requestCallback2;
    }
}
