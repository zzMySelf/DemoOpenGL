package com.baidu.map.poipage.event;

import com.baidu.searchbox.nacomp.util.UniqueId;

public class CloseContainerEvent {
    private final UniqueId mToken;

    public CloseContainerEvent(UniqueId token) {
        this.mToken = token;
    }

    public UniqueId getToken() {
        return this.mToken;
    }
}
