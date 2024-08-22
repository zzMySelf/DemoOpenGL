package com.baidu.searchbox.export;

import com.baidu.searchbox.feed.PlayerFeedSessionManager_Factory;

public interface IPlayerFeedSessionManager {
    public static final IPlayerFeedSessionManager EMPTY = new IPlayerFeedSessionManager() {
        public String getClickId() {
            return "";
        }
    };

    String getClickId();

    public static class Impl {
        public static IPlayerFeedSessionManager get() {
            return PlayerFeedSessionManager_Factory.get();
        }
    }
}
