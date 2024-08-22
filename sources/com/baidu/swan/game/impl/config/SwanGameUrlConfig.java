package com.baidu.swan.game.impl.config;

import com.baidu.searchbox.config.HostConfig;
import com.baidu.swan.apps.impl.config.SwanUrlConfig;

public class SwanGameUrlConfig {
    private static final String HOST_FOR_HTTPS = SwanUrlConfig.getSearchboxHostForHttps();

    public static String getCheckIsToRestUrl() {
        return String.format("%s/ma/game/rest/check_is_user_advised_to_rest", new Object[]{HOST_FOR_HTTPS});
    }

    public static String getGetUserInfoUrl() {
        return String.format("%s/ma/game/od/get_user_info", new Object[]{HOST_FOR_HTTPS});
    }

    public static String getRemoveUserCloudStorageUrl() {
        return String.format("%s/ma/game/od/remove_user_cloud_storage", new Object[]{HOST_FOR_HTTPS});
    }

    public static String getGetUserCloudStorageUrl() {
        return String.format("%s/ma/game/od/get_user_cloud_storage", new Object[]{HOST_FOR_HTTPS});
    }

    public static String getSetUserCloudStorageUrl() {
        return String.format("%s/ma/game/od/set_user_cloud_storage", new Object[]{HOST_FOR_HTTPS});
    }

    public static String getGetFriendCloudStorageUrl() {
        return String.format("%s/ma/game/od/get_friend_cloud_storage", new Object[]{HOST_FOR_HTTPS});
    }

    public static String getGetRecommendationListUrl() {
        return String.format("%s/api/exchange/list", new Object[]{HostConfig.getGameServerHost()});
    }

    public static String getRecommendationTransferReportUrl() {
        return String.format("%s/api/exchange/transfer_report", new Object[]{HostConfig.getGameServerHost()});
    }

    public static String getBannerLockUrl() {
        return String.format("%s/api/msgame/adblock", new Object[]{HostConfig.getGameServerHost()});
    }

    public static String getReportRealName() {
        return String.format("%s/api/user/addiction/realname", new Object[]{HostConfig.getGameServerHost()});
    }

    public static String getReportUserBehaviour() {
        return String.format("%s/api/user/addiction/behavior_report", new Object[]{HostConfig.getGameServerHost()});
    }

    public static String getSwanGameAppIdUrl() {
        return String.format("%s/api/user/addiction/gamevalid", new Object[]{HostConfig.getGameServerHost()});
    }

    public static String getCommonConfigUrl() {
        return String.format("%s/api/settings/common_config", new Object[]{HostConfig.getGameServerHost()});
    }
}
