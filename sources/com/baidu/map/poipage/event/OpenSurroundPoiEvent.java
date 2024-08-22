package com.baidu.map.poipage.event;

public class OpenSurroundPoiEvent {
    String url;

    public OpenSurroundPoiEvent(String url2) {
        this.url = url2;
    }

    public String getUrl() {
        return this.url;
    }
}
