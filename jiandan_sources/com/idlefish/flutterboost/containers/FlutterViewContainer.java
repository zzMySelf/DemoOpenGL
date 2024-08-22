package com.idlefish.flutterboost.containers;

import java.util.Map;

public interface FlutterViewContainer {
    void detachFromEngineIfNeeded();

    void finishContainer(Map<String, Object> map);

    String getUniqueId();

    String getUrl();

    Map<String, Object> getUrlParams();

    boolean isOpaque();

    boolean isPausing();
}
